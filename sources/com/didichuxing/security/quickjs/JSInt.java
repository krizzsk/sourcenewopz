package com.didichuxing.security.quickjs;

final class JSInt extends JSNumber {
    private final int value;

    JSInt(long j, JSContext jSContext, int i) {
        super(j, jSContext);
        this.value = i;
    }

    private int getIntInRange(String str, int i, int i2) {
        int i3 = this.value;
        if (i <= i3 && i3 <= i2) {
            return i3;
        }
        throw new JSDataException("Can't treat " + i3 + " as " + str);
    }

    public byte getByte() {
        return (byte) getIntInRange("byte", -128, 127);
    }

    public short getShort() {
        return (short) getIntInRange("short", -32768, 32767);
    }

    public int getInt() {
        return this.value;
    }

    public long getLong() {
        return (long) this.value;
    }

    public float getFloat() {
        return (float) this.value;
    }

    public double getDouble() {
        return (double) this.value;
    }
}
