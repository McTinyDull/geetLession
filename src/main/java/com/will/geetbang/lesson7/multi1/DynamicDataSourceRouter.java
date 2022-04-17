package com.will.geetbang.lesson7.multi1;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.Map;

/**
 * @Description TODO
 * @Author Will
 * @Date 2022/4/17 11:41 PM
 */
public class DynamicDataSourceRouter extends AbstractRoutingDataSource {
    public DynamicDataSourceRouter(Object defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        this.setDefaultTargetDataSource(defaultTargetDataSource);
        this.setTargetDataSources(targetDataSources);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getLookupKey();
    }
}
