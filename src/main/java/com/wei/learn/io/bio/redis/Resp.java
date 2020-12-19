package com.wei.learn.io.bio.redis;

public class Resp {

    public static final String STAR = "*";

    public static final String STRING_LENGTH = "$";

    public static final String LINE = "\r\n";

    public static enum command{
        SET, GET, INCR
    }
}
