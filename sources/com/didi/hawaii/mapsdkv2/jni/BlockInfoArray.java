package com.didi.hawaii.mapsdkv2.jni;

public class BlockInfoArray {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected BlockInfoArray(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(BlockInfoArray blockInfoArray) {
        if (blockInfoArray == null) {
            return 0;
        }
        return blockInfoArray.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_BlockInfoArray(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public BlockInfoArray(int i) {
        this(MapEngineJNIBridge.new_BlockInfoArray(i), true);
    }

    public BlockInfo getitem(int i) {
        return new BlockInfo(MapEngineJNIBridge.BlockInfoArray_getitem(this.swigCPtr, this, i), true);
    }

    public void setitem(int i, BlockInfo blockInfo) {
        MapEngineJNIBridge.BlockInfoArray_setitem(this.swigCPtr, this, i, BlockInfo.getCPtr(blockInfo), blockInfo);
    }

    public BlockInfo cast() {
        long BlockInfoArray_cast = MapEngineJNIBridge.BlockInfoArray_cast(this.swigCPtr, this);
        if (BlockInfoArray_cast == 0) {
            return null;
        }
        return new BlockInfo(BlockInfoArray_cast, false);
    }

    public static BlockInfoArray frompointer(BlockInfo blockInfo) {
        long BlockInfoArray_frompointer = MapEngineJNIBridge.BlockInfoArray_frompointer(BlockInfo.getCPtr(blockInfo), blockInfo);
        if (BlockInfoArray_frompointer == 0) {
            return null;
        }
        return new BlockInfoArray(BlockInfoArray_frompointer, false);
    }
}
