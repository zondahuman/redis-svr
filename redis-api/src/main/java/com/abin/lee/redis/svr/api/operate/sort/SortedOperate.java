package com.abin.lee.redis.svr.api.operate.sort;

import com.abin.lee.redis.svr.api.util.RedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.SortingParams;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abin on 2018/4/30 1:54.
 * redis-svr
 * com.abin.lee.redis.svr.api.operate.sortedset
 * http://www.importnew.com/19321.html
 *
 */
public class SortedOperate {

    @Test
    public void testSort() {
        Jedis jedis = RedisUtil.getJedis();
        jedis.flushDB();
        jedis.lpush("collections", "ArrayList", "Vector", "Stack", "HashMap", "WeakHashMap", "LinkedHashMap");
        System.out.println("collections的内容：" + jedis.lrange("collections", 0, -1));
        SortingParams sortingParameters = new SortingParams();
        System.out.println(jedis.sort("collections", sortingParameters.alpha()));
        System.out.println("===============================");
        jedis.lpush("sortedList", "3", "6", "2", "0", "7", "4");
        System.out.println("sortedList排序前：" + jedis.lrange("sortedList", 0, -1));
        System.out.println("升序：" + jedis.sort("sortedList", sortingParameters.asc()));
        System.out.println("升序：" + jedis.sort("sortedList", sortingParameters.desc()));
        System.out.println("===============================");
        jedis.lpush("userlist", "33");
        jedis.lpush("userlist", "22");
        jedis.lpush("userlist", "55");
        jedis.lpush("userlist", "11");
        jedis.hset("user:66", "name", "66");
        jedis.hset("user:55", "name", "55");
        jedis.hset("user:33", "name", "33");
        jedis.hset("user:22", "name", "79");
        jedis.hset("user:11", "name", "24");
        jedis.hset("user:11", "add", "beijing");
        jedis.hset("user:22", "add", "shanghai");
        jedis.hset("user:33", "add", "guangzhou");
        jedis.hset("user:55", "add", "chongqing");
        jedis.hset("user:66", "add", "xi'an");
        sortingParameters = new SortingParams();
        sortingParameters.get("user:*->name");
        sortingParameters.get("user:*->add");
        System.out.println(jedis.sort("userlist", sortingParameters));
    }

}
