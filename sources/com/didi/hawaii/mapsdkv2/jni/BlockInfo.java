package com.didi.hawaii.mapsdkv2.jni;

import java.math.BigInteger;

public class BlockInfo {
    protected transient boolean swigCMemOwn;
    private transient long swigCPtr;

    protected BlockInfo(long j, boolean z) {
        this.swigCMemOwn = z;
        this.swigCPtr = j;
    }

    protected static long getCPtr(BlockInfo blockInfo) {
        if (blockInfo == null) {
            return 0;
        }
        return blockInfo.swigCPtr;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        delete();
    }

    public synchronized void delete() {
        if (this.swigCPtr != 0) {
            if (this.swigCMemOwn) {
                this.swigCMemOwn = false;
                MapEngineJNIBridge.delete_BlockInfo(this.swigCPtr);
            }
            this.swigCPtr = 0;
        }
    }

    public void setBlockId(BigInteger bigInteger) {
        MapEngineJNIBridge.BlockInfo_blockId_set(this.swigCPtr, this, bigInteger);
    }

    public BigInteger getBlockId() {
        return MapEngineJNIBridge.BlockInfo_blockId_get(this.swigCPtr, this);
    }

    public void setBlockType(BlockType blockType) {
        MapEngineJNIBridge.BlockInfo_blockType_set(this.swigCPtr, this, blockType.swigValue());
    }

    public BlockType getBlockType() {
        return BlockType.swigToEnum(MapEngineJNIBridge.BlockInfo_blockType_get(this.swigCPtr, this));
    }

    public void setStartPoint(BlockPoint blockPoint) {
        MapEngineJNIBridge.BlockInfo_startPoint_set(this.swigCPtr, this, BlockPoint.getCPtr(blockPoint), blockPoint);
    }

    public BlockPoint getStartPoint() {
        long BlockInfo_startPoint_get = MapEngineJNIBridge.BlockInfo_startPoint_get(this.swigCPtr, this);
        if (BlockInfo_startPoint_get == 0) {
            return null;
        }
        return new BlockPoint(BlockInfo_startPoint_get, false);
    }

    public void setEndPoint(BlockPoint blockPoint) {
        MapEngineJNIBridge.BlockInfo_endPoint_set(this.swigCPtr, this, BlockPoint.getCPtr(blockPoint), blockPoint);
    }

    public BlockPoint getEndPoint() {
        long BlockInfo_endPoint_get = MapEngineJNIBridge.BlockInfo_endPoint_get(this.swigCPtr, this);
        if (BlockInfo_endPoint_get == 0) {
            return null;
        }
        return new BlockPoint(BlockInfo_endPoint_get, false);
    }

    public BlockInfo() {
        this(MapEngineJNIBridge.new_BlockInfo(), true);
    }
}
