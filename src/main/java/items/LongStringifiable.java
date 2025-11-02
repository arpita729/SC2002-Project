package items;

/**
 * The {@code LongStringifiable} interface should be implemented by classes
 * that can provide a more detailed, descriptive string representation of themselves.
 * <p>
 * This is useful for displaying verbose information in user interfaces,
 * logs, or reports.
 */
public interface LongStringifiable {

    /**
     * Returns a detailed string representation of the object.
     *
     * @return a verbose and descriptive string format of the object
     */
    String toLongString();
}
