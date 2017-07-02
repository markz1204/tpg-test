package question3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.concurrent.TimeUnit;

/**
 * Created by markz on 2/7/17.
 */
@Aspect
public class MeasureTimeAspect {

    @Pointcut("@annotation(MeasureTime)")
    public void annotationPointCutDefinition() {
    }

    @Pointcut("execution(* *(..))")
    public void forExecution() {
    }

    @Around("@annotation(MeasureTime) && execution(* *(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object returnObject = null;

        long start = System.nanoTime();

        try {

            returnObject = joinPoint.proceed();

        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            System.out.println("Method: consumes " + TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - start) + "s");
        }
        return returnObject;
    }
}
