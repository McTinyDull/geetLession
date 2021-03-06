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

import org.dromara.hmily.annotation.HmilyTCC;
import org.dromara.hmily.annotation.HmilyXA;
import org.dromara.hmily.common.exception.HmilyRuntimeException;
import org.dromara.hmily.demo.common.account.api.AccountService;
import org.dromara.hmily.demo.common.account.api.InlineService;
import org.dromara.hmily.demo.common.account.dto.AccountDTO;
import org.dromara.hmily.demo.common.account.dto.AccountNestedDTO;
import org.dromara.hmily.demo.common.account.entity.AccountDO;
import org.dromara.hmily.demo.common.account.mapper.AccountMapper;
import org.dromara.hmily.demo.common.inventory.api.InventoryService;
import org.dromara.hmily.demo.common.inventory.dto.InventoryDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type Account service.
 *
 * @author xiaoyu
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    /**
     * logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    /**
     * The Trycount.
     */
    private static AtomicInteger trycount = new AtomicInteger(0);

    /**
     * The Confrim count.
     */
    private static AtomicInteger confrimCount = new AtomicInteger(0);

    private final AccountMapper accountMapper;

    private final InventoryService inventoryService;

    private final InlineService inlineService;

    /**
     * Instantiates a new Account service.
     *
     * @param accountMapper the account mapper
     */
    @Autowired(required = false)
    public AccountServiceImpl(final AccountMapper accountMapper,
                              final InventoryService inventoryService,
                              final InlineService inlineService) {
        this.accountMapper = accountMapper;
        this.inventoryService = inventoryService;
        this.inlineService = inlineService;
    }

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean payment(AccountDTO accountDTO) {
        int count = accountMapper.update(accountDTO);
        if (count > 0) {
            return true;
        } else {
            throw new HmilyRuntimeException("?????????????????????");
        }
    }

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean mockTryPaymentException(AccountDTO accountDTO) {
        throw new HmilyRuntimeException("?????????????????????");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean mockTryPaymentTimeout(AccountDTO accountDTO) {
        try {
            //???????????? ??????????????????10???
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final int decrease = accountMapper.update(accountDTO);
        if (decrease != 1) {
            throw new HmilyRuntimeException("????????????");
        }
        return true;
    }

    @Override
    @HmilyXA
    @Transactional
    public boolean testPayment(AccountDTO accountDTO) {
        accountMapper.testUpdate(accountDTO);
//        throw new RuntimeException("111111111");
        return Boolean.TRUE;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @HmilyXA
    public boolean paymentWithNested(AccountNestedDTO accountNestedDTO) {
        AccountDTO dto = new AccountDTO();
        dto.setAmount(accountNestedDTO.getAmount());
        dto.setUserId(accountNestedDTO.getUserId());
        accountMapper.update(dto);
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setCount(accountNestedDTO.getCount());
        inventoryDTO.setProductId(accountNestedDTO.getProductId());
        inventoryService.decrease(inventoryDTO);
        return Boolean.TRUE;
    }

    @Override
    @HmilyTCC(confirmMethod = "confirmNested", cancelMethod = "cancelNested")
    @Transactional(rollbackFor = Exception.class)
    public boolean paymentWithNestedException(AccountNestedDTO accountNestedDTO) {
        AccountDTO dto = new AccountDTO();
        dto.setAmount(accountNestedDTO.getAmount());
        dto.setUserId(accountNestedDTO.getUserId());
        accountMapper.update(dto);
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setCount(accountNestedDTO.getCount());
        inventoryDTO.setProductId(accountNestedDTO.getProductId());
        inventoryService.decrease(inventoryDTO);
        //??????????????????????????????
        inventoryService.mockWithTryException(inventoryDTO);
        return Boolean.TRUE;
    }

    @Override
    public AccountDO findByUserId(String userId) {
        return accountMapper.findByUserId(userId);
    }

    /**
     * Confirm nested boolean.
     *
     * @param accountNestedDTO the account nested dto
     * @return the boolean
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean confirmNested(AccountNestedDTO accountNestedDTO) {
        LOGGER.debug("============dubbo tcc ????????????????????????===============");
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(accountNestedDTO.getUserId());
        accountDTO.setAmount(accountNestedDTO.getAmount());
        accountMapper.confirm(accountDTO);
        return Boolean.TRUE;
    }

    /**
     * Cancel nested boolean.
     *
     * @param accountNestedDTO the account nested dto
     * @return the boolean
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean cancelNested(AccountNestedDTO accountNestedDTO) {
        LOGGER.debug("============ dubbo tcc ????????????????????????===============");
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserId(accountNestedDTO.getUserId());
        accountDTO.setAmount(accountNestedDTO.getAmount());
        accountMapper.cancel(accountDTO);
        return Boolean.TRUE;
    }

    /**
     * Confirm boolean.
     *
     * @param accountDTO the account dto
     * @return the boolean
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean confirm(AccountDTO accountDTO) {
        LOGGER.info("============dubbo tcc ????????????????????????===============");
        accountMapper.confirm(accountDTO);
        final int i = confrimCount.incrementAndGet();
        LOGGER.info("?????????account confirm " + i + " ???");
        return Boolean.TRUE;
    }

    /**
     * Cancel boolean.
     *
     * @param accountDTO the account dto
     * @return the boolean
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean cancel(AccountDTO accountDTO) {
        LOGGER.info("============ dubbo tcc ????????????????????????===============");
        final AccountDO accountDO = accountMapper.findByUserId(accountDTO.getUserId());
        accountMapper.cancel(accountDTO);
        return Boolean.TRUE;
    }
}
