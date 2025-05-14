package se.yrgo.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTimingAdvice {

    public Object performanceTimingMeasurement(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        try { return pjp.proceed();
        } finally {
            long end = System.currentTimeMillis();
            long result = end - start;
            System.out.println("This is the time taken for method " + pjp.getSignature().getName() +
                    " from the class " + pjp.getSignature().getDeclaringTypeName() + " took " + result + "ms");
        }
    }

}
