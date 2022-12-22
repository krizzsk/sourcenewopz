package com.squareup.haha.perflib;

public class RootObj extends Instance {
    public static final String UNDEFINED_CLASS_NAME = "no class defined!!";
    int mIndex;
    int mThread;
    RootType mType;

    public RootObj(RootType rootType) {
        this(rootType, 0, 0, (StackTrace) null);
    }

    public RootObj(RootType rootType, long j) {
        this(rootType, j, 0, (StackTrace) null);
    }

    public RootObj(RootType rootType, long j, int i, StackTrace stackTrace) {
        super(j, stackTrace);
        this.mType = RootType.UNKNOWN;
        this.mType = rootType;
        this.mThread = i;
    }

    public final String getClassName(Snapshot snapshot) {
        ClassObj classObj;
        if (this.mType == RootType.SYSTEM_CLASS) {
            classObj = snapshot.findClass(this.mId);
        } else {
            classObj = snapshot.findInstance(this.mId).getClassObj();
        }
        if (classObj == null) {
            return UNDEFINED_CLASS_NAME;
        }
        return classObj.mClassName;
    }

    public final void accept(Visitor visitor) {
        visitor.visitRootObj(this);
        Instance referredInstance = getReferredInstance();
        if (referredInstance != null) {
            visitor.visitLater((Instance) null, referredInstance);
        }
    }

    public final String toString() {
        return String.format("%s@0x%08x", new Object[]{this.mType.getName(), Long.valueOf(this.mId)});
    }

    public Instance getReferredInstance() {
        if (this.mType == RootType.SYSTEM_CLASS) {
            return this.mHeap.mSnapshot.findClass(this.mId);
        }
        return this.mHeap.mSnapshot.findInstance(this.mId);
    }

    public RootType getRootType() {
        return this.mType;
    }
}
