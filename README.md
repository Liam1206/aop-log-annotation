aop-log-annotation

基于Log4j+SpringAOP+Annotation的可注解日志切面组件

使用方式

@Log(logAfter = true, logBefore = true)
public returntype methodName(params){
    //do something...................
}

测试类com.liam.aop.aspect.test.AopLogAnnotationTest
