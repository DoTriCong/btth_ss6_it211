# BÁO CÁO SAU BUỔI THỰC HÀNH

**Môn học:** Java Web Service  
**Tên buổi thực hành:** Mini-project – CourseCatalog RESTful API   
**Họ và tên sinh viên:** Đỗ Trí Công  
**Mã sinh viên:** PTIT-HN-103  
**Lớp:** HN-KS24-CNTT2  
**Nhóm:** 1


# I. NỘI DUNG ĐÃ THỰC HÀNH

## 1. Trình bày các giải pháp

Trong buổi thực hành, em đã xây dựng hệ thống RESTful API quản lý khóa học (CourseCatalog) sử dụng:

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- MySQL
- REST API
- Upload file ảnh

Hệ thống cho phép:

- Quản lý danh sách khóa học
- Thêm, sửa, xóa khóa học
- Xem chi tiết khóa học
- Upload và xóa ảnh đại diện
- Phân trang và sắp xếp dữ liệu

### Giải pháp tổng thể

Hệ thống được thiết kế theo kiến trúc nhiều tầng:

- Controller: Tiếp nhận request API
- Service: Xử lý logic nghiệp vụ
- Repository: Làm việc với database thông qua JPA
- DTO: Truyền dữ liệu giữa client và server
- Entity: Mapping dữ liệu với MySQL

### Các giải pháp kỹ thuật áp dụng

- Sử dụng Spring Data JPA để thao tác database
- Áp dụng RESTful API theo chuẩn HTTP Method
- Sử dụng ResponseEntity để trả về HTTP Status Code đúng chuẩn
- Dùng MultipartFile để upload file ảnh
- Lưu file ảnh vật lý trong thư mục uploads
- Sử dụng UUID để tránh trùng tên file
- Áp dụng Pagination & Sorting với Pageable
- Sử dụng PATCH để cập nhật dữ liệu một phần
- Áp dụng validation dữ liệu với annotation


## 2. Liệt kê các câu hỏi từ nhóm khác và câu hỏi phản biện

- Vì sao cần dùng DTO thay vì trả trực tiếp Entity?  
  (Để tách biệt dữ liệu database và dữ liệu trả về API.)

- Vì sao upload file cần UUID?  
  (Để tránh trùng tên file khi nhiều người upload.)

- PUT và PATCH khác nhau như thế nào?  
  (PUT cập nhật toàn bộ dữ liệu, PATCH cập nhật một phần.)

- Vì sao cần xóa file vật lý khi DELETE khóa học?  
  (Để tránh file rác tồn tại trên server.)

- Pagination có lợi ích gì?  
  (Giúp tối ưu hiệu năng khi dữ liệu lớn.)


## 3. Thực hành triển khai code

### a. Các nội dung lập trình đã sử dụng

- RESTful API
- Spring Boot 3.x
- Spring Data JPA
- MySQL
- DTO Pattern
- Upload File với MultipartFile
- Pagination & Sorting
- Exception Handling
- ResponseEntity
- Validation

### b. Cấu trúc chương trình gồm

- Entity
    - Course

- DTO
    - CourseRequestDTO
    - CourseResponseDTO

- Repository
    - CourseRepository

- Service
    - CourseService
    - FileStorageService

- Controller
    - CourseController

- Config
    - WebConfig

### c. Các API đã triển khai

- GET danh sách khóa học có phân trang
- GET khóa học theo ID
- POST thêm khóa học mới
- PUT cập nhật toàn bộ khóa học
- PATCH cập nhật từng field
- DELETE khóa học
- UPLOAD ảnh khóa học
- DELETE ảnh khóa học


# II. CÔNG VIỆC CÁC EM ĐÃ LÀM

## 1. Công việc cá nhân

- Phân tích yêu cầu từ SRS
- Thiết kế entity và DTO
- Xây dựng API CRUD
- Kết nối MySQL bằng JPA
- Xử lý upload file ảnh
- Cài đặt phân trang và sắp xếp
- Test API bằng Postman
- Debug lỗi dữ liệu và upload file

## 2. Công việc nhóm

- Thảo luận cấu trúc project
- Kiểm tra API response
- Hỗ trợ sửa lỗi logic
- Kiểm tra upload và delete file
- Góp ý tối ưu code


# III. KẾT QUẢ CÁC EM ĐẠT ĐƯỢC

Sau buổi thực hành, em đã:

1. Hiểu rõ cách xây dựng RESTful API bằng Spring Boot
2. Thành thạo thao tác CRUD với Spring Data JPA
3. Biết cách xử lý upload file trong Java Web Service
4. Áp dụng được Pagination và Sorting
5. Hiểu cách sử dụng DTO và ResponseEntity
6. Hoàn thành đầy đủ các API theo yêu cầu đề bài


# IV. KHÓ KHĂN VÀ VẤN ĐỀ CÁC EM GẶP PHẢI

## 1. Các khó khăn

1. Lỗi upload file không lưu đúng thư mục
2. Lỗi mapping Entity với database
3. Lỗi PATCH cập nhật dữ liệu chưa đúng
4. Lỗi khi xóa file vật lý
5. Lỗi phân trang và sort dữ liệu

## 2. Cách khắc phục

- Kiểm tra lại cấu hình upload trong application.properties
- Sử dụng annotation JPA đúng chuẩn
- Kiểm tra null trước khi PATCH
- Dùng File API để xóa file vật lý
- Debug Pageable và Sort trong controller


# V. KINH NGHIỆM RÚT RA

## 1. Kinh nghiệm từ bài thực hành

- Nên thiết kế DTO ngay từ đầu
- Luôn validate dữ liệu trước khi lưu database
- Kiểm tra file upload cẩn thận
- Tách riêng Service xử lý file
- Test API bằng Postman thường xuyên

## 2. Lưu ý cho các buổi thực hành sau

- Viết exception handler riêng
- Tối ưu cấu trúc thư mục project
- Kiểm tra bảo mật upload file
- Ghi log lỗi đầy đủ
- Backup database trước khi test dữ liệu


# VI. ĐỀ XUẤT / KIẾN NGHỊ

Em đề xuất giảng viên:

- Hướng dẫn thêm về Spring Security và JWT
- Bổ sung bài tập kết hợp frontend React/Angular với REST API
- Giới thiệu thêm về Docker và Deploy API thực tế



# VII. KẾT LUẬN

Qua buổi thực hành mini-project CourseCatalog RESTful API, em đã nắm vững:

- Cách xây dựng REST API bằng Spring Boot
- Kết nối và thao tác dữ liệu với MySQL
- Upload và quản lý file ảnh
- Phân trang, sắp xếp và xử lý dữ liệu

Buổi thực hành giúp em nâng cao kỹ năng phát triển backend Java Web Service, hiểu rõ quy trình xây dựng API thực tế và tạo nền tảng tốt cho các dự án enterprise sau này.