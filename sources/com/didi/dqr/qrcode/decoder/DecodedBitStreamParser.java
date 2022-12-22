package com.didi.dqr.qrcode.decoder;

import com.didi.dqr.DecodeHintType;
import com.didi.dqr.FormatException;
import com.didi.dqr.common.BitSource;
import com.didi.dqr.common.CharacterSetECI;
import com.didi.dqr.common.DecoderResult;
import com.didi.dqr.common.StringUtils;
import com.didi.dqrutil.analysis.AnalysisManager;
import com.didi.dqrutil.analysis.EventId;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class DecodedBitStreamParser {

    /* renamed from: a */
    private static final char[] f19016a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* renamed from: b */
    private static final int f19017b = 1;

    private DecodedBitStreamParser() {
    }

    public static DecoderResult decode(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        Mode forBits;
        Mode mode;
        Version version2 = version;
        BitSource bitSource = new BitSource(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i = 1;
        ArrayList arrayList = new ArrayList(1);
        String str = null;
        CharacterSetECI characterSetECI = null;
        boolean z = false;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            try {
                if (bitSource.available() < 4) {
                    forBits = Mode.TERMINATOR;
                } else {
                    forBits = Mode.forBits(bitSource.readBits(4));
                }
                Mode mode2 = forBits;
                switch (mode2) {
                    case TERMINATOR:
                        break;
                    case FNC1_FIRST_POSITION:
                    case FNC1_SECOND_POSITION:
                        mode = mode2;
                        z = true;
                        break;
                    case STRUCTURED_APPEND:
                        if (bitSource.available() >= 16) {
                            int readBits = bitSource.readBits(8);
                            i3 = bitSource.readBits(8);
                            i2 = readBits;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    case ECI:
                        characterSetECI = CharacterSetECI.getCharacterSetECIByValue(m14205a(bitSource));
                        if (characterSetECI == null) {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    case HANZI:
                        int readBits2 = bitSource.readBits(4);
                        int readBits3 = bitSource.readBits(mode2.getCharacterCountBits(version2));
                        if (readBits2 == i) {
                            m14206a(bitSource, sb, readBits3);
                            break;
                        }
                        break;
                    default:
                        int readBits4 = bitSource.readBits(mode2.getCharacterCountBits(version2));
                        int i4 = C78961.$SwitchMap$com$didi$dqr$qrcode$decoder$Mode[mode2.ordinal()];
                        if (i4 != i) {
                            if (i4 != 2) {
                                if (i4 == 3) {
                                    mode = mode2;
                                    m14207a(bitSource, sb, readBits4, characterSetECI, arrayList, map);
                                    break;
                                } else if (i4 == 4) {
                                    m14209b(bitSource, sb, readBits4);
                                    break;
                                } else {
                                    AnalysisManager.report(EventId.QRCODE_RESULT_MODE_ERROR);
                                    throw FormatException.getFormatInstance();
                                }
                            } else {
                                mode = mode2;
                                m14208a(bitSource, sb, readBits4, z);
                                break;
                            }
                        } else {
                            mode = mode2;
                            m14210c(bitSource, sb, readBits4);
                            break;
                        }
                }
                mode = mode2;
                if (mode == Mode.TERMINATOR) {
                    String sb2 = sb.toString();
                    ArrayList arrayList2 = arrayList.isEmpty() ? null : arrayList;
                    if (errorCorrectionLevel != null) {
                        str = errorCorrectionLevel.toString();
                    }
                    return new DecoderResult(bArr, sb2, arrayList2, str, i2, i3);
                }
                i = 1;
            } catch (IllegalArgumentException unused) {
                AnalysisManager.report(EventId.QRCODE_RESULT_MODE_ERROR);
                throw FormatException.getFormatInstance();
            }
        }
    }

    /* renamed from: a */
    private static void m14206a(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        if (i * 13 <= bitSource.available()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int readBits = bitSource.readBits(13);
                int i3 = (readBits % 96) | ((readBits / 96) << 8);
                int i4 = i3 + (i3 < 959 ? 41377 : 42657);
                bArr[i2] = (byte) ((i4 >> 8) & 255);
                bArr[i2 + 1] = (byte) (i4 & 255);
                i2 += 2;
                i--;
            }
            try {
                sb.append(new String(bArr, "GB2312"));
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    /* renamed from: b */
    private static void m14209b(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        if (i * 13 <= bitSource.available()) {
            byte[] bArr = new byte[(i * 2)];
            int i2 = 0;
            while (i > 0) {
                int readBits = bitSource.readBits(13);
                int i3 = (readBits % 192) | ((readBits / 192) << 8);
                int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
                bArr[i2] = (byte) (i4 >> 8);
                bArr[i2 + 1] = (byte) i4;
                i2 += 2;
                i--;
            }
            try {
                sb.append(new String(bArr, "SJIS"));
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    /* renamed from: a */
    private static void m14207a(BitSource bitSource, StringBuilder sb, int i, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        String str;
        if (i * 8 <= bitSource.available()) {
            byte[] bArr = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                bArr[i2] = (byte) bitSource.readBits(8);
            }
            if (characterSetECI == null) {
                str = StringUtils.guessEncoding(bArr, map);
            } else {
                str = characterSetECI.name();
            }
            try {
                sb.append(new String(bArr, str));
                collection.add(bArr);
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    /* renamed from: a */
    private static char m14204a(int i) throws FormatException {
        char[] cArr = f19016a;
        if (i < cArr.length) {
            return cArr[i];
        }
        AnalysisManager.report(EventId.QRCODE_CODE_TO_RESULT_ERROR);
        throw FormatException.getFormatInstance();
    }

    /* renamed from: a */
    private static void m14208a(BitSource bitSource, StringBuilder sb, int i, boolean z) throws FormatException {
        while (i > 1) {
            if (bitSource.available() >= 11) {
                int readBits = bitSource.readBits(11);
                sb.append(m14204a(readBits / 45));
                sb.append(m14204a(readBits % 45));
                i -= 2;
            } else {
                AnalysisManager.report(EventId.QRCODE_CODE_TO_RESULT_ERROR);
                throw FormatException.getFormatInstance();
            }
        }
        if (i == 1) {
            if (bitSource.available() >= 6) {
                sb.append(m14204a(bitSource.readBits(6)));
            } else {
                AnalysisManager.report(EventId.QRCODE_CODE_TO_RESULT_ERROR);
                throw FormatException.getFormatInstance();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        }
                    }
                    sb.setCharAt(length, 29);
                }
            }
        }
    }

    /* renamed from: c */
    private static void m14210c(BitSource bitSource, StringBuilder sb, int i) throws FormatException {
        while (i >= 3) {
            if (bitSource.available() >= 10) {
                int readBits = bitSource.readBits(10);
                if (readBits < 1000) {
                    sb.append(m14204a(readBits / 100));
                    sb.append(m14204a((readBits / 10) % 10));
                    sb.append(m14204a(readBits % 10));
                    i -= 3;
                } else {
                    throw FormatException.getFormatInstance();
                }
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i == 2) {
            if (bitSource.available() >= 7) {
                int readBits2 = bitSource.readBits(7);
                if (readBits2 < 100) {
                    sb.append(m14204a(readBits2 / 10));
                    sb.append(m14204a(readBits2 % 10));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        } else if (i != 1) {
        } else {
            if (bitSource.available() >= 4) {
                int readBits3 = bitSource.readBits(4);
                if (readBits3 < 10) {
                    sb.append(m14204a(readBits3));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        }
    }

    /* renamed from: a */
    private static int m14205a(BitSource bitSource) throws FormatException {
        int readBits = bitSource.readBits(8);
        if ((readBits & 128) == 0) {
            return readBits & 127;
        }
        if ((readBits & 192) == 128) {
            return bitSource.readBits(8) | ((readBits & 63) << 8);
        }
        if ((readBits & 224) == 192) {
            return bitSource.readBits(16) | ((readBits & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }
}
