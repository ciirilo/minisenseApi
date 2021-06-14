create table measurements (

	id bigint  not null auto_increment,
	time timestamp not null default current_timestamp,
	value float(32) not null,
	unitId bigint not null, 
	
	
	primary key (id)
)