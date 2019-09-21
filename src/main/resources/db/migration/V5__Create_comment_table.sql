create table comment
(
	id bigint auto_increment,
	parent_id bigint not null,
	type int auto_increment,
	commentator int not null,
	gmt_create bigint not null,
	gmt_modified bigint,
	like_count bigint default 0,
	constraint comment_pk
		primary key (id)
);
