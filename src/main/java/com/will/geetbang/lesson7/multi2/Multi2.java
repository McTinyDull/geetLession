package com.will.geetbang.lesson7.multi2;

/**
 * @Description TODO
 * @Author Will
 * @Date 2022/4/17 11:58 PM
 */
public class Multi2 {
    public static void main(String[] args) {
        DataSource dataSource = ShardingSphereDataSourceFactory.createDataSource(schemaName, modeConfig, dataSourceMap, ruleConfigs, props);
    }
}
