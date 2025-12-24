# UDH - 统一数据处理平台

## 项目简介

UDH (Unified Data Handling) 是一个基于Java开发的分布式数据处理和存储系统，主要用于大数据文件的管理、存储和检索。该项目整合了多种大数据技术栈，提供了完整的文件元数据管理和分布式存储解决方案。

## 核心功能

### 1. 文件元数据管理
- 文件信息存储和更新
- 文件版本控制
- 文件MD5校验
- 批次信息管理

### 2. 分布式存储
- **HDFS**: 使用Hadoop分布式文件系统进行文件存储
- **HBase**: 用于存储结构化的文件元数据
- **ElasticSearch**: 提供高效的文件检索和搜索功能

### 3. 数据库集成
- **MySQL**: 关系型数据库，使用C3P0连接池进行连接管理
- 支持事务处理和数据持久化

## 技术栈

### 核心框架
- **Java**: 主要开发语言
- **Apache Ant**: 项目构建工具

### 大数据组件
- **Hadoop 2.6.0-cdh5.7.0**: 分布式计算框架
  - HDFS: 分布式文件系统
  - MapReduce: 分布式计算
  - YARN: 资源管理
- **HBase 1.2.0-cdh5.7.0**: NoSQL数据库
- **ElasticSearch 5.4.0**: 分布式搜索引擎
- **ZooKeeper**: 分布式协调服务

### 数据库与连接池
- **MySQL**: 关系型数据库
- **C3P0**: 数据库连接池

### 其他依赖
- **Jackson**: JSON处理
- **Log4j**: 日志管理
- **Commons**: Apache通用工具库
- **Netty**: 网络通信框架

## 项目结构

```
JavaAntTest/
├── src/                          # 源代码目录
│   ├── com/bonc/
│   │   ├── main/                # 主程序入口
│   │   │   └── SocketMain.java  # Socket服务端主类
│   │   ├── model/               # 数据模型
│   │   │   ├── FileInfo.java        # 文件信息模型
│   │   │   ├── FileStoreInfo.java   # 文件存储信息
│   │   │   ├── FileInfoUpdate.java  # 文件更新信息
│   │   │   ├── BatchInfo.java       # 批次信息
│   │   │   └── File.java            # 文件模型
│   │   ├── util/                # 工具类
│   │   │   ├── ElasticSearchUtil.java # ES操作工具
│   │   │   ├── ConnDBUtil.java       # 数据库连接工具
│   │   │   ├── JSONUtil.java         # JSON处理工具
│   │   │   ├── MD5Util.java          # MD5加密工具
│   │   │   ├── PropertiesUtil.java   # 配置文件工具
│   │   │   └── ConfigUtil.java       # 配置管理工具
│   │   └── constant/            # 常量定义
│   │       └── Constants.java
│   ├── config.properties        # 系统配置文件
│   ├── jdbc.properties          # 数据库配置文件
│   ├── core-site.xml           # Hadoop核心配置
│   ├── hdfs-site.xml           # HDFS配置
│   └── log4j.properties        # 日志配置
├── lib/                         # 第三方依赖库
├── build.xml                    # Ant构建配置文件
└── README.md                    # 项目说明文档
```

## 配置说明

### 1. 系统配置 (config.properties)
```properties
ipAddress=10.160.15.138      # 服务器IP地址
port=55536                   # 服务端口
UserThreads=256              # 用户线程数
HDFSPath=/hdfsData/          # HDFS存储路径
validTime=60                 # 有效时间（秒）
```

### 2. HBase配置
```properties
zookeepers=10.160.15.136,10.160.15.137,10.160.15.138
clientPort=2181
masterIP=10.160.15.137:60010
```

### 3. ElasticSearch配置
```properties
ESIP=10.160.15.138,10.160.15.139,10.160.15.140
clusterName=elasticsearch
```

### 4. 数据库配置 (jdbc.properties)
```properties
driverName=com.mysql.jdbc.Driver
url=jdbc:mysql://10.160.15.140:3306/yx_database
user=yxpt
drowssap=123456              # 密码（注意：实际使用时应加密存储）
```

## 构建与运行

### 前置要求
- JDK 1.7 或更高版本
- Apache Ant
- Hadoop集群环境
- HBase服务
- ElasticSearch服务
- MySQL数据库

### 构建项目

使用Apache Ant构建项目：

```bash
# 清理编译目录
ant 清空class目录

# 初始化目录结构
ant 初始化

# 编译源代码
ant 编译

# 打包成JAR文件（默认目标）
ant jar
```

执行 `ant jar` 后，将在 `out/` 目录下生成 `UDH.jar` 文件。

### 运行程序

```bash
java -jar out/UDH.jar
```

## 主要模块说明

### 1. SocketMain (主程序)
- 程序入口类
- 初始化ElasticSearch客户端
- 提供Socket服务端功能

### 2. ElasticSearchUtil (检索工具)
- 连接ElasticSearch集群
- 提供文档索引、查询、更新功能
- 支持复杂查询和聚合操作

### 3. ConnDBUtil (数据库工具)
- 使用C3P0连接池管理MySQL连接
- 提供数据库连接获取功能
- 自动连接池管理和优化

### 4. 数据模型
- **FileInfo**: 文件基本信息（名称、类型、大小、MD5、版本号）
- **FileStoreInfo**: 文件存储位置信息
- **FileInfoUpdate**: 文件更新记录
- **BatchInfo**: 批次处理信息

## 开发说明

### 日志配置
项目使用Log4j进行日志管理，配置文件为 `src/log4j.properties`。

### 编码规范
- 源代码使用UTF-8编码
- 遵循Java编码规范
- 类和方法添加适当的注释

## 注意事项

1. **安全性**: 生产环境中应加密存储数据库密码等敏感信息
2. **配置**: 根据实际部署环境修改配置文件中的IP地址和端口
3. **依赖**: 确保所有依赖的服务（Hadoop、HBase、ES、MySQL）正常运行
4. **资源**: 根据实际负载调整线程池和连接池配置

## 版本信息

- **项目版本**: 1.0
- **Hadoop**: 2.6.0-cdh5.7.0
- **HBase**: 1.2.0-cdh5.7.0
- **ElasticSearch**: 5.4.0

## 许可证

本项目为内部项目，版权归属相关组织所有。

## 联系方式

如有问题或建议，请联系项目维护团队。
