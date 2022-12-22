package org.mozilla.javascript;

public abstract class SecurityController {

    /* renamed from: global  reason: collision with root package name */
    private static SecurityController f61857global;

    public abstract GeneratedClassLoader createClassLoader(ClassLoader classLoader, Object obj);

    public abstract Object getDynamicSecurityDomain(Object obj);

    public Class<?> getStaticSecurityDomainClassInternal() {
        return null;
    }

    static SecurityController global() {
        return f61857global;
    }

    public static boolean hasGlobal() {
        return f61857global != null;
    }

    public static void initGlobal(SecurityController securityController) {
        if (securityController == null) {
            throw new IllegalArgumentException();
        } else if (f61857global == null) {
            f61857global = securityController;
        } else {
            throw new SecurityException("Cannot overwrite already installed global SecurityController");
        }
    }

    public static GeneratedClassLoader createLoader(ClassLoader classLoader, Object obj) {
        Context context = Context.getContext();
        if (classLoader == null) {
            classLoader = context.getApplicationClassLoader();
        }
        SecurityController securityController = context.getSecurityController();
        if (securityController == null) {
            return context.createClassLoader(classLoader);
        }
        return securityController.createClassLoader(classLoader, securityController.getDynamicSecurityDomain(obj));
    }

    public static Class<?> getStaticSecurityDomainClass() {
        SecurityController securityController = Context.getContext().getSecurityController();
        if (securityController == null) {
            return null;
        }
        return securityController.getStaticSecurityDomainClassInternal();
    }

    public Object callWithDomain(Object obj, Context context, final Callable callable, Scriptable scriptable, final Scriptable scriptable2, final Object[] objArr) {
        return execWithDomain(context, scriptable, new Script() {
            public Object exec(Context context, Scriptable scriptable) {
                return callable.call(context, scriptable, scriptable2, objArr);
            }
        }, obj);
    }

    @Deprecated
    public Object execWithDomain(Context context, Scriptable scriptable, Script script, Object obj) {
        throw new IllegalStateException("callWithDomain should be overridden");
    }
}
