/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package kr.co.pohinian.gemfiredemo.controller;

import kr.co.pohinian.gemfiredemo.service.TestCacheService;
import kr.co.pohinian.gemfiredemo.entity.TestCache;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cache")
public class TestCacheController {

    private final TestCacheService testCacheService;

    public TestCacheController(TestCacheService testCacheService) {
        this.testCacheService = testCacheService;
    }

    @PostMapping("{key}")
    public TestCache put(@PathVariable("key") String key, @RequestBody TestCache value) {
        return testCacheService.put(key, value);
    }

    @GetMapping("{key}")
    public TestCache get(@PathVariable("key") String key) {
        return testCacheService.get(key);
    }

}
