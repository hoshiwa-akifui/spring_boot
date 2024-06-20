drop table if exists teacher;
drop table if exists student;
drop table if exists school;

create table teacher
(
    id       int primary key auto_increment,
    avatar   blob,
    username varchar(255),
    password varchar(255),
    name     varchar(255),
    phone    varchar(255)
);
insert into teacher
values (null, null, 'akifui123', '123456', 'akifui', '15527651578');

create table student
(
    id        int primary key auto_increment,
    name      varchar(255),
    sex       char(4),
    school    varchar(255),
    school_id int,
    status    int comment '1表示正常使用，0表示禁用'
);
insert into student
values (null, '星野', '女', '阿拜多斯', 1, 1),
       (null, '白子', '女', '阿拜多斯', 1, 1),
       (null, '野宫', '女', '阿拜多斯', 1, 1),
       (null, '芹香', '女', '阿拜多斯', 1, 1),
       (null, '凌音', '女', '阿拜多斯', 1, 1),
       (null, '阿露', '女', '格赫娜', 2, 1),
       (null, '日奈', '女', '格赫娜', 2, 1),
       (null, '伊织', '女', '格赫娜', 2, 1),
       (null, '佳代子', '女', '格赫娜', 2, 1),
       (null, '睦月', '女', '格赫娜', 2, 1),
       (null, '真纪', '女', '千禧', 3, 1),
       (null, '妮露', '女', '千禧', 3, 1),
       (null, '优香', '女', '千禧', 3, 1),
       (null, '明日奈', '女', '千禧', 3, 1),
       (null, '爱丽丝', '女', '千禧', 3, 1),
       (null, '日富美', '女', '圣三一', 4, 1),
       (null, '花子', '女', '圣三一', 4, 1),
       (null, '小春', '女', '圣三一', 4, 1),
       (null, '未花', '女', '圣三一', 4, 1),
       (null, '渚', '女', '圣三一', 4, 1);

create table school
(
    id   int primary key auto_increment,
    name varchar(255)
);
insert into school
values (null, '阿拜多斯'),
       (null, '格赫娜'),
       (null, '千禧'),
       (null, '圣三一');