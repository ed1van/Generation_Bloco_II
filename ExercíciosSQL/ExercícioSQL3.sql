create database db_escola;

use db_escola;

create table tb_estudantes(
id bigint auto_increment,
nome varchar (100) not null,
nascimento varchar(50) not null,
serie bigint not null,
periodo  enum ('N', 'D', 'V'),
nota bigint not null,
primary key(id)

);

  insert into tb_estudantes(nome,nascimento,serie,periodo,nota) values ("Ruan","30/02/2004",6,'D',10);
  insert into tb_estudantes(nome,nascimento,serie,periodo,nota) values ("Maria","10/04/2006",5,'D',9);
  insert into tb_estudantes(nome,nascimento,serie,periodo,nota) values ("Ronaldo","22/12/2007",4,'V',5);
  insert into tb_estudantes(nome,nascimento,serie,periodo,nota) values ("Mariano","30/02/2004",6,'D',10);
  insert into tb_estudantes(nome,nascimento,serie,periodo,nota) values ("Josefa","30/02/2008",5,'V',8);
  insert into tb_estudantes(nome,nascimento,serie,periodo,nota) values ("Daniel","30/02/2007",4,'V',4);
  insert into tb_estudantes(nome,nascimento,serie,periodo,nota) values ("Daniel Augusto","30/02/2002",9,'N',4);
  insert into tb_estudantes(nome,nascimento,serie,periodo,nota) values ("Fatima","30/02/2002",9,'N',10);
  
  SELECT * FROM tb_estudantes WHERE nota > 7;
  SELECT * FROM tb_estudantes WHERE nota <= 7;
  UPDATE tb_estudantes SET periodo = 'V' WHERE id = 1;