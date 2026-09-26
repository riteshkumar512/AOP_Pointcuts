package in.kumar.AOP_Pointcuts.aspects;

import in.kumar.AOP_Pointcuts.annotation.TrackExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleAspect {

    @Around("@annotation(trackExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint,
                                        TrackExecutionTime trackExecutionTime)
            throws Throwable {
        long startTime=System.currentTimeMillis();

        try {
            return joinPoint.proceed();
        }
        finally {
            long endTime=System.currentTimeMillis();
            long duration=endTime-startTime;

            String opertaion=trackExecutionTime.operation();

            if (opertaion.isBlank()){
                opertaion=joinPoint.getSignature().getName();
            }
            long warningTheshold=trackExecutionTime.warnAfter();

            if (duration>=warningTheshold){
                System.out.println("SLOW OPERATION ALERT :"+
                                "Time taken by " + opertaion +" is :" + duration
                        );
            }else {
                System.out.println("Time taken by " + opertaion + " is :" + duration);
            }
        }

    }
}
