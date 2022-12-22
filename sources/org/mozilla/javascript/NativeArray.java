package org.mozilla.javascript;

import android.support.p003v4.media.session.PlaybackStateCompat;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import net.lingala.zip4j.util.InternalZipConstants;
import org.mozilla.javascript.TopLevel;

public class NativeArray extends IdScriptableObject implements List {
    private static final Object ARRAY_TAG = "Array";
    private static final int ConstructorId_concat = -13;
    private static final int ConstructorId_every = -17;
    private static final int ConstructorId_filter = -18;
    private static final int ConstructorId_find = -22;
    private static final int ConstructorId_findIndex = -23;
    private static final int ConstructorId_forEach = -19;
    private static final int ConstructorId_indexOf = -15;
    private static final int ConstructorId_isArray = -26;
    private static final int ConstructorId_join = -5;
    private static final int ConstructorId_lastIndexOf = -16;
    private static final int ConstructorId_map = -20;
    private static final int ConstructorId_pop = -9;
    private static final int ConstructorId_push = -8;
    private static final int ConstructorId_reduce = -24;
    private static final int ConstructorId_reduceRight = -25;
    private static final int ConstructorId_reverse = -6;
    private static final int ConstructorId_shift = -10;
    private static final int ConstructorId_slice = -14;
    private static final int ConstructorId_some = -21;
    private static final int ConstructorId_sort = -7;
    private static final int ConstructorId_splice = -12;
    private static final int ConstructorId_unshift = -11;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final double GROW_FACTOR = 1.5d;
    private static final int Id_concat = 13;
    private static final int Id_constructor = 1;
    private static final int Id_every = 17;
    private static final int Id_filter = 18;
    private static final int Id_find = 22;
    private static final int Id_findIndex = 23;
    private static final int Id_forEach = 19;
    private static final int Id_indexOf = 15;
    private static final int Id_join = 5;
    private static final int Id_lastIndexOf = 16;
    private static final int Id_length = 1;
    private static final int Id_map = 20;
    private static final int Id_pop = 9;
    private static final int Id_push = 8;
    private static final int Id_reduce = 24;
    private static final int Id_reduceRight = 25;
    private static final int Id_reverse = 6;
    private static final int Id_shift = 10;
    private static final int Id_slice = 14;
    private static final int Id_some = 21;
    private static final int Id_sort = 7;
    private static final int Id_splice = 12;
    private static final int Id_toLocaleString = 3;
    private static final int Id_toSource = 4;
    private static final int Id_toString = 2;
    private static final int Id_unshift = 11;
    private static final int MAX_INSTANCE_ID = 1;
    private static final int MAX_PRE_GROW_SIZE = 1431655764;
    private static final int MAX_PROTOTYPE_ID = 25;
    private static final Integer NEGATIVE_ONE = -1;
    private static int maximumInitialCapacity = 10000;
    static final long serialVersionUID = 7331366857676127338L;
    private Object[] dense;
    private boolean denseOnly;
    private long length;
    private int lengthAttr;

    private static long toSliceIndex(double d, long j) {
        if (d < 0.0d) {
            d += (double) j;
            if (d < 0.0d) {
                return 0;
            }
        } else if (d > ((double) j)) {
            return j;
        }
        return (long) d;
    }

    public String getClassName() {
        return "Array";
    }

    /* access modifiers changed from: protected */
    public int getMaxInstanceId() {
        return 1;
    }

    static void init(Scriptable scriptable, boolean z) {
        new NativeArray(0).exportAsJSClass(25, scriptable, z);
    }

    static int getMaximumInitialCapacity() {
        return maximumInitialCapacity;
    }

    static void setMaximumInitialCapacity(int i) {
        maximumInitialCapacity = i;
    }

    public NativeArray(long j) {
        this.lengthAttr = 6;
        boolean z = j <= ((long) maximumInitialCapacity);
        this.denseOnly = z;
        if (z) {
            int i = (int) j;
            Object[] objArr = new Object[(i < 10 ? 10 : i)];
            this.dense = objArr;
            Arrays.fill(objArr, Scriptable.NOT_FOUND);
        }
        this.length = j;
    }

    public NativeArray(Object[] objArr) {
        this.lengthAttr = 6;
        this.denseOnly = true;
        this.dense = objArr;
        this.length = (long) objArr.length;
    }

    /* access modifiers changed from: protected */
    public void setInstanceIdAttributes(int i, int i2) {
        if (i == 1) {
            this.lengthAttr = i2;
        }
    }

    /* access modifiers changed from: protected */
    public int findInstanceIdInfo(String str) {
        if (str.equals("length")) {
            return instanceIdInfo(this.lengthAttr, 1);
        }
        return super.findInstanceIdInfo(str);
    }

    /* access modifiers changed from: protected */
    public String getInstanceIdName(int i) {
        return i == 1 ? "length" : super.getInstanceIdName(i);
    }

    /* access modifiers changed from: protected */
    public Object getInstanceIdValue(int i) {
        if (i == 1) {
            return ScriptRuntime.wrapNumber((double) this.length);
        }
        return super.getInstanceIdValue(i);
    }

    /* access modifiers changed from: protected */
    public void setInstanceIdValue(int i, Object obj) {
        if (i == 1) {
            setLength(obj);
        } else {
            super.setInstanceIdValue(i, obj);
        }
    }

