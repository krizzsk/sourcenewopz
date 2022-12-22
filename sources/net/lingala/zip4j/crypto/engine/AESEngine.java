package net.lingala.zip4j.crypto.engine;

import com.google.common.base.Ascii;
import java.lang.reflect.Array;
import net.lingala.zip4j.exception.ZipException;
import okio.Utf8;
import org.bouncycastle.crypto.signers.PSSSigner;

public class AESEngine {

    /* renamed from: g */
    private static final byte[] f4814g = {99, 124, 119, 123, -14, 107, 111, -59, 48, 1, 103, 43, -2, -41, -85, 118, -54, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, -64, -73, -3, -109, 38, 54, Utf8.REPLACEMENT_BYTE, -9, -52, 52, -91, -27, -15, 113, -40, 49, Ascii.NAK, 4, -57, 35, -61, Ascii.CAN, -106, 5, -102, 7, Ascii.DC2, Byte.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, Ascii.SUB, Ascii.ESC, 110, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, 74, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Byte.MAX_VALUE, 80, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, 16, -1, -13, -46, -51, Ascii.f53586FF, 19, -20, 95, -105, 68, Ascii.ETB, -60, -89, 126, 61, 100, 93, Ascii.f53585EM, 115, 96, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, Ascii.DC4, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, 120, 37, 46, Ascii.f53587FS, -90, -76, -58, -24, -35, 116, Ascii.f53596US, 75, -67, -117, -118, 112, 62, -75, 102, 72, 3, -10, Ascii.f53594SO, 97, 53, 87, -71, -122, -63, Ascii.f53588GS, -98, -31, -8, -104, 17, 105, -39, -114, -108, -101, Ascii.f53592RS, -121, -23, -50, 85, 40, -33, -116, -95, -119, Ascii.f53584CR, -65, -26, 66, 104, 65, -103, 45, Ascii.f53593SI, -80, 84, -69, Ascii.SYN};

