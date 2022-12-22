package didihttp.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: didihttp.internal.platform.b */
/* compiled from: OptionalMethod */
class C20781b<T> {

    /* renamed from: a */
    private final Class<?> f56888a;

    /* renamed from: b */
    private final String f56889b;

    /* renamed from: c */
    private final Class[] f56890c;

    public C20781b(Class<?> cls, String str, Class... clsArr) {
        this.f56888a = cls;
        this.f56889b = str;
        this.f56890c = clsArr;
    }

    /* renamed from: a */
    public boolean mo170338a(T t) {
        return m40831a(t.getClass()) != null;
    }

    /* renamed from: a */
    public Object mo170337a(T t, Object... objArr) throws InvocationTargetException {
        Method a = m40831a(t.getClass());
        if (a == null) {
            return null;
        }
        try {
            return a.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public Object mo170339b(T t, Object... objArr) {
        try {
            return mo170337a(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: c */
    public Object mo170340c(T t, Object... objArr) throws InvocationTargetException {
        Method a = m40831a(t.getClass());
        if (a != null) {
            try {
                return a.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
                assertionError.initCause(e);
                throw assertionError;
            }
        } else {
            throw new AssertionError("Method " + this.f56889b + " not supported for object " + t);
        }
    }

    /* renamed from: d */
    public Object mo170341d(T t, Object... objArr) {
        try {
            return mo170340c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: a */
    private Method m40831a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f56889b;
        if (str == null) {
            return null;
        }
        Method a = m40832a(cls, str, this.f56890c);
        if (a == null || (cls2 = this.f56888a) == null || cls2.isAssignableFrom(a.getReturnType())) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private static Method m40832a(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }
}
