drop table if exists users;

create table users(
    username varchar(50)    not null primary key ,
    password varchar(500)   not null ,
    enabled boolean         not null
);

create table authorities(
      username varchar(255)    not null primary key ,
      authority varchar(50)   not null ,
      constraint fk_authorities_users foreign key (username) references users (username)
);

create unique index ix_auth_username
on authorities(username,authority);

insert into users(username,password,enabled) values('test','test',true);
insert into users(username,password,enabled) values('a','a',true);
insert into users(username,password,enabled) values('nitin','password',true);

insert into authorities(username,authority) values('test','USER');
--insert into authorities(username,authority) values('test','ADMIN');
--insert into authorities(username,authority) values('test','MANAGER');
--insert into authorities(username,authority) values('test','HR');
insert into authorities(username,authority) values('a','USER');
insert into authorities(username,authority) values('nitin','USER');
