import java.util.ArrayList;
import java.util.List;

public class Quest {
    private final int ID;
    public List<Decision> decisions = new ArrayList<>();
    public final String DESCRIPTION;

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

    public List<Decision> getDecisions() {
        return decisions;
    }

    public void setDecisions(List<Decision> decisions) {
        this.decisions = decisions;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "ID=" + ID +
                ", decisions=" + decisions +
                ", DESCRIPTION='" + DESCRIPTION + '\'' +
                '}';
    }
}
