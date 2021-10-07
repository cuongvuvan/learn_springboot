
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