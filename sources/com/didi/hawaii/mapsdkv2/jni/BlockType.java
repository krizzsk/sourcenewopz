package com.didi.hawaii.mapsdkv2.jni;

public final class BlockType {
    public static final BlockType HW_TRAFFIC_JAM = new BlockType("HW_TRAFFIC_JAM", MapEngineJNIBridge.HW_TRAFFIC_JAM_get());
    public static final BlockType HW_TRAFFIC_JAM_ACCIDENT = new BlockType("HW_TRAFFIC_JAM_ACCIDENT", MapEngineJNIBridge.HW_TRAFFIC_JAM_ACCIDENT_get());
    public static final BlockType HW_TRAFFIC_JAM_HOSPITAL = new BlockType("HW_TRAFFIC_JAM_HOSPITAL", MapEngineJNIBridge.HW_TRAFFIC_JAM_HOSPITAL_get());
    public static final BlockType HW_TRAFFIC_JAM_IMAGE = new BlockType("HW_TRAFFIC_JAM_IMAGE", MapEngineJNIBridge.HW_TRAFFIC_JAM_IMAGE_get());
    public static final BlockType HW_TRAFFIC_JAM_MULTI = new BlockType("HW_TRAFFIC_JAM_MULTI", MapEngineJNIBridge.HW_TRAFFIC_JAM_MULTI_get());
    public static final BlockType HW_TRAFFIC_JAM_NONE;
    public static final BlockType HW_TRAFFIC_JAM_SCHOOL = new BlockType("HW_TRAFFIC_JAM_SCHOOL", MapEngineJNIBridge.HW_TRAFFIC_JAM_SCHOOL_get());
    private static int swigNext = 0;
    private static BlockType[] swigValues;
    private final String swigName;
    private final int swigValue;

    static {
        BlockType blockType = new BlockType("HW_TRAFFIC_JAM_NONE", MapEngineJNIBridge.HW_TRAFFIC_JAM_NONE_get());
        HW_TRAFFIC_JAM_NONE = blockType;
        swigValues = new BlockType[]{HW_TRAFFIC_JAM, HW_TRAFFIC_JAM_ACCIDENT, HW_TRAFFIC_JAM_MULTI, HW_TRAFFIC_JAM_SCHOOL, HW_TRAFFIC_JAM_HOSPITAL, HW_TRAFFIC_JAM_IMAGE, blockType};
    }

    public final int swigValue() {
        return this.swigValue;
    }

    public String toString() {
        return this.swigName;
    }

    public static BlockType swigToEnum(int i) {
        BlockType[] blockTypeArr = swigValues;
        if (i < blockTypeArr.length && i >= 0 && blockTypeArr[i].swigValue == i) {
            return blockTypeArr[i];
        }
        int i2 = 0;
        while (true) {
            BlockType[] blockTypeArr2 = swigValues;
            if (i2 >= blockTypeArr2.length) {
                throw new IllegalArgumentException("No enum " + BlockType.class + " with value " + i);
            } else if (blockTypeArr2[i2].swigValue == i) {
                return blockTypeArr2[i2];
            } else {
                i2++;
            }
        }
    }

    private BlockType(String str) {
        this.swigName = str;
        int i = swigNext;
        swigNext = i + 1;
        this.swigValue = i;
    }

    private BlockType(String str, int i) {
        this.swigName = str;
        this.swigValue = i;
        swigNext = i + 1;
    }

    private BlockType(String str, BlockType blockType) {
        this.swigName = str;
        int i = blockType.swigValue;
        this.swigValue = i;
        swigNext = i + 1;
    }
}
