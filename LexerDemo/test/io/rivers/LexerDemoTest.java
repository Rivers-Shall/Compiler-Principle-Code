package io.rivers;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LexerDemoTest {

    /*
     * Testing Strategy:
     *
     * Partitions:
     *     The input can be a single line or multiple lines.
     *
     *     Every line of input can contain number, +, -, *, / or other invalid
     *     input.
     *
     *     One instance of LexerDemo can be used to lex multiple inputs by
     *     calling `lex` method.
     *
     * Each of these parts is covered by at least one test case below.
     */

    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    // covers single line input with number
    @Test
    public void testSingleLineInputWithNumber() {
        LexerDemo lexerDemo = new LexerDemo();
        assertEquals("line 1 token: NUM text: 12\n", lexerDemo.lex("12"));
    }

    // covers single line input with +
    @Test
    public void testSingleLineInputWithPlus() {
        LexerDemo lexerDemo = new LexerDemo();
        assertEquals("line 1 token: PLUS text: +\n", lexerDemo.lex("+"));
    }

    // covers single line input with -
    @Test
    public void testSingleLineInputWithSUB() {
        LexerDemo lexerDemo = new LexerDemo();
        assertEquals("line 1 token: SUB text: -\n", lexerDemo.lex("-"));
    }

    // covers single line input with *
    @Test
    public void testSingleLineInputWithMULT() {
        LexerDemo lexerDemo = new LexerDemo();
        assertEquals("line 1 token: MULT text: *\n", lexerDemo.lex("*"));
    }

    // covers single line input with /
    @Test
    public void testSingleLineInputWithDIV() {
        LexerDemo lexerDemo = new LexerDemo();
        assertEquals("line 1 token: DIV text: /\n", lexerDemo.lex("/"));
    }

    // covers single line input with invalid symbol
    @Test
    public void testSingleLineInputWithError() {
        LexerDemo lexerDemo = new LexerDemo();
        assertEquals("line 1 token: ERR text: i\n" +
                "line 1 token: ERR text: n\n" +
                "line 1 token: ERR text: v\n" +
                "line 1 token: ERR text: a\n" +
                "line 1 token: ERR text: l\n" +
                "line 1 token: ERR text: i\n" +
                "line 1 token: ERR text: d\n", lexerDemo.lex("invalid"));
    }

    // covers single line input with all possible symbols
    @Test
    public void testSingleLineInputWithAll() {
        LexerDemo lexerDemo = new LexerDemo();
        assertEquals("line 1 token: NUM text: 12\n" +
                "line 1 token: PLUS text: +\n" +
                "line 1 token: NUM text: 3\n" +
                "line 1 token: SUB text: -\n" +
                "line 1 token: NUM text: 4\n" +
                "line 1 token: MULT text: *\n" +
                "line 1 token: NUM text: 5\n" +
                "line 1 token: DIV text: /\n" +
                "line 1 token: NUM text: 5\n", lexerDemo.lex("12+3-4*5/5"));
    }

    // covers multi-line input with all possible symbols
    @Test
    public void testMultiLineInputWithAll() {
        LexerDemo lexerDemo = new LexerDemo();
        assertEquals("line 1 token: NUM text: 12\n" +
                "line 2 token: PLUS text: +\n" +
                "line 3 token: SUB text: -\n" +
                "line 4 token: MULT text: *\n" +
                "line 5 token: DIV text: /\n" +
                "line 6 token: ERR text: i\n", lexerDemo.lex("12\n" +
                "+\n" +
                "-\n" +
                "*\n" +
                "/\n" +
                "i"));
    }

    // covers multiple inputs with all possible symbols
    @Test
    public void testMultiInputWithAll() {
        LexerDemo lexerDemo = new LexerDemo();
        assertEquals("line 1 token: NUM text: 12\n" +
                "line 1 token: PLUS text: +\n" +
                "line 1 token: NUM text: 3\n" +
                "line 2 token: NUM text: 15\n" +
                "line 2 token: SUB text: -\n" +
                "line 2 token: NUM text: 12\n", lexerDemo.lex("12+3\n" +
                        "15-12\n"));

        assertEquals("line 1 token: NUM text: 10\n" +
                "line 1 token: MULT text: *\n" +
                "line 1 token: NUM text: 2\n" +
                "line 2 token: NUM text: 20\n" +
                "line 2 token: DIV text: /\n" +
                "line 2 token: NUM text: 4\n" +
                "line 3 token: ERR text: i\n", lexerDemo.lex("10*2\n" +
                "20/4\n" +
                "i"));
    }
}
