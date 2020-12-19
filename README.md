# nio

​		核心概念：selector，channel，buffer

​		java.nio中，面向块(block)或缓冲区(buffer)编程

## buffer

​		java原生8中基本数据类型都有各自对应的buffer类型(除boolean外)，IntBuffer、CharBuffer、ByteBuffer、LongBuffer、ShortBuffer。

### 三个属性

​		capacity：最大容量，它永远不可能为负数，并且是不会变化的

​		limit：限制，它永远不可能为负数，并且不会大于capacity

​		position：下一个读或写的位置，它永远不可能为负数，并且不会大于limit

## channel

​		所有数据的读写都是通过buffer来进行的，永远不会出现直接channel中直接写入、读取数据，与stream不同的是，channel是双向的，一个流只可能是inputStream或是outputStream，channel则是双向的channel打开后可以进行读又可以进行写

# selector

1.  一个channel注册到selector上，这个动作是通过selectionKey来表示的：一个selector会维护三种selectorKey的集合：
    1.  ​	key set 表示注册到selector上面所有的selectionKey，通过keys()方法返回

