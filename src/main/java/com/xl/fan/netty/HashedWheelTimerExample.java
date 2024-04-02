package com.xl.fan.netty;
import io.netty.util.HashedWheelTimer;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class HashedWheelTimerExample {


//    netty的hash时间轮工具类是HashedWheelTimer，实现了Timer接口【定时任务执行器】。Timer接口比较简单，只有两个方法：
//    newTimeout() - 向时间轮中添加一个任务，并返回Timeout任务实例；
//    stop() - 停止时间轮，返回还未执行的定时任务。里面有三个内部类：Worker、HashedWheelTimeout、HashedWheelBucket。

//    Worker
//    Worker是一个Runnable实现类，是Timer的工作引擎，主要有两个功能：执行任务和轮询。
//    Worker类中有一个final Set集合【unprocessedTimeouts】，用于存放未处理的定时任务，在调用Timer.stop()方法停止时，返回给调用者。

//    HashedWheelTimeout
//    实现的是Netty中的Timeout接口，接口中有三类信息：Timer实例【创建Timeout的Timer】、TimerTask实例、任务的状态【取消任务，是否取消，是否过期】

//    HashedWheelBucket
//    bucket是时间轮的一个刻度，在bucket里面会维护一个链表，用来保存产生hash冲突的任务。新建时间轮时，如果初始化的bucket数量比较少，hash冲突是不可避免的。

//    TimeTask
//    此接口没有显式实现类，每次调用newTimeout时，隐式创建一个实例。其中只有一个run方法，在执行时调用。

    public static void main(String[] args) throws InterruptedException {
        // 创建一个哈希时间轮实例
        HashedWheelTimer timer = new HashedWheelTimer(
                Executors.defaultThreadFactory(),//threadFactory：创建处理任务的线程工厂
                100,//tickDuration：时间周期，默认100
                TimeUnit.MICROSECONDS,
                10,//ticksPerWheel：时间轮中的格子，默认512，分配的时间格越多，占用内存空间就越大
                false//eakDetection：是否开启内存泄漏检测
        );

        // 添加一个精确执行任务，10秒后执行
        timer.newTimeout(timeout -> {
            log.info("11111111111111111111");
        },10,TimeUnit.SECONDS);

        timer.newTimeout(timeout -> {
            log.info("2222222222222");
            Thread.sleep(10000);
        },5,TimeUnit.SECONDS);

        log.info("=====等待的任务",timer.pendingTimeouts());
    }
}
