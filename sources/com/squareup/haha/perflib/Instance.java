package com.squareup.haha.perflib;

import com.squareup.haha.guava.collect.ImmutableList;
import com.squareup.haha.perflib.p225io.HprofBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.UShort;

public abstract class Instance {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long mClassId;
    int mDistanceToGcRoot = Integer.MAX_VALUE;
    private final ArrayList<Instance> mHardReferences = new ArrayList<>();
    Heap mHeap;
    protected final long mId;
    private Instance mImmediateDominator;
    Instance mNextInstanceToGcRoot = null;
    boolean mReferencesAdded = false;
    private long[] mRetainedSizes;
    int mSize;
    private ArrayList<Instance> mSoftReferences = null;
    protected final StackTrace mStack;
    int mTopologicalOrder;

    public abstract void accept(Visitor visitor);

    public boolean getIsSoftReference() {
        return false;
    }

    Instance(long j, StackTrace stackTrace) {
        this.mId = j;
        this.mStack = stackTrace;
    }

    public long getId() {
        return this.mId;
    }

    public long getUniqueId() {
        return getId() & this.mHeap.mSnapshot.getIdSizeMask();
    }

    public void setClassId(long j) {
        this.mClassId = j;
    }

    public ClassObj getClassObj() {
        return this.mHeap.mSnapshot.findClass(this.mClassId);
    }

    public final int getCompositeSize() {
        CompositeSizeVisitor compositeSizeVisitor = new CompositeSizeVisitor();
        compositeSizeVisitor.doVisit(ImmutableList.m40365of(this));
        return compositeSizeVisitor.getCompositeSize();
    }

    public int getSize() {
        return this.mSize;
    }

    public void setSize(int i) {
        this.mSize = i;
    }

    public void setHeap(Heap heap) {
        this.mHeap = heap;
    }

    public Heap getHeap() {
        return this.mHeap;
    }

    public int getTopologicalOrder() {
        return this.mTopologicalOrder;
    }

    public void setTopologicalOrder(int i) {
        this.mTopologicalOrder = i;
    }

    public Instance getImmediateDominator() {
        return this.mImmediateDominator;
    }

    public void setImmediateDominator(Instance instance) {
        this.mImmediateDominator = instance;
    }

    public int getDistanceToGcRoot() {
        return this.mDistanceToGcRoot;
    }

    public Instance getNextInstanceToGcRoot() {
        return this.mNextInstanceToGcRoot;
    }

    public void setDistanceToGcRoot(int i) {
        this.mDistanceToGcRoot = i;
    }

    public void setNextInstanceToGcRoot(Instance instance) {
        this.mNextInstanceToGcRoot = instance;
    }

    public void resetRetainedSize() {
        ArrayList<Heap> arrayList = this.mHeap.mSnapshot.mHeaps;
        long[] jArr = this.mRetainedSizes;
        if (jArr == null) {
            this.mRetainedSizes = new long[arrayList.size()];
        } else {
            Arrays.fill(jArr, 0);
        }
        this.mRetainedSizes[arrayList.indexOf(this.mHeap)] = (long) getSize();
    }

    public void addRetainedSize(int i, long j) {
        long[] jArr = this.mRetainedSizes;
        jArr[i] = jArr[i] + j;
    }

    public long getRetainedSize(int i) {
        return this.mRetainedSizes[i];
    }

    public long getTotalRetainedSize() {
        long[] jArr = this.mRetainedSizes;
        long j = 0;
        if (jArr == null) {
            return 0;
        }
        for (long j2 : jArr) {
            j += j2;
        }
        return j;
    }

    public void addReference(Field field, Instance instance) {
        if (!instance.getIsSoftReference() || field == null || !field.getName().equals("referent")) {
            this.mHardReferences.add(instance);
            return;
        }
        if (this.mSoftReferences == null) {
            this.mSoftReferences = new ArrayList<>();
        }
        this.mSoftReferences.add(instance);
    }

    public ArrayList<Instance> getHardReferences() {
        return this.mHardReferences;
    }

    public ArrayList<Instance> getSoftReferences() {
        return this.mSoftReferences;
    }

    /* renamed from: com.squareup.haha.perflib.Instance$1 */
    static /* synthetic */ class C205401 {
        static final /* synthetic */ int[] $SwitchMap$com$android$tools$perflib$heap$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
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
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.OBJECT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$android$tools$perflib$heap$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$android$tools$perflib$heap$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.CHAR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$android$tools$perflib$heap$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.FLOAT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$android$tools$perflib$heap$Type     // Catch:{ NoSuchFieldError -> 0x003e }
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.DOUBLE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$android$tools$perflib$heap$Type     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.BYTE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$android$tools$perflib$heap$Type     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.SHORT     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$android$tools$perflib$heap$Type     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.INT     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$android$tools$perflib$heap$Type     // Catch:{ NoSuchFieldError -> 0x006c }
                com.squareup.haha.perflib.Type r1 = com.squareup.haha.perflib.Type.LONG     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.haha.perflib.Instance.C205401.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public Object readValue(Type type) {
        switch (C205401.$SwitchMap$com$android$tools$perflib$heap$Type[type.ordinal()]) {
            case 1:
                return this.mHeap.mSnapshot.findInstance(readId());
            case 2:
                return Boolean.valueOf(getBuffer().readByte() != 0);
            case 3:
                return Character.valueOf(getBuffer().readChar());
            case 4:
                return Float.valueOf(getBuffer().readFloat());
            case 5:
                return Double.valueOf(getBuffer().readDouble());
            case 6:
                return Byte.valueOf(getBuffer().readByte());
            case 7:
                return Short.valueOf(getBuffer().readShort());
            case 8:
                return Integer.valueOf(getBuffer().readInt());
            case 9:
                return Long.valueOf(getBuffer().readLong());
            default:
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public long readId() {
        int typeSize = this.mHeap.mSnapshot.getTypeSize(Type.OBJECT);
        if (typeSize == 1) {
            return (long) getBuffer().readByte();
        }
        if (typeSize == 2) {
            return (long) getBuffer().readShort();
        }
        if (typeSize == 4) {
            return (long) getBuffer().readInt();
        }
        if (typeSize != 8) {
            return 0;
        }
        return getBuffer().readLong();
    }

    /* access modifiers changed from: protected */
    public int readUnsignedByte() {
        return getBuffer().readByte() & 255;
    }

    /* access modifiers changed from: protected */
    public int readUnsignedShort() {
        return getBuffer().readShort() & UShort.MAX_VALUE;
    }

    /* access modifiers changed from: protected */
    public HprofBuffer getBuffer() {
        return this.mHeap.mSnapshot.mBuffer;
    }

    public static class CompositeSizeVisitor extends NonRecursiveVisitor {
        int mSize = 0;

        /* access modifiers changed from: protected */
        public void defaultAction(Instance instance) {
            this.mSize += instance.getSize();
        }

        public int getCompositeSize() {
            return this.mSize;
        }
    }
}
