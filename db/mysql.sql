-- 用户表（APP）
CREATE TABLE `tb_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `mobile` varchar(20) NOT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `pri_key` varchar(2000) DEFAULT NULL COMMENT '私钥',
  `pub_key` varchar(2000) DEFAULT NULL COMMENT '公钥',
  `gender` int(2) NOT NULL COMMENT '性别'
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户';

































































