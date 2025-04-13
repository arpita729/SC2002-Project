package items;

/**
 * The {@code Stringifiable} interface is intended for classes that want to provide
 * a standardized string representation of their instances.
 * <p>
 * This is similar to overriding {@link Object#toString()}, but serves as an explicit
 * contract for custom string formatting across different classes.
 */
public interface Stringifiable {

    /**
     * Returns a string representation of the object.
     *
     * @return a concise and readable string format of the object
     */
    @Override
    String toString();
}
