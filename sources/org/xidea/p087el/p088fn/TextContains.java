package org.xidea.p087el.p088fn;

import java.util.Collection;
import org.xidea.p087el.Invocable;

/* renamed from: org.xidea.el.fn.TextContains */
public class TextContains implements Invocable {
    public Object invoke(Object obj, Object... objArr) throws Exception {
        return containsText(objArr[0], objArr[1]);
    }

    /* access modifiers changed from: protected */
    public Boolean containsText(Object obj, Object obj2) {
        String valueOf = String.valueOf(obj2);
        if (obj instanceof Object[]) {
            for (Object obj3 : (Object[]) obj) {
                if (obj3 != null && valueOf.equals(String.valueOf(obj3))) {
                    return Boolean.TRUE;
                }
            }
        } else if (obj instanceof Collection) {
            for (Object next : (Collection) obj) {
                if (next != null && valueOf.equals(String.valueOf(next))) {
                    return Boolean.TRUE;
                }
            }
        } else if (String.valueOf(obj).equals(valueOf)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
