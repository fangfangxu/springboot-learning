# springboot-learning
springboot入门

1、从配置文件中获取配置使用@value，当你在bean加载时调用@value时会出现空指针异常。因为bean加载完成后才会执行@value。

2、@Value("${spring.redis.password}")写在标有@Bean的方法形参上，不写在当前所属类的属性上，即可先注入@Value,再执行@Bean。

3、jpa事务：
（1）springboot1.0：@Test @Trans 默认是 @Rollback=true ，只有写@Rollback=false的时候会遵循事务的规律，保存或者回滚。
    我们通常在service层接口中使用@Transactional来对各个业务逻辑进行事务管理的配置。
    
    
（2）springboot2.0：@Test @Trans 默认还是@Rollback=true ，但是写@Rollback=false的时候是不回滚。

在@test测试类中，使用@Transactional默认是回滚的（无论成功还是失败），除非显示的去写@Rollback(value = false)。

4、异步是目的，多线程是实现异步的一个方式：

为什么引入Executor线程池框架？

（1）new Thread()的缺点：每次new Thread()耗费性能，每次new Thread()耗费性能 ，调用new Thread()创建的线程缺乏管理，被称为野线程，而且可以无限制创建，之间相互竞争，会导致过多占用系统资源导致系统瘫痪。 

（2）采用线程池的优点：重用存在的线程，减少对象创建、消亡的开销，性能佳。可有效控制最大并发线程数，提高系统资源的使用率，同时避免过多资源竞争，避免堵塞 。

（3）Executor框架是Java 5中引入：其内部使用了线程池机制，它在java.util.cocurrent 包下，通过该框架来控制线程的启动、执行和关闭，可以简化并发编程的操作。
Executor框架包括：线程池，Executor，Executors，ExecutorService，CompletionService，Future，Callable等。

（4）java中的线程池（ThreadPoolExecutor）---ExecutorService的一个底层实现
 
    ThreadPoolExecutor--->AbstractExecutorService--->ExecutorService--->Executor
    
    ThreadPoolExecutor是线程池的真正实现，他通过构造方法的一系列参数，来构成不同配置的线程池






















   