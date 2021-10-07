# learn_springboot

## Controller

Trong Spring Boot, có hai dạng Controller, tương ứng hai annotation trên:

- **@Controller**: có thể trả về View qua một String hoặc JSON data trong response body (nếu được chỉ định). Thích hợp
  cho các controller có routing, chuyển trang các kiểu.
- **@RestController**: chỉ có thể trả về data trong response body. Thích hợp cho các controller để cung cấp API. Do đó,
  ta có thể nói @RestController = @Controller + @ResponseBody.
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

## HttpRequest & HttpResponse

### HttpRequest

**Cấu trúc**\
Gồm 3 phần trong 1 request

1. `<method> <request-URL> <http-serverion>` => Request Line
2. `<headers>`
3. `<body>`

#### 1. Request Line

`<method>`

- GET: Data đính kèm vào URL => Read
- POST: Data trong message body của request => Create
- HEAD (tương tự như GET nhưng chỉ gửi về HTTP header.)
- PUT: tải lên một mô tả về URL định trước. => Update
- DELETE: xóa một tài nguyên định trước. => Delete
- OPTIONS: trả về phương thức HTTP mà server hỗ trợ.
- CONNECT: chuyển kết nối của HTTP request thành một kết nối HTTP tunnel.
  <br />

`<request-URL>`\
URL

`<http-serverion>`\
HTTP version là Phiên bản HTTP đang sử dụng.

#### 2. Request header

Cho phép client gửi thêm các thông tin bổ sung về thông điệp HTTP request và về chính client. Một số trường thông dụng
như:

- Accept loại nội dung có thể nhận được từ thông điệp response. Ví dụ: text/plain, text/html…
- Accept-Encoding: các kiểu nén được chấp nhận. Ví dụ: gzip, deflate, xz, exi…
- Connection: tùy chọn điều khiển cho kết nối hiện thời. Ví dụ: keepalive,Upgrade…
- Cookie: thông tin HTTP Cookie từ server
- User-Agent: thông tin về user agent của người dùng

#### 3. Request body

Data request

### HttpResponse

**Cấu trúc**\
Gồm 3 phần trong 1 request

1. `<http-version> <status> <reason-pharse>` => Status Line
2. `<headers>`
3. `<body>`

#### 1. Status Line

`<http-version>` phiên bản HTTP cao nhất mà server hỗ trợ.\
`<status>`\
Mã kết quả trả về. => HTTP Status code, là một số nguyên 3 ký tự. Ký tự đầu tiên của mã hóa trạng thái định nghĩa hạng (
loại) phản hồi và hai ký tự cuối không có bất cứ vai trò phân loại nào. Có 5 giá trị của ký tự đầu tiên:

- 1xx: Thông tin. Mã này nghĩa là yêu cầu đã được nhận và tiến trình đang tiếp tục.
- 2xx: Thành công. Mã này nghĩa là hoạt động đã được nhận, được hiểu, và được chấp nhận một cách thành công.
- 3xx: Sự điều hướng lại. Mã này nghĩa là hoạt động phải được thực hiện để hoàn thành yêu cầu.
- 4xx: Lỗi Client. Mã này nghĩa là yêu cầu chứa cú pháp không chính xác hoặc không được thực hiện.
- 5xx: Lỗi Server. Mã này nghĩa là Server thất bại với việc thực hiện một yêu cầu nhìn như có vẻ khả thi.

`<reason-pharse>` mô tả về Status-Code

## Mapping annotation

- @GetMapping, @DeleteMapping, @PostMapping, @PutMapping, ...
- @RequestMapping(value = "/users", method = RequestMethod.GET)
- @RequestMapping("/users") public class UserController {}

## Nhận request data trong Controller

Gồm các loại:

1. Request param (query string)
2. Path variable
3. Request body
4. Header

### 1. Request param

Sử dụng annotation @RequestParam. Sử dụng để get parameter từ URL Các thuộc tính:

- defaultValue: This is the default value as a fallback mechanism if request is not having the value or it is empty.
- name: Name of the parameter to bind
- required: Whether the parameter is mandatory or not. If it is true, failing to send that parameter will fail.
- value: This is an alias for the name attribute

```
@GetMapping("/users")
public ResponseEntity<?> getAllUsers(
  @RequestParam(value = "age", required = false) Integer age,
  @RequestParam(value = "name", required = false) String name) {
  // biến age có thể không có, nên phải cho nó kiểu Integer có giá trị null để biết được age có được gửi lên hay không
  // ngoài ra có thể gán giá trị default: defaultValue
}
```

Tham khảo: [Spring request param](https://www.baeldung.com/spring-request-param)

### 2. Path variable

Path variable là một phần trong đường dẫn URL, ví dụ GET /users/123/info thì 123 là path variable. Sử dụng @PathVariable
để làm việc này, tương tự như dùng @RequestParam. @PathVariable cũng có các thuộc tính tương tự @RequestParam <br/>
Because @PathVariable is extracting values from the URI path, it’s not encoded. On the other hand, @RequestParam is
encoded.

```
@GetMapping("/users/{id}/info")
public ResponseEntity<?> getUserInfo(
    @PathVariable(value = "id", defaultValue = "0") int userId) {
    // id là tên path variable, tương ứng trên url {id}
}
```

Tham khảo:

- [PathVariable vs RequestParam](https://www.baeldung.com/spring-requestparam-vs-pathvariable)

### 3. Request body

Request method PUT, POST mới có request body, đây là nơi chứa data chính để gửi lên. Thường thì request body sẽ ở dạng
JSON hoặc form-data, khi vào controller sẽ được tự động parse ra thành Object (ví dụ DTO chẳng hạn)
```
@PostMapping("/login")
public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
    // Dữ liệu trong request body có thể là JSON, form-data,...
    // Tuy nhiên khi vào controller sẽ bị parse thành object hết
}

@Getter // => lombok lib
@Setter
public class LoginDto {
    private String username;
    private String password;
}
```

###4. Header
```
@PostMapping("/login")
public ResponseEntity<?> login(@Header("Authorization") String authHeader) {
    // Biến authHeader sẽ có giá trị là giá trị của Authorization header
}
```

[OK](/http_request_response.md)
## ok

- @PathVariable

<br/>
*#end*