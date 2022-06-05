package com.will.geetbang.lession13.kafka.src.main.java.io.kimmking.javacourse.kafka.kimmking;

import io.kimmking.javacourse.kafka.Order;

public interface Producer {

    void send(Order order);

    void close();

    // add your interface method here

    // and then implement it

}
