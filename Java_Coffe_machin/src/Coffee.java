public class Coffee {
    private String name;
    private String recipe;
    private int volumeCaffeine;
    private int volumeWater;
    private int volumeMilk;
    private int volumeCream;

    Coffee() {
        name = "Espresso";
        recipe = "Espresso";
        volumeCaffeine = 2;
        volumeWater = 35;
        volumeMilk = 0;
        volumeCream = 0;
    }

    Coffee(String _name, String _recipe, int _volumeCaffeine, int _volumeWater,
                int _volumeMilk, int _volumeCream) {
        name = _name;
        recipe = _recipe;
        volumeCaffeine = _volumeCaffeine;
        volumeWater = _volumeWater;
        volumeMilk = _volumeMilk;
        volumeCream = _volumeCream;
    }

    public int getVolumeMilk() {
        return volumeMilk;
    }

}
