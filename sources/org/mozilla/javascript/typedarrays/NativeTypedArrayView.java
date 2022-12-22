package org.mozilla.javascript.typedarrays;

import com.didi.soda.customer.p165h5.hybird.model.GuideParamModel;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ExternalArrayData;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.NativeArray;
import org.mozilla.javascript.ScriptRuntime;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.Undefined;

public abstract class NativeTypedArrayView<T> extends NativeArrayBufferView implements List<T>, RandomAccess, ExternalArrayData {
    private static final int Id_BYTES_PER_ELEMENT = 11;
    private static final int Id_constructor = 1;
    private static final int Id_get = 2;
    private static final int Id_length = 10;
    private static final int Id_set = 3;
    private static final int Id_subarray = 4;
    private static final int MAX_INSTANCE_ID = 11;
    protected static final int MAX_PROTOTYPE_ID = 4;
    protected final int length;

    /* access modifiers changed from: protected */
    public abstract NativeTypedArrayView construct(NativeArrayBuffer nativeArrayBuffer, int i, int i2);

    public void delete(int i) {
    }

    public abstract int getBytesPerElement();

    /* access modifiers changed from: protected */
    public int getMaxInstanceId() {
        return 11;
    }

    /* access modifiers changed from: protected */
    public abstract Object js_get(int i);

    /* access modifiers changed from: protected */
    public abstract Object js_set(int i, Object obj);

    /* access modifiers changed from: protected */
    public abstract NativeTypedArrayView realThis(Scriptable scriptable, IdFunctionObject idFunctionObject);

    protected NativeTypedArrayView() {
        this.length = 0;
    }

    protected NativeTypedArrayView(NativeArrayBuffer nativeArrayBuffer, int i, int i2, int i3) {
        super(nativeArrayBuffer, i, i3);
        this.length = i2;
    }

    public Object get(int i, Scriptable scriptable) {
        return js_get(i);
    }

    public boolean has(int i, Scriptable scriptable) {
        return i > 0 && i < this.length;
    }

    public void put(int i, Scriptable scriptable, Object obj) {
        js_set(i, obj);
    }

