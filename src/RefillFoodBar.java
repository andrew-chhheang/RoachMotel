
/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * This class represents a refill food bar, is a decoration
 */
public class RefillFoodBar extends AmenityDecorator {

	public double COST = 5.00;

	/**
	 * decorator constructor for refill food bar
	 * @param room
	 */
	public RefillFoodBar(Room room){
		this.room = room;
	}

	/**
	 *  returns description
	 * @see AmenityDecorator#getDescription()
	 */
	@Override
	public String getDescription() {
		return this.room.getDescription()+"| w/ refill food bar ";
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
