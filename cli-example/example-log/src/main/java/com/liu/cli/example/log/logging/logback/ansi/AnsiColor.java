package com.liu.cli.example.log.logging.logback.ansi;

/**
 * {@link AnsiElement Ansi} colors.
 *
 * @author Phillip Webb
 * @author Geoffrey Chandler
 * Copied from seata.jar by liu
 */
public enum AnsiColor implements AnsiElement {

    /**
     * default is light-grey
     */
    DEFAULT("39"),

    /**
     * black
     */
    BLACK("30"),

    /**
     * red
     */
    RED("31"),

    /**
     * green
     */
    GREEN("32"),

    /**
     * yellow
     */
    YELLOW("33"),

    /**
     * blue
     */
    BLUE("34"),

    /**
     * magenta
     */
    MAGENTA("35"),

    /**
     * cyan
     */
    CYAN("36"),

    /**
     * white
     */
    WHITE("37"),

    /**
     * bright black
     */
    BRIGHT_BLACK("90"),

    /**
     * bright red
     */
    BRIGHT_RED("91"),

    /**
     * bright green
     */
    BRIGHT_GREEN("92"),

    /**
     * bright yellow
     */
    BRIGHT_YELLOW("93"),

    /**
     * bright blue
     */
    BRIGHT_BLUE("94"),

    /**
     * bright magenta
     */
    BRIGHT_MAGENTA("95"),

    /**
     * bright cyan
     */
    BRIGHT_CYAN("96"),

    /**
     * bright white
     */
    BRIGHT_WHITE("97");

    /**
     * code of color
     */
    private final String code;

    AnsiColor(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return this.code;
    }

}
