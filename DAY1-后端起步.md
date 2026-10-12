# Day 1 · 后端起步 —— 完成记录

> 日期：2026-10-12（深夜）
> 状态：**已完成** ✅ —— 「浏览器 → Spring Boot → JSON」这条链路是通的

---

## 今天拿到了什么

请求 `http://localhost:8080/api/hello`，返回：

```json
{"app":"expense","code":200,"message":"后端跑起来了，权哥！"}
```

- HTTP 状态码：**200**
- Content-Type：**application/json**

---

## 项目位置

| 项 | 路径 |
|---|---|
| 项目根 | `A:\PERson\work-study\java\expense` |
| 启动类 | `src/main/java/com/yan/expense/ExpenseApplication.java` |
| 第一个接口 | `src/main/java/com/yan/expense/controller/HelloController.java` |
| 配置文件 | `src/main/resources/application.properties` |

---

## 技术栈实况（已和本机环境对齐）

| 组件 | 实际落地 | 说明 |
|---|---|---|
| Spring Boot | **3.5.16** | 官方初始化器现在最低只给 4.0.8，3.5.x 已下架 → 手动把 pom 改回基线 |
| JDK | **17**（Temurin 17.0.18.8） | 本机已装，`settings.xml` 里配的也是 jdk-17 profile；Boot 3.5 官方支持 17 |
| Maven | 项目自带 **`mvnw`**（3.10.0） | 不用单独装 Maven；下载源已改阿里云 |
| 本地仓库 | `D:\Tools\maven-repository` | 你原来配好的，避免撑爆 C 盘 |
| 首次构建耗时 | **1 分 09 秒** | 走阿里云镜像 |

---

## 怎么自己跑一遍

```powershell
cd A:\PERson\work-study\java\expense
.\mvnw.cmd -DskipTests package
java -jar target\expense-0.0.1-SNAPSHOT.jar --server.port=8080
```

然后浏览器打开 <http://localhost:8080/api/hello>

> 在 IDEA 里跑的话，直接运行 `ExpenseApplication` 即可（`application.properties` 里已经写了 `server.port=8080`）。

---

## ⚠️ 今天踩到的一个隐蔽坑（已解决）

启动时先报了：

```
Web server failed to start. Port 15444 was already in use.
```

**根因**：WorkBuddy 会给它派生的 shell 注入环境变量 `SERVER__PORT=15444`，
Spring Boot 的「宽松绑定」把这个名字当成了 `server.port`，
于是应用去抢 15444 端口 —— 而 15444 正是 WorkBuddy 自己占着的。

**解法**：命令行参数优先级最高，启动时加 `--server.port=8080` 就能压过环境变量。

**顺带记住这条优先级**（以后排查配置问题会反复用到）：

```
命令行参数  >  Java 系统属性  >  操作系统环境变量  >  application.properties
```

---

## 今天这一课，你应该能回答

1. `@RestController` 和 `@Controller` 差在哪？
2. 类上的 `@RequestMapping("/api")` 和方法上的 `@GetMapping("/hello")` 是怎么拼成 `/api/hello` 的？
3. 为什么返回一个 `Map` 会自动变成 JSON？（提示：`HttpMessageConverter`）

---

## 下一步（Day 2）

- [ ] 装 MySQL 8.0，建 `money` 库 + `expense` 表
- [ ] SQL 速通：`INSERT` / `SELECT` / `UPDATE` / `DELETE`
- [ ] 接 MyBatis-Plus：实体类 + `Mapper extends BaseMapper<T>`
- [ ] 5 个 CRUD 接口

---

## Git

- 仓库已初始化（分支 `main`）
- 首次提交：`bd5e7cf` —— `chore: baseline - Spring Boot 3.5.16 + JDK17, first endpoint /api/hello`
- 尚未推送到 GitHub（凭据管理器 GCM 已就绪，push 时会弹浏览器登录）
