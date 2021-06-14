create table user (

	id bigint  not null auto_increment,
	username varchar(60) not null,
	email varchar(50) not null,
	
	
	primary key (id),
	constraint UNK_FIELDS unique(username)

)
