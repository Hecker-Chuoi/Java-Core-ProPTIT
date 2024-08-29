# Xử lý ngoại lệ trong Java

## I. Exceptions, Errors trong Java
### 1, Exceptions là gì?
Exceptions hay ngoại lệ là những sự kiện hoặc trường hợp không mong muốn xảy ra trong quá trình thực thi chương trình, làm gián đoạn luồng hoạt động của chương trình.

Exceptions có thể được nhận ra và xử lý, trong quá trình chạy một phương thức gặp phải Exceptions, JVM (Java Virtual Machine) sẽ tạo ra một Object thuộc một class tương ứng của lỗi đó; Object này chứa các thông tin như: tên Exception, nguyên nhân gây ra lỗi / thông báo và vị trí tại nơi xảy ra lỗi.

**Một số nguyên nhân chính sinh ra Exception:** 
+ Mất kết nối mạng
+ Dữ liệu nhập vào sai (sai kiểu dữ liệu, kích thước quá lớn,...)
+ Dữ liệu nhập vào không đúng yêu cầu (do LTV cài đặt)
+ Truy cập vào file không có quyền đọc/ ghi hoặc không tồn tại
+ Một số giới hạn phần cứng (Dung lượng ổ cứng trống)
+ Một số lỗi trong code mà compiler không phát hiện

***Tại sao cần có Exceptions***
+ Exceptions giúp lập trình viên nhận biết nhưng lỗi xảy ra trong chương trình và có giải pháp để khắc phục kịp thời
+ Exceptions giúp người dùng biết được đã gặp phải lỗi gì để tránh và có cách sử dụng hợp lý hơn
+ Exceptions giúp bảo vệ dữ liệu, luồng hoạt động hiện tại của chương trình, việc xử lý (handle) Exception giúp cho chương trình không bị sập bất thường khi gặp những sự cố không mong muốn
  
***Cách hiển thị thông tin Exceptions***
1. **printStackTrace()**
<Tên Exception>: <mô tả lỗi>
<Hiển thị StackTrace (vị trí chương trình bị lỗi)>

**Ví dụ**
```java
import java.io.*; 
  
class GFG { 
    public static void main (String[] args) { 
      int a=5; 
      int b=0; 
        try{ 
          System.out.println(a/b); 
        } 
        catch(ArithmeticException e){ 
            e.printStackTrace(); 
        } 
    } 
} 
```

**Output**
>java.lang.ArithmeticException: / by zero  
at GFG.main(File.java:10)

2. **toString()**
<Tên Exception>: <mô tả lỗi>

**Ví dụ**
```java
import java.io.*; 
  
class GFG { 
    public static void main (String[] args) { 
      int a=5; 
      int b=0; 
        try{ 
          System.out.println(a/b); 
        } 
      catch(ArithmeticException e){ 
        System.out.println(e.toString()); 
      } 
    } 
} 
```

**Output**
>java.lang.ArithmeticException: / by zero

3. **getMassage()**
Chỉ trả về mô tả lỗi

**Ví dụ**
```java
import java.io.*; 
  
class GFG { 
    public static void main (String[] args) { 
      int a=5; 
      int b=0; 
        try{ 
          System.out.println(a/b); 
        } 
      catch(ArithmeticException e){ 
        System.out.println(e.getMessage()); 
      } 
    } 
} 
```

**Output**
>/ by zero

### 2, Error là gì?
Tương tự Exceptions, Errors cũng là những sự kiện không mong muốn trong quá trình thực thi chương trình. Chúng khác nhau ở chỗ, chỉ có Exceptions có thể handle được còn Errors thì không. Điều đó có nghĩa là khi gặp phải Errors, việc thực thi chương trình sẽ bị hủy bất thường.

Các lỗi có thể dẫn đến Errors như:  
+ Java virtual machine (JVM) running out of memory
+ Stack overflow: tràn bộ nhớ stack
+ Thư viện không tương thích
+ Lặp vô hạn
+ ...

<figure>
    <img style="width: 800px" src="image.png">
    <figcaption style="font-size: 60%; text-align: center; font-style: Italic;">Java Exception Hierachy</figcaption>
</figure>

### 3, Khác nhau giữa Exceptions và Errors
Khác nhau giữa Error (lỗi) và Exception (ngoại lệ):  
+ `Error`: chỉ những lỗi nghiêm trọng, liên quan đến giới hạn phần cứng, lỗi phần cứng, tràn bộ nhớ, không thể nhận biết và xử lý
+ `Exception`: chỉ một số trường hợp không mong muốn có thể xảy ra trong quá trình thực thi (những lỗi này không làm ngắt việc thực thi của chương trình) và có thể xử lý được

