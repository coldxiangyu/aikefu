
DROP TABLE IF EXISTS user;

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL,
  `login_enable` varchar(255) DEFAULT NULL,
  `login_error` int(11) DEFAULT NULL,
  `login_last` datetime DEFAULT NULL,
  `user_avatar` varchar(255) DEFAULT NULL,
  `user_desc` varchar(255) DEFAULT NULL,
  `user_display_name` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_pass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);