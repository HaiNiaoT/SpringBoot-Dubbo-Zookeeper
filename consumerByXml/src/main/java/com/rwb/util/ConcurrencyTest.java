package com.rwb.util;

import com.rwb.API.AcceptsNumTset;
import com.rwb.API.ConcurrencyNumTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.concurrent.*;

public class ConcurrencyTest {

    private final static Logger log = LoggerFactory.getLogger(ConcurrencyTest.class);

    private final static int clientTotal = 500;

    private final static int concurrencyTotal = 9;

    public static void ConcurrencyMethodTest(Object obj, String MethodName){
        ConcurrencyTest.ConcurrencyMethodTest(obj,MethodName,null,null);
    }

    public static void ConcurrencyMethodTest(Object obj, String MethodName,Integer clientTotal1,Integer concurrencyTotal1) {
        int clientTotalCp = ((clientTotal1 != null) && (clientTotal1 > 0)) ? clientTotal1 : clientTotal;
        int concurrencyTotalcp = ((concurrencyTotal1 != null) && (concurrencyTotal1 > 0)) ? clientTotal1 : concurrencyTotal;
        try {
            Method method = obj.getClass().getMethod(MethodName);

            ExecutorService poolExecutor = Executors.newCachedThreadPool();
            CountDownLatch countDownLatch = new CountDownLatch(clientTotalCp);
            Semaphore semaphore = new Semaphore(concurrencyTotalcp);

            for (int i = 0; i < clientTotalCp; i++) {
                poolExecutor.execute(() -> {
                    try {
                        semaphore.acquire();
                        method.invoke(obj);
                        semaphore.release();
                        countDownLatch.countDown();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
            countDownLatch.await();
            log.info("执行完毕.......");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void ConcurrencyMethod(){
        ConcurrencyNumTest test = DubboBeanUtil.getBean("concurrencyNumTest", ConcurrencyNumTest.class);
        ExecutorService poolExecutor = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        Semaphore semaphore = new Semaphore(concurrencyTotal);

        for (int i = 0; i < clientTotal; i++) {
            poolExecutor.execute(() -> {
                try {
                    semaphore.acquire();
                    test.testNethod();
                    semaphore.release();
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void ConcurrencyMethodCon(){
        AcceptsNumTset acceptsNumTset = DubboBeanUtil.getBean("accpetsNum",AcceptsNumTset.class);
        ExecutorService poolExecutor = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        Semaphore semaphore = new Semaphore(concurrencyTotal);

        for (int i = 0; i < clientTotal; i++) {
            poolExecutor.execute(() -> {
                try {
                    semaphore.acquire();
                    acceptsNumTset.acceptTestMethod();
                    semaphore.release();
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
