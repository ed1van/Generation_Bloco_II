use db_farmacia_do_bem;

select * from tb_categoria;


insert into tb_produto (nome, embalagem, controlado, fk_categoria_id) values ("Dipírona", "Reciclável","Não",2);
insert into tb_produto (nome, embalagem, controlado, fk_categoria_id) values ("Xarope", "Reciclável","Não",3);
insert into tb_produto (nome, embalagem, controlado, fk_categoria_id) values ("Clomipramina", "Não Reciclável","Sim",1);
insert into tb_produto (nome, embalagem, controlado, fk_categoria_id) values ("Fluoxetina", "Não Reciclável","Sim",2);
insert into tb_produto (nome, embalagem, controlado, fk_categoria_id) values ("Cefaliv", "Não Reciclável","Não",5);
insert into tb_produto (nome, embalagem, controlado, fk_categoria_id) values ("amoxicilina", "Reciclável","Sim",4);

SELECT * FROM db_farmacia_do_bem.tb_produto;

alter table tb_produto add preco bigint;

UPDATE `db_farmacia_do_bem`.`tb_produto` SET `preco` = '17' WHERE (`id` = '1');
UPDATE `db_farmacia_do_bem`.`tb_produto` SET `preco` = '23' WHERE (`id` = '2');
UPDATE `db_farmacia_do_bem`.`tb_produto` SET `preco` = '85' WHERE (`id` = '3');
UPDATE `db_farmacia_do_bem`.`tb_produto` SET `preco` = '45' WHERE (`id` = '4');
UPDATE `db_farmacia_do_bem`.`tb_produto` SET `preco` = '33' WHERE (`id` = '5');
UPDATE `db_farmacia_do_bem`.`tb_produto` SET `preco` = '12' WHERE (`id` = '6');

select * from tb_produto where preco > 50;
select * from tb_produto where preco between 3 and 60;
select * from tb_produto where nome like "%b%";

select * from tb_produto inner join tb_categoria on tb_categoria.id = tb_produto.fk_categoria_id;

select * from tb_categoria where categoria = "original";





