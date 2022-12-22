package org.apache.commons.codec2.language;

import androidx.exifinterface.media.ExifInterface;
import com.didi.sdk.sidebar.history.HistoryRecordFragment;
import com.didi.sdk.util.GlobalCountryCode;
import java.util.Locale;
import org.apache.commons.codec2.EncoderException;
import org.apache.commons.codec2.StringEncoder;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public class DoubleMetaphone implements StringEncoder {
    private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = {GlobalCountryCode.SPAIN, "EP", "EB", "EL", "EY", "IB", "IL", "IN", GlobalCountryCode.IRELAND, "EI", "ER"};
    private static final String[] L_R_N_M_B_H_F_V_W_SPACE = {"L", "R", "N", "M", "B", "H", "F", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, " "};
    private static final String[] L_T_K_S_N_M_B_Z = {"L", "T", "K", ExifInterface.LATITUDE_SOUTH, "N", "M", "B", "Z"};
    private static final String[] SILENT_START = {"GN", "KN", "PN", "WR", "PS"};
    private static final String VOWELS = "AEIOUY";
    private int maxCodeLen = 4;

    public String doubleMetaphone(String str) {
        return doubleMetaphone(str, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005a, code lost:
        if (charAt(r8, r3) == 'V') goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005c, code lost:
        r1 = r1 + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005f, code lost:
        r1 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007b, code lost:
        if (charAt(r8, r3) == 'Q') goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008c, code lost:
        if (charAt(r8, r3) == 'N') goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0098, code lost:
        if (conditionM0(r8, r1) != false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00aa, code lost:
        if (charAt(r8, r3) == 'K') goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c8, code lost:
        if (charAt(r8, r3) == 'F') goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e4, code lost:
        if (charAt(r8, r3) == 'B') goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String doubleMetaphone(java.lang.String r8, boolean r9) {
        /*
            r7 = this;
            java.lang.String r8 = r7.cleanInput(r8)
            if (r8 != 0) goto L_0x0008
            r8 = 0
            return r8
        L_0x0008:
            boolean r0 = r7.isSlavoGermanic(r8)
            boolean r1 = r7.isSilentStart(r8)
            org.apache.commons.codec2.language.DoubleMetaphone$DoubleMetaphoneResult r2 = new org.apache.commons.codec2.language.DoubleMetaphone$DoubleMetaphoneResult
            int r3 = r7.getMaxCodeLen()
            r2.<init>(r3)
        L_0x0019:
            boolean r3 = r2.isComplete()
            if (r3 != 0) goto L_0x00fb
            int r3 = r8.length()
            int r3 = r3 + -1
            if (r1 <= r3) goto L_0x0029
            goto L_0x00fb
        L_0x0029:
            char r3 = r8.charAt(r1)
            r4 = 199(0xc7, float:2.79E-43)
            if (r3 == r4) goto L_0x00f2
            r4 = 209(0xd1, float:2.93E-43)
            r5 = 78
            if (r3 == r4) goto L_0x00ee
            r4 = 75
            r6 = 70
            switch(r3) {
                case 65: goto L_0x00e8;
                case 66: goto L_0x00d7;
                case 67: goto L_0x00d1;
                case 68: goto L_0x00cb;
                case 69: goto L_0x00e8;
                case 70: goto L_0x00bf;
                case 71: goto L_0x00b9;
                case 72: goto L_0x00b3;
                case 73: goto L_0x00e8;
                case 74: goto L_0x00ad;
                case 75: goto L_0x00a1;
                case 76: goto L_0x009b;
                case 77: goto L_0x008f;
                case 78: goto L_0x0083;
                case 79: goto L_0x00e8;
                case 80: goto L_0x007e;
                case 81: goto L_0x0070;
                case 82: goto L_0x006b;
                case 83: goto L_0x0066;
                case 84: goto L_0x0061;
                case 85: goto L_0x00e8;
                case 86: goto L_0x004f;
                case 87: goto L_0x004a;
                case 88: goto L_0x0045;
                case 89: goto L_0x00e8;
                case 90: goto L_0x0040;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x00f7
        L_0x0040:
            int r1 = r7.handleZ(r8, r2, r1, r0)
            goto L_0x0019
        L_0x0045:
            int r1 = r7.handleX(r8, r2, r1)
            goto L_0x0019
        L_0x004a:
            int r1 = r7.handleW(r8, r2, r1)
            goto L_0x0019
        L_0x004f:
            r2.append((char) r6)
            int r3 = r1 + 1
            char r4 = r7.charAt(r8, r3)
            r5 = 86
            if (r4 != r5) goto L_0x005f
        L_0x005c:
            int r1 = r1 + 2
            goto L_0x0019
        L_0x005f:
            r1 = r3
            goto L_0x0019
        L_0x0061:
            int r1 = r7.handleT(r8, r2, r1)
            goto L_0x0019
        L_0x0066:
            int r1 = r7.handleS(r8, r2, r1, r0)
            goto L_0x0019
        L_0x006b:
            int r1 = r7.handleR(r8, r2, r1, r0)
            goto L_0x0019
        L_0x0070:
            r2.append((char) r4)
            int r3 = r1 + 1
            char r4 = r7.charAt(r8, r3)
            r5 = 81
            if (r4 != r5) goto L_0x005f
            goto L_0x005c
        L_0x007e:
            int r1 = r7.handleP(r8, r2, r1)
            goto L_0x0019
        L_0x0083:
            r2.append((char) r5)
            int r3 = r1 + 1
            char r4 = r7.charAt(r8, r3)
            if (r4 != r5) goto L_0x005f
            goto L_0x005c
        L_0x008f:
            r3 = 77
            r2.append((char) r3)
            boolean r3 = r7.conditionM0(r8, r1)
            if (r3 == 0) goto L_0x00f7
            goto L_0x005c
        L_0x009b:
            int r1 = r7.handleL(r8, r2, r1)
            goto L_0x0019
        L_0x00a1:
            r2.append((char) r4)
            int r3 = r1 + 1
            char r5 = r7.charAt(r8, r3)
            if (r5 != r4) goto L_0x005f
            goto L_0x005c
        L_0x00ad:
            int r1 = r7.handleJ(r8, r2, r1, r0)
            goto L_0x0019
        L_0x00b3:
            int r1 = r7.handleH(r8, r2, r1)
            goto L_0x0019
        L_0x00b9:
            int r1 = r7.handleG(r8, r2, r1, r0)
            goto L_0x0019
        L_0x00bf:
            r2.append((char) r6)
            int r3 = r1 + 1
            char r4 = r7.charAt(r8, r3)
            if (r4 != r6) goto L_0x005f
            goto L_0x005c
        L_0x00cb:
            int r1 = r7.handleD(r8, r2, r1)
            goto L_0x0019
        L_0x00d1:
            int r1 = r7.handleC(r8, r2, r1)
            goto L_0x0019
        L_0x00d7:
            r3 = 80
            r2.append((char) r3)
            int r3 = r1 + 1
            char r4 = r7.charAt(r8, r3)
            r5 = 66
            if (r4 != r5) goto L_0x005f
            goto L_0x005c
        L_0x00e8:
            int r1 = r7.handleAEIOUY(r2, r1)
            goto L_0x0019
        L_0x00ee:
            r2.append((char) r5)
            goto L_0x00f7
        L_0x00f2:
            r3 = 83
            r2.append((char) r3)
        L_0x00f7:
            int r1 = r1 + 1
            goto L_0x0019
        L_0x00fb:
            if (r9 == 0) goto L_0x0102
            java.lang.String r8 = r2.getAlternate()
            goto L_0x0106
        L_0x0102:
            java.lang.String r8 = r2.getPrimary()
        L_0x0106:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec2.language.DoubleMetaphone.doubleMetaphone(java.lang.String, boolean):java.lang.String");
    }

    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return doubleMetaphone((String) obj);
        }
        throw new EncoderException("DoubleMetaphone encode parameter is not of type String");
    }

    public String encode(String str) {
        return doubleMetaphone(str);
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2) {
        return isDoubleMetaphoneEqual(str, str2, false);
    }

    public boolean isDoubleMetaphoneEqual(String str, String str2, boolean z) {
        return doubleMetaphone(str, z).equals(doubleMetaphone(str2, z));
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public void setMaxCodeLen(int i) {
        this.maxCodeLen = i;
    }

    private int handleAEIOUY(DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i == 0) {
            doubleMetaphoneResult.append('A');
        }
        return i + 1;
    }

    private int handleC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (conditionC0(str, i)) {
            doubleMetaphoneResult.append('K');
        } else if (i == 0 && contains(str, i, 6, "CAESAR")) {
            doubleMetaphoneResult.append('S');
        } else if (contains(str, i, 2, "CH")) {
            return handleCH(str, doubleMetaphoneResult, i);
        } else {
            if (!contains(str, i, 2, GlobalCountryCode.CZECH_REPUBLIC) || contains(str, i - 2, 4, "WICZ")) {
                int i2 = i + 1;
                if (contains(str, i2, 3, "CIA")) {
                    doubleMetaphoneResult.append('X');
                } else if (contains(str, i, 2, "CC") && (i != 1 || charAt(str, 0) != 'M')) {
                    return handleCC(str, doubleMetaphoneResult, i);
                } else {
                    if (contains(str, i, 2, "CK", "CG", "CQ")) {
                        doubleMetaphoneResult.append('K');
                    } else if (!contains(str, i, 2, "CI", "CE", GlobalCountryCode.CYPRUS)) {
                        doubleMetaphoneResult.append('K');
                        if (!contains(str, i2, 2, " C", " Q", " G")) {
                            if (!contains(str, i2, 1, "C", "K", "Q") || contains(str, i2, 2, "CE", "CI")) {
                                return i2;
                            }
                        }
                    } else if (contains(str, i, 3, "CIO", "CIE", "CIA")) {
                        doubleMetaphoneResult.append('S', 'X');
                    } else {
                        doubleMetaphoneResult.append('S');
                    }
                }
                return i + 3;
            }
            doubleMetaphoneResult.append('S', 'X');
        }
        return i + 2;
    }

    private int handleCC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 2;
        if (!contains(str, i2, 1, "I", ExifInterface.LONGITUDE_EAST, "H") || contains(str, i2, 2, GlobalCountryCode.HUNGARY)) {
            doubleMetaphoneResult.append('K');
            return i2;
        }
        if (!(i == 1 && charAt(str, i - 1) == 'A') && !contains(str, i - 1, 5, "UCCEE", "UCCES")) {
            doubleMetaphoneResult.append('X');
        } else {
            doubleMetaphoneResult.append("KS");
        }
        return i + 3;
    }

    private int handleCH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i > 0 && contains(str, i, 4, "CHAE")) {
            doubleMetaphoneResult.append('K', 'X');
        } else if (conditionCH0(str, i)) {
            doubleMetaphoneResult.append('K');
        } else if (conditionCH1(str, i)) {
            doubleMetaphoneResult.append('K');
        } else {
            if (i <= 0) {
                doubleMetaphoneResult.append('X');
            } else if (contains(str, 0, 2, "MC")) {
                doubleMetaphoneResult.append('K');
            } else {
                doubleMetaphoneResult.append('X', 'K');
            }
            return i + 2;
        }
        return i + 2;
    }

    private int handleD(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (contains(str, i, 2, "DG")) {
            int i2 = i + 2;
            if (contains(str, i2, 1, "I", ExifInterface.LONGITUDE_EAST, C16471q.f49113b)) {
                doubleMetaphoneResult.append('J');
                return i + 3;
            }
            doubleMetaphoneResult.append("TK");
            return i2;
        } else if (contains(str, i, 2, "DT", "DD")) {
            doubleMetaphoneResult.append('T');
            return i + 2;
        } else {
            doubleMetaphoneResult.append('T');
            return i + 1;
        }
    }

    private int handleG(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        String str2 = str;
        DoubleMetaphoneResult doubleMetaphoneResult2 = doubleMetaphoneResult;
        int i2 = i;
        int i3 = i2 + 1;
        if (charAt(str2, i3) == 'H') {
            return handleGH(str, doubleMetaphoneResult, i);
        }
        if (charAt(str2, i3) == 'N') {
            if (i2 == 1 && isVowel(charAt(str2, 0)) && !z) {
                doubleMetaphoneResult2.append("KN", "N");
            } else if (contains(str2, i2 + 2, 2, "EY") || charAt(str2, i3) == 'Y' || z) {
                doubleMetaphoneResult2.append("KN");
            } else {
                doubleMetaphoneResult2.append("N", "KN");
            }
        } else if (contains(str2, i3, 2, "LI") && !z) {
            doubleMetaphoneResult2.append("KL", "L");
        } else if (i2 != 0 || (charAt(str2, i3) != 'Y' && !contains(str2, i3, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))) {
            if ((contains(str2, i3, 2, "ER") || charAt(str2, i3) == 'Y') && !contains(str2, 0, 6, "DANGER", "RANGER", "MANGER")) {
                int i4 = i2 - 1;
                if (!contains(str2, i4, 1, ExifInterface.LONGITUDE_EAST, "I") && !contains(str2, i4, 3, "RGY", "OGY")) {
                    doubleMetaphoneResult2.append('K', 'J');
                    return i2 + 2;
                }
            }
            if (contains(str2, i3, 1, ExifInterface.LONGITUDE_EAST, "I", C16471q.f49113b) || contains(str2, i2 - 1, 4, "AGGI", "OGGI")) {
                if (contains(str2, 0, 4, "VAN ", "VON ") || contains(str2, 0, 3, "SCH") || contains(str2, i3, 2, "ET")) {
                    doubleMetaphoneResult2.append('K');
                    return i2 + 2;
                }
                if (contains(str2, i3, 3, "IER")) {
                    doubleMetaphoneResult2.append('J');
                } else {
                    doubleMetaphoneResult2.append('J', 'K');
                }
                return i2 + 2;
            } else if (charAt(str2, i3) == 'G') {
                int i5 = i2 + 2;
                doubleMetaphoneResult2.append('K');
                return i5;
            } else {
                doubleMetaphoneResult2.append('K');
                return i3;
            }
        } else {
            doubleMetaphoneResult2.append('K', 'J');
        }
        return i2 + 2;
    }

    private int handleGH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i > 0 && !isVowel(charAt(str, i - 1))) {
            doubleMetaphoneResult.append('K');
        } else if (i == 0) {
            int i2 = i + 2;
            if (charAt(str, i2) == 'I') {
                doubleMetaphoneResult.append('J');
                return i2;
            }
            doubleMetaphoneResult.append('K');
            return i2;
        } else if ((i <= 1 || !contains(str, i - 2, 1, "B", "H", "D")) && ((i <= 2 || !contains(str, i - 3, 1, "B", "H", "D")) && (i <= 3 || !contains(str, i - 4, 1, "B", "H")))) {
            if (i > 2 && charAt(str, i - 1) == 'U' && contains(str, i - 3, 1, "C", "G", "L", "R", "T")) {
                doubleMetaphoneResult.append('F');
            } else if (i > 0 && charAt(str, i - 1) != 'I') {
                doubleMetaphoneResult.append('K');
            }
        }
        return i + 2;
    }

    private int handleH(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if ((i != 0 && !isVowel(charAt(str, i - 1))) || !isVowel(charAt(str, i + 1))) {
            return i + 1;
        }
        doubleMetaphoneResult.append('H');
        return i + 2;
    }

    private int handleJ(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        if (contains(str, i, 4, "JOSE") || contains(str, 0, 4, "SAN ")) {
            if ((i == 0 && charAt(str, i + 4) == ' ') || str.length() == 4 || contains(str, 0, 4, "SAN ")) {
                doubleMetaphoneResult.append('H');
            } else {
                doubleMetaphoneResult.append('J', 'H');
            }
            return i + 1;
        }
        if (i != 0 || contains(str, i, 4, "JOSE")) {
            int i2 = i - 1;
            if (isVowel(charAt(str, i2)) && !z) {
                int i3 = i + 1;
                if (charAt(str, i3) == 'A' || charAt(str, i3) == 'O') {
                    doubleMetaphoneResult.append('J', 'H');
                }
            }
            if (i == str.length() - 1) {
                doubleMetaphoneResult.append('J', ' ');
            } else if (!contains(str, i + 1, 1, L_T_K_S_N_M_B_Z) && !contains(str, i2, 1, ExifInterface.LATITUDE_SOUTH, "K", "L")) {
                doubleMetaphoneResult.append('J');
            }
        } else {
            doubleMetaphoneResult.append('J', 'A');
        }
        int i4 = i + 1;
        if (charAt(str, i4) == 'J') {
            return i + 2;
        }
        return i4;
    }

    private int handleL(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'L') {
            if (conditionL0(str, i)) {
                doubleMetaphoneResult.appendPrimary((char) Matrix.MATRIX_TYPE_RANDOM_LT);
            } else {
                doubleMetaphoneResult.append((char) Matrix.MATRIX_TYPE_RANDOM_LT);
            }
            return i + 2;
        }
        doubleMetaphoneResult.append((char) Matrix.MATRIX_TYPE_RANDOM_LT);
        return i2;
    }

    private int handleP(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'H') {
            doubleMetaphoneResult.append('F');
            return i + 2;
        }
        doubleMetaphoneResult.append('P');
        if (contains(str, i2, 1, "P", "B")) {
            i2 = i + 2;
        }
        return i2;
    }

    private int handleR(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        if (i != str.length() - 1 || z || !contains(str, i - 2, 2, GlobalCountryCode.IRELAND) || contains(str, i - 4, 2, "ME", "MA")) {
            doubleMetaphoneResult.append((char) Matrix.MATRIX_TYPE_RANDOM_REGULAR);
        } else {
            doubleMetaphoneResult.appendAlternate((char) Matrix.MATRIX_TYPE_RANDOM_REGULAR);
        }
        int i2 = i + 1;
        return charAt(str, i2) == 'R' ? i + 2 : i2;
    }

    private int handleS(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        if (!contains(str, i - 1, 3, "ISL", "YSL")) {
            if (i != 0 || !contains(str, i, 5, "SUGAR")) {
                if (contains(str, i, 2, "SH")) {
                    if (contains(str, i + 1, 4, "HEIM", "HOEK", "HOLM", "HOLZ")) {
                        doubleMetaphoneResult.append('S');
                    } else {
                        doubleMetaphoneResult.append('X');
                    }
                } else if (contains(str, i, 3, "SIO", "SIA") || contains(str, i, 4, "SIAN")) {
                    if (z) {
                        doubleMetaphoneResult.append('S');
                    } else {
                        doubleMetaphoneResult.append('S', 'X');
                    }
                    return i + 3;
                } else {
                    if (i != 0 || !contains(str, i + 1, 1, "M", "N", "L", ExifInterface.LONGITUDE_WEST)) {
                        int i2 = i + 1;
                        if (!contains(str, i2, 1, "Z")) {
                            if (contains(str, i, 2, "SC")) {
                                return handleSC(str, doubleMetaphoneResult, i);
                            }
                            if (i != str.length() - 1 || !contains(str, i - 2, 2, "AI", "OI")) {
                                doubleMetaphoneResult.append('S');
                            } else {
                                doubleMetaphoneResult.appendAlternate('S');
                            }
                            if (!contains(str, i2, 1, ExifInterface.LATITUDE_SOUTH, "Z")) {
                                return i2;
                            }
                        }
                    }
                    doubleMetaphoneResult.append('S', 'X');
                    int i3 = i + 1;
                    if (!contains(str, i3, 1, "Z")) {
                        return i3;
                    }
                }
                return i + 2;
            }
            doubleMetaphoneResult.append('X', 'S');
        }
        return i + 1;
    }

    private int handleSC(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = i + 2;
        if (charAt(str, i2) == 'H') {
            int i3 = i + 3;
            if (contains(str, i3, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (contains(str, i3, 2, "ER", "EN")) {
                    doubleMetaphoneResult.append(C16471q.f49112a, GlobalCountryCode.SLOVAKIA);
                } else {
                    doubleMetaphoneResult.append(GlobalCountryCode.SLOVAKIA);
                }
            } else if (i != 0 || isVowel(charAt(str, 3)) || charAt(str, 3) == 'W') {
                doubleMetaphoneResult.append('X');
            } else {
                doubleMetaphoneResult.append('X', 'S');
            }
        } else if (contains(str, i2, 1, "I", ExifInterface.LONGITUDE_EAST, C16471q.f49113b)) {
            doubleMetaphoneResult.append('S');
        } else {
            doubleMetaphoneResult.append(GlobalCountryCode.SLOVAKIA);
        }
        return i + 3;
    }

    private int handleT(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (contains(str, i, 4, "TION")) {
            doubleMetaphoneResult.append('X');
        } else if (contains(str, i, 3, "TIA", "TCH")) {
            doubleMetaphoneResult.append('X');
        } else if (contains(str, i, 2, "TH") || contains(str, i, 3, "TTH")) {
            int i2 = i + 2;
            if (contains(str, i2, 2, "OM", "AM") || contains(str, 0, 4, "VAN ", "VON ") || contains(str, 0, 3, "SCH")) {
                doubleMetaphoneResult.append('T');
                return i2;
            }
            doubleMetaphoneResult.append('0', 'T');
            return i2;
        } else {
            doubleMetaphoneResult.append('T');
            int i3 = i + 1;
            return contains(str, i3, 1, "T", "D") ? i + 2 : i3;
        }
        return i + 3;
    }

    private int handleW(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        int i2 = 2;
        if (contains(str, i, 2, "WR")) {
            doubleMetaphoneResult.append((char) Matrix.MATRIX_TYPE_RANDOM_REGULAR);
        } else {
            if (i == 0) {
                int i3 = i + 1;
                if (isVowel(charAt(str, i3)) || contains(str, i, 2, "WH")) {
                    if (isVowel(charAt(str, i3))) {
                        doubleMetaphoneResult.append('A', 'F');
                    } else {
                        doubleMetaphoneResult.append('A');
                    }
                    return i3;
                }
            }
            if ((i != str.length() - 1 || !isVowel(charAt(str, i - 1))) && !contains(str, i - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") && !contains(str, 0, 3, "SCH")) {
                i2 = 4;
                if (contains(str, i, 4, "WICZ", "WITZ")) {
                    doubleMetaphoneResult.append("TS", "FX");
                }
            } else {
                doubleMetaphoneResult.appendAlternate('F');
            }
            return i + 1;
        }
        return i + i2;
    }

    private int handleX(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i) {
        if (i == 0) {
            doubleMetaphoneResult.append('S');
            return i + 1;
        }
        if (i != str.length() - 1 || (!contains(str, i - 3, 3, "IAU", "EAU") && !contains(str, i - 2, 2, "AU", "OU"))) {
            doubleMetaphoneResult.append("KS");
        }
        int i2 = i + 1;
        return contains(str, i2, 1, "C", C16471q.f49112a) ? i + 2 : i2;
    }

    private int handleZ(String str, DoubleMetaphoneResult doubleMetaphoneResult, int i, boolean z) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'H') {
            doubleMetaphoneResult.append('J');
            return i + 2;
        }
        if (contains(str, i2, 2, "ZO", "ZI", HistoryRecordFragment.COUNTRY_CODE_ZA) || (z && i > 0 && charAt(str, i - 1) != 'T')) {
            doubleMetaphoneResult.append(ExifInterface.LATITUDE_SOUTH, "TS");
        } else {
            doubleMetaphoneResult.append('S');
        }
        if (charAt(str, i2) == 'Z') {
            i2 = i + 2;
        }
        return i2;
    }

    private boolean conditionC0(String str, int i) {
        if (contains(str, i, 4, "CHIA")) {
            return true;
        }
        if (i <= 1) {
            return false;
        }
        int i2 = i - 2;
        if (isVowel(charAt(str, i2)) || !contains(str, i - 1, 3, "ACH")) {
            return false;
        }
        char charAt = charAt(str, i + 2);
        return !(charAt == 'I' || charAt == 'E') || contains(str, i2, 6, "BACHER", "MACHER");
    }

    private boolean conditionCH0(String str, int i) {
        if (i != 0) {
            return false;
        }
        int i2 = i + 1;
        return (contains(str, i2, 5, "HARAC", "HARIS") || contains(str, i2, 3, "HOR", "HYM", "HIA", "HEM")) && !contains(str, 0, 5, "CHORE");
    }

    private boolean conditionCH1(String str, int i) {
        if (!contains(str, 0, 4, "VAN ", "VON ") && !contains(str, 0, 3, "SCH") && !contains(str, i - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) {
            int i2 = i + 2;
            return contains(str, i2, 1, "T", ExifInterface.LATITUDE_SOUTH) || ((contains(str, i + -1, 1, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O", "U", ExifInterface.LONGITUDE_EAST) || i == 0) && (contains(str, i2, 1, L_R_N_M_B_H_F_V_W_SPACE) || i + 1 == str.length() - 1));
        }
    }

    private boolean conditionL0(String str, int i) {
        if (i == str.length() - 3 && contains(str, i - 1, 4, "ILLO", "ILLA", "ALLE")) {
            return true;
        }
        if ((contains(str, str.length() - 2, 2, "AS", "OS") || contains(str, str.length() - 1, 1, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O")) && contains(str, i - 1, 4, "ALLE")) {
            return true;
        }
        return false;
    }

    private boolean conditionM0(String str, int i) {
        int i2 = i + 1;
        if (charAt(str, i2) == 'M') {
            return true;
        }
        if (!contains(str, i - 1, 3, "UMB")) {
            return false;
        }
        if (i2 == str.length() - 1 || contains(str, i + 2, 2, "ER")) {
            return true;
        }
        return false;
    }

    private boolean isSlavoGermanic(String str) {
        return str.indexOf(87) > -1 || str.indexOf(75) > -1 || str.indexOf(GlobalCountryCode.CZECH_REPUBLIC) > -1 || str.indexOf("WITZ") > -1;
    }

    private boolean isVowel(char c) {
        return VOWELS.indexOf(c) != -1;
    }

    private boolean isSilentStart(String str) {
        for (String startsWith : SILENT_START) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private String cleanInput(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim.toUpperCase(Locale.ENGLISH);
    }

    /* access modifiers changed from: protected */
    public char charAt(String str, int i) {
        if (i < 0 || i >= str.length()) {
            return 0;
        }
        return str.charAt(i);
    }

    protected static boolean contains(String str, int i, int i2, String... strArr) {
        int i3;
        if (i < 0 || (i3 = i2 + i) > str.length()) {
            return false;
        }
        String substring = str.substring(i, i3);
        for (String equals : strArr) {
            if (substring.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public class DoubleMetaphoneResult {
        private final StringBuilder alternate;
        private final int maxLength;
        private final StringBuilder primary;

        public DoubleMetaphoneResult(int i) {
            this.primary = new StringBuilder(DoubleMetaphone.this.getMaxCodeLen());
            this.alternate = new StringBuilder(DoubleMetaphone.this.getMaxCodeLen());
            this.maxLength = i;
        }

        public void append(char c) {
            appendPrimary(c);
            appendAlternate(c);
        }

        public void append(char c, char c2) {
            appendPrimary(c);
            appendAlternate(c2);
        }

        public void appendPrimary(char c) {
            if (this.primary.length() < this.maxLength) {
                this.primary.append(c);
            }
        }

        public void appendAlternate(char c) {
            if (this.alternate.length() < this.maxLength) {
                this.alternate.append(c);
            }
        }

        public void append(String str) {
            appendPrimary(str);
            appendAlternate(str);
        }

        public void append(String str, String str2) {
            appendPrimary(str);
            appendAlternate(str2);
        }

        public void appendPrimary(String str) {
            int length = this.maxLength - this.primary.length();
            if (str.length() <= length) {
                this.primary.append(str);
            } else {
                this.primary.append(str.substring(0, length));
            }
        }

        public void appendAlternate(String str) {
            int length = this.maxLength - this.alternate.length();
            if (str.length() <= length) {
                this.alternate.append(str);
            } else {
                this.alternate.append(str.substring(0, length));
            }
        }

        public String getPrimary() {
            return this.primary.toString();
        }

        public String getAlternate() {
            return this.alternate.toString();
        }

        public boolean isComplete() {
            return this.primary.length() >= this.maxLength && this.alternate.length() >= this.maxLength;
        }
    }
}
