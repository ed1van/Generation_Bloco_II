create database ecommerce;

use ecommerce;

create table tb_ecommerce(
id bigint auto_increment,
nome varchar(250) not null,
preco decimal(6,2)not null,
peso decimal not null,
tamanho decimal(3,2)not null,
embalagem enum("Presente","Normal"),
primary key(id)
);

insert into tb_ecommerce(nome,preco,peso,tamanho,embalagem) values("Bicicleta",2000.00,11,1.26,"presente");
insert into tb_ecommerce(nome,preco,peso,tamanho,embalagem) values("PC Gamer",8000.00,8,0.90,"Presente");
insert into tb_ecommerce(nome,preco,peso,tamanho,embalagem) values("TV",5000.00,10,1.20,"Normal");
insert into tb_ecommerce(nome,preco,peso,tamanho,embalagem) values("PS4",5000.00,4,0.66,"Normal");
insert into tb_ecommerce(nome,preco,peso,tamanho,embalagem) values("Geladeira",9000.00,40,2.00,"Presente");
insert into tb_ecommerce(nome,preco,peso,tamanho,embalagem) values("Fogão",0500.00,30,1.40,"Normal");

SELECT * FROM tb_ecommerce WHERE preco > 500.00;
SELECT * FROM tb_ecommerce WHERE preco <= 500.00;
UPDATE tb_ecommerce SET nome = "Notbook Gamer" WHERE id = 2;


