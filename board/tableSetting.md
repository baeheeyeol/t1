    create table TB_POST
    (
      ID            NUMBER(20) not null,
      TITLE         VARCHAR2(100),
      CONTENT       VARCHAR2(3000),
      WRITER        VARCHAR2(20),
      VIEW_CNT      NUMBER(11),
      NOTICE_YN     NUMBER(1),
      DELETE_YN     NUMBER(1),
      CREATED_DATE  DATE,
      MODIFIED_DATE DATE
    )
    create table TB_COMMENT
    (
      ID            NUMBER,
      POST_ID       NUMBER,
      CONTENT       VARCHAR2(1000),
      WRITER        VARCHAR2(20),
      DELETE_YN     NUMBER,
      CREATED_DATE  DATE,
      MODIFIED_DATE DATE
    )
    create sequence TB_POST_seq
       increment by 1
       start with 1
       maxvalue 999999
       minvalue 1
       ;
    create sequence TB_comment_seq
       increment by 1
       start with 1
       maxvalue 999999
       minvalue 1
       ;
    create table TB_MEMBER
    (
      ID            NUMBER,
      LOGIN_ID      VARCHAR2(20),
      PASSWORD      VARCHAR2(60),
      NAME          VARCHAR2(20),
      GENDER        VARCHAR2(2),
      BIRTHDAY      DATE,
      DELETE_YN     NUMBER,
      CREATED_DATE  DATE,
      MODIFIED_DATE DATE
    )
  create sequence TB_MEMBER_seq
  increment by 1
  start with 1
  maxvalue 999999
  minvalue 1
  ;