import java.util.ArrayList;
import java.util.List;

public class Quest {
    private int id;
    public List<Decision> decisions = new ArrayList<>();
    public  String description;

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
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
                "id=" + id +
                ", decisions=" + decisions +
                ", description='" + description + '\'' +
                '}';
    }
}
