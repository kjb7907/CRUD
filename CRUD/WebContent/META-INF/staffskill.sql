create table skill (
    no number(3),
    name varchar2(20) not null unique,
    primary key(no)
);
 
create sequence skill_seq start with 1 increment by 1;
 
create table school (
    no number(3),
    graduate varchar2(20) not null unique,
    primary key(no)
);
 
create sequence school_seq start with 1 increment by 1;
 
create table religion (
    no number(3),
    name varchar2(20) not null unique,
    primary key(no)
);
 
create sequence religion_seq start with 1 increment by 1;
create table staff (
    no number(3),
    name varchar2(14) not null,
    sn char(14) not null unique,
    graduateday date not null,
    schoolno number(3) not null,
    religionno number(3) not null,
    foreign key(schoolno) references school(no),
    foreign key(religionno) references religion(no),
    primary key(no)
);
 
create sequence staff_seq start with 1 increment by 1;
create table staffskill (
    no number(3),
    staffno number(3), 
    skillno number(3),
    foreign key(staffno) references staff(no),
    foreign key(skillno) references skill(no),
    primary key(no)
);
 
create sequence staffskill_seq start with 1 increment by 1;
insert into skill(no, name) values(skill_seq.nextval, 'java');
insert into skill(no, name) values(skill_seq.nextval, 'html5');
insert into skill(no, name) values(skill_seq.nextval, 'JSP');
insert into skill(no, name) values(skill_seq.nextval, 'SQL');
insert into skill(no, name) values(skill_seq.nextval,'javascript');
 
insert into religion(no, name) values(religion_seq.nextval, '����');
insert into religion(no, name) values(religion_seq.nextval, '�ұ�');
insert into religion(no, name) values(religion_seq.nextval, '�⵶��');
insert into religion(no, name) values(religion_seq.nextval, 'õ�ֱ�');
 
insert into school(no, graduate) values(school_seq.nextval, '����');
insert into school(no, graduate) values(school_seq.nextval, '��������');
insert into school(no, graduate) values(school_seq.nextval, '����');

