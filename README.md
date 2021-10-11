# learn_springboot

## 1. Mô hình

Flow request/response trong spring MVC
![N|Spring flow](https://images.viblo.asia/full/68d13e98-8714-4dd9-ae27-641ee729ab20.png)

Các layer và data access level trong framework
![N|](https://images.viblo.asia/full/0b2971bd-7098-4652-a677-c61aea36e032.png)

## 2. Controller

Trong mô hình MVC, controller là nơi nhận request từ người dùng, xử lý request, xây dựng dữ liệu cho view (model) và
chọn view để trả lại kết quả của cho người dùng.
<br/>
Chi tiết: [Controller Document](/doc/controller.md)

## 3. HttpRequest & HttpResponse

Chi tiết: [Document](/doc/http_request_response.md)

## 4. Mapping annotation

- @GetMapping, @DeleteMapping, @PostMapping, @PutMapping, ...
- @RequestMapping(value = "/users", method = RequestMethod.GET)
- @RequestMapping("/users") public class UserController {}

## 5. Nhận request data trong Controller

Chi tiết: [Document](/doc/handle_request.md)

## 6. Trả về response từ controller

Chi tiết: [Document](/doc/handle_response.md)

## Tham khảo

- https://viblo.asia/p/hoc-spring-boot-bat-dau-tu-dau-6J3ZgN7WKmB
- https://loda.me/spring-boot-0-series-lam-chu-spring-boot-zero-to-hero-loda1558963914472/
- https://www.baeldung.com/learn-spring-course
- https://shareeverythings.com/lap-trinh/java/lap-trinh-spring-boot-crud-don-gian/
- https://shareeverythings.com/lap-trinh/tim-hieu-spring-mvc-va-spring-boot-trong-java-web/
- https://www.baeldung.com/spring-boot
- https://www.tutorialspoint.com/spring_boot/index.htm
- https://spring.io/guides
- https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/
- https://www.javatpoint.com/spring-boot-tutorial
- https://viblo.asia/p/su-dung-modelmapper-trong-spring-boot-63vKj1Vd52R
- https://loda.me/spring-boot-0-series-lam-chu-spring-boot-zero-to-hero-loda1558963914472/
- https://techglimpse.com/dst-root-ca-x3-expired-certificate-error/

## Demo
- https://www.djamware.com/post/5b2f000880aca77b083240b2/spring-boot-security-and-data-mongodb-authentication-example
<br/>
*#end*