    /* access modifiers changed from: protected */
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        IdFunctionObject idFunctionObject2 = idFunctionObject;
        addIdFunctionProperty(idFunctionObject2, ARRAY_TAG, -5, SDKConsts.ACTION_VALUE_JOIN, 1);
        IdFunctionObject idFunctionObject3 = idFunctionObject;
        addIdFunctionProperty(idFunctionObject3, ARRAY_TAG, -6, "reverse", 0);
        addIdFunctionProperty(idFunctionObject2, ARRAY_TAG, -7, "sort", 1);
        addIdFunctionProperty(idFunctionObject3, ARRAY_TAG, -8, "push", 1);
        addIdFunctionProperty(idFunctionObject2, ARRAY_TAG, -9, "pop", 0);
        addIdFunctionProperty(idFunctionObject3, ARRAY_TAG, -10, "shift", 0);
        addIdFunctionProperty(idFunctionObject2, ARRAY_TAG, -11, "unshift", 1);
        addIdFunctionProperty(idFunctionObject3, ARRAY_TAG, -12, "splice", 2);
        addIdFunctionProperty(idFunctionObject2, ARRAY_TAG, -13, "concat", 1);
        addIdFunctionProperty(idFunctionObject3, ARRAY_TAG, -14, "slice", 2);
        addIdFunctionProperty(idFunctionObject2, ARRAY_TAG, -15, "indexOf", 1);
        addIdFunctionProperty(idFunctionObject3, ARRAY_TAG, -16, "lastIndexOf", 1);
        addIdFunctionProperty(idFunctionObject2, ARRAY_TAG, -17, "every", 1);
        addIdFunctionProperty(idFunctionObject3, ARRAY_TAG, -18, "filter", 1);
        addIdFunctionProperty(idFunctionObject2, ARRAY_TAG, -19, "forEach", 1);
        addIdFunctionProperty(idFunctionObject3, ARRAY_TAG, -20, "map", 1);
        addIdFunctionProperty(idFunctionObject2, ARRAY_TAG, -21, "some", 1);
        addIdFunctionProperty(idFunctionObject3, ARRAY_TAG, -22, "find", 1);
        addIdFunctionProperty(idFunctionObject2, ARRAY_TAG, -23, "findIndex", 1);
        addIdFunctionProperty(idFunctionObject3, ARRAY_TAG, -24, "reduce", 1);
        addIdFunctionProperty(idFunctionObject2, ARRAY_TAG, -25, "reduceRight", 1);
        addIdFunctionProperty(idFunctionObject3, ARRAY_TAG, -26, "isArray", 1);
        super.fillConstructorProperties(idFunctionObject);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        r0 = r1;
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0062, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0066, code lost:
        initPrototypeMethod(ARRAY_TAG, r4, r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initPrototypeId(int r4) {
        /*
            r3 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            switch(r4) {
                case 1: goto L_0x0064;
                case 2: goto L_0x005f;
                case 3: goto L_0x005b;
                case 4: goto L_0x0057;
                case 5: goto L_0x0054;
                case 6: goto L_0x0051;
                case 7: goto L_0x004d;
                case 8: goto L_0x004a;
                case 9: goto L_0x0047;
                case 10: goto L_0x0043;
                case 11: goto L_0x003f;
                case 12: goto L_0x0039;
                case 13: goto L_0x0036;
                case 14: goto L_0x0032;
                case 15: goto L_0x002f;
                case 16: goto L_0x002c;
                case 17: goto L_0x0029;
                case 18: goto L_0x0026;
                case 19: goto L_0x0023;
                case 20: goto L_0x0020;
                case 21: goto L_0x001c;
                case 22: goto L_0x0019;
                case 23: goto L_0x0016;
                case 24: goto L_0x0013;
                case 25: goto L_0x0010;
                default: goto L_0x0006;
            }
        L_0x0006:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r0.<init>(r4)
            throw r0
        L_0x0010:
            java.lang.String r0 = "reduceRight"
            goto L_0x0066
        L_0x0013:
            java.lang.String r0 = "reduce"
            goto L_0x0066
        L_0x0016:
            java.lang.String r0 = "findIndex"
            goto L_0x0066
        L_0x0019:
            java.lang.String r0 = "find"
            goto L_0x0066
        L_0x001c:
            java.lang.String r0 = "some"
            goto L_0x0066
        L_0x0020:
            java.lang.String r0 = "map"
            goto L_0x0066
        L_0x0023:
            java.lang.String r0 = "forEach"
            goto L_0x0066
        L_0x0026:
            java.lang.String r0 = "filter"
            goto L_0x0066
        L_0x0029:
            java.lang.String r0 = "every"
            goto L_0x0066
        L_0x002c:
            java.lang.String r0 = "lastIndexOf"
            goto L_0x0066
        L_0x002f:
            java.lang.String r0 = "indexOf"
            goto L_0x0066
        L_0x0032:
            java.lang.String r1 = "slice"
            goto L_0x003c
        L_0x0036:
            java.lang.String r0 = "concat"
            goto L_0x0066
        L_0x0039:
            java.lang.String r1 = "splice"
        L_0x003c:
            r0 = r1
            r2 = 2
            goto L_0x0066
        L_0x003f:
            java.lang.String r0 = "unshift"
            goto L_0x0066
        L_0x0043:
            java.lang.String r0 = "shift"
            goto L_0x0062
        L_0x0047:
            java.lang.String r0 = "pop"
            goto L_0x0062
        L_0x004a:
            java.lang.String r0 = "push"
            goto L_0x0066
        L_0x004d:
            java.lang.String r0 = "sort"
            goto L_0x0066
        L_0x0051:
            java.lang.String r0 = "reverse"
            goto L_0x0062
        L_0x0054:
            java.lang.String r0 = "join"
            goto L_0x0066
        L_0x0057:
            java.lang.String r0 = "toSource"
            goto L_0x0062
        L_0x005b:
            java.lang.String r0 = "toLocaleString"
            goto L_0x0062
        L_0x005f:
            java.lang.String r0 = "toString"
        L_0x0062:
            r2 = 0
            goto L_0x0066
        L_0x0064:
            java.lang.String r0 = "constructor"
        L_0x0066:
            java.lang.Object r1 = ARRAY_TAG
            r3.initPrototypeMethod(r1, r4, r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.initPrototypeId(int):void");
    }

    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(ARRAY_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        while (true) {
            boolean z = true;
            int i = 0;
            switch (methodId) {
                case -26:
                    if (objArr.length <= 0 || !js_isArray(objArr[0])) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case -25:
                case -24:
                case -23:
                case -22:
                case -21:
                case -20:
                case -19:
                case -18:
                case -17:
                case -16:
                case -15:
                case -14:
                case -13:
                case -12:
                case -11:
                case -10:
                case -9:
                case -8:
                case -7:
                case -6:
                case -5:
                    if (objArr.length > 0) {
                        scriptable2 = ScriptRuntime.toObject(context, scriptable, objArr[0]);
                        int length2 = objArr.length - 1;
                        Object[] objArr2 = new Object[length2];
                        while (i < length2) {
                            int i2 = i + 1;
                            objArr2[i] = objArr[i2];
                            i = i2;
                        }
                        objArr = objArr2;
                    }
                    methodId = -methodId;
                default:
                    switch (methodId) {
                        case 1:
                            if (scriptable2 != null) {
                                z = false;
                            }
                            if (!z) {
                                return idFunctionObject.construct(context, scriptable, objArr);
                            }
                            return jsConstructor(context, scriptable, objArr);
                        case 2:
                            return toStringHelper(context, scriptable, scriptable2, context.hasFeature(4), false);
                        case 3:
                            return toStringHelper(context, scriptable, scriptable2, false, true);
                        case 4:
                            return toStringHelper(context, scriptable, scriptable2, true, false);
                        case 5:
                            return js_join(context, scriptable2, objArr);
                        case 6:
                            return js_reverse(context, scriptable2, objArr);
                        case 7:
                            return js_sort(context, scriptable, scriptable2, objArr);
                        case 8:
                            return js_push(context, scriptable2, objArr);
                        case 9:
                            return js_pop(context, scriptable2, objArr);
                        case 10:
                            return js_shift(context, scriptable2, objArr);
                        case 11:
                            return js_unshift(context, scriptable2, objArr);
                        case 12:
                            return js_splice(context, scriptable, scriptable2, objArr);
                        case 13:
                            return js_concat(context, scriptable, scriptable2, objArr);
                        case 14:
                            return js_slice(context, scriptable2, objArr);
                        case 15:
                            return js_indexOf(context, scriptable2, objArr);
                        case 16:
                            return js_lastIndexOf(context, scriptable2, objArr);
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                            return iterativeMethod(context, methodId, scriptable, scriptable2, objArr);
                        case 24:
                        case 25:
                            return reduceMethod(context, methodId, scriptable, scriptable2, objArr);
                        default:
                            throw new IllegalArgumentException(String.valueOf(methodId));
                    }
            }
        }
    }

    public Object get(int i, Scriptable scriptable) {
        if (!this.denseOnly && isGetterOrSetter((String) null, i, false)) {
            return super.get(i, scriptable);
        }
        Object[] objArr = this.dense;
        if (objArr == null || i < 0 || i >= objArr.length) {
            return super.get(i, scriptable);
        }
        return objArr[i];
    }

    public boolean has(int i, Scriptable scriptable) {
        if (!this.denseOnly && isGetterOrSetter((String) null, i, false)) {
            return super.has(i, scriptable);
        }
        Object[] objArr = this.dense;
        if (objArr == null || i < 0 || i >= objArr.length) {
            return super.has(i, scriptable);
        }
        if (objArr[i] != NOT_FOUND) {
            return true;
        }
        return false;
    }

    private static long toArrayIndex(Object obj) {
        if (obj instanceof String) {
            return toArrayIndex((String) obj);
        }
        if (obj instanceof Number) {
            return toArrayIndex(((Number) obj).doubleValue());
        }
        return -1;
    }

    private static long toArrayIndex(String str) {
        long arrayIndex = toArrayIndex(ScriptRuntime.toNumber(str));
        if (Long.toString(arrayIndex).equals(str)) {
            return arrayIndex;
        }
        return -1;
    }

    private static long toArrayIndex(double d) {
        if (d != d) {
            return -1;
        }
        long uint32 = ScriptRuntime.toUint32(d);
        if (((double) uint32) != d || uint32 == InternalZipConstants.ZIP_64_SIZE_LIMIT) {
            return -1;
        }
        return uint32;
    }

    private static int toDenseIndex(Object obj) {
        long arrayIndex = toArrayIndex(obj);
        if (0 > arrayIndex || arrayIndex >= 2147483647L) {
            return -1;
        }
        return (int) arrayIndex;
    }

    public void put(String str, Scriptable scriptable, Object obj) {
        super.put(str, scriptable, obj);
        if (scriptable == this) {
            long arrayIndex = toArrayIndex(str);
            if (arrayIndex >= this.length) {
                this.length = arrayIndex + 1;
                this.denseOnly = false;
            }
        }
    }

    private boolean ensureCapacity(int i) {
        Object[] objArr = this.dense;
        if (i <= objArr.length) {
            return true;
        }
        if (i > MAX_PRE_GROW_SIZE) {
            this.denseOnly = false;
            return false;
        }
        int max = Math.max(i, (int) (((double) objArr.length) * GROW_FACTOR));
        Object[] objArr2 = new Object[max];
        Object[] objArr3 = this.dense;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        Arrays.fill(objArr2, this.dense.length, max, Scriptable.NOT_FOUND);
        this.dense = objArr2;
        return true;
    }

    public void put(int i, Scriptable scriptable, Object obj) {
        if (scriptable == this && !isSealed() && this.dense != null && i >= 0 && (this.denseOnly || !isGetterOrSetter((String) null, i, true))) {
            if (isExtensible() || this.length > ((long) i)) {
                Object[] objArr = this.dense;
                if (i < objArr.length) {
                    objArr[i] = obj;
                    long j = (long) i;
                    if (this.length <= j) {
                        this.length = j + 1;
                        return;
                    }
                    return;
                } else if (!this.denseOnly || ((double) i) >= ((double) objArr.length) * GROW_FACTOR || !ensureCapacity(i + 1)) {
                    this.denseOnly = false;
                } else {
                    this.dense[i] = obj;
                    this.length = ((long) i) + 1;
                    return;
                }
            } else {
                return;
            }
        }
        super.put(i, scriptable, obj);
        if (scriptable == this && (this.lengthAttr & 1) == 0) {
            long j2 = (long) i;
            if (this.length <= j2) {
                this.length = j2 + 1;
            }
        }
    }

    public void delete(int i) {
        Object[] objArr = this.dense;
        if (objArr == null || i < 0 || i >= objArr.length || isSealed() || (!this.denseOnly && isGetterOrSetter((String) null, i, true))) {
            super.delete(i);
        } else {
            this.dense[i] = NOT_FOUND;
        }
    }

    public Object[] getIds() {
        Object[] ids = super.getIds();
        Object[] objArr = this.dense;
        if (objArr == null) {
            return ids;
        }
        int length2 = objArr.length;
        long j = this.length;
        if (((long) length2) > j) {
            length2 = (int) j;
        }
        if (length2 == 0) {
            return ids;
        }
        int length3 = ids.length;
        Object[] objArr2 = new Object[(length2 + length3)];
        int i = 0;
        for (int i2 = 0; i2 != length2; i2++) {
            if (this.dense[i2] != NOT_FOUND) {
                objArr2[i] = Integer.valueOf(i2);
                i++;
            }
        }
        if (i != length2) {
            Object[] objArr3 = new Object[(i + length3)];
            System.arraycopy(objArr2, 0, objArr3, 0, i);
            objArr2 = objArr3;
        }
        System.arraycopy(ids, 0, objArr2, i, length3);
        return objArr2;
    }

    public Object[] getAllIds() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(getIds()));
        linkedHashSet.addAll(Arrays.asList(super.getAllIds()));
        return linkedHashSet.toArray();
    }

    public Integer[] getIndexIds() {
        Object[] ids = getIds();
        ArrayList arrayList = new ArrayList(ids.length);
        for (Object obj : ids) {
            int int32 = ScriptRuntime.toInt32(obj);
            if (int32 >= 0 && ScriptRuntime.toString((double) int32).equals(ScriptRuntime.toString(obj))) {
                arrayList.add(Integer.valueOf(int32));
            }
        }
        return (Integer[]) arrayList.toArray(new Integer[arrayList.size()]);
    }

    public Object getDefaultValue(Class<?> cls) {
        if (cls == ScriptRuntime.NumberClass && Context.getContext().getLanguageVersion() == 120) {
            return Long.valueOf(this.length);
        }
        return super.getDefaultValue(cls);
    }

    private ScriptableObject defaultIndexPropertyDescriptor(Object obj) {
        Scriptable parentScope = getParentScope();
        if (parentScope == null) {
            parentScope = this;
        }
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, parentScope, TopLevel.Builtins.Object);
        nativeObject.defineProperty("value", obj, 0);
        nativeObject.defineProperty("writable", (Object) true, 0);
        nativeObject.defineProperty("enumerable", (Object) true, 0);
        nativeObject.defineProperty("configurable", (Object) true, 0);
        return nativeObject;
    }

    public int getAttributes(int i) {
        Object[] objArr = this.dense;
        if (objArr == null || i < 0 || i >= objArr.length || objArr[i] == NOT_FOUND) {
            return super.getAttributes(i);
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public ScriptableObject getOwnPropertyDescriptor(Context context, Object obj) {
        int denseIndex;
        if (this.dense != null && (denseIndex = toDenseIndex(obj)) >= 0) {
            Object[] objArr = this.dense;
            if (denseIndex < objArr.length && objArr[denseIndex] != NOT_FOUND) {
                return defaultIndexPropertyDescriptor(this.dense[denseIndex]);
            }
        }
        return super.getOwnPropertyDescriptor(context, obj);
    }

    /* access modifiers changed from: protected */
    public void defineOwnProperty(Context context, Object obj, ScriptableObject scriptableObject, boolean z) {
        Object[] objArr = this.dense;
        if (objArr != null) {
            this.dense = null;
            this.denseOnly = false;
            for (int i = 0; i < objArr.length; i++) {
                if (objArr[i] != NOT_FOUND) {
                    put(i, (Scriptable) this, objArr[i]);
                }
            }
        }
        long arrayIndex = toArrayIndex(obj);
        if (arrayIndex >= this.length) {
            this.length = arrayIndex + 1;
        }
        super.defineOwnProperty(context, obj, scriptableObject, z);
    }

    private static Object jsConstructor(Context context, Scriptable scriptable, Object[] objArr) {
        if (objArr.length == 0) {
            return new NativeArray(0);
        }
        if (context.getLanguageVersion() == 120) {
            return new NativeArray(objArr);
        }
        Number number = objArr[0];
        if (objArr.length > 1 || !(number instanceof Number)) {
            return new NativeArray(objArr);
        }
        long uint32 = ScriptRuntime.toUint32((Object) number);
        if (((double) uint32) == number.doubleValue()) {
            return new NativeArray(uint32);
        }
        throw ScriptRuntime.constructError("RangeError", ScriptRuntime.getMessage0("msg.arraylength.bad"));
    }

    public long getLength() {
        return this.length;
    }

    @Deprecated
    public long jsGet_length() {
        return getLength();
    }

    /* access modifiers changed from: package-private */
    public void setDenseOnly(boolean z) {
        if (!z || this.denseOnly) {
            this.denseOnly = z;
            return;
        }
        throw new IllegalArgumentException();
    }

    private void setLength(Object obj) {
        if ((this.lengthAttr & 1) == 0) {
            double number = ScriptRuntime.toNumber(obj);
            long uint32 = ScriptRuntime.toUint32(number);
            double d = (double) uint32;
            if (d == number) {
                if (this.denseOnly) {
                    long j = this.length;
                    if (uint32 < j) {
                        Object[] objArr = this.dense;
                        Arrays.fill(objArr, (int) uint32, objArr.length, NOT_FOUND);
                        this.length = uint32;
                        return;
                    } else if (uint32 >= 1431655764 || d >= ((double) j) * GROW_FACTOR || !ensureCapacity((int) uint32)) {
                        this.denseOnly = false;
                    } else {
                        this.length = uint32;
                        return;
                    }
                }
                long j2 = this.length;
                if (uint32 < j2) {
                    if (j2 - uint32 > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
                        Object[] ids = getIds();
                        for (Object obj2 : ids) {
                            if (obj2 instanceof String) {
                                String str = (String) obj2;
                                if (toArrayIndex(str) >= uint32) {
                                    delete(str);
                                }
                            } else {
                                int intValue = ((Integer) obj2).intValue();
                                if (((long) intValue) >= uint32) {
                                    delete(intValue);
                                }
                            }
                        }
                    } else {
                        for (long j3 = uint32; j3 < this.length; j3++) {
                            deleteElem(this, j3);
                        }
                    }
                }
                this.length = uint32;
                return;
            }
            throw ScriptRuntime.constructError("RangeError", ScriptRuntime.getMessage0("msg.arraylength.bad"));
        }
    }

    static long getLengthProperty(Context context, Scriptable scriptable) {
        if (scriptable instanceof NativeString) {
            return (long) ((NativeString) scriptable).getLength();
        }
        if (scriptable instanceof NativeArray) {
            return ((NativeArray) scriptable).getLength();
        }
        Object property = ScriptableObject.getProperty(scriptable, "length");
        if (property == Scriptable.NOT_FOUND) {
            return 0;
        }
        return ScriptRuntime.toUint32(property);
    }

    private static Object setLengthProperty(Context context, Scriptable scriptable, long j) {
        Number wrapNumber = ScriptRuntime.wrapNumber((double) j);
        ScriptableObject.putProperty(scriptable, "length", (Object) wrapNumber);
        return wrapNumber;
    }

    private static void deleteElem(Scriptable scriptable, long j) {
        int i = (int) j;
        if (((long) i) == j) {
            scriptable.delete(i);
        } else {
            scriptable.delete(Long.toString(j));
        }
    }

    private static Object getElem(Context context, Scriptable scriptable, long j) {
        Object rawElem = getRawElem(scriptable, j);
        return rawElem != Scriptable.NOT_FOUND ? rawElem : Undefined.instance;
    }

    private static Object getRawElem(Scriptable scriptable, long j) {
        if (j > 2147483647L) {
            return ScriptableObject.getProperty(scriptable, Long.toString(j));
        }
        return ScriptableObject.getProperty(scriptable, (int) j);
    }

    private static void defineElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (j > 2147483647L) {
            scriptable.put(Long.toString(j), scriptable, obj);
        } else {
            scriptable.put((int) j, scriptable, obj);
        }
    }

    private static void setElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (j > 2147483647L) {
            ScriptableObject.putProperty(scriptable, Long.toString(j), obj);
        } else {
            ScriptableObject.putProperty(scriptable, (int) j, obj);
        }
    }

