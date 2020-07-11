package cn.dispatcher.handler;


import cn.dispatcher.vo.ConfigVo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ScheduledStatisticsHandler {

    @Autowired
    private ConfigVo configVo;


    @Pointcut("@annotation(cn.dispatcher.annotation.TaskRegister)")
    public void proxyAspect() {

    }

//    @Pointcut("execution(public * com.example.demo.schedule.*(..))")
//    public void proxyAspect() {
//
//    }

    @Around("proxyAspect()")
    public void doInvoke(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("获取执行情况开始~~~~~~~~~~~~~~");
        System.out.println(configVo.getName());
        joinPoint.proceed();
        System.out.println(configVo.getLink());
        System.out.println("获取执行情况结束~~~~~~~~~~~~~~");
    }
}
