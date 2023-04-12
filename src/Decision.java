public class Decision {
    private final String ACTION;
    private String RESULT;
    private int NEXT_QUEST_ID;

    public Decision(String ACTION, String RESULT, int NEXT_QUEST_ID) {
        this.ACTION = ACTION;
        this.RESULT = RESULT;
        this.NEXT_QUEST_ID = NEXT_QUEST_ID;
    }

    public String getACTION() {
        return ACTION;
    }

    public String getRESULT() {
        return RESULT;
    }

    public int getNEXT_QUEST_ID() {
        return NEXT_QUEST_ID;
    }
}
