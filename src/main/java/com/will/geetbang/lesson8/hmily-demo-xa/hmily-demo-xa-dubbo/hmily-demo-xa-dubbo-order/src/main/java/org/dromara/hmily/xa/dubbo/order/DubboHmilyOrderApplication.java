/*
 * Copyright 2017-2021 Dromara.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.will.geetbang.lesson8.hmily;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DubboTccOrderApplication.
 *
 * @author xiaoyu
 */
@SpringBootApplication
@ImportResource({"classpath:applicationContext.xml"})
@MapperScan("org.dromara.hmily.demo.common.order.mapper")
public class DubboHmilyOrderApplication {

    /**
     * main.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        SpringApplication.run(DubboHmilyOrderApplication.class, args);
    }
}
