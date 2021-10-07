## Trả về response trong Controller

### 1. @ResponseBody & @ResponseStatus

- Thông thường @Controller sẽ dùng để điều hướng nên data trả về sẽ là String - tên file html
- Trường hợp muốn trả về data thì sử dụng @RestController hoặc nếu sử dụng @Controller thì phải đánh dấu @ResponseBody
- Có thể custome Http response code bằng cách sử dụng annotation `@ResponseStatus(HttpStatus.BAD_REQUEST)` hoặc
  `ResponseEntity.status(HttpStatus.OK).body(objUser)`

Method handel request trong controller có thể trả về luôn object mà KHÔNG cần convert => JSON, spring boot sẽ làm điều
đó

```
@GetMapping("/info")
@ResponseBody
public UserInfo getUserInfo() {
    // get userInfo
    return userInfo;
}
```

### 2. Sử dụng HttpServletResponse

Chỉ nên dùng trong các project Servlet

### 3. Sử dụng ResponseEntity\<T>

Ưu điểm:

- Sử dụng builder pattern nên quá trình code rất tiện
- Nếu sử dụng @ResponseStatus thì chỉ fix status code, trường hợp muốn trả về status code khác tùy vào các điều kiện thì
  có thể sử dụng ResponseEntity.
- Có thể trả về data trong body, tùy chỉnh header.

```
@GetMapping("/info")
public ResponseEntity<User> getUserInfo(@RequestParam("username") String username) {
    // Tìm User trong database bằng username
    User user = userRepository.findByUsername(username);
    
    // Nếu không tìm thấy, trả về message lỗi 404 Not found
    if (user == null)
        return ResponseEntity.notFound();  // Tạm thời là vậy, thực tế người ta dùng AOP để bắt exception
        
    // Nếu tìm thấy return 200 OK
    return ResponseEntity.ok(user);
}
```

ResponseEntity<T> có thể dùng 3 cách:

- Tạo mới object dạng new ResponseEntity<>(user, HttpStatus.OK)
- Dùng dạng static method ResponseEntity.ok(user)
- Dùng dạng builder ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found").build()