public class Decision {
    private String action;
    private String result;
    private String item;
    private int nextQuestId;
    private int enemyHealth;
    private String enemyName;
    private boolean getItem = false;
    private boolean lostItem = false;
    private boolean checkItem = false;
    private boolean isFightDecision = false;

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

    public boolean isFightDecision() {
        return isFightDecision;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
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

    public void setFightDecision(boolean fightDecision) {
        isFightDecision = fightDecision;
    }

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
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
