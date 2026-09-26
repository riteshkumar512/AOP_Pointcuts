package in.kumar.AOP_Pointcuts.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Before("@annotation(jdk.jfr.Timespan)")
    public void logBeforeMethod(){
        System.out.println("Method Intercepted");
    }

//    @Before("execution(in.kumar.AOP_Pointcuts.dto.Student " +
//            "in.kumar.AOP_Pointcuts.service.StudentService.createStudent" +
//            "(in.kumar.AOP_Pointcuts.dto.Student))")
//    public void logBeforeMethod2(){
//        System.out.println("Method2 Intercepted");
//    }
}
