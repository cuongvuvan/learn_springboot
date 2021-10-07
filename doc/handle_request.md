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

### 4. Header

Hay được dùng để verify HttpBasicAuthen

```
@PostMapping("/login")
public ResponseEntity<?> login(@Header("Authorization") String authHeader) {
    // Biến authHeader sẽ có giá trị là giá trị của Authorization header
}
```

