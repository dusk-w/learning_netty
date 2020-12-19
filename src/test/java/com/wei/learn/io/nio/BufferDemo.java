package com.wei.learn.io.nio;

import java.nio.IntBuffer;
import java.security.SecureRandom;

/**
 * buffer三大属性
 *
 * capacity：最大容量，它永远不可能为负数，并且是不会变化的
 *
 * limit：限制，它永远不可能为负数，并且不会大于capacity
 *
 * position：下一个读或写的位置，它永远不可能为负数，并且不会大于limit
 */
public class BufferDemo {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(8);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            int intNext = new SecureRandom().nextInt(20);
            intBuffer.put(intNext);
        }
        intBuffer.flip();   // 翻转position和limit开始读buffer
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
