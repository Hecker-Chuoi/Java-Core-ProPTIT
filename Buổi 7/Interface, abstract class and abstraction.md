# Interface, abstract class và tính trừu tượng trong Java

## 1. Interface là gì
Interface trong Java là bản vẽ của lớp, được thiết kế để đạt được sự trừu tượng hoàn toàn. Interface chỉ chứa các phương thức trừu tượng và các trường hằng. Khi nhìn vào phần khai báo của một Interface, ta có thể nhìn thấy một cấu trúc tổng quan các phương thức của các class triển khai interface đó.

Các phương thức trừu tượng chỉ có phần khai báo (chứa tên và các tham số) và không có phần thân. Các phương thức trong interface có access modifier dưới dạng public và abstract, tương tự các trường của interface được khai báo dưới dạng hằng với public, static và final. Một class triển khai interface cần phải định nghĩa lại tất cả các phương thức chứa trong đó.

### Syntax khai báo Interface

```java
interface <name>{
    // declare constant fields, implicity public, static and final.
    // declare methods, implicity public and abstract
}
```

***Ví dụ***
```java
interface Vehicle{
    final int abc = 10;
    final String s = "abc";

    void run();
    void stop();
    void turnLeft();
    void turnRight();
}
```

### Mối quan hệ giữa class và interface
![Alt text](image.png)

Một class muốn triển khai interface cần khai báo kèm từ khóa `implements`. Ngoài ra ở trong java, interface hỗ trợ đa kế thừa, một class có thể implement nhiều interface.

```java
import java.io.*;

interface In1 {

    final int a = 10;

    void display();
}

class TestClass implements In1 {
   
    public void display(){ 
      System.out.println("ABC"); 
    }

    public static void main(String[] args)
    {
        TestClass t = new TestClass();
        t.display();
        System.out.println(a);
    }
}
```

**Output**
>ABC
>10

### Một số tính năng mới cho interface kể từ JDK 8
1. Default method
Default method là một phương thức không cần phải ghi đè và có thể sử dụng trong các đối tượng thuộc class con. Việc này có ý nghĩa khi ta muốn cập nhật thêm 1 function nào đó, sử dụng default function thì ta không cần phải viết lại hay chỉnh sửa nhiều.

```java
interface In1
{
    final int a = 10;
    default void display()
    {
        System.out.println("New function");
    }
}

class TestClass implements In1
{
    // Driver Code
    public static void main (String[] args)
    {
        TestClass t = new TestClass();
        t.display();
    }
}
```
**Output**
>New function

2. Cho phép khai báo static method
Static method là phương thức có thể gọi và sử dụng một cách độc lập mà không cần phải thông qua đối tượng của lớp đó.

```java
interface In1
{
    final int a = 10;
    static void display()
    {
        System.out.println("Static method");
    }
}

class TestClass implements In1
{
    public static void main (String[] args)
    {
        In1.display();
    }
}
```
**Output**
>Static method

### Kế thừa interface
Một interface có thể kế thừa một interface khác sử dụng từ khóa `extends`. Khi một class triển khai interface con thì nó phải định nghĩa các phương thức thuộc cả interface cha con.

```java
interface A {
    void method1();
    void method2();
}

interface B extends A {
    void method3();
}

class abc implements B {
    public void method1()
    {
        System.out.println("Method 1");
    }
    public void method2()
    {
        System.out.println("Method 2");
    }
    public void method3()
    {
        System.out.println("Method 3");
    }
}
```

## 2. Abstract class
Abstract class trong Java được khai báo với từ khóa `abstract`, có thể chứa cả `abstract methods` và `non-abstract methods`.

Ta không thể tạo 1 đối tượng thuộc lớp abstract, ta cần phải kế thừa lớp này và tạo đối tượng thuộc lớp con thì mới có thể sử dụng các thuộc tính và phương thức của nó.

***Dưới đây là một số đặc điểm quan trọng của abstract-class***
1. Không thể tạo đối tượng thuộc abstract class
2. Có thể có constructor
3. Có thể khai báo `final method` bên trong abstract class nhưng một abstract class không thể để ở dạng final, bởi vì các abstract method cần phải được ghi đè ở class con, việc khai báo method là `final` sẽ ngăn điều này gây ra xung đột:
> Illegal combination of modifiers: abstract and final
4. Một abstract class có thể không chứa 1 abstract method nào
5. Có thể khai báo `static methods` bên trong abstract class
6. Nếu 1 class chứa ít nhất 1 abstract method thì phải để class ấy cũng là abstract

