package kotlin.reflect.jvm.internal.impl.utils;

public class WrappedValues {

    /* renamed from: a */
    private static final Object f61204a = new Object() {
        public String toString() {
            return "NULL_VALUE";
        }
    };
    public static volatile boolean throwWrappedProcessCanceledException = false;

    /* renamed from: a */
    private static /* synthetic */ void m45108a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i == 1 || i == 2) ? 2 : 3)];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        } else if (i != 3) {
            objArr[0] = "value";
        } else {
            objArr[0] = "throwable";
        }
        if (i == 1 || i == 2) {
            objArr[1] = "escapeNull";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        }
        if (!(i == 1 || i == 2)) {
            if (i == 3) {
                objArr[2] = "escapeThrowable";
            } else if (i != 4) {
                objArr[2] = "unescapeNull";
            } else {
                objArr[2] = "unescapeExceptionOrNull";
            }
        }
        String format = String.format(str, objArr);
        throw ((i == 1 || i == 2) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    private static final class ThrowableWrapper {
        private final Throwable throwable;

        private static /* synthetic */ void $$$reportNull$$$0(int i) {
            String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i != 1 ? 3 : 2)];
            if (i != 1) {
                objArr[0] = "throwable";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            }
            if (i != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
            } else {
                objArr[1] = "getThrowable";
            }
            if (i != 1) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            throw (i != 1 ? new IllegalArgumentException(format) : new IllegalStateException(format));
        }

        private ThrowableWrapper(Throwable th) {
            if (th == null) {
                $$$reportNull$$$0(0);
            }
            this.throwable = th;
        }

        public Throwable getThrowable() {
            Throwable th = this.throwable;
            if (th == null) {
                $$$reportNull$$$0(1);
            }
            return th;
        }

        public String toString() {
            return this.throwable.toString();
        }
    }

    public static <V> V unescapeNull(Object obj) {
        if (obj == null) {
            m45108a(0);
        }
        if (obj == f61204a) {
            return null;
        }
        return obj;
    }

    public static <V> Object escapeNull(V v) {
        if (v == null) {
            Object obj = f61204a;
            if (obj == null) {
                m45108a(1);
            }
            return obj;
        }
        if (v == null) {
            m45108a(2);
        }
        return v;
    }

    public static Object escapeThrowable(Throwable th) {
        if (th == null) {
            m45108a(3);
        }
        return new ThrowableWrapper(th);
    }

    public static <V> V unescapeExceptionOrNull(Object obj) {
        if (obj == null) {
            m45108a(4);
        }
        return unescapeNull(unescapeThrowable(obj));
    }

    public static <V> V unescapeThrowable(Object obj) {
        if (!(obj instanceof ThrowableWrapper)) {
            return obj;
        }
        Throwable throwable = ((ThrowableWrapper) obj).getThrowable();
        if (!throwWrappedProcessCanceledException || !ExceptionUtilsKt.isProcessCanceledException(throwable)) {
            throw ExceptionUtilsKt.rethrow(throwable);
        }
        throw new WrappedProcessCanceledException(throwable);
    }

    public static class WrappedProcessCanceledException extends RuntimeException {
        public WrappedProcessCanceledException(Throwable th) {
            super("Rethrow stored exception", th);
        }
    }
}
