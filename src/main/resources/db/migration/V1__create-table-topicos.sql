
create table topicos(
    id bigint not null auto_increment,
    autor varchar(100) not null,
    titulo varchar(100) not null unique,
    mensaje varchar(100) not null,
    status varchar(100) not null,
    curso varchar(100) not null,
    fecha_de_creacion Date not null,

    primary key(id)
);