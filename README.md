# springboot-learning
springboot入门

1、从配置文件中获取配置使用@value，当你在bean加载时调用@value时会出现空指针异常。因为bean加载完成后才会执行@value。

2、@Value("${spring.redis.password}")写在标有@Bean的方法形参上，不写在当前所属类的属性上，即可先注入@Value,再执行@Bean。