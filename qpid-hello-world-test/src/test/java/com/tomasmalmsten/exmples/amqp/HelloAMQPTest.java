package com.tomasmalmsten.exmples.amqp;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class HelloAMQPTest {

    private static final String EXCHANGE_NAME = "hello";
    private static final String ROUTING_KEY = "routingkey";
    private static final String MESSAGE = "Hello World";
    private static final boolean AUTO_ACK = false;
    private Channel channel;
    private Connection connection;
    private String queueName;
    private String message;


    @Before
    public void setUp() throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        connection = factory.newConnection();
        channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct", true);
        queueName = channel.queueDeclare().getQueue();
    }

    @Test
    public void receiveSentMessage() throws InterruptedException, IOException {
        givenHelloWorldMessageHasBeenSent();
        whenTheMessageIsRetrivedFromTheMQ();
        thenTheReceivedMessageShouldMatchTheSentMessage();
    }

    private void givenHelloWorldMessageHasBeenSent() throws IOException {
        channel.queueBind(queueName, EXCHANGE_NAME, ROUTING_KEY);
        channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, MESSAGE.getBytes());
    }

    private void whenTheMessageIsRetrivedFromTheMQ() throws IOException, InterruptedException {
        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume(queueName, AUTO_ACK, consumer);
        QueueingConsumer.Delivery delivery = consumer.nextDelivery();
        message = new String(delivery.getBody());
        channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
    }

    private void thenTheReceivedMessageShouldMatchTheSentMessage() {
        assertEquals(MESSAGE, message);
    }

    @After
    public void cleanUp() throws IOException {
        channel.close();
        connection.close();
    }
}
