package com.didi.dqr.oned;

import com.didi.dcrypto.util.DCryptoUtils;
import com.didi.map.setting.common.MapSettingNavConstant;
import com.didi.sdk.sidebar.history.HistoryRecordFragment;
import com.didi.sdk.util.GlobalCountryCode;
import com.google.zxing.client.result.ExpandedProductParsedResult;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.dqr.oned.a */
/* compiled from: EANManufacturerOrgSupport */
final class C7850a {

    /* renamed from: a */
    private final List<int[]> f18766a = new ArrayList();

    /* renamed from: b */
    private final List<String> f18767b = new ArrayList();

    C7850a() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0017, code lost:
        r4 = r7.f18766a.get(r2);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo58377a(java.lang.String r8) {
        /*
            r7 = this;
            r7.m13926a()
            r0 = 0
            r1 = 3
            java.lang.String r8 = r8.substring(r0, r1)
            int r8 = java.lang.Integer.parseInt(r8)
            java.util.List<int[]> r1 = r7.f18766a
            int r1 = r1.size()
            r2 = 0
        L_0x0014:
            r3 = 0
            if (r2 >= r1) goto L_0x0039
            java.util.List<int[]> r4 = r7.f18766a
            java.lang.Object r4 = r4.get(r2)
            int[] r4 = (int[]) r4
            r5 = r4[r0]
            if (r8 >= r5) goto L_0x0024
            return r3
        L_0x0024:
            int r3 = r4.length
            r6 = 1
            if (r3 != r6) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r5 = r4[r6]
        L_0x002b:
            if (r8 > r5) goto L_0x0036
            java.util.List<java.lang.String> r8 = r7.f18767b
            java.lang.Object r8 = r8.get(r2)
            java.lang.String r8 = (java.lang.String) r8
            return r8
        L_0x0036:
            int r2 = r2 + 1
            goto L_0x0014
        L_0x0039:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dqr.oned.C7850a.mo58377a(java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    private void m13927a(int[] iArr, String str) {
        this.f18766a.add(iArr);
        this.f18767b.add(str);
    }

    /* renamed from: a */
    private synchronized void m13926a() {
        if (this.f18766a.isEmpty()) {
            m13927a(new int[]{0, 19}, "US/CA");
            m13927a(new int[]{30, 39}, GlobalCountryCode.AMERICA);
            m13927a(new int[]{60, 139}, "US/CA");
            m13927a(new int[]{300, 379}, GlobalCountryCode.FRANCE);
            m13927a(new int[]{380}, GlobalCountryCode.BULGARIA);
            m13927a(new int[]{383}, GlobalCountryCode.SLOVENIA);
            m13927a(new int[]{385}, GlobalCountryCode.CROATIA);
            m13927a(new int[]{387}, "BA");
            m13927a(new int[]{400, 440}, GlobalCountryCode.GERMANY);
            m13927a(new int[]{450, 459}, "JP");
            m13927a(new int[]{460, 469}, MapSettingNavConstant.MAP_COUNTRY_CODE_RUSSIA);
            m13927a(new int[]{471}, "TW");
            m13927a(new int[]{474}, GlobalCountryCode.ESTONIA);
            m13927a(new int[]{475}, GlobalCountryCode.LATVIA);
            m13927a(new int[]{476}, "AZ");
            m13927a(new int[]{477}, GlobalCountryCode.LITHUANIA);
            m13927a(new int[]{478}, "UZ");
            m13927a(new int[]{479}, "LK");
            m13927a(new int[]{480}, "PH");
            m13927a(new int[]{481}, "BY");
            m13927a(new int[]{482}, "UA");
            m13927a(new int[]{484}, "MD");
            m13927a(new int[]{485}, "AM");
            m13927a(new int[]{486}, "GE");
            m13927a(new int[]{487}, MapSettingNavConstant.MAP_COUNTRY_CODE_KAZAKHSTAN);
            m13927a(new int[]{489}, "HK");
            m13927a(new int[]{490, 499}, "JP");
            m13927a(new int[]{500, 509}, GlobalCountryCode.ENGLAND);
            m13927a(new int[]{520}, GlobalCountryCode.GREECE);
            m13927a(new int[]{528}, ExpandedProductParsedResult.POUND);
            m13927a(new int[]{529}, GlobalCountryCode.CYPRUS);
            m13927a(new int[]{531}, "MK");
            m13927a(new int[]{535}, GlobalCountryCode.MALTA);
            m13927a(new int[]{539}, GlobalCountryCode.IRELAND);
            m13927a(new int[]{540, 549}, "BE/LU");
            m13927a(new int[]{560}, GlobalCountryCode.PORTUGAL);
            m13927a(new int[]{569}, "IS");
            m13927a(new int[]{570, 579}, GlobalCountryCode.DENMARK);
            m13927a(new int[]{590}, GlobalCountryCode.POLAND);
            m13927a(new int[]{594}, GlobalCountryCode.RUMANIA);
            m13927a(new int[]{599}, GlobalCountryCode.HUNGARY);
            m13927a(new int[]{600, 601}, HistoryRecordFragment.COUNTRY_CODE_ZA);
            m13927a(new int[]{603}, "GH");
            m13927a(new int[]{608}, "BH");
            m13927a(new int[]{609}, "MU");
            m13927a(new int[]{611}, "MA");
            m13927a(new int[]{613}, "DZ");
            m13927a(new int[]{616}, "KE");
            m13927a(new int[]{618}, "CI");
            m13927a(new int[]{619}, "TN");
            m13927a(new int[]{621}, "SY");
            m13927a(new int[]{622}, "EG");
            m13927a(new int[]{624}, "LY");
            m13927a(new int[]{625}, "JO");
            m13927a(new int[]{626}, "IR");
            m13927a(new int[]{627}, "KW");
            m13927a(new int[]{628}, "SA");
            m13927a(new int[]{629}, "AE");
            m13927a(new int[]{640, 649}, GlobalCountryCode.FINLAND);
            m13927a(new int[]{690, 695}, GlobalCountryCode.CHINA);
            m13927a(new int[]{700, 709}, DCryptoUtils.KEY_IP_BLOCKING_STATUS_UNBLOCK);
            m13927a(new int[]{729}, "IL");
            m13927a(new int[]{730, 739}, GlobalCountryCode.SWEDEN);
            m13927a(new int[]{740}, "GT");
            m13927a(new int[]{741}, "SV");
            m13927a(new int[]{742}, "HN");
            m13927a(new int[]{743}, "NI");
            m13927a(new int[]{744}, HistoryRecordFragment.COUNTRY_CODE_CR);
            m13927a(new int[]{745}, HistoryRecordFragment.COUNTRY_CODE_PA);
            m13927a(new int[]{746}, HistoryRecordFragment.COUNTRY_CODE_DO);
            m13927a(new int[]{750}, "MX");
            m13927a(new int[]{754, 755}, GlobalCountryCode.CANADA);
            m13927a(new int[]{759}, "VE");
            m13927a(new int[]{760, 769}, "CH");
            m13927a(new int[]{770}, HistoryRecordFragment.COUNTRY_CODE_CO);
            m13927a(new int[]{773}, "UY");
            m13927a(new int[]{775}, HistoryRecordFragment.COUNTRY_CODE_PE);
            m13927a(new int[]{777}, "BO");
            m13927a(new int[]{779}, HistoryRecordFragment.COUNTRY_CODE_AR);
            m13927a(new int[]{780}, HistoryRecordFragment.COUNTRY_CODE_CL);
            m13927a(new int[]{784}, "PY");
            m13927a(new int[]{785}, HistoryRecordFragment.COUNTRY_CODE_PE);
            m13927a(new int[]{786}, "EC");
            m13927a(new int[]{789, 790}, "BR");
            m13927a(new int[]{800, 839}, GlobalCountryCode.ITALY);
            m13927a(new int[]{840, 849}, GlobalCountryCode.SPAIN);
            m13927a(new int[]{850}, "CU");
            m13927a(new int[]{858}, GlobalCountryCode.SLOVAKIA);
            m13927a(new int[]{859}, GlobalCountryCode.CZECH_REPUBLIC);
            m13927a(new int[]{860}, "YU");
            m13927a(new int[]{865}, "MN");
            m13927a(new int[]{867}, "KP");
            m13927a(new int[]{868, 869}, "TR");
            m13927a(new int[]{870, 879}, GlobalCountryCode.NETHERLANDS);
            m13927a(new int[]{880}, "KR");
            m13927a(new int[]{885}, "TH");
            m13927a(new int[]{888}, "SG");
            m13927a(new int[]{890}, "IN");
            m13927a(new int[]{893}, "VN");
            m13927a(new int[]{896}, "PK");
            m13927a(new int[]{899}, "ID");
            m13927a(new int[]{900, 919}, GlobalCountryCode.AUSTRIA);
            m13927a(new int[]{930, 939}, "AU");
            m13927a(new int[]{940, 949}, "AZ");
            m13927a(new int[]{955}, "MY");
            m13927a(new int[]{958}, "MO");
        }
    }
}
