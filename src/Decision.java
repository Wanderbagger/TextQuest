public class Decision {
    public String action;
    public String result;
    public int nextQuestId;
    public Item item = null;



    public void setAction(String action) {
        this.action = action;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setNextQuestId(int nextQuestId) {
        this.nextQuestId = nextQuestId;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Decision{" +
                "action='" + action + '\'' +
                ", result='" + result + '\'' +
                ", nextQuestId=" + nextQuestId +
                ", item=" + item +
                '}';
    }
}
