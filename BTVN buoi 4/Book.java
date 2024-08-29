import java.util.Scanner;

public class Book extends Product{
    private String author;
    private String theme;
    private String publisher;
    private String publishDate;
    private String language;

    public Book(){
        super.setTTSP("Book");
    }
    public Book(String name, double price, String author, String theme, String publisher, String publishDate, String language){
        super(name, price);
        super.setTTSP("Book");
        this.author = author;
        this.theme = theme;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.language = language;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void displayAsTable(){
        char c = (char)166;
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, " ".repeat(30), c, " ".repeat(8), c, " ".repeat(15), c, "- Thể loại: " + theme, c);
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, " ".repeat(30), c, " ".repeat(8), c, " ".repeat(15), c, "- Tác giả: " + author, c);
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, super.getName(), c, super.getPrice(), c, publisher, c, "- Nhà xuất bản: " + publisher, c);
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, " ".repeat(30), c, " ".repeat(8), c, " ".repeat(15), c, "- Năm xuất bản: " + publishDate, c);
        System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, " ".repeat(30), c, " ".repeat(8), c, " ".repeat(15), c, "- Ngôn ngữ: " + language, c);
        System.out.printf("+%s-%s-%s-%s+\n", "-".repeat(30), "-".repeat(8), "-".repeat(15), "-".repeat(40));
    }

    public void displayAsList(){
        System.out.println("Tên sản phẩm: " + super.getName());
        System.out.println("Giá bán: " + super.getPrice());
        System.out.println("Tác giả: " + author);
        System.out.println("Nhà xuất bản: " + publisher);
        System.out.println("Thể loại: " + theme);
        System.out.println("Năm xuất bản: " + publishDate);
        System.out.println("Ngôn ngữ: " + language);
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
        System.out.print("Tác giả: "); s = sc.nextLine(); setAuthor(s);
        System.out.print("Thể loại: "); s = sc.nextLine(); setTheme(s);
        System.out.print("Nhà xuất bản: "); s = sc.nextLine(); setPublisher(s);
        System.out.print("Năm xuất bản: "); s = sc.nextLine(); setPublishDate(s);
        System.out.print("Ngôn ngữ: "); s = sc.nextLine(); setLanguage(s);
    }
}
