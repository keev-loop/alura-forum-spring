INSERT INTO PERFIL(id, nome) VALUES(1, 'ROLE_ALUNO');
INSERT INTO PERFIL(id, nome) VALUES(2, 'ROLE_MODERADOR');

INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$Q.ufDj7sSYxrR8FD.0PGQO875qchYqmTumveJmegB5d2cMFxCtf7W');
INSERT INTO USUARIO(nome, email, senha) VALUES('Moderator', 'moderador@email.com', '$2a$10$Q.ufDj7sSYxrR8FD.0PGQO875qchYqmTumveJmegB5d2cMFxCtf7W');

INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(1, 1);
INSERT INTO USUARIO_PERFIS(usuario_id, perfis_id) VALUES(2, 2);

INSERT INTO CURSO(nome, categoria) VALUES('SPRING BOOT','BACK-END');
INSERT INTO CURSO(nome, categoria) VALUES('PYTHON','BACK-END');
