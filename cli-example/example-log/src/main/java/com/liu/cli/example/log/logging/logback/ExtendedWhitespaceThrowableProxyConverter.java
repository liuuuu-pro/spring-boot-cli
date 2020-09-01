package com.liu.cli.example.log.logging.logback;

import ch.qos.logback.classic.pattern.ExtendedThrowableProxyConverter;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.core.CoreConstants;

/**
 * {@link ExtendedThrowableProxyConverter} that adds some additional whitespace around the
 * stack trace.
 *
 * @author Phillip Webb
 * Copied from seata.jar by liu
 */
public class ExtendedWhitespaceThrowableProxyConverter extends ExtendedThrowableProxyConverter {

    @Override
    protected String throwableProxyToString(IThrowableProxy tp) {
        return "==>" + CoreConstants.LINE_SEPARATOR + super.throwableProxyToString(tp)
                + "<==" + CoreConstants.LINE_SEPARATOR + CoreConstants.LINE_SEPARATOR;
    }
}