### 4, Phân loại các Exceptions
Trong Java có nhiều loại Exceptions, tất cả các Exceptions này đều là một class được kế thừa từ một Base Class chung là `Exception`. Những Exceptions được tạo sẵn này được gọi là `Built-in Exception`.  
Ngoài ra, Java cũng cho phép Lập trình viên tự tạo Exception riêng gọi là `User-defined Exception`.  

<figure>
    <img style="width: 800px" src="image-1.png">
    <figcaption style="font-size: 60%; text-align: center; font-style: Italic;">Types of Exceptions</figcaption>
</figure>

Trong các Exceptions có sẵn (Built-in Exception) cũng được chia thành 2 loại:  
+ CheckedException
+ UncheckedException

##### a, CheckedException
* Là những Exception được compiler phát hiện ra trong khi biên dịch (compile time), có thể được chỉ định bởi các phương thức qua từ khóa `throws`.
* Trong một method, các CheckedException cần được chỉ định qua lệnh `throws`.
* Có thể không throws exception nếu các Exception đã được handle bên trong method.

Trong Checked Exception cũng bao gồm 2 loại:
* `Fully checked Exception`: là Checked Exception và tất cả các class con của nó cũng đều là Checked Exception.
VD: IOException, InterruptedException,...
* `Partially check Exception`: là Checked Exception mà có ít nhất một class con là Unchecked Exception

##### b, UncheckedException
Là những Exception xảy ra trong quá trình thực thi chương trình, tất cả các Exception là con của class `RuntimeException` đều thuộc dạng UncheckException.

Unchecked Exception không cần phải được chỉ định bằng lệnh `throws`, nó xuất hiện trong thời gian thực thi (Runtime).

Một số loại Unchecked Exception thường gặp:
1. ArrayIndexOutOfBoundException
2. NullPointerException
3. StringIndexOutOfBoundException
4. ArithmeticException

<!--Thêm ví dụ-->

## II. Handle Exceptions với khối try-catch
### 1, try block
Khối try (try block) chứa khối lệnh có thể xảy ra ngoại lệ (Exceptions). 

**Cú pháp**
```java
try
{
    // statement(s) that might cause exception
}
```

### 2, catch block
Khối catch (catch block) chứa handler tương ứng với Exceptions gặp phải trong khối try, đối số của khối catch là Object của Exception tương ứng.

**Cú pháp**
```java
catch
{
   // statement(s) that handle an exception
   // examples, closing a connection, closing
   // file, exiting the process after writing
   // details to a log file.
}
```

**Lưu ý:**
+ Khối catch được khai báo ngay sau khối try và chỉ được gọi đến khi khối try gặp phải Exception
+ Một khối try có thể có nhiều khối catch để handle nhiều loại Exception
+ Khối try cũng có thể không có khối catch nào
+ Khi khối try không có khối catch hoặc không có khối catch xử lý Exception tương ứng thì chương trình vẫn sẽ bị sập

### 3, throw và throws
##### a, throw
Từ khóa `throw` dùng để ném Exception một cách chủ động từ khối try, từ một method hoặc từ một khối lệnh bất kỳ. Có thể dùng cho cả checked và unchecked Exception nhưng chủ yếu dùng cho user-define Exceptions.

**Cú pháp**
>throw Object;

Trong đó Object phải là instance của class `Throwable` hoặc subclass của nó. 

**Ví dụ**
```java
throw new ArithmeticException("/ by zero");
```

Khi gặp throw thì luồng chạy hiện tại của khối lệnh hoặc method sẽ dừng lại ngay, các câu lệnh phía sau sẽ không được gọi đến.
**Ví dụ**
```java
class ThrowExcep {
    static void fun(int a)
    {
        try {
            if(a == 1)
                throw new NullPointerException("demo");
            System.out.println("abc");
        }
        catch (NullPointerException e) {
            System.out.println("Caught inside fun().");
            throw e; // rethrowing the exception
        }
    }
 
    public static void main(String args[])
    {
        try {
            fun(1);
            System.out.println("def");
        }
        catch (NullPointerException e) {
            System.out.println("Caught in main.");
        }
    }
}
```
-> **Output**
>Caught inside fun().
>Caught in main.

