package Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import Model.*;



public class systemDateBase {

    private MainManager Administrator = new MainManager(); // The Administrator of the program - user name "system", password "12345" name "Admin" - initilized in constructor
    private ArrayList<Manager> allManagers; // Array list of all Managers
    private ArrayList<Taxi> allTaxies; // Array list of all taxies
    private Hashtable<String, ArrayList<Taxi>> allOrdersHashtable; // Hashtable of all orders, key - subCode (String), value ArrayList<Taxi>
    private ArrayList<Station> allStations; // Array list of all stations
    private ArrayList<Order> allOrders; // Array list of all orders
    private ArrayList<Subscription> allSubscribers; // Array list of all subscribers
    private HashMap<String,ArrayList<Order>> allOrderHashMap; // HashMap of all orders, key - subCode (String), value ArrayList<Order>

    //Constructor - Assigning userName and password for Administrator and setting all lists to be size 0
    public systemDateBase(){
        this.allManagers = new ArrayList<>();
        this.Administrator.setFirstName("Admin");
        this.Administrator.setUserName("system");
        this.Administrator.setPassword("12345");
        this.allManagers.add(Administrator);//Adding Administrator to list of all main managers
        this.allTaxies = new ArrayList<>();
        this.allOrdersHashtable = new Hashtable<>();
        this.allStations = new ArrayList<>();
        this.allOrders = new ArrayList<>();
        this.allSubscribers = new ArrayList<>();
        this.allOrderHashMap = new HashMap<>();
    }

    //Getters
    public MainManager getAdministrator() {
        return Administrator;
    }

    public ArrayList<Manager> getAllManagers() {
        return allManagers;
    }

    public ArrayList<Taxi> getAllTaxies() {
        return allTaxies;
    }

    public Hashtable<String, ArrayList<Taxi>> getAllOrdersHashtable() {
        return allOrdersHashtable;
    }

    public ArrayList<Station> getAllStations() {
        return allStations;
    }

    public ArrayList<Order> getAllOrders() {
        return allOrders;
    }

    public ArrayList<Subscription> getAllSubscribers() {
        return allSubscribers;
    }

  public ArrayList<Order> getOrdersOfSubscriber(String code) {
    
    return allOrderHashMap.getOrDefault(code, new ArrayList<>());
  }
    public HashMap<String, ArrayList<Order>> getAllOrderHashMap() {
        return allOrderHashMap;
    }
    

    /*
     * Input: A new Subscriber
     * Effect: If its a new subscriber and Subscriber is legal, adds it to array list of subscribers
     * Output: True if added succesfully, false otherwise
     */
    public boolean addSubscription(Subscription newSubscription){
        if(newSubscription == null)
            return false;
        
        if(allSubscribers.contains(newSubscription))
            return false;
            
        allSubscribers.add(newSubscription);
        return true;
    }

    /*
     * Input: A subscriber to remove
     * Effect: If legal, removes subscriber from arraylist of subscribers
     * Output: True if removed succesfully, false otherwise
     */
	public boolean removeSubscription(Subscription subscriptionToremove){
        if(subscriptionToremove == null)
            return false;
        
        if(!allSubscribers.contains(subscriptionToremove))
            return false;
        
        int subIndex = allSubscribers.indexOf(subscriptionToremove);
        allSubscribers.remove(subIndex);
        return true;
    }

    /*
     * Input: A new manager
     * Effect: If its a new  manager and  manager is legal, adds it to array list of  managers
     * Output: True if added succesfully, false otherwise
     */
    public boolean addManager(Manager newManager){
        if(newManager == null)
            return false;
        
        if(allManagers.contains(newManager))
            return false;
        
        allManagers.add(newManager);
        return true;
    }
    /*
     * Input: A manager to remove
     * Effect: If legal, removes manager from arraylist of managers
     * Output: True if removed succesfully, false otherwise
     */
	public boolean removeManager(Manager ManagerToRemove){

        if(ManagerToRemove == null)
            return false;
        
        if(!allManagers.contains(ManagerToRemove))
            return false;
        
        int MIndex = allManagers.indexOf(ManagerToRemove);
        allManagers.remove(MIndex);
        return true;
    }


