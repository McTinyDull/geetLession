package com.will.geetbang.lesson9.rpc01.rpcfx;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceProviderDesc {

    private String host;
    private Integer port;
    private String serviceClass;

    // group
    // version
}
