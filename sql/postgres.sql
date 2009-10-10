CREATE TABLE user_data (
       id			   VARCHAR(64),
       user_login      VARCHAR(64)	   NOT NULL,
       user_password   VARCHAR(64)     NOT NULL,
       security_level  INTEGER NOT NULL,
       PRIMARY KEY (id),
       UNIQUE (id, user_login)
);

create table bookmark (
	id 			varchar(255) not null, 
	url 		varchar(1024) not null, 
	title 		varchar(1024), 
	folder 		varchar(1024), 
	description varchar(255), 
	add_date 	date, 
	last_visit 	date, 
	viewable 	int2, 
	keywords 	varchar(255),
	user_id 	varchar(255), 
	primary key (id));

create table page_list (
	id			bigint not null,
	url			varchar(1024) not null unique,
	cache_failed int2,
	primary key(id)
	);

create table page_index (
	id			bigint not null,
	word		varchar(255),
	occurances	smallint,
	primary key(id, word)
	);

create table page_cache (
	id			bigint not null,
	page_text	text,
	time_loaded	timestamp,
	primary key(id)
	);
	
alter table page_index add constraint FKPIID foreign key (ID) references page_list (ID);	
alter table page_cache add constraint FKPCID foreign key (ID) references page_list (ID);

CREATE TABLE files(
	id VARCHAR(32) NOT NULL PRIMARY KEY,
	file_name VARCHAR(64),
	file_size INTEGER,
	file_type VARCHAR(255),
	file_description VARCHAR(255),
	file bytea NOT NULL);

CREATE TABLE releases (
       id			   VARCHAR(64),
       created_by      VARCHAR(64),
       title           VARCHAR(255),
       description     VARCHAR(255),
       instructions	   VARCHAR(255),
       version_number  VARCHAR(255),
       created_date    DATE,
       ready           INTEGER,
       keywords        VARCHAR(255),
       PRIMARY KEY (id),
       UNIQUE (id)
);

create table release_file_xref (release_id varchar(64) not null, file_id varchar(64) not null, primary key (release_id, file_id));

create table todo_lists (
	id varchar(255) not null, 
	title varchar(255) not null,
	USER_ID varchar(255) not null,
	primary key(id)); 	

create table todo_items (
	id varchar(255) not null, 
	title varchar(255) not null, 
	USER_ID varchar(255) not null, 
	todo_list_id varchar(255) not null,
	primary key (id));	
	
create table release_user_xref (release_id varchar(64) not null, user_id varchar(64) not null, primary key (release_id, user_id));
create table friend (id varchar(64) not null, friend_id varchar(64) not null, primary key (id, friend_id));

create table cookies (
	id 			varchar(255) not null, 
	user_id 	varchar(64) not null, 
	create_date	date not null, 
	primary key (id));

alter table bookmark add constraint FK7787A5362206F20F foreign key (USER_ID) references user_data;
alter table release_file_xref add constraint FKDABE1BC6F7D5BEBE foreign key (FILE_ID) references files;
alter table release_file_xref add constraint FKDABE1BC6C27CDC73 foreign key (RELEASE_ID) references releases;
alter table todo add constraint FK3668462206F20F foreign key (USER_ID) references user_data;
alter table release_user_xref add constraint FK3D6FBED7C27CDC73 foreign key (RELEASE_ID) references releases;
alter table release_user_xref add constraint FK3D6FBED72206F20F foreign key (USER_ID) references user_data;
alter table friend add constraint FKB4860A9E60A7825C foreign key (FRIEND_ID) references user_data;
alter table friend add constraint FKB4860A9E91B foreign key (ID) references user_data;
alter table cookies add constraint FK_COOKIE_USER foreign key (USER_ID) references user_data;
alter table todo_lists add constraint FK_TODO_LISTS_USER foreign key (USER_ID) references user_data;
alter table todo_items add constraint FK_TODO_ITEMS_USER foreign key (USER_ID) references user_data;
alter table todo_items add constraint FK_TODO_ITEMS_TODO_LISTS foreign key (todo_list_id) references todo_lists;

CREATE TABLE ts_entry (
	id VARCHAR(64) NOT NULL PRIMARY KEY,
    user_id VARCHAR(64) NOT NULL,
	activity_id VARCHAR(64) NOT NULL,
	customer_id VARCHAR(64),
	hours NUMERIC(4, 2),
	date_time_start TIMESTAMP,
	date_occur DATE,
	description VARCHAR(1024)
	);

CREATE TABLE ts_activity (
	id VARCHAR(64) NOT NULL PRIMARY KEY,
	name VARCHAR(32) NOT NULL,
	description VARCHAR(255),
	default_customer_id VARCHAR(64)
	);
	
CREATE TABLE ts_customer (
	id VARCHAR(64) NOT NULL PRIMARY KEY,
	name VARCHAR(64) NOT NULL,
	abbreviation VARCHAR(8) NOT NULL
	);
	
alter table ts_entry add constraint FK_TS_ENTRY_USER foreign key (USER_ID) references user_data;
alter table ts_entry add constraint FK_TS_ENTRY_ACTIVITY foreign key (ACTIVITY_ID) references ts_activity;
alter table ts_entry add constraint FK_TS_ENTRY_CUSTOMER foreign key (CUSTOMER_ID) references ts_customer;
alter table ts_activity add constraint FK_TS_ACTIVITY_DEFAULT_CUSTOMER foreign key (DEFAULT_CUSTOMER_ID) references ts_customer;
