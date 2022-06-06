import java.io.Console;
import java.util.Map;

public class Interface {
    public void start(){
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        System.out.println( coffeeMachine.getCoffee().toString());

        for (Map.Entry<String, Coffee> pair : coffeeMachine.getCoffee().entrySet())
        {
            String key = pair.getKey();
            Coffee value = pair.getValue();
            System.out.println(key + ":" + value.getVolumeMilk());
        }
    }
}
