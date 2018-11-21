For StackOverflow Question:

https://stackoverflow.com/questions/53365734/one-off-configuration-for-a-springboottest/53366040#53366040

# Spring Boot example for load SQL data into your tests

The objective of this application is to insert data into tables for tests and
then query this information.

There are two examples
1) Not Mapped Entities
    
        This case need the 'CREATE TABLE..' part in the SQL file (because the hibernate doesn't know about this table) 

2) Mapped Entities
        
        This case doesn't need the table creation in the SQL file because it has already created by hibernate.
        
        
#  Building the application
    ./gradlew clean build

# Running the tests
    ./gradlew clean test