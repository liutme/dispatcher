package cn.dispatcher.handler;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

@Aspect
@Component
public class ScheduleExceptionHandler {

    @Pointcut("@annotation(cn.dispatcher.annotation.TaskRegister)")
    public void proxyAspect() {

    }

    @AfterThrowing(pointcut = "proxyAspect()", throwing = "ex")
    public void doException(JoinPoint joinPoint, Exception ex) {
        Object target = joinPoint.getTarget();
        System.out.println("任务出现异常：" + ex);
        final Writer result = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(result);
        ex.fillInStackTrace().printStackTrace(printWriter);
        System.out.println("整个异常信息：" + result.toString());
    }
}
