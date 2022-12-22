package org.mozilla.javascript.typedarrays;

import androidx.core.view.InputDeviceCompat;
import org.mozilla.javascript.ScriptRuntime;

public class Conversions {
    public static final int EIGHT_BIT = 256;
    public static final int SIXTEEN_BIT = 65536;
    public static final long THIRTYTWO_BIT = 4294967296L;

    public static int toInt8(Object obj) {
        int i;
        if (obj instanceof Integer) {
            i = ((Integer) obj).intValue();
        } else {
            i = ScriptRuntime.toInt32(obj);
        }
        int i2 = i % 256;
        return i2 >= 128 ? i2 + InputDeviceCompat.SOURCE_ANY : i2;
    }

    public static int toUint8(Object obj) {
        int i;
        if (obj instanceof Integer) {
            i = ((Integer) obj).intValue();
        } else {
            i = ScriptRuntime.toInt32(obj);
        }
        return i % 256;
    }

    public static int toUint8Clamp(Object obj) {
        double number = ScriptRuntime.toNumber(obj);
        if (number <= 0.0d) {
            return 0;
        }
        if (number >= 255.0d) {
            return 255;
        }
        double floor = Math.floor(number);
        double d = 0.5d + floor;
        if (d < number) {
            return (int) (floor + 1.0d);
        }
        if (number < d) {
            return (int) floor;
        }
        int i = (int) floor;
        return i % 2 != 0 ? i + 1 : i;
    }

    public static int toInt16(Object obj) {
        int i;
        if (obj instanceof Integer) {
            i = ((Integer) obj).intValue();
        } else {
            i = ScriptRuntime.toInt32(obj);
        }
        int i2 = i % 65536;
        return i2 >= 32768 ? i2 - 65536 : i2;
    }

    public static int toUint16(Object obj) {
        int i;
        if (obj instanceof Integer) {
            i = ((Integer) obj).intValue();
        } else {
            i = ScriptRuntime.toInt32(obj);
        }
        return i % 65536;
    }

    public static int toInt32(Object obj) {
        long number = ((long) ScriptRuntime.toNumber(obj)) % THIRTYTWO_BIT;
        if (number >= 2147483648L) {
            number -= THIRTYTWO_BIT;
        }
        return (int) number;
    }

    public static long toUint32(Object obj) {
        return ((long) ScriptRuntime.toNumber(obj)) % THIRTYTWO_BIT;
    }
}
