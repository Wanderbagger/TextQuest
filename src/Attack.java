public class Attack {
    private final String NAME;
    private final int PROBABILITY;
    private final int MIN_DAMAGE;
    private final int MAX_DAMAGE;
    private final String MESSAGE;

    public Attack(String NAME, int PROBABILITY, int MIN_DAMAGE, int MAX_DAMAGE, String MESSAGE) {
        this.NAME = NAME;
        this.PROBABILITY = PROBABILITY;
        this.MIN_DAMAGE = MIN_DAMAGE;
        this.MAX_DAMAGE = MAX_DAMAGE;
        this.MESSAGE = MESSAGE;
    }


}
