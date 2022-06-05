package com.will.geetbang.lession13.kafka.src.main.java.io.kimmking.javacourse.kafka;

import io.kimmking.javacourse.kafka.kimmking.ConsumerImpl;

public class KafkaConsumerDemo {

    public static void main(String[] args) {
        testConsumer();
    }

    private static void testConsumer() {
        ConsumerImpl consumer = new ConsumerImpl();
        consumer.consumeOrder();

    }
}
