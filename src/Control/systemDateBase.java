package Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import Model.Manager; 
import Model.MainManager;
import Model.Order;
import Model.Taxi;
import Model.Station;
import Model.ExpressTaxi;
import Model.Subscription;


public class systemDateBase {

    private MainManager Administrator; // The Administrator of the program - user name "system", password "12345" - initilized in constructors
    private ArrayList<MainManager> allMainManagers; // Array list of all Main Managers
    private ArrayList<Taxi> allTaxies; // Array list of all taxies
    private Hashtable<String, ArrayList<Taxi>> allOrdersHashtable; // Hashtable of all orders, key - subCode (String), value ArrayList<Taxi>
    private ArrayList<Station> allStations; // Array list of all stations
    private ArrayList<Order> allOrders; // Array list of all orders
    private ArrayList<Subscription> allSubscribers; // Array list of all subscribers
    private HashMap<String,ArrayList<Order>> allOrderHashMap; // HashMap of all orders, key - subCode (String), value ArrayList<Order>

    //Constructors
    public systemDateBase(ArrayList<MainManager> allMainManagers, ArrayList<Taxi> allTaxies,
            Hashtable<String, ArrayList<Taxi>> allOrdersHashtable, ArrayList<Station> allStations,
            ArrayList<Order> allOrders, ArrayList<Subscription> allSubscribers,
            HashMap<String, ArrayList<Order>> allOrderHashMap) {
        this.Administrator.setUserName("system");
        this.Administrator.setPassword("12345");
        this.allMainManagers = new ArrayList<>();
        this.allTaxies = new ArrayList<>();
        this.allOrdersHashtable = new Hashtable<>();
        this.allStations = new ArrayList<>();
        this.allOrders = new ArrayList<>();
        this.allSubscribers = new ArrayList<>();
        this.allOrderHashMap = new HashMap<>();
    }

    public systemDateBase(){
        this.Administrator.setUserName("system");
        this.Administrator.setPassword("12345");
        this.allMainManagers = new ArrayList<>();
        this.allTaxies = new ArrayList<>();
        this.allOrdersHashtable = new Hashtable<>();
        this.allStations = new ArrayList<>();
        this.allOrders = new ArrayList<>();
        this.allSubscribers = new ArrayList<>();
        this.allOrderHashMap = new HashMap<>();
    }
    /*
     * Input: A new Subscriber
     * Effect: If its a new subscriber and Subscriber is legal, adds it to array list of subscribers
     * Output: True if added succesfully, false otherwise
     */
    public boolean addSubscription(Subscription newSubscription){
        if(newSubscription == null){
            System.out.println("Enter none null value");
            return false;
        }
        if(allSubscribers.contains(newSubscription)){
            System.out.println("Subscriber already exists");
            return false;
        }
        allSubscribers.add(newSubscription);
        System.err.println("Subscriber added succesfully");
        return true;
    }

    /*
     * Input: A subscriber to remove
     * Effect: If legal, removes subscriber from arraylist of subscribers
     * Output: True if removed succesfully, false otherwise
     */
	public boolean removeSubscription(Subscription subscriptionToremove){
        if(subscriptionToremove == null){
            System.out.println("Can not remove null value");
            return false;
        }
        if(!allSubscribers.contains(subscriptionToremove)){
            System.out.println("Failure - Subscriber is not in our system");
            return false;
        }
        int subIndex = allSubscribers.indexOf(subscriptionToremove);
        allSubscribers.remove(subIndex);
        System.out.println("Subscriber removed succesfully");
        return true;
    }

    /*
     * Input: A new Main manager
     * Effect: If its a new Main manager and Main manager is legal, adds it to array list of Main managers
     * Output: True if added succesfully, false otherwise
     */
    public boolean addMainManager(MainManager newMainManager){
        if(newMainManager == null){
            System.out.println("Enter none null value");
            return false;
        }
        if(allMainManagers.contains(newMainManager)){
            System.out.println("Main manager already exists");
            return false;
        }
        allMainManagers.add(newMainManager);
        System.out.println("Main manager added succesfully");
        return true;
    }
    /*
     * Input: A main manager to remove
     * Effect: If legal, removes main manager from arraylist of main managers
     * Output: True if removed succesfully, false otherwise
     */
	public boolean removeMainManager(MainManager mainManagerToRemove){
        if(mainManagerToRemove == null){
            System.out.println("Can not remove null value");
            return false;
        }
        if(!allMainManagers.contains(mainManagerToRemove)){
            System.out.println("Failure - Main manager is not in our system");
            return false;
        }
        int MMIndex = allMainManagers.indexOf(mainManagerToRemove);
        allMainManagers.remove(MMIndex);
        System.out.println("Main manager removed succesfully");
        return true;
    }

    /*
     * Input: A new Taxi
     * Effect: If its a new Taxi and Taxi is legal, adds it to array list of taxies
     * Output: True if added succesfully, false otherwise
     */
    public boolean addTaxi(Taxi newTaxi){
        if(newTaxi == null){
            System.out.println("Enter none null value");
            return false;
        }
        if(allTaxies.contains(newTaxi)){
            System.out.println("Taxi already exists");
            return false;
        }
        allTaxies.add(newTaxi);
        System.out.println("Taxi added succesfully");
        return true;
    }

