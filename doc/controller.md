# Controller

Trong Spring Boot, có hai dạng Controller, tương ứng hai annotation trên:

- **@Controller**: có thể trả về View qua một String hoặc JSON data trong response body (nếu được chỉ định). Thích hợp
  cho các controller có routing, chuyển trang các kiểu.
- **@RestController**: chỉ có thể trả về data trong response body. Thích hợp cho các controller để cung cấp API.
  <br/> Hoặc có thể hiểu `@RestController = @Controller + @ResponseBody`.
  <br /><br />

Cách Controller hoạt động

- Client -> HTTP Request -> DispatcherServlet (Front Controller) -> Handler Mapping -> Controller -> Model & View
- Model & View -> DispatcherServlet -> HTTP Response -> Client

=> Khi client gửi một request tới server Spring Boot, thì nó sẽ đi qua Front controller. Đây là controller có sẵn, nó có
tác dụng sau:

- Phân giải request, tìm coi request gọi tới method nào của controller nào để gọi đúng tới đó
- Các data của request sẽ được parse ra và mapping tương ứng vào các tham số controller method (có @RequestParam,
  @PathVariable, @Header,... tương ứng).
- Đặc biệt, Spring MVC có thể parse được các data phức tạp như enum, List hay object. Ví dụ enum trong request là dạng
  string, vẫn sẽ được parse đúng thành enum.
- Nếu data không thể parse được, front controller sẽ trả về bad request (hoặc có cơ chế khác để chúng ta ghi đè lại việc
  này).
- Với chiều ngược lại cũng tương tự như vậy. Dữ liệu trả về từ controller sẽ được build thành response và trả cho
  client.

=> Custom HttpStatus cho method ResponseBody: ResponseEntity.status(HttpStatus.OK).body("Hello 2: " + name);
<br/>

Tham khảo:

- https://www.baeldung.com/spring-controller-vs-restcontroller