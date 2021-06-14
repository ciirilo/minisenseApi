create table data_stream (

	id bigint  not null auto_increment,
	chave varchar(32) not null,
	label varchar(50) not null,
	enabled boolean not null,
	measurement_Count bigint,
	
	primary key (id),
	constraint UNK_FIELDS unique(chave)
)