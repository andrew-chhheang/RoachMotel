

/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * This class represents a deluxe room
 */
public class DeluxeRoom extends Room implements ItemElement{

	private static String type;
	private double cost;
	private boolean doNotDisturb = false;
	
	/**
	 * default constructor for deluxe room
	 */
	public DeluxeRoom()
	{
		type = "Deluxe";
		cost = 75.00;
	}

	/**
	 * gets description for deluxe room
	 * @return description
	 */
	public String getDescription()
	{
		return("Deluxe room: ");
	}
	
	/**
	 * returns cost of deluxe room
	 * @return cost
	 */
	public double cost()
	{
		return(cost);
	}
	
	/**
	 * sets room to do not disturb
	 */
	public void setDoNotDisturb()
	{
		doNotDisturb = true;
	}
	

	/**
	 * returns the description of the class
	 * @return description
	 */
	public String toString()
	{
		return getDescription();
	}

	/**
	 * 
	 * This class represents a food bar, is a decoration
	 */
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}
