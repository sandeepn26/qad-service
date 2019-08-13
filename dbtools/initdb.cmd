REM tier
set tier=prod

REM Use password root
REM QAD MySQL db details
set db_host=localhost
set db_user=root
set port=3306

echo initializing QAD local db for %db_host%...
mysql -h %db_host% -u %db_user% -P %port% -p --local-infile=1 < sql/initdb.sql