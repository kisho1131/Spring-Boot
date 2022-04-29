package springaop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    // * --> what ever the return type can be
    @Before("execution(* springaop.ShoppingCart.checkOut())")
    public void logging(){
        System.out.println("Logging Application Logs");
    }

    @After("execution(* *.*.checkOut())")
    public  void afterLogging(){
        System.out.println("Logging After Logs");
    }
}
