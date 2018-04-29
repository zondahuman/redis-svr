package com.abin.lee.redis.svr.api.operate.sortedset;

import com.abin.lee.redis.svr.api.util.RedisUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by abin on 2018/4/30 1:54.
 * redis-svr
 * com.abin.lee.redis.svr.api.operate.sortedset
 * http://www.importnew.com/19321.html
 */
public class SortedSetOperate {

    @Test
    public void testSortedSet()
    {
        Jedis jedis = RedisUtil.getJedis();
        jedis.flushDB();
        Map<String,Double> map = new HashMap<>();
        map.put("key2", 1.2);
        map.put("key3", 4.0);
        map.put("key4", 5.0);
        map.put("key5", 0.2);
        System.out.println(jedis.zadd("zset", 3,"key1"));
        System.out.println(jedis.zadd("zset", map));
        System.out.println("zset中的所有元素："+jedis.zrange("zset", 0, -1));
        System.out.println("zset中的所有元素："+jedis.zrangeWithScores("zset", 0, -1));
        System.out.println("zset中的所有元素："+jedis.zrangeByScore("zset", 0,100));
        System.out.println("zset中的所有元素："+jedis.zrangeByScoreWithScores("zset", 0,100));
        System.out.println("zset中key2的分值："+jedis.zscore("zset", "key2"));
        System.out.println("zset中key2的排名："+jedis.zrank("zset", "key2"));
        System.out.println("删除zset中的元素key3："+jedis.zrem("zset", "key3"));
        System.out.println("zset中的所有元素："+jedis.zrange("zset", 0, -1));
        System.out.println("zset中元素的个数："+jedis.zcard("zset"));
        System.out.println("zset中分值在1-4之间的元素的个数："+jedis.zcount("zset", 1, 4));
        System.out.println("key2的分值加上5："+jedis.zincrby("zset", 5, "key2"));
        System.out.println("key3的分值加上4："+jedis.zincrby("zset", 4, "key3"));
        System.out.println("zset中的所有元素："+jedis.zrange("zset", 0, -1));
    }


}
