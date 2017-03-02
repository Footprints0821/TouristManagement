# Tourist Management System
The purpose of the required journey management system is to manage tourist trains that are serving a number of routes on the new area. The system manages the allocation of trains to journeys and tracks their progress along the routes. Each route is served by a timetable, which states the times at which a train will depart from designated train stops along the route. A single outward and return trip on the timetable is known as a journey. Each route may be served by a number of trains, but only one train is assigned to a particular journey at a time. Driver information should also be managed. Drivers are assigned to journeys when they are available.

#How to Set up/Configure and Run the Software
As for all code must run from the command line with no requirements to install extra software, I will first tell you how to launch our system through command line.
You first need to make to path to the position where the code store, in our path, you need to move into the src folder, which contain all the code for running this system.

This folder will contain such file above; you need to compile the file Main.java by using these following commands.
`javac Main.java`
After finish this process, it means that all those file are successfully compiled, you then need to execute the program by using following commands.
`java Main`
After that, this system will successfully launch. You will see the first interface; the detailed manipulation instruction can be found by reading the user manual.
As for test programs, which is in the test folder, due to we use JUnit as test tool, if you want to run our testing programs, you need add this folder to the eclipse project and add JUnit 4 packet to the project and run these tests.
