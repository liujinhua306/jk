CREATE TABLE admin(
id 	INT 	PRIMARY KEY NOT NULL AUTO_INCREMENT,
USER 	VARCHAR(32),
PASSWORD VARCHAR(32)
);
create table loginlog(
id 	INT 	PRIMARY KEY NOT NULL AUTO_INCREMENT,  
date date not null,
ip varchar(20) ,
user varchar(32) not null
);

create table ip_Monitor(
id 	INT 	PRIMARY KEY NOT NULL AUTO_INCREMENT,  
url_ip varchar(50) not null,
date date ,
state int DEFAULT 0,//状态是否正常，0为正常1为不正常
Send_status int DEFAULT 0,//0为未发送1为已发送
Get_Post int  DEFAULT 0,//0为不监控getpost请求
Send_Get_post default 0,//get_Post请求邮件通知0為未發送
email varchar(50) not null 
)
//断开记录
create table Record(
id 	INT 	PRIMARY KEY NOT NULL AUTO_INCREMENT,
url_ip varchar(32) ,
 Event int NOT NULL,//0为get    1为ping
date date not null
)