package com.didichuxing.security.quickjs;

final class JSFloat64 extends JSNumber {
    private final double value;

    JSFloat64(long j, JSContext jSContext, double d) {
        super(j, jSContext);
        this.value = d;
    }

    private String wrongNumberMessage(String str, double d) {
        return "Can't treat " + d + " as " + str;
    }

    public byte getByte() {
        double d = this.value;
        byte b = (byte) ((int) d);
        if (((double) b) == d) {
            return b;
        }
        throw new JSDataException(wrongNumberMessage("byte", d));
    }

    public short getShort() {
        double d = this.value;
        short s = (short) ((int) d);
        if (((double) s) == d) {
            return s;
        }
        throw new JSDataException(wrongNumberMessage("short", d));
    }

    public int getInt() {
        double d = this.value;
        int i = (int) d;
        if (((double) i) == d) {
            return i;
        }
        throw new JSDataException(wrongNumberMessage("int", d));
    }

    public long getLong() {
        double d = this.value;
        long j = (long) d;
        if (((double) j) == d) {
            return j;
        }
        throw new JSDataException(wrongNumberMessage("long", d));
    }

    public float getFloat() {
        return (float) this.value;
    }

    public double getDouble() {
        return this.value;
    }
}
