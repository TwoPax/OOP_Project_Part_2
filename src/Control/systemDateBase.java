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
	 public boolean removeSubscription(String subIdToRemove){
        if(subIdToRemove == null)
            return false;

        boolean subscriberFoundAndRemoved = false;
        // Remove from allSubscribers
        for (int i = 0; i < allSubscribers.size(); i++) {
            if (allSubscribers.get(i).getSubCode().equals(subIdToRemove)) {
                allSubscribers.remove(i);
                subscriberFoundAndRemoved = true;
                break;
            }
        }
        if (subscriberFoundAndRemoved) {
        //  Remove all associated orders from allOrders (main ArrayList)
        for (int i = allOrders.size() - 1; i >= 0; i--) 
        {
                if (allOrders.get(i).getSubCode().equals(subIdToRemove)) 
                {
                    allOrders.remove(i);
                }
        }
        // 3. Remove entry from allOrderHashMap
            allOrderHashMap.remove(subIdToRemove);

            // 4. Remove entry from allOrdersHashtable
            allOrdersHashtable.remove(subIdToRemove);

            return true;
        }

        return false; // Subscriber not found
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
     * Input: The ID of a manager to remove
     * Effect: If legal, removes manager from arraylist of managers
     * Output: True if removed succesfully, false otherwise
     */
    public boolean removeManager(String managerIdToRemove){
        if(managerIdToRemove == null)
            return false;

        if (Administrator != null && Administrator.getId() != null && Administrator.getId().equals(managerIdToRemove)) {
            System.out.println("Cannot remove the Main Administrator.");
            return false;
        }

        for (int i = 0; i < allManagers.size(); i++) {
            if (allManagers.get(i).getId().equals(managerIdToRemove)) {
                allManagers.remove(i);
                return true;
            }
        }
        return false; // Manager not found
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
     * Input: The code of a taxi to remove
     * Effect: If legal, removes taxi from array list of taxies
     * Output: True if removed succesfully, false otherwise
     */
    public boolean removeTaxi(String taxiCodeToRemove){
        if(taxiCodeToRemove == null)
            return false;

        boolean taxiFoundAndRemoved = false;
        // 1. Remove from allTaxies
        for (int i = 0; i < allTaxies.size(); i++) {
            if (allTaxies.get(i).getTaxiCode().equals(taxiCodeToRemove)) {
                allTaxies.remove(i);
                taxiFoundAndRemoved = true;
                break; 
            }
        }

        if (taxiFoundAndRemoved) {
            //  Remove the taxi from any station it might be in
            for (Station station : allStations) {
                ArrayList<Taxi> stationTaxis = station.getTaxis();
                for (int i = stationTaxis.size() - 1; i >= 0; i--) {
                    if (stationTaxis.get(i).getTaxiCode().equals(taxiCodeToRemove)) {
                        stationTaxis.remove(i);
                    }
                }
            }
            return true;
        }
        return false; // Taxi not found
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

        if(allOrders.contains(newOrder)) // Assumes Order has proper equals()
            return false;

        allOrders.add(newOrder);

        // Add to the HashMap for subscriber-specific orders
        String subCode = newOrder.getSubCode();

        if (allOrderHashMap.containsKey(subCode)) {
            allOrderHashMap.get(subCode).add(newOrder);
        } else {
            ArrayList<Order> newSubOrdersList = new ArrayList<>();
            newSubOrdersList.add(newOrder);
            allOrderHashMap.put(subCode, newSubOrdersList);
        }

        // Also add to the Hashtable for subscriber-specific taxis
        if (newOrder.getTaxi() != null) { 
            if (allOrdersHashtable.containsKey(subCode)) {
                allOrdersHashtable.get(subCode).add(newOrder.getTaxi());
            } else {
                ArrayList<Taxi> newSubTaxisList = new ArrayList<>();
                newSubTaxisList.add(newOrder.getTaxi()); 
                allOrdersHashtable.put(subCode, newSubTaxisList);
            }
        }
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

        boolean removedFromAllOrdersList = allOrders.remove(orderToRemove);

        if (removedFromAllOrdersList) {
            // Remove from allOrderHashMap
            String subCode = orderToRemove.getSubCode();
            if (subCode != null && allOrderHashMap.containsKey(subCode)) {
                ArrayList<Order> subOrders = allOrderHashMap.get(subCode);
                if (subOrders != null) {
                    subOrders.remove(orderToRemove);
                    if (subOrders.isEmpty()) {
                        allOrderHashMap.remove(subCode); 
                    }
                }
            }

            // Remove associated taxi from allOrdersHashtable 
            if (orderToRemove.getTaxi() != null && subCode != null && allOrdersHashtable.containsKey(subCode)) {
                ArrayList<Taxi> subTaxis = allOrdersHashtable.get(subCode);
                if (subTaxis != null) {
                    subTaxis.remove(orderToRemove.getTaxi()); 
                    if (subTaxis.isEmpty()) {
                        allOrdersHashtable.remove(subCode);
                    }
                }
            }
            return true;
        }
        return false; // Order not found in main list
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





    



    

    
