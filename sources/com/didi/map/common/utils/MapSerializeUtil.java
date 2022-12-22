package com.didi.map.common.utils;

import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class MapSerializeUtil {

    /* renamed from: a */
    private static final String f24683a = "UTF-16LE";

    /* renamed from: b */
    private ByteArrayOutputStream f24684b = new ByteArrayOutputStream();

    public static byte[] intToBytes(int i) {
        return new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    public static byte[] longToBytes(long j) {
        return new byte[]{(byte) ((int) j), (byte) ((int) (j >> 8)), (byte) ((int) (j >> 16)), (byte) ((int) (j >> 24)), (byte) ((int) (j >> 32)), (byte) ((int) (j >> 40)), (byte) ((int) (j >> 48)), (byte) ((int) (j >> 56))};
    }

    public void appendByteArray(byte[] bArr) {
        this.f24684b.write(bArr, 0, bArr.length);
    }

    public void appendByte(byte b) {
        this.f24684b.write(b);
    }

    public byte[] toByteArray() {
        byte[] bArr;
        IOException e;
        try {
            this.f24684b.close();
            bArr = this.f24684b.toByteArray();
            try {
                this.f24684b = null;
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

    public static int bytesToInt(byte[] bArr, int i) {
        return ((bArr[i + 3] << Ascii.CAN) & -16777216) | (bArr[i] & 255) | ((bArr[i + 1] << 8) & 65280) | ((bArr[i + 2] << 16) & 16711680);
    }

    public static boolean bytesToBoolean(byte[] bArr) {
        return bArr[0] > 0;
    }

    public static long bytesToLong(byte[] bArr) {
        return ((long) (bArr[0] & 255)) | (((long) (bArr[1] & 255)) << 8) | (((long) (bArr[2] & 255)) << 16) | (((long) (bArr[3] & 255)) << 24) | (((long) (bArr[4] & 255)) << 32) | (((long) (bArr[5] & 255)) << 40) | (((long) (bArr[6] & 255)) << 48) | (((long) (bArr[7] & 255)) << 56);
    }

    public static long bytesToLong(byte[] bArr, int i) {
        return (((long) (bArr[i + 7] & 255)) << 56) | ((long) (bArr[i] & 255)) | (((long) (bArr[i + 1] & 255)) << 8) | (((long) (bArr[i + 2] & 255)) << 16) | (((long) (bArr[i + 3] & 255)) << 24) | (((long) (bArr[i + 4] & 255)) << 32) | (((long) (bArr[i + 5] & 255)) << 40) | (((long) (bArr[i + 6] & 255)) << 48);
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new byte[0];
    }

    public static int[] stringToIntsEndNull(String str, int i) {
        if (str != null) {
            try {
                byte[] bytes = str.getBytes("UTF-16LE");
                int length = bytes.length + 2;
                byte[] bArr = new byte[length];
                System.arraycopy(bytes, 0, bArr, 0, bytes.length);
                bArr[bytes.length] = 0;
                bArr[bytes.length + 1] = 0;
                int[] iArr = new int[i];
                int i2 = 0;
                int i3 = 0;
                while (i2 < length - 1) {
                    int i4 = i3 + 1;
                    iArr[i3] = (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8);
                    i2 += 2;
                    i3 = i4;
                }
                return iArr;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new int[0];
    }

    public static byte[] intsToBytesEndNull(int[] iArr) {
        if (iArr != null) {
            try {
                byte[] bArr = new byte[((iArr.length * 2) + 2)];
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i >= iArr.length) {
                        break;
                    } else if (iArr[i] == 0) {
                        break;
                    } else {
                        int i3 = i2 + 1;
                        bArr[i2] = (byte) (iArr[i] & 255);
                        i2 = i3 + 1;
                        bArr[i3] = (byte) ((iArr[i] >> 8) & 255);
                        i++;
                    }
                }
                int i4 = i2 + 1;
                bArr[i2] = 0;
                int i5 = i4 + 1;
                bArr[i4] = 0;
                byte[] bArr2 = new byte[i5];
                System.arraycopy(bArr, 0, bArr2, 0, i5);
                return bArr2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new byte[0];
    }

    public static byte[] intsToBytesEndNull(int[] iArr, int i) {
        if (iArr != null) {
            try {
                int min = Math.min(iArr.length, i);
                byte[] bArr = new byte[((min * 2) + 2)];
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= min) {
                        break;
                    } else if (iArr[i2] == 0) {
                        break;
                    } else {
                        int i4 = i3 + 1;
                        bArr[i3] = (byte) (iArr[i2] & 255);
                        i3 = i4 + 1;
                        bArr[i4] = (byte) ((iArr[i2] >> 8) & 255);
                        i2++;
                    }
                }
                int i5 = i3 + 1;
                bArr[i3] = 0;
                int i6 = i5 + 1;
                bArr[i5] = 0;
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, 0, bArr2, 0, i6);
                return bArr2;
            } catch (Exception e) {
                e.printStackTrace();
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String bytesToString_urf8(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "UTF-8").trim();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
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

    public static String bytesToString(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "UTF-16LE").trim();
        } catch (Exception unused) {
            return null;
        }
    }
}
