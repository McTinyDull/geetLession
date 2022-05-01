package com.will.geetbang.lesson9.rpc01.rpcfx;

import lombok.Data;

@Data
public class RpcfxResponse {
    private Object result;
    private boolean status;
    private Exception exception;
}
