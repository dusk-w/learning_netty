package com.wei.learn.io.bio.redis;

/**
 * redis协议转化工具类
 */
public class RespTransformUtil {
    public static String command(Resp.command command, byte[]... bytes) {
        StringBuilder sb = new StringBuilder();
        sb.append(Resp.STAR).append(1 + bytes.length).append(Resp.LINE);
        sb.append(Resp.STRING_LENGTH).append(command.toString().length()).append(Resp.LINE);
        sb.append(command.toString()).append(Resp.LINE);
        for (byte[] aByte : bytes) {
            sb.append(Resp.STRING_LENGTH).append(aByte.length).append(Resp.LINE);
            sb.append(new String(aByte)).append(Resp.LINE);
        }
        return sb.toString();
    }
}
