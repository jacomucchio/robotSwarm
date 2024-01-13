package it.unicam.cs.pa.robotSwarm.model;

import java.util.Objects;
import java.util.regex.Pattern;

public class BasicLabel implements ILabel{
    //controllo per verificare che l'id inizi con _ e sia una serie di caratteri alfanumerici
    private static final Pattern VALID_ID_PATTERN = Pattern.compile("^_[A-Za-z0-9]+$");
    private String id;
    public BasicLabel(String id) {
        validateAndSetId(id);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
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
}