    /* renamed from: h */
    private static final int[] f4815h = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, 239, 197, 145};

    /* renamed from: i */
    private static final int[] f4816i = {-1520213050, -2072216328, -1720223762, -1921287178, 234025727, -1117033514, -1318096930, 1422247313, 1345335392, 50397442, -1452841010, 2099981142, 436141799, 1658312629, -424957107, -1703512340, 1170918031, -1652391393, 1086966153, -2021818886, 368769775, -346465870, -918075506, 200339707, -324162239, 1742001331, -39673249, -357585083, -1080255453, -140204973, -1770884380, 1539358875, -1028147339, 486407649, -1366060227, 1780885068, 1513502316, 1094664062, 49805301, 1338821763, 1546925160, -190470831, 887481809, 150073849, -1821281822, 1943591083, 1395732834, 1058346282, 201589768, 1388824469, 1696801606, 1589887901, 672667696, -1583966665, 251987210, -1248159185, 151455502, 907153956, -1686077413, 1038279391, 652995533, 1764173646, -843926913, -1619692054, 453576978, -1635548387, 1949051992, 773462580, 756751158, -1301385508, -296068428, -73359269, -162377052, 1295727478, 1641469623, -827083907, 2066295122, 1055122397, 1898917726, -1752923117, -179088474, 1758581177, 0, 753790401, 1612718144, 536673507, -927878791, -312779850, -1100322092, 1187761037, -641810841, 1262041458, -565556588, -733197160, -396863312, 1255133061, 1808847035, 720367557, -441800113, 385612781, -985447546, -682799718, 1429418854, -1803188975, -817543798, 284817897, 100794884, -2122350594, -263171936, 1144798328, -1163944155, -475486133, -212774494, -22830243, -1069531008, -1970303227, -1382903233, -1130521311, 1211644016, 83228145, -541279133, -1044990345, 1977277103, 1663115586, 806359072, 452984805, 250868733, 1842533055, 1288555905, 336333848, 890442534, 804056259, -513843266, -1567123659, -867941240, 957814574, 1472513171, -223893675, -2105639172, 1195195770, -1402706744, -413311558, 723065138, -1787595802, -1604296512, -1736343271, -783331426, 2145180835, 1713513028, 2116692564, -1416589253, -2088204277, -901364084, 703524551, -742868885, 1007948840, 2044649127, -497131844, 487262998, 1994120109, 1004593371, 1446130276, 1312438900, 503974420, -615954030, 168166924, 1814307912, -463709000, 1573044895, 1859376061, -273896381, -1503501628, -1466855111, -1533700815, 937747667, -1954973198, 854058965, 1137232011, 1496790894, -1217565222, -1936880383, 1691735473, -766620004, -525751991, -1267962664, -95005012, 133494003, 636152527, -1352309302, -1904575756, -374428089, 403179536, -709182865, -2005370640, 1864705354, 1915629148, 605822008, -240736681, -944458637, 1371981463, 602466507, 2094914977, -1670089496, 555687742, -582268010, -591544991, -2037675251, -2054518257, -1871679264, 1111375484, -994724495, -1436129588, -666351472, 84083462, 32962295, 302911004, -1553899070, 1597322602, -111716434, -793134743, -1853454825, 1489093017, 656219450, -1180787161, 954327513, 335083755, -1281845205, 856756514, -1150719534, 1893325225, -1987146233, -1483434957, -1231316179, 572399164, -1836611819, 552200649, 1238290055, -11184726, 2015897680, 2061492133, -1886614525, -123625127, -2138470135, 386731290, -624967835, 837215959, -968736124, -1201116976, -1019133566, -1332111063, 1999449434, 286199582, -877612933, -61582168, -692339859, 974525996};

    /* renamed from: a */
    private int f4817a;

    /* renamed from: b */
    private int[][] f4818b = null;

    /* renamed from: c */
    private int f4819c;

    /* renamed from: d */
    private int f4820d;

    /* renamed from: e */
    private int f4821e;

    /* renamed from: f */
    private int f4822f;

    /* renamed from: a */
    private int m3068a(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    public AESEngine(byte[] bArr) throws ZipException {
        m3069a(bArr);
    }

    /* renamed from: a */
    private void m3069a(byte[] bArr) throws ZipException {
        this.f4818b = m3073b(bArr);
    }

    /* renamed from: b */
    private int[][] m3073b(byte[] bArr) throws ZipException {
        int length = bArr.length / 4;
        if ((length == 4 || length == 6 || length == 8) && length * 4 == bArr.length) {
            int i = length + 6;
            this.f4817a = i;
            int[] iArr = new int[2];
            iArr[1] = 4;
            int i2 = 0;
            iArr[0] = i + 1;
            int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
            int i3 = 0;
            while (i2 < bArr.length) {
                iArr2[i3 >> 2][i3 & 3] = (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | (bArr[i2 + 3] << Ascii.CAN);
                i2 += 4;
                i3++;
            }
            int i4 = (this.f4817a + 1) << 2;
            for (int i5 = length; i5 < i4; i5++) {
                int i6 = i5 - 1;
                int i7 = iArr2[i6 >> 2][i6 & 3];
                int i8 = i5 % length;
                if (i8 == 0) {
                    i7 = m3067a(m3068a(i7, 8)) ^ f4815h[(i5 / length) - 1];
                } else if (length > 6 && i8 == 4) {
                    i7 = m3067a(i7);
                }
                int i9 = i5 - length;
                iArr2[i5 >> 2][i5 & 3] = i7 ^ iArr2[i9 >> 2][i9 & 3];
            }
            return iArr2;
        }
        throw new ZipException("invalid key length (not 128/192/256)");
    }

    public int processBlock(byte[] bArr, byte[] bArr2) throws ZipException {
        return processBlock(bArr, 0, bArr2, 0);
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws ZipException {
        if (this.f4818b == null) {
            throw new ZipException("AES engine not initialised");
        } else if (i + 16 > bArr.length) {
            throw new ZipException("input buffer too short");
        } else if (i2 + 16 <= bArr2.length) {
            m3070a(bArr, i);
            m3071a(this.f4818b);
            m3072b(bArr2, i2);
            return 16;
        } else {
            throw new ZipException("output buffer too short");
        }
    }

    /* renamed from: a */
    private void m3070a(byte[] bArr, int i) {
        int i2 = i + 1;
        byte b = bArr[i] & 255;
        this.f4819c = b;
        int i3 = i2 + 1;
        byte b2 = b | ((bArr[i2] & 255) << 8);
        this.f4819c = b2;
        int i4 = i3 + 1;
        byte b3 = b2 | ((bArr[i3] & 255) << 16);
        this.f4819c = b3;
        int i5 = i4 + 1;
        this.f4819c = b3 | (bArr[i4] << Ascii.CAN);
        int i6 = i5 + 1;
        byte b4 = bArr[i5] & 255;
        this.f4820d = b4;
        int i7 = i6 + 1;
        byte b5 = ((bArr[i6] & 255) << 8) | b4;
        this.f4820d = b5;
        int i8 = i7 + 1;
        byte b6 = b5 | ((bArr[i7] & 255) << 16);
        this.f4820d = b6;
        int i9 = i8 + 1;
        this.f4820d = b6 | (bArr[i8] << Ascii.CAN);
        int i10 = i9 + 1;
        byte b7 = bArr[i9] & 255;
        this.f4821e = b7;
        int i11 = i10 + 1;
        byte b8 = ((bArr[i10] & 255) << 8) | b7;
        this.f4821e = b8;
        int i12 = i11 + 1;
        byte b9 = b8 | ((bArr[i11] & 255) << 16);
        this.f4821e = b9;
        int i13 = i12 + 1;
        this.f4821e = b9 | (bArr[i12] << Ascii.CAN);
        int i14 = i13 + 1;
        byte b10 = bArr[i13] & 255;
        this.f4822f = b10;
        int i15 = i14 + 1;
        byte b11 = ((bArr[i14] & 255) << 8) | b10;
        this.f4822f = b11;
        byte b12 = b11 | ((bArr[i15] & 255) << 16);
        this.f4822f = b12;
        this.f4822f = (bArr[i15 + 1] << Ascii.CAN) | b12;
    }

    /* renamed from: b */
    private void m3072b(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = this.f4819c;
        bArr[i] = (byte) i3;
        int i4 = i2 + 1;
        bArr[i2] = (byte) (i3 >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i3 >> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i3 >> 24);
        int i7 = i6 + 1;
        int i8 = this.f4820d;
        bArr[i6] = (byte) i8;
        int i9 = i7 + 1;
        bArr[i7] = (byte) (i8 >> 8);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i8 >> 16);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i8 >> 24);
        int i12 = i11 + 1;
        int i13 = this.f4821e;
        bArr[i11] = (byte) i13;
        int i14 = i12 + 1;
        bArr[i12] = (byte) (i13 >> 8);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i13 >> 16);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (i13 >> 24);
        int i17 = i16 + 1;
        int i18 = this.f4822f;
        bArr[i16] = (byte) i18;
        int i19 = i17 + 1;
        bArr[i17] = (byte) (i18 >> 8);
        bArr[i19] = (byte) (i18 >> 16);
        bArr[i19 + 1] = (byte) (i18 >> 24);
    }

    /* renamed from: a */
    private void m3071a(int[][] iArr) {
        this.f4819c ^= iArr[0][0];
        this.f4820d ^= iArr[0][1];
        this.f4821e ^= iArr[0][2];
        this.f4822f ^= iArr[0][3];
        int i = 1;
        while (i < this.f4817a - 1) {
            int[] iArr2 = f4816i;
            int a = (((m3068a(iArr2[(this.f4820d >> 8) & 255], 24) ^ iArr2[this.f4819c & 255]) ^ m3068a(f4816i[(this.f4821e >> 16) & 255], 16)) ^ m3068a(f4816i[(this.f4822f >> 24) & 255], 8)) ^ iArr[i][0];
            int[] iArr3 = f4816i;
            int a2 = (((m3068a(iArr3[(this.f4821e >> 8) & 255], 24) ^ iArr3[this.f4820d & 255]) ^ m3068a(f4816i[(this.f4822f >> 16) & 255], 16)) ^ m3068a(f4816i[(this.f4819c >> 24) & 255], 8)) ^ iArr[i][1];
            int[] iArr4 = f4816i;
            int a3 = (((m3068a(iArr4[(this.f4822f >> 8) & 255], 24) ^ iArr4[this.f4821e & 255]) ^ m3068a(f4816i[(this.f4819c >> 16) & 255], 16)) ^ m3068a(f4816i[(this.f4820d >> 24) & 255], 8)) ^ iArr[i][2];
            int[] iArr5 = f4816i;
            int i2 = i + 1;
            int a4 = iArr[i][3] ^ (((m3068a(iArr5[(this.f4819c >> 8) & 255], 24) ^ iArr5[this.f4822f & 255]) ^ m3068a(f4816i[(this.f4820d >> 16) & 255], 16)) ^ m3068a(f4816i[(this.f4821e >> 24) & 255], 8));
            int[] iArr6 = f4816i;
            this.f4819c = (((m3068a(iArr6[(a2 >> 8) & 255], 24) ^ iArr6[a & 255]) ^ m3068a(f4816i[(a3 >> 16) & 255], 16)) ^ m3068a(f4816i[(a4 >> 24) & 255], 8)) ^ iArr[i2][0];
            int[] iArr7 = f4816i;
            this.f4820d = (((m3068a(iArr7[(a3 >> 8) & 255], 24) ^ iArr7[a2 & 255]) ^ m3068a(f4816i[(a4 >> 16) & 255], 16)) ^ m3068a(f4816i[(a >> 24) & 255], 8)) ^ iArr[i2][1];
            int[] iArr8 = f4816i;
            this.f4821e = (((m3068a(iArr8[(a4 >> 8) & 255], 24) ^ iArr8[a3 & 255]) ^ m3068a(f4816i[(a >> 16) & 255], 16)) ^ m3068a(f4816i[(a2 >> 24) & 255], 8)) ^ iArr[i2][2];
            int[] iArr9 = f4816i;
            this.f4822f = (((iArr9[a4 & 255] ^ m3068a(iArr9[(a >> 8) & 255], 24)) ^ m3068a(f4816i[(a2 >> 16) & 255], 16)) ^ m3068a(f4816i[(a3 >> 24) & 255], 8)) ^ iArr[i2][3];
            i = i2 + 1;
        }
        int[] iArr10 = f4816i;
        int a5 = (((m3068a(iArr10[(this.f4820d >> 8) & 255], 24) ^ iArr10[this.f4819c & 255]) ^ m3068a(f4816i[(this.f4821e >> 16) & 255], 16)) ^ m3068a(f4816i[(this.f4822f >> 24) & 255], 8)) ^ iArr[i][0];
        int[] iArr11 = f4816i;
        int a6 = (((m3068a(iArr11[(this.f4821e >> 8) & 255], 24) ^ iArr11[this.f4820d & 255]) ^ m3068a(f4816i[(this.f4822f >> 16) & 255], 16)) ^ m3068a(f4816i[(this.f4819c >> 24) & 255], 8)) ^ iArr[i][1];
        int[] iArr12 = f4816i;
        int a7 = (((m3068a(iArr12[(this.f4822f >> 8) & 255], 24) ^ iArr12[this.f4821e & 255]) ^ m3068a(f4816i[(this.f4819c >> 16) & 255], 16)) ^ m3068a(f4816i[(this.f4820d >> 24) & 255], 8)) ^ iArr[i][2];
        int[] iArr13 = f4816i;
        int i3 = i + 1;
        int a8 = iArr[i][3] ^ (((m3068a(iArr13[(this.f4819c >> 8) & 255], 24) ^ iArr13[this.f4822f & 255]) ^ m3068a(f4816i[(this.f4820d >> 16) & 255], 16)) ^ m3068a(f4816i[(this.f4821e >> 24) & 255], 8));
        byte[] bArr = f4814g;
        this.f4819c = iArr[i3][0] ^ ((((bArr[a5 & 255] & 255) ^ ((bArr[(a6 >> 8) & 255] & 255) << 8)) ^ ((bArr[(a7 >> 16) & 255] & 255) << 16)) ^ (bArr[(a8 >> 24) & 255] << Ascii.CAN));
        this.f4820d = ((((bArr[a6 & 255] & 255) ^ ((bArr[(a7 >> 8) & 255] & 255) << 8)) ^ ((bArr[(a8 >> 16) & 255] & 255) << 16)) ^ (bArr[(a5 >> 24) & 255] << Ascii.CAN)) ^ iArr[i3][1];
        this.f4821e = ((((bArr[a7 & 255] & 255) ^ ((bArr[(a8 >> 8) & 255] & 255) << 8)) ^ ((bArr[(a5 >> 16) & 255] & 255) << 16)) ^ (bArr[(a6 >> 24) & 255] << Ascii.CAN)) ^ iArr[i3][2];
        this.f4822f = ((((bArr[a8 & 255] & 255) ^ ((bArr[(a5 >> 8) & 255] & 255) << 8)) ^ ((bArr[(a6 >> 16) & 255] & 255) << 16)) ^ (bArr[(a7 >> 24) & 255] << Ascii.CAN)) ^ iArr[i3][3];
    }

    /* renamed from: a */
    private int m3067a(int i) {
        byte[] bArr = f4814g;
        return (bArr[(i >> 24) & 255] << Ascii.CAN) | (bArr[i & 255] & 255) | ((bArr[(i >> 8) & 255] & 255) << 8) | ((bArr[(i >> 16) & 255] & 255) << 16);
    }
}
