create table post_codes (id integer not null, isso bit not null, latitude float(53), longitude float(53), post_code varchar(255) not null, primary key (id)) engine=InnoDB;
create table post_codes_seq (next_val bigint) engine=InnoDB;
insert into post_codes_seq values ( 1 );
alter table post_codes add constraint UK_7gkcllfp0ov6ubrvd8mnjelxj unique (post_code);
