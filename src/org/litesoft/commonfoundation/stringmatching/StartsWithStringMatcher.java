// This Source Code is in the Public Domain per: http://unlicense.org
package org.litesoft.commonfoundation.stringmatching;

public class StartsWithStringMatcher extends AbstractSingleStringMatcher {
    // Package Friendly
    StartsWithStringMatcher( int pMinLength, boolean pIgnoreCase, String pToMatch ) {
        super( pMinLength, pIgnoreCase, pToMatch );
    }

    @Override
    protected boolean LLmatches( String pInQuestion ) {
        return pInQuestion.startsWith( mToMatch );
    }

    @Override
    public String toString() {
        return "StartsWith( '" + mToMatch + "' )";
    }
}
