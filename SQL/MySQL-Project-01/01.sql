# 创建数据库
create database if not exists db01;
create database if not exists db02;

# 切换数据库
use db01;

# 所有数据库
show databases;

# 正在使用的数据库
select database();

# 删除库
drop database if exists db02;



-- ------------------DDL 表操作 ------------

-- 创建表
create table user
(
    #字段名 字段类型 [约束] [comment 注释]
    id       int primary key auto_increment comment ' ID 唯一标识', -- 主键约束 自增
    username varchar(50) not null unique comment '用户名',          -- 非空 唯一
    name     varchar(10) not null comment '姓名',                   -- 非空
    age      int comment '年龄',
    gender   char(1) default '男' comment '性别'                    -- 默认值
) comment '用户信息表';

# 案例: 设计员工表
create table emp
(
    id          int primary key auto_increment comment 'id',
    username    varchar(20)      not null unique comment '用户名',
    password    varchar(32) default '123456' comment '密码',
    name        varchar(10)      not null comment '姓名',
    gender      tinyint unsigned not null comment '性别 1:男, 2:女',
    phone       char(11)         not null unique comment '手机号',
    job         tinyint unsigned comment '职位, 1 班主任; 2 讲师; 3主管; 4 校验主管; 5 咨询师',
    salary      int unsigned comment '薪资',
    entry_data  date comment '入职日期',
    avatar      varchar(500) comment '头像url',
    create_time datetime comment '创建时间',
    update_time datetime comment '修改时间'
) comment '员工表';

# 查看表结构
desc emp;

# 查询建表语句
show create table emp;

# 添加字段
alter table emp
    add qq varchar(13) comment 'QQ号码';

# 修改字段类型
alter table emp
    modify qq varchar(15) comment ' QQ号码';

# 修改字段名
alter table emp
    change qq qq_num varchar(15) comment ' QQ号码';

# 删除字段
alter table emp
    drop column qq_num;

# 修改表名
alter table emp rename to employee;

# 删除表
drop table if exists db01.user;


-- --------------DML 数据操作语句----------------
# 插入数据 insert
# 插入部分字段的值
insert into employee(username, password, name, gender, phone)
values ('liyinghe', '1234444', '李银河', 1, '15000000000');

# 插入所有字段的值
# 方式一: 罗列所有字段
insert into employee(id, username, password, name, gender, phone, job, salary, entry_data, avatar, create_time,
                     update_time)
values (null, 'linchong', '1231223', '龄虫', 2, '123123123', 1, 5000, '2020-05-06', '1.jpg', now(), now());


# 方式二: 直接插入数据
insert into employee
values (null, 'linchong2', '1231223', '龄虫', 2, '123123123', 1, 5000, '2020-05-06', '1.jpg', now(), now());


# 批量插入数据 数据之间都好分割
insert into employee(username, password, name, gender, phone)
values ('liyinghe2', '1234444', '李银河2', 1, '15000000001'),
       ('liyinghe3', '1234444', '李银河2', 1, '15000000002');

# 更新数据
update employee set  username = 'lisi', name = '里斯' where id = 8;

# 删除行数据
delete from employee;

