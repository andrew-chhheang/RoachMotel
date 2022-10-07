
/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * This class is a payment method
 */
public class RoachPalStrategy implements PaymentStrategy{

	 private String emailId;
	 private String password;

	    /**
	     * constructor
	     * @param eID
	     * @param pass
	     */
	    RoachPalStrategy(String eID, String pass){
	        emailId = eID;
	        password = pass;
	    }
	    /**
		 *  pays for room
	     * @see PaymentStrategy#pay(double)
	     */
	    @Override
	    public void pay(double cost) {
	        System.out.println("Paid by using Roachpal.");
	        System.out.println("You're receipt has been sent to " + emailId + ".");
	        System.out.println("Thank you for your stay!");
	    }
}
