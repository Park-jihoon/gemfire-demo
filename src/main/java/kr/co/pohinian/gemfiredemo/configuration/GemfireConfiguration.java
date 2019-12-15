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
import org.apache.geode.pdx.JSONFormatter;
import org.apache.geode.pdx.ReflectionBasedAutoSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.cache.config.EnableGemfireCaching;
import org.springframework.data.gemfire.client.ClientRegionFactoryBean;
import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
import org.springframework.data.gemfire.config.annotation.EnableLogging;
import org.springframework.data.gemfire.config.annotation.EnablePdx;
import org.springframework.data.gemfire.mapping.MappingPdxSerializer;

@Configuration
@EnableGemfireCaching
@EnableLogging(logLevel = "info")
@EnablePdx
public class GemfireConfiguration {

    @Bean
    public ClientCache gemfireCache() {
        ClientCacheFactory cacheFactory = new ClientCacheFactory();
        cacheFactory.addPoolLocator("192.168.0.6", 10334);
//        cacheFactory.set("security-client-auth-init", "io.pivotal.gemfire.demo.ClientAuthentication.create");
//        cacheFactory.set("security-username", "admin");
//        cacheFactory.set("security-password", "admin");
//        cacheFactory.setPdxSerializer(new ReflectionBasedAutoSerializer("kr.co.pohinian.gemfiredemo.*"));
//        cacheFactory.setPdxSerializer(new MappingPdxSerializer());
//        cacheFactory.setPdxReadSerialized(false);
        return cacheFactory.create();
    }

    @Bean("testCache")
    public ClientRegionFactoryBean<String, TestCache> testCache(@Autowired ClientCache clientCache) {
        ClientRegionFactoryBean<String, TestCache> regionFactoryBean = new ClientRegionFactoryBean<>();
        regionFactoryBean.setCache(clientCache);
        regionFactoryBean.setClose(false);
        regionFactoryBean.setShortcut(ClientRegionShortcut.PROXY);
        regionFactoryBean.setRegionName("testCache");
        return regionFactoryBean;
    }
    @Bean("customer")
    public ClientRegionFactoryBean<Long, Customer> customer(@Autowired ClientCache clientCache) {
        ClientRegionFactoryBean<Long, Customer> regionFactoryBean = new ClientRegionFactoryBean<>();
        regionFactoryBean.setCache(clientCache);
        regionFactoryBean.setClose(false);
        regionFactoryBean.setShortcut(ClientRegionShortcut.PROXY);
        regionFactoryBean.setRegionName("customer");
        return regionFactoryBean;
    }
}
