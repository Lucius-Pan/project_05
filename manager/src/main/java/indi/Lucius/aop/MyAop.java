package indi.Lucius.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @ClassName: MyAop
 * @Description: Aop规则类
 * @Author: Lucius Pan
 * @Date: 2023/6/5 09:20
 */

@Component
@Aspect
public class MyAop {

    @Before("execution(public * indi.Lucius.service.*.*(..))")
    public void before() {

    }

    @Pointcut("execution(public * indi.Lucius.service.*.*(..))")
    public void addLog() {

    }


    @Around("addLog()")
    public Object doLogger(ProceedingJoinPoint joinPoint)throws Throwable{
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String remoteAddr = request.getRemoteAddr();
        String localAddr = request.getLocalAddr();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("请求地址：" + requestURL);
        System.out.println("远程ip地址：" + remoteAddr+"/ 本地ip地址："+localAddr);
        //获取Request
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("类名："+className+" 方法名："+methodName+" 参数："+ Arrays.toString(args));
        //继续执行下一步
        Object object = joinPoint.proceed();
        return object;
    }





}
