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

5、
  （1）Spring Boot 2.*默认采用了slf4j+logback的形式 ，slf4j是个通用的日志门面，logback就是个具体的日志框架了，我们记录日志的时候采用slf4j的方法去记录日志，底层的实现就是根据引用的不同日志jar去判定了。所以Spring Boot也能自动适配JCL、JUL、Log4J等日志框架，它的内部逻辑就是通过特定的JAR包去适配各个不同的日志框架。
  
  （2）默认情况下，Spring Boot会用Logback来记录日志，并用INFO级别输出到控制台。（spring-boot-starter其中包含了 spring-boot-starter-logging，该依赖内容就是 Spring Boot 默认的日志框架 logback）
 
  （3）SpringBoot能自动适配所有的日志，其底层使用slf4j+logback的方式记录日志，引入其他框架的时候，只需要 把这个框架依赖的日志框架排除掉即可，因为Spring Boot会通过自己的jar去替代；

  （4）切换Log4j2框架：Spring Boot虽然默认使用Logback日志框架，但其内部也集成了Log4j2框架。要知道的是，在Java中，Log4j2框架的性能是最强的，所以我们一般在程序中使用Log4j2框架。下面介绍一下Log4j2的使用及其内部属性的含义。 
  首先，要在Spring Boot使用Log4j2的话，那么第一件事就是去除Logback的jar包，并引入Log4j2的jar。
  
  （5）控制台输出
  日志级别从低到高分为
  TRACE < DEBUG < INFO < WARN < ERROR < FATAL。
  Spring Boot中默认配置ERROR、WARN和INFO级别的日志输出到控制台。 

6、AOP执行顺序：

@Before---->@Around--->业务--->@Around--->@After--->@AfterReturning

@Before---->@Around--->业务异常->@Around--->@After--->@AfterThrowing

业务代码正常try...catch:@Around--->@Before---->业务--->@Around--->@After--->@AfterReturning

7、AOP切面的优先级@Order(5)

在切入点前的操作，按order的值由小到大执行

在切入点后的操作，按order的值由大到小执行

---Around1---Before1---Around2---Before2---业务代码---Around2---After2---AfterReturning2---
---Around1---After1---AfterReturning1---




   