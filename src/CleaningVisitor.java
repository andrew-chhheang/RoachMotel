
/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * This class allows the rooms to be visited for cleaning
 */
public class CleaningVisitor implements Visitor {
    /**
     * visits the Regular room mag
     * @param mag
     */
    @Override
    public void visit(RegularRoom mag) {
        System.out.println("Linens on the bed are changed");
        System.out.println("The towels on the floor are changed");
    }

    /**
     * visits the deluxe room deluxe
     * @param deluxe
     */
    @Override
    public void visit(DeluxeRoom deluxe) {
        System.out.println("Linens on the bed are changed");
        System.out.println("The towels on the floor are changed");
        System.out.println("All other towels are changed");
    }

    /**
     * visits the suite room suite
     * @param suite
     */
    @Override
    public void visit(SuiteRoom suite) {
        System.out.println("Linens on the bed are changed");
        System.out.println("The towels on the floor are changed");
        System.out.println("All other towels are changed");
        System.out.println("A hamburger is placed on top of the pillow");
    }

    /**
     * visits room rm based on the type of room
     * @param rm
     */
    public void visit(Room rm){
        if(rm instanceof RegularRoom){
            visit((RegularRoom) rm);
        }
        else if(rm instanceof DeluxeRoom){
            visit((DeluxeRoom) rm);
        }
        else if(rm instanceof SuiteRoom){
            visit((SuiteRoom) rm);
        }
    }
}