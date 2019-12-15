/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package kr.co.pohinian.gemfiredemo.configuration;

import kr.co.pohinian.gemfiredemo.entity.Customer;
import kr.co.pohinian.gemfiredemo.entity.TestCache;
import org.apache.geode.cache.client.ClientCache;
import org.apache.geode.cache.client.ClientCacheFactory;
import org.apache.geode.cache.client.ClientRegionShortcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.cache.config.EnableGemfireCaching;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.config.annotation.EnableLogging;

@Configuration
@EnableGemfireCaching
public class GemfireConfiguration {

    @Bean
    public ClientCache gemfireCache() {
        ClientCacheFactory cacheFactory = new ClientCacheFactory();
        cacheFactory.addPoolLocator("192.168.0.6", 10334);
        return cacheFactory.create();
    }

    @Bean("testCache")
    public ClientRegionFactoryBean<String, TestCache> testCache(@Autowired ClientCache clientCache) {
        ClientRegionFactoryBean<String, TestCache> regionFactoryBean = new ClientRegionFactoryBean<>();
        regionFactoryBean.setCache(clientCache);
        regionFactoryBean.setClose(false);
        regionFactoryBean.setShortcut(ClientRegionShortcut.PROXY);
        return regionFactoryBean;
    }
    @Bean("customer")
    public ClientRegionFactoryBean<Long, Customer> customer(@Autowired ClientCache clientCache) {
        ClientRegionFactoryBean<Long, Customer> regionFactoryBean = new ClientRegionFactoryBean<>();
        regionFactoryBean.setCache(clientCache);
        regionFactoryBean.setClose(false);
        regionFactoryBean.setShortcut(ClientRegionShortcut.PROXY);
        return regionFactoryBean;
    }
}
