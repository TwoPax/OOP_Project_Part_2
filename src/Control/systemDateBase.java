package Control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Objects; 
import Model.*;

public class systemDateBase {

    private MainManager Administrator = new MainManager(); // The Administrator of the program - user name "system", password "12345" name "Admin" - initilized in constructor
    private ArrayList<Manager> allManagers; // Array list of all Managers
    private ArrayList<Taxi> allTaxies; // Array list of all taxies
    private Hashtable<String, ArrayList<Taxi>> allTaxiesHashtable; // Hashtable of all taxies by subCode, key - subCode (String), value ArrayList<Taxi>
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
        this.allTaxiesHashtable = new Hashtable<>(); 
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

    public Hashtable<String, ArrayList<Taxi>> getAllTaxiesHashtable() {
        return allTaxiesHashtable;
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
     * Effect: If legal, removes subscriber from arraylist of subscribers and orders and from HashMap and HashTable of orders
     * Output: True if removed succesfully, false otherwise
     */
    public boolean removeSubscription(String subIdToRemove){
        if(subIdToRemove == null)
            return false;

        boolean subscriberFoundAndRemoved = false;
        // Remove from allSubscribers
        for (int i = 0; i < allSubscribers.size(); i++) {
            if (Objects.equals(allSubscribers.get(i).getSubCode(), subIdToRemove)) {
                allSubscribers.remove(i);
                subscriberFoundAndRemoved = true;
                break;
            }
        }
        if (subscriberFoundAndRemoved) {
            for (int i = allOrders.size() - 1; i >= 0; i--) {
                if (Objects.equals(allOrders.get(i).getSubCode(), subIdToRemove)) {
                    allOrders.remove(i);
                }
            }
            // Remove from allOrderHashMap
            allOrderHashMap.remove(subIdToRemove);

            // Remove from allTaxiesHashtable
            allTaxiesHashtable.remove(subIdToRemove);

            return true;
        }

        return false;
    }
    /*
     * Input: A new manager
     * Effect: If its a new  manager and manager is legal, adds it to array list of  managers
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
     * Effect: If legal, removes manager from arraylist of managers - Cannot remove admin
     * Output: True if removed succesfully, false otherwise
     */
    public boolean removeManager(String managerIdToRemove){
        if(managerIdToRemove == null)
            return false;

        if (Administrator != null && Objects.equals(Administrator.getId(), managerIdToRemove)) {
            System.out.println("Cannot remove the Main Administrator.");
            return false;
        }

        for (int i = 0; i < allManagers.size(); i++) {
            if (Objects.equals(allManagers.get(i).getId(), managerIdToRemove)) {
                allManagers.remove(i);
                return true;
            }
        }
        return false;
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
        for (int i = 0; i < allTaxies.size(); i++) {
            if (Objects.equals(allTaxies.get(i).getTaxiCode(), taxiCodeToRemove)) {
                allTaxies.remove(i);
                taxiFoundAndRemoved = true;
                break;
            }
        }

        if (taxiFoundAndRemoved) {
            for (Station station : allStations) {
                ArrayList<Taxi> stationTaxies = station.getTaxis();
                if (stationTaxies != null) {
                    for (int i = stationTaxies.size() - 1; i >= 0; i--) {
                        if (Objects.equals(stationTaxies.get(i).getTaxiCode(), taxiCodeToRemove)) {
                            stationTaxies.remove(i);
                        }
                    }
                }
            }
            return true;
        }
        return false;
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
     * Effect: If its a new order and order is legal, adds it to array list of orders, HashMap of Orders, HashTable of taxies
     * Output: True if added succesfully, false otherwise
     */
    public boolean addOrder(Order newOrder){
        if(newOrder == null)
            return false;

        if(allOrders.contains(newOrder))
            return false;

        allOrders.add(newOrder);//Add to allOrders
        addOrderByCode(newOrder.getSubCode(), newOrder); //Add to allOrdersHashMap
        addTaxiByCode(newOrder.getSubCode(), newOrder.getTaxi()); //Add to allTaxiesHashTable
        return true;
    }
    /*
     * Input: An Order to remove
     * Effect: If legal, removes order from array list of orders, HashMap and HashTable
     * Output: True if removed succesfully, false otherwise
     */
    public boolean removeOrder(Order orderToRemove){
        if(orderToRemove == null)
            return false;

        //Remove from allOrders if exist
        if(!allOrders.remove(orderToRemove))
            return false;

        String subCode = orderToRemove.getSubCode();
        Taxi taxiInOrder = orderToRemove.getTaxi();
        //Remove from AllOrdersHashMap
        if(subCode != null){
            ArrayList<Order> subOrders = this.allOrderHashMap.get(subCode);
            if(subOrders != null){
                subOrders.remove(orderToRemove);
                if(subOrders.isEmpty())
                    allOrderHashMap.remove(subCode);//If it was the only order by sub - remove sub
            }
        }
        //Remove from allTaxiesHashTable
        if(subCode != null && taxiInOrder != null){
            ArrayList<Taxi> subOrderedTaxies = this.allTaxiesHashtable.get(subCode);
            if(subOrderedTaxies != null){
                subOrderedTaxies.remove(taxiInOrder);
                if(subOrderedTaxies.isEmpty()){ // If it was the only taxi ordred by sub - remove sub
                    allTaxiesHashtable.remove(subCode);
                }
            }
        }
        return true;
    }
    /*
     * Input: A subscriber code, an order from this subscriber
     * Effect: If legal, adds order to HashMap of orders by codes
     * Output: True if added succesfully, false otherwise
     */
    public boolean addOrderByCode(String subCode, Order newOrder){
        if(subCode == null || newOrder == null)
            return false;

        if(allOrders.contains(newOrder))
            return false;

        if(!this.allOrderHashMap.containsKey(subCode)){// If key does not exist in HashMap
            this.allOrderHashMap.put(subCode, new ArrayList<>());
            ArrayList<Order> newSubOrders = this.allOrderHashMap.get(subCode);
            newSubOrders.add(newOrder);
            this.allOrderHashMap.get(subCode).add(newOrder); // Add order to HashMap
            return true;
        }
        ArrayList<Order> existingSubOrders = this.allOrderHashMap.get(subCode);
        existingSubOrders.add(newOrder);
        return true;
    }
    /*
     * Input: A subscriber code, A taxi that was ordred by subscriber
     * Effect: If legal, adds taxi to HashTable of Taxies by codes
     * Output: True if added succesfully, false otherwise
     */
    public boolean addTaxiByCode(String subCode, Taxi taxi){
        if(subCode == null || taxi == null)
            return false;
        if(!this.allTaxiesHashtable.containsKey(subCode)){ //If key does not exist in HashTable
            this.allTaxiesHashtable.put(subCode, new ArrayList<>());
            this.allTaxiesHashtable.get(subCode).add(taxi);
            return true;
        }
        //If key exists - make sure taxi does not exist in his array
        ArrayList<Taxi> existingTaxies = this.allTaxiesHashtable.get(subCode);
        if(existingTaxies.contains(taxi))
            return false;
        existingTaxies.add(taxi);
        return true;
    }
    /*
     * Input: A station
     * Output: ArrayList<String> containing codes of all available taxies in that station
     */
    public ArrayList<String> listAvailableTaxiCodesInStation(Station station)
    {
        ArrayList<String> result = new ArrayList<>();
        if (station == null)
        {
            return result ;
        }
        ArrayList<Taxi> taxisInStation = station.getTaxis();
        if (taxisInStation != null) {
            for (Taxi taxi : taxisInStation) {
                if (taxi != null && taxi.isAvailable())
                {
                    result.add(taxi.getTaxiCode());
                }
            }
        }
        return result;
    }
    /*
     * Input: A subscriber
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
        if (code == null) {
             return expressList;
        }
        ArrayList<Taxi> ordered = allTaxiesHashtable.get(code);

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