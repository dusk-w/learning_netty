package com.wei.learn.io.bio.client;

import java.util.concurrent.*;

public class TimeServerHandlerExecutorPool implements Executor {
    private ExecutorService executorService;

    public TimeServerHandlerExecutorPool(int maxPoolSize, int queueSize) {
        /**
         * @param corePoolSize 核心线程数量
         * @param maximumPoolSize 创建最大线程数量
         * @param keepAliveTime 当创建了线程池最大数时，多长时间没有处理任务则线程销毁
         * @param util keepAliveTime时间单位
         * @param workQueue 此线程池使用什么队列
         */
        this.executorService = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                maxPoolSize,
                120l,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public TimeServerHandlerExecutorPool(int corePoolSize, int maxPoolSize, int queueSize) {
        this.executorService = new ThreadPoolExecutor(corePoolSize,
                maxPoolSize,
                120l,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(queueSize));
    }
    public void execute(Runnable command) {
        executorService.execute(command);
    }
}
