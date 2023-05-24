public class Decision {
    public String action;
    public String result;
    public int nextQuestId;


    public void setAction(String action) {
        this.action = action;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setNextQuestId(int nextQuestId) {
        this.nextQuestId = nextQuestId;
    }

    @Override
    public String toString() {
        return "Decision{" +
                "ACTION='" + action + '\'' +
                ", RESULT='" + result + '\'' +
                ", NEXT_QUEST_ID=" + nextQuestId +
                '}';
    }
}
