package com.abin.lee.redis.svr.api.operate.set;

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
public class SetOperate {

    @Test
    public void testSet() {
        Jedis jedis = RedisUtil.getJedis();
        jedis.flushDB();
        System.out.println("============向集合中添加元素============");
        System.out.println(jedis.sadd("eleSet", "e1", "e2", "e4", "e3", "e0", "e8", "e7", "e5"));
        System.out.println(jedis.sadd("eleSet", "e6"));
        System.out.println(jedis.sadd("eleSet", "e6"));
        System.out.println("eleSet的所有元素为：" + jedis.smembers("eleSet"));
        System.out.println("删除一个元素e0：" + jedis.srem("eleSet", "e0"));
        System.out.println("eleSet的所有元素为：" + jedis.smembers("eleSet"));
        System.out.println("删除两个元素e7和e6：" + jedis.srem("eleSet", "e7", "e6"));
        System.out.println("eleSet的所有元素为：" + jedis.smembers("eleSet"));
        System.out.println("随机的移除集合中的一个元素：" + jedis.spop("eleSet"));
        System.out.println("随机的移除集合中的一个元素：" + jedis.spop("eleSet"));
        System.out.println("eleSet的所有元素为：" + jedis.smembers("eleSet"));
        System.out.println("eleSet中包含元素的个数：" + jedis.scard("eleSet"));
        System.out.println("e3是否在eleSet中：" + jedis.sismember("eleSet", "e3"));
        System.out.println("e1是否在eleSet中：" + jedis.sismember("eleSet", "e1"));
        System.out.println("e1是否在eleSet中：" + jedis.sismember("eleSet", "e5"));
        System.out.println("=================================");
        System.out.println(jedis.sadd("eleSet1", "e1", "e2", "e4", "e3", "e0", "e8", "e7", "e5"));
        System.out.println(jedis.sadd("eleSet2", "e1", "e2", "e4", "e3", "e0", "e8"));
        System.out.println("将eleSet1中删除e1并存入eleSet3中：" + jedis.smove("eleSet1", "eleSet3", "e1"));
        System.out.println("将eleSet1中删除e2并存入eleSet3中：" + jedis.smove("eleSet1", "eleSet3", "e2"));
        System.out.println("eleSet1中的元素：" + jedis.smembers("eleSet1"));
        System.out.println("eleSet3中的元素：" + jedis.smembers("eleSet3"));
        System.out.println("============集合运算=================");
        System.out.println("eleSet1中的元素：" + jedis.smembers("eleSet1"));
        System.out.println("eleSet2中的元素：" + jedis.smembers("eleSet2"));
        System.out.println("eleSet1和eleSet2的交集:" + jedis.sinter("eleSet1", "eleSet2"));
        System.out.println("eleSet1和eleSet2的并集:" + jedis.sunion("eleSet1", "eleSet2"));
        System.out.println("eleSet1和eleSet2的差集:" + jedis.sdiff("eleSet1", "eleSet2"));//eleSet1中有，eleSet2中没有
    }

}
