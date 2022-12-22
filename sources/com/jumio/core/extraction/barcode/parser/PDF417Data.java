package com.jumio.core.extraction.barcode.parser;

import com.jumio.core.enums.JumioGender;
import com.jumio.core.extraction.barcode.enums.EyeColor;
import java.util.Date;

public class PDF417Data {

    /* renamed from: a */
    public Date f54732a = null;

    /* renamed from: b */
    public Date f54733b = null;

    /* renamed from: c */
    public String f54734c = "";

    /* renamed from: d */
    public String f54735d = "";

    /* renamed from: e */
    public String f54736e = "";

    /* renamed from: f */
    public String f54737f = "";

    /* renamed from: g */
    public String f54738g = "";

    /* renamed from: h */
    public String f54739h = "";

    /* renamed from: i */
    public String f54740i = "";

    /* renamed from: j */
    public String f54741j = "";

    /* renamed from: k */
    public Date f54742k = null;

    /* renamed from: l */
    public JumioGender f54743l = null;

    /* renamed from: m */
    public EyeColor f54744m = null;

    /* renamed from: n */
    public String f54745n = "";

    /* renamed from: o */
    public String f54746o = "";

    /* renamed from: p */
    public String f54747p = "";

    /* renamed from: q */
    public String f54748q = "";

    /* renamed from: r */
    public String f54749r = "";

    /* renamed from: s */
    public String f54750s = "";

    /* renamed from: t */
    public String f54751t = "";

    /* renamed from: u */
    public final StringBuilder f54752u = new StringBuilder();

    /* renamed from: a */
    public final String mo162710a(String str) {
        if (!(str == null || str.length() == 0)) {
            String trim = str.replace(",", " ").trim();
            if (trim.equalsIgnoreCase("none") || trim.equalsIgnoreCase("unavl")) {
                return "";
            }
            return trim;
        }
        return "";
    }

    public void addUnparsedData(String str, String str2) {
        StringBuilder sb = this.f54752u;
        sb.append(str);
        sb.append(str2);
    }

    public String getAddressCity() {
        return this.f54748q;
    }

    public String getAddressState() {
        return this.f54749r;
    }

    public String getAddressStreet1() {
        return this.f54746o;
    }

    public String getAddressStreet2() {
        return this.f54747p;
    }

    public String getAddressZip() {
        return this.f54750s;
    }

    public Date getDateOfBirth() {
        return this.f54742k;
    }

    public String getEndorsementCodes() {
        return this.f54737f;
    }

    public Date getExpiryDate() {
        return this.f54733b;
    }

    public EyeColor getEyeColor() {
        return this.f54744m;
    }

    public String getFirstName() {
        return this.f54738g;
    }

    public JumioGender getGender() {
        return this.f54743l;
    }

    public String getHeight() {
        return this.f54745n;
    }

    public String getIdNumber() {
        return this.f54751t;
    }

    public Date getIssueDate() {
        return this.f54732a;
    }

    public String getIssuingCountry() {
        return this.f54734c;
    }

    public String getLastName() {
        return this.f54739h;
    }

    public String getMiddleName() {
        return this.f54740i;
    }

    public String getNameSuffix() {
        return this.f54741j;
    }

    public String getRestrictionCodes() {
        return this.f54736e;
    }

    public StringBuilder getUnparsedData() {
        return this.f54752u;
    }

    public String getVehicleClass() {
        return this.f54735d;
    }

    public void setAddressCity(String str) {
        this.f54748q = mo162710a(str);
    }

    public void setAddressState(String str) {
        this.f54749r = mo162710a(str);
    }

    public void setAddressStreet1(String str) {
        this.f54746o = mo162710a(str);
    }

    public void setAddressStreet2(String str) {
        this.f54747p = mo162710a(str);
    }

    public void setAddressZip(String str) {
        this.f54750s = mo162710a(str);
    }

    public void setDateOfBirth(Date date) {
        this.f54742k = date;
    }

    public void setEndorsementCodes(String str) {
        if (str != null && !str.trim().equals("")) {
            this.f54737f = str.trim();
        }
    }

    public void setExpiryDate(Date date) {
        this.f54733b = date;
    }

    public void setEyeColor(EyeColor eyeColor) {
        if (eyeColor != null) {
            this.f54744m = eyeColor;
        }
    }

    public void setFirstName(String str) {
        this.f54738g = mo162710a(str.trim());
    }

    public void setGender(JumioGender jumioGender) {
        if (jumioGender != null) {
            this.f54743l = jumioGender;
        }
    }

