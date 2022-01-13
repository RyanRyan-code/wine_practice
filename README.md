# How to run:
# 1. 
in the terminal, go to the directory of postgres.yml, then $ docker-compose -f postgres.yml up
the database should now be receiving data from port 5433
the database needs yet to be initialized. Now it only has the dafault database and no tables
# 2. 
in Intelli J, run the main application
the initialization function will create two tables in the database named 'wine_lots'. It will also upload three lotcodes together with all their information integrated into the database. 

# the database:
the database has two tables. The table 'wine_lot_codes' has all the lotcodes and their basic information. The table 'wine_component' has the information of components which are used to produce the query results

# functions of the application:
the application has two functions:
# 1. 
 you can post the json file containing the lotcode and its relevant information to localhost:8080/api/post. The two tables will be updated accordingly. 
# 2. 
●	/api/breakdown/year/{lotCode} - breakdown of TOTAL percentage by year
●	/api/breakdown/variety/{lotCode} - breakdown of TOTAL percentage by variety
●	/api/breakdown/region/{lotCode} - breakdown of TOTAL percentage by region
●	/api/breakdown/year-variety/{lotCode} - breakdown of TOTAL percentage by year + variety combination
