use PasswordProject;
drop table if exists passwords;
create table passwords (
id int primary key auto_increment not null, 
source_of_hash varchar(60) not null,
email varchar(60), 
hashed_password varchar(260) not null
);
select * from passwords;