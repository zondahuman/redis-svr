package com.abin.lee.redis.svr.api.test;

import com.abin.lee.redis.svr.api.util.RedisUtil;
import com.abin.lee.redis.svr.common.util.JsonUtil;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import redis.clients.jedis.Protocol;

import java.util.List;
import java.util.Map;

/**
 * Created by abin on 2018/4/16 19:57.
 * redis-svr
 * com.abin.lee.redis.svr.api.test
 */
public class RedisPerformanceTest {


    @Test
    public void testRedisInfo(){
        String info1 = RedisUtil.getJedis().info();
        System.out.println("info1="+ JsonUtil.toJson(info1));
//        String info2 = RedisUtil.getJedis().info("clients");
        String info2 = RedisUtil.getJedis().info("Clients");
        System.out.println("info2="+ JsonUtil.toJson(info2));
        Integer connectedClients = getConnectedClients(info2);
        System.out.println("connectedClients= "+ connectedClients);

    }



    public static Integer getConnectedClients(String param){
        String temp = "";
        if(StringUtils.isBlank(param)) {
            return 0;
        }else{
            temp = param.replace("# Clients\r\n", "");
//            param = param.substring(param.indexOf("# Clients\\r\\n")+1);
            System.out.println("temp=" + temp);
        }
        String[] params = temp.split("\\r\\n");
        System.out.println("params=" + JsonUtil.toJson(params));
        Map<String, String> clients = Maps.newHashMap() ;
        for(String tt : params){
            String[] middle = tt.split(":") ;
            clients.put(middle[0], middle[1]);
        }
        Integer connectedClients = Ints.tryParse(clients.get("connected_clients"));
        return connectedClients;
    }
}
