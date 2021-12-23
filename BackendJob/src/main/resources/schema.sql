drop table if exists job;
create table job (job_id INT primary key, description varchar(200), status varchar(10), start_date date, end_date date, 
update_date date, errors varchar(100), is_active_flag boolean(10));
commit;
