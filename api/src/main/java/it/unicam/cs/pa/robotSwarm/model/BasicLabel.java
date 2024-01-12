package it.unicam.cs.pa.robotSwarm.model;

import java.util.Objects;

public class BasicLabel implements ILabel{
    private String id;
    public BasicLabel(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
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
