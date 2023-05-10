create table board(
	num int primary key,
	writer varchar(30),	
	pass varchar(20),	
	title varchar(100),	
	content varchar(2000), 
	file1 varchar(200), 
	boardid varchar(2),
	regdate datetime,	
	readcnt int(10),	
	grp int,			
	grplevel int(3),	
	grpstep int(5)		
);
drop table board;

create table member (
   id varchar(20) primary key,
   pw varchar(20),
   name varchar(20),
   tel varchar(15),
   email varchar(50),
);
select *from member

select * from comment
