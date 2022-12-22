package com.squareup.haha.perflib;

import com.squareup.haha.guava.collect.ImmutableList;
import com.squareup.haha.guava.collect.UnmodifiableIterator;
import com.squareup.haha.perflib.analysis.Dominators;
import com.squareup.haha.perflib.analysis.ShortestDistanceVisitor;
import com.squareup.haha.perflib.analysis.TopologicalSort;
import com.squareup.haha.perflib.p225io.HprofBuffer;
import com.squareup.haha.trove.THashSet;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.lingala.zip4j.util.InternalZipConstants;

public class Snapshot {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int DEFAULT_HEAP_ID = 0;
    private static final String JAVA_LANG_CLASS = "java.lang.Class";
    public static final Instance SENTINEL_ROOT = new RootObj(RootType.UNKNOWN);
    final HprofBuffer mBuffer;
    Heap mCurrentHeap;
    private Dominators mDominators;
    ArrayList<Heap> mHeaps = new ArrayList<>();
    private long mIdSizeMask = InternalZipConstants.ZIP_64_SIZE_LIMIT;
    private THashSet<ClassObj> mReferenceClasses = new THashSet<>();
    private ImmutableList<Instance> mTopSort;
    private int[] mTypeSizes;

    public Snapshot(HprofBuffer hprofBuffer) {
        this.mBuffer = hprofBuffer;
        setToDefaultHeap();
    }

    public Heap setToDefaultHeap() {
        return setHeapTo(0, "default");
    }

    public Heap setHeapTo(int i, String str) {
        Heap heap = getHeap(i);
        if (heap == null) {
            heap = new Heap(i, str);
            heap.mSnapshot = this;
            this.mHeaps.add(heap);
        }
        this.mCurrentHeap = heap;
        return heap;
    }

    public int getHeapIndex(Heap heap) {
        return this.mHeaps.indexOf(heap);
    }

    public Heap getHeap(int i) {
        for (int i2 = 0; i2 < this.mHeaps.size(); i2++) {
            if (this.mHeaps.get(i2).getId() == i) {
                return this.mHeaps.get(i2);
            }
        }
        return null;
    }

    public Heap getHeap(String str) {
        for (int i = 0; i < this.mHeaps.size(); i++) {
            if (str.equals(this.mHeaps.get(i).getName())) {
                return this.mHeaps.get(i);
            }
        }
        return null;
    }

    public Collection<Heap> getHeaps() {
        return this.mHeaps;
    }

    public Collection<RootObj> getGCRoots() {
        return this.mHeaps.get(0).mRoots;
    }

    public final void addStackFrame(StackFrame stackFrame) {
        this.mCurrentHeap.addStackFrame(stackFrame);
    }

    public final StackFrame getStackFrame(long j) {
        return this.mCurrentHeap.getStackFrame(j);
    }

    public final void addStackTrace(StackTrace stackTrace) {
        this.mCurrentHeap.addStackTrace(stackTrace);
    }

    public final StackTrace getStackTrace(int i) {
        return this.mCurrentHeap.getStackTrace(i);
    }

    public final StackTrace getStackTraceAtDepth(int i, int i2) {
        return this.mCurrentHeap.getStackTraceAtDepth(i, i2);
    }

    public final void addRoot(RootObj rootObj) {
        this.mCurrentHeap.addRoot(rootObj);
        rootObj.setHeap(this.mCurrentHeap);
    }

    public final void addThread(ThreadObj threadObj, int i) {
        this.mCurrentHeap.addThread(threadObj, i);
    }

    public final ThreadObj getThread(int i) {
        return this.mCurrentHeap.getThread(i);
    }

    public final void setIdSize(int i) {
        int i2 = -1;
        for (Type typeId : Type.values()) {
            i2 = Math.max(typeId.getTypeId(), i2);
        }
        int[] iArr = new int[(i2 + 1)];
        this.mTypeSizes = iArr;
        Arrays.fill(iArr, -1);
        for (int i3 = 0; i3 < Type.values().length; i3++) {
            this.mTypeSizes[Type.values()[i3].getTypeId()] = Type.values()[i3].getSize();
        }
        this.mTypeSizes[Type.OBJECT.getTypeId()] = i;
        this.mIdSizeMask = -1 >>> ((8 - i) << 3);
    }

    public final int getTypeSize(Type type) {
        return this.mTypeSizes[type.getTypeId()];
    }

    public final long getIdSizeMask() {
        return this.mIdSizeMask;
    }

