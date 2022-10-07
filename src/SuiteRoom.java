

/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * This class represents a suite
 */
public class SuiteRoom extends Room implements ItemElement{

	private static String type;
	private double cost;
	private boolean doNotDisturb = false;
	
	/**
	 * default constructor for suite
	 */
	public SuiteRoom()
	{
		type = "Suite";
		cost = 100.00;
	}

	/**
	 * gets description of the object
	 * @return description
	 */
	public String getDescription()
	{
		return("Suite: ");
	}
	
	/**
	 * returns cost of the suite
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
	 *  accepts a visitor to this room
	 * @see ItemElement#accept(Visitor)
	 */
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
