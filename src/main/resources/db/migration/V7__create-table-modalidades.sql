create table modalidades(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    mensalidade decimal(14,2) not null,
    descricao varchar(200),

    primary key(id)

);