    public void setHeight(String str) {
        if (str != null && !str.trim().equals("")) {
            this.f54745n = str.trim();
        }
    }

    public void setIdNumber(String str) {
        this.f54751t = mo162710a(str);
    }

    public void setIssueDate(Date date) {
        this.f54732a = date;
    }

    public void setIssuingCountry(String str) {
        this.f54734c = mo162710a(str);
    }

    public void setLastName(String str) {
        this.f54739h = mo162710a(str.trim());
    }

    public void setMiddleName(String str) {
        this.f54740i = mo162710a(str.trim());
    }

    public void setNameSuffix(String str) {
        this.f54741j = mo162710a(str.trim());
    }

    public void setRestrictionCodes(String str) {
        if (str != null && !str.trim().equals("")) {
            this.f54736e = str.trim();
        }
    }

    public void setVehicleClass(String str) {
        if (str != null && !str.trim().equals("")) {
            this.f54735d = str.trim();
        }
    }

    public String toString(String str) {
        StringBuilder sb = new StringBuilder();
        if (this.f54732a != null) {
            sb.append("issueDate: ");
            sb.append(this.f54732a.toString());
            sb.append(str);
        }
        if (this.f54733b != null) {
            sb.append("expiryDate: ");
            sb.append(this.f54733b.toString());
            sb.append(str);
        }
        String str2 = this.f54734c;
        if (str2 != null && !str2.equals("")) {
            sb.append("issuingCountry: ");
            sb.append(this.f54734c);
            sb.append(str);
        }
        String str3 = this.f54735d;
        if (str3 != null && !str3.equals("")) {
            sb.append("vehicleClass: ");
            sb.append(this.f54735d);
            sb.append(str);
        }
        String str4 = this.f54736e;
        if (str4 != null && !str4.equals("")) {
            sb.append("restrictionCodes: ");
            sb.append(this.f54736e);
            sb.append(str);
        }
        String str5 = this.f54737f;
        if (str5 != null && !str5.equals("")) {
            sb.append("endorsementCodes: ");
            sb.append(this.f54737f);
            sb.append(str);
        }
        String str6 = this.f54738g;
        if (str6 != null && !str6.equals("")) {
            sb.append("firstName: ");
            sb.append(this.f54738g);
            sb.append(str);
        }
        String str7 = this.f54739h;
        if (str7 != null && !str7.equals("")) {
            sb.append("lastName: ");
            sb.append(this.f54739h);
            sb.append(str);
        }
        String str8 = this.f54740i;
        if (str8 != null && !str8.equals("")) {
            sb.append("middleName: ");
            sb.append(this.f54740i);
            sb.append(str);
        }
        if (this.f54742k != null) {
            sb.append("dateOfBirth: ");
            sb.append(this.f54742k);
            sb.append(str);
        }
        if (this.f54743l != null) {
            sb.append("sex: ");
            sb.append(this.f54743l.name());
            sb.append(str);
        }
        if (this.f54744m != null) {
            sb.append("eyeColor: ");
            sb.append(this.f54744m);
            sb.append(str);
        }
        String str9 = this.f54745n;
        if (str9 != null && !str9.equals("")) {
            sb.append("height: ");
            sb.append(this.f54745n);
            sb.append(str);
        }
        String str10 = this.f54746o;
        if (str10 != null && !str10.equals("")) {
            sb.append("addressStreet1: ");
            sb.append(this.f54746o);
            sb.append(str);
        }
        String str11 = this.f54747p;
        if (str11 != null && !str11.equals("")) {
            sb.append("addressStreet2: ");
            sb.append(this.f54747p);
            sb.append(str);
        }
        String str12 = this.f54748q;
        if (str12 != null && !str12.equals("")) {
            sb.append("addressCity: ");
            sb.append(this.f54748q);
            sb.append(str);
        }
        String str13 = this.f54749r;
        if (str13 != null && !str13.equals("")) {
            sb.append("addressState: ");
            sb.append(this.f54749r);
            sb.append(str);
        }
        String str14 = this.f54750s;
        if (str14 != null && !str14.equals("")) {
            sb.append("addressZip: ");
            sb.append(this.f54750s);
            sb.append(str);
        }
        String str15 = this.f54751t;
        if (str15 != null && !str15.equals("")) {
            sb.append("idNumber: ");
            sb.append(this.f54751t);
        }
        return sb.toString();
    }

    public String toString() {
        return toString(", ");
    }
}
