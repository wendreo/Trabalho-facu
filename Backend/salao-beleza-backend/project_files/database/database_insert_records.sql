-- Password: "admin".
INSERT INTO `salao`.`tb_user` (`pk_id`, `name`, `email`, `password`)
VALUES ('1', 'Admin', 'admin@admin.com', '48b11007522de55f17cae287f725cfb3fce6ea3de9669779a7e6d53599286e8c4ceeeed02956ba73');

INSERT INTO `salao.tb_permission` (`pk_id`,`role`)VALUES('1','ROLE_ADMIN');
INSERT INTO `salao.tb_permission` (`pk_id`,`role`)VALUES('2','ROLE_CLIENTE');
INSERT INTO `salao.tb_permission` (`pk_id`,`role`)VALUES('3','ROLE_FUNCIONARIO');

INSERT INTO `salao`.`tb_user_permission` (`permission_id`, `user_id`) VALUES ('1', '1');

