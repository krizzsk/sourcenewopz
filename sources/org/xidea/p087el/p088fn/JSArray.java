package org.xidea.p087el.p088fn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.xidea.p087el.Invocable;

/* renamed from: org.xidea.el.fn.JSArray */
class JSArray extends JSObject implements Invocable {
    JSArray() {
    }

    public Object invoke(Object obj, Object... objArr) throws Exception {
        return this.method.invoke(this, new Object[]{toList(obj), objArr});
    }

    private static final Object toList(Object obj) {
        if (obj instanceof Object[]) {
            return Arrays.asList(new Object[]{obj});
        } else if (!obj.getClass().isArray()) {
            return obj;
        } else {
            int length = Array.getLength(obj);
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(Array.get(obj, 1));
            }
            return arrayList;
        }
    }

    static int toSliceRange(int i, int i2) {
        if (i < 0) {
            return Math.max(i + i2, 0);
        }
        return Math.min(i, i2);
    }

    public Object splice(List<Object> list, Object... objArr) throws Exception {
        return slice(list, objArr);
    }

    public Object slice(List<Object> list, Object... objArr) throws Exception {
        int size = list.size();
        int sliceRange = toSliceRange(JSObject.getIntArg(objArr, 0, 0), size);
        int sliceRange2 = toSliceRange(JSObject.getIntArg(objArr, 1, Integer.valueOf(size)), size);
        if (sliceRange < sliceRange2) {
            return list.subList(sliceRange, sliceRange2);
        }
        return Collections.EMPTY_LIST;
    }

    public Object join(List<Object> list, Object... objArr) {
        StringBuilder sb = new StringBuilder();
        String str = null;
        for (Object next : list) {
            if (str == null) {
                str = JSObject.getStringArg(objArr, 0, ",");
            } else {
                sb.append(str);
            }
            sb.append(ECMA262Impl.ToString(next));
        }
        return sb.toString();
    }

    public Object toString(List<Object> list, Object... objArr) {
        return join(list, ",");
    }

    public Object push(List<Object> list, Object... objArr) {
        for (Object add : objArr) {
            list.add(add);
        }
        return Integer.valueOf(list.size());
    }

    public Object pop(List<Object> list, Object... objArr) {
        int size = list.size();
        if (size > 0) {
            return list.remove(size - 1);
        }
        return null;
    }

    public Object shift(List<Object> list, Object... objArr) {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }

    public Object unshift(List<Object> list, Object... objArr) {
        for (int i = 0; i < objArr.length; i++) {
            list.add(i, objArr[i]);
        }
        return Integer.valueOf(list.size());
    }

    public Object concat(List<Object> list, Object... objArr) {
        ArrayList arrayList = new ArrayList(list);
        for (Object list2 : objArr) {
            Object list3 = toList(list2);
            if (list3 instanceof Collection) {
                arrayList.addAll((Collection) list3);
            } else {
                arrayList.add(list3);
            }
        }
        return arrayList;
    }

    public Object reverse(List<Object> list, Object... objArr) {
        Collections.reverse(list);
        return list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.util.Comparator} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object sort(java.util.List<java.lang.Object> r3, java.lang.Object... r4) {
        /*
            r2 = this;
            r0 = 0
            r1 = 0
            java.lang.Object r4 = org.xidea.p087el.p088fn.JSObject.getArg(r4, r0, r1)
            boolean r0 = r4 instanceof java.util.Comparator
            if (r0 == 0) goto L_0x000d
            r1 = r4
            java.util.Comparator r1 = (java.util.Comparator) r1
        L_0x000d:
            java.util.Collections.sort(r3, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xidea.p087el.p088fn.JSArray.sort(java.util.List, java.lang.Object[]):java.lang.Object");
    }
}
