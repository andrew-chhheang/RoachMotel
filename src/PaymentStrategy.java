
/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * This class represents a deluxe room
 */
public interface PaymentStrategy {

	/**
	 * pays based on amount
	 * @param amount
	 */
	void pay(double amount);
}
