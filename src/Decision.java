public class Decision {
    private String action;
    private String result;
    private String item;
    private int nextQuestId;
    private boolean getItem = false;
    private boolean lostItem = false;
    private boolean checkItem = false;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getAction() {
        return action;
    }

    public String getResult() {
        return result;
    }

    public int getNextQuestId() {
        return nextQuestId;
    }

    public boolean isGetItem() {
        return getItem;
    }

    public boolean isLostItem() {
        return lostItem;
    }

    public boolean isCheckItem() {
        return checkItem;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setNextQuestId(int nextQuestId) {
        this.nextQuestId = nextQuestId;
    }

    public void setGetItem(boolean getItem) {
        this.getItem = getItem;
    }

    public void setLostItem(boolean lostItem) {
        this.lostItem = lostItem;
    }

    public void setCheckItem(boolean checkItem) {
        this.checkItem = checkItem;
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
