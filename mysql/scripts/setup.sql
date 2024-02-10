use template_db;

create table if not exists note
(
    id int auto_increment comment 'Primary Key'
        primary key,
    text varchar(255) null
);

create table if not exists dummyTable(
    id int auto_increment primary key,
    some_string varchar(255) null
);

if (not exists (select * from dummyTable))
begin
    insert into dummyTable ("First String");
    insert into dummyTable ("Second String");
    insert into dummyTable ("Third String");
end

