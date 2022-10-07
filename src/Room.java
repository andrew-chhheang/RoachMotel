



/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * This abstract class models a room
 */
public abstract class Room {

	private RoachColony occupant;
	private boolean available = true;
	private boolean doNotDisturb;
	public Room room;
	
	/**
	 * @return description
	 */
	public abstract String getDescription();
	
	/**
	 * @return cost
	 */
	public abstract double cost();
	
	/**
	 * set the colony occupying the room
	 * @param rc
	 */
	public void setOcc(RoachColony rc)
	{
		occupant = rc;
	}
	
	/**
	 * sets room availability
	 * @param a
	 */
	public void setAvailability(boolean a) {
		available = a; 
	}
	
	/**
	 * gets room availability
	 * @return availability
	 */
	public boolean getAvailablity() {
		return available;
	}
	
	/**
	 * gets the occupant of the room
	 * @return roachColony
	 */
	public RoachColony getOcc()
	{
		return occupant;
	}
	
	/**
	 * sets rooms to do not disturb
	 */
	public void setDoNotDisturb()
	{
		doNotDisturb = true;
	}
	
	public boolean isDoNotDisturb()
	{
		return doNotDisturb;
	}
	
	/**
	 * pays for room
	 * @param paymentMethod
	 */
	public void pay(PaymentStrategy paymentMethod){
		paymentMethod.pay(cost());
	}
	
}
