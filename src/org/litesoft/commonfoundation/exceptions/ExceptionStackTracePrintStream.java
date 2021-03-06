// This Source Code is in the Public Domain per: http://unlicense.org
package org.litesoft.commonfoundation.exceptions;

import java.io.*;

/**
 * A print stream which can be passed to
 * {@link Throwable#printStackTrace(PrintStream)}. Only the minimally necessary
 * methods for this use are implemented.
 */
public class ExceptionStackTracePrintStream extends PrintStream {
    private final StringBuilder mStringBuilder = new StringBuilder();

    public ExceptionStackTracePrintStream() {
        super( OutputStreamStub.INSTANCE );
    }

    @Override
    public void println( Object x ) {
        mStringBuilder.append( x );
        newLine();
    }

    @Override
    public void println( String x ) {
        mStringBuilder.append( x );
        newLine();
    }

    @Override
    public String toString() {
        return mStringBuilder.toString();
    }

    private void newLine() {
        mStringBuilder.append( '\n' );
    }

    private static class OutputStreamStub extends OutputStream {
        public static final OutputStreamStub INSTANCE = new OutputStreamStub();

        private static final String MESSAGE = "FIXME: this method should never be called";

        public void write( int b ) {
            throw new AssertionError( MESSAGE );
        }

        public void write( byte[] b ) {
            throw new AssertionError( MESSAGE );
        }

        public void write( byte[] b, int off, int len ) {
            throw new AssertionError( MESSAGE );
        }

        public void flush() {
            throw new AssertionError( MESSAGE );
        }

        public void close() {
            throw new AssertionError( MESSAGE );
        }
    }
}
