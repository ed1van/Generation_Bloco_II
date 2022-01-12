create database db_rh;

use db_rh; -- acesso a banco de dados

create table tb_rh(
id bigint auto_increment,
nome varchar(250) not null,
funcao varchar(250) not null,
salario decimal(6,2) not null,
horario varchar (50) not null,
nivel enum ( 'J', 'P', 'S'),
primary key(id)

);

insert into tb_rh(nome, funcao, salario, horario, nivel) values ("José Romero"," Agente comercial",2000.00,"08:30 am",'J');
insert into tb_rh(nome, funcao, salario, horario, nivel) values ("Samantha Bueno","Analista da Qualidade",5000.00,"07:00 am",'P');
insert into tb_rh(nome, funcao, salario, horario, nivel) values ("Manuel Fernandes","Analista de Recursos Humanos",9000.00,"07:00 am",'S');
insert into tb_rh(nome, funcao, salario, horario, nivel) values ("Samara Almeida","Analista de T.I",1500.00,"10:00 am",'J');
insert into tb_rh(nome, funcao, salario, horario, nivel) values ("Leo Silveiro", "Analista Financeiro",7000.00,"09:00 am",'S');


SELECT * FROM tb_rh WHERE salario > 2000.00; -- vai retorinar os salários acima de 2000.00
SELECT * FROM tb_rh WHERE salario <= 2000.00; -- vai retornar os salários abaixo ou igual 2000.00
UPDATE tb_rh SET salario = 1700.00 WHERE id = 4; -- fez alteração de um dado -- dado altrerado: Salário da Samara

