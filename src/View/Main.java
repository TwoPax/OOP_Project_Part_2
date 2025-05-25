package View;
import java.util.*;

import Model.*;
import Control.systemDateBase;


public class Main {
	
    static Scanner scanner = new Scanner(System.in);
    static systemDateBase ourSystem = new systemDateBase();
    
	public static void main(String[] args) {
		 initializeData();
	     mainMenu();
	     return;
	}
    
	/*
     * Effect: Shows main menu
     */
	public static void mainMenu() {
	
        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Login as Main Manager");
            System.out.println("2. Login as Manager");
            System.out.println("3. Login as Subscriber");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            String ch = scanner.nextLine();
           
            if (ch.equals("1")) 
            {
                loginMainManager();
            } 
            else if (ch.equals("2")) 
            {
                loginManager();
            }
             else if (ch.equals("3"))
            {
                loginSubscriber();
            } 
            else if (ch.equals("0")) 
            {
                System.out.println("Goodbye!");
                break;
            } 
            else 
            {
                System.out.println("Invalid option.");
            }
        }
        return;
    }
    /*
     * Effect: Initialize all data *************************************************Fix***********************************
     */
    public static void initializeData() 
    { 
    	ourSystem.addManager(new MainManager("9001", "Maria", "Fahoum", "0500000000", "Central Perk", "system", "12345"));
    	ourSystem.addManager(new Manager("M1", "Mike", "Hannigan", "0500000001", "NYC"));
    	ourSystem.addManager(new Manager("M2", "Janice", "Hosenstein", "0500000002", "Brooklyn"));
    	ourSystem.addManager(new Manager("M3", "Estelle", "Leonard", "0500000003", "Queens"));
    	ourSystem.addManager(new Manager("M4", "Jack", "Geller", "0500000004", "Manhattan"));

    	ourSystem.addSubscription(new Subscription("S1", "Rachel", "Green", "0501111111", "Soho"));
    	ourSystem.addSubscription(new Subscription("S2", "Monica", "Geller", "0501111112", "West Village"));
    	ourSystem.addSubscription(new Subscription("S3", "Phoebe", "Buffay", "0501111113", "Upper East"));
    	ourSystem.addSubscription(new Subscription("S4", "Joey", "Tribbiani", "0501111114", "Queens"));
    	ourSystem.addSubscription(new Subscription("S5", "Ross", "Geller", "0501111115", "Museum District"));
    	ourSystem.addSubscription(new Subscription("S6", "Chandler", "Bing", "0501111116", "Greenwich"));
    	ourSystem.addSubscription(new Subscription("S7", "Emily", "Waltham", "0501111117", "London"));
    	ourSystem.addSubscription(new Subscription("S8", "Carol", "Willick", "0501111118", "Brooklyn"));
    	ourSystem.addSubscription(new Subscription("S9", "Susan", "Bunch", "0501111119", "Brooklyn"));
    	ourSystem.addSubscription(new Subscription("S10", "Ben", "Geller", "0501111120", "NYC"));

    	ourSystem.addTaxi(new Taxi("T1", true, 35));
    	ourSystem.addTaxi(new Taxi("T2", true, 40));
    	ourSystem.addTaxi(new ExpressTaxi("T3", true, 45, true, 10));
    	ourSystem.addTaxi(new ExpressTaxi("T4", true, 50, true, 12));
    	ourSystem.addTaxi(new IntercityTaxi("T5", true, 60,new ArrayList<>(Arrays.asList("Tel Aviv", "Haifa")),15, 3));
        ourSystem.addTaxi(new IntercityTaxi("T6", true, 70,new ArrayList<>(Arrays.asList("Jerusalem", "Eilat")),20, 5));
    	ourSystem.addTaxi(new Taxi("T7", true, 30));
    	ourSystem.addTaxi(new ExpressTaxi("T8", true, 55, true, 13));
    	ourSystem.addTaxi(new Taxi("T9", true, 32));
    	ourSystem.addTaxi(new Taxi("T10", true, 38));
    }


    /*
     * Effect: Getting day value from user
     * Output: A legal value of day
     */
    public static int getValidDay() {
        int day;
        do {
            System.out.print("Enter day (1-31): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter day (1-31): ");
                scanner.next();
            }
            day = scanner.nextInt();
        } while (day < 1 || day > 31);
        return day;
    }
    /*
     * Effect: Getting month value from user
     * Output: A legal value of month
     */
    public static int getValidMonth() {
        int month;
        do {
            System.out.print("Enter month (1-12): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter month (1-12): ");
                scanner.next();
            }
            month = scanner.nextInt();
        } while (month < 1 || month > 12);
        return month;
    }
    /*
     * Effect: Getting hour value from user
     * Output: A legal value of hour
     */
    public static int getValidHour() {
        int hour;
        do {
            System.out.print("Enter hour (0-23): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter hour (0-23): ");
                scanner.next();
            }
            hour = scanner.nextInt();
        } while (hour < 0 || hour > 23);
        return hour;
    }
    /*
     * Effect: Getting price value from user
     * Output: A legal value of price
     */
    public static double getValidPrice() {
        double price;
        do {
            System.out.print("Enter price (>0): ");
            while (!scanner.hasNextDouble()) {
                System.out.print("Invalid input. Enter price (>0): ");
                scanner.next();
            }
            price = scanner.nextDouble();
        } while (price <= 0);
        return price;
    }
    /*
     * Effect: Getting a positive value from user
     * Output: A legal value of number
     */
    public static int getPositiveNumber() {
        int number;
        do {
            System.out.print("Enter a positive number (>0): ");
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a positive number: ");
                scanner.next();
            }
            number = scanner.nextInt();
        } while (number <= 0);
        return number;
    }
    /*
     * Effect: Shows login main manager menu, initiates logging in
     */
    public static void loginMainManager() {
        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();
        for (Manager m : ourSystem.getManagers()) {
            if (m instanceof MainManager ) {
            	MainManager mm = (MainManager) m;
                if (mm.getUserName().equals(user) && mm.getPassword().equals(pass)) {
                    System.out.println("Welcome Main Manager " + mm.getFirstName());
                    mainManagerMenu();
                }
            }
        }
        System.out.println("Login failed.");
    }
    /*
     * Effect: Shows main manager menu
     */
    public static void mainManagerMenu() {
        while (true) {
            System.out.println("\n--- Main Manager Menu ---");
            System.out.println("1. Add Subscriber");
            System.out.println("2. Add Manager");
            System.out.println("3. Add Taxi");
            System.out.println("4. Assign Taxi to Manager");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                addSubscriber();
            } else if (choice.equals("2")) {
                addManager();
            } else if (choice.equals("3")) {
                addTaxi();
            } else if (choice.equals("4")) {
                assignTaxiToManager();
            } else if (choice.equals("0")) {
                return;
            } else {
                System.out.println("Invalid option.");
            }

        }
    }
    /*
     * Effect: Getting subscriber values from user, adds it to our DataBase *********************************FIX*******************************
     */
    public static void addSubscriber() 
    {
        System.out.print("ID: "); String id = scanner.nextLine();
        System.out.print("First name: "); String fn = scanner.nextLine();
        System.out.print("Last name: "); String ln = scanner.nextLine();
        System.out.print("Phone: "); String phone = scanner.nextLine();
        System.out.print("Address: "); String addr = scanner.nextLine();

        Subscription newSub = new Subscription(id, fn, ln, phone, addr);
        boolean added = ourSystem.addSubscription(newSub);

        if(added) 
        {
        	System.out.println("Subscriber added.");
        }
        else System.out.println("Failed to add subscriber .");
        mainManagerMenu();
    }
    /*
     * Effect: Getting manager values form user, adds it to our DataBase *********************************Fix***********************************
     */
    public static void addManager() {
        System.out.println("Type: 1. Regular  2. Main");
        int type = scanner.nextInt(); scanner.nextLine();

        System.out.print("ID: "); String id = scanner.nextLine();
        System.out.print("First name: "); String fn = scanner.nextLine();
        System.out.print("Last name: "); String ln = scanner.nextLine();
        System.out.print("Phone: "); String phone = scanner.nextLine();
        System.out.print("Address: "); String addr = scanner.nextLine();

        Manager manager;
        if (type == 1) 
        {
        	manager = new Manager(id, fn, ln, phone, addr);
        } 
        else 
        {
            System.out.print("Username: "); String un = scanner.nextLine();
            System.out.print("Password: "); String pw = scanner.nextLine();
        	manager = new MainManager(id, fn, ln, phone, addr, un, pw);

        }
        boolean added = ourSystem.addMainManager(manager);       // addManager(Manager)

        if(added ) {
        	System.out.println("Manager added.");
    }
        
        else System.out.println("Failed to add manager!");
        return;    }
    /*
     * Effect: Getting Taxi values form user, adds it to our DataBase *********************************Fix***********************************
     */
    public static void addTaxi() {
        System.out.println("Type: 1. Regular 2. Express 3. InterCity");
        String type = scanner.nextLine(); 
        System.out.print("Code: "); String code = scanner.nextLine();
        System.out.print("Available (true/false): "); boolean avail = scanner.nextBoolean();
        System.out.print("Min price: "); double price = getValidPrice();
        scanner.nextLine();

        boolean added=false;

        if (type.equals("1")) {
            added = ourSystem.addTaxi(new Taxi(code, avail, price)) ;
        } else if (type.equals("2")) {
            System.out.print("City Taxi (true/false): "); boolean city = scanner.nextBoolean();
            System.out.print("Extra Price: "); double extra = getValidPrice();
            scanner.nextLine();
            added = ourSystem.addTaxi(new ExpressTaxi(code, avail, price, city, extra));
        } else if (type.equals("3")) {
            System.out.print("Number of cities: "); int n = scanner.nextInt(); scanner.nextLine();
            String[] cities = new String[n];
            for (int j = 0; j < n; j++) {
                System.out.print("City " + (j+1) + ": ");
                cities[j] = scanner.nextLine();
            }
            System.out.print("Extra price: "); double extra =getValidPrice();
            System.out.print("Max hours: "); int hours = getPositiveNumber();
            scanner.nextLine();
            added = ourSystem.addTaxi(new IntercityTaxi(code, avail, price, cities, extra, hours));
        }
       if(added) {
    	   System.out.println("Taxi added.");

       }
    
        
       else System.out.println("failed to add Taxi");
       return;
    }
    /*
     * Effect: Getting a taxi code and manager's ID, adds taxi to manager's taxi list if legal ****************************Fix*****************************
     */
    public static void assignTaxiToManager() {
        System.out.print("Taxi code: ");
        String taxiCode = scanner.nextLine();
        System.out.print("Manager ID: ");
        String managerId = scanner.nextLine();
        Taxi taxi = null;
        for (Taxi t : ourSystem.getTaxis()) {
            if (t != null && t.getTaxiCode().equals(taxiCode)) {
                taxi = t;
                break;
            }
        }
        if (taxi == null) {
            System.out.println("Taxi not found.");
            return;
        }
        boolean m2=false;
        for (Manager m : ourSystem.getManagers()) {
            if (m != null && m.getId().equals(managerId)) {
            	m.addTaxi(taxi);
                System.out.println("Taxi " + taxiCode + " assigned to Manager " + m.getFirstName());
                m2=true;
            }
        }
        if(!m2)  System.out.println("Manager not found.");
        return;
    }
    
   /*
    * Effect: Getting manager's ID, if manager exist, shows regular manager's menu *****************************Fix*******************************
    */
    public static void loginManager() {
        System.out.print("Manager ID: ");
        String id = scanner.nextLine();
        boolean founded = false;
        for (Manager m : ourSystem.getManagers()) {
            if (!(m instanceof MainManager) && m.getId().equals(id)) {
                System.out.println("Hello Manager " + m.getFirstName());
                founded=true;
                managerMenu(m);
            }
        }
       if(!founded) System.out.println("Manager not found.");
        return;
        
    }
    /*
     * Effect: Shows regular manager's menu
     */
    public static void managerMenu(Manager manager) {
        while (true) {
            System.out.println("\n--- Manager Menu ---");
            System.out.println("1. Add Order");
            System.out.println("2. Change Taxi in Order");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" : addOrder(manager);
                case "2" : changeTaxiInOrder(manager);
                case "0" : { return;}
                default : System.out.println("Invalid option.");
            }
        }
    }

   
    /*
     * Effect: Getting order values from user, if legal, adds order to DataBase *************************************Fix*************************************
     */
    public static void addOrder(Manager manager) {
    	System.out.print("Order ID: ");
        String orderId = scanner.nextLine();
        System.out.print("Subscriber ID: ");
        String subId = scanner.nextLine();
        System.out.print("Taxi Code: ");
        String taxiCode = scanner.nextLine();

        Subscription sub = null;
        for (Subscription s : ourSystem.getSubscriptions()) {
            if (s != null && s.getSubCode().equals(subId)) {
                sub = s;
                break;
            }
        }

        Taxi taxi = null;
        for (Taxi t : ourSystem.getTaxis()) {
            if (t != null && t.getTaxiCode().equals(taxiCode)) {
                taxi = t;
                break;
            }
        }

        if (sub == null || taxi == null) {
            System.out.println("Subscriber or Taxi not found.");
            return;
        }

        if (!taxi.isAvailable()) {
            System.out.println("Taxi is not available.");
            return;
        }

        System.out.print("Day: ");
        int day = getValidDay();
        System.out.print("Month: ");
        int month = getValidMonth();
        System.out.print("Hour: ");
        int hour = getValidHour();
        scanner.nextLine();

        orders[orderCount] = new Order(orderId,manager.getId(), day, month, hour,subId ,taxi, taxi.getMinPrice());
        orderCount++;
        taxi.setAvailable(false);
        System.out.println("Order added.");
        managerMenu(manager);
    }

    /*
     * Effect: Getting existing order's number, changing taxi if legal *********************Fix**********************
     */
    public static void changeTaxiInOrder(Manager manager) {
    	if(orderCount==0) {
            System.out.print("There are no orders yet!");
            managerMenu(manager);

    	}
        System.out.print("Orders codes : ");
        for(int i=0 ; i<orderCount ; i++)
        	System.out.print(orders[i].getOrderNum()+" , ");
        System.out.println();
        System.out.print("Enter order's code that  you want to change : ");

        String num = scanner.nextLine();
        Order o = null;

        for(int i=0 ; i<orderCount ; i++) {
        	if(orders[i].getOrderNum().equals(num))
        		 o = orders[i];
        }
        if (o==null) {
            System.out.println("Invalid order number.");
            return;
        }

        Taxi oldTaxi = null;
        for (Taxi t : ourSystem.getTaxis()) {
            if (t != null && t.getTaxiCode().equals(o.getTaxi().getTaxiCode())) {
                oldTaxi = t;
                break;
            }
        }

        if (oldTaxi == null || !(oldTaxi instanceof Taxi)) {
            System.out.println("Original taxi is not regular. Cannot change.");
            return;
        }

        System.out.print("New Taxi Code: ");
        String newCode = scanner.nextLine();

        Taxi newTaxi = null;
        for (Taxi t : ourSystem.getTaxis()) {
            if (t != null && t.getTaxiCode().equals(newCode) && t.isAvailable()) {
                newTaxi = t;
                break;
            }
        }

        if (newTaxi == null) {
            System.out.println("New Taxi not found or not available.");
            return;
        }

        o.setTaxi(newTaxi);
        o.setOrderPrice(newTaxi.getMinPrice());
        oldTaxi.setAvailable(true);
        newTaxi.setAvailable(false);
        System.out.println("Taxi changed in order.");
        managerMenu(manager);
    }
    /*
     * Effect: Getting subscriber ID from user, if legal, logging in *****************************Fix*****************************
     */
    public static void loginSubscriber() {
        System.out.print("Subscriber ID: ");
        String id = scanner.nextLine();
        Subscription sub = null;
        for (Subscription s : ourSystem.getSubscriptions()) {
            if (s != null && s.getSubCode().equals(id)) {
                sub = s;
                break;
            }
        }
        if (sub != null) {
            System.out.println("Hello Subscriber " + sub.getFirstName());
            subscriberMenu(sub);
        } else {
            System.out.println("Subscriber not found.");
        }
    }
    /*
     * Effect: Shows subscriber's menu
     */
    public static void subscriberMenu(Subscription sub) {
        while (true) {
            System.out.println("\n--- Subscriber Menu ---");
            System.out.println("1. Print My Orders");
            System.out.println("2. Update Personal Details");
            System.out.println("3. Show Taxi Details");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" : {
                	printSubscriberOrders(sub);
                	break;
                }
                case "2" :{
                	updateSubscriberDetails(sub);
                	break;
                }
                case "3" :{
                	showTaxiDetails(sub);
                	break;
                }
                case "0" : {
                	return;
                }
                default : System.out.println("Invalid option.");
            }
        }
    }
    /*
     * Effect: Prints all orders by subscriber   ******************************Fix****************************
     */
    public static void printSubscriberOrders(Subscription sub) {
        boolean found = false;
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].getSubCode().equals(sub.getSubCode())) {
                System.out.println(orders[i]);
                for (Taxi t : ourSystem.getTaxis()) {
                    if (t != null && t.getTaxiCode().equals(orders[i].getTaxi().getTaxiCode())) {
                        System.out.println("Taxi Details: " + t);
                    }
                }
                found = true;
            }
        }
        if (!found) {
            System.out.println("No orders found for this subscriber.");
            return;
        }
    }
    /*
     * Effect: Updates subscriber's details according user requests
     */
    public static void updateSubscriberDetails(Subscription sub) {
        System.out.print("New Phone: ");
        String phone = scanner.nextLine();
        System.out.print("New Address: ");
        String address = scanner.nextLine();
        sub.setPhone(phone);
        sub.setAddress(address);
        System.out.println("Details updated.");
        return;
    }
    /*
     * Effect: Getting a taxi code from user, if found, showing taxi details *************************Fix***************************
     */
    public  static void showTaxiDetails(Subscription sub) {
        System.out.print("Taxi Code: ");
        boolean founded=false;
        String taxiCode = scanner.nextLine();
        for (Taxi t : ourSystem.getTaxis()) {
            if (t != null && t.getTaxiCode().equals(taxiCode)) {
            	founded=true;
                System.out.println(t);
               
            }
        }
        if(!founded) System.out.println("Taxi not found.");
        return;
        
    }
    /*
     * Showing all taxies???????!!!!!!!!!!! ********************Fix**************************
     */
    public  static void displayAllTaxis() {
        System.out.println("\n--- All Taxis ---");
        for (Taxi t : ourSystem.getTaxis()) {
            System.out.println(t);
        }
    }

}
