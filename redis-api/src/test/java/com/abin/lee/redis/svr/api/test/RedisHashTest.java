package com.abin.lee.redis.svr.api.test;

import com.abin.lee.redis.svr.api.util.RedisUtil;
import com.abin.lee.redis.svr.common.util.JsonUtil;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by abin on 2018/3/15 22:51.
 * redis-svr
 * com.abin.lee.redis.svr.common.test
 */
public class RedisHashTest {

    @Test
    public void testRedisHash1(){
        String hashTable1 = "hashTables1" ;
        String key1 = "name1" ;
        String key2 = "name2" ;
        String temp2 = "tempname2" ;
        String param1 = "lee1" ;
        String[] param2 = {"lee2", "lee3"} ;
        RedisUtil.getJedis().hset(hashTable1, key1, param1);
        String result1 = RedisUtil.getJedis().hget(hashTable1, key1);
        System.out.println("result1="+result1);
        Set<String> keysValue = RedisUtil.getJedis().keys("*");
        System.out.println("keysValue="+ JsonUtil.toJson(keysValue));
        Boolean key2Exists = RedisUtil.getJedis().exists(key2);

        System.out.println("key2Exists="+ JsonUtil.toJson(key2Exists));



    }















}
