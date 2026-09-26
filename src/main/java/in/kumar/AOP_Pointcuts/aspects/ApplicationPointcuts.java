package in.kumar.AOP_Pointcuts.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointcuts {

    @Pointcut("within(in.kumar.AOP_Pointcuts.service..*)")
    public void serviceLayer(){
        //empty body
    }

    @Pointcut("within(in.kumar.AOP_Pointcuts.controller..*)")
    public void ControllerLayer(){
        //empty body
    }
    @Pointcut("execution(public * * (..))")
    public void publicMethod(){
        //empty body
    }
    @Pointcut("serviceLayer && publicMethod")
    public void publicServiceMethod(){
        //empty body
    }

    @Pointcut("execution(* *.get*(..))")
    public void getMethod(){
        //empty body
    }
}
