

/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * This is a factory class for rooms
 */
public class RoomFactory {

	/**
	 * returns different room depending on type parameter
	 * @param type
	 * @return room
	 */
	public Room getRoom(String type)
	{
		if(type.equals("Regular"))
		{
			return new RegularRoom();
		}
		else if(type.equals("Deluxe"))
		{
			return new DeluxeRoom();
		}
		else if(type.equals("Suite"))
		{
			return new SuiteRoom();
		}
		else
		{
			return null;
		}
	}
}
