package org.xidea.p087el.p088fn;

import java.lang.reflect.Method;
import org.xidea.p087el.Invocable;

/* renamed from: org.xidea.el.fn.JSObject */
abstract class JSObject implements Invocable {
    protected Method method;
    Class<?>[] params;

    JSObject() {
    }

    public Object invoke(Object obj, Object... objArr) throws Exception {
        Class<?>[] clsArr = this.params;
        if (clsArr == null) {
            return this.method.invoke(this, new Object[]{obj, objArr});
        }
        int length = clsArr.length;
        Object[] objArr2 = new Object[length];
        int i = length - 1;
        while (i > 0) {
            objArr2[i] = ECMA262Impl.ToValue(objArr.length >= i ? objArr[i - 1] : null, this.params[i]);
            i--;
        }
        objArr2[0] = obj;
        return this.method.invoke(this, objArr2);
    }

    public String toString() {
        return this.method.getName();
    }

    static Object getArg(Object[] objArr, int i, Object obj) {
        return (i < 0 || i >= objArr.length) ? obj : objArr[i];
    }

    static int getIntArg(Object[] objArr, int i, Integer num) {
        return getNumberArg(objArr, i, num).intValue();
    }

    static Number getNumberArg(Object[] objArr, int i, Number number) {
        return ECMA262Impl.ToNumber(getArg(objArr, i, number));
    }

    static String getStringArg(Object[] objArr, int i, String str) {
        Object arg = getArg(objArr, i, (Object) null);
        if (arg == null) {
            return null;
        }
        return ECMA262Impl.ToString(arg);
    }
}
