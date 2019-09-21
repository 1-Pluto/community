create table notification
(
	id bigint auto_increment,
	notifier bigint not null,
	receiver bigint not null,
	outerId bigint not null,
	type int not null,
	gmt_create bigint not null,
	stauts int default 0 not null,
	constraint notification_pk
		primary key (id)
);
