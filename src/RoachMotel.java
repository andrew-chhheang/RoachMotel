import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;


/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * The RoachMotel Class is base class for the Patterns Project. It implements the Singleton Pattern to ensure that there
 * is only one instance of the RoachMotel being used.
 */
public class RoachMotel implements SubjectMotel{
	
	private MasterRoachStrategy MasterRoach;
	private RoachPalStrategy RoachPal;
	private File log;
	private PrintWriter fileout;
	private String name = "MOTEL ROACHISH";
	private static RoachMotel uniqueInstance;
	private static final int rooms = 10;
	private int availableRooms;
	private ArrayList<ObserverColony> waitlist;
	private HashMap<Integer,Room> roomMap = new HashMap<>();
	private RoomFactory rf = new RoomFactory();
	
	/**
	 * RoachMotel constructor sets the number of available rooms equal to the number of room that are to be created by the 
	 * createRooms() method. It also creates an ArrayList for potential Observers who are trying to get on the waitlist for
	 * a room.  
	 */
	private RoachMotel()
	{
		availableRooms = rooms;
		waitlist = new ArrayList<ObserverColony>();
	}
	
	
	/**
	 * getInstance() checks if other instances of the RoachMotel class are being used in other threads and synchronizing all instances
	 * using the synchronized method call. Then if the uniqueInstance of the RoachMotel class has not been instantiated, a new RoachMotel 
	 * Object is created and returned. 
	 *   
	 * @return Unique RoachMotel Object 
	 */
	public static RoachMotel getInstance()
	{
		synchronized(RoachMotel.class)
		{
			if(uniqueInstance == null)
			{
				uniqueInstance = new RoachMotel();
			}
		}
		return uniqueInstance;
	}
	
