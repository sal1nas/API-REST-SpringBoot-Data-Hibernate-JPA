insert into cozinha(id,nome) values (1, 'Tailandesa');
insert into cozinha(id,nome) values (2, 'Indiana');

insert into restaurante(nome,taxa_frete, cozinha_id) values('Thai Gourmet',10.00, 1);
insert into restaurante(nome,taxa_frete, cozinha_id) values('Thai Delivery',9.50, 1);
insert into restaurante(nome,taxa_frete, cozinha_id) values('Tuk Tuk Comida Indiana',15.00, 2);

insert into cidade(nome) values('Corumbá');
insert into cidade(nome) values('Campo Grande');
insert into cidade(nome) values('Dourados');
insert into cidade(nome) values('Tres Lagoas');

insert into cidade(nome) values('Bauru');
insert into cidade(nome) values('Campinas');

insert into estado(nome) values('MS');
insert into estado(nome) values('SP');

insert into forma_pagamento(descricao) values('PIX');
insert into forma_pagamento(descricao) values('CARTAO DE CREDITO');
insert into forma_pagamento(descricao) values('CARTAO DE DEBITO');
insert into forma_pagamento(descricao) values('DINHEIRO');

insert into permissao(nome,descricao) values('PEDRO','ADMINISTRADOR');
insert into permissao(nome,descricao) values('Convidado','Usuario Comum');


insert into funcionarios(nome) values('Jack Bauer');
insert into funcionarios(nome) values('Kim Bauer');
insert into funcionarios(nome) values('Chloe OBrian');
insert into funcionarios(nome) values('Michelle Dessler');

      
      
      
      
      
      