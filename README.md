
# 缓存服务器 (Cache Server)

这是一个基于Spring WebFlux实现的响应式缓存服务器，提供简单的键值对存储功能。

## 功能特点

- 基于响应式编程模型
- 提供基本的缓存操作接口
- RESTful API设计
- 非阻塞式操作

## API接口

### 获取缓存值
- `src/main/java/com/huangjie/core/Cache.java`：缓存接口，定义了缓存的基本操作。
- `src/main/java/com/huangjie/core/InMemoryCache.java`：基于内存的缓存实现，实现了`Cache`接口。
- `src/main/java/com/huangjie/controller/CacheController.java`：缓存控制器，提供了RESTful API接口。
- `src/main/java/com/huangjie/Application.java`：Spring Boot应用程序入口。

## 接口说明

### 1. 获取缓存值
- **接口**: `GET /get/{key}`
- **参数**: 
  - `key`: 缓存键（路径参数）
- **返回**: `Mono<String>` - 对应键的缓存值
- **示例**:
  ```bash
  curl http://localhost:8080/get/myKey
  ```

### 2. 设置缓存
- **接口**: `POST /put/{key}`
- **参数**: 
  - `key`: 缓存键（路径参数）
  - `value`: 缓存值（请求体）
- **返回**: `Mono<Void>`
- **示例**:
  ```bash
  curl -X POST http://localhost:8080/put/myKey \
       -H "Content-Type: text/plain" \
       -d "myValue"
  ```

### 3. 删除缓存
- **接口**: `DELETE /delete/{key}`
- **参数**: 
  - `key`: 缓存键（路径参数）
- **返回**: `Mono<Void>`
- **示例**:
  ```bash
  curl -X DELETE http://localhost:8080/delete/myKey
  ```

## 技术栈

- Java
- Spring Boot
- Spring WebFlux
- Project Reactor

## 快速开始

1. **克隆项目**
   ```bash
   git clone https://github.com/your-repo/cache-server.git
   cd cache-server
   ```
2. **构建项目**
   ```bash
   ./gradlew bootRun
   ```
3. **运行服务器**
   ```bash
   java -jar target/cache-server-1.0.0.jar
   ```

## 开发环境要求

- JDK 21+
- Gradle 8.0+
- Spring Boot 3.x

## 配置说明

服务器默认运行在8080端口。如需修改，请在`application.yml`中配置：

## 待办事项

- [ ] 支持分布式缓存
- [ ] 一致性哈希配置与数据路由
- [ ] 节点间数据复制与可用性
- [ ] 服务注册与发现
- [ ] 配置热更新
- [ ] 负载均衡与请求路由
- [ ] 节点管理与扩缩容
- [ ] 监控与告警
- [ ] 日志与审计追踪


