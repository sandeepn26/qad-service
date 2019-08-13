#!/bin/bash

# tier
tier="'prod'"

# Use password root
# QAD MySQL db details
db_host='localhost'
db_user='root'
port='3306'

echo initializing local db for ${db_host}...
mysql -h ${db_host} -u ${db_user} -P ${port} -p --local-infile=1 < sql/initdb.sql