    private static void setRawElem(Context context, Scriptable scriptable, long j, Object obj) {
        if (obj == NOT_FOUND) {
            deleteElem(scriptable, j);
        } else {
            setElem(context, scriptable, j, obj);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054 A[Catch:{ all -> 0x00bb }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String toStringHelper(org.mozilla.javascript.Context r18, org.mozilla.javascript.Scriptable r19, org.mozilla.javascript.Scriptable r20, boolean r21, boolean r22) {
        /*
            r1 = r18
            r0 = r19
            r2 = r20
            long r3 = getLengthProperty(r1, r2)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r6 = 256(0x100, float:3.59E-43)
            r5.<init>(r6)
            if (r21 == 0) goto L_0x001b
            r6 = 91
            r5.append(r6)
            java.lang.String r6 = ", "
            goto L_0x001d
        L_0x001b:
            java.lang.String r6 = ","
        L_0x001d:
            org.mozilla.javascript.ObjToIntMap r7 = r1.iterating
            r9 = 0
            if (r7 != 0) goto L_0x002e
            org.mozilla.javascript.ObjToIntMap r7 = new org.mozilla.javascript.ObjToIntMap
            r10 = 31
            r7.<init>(r10)
            r1.iterating = r7
            r7 = 0
            r10 = 1
            goto L_0x0035
        L_0x002e:
            org.mozilla.javascript.ObjToIntMap r7 = r1.iterating
            boolean r7 = r7.has(r2)
            r10 = 0
        L_0x0035:
            r11 = 0
            r12 = 0
            if (r7 != 0) goto L_0x00c1
            org.mozilla.javascript.ObjToIntMap r7 = r1.iterating     // Catch:{ all -> 0x00bb }
            r7.put(r2, r9)     // Catch:{ all -> 0x00bb }
            if (r21 == 0) goto L_0x004c
            int r7 = r18.getLanguageVersion()     // Catch:{ all -> 0x00bb }
            r14 = 150(0x96, float:2.1E-43)
            if (r7 >= r14) goto L_0x004a
            goto L_0x004c
        L_0x004a:
            r7 = 0
            goto L_0x004d
        L_0x004c:
            r7 = 1
        L_0x004d:
            r14 = r12
            r16 = 0
        L_0x0050:
            int r17 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r17 >= 0) goto L_0x00b8
            int r16 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r16 <= 0) goto L_0x005b
            r5.append(r6)     // Catch:{ all -> 0x00bb }
        L_0x005b:
            java.lang.Object r8 = getRawElem(r2, r14)     // Catch:{ all -> 0x00bb }
            java.lang.Object r9 = NOT_FOUND     // Catch:{ all -> 0x00bb }
            if (r8 == r9) goto L_0x00af
            if (r7 == 0) goto L_0x006c
            if (r8 == 0) goto L_0x00af
            java.lang.Object r9 = org.mozilla.javascript.Undefined.instance     // Catch:{ all -> 0x00bb }
            if (r8 != r9) goto L_0x006c
            goto L_0x00af
        L_0x006c:
            if (r21 == 0) goto L_0x0076
            java.lang.String r8 = org.mozilla.javascript.ScriptRuntime.uneval(r1, r0, r8)     // Catch:{ all -> 0x00bb }
            r5.append(r8)     // Catch:{ all -> 0x00bb }
            goto L_0x00ac
        L_0x0076:
            boolean r9 = r8 instanceof java.lang.String     // Catch:{ all -> 0x00bb }
            if (r9 == 0) goto L_0x0092
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x00bb }
            if (r21 == 0) goto L_0x008e
            r9 = 34
            r5.append(r9)     // Catch:{ all -> 0x00bb }
            java.lang.String r8 = org.mozilla.javascript.ScriptRuntime.escapeString(r8)     // Catch:{ all -> 0x00bb }
            r5.append(r8)     // Catch:{ all -> 0x00bb }
            r5.append(r9)     // Catch:{ all -> 0x00bb }
            goto L_0x00ac
        L_0x008e:
            r5.append(r8)     // Catch:{ all -> 0x00bb }
            goto L_0x00ac
        L_0x0092:
            if (r22 == 0) goto L_0x00a5
            java.lang.String r9 = "toLocaleString"
            org.mozilla.javascript.Callable r8 = org.mozilla.javascript.ScriptRuntime.getPropFunctionAndThis(r8, r9, r1, r0)     // Catch:{ all -> 0x00bb }
            org.mozilla.javascript.Scriptable r9 = org.mozilla.javascript.ScriptRuntime.lastStoredScriptable(r18)     // Catch:{ all -> 0x00bb }
            java.lang.Object[] r12 = org.mozilla.javascript.ScriptRuntime.emptyArgs     // Catch:{ all -> 0x00bb }
            java.lang.Object r8 = r8.call(r1, r0, r9, r12)     // Catch:{ all -> 0x00bb }
        L_0x00a5:
            java.lang.String r8 = org.mozilla.javascript.ScriptRuntime.toString((java.lang.Object) r8)     // Catch:{ all -> 0x00bb }
            r5.append(r8)     // Catch:{ all -> 0x00bb }
        L_0x00ac:
            r16 = 1
            goto L_0x00b1
        L_0x00af:
            r16 = 0
        L_0x00b1:
            r8 = 1
            long r14 = r14 + r8
            r9 = 0
            r12 = 0
            goto L_0x0050
        L_0x00b8:
            r9 = r16
            goto L_0x00c4
        L_0x00bb:
            r0 = move-exception
            if (r10 == 0) goto L_0x00c0
            r1.iterating = r11
        L_0x00c0:
            throw r0
        L_0x00c1:
            r9 = 0
            r14 = 0
        L_0x00c4:
            if (r10 == 0) goto L_0x00c8
            r1.iterating = r11
        L_0x00c8:
            if (r21 == 0) goto L_0x00dd
            if (r9 != 0) goto L_0x00d8
            r0 = 0
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x00d8
            java.lang.String r0 = ", ]"
            r5.append(r0)
            goto L_0x00dd
        L_0x00d8:
            r0 = 93
            r5.append(r0)
        L_0x00dd:
            java.lang.String r0 = r5.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.toStringHelper(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, boolean, boolean):java.lang.String");
    }

    private static String js_join(Context context, Scriptable scriptable, Object[] objArr) {
        Object obj;
        long lengthProperty = getLengthProperty(context, scriptable);
        int i = (int) lengthProperty;
        if (lengthProperty == ((long) i)) {
            int i2 = 0;
            String scriptRuntime = (objArr.length < 1 || objArr[0] == Undefined.instance) ? "," : ScriptRuntime.toString(objArr[0]);
            if (scriptable instanceof NativeArray) {
                NativeArray nativeArray = (NativeArray) scriptable;
                if (nativeArray.denseOnly) {
                    StringBuilder sb = new StringBuilder();
                    while (i2 < i) {
                        if (i2 != 0) {
                            sb.append(scriptRuntime);
                        }
                        Object[] objArr2 = nativeArray.dense;
                        if (!(i2 >= objArr2.length || (obj = objArr2[i2]) == null || obj == Undefined.instance || obj == Scriptable.NOT_FOUND)) {
                            sb.append(ScriptRuntime.toString(obj));
                        }
                        i2++;
                    }
                    return sb.toString();
                }
            }
            if (i == 0) {
                return "";
            }
            String[] strArr = new String[i];
            int i3 = 0;
            for (int i4 = 0; i4 != i; i4++) {
                Object elem = getElem(context, scriptable, (long) i4);
                if (!(elem == null || elem == Undefined.instance)) {
                    String scriptRuntime2 = ScriptRuntime.toString(elem);
                    i3 += scriptRuntime2.length();
                    strArr[i4] = scriptRuntime2;
                }
            }
            StringBuilder sb2 = new StringBuilder(i3 + ((i - 1) * scriptRuntime.length()));
            while (i2 != i) {
                if (i2 != 0) {
                    sb2.append(scriptRuntime);
                }
                String str = strArr[i2];
                if (str != null) {
                    sb2.append(str);
                }
                i2++;
            }
            return sb2.toString();
        }
        throw Context.reportRuntimeError1("msg.arraylength.too.big", String.valueOf(lengthProperty));
    }

    private static Scriptable js_reverse(Context context, Scriptable scriptable, Object[] objArr) {
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly) {
                int i = 0;
                for (int i2 = ((int) nativeArray.length) - 1; i < i2; i2--) {
                    Object[] objArr2 = nativeArray.dense;
                    Object obj = objArr2[i];
                    objArr2[i] = objArr2[i2];
                    objArr2[i2] = obj;
                    i++;
                }
                return scriptable;
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable);
        long j = lengthProperty / 2;
        for (long j2 = 0; j2 < j; j2++) {
            long j3 = (lengthProperty - j2) - 1;
            Object rawElem = getRawElem(scriptable, j2);
            setRawElem(context, scriptable, j2, getRawElem(scriptable, j3));
            setRawElem(context, scriptable, j3, rawElem);
        }
        return scriptable;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: org.mozilla.javascript.NativeArray$2} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: org.mozilla.javascript.NativeArray$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: org.mozilla.javascript.NativeArray$1} */
    /* JADX WARNING: type inference failed for: r11v1, types: [java.util.Comparator] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.mozilla.javascript.Scriptable js_sort(org.mozilla.javascript.Context r8, org.mozilla.javascript.Scriptable r9, org.mozilla.javascript.Scriptable r10, java.lang.Object[] r11) {
        /*
            int r0 = r11.length
            r1 = 0
            if (r0 <= 0) goto L_0x0020
            java.lang.Object r0 = org.mozilla.javascript.Undefined.instance
            r2 = r11[r1]
            if (r0 == r2) goto L_0x0020
            r11 = r11[r1]
            org.mozilla.javascript.Callable r4 = org.mozilla.javascript.ScriptRuntime.getValueFunctionAndThis(r11, r8)
            org.mozilla.javascript.Scriptable r7 = org.mozilla.javascript.ScriptRuntime.lastStoredScriptable(r8)
            r11 = 2
            java.lang.Object[] r3 = new java.lang.Object[r11]
            org.mozilla.javascript.NativeArray$1 r11 = new org.mozilla.javascript.NativeArray$1
            r2 = r11
            r5 = r8
            r6 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            goto L_0x0025
        L_0x0020:
            org.mozilla.javascript.NativeArray$2 r11 = new org.mozilla.javascript.NativeArray$2
            r11.<init>()
        L_0x0025:
            long r2 = getLengthProperty(r8, r10)
            int r9 = (int) r2
            long r4 = (long) r9
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 != 0) goto L_0x004d
            java.lang.Object[] r0 = new java.lang.Object[r9]
            r2 = 0
        L_0x0032:
            if (r2 == r9) goto L_0x003e
            long r3 = (long) r2
            java.lang.Object r3 = getRawElem(r10, r3)
            r0[r2] = r3
            int r2 = r2 + 1
            goto L_0x0032
        L_0x003e:
            java.util.Arrays.sort(r0, r11)
        L_0x0041:
            if (r1 >= r9) goto L_0x004c
            long r2 = (long) r1
            r11 = r0[r1]
            setRawElem(r8, r10, r2, r11)
            int r1 = r1 + 1
            goto L_0x0041
        L_0x004c:
            return r10
        L_0x004d:
            java.lang.String r8 = java.lang.String.valueOf(r2)
            java.lang.String r9 = "msg.arraylength.too.big"
            org.mozilla.javascript.EvaluatorException r8 = org.mozilla.javascript.Context.reportRuntimeError1(r9, r8)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.js_sort(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):org.mozilla.javascript.Scriptable");
    }

    private static Object js_push(Context context, Scriptable scriptable, Object[] objArr) {
        int i = 0;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly && nativeArray.ensureCapacity(((int) nativeArray.length) + objArr.length)) {
                while (i < objArr.length) {
                    Object[] objArr2 = nativeArray.dense;
                    long j = nativeArray.length;
                    nativeArray.length = 1 + j;
                    objArr2[(int) j] = objArr[i];
                    i++;
                }
                return ScriptRuntime.wrapNumber((double) nativeArray.length);
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable);
        while (i < objArr.length) {
            setElem(context, scriptable, ((long) i) + lengthProperty, objArr[i]);
            i++;
        }
        Object lengthProperty2 = setLengthProperty(context, scriptable, lengthProperty + ((long) objArr.length));
        if (context.getLanguageVersion() == 120) {
            return objArr.length == 0 ? Undefined.instance : objArr[objArr.length - 1];
        }
        return lengthProperty2;
    }

    private static Object js_pop(Context context, Scriptable scriptable, Object[] objArr) {
        Object obj;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly) {
                long j = nativeArray.length;
                if (j > 0) {
                    long j2 = j - 1;
                    nativeArray.length = j2;
                    Object[] objArr2 = nativeArray.dense;
                    Object obj2 = objArr2[(int) j2];
                    objArr2[(int) j2] = NOT_FOUND;
                    return obj2;
                }
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable);
        if (lengthProperty > 0) {
            lengthProperty--;
            obj = getElem(context, scriptable, lengthProperty);
            deleteElem(scriptable, lengthProperty);
        } else {
            obj = Undefined.instance;
        }
        setLengthProperty(context, scriptable, lengthProperty);
        return obj;
    }

    private static Object js_shift(Context context, Scriptable scriptable, Object[] objArr) {
        Object obj;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly) {
                long j = nativeArray.length;
                if (j > 0) {
                    long j2 = j - 1;
                    nativeArray.length = j2;
                    Object[] objArr2 = nativeArray.dense;
                    Object obj2 = objArr2[0];
                    System.arraycopy(objArr2, 1, objArr2, 0, (int) j2);
                    nativeArray.dense[(int) nativeArray.length] = NOT_FOUND;
                    return obj2 == NOT_FOUND ? Undefined.instance : obj2;
                }
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable);
        if (lengthProperty > 0) {
            lengthProperty--;
            obj = getElem(context, scriptable, 0);
            if (lengthProperty > 0) {
                for (long j3 = 1; j3 <= lengthProperty; j3++) {
                    setRawElem(context, scriptable, j3 - 1, getRawElem(scriptable, j3));
                }
            }
            deleteElem(scriptable, lengthProperty);
        } else {
            obj = Undefined.instance;
        }
        setLengthProperty(context, scriptable, lengthProperty);
        return obj;
    }

    private static Object js_unshift(Context context, Scriptable scriptable, Object[] objArr) {
        int i = 0;
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly && nativeArray.ensureCapacity(((int) nativeArray.length) + objArr.length)) {
                Object[] objArr2 = nativeArray.dense;
                System.arraycopy(objArr2, 0, objArr2, objArr.length, (int) nativeArray.length);
                while (i < objArr.length) {
                    nativeArray.dense[i] = objArr[i];
                    i++;
                }
                long length2 = nativeArray.length + ((long) objArr.length);
                nativeArray.length = length2;
                return ScriptRuntime.wrapNumber((double) length2);
            }
        }
        long lengthProperty = getLengthProperty(context, scriptable);
        int length3 = objArr.length;
        if (objArr.length > 0) {
            if (lengthProperty > 0) {
                for (long j = lengthProperty - 1; j >= 0; j--) {
                    setRawElem(context, scriptable, ((long) length3) + j, getRawElem(scriptable, j));
                }
            }
            while (i < objArr.length) {
                setElem(context, scriptable, (long) i, objArr[i]);
                i++;
            }
        }
        return setLengthProperty(context, scriptable, lengthProperty + ((long) objArr.length));
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014b A[LOOP:4: B:72:0x0149->B:73:0x014b, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object js_splice(org.mozilla.javascript.Context r25, org.mozilla.javascript.Scriptable r26, org.mozilla.javascript.Scriptable r27, java.lang.Object[] r28) {
        /*
            r0 = r25
            r1 = r27
            r2 = r28
            boolean r3 = r1 instanceof org.mozilla.javascript.NativeArray
            r4 = 0
            if (r3 == 0) goto L_0x0011
            r3 = r1
            org.mozilla.javascript.NativeArray r3 = (org.mozilla.javascript.NativeArray) r3
            boolean r5 = r3.denseOnly
            goto L_0x0013
        L_0x0011:
            r3 = 0
            r5 = 0
        L_0x0013:
            org.mozilla.javascript.Scriptable r6 = getTopLevelScope(r26)
            int r7 = r2.length
            if (r7 != 0) goto L_0x001f
            org.mozilla.javascript.Scriptable r0 = r0.newArray((org.mozilla.javascript.Scriptable) r6, (int) r4)
            return r0
        L_0x001f:
            long r8 = getLengthProperty(r0, r1)
            r10 = r2[r4]
            double r10 = org.mozilla.javascript.ScriptRuntime.toInteger((java.lang.Object) r10)
            long r10 = toSliceIndex(r10, r8)
            int r7 = r7 + -1
            int r12 = r2.length
            r13 = 1
            if (r12 != r13) goto L_0x0038
            long r12 = r8 - r10
            r17 = r5
            goto L_0x0057
        L_0x0038:
            r12 = r2[r13]
            double r12 = org.mozilla.javascript.ScriptRuntime.toInteger((java.lang.Object) r12)
            r16 = 0
            int r18 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r18 >= 0) goto L_0x0049
            r17 = r5
            r12 = 0
            goto L_0x0055
        L_0x0049:
            r17 = r5
            long r4 = r8 - r10
            double r14 = (double) r4
            int r20 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r20 <= 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            long r4 = (long) r12
        L_0x0054:
            r12 = r4
        L_0x0055:
            int r7 = r7 + -1
        L_0x0057:
            long r4 = r10 + r12
            r14 = 120(0x78, float:1.68E-43)
            r20 = 1
            r18 = 0
            int r15 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r15 == 0) goto L_0x00b1
            int r15 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1))
            if (r15 != 0) goto L_0x0076
            int r15 = r25.getLanguageVersion()
            if (r15 != r14) goto L_0x0076
            java.lang.Object r6 = getElem(r0, r1, r10)
            r22 = r3
            r23 = r8
            goto L_0x00bd
        L_0x0076:
            if (r17 == 0) goto L_0x008d
            long r14 = r4 - r10
            int r15 = (int) r14
            java.lang.Object[] r14 = new java.lang.Object[r15]
            java.lang.Object[] r2 = r3.dense
            r22 = r3
            int r3 = (int) r10
            r23 = r8
            r8 = 0
            java.lang.System.arraycopy(r2, r3, r14, r8, r15)
            org.mozilla.javascript.Scriptable r6 = r0.newArray((org.mozilla.javascript.Scriptable) r6, (java.lang.Object[]) r14)
            goto L_0x00bd
        L_0x008d:
            r22 = r3
            r23 = r8
            r8 = 0
            org.mozilla.javascript.Scriptable r6 = r0.newArray((org.mozilla.javascript.Scriptable) r6, (int) r8)
            r2 = r10
        L_0x0097:
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00ab
            java.lang.Object r8 = getRawElem(r1, r2)
            java.lang.Object r9 = NOT_FOUND
            if (r8 == r9) goto L_0x00a8
            long r14 = r2 - r10
            setElem(r0, r6, r14, r8)
        L_0x00a8:
            long r2 = r2 + r20
            goto L_0x0097
        L_0x00ab:
            long r2 = r4 - r10
            setLengthProperty(r0, r6, r2)
            goto L_0x00bd
        L_0x00b1:
            r22 = r3
            r23 = r8
            int r2 = r25.getLanguageVersion()
            if (r2 != r14) goto L_0x00bf
            java.lang.Object r6 = org.mozilla.javascript.Undefined.instance
        L_0x00bd:
            r2 = 0
            goto L_0x00c4
        L_0x00bf:
            r2 = 0
            org.mozilla.javascript.Scriptable r6 = r0.newArray((org.mozilla.javascript.Scriptable) r6, (int) r2)
        L_0x00c4:
            long r8 = (long) r7
            long r12 = r8 - r12
            if (r17 == 0) goto L_0x0104
            long r14 = r23 + r12
            r16 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r3 >= 0) goto L_0x0104
            int r3 = (int) r14
            r2 = r22
            boolean r17 = r2.ensureCapacity(r3)
            if (r17 == 0) goto L_0x0104
            java.lang.Object[] r0 = r2.dense
            int r1 = (int) r4
            long r8 = r8 + r10
            int r9 = (int) r8
            long r4 = r23 - r4
            int r5 = (int) r4
            java.lang.System.arraycopy(r0, r1, r0, r9, r5)
            if (r7 <= 0) goto L_0x00f1
            r0 = 2
            java.lang.Object[] r1 = r2.dense
            int r4 = (int) r10
            r8 = r28
            java.lang.System.arraycopy(r8, r0, r1, r4, r7)
        L_0x00f1:
            r0 = 0
            int r4 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r4 >= 0) goto L_0x0101
            java.lang.Object[] r0 = r2.dense
            r4 = r23
            int r1 = (int) r4
            java.lang.Object r4 = NOT_FOUND
            java.util.Arrays.fill(r0, r3, r1, r4)
        L_0x0101:
            r2.length = r14
            return r6
        L_0x0104:
            r8 = r28
            r2 = r23
            r14 = 0
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x0124
            long r14 = r2 - r20
        L_0x0110:
            int r9 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r9 < 0) goto L_0x0146
            java.lang.Object r9 = getRawElem(r1, r14)
            r17 = r4
            long r4 = r14 + r12
            setRawElem(r0, r1, r4, r9)
            long r14 = r14 - r20
            r4 = r17
            goto L_0x0110
        L_0x0124:
            r17 = r4
            if (r9 >= 0) goto L_0x0146
            r4 = r17
        L_0x012a:
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 >= 0) goto L_0x013a
            java.lang.Object r9 = getRawElem(r1, r4)
            long r14 = r4 + r12
            setRawElem(r0, r1, r14, r9)
            long r4 = r4 + r20
            goto L_0x012a
        L_0x013a:
            long r4 = r2 + r12
        L_0x013c:
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 >= 0) goto L_0x0146
            deleteElem(r1, r4)
            long r4 = r4 + r20
            goto L_0x013c
        L_0x0146:
            int r4 = r8.length
            int r4 = r4 - r7
            r5 = 0
        L_0x0149:
            if (r5 >= r7) goto L_0x0157
            long r14 = (long) r5
            long r14 = r14 + r10
            int r9 = r5 + r4
            r9 = r8[r9]
            setElem(r0, r1, r14, r9)
            int r5 = r5 + 1
            goto L_0x0149
        L_0x0157:
            long r8 = r2 + r12
            setLengthProperty(r0, r1, r8)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.js_splice(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    private static Scriptable js_concat(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        long j;
        Context context2 = context;
        Scriptable scriptable3 = scriptable2;
        Object[] objArr2 = objArr;
        int i = 0;
        Scriptable newArray = context2.newArray(getTopLevelScope(scriptable), 0);
        if ((scriptable3 instanceof NativeArray) && (newArray instanceof NativeArray)) {
            NativeArray nativeArray = (NativeArray) scriptable3;
            NativeArray nativeArray2 = (NativeArray) newArray;
            if (nativeArray.denseOnly && nativeArray2.denseOnly) {
                int i2 = (int) nativeArray.length;
                boolean z = true;
                for (int i3 = 0; i3 < objArr2.length && z; i3++) {
                    if (objArr2[i3] instanceof NativeArray) {
                        NativeArray nativeArray3 = (NativeArray) objArr2[i3];
                        boolean z2 = nativeArray3.denseOnly;
                        i2 = (int) (((long) i2) + nativeArray3.length);
                        z = z2;
                    } else {
                        i2++;
                    }
                }
                if (z && nativeArray2.ensureCapacity(i2)) {
                    System.arraycopy(nativeArray.dense, 0, nativeArray2.dense, 0, (int) nativeArray.length);
                    int i4 = (int) nativeArray.length;
                    for (int i5 = 0; i5 < objArr2.length && z; i5++) {
                        if (objArr2[i5] instanceof NativeArray) {
                            NativeArray nativeArray4 = (NativeArray) objArr2[i5];
                            System.arraycopy(nativeArray4.dense, 0, nativeArray2.dense, i4, (int) nativeArray4.length);
                            i4 += (int) nativeArray4.length;
                        } else {
                            nativeArray2.dense[i4] = objArr2[i5];
                            i4++;
                        }
                    }
                    nativeArray2.length = (long) i2;
                    return newArray;
                }
            }
        }
        long j2 = 0;
        if (js_isArray(scriptable2)) {
            long lengthProperty = getLengthProperty(context2, scriptable3);
            j = 0;
            while (j < lengthProperty) {
                Object rawElem = getRawElem(scriptable3, j);
                if (rawElem != NOT_FOUND) {
                    defineElem(context2, newArray, j, rawElem);
                }
                j++;
            }
        } else {
            defineElem(context2, newArray, 0, scriptable3);
            j = 1;
        }
        while (i < objArr2.length) {
            if (js_isArray(objArr2[i])) {
                Scriptable scriptable4 = (Scriptable) objArr2[i];
                long lengthProperty2 = getLengthProperty(context2, scriptable4);
                long j3 = j2;
                while (j3 < lengthProperty2) {
                    Object rawElem2 = getRawElem(scriptable4, j3);
                    if (rawElem2 != NOT_FOUND) {
                        defineElem(context2, newArray, j, rawElem2);
                    }
                    j3++;
                    j++;
                }
            } else {
                defineElem(context2, newArray, j, objArr2[i]);
                j++;
            }
            i++;
            j2 = 0;
        }
        setLengthProperty(context2, newArray, j);
        return newArray;
    }

    private Scriptable js_slice(Context context, Scriptable scriptable, Object[] objArr) {
        long j;
        Context context2 = context;
        Object[] objArr2 = objArr;
        Scriptable newArray = context2.newArray(getTopLevelScope(this), 0);
        long lengthProperty = getLengthProperty(context, scriptable);
        if (objArr2.length == 0) {
            j = 0;
        } else {
            j = toSliceIndex(ScriptRuntime.toInteger(objArr2[0]), lengthProperty);
            if (!(objArr2.length == 1 || objArr2[1] == Undefined.instance)) {
                lengthProperty = toSliceIndex(ScriptRuntime.toInteger(objArr2[1]), lengthProperty);
            }
        }
        for (long j2 = j; j2 < lengthProperty; j2++) {
            Object rawElem = getRawElem(scriptable, j2);
            if (rawElem != NOT_FOUND) {
                defineElem(context2, newArray, j2 - j, rawElem);
            }
        }
        setLengthProperty(context2, newArray, Math.max(0, lengthProperty - j));
        return newArray;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        if (r8 < 0) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object js_indexOf(org.mozilla.javascript.Context r10, org.mozilla.javascript.Scriptable r11, java.lang.Object[] r12) {
        /*
            int r0 = r12.length
            if (r0 <= 0) goto L_0x0007
            r0 = 0
            r0 = r12[r0]
            goto L_0x0009
        L_0x0007:
            java.lang.Object r0 = org.mozilla.javascript.Undefined.instance
        L_0x0009:
            long r1 = getLengthProperty(r10, r11)
            int r10 = r12.length
            r3 = 2
            r4 = 1
            r6 = 0
            if (r10 >= r3) goto L_0x0016
            goto L_0x0032
        L_0x0016:
            r10 = 1
            r10 = r12[r10]
            double r8 = org.mozilla.javascript.ScriptRuntime.toInteger((java.lang.Object) r10)
            long r8 = (long) r8
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 >= 0) goto L_0x0028
            long r8 = r8 + r1
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 >= 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r6 = r8
        L_0x0029:
            long r8 = r1 - r4
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 <= 0) goto L_0x0032
            java.lang.Integer r10 = NEGATIVE_ONE
            return r10
        L_0x0032:
            boolean r10 = r11 instanceof org.mozilla.javascript.NativeArray
            if (r10 == 0) goto L_0x006a
            r10 = r11
            org.mozilla.javascript.NativeArray r10 = (org.mozilla.javascript.NativeArray) r10
            boolean r12 = r10.denseOnly
            if (r12 == 0) goto L_0x006a
            org.mozilla.javascript.Scriptable r11 = r10.getPrototype()
            int r12 = (int) r6
        L_0x0042:
            long r3 = (long) r12
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x0067
            java.lang.Object[] r5 = r10.dense
            r5 = r5[r12]
            java.lang.Object r6 = NOT_FOUND
            if (r5 != r6) goto L_0x0055
            if (r11 == 0) goto L_0x0055
            java.lang.Object r5 = org.mozilla.javascript.ScriptableObject.getProperty((org.mozilla.javascript.Scriptable) r11, (int) r12)
        L_0x0055:
            java.lang.Object r6 = NOT_FOUND
            if (r5 == r6) goto L_0x0064
            boolean r5 = org.mozilla.javascript.ScriptRuntime.shallowEq(r5, r0)
            if (r5 == 0) goto L_0x0064
            java.lang.Long r10 = java.lang.Long.valueOf(r3)
            return r10
        L_0x0064:
            int r12 = r12 + 1
            goto L_0x0042
        L_0x0067:
            java.lang.Integer r10 = NEGATIVE_ONE
            return r10
        L_0x006a:
            int r10 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r10 >= 0) goto L_0x0083
            java.lang.Object r10 = getRawElem(r11, r6)
            java.lang.Object r12 = NOT_FOUND
            if (r10 == r12) goto L_0x0081
            boolean r10 = org.mozilla.javascript.ScriptRuntime.shallowEq(r10, r0)
            if (r10 == 0) goto L_0x0081
            java.lang.Long r10 = java.lang.Long.valueOf(r6)
            return r10
        L_0x0081:
            long r6 = r6 + r4
            goto L_0x006a
        L_0x0083:
            java.lang.Integer r10 = NEGATIVE_ONE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.js_indexOf(org.mozilla.javascript.Context, org.mozilla.javascript.Scriptable, java.lang.Object[]):java.lang.Object");
    }

    private static Object js_lastIndexOf(Context context, Scriptable scriptable, Object[] objArr) {
        long j;
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        long lengthProperty = getLengthProperty(context, scriptable);
        if (objArr.length < 2) {
            j = lengthProperty - 1;
        } else {
            long integer = (long) ScriptRuntime.toInteger(objArr[1]);
            if (integer >= lengthProperty) {
                j = lengthProperty - 1;
            } else {
                if (integer < 0) {
                    integer += lengthProperty;
                }
                j = integer;
            }
            if (j < 0) {
                return NEGATIVE_ONE;
            }
        }
        if (scriptable instanceof NativeArray) {
            NativeArray nativeArray = (NativeArray) scriptable;
            if (nativeArray.denseOnly) {
                Scriptable prototype = nativeArray.getPrototype();
                for (int i = (int) j; i >= 0; i--) {
                    Object obj2 = nativeArray.dense[i];
                    if (obj2 == NOT_FOUND && prototype != null) {
                        obj2 = ScriptableObject.getProperty(prototype, i);
                    }
                    if (obj2 != NOT_FOUND && ScriptRuntime.shallowEq(obj2, obj)) {
                        return Long.valueOf((long) i);
                    }
                }
                return NEGATIVE_ONE;
            }
        }
        while (j >= 0) {
            Object rawElem = getRawElem(scriptable, j);
            if (rawElem != NOT_FOUND && ScriptRuntime.shallowEq(rawElem, obj)) {
                return Long.valueOf(j);
            }
            j--;
        }
        return NEGATIVE_ONE;
    }

    private static Object iterativeMethod(Context context, int i, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Scriptable scriptable3;
        long j;
        Context context2 = context;
        int i2 = i;
        Scriptable scriptable4 = scriptable;
        Scriptable scriptable5 = scriptable2;
        Object[] objArr2 = objArr;
        long lengthProperty = getLengthProperty(context2, scriptable5);
        Object obj = objArr2.length > 0 ? objArr2[0] : Undefined.instance;
        if (obj == null || !(obj instanceof Function)) {
            throw ScriptRuntime.notFunctionError(obj);
        } else if ((i2 == 22 || i2 == 23) && !(obj instanceof NativeFunction)) {
            throw ScriptRuntime.notFunctionError(obj);
        } else {
            Function function = (Function) obj;
            Scriptable topLevelScope = ScriptableObject.getTopLevelScope(function);
            Scriptable object = (objArr2.length < 2 || objArr2[1] == null || objArr2[1] == Undefined.instance) ? topLevelScope : ScriptRuntime.toObject(context2, scriptable4, objArr2[1]);
            if ((22 == i2 || 23 == i2) && object == scriptable5) {
                throw ScriptRuntime.typeError("Array.prototype method called on null or undefined");
            }
            Scriptable scriptable6 = null;
            if (i2 == 18 || i2 == 20) {
                scriptable6 = context2.newArray(scriptable4, i2 == 20 ? (int) lengthProperty : 0);
            }
            long j2 = 0;
            long j3 = 0;
            while (j2 < lengthProperty) {
                Object[] objArr3 = new Object[3];
                Object rawElem = getRawElem(scriptable5, j2);
                if (rawElem != Scriptable.NOT_FOUND) {
                    objArr3[0] = rawElem;
                    objArr3[1] = Long.valueOf(j2);
                    objArr3[2] = scriptable5;
                    Object call = function.call(context2, topLevelScope, object, objArr3);
                    switch (i2) {
                        case 17:
                            scriptable3 = topLevelScope;
                            j = j3;
                            if (!ScriptRuntime.toBoolean(call)) {
                                return Boolean.FALSE;
                            }
                            break;
                        case 18:
                            if (ScriptRuntime.toBoolean(call)) {
                                scriptable3 = topLevelScope;
                                long j4 = j3;
                                j3 = j4 + 1;
                                defineElem(context2, scriptable6, j4, objArr3[0]);
                                continue;
                            }
                            break;
                        case 20:
                            defineElem(context2, scriptable6, j2, call);
                            break;
                        case 21:
                            if (ScriptRuntime.toBoolean(call)) {
                                return Boolean.TRUE;
                            }
                            break;
                        case 22:
                            if (ScriptRuntime.toBoolean(call)) {
                                return rawElem;
                            }
                            break;
                        case 23:
                            if (ScriptRuntime.toBoolean(call)) {
                                return ScriptRuntime.wrapNumber((double) j2);
                            }
                            break;
                    }
                }
                scriptable3 = topLevelScope;
                j = j3;
                j3 = j;
                j2++;
                topLevelScope = scriptable3;
            }
            switch (i2) {
                case 17:
                    return Boolean.TRUE;
                case 18:
                case 20:
                    return scriptable6;
                case 21:
                    return Boolean.FALSE;
                case 23:
                    return ScriptRuntime.wrapNumber(-1.0d);
                default:
                    return Undefined.instance;
            }
        }
    }

    private static Object reduceMethod(Context context, int i, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Context context2 = context;
        Scriptable scriptable3 = scriptable2;
        Object[] objArr2 = objArr;
        long lengthProperty = getLengthProperty(context2, scriptable3);
        Object obj = objArr2.length > 0 ? objArr2[0] : Undefined.instance;
        if (obj == null || !(obj instanceof Function)) {
            throw ScriptRuntime.notFunctionError(obj);
        }
        Function function = (Function) obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(function);
        boolean z = i == 24;
        Object obj2 = objArr2.length > 1 ? objArr2[1] : Scriptable.NOT_FOUND;
        for (long j = 0; j < lengthProperty; j++) {
            long j2 = z ? j : (lengthProperty - 1) - j;
            Object rawElem = getRawElem(scriptable3, j2);
            if (rawElem != Scriptable.NOT_FOUND) {
                if (obj2 == Scriptable.NOT_FOUND) {
                    obj2 = rawElem;
                } else {
                    obj2 = function.call(context2, topLevelScope, topLevelScope, new Object[]{obj2, rawElem, Long.valueOf(j2), scriptable3});
                }
            }
        }
        if (obj2 != Scriptable.NOT_FOUND) {
            return obj2;
        }
        throw ScriptRuntime.typeError0("msg.empty.array.reduce");
    }

    private static boolean js_isArray(Object obj) {
        if (!(obj instanceof Scriptable)) {
            return false;
        }
        return "Array".equals(((Scriptable) obj).getClassName());
    }

    public boolean contains(Object obj) {
        return indexOf(obj) > -1;
    }

    public Object[] toArray() {
        return toArray(ScriptRuntime.emptyArgs);
    }

    public Object[] toArray(Object[] objArr) {
        long j = this.length;
        if (j <= 2147483647L) {
            int i = (int) j;
            if (objArr.length < i) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), i);
            }
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = get(i2);
            }
            return objArr;
        }
        throw new IllegalStateException();
    }

    public boolean containsAll(Collection collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public int size() {
        long j = this.length;
        if (j <= 2147483647L) {
            return (int) j;
        }
        throw new IllegalStateException();
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public Object get(long j) {
        if (j < 0 || j >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        Object rawElem = getRawElem(this, j);
        if (rawElem == Scriptable.NOT_FOUND || rawElem == Undefined.instance) {
            return null;
        }
        return rawElem instanceof Wrapper ? ((Wrapper) rawElem).unwrap() : rawElem;
    }

    public Object get(int i) {
        return get((long) i);
    }

    public int indexOf(Object obj) {
        long j = this.length;
        if (j <= 2147483647L) {
            int i = (int) j;
            int i2 = 0;
            if (obj == null) {
                while (i2 < i) {
                    if (get(i2) == null) {
                        return i2;
                    }
                    i2++;
                }
                return -1;
            }
            while (i2 < i) {
                if (obj.equals(get(i2))) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        throw new IllegalStateException();
    }

    public int lastIndexOf(Object obj) {
        long j = this.length;
        if (j <= 2147483647L) {
            int i = (int) j;
            if (obj == null) {
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    if (get(i2) == null) {
                        return i2;
                    }
                }
                return -1;
            }
            for (int i3 = i - 1; i3 >= 0; i3--) {
                if (obj.equals(get(i3))) {
                    return i3;
                }
            }
            return -1;
        }
        throw new IllegalStateException();
    }

    public Iterator iterator() {
        return listIterator(0);
    }

    public ListIterator listIterator() {
        return listIterator(0);
    }

    public ListIterator listIterator(final int i) {
        long j = this.length;
        if (j <= 2147483647L) {
            final int i2 = (int) j;
            if (i >= 0 && i <= i2) {
                return new ListIterator() {
                    int cursor = i;

                    public boolean hasNext() {
                        return this.cursor < i2;
                    }

                    public Object next() {
                        int i = this.cursor;
                        if (i != i2) {
                            NativeArray nativeArray = NativeArray.this;
                            this.cursor = i + 1;
                            return nativeArray.get(i);
                        }
                        throw new NoSuchElementException();
                    }

                    public boolean hasPrevious() {
                        return this.cursor > 0;
                    }

                    public Object previous() {
                        int i = this.cursor;
                        if (i != 0) {
                            NativeArray nativeArray = NativeArray.this;
                            int i2 = i - 1;
                            this.cursor = i2;
                            return nativeArray.get(i2);
                        }
                        throw new NoSuchElementException();
                    }

                    public int nextIndex() {
                        return this.cursor;
                    }

                    public int previousIndex() {
                        return this.cursor - 1;
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    public void add(Object obj) {
                        throw new UnsupportedOperationException();
                    }

                    public void set(Object obj) {
                        throw new UnsupportedOperationException();
                    }
                };
            }
            throw new IndexOutOfBoundsException("Index: " + i);
        }
        throw new IllegalStateException();
    }

    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    public Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    public Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    public List subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0128 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int findPrototypeId(java.lang.String r17) {
        /*
            r16 = this;
            r0 = r17
            int r1 = r17.length()
            r2 = 108(0x6c, float:1.51E-43)
            r3 = 3
            r4 = 99
            r5 = 14
            r6 = 11
            r7 = 1
            r8 = 114(0x72, float:1.6E-43)
            r9 = 2
            r10 = 0
            if (r1 == r6) goto L_0x010c
            if (r1 == r5) goto L_0x0108
            r11 = 111(0x6f, float:1.56E-43)
            r12 = 102(0x66, float:1.43E-43)
            r13 = 115(0x73, float:1.61E-43)
            r14 = 105(0x69, float:1.47E-43)
            r15 = 109(0x6d, float:1.53E-43)
            switch(r1) {
                case 3: goto L_0x00de;
                case 4: goto L_0x00b4;
                case 5: goto L_0x0092;
                case 6: goto L_0x006b;
                case 7: goto L_0x0043;
                case 8: goto L_0x002d;
                case 9: goto L_0x0027;
                default: goto L_0x0025;
            }
        L_0x0025:
            goto L_0x0124
        L_0x0027:
            r3 = 23
            java.lang.String r1 = "findIndex"
            goto L_0x0126
        L_0x002d:
            char r1 = r0.charAt(r3)
            if (r1 != r11) goto L_0x0039
            r3 = 4
            java.lang.String r1 = "toSource"
            goto L_0x0126
        L_0x0039:
            r2 = 116(0x74, float:1.63E-43)
            if (r1 != r2) goto L_0x0124
            java.lang.String r1 = "toString"
            r3 = 2
            goto L_0x0126
        L_0x0043:
            char r1 = r0.charAt(r10)
            if (r1 == r12) goto L_0x0065
            if (r1 == r14) goto L_0x005f
            if (r1 == r8) goto L_0x005a
            r2 = 117(0x75, float:1.64E-43)
            if (r1 == r2) goto L_0x0053
            goto L_0x0124
        L_0x0053:
            java.lang.String r1 = "unshift"
            r3 = 11
            goto L_0x0126
        L_0x005a:
            r3 = 6
            java.lang.String r1 = "reverse"
            goto L_0x0126
        L_0x005f:
            r3 = 15
            java.lang.String r1 = "indexOf"
            goto L_0x0126
        L_0x0065:
            r3 = 19
            java.lang.String r1 = "forEach"
            goto L_0x0126
        L_0x006b:
            char r1 = r0.charAt(r10)
            if (r1 == r4) goto L_0x008c
            if (r1 == r12) goto L_0x0086
            if (r1 == r8) goto L_0x0080
            if (r1 == r13) goto L_0x0079
            goto L_0x0124
        L_0x0079:
            r3 = 12
            java.lang.String r1 = "splice"
            goto L_0x0126
        L_0x0080:
            r3 = 24
            java.lang.String r1 = "reduce"
            goto L_0x0126
        L_0x0086:
            r3 = 18
            java.lang.String r1 = "filter"
            goto L_0x0126
        L_0x008c:
            r3 = 13
            java.lang.String r1 = "concat"
            goto L_0x0126
        L_0x0092:
            char r1 = r0.charAt(r7)
            r3 = 104(0x68, float:1.46E-43)
            if (r1 != r3) goto L_0x00a1
            r3 = 10
            java.lang.String r1 = "shift"
            goto L_0x0126
        L_0x00a1:
            if (r1 != r2) goto L_0x00aa
            java.lang.String r1 = "slice"
            r3 = 14
            goto L_0x0126
        L_0x00aa:
            r2 = 118(0x76, float:1.65E-43)
            if (r1 != r2) goto L_0x0124
            r3 = 17
            java.lang.String r1 = "every"
            goto L_0x0126
        L_0x00b4:
            char r1 = r0.charAt(r9)
            if (r1 == r14) goto L_0x00da
            if (r1 == r15) goto L_0x00d4
            r2 = 110(0x6e, float:1.54E-43)
            if (r1 == r2) goto L_0x00cf
            if (r1 == r8) goto L_0x00ca
            if (r1 == r13) goto L_0x00c5
            goto L_0x0124
        L_0x00c5:
            r3 = 8
            java.lang.String r1 = "push"
            goto L_0x0126
        L_0x00ca:
            r3 = 7
            java.lang.String r1 = "sort"
            goto L_0x0126
        L_0x00cf:
            r3 = 22
            java.lang.String r1 = "find"
            goto L_0x0126
        L_0x00d4:
            r3 = 21
            java.lang.String r1 = "some"
            goto L_0x0126
        L_0x00da:
            r3 = 5
            java.lang.String r1 = "join"
            goto L_0x0126
        L_0x00de:
            char r1 = r0.charAt(r10)
            r2 = 112(0x70, float:1.57E-43)
            if (r1 != r15) goto L_0x00f7
            char r1 = r0.charAt(r9)
            if (r1 != r2) goto L_0x0124
            char r1 = r0.charAt(r7)
            r2 = 97
            if (r1 != r2) goto L_0x0124
            r10 = 20
            goto L_0x0132
        L_0x00f7:
            if (r1 != r2) goto L_0x0124
            char r1 = r0.charAt(r9)
            if (r1 != r2) goto L_0x0124
            char r1 = r0.charAt(r7)
            if (r1 != r11) goto L_0x0124
            r10 = 9
            goto L_0x0132
        L_0x0108:
            java.lang.String r1 = "toLocaleString"
            goto L_0x0126
        L_0x010c:
            char r1 = r0.charAt(r10)
            if (r1 != r4) goto L_0x0116
            java.lang.String r1 = "constructor"
            r3 = 1
            goto L_0x0126
        L_0x0116:
            if (r1 != r2) goto L_0x011d
            r3 = 16
            java.lang.String r1 = "lastIndexOf"
            goto L_0x0126
        L_0x011d:
            if (r1 != r8) goto L_0x0124
            r3 = 25
            java.lang.String r1 = "reduceRight"
            goto L_0x0126
        L_0x0124:
            r1 = 0
            r3 = 0
        L_0x0126:
            if (r1 == 0) goto L_0x0131
            if (r1 == r0) goto L_0x0131
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0131
            goto L_0x0132
        L_0x0131:
            r10 = r3
        L_0x0132:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.NativeArray.findPrototypeId(java.lang.String):int");
    }
}
