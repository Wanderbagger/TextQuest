public class Quest {
    private final int id;
    private String description;
    private String firstDecision;
    private String firstResultDescription;
    private int firstResult;
    private String secondDecision;
    private String secondResultDescription;
    private int secondResult;
    private String thirdDecision;
    private String thirdResultDescription;
    private int thirdResult;



    public Quest(int id, String description, String firstDecision, String firstResultDescription, int firstResult, String secondDecision, String secondResultDescription, int secondResult, String thirdDecision, String thirdResultDescription, int thirdResult) {
        this.id = id;
        this.description = description;
        this.firstDecision = firstDecision;
        this.firstResultDescription = firstResultDescription;
        this.firstResult = firstResult;
        this.secondDecision = secondDecision;
        this.secondResultDescription = secondResultDescription;
        this.secondResult = secondResult;
        this.thirdDecision = thirdDecision;
        this.thirdResultDescription = thirdResultDescription;
        this.thirdResult = thirdResult;
    }

    public Quest(int id, String description, String firstDecision, String firstResultDescription, int firstResult, String secondDecision, String secondResultDescription, int secondResult) {
        this.id = id;
        this.description = description;
        this.firstDecision = firstDecision;
        this.firstResultDescription = firstResultDescription;
        this.firstResult = firstResult;
        this.secondDecision = secondDecision;
        this.secondResultDescription = secondResultDescription;
        this.secondResult = secondResult;
    }

    public Quest(int id, String description, String firstDecision, String firstResultDescription, int firstResult) {
        this.id = id;
        this.description = description;
        this.firstDecision = firstDecision;
        this.firstResultDescription = firstResultDescription;
        this.firstResult = firstResult;
    }

    public void initialize(){
        new Quest(1, "Вы видите Власову, что вы хотите сделать?", "Бросить кирпичом", "Отличное попадание", 2, "Ударить сапогом", "Вы подошли слишком близко, о боже!", -1);
        new Quest(2, "Вы видите Власову, что вы хотите сделать?", "Бросить кирпичом", "Отличное попадание", 2, "Ударить сапогом", "Вы подошли слишком близко, о боже!", -1);
    }
}
