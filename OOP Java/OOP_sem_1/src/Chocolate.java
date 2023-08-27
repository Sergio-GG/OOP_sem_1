public class Chocolate extends Product {

    private int calories;

    public Chocolate(String name, String brand, double price, int calories) {
        super(name, brand, price);
        this.calories = calories;
    }
    public String getBrand() {
        return brand;
    }
    public double getCalories() {
        return calories;
    }

    @Override
    public String displayInfo() {
        return String.format("[Шоколадный батончик] %s - %s - %.2f - с: %d", name, brand, price, calories);
    }
}
