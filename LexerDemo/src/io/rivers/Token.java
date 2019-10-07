package io.rivers;

/**
 * It is a class to classify the tokens.
 * <code>NUM</code> for any valid non-negative integer number;
 * <code>PLUS</code> for +;
 * <code>SUB</code> for -;
 * <code>MULT</code> for *;
 * <code>DIV</code> for /;
 * <code>ERR</code> for any other invalid input.
 */
public enum Token {
    NUM, PLUS, SUB, MULT, DIV, ERR;

    /**
     * turn Token into String, which is just their name
     * @return String for the name of Token
     */
    @Override
    public String toString() {
        String str = null;
        switch (this) {
            case NUM:
                str = "NUM";
                break;
            case PLUS:
                str = "PLUS";
                break;
            case SUB:
                str = "SUB";
                break;
            case MULT:
                str = "MULT";
                break;
            case DIV:
                str = "DIV";
                break;
            case ERR:
                str = "ERR";
                break;
        }
        return str;
    }
}
