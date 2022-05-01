package com.will.geetbang.lesson9.rpc01.rpcfx;

import lombok.Data;

@Data
public class RpcfxRequest {
  private String serviceClass;
  private String method;
  private Object[] params;
}
