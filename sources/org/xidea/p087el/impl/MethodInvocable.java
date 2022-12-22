package org.xidea.p087el.impl;

import java.lang.reflect.Method;
import org.xidea.p087el.Invocable;
import org.xidea.p087el.p088fn.ECMA262Impl;

/* renamed from: org.xidea.el.impl.MethodInvocable */
/* compiled from: ReferenceImpl */
class MethodInvocable implements Invocable {
    Method[] methods;

    MethodInvocable() {
    }

    public Object invoke(Object obj, Object... objArr) throws Exception {
        Method[] methodArr = this.methods;
        int length = methodArr.length;
        int i = 0;
        while (i < length) {
            Method method = methodArr[i];
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length == objArr.length) {
                int i2 = 0;
                while (i2 < parameterTypes.length) {
                    Class<? extends Object> wrapper = ReflectUtil.toWrapper(parameterTypes[i2]);
                    Object ToValue = ECMA262Impl.ToValue(objArr[i2], wrapper);
                    objArr[i2] = ToValue;
                    if (ToValue == null || wrapper.isInstance(ToValue)) {
                        i2++;
                    } else {
                        i++;
                    }
                }
            }
            return method.invoke(obj, objArr);
        }
        return null;
    }
}
