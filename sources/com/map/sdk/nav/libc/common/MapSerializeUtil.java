package com.map.sdk.nav.libc.common;

import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class MapSerializeUtil {
    private static final String UTF_16_LE = "UTF-16LE";
    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    public static byte[] intToBytes(int i) {
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    public static byte[] longToBytes(long j) {
        return new byte[]{(byte) ((int) j), (byte) ((int) (j >> 8)), (byte) ((int) (j >> 16)), (byte) ((int) (j >> 24)), (byte) ((int) (j >> 32)), (byte) ((int) (j >> 40)), (byte) ((int) (j >> 48)), (byte) ((int) (j >> 56))};
    }

    public void appendByteArray(byte[] bArr) {
        this.byteArrayOutputStream.write(bArr, 0, bArr.length);
    }

    public void appendByte(byte b) {
        this.byteArrayOutputStream.write(b);
    }

    public byte[] toByteArray() {
        byte[] bArr;
        IOException e;
        try {
            this.byteArrayOutputStream.close();
            bArr = this.byteArrayOutputStream.toByteArray();
            try {
                this.byteArrayOutputStream = null;
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            IOException iOException = e3;
            bArr = null;
            e = iOException;
            e.printStackTrace();
            return bArr;
        }
        return bArr;
    }

    public static int bytesToInt(byte[] bArr) {
        return ((bArr[3] << Ascii.CAN) & -16777216) | (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 16) & 16711680);
    }

    public static boolean bytesToBoolean(byte[] bArr) {
        return bArr[0] > 0;
    }

    public static long bytesToLong(byte[] bArr) {
        return ((long) (bArr[0] & 255)) | (((long) (bArr[1] & 255)) << 8) | (((long) (bArr[2] & 255)) << 16) | (((long) (bArr[3] & 255)) << 24) | (((long) (bArr[4] & 255)) << 32) | (((long) (bArr[5] & 255)) << 40) | (((long) (bArr[6] & 255)) << 48) | (((long) (bArr[7] & 255)) << 56);
    }

    public static byte[] floatToBytes(float f) {
        return intToBytes(Float.floatToIntBits(f));
    }

    public static float bytesToFloat(byte[] bArr) {
        return Float.intBitsToFloat(bytesToInt(bArr));
    }

    public static byte[] doubleToBytes(double d) {
        return longToBytes(Double.doubleToLongBits(d));
    }

    public static double bytesToDouble(byte[] bArr) {
        return Double.longBitsToDouble(bytesToLong(bArr));
    }

    public static byte[] stringToBytesEndNull(String str) {
        if (str != null) {
            try {
                byte[] bytes = str.getBytes("UTF-16LE");
                byte[] bArr = new byte[(bytes.length + 2)];
                System.arraycopy(bytes, 0, bArr, 0, bytes.length);
                bArr[bytes.length] = 0;
                bArr[bytes.length + 1] = 0;
                return bArr;
            } catch (Exception unused) {
            }
        }
        return new byte[0];
    }

    public static byte[] stringToBytes(String str) {
        if (str != null) {
            try {
                return str.getBytes("UTF-16LE");
            } catch (Exception unused) {
            }
        }
        return new byte[0];
    }

    public static String bytesToString_utf8(byte[] bArr) {
        try {
            return new String(bArr, "UTF_8").trim();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String bytesToString(byte[] bArr) {
        try {
            return new String(bArr, "UTF-16LE").trim();
        } catch (Exception unused) {
            return null;
        }
    }
}