    /*
     * Input: A new Taxi
     * Effect: If its a new Taxi and Taxi is legal, adds it to array list of taxies
     * Output: True if added succesfully, false otherwise
     */
    public boolean addTaxi(Taxi newTaxi){
        if(newTaxi == null)
            return false;
        
        if(allTaxies.contains(newTaxi))
            return false;
        
        allTaxies.add(newTaxi);
        return true;
    }

    /*
     * Input: A Taxi to remove
     * Effect: If legal, removes taxi from array list of taxies
     * Output: True if removed succesfully, false otherwise
     */
	public boolean removeTaxi(Taxi taxiToRemove){
        if(taxiToRemove == null)
            return false;
        
        if(!allTaxies.contains(taxiToRemove))
            return false;
        
        int taxiIndex = allTaxies.indexOf(taxiToRemove);
        allTaxies.remove(taxiIndex);
        return true;
    }

    /*
     * Input: A new Station
     * Effect: If its a new station and station is legal, adds it to array list of stations
     * Output: True if added succesfully, false otherwise
     */
    public boolean addStation(Station newStation){
        if(newStation == null)
            return false;
        
        if(allStations.contains(newStation))
            return false;
        
        allStations.add(newStation);
        return true;
    }

    /*
     * Input: A station to remove
     * Effect: If legal, removes station from array list of stations
     * Output: True if removed succesfully, false otherwise
     */
	public boolean removeStation(Station stationToRemove){
        if(stationToRemove == null)
            return false;
        
        if(!allStations.contains(stationToRemove))
            return false;
        
        int stationIndex = allStations.indexOf(stationToRemove);
        allStations.remove(stationIndex);
        return true;
    }

    /*
     * Input: A new Order
     * Effect: If its a new order and order is legal, adds it to array list of orders
     * Output: True if added succesfully, false otherwise
     */
    public boolean addOrder(Order newOrder){
        if(newOrder == null)
            return false;
        
        if(allOrders.contains(newOrder))
            return false;
        
        allOrders.add(newOrder);
        return true;
    }
    /*
     * Input: An Order to remove
     * Effect: If legal, removes order from array list of orders
     * Output: True if removed succesfully, false otherwise
     */
	public boolean removeOrder(Order orderToRemove){
        if(orderToRemove == null)
            return false;
        
        if(!allOrders.contains(orderToRemove))
            return false;
        
        int orderIndex = allOrders.indexOf(orderToRemove);
        allOrders.remove(orderIndex);
        return true;
    }
    /*
     * Input: A subscriber code, an order from this subscriber
     * Effect: If legal, adds order to HashMap of orders by codes
     * Output: True if addes succesfully, false otherwise
     */
    public boolean addOrderByCode(String subCode, Order newOrder){
        if(subCode == null || newOrder == null)
            return false;
        
        if(allOrders.contains(newOrder))
            return false;
        
        if(!this.allOrderHashMap.containsKey(subCode)){// If key does not exist in HashMap
            this.allOrderHashMap.put(subCode, new ArrayList<>());
            ArrayList<Order> newSubOrders = this.allOrderHashMap.get(subCode);
            newSubOrders.add(newOrder); // Add order to HashMap
            allOrders.add(newOrder); // Add order to all Orders
            return true;
        }
        ArrayList<Order> existingSubOrders = this.allOrderHashMap.get(subCode);
        existingSubOrders.add(newOrder);
        allOrders.add(newOrder); // Add order to all Orders
        return true;
        } 



    /* 
    * Input: station (Station) – the station to query
    * Output: ArrayList<String> containing codes of all available taxies in that station
    */
    public ArrayList<String> listAvailableTaxiCodesInStation(Station station)
    {
            ArrayList<String> result = new ArrayList<>();
            if (station == null) 
            {
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

    /*
     * Input: sub (Subscription) – the subscriber whose orders are examined
     * Output: ArrayList<ExpressTaxi> containing every ExpressTaxi ordered by that subscriber 
     */
    public ArrayList<ExpressTaxi> getExpressTaxisBySubscriber(Subscription sub)

    {
    ArrayList<ExpressTaxi> expressList = new ArrayList<>();
    
        if (sub == null) 
        {
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
    } 





    



    

    