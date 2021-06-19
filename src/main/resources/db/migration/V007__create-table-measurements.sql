create table measurements (

	id bigint  not null auto_increment,
	time varchar(10) not null ,
	data_stream_id bigint not null,
	value float(32) not null,
	unit_id bigint not null, 
	
	
	primary key (id)
);

alter table measurements add foreign key(data_stream_id) references data_stream(id)