import java.io.Console;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Interface {
    CoffeeMachine coffeeMachine = new CoffeeMachine();
    List<String> listCoffeeText = List.of( "Espresso", "Doppio", "Ristretto", "Lungo", "Americano",
            "Cappuccino", "Macchiato", "Latte", "Con Panna", "Vienna coffee", "Latte macchiato");
    public void start(){
        //CoffeeMachine coffeeMachine = new CoffeeMachine();
        /*System.out.println( coffeeMachine.getCoffee().toString());

        for (Map.Entry<String, Coffee> pair : coffeeMachine.getCoffee().entrySet())
        {
            String key = pair.getKey();
            Coffee value = pair.getValue();
            System.out.println(key + ":" + value.getVolumeMilk());
        }*/

        printMessageText(1);
        dialog();
    }

    private void dialog() {
        boolean running = true;

        while (running) {
            printMessageText(3);
            String input = new Scanner(System.in).nextLine();
            try {
                int inputInt = Integer.parseInt(input);
                switch (inputInt) {
                    case 0 -> running = false;
                    case 1 -> drinksMenu();
                    case 2 -> godMode();
                    case 3 -> checkIngredients();
                    default -> printMessageText(2);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void printMessageText(int input) {
        switch (input) {
            case 1 -> System.out.println("Hello!");
            case 2 -> System.out.println("Please enter a valid number!");
            case 3 -> System.out.println("0 - Power off / 1 - Drinks menu / 2 - God 'mode / " +
                    "3 - Check ingredients and add if needed" );
            case 4 -> System.out.println("0 - Exit to the main menu / 1 - Choose which ingredients to add");
            case 5 -> System.out.println("1 - Add Bean max / 2 - Add Milk max / 3 - Add Cream max / " +
                    "4 - Add Water max / 0 - Exit to the main menu\n");
            case 6 -> System.out.println("Bean: " + coffeeMachine.getCoffeeBean() + "\n" +
                    "Milk: " + coffeeMachine.getVolumeMilk() + "\n" +
                    "Cream: " + coffeeMachine.getVolumeCream() + "\n" +
                    "Water: " + coffeeMachine.getVolumeWater() + "\n\n");
            case 7 -> System.out.println("1 - Espresso / 2 - Doppio / 3 - Ristreto / 4 - Lungo / " +
                    "5 - Americano / 6 - Cappuccino\n" +
                    "7 - Macchiato / 8 - Latte / 9 - Con Panna / " +
                    "10 - Vienna Coffee / 11 - Latte Macchiato");
            case 8 -> System.out.println("Enter the number of mugs:");
            case 9 -> System.out.println("God mode allows you to choose the amount of ingredients yourself:)\n" +
                    "You can also see the recipe for any drink or press 0:");
            case 10 -> System.out.println("1 - Espresso / 2 - Double dose of caffeine / 3 - Reduced dose of caffeine" +
                    "4 - Water / 5 - Milk / 6 - frothed milk / 7 - Cream / 8 - Whipped cream");
            default -> System.out.println("Error");
        }
    }


    private void godMode() {
        printMessageText(9);
        printMessageText(7);
        String inputName = new Scanner(System.in).nextLine();
        if(Integer.parseInt(inputName) !=0) {
            System.out.println("Recipe: " + coffeeMachine.getRecipe(listCoffeeText.get(Integer.parseInt(inputName) - 1)));
        }

        String inputIngredient = new Scanner(System.in).nextLine();
        String inputBean = "2";
        String inputMilk = "0";
        String inputCream = "0";
        int inputWater = 0;
        boolean running = true;

        printMessageText(10);

        while (running) {
            switch (Integer.parseInt(inputIngredient)) {
                case 0 -> inputWater += new Scanner(System.in).nextInt();
                case 1 -> inputBean = "3";
                case 2 -> inputBean = "1";
                case 3 -> inputWater += new Scanner(System.in).nextInt();
                case 4 -> checkIngredients();
                default -> printMessageText(2);
            }
        }

        printMessageText(8);
        String inputAmount = new Scanner(System.in).nextLine();

        coffeeMachine.createDrink(Integer.parseInt(inputAmount), Integer.parseInt(inputBean), Integer.parseInt(inputMilk),
                Integer.parseInt(inputCream), inputWater);
    }

    private void checkIngredients() {
        printMessageText(6);

        printMessageText(4);
        String input = new Scanner(System.in).nextLine();

        if (Integer.parseInt(input) == 1) {
            boolean running = true;

            while (running) {
                printMessageText(6);
                printMessageText(5);
                input = new Scanner(System.in).nextLine();

                switch (Integer.parseInt(input)) {
                    case 1 -> coffeeMachine.addIngredientBeanMax();
                    case 2 -> coffeeMachine.addIngredientMilkMax();
                    case 3 -> coffeeMachine.addIngredientCreamMax();
                    case 4 -> coffeeMachine.addIngredientWaterMax();
                    case 0 -> running = false;
                    default -> printMessageText(2);
                }
            }
        }
    }

    private void drinksMenu() {
        printMessageText(7);
        String inputName = new Scanner(System.in).nextLine();
        printMessageText(8);
        String inputAmount = new Scanner(System.in).nextLine();
        coffeeMachine.createDrink(listCoffeeText.get(Integer.parseInt(inputName) - 1), Integer.parseInt(inputAmount));
    }


}
