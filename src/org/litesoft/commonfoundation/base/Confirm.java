package org.litesoft.commonfoundation.base;

import java.util.*;

@SuppressWarnings("UnusedDeclaration")
public class Confirm {
    public static void isNull( String pReferenceLabel, Object pToTest )
            throws IllegalArgumentException {
        IllegalArgument.ifNotNull( pReferenceLabel, pToTest );
    }

    public static <T> T isNotNull( String pReferenceLabel, T pToTest )
            throws IllegalArgumentException {
        return IllegalArgument.ifNull( pReferenceLabel, pToTest );
    }

    public static <T extends Collection<?>> T isNotNullOrEmpty( String pReferenceLabel, T pToTest )
            throws IllegalArgumentException {
        return IllegalArgument.ifEmpty( pReferenceLabel, pToTest, IllegalArgument.ifNull( pReferenceLabel, pToTest ).size() );
    }

    public static <T extends Map<?, ?>> T isNotNullOrEmpty( String pReferenceLabel, T pToTest )
            throws IllegalArgumentException {
        return IllegalArgument.ifEmpty( pReferenceLabel, pToTest, IllegalArgument.ifNull( pReferenceLabel, pToTest ).size() );
    }

    public static <T> T[] isNotNullOrEmpty( String pReferenceLabel, T[] pToTest )
            throws IllegalArgumentException {
        return IllegalArgument.ifEmpty( pReferenceLabel, pToTest, IllegalArgument.ifNull( pReferenceLabel, pToTest ).length );
    }

    public static <T extends Collection<?>> T isNotNullOrEmptyAndHasNoNullEntries( String pReferenceLabel, T pToTest )
            throws IllegalArgumentException {
        IllegalArgument.ifEmpty( pReferenceLabel, pToTest, IllegalArgument.ifNull( pReferenceLabel, pToTest ).size() );
        testElementsNotNull( pReferenceLabel, pToTest.toArray(), " entry '", "'" );
        return pToTest;
    }

    public static <T> T[] isNotNullOrEmptyAndHasNoNullEntries( String pReferenceLabel, T[] pToTest )
            throws IllegalArgumentException {
        return testElementsNotNull( pReferenceLabel, isNotNullOrEmpty( pReferenceLabel, pToTest ) );
    }

    public static <T> T[] isNotNullAndElementsNotNull( String pReferenceLabel, T[] pToTest )
            throws IllegalArgumentException {
        return testElementsNotNull( pReferenceLabel, isNotNull( pReferenceLabel, pToTest ) );
    }

    public static String significant( String pReferenceLabel, String pToCheck )
            throws IllegalArgumentException {
        String zValue = IllegalArgument.ifNull( pReferenceLabel, pToCheck ).trim(); // Note the trim()!
        return IllegalArgument.ifEmpty( pReferenceLabel, zValue, zValue.length() );
    }

    public static boolean isTrue( String pReferenceLabel, boolean pToTest )
            throws IllegalArgumentException {
        return IllegalArgument.ifNotEqual( pReferenceLabel, pToTest, true );
    }

    public static boolean isFalse( String pReferenceLabel, boolean pToTest )
            throws IllegalArgumentException {
        return IllegalArgument.ifNotEqual( pReferenceLabel, pToTest, false );
    }

    public static <T> T isEqual( String pReferenceLabel, T pToTest, T pExpected )
            throws IllegalArgumentException {
        return IllegalArgument.ifNotEqual( pReferenceLabel, pToTest, pExpected );
    }

    public static boolean isEqual( String pReferenceLabel, boolean pToTest, boolean pExpected )
            throws IllegalArgumentException {
        return IllegalArgument.ifNotEqual( pReferenceLabel, pToTest, pExpected );
    }

    public static char isEqual( String pReferenceLabel, char pToTest, char pExpected )
            throws IllegalArgumentException {
        return IllegalArgument.ifNotEqual( pReferenceLabel, pToTest, pExpected );
    }

    public static int isEqual( String pReferenceLabel, int pToTest, int pExpected )
            throws IllegalArgumentException {
        return IllegalArgument.ifNotEqual( pReferenceLabel, pToTest, pExpected );
    }

    public static long isEqual( String pReferenceLabel, long pToTest, long pExpected )
            throws IllegalArgumentException {
        return IllegalArgument.ifNotEqual( pReferenceLabel, pToTest, pExpected );
    }

    public static float isEqual( String pReferenceLabel, float pToTest, float pExpected )
            throws IllegalArgumentException {
        return IllegalArgument.ifNotEqual( pReferenceLabel, pToTest, pExpected );
    }

    public static double isEqual( String pReferenceLabel, double pToTest, double pExpected )
            throws IllegalArgumentException {
        return IllegalArgument.ifNotEqual( pReferenceLabel, pToTest, pExpected );
    }

    private static <T> T[] testElementsNotNull( String pReferenceLabel, T[] pToTest ) {
        testElementsNotNull( pReferenceLabel, pToTest, "[", "]" );
        return pToTest;
    }

    private static void testElementsNotNull( String pReferenceLabel, Object[] pElements, String pEntryPrefix, String pEntrySuffix ) {
        for ( int i = 0; i < pElements.length; i++ ) {
            if ( null == pElements[i] ) {
                throw IllegalArgument.ofNull( pReferenceLabel + pEntryPrefix + i + pEntrySuffix );
            }
        }
    }
}
