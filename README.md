aop-log-annotation

基于Log4j+SpringAOP+Annotation的可注解日志切面组件

使用方式

@Log(logAfter = true, logBefore = true)
public returntype methodName(params)

测试类com.liam.aop.aspect.test.AopLogAnnotationTest

测试输出
[log-aop]2014-12-18 14:31:43,506 INFO  [com.liam.aop.service.impl.TestServiceImpl] start invoke [test], params = ["abc""123"]
do something...................
[log-aop]2014-12-18 14:31:43,507 INFO  [com.liam.aop.service.impl.TestServiceImpl] complete invoke [test]


