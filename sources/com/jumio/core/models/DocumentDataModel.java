package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.data.country.Country;
import com.jumio.core.enums.JumioGender;
import com.jumio.core.model.StaticModel;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.result.JumioImageData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import jumio.core.C21374p0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\t¢\u0006\u0006\b\u0001\u0010\u0001J'\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002\"\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J$\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0004J$\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0019H\u0004R.\u0010 \u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R.\u0010,\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR.\u00100\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\b-\u0010\u001b\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR$\u00108\u001a\u0004\u0018\u0001018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010<\u001a\u0004\u0018\u0001018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b9\u00103\u001a\u0004\b:\u00105\"\u0004\b;\u00107R.\u0010@\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\b=\u0010\u001b\u001a\u0004\b>\u0010\u001d\"\u0004\b?\u0010\u001fR.\u0010D\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00038F@FX\u000e¢\u0006\u0012\n\u0004\bA\u0010\u001b\u001a\u0004\bB\u0010\u001d\"\u0004\bC\u0010\u001fR$\u0010H\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bE\u0010\u001b\u001a\u0004\bF\u0010\u001d\"\u0004\bG\u0010\u001fR.\u0010L\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\bI\u0010\u001b\u001a\u0004\bJ\u0010\u001d\"\u0004\bK\u0010\u001fR$\u0010P\u001a\u0004\u0018\u0001018\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bM\u00103\u001a\u0004\bN\u00105\"\u0004\bO\u00107R$\u0010X\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR.\u0010\\\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\bY\u0010\u001b\u001a\u0004\bZ\u0010\u001d\"\u0004\b[\u0010\u001fR.\u0010`\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\b]\u0010\u001b\u001a\u0004\b^\u0010\u001d\"\u0004\b_\u0010\u001fR.\u0010d\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\ba\u0010\u001b\u001a\u0004\bb\u0010\u001d\"\u0004\bc\u0010\u001fR.\u0010h\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\be\u0010\u001b\u001a\u0004\bf\u0010\u001d\"\u0004\bg\u0010\u001fR.\u0010l\u001a\u0004\u0018\u00010\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@FX\u000e¢\u0006\u0012\n\u0004\bi\u0010\u001b\u001a\u0004\bj\u0010\u001d\"\u0004\bk\u0010\u001fR$\u0010p\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bm\u0010\u001b\u001a\u0004\bn\u0010\u001d\"\u0004\bo\u0010\u001fR$\u0010t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bq\u0010\u001b\u001a\u0004\br\u0010\u001d\"\u0004\bs\u0010\u001fR$\u0010x\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bu\u0010\u001b\u001a\u0004\bv\u0010\u001d\"\u0004\bw\u0010\u001fR%\u0010\u0001\u001a\u0004\u0018\u00010y8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010¨\u0006\u0001"}, mo175978d2 = {"Lcom/jumio/core/models/DocumentDataModel;", "Lcom/jumio/core/model/StaticModel;", "", "", "names", "", "setFirstNames", "([Ljava/lang/String;)V", "getOptionalData1", "optionalData1", "setOptionalData1", "getOptionalData2", "optionalData2", "setOptionalData2", "isoCode", "", "checkCountryCode", "Lorg/json/JSONObject;", "request", "Lcom/jumio/core/models/ScanPartModel;", "scanPart", "fillRequest", "name", "value", "appendValue", "Lorg/json/JSONArray;", "a", "Ljava/lang/String;", "getSelectedCountry", "()Ljava/lang/String;", "setSelectedCountry", "(Ljava/lang/String;)V", "selectedCountry", "Lcom/jumio/sdk/document/JumioDocumentType;", "b", "Lcom/jumio/sdk/document/JumioDocumentType;", "getSelectedDocumentType", "()Lcom/jumio/sdk/document/JumioDocumentType;", "setSelectedDocumentType", "(Lcom/jumio/sdk/document/JumioDocumentType;)V", "selectedDocumentType", "c", "getIdNumber", "setIdNumber", "idNumber", "d", "getPersonalNumber", "setPersonalNumber", "personalNumber", "Ljava/util/Date;", "e", "Ljava/util/Date;", "getIssuingDate", "()Ljava/util/Date;", "setIssuingDate", "(Ljava/util/Date;)V", "issuingDate", "f", "getExpiryDate", "setExpiryDate", "expiryDate", "g", "getIssuingCountry", "setIssuingCountry", "issuingCountry", "h", "getLastName", "setLastName", "lastName", "i", "getFirstName", "setFirstName", "firstName", "j", "getNameSuffix", "setNameSuffix", "nameSuffix", "k", "getDob", "setDob", "dob", "Lcom/jumio/core/enums/JumioGender;", "l", "Lcom/jumio/core/enums/JumioGender;", "getGender", "()Lcom/jumio/core/enums/JumioGender;", "setGender", "(Lcom/jumio/core/enums/JumioGender;)V", "gender", "m", "getOriginatingCountry", "setOriginatingCountry", "originatingCountry", "n", "getAddressLine", "setAddressLine", "addressLine", "o", "getCity", "setCity", "city", "p", "getSubdivision", "setSubdivision", "subdivision", "q", "getPostCode", "setPostCode", "postCode", "r", "getOptData1", "setOptData1", "optData1", "s", "getOptData2", "setOptData2", "optData2", "t", "getPlaceOfBirth", "setPlaceOfBirth", "placeOfBirth", "Lcom/jumio/sdk/result/JumioImageData;", "u", "Lcom/jumio/sdk/result/JumioImageData;", "getImageData", "()Lcom/jumio/sdk/result/JumioImageData;", "setImageData", "(Lcom/jumio/sdk/result/JumioImageData;)V", "imageData", "<init>", "()V", "Companion", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
@PersistWith("DocumentDataModel")
/* compiled from: DocumentDataModel.kt */
public class DocumentDataModel implements StaticModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    public String f54815a;

    /* renamed from: b */
    public JumioDocumentType f54816b;

    /* renamed from: c */
    public String f54817c;

    /* renamed from: d */
    public String f54818d;

    /* renamed from: e */
    public Date f54819e;

    /* renamed from: f */
    public Date f54820f;

    /* renamed from: g */
    public String f54821g;

    /* renamed from: h */
    public String f54822h;

    /* renamed from: i */
    public String f54823i;

    /* renamed from: j */
    public String f54824j;

    /* renamed from: k */
    public Date f54825k;

    /* renamed from: l */
    public JumioGender f54826l;

    /* renamed from: m */
    public String f54827m;

    /* renamed from: n */
    public String f54828n;

    /* renamed from: o */
    public String f54829o;

    /* renamed from: p */
    public String f54830p;

    /* renamed from: q */
    public String f54831q;

    /* renamed from: r */
    public String f54832r;

    /* renamed from: s */
    public String f54833s;

    /* renamed from: t */
    public String f54834t;

    /* renamed from: u */
    public JumioImageData f54835u;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, mo175978d2 = {"Lcom/jumio/core/models/DocumentDataModel$Companion;", "", "", "REGEX_ALPHANUMERICAL", "Ljava/lang/String;", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: DocumentDataModel.kt */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void appendValue(JSONObject jSONObject, String str, String str2) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "request");
        if (str2 != null) {
            if (!(str2.length() == 0)) {
                jSONObject.put(str, str2);
            }
        }
    }

    public boolean checkCountryCode(String str) {
        if (str != null) {
            if (!(str.length() == 0)) {
                return !StringsKt.equals(new Country(str, false, 2, (DefaultConstructorMarker) null).getName(), str, true);
            }
        }
        return false;
    }

    public void fillRequest(JSONObject jSONObject, ScanPartModel scanPartModel) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "request");
        Intrinsics.checkNotNullParameter(scanPartModel, "scanPart");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        appendValue(jSONObject, "firstName", this.f54823i);
        appendValue(jSONObject, "lastName", getLastName());
        appendValue(jSONObject, "personalNumber", this.f54818d);
        appendValue(jSONObject, "number", this.f54817c);
        Date date = this.f54819e;
        String str = null;
        appendValue(jSONObject, "issuingDate", date == null ? null : simpleDateFormat.format(date));
        Date date2 = this.f54825k;
        appendValue(jSONObject, "dob", date2 == null ? null : simpleDateFormat.format(date2));
        Date date3 = this.f54820f;
        if (date3 != null) {
            str = simpleDateFormat.format(date3);
        }
        appendValue(jSONObject, "expiry", str);
        appendValue(jSONObject, "country", this.f54827m);
        appendValue(jSONObject, "optionalData1", this.f54832r);
        appendValue(jSONObject, "optionalData2", this.f54833s);
        appendValue(jSONObject, "extractionSide", scanPartModel.getSide().name());
        JSONObject jSONObject2 = new JSONObject();
        appendValue(jSONObject2, "city", this.f54829o);
        appendValue(jSONObject2, "subdivision", this.f54830p);
        appendValue(jSONObject2, "addressLine", C21374p0.f59668a.mo175868a(this.f54828n, 100));
        appendValue(jSONObject2, "postCode", this.f54831q);
        jSONObject.put("address", jSONObject2);
    }

    public final String getAddressLine() {
        return this.f54828n;
    }

    public final String getCity() {
        return this.f54829o;
    }

    public final Date getDob() {
        return this.f54825k;
    }

    public final Date getExpiryDate() {
        return this.f54820f;
    }

    public final String getFirstName() {
        return this.f54823i;
    }

    public final JumioGender getGender() {
        return this.f54826l;
    }

    public final String getIdNumber() {
        return this.f54817c;
    }

    public final JumioImageData getImageData() {
        return this.f54835u;
    }

    public final String getIssuingCountry() {
        return this.f54821g;
    }

    public final Date getIssuingDate() {
        return this.f54819e;
    }

    public final String getLastName() {
        String str = this.f54822h;
        String str2 = this.f54824j;
        if (str2 == null) {
            return str;
        }
        if ((str2 != null && str2.length() == 0) || str == null) {
            return str;
        }
        String str3 = this.f54824j;
        Intrinsics.checkNotNull(str3);
        if (StringsKt.endsWith$default(str, str3, false, 2, (Object) null)) {
            return str;
        }
        return this.f54822h + ' ' + this.f54824j;
    }

    public final String getNameSuffix() {
        return this.f54824j;
    }

    public final String getOptData1() {
        return this.f54832r;
    }

    public final String getOptData2() {
        return this.f54833s;
    }

    public String getOptionalData1() {
        return this.f54832r;
    }

    public String getOptionalData2() {
        return this.f54833s;
    }

    public final String getOriginatingCountry() {
        return this.f54827m;
    }

    public final String getPersonalNumber() {
        return this.f54818d;
    }

    public final String getPlaceOfBirth() {
        return this.f54834t;
    }

    public final String getPostCode() {
        return this.f54831q;
    }

    public final String getSelectedCountry() {
        return this.f54815a;
    }

    public final JumioDocumentType getSelectedDocumentType() {
        return this.f54816b;
    }

    public final String getSubdivision() {
        return this.f54830p;
    }

    public final void setAddressLine(String str) {
        this.f54828n = C21374p0.f59668a.mo175868a(str, 255);
    }

    public final void setCity(String str) {
        this.f54829o = C21374p0.f59668a.mo175868a(str, 64);
    }

    public final void setDob(Date date) {
        this.f54825k = date;
    }

    public final void setExpiryDate(Date date) {
        this.f54820f = date;
    }

    public final void setFirstName(String str) {
        this.f54823i = str;
    }

    public void setFirstNames(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "names");
        StringBuilder sb = new StringBuilder();
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str = strArr[i];
            i++;
            if (str != null) {
                sb.append(str);
                sb.append(" ");
            }
        }
        this.f54823i = C21374p0.f59668a.mo175868a(sb.toString(), 100);
    }

    public final void setGender(JumioGender jumioGender) {
        this.f54826l = jumioGender;
    }

    public final void setIdNumber(String str) {
        this.f54817c = C21374p0.f59668a.mo175868a(str, 100);
    }

    public final void setImageData(JumioImageData jumioImageData) {
        this.f54835u = jumioImageData;
    }

    public final void setIssuingCountry(String str) {
        String a = C21374p0.f59668a.mo175869a(str, 3, "[A-Z]{3}");
        this.f54821g = a;
        if (!checkCountryCode(a)) {
            this.f54821g = null;
        }
    }

    public final void setIssuingDate(Date date) {
        this.f54819e = date;
    }

    public final void setLastName(String str) {
        this.f54822h = C21374p0.f59668a.mo175868a(str, 100);
    }

    public final void setNameSuffix(String str) {
        this.f54824j = C21374p0.f59668a.mo175868a(str, 100);
    }

    public final void setOptData1(String str) {
        this.f54832r = str;
    }

    public final void setOptData2(String str) {
        this.f54833s = str;
    }

    public void setOptionalData1(String str) {
        this.f54832r = C21374p0.f59668a.mo175869a(str, 50, "^[A-Z0-9]*$");
    }

    public void setOptionalData2(String str) {
        this.f54833s = C21374p0.f59668a.mo175869a(str, 50, "^[A-Z0-9]*$");
    }

    public final void setOriginatingCountry(String str) {
        String a = C21374p0.f59668a.mo175869a(str, 3, "[A-Z]{3}");
        this.f54827m = a;
        if (!checkCountryCode(a)) {
            this.f54827m = null;
        }
    }

    public final void setPersonalNumber(String str) {
        this.f54818d = C21374p0.f59668a.mo175869a(str, 14, "^[A-Z0-9]*$");
    }

    public final void setPlaceOfBirth(String str) {
        this.f54834t = str;
    }

    public final void setPostCode(String str) {
        this.f54831q = C21374p0.f59668a.mo175868a(str, 15);
    }

    public final void setSelectedCountry(String str) {
        this.f54815a = C21374p0.f59668a.mo175868a(str, 3);
    }

    public final void setSelectedDocumentType(JumioDocumentType jumioDocumentType) {
        this.f54816b = jumioDocumentType;
    }

    public final void setSubdivision(String str) {
        this.f54830p = C21374p0.f59668a.mo175868a(str, 64);
    }

    public final void appendValue(JSONObject jSONObject, String str, JSONArray jSONArray) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "request");
        if (jSONArray != null && jSONArray.length() != 0) {
            jSONObject.put(str, jSONArray);
        }
    }
}
