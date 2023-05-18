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

    public void addIngredientBeanMax() {
        coffeeBean = 1000;
    }

    public void addIngredientWaterMax() {
        volumeWater = 1000;
    }

    public void addIngredientMilkMax() {
        volumeMilk = 1000;
    }

    public void addIngredientCreamMax() {
        volumeCream = 1000;
    }

    private boolean checkIngredient(int remainingIngredient, int amount, int ingredient) {
        return remainingIngredient >= ingredient * amount;
    }

    private void spendingIngredient(int _coffeeBean, int _volumeWater, int _volumeMilk, int _volumeCream) {
        coffeeBean -= _coffeeBean;
        volumeWater -= _volumeWater;
        volumeMilk -= _volumeMilk;
        volumeCream -= _volumeCream;
        state -= 1;
    }

    private void machineCleaning() {
        volumeWater -= 20;
        System.out.println("Coffee machine is being cleaned!");
        state = 10;
        doWork("cleaned");
    }

    public void createDrink(String name, int amount) {
        if(checkIngredient(coffeeBean, amount, coffee.get(name).getVolumeCaffeine()) &&
                checkIngredient(volumeWater, amount, coffee.get(name).getVolumeWater()) &&
                checkIngredient(volumeMilk, amount, coffee.get(name).getVolumeMilk()) &&
                checkIngredient(volumeCream, amount, coffee.get(name).getVolumeCream())) {

            for (int i = 1; i <= amount; i++) {
                if(state <= 0) {
                    machineCleaning();
                }
                System.out.println("All right!");
                spendingIngredient(coffee.get(name).getVolumeCaffeine(), coffee.get(name).getVolumeWater(),
                        coffee.get(name).getVolumeMilk(), coffee.get(name).getVolumeCream());
                doWork(name);
                System.out.println(i + " : " + name + "\n");
            }
        }
        else {
            System.out.println("NO INGREDIENT!");
        }
    }

    public void createDrink(int amount, int _coffeeBean, int _volumeWater, int _volumeMilk, int _volumeCream) {
        if(checkIngredient(coffeeBean, amount, _coffeeBean) &&
                checkIngredient(volumeWater, amount, _volumeWater) &&
                checkIngredient(volumeMilk, amount, _volumeMilk) &&
                checkIngredient(volumeCream, amount, _volumeCream)) {

            for (int i = 1; i <= amount; i++) {
                if(state <= 0) {
                    machineCleaning();
                }
                System.out.println("All right!");
                spendingIngredient(_coffeeBean, _volumeWater, _volumeMilk, _volumeCream);
                doWork("Your drink");
                System.out.println(i + " : Your drink\n");
            }
        }
        else {
            System.out.println("NO INGREDIENT!");
        }
    }
    
    public String getRecipe(String name) {
        return coffee.get(name).getRecipe();
    }

    private void doWork(String name) {
        System.out.println("Please wait :)\nGoing on " + name + "\nDrrrr");
        for (int i = 0; i <= 3; i++) {
            try {
                Thread.sleep(1000);
                System.out.print(".");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("\n");
    }


}
