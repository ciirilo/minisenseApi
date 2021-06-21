create table data_stream (

	id bigint  not null auto_increment,
	chave varchar(32) not null,
	sensor_device_id bigint not null,
	alert_max_value bigint not null,
	alert_min_value bigint not null,
	label varchar(50) not null,
	enabled boolean not null,
	measurement_Count bigint,
	unit_Id bigint not null,
	
	primary key (id)
	
);

alter table data_stream add constraint fk_data_stream_sensor_device
foreign key(sensor_device_id) references sensor_device(id)