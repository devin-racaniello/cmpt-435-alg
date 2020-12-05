public class Spice {
    public String name;
    public double price;
    public double quantity;
    public double value;

    Spice(String name, double price, double quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.value = price / quantity;

    }

    @Override
    public String toString() {
        return this.name +", "+this.price+", "+ this.quantity+", "+ this.value;
    }
}
