package androidx.work;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class Data {
    public static final Data EMPTY = new Builder().build();
    public static final int MAX_DATA_BYTES = 10240;
    private static final String TAG = Logger.tagWithPrefix("Data");
    Map<String, Object> mValues;

    Data() {
    }

    public Data(Data data) {
        this.mValues = new HashMap(data.mValues);
    }

    public Data(Map<String, ?> map) {
        this.mValues = new HashMap(map);
    }

    public boolean getBoolean(String str, boolean z) {
        Object obj = this.mValues.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    public boolean[] getBooleanArray(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Boolean[]) {
            return convertToPrimitiveArray((Boolean[]) obj);
        }
        return null;
    }

    public byte getByte(String str, byte b) {
        Object obj = this.mValues.get(str);
        return obj instanceof Byte ? ((Byte) obj).byteValue() : b;
    }

    public byte[] getByteArray(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Byte[]) {
            return convertToPrimitiveArray((Byte[]) obj);
        }
        return null;
    }

    public int getInt(String str, int i) {
        Object obj = this.mValues.get(str);
        return obj instanceof Integer ? ((Integer) obj).intValue() : i;
    }

    public int[] getIntArray(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Integer[]) {
            return convertToPrimitiveArray((Integer[]) obj);
        }
        return null;
    }

    public long getLong(String str, long j) {
        Object obj = this.mValues.get(str);
        return obj instanceof Long ? ((Long) obj).longValue() : j;
    }

    public long[] getLongArray(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Long[]) {
            return convertToPrimitiveArray((Long[]) obj);
        }
        return null;
    }

    public float getFloat(String str, float f) {
        Object obj = this.mValues.get(str);
        return obj instanceof Float ? ((Float) obj).floatValue() : f;
    }

    public float[] getFloatArray(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Float[]) {
            return convertToPrimitiveArray((Float[]) obj);
        }
        return null;
    }

    public double getDouble(String str, double d) {
        Object obj = this.mValues.get(str);
        return obj instanceof Double ? ((Double) obj).doubleValue() : d;
    }

    public double[] getDoubleArray(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof Double[]) {
            return convertToPrimitiveArray((Double[]) obj);
        }
        return null;
    }

    public String getString(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public String[] getStringArray(String str) {
        Object obj = this.mValues.get(str);
        if (obj instanceof String[]) {
            return (String[]) obj;
        }
        return null;
    }

    public Map<String, Object> getKeyValueMap() {
        return Collections.unmodifiableMap(this.mValues);
    }

    public byte[] toByteArray() {
        return toByteArrayInternal(this);
    }

    public <T> boolean hasKeyWithValueOfType(String str, Class<T> cls) {
        Object obj = this.mValues.get(str);
        return obj != null && cls.isAssignableFrom(obj.getClass());
    }

    public int size() {
        return this.mValues.size();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x008d A[SYNTHETIC, Splitter:B:32:0x008d] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b2 A[SYNTHETIC, Splitter:B:42:0x00b2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] toByteArrayInternal(androidx.work.Data r15) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
            r1 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x0079 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0079 }
            int r1 = r15.size()     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            r2.writeInt(r1)     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            java.util.Map<java.lang.String, java.lang.Object> r15 = r15.mValues     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            java.util.Set r15 = r15.entrySet()     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            java.util.Iterator r15 = r15.iterator()     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
        L_0x001c:
            boolean r1 = r15.hasNext()     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            if (r1 == 0) goto L_0x0039
            java.lang.Object r1 = r15.next()     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            java.lang.Object r3 = r1.getKey()     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            r2.writeUTF(r3)     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            r2.writeObject(r1)     // Catch:{ IOException -> 0x0073, all -> 0x0070 }
            goto L_0x001c
        L_0x0039:
            r2.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x004a
        L_0x003d:
            r6 = move-exception
            java.lang.String r4 = TAG
            r3 = 6
            r8 = 396(0x18c, float:5.55E-43)
            java.lang.String r5 = "Error in Data#toByteArray: "
            java.lang.String r7 = "androidx.work.Data"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
        L_0x004a:
            r0.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x005b
        L_0x004e:
            r12 = move-exception
            java.lang.String r10 = TAG
            r9 = 6
            r14 = 402(0x192, float:5.63E-43)
            java.lang.String r11 = "Error in Data#toByteArray: "
            java.lang.String r13 = "androidx.work.Data"
            com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)
        L_0x005b:
            int r15 = r0.size()
            r1 = 10240(0x2800, float:1.4349E-41)
            if (r15 > r1) goto L_0x0068
            byte[] r15 = r0.toByteArray()
            return r15
        L_0x0068:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r15.<init>(r0)
            throw r15
        L_0x0070:
            r15 = move-exception
            r1 = r2
            goto L_0x00b0
        L_0x0073:
            r15 = move-exception
            r5 = r15
            r1 = r2
            goto L_0x007b
        L_0x0077:
            r15 = move-exception
            goto L_0x00b0
        L_0x0079:
            r15 = move-exception
            r5 = r15
        L_0x007b:
            java.lang.String r3 = TAG     // Catch:{ all -> 0x0077 }
            java.lang.String r4 = "Error in Data#toByteArray: "
            r2 = 6
            java.lang.String r6 = "androidx.work.Data"
            r7 = 387(0x183, float:5.42E-43)
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0077 }
            byte[] r15 = r0.toByteArray()     // Catch:{ all -> 0x0077 }
            if (r1 == 0) goto L_0x009e
            r1.close()     // Catch:{ IOException -> 0x0091 }
            goto L_0x009e
        L_0x0091:
            r5 = move-exception
            java.lang.String r3 = TAG
            r2 = 6
            r7 = 396(0x18c, float:5.55E-43)
            java.lang.String r4 = "Error in Data#toByteArray: "
            java.lang.String r6 = "androidx.work.Data"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
        L_0x009e:
            r0.close()     // Catch:{ IOException -> 0x00a2 }
            goto L_0x00af
        L_0x00a2:
            r11 = move-exception
            java.lang.String r9 = TAG
            r8 = 6
            r13 = 402(0x192, float:5.63E-43)
            java.lang.String r10 = "Error in Data#toByteArray: "
            java.lang.String r12 = "androidx.work.Data"
            com.didi.sdk.apm.SystemUtils.log(r8, r9, r10, r11, r12, r13)
        L_0x00af:
            return r15
        L_0x00b0:
            if (r1 == 0) goto L_0x00c3
            r1.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00c3
        L_0x00b6:
            r5 = move-exception
            java.lang.String r3 = TAG
            r2 = 6
            r7 = 396(0x18c, float:5.55E-43)
            java.lang.String r4 = "Error in Data#toByteArray: "
            java.lang.String r6 = "androidx.work.Data"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
        L_0x00c3:
            r0.close()     // Catch:{ IOException -> 0x00c7 }
            goto L_0x00d4
        L_0x00c7:
            r11 = move-exception
            java.lang.String r9 = TAG
            r8 = 6
            r13 = 402(0x192, float:5.63E-43)
            java.lang.String r10 = "Error in Data#toByteArray: "
            java.lang.String r12 = "androidx.work.Data"
            com.didi.sdk.apm.SystemUtils.log(r8, r9, r10, r11, r12, r13)
        L_0x00d4:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.toByteArrayInternal(androidx.work.Data):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x006a A[SYNTHETIC, Splitter:B:28:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0094 A[SYNTHETIC, Splitter:B:39:0x0094] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.work.Data fromByteArray(byte[] r15) {
        /*
            int r0 = r15.length
            r1 = 10240(0x2800, float:1.4349E-41)
            if (r0 > r1) goto L_0x00b7
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r15)
            r15 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x005a, ClassNotFoundException -> 0x0058 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x005a, ClassNotFoundException -> 0x0058 }
            int r15 = r2.readInt()     // Catch:{ IOException -> 0x0050, ClassNotFoundException -> 0x004e, all -> 0x004c }
        L_0x0019:
            if (r15 <= 0) goto L_0x0029
            java.lang.String r3 = r2.readUTF()     // Catch:{ IOException -> 0x0050, ClassNotFoundException -> 0x004e, all -> 0x004c }
            java.lang.Object r4 = r2.readObject()     // Catch:{ IOException -> 0x0050, ClassNotFoundException -> 0x004e, all -> 0x004c }
            r0.put(r3, r4)     // Catch:{ IOException -> 0x0050, ClassNotFoundException -> 0x004e, all -> 0x004c }
            int r15 = r15 + -1
            goto L_0x0019
        L_0x0029:
            r2.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x003a
        L_0x002d:
            r6 = move-exception
            java.lang.String r4 = TAG
            r3 = 6
            r8 = 444(0x1bc, float:6.22E-43)
            java.lang.String r5 = "Error in Data#fromByteArray: "
            java.lang.String r7 = "androidx.work.Data"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
        L_0x003a:
            r1.close()     // Catch:{ IOException -> 0x003e }
            goto L_0x008c
        L_0x003e:
            r12 = move-exception
            java.lang.String r10 = TAG
            r9 = 6
            r14 = 450(0x1c2, float:6.3E-43)
            java.lang.String r11 = "Error in Data#fromByteArray: "
            java.lang.String r13 = "androidx.work.Data"
            com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)
            goto L_0x008c
        L_0x004c:
            r15 = move-exception
            goto L_0x0092
        L_0x004e:
            r15 = move-exception
            goto L_0x0051
        L_0x0050:
            r15 = move-exception
        L_0x0051:
            r6 = r15
            r15 = r2
            goto L_0x005c
        L_0x0054:
            r0 = move-exception
            r2 = r15
            r15 = r0
            goto L_0x0092
        L_0x0058:
            r2 = move-exception
            goto L_0x005b
        L_0x005a:
            r2 = move-exception
        L_0x005b:
            r6 = r2
        L_0x005c:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x0054 }
            java.lang.String r5 = "Error in Data#fromByteArray: "
            r3 = 6
            java.lang.String r7 = "androidx.work.Data"
            r8 = 438(0x1b6, float:6.14E-43)
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0054 }
            if (r15 == 0) goto L_0x007b
            r15.close()     // Catch:{ IOException -> 0x006e }
            goto L_0x007b
        L_0x006e:
            r12 = move-exception
            java.lang.String r10 = TAG
            r9 = 6
            r14 = 444(0x1bc, float:6.22E-43)
            java.lang.String r11 = "Error in Data#fromByteArray: "
            java.lang.String r13 = "androidx.work.Data"
            com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)
        L_0x007b:
            r1.close()     // Catch:{ IOException -> 0x007f }
            goto L_0x008c
        L_0x007f:
            r5 = move-exception
            java.lang.String r3 = TAG
            r2 = 6
            r7 = 450(0x1c2, float:6.3E-43)
            java.lang.String r4 = "Error in Data#fromByteArray: "
            java.lang.String r6 = "androidx.work.Data"
            com.didi.sdk.apm.SystemUtils.log(r2, r3, r4, r5, r6, r7)
        L_0x008c:
            androidx.work.Data r15 = new androidx.work.Data
            r15.<init>((java.util.Map<java.lang.String, ?>) r0)
            return r15
        L_0x0092:
            if (r2 == 0) goto L_0x00a5
            r2.close()     // Catch:{ IOException -> 0x0098 }
            goto L_0x00a5
        L_0x0098:
            r6 = move-exception
            java.lang.String r4 = TAG
            r3 = 6
            r8 = 444(0x1bc, float:6.22E-43)
            java.lang.String r5 = "Error in Data#fromByteArray: "
            java.lang.String r7 = "androidx.work.Data"
            com.didi.sdk.apm.SystemUtils.log(r3, r4, r5, r6, r7, r8)
        L_0x00a5:
            r1.close()     // Catch:{ IOException -> 0x00a9 }
            goto L_0x00b6
        L_0x00a9:
            r12 = move-exception
            java.lang.String r10 = TAG
            r9 = 6
            r14 = 450(0x1c2, float:6.3E-43)
            java.lang.String r11 = "Error in Data#fromByteArray: "
            java.lang.String r13 = "androidx.work.Data"
            com.didi.sdk.apm.SystemUtils.log(r9, r10, r11, r12, r13, r14)
        L_0x00b6:
            throw r15
        L_0x00b7:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.Data.fromByteArray(byte[]):androidx.work.Data");
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Data data = (Data) obj;
        Set<String> keySet = this.mValues.keySet();
        if (!keySet.equals(data.mValues.keySet())) {
            return false;
        }
        for (String next : keySet) {
            Object obj2 = this.mValues.get(next);
            Object obj3 = data.mValues.get(next);
            if (obj2 == null || obj3 == null) {
                if (obj2 == obj3) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
            } else if (!(obj2 instanceof Object[]) || !(obj3 instanceof Object[])) {
                z = obj2.equals(obj3);
                continue;
            } else {
                z = Arrays.deepEquals((Object[]) obj2, (Object[]) obj3);
                continue;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.mValues.hashCode() * 31;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Data {");
        if (!this.mValues.isEmpty()) {
            for (String next : this.mValues.keySet()) {
                sb.append(next);
                sb.append(" : ");
                Object obj = this.mValues.get(next);
                if (obj instanceof Object[]) {
                    sb.append(Arrays.toString((Object[]) obj));
                } else {
                    sb.append(obj);
                }
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static Boolean[] convertPrimitiveBooleanArray(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    public static Byte[] convertPrimitiveByteArray(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    public static Integer[] convertPrimitiveIntArray(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    public static Long[] convertPrimitiveLongArray(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    public static Float[] convertPrimitiveFloatArray(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    public static Double[] convertPrimitiveDoubleArray(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    public static boolean[] convertToPrimitiveArray(Boolean[] boolArr) {
        boolean[] zArr = new boolean[boolArr.length];
        for (int i = 0; i < boolArr.length; i++) {
            zArr[i] = boolArr[i].booleanValue();
        }
        return zArr;
    }

    public static byte[] convertToPrimitiveArray(Byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[i].byteValue();
        }
        return bArr2;
    }

    public static int[] convertToPrimitiveArray(Integer[] numArr) {
        int[] iArr = new int[numArr.length];
        for (int i = 0; i < numArr.length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    public static long[] convertToPrimitiveArray(Long[] lArr) {
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            jArr[i] = lArr[i].longValue();
        }
        return jArr;
    }

    public static float[] convertToPrimitiveArray(Float[] fArr) {
        float[] fArr2 = new float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = fArr[i].floatValue();
        }
        return fArr2;
    }

    public static double[] convertToPrimitiveArray(Double[] dArr) {
        double[] dArr2 = new double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = dArr[i].doubleValue();
        }
        return dArr2;
    }

    public static final class Builder {
        private Map<String, Object> mValues = new HashMap();

        public Builder putBoolean(String str, boolean z) {
            this.mValues.put(str, Boolean.valueOf(z));
            return this;
        }

        public Builder putBooleanArray(String str, boolean[] zArr) {
            this.mValues.put(str, Data.convertPrimitiveBooleanArray(zArr));
            return this;
        }

        public Builder putByte(String str, byte b) {
            this.mValues.put(str, Byte.valueOf(b));
            return this;
        }

        public Builder putByteArray(String str, byte[] bArr) {
            this.mValues.put(str, Data.convertPrimitiveByteArray(bArr));
            return this;
        }

        public Builder putInt(String str, int i) {
            this.mValues.put(str, Integer.valueOf(i));
            return this;
        }

        public Builder putIntArray(String str, int[] iArr) {
            this.mValues.put(str, Data.convertPrimitiveIntArray(iArr));
            return this;
        }

        public Builder putLong(String str, long j) {
            this.mValues.put(str, Long.valueOf(j));
            return this;
        }

        public Builder putLongArray(String str, long[] jArr) {
            this.mValues.put(str, Data.convertPrimitiveLongArray(jArr));
            return this;
        }

        public Builder putFloat(String str, float f) {
            this.mValues.put(str, Float.valueOf(f));
            return this;
        }

        public Builder putFloatArray(String str, float[] fArr) {
            this.mValues.put(str, Data.convertPrimitiveFloatArray(fArr));
            return this;
        }

        public Builder putDouble(String str, double d) {
            this.mValues.put(str, Double.valueOf(d));
            return this;
        }

        public Builder putDoubleArray(String str, double[] dArr) {
            this.mValues.put(str, Data.convertPrimitiveDoubleArray(dArr));
            return this;
        }

        public Builder putString(String str, String str2) {
            this.mValues.put(str, str2);
            return this;
        }

        public Builder putStringArray(String str, String[] strArr) {
            this.mValues.put(str, strArr);
            return this;
        }

        public Builder putAll(Data data) {
            putAll(data.mValues);
            return this;
        }

        public Builder putAll(Map<String, Object> map) {
            for (Map.Entry next : map.entrySet()) {
                put((String) next.getKey(), next.getValue());
            }
            return this;
        }

        public Builder put(String str, Object obj) {
            if (obj == null) {
                this.mValues.put(str, (Object) null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.mValues.put(str, obj);
                } else if (cls == boolean[].class) {
                    this.mValues.put(str, Data.convertPrimitiveBooleanArray((boolean[]) obj));
                } else if (cls == byte[].class) {
                    this.mValues.put(str, Data.convertPrimitiveByteArray((byte[]) obj));
                } else if (cls == int[].class) {
                    this.mValues.put(str, Data.convertPrimitiveIntArray((int[]) obj));
                } else if (cls == long[].class) {
                    this.mValues.put(str, Data.convertPrimitiveLongArray((long[]) obj));
                } else if (cls == float[].class) {
                    this.mValues.put(str, Data.convertPrimitiveFloatArray((float[]) obj));
                } else if (cls == double[].class) {
                    this.mValues.put(str, Data.convertPrimitiveDoubleArray((double[]) obj));
                } else {
                    throw new IllegalArgumentException(String.format("Key %s has invalid type %s", new Object[]{str, cls}));
                }
            }
            return this;
        }

        public Data build() {
            Data data = new Data((Map<String, ?>) this.mValues);
            Data.toByteArrayInternal(data);
            return data;
        }
    }
}
