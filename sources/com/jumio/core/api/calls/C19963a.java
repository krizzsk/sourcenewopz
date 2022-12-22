package com.jumio.core.api.calls;

import com.google.common.base.Ascii;
import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringDeobfuscator;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.network.C20000d;
import com.jumio.sdk.result.JumioCredentialResult;
import com.jumio.sdk.result.JumioIDResult;
import java.util.HashMap;
import java.util.Iterator;
import jumio.core.C21351f;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.jumio.core.api.calls.a */
/* compiled from: ExtractDataCall.kt */
public final class C19963a extends C20000d<HashMap<String, JumioCredentialResult>> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C19963a(C21351f fVar, ApiCallDataModel<?> apiCallDataModel) {
        super(fVar, apiCallDataModel);
        Intrinsics.checkNotNullParameter(fVar, "apiCallSettings");
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
    }

    /* renamed from: a */
    public final String mo162596a(String str) {
        if (str != null) {
            if (!(str.length() > 0) || Intrinsics.areEqual((Object) JSONObject.NULL.toString(), (Object) str)) {
                return null;
            }
            return str;
        }
        return null;
    }

    /* renamed from: b */
    public HashMap<String, JumioCredentialResult> parseResponse(String str) {
        Intrinsics.checkNotNullParameter(str, "plainTextAnswer");
        HashMap<String, JumioCredentialResult> hashMap = new HashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            Intrinsics.checkNotNullExpressionValue(keys, "result.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                JumioIDResult jumioIDResult = new JumioIDResult();
                jumioIDResult.setIssuingCountry(mo162596a(jSONObject2.optString("issuingCountry")));
                jumioIDResult.setIdType(mo162596a(jSONObject2.optString("idType")));
                jumioIDResult.setFirstName(mo162596a(jSONObject2.optString("firstName")));
                jumioIDResult.setLastName(mo162596a(jSONObject2.optString("lastName")));
                jumioIDResult.setDateOfBirth(mo162596a(jSONObject2.optString("dateOfBirth")));
                jumioIDResult.setIssuingDate(mo162596a(jSONObject2.optString("issuingDate")));
                jumioIDResult.setExpiryDate(mo162596a(jSONObject2.optString("expiryDate")));
                jumioIDResult.setDocumentNumber(mo162596a(jSONObject2.optString("documentNumber")));
                jumioIDResult.setPersonalNumber(mo162596a(jSONObject2.optString("personalNumber")));
                jumioIDResult.setGender(mo162596a(jSONObject2.optString("gender")));
                jumioIDResult.setNationality(mo162596a(jSONObject2.optString("nationality")));
                jumioIDResult.setPlaceOfBirth(mo162596a(jSONObject2.optString("placeOfBirth")));
                jumioIDResult.setCountry(mo162596a(jSONObject2.optString("country")));
                jumioIDResult.setAddress(mo162596a(jSONObject2.optString("address")));
                jumioIDResult.setCity(mo162596a(jSONObject2.optString("city")));
                jumioIDResult.setSubdivision(mo162596a(jSONObject2.optString("subdivision")));
                jumioIDResult.setPostalCode(mo162596a(jSONObject2.optString("postalCode")));
                jumioIDResult.setMrzLine1(mo162596a(jSONObject2.optString("mrzLine1")));
                jumioIDResult.setMrzLine2(mo162596a(jSONObject2.optString("mrzLine2")));
                jumioIDResult.setMrzLine3(mo162596a(jSONObject2.optString("mrzLine3")));
                jumioIDResult.setRawBarcodeData(mo162596a(jSONObject2.optString("rawBarcodeData")));
                hashMap.put(next, jumioIDResult);
            }
        } catch (Exception e) {
            Log.m39477w(this.TAG, "Exception", (Throwable) e);
        }
        return hashMap;
    }

    public String getRequest() throws Exception {
        return "";
    }

    public String getUri() {
        return StringDeobfuscator.deobfuscate(new byte[]{101, -35, -99, -103, -74, 101, -119, -9, 114, 4, -53, 7, 35, 94, 39, -23, Ascii.CAN, 5, 82, 40}, 1493473626205255869L);
    }
}
