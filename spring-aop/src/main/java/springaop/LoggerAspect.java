package springaop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {

    // * --> what ever the return type can be
    @Before("execution(* demo.ShoppingCart.checkOut())")
    public void logging(){
        System.out.println("Logging Application Logs");
    }
}