##### b, throws
Được khai báo đằng sau tên của mỗi method để chỉ ra những Exceptions có thể gặp phải trong method đó, các Exceptions này cần phải được handle bởi caller (vị trí gọi đến hàm đó).

**Cú pháp**
```java
type method_name(parameters) throws exception_list
```
Nếu exception_list có chứa nhiều hơn 1 Exception thì các Exceptions được cách nhau bởi dấu phẩy. 

Nếu một method có thể gặp phải một Exception nào đó thì compiler sẽ bắt LTV phải handle tất cả Exceptions đó, có 2 cách:
1. Sử dụng try-catch bên trong method
2. Sử dụng throws

**Ví dụ 1**
```java
class tst {
    public static void main(String[] args)
    {
        Thread.sleep(10000);
        System.out.println("Hello Geeks");
    }
}
```
**Output**
>error: unreported exception InterruptedException; must be caught or declared to be thrown

**Ví dụ 2**
```java
class tst {
    public static void main(String[] args)
        throws InterruptedException
    {
        Thread.sleep(10000);
        System.out.println("Hello World!");
    }
}
```
**Output**
>Hello World!

**Ví dụ 3**
```java
class tst {
    public static void main(String[] args)
    {
        try{
            Thread.sleep(10000);
        }
        catch(InterruptedException e){
            System.out.println("Error");
        }
        System.out.println("Hello World!");
    }
}
```
**Output**
>Hello World!

## III. Finally block
<figure>
    <img style="width: 800px" src="image-2.png">
    <figcaption style="font-size: 60%; text-align: center; font-style: Italic;">Flowchart of finally block</figcaption>
</figure>

Khối finally trong cấu trúc try-catch-finally hoặc try-finally sẽ chạy trong cả 2 trường hợp khi có gặp phải Exceptions hoặc không, thường được dùng để thực hiện một số thao tác như: đóng file, ngắt kết nối, reset cài đặt,... hoặc hiển thị thông báo đến người dùng.

Những trường hợp sau đây có thể xảy ra khi dùng khối finally:
**Case 1: Không gặp Exceptions**
```java
class TestFinallyBlock {    
    public static void main(String args[]){    
    try{
        int data=25/5;    
        System.out.println(data);    
    }
    catch(NullPointerException e){  
    System.out.println(e);  
    }    
    finally {  
        System.out.println("finally block is always executed");  
    }    

    System.out.println("rest of phe code...");    
    }    
}   
```

**Case 2: Gặp Exceptions nhưng không được handle bởi khối catch**
```java
public class TestFinallyBlock1{    
    public static void main(String args[]){   
    try {    
        System.out.println("Inside the try block");  
        int data=25/0;    
        System.out.println(data);    
    }    
    catch(NullPointerException e){  
        System.out.println(e);  
    }   
    finally {  
        System.out.println("finally block is always executed");  
    }    
  
    System.out.println("rest of the code...");    
    }    
}    
```

**Case 3: Gặp Exception và được handle bởi khối catch**
```java
public class TestFinallyBlock1{    
    public static void main(String args[]){   
    try {    
        System.out.println("Inside the try block");  
        int data=25/0;    
        System.out.println(data);    
    }    
    catch(Arithmetic e){  
        System.out.println(e);  
    }   
    finally {  
        System.out.println("finally block is always executed");  
    }    
  
    System.out.println("rest of the code...");    
    }    
}  
```

## III. Built-in Exception
Built-in Exceptions là các class Exceptions có sẵn được Java cung cấp (tất cả các class này đều là con cháu của Throwable).  
Có nhiều loại Built-in Exceptions bao gồm hầu hết các Exceptions có thể xảy ra:

1. `ArithmeticException`: It is thrown when an exceptional condition has occurred in an arithmetic operation.
```java
class ArithmeticException_Demo 
{ 
    public static void main(String args[]) 
    { 
        try { 
            int a = 30, b = 0; 
            int c = a/b;  // cannot divide by zero 
            System.out.println ("Result = " + c); 
        } 
        catch(ArithmeticException e) { 
            System.out.println ("Can't divide a number by 0"); 
        } 
    } 
} 
```
**Output**
>Can't divide a number by 0
   
2. `ArrayIndexOutOfBoundsException`: It is thrown to indicate that an array has been accessed with an illegal index. The index is either negative or greater than or equal to the size of the array.
```java
class ArrayIndexOutOfBound_Demo 
{ 
	public static void main(String args[]) 
	{ 
		try{ 
			int a[] = new int[5]; 
			a[6] = 9; // accessing 7th element in an array of 
					// size 5 
		} 
		catch(ArrayIndexOutOfBoundsException e){ 
			System.out.println ("Array Index is Out Of Bounds"); 
		} 
	} 
} 

```
**Output**
>Array Index is Out Of Bounds
   
