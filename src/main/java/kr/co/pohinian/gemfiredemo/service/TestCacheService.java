/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package kr.co.pohinian.gemfiredemo.service;

import kr.co.pohinian.gemfiredemo.entity.TestCache;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestCacheService {

    @CachePut(cacheNames = "testCache", key = "#key")
    public TestCache put(String key, TestCache testCache) {
        return testCache;
    }

    @Cacheable(cacheNames = "testCache", key = "#key")
    public TestCache get(String key) {
        return null;
    }
}
