package com.liu.cli.example.log.logging.logback.ansi;

/**
 * An ANSI encodable element.
 *
 * @author Phillip Webb
 * Copied from seata.jar by liu
 */
public interface AnsiElement {

    /**
     * @return the ANSI escape code
     */
    @Override
    String toString();

}
