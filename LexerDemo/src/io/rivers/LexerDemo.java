package io.rivers;

/**
 * <p>It is a class used to demonstrate lexing for arithmetic expressions with
 * +, -, *, / and non-negative integers.
 *
 * It takes input as a String using method <code>lex</code>.
 *
 * There can be multiple lines in one input but there should be no space in input.
 *
 * It can be used to lex multiple input.  Once a new input String is provided,
 * the information about the former String is lost.
 *
 * After calling method <code>lex</code>, it will return the result as a String
 * with each line being <br>
 * &lt;line-number&gt; &lt;token-type&gt;  &lt;text-content&gt;</p>
 *
 * For example, when you execute
 * <pre>Lexer lexer = new Lexer(); System.out.println(lexer.lex("1+2"));</pre>
 * The output will be
 * <pre>
 * line 1 token: NUM text: 1
 * line 1 token: PLUS text: +
 * line 1 token: NUM text: 2
 * </pre>
 *
 * @see Token
 * @author rivers
 */

public class LexerDemo {
    private StringBuilder lastTokenText = null;

    private Token lastToken = null;

    private int lastLineNumber = 1;

    /**
     * non-parameter constructor
     */
    public LexerDemo() {
        this.lastTokenText = new StringBuilder();
    }

    /**
     * return the result of lexing *text* in the form of<br>
     * &lt;line-number&gt; &lt;token-type&gt;  &lt;text-content&gt;
     * @param text the input to lex
     * @return a String which is the result of lexing *text*
     */
    public String lex(String text) {
        this.lastLineNumber = 1;
        char[] textCharArray = text.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : textCharArray) {
            Token currentToken = null;
            int currentLineNumber = this.lastLineNumber;
            if (Character.isDigit(c)) {
                currentToken = Token.NUM;
            } else if (c == '+') {
                currentToken = Token.PLUS;
            } else if (c == '-') {
                currentToken = Token.SUB;
            } else if (c == '*') {
                currentToken = Token.MULT;
            } else if (c == '/') {
                currentToken = Token.DIV;
            } else if (c == '\n') {
                currentLineNumber++;
            } else {
                currentToken = Token.ERR;
            }

            if (currentToken == this.lastToken && this.lastToken == Token.NUM) {
                this.lastTokenText.append(c);
            } else {
                if (this.lastToken != null) {
                    result.append(infoLine());
                }
                this.lastTokenText.delete(0, this.lastTokenText.length()).append(c);
                this.lastToken = currentToken;
            }
            this.lastLineNumber = currentLineNumber;
        }

        if (this.lastToken != null) {
            result.append(this.infoLine());
        }

        return result.toString();
    }

    private String infoLine() {
        return "line " + this.lastLineNumber + " token: " + this.lastToken + " text: " + this.lastTokenText + "\n";
    }

    public static void main(String[] args) {
        LexerDemo lexerDemo = new LexerDemo();
        System.out.println(lexerDemo.lex("12"));
    }
}
