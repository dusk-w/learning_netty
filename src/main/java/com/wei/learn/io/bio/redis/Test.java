package com.wei.learn.io.bio.redis;

public class Test {
    public static void main(String[] args) {
        Jedis jedis = new Jedis();
        System.out.println(jedis.set("weiwei","123"));
        System.out.println(jedis.get("weiwei"));
    }
}
