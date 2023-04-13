public class Decision {
    public final String ACTION;
    public String RESULT;
    public int NEXT_QUEST_ID;

    public Decision(String ACTION, String RESULT, int NEXT_QUEST_ID) {
        this.ACTION = ACTION;
        this.RESULT = RESULT;
        this.NEXT_QUEST_ID = NEXT_QUEST_ID;
    }


}
