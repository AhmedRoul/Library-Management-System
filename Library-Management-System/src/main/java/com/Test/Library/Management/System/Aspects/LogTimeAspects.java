package com.Test.Library.Management.System.Aspects;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.buf.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class LogTimeAspects {
    // Pointcut to match all methods in controllers related to books and patrons
    @Pointcut("execution(* com.Test.Library.Management.System.Controllers..*(..))")
            /*"//execution(* com.Test.Library.Management.System.Controllers.BookController.*(..)) || " +
            "execution(* com.Test.Library.Management.System.Controllers.PatronController.*(..))")*/
    /*execution(* com.Test.Library.Management.System.Controllers..*(..))*/

    public void bookAndPatronMethods() {}

    // Around advice to log method calls and performance metrics
    @Around("execution(* com.Test.Library.Management.System.Controllers..*(..))||" +//Controllers
            "execution(* com.Test.Library.Management.System.Services..*(..)) ||" + //Services
            "execution(* com.Test.Library.Management.System.Utils.JwtUtil.*(..))")//JWt

    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = null;
        String classType = determineClassType(joinPoint.getTarget().getClass().getPackageName());
        String className = joinPoint.getTarget().getClass().getSimpleName();

        String s="\n " +classType+" Method "+joinPoint.getSignature().getName()+
                " is called on "+className+" with arguments "+ Arrays.toString(joinPoint.getArgs());
        //print
        log.info(s);

        result = joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        log.info("Method " + joinPoint.getSignature().getName() + " took " + timeTaken + " ms to execute.");
        log.info("\n %s Method %s completed successfully.%n".formatted(classType, joinPoint.getSignature().getName())+
                "\n"+"Method " + joinPoint.getSignature().getName() + " took " + timeTaken + " ms to execute.");

        return result;
    }
    private String determineClassType(String packageName) {
        if (packageName.contains("Controllers")) {
            return "[Controller]";
        } else if (packageName.contains("Services")) {
            return "[Service]";
        } else if (packageName.contains("Utils")) {
            return "[Util]";
        } else {
            return "[Component]";
        }
    }


}

