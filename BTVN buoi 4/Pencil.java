import java.util.Scanner;

public class Pencil extends Product{
    private String brand;
    private String color;
    private String material;
    private String hardness;

    public Pencil(){
        super.setTTSP("Pencil");
    }
    public Pencil(String name, double price, String brand, String color, String material, String hardness){
        super(name, price);
        super.setTTSP("Pencil");
        this.brand = brand;
        this.color = color;
        this.material = material;
        this.hardness = hardness;
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

    public String getHardness() {
        return hardness;
    }

    public void setHardness(String hardness) {
        this.hardness = hardness;
    }

    public void displayAsTable(){
        char c = (char)166;
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, " ".repeat(30), c, " ".repeat(8), c, " ".repeat(15), c, "- Màu: " + color, c);
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, super.getName(), c, super.getPrice(), c, brand, c, "- Chất liệu: " + material, c);
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, " ".repeat(30), c, " ".repeat(8), c, " ".repeat(15), c, "- Độ cứng: " + hardness, c);
        System.out.printf("+%s-%s-%s-%s+\n", "-".repeat(30), "-".repeat(8), "-".repeat(15), "-".repeat(40));
    }

    public void displayAsList(){
        System.out.println("Tên sản phẩm: " + super.getName());
        System.out.println("Giá bán: " + super.getPrice());
        System.out.println("Thương hiệu: " + brand);
        System.out.println("Màu sắc: " + color);
        System.out.println("Chất liệu gỗ: " + material);
        System.out.println("Độ cứng: " + hardness);
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
        System.out.print("Chất liệu gỗ: "); s = sc.nextLine(); setMaterial(s);
        System.out.print("Độ cứng: "); s = sc.nextLine(); setHardness(s);
    }
}
