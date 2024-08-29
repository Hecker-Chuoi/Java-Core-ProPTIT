import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        ArrayList<Product> list = new ArrayList<>();
        sign_in enter = new sign_in();
        while(true){
            enter.check(list);
        }
    }
}