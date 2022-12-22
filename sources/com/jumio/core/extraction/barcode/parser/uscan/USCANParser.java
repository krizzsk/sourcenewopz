package com.jumio.core.extraction.barcode.parser.uscan;

import com.jumio.commons.log.Log;
import com.jumio.core.enums.JumioGender;
import com.jumio.core.extraction.barcode.enums.EyeColor;
import com.jumio.core.extraction.barcode.exception.PDF417ParserException;
import com.jumio.core.extraction.barcode.parser.PDF417Data;
import com.jumio.core.extraction.barcode.parser.PDF417Parser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class USCANParser extends PDF417Parser {

    /* renamed from: f */
    public static final String f54756f = "USCANParser";

    /* renamed from: a */
    public char[] f54757a;

    /* renamed from: b */
    public final ArrayList<String> f54758b = new ArrayList<>();

    /* renamed from: c */
    public String f54759c = "";

    /* renamed from: d */
    public int f54760d = -1;

    /* renamed from: e */
    public int f54761e = 0;

    /* renamed from: a */
    public final int mo162760a() throws PDF417ParserException {
        String str;
        if (this.f54757a == null || (str = this.rawData) == null) {
            throw new PDF417ParserException("Delimiter or rawdata not set");
        } else if (this.f54761e >= str.length()) {
            return -1;
        } else {
            int length = this.rawData.length();
            int i = 0;
            while (true) {
                char[] cArr = this.f54757a;
                if (i >= cArr.length) {
                    return length;
                }
                int indexOf = this.rawData.indexOf(cArr[i], this.f54761e);
                if (indexOf < length && indexOf != -1) {
                    length = indexOf;
                }
                i++;
            }
        }
    }

    /* renamed from: b */
    public final void mo162762b() {
        if (BouncyCastleProvider.PROVIDER_NAME.equals(this.data.getAddressState()) && this.data.getIdNumber() != null && this.data.getIdNumber().length() > 7 && this.data.getIdNumber().startsWith("28")) {
            PDF417Data pDF417Data = this.data;
            pDF417Data.setIdNumber(pDF417Data.getIdNumber().substring(2));
        }
    }

    /* renamed from: c */
    public final void mo162763c() {
        if ("OH".equals(this.data.getAddressState()) && this.data.getIdNumber().length() == 10) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append((char) (Integer.parseInt(this.data.getIdNumber().substring(0, 2)) + 64));
                stringBuffer.append((char) (Integer.parseInt(this.data.getIdNumber().substring(2, 4)) + 64));
                stringBuffer.append(this.data.getIdNumber().substring(4));
                this.data.setIdNumber(stringBuffer.toString());
            } catch (Exception e) {
                Log.m39463e(f54756f, (Throwable) e);
            }
        }
    }

    /* renamed from: d */
    public final void mo162764d() throws PDF417ParserException {
        int a = mo162760a();
        while (a != -1) {
            String substring = this.rawData.substring(this.f54761e, a);
            int i = 0;
            while (true) {
                if (i >= this.f54758b.size()) {
                    break;
                } else if (substring.startsWith(this.f54758b.get(i))) {
                    substring = substring.substring(this.f54758b.get(i).length());
                    break;
                } else {
                    i++;
                }
            }
            if (substring.startsWith("DAA")) {
                String substring2 = substring.substring(3);
                if (substring2.contains(",")) {
                    String[] split = substring2.split(",");
                    if (this.f54760d != 1 || !"636020".equals(this.f54759c)) {
                        if (split.length > 0) {
                            this.data.setLastName(split[0]);
                        }
                        if (split.length > 1) {
                            this.data.setFirstName(split[1]);
                        }
                        if (split.length > 2) {
                            this.data.setMiddleName(split[2]);
                        }
                    } else {
                        if (split.length > 0) {
                            this.data.setFirstName(split[0]);
                        }
                        if (split.length > 2) {
                            this.data.setMiddleName(split[1]);
                        }
                        if (split.length > 1) {
                            this.data.setLastName(split[split.length - 1]);
                        }
                    }
                } else {
                    String[] split2 = substring2.split(" ");
                    if (split2.length > 0) {
                        if (split2.length == 1) {
                            this.data.setLastName(split2[0]);
                        } else if (split2.length == 2) {
                            this.data.setFirstName(split2[0]);
                            this.data.setLastName(split2[1]);
                        } else {
                            this.data.setFirstName(split2[0]);
                            this.data.setMiddleName(split2[1]);
                            StringBuilder sb = new StringBuilder();
                            for (int i2 = 2; i2 < split2.length; i2++) {
                                sb.append(split2[i2]);
                                sb.append(" ");
                            }
                            this.data.setLastName(sb.toString());
                        }
                    }
                }
            } else if (substring.startsWith("DAC")) {
                this.data.setFirstName(substring.substring(3));
            } else if (substring.startsWith("DCT")) {
                this.data.setFirstName(substring.substring(3).replaceAll(",", " "));
            } else if (substring.startsWith("DCS") || substring.startsWith("DAB")) {
                this.data.setLastName(substring.substring(3));
            } else if (substring.startsWith("DAD")) {
                this.data.setMiddleName(substring.substring(3));
            } else if (substring.startsWith("DCU")) {
                this.data.setNameSuffix(substring.substring(3));
            } else if (substring.startsWith("DBC")) {
                String substring3 = substring.substring(3);
                if ("M".equals(substring3) || "1".equals(substring3)) {
                    this.data.setGender(JumioGender.M);
                } else if ("F".equals(substring3) || "2".equals(substring3)) {
                    this.data.setGender(JumioGender.F);
                }
            } else if (substring.startsWith("DBB")) {
                this.data.setDateOfBirth(mo162761a(substring.substring(3), true));
            } else if (substring.startsWith("DAY")) {
                String substring4 = substring.substring(3);
                if (substring4.equals("BLK")) {
                    this.data.setEyeColor(EyeColor.BLACK);
                } else if (substring4.equals("BLU")) {
                    this.data.setEyeColor(EyeColor.BLUE);
                } else if (substring4.equals("BRO") || substring4.equals("BR") || substring4.equals("BRN")) {
                    this.data.setEyeColor(EyeColor.BROWN);
                } else if (substring4.equals("GRY")) {
                    this.data.setEyeColor(EyeColor.GRAY);
                } else if (substring4.equals("GRN")) {
                    this.data.setEyeColor(EyeColor.GREEN);
                } else if (substring4.equals("HAZ") || substring4.equals("HZL")) {
                    this.data.setEyeColor(EyeColor.HAZEL);
                } else if (substring4.equals("MAR")) {
                    this.data.setEyeColor(EyeColor.MAROON);
                } else if (substring4.equals("PNK")) {
                    this.data.setEyeColor(EyeColor.PINK);
                } else if (substring4.equals("DIC")) {
                    this.data.setEyeColor(EyeColor.DICHROMATIC);
                } else if (substring4.equals("UNK")) {
                    this.data.setEyeColor(EyeColor.UNKNOWN);
                }
            } else if (substring.startsWith("DAU")) {
                this.data.setHeight(substring.substring(3));
            } else if (substring.startsWith("DAG") || substring.startsWith("DAL")) {
                this.data.setAddressStreet1(substring.substring(3));
            } else if (substring.startsWith("DAH") || substring.startsWith("DAM")) {
                this.data.setAddressStreet2(substring.substring(3));
            } else if (substring.startsWith("DAI") || substring.startsWith("DAN")) {
                this.data.setAddressCity(substring.substring(3));
            } else if (substring.startsWith("DAJ") || substring.startsWith("DAO")) {
                this.data.setAddressState(substring.substring(3));
            } else if (substring.startsWith("DAK") || substring.startsWith("DAP")) {
                this.data.setAddressZip(substring.substring(3));
            } else if (substring.startsWith("DAQ")) {
                this.data.setIdNumber(substring.substring(3));
            } else if (substring.startsWith("DCG")) {
                this.data.setIssuingCountry(substring.substring(3));
            } else if (substring.startsWith("DBD")) {
                this.data.setIssueDate(mo162761a(substring.substring(3), true));
            } else if (substring.startsWith("DBA")) {
                this.data.setExpiryDate(mo162761a(substring.substring(3), false));
            } else if (substring.startsWith("DCA")) {
                this.data.setVehicleClass(substring.substring(3));
            } else if (substring.startsWith("DCB")) {
                this.data.setRestrictionCodes(substring.substring(3));
            } else if (substring.startsWith("DCD")) {
                this.data.setEndorsementCodes(substring.substring(3));
            } else {
                this.data.addUnparsedData(substring, "\n");
            }
            this.f54761e = a + 1;
            a = mo162760a();
        }
    }

    /* renamed from: e */
    public final void mo162765e() {
        Matcher matcher = Pattern.compile("@([\\x00-\\x1F\\x21-\\x40\\x5B-\\xFF]{2,3})[A-Z ]*([0-9]{6})([0-9]{2})[0-9]*").matcher(this.rawData);
        if (matcher.find()) {
            String group = matcher.group(1);
            this.f54757a = new char[group.length()];
            group.getChars(0, group.length(), this.f54757a, 0);
            this.f54759c = matcher.group(2);
            this.f54760d = Integer.parseInt(matcher.group(3));
        }
        this.rawData = this.rawData.replaceAll("@([\\x00-\\x1F\\x21-\\x40\\x5B-\\xFF]{2,3})[A-Z ]*([0-9]{6})([0-9]{2})[0-9]*", "");
        this.f54761e = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00dd A[Catch:{ Exception -> 0x0275 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f2 A[Catch:{ Exception -> 0x0275 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0103 A[Catch:{ Exception -> 0x0275 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0189 A[Catch:{ Exception -> 0x0275 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01ea A[Catch:{ Exception -> 0x0275 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0208 A[Catch:{ Exception -> 0x0275 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x024a A[Catch:{ Exception -> 0x0275 }] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.jumio.core.extraction.barcode.parser.PDF417Data mo162766f() throws com.jumio.core.extraction.barcode.exception.PDF417ParserException {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "88"
            java.lang.String r2 = "\\$"
            java.lang.String r3 = ""
            java.lang.String r4 = "[^A-Za-z\\- \\']"
            java.lang.String r5 = "%"
            java.lang.String r6 = "^"
            r7 = 0
            r1.f54761e = r7     // Catch:{ Exception -> 0x0275 }
            java.lang.String r8 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            boolean r8 = r8.startsWith(r5)     // Catch:{ Exception -> 0x0275 }
            r9 = 1
            if (r8 == 0) goto L_0x001f
            int r8 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r8 = r8 + r9
            r1.f54761e = r8     // Catch:{ Exception -> 0x0275 }
        L_0x001f:
            com.jumio.core.extraction.barcode.parser.PDF417Data r8 = r1.data     // Catch:{ Exception -> 0x0275 }
            java.lang.String r10 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            int r11 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r12 = r11 + 2
            java.lang.String r10 = r10.substring(r11, r12)     // Catch:{ Exception -> 0x0275 }
            r8.setAddressState(r10)     // Catch:{ Exception -> 0x0275 }
            int r8 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            r10 = 2
            int r8 = r8 + r10
            r1.f54761e = r8     // Catch:{ Exception -> 0x0275 }
            java.lang.String r11 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            int r8 = r11.indexOf(r6, r8)     // Catch:{ Exception -> 0x0275 }
            int r11 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r8 = r8 - r11
            r12 = 13
            if (r8 >= r12) goto L_0x0043
            r13 = 1
            goto L_0x0044
        L_0x0043:
            r13 = 0
        L_0x0044:
            if (r13 == 0) goto L_0x004a
            int r12 = 13 - r8
            int r12 = r12 + r7
            goto L_0x004d
        L_0x004a:
            r8 = 13
            r12 = 0
        L_0x004d:
            com.jumio.core.extraction.barcode.parser.PDF417Data r14 = r1.data     // Catch:{ Exception -> 0x0275 }
            java.lang.String r15 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            int r10 = r11 + r8
            java.lang.String r10 = r15.substring(r11, r10)     // Catch:{ Exception -> 0x0275 }
            r14.setAddressCity(r10)     // Catch:{ Exception -> 0x0275 }
            int r10 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r8 = r8 + r13
            int r10 = r10 + r8
            r1.f54761e = r10     // Catch:{ Exception -> 0x0275 }
            java.lang.String r8 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            int r8 = r8.indexOf(r6, r10)     // Catch:{ Exception -> 0x0275 }
            int r10 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r8 = r8 - r10
            int r11 = r10 + 35
            if (r8 >= r11) goto L_0x006f
            r11 = 1
            goto L_0x0070
        L_0x006f:
            r11 = 0
        L_0x0070:
            if (r11 == 0) goto L_0x0076
            int r13 = 35 - r8
            int r12 = r12 + r13
            goto L_0x0078
        L_0x0076:
            r8 = 35
        L_0x0078:
            java.lang.String r13 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            int r14 = r10 + r8
            java.lang.String r10 = r13.substring(r10, r14)     // Catch:{ Exception -> 0x0275 }
            java.lang.String[] r10 = r10.split(r2)     // Catch:{ Exception -> 0x0275 }
            com.jumio.core.extraction.barcode.parser.PDF417Data r13 = r1.data     // Catch:{ Exception -> 0x0275 }
            r14 = r10[r7]     // Catch:{ Exception -> 0x0275 }
            java.lang.String r14 = r14.replaceAll(r4, r3)     // Catch:{ Exception -> 0x0275 }
            r13.setLastName(r14)     // Catch:{ Exception -> 0x0275 }
            int r13 = r10.length     // Catch:{ Exception -> 0x0275 }
            if (r13 <= r9) goto L_0x009d
            com.jumio.core.extraction.barcode.parser.PDF417Data r13 = r1.data     // Catch:{ Exception -> 0x0275 }
            r14 = r10[r9]     // Catch:{ Exception -> 0x0275 }
            java.lang.String r14 = r14.replaceAll(r4, r3)     // Catch:{ Exception -> 0x0275 }
            r13.setFirstName(r14)     // Catch:{ Exception -> 0x0275 }
        L_0x009d:
            int r13 = r10.length     // Catch:{ Exception -> 0x0275 }
            r14 = 2
            if (r13 <= r14) goto L_0x00ac
            com.jumio.core.extraction.barcode.parser.PDF417Data r13 = r1.data     // Catch:{ Exception -> 0x0275 }
            r10 = r10[r14]     // Catch:{ Exception -> 0x0275 }
            java.lang.String r3 = r10.replaceAll(r4, r3)     // Catch:{ Exception -> 0x0275 }
            r13.setMiddleName(r3)     // Catch:{ Exception -> 0x0275 }
        L_0x00ac:
            int r3 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r8 = r8 + r11
            int r3 = r3 + r8
            r1.f54761e = r3     // Catch:{ Exception -> 0x0275 }
            java.lang.String r4 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            int r3 = r4.indexOf(r6, r3)     // Catch:{ Exception -> 0x0275 }
            int r4 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r3 = r3 - r4
            if (r3 < 0) goto L_0x00c4
            int r8 = r12 + 29
            if (r3 <= r8) goto L_0x00c2
            goto L_0x00c4
        L_0x00c2:
            r8 = 1
            goto L_0x00c7
        L_0x00c4:
            int r3 = r12 + 29
            r8 = 0
        L_0x00c7:
            java.lang.String r10 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            int r11 = r4 + r3
            java.lang.String r4 = r10.substring(r4, r11)     // Catch:{ Exception -> 0x0275 }
            java.lang.String[] r2 = r4.split(r2)     // Catch:{ Exception -> 0x0275 }
            com.jumio.core.extraction.barcode.parser.PDF417Data r4 = r1.data     // Catch:{ Exception -> 0x0275 }
            r7 = r2[r7]     // Catch:{ Exception -> 0x0275 }
            r4.setAddressStreet1(r7)     // Catch:{ Exception -> 0x0275 }
            int r4 = r2.length     // Catch:{ Exception -> 0x0275 }
            if (r4 <= r9) goto L_0x00e4
            com.jumio.core.extraction.barcode.parser.PDF417Data r4 = r1.data     // Catch:{ Exception -> 0x0275 }
            r2 = r2[r9]     // Catch:{ Exception -> 0x0275 }
            r4.setAddressStreet2(r2)     // Catch:{ Exception -> 0x0275 }
        L_0x00e4:
            int r2 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r3 = r3 + r8
            int r2 = r2 + r3
            r1.f54761e = r2     // Catch:{ Exception -> 0x0275 }
            java.lang.String r3 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            boolean r2 = r3.startsWith(r6, r2)     // Catch:{ Exception -> 0x0275 }
            if (r2 == 0) goto L_0x00f7
            int r2 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r2 = r2 + r9
            r1.f54761e = r2     // Catch:{ Exception -> 0x0275 }
        L_0x00f7:
            java.lang.String r2 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            java.lang.String r3 = ";"
            int r4 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            boolean r2 = r2.startsWith(r3, r4)     // Catch:{ Exception -> 0x0275 }
            if (r2 == 0) goto L_0x0108
            int r2 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r2 = r2 + r9
            r1.f54761e = r2     // Catch:{ Exception -> 0x0275 }
        L_0x0108:
            java.lang.String r2 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            int r3 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r4 = r3 + 6
            java.lang.String r2 = r2.substring(r3, r4)     // Catch:{ Exception -> 0x0275 }
            r1.f54759c = r2     // Catch:{ Exception -> 0x0275 }
            int r2 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r2 = r2 + 6
            r1.f54761e = r2     // Catch:{ Exception -> 0x0275 }
            java.lang.String r3 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            java.lang.String r4 = "="
            int r2 = r3.indexOf(r4, r2)     // Catch:{ Exception -> 0x0275 }
            int r3 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r2 = r2 - r3
            com.jumio.core.extraction.barcode.parser.PDF417Data r4 = r1.data     // Catch:{ Exception -> 0x0275 }
            java.lang.String r6 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            int r7 = r3 + r2
            java.lang.String r3 = r6.substring(r3, r7)     // Catch:{ Exception -> 0x0275 }
            r4.setIdNumber(r3)     // Catch:{ Exception -> 0x0275 }
            int r3 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r2 = r2 + r9
            int r3 = r3 + r2
            r1.f54761e = r3     // Catch:{ Exception -> 0x0275 }
            java.lang.String r2 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            int r4 = r3 + 2
            java.lang.String r2 = r2.substring(r3, r4)     // Catch:{ Exception -> 0x0275 }
            java.lang.String r3 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            int r4 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r6 = r4 + 2
            int r4 = r4 + 4
            java.lang.String r3 = r3.substring(r6, r4)     // Catch:{ Exception -> 0x0275 }
            int r4 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r4 = r4 + 4
            r1.f54761e = r4     // Catch:{ Exception -> 0x0275 }
            java.text.SimpleDateFormat r4 = r1.dateFormat     // Catch:{ Exception -> 0x0275 }
            java.lang.String r6 = "yyyyMMdd"
            r4.applyPattern(r6)     // Catch:{ Exception -> 0x0275 }
            java.text.SimpleDateFormat r4 = r1.dateFormat     // Catch:{ Exception -> 0x0275 }
            java.lang.String r6 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            int r7 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r8 = r7 + 8
            java.lang.String r6 = r6.substring(r7, r8)     // Catch:{ Exception -> 0x0275 }
            java.util.Date r4 = r4.parse(r6)     // Catch:{ Exception -> 0x0275 }
            com.jumio.core.extraction.barcode.parser.PDF417Data r6 = r1.data     // Catch:{ Exception -> 0x0275 }
            r6.setDateOfBirth(r4)     // Catch:{ Exception -> 0x0275 }
            int r6 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r6 = r6 + 8
            r1.f54761e = r6     // Catch:{ Exception -> 0x0275 }
            java.util.GregorianCalendar r6 = new java.util.GregorianCalendar     // Catch:{ Exception -> 0x0275 }
            r6.<init>()     // Catch:{ Exception -> 0x0275 }
            java.lang.String r7 = "UTC"
            java.util.TimeZone r7 = java.util.TimeZone.getTimeZone(r7)     // Catch:{ Exception -> 0x0275 }
            r6.setTimeZone(r7)     // Catch:{ Exception -> 0x0275 }
            boolean r7 = r0.equals(r3)     // Catch:{ Exception -> 0x0275 }
            r8 = 5
            if (r7 != 0) goto L_0x01cd
            java.lang.String r7 = "99"
            boolean r7 = r7.equals(r3)     // Catch:{ Exception -> 0x0275 }
            if (r7 == 0) goto L_0x0192
            goto L_0x01cd
        L_0x0192:
            java.lang.String r0 = "77"
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x0275 }
            if (r0 != 0) goto L_0x01fd
            java.text.SimpleDateFormat r0 = r1.dateFormat     // Catch:{ Exception -> 0x0275 }
            java.lang.String r7 = "yyMM"
            r0.applyPattern(r7)     // Catch:{ Exception -> 0x0275 }
            java.text.SimpleDateFormat r0 = r1.dateFormat     // Catch:{ Exception -> 0x0275 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0275 }
            r7.<init>()     // Catch:{ Exception -> 0x0275 }
            r7.append(r2)     // Catch:{ Exception -> 0x0275 }
            r7.append(r3)     // Catch:{ Exception -> 0x0275 }
            java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x0275 }
            java.util.Date r0 = r0.parse(r2)     // Catch:{ Exception -> 0x0275 }
            r6.setTime(r4)     // Catch:{ Exception -> 0x0275 }
            int r2 = r6.get(r8)     // Catch:{ Exception -> 0x0275 }
            r6.setTime(r0)     // Catch:{ Exception -> 0x0275 }
            r6.set(r8, r2)     // Catch:{ Exception -> 0x0275 }
            com.jumio.core.extraction.barcode.parser.PDF417Data r0 = r1.data     // Catch:{ Exception -> 0x0275 }
            java.util.Date r2 = r6.getTime()     // Catch:{ Exception -> 0x0275 }
            r0.setExpiryDate(r2)     // Catch:{ Exception -> 0x0275 }
            goto L_0x01fd
        L_0x01cd:
            java.text.SimpleDateFormat r7 = r1.dateFormat     // Catch:{ Exception -> 0x0275 }
            java.lang.String r10 = "yy"
            r7.applyPattern(r10)     // Catch:{ Exception -> 0x0275 }
            java.text.SimpleDateFormat r7 = r1.dateFormat     // Catch:{ Exception -> 0x0275 }
            java.util.Date r2 = r7.parse(r2)     // Catch:{ Exception -> 0x0275 }
            r6.setTime(r2)     // Catch:{ Exception -> 0x0275 }
            int r2 = r6.get(r9)     // Catch:{ Exception -> 0x0275 }
            r6.setTime(r4)     // Catch:{ Exception -> 0x0275 }
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x0275 }
            if (r0 == 0) goto L_0x01f1
            int r0 = r6.getActualMaximum(r8)     // Catch:{ Exception -> 0x0275 }
            r6.set(r8, r0)     // Catch:{ Exception -> 0x0275 }
        L_0x01f1:
            r6.set(r9, r2)     // Catch:{ Exception -> 0x0275 }
            com.jumio.core.extraction.barcode.parser.PDF417Data r0 = r1.data     // Catch:{ Exception -> 0x0275 }
            java.util.Date r2 = r6.getTime()     // Catch:{ Exception -> 0x0275 }
            r0.setExpiryDate(r2)     // Catch:{ Exception -> 0x0275 }
        L_0x01fd:
            java.lang.String r0 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            int r2 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r0 = r0.indexOf(r5, r2)     // Catch:{ Exception -> 0x0275 }
            r2 = -1
            if (r0 == r2) goto L_0x0213
            java.lang.String r0 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            int r2 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r0 = r0.indexOf(r5, r2)     // Catch:{ Exception -> 0x0275 }
            int r0 = r0 + r9
            r1.f54761e = r0     // Catch:{ Exception -> 0x0275 }
        L_0x0213:
            int r0 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r0 = r0 + r9
            r1.f54761e = r0     // Catch:{ Exception -> 0x0275 }
            int r0 = r0 + r9
            r1.f54761e = r0     // Catch:{ Exception -> 0x0275 }
            com.jumio.core.extraction.barcode.parser.PDF417Data r2 = r1.data     // Catch:{ Exception -> 0x0275 }
            java.lang.String r3 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            int r4 = r0 + 11
            java.lang.String r0 = r3.substring(r0, r4)     // Catch:{ Exception -> 0x0275 }
            r2.setAddressZip(r0)     // Catch:{ Exception -> 0x0275 }
            int r0 = r1.f54761e     // Catch:{ Exception -> 0x0275 }
            int r0 = r0 + 11
            r1.f54761e = r0     // Catch:{ Exception -> 0x0275 }
            r2 = 2
            int r0 = r0 + r2
            r1.f54761e = r0     // Catch:{ Exception -> 0x0275 }
            int r0 = r0 + 10
            r1.f54761e = r0     // Catch:{ Exception -> 0x0275 }
            int r0 = r0 + 4
            r1.f54761e = r0     // Catch:{ Exception -> 0x0275 }
            java.lang.String r2 = r1.rawData     // Catch:{ Exception -> 0x0275 }
            int r3 = r0 + 1
            java.lang.String r0 = r2.substring(r0, r3)     // Catch:{ Exception -> 0x0275 }
            java.lang.String r2 = "1"
            boolean r2 = r2.equals(r0)     // Catch:{ Exception -> 0x0275 }
            if (r2 != 0) goto L_0x026b
            java.lang.String r2 = "M"
            boolean r2 = r2.equals(r0)     // Catch:{ Exception -> 0x0275 }
            if (r2 == 0) goto L_0x0253
            goto L_0x026b
        L_0x0253:
            java.lang.String r2 = "2"
            boolean r2 = r2.equals(r0)     // Catch:{ Exception -> 0x0275 }
            if (r2 != 0) goto L_0x0263
            java.lang.String r2 = "F"
            boolean r0 = r2.equals(r0)     // Catch:{ Exception -> 0x0275 }
            if (r0 == 0) goto L_0x0272
        L_0x0263:
            com.jumio.core.extraction.barcode.parser.PDF417Data r0 = r1.data     // Catch:{ Exception -> 0x0275 }
            com.jumio.core.enums.JumioGender r2 = com.jumio.core.enums.JumioGender.F     // Catch:{ Exception -> 0x0275 }
            r0.setGender(r2)     // Catch:{ Exception -> 0x0275 }
            goto L_0x0272
        L_0x026b:
            com.jumio.core.extraction.barcode.parser.PDF417Data r0 = r1.data     // Catch:{ Exception -> 0x0275 }
            com.jumio.core.enums.JumioGender r2 = com.jumio.core.enums.JumioGender.M     // Catch:{ Exception -> 0x0275 }
            r0.setGender(r2)     // Catch:{ Exception -> 0x0275 }
        L_0x0272:
            com.jumio.core.extraction.barcode.parser.PDF417Data r0 = r1.data
            return r0
        L_0x0275:
            r0 = move-exception
            com.jumio.core.extraction.barcode.exception.PDF417ParserException r2 = new com.jumio.core.extraction.barcode.exception.PDF417ParserException
            java.lang.String r3 = "Incompatible magstripe structure"
            r2.<init>((java.lang.Exception) r0, (java.lang.String) r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.extraction.barcode.parser.uscan.USCANParser.mo162766f():com.jumio.core.extraction.barcode.parser.PDF417Data");
    }

    /* renamed from: g */
    public final void mo162767g() {
        Matcher matcher = Pattern.compile("^((?:[A-Z]{2}[0-9]{8})*)").matcher(this.rawData);
        this.f54758b.clear();
        if (matcher.find()) {
            Matcher matcher2 = Pattern.compile("([A-Z]{2})").matcher(matcher.group(1));
            while (matcher2.find()) {
                this.f54758b.add(matcher2.group(1));
            }
        }
        this.rawData = this.rawData.replaceAll("^((?:[A-Z]{2}[0-9]{8})*)", "");
        this.f54761e = 0;
    }

    public void parse() throws PDF417ParserException {
        String str = this.rawData;
        int i = this.f54761e;
        if (str.substring(i, i + 1).equals("@")) {
            this.f54761e++;
            mo162765e();
            mo162767g();
            mo162764d();
        } else {
            mo162766f();
            mo162763c();
        }
        mo162762b();
    }

    /* renamed from: a */
    public final Date mo162761a(String str, boolean z) {
        Date date = null;
        if (str.isEmpty()) {
            return null;
        }
        try {
            String replaceAll = str.replaceAll("\\D", "");
            String substring = replaceAll.substring(0, 4);
            String substring2 = replaceAll.substring(4);
            Pattern compile = Pattern.compile("^(?:(?:19|20)\\d{2})$");
            Pattern compile2 = Pattern.compile("^(?:0[1-9]|1[0-2])(?:0[1-9]|[12][0-9]|3[01])$");
            Pattern compile3 = Pattern.compile("^(?:0[1-9]|[12][0-9]|3[01])(?:0[1-9]|1[0-2])$");
            if (compile.matcher(substring).matches() && compile2.matcher(substring2).matches()) {
                this.dateFormat.applyPattern("yyyyMMdd");
            } else if (compile.matcher(substring).matches() && compile3.matcher(substring2).matches()) {
                this.dateFormat.applyPattern("yyyyddMM");
            } else if (compile2.matcher(substring).matches() && compile.matcher(substring2).matches()) {
                this.dateFormat.applyPattern("MMddyyyy");
            } else if (compile3.matcher(substring).matches() && compile.matcher(substring2).matches()) {
                this.dateFormat.applyPattern("ddMMyyyy");
            }
            Date parse = this.dateFormat.parse(replaceAll);
            if (z) {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    if (parse.after(simpleDateFormat.parse(simpleDateFormat.format(new Date())))) {
                        return null;
                    }
                } catch (Exception e) {
                    date = parse;
                    e = e;
                    Log.m39463e(f54756f, (Throwable) e);
                    return date;
                }
            }
            return parse;
        } catch (Exception e2) {
            e = e2;
            Log.m39463e(f54756f, (Throwable) e);
            return date;
        }
    }
}
