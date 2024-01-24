package it.unicam.cs.pa.robotSwarm.model;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Implementation of the {@code ILabel} interface representing a basic label.
 */
public class BasicLabel implements ILabel{
    /**
     * Regular expression pattern for a valid ID.
     * The ID must start with an underscore followed by alphanumeric characters.
     */
    private static final Pattern VALID_ID_PATTERN = Pattern.compile("^_[A-Za-z0-9]+$");

    /** The ID of the label. */
    private String id;
    /**
     * Constructs a BasicLabel with the specified ID.
     *
     * @param id The ID to be set for the label.
     * @throws IllegalArgumentException If the provided ID is invalid.
     */
    public BasicLabel(String id) {
        validateAndSetId(id);
    }
    @Override
    public String getId() {
        return id;
    }
    @Override
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Validates the provided ID and sets it for the label.
     *
     * @param id The ID to be validated and set.
     * @throws IllegalArgumentException If the provided ID is invalid.
     */
    private void validateAndSetId(String id) {
        if (id == null || !VALID_ID_PATTERN.matcher(id).matches()) {
            throw new IllegalArgumentException("Invalid ID. ID must start with an underscore followed by alphanumeric characters.");
        }
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicLabel that = (BasicLabel) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return id;
    }
}
