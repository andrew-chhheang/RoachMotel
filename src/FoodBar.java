
/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * This class represents a food bar, is a decoration
 */
public class FoodBar extends AmenityDecorator {


	public double COST = 10.00;

	/**
	 * decorator constructor for food bar
	 * @param room
	 */
	public FoodBar(Room room){
		this.room = room;
	}

	/**
	 * gets decription for room
	 * @return description
	 */
	@Override
	public String getDescription() {
		return this.room.getDescription()+"| w/ food bar ";
	}

	/**
	 * returns cost of room
	 * @return cost
	 */
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return this.room.cost()+COST ;
	}
	
	/**
	 *  returns description
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return getDescription();
	}

}
