package com.squareup.haha.perflib;

import com.squareup.haha.guava.collect.Maps;
import java.util.Map;

public enum Type {
    OBJECT(2, 0),
    BOOLEAN(4, 1),
    CHAR(5, 2),
    FLOAT(6, 4),
    DOUBLE(7, 8),
    BYTE(8, 1),
    SHORT(9, 2),
    INT(10, 4),
    LONG(11, 8);
    
    private static Map<Integer, Type> sTypeMap;
    private int mId;
    private int mSize;

    static {
        int i;
        sTypeMap = Maps.newHashMap();
        for (Type type : values()) {
            sTypeMap.put(Integer.valueOf(type.mId), type);
        }
    }

    private Type(int i, int i2) {
        this.mId = i;
        this.mSize = i2;
    }

    public static Type getType(int i) {
        return sTypeMap.get(Integer.valueOf(i));
    }

    public final int getSize() {
        return this.mSize;
    }

    public final int getTypeId() {
        return this.mId;
    }

    /* renamed from: com.squareup.haha.perflib.Type$1 */
    static /* synthetic */ class C205481 {
        static final /* synthetic */ int[] $SwitchMap$com$android$tools$perflib$heap$Type = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.squareup.haha.perflib.Type[] r0 = com.squareup.haha.perflib.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$android$tools$perflib$heap$Type = r0
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$android$tools$perflib$heap$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.CHAR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$android$tools$perflib$heap$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.FLOAT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$android$tools$perflib$heap$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.DOUBLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$android$tools$perflib$heap$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.BYTE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$android$tools$perflib$heap$Type     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.SHORT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$android$tools$perflib$heap$Type     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.INT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$android$tools$perflib$heap$Type     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.LONG     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.haha.perflib.Type.C205481.<clinit>():void");
        }
    }

    public static String getClassNameOfPrimitiveArray(Type type) {
        switch (C205481.$SwitchMap$com$android$tools$perflib$heap$Type[type.ordinal()]) {
            case 1:
                return "boolean[]";
            case 2:
                return "char[]";
            case 3:
                return "float[]";
            case 4:
                return "double[]";
            case 5:
                return "byte[]";
            case 6:
                return "short[]";
            case 7:
                return "int[]";
            case 8:
                return "long[]";
            default:
                throw new IllegalArgumentException("OBJECT type is not a primitive type");
        }
    }
}