	/**
	 * isVacant() checks if the number of available rooms is greater than the number of rooms at the Motel.
	 * If the number of available is less then there is a Vacancy, else the Motel is full. 
	 * 
	 * @return Vacancy Boolean 
	 */
	public boolean isVacant()
	{
		if(availableRooms > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * getName() returns the Name of the RoachMotel
	 * 
	 * @return String name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * setName(String n) sets the name of the RoachMotel
	 * 
	 * @param n
	 */
	public void setName(String n)
	{
		name = n;
	}
	
	/**
	 * createRooms() creates a Map of rooms with 
	 */
	public void createRooms()
	{
		for(int i = 0; i < rooms; i++)
		{
			roomMap.put(i+101,new RegularRoom());
		}
	}

	/**
	 * notifies observers of the motel when a vacancy is available, then clears the waitlist
	 */
	public void notifyObservers()
	{
		for(ObserverColony waiting : waitlist)
		{
			waiting.update(this);
		}
		waitlist.clear();
	}
	
	/**
	 * allows roach colony to check in to the motel if there is a vacancy, or adds the colony to a waitlist
	 * @param rc
	 * @param room
	 * @param ammenities
	 * @return
	 */
	public Room checkIn(RoachColony rc, String room, ArrayList<String> ammenities)
	{
		Room r1 = rf.getRoom(room);
		int key = 0;
		for(int i = 0; i < roomMap.size(); i++)
		{
			if(roomMap.get(i+101).getAvailablity()==true)
			{
				key = i+101;
				break;
			}
		}
		if(isVacant() == true)
		{
			r1 = rf.getRoom(room);
			for(String a : ammenities)
			{
				if(a.equals("foodbar"))
					r1 = new FoodBar(r1);
				else if(a.equals("spa"))
					r1 = new Spa(r1);
				else if(a.equals("shower"))
					r1 = new SprayShower(r1);
				else if(a.equals("refillbar"))
					r1 = new RefillFoodBar(r1);
			}
			r1.setOcc(rc);
			r1.setAvailability(false);
			rc.setRoom(r1);
			roomMap.put(key,r1);
			availableRooms--;
			return r1;
		}
		else
		{
			addObserver(rc);
		}
		return null;
	}
	
	/**
	 * reads out the log of transactions to the console
	 */
	public void readTransactionLog(){
		try {
			fileout.close();
			Scanner in = new Scanner(log);
			while (in.hasNextLine()){
				System.out.println(in.nextLine());
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * allows the maids to visit each room and clean them
	 */
	public void cleanRooms(){
		for(int i = 0; i < roomMap.size(); i++){			
			
			if((roomMap.get(101 + i).isDoNotDisturb() == false)){ 
				CleaningVisitor g = new CleaningVisitor();
				Room r = roomMap.get(101 + i).room;
				System.out.println("Cleaning room: " + (101 + i));
				
				
				if(r instanceof RegularRoom){
					RegularRoom rr = (RegularRoom)r; 
					g.visit(rr);
				}
				else if(r instanceof DeluxeRoom){
					DeluxeRoom dr = (DeluxeRoom)r;
					g.visit(dr);
				}
				else if(r instanceof SuiteRoom){
					SuiteRoom sr = (SuiteRoom)r; 
					g.visit(sr);
				}
			}
		}
	}
	
	/**
	 * creates a file for the transaction log
	 */
	public void createFile()
	{
		log = new File("TransactionLog.txt");
		try {
			fileout = new PrintWriter(log);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * checks roach colony out of room and takes their payment
	 * @param r
	 * @param days
	 * @param pay
	 * @return cost
	 */
	public double checkOut(Room r, int days, String pay)
	{
		double cost = r.cost() * days;
		if(pay.equals("MasterRoach")){
			MasterRoach = new MasterRoachStrategy("Roach","12345678","123","12/5");
			r.pay(MasterRoach);
			fileout.println("Name of the colony: "+ r.getOcc()+
					"\nMethod of payment: MasterRoach" +
					"\nAmount paid: "+cost+"\n");
		}
		else if(pay.equals("RoachPal")){
			RoachPal = new RoachPalStrategy("roach@gmail.com","123");
			r.pay(RoachPal);
			fileout.println("Name of the colony: "+ r.getOcc()+
					"\nMethod of payment: RoachPal" +
					"\nAmount paid: "+cost+"\n");
		}
		int key = 0;
		for(int i = 0; i < roomMap.size(); i++)
		{
			if(roomMap.get(i+101) == r)
			{
				key = i+101;
			}
		}
		roomMap.get(key).setAvailability(true);
		roomMap.put(key, new RegularRoom());
		availableRooms++;
		if(isVacant() == true)
		{
			notifyObservers();
		}
		return cost;
	}

	/**
	 * adds an observer of the motel to a waitlist
	 */
	public void addObserver(ObserverColony o)
	{
		waitlist.add(o);
	}
	
	/**
	 * removes an observer from a the motel waitlist
	 */
	public void removeObserver(ObserverColony o)
	{
		waitlist.remove(o);
	}

	/**
	 * toString() this messily coded method returns the MotelName, the Vacancy condition of the Motel(full or Vacant), 
	 * and the rooms that are available if the Motel has rooms.  
	 */
	public String toString() {
		String s = this.name;
		if(this.isVacant())
			s += " Rooms Available! \n";
		else {
			s += " Motel Full! \n";
			return s; 
		}
		
		s+= "{";
		for(int i = 0; i < roomMap.size(); i++) {
			if(!roomMap.get(101 + i).getAvailablity()) {
				s += roomMap.get(101 + i).getDescription();
				if(roomMap.get(101 + i).isDoNotDisturb())
					s += "(do not disturb) ";
				s += roomMap.get(101 + i).cost()+ " = " +  roomMap.get(101 + i).getOcc() +"} \n{";
			}
		}
		
		s+= "}";
		s += "available rooms: [";
		
		for(int i = 0; i < roomMap.size(); i++) {
			if(roomMap.get(101 + i).getAvailablity()) {
				s += (101 + i);
				if(i < roomMap.size() - 1)
					s+= ",";
			}
		}
		
		s += "] \n";
			
		return s;
	}
	
}
