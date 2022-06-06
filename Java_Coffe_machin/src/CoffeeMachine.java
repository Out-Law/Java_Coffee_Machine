import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CoffeeMachine {

    private int coffeeBean;
    private int volumeWater;
    private int volumeMilk;
    private int volumeCream;
    private int state;
    private Map<String, Coffee> coffee;

    public CoffeeMachine() {
        coffee = Map.of(
                "Doppio", new Coffee("Doppio", "Double dose Espresso", 2, 40, 0, 0),
                "Ristretto", new Coffee("Ristretto", "Espresso + Double dose of caffeine", 3, 40, 0, 0),
                "Lungo", new Coffee("Lungo", "Espresso + Reduced dose of caffeine", 1, 60, 0, 0),
                "Americano", new Coffee("Americano", "Espresso + Triple dose Water", 2, 140, 0, 0),
                "Cappuccino", new Coffee("Cappuccino", "Espresso + Milk + Double dose frothed milk", 2, 40, 80, 0),
                "Macchiato", new Coffee("Macchiato", "Double dose espresso + Frothed milk", 2, 60, 25, 0),
                "Latte",  new Coffee("Latte", "Espresso + Double dose milk + Frothed milk", 2, 40, 60, 25),
                "Con Panna", new Coffee("Con Panna", "Espresso + Whipped cream", 2, 40, 0, 25),
                "Vienna coffee", new Coffee("Vienna coffee", "Espresso + Double dose whipped cream", 2, 40, 0, 50),
                "Latte macchiato", new Coffee("Latte macchiato", "Espresso + Double dose milk + Whipped cream", 2, 40, 60, 25)
        );
    }

    public int getCoffeeBean() {
        return coffeeBean;
    }

    public void setCoffeeBean(int coffeeBean) {
        this.coffeeBean = coffeeBean;
    }

    public int getVolumeWater() {
        return volumeWater;
    }

    public void setVolumeWater(int volumeWater) {
        this.volumeWater = volumeWater;
    }

    public int getVolumeMilk() {
        return volumeMilk;
    }

    public void setVolumeMilk(int volumeMilk) {
        this.volumeMilk = volumeMilk;
    }

    public int getVolumeCream() {
        return volumeCream;
    }

    public void setVolumeCream(int volumeCream) {
        this.volumeCream = volumeCream;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setCoffee(Map<String, Coffee> coffee) {
        this.coffee = coffee;
    }

    public Map<String, Coffee> getCoffee() {
        return coffee;
    }

}
