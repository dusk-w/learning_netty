package com.wei.learn.io.bio.redis;

public class Jedis {

    JedisSocket jedisSocket = new JedisSocket("132.232.94.66", 6379);

    public String set(String key, String value) {
        jedisSocket.send(RespTransformUtil.command(Resp.command.SET, key.getBytes(), value.getBytes()));
        return jedisSocket.read();
    }

    public String get(String key) {
        jedisSocket.send(RespTransformUtil.command(Resp.command.GET, key.getBytes()));
        return jedisSocket.read();
    }

    public String incr(String key) {
        jedisSocket.send(RespTransformUtil.command(Resp.command.INCR, key.getBytes()));
        return jedisSocket.read();
    }
}
