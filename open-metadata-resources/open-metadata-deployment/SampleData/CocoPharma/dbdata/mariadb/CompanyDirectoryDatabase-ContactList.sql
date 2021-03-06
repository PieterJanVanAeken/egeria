-- SPDX-License-Identifier: Apache-2.0
-- Copyright Contributors to the ODPi Egeria project.
create database IF NOT EXISTS CompanyDirectoryDatabase  character set = UTF8;

use CompanyDirectoryDatabase;

drop table if exists ContactList;
CREATE TABLE ContactList (
  RecId INT NOT NULL,
  ContactType CHAR NOT NULL,
  FirstName VARCHAR(50) NOT NULL,
  LastName VARCHAR(50) NOT NULL,
  Company VARCHAR(50) NOT NULL,
  JobTitle VARCHAR(80) NOT NULL,
  WorkLocation INT NOT NULL
) ;

load data infile '/tmp/_mariadbimport-ocopharma_tmp/CompanyDirectoryDatabase-ContactList.csv' into table ContactList columns terminated by ';' ignore 1 lines;
