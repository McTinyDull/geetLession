package com.will.geetbangstarter.prop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.Properties;

/**
 * @Description TODO
 * @Author Will
 * @Date 2022/4/3 11:35 PM
 */
@ConfigurationProperties(prefix = "will")
public class SpringBootPropertiesConfiguration  {

    private Properties props = new Properties();

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }
}
