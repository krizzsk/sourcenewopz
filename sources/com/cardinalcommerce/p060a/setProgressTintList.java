package com.cardinalcommerce.p060a;

import com.didichuxing.foundation.net.CertificateTransporter;

/* renamed from: com.cardinalcommerce.a.setProgressTintList */
public final class setProgressTintList {

    /* renamed from: a */
    private static int f2956a = 0;

    /* renamed from: b */
    private static int f2957b = 1;
    public setSecondaryProgress cca_continue;
    public String configure;
    public setMax init;

    setProgressTintList() {
    }

    /* renamed from: b */
    private static setTransformationMethod m2077b(setBaselineAligned setbaselinealigned) {
        setTransformationMethod settransformationmethod = new setTransformationMethod();
        if (!(setMinLines.init(setbaselinealigned.configure))) {
            int i = f2956a;
            int i2 = i & 27;
            int i3 = i | 27;
            int i4 = (i2 & i3) + (i3 | i2);
            f2957b = i4 % 128;
            if ((i4 % 2 == 0 ? 'G' : 'a') != 'G') {
                settransformationmethod.Cardinal = false;
            } else {
                settransformationmethod.Cardinal = true;
            }
            settransformationmethod.getInstance("ThreeDSServerTransID");
            int i5 = f2956a;
            int i6 = ((i5 & 90) + (i5 | 90)) - 1;
            f2957b = i6 % 128;
            int i7 = i6 % 2;
        }
        if (!(setMinLines.init(setbaselinealigned.getEnvironment))) {
            int i8 = f2956a;
            int i9 = i8 & 3;
            int i10 = (i8 ^ 3) | i9;
            int i11 = (i9 ^ i10) + ((i10 & i9) << 1);
            f2957b = i11 % 128;
            int i12 = i11 % 2;
            settransformationmethod.Cardinal = false;
            settransformationmethod.getInstance("AcsCounterAtoS");
            int i13 = f2956a + 72;
            int i14 = (i13 & -1) + (i13 | -1);
            f2957b = i14 % 128;
            int i15 = i14 % 2;
        }
        if ((!setMinLines.init(setbaselinealigned.cca_continue) ? 28 : ' ') == 28) {
            int i16 = f2957b;
            int i17 = (i16 ^ 41) + ((i16 & 41) << 1);
            f2956a = i17 % 128;
            int i18 = i17 % 2;
            settransformationmethod.Cardinal = false;
            settransformationmethod.getInstance("AcsTransID");
            int i19 = f2956a;
            int i20 = i19 & 29;
            int i21 = -(-((i19 ^ 29) | i20));
            int i22 = ((i20 | i21) << 1) - (i21 ^ i20);
            f2957b = i22 % 128;
            int i23 = i22 % 2;
        }
        if ((!setMinLines.init(setbaselinealigned.getWarnings) ? '*' : 31) != 31) {
            int i24 = (f2957b + 34) - 1;
            f2956a = i24 % 128;
            int i25 = i24 % 2;
            settransformationmethod.Cardinal = false;
            settransformationmethod.getInstance("ChallengeCompletionInd");
            int i26 = f2957b;
            int i27 = i26 & 69;
            int i28 = -(-(i26 | 69));
            int i29 = (i27 ^ i28) + ((i28 & i27) << 1);
            f2956a = i29 % 128;
            int i30 = i29 % 2;
        } else {
            if ((setbaselinealigned.getWarnings.equals(C16471q.f49113b) ? 6 : 'W') == 6) {
                int i31 = (f2956a + 123) - 1;
                int i32 = (i31 ^ -1) + ((i31 & -1) << 1);
                f2957b = i32 % 128;
                int i33 = i32 % 2;
                if ((!setMinLines.cca_continue(setbaselinealigned.setChallengeTimeout, 1) ? 'P' : '6') == 'P') {
                    int i34 = f2957b;
                    int i35 = i34 & 113;
                    int i36 = i35 + ((i34 ^ 113) | i35);
                    f2956a = i36 % 128;
                    if (i36 % 2 != 0) {
                        settransformationmethod.Cardinal = true;
                    } else {
                        settransformationmethod.Cardinal = false;
                    }
                    settransformationmethod.getInstance("TransStatus");
                    int i37 = f2957b;
                    int i38 = i37 & 109;
                    int i39 = ((i37 | 109) & (~i38)) + (i38 << 1);
                    f2956a = i39 % 128;
                    int i40 = i39 % 2;
                }
            }
        }
        if ((!setMinLines.init(setbaselinealigned.CardinalConfigurationParameters) ? (char) 18 : 19) != 19) {
            int i41 = f2956a;
            int i42 = ((i41 ^ 105) | (i41 & 105)) << 1;
            int i43 = -(((~i41) & 105) | (i41 & -106));
            int i44 = ((i42 | i43) << 1) - (i43 ^ i42);
            f2957b = i44 % 128;
            if ((i44 % 2 == 0 ? '@' : 4) != 4) {
                settransformationmethod.Cardinal = true;
            } else {
                settransformationmethod.Cardinal = false;
            }
            settransformationmethod.getInstance("MessageVersion");
        }
        if (!setMinLines.init(setbaselinealigned.setRequestTimeout)) {
            int i45 = f2956a;
            int i46 = (i45 ^ 111) + ((i45 & 111) << 1);
            f2957b = i46 % 128;
            int i47 = i46 % 2;
            settransformationmethod.Cardinal = false;
            settransformationmethod.getInstance("SdkTransID");
            int i48 = f2957b;
            int i49 = ((i48 & 6) + (i48 | 6)) - 1;
            f2956a = i49 % 128;
            int i50 = i49 % 2;
        }
        int i51 = f2956a;
        int i52 = (i51 ^ 17) + ((i51 & 17) << 1);
        f2957b = i52 % 128;
        int i53 = i52 % 2;
        return settransformationmethod;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01b5, code lost:
        if (r1 == 0) goto L_0x0420;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01bb, code lost:
        if (r1 == 1) goto L_0x03a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01bd, code lost:
        if (r1 == 2) goto L_0x0310;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01bf, code lost:
        if (r1 == 3) goto L_0x02a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01c1, code lost:
        if (r1 == 4) goto L_0x01e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01c3, code lost:
        r0 = m2077b(r16);
        r1 = f2956a;
        r2 = r1 & 83;
        r2 = (r2 - (~((r1 ^ 83) | r2))) - 1;
        f2957b = r2 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01d5, code lost:
        if ((r2 % 2) != 0) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01d7, code lost:
        r1 = 'N';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01da, code lost:
        r1 = 20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01dc, code lost:
        if (r1 == 'N') goto L_0x01df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01de, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
        r1 = r9.length;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01e0, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01e1, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01e3, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01e4, code lost:
        r1 = m2077b(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01ee, code lost:
        if (com.cardinalcommerce.p060a.setMinLines.getInstance(r0.cleanup) != false) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01f0, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01f2, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01f3, code lost:
        if (r3 == true) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01f6, code lost:
        r3 = f2957b + 39;
        f2956a = r3 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01ff, code lost:
        if ((r3 % 2) == 0) goto L_0x0203;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0201, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0203, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0204, code lost:
        if (r3 == false) goto L_0x0209;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0206, code lost:
        r1.Cardinal = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0209, code lost:
        r1.Cardinal = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x020b, code lost:
        r1.getInstance("ChallengeInfoText");
        r3 = f2957b;
        r7 = (r3 & 31) + (r3 | 31);
        f2956a = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0220, code lost:
        if (com.cardinalcommerce.p060a.setMinLines.getInstance(r0.getProxyAddress) != false) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0222, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0224, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0225, code lost:
        if (r3 == true) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0227, code lost:
        r3 = f2957b;
        r8 = ((((r3 ^ 85) | (r3 & 85)) << 1) - (~(-(((~r3) & 85) | (r3 & -86))))) - 1;
        f2956a = r8 % 128;
        r8 = r8 % 2;
        r1.Cardinal = false;
        r1.getInstance("SubmitAuthenticationLabel");
        r2 = f2956a;
        r7 = (((r2 ^ 5) | (r2 & 5)) << 1) - (((~r2) & 5) | (r2 & -6));
        f2957b = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x025e, code lost:
        if (r0.CardinalRenderType.size() > 0) goto L_0x0262;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0260, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0262, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0263, code lost:
        if (r0 == true) goto L_0x0298;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0265, code lost:
        r0 = f2957b;
        r2 = r0 | 23;
        r3 = r2 << 1;
        r0 = -((~(r0 & 23)) & r2);
        r2 = (r3 ^ r0) + ((r0 & r3) << 1);
        f2956a = r2 % 128;
        r2 = r2 % 2;
        r1.Cardinal = false;
        r1.getInstance("ChallengeSelectInfo");
        r0 = f2957b;
        r2 = ((r0 ^ 103) | (r0 & 103)) << 1;
        r0 = -(((~r0) & 103) | (r0 & -104));
        r3 = (r2 & r0) + (r0 | r2);
        f2956a = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0298, code lost:
        r0 = f2957b;
        r2 = (r0 & 27) + (r0 | 27);
        f2956a = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x02a4, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x02a5, code lost:
        r1 = m2077b(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02af, code lost:
        if (com.cardinalcommerce.p060a.setMinLines.getInstance(r0.cleanup) != false) goto L_0x02b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02b1, code lost:
        r2 = '8';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x02b4, code lost:
        r2 = 30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x02b8, code lost:
        if (r2 == 30) goto L_0x02da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x02ba, code lost:
        r2 = f2957b;
        r3 = (r2 & 66) + (r2 | 66);
        r2 = ((r3 | -1) << 1) - (r3 ^ -1);
        f2956a = r2 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x02cb, code lost:
        if ((r2 % 2) == 0) goto L_0x02cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x02cd, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x02cf, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x02d0, code lost:
        if (r2 == false) goto L_0x02d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x02d2, code lost:
        r1.Cardinal = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x02d5, code lost:
        r1.Cardinal = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x02d7, code lost:
        r1.getInstance("ChallengeInfoText");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x02e0, code lost:
        if (com.cardinalcommerce.p060a.setMinLines.init(r0.getRequestTimeout) != false) goto L_0x02e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x02e2, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x02e4, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x02e5, code lost:
        if (r0 == false) goto L_0x030f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x02e7, code lost:
        r0 = f2957b;
        r2 = r0 & 63;
        r0 = r0 | 63;
        r3 = (r2 ^ r0) + ((r0 & r2) << 1);
        f2956a = r3 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x02f7, code lost:
        if ((r3 % 2) == 0) goto L_0x02fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x02fe, code lost:
        r1.Cardinal = false;
        r1.getInstance("OobContinueLabel");
        r0 = f2957b + 103;
        f2956a = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x030f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0310, code lost:
        r1 = m2077b(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x031c, code lost:
        if (com.cardinalcommerce.p060a.setMinLines.getInstance(r0.cleanup) != false) goto L_0x0321;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x031e, code lost:
        r3 = 22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0321, code lost:
        r3 = '#';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0323, code lost:
        if (r3 == '#') goto L_0x0354;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0325, code lost:
        r3 = f2956a;
        r7 = r3 & 113;
        r3 = -(-((r3 ^ 113) | r7));
        r8 = (r7 ^ r3) + ((r3 & r7) << 1);
        f2957b = r8 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0338, code lost:
        if ((r8 % 2) != 0) goto L_0x033d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x033f, code lost:
        r1.Cardinal = false;
        r1.getInstance("ChallengeInfoText");
        r3 = f2956a;
        r7 = (((r3 ^ 64) + ((r3 & 64) << 1)) - 0) - 1;
        f2957b = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x035a, code lost:
        if (com.cardinalcommerce.p060a.setMinLines.getInstance(r0.getProxyAddress) != false) goto L_0x035e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x035c, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x035e, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x035f, code lost:
        if (r3 == true) goto L_0x0362;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0362, code lost:
        r3 = ((f2956a + 7) - 1) - 1;
        f2957b = r3 % 128;
        r3 = r3 % 2;
        r1.Cardinal = false;
        r1.getInstance("SubmitAuthenticationLabel");
        r2 = f2956a;
        r3 = r2 & 25;
        r2 = -(-((r2 ^ 25) | r3));
        r7 = (r3 & r2) + (r2 | r3);
        f2957b = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x038a, code lost:
        if (r0.CardinalRenderType.size() > 0) goto L_0x038d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x038c, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x038d, code lost:
        if (r5 == false) goto L_0x0390;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0390, code lost:
        r0 = f2957b;
        r2 = (r0 & 91) + (r0 | 91);
        f2956a = r2 % 128;
        r2 = r2 % 2;
        r1.Cardinal = false;
        r1.getInstance("ChallengeSelectInfo");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x03a2, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x03a3, code lost:
        r1 = m2077b(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x03af, code lost:
        if (com.cardinalcommerce.p060a.setMinLines.getInstance(r0.getProxyAddress) != false) goto L_0x03b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x03b1, code lost:
        r3 = 17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x03b4, code lost:
        r3 = 28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x03b6, code lost:
        if (r3 == 17) goto L_0x03b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x03b9, code lost:
        r3 = f2956a;
        r7 = ((((r3 ^ 41) | (r3 & 41)) << 1) - (~(-(((~r3) & 41) | (r3 & -42))))) - 1;
        f2957b = r7 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x03d0, code lost:
        if ((r7 % 2) != 0) goto L_0x03d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x03d2, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x03d4, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x03d5, code lost:
        if (r3 == false) goto L_0x03da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x03d7, code lost:
        r1.Cardinal = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x03da, code lost:
        r1.Cardinal = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x03dc, code lost:
        r1.getInstance("SubmitAuthenticationLabel");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x03e5, code lost:
        if (com.cardinalcommerce.p060a.setMinLines.getInstance(r0.cleanup) != false) goto L_0x03e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x03e7, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x03e9, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x03ea, code lost:
        if (r0 == true) goto L_0x0404;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x03ec, code lost:
        r0 = f2956a;
        r2 = ((r0 & 117) - (~(r0 | 117))) - 1;
        f2957b = r2 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x03fa, code lost:
        if ((r2 % 2) != 0) goto L_0x03fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x03fe, code lost:
        r1.Cardinal = false;
        r1.getInstance("ChallengeInfoText");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0404, code lost:
        r0 = f2956a + 121;
        f2957b = r0 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x040d, code lost:
        if ((r0 % 2) != 0) goto L_0x0412;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x040f, code lost:
        r0 = 'C';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0412, code lost:
        r0 = '.';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0416, code lost:
        if (r0 == '.') goto L_0x041f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:?, code lost:
        r0 = 23 / 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x041b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x041c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x041e, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x041f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0420, code lost:
        r1 = m2077b(r16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x042a, code lost:
        if (com.cardinalcommerce.p060a.setMinLines.init(r0.Cardinal) != false) goto L_0x042e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x042c, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x042e, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x0431, code lost:
        if (r0 == false) goto L_0x0459;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0433, code lost:
        r0 = f2957b;
        r3 = r0 & 61;
        r0 = (r0 ^ 61) | r3;
        r7 = (r3 & r0) + (r0 | r3);
        f2956a = r7 % 128;
        r7 = r7 % 2;
        r1.Cardinal = false;
        r1.getInstance("AcsHTML");
        r0 = f2956a;
        r3 = ((r0 & 41) - (~(-(-(r0 | 41))))) - 1;
        f2957b = r3 % 128;
        r3 = r3 % 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0459, code lost:
        r0 = f2956a;
        r3 = ((r0 | 61) << 1) - (((~r0) & 61) | (r0 & -62));
        f2957b = r3 % 128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0469, code lost:
        if ((r3 % 2) != 0) goto L_0x046e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x046b, code lost:
        r0 = 'X';
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x046e, code lost:
        r0 = kotlin.text.Typography.less;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0472, code lost:
        if (r0 == '<') goto L_0x0479;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:?, code lost:
        r2 = 61 / 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x0475, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0476, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0478, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0479, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x011a, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x017f, code lost:
        r1 = 2;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.cardinalcommerce.p060a.setTransformationMethod m2076a(com.cardinalcommerce.p060a.setBaselineAligned r16) {
        /*
            r0 = r16
            java.lang.String r1 = r0.init
            com.cardinalcommerce.a.setTransformationMethod r2 = new com.cardinalcommerce.a.setTransformationMethod
            r2.<init>()
            java.lang.String r3 = r0.getWarnings
            boolean r3 = com.cardinalcommerce.p060a.setMinLines.init(r3)
            r4 = 0
            r5 = 1
            if (r3 != 0) goto L_0x0015
            r3 = 1
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            r6 = 2
            if (r3 == 0) goto L_0x0038
            int r3 = f2956a
            r7 = r3 & 111(0x6f, float:1.56E-43)
            int r8 = ~r7
            r3 = r3 | 111(0x6f, float:1.56E-43)
            r3 = r3 & r8
            int r7 = r7 << r5
            int r7 = -r7
            int r7 = -r7
            int r7 = ~r7
            int r3 = r3 - r7
            int r3 = r3 - r5
            int r7 = r3 % 128
            f2957b = r7
            int r3 = r3 % r6
            if (r3 != 0) goto L_0x0030
            r3 = 0
            goto L_0x0031
        L_0x0030:
            r3 = 1
        L_0x0031:
            java.lang.String r7 = "ChallengeCompletionInd"
            r2.Cardinal = r4
            r2.getInstance(r7)
        L_0x0038:
            boolean r3 = r2.getInstance()
            r7 = 83
            r8 = 78
            if (r3 == 0) goto L_0x0045
            r3 = 78
            goto L_0x0047
        L_0x0045:
            r3 = 83
        L_0x0047:
            r9 = 0
            if (r3 == r8) goto L_0x006c
            int r0 = f2957b
            r1 = r0 & 43
            r0 = r0 ^ 43
            r0 = r0 | r1
            r3 = r1 ^ r0
            r0 = r0 & r1
            int r0 = r0 << r5
            int r3 = r3 + r0
            int r0 = r3 % 128
            f2956a = r0
            int r3 = r3 % r6
            if (r3 == 0) goto L_0x0060
            r0 = 78
            goto L_0x0062
        L_0x0060:
            r0 = 86
        L_0x0062:
            if (r0 == r8) goto L_0x0065
            return r2
        L_0x0065:
            super.hashCode()     // Catch:{ all -> 0x0069 }
            return r2
        L_0x0069:
            r0 = move-exception
            r1 = r0
            throw r1
        L_0x006c:
            int r3 = f2957b
            r10 = r3 & 9
            r3 = r3 ^ 9
            r3 = r3 | r10
            int r10 = r10 + r3
            int r3 = r10 % 128
            f2956a = r3
            int r10 = r10 % r6
            java.lang.String r3 = r0.getWarnings
            java.lang.String r10 = "N"
            boolean r3 = r3.equalsIgnoreCase(r10)
            r10 = 64
            if (r3 == 0) goto L_0x0088
            r3 = 42
            goto L_0x008a
        L_0x0088:
            r3 = 64
        L_0x008a:
            if (r3 == r10) goto L_0x047a
            int r3 = f2956a
            int r3 = r3 + 111
            int r11 = r3 % 128
            f2957b = r11
            int r3 = r3 % r6
            boolean r3 = com.cardinalcommerce.p060a.setMinLines.cca_continue(r1, r6)
            if (r3 != 0) goto L_0x009d
            r3 = 1
            goto L_0x009e
        L_0x009d:
            r3 = 0
        L_0x009e:
            r11 = 103(0x67, float:1.44E-43)
            if (r3 == 0) goto L_0x00b4
            int r3 = f2957b
            r12 = r3 & 103(0x67, float:1.44E-43)
            r3 = r3 | r11
            int r12 = r12 + r3
            int r3 = r12 % 128
            f2956a = r3
            int r12 = r12 % r6
            if (r12 == 0) goto L_0x00b1
            r3 = 1
            goto L_0x00b2
        L_0x00b1:
            r3 = 0
        L_0x00b2:
            r2.Cardinal = r4
        L_0x00b4:
            boolean r3 = r2.getInstance()
            if (r3 == 0) goto L_0x00bc
            r3 = 1
            goto L_0x00bd
        L_0x00bc:
            r3 = 0
        L_0x00bd:
            if (r3 == r5) goto L_0x00ce
            java.lang.String r0 = "AcsUiType"
            r2.getInstance(r0)
            int r0 = f2957b
            int r0 = r0 + 41
            int r1 = r0 % 128
            f2956a = r1
            int r0 = r0 % r6
            return r2
        L_0x00ce:
            int r2 = f2957b
            r3 = r2 & 98
            r2 = r2 | 98
            int r3 = r3 + r2
            r2 = r3 | -1
            int r2 = r2 << r5
            r12 = -1
            r3 = r3 ^ r12
            int r2 = r2 - r3
            int r3 = r2 % 128
            f2956a = r3
            int r2 = r2 % r6
            int r2 = r1.hashCode()
            r3 = 4
            r13 = 91
            r14 = 3
            r15 = 46
            switch(r2) {
                case 1537: goto L_0x0183;
                case 1538: goto L_0x015d;
                case 1539: goto L_0x0145;
                case 1540: goto L_0x0120;
                case 1541: goto L_0x00ef;
                default: goto L_0x00ed;
            }
        L_0x00ed:
            goto L_0x01b4
        L_0x00ef:
            java.lang.String r2 = "05"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00f9
            r1 = 0
            goto L_0x00fa
        L_0x00f9:
            r1 = 1
        L_0x00fa:
            if (r1 == 0) goto L_0x00fe
            goto L_0x01b4
        L_0x00fe:
            int r1 = f2957b
            r2 = r1 | 118(0x76, float:1.65E-43)
            int r2 = r2 << r5
            r1 = r1 ^ 118(0x76, float:1.65E-43)
            int r2 = r2 - r1
            r1 = r2 & -1
            r2 = r2 | r12
            int r1 = r1 + r2
            int r2 = r1 % 128
            f2956a = r2
            int r1 = r1 % r6
            if (r1 == 0) goto L_0x0114
            r1 = 12
            goto L_0x0116
        L_0x0114:
            r1 = 69
        L_0x0116:
            r2 = 69
            if (r1 == r2) goto L_0x011d
        L_0x011a:
            r1 = 1
            goto L_0x01b5
        L_0x011d:
            r1 = 0
            goto L_0x01b5
        L_0x0120:
            java.lang.String r2 = "04"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x012b
            r1 = 46
            goto L_0x012d
        L_0x012b:
            r1 = 32
        L_0x012d:
            if (r1 == r15) goto L_0x0131
            goto L_0x01b4
        L_0x0131:
            int r1 = f2957b
            r2 = r1 ^ 29
            r1 = r1 & 29
            int r1 = r1 << r5
            int r1 = -r1
            int r1 = -r1
            int r1 = ~r1
            int r2 = r2 - r1
            int r2 = r2 - r5
            int r1 = r2 % 128
            f2956a = r1
            int r2 = r2 % r6
            r1 = 3
            goto L_0x01b5
        L_0x0145:
            java.lang.String r2 = "03"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x014f
            r1 = 0
            goto L_0x0150
        L_0x014f:
            r1 = 1
        L_0x0150:
            if (r1 == 0) goto L_0x0153
            goto L_0x01b4
        L_0x0153:
            int r1 = f2957b
            int r1 = r1 + 31
            int r2 = r1 % 128
            f2956a = r2
            int r1 = r1 % r6
            goto L_0x017f
        L_0x015d:
            java.lang.String r2 = "02"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0167
            r1 = 1
            goto L_0x0168
        L_0x0167:
            r1 = 0
        L_0x0168:
            if (r1 == r5) goto L_0x016b
            goto L_0x01b4
        L_0x016b:
            int r1 = f2956a
            int r1 = r1 + 99
            int r2 = r1 % 128
            f2957b = r2
            int r1 = r1 % r6
            if (r1 != 0) goto L_0x0179
            r1 = 18
            goto L_0x017b
        L_0x0179:
            r1 = 36
        L_0x017b:
            r2 = 36
            if (r1 == r2) goto L_0x0181
        L_0x017f:
            r1 = 2
            goto L_0x01b5
        L_0x0181:
            r1 = 4
            goto L_0x01b5
        L_0x0183:
            java.lang.String r2 = "01"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x018d
            r1 = 1
            goto L_0x018e
        L_0x018d:
            r1 = 0
        L_0x018e:
            if (r1 == 0) goto L_0x01b4
            int r1 = f2956a
            int r1 = r1 + 27
            int r1 = r1 - r5
            r2 = r1 & -1
            r1 = r1 | r12
            int r2 = r2 + r1
            int r1 = r2 % 128
            f2957b = r1
            int r2 = r2 % r6
            if (r2 != 0) goto L_0x01a3
            r1 = 88
            goto L_0x01a5
        L_0x01a3:
            r1 = 91
        L_0x01a5:
            int r1 = f2956a
            r2 = r1 | 109(0x6d, float:1.53E-43)
            int r2 = r2 << r5
            r1 = r1 ^ 109(0x6d, float:1.53E-43)
            int r2 = r2 - r1
            int r1 = r2 % 128
            f2957b = r1
            int r2 = r2 % r6
            goto L_0x011a
        L_0x01b4:
            r1 = -1
        L_0x01b5:
            if (r1 == 0) goto L_0x0420
            java.lang.String r2 = "SubmitAuthenticationLabel"
            java.lang.String r15 = "ChallengeInfoText"
            if (r1 == r5) goto L_0x03a3
            if (r1 == r6) goto L_0x0310
            if (r1 == r14) goto L_0x02a5
            if (r1 == r3) goto L_0x01e4
            com.cardinalcommerce.a.setTransformationMethod r0 = m2077b(r16)
            int r1 = f2956a
            r2 = r1 & 83
            r1 = r1 ^ r7
            r1 = r1 | r2
            int r1 = ~r1
            int r2 = r2 - r1
            int r2 = r2 - r5
            int r1 = r2 % 128
            f2957b = r1
            int r2 = r2 % r6
            if (r2 != 0) goto L_0x01da
            r1 = 78
            goto L_0x01dc
        L_0x01da:
            r1 = 20
        L_0x01dc:
            if (r1 == r8) goto L_0x01df
            return r0
        L_0x01df:
            int r1 = r9.length     // Catch:{ all -> 0x01e1 }
            return r0
        L_0x01e1:
            r0 = move-exception
            r1 = r0
            throw r1
        L_0x01e4:
            com.cardinalcommerce.a.setTransformationMethod r1 = m2077b(r16)
            java.lang.String r3 = r0.cleanup
            boolean r3 = com.cardinalcommerce.p060a.setMinLines.getInstance(r3)
            if (r3 != 0) goto L_0x01f2
            r3 = 1
            goto L_0x01f3
        L_0x01f2:
            r3 = 0
        L_0x01f3:
            if (r3 == r5) goto L_0x01f6
            goto L_0x021a
        L_0x01f6:
            int r3 = f2957b
            int r3 = r3 + 39
            int r7 = r3 % 128
            f2956a = r7
            int r3 = r3 % r6
            if (r3 == 0) goto L_0x0203
            r3 = 1
            goto L_0x0204
        L_0x0203:
            r3 = 0
        L_0x0204:
            if (r3 == 0) goto L_0x0209
            r1.Cardinal = r5
            goto L_0x020b
        L_0x0209:
            r1.Cardinal = r4
        L_0x020b:
            r1.getInstance(r15)
            int r3 = f2957b
            r7 = r3 & 31
            r3 = r3 | 31
            int r7 = r7 + r3
            int r3 = r7 % 128
            f2956a = r3
            int r7 = r7 % r6
        L_0x021a:
            java.lang.String r3 = r0.getProxyAddress
            boolean r3 = com.cardinalcommerce.p060a.setMinLines.getInstance(r3)
            if (r3 != 0) goto L_0x0224
            r3 = 0
            goto L_0x0225
        L_0x0224:
            r3 = 1
        L_0x0225:
            if (r3 == r5) goto L_0x0258
            int r3 = f2957b
            r7 = 85
            r8 = r3 ^ 85
            r9 = r3 & 85
            r8 = r8 | r9
            int r8 = r8 << r5
            r9 = r3 & -86
            int r3 = ~r3
            r3 = r3 & r7
            r3 = r3 | r9
            int r3 = -r3
            int r3 = ~r3
            int r8 = r8 - r3
            int r8 = r8 - r5
            int r3 = r8 % 128
            f2956a = r3
            int r8 = r8 % r6
            r1.Cardinal = r4
            r1.getInstance(r2)
            int r2 = f2956a
            r3 = 5
            r7 = r2 ^ 5
            r8 = r2 & 5
            r7 = r7 | r8
            int r7 = r7 << r5
            r8 = r2 & -6
            int r2 = ~r2
            r2 = r2 & r3
            r2 = r2 | r8
            int r7 = r7 - r2
            int r2 = r7 % 128
            f2957b = r2
            int r7 = r7 % r6
        L_0x0258:
            java.util.ArrayList<com.cardinalcommerce.a.setCompoundDrawablesRelativeWithIntrinsicBounds> r0 = r0.CardinalRenderType
            int r0 = r0.size()
            if (r0 > 0) goto L_0x0262
            r0 = 0
            goto L_0x0263
        L_0x0262:
            r0 = 1
        L_0x0263:
            if (r0 == r5) goto L_0x0298
            int r0 = f2957b
            r2 = r0 | 23
            int r3 = r2 << 1
            r0 = r0 & 23
            int r0 = ~r0
            r0 = r0 & r2
            int r0 = -r0
            r2 = r3 ^ r0
            r0 = r0 & r3
            int r0 = r0 << r5
            int r2 = r2 + r0
            int r0 = r2 % 128
            f2956a = r0
            int r2 = r2 % r6
            r1.Cardinal = r4
            java.lang.String r0 = "ChallengeSelectInfo"
            r1.getInstance(r0)
            int r0 = f2957b
            r2 = r0 ^ 103(0x67, float:1.44E-43)
            r3 = r0 & 103(0x67, float:1.44E-43)
            r2 = r2 | r3
            int r2 = r2 << r5
            r3 = r0 & -104(0xffffffffffffff98, float:NaN)
            int r0 = ~r0
            r0 = r0 & r11
            r0 = r0 | r3
            int r0 = -r0
            r3 = r2 & r0
            r0 = r0 | r2
            int r3 = r3 + r0
            int r0 = r3 % 128
            f2956a = r0
            int r3 = r3 % r6
        L_0x0298:
            int r0 = f2957b
            r2 = r0 & 27
            r0 = r0 | 27
            int r2 = r2 + r0
            int r0 = r2 % 128
            f2956a = r0
            int r2 = r2 % r6
            return r1
        L_0x02a5:
            com.cardinalcommerce.a.setTransformationMethod r1 = m2077b(r16)
            java.lang.String r2 = r0.cleanup
            boolean r2 = com.cardinalcommerce.p060a.setMinLines.getInstance(r2)
            if (r2 != 0) goto L_0x02b4
            r2 = 56
            goto L_0x02b6
        L_0x02b4:
            r2 = 30
        L_0x02b6:
            r3 = 30
            if (r2 == r3) goto L_0x02da
            int r2 = f2957b
            r3 = r2 & 66
            r2 = r2 | 66
            int r3 = r3 + r2
            r2 = r3 | -1
            int r2 = r2 << r5
            r3 = r3 ^ r12
            int r2 = r2 - r3
            int r3 = r2 % 128
            f2956a = r3
            int r2 = r2 % r6
            if (r2 == 0) goto L_0x02cf
            r2 = 1
            goto L_0x02d0
        L_0x02cf:
            r2 = 0
        L_0x02d0:
            if (r2 == 0) goto L_0x02d5
            r1.Cardinal = r5
            goto L_0x02d7
        L_0x02d5:
            r1.Cardinal = r4
        L_0x02d7:
            r1.getInstance(r15)
        L_0x02da:
            java.lang.String r0 = r0.getRequestTimeout
            boolean r0 = com.cardinalcommerce.p060a.setMinLines.init(r0)
            if (r0 != 0) goto L_0x02e4
            r0 = 1
            goto L_0x02e5
        L_0x02e4:
            r0 = 0
        L_0x02e5:
            if (r0 == 0) goto L_0x030f
            int r0 = f2957b
            r2 = r0 & 63
            r0 = r0 | 63
            r3 = r2 ^ r0
            r0 = r0 & r2
            int r0 = r0 << r5
            int r3 = r3 + r0
            int r0 = r3 % 128
            f2956a = r0
            int r3 = r3 % r6
            if (r3 == 0) goto L_0x02fc
            r0 = 68
            goto L_0x02fe
        L_0x02fc:
            r0 = 50
        L_0x02fe:
            r2 = 68
            r1.Cardinal = r4
            java.lang.String r0 = "OobContinueLabel"
            r1.getInstance(r0)
            int r0 = f2957b
            int r0 = r0 + r11
            int r2 = r0 % 128
            f2956a = r2
            int r0 = r0 % r6
        L_0x030f:
            return r1
        L_0x0310:
            com.cardinalcommerce.a.setTransformationMethod r1 = m2077b(r16)
            java.lang.String r3 = r0.cleanup
            boolean r3 = com.cardinalcommerce.p060a.setMinLines.getInstance(r3)
            r7 = 35
            if (r3 != 0) goto L_0x0321
            r3 = 22
            goto L_0x0323
        L_0x0321:
            r3 = 35
        L_0x0323:
            if (r3 == r7) goto L_0x0354
            int r3 = f2956a
            r7 = r3 & 113(0x71, float:1.58E-43)
            r3 = r3 ^ 113(0x71, float:1.58E-43)
            r3 = r3 | r7
            int r3 = -r3
            int r3 = -r3
            r8 = r7 ^ r3
            r3 = r3 & r7
            int r3 = r3 << r5
            int r8 = r8 + r3
            int r3 = r8 % 128
            f2957b = r3
            int r8 = r8 % r6
            if (r8 != 0) goto L_0x033d
            r3 = 59
            goto L_0x033f
        L_0x033d:
            r3 = 74
        L_0x033f:
            r7 = 59
            r1.Cardinal = r4
            r1.getInstance(r15)
            int r3 = f2956a
            r7 = r3 ^ 64
            r3 = r3 & r10
            int r3 = r3 << r5
            int r7 = r7 + r3
            int r7 = r7 - r4
            int r7 = r7 - r5
            int r3 = r7 % 128
            f2957b = r3
            int r7 = r7 % r6
        L_0x0354:
            java.lang.String r3 = r0.getProxyAddress
            boolean r3 = com.cardinalcommerce.p060a.setMinLines.getInstance(r3)
            if (r3 != 0) goto L_0x035e
            r3 = 1
            goto L_0x035f
        L_0x035e:
            r3 = 0
        L_0x035f:
            if (r3 == r5) goto L_0x0362
            goto L_0x0384
        L_0x0362:
            int r3 = f2956a
            int r3 = r3 + 7
            int r3 = r3 - r5
            int r3 = r3 - r5
            int r7 = r3 % 128
            f2957b = r7
            int r3 = r3 % r6
            r1.Cardinal = r4
            r1.getInstance(r2)
            int r2 = f2956a
            r3 = r2 & 25
            r2 = r2 ^ 25
            r2 = r2 | r3
            int r2 = -r2
            int r2 = -r2
            r7 = r3 & r2
            r2 = r2 | r3
            int r7 = r7 + r2
            int r2 = r7 % 128
            f2957b = r2
            int r7 = r7 % r6
        L_0x0384:
            java.util.ArrayList<com.cardinalcommerce.a.setCompoundDrawablesRelativeWithIntrinsicBounds> r0 = r0.CardinalRenderType
            int r0 = r0.size()
            if (r0 > 0) goto L_0x038d
            r5 = 0
        L_0x038d:
            if (r5 == 0) goto L_0x0390
            goto L_0x03a2
        L_0x0390:
            int r0 = f2957b
            r2 = r0 & 91
            r0 = r0 | r13
            int r2 = r2 + r0
            int r0 = r2 % 128
            f2956a = r0
            int r2 = r2 % r6
            r1.Cardinal = r4
            java.lang.String r0 = "ChallengeSelectInfo"
            r1.getInstance(r0)
        L_0x03a2:
            return r1
        L_0x03a3:
            com.cardinalcommerce.a.setTransformationMethod r1 = m2077b(r16)
            java.lang.String r3 = r0.getProxyAddress
            boolean r3 = com.cardinalcommerce.p060a.setMinLines.getInstance(r3)
            r7 = 17
            if (r3 != 0) goto L_0x03b4
            r3 = 17
            goto L_0x03b6
        L_0x03b4:
            r3 = 28
        L_0x03b6:
            if (r3 == r7) goto L_0x03b9
            goto L_0x03df
        L_0x03b9:
            int r3 = f2956a
            r7 = r3 ^ 41
            r8 = r3 & 41
            r7 = r7 | r8
            int r7 = r7 << r5
            r8 = r3 & -42
            int r3 = ~r3
            r3 = r3 & 41
            r3 = r3 | r8
            int r3 = -r3
            int r3 = ~r3
            int r7 = r7 - r3
            int r7 = r7 - r5
            int r3 = r7 % 128
            f2957b = r3
            int r7 = r7 % r6
            if (r7 != 0) goto L_0x03d4
            r3 = 1
            goto L_0x03d5
        L_0x03d4:
            r3 = 0
        L_0x03d5:
            if (r3 == 0) goto L_0x03da
            r1.Cardinal = r5
            goto L_0x03dc
        L_0x03da:
            r1.Cardinal = r4
        L_0x03dc:
            r1.getInstance(r2)
        L_0x03df:
            java.lang.String r0 = r0.cleanup
            boolean r0 = com.cardinalcommerce.p060a.setMinLines.getInstance(r0)
            if (r0 != 0) goto L_0x03e9
            r0 = 0
            goto L_0x03ea
        L_0x03e9:
            r0 = 1
        L_0x03ea:
            if (r0 == r5) goto L_0x0404
            int r0 = f2956a
            r2 = r0 & 117(0x75, float:1.64E-43)
            r0 = r0 | 117(0x75, float:1.64E-43)
            int r0 = ~r0
            int r2 = r2 - r0
            int r2 = r2 - r5
            int r0 = r2 % 128
            f2957b = r0
            int r2 = r2 % r6
            if (r2 != 0) goto L_0x03fd
            goto L_0x03fe
        L_0x03fd:
            r14 = 6
        L_0x03fe:
            r0 = 6
            r1.Cardinal = r4
            r1.getInstance(r15)
        L_0x0404:
            int r0 = f2956a
            int r0 = r0 + 121
            int r2 = r0 % 128
            f2957b = r2
            int r0 = r0 % r6
            if (r0 != 0) goto L_0x0412
            r0 = 67
            goto L_0x0414
        L_0x0412:
            r0 = 46
        L_0x0414:
            r2 = 46
            if (r0 == r2) goto L_0x041f
            r0 = 23
            int r0 = r0 / r4
            return r1
        L_0x041c:
            r0 = move-exception
            r1 = r0
            throw r1
        L_0x041f:
            return r1
        L_0x0420:
            com.cardinalcommerce.a.setTransformationMethod r1 = m2077b(r16)
            java.lang.String r0 = r0.Cardinal
            boolean r0 = com.cardinalcommerce.p060a.setMinLines.init(r0)
            if (r0 != 0) goto L_0x042e
            r0 = 1
            goto L_0x042f
        L_0x042e:
            r0 = 0
        L_0x042f:
            r2 = 61
            if (r0 == 0) goto L_0x0459
            int r0 = f2957b
            r3 = r0 & 61
            r0 = r0 ^ r2
            r0 = r0 | r3
            r7 = r3 & r0
            r0 = r0 | r3
            int r7 = r7 + r0
            int r0 = r7 % 128
            f2956a = r0
            int r7 = r7 % r6
            r1.Cardinal = r4
            java.lang.String r0 = "AcsHTML"
            r1.getInstance(r0)
            int r0 = f2956a
            r3 = r0 & 41
            r0 = r0 | 41
            int r0 = -r0
            int r0 = -r0
            int r0 = ~r0
            int r3 = r3 - r0
            int r3 = r3 - r5
            int r0 = r3 % 128
            f2957b = r0
            int r3 = r3 % r6
        L_0x0459:
            int r0 = f2956a
            r3 = r0 | 61
            int r3 = r3 << r5
            r5 = r0 & -62
            int r0 = ~r0
            r0 = r0 & r2
            r0 = r0 | r5
            int r3 = r3 - r0
            int r0 = r3 % 128
            f2957b = r0
            int r3 = r3 % r6
            if (r3 != 0) goto L_0x046e
            r0 = 88
            goto L_0x0470
        L_0x046e:
            r0 = 60
        L_0x0470:
            r3 = 60
            if (r0 == r3) goto L_0x0479
            int r2 = r2 / r4
            return r1
        L_0x0476:
            r0 = move-exception
            r1 = r0
            throw r1
        L_0x0479:
            return r1
        L_0x047a:
            com.cardinalcommerce.a.setTransformationMethod r0 = m2077b(r16)
            int r1 = f2957b
            r2 = r1 & 95
            r1 = r1 | 95
            int r2 = r2 + r1
            int r1 = r2 % 128
            f2956a = r1
            int r2 = r2 % r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setProgressTintList.m2076a(com.cardinalcommerce.a.setBaselineAligned):com.cardinalcommerce.a.setTransformationMethod");
    }

    public setProgressTintList(String str, setSecondaryProgress setsecondaryprogress, setMax setmax) {
        this.cca_continue = setsecondaryprogress;
        if (setmax == setMax.KEY) {
            StringBuilder sb = new StringBuilder("-----BEGIN PUBLIC KEY-----\n");
            sb.append(str);
            sb.append("\n-----END PUBLIC KEY-----");
            this.configure = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder(CertificateTransporter.BEGIN_CERTIFICATE);
            sb2.append(str);
            sb2.append(CertificateTransporter.END_CERTIFICATE);
            this.configure = sb2.toString();
        }
        this.init = setmax;
    }
}
