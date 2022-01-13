CREATE DATABASE db_generation_game_online;

use db_generation_game_online;

CREATE TABLE tb_classe(
id bigint auto_increment,
nomeClasse varchar(100) not null,
nivel bigint not null,
especialidade varchar(100) not null,
primary key(id)

);

CREATE TABLE tb_personagem(
id bigint auto_increment,
nomePersonagem varchar(100) not null,
poderAtaque bigint not null,
poderDefesa bigint not null,
agilidade bigint not null,
inteligencia bigint not null,
classe_id bigint not null,
primary key(id),
foreign key(classe_id) references tb_classe(id)

);

-- classes
insert into tb_classe(nomeClasse, nivel, especialidade) values ("Assassino",32, "Ataque furtivo");
insert into tb_classe(nomeClasse, nivel, especialidade) values ("Arqueiro",40, "Pontaria");
insert into tb_classe(nomeClasse, nivel, especialidade) values ("Guerreiro",22, "Armas pesadas");

-- Personagens
insert into tb_personagem(nomePersonagem, poderAtaque, poderDefesa, agilidade, inteligencia, classe_id) values ("Aron",51,33,90,85,1);
insert into tb_personagem(nomePersonagem, poderAtaque, poderDefesa, agilidade, inteligencia, classe_id) values ("Ban",41,30,95,90,1);
insert into tb_personagem(nomePersonagem, poderAtaque, poderDefesa, agilidade, inteligencia, classe_id) values ("Arqueiro verde",72,43,90,85,2);
insert into tb_personagem(nomePersonagem, poderAtaque, poderDefesa, agilidade, inteligencia, classe_id) values ("Robin Hood",81,13,70,99,2);
insert into tb_personagem (nomePersonagem, poderAtaque, poderDefesa, agilidade, inteligencia, classe_id) values ("Hercules", 95,87,60,66,3);
insert into tb_personagem (nomePersonagem, poderAtaque, poderDefesa, agilidade, inteligencia, classe_id) values ("Sansão", 97,80,76,50,3);

 select * from tb_personagem where poderAtaque > 50;
 select * from tb_personagem where poderDefesa > 50 and poderDefesa < 100;
select * from tb_personagem where nomePersonagem like  "%c%";
    
select * from tb_personagem
inner join tb_classe on tb_classe.id = tb_personagem.classe_id
where tb_classe.nomeClasse = "Assassino"; 