    public Object[] getIds() {
        Object[] objArr = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            objArr[i] = Integer.valueOf(i);
        }
        return objArr;
    }

    /* access modifiers changed from: protected */
    public boolean checkIndex(int i) {
        return i < 0 || i >= this.length;
    }

    private NativeArrayBuffer makeArrayBuffer(Context context, Scriptable scriptable, int i) {
        return (NativeArrayBuffer) context.newObject(scriptable, NativeArrayBuffer.CLASS_NAME, new Object[]{Integer.valueOf(i)});
    }

    private NativeTypedArrayView js_constructor(Context context, Scriptable scriptable, Object[] objArr) {
        int i;
        int i2 = 0;
        if (!isArg(objArr, 0)) {
            return construct(NativeArrayBuffer.EMPTY_BUFFER, 0, 0);
        }
        if ((objArr[0] instanceof Number) || (objArr[0] instanceof String)) {
            int int32 = ScriptRuntime.toInt32(objArr[0]);
            return construct(makeArrayBuffer(context, scriptable, getBytesPerElement() * int32), 0, int32);
        } else if (objArr[0] instanceof NativeTypedArrayView) {
            NativeTypedArrayView nativeTypedArrayView = objArr[0];
            NativeTypedArrayView construct = construct(makeArrayBuffer(context, scriptable, nativeTypedArrayView.length * getBytesPerElement()), 0, nativeTypedArrayView.length);
            while (i2 < nativeTypedArrayView.length) {
                construct.js_set(i2, nativeTypedArrayView.js_get(i2));
                i2++;
            }
            return construct;
        } else if (objArr[0] instanceof NativeArrayBuffer) {
            NativeArrayBuffer nativeArrayBuffer = objArr[0];
            if (isArg(objArr, 1)) {
                i2 = ScriptRuntime.toInt32(objArr[1]);
            }
            if (isArg(objArr, 2)) {
                i = ScriptRuntime.toInt32(objArr[2]) * getBytesPerElement();
            } else {
                i = nativeArrayBuffer.getLength() - i2;
            }
            if (i2 < 0 || i2 > nativeArrayBuffer.buffer.length) {
                throw ScriptRuntime.constructError("RangeError", "offset out of range");
            } else if (i < 0 || i2 + i > nativeArrayBuffer.buffer.length) {
                throw ScriptRuntime.constructError("RangeError", "length out of range");
            } else if (i2 % getBytesPerElement() != 0) {
                throw ScriptRuntime.constructError("RangeError", "offset must be a multiple of the byte size");
            } else if (i % getBytesPerElement() == 0) {
                return construct(nativeArrayBuffer, i2, i / getBytesPerElement());
            } else {
                throw ScriptRuntime.constructError("RangeError", "offset and buffer must be a multiple of the byte size");
            }
        } else if (objArr[0] instanceof NativeArray) {
            List<Object> list = objArr[0];
            NativeTypedArrayView construct2 = construct(makeArrayBuffer(context, scriptable, list.size() * getBytesPerElement()), 0, list.size());
            for (Object js_set : list) {
                construct2.js_set(i2, js_set);
                i2++;
            }
            return construct2;
        } else {
            throw ScriptRuntime.constructError("Error", "invalid argument");
        }
    }

    private void setRange(NativeTypedArrayView nativeTypedArrayView, int i) {
        int i2 = this.length;
        if (i >= i2) {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        } else if (nativeTypedArrayView.length <= i2 - i) {
            int i3 = 0;
            if (nativeTypedArrayView.arrayBuffer == this.arrayBuffer) {
                Object[] objArr = new Object[nativeTypedArrayView.length];
                for (int i4 = 0; i4 < nativeTypedArrayView.length; i4++) {
                    objArr[i4] = nativeTypedArrayView.js_get(i4);
                }
                while (i3 < nativeTypedArrayView.length) {
                    js_set(i3 + i, objArr[i3]);
                    i3++;
                }
                return;
            }
            while (i3 < nativeTypedArrayView.length) {
                js_set(i3 + i, nativeTypedArrayView.js_get(i3));
                i3++;
            }
        } else {
            throw ScriptRuntime.constructError("RangeError", "source array too long");
        }
    }

    private void setRange(NativeArray nativeArray, int i) {
        if (i > this.length) {
            throw ScriptRuntime.constructError("RangeError", "offset out of range");
        } else if (nativeArray.size() + i <= this.length) {
            Iterator it = nativeArray.iterator();
            while (it.hasNext()) {
                js_set(i, it.next());
                i++;
            }
        } else {
            throw ScriptRuntime.constructError("RangeError", "offset + length out of range");
        }
    }

    private Object js_subarray(Context context, Scriptable scriptable, int i, int i2) {
        if (i < 0) {
            i += this.length;
        }
        if (i2 < 0) {
            i2 += this.length;
        }
        int max = Math.max(0, i);
        int max2 = Math.max(0, Math.min(this.length, i2) - max);
        int min = Math.min(max * getBytesPerElement(), this.arrayBuffer.getLength());
        return context.newObject(scriptable, getClassName(), new Object[]{this.arrayBuffer, Integer.valueOf(min), Integer.valueOf(max2)});
    }

    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(getClassName())) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId == 1) {
            return js_constructor(context, scriptable, objArr);
        }
        if (methodId != 2) {
            if (methodId == 3) {
                if (objArr.length > 0) {
                    NativeTypedArrayView realThis = realThis(scriptable2, idFunctionObject);
                    if (objArr[0] instanceof NativeTypedArrayView) {
                        realThis.setRange(objArr[0], isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0);
                        return Undefined.instance;
                    } else if (objArr[0] instanceof NativeArray) {
                        realThis.setRange(objArr[0], isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0);
                        return Undefined.instance;
                    } else if (objArr[0] instanceof Scriptable) {
                        return Undefined.instance;
                    } else {
                        if (isArg(objArr, 2)) {
                            return realThis.js_set(ScriptRuntime.toInt32(objArr[0]), objArr[1]);
                        }
                    }
                }
                throw ScriptRuntime.constructError("Error", "invalid arguments");
            } else if (methodId != 4) {
                throw new IllegalArgumentException(String.valueOf(methodId));
            } else if (objArr.length > 0) {
                NativeTypedArrayView realThis2 = realThis(scriptable2, idFunctionObject);
                return realThis2.js_subarray(context, scriptable, ScriptRuntime.toInt32(objArr[0]), isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : realThis2.length);
            } else {
                throw ScriptRuntime.constructError("Error", "invalid arguments");
            }
        } else if (objArr.length > 0) {
            return realThis(scriptable2, idFunctionObject).js_get(ScriptRuntime.toInt32(objArr[0]));
        } else {
            throw ScriptRuntime.constructError("Error", "invalid arguments");
        }
    }

    /* access modifiers changed from: protected */
    public void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 2;
        if (i == 1) {
            str2 = "constructor";
        } else if (i != 2) {
            if (i == 3) {
                str = GuideParamModel.ACTION_SET;
            } else if (i == 4) {
                str = "subarray";
            } else {
                throw new IllegalArgumentException(String.valueOf(i));
            }
            initPrototypeMethod(getClassName(), i, str, i2);
        } else {
            str2 = "get";
        }
        str = str2;
        i2 = 1;
        initPrototypeMethod(getClassName(), i, str, i2);
    }

    /* access modifiers changed from: protected */
    public int findPrototypeId(String str) {
        String str2;
        int i;
        int length2 = str.length();
        if (length2 == 3) {
            char charAt = str.charAt(0);
            if (charAt == 'g') {
                if (str.charAt(2) == 't' && str.charAt(1) == 'e') {
                    return 2;
                }
            } else if (charAt == 's' && str.charAt(2) == 't' && str.charAt(1) == 'e') {
                return 3;
            }
        } else {
            if (length2 == 8) {
                i = 4;
                str2 = "subarray";
            } else if (length2 == 11) {
                str2 = "constructor";
                i = 1;
            }
            if (str2 != null || str2 == str || str2.equals(str)) {
                return i;
            }
            return 0;
        }
        str2 = null;
        i = 0;
        if (str2 != null) {
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        idFunctionObject.put("BYTES_PER_ELEMENT", idFunctionObject, ScriptRuntime.wrapInt(getBytesPerElement()));
    }

    /* access modifiers changed from: protected */
    public String getInstanceIdName(int i) {
        if (i != 10) {
            return i != 11 ? super.getInstanceIdName(i) : "BYTES_PER_ELEMENT";
        }
        return "length";
    }

    /* access modifiers changed from: protected */
    public Object getInstanceIdValue(int i) {
        if (i == 10) {
            return ScriptRuntime.wrapInt(this.length);
        }
        if (i != 11) {
            return super.getInstanceIdValue(i);
        }
        return ScriptRuntime.wrapInt(getBytesPerElement());
    }

    /* access modifiers changed from: protected */
    public int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int length2 = str.length();
        int i2 = 0;
        if (length2 == 6) {
            i = 10;
            str2 = "length";
        } else if (length2 == 17) {
            i = 11;
            str2 = "BYTES_PER_ELEMENT";
        } else {
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            i2 = i;
        }
        if (i2 == 0) {
            return super.findInstanceIdInfo(str);
        }
        return instanceIdInfo(5, i2);
    }

    public Object getArrayElement(int i) {
        return js_get(i);
    }

    public void setArrayElement(int i, Object obj) {
        js_set(i, obj);
    }

    public int getArrayLength() {
        return this.length;
    }

    public int size() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < this.length; i++) {
            if (obj.equals(js_get(i))) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        for (int i = this.length - 1; i >= 0; i--) {
            if (obj.equals(js_get(i))) {
                return i;
            }
        }
        return -1;
    }

    public Object[] toArray() {
        Object[] objArr = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            objArr[i] = js_get(i);
        }
        return objArr;
    }

    public <U> U[] toArray(U[] uArr) {
        if (uArr.length < this.length) {
            uArr = (Object[]) Array.newInstance(uArr.getClass().getComponentType(), this.length);
        }
        int i = 0;
        while (i < this.length) {
            try {
                uArr[i] = js_get(i);
                i++;
            } catch (ClassCastException unused) {
                throw new ArrayStoreException();
            }
        }
        return uArr;
    }

    public boolean equals(Object obj) {
        try {
            NativeTypedArrayView nativeTypedArrayView = (NativeTypedArrayView) obj;
            if (this.length != nativeTypedArrayView.length) {
                return false;
            }
            for (int i = 0; i < this.length; i++) {
                if (!js_get(i).equals(nativeTypedArrayView.js_get(i))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        for (int i = 0; i < this.length; i++) {
            js_get(i).hashCode();
        }
        return 0;
    }

    public Iterator<T> iterator() {
        return new NativeTypedArrayIterator(this, 0);
    }

    public ListIterator<T> listIterator() {
        return new NativeTypedArrayIterator(this, 0);
    }

    public ListIterator<T> listIterator(int i) {
        if (!checkIndex(i)) {
            return new NativeTypedArrayIterator(this, i);
        }
        throw new IndexOutOfBoundsException();
    }

    public List<T> subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    public void add(int i, T t) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i, Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public T remove(int i) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }
}