***Ví dụ***
```java
import java.io.*;

abstract class Subject {
	Subject() { 
	System.out.println("Learning Subject"); 
	}

	abstract void syllabus();

	void Learn(){
		System.out.println("Preparing Right Now!");
	}
}

class IT extends Subject {
void syllabus(){
	System.out.println("C , Java , C++");
}
}

class GFG {
	public static void main(String[] args) {
		Subject x=new IT();
	
		x.syllabus();
		x.Learn();
	}
}
```

**Output**
>Learning Subject
>C, Java, C++
>Preparing Right Now!

## 3. So sánh Interface và Abstract class

|*Interface*|*Abstract class*   |
|:---:|:---:|
|Chỉ có thể chứa abstract method|Có thể chứa cả abstract method và non-abstract method |
|Hỗ trợ đa kế thừa, kế thừa hỗn hợp, một class có thể kế thừa nhiều interface|Không hỗ trợ đa kế thừa, mỗi class chỉ có thể kế thừa 1 abstract class|
|Các thuộc tính mặc định ở dạng public static final, còn các method mặc định ở dạng public abstract|Access modifiers không bị ràng buộc, một abstract class có thể không chứa abstract method nào|
|Sử dụng từ khóa `implements`|Sử dụng từ khóa `extends`|

## 4. Tính trừu tượng trong OOP

### Khái niệm
Tính trừu tượng (Abstraction) là một trong bốn tính chất cơ bản của Lập trình hướng đối tượng (Object-oriented programming – viết tắt là OOP). Các tính chất còn lại bao gồm: Tính đóng gói (Encapsulation), Tính kế thừa (Inheritance) và Tính đa hình (Polymorphism).

Hiểu đơn giản, Tính trừu tượng dùng để chỉ quá trình ẩn việc triển khai thực tế của một ứng dụng khỏi người dùng. Thay vào đó, lập trình viên chỉ nhấn mạnh vào cách sử dụng ứng dụng.

### Mục đích
Thông qua Tính trừu tượng, lập trình viên có thể ẩn tất cả dữ liệu hoặc quy trình không liên quan của ứng dụng. Đối với người dùng, đó chỉ là những chi tiết không cần thiết. Từ đó, ta có thể để giảm độ phức tạp và tăng hiệu quả sử dụng của phần mềm.

Có thể xem Tính trừu tượng là một phần mở rộng của Tính đóng gói. Bạn có thể tìm hiểu thêm về Tính đóng gói để hiểu rõ hơn về hai thuộc tính này.

### Ý nghĩa

* Một số lợi ích của Tính trừu tượng có thể kể đến là:
* Giao diện người dùng đơn giản, cấp cao.
* Các đoạn mã phức tạp bị ẩn đi.
* Nâng cao vấn đề bảo mật, bảo vệ dự liệu không bị lộ.
* Việc bảo trì phần mềm dễ dàng hơn.
* Việc cập nhật hay thay đổi mã sẽ rất ít khi ảnh hưởng đến Tính trừu tượng.

### Ví dụ về tính trừu tượng

Tính trừu tượng là một khái niệm khá phổ biến trong thực tế. Ví dụ như một chiếc xe hoạt động chứa rất nhiều chi tiết và cách vận hành rất phức tạp, nhưng những thông tin đó không quan trọng với người lái. Người lái chỉ cần sử dụng những công cụ như: bàn đạp ga, phanh, vô lăng, đèn nháy. Các kỹ thuật phức tạp đều được ẩn khỏi trình điều khiển. Nghĩa là ta chỉ cần biết cách lái xe, chứ không cần quan tâm những chi tiết về cách thức động cơ hoạt động.

### Các loại hình trừu tượng

1. Trừu tượng hóa dữ liệu
   Khi dữ liệu của đối tượng không hiển thị ra bên ngoài, thì đó gọi là Trừu tượng hóa dữ liệu. Nếu cần, lập trình viên có thể cấp quyền truy cập vào dữ liệu của đối tượng bằng nhiều cách. Thông thường họ sử dụng một số phương thức, chẳng hạn như get, set.
2. Trừu tượng hóa quy trình
   Lập trình viên không cần phải cung cấp chi tiết về tất cả các chức năng khác nhau của một đối tượng. Khi họ ẩn việc triển khai nội bộ của các chức năng liên quan đến hoạt động của người dùng, đó gọi là Trừu tượng hóa quy trình.
