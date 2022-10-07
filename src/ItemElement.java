
/**
 * @author Kristinann Osborn, Lucas Colias, Binh Pham, Andrew Chheang
 * this interface is for the visitor pattern
 */
public interface ItemElement
{
    /**
     * allows items to accept a visitor
     * @param visitor
     */
    public void accept(Visitor visitor);
}