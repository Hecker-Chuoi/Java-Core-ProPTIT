# Các nguyên tắc, mô hình thiết kế ứng dụng

## I. SOLID là gì?
![alt text](image-5.png)  
SOLID là viết tắt của 5 chữ cái đầu trong 5 nguyên tắc thiết kế hướng đối tượng. SOLID hướng đến việc viết code một cách dễ đọc, dễ hiểu, dễ maintain.

5 nguyên tắc bao gồm:
+ `S`ingle responsibility principle (**SRP**)
+ `O`open/Closed principle (**OCP**)
+ `L`iskov substitution principle (**LSP**)
+ `I`nterface segreration principle (**ISP**)
+ `D`ependency inversion principle (**DIP**)

### 1, Single responsibility principle
![alt text](image.png)

Nguyên lý đầu tiên ứng với chữ `S` trong SOLID.  
Nội dung:  
>Mỗi class chỉ nên làm một nhiệm vụ duy nhất.

Một class có quá nhiều chức năng sẽ trở nên cồng kềnh và trở nên khó đọc, khó maintain. Mà đối với ngành IT việc requirement thay đổi, cần thêm sửa chức năng là rất bình thường, nên việc code trong sáng, dễ đọc dễ hiểu là rất cần thiết.

**Ví dụ**  
Hình dung rằng nhân viên của một công ty phần mềm cần phải làm 1 trong 3 việc sau đây: lập trình phần mềm (developer), kiểm tra phần mềm (tester), bán phần mềm (salesman). Mỗi nhân viên sẽ có một chức vụ và dựa vào chức vụ sẽ làm công việc tương ứng. Khi đó bạn có nên thiết kế lớp “Employee” với thuộc tính “position” và 3 phương thức developSoftware(), testSoftware() và saleSoftware() không?

```java
class Employee{
    string position;

    void developSoftware(){};
    void testSoftWare(){};
    void saleSoftWare(){};
}
```

Câu trả lời là không, nếu sau này ta cần phát triển thêm những chức vụ mới, thì ta lại phải sửa lớp nhân viên và thêm phương thức mới. Khi đó một đối tượng được tạo ra sẽ dư thừa nhiều phương thức, developer thì không cần phương thức của tester và saleman.

Thay vào đó, ta có thể xây dựng 1 class Employee với phương thức work(). Sau đó tạo ra 3 class `developer`, `tester` và `saleman` kế thừa lớp `Employee` và ghi đè phương thức `work()`.

### 2, Open/Closed principle
![alt text](image-1.png)

Nguyên lý thứ 2 ứng với chữ `O` trong SOLID.  
Nội dung:  
>Không được sửa đổi một class có sẵn, nhưng có thể mở rộng bằng kế thừa.

<!--Thêm ví dụ-->

### 3, Liskov substitution principle
![alt text](image-2.png)  

Nguyên tắc thứ 3 ứng với chữ `L` trong SOLID.
Nội dung:  
>Bất cứ instance nào của class cha cũng có thể được thay thế bởi instance của class con của nó mà không làm thay đổi tính đúng đắn của chương trình.

### 4, Interface segregation principle
![alt text](image-3.png)

Nguyên tắc thứ 4 ứng với chữ `I` trong SOLID.
Nội dung:  
>Thay vì dùng 1 interface lớn, ta nên tách thành nhiều interface nhỏ, với nhiều mục đích cụ thể.  
Client không nên phụ thuộc vào interface mà nó không sử dụng.

### 5, Dependency inversion principle

Nguyên tắc thứ 5 ứng với chữ `D` trong SOLID.  
Nội dung:  
>1. Các module cấp cao không nên phụ thuộc vào các module cấp thấp, cả hai nên phụ thuộc vào Abstraction  
2. Interface (abstraction) không nên phụ thuộc vào chi tiết, mà ngược lại (Các class giao tiếp với nhau thông qua interface (abstraction), không phải thông qua implementation).

**Tại sao cần áp dụng nguyên tắc SOLID trong thiết kế code**  
+ `Rõ ràng, dễ hiểu`
  Giúp code dễ hiểu, tường minh để có thể làm việc nhóm tốt hơn.
+ `Dễ thay đổi`
  Giúp tạo ra các module, class rõ ràng, mạch lạc, mang tính độc lập cao. Khi cần thay đổi, mở rộng thì không tốn quá nhiều công sức.
+ `Tái sử dụng`
  Giúp code trở nên mạch lạc, dễ hiểu, dễ sử dụng.

## II. Kiss, DRY, YAGNI
### 1, DRY - Don't repeat yourself
DRY là tính chất đề cập đến việc viết code gọn gàng, đảm bảo một đoạn code với logic tương tự không bị lặp lại.  
Cách để làm một đoạn code có nhiều chức năng cần sử dụng nhiều lần trở nên DRY là tạo một `function` riêng cho mỗi chức năng riêng biệt. Khi đó ta chỉ cần gọi đến `function` thay vì lặp lại đoạn code dài dòng.

<!--Thêm ví dụ-->

### 2, KISS - Keep it simple stupid
Tính chất KISS hướng tới việc viết code tường minh, dễ hiểu.  
Để đạt được tính chất KISS, lập trình viên chỉ cần viết code ngắn gọn, tường minh, mỗi phương thức chỉ dùng để giải quyết một nhiệm vụ và không nên dài hơn 50 dòng.

<!--Thêm ví dụ-->

### 3, YAGNI - You aren't gonna need it
YAGNI - không thêm những gì không cần thiết. Hay nói cách khác, YAGNI yêu cầu lập trình viên chỉ thêm những tính năng thực sự cần thiết cho chương trình.  

<!--Thêm ví dụ-->

