
/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * This class is a payment method
 */
public class MasterRoachStrategy implements PaymentStrategy{

	private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;

    /**
     * constructor
     * @param n
     * @param cn
     * @param cvv
     * @param doe
     */
    MasterRoachStrategy(String n, String cn, String cvv, String doe){
        name = n;
        cardNumber = cn;
        this.cvv = cvv;
        dateOfExpiry = doe;
    }

    /**
     *  pays for room
     * @see PaymentStrategy#pay(double)
     */
    @Override
    public void pay(double amount) {
        System.out.println("Paid by using MasterRoach.");
        System.out.println("Thank you for staying at the Roach Motel, " + name + "!");
    }
}
