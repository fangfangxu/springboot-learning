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

8、认证过程
1、用户使用用户名和密码进行登录。

2、Spring Security将获取到的用户名和密码封装成一个Authentication接口的实现类，比如常用的UsernamePasswordAuthenticationToken。

3、将上述产生的Authentication对象传递给AuthenticationManager的实现类ProviderManager进行认证。

4、ProviderManager依次调用各个AuthenticationProvider进行认证，认证成功后返回一个封装了用户权限等信息的Authentication对象。

5、将AuthenticationManager返回的Authentication对象赋予给当前的SecurityContext

問題：
1、springSecurity的remember-me

2、cookie、session、token的區別

9、RabbitMQ（路由模式）

（1）生产者：投递消息的一方、消费者：接受消息的一方

（2）队列（Queue）：是RabbitMQ的内部对象，用于存储消息。

（3）RabbitMQ的生产者生产消息并最终投递到队列中，消费者可以从队列中获取消息并消费。多个消费者可以订阅同一个队列，
这时队列中的消息会被平均分摊（Round-Robin，轮询）给多个消费者进行处理，而不是每个消费者都收到所有的消息并处理。

（4）Exchange：交换器。

   生产者将消息发送到Exchange（交换器，通常用大写的“X”表示），由交换器将消息路由到一个或者多个队列中，如果路由不到，
   或许会返回给生产者，或许直接丢弃，这里可以将RabbitMQ中的交换器看作一个简单的实体。

（5）RoutingKey：路由键

  生产者将消息发给交换器的时候，一般会指定一个RoutingKey，用来指定这个消息的路由规则，而这个RoutingKey需要与交换器类型和绑定键（BindingKey）
  联合使用才能最终生效。在交换器类型和绑定键固定的情况下，生产者可以在发送消息给交换器时，通过指定的RoutingKey来决定消息流向哪里。
 
（6）Binding：绑定
 
 RabbitMQ中通过绑定将交换器与队列关联起来，在绑定的时候一般会指定一个绑定键（BindingKey），这样RabbitMQ知道如果正确的将消息路由到队列了

 生产者将消息发送给交换器时，需要一个RoutingKey，当BindingKey和RoutingKey相匹配时，消息会被路由到对应的队列中

一.生产者发送消息的过程
1.生产者连接到RabbitMQ，建立一个连接（connection），开启一个信道（channel)

2.生产者声明一个交换器

3.生产者声明一个队列

4.生产者通过绑定键将交换器和队列绑定起来

5.生产者发送消息到RabbitMQ，其中包含路由键、交换器等信息

6.相应的交换器根据接收到的路由键查找相匹配的队列（路由键匹配上绑定键）

7.如果匹配上，则将从生产者发送过来的消息存入到响应的队列中

8.如果没有找到，则根据生产者配置属性选择是丢弃还是回退给生产者

9.关闭信道

10.关闭连接

二.消费者接收消息的过程

1.消费者连接到RabbitMQ，建立一个连接（connection），开启一个信道（channel）

2.消费者向RabbitMQ请求消费相应的队列的消息

3.等待RabbitMQ回应并投递相应队列的消息，消费者接收消息

4.消费者确认（ack）接收到的消息

5.RabbitMQ从队列中删除相应已经被确认的消息

6.关闭信道

7.关闭连接

























   