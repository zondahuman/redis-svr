package com.abin.lee.redis.svr.api.test;

import com.abin.lee.redis.svr.api.util.RedisUtil;
import com.abin.lee.redis.svr.common.util.JsonUtil;
import org.junit.Test;

import java.util.List;

/**
 * Created by abin on 2018/3/15 22:51.
 * redis-svr
 * com.abin.lee.redis.svr.common.test
 */
public class AppTest {

    @Test
    public void testRedisList(){
        String key1 = "name1" ;
        String key2 = "name2" ;
        String temp2 = "tempname2" ;
        String param1 = "lee1" ;
        String[] param2 = {"lee2", "lee3"} ;
        RedisUtil.getJedis().lpush(key1, param1);
        String result1 = RedisUtil.getJedis().rpop(key1);
        System.out.println("result1="+result1);
        RedisUtil.getJedis().lpush(key2, param2);
        List<String> result2 = RedisUtil.getJedis().brpop(1000, key2);
//        List<String> result2 = RedisUtil.getJedis().brpoplpush(key2, temp2, 1000);
//        String result2 = RedisUtil.getJedis().brpoplpush(key2, temp2, 1000);
        System.out.println("result2="+ JsonUtil.toJson(result2));
    }















}