3. `ClassNotFoundException`: This Exception is raised when we try to access a class whose definition is not found
   
4. `FileNotFoundException`: This Exception is raised when a file is not accessible or does not open.
```java
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.FileReader; 

class File_notFound_Demo { 
	public static void main(String args[]) { 
		try { 
			// Following file does not exist 
			File file = new File("E://file.txt"); 

			FileReader fr = new FileReader(file); 
		} catch (FileNotFoundException e) { 
		System.out.println("File does not exist"); 
		} 
	} 
} 
```
**Output**
>File does not exist
   
5. `IOException`: It is thrown when an input-output operation failed or interrupted
   
6. `InterruptedException`: It is thrown when a thread is waiting, sleeping, or doing some processing, and it is interrupted.
   
7. `NoSuchFieldException`: It is thrown when a class does not contain the field (or variable) specified
   
8. `NoSuchMethodException`: It is thrown when accessing a method that is not found.
   
9.  `NullPointerException`: This exception is raised when referring to the members of a null object. Null represents nothing
```java
class NullPointer_Demo 
{ 
	public static void main(String args[]) 
	{ 
		try { 
			String a = null; //null value 
			System.out.println(a.charAt(0)); 
		} catch(NullPointerException e) { 
			System.out.println("NullPointerException.."); 
		} 
	} 
} 
```
**Output**
>NullPointerException..
    
10.  `NumberFormatException`: This exception is raised when a method could not convert a string into a numeric format.
```java
class NumberFormat_Demo 
{ 
	public static void main(String args[]) 
	{ 
		try { 
			// "akki" is not a number 
			int num = Integer.parseInt ("akki") ; 

			System.out.println(num); 
		} catch(NumberFormatException e) { 
			System.out.println("Number format exception"); 
		} 
	} 
} 

```
**Output**
>Number format exception
    
11.  `RuntimeException`: This represents an exception that occurs during runtime.
    
12.  `StringIndexOutOfBoundsException`: It is thrown by String class methods to indicate that an index is either negative or greater than the size of the string
```java
class StringIndexOutOfBound_Demo 
{ 
    public static void main(String args[]) 
    { 
        try { 
            String a = "This is like chipping "; // length is 22 
            char c = a.charAt(24); // accessing 25th element 
            System.out.println(c); 
        } 
        catch(StringIndexOutOfBoundsException e) { 
            System.out.println("StringIndexOutOfBoundsException"); 
        } 
    } 
} 
```
**Output**
>StringIndexOutOfBoundsException
    
13.   `IllegalArgumentException`: This exception will throw the error or error statement when the method receives an argument which is not accurately fit to the given relation or condition. It comes under the unchecked exception. 
```java
class ArithmeticException_Demo 
{ 
    public static void main(String args[]) 
    { 
        try { 
            int a = 30, b = 0; 
            int c = a/b;  // cannot divide by zero 
            System.out.println ("Result = " + c); 
        } 
        catch(ArithmeticException e) { 
            System.out.println ("Can't divide a number by 0"); 
        } 
    } 
} 
```
**Output**
>Can't divide a number by 0
    
14.   `IllegalStateException`: This exception will throw an error or error message when the method is not accessed for the particular operation in the application. It comes under the unchecked exception.

## IV. User-Defined Exception
Bên cạnh các Built-in Exception, Java cũng cho phép lập trình viên tạo ra Exceptions riêng. Điều này cho phép các LTV tùy biến luồng chương trình linh hoạt hơn.

Để tạo User-Defined Exception, ta phải import class Exception (`import java.lang.Exception;`) và kế thừa nó.

Để tạo một Exception có thể thay đổi message, ta sử dụng lời gọi `super(string s)` để gọi đến constructor của lớp cha để thay đổi trường `message`.

**Ví dụ**

```java
import java.lang.Exception;

class MyException extends Exception {
	public MyException(String s)
	{
		super(s);
	}
}

public class Main {
	public static void main(String args[])
	{
		try {
			throw new MyException("abc");
		}
		catch (MyException ex) {
			System.out.println("Caught");
			System.out.println(ex.getMessage());
		}
	}
}
```
**Output**
>Caught
abc
