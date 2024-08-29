abstract public class Product {
    private String name;
    private double price;
    private String TTSP;

    public Product(){}
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTTSP() {
        return TTSP;
    }

    public void setTTSP(String TTSP) {
        this.TTSP = TTSP;
    }

    abstract public void displayAsTable();
    abstract public void displayAsList();
    abstract public void update();
    abstract public void getDetails();
}
