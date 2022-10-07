

/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * This class represents a spray shower, is a decoration
 */
public class SprayShower extends AmenityDecorator {


	public double COST = 25.00;

	/**
	 * decorator constructor for spray shower
	 * @param room
	 */
	public SprayShower(Room room){
		this.room = room;
	}

	/**
	 *  returns description
	 * @see AmenityDecorator#getDescription()
	 */
	@Override
	public String getDescription() {
		return this.room.getDescription()+"| w/ spray shower ";
	}
	
	/**
	 *  returns description
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return getDescription();
	}

	/**
	 *  returns cost
	 * @see Room#cost()
	 */
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return this.room.cost()+COST ;
	}

}
