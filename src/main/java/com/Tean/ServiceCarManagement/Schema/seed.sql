create table users(
	username varchar(20),
	password varchar(20),
	constraint pk_user primary key (username)
)
create table email(
	email varchar(50),
	constraint pk_email primary key(email)
)
create table usersemail(
	username varchar(20),
	email varchar(50),
	constraint fk_username_usersemail foreign key(username) references users(username),
	constraint fk_email_usersemail foreign key(email) references email(email)
)

create table license(
	license varchar(15),
	constraint pk_license primary key(license)
)
create table carlist(
	id int generated always as identity,
	driver varchar(25),
	license varchar(15),
	brand varchar(15),
	manufacturedate int,
	cartype varchar(15),
	registerdate timestamp,
	state varchar(15),
	constraint pk_carlist primary key (id),
	constraint fk_carist_license foreign key (license) references license(license)
)
create table schedule(
	id int generated always as identity,
	carid int ,
	destination varchar(15),
	departure varchar(15),
	startingtime timestamp,
	arrivingtime timestamp,
	capacity varchar(20),

	constraint pk_schedule primary key (id),
	constraint fk_schedule_carid foreign key (carid) references carlist(id)
)




insert into users(username, password) values ('admin','admin')
insert into email(email) values ('admin@gmail.com')
insert into usersemail(username,email) values('admin','admin@gmail.com')