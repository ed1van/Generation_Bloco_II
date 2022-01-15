use `db_cidade_das_carnes`;

insert into tb_categoria (tipo,pais) values ("Bovina","Brasil");
insert into tb_categoria (tipo,pais) values ("Bovina","Espanha");
insert into tb_categoria (tipo,pais) values ("Suina","Irlanda");
insert into tb_categoria (tipo,pais) values ("Suina","Argentina");
insert into tb_categoria (tipo,pais) values ("Ovina","Suécia");
insert into tb_categoria (tipo,pais) values ("Ovina","Italia");

select * from tb_categoria;

insert into tb_produto (preco, parteCarne, peso, validade, fk_categoria_id) values (23.66,"Picanha",2,'2022-01-20',1);
insert into tb_produto (preco, parteCarne, peso, validade, fk_categoria_id) values (33.66,"Acém",1,'2022-01-19',2);
insert into tb_produto (preco, parteCarne, peso, validade, fk_categoria_id) values (53.66,"Chispe",5,'2022-01-29',3);
insert into tb_produto (preco, parteCarne, peso, validade, fk_categoria_id) values (43.86,"Lombo",7,'2022-02-09',4);
insert into tb_produto (preco, parteCarne, peso, validade, fk_categoria_id) values (173.66,"Costela",10,'2022-03-29',5);
insert into tb_produto (preco, parteCarne, peso, validade, fk_categoria_id) values (83.66,"Puleta",4,'2022-02-17',6);

select * from tb_produto;

select * from tb_produto where preco > 50;

select * from tb_produto where preco between 3 and 60;

select * from tb_produto where parteCarne like "%c%";

select * from tb_produto inner join tb_categoria on tb_categoria.id = tb_produto.fk_categoria_id;

select * from tb_categoria where tipo = "Bovina";



