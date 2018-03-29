package com.abin.lee.redis.svr.api.sentinel;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by abin on 2018/3/29 14:52.
 * redis-svr
 * com.abin.lee.redis.svr.api.sentinel
 */


public class JedisSentinelCommon {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        Set<String> sentinels = new HashSet<String>();
        sentinels.add("192.168.244.10:26379");
        sentinels.add("192.168.244.10:26380");
        sentinels.add("192.168.244.10:26381");

        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool("mymaster", sentinels);
        Jedis jedis = null;
        while (true) {
            Thread.sleep(1000);

            try {
                jedis = jedisSentinelPool.getResource();

                Date now = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                String format_now = dateFormat.format(now);

                jedis.set("hello", "world");
                String value = jedis.get("hello");
                System.out.println(format_now + ' ' + value);

            } catch (Exception e) {
                System.out.println(e);
            } finally {
                if (jedis != null)
                    try {
                        jedis.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
            }
        }

    }
}