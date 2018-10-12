CREATE TABLE `crc_change` (
  `crc_change_id` int(11) NOT NULL auto_increment,
  `change_data` date default NULL,
  `crc_file_id` int(11) default NULL,
  `last_modified` date default NULL,
  `new_data` varchar(255) default NULL,
  `old_data` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  `user` varchar(255) default NULL,
  PRIMARY KEY  (`crc_change_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `crc_owner` (
  `ownerid` int(11) NOT NULL auto_increment,
  `username` varchar(255) default NULL,
  `file_id` int(11) NOT NULL,
  PRIMARY KEY  (`ownerid`),
  KEY `FK450xbqpuy9d9gq5oqt0d16kwe` (`file_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6011 DEFAULT CHARSET=latin1;
