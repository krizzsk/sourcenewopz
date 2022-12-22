package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: okhttp3.internal.platform.b */
/* compiled from: OptionalMethod */
class C2461b<T> {

    /* renamed from: a */
    private final Class<?> f5516a;

    /* renamed from: b */
    private final String f5517b;

    /* renamed from: c */
    private final Class[] f5518c;

    C2461b(Class<?> cls, String str, Class... clsArr) {
        this.f5516a = cls;
        this.f5517b = str;
        this.f5518c = clsArr;
    }

    /* renamed from: a */
    public boolean mo25379a(T t) {
        return m3552a(t.getClass()) != null;
    }

    /* renamed from: a */
    public Object mo25378a(T t, Object... objArr) throws InvocationTargetException {
        Method a = m3552a(t.getClass());
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
    public Object mo25380b(T t, Object... objArr) {
        try {
            return mo25378a(t, objArr);
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
    public Object mo25381c(T t, Object... objArr) throws InvocationTargetException {
        Method a = m3552a(t.getClass());
        if (a != null) {
            try {
                return a.invoke(t, objArr);
            } catch (IllegalAccessException e) {
                AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + a);
                assertionError.initCause(e);
                throw assertionError;
            }
        } else {
            throw new AssertionError("Method " + this.f5517b + " not supported for object " + t);
        }
    }

    /* renamed from: d */
    public Object mo25382d(T t, Object... objArr) {
        try {
            return mo25381c(t, objArr);
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
    private Method m3552a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f5517b;
        if (str == null) {
            return null;
        }
        Method a = m3553a(cls, str, this.f5518c);
        if (a == null || (cls2 = this.f5516a) == null || cls2.isAssignableFrom(a.getReturnType())) {
            return a;
        }
        return null;
    }

    /* renamed from: a */
    private static Method m3553a(Class<?> cls, String str, Class[] clsArr) {
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
