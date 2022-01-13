create database db_pizzaria_legal;

use db_pizzaria_legal;

create table tb_categoria(
id bigint auto_increment,
tamanho enum ('P','M','G'),
bordas varchar(50) not null,
observacao varchar(255)not null,
primary key(id)
);

create table tb_pizza (
id bigint auto_increment,
nome varchar(50) not null,
sabor varchar(50) not null,
adicionais enum ("queijo","Cebola","Azeitona"), -- Foi alterado para varchar
catego_id bigint not null,
-- houve uma adição de preco
primary key(id),
foreign key(catego_id) references tb_categoria(id)
);

insert into tb_categoria(tamanho,bordas,observacao) values('P',"Com","Salgada");
insert into tb_categoria(tamanho,bordas,observacao) values('P',"Sem","Doce");
insert into tb_categoria(tamanho,bordas,observacao) values('M',"Com","Salgada");
insert into tb_categoria(tamanho,bordas,observacao) values('M',"Sem","Doce");
insert into tb_categoria(tamanho,bordas,observacao) values('G',"Com","Salgada");
insert into tb_categoria(tamanho,bordas,observacao) values('G',"Sem","Doce");




insert into tb_pizza(nome,sabor,adicionais,catego_id) values("QND","Quatro Queijos","Azeitona",1);
insert into tb_pizza(nome,sabor,adicionais,catego_id) values("RJS","Romeu e Julieta"," - ",2);
insert into tb_pizza(nome,sabor,adicionais,catego_id) values("BRQ","Brigadeiro"," - ",4);
insert into tb_pizza(nome,sabor,adicionais,catego_id) values("POI","Portuguesa","+Cebola",3);
insert into tb_pizza(nome,sabor,adicionais,catego_id) values("TSS","Toscana","+Queijo",5);
insert into tb_pizza(nome,sabor,adicionais,catego_id) values("MOD","Morango com chocolate","+Morango",6);
insert into tb_pizza(nome,sabor,adicionais,catego_id) values("CCD","Coco com Chocolate","-",2);
insert into tb_pizza(nome,sabor,adicionais,catego_id) values("AMD","Mista","Queijo",5);


alter table tb_pizza modify adicionais varchar(250);

alter table tb_pizza add preco decimal(5,2);

UPDATE `db_pizzaria_legal`.`tb_pizza` SET `preco` = '56.22' WHERE (`id` = '1');
UPDATE `db_pizzaria_legal`.`tb_pizza` SET `preco` = '44.62' WHERE (`id` = '2');
UPDATE `db_pizzaria_legal`.`tb_pizza` SET `preco` = '53.22' WHERE (`id` = '3');
UPDATE `db_pizzaria_legal`.`tb_pizza` SET `preco` = '45.32' WHERE (`id` = '4');
UPDATE `db_pizzaria_legal`.`tb_pizza` SET `preco` = '46.33' WHERE (`id` = '5');
UPDATE `db_pizzaria_legal`.`tb_pizza` SET `preco` = '85.66' WHERE (`id` = '6');
UPDATE `db_pizzaria_legal`.`tb_pizza` SET `preco` = '33.11' WHERE (`id` = '7');
UPDATE `db_pizzaria_legal`.`tb_pizza` SET `preco` = '43.66' WHERE (`id` = '8');


select * from tb_pizza where preco > 45;
select * from tb_pizza where preco > 29 and preco < 60;
select * from tb_pizza where nome like  "%c%";

select * from tb_pizza
inner join tb_categoria on tb_categoria.id = tb_pizza.catego_id
where tb_categoria.observacao = "doce"; 





