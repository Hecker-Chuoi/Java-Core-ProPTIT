import java.util.Scanner;
import java.util.ArrayList;
public class Guest {
    private int displayOption = 2;
    Scanner sc = new Scanner(System.in);
    public void showAllFunction(){
        char c = (char)166;
        System.out.println("-".repeat(52));
        System.out.printf("%c%-50s%c\n", c, "Các chức năng: ", c);
        System.out.printf("%c%-50s%c\n", c, "0. Hiển thị menu", c);
        System.out.printf("%c%-50s%c\n", c, "1. Hiển thị danh sách sản phẩm", c);
        System.out.printf("%c%-50s%c\n", c, "2. Tìm kiếm sản phẩm", c);
        System.out.printf("%c%-50s%c\n", c, "3. Thay đổi chế độ hiển thị", c);
        System.out.printf("%c%-50s%c\n", c, "4. Thoát", c);
        System.out.println("-".repeat(52));
    }
    public void displayAllProducts(ArrayList list){
        System.out.println("Hiển thị dưới dạng: ");
        System.out.println("1. Bảng");
        System.out.println("2. Danh sách");
        int n = sc.nextInt();
        if(n == 1){
            // display as table
            char c = (char) 166;
            System.out.printf("+%s+%s+%s+%s+\n", "-".repeat(30), "-".repeat(8), "-".repeat(15), "-".repeat(40));
            System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, "Tên sản phẩm", c, "Giá bán", c, "Thương hiệu", c, "Thông tin thêm", c);
            System.out.printf("+%s+%s+%s+%s+\n", "-".repeat(30), "-".repeat(8), "-".repeat(15), "-".repeat(40));
            for(int i = 0; i < list.size(); i++){
                Product p = (Product) list.get(i);
                p.displayAsTable();
            }
        }
        else if(n == 2){
            // display as list
            System.out.println("__________");
            for(int i = 0; i < list.size(); i++){
                Product p = (Product) list.get(i);
                p.displayAsList();
            }
        }
    }
    public void changeDisplayOption(){
        System.out.println("Chọn chế độ hiển thị: ");
        System.out.println("1. Bảng");
        System.out.println("2. Danh sách");
        int n = sc.nextInt();
        if(n == 1){
            displayOption = 1;
        }
        else if(n == 2){
            displayOption = 2;
        }
    }
    public void lookForProduct(ArrayList list){
        System.out.print("Chọn loại sản phẩm: ");
        System.out.println("1. Sách");
        System.out.println("2. Vở");
        System.out.println("3. Bút");
        System.out.println("4. Bút chì");
        int type = sc.nextInt();
        String s = "";
        switch(type){
            case 1:
                s = "Book"; break;
            case 2:
                s = "Notebook"; break;
            case 3:
                s = "Pen"; break;
            case 4:
                s = "Pencil"; break;
        }
        System.out.println();
        int i;
        for(i = 0; i < list.size(); ++i){
           Product p = (Product) list.get(i);
           if(p.getTTSP().equals(s)){
               p.displayAsList();
           }
        }
    }
    public void guestFunction(ArrayList list){
        showAllFunction();
        System.out.print("Chọn một chức năng: ");
        int n = sc.nextInt(); // user's choice
        System.out.println();
        while(true) {
            switch(n){
                case 0:
                    showAllFunction();
                    break;
                case 1:
                    displayAllProducts(list);
                    break;
                case 2:
                    lookForProduct(list);
                    break;
                case 3:
                    changeDisplayOption();
                    break;
                case 4:
                    return;
            }
            System.out.print("Chọn một chức năng: ");
            n = sc.nextInt();
            System.out.println();
        }
    }
}
