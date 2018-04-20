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
public class RedisListTest {

    @Test
    public void testRedisList1(){
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


    @Test
    public void testRedisList2(){
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

    @Test
    public void testRedisList3(){
        String key2 = "order" ;
        String key2_value = "beijing fire pan" ;
        String key2_ext = "orderext" ;
        RedisUtil.getJedis().lpush(key2, key2_value);
//        List<String> result2 = RedisUtil.getJedis().brpop(1000, key2);
//        List<String> result2 = RedisUtil.getJedis().brpoplpush(key2, temp2, 1000);
        String result2 = RedisUtil.getJedis().brpoplpush(key2, key2_ext, 1000);
        System.out.println("result2="+ JsonUtil.toJson(result2));
        List<String> key2List = RedisUtil.getJedis().lrange(key2, 0, 1000);
        System.out.println("key2List="+ JsonUtil.toJson(key2List));
        List<String> key2ExtList = RedisUtil.getJedis().lrange(key2_ext, 0, 1000);
        System.out.println("key2ExtList="+ JsonUtil.toJson(key2ExtList));

        Long key2Length = RedisUtil.getJedis().llen(key2);
        System.out.println("key2Length="+ JsonUtil.toJson(key2Length));
        Long key2ExtLength = RedisUtil.getJedis().llen(key2_ext);
        System.out.println("key2ExtLength="+ JsonUtil.toJson(key2ExtLength));
    }

    @Test
    public void testRedisList4(){
        String key1 = "name1" ;
        String key2 = "name2" ;
        String temp2 = "tempname2" ;
        String param1 = "lee1" ;
        String[] param2 = {"lee2", "lee3"} ;


        RedisUtil.getJedis().lpush(key2, param2);
//        List<String> result2 = RedisUtil.getJedis().brpop(1000, key2);
//        List<String> result2 = RedisUtil.getJedis().brpoplpush(key2, temp2, 1000);
        String result2 = RedisUtil.getJedis().rpoplpush(key2, temp2);
        System.out.println("result2="+ JsonUtil.toJson(result2));

        String result4 = RedisUtil.getJedis().brpoplpush(key2, temp2, 1000);
        System.out.println("result4="+ JsonUtil.toJson(result2));
    }









}
