### Buoi 1

- Tạo database bằng docker

```
jdbc:mysql://localhost:3306/db_spring_security?allowPublicKeyRetrieval=true&useSSL=false

- docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -e MYSQL_DATABASE=db_spring_security -d -p 3306:3306 -v mysql-data:/var/lib/mysql mysql

```

- Define file application.yml: port, url datasource, username, password, jpa config
- Tạo entity User, Role
- Mapping entity class + table
- Cấu hình Spring Security
- Viết 2 API sign-up, login trong AuthController

### Buoi 2

- Tạo UserRepository
- Tạo UserService + Impl
- Tạo DTO Request AuthRequest, SignUpRequest
- Implement API /sign-up, /login -> trả về thông tin user đăng nhập
- Cấu hình filterChain, tạo CustomUserDetailsServiceImpl, AuthenticationManager, Provider

### Buoi 3

- Viết class JwtTokenUtils -> validate token, generate token,...
- Implement API /login return JWT
- Phân quyền trên URL
- Phân quyền trên method