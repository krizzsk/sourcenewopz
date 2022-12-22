package com.squareup.haha.perflib;

import com.squareup.haha.trove.TIntObjectHashMap;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import org.apache.commons.p071io.IOUtils;

public class ClassObj extends Instance implements Comparable<ClassObj> {
    long mClassLoaderId;
    final String mClassName;
    Field[] mFields;
    TIntObjectHashMap<HeapData> mHeapData = new TIntObjectHashMap<>();
    private int mInstanceSize;
    private boolean mIsSoftReference = false;
    Field[] mStaticFields;
    private final long mStaticFieldsOffset;
    Set<ClassObj> mSubclasses = new HashSet();
    long mSuperClassId;

    public static class HeapData {
        public List<Instance> mInstances = new ArrayList();
        public int mShallowSize = 0;
    }

    public static String getReferenceClassName() {
        return "java.lang.ref.Reference";
    }

    public ClassObj(long j, StackTrace stackTrace, String str, long j2) {
        super(j, stackTrace);
        this.mClassName = str;
        this.mStaticFieldsOffset = j2;
    }

    public final void addSubclass(ClassObj classObj) {
        this.mSubclasses.add(classObj);
    }

    public final Set<ClassObj> getSubclasses() {
        return this.mSubclasses;
    }

    public final void dumpSubclasses() {
        for (ClassObj classObj : this.mSubclasses) {
            PrintStream printStream = System.out;
            printStream.println("     " + classObj.mClassName);
        }
    }

    public final String toString() {
        return this.mClassName.replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
    }

    public final void addInstance(int i, Instance instance) {
        if (instance instanceof ClassInstance) {
            instance.setSize(this.mInstanceSize);
        }
        HeapData heapData = this.mHeapData.get(i);
        if (heapData == null) {
            heapData = new HeapData();
            this.mHeapData.put(i, heapData);
        }
        heapData.mInstances.add(instance);
        heapData.mShallowSize += instance.getSize();
    }

    public final void setSuperClassId(long j) {
        this.mSuperClassId = j;
    }

    public final void setClassLoaderId(long j) {
        this.mClassLoaderId = j;
    }

    public int getAllFieldsCount() {
        int i = 0;
        for (ClassObj classObj = this; classObj != null; classObj = classObj.getSuperClassObj()) {
            i += classObj.getFields().length;
        }
        return i;
    }

    public Field[] getFields() {
        return this.mFields;
    }

    public void setFields(Field[] fieldArr) {
        this.mFields = fieldArr;
    }

    public void setStaticFields(Field[] fieldArr) {
        this.mStaticFields = fieldArr;
    }

    public void setInstanceSize(int i) {
        this.mInstanceSize = i;
    }

    public int getInstanceSize() {
        return this.mInstanceSize;
    }

    public int getShallowSize(int i) {
        if (this.mHeapData.get(i) == null) {
            return 0;
        }
        return this.mHeapData.get(i).mShallowSize;
    }

    public void setIsSoftReference() {
        this.mIsSoftReference = true;
    }

    public boolean getIsSoftReference() {
        return this.mIsSoftReference;
    }

    public Map<Field, Object> getStaticFieldValues() {
        HashMap hashMap = new HashMap();
        getBuffer().setPosition(this.mStaticFieldsOffset);
        int readUnsignedShort = readUnsignedShort();
        for (int i = 0; i < readUnsignedShort; i++) {
            Field field = this.mStaticFields[i];
            readId();
            readUnsignedByte();
            hashMap.put(field, readValue(field.getType()));
        }
        return hashMap;
    }

    public final void dump() {
        ClassObj classObj = this;
        while (true) {
            System.out.println("+----------  ClassObj dump for: " + classObj.mClassName);
            System.out.println("+-----  Static fields");
            Map<Field, Object> staticFieldValues = classObj.getStaticFieldValues();
            for (Field next : staticFieldValues.keySet()) {
                System.out.println(next.getName() + ": " + next.getType() + " = " + staticFieldValues.get(next));
            }
            System.out.println("+-----  Instance fields");
            for (Field field : classObj.mFields) {
                System.out.println(field.getName() + ": " + field.getType());
            }
            if (classObj.getSuperClassObj() != null) {
                classObj = classObj.getSuperClassObj();
            } else {
                return;
            }
        }
    }

    public final String getClassName() {
        return this.mClassName;
    }

    public final void accept(Visitor visitor) {
        visitor.visitClassObj(this);
        for (Map.Entry next : getStaticFieldValues().entrySet()) {
            Object value = next.getValue();
            if (value instanceof Instance) {
                if (!this.mReferencesAdded) {
                    ((Instance) value).addReference((Field) next.getKey(), this);
                }
                visitor.visitLater(this, (Instance) value);
            }
        }
        this.mReferencesAdded = true;
    }

    public final int compareTo(ClassObj classObj) {
        if (getId() == classObj.getId()) {
            return 0;
        }
        int compareTo = this.mClassName.compareTo(classObj.mClassName);
        if (compareTo != 0) {
            return compareTo;
        }
        return getId() - classObj.getId() > 0 ? 1 : -1;
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ClassObj) && compareTo((ClassObj) obj) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.mClassName.hashCode();
    }

    /* access modifiers changed from: package-private */
    public Object getStaticField(Type type, String str) {
        return getStaticFieldValues().get(new Field(type, str));
    }

    public ClassObj getSuperClassObj() {
        return this.mHeap.mSnapshot.findClass(this.mSuperClassId);
    }

    public Instance getClassLoader() {
        return this.mHeap.mSnapshot.findInstance(this.mClassLoaderId);
    }

    public List<Instance> getInstancesList() {
        ArrayList arrayList = new ArrayList(getInstanceCount());
        for (int heapInstances : this.mHeapData.keys()) {
            arrayList.addAll(getHeapInstances(heapInstances));
        }
        return arrayList;
    }

    public List<Instance> getHeapInstances(int i) {
        HeapData heapData = this.mHeapData.get(i);
        return heapData == null ? new ArrayList(0) : heapData.mInstances;
    }

    public int getHeapInstancesCount(int i) {
        HeapData heapData = this.mHeapData.get(i);
        if (heapData == null) {
            return 0;
        }
        return heapData.mInstances.size();
    }

    public int getInstanceCount() {
        int i = 0;
        for (Object obj : this.mHeapData.getValues()) {
            i += ((HeapData) obj).mInstances.size();
        }
        return i;
    }

    public int getShallowSize() {
        int i = 0;
        for (Object obj : this.mHeapData.getValues()) {
            i += ((HeapData) obj).mShallowSize;
        }
        return i;
    }

    public List<ClassObj> getDescendantClasses() {
        ArrayList arrayList = new ArrayList();
        Stack stack = new Stack();
        stack.push(this);
        while (!stack.isEmpty()) {
            ClassObj classObj = (ClassObj) stack.pop();
            arrayList.add(classObj);
            for (ClassObj push : classObj.getSubclasses()) {
                stack.push(push);
            }
        }
        return arrayList;
    }
}
