package com.didi.sdk.messagecenter.util;

import com.didi.raven.config.RavenKey;
import com.didichuxing.mlcp.drtc.consts.SDKConsts;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import net.lingala.zip4j.util.InternalZipConstants;
import org.mozilla.javascript.typedarrays.Conversions;

public class TextUtils {

    /* renamed from: a */
    private static final Pattern f36795a = Pattern.compile("-?inf(inity)?", 2);

    /* renamed from: b */
    private static final Pattern f36796b = Pattern.compile("-?inf(inity)?f?", 2);

    /* renamed from: c */
    private static final Pattern f36797c = Pattern.compile("nanf?", 2);

    /* renamed from: d */
    private static final Pattern f36798d = Pattern.compile("[0-9]", 2);

    /* renamed from: e */
    private static final int f36799e = 4096;

    public static int digitValue(char c) {
        if ('0' <= c && c <= '9') {
            return c - '0';
        }
        return (('a' > c || c > 'z') ? c - 'A' : c - 'a') + 10;
    }

    public static boolean isHex(char c) {
        return ('0' <= c && c <= '9') || ('a' <= c && c <= 'f') || ('A' <= c && c <= 'F');
    }

    public static boolean isOctal(char c) {
        return '0' <= c && c <= '7';
    }

    public static String unsignedToString(long j) {
        if (j >= 0) {
            return Long.toString(j);
        }
        return BigInteger.valueOf(j & Long.MAX_VALUE).setBit(63).toString();
    }

    public static String unsignedToString(int i) {
        if (i >= 0) {
            return Integer.toString(i);
        }
        return Long.toString(((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
    }

    public static BigInteger unsignedLong(long j) {
        if (j < 0) {
            return BigInteger.valueOf(j & Long.MAX_VALUE).setBit(63);
        }
        return BigInteger.valueOf(j);
    }

    public static boolean isDigits(String str) {
        return f36798d.matcher(str).matches();
    }

    public static StringBuilder toStringBuilder(Readable readable) throws IOException {
        StringBuilder sb = new StringBuilder();
        CharBuffer allocate = CharBuffer.allocate(4096);
        while (true) {
            int read = readable.read(allocate);
            if (read == -1) {
                return sb;
            }
            allocate.flip();
            sb.append(allocate, 0, read);
        }
    }

    public static InputStream toInputStream(String str) {
        return toInputStream(str, Charset.defaultCharset());
    }

    public static InputStream toInputStream(String str, Charset charset) {
        return new ByteArrayInputStream(str.getBytes(charset));
    }

    public static double parseDouble(String str) throws NumberFormatException {
        if (f36795a.matcher(str).matches()) {
            return str.startsWith("-") ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        if (str.equalsIgnoreCase("nan")) {
            return Double.NaN;
        }
        return Double.parseDouble(str);
    }

    public static float parseFloat(String str) throws NumberFormatException {
        if (f36796b.matcher(str).matches()) {
            return str.startsWith("-") ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
        }
        if (f36797c.matcher(str).matches()) {
            return Float.NaN;
        }
        return Float.parseFloat(str);
    }

    public static boolean parseBoolean(String str) throws IllegalArgumentException {
        if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase(RavenKey.TYPE) || str.equals("1")) {
            return true;
        }
        if (str.equalsIgnoreCase(SDKConsts.BOOLEAN_FALSE) || str.equalsIgnoreCase("f") || str.equals("0")) {
            return false;
        }
        throw new IllegalArgumentException("Expected \"true\" or \"false\".");
    }

    public static int parseInt32(String str) throws NumberFormatException {
        return (int) parseInteger(str, true, false);
    }

    public static int parseUInt32(String str) throws NumberFormatException {
        return (int) parseInteger(str, false, false);
    }

    public static long parseInt64(String str) throws NumberFormatException {
        return parseInteger(str, true, true);
    }

    public static long parseUInt64(String str) throws NumberFormatException {
        return parseInteger(str, false, true);
    }

    public static long parseInteger(String str, boolean z, boolean z2) throws NumberFormatException {
        int i = 0;
        boolean z3 = true;
        if (!str.startsWith("-", 0)) {
            z3 = false;
        } else if (z) {
            i = 1;
        } else {
            throw new NumberFormatException("Number must be positive: " + str);
        }
        int i2 = 10;
        if (str.startsWith("0x", i)) {
            i += 2;
            i2 = 16;
        } else if (str.startsWith("0", i)) {
            i2 = 8;
        }
        String substring = str.substring(i);
        if (substring.length() < 16) {
            long parseLong = Long.parseLong(substring, i2);
            if (z3) {
                parseLong = -parseLong;
            }
            if (z2) {
                return parseLong;
            }
            if (z) {
                if (parseLong <= 2147483647L && parseLong >= -2147483648L) {
                    return parseLong;
                }
                throw new NumberFormatException("Number out of range for 32-bit signed integer: " + str);
            } else if (parseLong < Conversions.THIRTYTWO_BIT && parseLong >= 0) {
                return parseLong;
            } else {
                throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + str);
            }
        } else {
            BigInteger bigInteger = new BigInteger(substring, i2);
            if (z3) {
                bigInteger = bigInteger.negate();
            }
            if (!z2) {
                if (z) {
                    if (bigInteger.bitLength() > 31) {
                        throw new NumberFormatException("Number out of range for 32-bit signed integer: " + str);
                    }
                } else if (bigInteger.bitLength() > 32) {
                    throw new NumberFormatException("Number out of range for 32-bit unsigned integer: " + str);
                }
            } else if (z) {
                if (bigInteger.bitLength() > 63) {
                    throw new NumberFormatException("Number out of range for 64-bit signed integer: " + str);
                }
            } else if (bigInteger.bitLength() > 64) {
                throw new NumberFormatException("Number out of range for 64-bit unsigned integer: " + str);
            }
            return bigInteger.longValue();
        }
    }
}
