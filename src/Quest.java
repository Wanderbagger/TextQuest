import java.util.ArrayList;
import java.util.List;

public class Quest {
    private final int ID;
    private final List<Decision> DECISIONS = new ArrayList<>();
    private final String DESCRIPTION;

    public Quest(int ID, String DESCRIPTION) {
        this.ID = ID;
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public int getID() {
        return ID;
    }

    public List<Decision> getDECISIONS() {
        return DECISIONS;
    }
}
