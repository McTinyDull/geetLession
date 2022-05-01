package com.will.geetbang.lesson9.rpc01.rpcfx;

import java.util.List;

public interface LoadBalancer {

    String select(List<String> urls);

}
