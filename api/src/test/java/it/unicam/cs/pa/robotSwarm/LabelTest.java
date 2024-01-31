package it.unicam.cs.pa.robotSwarm;

import it.unicam.cs.pa.robotSwarm.model.BasicLabel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LabelTest {
    @Test
    void shouldCreateLabelWithValidID() {
        String validId = "_Label123";

        BasicLabel label = new BasicLabel(validId);

        assertEquals(validId, label.getId());
    }

    @Test
    void shouldThrowExceptionForNullID() {
        String nullId = null;

        assertThrows(IllegalArgumentException.class, () -> new BasicLabel(nullId));
    }

    @Test
    void shouldThrowExceptionForInvalidID() {
        String invalidId = "InvalidLabel";

        assertThrows(IllegalArgumentException.class, () -> new BasicLabel(invalidId));
    }

    @Test
    void shouldSetNewID() {
        String initialId = "_InitialLabel";
        String newId = "_NewLabel";
        BasicLabel label = new BasicLabel(initialId);

        label.setId(newId);

        assertEquals(newId, label.getId());
    }

    @Test
    void shouldEqualLabelsWithSameID() {
        String commonId = "_CommonLabel";
        BasicLabel label1 = new BasicLabel(commonId);
        BasicLabel label2 = new BasicLabel(commonId);

        assertEquals(label1, label2);
    }

    @Test
    void shouldNotEqualLabelsWithDifferentID() {
        BasicLabel label1 = new BasicLabel("_Label1");
        BasicLabel label2 = new BasicLabel("_Label2");

        assertNotEquals(label1, label2);
    }

    @Test
    void shouldReturnCorrectHashCode() {
        String commonId = "_CommonLabel";
        BasicLabel label1 = new BasicLabel(commonId);
        BasicLabel label2 = new BasicLabel(commonId);

        assertEquals(label1.hashCode(), label2.hashCode());
    }
}
