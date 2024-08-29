import java.util.Scanner;
import java.util.ArrayList;
public class Admin {
    private int displayOption = 2;
    Scanner sc = new Scanner(System.in);
    public void showAllFunction() {
        char c = (char) 166;
        System.out.println("-".repeat(52));
        System.out.printf("%c%-50s%c\n", c, "Các chức năng: ", c);
        System.out.printf("%c%-50s%c\n", c, "0. Hiển thị menu", c);
        System.out.printf("%c%-50s%c\n", c, "1. Thêm sản phẩm", c);
        System.out.printf("%c%-50s%c\n", c, "2. Xóa sản phẩm", c);
        System.out.printf("%c%-50s%c\n", c, "3. Cập nhật sản phẩm", c);
        System.out.printf("%c%-50s%c\n", c, "4. Hiển thị danh sách sản phẩm", c);
        System.out.printf("%c%-50s%c\n", c, "5. Tìm kiếm sản phẩm", c);
        System.out.printf("%c%-50s%c\n", c, "6. Thay đổi chế độ hiển thị", c);
        System.out.printf("%c%-50s%c\n", c, "7. Thoát", c);
        System.out.println("-".repeat(52));
    }

    public void addProduct(ArrayList list){
        System.out.println("1. Sách");
        System.out.println("2. Vở");
        System.out.println("3. Bút");
        System.out.println("4. Bút chì");
        System.out.print("Chọn loại sản phẩm muốn thêm: ");
        int type = sc.nextInt();
        System.out.print("Nhập số lượng: ");
        int number = sc.nextInt();
        for(int i = 0; i < number; ++i) {
            switch(type){
                case 1:
                    Book book = new Book(); book.getDetails();
                    list.add(book);
                    break;
                case 2:
                    Notebook notebook = new Notebook(); notebook.getDetails();
                    list.add(notebook);
                    break;
                case 3:
                    Pen pen = new Pen(); pen.getDetails();
                    list.add(pen);
                    break;
                case 4:
                    Pencil pencil = new Pencil(); pencil.getDetails();
                    break;
            }
        }
    }
    public void removeProduct(ArrayList list){
        System.out.print("Nhập vị trí cần xóa: ");
        int index = sc.nextInt();
        if(index < 0 || index >= list.size()){
            System.out.println("Vị trí không hợp lệ!");
            return;
        }
        list.remove(index);
    }
    public void updateProduct(ArrayList list){
        System.out.print("Nhập vị trí cần cập nhật: ");
        int i = sc.nextInt() - 1;
        if(i < 0 || i >= list.size()){
            System.out.println("Vị trí không hợp lệ!");
            return;
        }
        System.out.println();
        System.out.println("1. Sách");
        System.out.println("2. Vở");
        System.out.println("3. Bút");
        System.out.println("4. Bút chì");
        System.out.print("Chọn loại sản phẩm muốn thêm: ");
        int type = sc.nextInt();
        System.out.println();
        Product p = (Product) list.get(i);
        switch(type){
            case 1:
                p = new Book(); p.getDetails();
                break;
            case 2:
                p = new Notebook(); p.getDetails();
                break;
            case 3:
                p = new Pen(); p.getDetails();
                break;
            case 4:
                p = new Pencil(); p.getDetails();
                break;
        }
    }
    public void displayAllProducts(ArrayList list){
        if(displayOption == 1){
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
        else if(displayOption == 2){
            // display as list
            System.out.println("__________");
            for(int i = 0; i < list.size(); i++){
                Product p = (Product) list.get(i);
                p.displayAsList();
            }
        }
    }
    public void lookForProduct(ArrayList list){
        System.out.print("Chọn loại sản phẩm: ");
        System.out.print("1. Sách\n");
        System.out.print("2. Vở\n");
        System.out.print("3. Bút\n");
        System.out.print("4. Bút chì\n");
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
        if(displayOption == 1){
            // display as table
            char c = (char) 166;
            System.out.printf("+%s+%s+%s+%s+\n", "-".repeat(30), "-".repeat(8), "-".repeat(15), "-".repeat(40));
            System.out.printf("%c%-30s%c%-8s%c%-15s%c%-40s%c\n", c, "Tên sản phẩm", c, "Giá bán", c, "Thương hiệu", c, "Thông tin thêm", c);
            System.out.printf("+%s+%s+%s+%s+\n", "-".repeat(30), "-".repeat(8), "-".repeat(15), "-".repeat(40));
        }
        else if(displayOption == 2){
            // display as list
            System.out.println("Danh sách sản phẩm tìm kiếm được:");
            System.out.println("__________");
        }
        for(int i = 0; i < list.size(); ++i){
            Product p = (Product) list.get(i);
            if(p.getTTSP().equals(s)){
                if(displayOption == 1){
                    p.displayAsTable();
                }
                else if(displayOption == 2){
                    p.displayAsList();
                }
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
    public void adminFunction(ArrayList list){
        showAllFunction();
        System.out.print("Chọn một chức năng: ");
        int n = sc.nextInt(); // user's choice
        while(true) {
            switch(n){
                case 0:
                    showAllFunction();
                    break;
                case 1:
                    addProduct(list);
                    System.out.println("Thêm sản phẩm thành công!");
                    break;
                case 2:
                    removeProduct(list);
                    break;
                case 3:
                    updateProduct(list);
                    break;
                case 4:
                    displayAllProducts(list);
                    break;
                case 5:
                    lookForProduct(list);
                    break;
                case 6:
                    changeDisplayOption();
                    break;
                case 7:
                    return;
            }
            System.out.print("Chọn một chức năng: ");
            n = sc.nextInt();
        }
    }
}
