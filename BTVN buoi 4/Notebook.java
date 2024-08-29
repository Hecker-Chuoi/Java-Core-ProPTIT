import java.util.Scanner;
public class Notebook extends Product{
    private String brand;
    private int pages;
    private String type;
    private String coverPageColor;
    private String paperMaterial;
    private String paperSize;

    public Notebook(){
        super.setTTSP("Notebook");
    }
    public Notebook(String name, double price, String brand, int pages, String type, String coverPageColor, String paperMaterial, String paperSize){
        super(name, price);
        super.setTTSP("Notebook");
        this.brand = brand;
        this.pages = pages;
        this.type = type;
        this.coverPageColor = coverPageColor;
        this.paperMaterial = paperMaterial;
        this.paperSize = paperSize;
    }

    public static String toString(int pages){
        String s = "";
        while(pages > 0){
            s = (pages % 10) + s;
            pages /= 10;
        }
        return s;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCoverPageColor() {
        return coverPageColor;
    }

    public void setCoverPageColor(String coverPageColor) {
        this.coverPageColor = coverPageColor;
    }

    public String getPaperMaterial() {
        return paperMaterial;
    }

    public void setPaperMaterial(String paperMaterial) {
        this.paperMaterial = paperMaterial;
    }

    public String getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(String paperSize) {
        this.paperSize = paperSize;
    }

    public void displayAsTable(){
        char c = (char)166;
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, " ".repeat(30), c, " ".repeat(8), c, " ".repeat(15), c, "- Số trang: " + toString(pages), c);
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, " ".repeat(30), c, " ".repeat(8), c, " ".repeat(15), c, "- Loại vở: " + type, c);
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, super.getName(), c, super.getPrice(), c, brand, c, "- Màu bìa: " + coverPageColor, c);
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, " ".repeat(30), c, " ".repeat(8), c, " ".repeat(15), c, "- Chất liệu giấy: " + paperMaterial, c);
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, " ".repeat(30), c, " ".repeat(8), c, " ".repeat(15), c, "- Kích thước: " + paperSize, c);
        System.out.printf("+%s-%s-%s-%s+\n", "-".repeat(30), "-".repeat(8), "-".repeat(15), "-".repeat(40));
    }

    public void displayAsList(){
        System.out.println("Tên sản phẩm: " + super.getName());
        System.out.println("Giá bán: " + super.getPrice());
        System.out.println("Thương hiệu: " + brand);
        System.out.println("Số trang: " + pages);
        System.out.println("Loại vở: " + type);
        System.out.println("Màu bìa: " + coverPageColor);
        System.out.println("Chất liệu giấy: " + paperMaterial);
        System.out.println("Kích thước: " + paperSize);
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
        System.out.print("Số trang: "); n = sc.nextInt(); setPages(n);
        sc.nextLine();
        System.out.print("Loại vở: "); s = sc.nextLine(); setType(s);
        System.out.print("Màu bìa: "); s = sc.nextLine(); setCoverPageColor(s);
        System.out.print("Chất liệu giấy: "); s = sc.nextLine(); setPaperMaterial(s);
        System.out.print("Kích thước: "); s = sc.nextLine(); setPaperSize(s);
    }
}
