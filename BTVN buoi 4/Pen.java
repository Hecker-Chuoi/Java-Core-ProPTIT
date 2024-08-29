import java.util.Scanner;

public class Pen extends Product{
    private String brand;
    private String color;
    private String material;
    private String inkType;
    private String ballpointSize;

    public Pen(){
        super.setTTSP("Pen");
    }
    public Pen(String name, double price, String brand, String color, String material, String inkType, String ballpointSize){
        super(name, price);
        super.setTTSP("Pen");
        this.brand = brand;
        this.color = color;
        this.material = material;
        this.inkType = inkType;
        this.ballpointSize = ballpointSize;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getInkType() {
        return inkType;
    }

    public void setInkType(String inkType) {
        this.inkType = inkType;
    }

    public String getBallpointSize() {
        return ballpointSize;
    }

    public void setBallpointSize(String ballpointSize) {
        this.ballpointSize = ballpointSize;
    }

    public void displayAsTable(){
        char c = (char)166;
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, " ".repeat(30), c, " ".repeat(8), c, " ".repeat(15), c, "- Màu sắc: " + color, c);
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, super.getName(), c, super.getPrice(), c, brand, c, "- Chất liệu: " + material, c);
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, " ".repeat(30), c, " ".repeat(8), c, " ".repeat(15), c, "- Loại mực: " + inkType, c);
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, " ".repeat(30), c, " ".repeat(8), c, " ".repeat(15), c, "- Độ mịn: " + ballpointSize, c);
        System.out.printf("+%s-%s-%s-%s+\n", "-".repeat(30), "-".repeat(8), "-".repeat(15), "-".repeat(40));
    }

    public void displayAsList(){
        System.out.println("Tên sản phẩm: " + super.getName());
        System.out.println("Giá bán: " + super.getPrice());
        System.out.println("Thương hiệu: " + brand);
        System.out.println("Màu sắc: " + color);
        System.out.println("Chất liệu: " + material);
        System.out.println("Loại mực: " + inkType);
        System.out.println("Độ mịn: " + ballpointSize);
        System.out.println("------");
    }

    public void update(){

    }

    public void getDetails(){
        Scanner sc = new Scanner(System.in);
        String s;
        double d;
        int n;
        System.out.print("Tên sản phẩm: "); s = sc.nextLine(); super.setName(s);
        System.out.print("Giá bán: "); d = sc.nextDouble(); super.setPrice(d);
        sc.nextLine();
        System.out.print("Thương hiệu: "); s = sc.nextLine(); setBrand(s);
        System.out.print("Màu sắc: "); s = sc.nextLine(); setColor(s);
        System.out.print("Chất liệu: "); s = sc.nextLine(); setMaterial(s);
        System.out.print("Loại mực: "); s = sc.nextLine(); setInkType(s);
        System.out.print("Độ mịn: "); s = sc.nextLine(); setBallpointSize(s);

    }
}
