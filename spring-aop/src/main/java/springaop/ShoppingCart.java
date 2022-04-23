package springaop;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkOut(){
        System.out.println("Checking from the Shopping Cart Application ");
    }
}