    /*
     * Input: A Taxi to remove
     * Effect: If legal, removes taxi from array list of taxies
     * Output: True if removed succesfully, false otherwise
     */
	public boolean removeTaxi(Taxi taxiToRemove){
        if(taxiToRemove == null){
            System.out.println("Can not remove null value");
            return false;
        }
        if(!allTaxies.contains(taxiToRemove)){
            System.out.println("Failure - taxi is not in our system");
            return false;
        }
        int taxiIndex = allTaxies.indexOf(taxiToRemove);
        allTaxies.remove(taxiIndex);
        System.out.println("Taxi removed succesfully");
        return true;
    }

    /*
     * Input: A new Station
     * Effect: If its a new station and station is legal, adds it to array list of stations
     * Output: True if added succesfully, false otherwise
     */
    public boolean addStation(Station newStation){
        if(newStation == null){
            System.out.println("Enter none null value");
            return false;
        }
        if(allStations.contains(newStation)){
            System.out.println("Station already exists");
            return false;
        }
        allStations.add(newStation);
        System.out.println("Station added succesfully");
        return true;
    }

    /*
     * Input: A station to remove
     * Effect: If legal, removes station from array list of stations
     * Output: True if removed succesfully, false otherwise
     */
	public boolean removeStation(Station stationToRemove){
        if(stationToRemove == null){
            System.out.println("Can not remove null value");
            return false;
        }
        if(!allStations.contains(stationToRemove)){
            System.out.println("Failure - Station is not in our system");
            return false;
        }
        int stationIndex = allStations.indexOf(stationToRemove);
        allStations.remove(stationIndex);
        System.out.println("Station removed succesfully");
        return true;
    }

    /*
     * Input: A new Order
     * Effect: If its a new order and order is legal, adds it to array list of orders
     * Output: True if added succesfully, false otherwise
     */
    public boolean addOrder(Order newOrder){
        if(newOrder == null){
            System.out.println("Enter none null value");
            return false;
        }
        if(allOrders.contains(newOrder)){
            System.out.println("Order already exists");
            return false;
        }
        allOrders.add(newOrder);
        System.out.println("Order added succesfully");
        return true;
    }
    /*
     * Input: An Order to remove
     * Effect: If legal, removes order from array list of orders
     * Output: True if removed succesfully, false otherwise
     */
	public boolean removeOrder(Order orderToRemove){
        if(orderToRemove == null){
            System.out.println("Can not remove null value");
            return false;
        }
        if(!allOrders.contains(orderToRemove)){
            System.out.println("Failure - Order is not in our system");
            return false;
        }
        int orderIndex = allOrders.indexOf(orderToRemove);
        allOrders.remove(orderIndex);
        System.out.println("Order removed succesfully");
        return true;
    }
    /*
     * Input: A subscriber code, an order from this subscriber
     * Effect: If legal, adds order to HashMap of orders by codes
     * Output: True if addes succesfully, false otherwise
     */
    public boolean addOrderByCode(String subCode, Order newOrder){
        if(subCode == null || newOrder == null){
            System.out.println("Enter non null values");
            return false;
        }
        if(allOrders.contains(newOrder)){
            System.out.println("Order already exists");
            return false;
        }
        if(!this.allOrderHashMap.containsKey(subCode)){// If key does not exist in HashMap
            this.allOrderHashMap.put(subCode, new ArrayList<>());
            ArrayList<Order> newSubOrders = this.allOrderHashMap.get(subCode);
            newSubOrders.add(newOrder); // Add order to HashMap
            allOrders.add(newOrder); // Add order to all Orders
            System.out.println("Subscriber and Order added succesfully");
            return true;
        }
        ArrayList<Order> existingSubOrders = this.allOrderHashMap.get(subCode);
        existingSubOrders.add(newOrder);
        allOrders.add(newOrder); // Add order to all Orders
        System.out.println("Order added succesfully to Subscriber order list");
        return true;
        } 



    /* 
    Input: station (Station) – the station to query
    Output: ArrayList<String> containing codes of all available taxis in that station
    */

    public ArrayList<String> listAvailableTaxiCodesInStation(Station station)
    {
            ArrayList<String> result = new ArrayList<>();
            if (station == null) 
            {
                    System.out.println("Station cannot be null");
                    return result ;
            }
            for (Taxi taxi : station.getTaxis()) 
            {
            if (taxi.isAvailable()) 
                {
                    result.add(taxi.getTaxiCode());
                }
            }
            return result;
    }

    /* Input: sub (Subscription) – the subscriber whose orders are examined
    Output: ArrayList<ExpressTaxi> containing every ExpressTaxi ordered by that subscriber 
    */

    public ArrayList<ExpressTaxi> getExpressTaxisBySubscriber(Subscription sub)

    {
    ArrayList<ExpressTaxi> expressList = new ArrayList<>();
    
        if (sub == null) 
        {
            System.out.println("Subscriber cannot be null");
            return expressList;
        }

        String code = sub.getSubCode();
        ArrayList<Taxi> ordered = allOrdersHashtable.get(code); 

        if(ordered == null)
        {
            return expressList;
        }

        for (Taxi taxi : ordered) 
        {
            if (taxi instanceof ExpressTaxi) 
            {
                expressList.add((ExpressTaxi) taxi);
            }
        }
        return expressList;

    }
    public ArrayList<Subscription> getSubscriptions() {
    return allSubscribers;
    }
    public ArrayList<Taxi> getTaxis() {
        return allTaxies;
    }

    } 





    



    

    

