# springboot-learning
springboot入门

1、从配置文件中获取配置使用@value，当你在bean加载时调用@value时会出现空指针异常。因为bean加载完成后才会执行@value。

2、@Value("${spring.redis.password}")写在标有@Bean的方法形参上，不写在当前所属类的属性上，即可先注入@Value,再执行@Bean。

3、jpa事务：在@test测试类中，使用@Transactional默认是回滚的（无论成功还是失败），除非显示的去写@Rollback(value = false)。
   我们通常在service层接口中使用@Transactional来对各个业务逻辑进行事务管理的配置。