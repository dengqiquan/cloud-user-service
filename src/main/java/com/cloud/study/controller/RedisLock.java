package com.cloud.study.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @description: TODO
 * @author: dqq
 * @date: 2020/10/19 20:29
 */
@RestController
public class RedisLock {

    @Resource
    RedissonClient redisson;

    @GetMapping("get/lock")
    public String getLock(){
        RLock lock = redisson.getLock("my_lock");
        boolean b = lock.tryLock();
        while (!b){//自旋
            System.out.println(Thread.currentThread().getName()+"等待获取redis分布式锁");
            b = lock.tryLock();
        }

        lock.lock();
        System.out.println(Thread.currentThread().getName()+"获得了redis 分布式锁");
        try {
            Thread.sleep(1000);
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+"释放了分布式锁");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            if(lock.isHeldByCurrentThread()){
                System.out.println("释放redis 分布式锁");
                lock.unlock();
            }
        }
        return "success";

    }



}
