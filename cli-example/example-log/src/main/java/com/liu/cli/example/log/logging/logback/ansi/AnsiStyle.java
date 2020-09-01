package com.liu.cli.example.log.logging.logback.ansi;

/**
 * {@link AnsiElement Ansi} styles.
 *
 * @author Phillip Webb
 * Copied from seata.jar by liu
 */
public enum AnsiStyle implements AnsiElement {

    /**
     * normal
     */
    NORMAL("0"),

    /**
     * bold
     */
    BOLD("1"),

    /**
     * faint
     */
    FAINT("2"),

    /**
     * italic
     */
    ITALIC("3"),

    /**
     * underline
     */
    UNDERLINE("4");

    /**
     * code of style
     */
    private final String code;

    AnsiStyle(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code;
    }

}
