package com.jumio.core.extraction.barcode.parser.col;

import com.jumio.commons.log.Log;
import com.jumio.core.extraction.barcode.parser.PDF417Parser;

public class COLParser extends PDF417Parser {

    /* renamed from: a */
    public boolean f54753a = true;

    /* renamed from: a */
    public final void mo162759a(StringBuilder sb, String str, String str2) {
        sb.append((str == null || str2 == null || !str.equals(str2.trim())) ? "0" : "1");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(27:172|173|174|177|178|179|180|(0)(0)|191|(0)(0)|195|(0)(0)|199|(0)(0)|203|(0)(0)|207|(0)(0)|211|(0)(0)|215|(0)(0)|219|(0)(0)|223|224|225) */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0466, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0467, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x046a, code lost:
        if (r1.f54753a != false) goto L_0x046c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x046c, code lost:
        r1.f54753a = false;
        com.jumio.analytics.Analytics.add(com.jumio.analytics.MobileEvents.misc(r22, r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x047f, code lost:
        throw new com.jumio.core.extraction.barcode.exception.PDF417ParserException(r2, "Could not parse COL Barcode");
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:224:0x0465 */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0373 A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0403 A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x040e A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x0411 A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0418 A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x041b A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0422 A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0425 A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x042c A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x042f A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0436 A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0439 A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0440 A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0443 A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x044a A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x044d A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0454 A[Catch:{ Exception -> 0x0465 }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0457 A[Catch:{ Exception -> 0x0465 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse() throws com.jumio.core.extraction.barcode.exception.PDF417ParserException {
        /*
            r25 = this;
            r1 = r25
            java.lang.String r2 = "pubdsk"
            java.lang.String r3 = "col_bc"
            java.lang.String r4 = "length"
            java.lang.String r5 = "type"
            java.lang.String r6 = "%1$5s"
            java.lang.String r7 = "1"
            java.lang.String r8 = "0"
            com.jumio.analytics.MetaInfo r9 = new com.jumio.analytics.MetaInfo
            r9.<init>()
            r13 = 48
            r16 = 0
            r10 = 4
            int r0 = r25.mo162757a()     // Catch:{ all -> 0x031c }
            r11 = 58
            java.lang.String r12 = r1.mo162758a(r13, r11)     // Catch:{ all -> 0x031c }
            if (r0 != r10) goto L_0x0028
            r11 = 59
        L_0x0028:
            r18 = 82
            r19 = 81
            if (r0 != r10) goto L_0x0031
            r13 = 82
            goto L_0x0033
        L_0x0031:
            r13 = 81
        L_0x0033:
            java.lang.String r11 = r1.mo162758a(r11, r13)     // Catch:{ all -> 0x030e }
            if (r0 != r10) goto L_0x003c
            r13 = 82
            goto L_0x003e
        L_0x003c:
            r13 = 81
        L_0x003e:
            r18 = 105(0x69, float:1.47E-43)
            r19 = 104(0x68, float:1.46E-43)
            if (r0 != r10) goto L_0x0047
            r15 = 105(0x69, float:1.47E-43)
            goto L_0x0049
        L_0x0047:
            r15 = 104(0x68, float:1.46E-43)
        L_0x0049:
            java.lang.String r13 = r1.mo162758a(r13, r15)     // Catch:{ all -> 0x0302 }
            if (r0 != r10) goto L_0x0052
            r15 = 105(0x69, float:1.47E-43)
            goto L_0x0054
        L_0x0052:
            r15 = 104(0x68, float:1.46E-43)
        L_0x0054:
            if (r0 != r10) goto L_0x005b
            r18 = 128(0x80, float:1.794E-43)
            r14 = 128(0x80, float:1.794E-43)
            goto L_0x005f
        L_0x005b:
            r18 = 127(0x7f, float:1.78E-43)
            r14 = 127(0x7f, float:1.78E-43)
        L_0x005f:
            java.lang.String r14 = r1.mo162758a(r15, r14)     // Catch:{ all -> 0x02f4 }
            if (r0 != r10) goto L_0x0068
            r15 = 128(0x80, float:1.794E-43)
            goto L_0x006a
        L_0x0068:
            r15 = 127(0x7f, float:1.78E-43)
        L_0x006a:
            r18 = 151(0x97, float:2.12E-43)
            if (r0 != r10) goto L_0x0071
            r10 = 151(0x97, float:2.12E-43)
            goto L_0x0075
        L_0x0071:
            r20 = 150(0x96, float:2.1E-43)
            r10 = 150(0x96, float:2.1E-43)
        L_0x0075:
            java.lang.String r10 = r1.mo162758a(r15, r10)     // Catch:{ all -> 0x02e7 }
            r15 = 4
            if (r0 != r15) goto L_0x0083
            r20 = 153(0x99, float:2.14E-43)
            r21 = r7
            r7 = 153(0x99, float:2.14E-43)
            goto L_0x0089
        L_0x0083:
            r20 = 152(0x98, float:2.13E-43)
            r21 = r7
            r7 = 152(0x98, float:2.13E-43)
        L_0x0089:
            if (r0 != r15) goto L_0x008e
            r15 = 161(0xa1, float:2.26E-43)
            goto L_0x0090
        L_0x008e:
            r15 = 160(0xa0, float:2.24E-43)
        L_0x0090:
            java.lang.String r7 = r1.mo162758a(r7, r15)     // Catch:{ all -> 0x02dc }
            java.text.SimpleDateFormat r15 = r1.dateFormat     // Catch:{ all -> 0x02d1 }
            r20 = r8
            java.lang.String r8 = "yyyyMMdd"
            r15.applyPattern(r8)     // Catch:{ all -> 0x02ce }
            java.text.SimpleDateFormat r8 = r1.dateFormat     // Catch:{ Exception -> 0x00ac, all -> 0x00a4 }
            java.util.Date r8 = r8.parse(r7)     // Catch:{ Exception -> 0x00ac, all -> 0x00a4 }
            goto L_0x00ae
        L_0x00a4:
            r0 = move-exception
            r15 = r3
            r8 = r11
            r3 = r16
            r11 = r7
            goto L_0x02d9
        L_0x00ac:
            r8 = r16
        L_0x00ae:
            r15 = 3
            if (r0 != r15) goto L_0x00b4
            r15 = 160(0xa0, float:2.24E-43)
            goto L_0x00b6
        L_0x00b4:
            r15 = 161(0xa1, float:2.26E-43)
        L_0x00b6:
            r22 = r3
            r3 = 3
            if (r0 != r3) goto L_0x00be
            r3 = 165(0xa5, float:2.31E-43)
            goto L_0x00c0
        L_0x00be:
            r3 = 166(0xa6, float:2.33E-43)
        L_0x00c0:
            java.lang.String r3 = r1.mo162758a(r15, r3)     // Catch:{ all -> 0x02c9 }
            int r15 = r3.length()     // Catch:{ all -> 0x02be }
            r23 = r7
            r7 = 5
            if (r15 >= r7) goto L_0x00fb
            r7 = 1
            java.lang.Object[] r15 = new java.lang.Object[r7]     // Catch:{ all -> 0x00ef }
            r7 = 0
            r15[r7] = r3     // Catch:{ all -> 0x00ef }
            java.lang.String r7 = java.lang.String.format(r6, r15)     // Catch:{ all -> 0x00ef }
            r24 = r3
            r3 = 48
            r15 = 32
            java.lang.String r7 = r7.replace(r15, r3)     // Catch:{ all -> 0x00e3 }
            r3 = r7
            goto L_0x00fd
        L_0x00e3:
            r0 = move-exception
            r8 = r11
            r7 = r16
            r15 = r22
            r11 = r23
            r3 = r24
            goto L_0x032b
        L_0x00ef:
            r0 = move-exception
            r24 = r3
            r8 = r11
            r7 = r16
        L_0x00f5:
            r15 = r22
            r11 = r23
            goto L_0x032b
        L_0x00fb:
            r24 = r3
        L_0x00fd:
            r7 = 4
            if (r0 == r7) goto L_0x0103
            r15 = 151(0x97, float:2.12E-43)
            goto L_0x0105
        L_0x0103:
            r15 = 150(0x96, float:2.1E-43)
        L_0x0105:
            if (r0 == r7) goto L_0x010c
            r18 = 152(0x98, float:2.13E-43)
            r0 = 152(0x98, float:2.13E-43)
            goto L_0x010e
        L_0x010c:
            r0 = 151(0x97, float:2.12E-43)
        L_0x010e:
            java.lang.String r7 = r1.mo162758a(r15, r0)     // Catch:{ all -> 0x02b7 }
            com.jumio.core.extraction.barcode.parser.PDF417Data r0 = r1.data     // Catch:{ all -> 0x02b3 }
            r0.setIdNumber(r12)     // Catch:{ all -> 0x02b3 }
            com.jumio.core.extraction.barcode.parser.PDF417Data r0 = r1.data     // Catch:{ all -> 0x02b3 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x02b3 }
            r15.<init>()     // Catch:{ all -> 0x02b3 }
            r15.append(r11)     // Catch:{ all -> 0x02b3 }
            r18 = r11
            java.lang.String r11 = " "
            r15.append(r11)     // Catch:{ all -> 0x02ae }
            r15.append(r13)     // Catch:{ all -> 0x02ae }
            java.lang.String r11 = r15.toString()     // Catch:{ all -> 0x02ae }
            r0.setLastName(r11)     // Catch:{ all -> 0x02ae }
            com.jumio.core.extraction.barcode.parser.PDF417Data r0 = r1.data     // Catch:{ all -> 0x02ae }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ae }
            r11.<init>()     // Catch:{ all -> 0x02ae }
            r11.append(r14)     // Catch:{ all -> 0x02ae }
            java.lang.String r15 = " "
            r11.append(r15)     // Catch:{ all -> 0x02ae }
            r11.append(r10)     // Catch:{ all -> 0x02ae }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x02ae }
            r0.setFirstName(r11)     // Catch:{ all -> 0x02ae }
            com.jumio.core.extraction.barcode.parser.PDF417Data r0 = r1.data     // Catch:{ all -> 0x02ae }
            com.jumio.core.enums.JumioGender r11 = com.jumio.core.enums.JumioGender.valueOf(r7)     // Catch:{ all -> 0x02ae }
            r0.setGender(r11)     // Catch:{ all -> 0x02ae }
            com.jumio.core.extraction.barcode.parser.PDF417Data r0 = r1.data     // Catch:{ all -> 0x02ae }
            r0.setDateOfBirth(r8)     // Catch:{ all -> 0x02ae }
            com.jumio.core.extraction.barcode.parser.PDF417Data r0 = r1.data     // Catch:{ all -> 0x02ae }
            java.lang.String r8 = com.jumio.core.extraction.barcode.parser.col.LocationLookup.getCity(r3)     // Catch:{ all -> 0x02ae }
            r0.setAddressCity(r8)     // Catch:{ all -> 0x02ae }
            com.jumio.core.extraction.barcode.parser.PDF417Data r0 = r1.data     // Catch:{ all -> 0x02ae }
            java.lang.String r8 = com.jumio.core.extraction.barcode.parser.col.LocationLookup.getState(r3)     // Catch:{ all -> 0x02ae }
            r0.setAddressState(r8)     // Catch:{ all -> 0x02ae }
            com.jumio.core.extraction.barcode.parser.PDF417Data r0 = r1.data     // Catch:{ all -> 0x02ae }
            r0.setAddressZip(r3)     // Catch:{ all -> 0x02ae }
            java.lang.String r0 = r1.rawData     // Catch:{ Exception -> 0x02a4 }
            r8 = 2
            r11 = 0
            java.lang.String r0 = r0.substring(r11, r8)     // Catch:{ Exception -> 0x02a4 }
            r9.put(r5, r0)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r0 = r1.rawData     // Catch:{ Exception -> 0x02a4 }
            int r0 = r0.length()     // Catch:{ Exception -> 0x02a4 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x02a4 }
            r9.put(r4, r0)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r0 = r1.rawData     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r4 = "PubDSK_1"
            int r0 = r0.indexOf(r4)     // Catch:{ Exception -> 0x02a4 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x02a4 }
            r9.put(r2, r0)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r0 = "^([0-9]{2})([0-9A-Z]*)[\\x00|\\x20]*(?:PubDSK_1)?(?:[0-9]*)?[\\x00|\\x20]*([0-9]*)[\\x00|\\x20]*([0-9]{10})(.{23})(.{23})(.{23})(.{23}).(M|F)([0-9]{8})(.{6})(.{3})"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r2 = r1.rawData     // Catch:{ Exception -> 0x02a4 }
            java.util.regex.Matcher r0 = r0.matcher(r2)     // Catch:{ Exception -> 0x02a4 }
            boolean r2 = r0.find()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r4 = "regex"
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r2)     // Catch:{ Exception -> 0x02a4 }
            r9.put(r4, r5)     // Catch:{ Exception -> 0x02a4 }
            if (r2 == 0) goto L_0x0242
            java.lang.String r2 = "03"
            r4 = 1
            java.lang.String r5 = r0.group(r4)     // Catch:{ Exception -> 0x02a4 }
            boolean r2 = r2.equals(r5)     // Catch:{ Exception -> 0x02a4 }
            r2 = r2 ^ r4
            r4 = 11
            java.lang.String r5 = r0.group(r4)     // Catch:{ Exception -> 0x02a4 }
            if (r5 == 0) goto L_0x01cf
            java.lang.String r4 = r0.group(r4)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r4 = r4.trim()     // Catch:{ Exception -> 0x02a4 }
            goto L_0x01d1
        L_0x01cf:
            java.lang.String r4 = ""
        L_0x01d1:
            int r5 = r4.length()     // Catch:{ Exception -> 0x02a4 }
            r8 = 5
            if (r5 >= r8) goto L_0x01eb
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x02a4 }
            r5 = 0
            r2[r5] = r4     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r2 = java.lang.String.format(r6, r2)     // Catch:{ Exception -> 0x02a4 }
            r4 = 32
            r5 = 48
            java.lang.String r4 = r2.replace(r4, r5)     // Catch:{ Exception -> 0x02a4 }
            r2 = 0
        L_0x01eb:
            int r5 = r2 + 5
            java.lang.String r2 = r4.substring(r2, r5)     // Catch:{ Exception -> 0x02a4 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r4.<init>()     // Catch:{ Exception -> 0x02a4 }
            r5 = 4
            java.lang.String r5 = r0.group(r5)     // Catch:{ Exception -> 0x02a4 }
            r1.mo162759a(r4, r12, r5)     // Catch:{ Exception -> 0x02a4 }
            r5 = 5
            java.lang.String r5 = r0.group(r5)     // Catch:{ Exception -> 0x02a4 }
            r8 = r18
            r1.mo162759a(r4, r8, r5)     // Catch:{ Exception -> 0x02a4 }
            r5 = 6
            java.lang.String r5 = r0.group(r5)     // Catch:{ Exception -> 0x02a4 }
            r1.mo162759a(r4, r13, r5)     // Catch:{ Exception -> 0x02a4 }
            r5 = 7
            java.lang.String r5 = r0.group(r5)     // Catch:{ Exception -> 0x02a4 }
            r1.mo162759a(r4, r14, r5)     // Catch:{ Exception -> 0x02a4 }
            r5 = 8
            java.lang.String r5 = r0.group(r5)     // Catch:{ Exception -> 0x02a4 }
            r1.mo162759a(r4, r10, r5)     // Catch:{ Exception -> 0x02a4 }
            r5 = 9
            java.lang.String r5 = r0.group(r5)     // Catch:{ Exception -> 0x02a4 }
            r1.mo162759a(r4, r7, r5)     // Catch:{ Exception -> 0x02a4 }
            r5 = 10
            java.lang.String r0 = r0.group(r5)     // Catch:{ Exception -> 0x02a4 }
            r11 = r23
            r1.mo162759a(r4, r11, r0)     // Catch:{ Exception -> 0x02a4 }
            r1.mo162759a(r4, r3, r2)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r0 = "crosscheck"
            java.lang.String r2 = r4.toString()     // Catch:{ Exception -> 0x02a4 }
            r9.put(r0, r2)     // Catch:{ Exception -> 0x02a4 }
            goto L_0x0246
        L_0x0242:
            r8 = r18
            r11 = r23
        L_0x0246:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02a4 }
            r0.<init>()     // Catch:{ Exception -> 0x02a4 }
            if (r12 == 0) goto L_0x0250
            r2 = r21
            goto L_0x0252
        L_0x0250:
            r2 = r20
        L_0x0252:
            r0.append(r2)     // Catch:{ Exception -> 0x02a4 }
            if (r8 == 0) goto L_0x025a
            r2 = r21
            goto L_0x025c
        L_0x025a:
            r2 = r20
        L_0x025c:
            r0.append(r2)     // Catch:{ Exception -> 0x02a4 }
            if (r13 == 0) goto L_0x0264
            r2 = r21
            goto L_0x0266
        L_0x0264:
            r2 = r20
        L_0x0266:
            r0.append(r2)     // Catch:{ Exception -> 0x02a4 }
            if (r14 == 0) goto L_0x026e
            r2 = r21
            goto L_0x0270
        L_0x026e:
            r2 = r20
        L_0x0270:
            r0.append(r2)     // Catch:{ Exception -> 0x02a4 }
            if (r10 == 0) goto L_0x0278
            r2 = r21
            goto L_0x027a
        L_0x0278:
            r2 = r20
        L_0x027a:
            r0.append(r2)     // Catch:{ Exception -> 0x02a4 }
            if (r7 == 0) goto L_0x0282
            r2 = r21
            goto L_0x0284
        L_0x0282:
            r2 = r20
        L_0x0284:
            r0.append(r2)     // Catch:{ Exception -> 0x02a4 }
            if (r11 == 0) goto L_0x028c
            r2 = r21
            goto L_0x028e
        L_0x028c:
            r2 = r20
        L_0x028e:
            r0.append(r2)     // Catch:{ Exception -> 0x02a4 }
            if (r3 == 0) goto L_0x0296
            r7 = r21
            goto L_0x0298
        L_0x0296:
            r7 = r20
        L_0x0298:
            r0.append(r7)     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02a4 }
            java.lang.String r2 = "fields"
            r9.put(r2, r0)     // Catch:{ Exception -> 0x02a4 }
        L_0x02a4:
            r15 = r22
            com.jumio.analytics.AnalyticsEvent r0 = com.jumio.analytics.MobileEvents.misc(r15, r9)
            com.jumio.analytics.Analytics.add(r0)
            return
        L_0x02ae:
            r0 = move-exception
            r8 = r18
            goto L_0x00f5
        L_0x02b3:
            r0 = move-exception
            r8 = r11
            goto L_0x00f5
        L_0x02b7:
            r0 = move-exception
            r8 = r11
            r15 = r22
            r11 = r23
            goto L_0x02c5
        L_0x02be:
            r0 = move-exception
            r24 = r3
            r8 = r11
            r15 = r22
            r11 = r7
        L_0x02c5:
            r7 = r16
            goto L_0x032b
        L_0x02c9:
            r0 = move-exception
            r8 = r11
            r15 = r22
            goto L_0x02d6
        L_0x02ce:
            r0 = move-exception
            r15 = r3
            goto L_0x02d5
        L_0x02d1:
            r0 = move-exception
            r15 = r3
            r20 = r8
        L_0x02d5:
            r8 = r11
        L_0x02d6:
            r11 = r7
            r3 = r16
        L_0x02d9:
            r7 = r3
            goto L_0x032b
        L_0x02dc:
            r0 = move-exception
            r15 = r3
            r20 = r8
            r8 = r11
            r3 = r16
            r7 = r3
            r11 = r7
            goto L_0x032b
        L_0x02e7:
            r0 = move-exception
            r15 = r3
            r21 = r7
            r20 = r8
            r8 = r11
            r3 = r16
            r7 = r3
            r10 = r7
            r11 = r10
            goto L_0x032b
        L_0x02f4:
            r0 = move-exception
            r15 = r3
            r21 = r7
            r20 = r8
            r8 = r11
            r3 = r16
            r7 = r3
            r10 = r7
            r11 = r10
            r14 = r11
            goto L_0x032b
        L_0x0302:
            r0 = move-exception
            r15 = r3
            r21 = r7
            r20 = r8
            r8 = r11
            r3 = r16
            r7 = r3
            r10 = r7
            goto L_0x0319
        L_0x030e:
            r0 = move-exception
            r15 = r3
            r21 = r7
            r20 = r8
            r3 = r16
            r7 = r3
            r8 = r7
            r10 = r8
        L_0x0319:
            r11 = r10
            r13 = r11
            goto L_0x032a
        L_0x031c:
            r0 = move-exception
            r15 = r3
            r21 = r7
            r20 = r8
            r3 = r16
            r7 = r3
            r8 = r7
            r10 = r8
            r11 = r10
            r12 = r11
            r13 = r12
        L_0x032a:
            r14 = r13
        L_0x032b:
            r22 = r15
            java.lang.String r15 = r1.rawData     // Catch:{ Exception -> 0x0465 }
            r16 = r3
            r17 = r11
            r3 = 2
            r11 = 0
            java.lang.String r3 = r15.substring(r11, r3)     // Catch:{ Exception -> 0x0465 }
            r9.put(r5, r3)     // Catch:{ Exception -> 0x0465 }
            java.lang.String r3 = r1.rawData     // Catch:{ Exception -> 0x0465 }
            int r3 = r3.length()     // Catch:{ Exception -> 0x0465 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0465 }
            r9.put(r4, r3)     // Catch:{ Exception -> 0x0465 }
            java.lang.String r3 = r1.rawData     // Catch:{ Exception -> 0x0465 }
            java.lang.String r4 = "PubDSK_1"
            int r3 = r3.indexOf(r4)     // Catch:{ Exception -> 0x0465 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x0465 }
            r9.put(r2, r3)     // Catch:{ Exception -> 0x0465 }
            java.lang.String r2 = "^([0-9]{2})([0-9A-Z]*)[\\x00|\\x20]*(?:PubDSK_1)?(?:[0-9]*)?[\\x00|\\x20]*([0-9]*)[\\x00|\\x20]*([0-9]{10})(.{23})(.{23})(.{23})(.{23}).(M|F)([0-9]{8})(.{6})(.{3})"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)     // Catch:{ Exception -> 0x0465 }
            java.lang.String r3 = r1.rawData     // Catch:{ Exception -> 0x0465 }
            java.util.regex.Matcher r2 = r2.matcher(r3)     // Catch:{ Exception -> 0x0465 }
            boolean r3 = r2.find()     // Catch:{ Exception -> 0x0465 }
            java.lang.String r4 = "regex"
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)     // Catch:{ Exception -> 0x0465 }
            r9.put(r4, r5)     // Catch:{ Exception -> 0x0465 }
            if (r3 == 0) goto L_0x0403
            java.lang.String r3 = "03"
            r4 = 1
            java.lang.String r5 = r2.group(r4)     // Catch:{ Exception -> 0x0465 }
            boolean r3 = r3.equals(r5)     // Catch:{ Exception -> 0x0465 }
            r3 = r3 ^ r4
            r4 = 11
            java.lang.String r5 = r2.group(r4)     // Catch:{ Exception -> 0x0465 }
            if (r5 == 0) goto L_0x0390
            java.lang.String r4 = r2.group(r4)     // Catch:{ Exception -> 0x0465 }
            java.lang.String r4 = r4.trim()     // Catch:{ Exception -> 0x0465 }
            goto L_0x0392
        L_0x0390:
            java.lang.String r4 = ""
        L_0x0392:
            int r5 = r4.length()     // Catch:{ Exception -> 0x0465 }
            r11 = 5
            if (r5 >= r11) goto L_0x03ac
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0465 }
            r5 = 0
            r3[r5] = r4     // Catch:{ Exception -> 0x0465 }
            java.lang.String r3 = java.lang.String.format(r6, r3)     // Catch:{ Exception -> 0x0465 }
            r4 = 32
            r5 = 48
            java.lang.String r4 = r3.replace(r4, r5)     // Catch:{ Exception -> 0x0465 }
            r3 = 0
        L_0x03ac:
            int r5 = r3 + 5
            java.lang.String r3 = r4.substring(r3, r5)     // Catch:{ Exception -> 0x0465 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0465 }
            r4.<init>()     // Catch:{ Exception -> 0x0465 }
            r5 = 4
            java.lang.String r5 = r2.group(r5)     // Catch:{ Exception -> 0x0465 }
            r1.mo162759a(r4, r12, r5)     // Catch:{ Exception -> 0x0465 }
            r5 = 5
            java.lang.String r5 = r2.group(r5)     // Catch:{ Exception -> 0x0465 }
            r1.mo162759a(r4, r8, r5)     // Catch:{ Exception -> 0x0465 }
            r5 = 6
            java.lang.String r5 = r2.group(r5)     // Catch:{ Exception -> 0x0465 }
            r1.mo162759a(r4, r13, r5)     // Catch:{ Exception -> 0x0465 }
            r5 = 7
            java.lang.String r5 = r2.group(r5)     // Catch:{ Exception -> 0x0465 }
            r1.mo162759a(r4, r14, r5)     // Catch:{ Exception -> 0x0465 }
            r5 = 8
            java.lang.String r5 = r2.group(r5)     // Catch:{ Exception -> 0x0465 }
            r1.mo162759a(r4, r10, r5)     // Catch:{ Exception -> 0x0465 }
            r5 = 9
            java.lang.String r5 = r2.group(r5)     // Catch:{ Exception -> 0x0465 }
            r1.mo162759a(r4, r7, r5)     // Catch:{ Exception -> 0x0465 }
            r5 = 10
            java.lang.String r2 = r2.group(r5)     // Catch:{ Exception -> 0x0465 }
            r11 = r17
            r1.mo162759a(r4, r11, r2)     // Catch:{ Exception -> 0x0465 }
            r2 = r16
            r1.mo162759a(r4, r2, r3)     // Catch:{ Exception -> 0x0465 }
            java.lang.String r3 = "crosscheck"
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0465 }
            r9.put(r3, r4)     // Catch:{ Exception -> 0x0465 }
            goto L_0x0407
        L_0x0403:
            r2 = r16
            r11 = r17
        L_0x0407:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0465 }
            r3.<init>()     // Catch:{ Exception -> 0x0465 }
            if (r12 == 0) goto L_0x0411
            r4 = r21
            goto L_0x0413
        L_0x0411:
            r4 = r20
        L_0x0413:
            r3.append(r4)     // Catch:{ Exception -> 0x0465 }
            if (r8 == 0) goto L_0x041b
            r4 = r21
            goto L_0x041d
        L_0x041b:
            r4 = r20
        L_0x041d:
            r3.append(r4)     // Catch:{ Exception -> 0x0465 }
            if (r13 == 0) goto L_0x0425
            r4 = r21
            goto L_0x0427
        L_0x0425:
            r4 = r20
        L_0x0427:
            r3.append(r4)     // Catch:{ Exception -> 0x0465 }
            if (r14 == 0) goto L_0x042f
            r4 = r21
            goto L_0x0431
        L_0x042f:
            r4 = r20
        L_0x0431:
            r3.append(r4)     // Catch:{ Exception -> 0x0465 }
            if (r10 == 0) goto L_0x0439
            r4 = r21
            goto L_0x043b
        L_0x0439:
            r4 = r20
        L_0x043b:
            r3.append(r4)     // Catch:{ Exception -> 0x0465 }
            if (r7 == 0) goto L_0x0443
            r4 = r21
            goto L_0x0445
        L_0x0443:
            r4 = r20
        L_0x0445:
            r3.append(r4)     // Catch:{ Exception -> 0x0465 }
            if (r11 == 0) goto L_0x044d
            r4 = r21
            goto L_0x044f
        L_0x044d:
            r4 = r20
        L_0x044f:
            r3.append(r4)     // Catch:{ Exception -> 0x0465 }
            if (r2 == 0) goto L_0x0457
            r7 = r21
            goto L_0x0459
        L_0x0457:
            r7 = r20
        L_0x0459:
            r3.append(r7)     // Catch:{ Exception -> 0x0465 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0465 }
            java.lang.String r3 = "fields"
            r9.put(r3, r2)     // Catch:{ Exception -> 0x0465 }
        L_0x0465:
            throw r0     // Catch:{ Exception -> 0x0466 }
        L_0x0466:
            r0 = move-exception
            r2 = r0
            boolean r0 = r1.f54753a
            if (r0 == 0) goto L_0x0478
            r3 = 0
            r1.f54753a = r3
            r3 = r22
            com.jumio.analytics.AnalyticsEvent r0 = com.jumio.analytics.MobileEvents.misc(r3, r9)
            com.jumio.analytics.Analytics.add(r0)
        L_0x0478:
            com.jumio.core.extraction.barcode.exception.PDF417ParserException r0 = new com.jumio.core.extraction.barcode.exception.PDF417ParserException
            java.lang.String r3 = "Could not parse COL Barcode"
            r0.<init>((java.lang.Exception) r2, (java.lang.String) r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.extraction.barcode.parser.col.COLParser.parse():void");
    }

    /* renamed from: a */
    public final int mo162757a() {
        int codePointAt = this.rawData.codePointAt(0);
        int codePointAt2 = this.rawData.codePointAt(1);
        if (codePointAt == 48 && codePointAt2 == 50) {
            return 2;
        }
        if (codePointAt == 48 && codePointAt2 == 51) {
            return 3;
        }
        return (codePointAt == 73 && codePointAt2 == 51) ? 4 : 5;
    }

    /* renamed from: a */
    public final String mo162758a(int i, int i2) {
        try {
            StringBuilder sb = new StringBuilder();
            while (i < i2) {
                int codePointAt = this.rawData.codePointAt(i);
                int i3 = i + 1;
                String substring = this.rawData.substring(i, i3);
                if (codePointAt != 0 || substring.equals("0")) {
                    sb.append(substring);
                }
                i = i3;
            }
            return sb.toString().trim();
        } catch (Exception e) {
            Log.printStackTrace(e);
            return null;
        }
    }
}
