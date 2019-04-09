# 工程说明
本工程名称EEP，本工程为基于eep 3.0项目开发的样板工程

# 工程结构
```
├── eep-start
├── ...
├── pom.xml
└── README.md
```

# 工程结构说明
- `eep-start`

    工程为项目的启动入口，其中包含项目的启动入口、开发模式设置、系统参数配置、test目录等

    注意：测试用例必须全部放置于此工程中test下

- `...`

    业务模块。


# API测试接口
打开浏览器，访问`http://localhost:8000/swagger-ui.html`

# 数据库访问
打开浏览器，访问`http://localhost:8000/h2-console`
```
Driver Class:org.h2.Driver
JDBC URL:jdbc:h2:mem:testdb
User Name:sa
Password:
```


# Framework-ddd开发手册
[Framework-ddd开发手册](http://192.168.138.171:8002/ieep/guide-of-develop/blob/master/Framework-ddd%E6%89%8B%E5%86%8C.md "Framework-ddd开发手册")


# 打包命令
```
mvn clean package -Dmaven.test.skip=true -Pdev

```

# 版本说明
对标frameowork-ddd-3.0