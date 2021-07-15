# Application structure and assumptions

### Install & Run

* Application runs on port 8081 having /vendingmachine as context path.
* This is a springboot application with maven as build tool.
* For binary build and installation, use maven commands : mvn build & mvn install
* To run the application, run it as a springboot application OR run as java application 
	(java -jar path/to/your/jarfile/build/from/mvn/install/command.jar com.interview.nestaway.BeverageVendingMachineApplication)  

### Database

* Apache derby has been used as an on fly database
* A table of ingredients has been used as inventory

### Assumptions made

* Maximum capacity of vending machine ingredients is 30.
* Create inventory to fill ingredients in machine for first time.
* Stock up the ingredients to maximum capacity i.e. 30
* Get one or more or all ingredient apis are defined to check the quantity of ingredient present in the machine.
* Get all beverages (currently coffee as beverage) api is defined
* Dispense beverage api is defined which also decreases the quantity from inventory
* Beverage will not be dispensable if any of ingredient is out of stock (Ingredient Out of Stock - 400 BAD Request)
