

/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * This class represents a spa, is a decorator
 */
public class Spa extends AmenityDecorator {


	public double COST = 20.00;

	/**
	 * decorator constructor for spa
	 * @param room
	 */
	public Spa(Room room){
		this.room = room;
	}

	/**
	 *  returns description
	 * @see AmenityDecorator#getDescription()
	 */
	@Override
	public String getDescription() {
		return this.room.getDescription()+"| w/ spa ";
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
		return this.room.cost()+COST ;
	}

}
