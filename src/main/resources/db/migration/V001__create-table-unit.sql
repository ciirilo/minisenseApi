create table unit (

	id bigint  not null auto_increment,
	symbol varchar(1) not null,
	description varchar(50) not null,
	
	
	primary key (id),
	constraint UNK_FIELDS unique(symbol)
)