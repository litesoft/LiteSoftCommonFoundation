// This Source Code is in the Public Domain per: http://unlicense.org
package org.litesoft.commonfoundation.exceptions;

import java.io.*;

public class WrappedIOException extends RuntimeException {
    public WrappedIOException( String message, Throwable cause ) {
        super( message, cause );
    }

    public WrappedIOException( IOException cause ) {
        super( cause );
    }
}
