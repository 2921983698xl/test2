package com.xl.fan.Thread;


import java.util.concurrent.*;

public class MyThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //通过线程池的ThreadPoolExecutor实现类创建线程池
        //int corePoolSize  核心线程数
        //int maximumPoolSize  最大线程数=核心+临时
        //long keepAliveTime  临时线程存活时间
        //TimeUnit unit  时间类型
        //BlockingQueue<Runnable> workQueue  任务队列
        //ThreadFactory threadFactory  创建线程的线程池工厂
        //RejectedExecutionHandler handler  出现错误的处理
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 0, TimeUnit.MICROSECONDS,
                new ArrayBlockingQueue<>(4), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        //实现Runnable
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"正在运行。。");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //实现Callable
        Future<String> f1 = pool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        });
        System.out.println(f1.get());

        //通过线程池工具类Executor创建不同类型的线程池，本质还是那个实现类
        //大型并发不要使用这个工具类，而是使用实现类
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
//        ExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
//        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    }
}
