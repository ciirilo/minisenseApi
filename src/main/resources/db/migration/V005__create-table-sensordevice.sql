create table sensor_device (

	id bigint  not null auto_increment,
	chave varchar(50),
	user_Id bigint(50),	
	label varchar(50) not null,
	description varchar(60) not null,

	
	primary key (id),
	constraint UNK_FIELDS unique(chave)
);