    public final void addInstance(long j, Instance instance) {
        this.mCurrentHeap.addInstance(j, instance);
        instance.setHeap(this.mCurrentHeap);
    }

    public final void addClass(long j, ClassObj classObj) {
        this.mCurrentHeap.addClass(j, classObj);
        classObj.setHeap(this.mCurrentHeap);
    }

    public final Instance findInstance(long j) {
        for (int i = 0; i < this.mHeaps.size(); i++) {
            Instance instance = this.mHeaps.get(i).getInstance(j);
            if (instance != null) {
                return instance;
            }
        }
        return findClass(j);
    }

    public final ClassObj findClass(long j) {
        for (int i = 0; i < this.mHeaps.size(); i++) {
            ClassObj classObj = this.mHeaps.get(i).getClass(j);
            if (classObj != null) {
                return classObj;
            }
        }
        return null;
    }

    public final ClassObj findClass(String str) {
        for (int i = 0; i < this.mHeaps.size(); i++) {
            ClassObj classObj = this.mHeaps.get(i).getClass(str);
            if (classObj != null) {
                return classObj;
            }
        }
        return null;
    }

    public final Collection<ClassObj> findClasses(String str) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mHeaps.size(); i++) {
            arrayList.addAll(this.mHeaps.get(i).getClasses(str));
        }
        return arrayList;
    }

    public void resolveClasses() {
        ClassObj findClass = findClass(JAVA_LANG_CLASS);
        int instanceSize = findClass != null ? findClass.getInstanceSize() : 0;
        Iterator<Heap> it = this.mHeaps.iterator();
        while (it.hasNext()) {
            Heap next = it.next();
            for (ClassObj next2 : next.getClasses()) {
                ClassObj superClassObj = next2.getSuperClassObj();
                if (superClassObj != null) {
                    superClassObj.addSubclass(next2);
                }
                int i = instanceSize;
                for (Field type : next2.mStaticFields) {
                    i += getTypeSize(type.getType());
                }
                next2.setSize(i);
            }
            for (Instance next3 : next.getInstances()) {
                ClassObj classObj = next3.getClassObj();
                if (classObj != null) {
                    classObj.addInstance(next.getId(), next3);
                }
            }
        }
    }

    public void resolveReferences() {
        for (ClassObj next : findAllDescendantClasses(ClassObj.getReferenceClassName())) {
            next.setIsSoftReference();
            this.mReferenceClasses.add(next);
        }
    }

    public List<ClassObj> findAllDescendantClasses(String str) {
        Collection<ClassObj> findClasses = findClasses(str);
        ArrayList arrayList = new ArrayList();
        for (ClassObj descendantClasses : findClasses) {
            arrayList.addAll(descendantClasses.getDescendantClasses());
        }
        return arrayList;
    }

    public void computeDominators() {
        if (this.mDominators == null) {
            ImmutableList<Instance> compute = TopologicalSort.compute(getGCRoots());
            this.mTopSort = compute;
            Dominators dominators = new Dominators(this, compute);
            this.mDominators = dominators;
            dominators.computeRetainedSizes();
            new ShortestDistanceVisitor().doVisit(getGCRoots());
        }
    }

    public List<Instance> getReachableInstances() {
        ArrayList arrayList = new ArrayList(this.mTopSort.size());
        UnmodifiableIterator<Instance> it = this.mTopSort.iterator();
        while (it.hasNext()) {
            Instance next = it.next();
            if (next.getImmediateDominator() != null) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public ImmutableList<Instance> getTopologicalOrdering() {
        return this.mTopSort;
    }

    public final void dumpInstanceCounts() {
        Iterator<Heap> it = this.mHeaps.iterator();
        while (it.hasNext()) {
            Heap next = it.next();
            PrintStream printStream = System.out;
            printStream.println("+------------------ instance counts for heap: " + next.getName());
            next.dumpInstanceCounts();
        }
    }

    public final void dumpSizes() {
        Iterator<Heap> it = this.mHeaps.iterator();
        while (it.hasNext()) {
            Heap next = it.next();
            PrintStream printStream = System.out;
            printStream.println("+------------------ sizes for heap: " + next.getName());
            next.dumpSizes();
        }
    }

    public final void dumpSubclasses() {
        Iterator<Heap> it = this.mHeaps.iterator();
        while (it.hasNext()) {
            Heap next = it.next();
            PrintStream printStream = System.out;
            printStream.println("+------------------ subclasses for heap: " + next.getName());
            next.dumpSubclasses();
        }
    }
}
