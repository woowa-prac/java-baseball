package baseball;

public enum Flag {
    CONTINUE(1), EXIT(2);

    private final int num;

    Flag(int num) {
        this.num = num;
    }

    public static void validate(int num) {
        if (!(num == 1 || num == 2)) throw new IllegalArgumentException();
    }
}
