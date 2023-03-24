
#  Tele2 Monty Hall TV Show

TV show where you can win money by picking the right box. The game show host shows you three boxes explaining that the money is in one of the boxes. He asks you to pick one of them without opening it. After you have picked one of the boxes he opens one of the other two boxes which is empty. Now he turns to you and asks, do you want to change your mind, picking the remaining box?




# Technology Stack
* Tele2 Monty Hall 
* Java 17
* IntelliJ

# Project Structure


#### Code Level
* **src/main/java** holding all the classes used for handling the required business
* **src/main/resources** resource files that will be used by the main source code
* **src/test/java** holding all unit test classes
* **src/test/resources** resource files that will be used by testing classes


#### Build Project


```sh
$ mvn clean install
$ java -jar target/Monty-Hall-1.0-SNAPSHOT.jar
```

- once App starts will ask user to define number of simulation cases he wants to run once user enter the number of simulations
- Application will run and result will as below encase # of simulation Entered = 10000

```aidl

 Number of simulations: 10000
 Number of times staying wins: 1686
 Number of times switching wins: 3287
 Winning probability if staying: 0.1686
 Winning probability if switching: 0.3287
 Switching gives a better chance of winning: true

```
