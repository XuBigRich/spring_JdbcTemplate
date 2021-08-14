# spring_JdbcTemplate

spring_JdbcTemplate的学习

介绍了spring_JdbcTemplate的使用

# 数据库事务

并且 模拟数据库事务处理方式

# spring mvc

启动spring mvc 需要注意两个地方的idea 配置，

* 一个是web.xml中引用 applicationContext.xml 使用了 classpath:applicationContext.xml
* 另一个是web.xml Modules模块 web 的 web.xml 引用不要出错 否则会导致  <servlet-name> 配置名称报红
* 还要注意artifacts 他们的依赖是否导入 spring mvc 一定要在WEB-INF目录下有一个lib目录,用以存放项目运行的依赖

# druid 监控

* 添加druid 监控,查看监控地址为http://localhost:8080/spring_JdbcTemplate_Web_exploded/druid/login.html