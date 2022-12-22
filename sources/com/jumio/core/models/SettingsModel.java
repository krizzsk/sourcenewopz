package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.commons.log.Log;
import com.jumio.core.data.country.Country;
import com.jumio.core.data.document.DocumentType;
import com.jumio.core.model.StaticModel;
import com.jumio.core.network.ErrorMock;
import com.jumio.core.provider.IproovProvider;
import com.jumio.sdk.util.IsoCountryConverter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import jumio.core.C21363k;
import jumio.core.C21378r0;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\"\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\t¢\u0006\u0006\b\u0001\u0010\u0001J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007R$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0016\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R(\u0010\u001c\u001a\u0004\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u00178\u0006@BX\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0015R$\u0010!\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0015R(\u0010$\u001a\u0004\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u00178\u0006@BX\u000e¢\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001bR(\u0010'\u001a\u0004\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u00178\u0016@RX\u000e¢\u0006\f\n\u0004\b%\u0010\u0019\u001a\u0004\b&\u0010\u001bR$\u0010)\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010\u0015R\u0019\u0010/\u001a\u00020*8\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R$\u00101\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b0\u0010\u0013\u001a\u0004\b1\u0010\u0015R$\u00103\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b2\u0010\u0013\u001a\u0004\b3\u0010\u0015R$\u00109\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0006@BX\u000e¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R$\u0010;\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\b:\u0010\u0013\u001a\u0004\b;\u0010\u0015R$\u0010>\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0006@BX\u000e¢\u0006\f\n\u0004\b<\u00106\u001a\u0004\b=\u00108R$\u0010A\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\b?\u00106\u001a\u0004\b@\u00108R$\u0010C\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00078\u0006@BX\u000e¢\u0006\f\n\u0004\bB\u0010\u0013\u001a\u0004\bC\u0010\u0015R$\u0010I\u001a\u00020D2\u0006\u0010\f\u001a\u00020D8\u0006@BX\u000e¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR$\u0010O\u001a\u00020J2\u0006\u0010\f\u001a\u00020J8\u0006@BX\u000e¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR4\u0010U\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010P2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010P8\u0016@RX\u000e¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR(\u0010X\u001a\u0004\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u00178\u0016@RX\u000e¢\u0006\f\n\u0004\bV\u0010\u0019\u001a\u0004\bW\u0010\u001bR(\u0010[\u001a\u0004\u0018\u00010\u00172\b\u0010\f\u001a\u0004\u0018\u00010\u00178\u0006@BX\u000e¢\u0006\f\n\u0004\bY\u0010\u0019\u001a\u0004\bZ\u0010\u001bR$\u0010^\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0006@BX\u000e¢\u0006\f\n\u0004\b\\\u00106\u001a\u0004\b]\u00108R$\u0010a\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0006@BX\u000e¢\u0006\f\n\u0004\b_\u00106\u001a\u0004\b`\u00108R$\u0010g\u001a\u00020b2\u0006\u0010\f\u001a\u00020b8\u0006@BX\u000e¢\u0006\f\n\u0004\bc\u0010d\u001a\u0004\be\u0010fR$\u0010j\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u00178\u0006@BX\u000e¢\u0006\f\n\u0004\bh\u0010\u0019\u001a\u0004\bi\u0010\u001bR$\u0010m\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\bk\u00106\u001a\u0004\bl\u00108R$\u0010p\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\bn\u00106\u001a\u0004\bo\u00108R$\u0010s\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\bq\u00106\u001a\u0004\br\u00108R$\u0010v\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\bt\u00106\u001a\u0004\bu\u00108R$\u0010x\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\bF\u00106\u001a\u0004\bw\u00108R$\u0010{\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\by\u00106\u001a\u0004\bz\u00108R$\u0010}\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\bL\u00106\u001a\u0004\b|\u00108R%\u0010\u0001\u001a\u0002042\u0006\u0010\f\u001a\u0002048\u0016@RX\u000e¢\u0006\f\n\u0004\b~\u00106\u001a\u0004\b\u00108R\u0018\u0010\u0001\u001a\u00020\u00078V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010\u0015¨\u0006\u0001"}, mo175978d2 = {"Lcom/jumio/core/models/SettingsModel;", "Lcom/jumio/core/model/StaticModel;", "Lcom/jumio/core/provider/IproovProvider;", "Ljumio/core/k;", "Ljumio/core/r0;", "Lorg/json/JSONObject;", "json", "", "localize", "", "fromJson", "Ljava/util/Date;", "<set-?>", "a", "Ljava/util/Date;", "getServerTimestamp", "()Ljava/util/Date;", "serverTimestamp", "b", "Z", "getHasBarcodeScannerKey", "()Z", "hasBarcodeScannerKey", "", "c", "Ljava/lang/String;", "getBarcodeScannerKey", "()Ljava/lang/String;", "barcodeScannerKey", "d", "isBrandingEnabled", "e", "getReturnImages", "returnImages", "f", "getCountryForIp", "countryForIp", "g", "getStateForIp", "stateForIp", "h", "isAdditionalDataPointsEnabled", "Lcom/jumio/core/models/CountryDocumentModel;", "i", "Lcom/jumio/core/models/CountryDocumentModel;", "getCountryModel", "()Lcom/jumio/core/models/CountryDocumentModel;", "countryModel", "j", "isLoaded", "k", "isAnalyticsEnabled", "", "l", "I", "getMaxLivenessImages", "()I", "maxLivenessImages", "m", "isInstantFeedbackEnabled", "n", "getAutomationMaxRetries", "automationMaxRetries", "o", "getIproovMaxAttempts", "iproovMaxAttempts", "p", "isCvAnalytics", "", "q", "D", "getCvMrzThreshold", "()D", "cvMrzThreshold", "", "r", "F", "getFocusScore", "()F", "focusScore", "", "s", "Ljava/util/List;", "getConsentStates", "()Ljava/util/List;", "consentStates", "t", "getConsentUrl", "consentUrl", "u", "getDataPrivacyUrl", "dataPrivacyUrl", "v", "getNfcRetries", "nfcRetries", "w", "getNfcTimeout", "nfcTimeout", "Lcom/jumio/core/models/DataDogModel;", "x", "Lcom/jumio/core/models/DataDogModel;", "getDataDog", "()Lcom/jumio/core/models/DataDogModel;", "dataDog", "y", "getWorkflowDefinitionKey", "workflowDefinitionKey", "z", "getUpload", "upload", "A", "getUsability", "usability", "B", "getFinalize", "finalize", "C", "getExtractdata", "extractdata", "getAnalytics", "analytics", "E", "getReporting", "reporting", "getIproovtoken", "iproovtoken", "G", "getIproovvalidate", "iproovvalidate", "isConsentRequired", "<init>", "()V", "jumio-core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
@PersistWith("SettingsModel")
/* compiled from: SettingsModel.kt */
public final class SettingsModel implements StaticModel, IproovProvider, C21363k, C21378r0 {

    /* renamed from: A */
    public int f54856A = 15000;

    /* renamed from: B */
    public int f54857B = 10000;

    /* renamed from: C */
    public int f54858C = 20000;

    /* renamed from: D */
    public int f54859D = 10000;

    /* renamed from: E */
    public int f54860E = 10000;

    /* renamed from: F */
    public int f54861F = 15000;

    /* renamed from: G */
    public int f54862G = 10000;

    /* renamed from: a */
    public Date f54863a = new Date();

    /* renamed from: b */
    public boolean f54864b;

    /* renamed from: c */
    public String f54865c;

    /* renamed from: d */
    public boolean f54866d = true;

    /* renamed from: e */
    public boolean f54867e;

    /* renamed from: f */
    public String f54868f;

    /* renamed from: g */
    public String f54869g;

    /* renamed from: h */
    public boolean f54870h;

    /* renamed from: i */
    public final CountryDocumentModel f54871i = new CountryDocumentModel();

    /* renamed from: j */
    public boolean f54872j;

    /* renamed from: k */
    public boolean f54873k;

    /* renamed from: l */
    public int f54874l;

    /* renamed from: m */
    public boolean f54875m;

    /* renamed from: n */
    public int f54876n;

    /* renamed from: o */
    public int f54877o;

    /* renamed from: p */
    public boolean f54878p;

    /* renamed from: q */
    public double f54879q = 0.9d;

    /* renamed from: r */
    public float f54880r = -1.0f;

    /* renamed from: s */
    public List<String> f54881s;

    /* renamed from: t */
    public String f54882t;

    /* renamed from: u */
    public String f54883u;

    /* renamed from: v */
    public int f54884v = 1;

    /* renamed from: w */
    public int f54885w = 10000;

    /* renamed from: x */
    public DataDogModel f54886x = new DataDogModel((String) null, (String) null, 3, (DefaultConstructorMarker) null);

    /* renamed from: y */
    public String f54887y = "";

    /* renamed from: z */
    public int f54888z = 20000;

    /* renamed from: a */
    public final void mo162951a(JSONObject jSONObject) throws JSONException {
        int i;
        float f;
        boolean z;
        String str = null;
        String optString = jSONObject.optString("barcodeScannerKey", (String) null);
        this.f54865c = optString;
        this.f54864b = !(optString == null || optString.length() == 0);
        try {
            i = jSONObject.optInt("iproovMaxAttempts", 3);
        } catch (Exception unused) {
            i = 0;
        }
        this.f54877o = i;
        try {
            f = (float) jSONObject.getDouble("focusScore");
        } catch (Exception unused2) {
            f = -1.0f;
        }
        this.f54880r = f;
        try {
            z = jSONObject.optBoolean("cvAnalytics", false);
        } catch (Exception unused3) {
            z = false;
        }
        this.f54878p = z;
        double d = 0.9d;
        try {
            d = jSONObject.optDouble("cvMrzThreshold", 0.9d);
        } catch (Exception unused4) {
        }
        this.f54879q = d;
        try {
            this.f54875m = jSONObject.getBoolean("instantFeedback");
            this.f54876n = jSONObject.getInt("maxRetries");
        } catch (Exception unused5) {
            this.f54875m = false;
            this.f54876n = 2;
        }
        try {
            String string = jSONObject.getString("consentRequired");
            Intrinsics.checkNotNullExpressionValue(string, "configuration.getString(\"consentRequired\")");
            this.f54881s = new Regex(",").split(string, 0);
            this.f54882t = jSONObject.getString("consentURL");
        } catch (Exception unused6) {
            this.f54881s = null;
            this.f54882t = null;
        }
        try {
            str = jSONObject.getString("dataPrivacyUrl");
        } catch (Exception unused7) {
        }
        this.f54883u = str;
        try {
            this.f54884v = jSONObject.getInt("nfcRetries");
            this.f54885w = jSONObject.getInt("nfcTimeout");
        } catch (Exception unused8) {
            this.f54884v = 1;
            this.f54885w = 10000;
        }
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("dataDog");
            DataDogModel dataDogModel = this.f54886x;
            String string2 = jSONObject2.getString("appId");
            Intrinsics.checkNotNullExpressionValue(string2, "dataDogModelJson.getString(\"appId\")");
            dataDogModel.setAppId(string2);
            DataDogModel dataDogModel2 = this.f54886x;
            String string3 = jSONObject2.getString("clientId");
            Intrinsics.checkNotNullExpressionValue(string3, "dataDogModelJson.getString(\"clientId\")");
            dataDogModel2.setClientId(string3);
        } catch (Exception unused9) {
        }
        try {
            JSONObject jSONObject3 = jSONObject.getJSONObject("networkTimeouts");
            this.f54888z = jSONObject3.optInt("upload", 20000);
            this.f54856A = jSONObject3.optInt("usability", 15000);
            this.f54857B = jSONObject3.optInt("finalize", 10000);
            this.f54858C = jSONObject3.optInt("extractdata", 20000);
            this.f54859D = jSONObject3.optInt("analytics", 10000);
            this.f54860E = jSONObject3.optInt("reporting", 10000);
            this.f54861F = jSONObject3.optInt("iproovtoken", 15000);
            this.f54862G = jSONObject3.optInt("iproovvalidate", 10000);
        } catch (Exception unused10) {
        }
    }

    /* renamed from: b */
    public final Date mo162952b(JSONObject jSONObject) throws JSONException {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S'Z'", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(jSONObject.optString("timestamp"));
        } catch (Exception e) {
            Log.printStackTrace(e);
            return null;
        }
    }

    public final void fromJson(JSONObject jSONObject, boolean z) throws JSONException {
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        ErrorMock.onSettingsMock(jSONObject);
        Date b = mo162952b(jSONObject);
        if (b != null) {
            this.f54863a = b;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("configurations");
        if (optJSONObject != null) {
            mo162951a(optJSONObject);
        }
        this.f54866d = jSONObject.optBoolean("brandingEnabled", true);
        this.f54867e = jSONObject.optBoolean("returnImages", false);
        this.f54868f = jSONObject.optString("countryForIp");
        this.f54869g = jSONObject.optString("stateForIp");
        this.f54873k = jSONObject.optBoolean("analyticsEnabled", true);
        this.f54870h = jSONObject.optBoolean("additionalDataPoints", false);
        int optInt = jSONObject.optInt("maxLivenessImages", 10);
        this.f54874l = optInt;
        if (optInt < 0 || optInt > 10) {
            this.f54874l = 10;
        }
        mo162950a(jSONObject.optJSONArray("supportedCountries"), z);
        String optString = jSONObject.optString("workflowDefinitionKey", (String) null);
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"workflowDefinitionKey\", null)");
        this.f54887y = optString;
        this.f54872j = true;
    }

    public int getAnalytics() {
        return this.f54859D;
    }

    public final int getAutomationMaxRetries() {
        return this.f54876n;
    }

    public final String getBarcodeScannerKey() {
        return this.f54865c;
    }

    public List<String> getConsentStates() {
        return this.f54881s;
    }

    public String getConsentUrl() {
        return this.f54882t;
    }

    public final String getCountryForIp() {
        return this.f54868f;
    }

    public final CountryDocumentModel getCountryModel() {
        return this.f54871i;
    }

    public final double getCvMrzThreshold() {
        return this.f54879q;
    }

    public final DataDogModel getDataDog() {
        return this.f54886x;
    }

    public final String getDataPrivacyUrl() {
        return this.f54883u;
    }

    public int getExtractdata() {
        return this.f54858C;
    }

    public int getFinalize() {
        return this.f54857B;
    }

    public final float getFocusScore() {
        return this.f54880r;
    }

    public final boolean getHasBarcodeScannerKey() {
        return this.f54864b;
    }

    public int getIproovMaxAttempts() {
        return this.f54877o;
    }

    public int getIproovtoken() {
        return this.f54861F;
    }

    public int getIproovvalidate() {
        return this.f54862G;
    }

    public final int getMaxLivenessImages() {
        return this.f54874l;
    }

    public final int getNfcRetries() {
        return this.f54884v;
    }

    public final int getNfcTimeout() {
        return this.f54885w;
    }

    public int getReporting() {
        return this.f54860E;
    }

    public final boolean getReturnImages() {
        return this.f54867e;
    }

    public final Date getServerTimestamp() {
        return this.f54863a;
    }

    public String getStateForIp() {
        return this.f54869g;
    }

    public int getUpload() {
        return this.f54888z;
    }

    public int getUsability() {
        return this.f54856A;
    }

    public final String getWorkflowDefinitionKey() {
        return this.f54887y;
    }

    public final boolean isAdditionalDataPointsEnabled() {
        return this.f54870h;
    }

    public final boolean isAnalyticsEnabled() {
        return this.f54873k;
    }

    public final boolean isBrandingEnabled() {
        return this.f54866d;
    }

    public boolean isConsentRequired() {
        if (getConsentStates() != null) {
            List<String> consentStates = getConsentStates();
            Intrinsics.checkNotNull(consentStates);
            if (consentStates.size() != 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean isCvAnalytics() {
        return this.f54878p;
    }

    public final boolean isInstantFeedbackEnabled() {
        return this.f54875m;
    }

    public final boolean isLoaded() {
        return this.f54872j;
    }

    /* renamed from: a */
    public final void mo162950a(JSONArray jSONArray, boolean z) throws JSONException {
        int length;
        this.f54871i.mo162833a();
        if (jSONArray != null && jSONArray.length() != 0 && (length = jSONArray.length()) > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString("country");
                Intrinsics.checkNotNullExpressionValue(string, "jsonCountry.getString(\"country\")");
                Country country = new Country(string, z);
                if (!StringsKt.equals(country.getName(), IsoCountryConverter.convertToAlpha2(jSONObject.getString("country")), true)) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("idTypes");
                    ArrayList arrayList = new ArrayList();
                    if (optJSONArray != null) {
                        int length2 = optJSONArray.length();
                        if (length2 > 0) {
                            int i3 = 0;
                            while (true) {
                                int i4 = i3 + 1;
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                                Intrinsics.checkNotNullExpressionValue(jSONObject2, "supportedIdTypes.getJSONObject(j)");
                                arrayList.add(new DocumentType(jSONObject2));
                                if (i4 >= length2) {
                                    break;
                                }
                                i3 = i4;
                            }
                        }
                    } else {
                        JSONObject jSONObject3 = jSONObject.getJSONObject("idTypes");
                        Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonCountry.getJSONObject(\"idTypes\")");
                        arrayList.add(new DocumentType(jSONObject3));
                    }
                    if (!arrayList.isEmpty()) {
                        CollectionsKt.sort(arrayList);
                        this.f54871i.mo162834a(country, (ArrayList<DocumentType>) arrayList);
                    }
                }
                if (i2 < length) {
                    i = i2;
                } else {
                    return;
                }
            }
        }
    }
}
