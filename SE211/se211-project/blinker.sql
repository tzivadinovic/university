create table category
(
	category_id int auto_increment
		primary key,
	name varchar(32) null,
	last_modified_date timestamp default current_timestamp() null,
	last_modified_by varchar(128) default 'system' null,
	created_date timestamp default current_timestamp() null,
	record_status int default 1 null
);

create table city
(
	city_id int auto_increment
		primary key,
	city varchar(32) null,
	zipcode varchar(32) null,
	last_modified_date timestamp default current_timestamp() null,
	last_modified_by varchar(128) default 'system' null,
	created_date timestamp default current_timestamp() null,
	record_status int default 1 null
);

create table currency
(
	currency_id int auto_increment
		primary key,
	currency varchar(32) null,
	last_modified_date timestamp default current_timestamp() null,
	last_modified_by varchar(128) default 'system' null,
	created_date timestamp default current_timestamp() null,
	record_status int default 1 null
);

create table employee
(
	employee_id int auto_increment
		primary key,
	user_id int null,
	first_name varchar(32) null,
	last_name varchar(32) null,
	position varchar(64) null,
	bank varchar(64) null,
	bank_account varchar(64) null,
	phone_number varchar(16) null,
	address varchar(128) null,
	employment_start_date date null,
	employment_end_date date null,
	last_modified_date timestamp default current_timestamp() null,
	last_modified_by varchar(128) default 'system' null,
	created_date timestamp default current_timestamp() null,
	record_status int default 1 null
);

create table product
(
	product_id int auto_increment
		primary key,
	category_id int null,
	code varchar(32) null,
	name varchar(32) null,
	description text null,
	unit varchar(16) null,
	price float null,
	stock int null,
	last_modified_date timestamp default current_timestamp() null,
	last_modified_by varchar(128) default 'system' null,
	created_date timestamp default current_timestamp() null,
	record_status int default 1 null,
	constraint fk_category_product
		foreign key (category_id) references category (category_id)
);

create table state
(
	state_id int auto_increment
		primary key,
	name varchar(32) null,
	last_modified_date timestamp default current_timestamp() null,
	last_modified_by varchar(128) default 'system' null,
	created_date timestamp default current_timestamp() null,
	record_status int default 1 null
);

create table customer
(
	customer_id int auto_increment
		primary key,
	state_id int not null,
	city_id int not null,
	name varchar(32) null,
	last_modified_date timestamp default current_timestamp() null,
	last_modified_by varchar(128) default 'system' null,
	created_date timestamp default current_timestamp() null,
	record_status int default 1 null,
	constraint fk_city_customer
		foreign key (city_id) references city (city_id),
	constraint fk_state_customer
		foreign key (state_id) references state (state_id)
);

create table transport_term
(
	transport_term_id int auto_increment
		primary key,
	term varchar(64) null,
	last_modified_date timestamp default current_timestamp() null,
	last_modified_by varchar(128) default 'system' null,
	created_date timestamp default current_timestamp() null,
	record_status int default 1 null
);

create table invoice_details
(
	invoice_detail_id int auto_increment
		primary key,
	transport_term_id int not null,
	currency_id int not null,
	employee_id int not null,
	customer_id int not null,
	number varchar(16) null,
	date date null,
	delivery_date date null,
	payment_conditions varchar(32) null,
	total_boxes int null,
	remarks varchar(32) null,
	gross_weight decimal null,
	net_weight decimal null,
	shipping_fees decimal null,
	total_price decimal null,
	items_info text null,
	boxes_info text null,
	attn varchar(64) null,
	last_modified_date timestamp default current_timestamp() null,
	last_modified_by varchar(128) default 'system' null,
	created_date timestamp default current_timestamp() null,
	record_status int default 1 null,
	constraint fk_customer_invoice_details
		foreign key (customer_id) references customer (customer_id),
	constraint fk_employee_invoice_details
		foreign key (employee_id) references employee (employee_id),
	constraint fk_invoice_details_currency
		foreign key (currency_id) references currency (currency_id),
	constraint fk_invoice_details_transport_term
		foreign key (transport_term_id) references transport_term (transport_term_id)
);

create table invoice
(
	invoice_id int auto_increment
		primary key,
	invoice_detail_id int null,
	last_modified_date timestamp default current_timestamp() null,
	last_modified_by varchar(128) default 'system' null,
	created_date timestamp default current_timestamp() null,
	record_status int default 1 null,
	constraint fk_invoice_details_invoice
		foreign key (invoice_detail_id) references invoice_details (invoice_detail_id)
			on update cascade on delete cascade
);

create table product_invoice
(
	product_invoice_id int auto_increment
		primary key,
	invoice_id int null,
	product_id int null,
	quantity int null,
	item_number int null,
	box_number int null,
	last_modified_date timestamp default current_timestamp() null,
	last_modified_by varchar(128) default 'system' null,
	created_date timestamp default current_timestamp() null,
	record_status int default 1 null,
	constraint fk_product_invoice_invoice
		foreign key (invoice_id) references invoice (invoice_id),
	constraint fk_product_product_invoice
		foreign key (product_id) references product (product_id)
);

create table user
(
	user_id int auto_increment
		primary key,
	username varchar(64) null,
	password varchar(64) null,
	last_modified_date timestamp default current_timestamp() null,
	last_modified_by varchar(128) default 'system' null,
	created_date timestamp default current_timestamp() null,
	record_status int default 1 null
);

