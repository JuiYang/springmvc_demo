# IOC
- IOC采用工厂设计模式
- IOC采用控制反转(依赖注入)
1. 构造注入
2. set方法注入
- IOC容器为每个对象创建一个单例实例，通过指定bean的scope属性来指定该实例对象的是否为单例
1. singleton：单例，容器初始化创建bean, 每次请求都使用同一个对象bean;
2. prototype: 原型的，容器初始化时不创建Bean, 每次请求都会创建一个新的对象bean;

- Bean的生命周期
1. 通过构造器创建bean实例
2. 为bean设置属性值
3. 调用bean初始化方法(通过bean中init-method属性进行指定)
4. 使用bean实例
5. 容器关闭时，调用bean的销毁方法进行bean实例销毁(通过bean的destroy-method属性进行指定)

- Bean初始化方法的后置处理器
1. 后置处理器：需要实现BeanPostProcessor类,重写postProcessBeforeInitialization()、postProcessAfterInitialization()方法

- 配置Bean
1. xml配置bean
2. 注解配置bean
    需要指定IOC扫描的包： <context:component-scan base-package="com.liyu" />
    a. @Component: 标识受spring管理的组件
    b. @Repository
    c. @Service
    d. @Controller
    
- 装配bean的方式：
1. @Autowire
2. @Resource
3. @Inject

- AOP面向切面编程(dynamicproxyimplaop手动实现aop)
1. 面向对象编程代码存在的问题：
    a. 代码混乱：越来越多的非业务需求(日志和验证等)加入后, 使得原有业务方法急剧膨胀.
            每个方法在处理核心逻辑的同时还必须兼顾其他多个关注点.
    
    b. 代码分散: 以日志需求为例, 只是为了满足这个单一需求, 就不得不在多个模块（方法）里多次重复相同的日志代码.
       如果日志需求发生变化, 必须修改所有模块.
2. 动态代理实现切面编程
3. aop的优点
3. aop通知
a. 前置增强(Before): 在method方法执行之前执行 
b. 后置增强(After): 在method方法执行之后执行，无论是否发生异常
c. 返回增强(AfterReturning): 在method方法正常执行之后执行
d. 异常增强(AfterThrowing): 在method方法出现异常时执行

4. 多个切面指定切面优先级
@Order(1): 值越小优先级越低 
5. 切面注解配置和xml文件配置

- Spring集成jdbc

- Spring中的事务，spring使用AOP处理事务
在properties.xml中配置
```
    <!--配置事务管理-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <property name="dataSource" ref="dataSource"/>
    </bean>
    <!--开启事务注解-->
    <tx:annotation-driven transaction-manager="transactionManager"></tx:annotation-driven>
```
并发事务导致的问题：脏读、不可重复读、幻读
1. 事务的传播属性： 在操作数据时中使用@Transactional(propagation=Propagation.REQUIRED)
// 当前事务调用另外一个事务，REQUIRED表示使用调用方法的事务； REQUIRED_NEW表示使用新事务
2. 事务的隔离级别： isolation="READ_COMMITTED"
3. 声明式事务对异常进行回滚：默认对所有异常事务都会进行回滚

---
spring整合hibernate:
1. IOC管理hibernate的SessionFactory
2. Hibernate使用spring的声明式事务

注：
HibernateTemplate：是spring自带的类库，并且只支持Hibernate3,不支持Hibernate4; 用于访问数据库进行查询数据
不推荐使用HibernateTemplate和HibernateDaoSupport