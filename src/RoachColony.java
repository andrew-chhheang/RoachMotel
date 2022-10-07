
/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * This class models a roach colony and allows them to do different things like party
 */
public class RoachColony implements ObserverColony{
 
	private String name;
	private double population;
	private double growthRate;
	private Room room;
	
	/**
	 * default constructor for roach colony
	 */
	public RoachColony()
	{
		name = "Roach Colony";
		population = 100;
		growthRate = 0.05;
	}
	
	/**
	 * constructor for roach colony, accepts name, poplation, and growth rate
	 * @param n
	 * @param p
	 * @param gr
	 */
	public RoachColony(String n, int p, double gr)
	{
		name = n;
		population = p;
		growthRate = gr;
	}
	
	
	/**
	 * mutator for name
	 * @param n
	 */
	public void setName(String n) {name = n;}
	
	/**
	 * accessor for name
	 * @return name
	 */
	public String getName() {return name;}

	/**
	 * accessor for population
	 * @return population
	 */
	public double getPop() {return population;}
	
	/**
	 * mutator for growth rate
	 * @param gr
	 */
	public void setGrowthRate(double gr) {growthRate = gr;}
	
	/**
	 * accessor for growth rate
	 * @return
	 */
	public double getGrowthRate() {return growthRate;}
	
	/**
	 * sets room
	 * @param r
	 */
	public void setRoom(Room r)
	{
		room = r;
	}
	
	/**
	 * alters the roach population when they party
	 */
	public void party()
	{
		population = (population * growthRate) + population;
		if(room instanceof SprayShower)
		{
			population = population - (population * 0.25);
		}
		else
		{
			population = population/2;
		}
	}
	
	/**
	 *  returns description
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		return(name +  " Members: " + population);
	}
	
	/**
	 * updates newest subject state
	 * @param newState
	 */
	@Override
	public void update(Object newState) 
	{
		RoachMotel availablity = (RoachMotel)newState;
		display(availablity);
	}

	/**
	 * displays notification for updates to subject
	 * @param rm
	 */
	private void display(RoachMotel rm) 
	{
		System.out.print("Vacancy available at " + rm.getName() + " message recieved by " + name + "\n");
	}
}