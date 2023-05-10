SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS board_recommend;
DROP TABLE IF EXISTS com_recommend;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS board;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS level;




/* Create Tables */

-- 게시판
CREATE TABLE board
(
	board_num int NOT NULL COMMENT '게시물번호',
	title varchar(45) COMMENT '제목',
	content varchar(1000) COMMENT '내용',
	readcnt int COMMENT '조회수',
	recommendcnt int COMMENT '추천수',
	regdate datetime COMMENT '등록일',
	boardid int COMMENT '게시판번호',
	file1 varchar(100) COMMENT '첨부파일',
	category_num int NOT NULL COMMENT '카테고리번호',
	member_id varchar(45) NOT NULL COMMENT '회원아이디',
	PRIMARY KEY (board_num)
) COMMENT = '게시판';

select *from board

-- 게시물추천
CREATE TABLE board_recommend
(
	num int NOT NULL COMMENT '추천번호',
	board_num int NOT NULL COMMENT '게시물번호',
	member_id varchar(45) NOT NULL COMMENT '회원아이디',
	PRIMARY KEY (num)
) COMMENT = '게시물추천';


-- 카테고리
CREATE TABLE category
(
	category_num int NOT NULL COMMENT '카테고리번호',
	name varchar(45) COMMENT '분류',
	boardid int COMMENT '게시판번호',
	PRIMARY KEY (category_num)
) COMMENT = '카테고리';


-- 댓글
CREATE TABLE comment
(
	comment_num int NOT NULL COMMENT '댓글번호',
	regdate datetime COMMENT '작성일',
	recommendcnt int COMMENT '추천수',
	member_id varchar(45) NOT NULL COMMENT '회원아이디',
	board_num int NOT NULL COMMENT '게시물번호',
	PRIMARY KEY (comment_num)
) COMMENT = '댓글';


-- 댓글추천
CREATE TABLE com_recommend
(
	num int NOT NULL COMMENT '추천번호',
	member_id varchar(45) NOT NULL COMMENT '회원아이디',
	comment_num int NOT NULL COMMENT '댓글번호',
	PRIMARY KEY (num)
) COMMENT = '댓글추천';


-- 레벨
CREATE TABLE level
(
	level int NOT NULL COMMENT '레벨',
	maxexp int COMMENT '필요경험치',
	PRIMARY KEY (level)
) COMMENT = '레벨';


-- 회원
CREATE TABLE member
(
	member_id varchar(45) NOT NULL COMMENT '회원아이디',
	password varchar(45) COMMENT '비밀번호',
	tel varchar(45) COMMENT '전화번호',
	email varchar(45) COMMENT '이메일',
	exp int COMMENT '경험치',
	level int NOT NULL COMMENT '레벨',
	PRIMARY KEY (member_id)
) COMMENT = '회원';

select *from member

/* Create Foreign Keys */

ALTER TABLE board_recommend
	ADD FOREIGN KEY (board_num)
	REFERENCES board (board_num)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE comment
	ADD FOREIGN KEY (board_num)
	REFERENCES board (board_num)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board
	ADD FOREIGN KEY (category_num)
	REFERENCES category (category_num)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE com_recommend
	ADD FOREIGN KEY (comment_num)
	REFERENCES comment (comment_num)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE member
	ADD FOREIGN KEY (level)
	REFERENCES level (level)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board
	ADD FOREIGN KEY (member_id)
	REFERENCES member (member_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE board_recommend
	ADD FOREIGN KEY (member_id)
	REFERENCES member (member_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE comment
	ADD FOREIGN KEY (member_id)
	REFERENCES member (member_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE com_recommend
	ADD FOREIGN KEY (member_id)
	REFERENCES member (member_id)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



