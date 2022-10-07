

/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * This class represents a regular room
 */
public class RegularRoom extends Room implements ItemElement{

	private static String type;
	private double cost;
	private boolean doNotDisturb = false;
	
	/**
	 * default constructor for regular room
	 */
	public RegularRoom()
	{
		type = "Regular";
		cost = 50.00;
	}

	/**
	 * gets description for regular room
	 * @return description
	 */
	public String getDescription()
	{
		return("Regular room: ");
	}
	
	/**
	 * returns cost of regular room
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
	 *  returns description
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return getDescription();
	}
	
	/**
	 *  allows visitor to visit room
	 * @see ItemElement#accept(Visitor)
	 */
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
