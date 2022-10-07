/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * The RoachMotel Class is base class for the Patterns Project. It implements the Singleton Pattern to ensure that there
 * is only one instance of the RoachMotel being used.
 */
public interface Visitor
{
    void visit(RegularRoom mag);
    void visit(DeluxeRoom deluxe);
    void visit(SuiteRoom suite);
}