### 4, Một số tính chất khác
+ **`TDD`: Test driven development**
  TDD đề cập đến một lối lập trình an toàn và đảm bảo. Mỗi chức năng được đóng gói trong 1 hàm và được kiểm tra cho đến khi đạt yêu cầu.  
  Thực hành tính chất này giúp hạn chế lỗi và dễ kiểm soát chương trình hơn.
+ **`BDUF`: Big design up front**
  BDUF nhắc nhở lập trình viên rằng không cần dành quá nhiều thời gian để tạo ra một mô hình ứng dụng hoàn hảo ngay từ đầu. Thay vào đó hãy KISS và cải tiến chương trình theo thời gian.  
  Việc quá tập trung vào thiết kế những function không cần thiết cũng có thể vi phạm vào YAGNI.
+ **`SOC`: Seperation of concerns**
  SOC đề cập đến việc viết phương thức hoặc hàm, rằng mỗi phương thức, mỗi hàm thay vì bị nhồi nhét mọi thứ thì chỉ nên thực hiện 1 chức năng riêng biệt.

## III. Mô hình MVC
![alt text](image-4.png)  

### 1, MVC là gì?
Mô hình Model-View-Controller (MVC) là một mẫu kiến ​​trúc phân tách một ứng dụng thành ba thành phần logic chính Model, View và Controller.

Mỗi thành phần kiến ​​trúc được xây dựng để xử lý khía cạnh phát triển cụ thể của một ứng dụng. MVC tách lớp logic nghiệp vụ và lớp hiển thị ra riêng biệt. Ngày nay, kiến ​​trúc MVC đã trở nên phổ biến để thiết kế các ứng dụng web cũng như ứng dụng di động.

### 2, Kiến trúc MVC
MVC gồm 3 cấu trúc quan trọng bao gồm:
+ `Model`: Bao gồm dữ liệu và các logic tương ứng
+ `View`: Cấu trúc có nhiệm vụ trình bày dữ liệu và xử lý tương tác cho người dùng
+ `Controller`: Liên kết Model và View

#### a, View
View là một phần của ứng dụng đại diện cho việc trình bày dữ liệu.

View được tạo bởi các dữ liệu mà chúng ta lấy từ dữ liệu trong model. Một view yêu cầu model cung cấp đầy đủ dữ liệu để nó hiển thị đầu ra cho người dùng.

View chính là nới chứa những giao diện như một nút bấm, khung nhập, menu, hình ảnh… nó đảm nhiệm nhiệm vụ hiển thị dữ liệu và giúp người dùng tương tác với hệ thống.

#### b, Controller
Controller là một phần của ứng dụng xử lý tương tác của người dùng. Bộ điều khiển diễn giải đầu vào chuột và bàn phím từ người dùng, thông báo cho model và view để thay đổi khi thích hợp.

Controller là nới tiếp nhận những yêu cầu xử lý được gửi từ người dùng, nó sẽ gồm những class/ function xử lý nhiều nghiệp vụ logic giúp lấy đúng dữ liệu thông tin cần thiết nhờ các nghiệp vụ lớp Model cung cấp và hiển thị dữ liệu đó ra cho người dùng nhờ lớp View.

Controller gửi các lệnh đến model để làm thay đổi trạng thái của nó (Ví dụ: ta thêm mới 1 user hoặc cập nhật tên 1 user). Controller cũng gửi các lệnh đến view liên quan của nó để thay đổi cách hiển thị của view (Ví dụ: xem thông tin 1 user).

#### c, Model
Thành phần model lưu trữ dữ liệu và logic liên quan của nó. Bao gồm các class function xử lý các tác vụ như truy vấn, thêm, sửa hoặc xóa dữ liệu. Ví dụ, một đối tượng Controller sẽ lấy thông tin khách hàng từ cơ sở dữ liệu. Nó thao tác dữ liệu và gửi trở lại cơ sở dữ liệu hoặc sử dụng nó để hiển thị dữ liệu.

### 3, Tương tác giữa các thành phần trong MVC
+ Controller tương tác với qua lại với View.
+ Controller tương tác qua lại với Model.
+ Model và View không có sự tương tác với nhau trực tiếp mà nó tương tác với nhau thông qua Controller.

### 4, Ưu điểm của MVC
+ Bảo trì code dễ dàng, dễ dàng mở rộng và phát triển.
+ Hỗ trợ dễ dàng hơn cho khách hàng mới.
+ Việc phát triển các thành phần khác nhau có thể được thực hiện song song.
+ Nó giúp bạn tránh sự phức tạp bằng cách chia ứng dụng thành ba đơn vị Model, View và Controller.
+ Cung cấp hỗ trợ tốt nhất cho phát triển theo hướng thử nghiệm.
+ Nó hoạt động tốt cho các ứng dụng Web được hỗ trợ bởi các nhóm lớn các nhà thiết kế và phát triển web.
+ Cung cấp khả năng phân tách rõ ràng các mối quan tâm.
+ Thân thiện với Công cụ Tìm kiếm (SEO).
+ Tất cả các đối tượng được phân loại và đối tượng độc lập với nhau để bạn có thể kiểm tra chúng một cách riêng biệt.

### 5, Nhược điểm của MVC
+ Khó đọc, thay đổi, kiểm tra và sử dụng lại mô hình này.
+ Không có hỗ trợ xác thực chính thức.
+ Tăng độ phức tạp và tính kém hiệu quả của dữ liệu.
+ Khó khăn khi sử dụng MVC với giao diện người dùng hiện đại.
+ Cần có nhiều người lập trình để tiến hành lập trình song song.
+ Cần có kiến ​​thức về nhiều công nghệ.
+ Bảo trì nhiều code trong Controller.
