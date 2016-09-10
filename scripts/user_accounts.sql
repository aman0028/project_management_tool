CREATE TABLE `user_accounts` (
  `user_identifer_id` varchar(20) NOT NULL,
  `fullname` varchar(40) NOT NULL,
  `user_email_id` varchar(40) NOT NULL,
  `company_name` varchar(40) NOT NULL,
  `company_website` varchar(40) NOT NULL,
  `company_phone_number` varchar(20) DEFAULT NULL,
  `order_edition_code` varchar(20) DEFAULT NULL,
  `price_duration` varchar(10) NOT NULL,
  `subscription_status` varchar(20) NOT NULL,
  `date_created` timestamp NULL DEFAULT NULL,
  `date_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_identifer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;