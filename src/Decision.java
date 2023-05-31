public class Decision {
    public String action;
    public String result;
    public int nextQuestId;
    public Item getItem = null;
    public Item lostItem = null;



    public void setAction(String action) {
        this.action = action;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setNextQuestId(int nextQuestId) {
        this.nextQuestId = nextQuestId;
    }

    public void setGetItem(Item getItem) {
        this.getItem = getItem;
    }

    public void setLostItem(Item lostItem) {
        this.lostItem = lostItem;
    }

    @Override
    public String toString() {
        return "Decision{" +
                "action='" + action + '\'' +
                ", result='" + result + '\'' +
                ", nextQuestId=" + nextQuestId +
                ", item=" + getItem +
                '}';
    }
}
