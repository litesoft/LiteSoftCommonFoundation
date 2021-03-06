package org.litesoft.commonfoundation.base;

public class ClassName {
    public static String full( Object pObject ) {
        return (pObject != null) ? pObject.getClass().getName() : null;
    }

    /**
     * This method returns the "really" Simple Name of the class of the object passed in (the name after the last of either: '.' or '$').
     *
     * @return the substring beginning one character beyond the last of either: '.' or '$'; or null if the parameter is null
     */
    public static String simple( Object pObject ) {
        return (pObject == null) ? null : simpleFromClass( toClass( pObject ) );
    }

    public static String simpleFromClass( Class pClass ) {
        String zName = "." + Confirm.isNotNull( "Class", pClass ).getName();
        zName = zName.substring( zName.lastIndexOf( '.' ) + 1 );
        for ( int at; -1 != (at = zName.lastIndexOf( '$' )); ) {
            String right = ConstrainTo.significantOrNull( zName.substring( at + 1 ), "1" ); // "1" force ignore if Empty
            char c = right.charAt( 0 );
            zName = ((c < '0') || ('9' < c)) ? right : zName.substring( 0, at );
        }
        return zName;
    }

    /**
     * This method strips the package name off the class name of the pObject returning just the substring
     * beginning one character beyond the last ".", and if it ends with "Impl" remove that.
     */
    public static String simpleNoImpl( Object pObject ) {
        String zName = simple( pObject );
        return ((zName != null) && zName.endsWith( "Impl" )) ? zName.substring( 0, zName.length() - 4 ) : zName;
    }

    public static String simpleIfPackage( String pClassName, String pPackage ) {
        if ( pClassName != null ) {
            if ( (pPackage != null) && pPackage.endsWith( "." ) && (pPackage.length() < pClassName.length()) ) {
                String zSimpleName = simple( pClassName );
                if ( pClassName.equals( pPackage + zSimpleName ) ) {
                    return zSimpleName;
                }
            }
        }
        return pClassName;
    }

    public static String simpleIfPackage( Class<?> pClass, String pPackage ) {
        return (pClass != null) ? simpleIfPackage( pClass.getName(), pPackage ) : null;
    }

    private static Class<?> toClass( Object pObject ) {
        return (pObject instanceof Class) ? (Class) pObject : pObject.getClass();
    }
}
