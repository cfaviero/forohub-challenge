create TABLE topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(700) not null unique,
    fecha_de_creacion datetime not null,
    status tinyint not null,
    usuario_id bigint not null,
    curso_id bigint not null,

    primary key(id),
    constraint fk_topicos_usuario_id foreign key (usuario_id) references usuarios(id),
    constraint fk_topicos_curso_id foreign key (curso_id) references cursos(id)
);