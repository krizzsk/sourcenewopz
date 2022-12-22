package com.cardinalcommerce.p060a;

import android.os.Build;
import com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;
import com.google.common.net.HttpHeaders;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.cardinalcommerce.a.getSDKVersion */
public final class getSDKVersion extends setKeyListener {

    /* renamed from: b */
    private static final CardinalRenderType f2575b = CardinalRenderType.cca_continue();

    /* renamed from: c */
    private static int f2576c = 0;

    /* renamed from: d */
    private static int f2577d = 1;

    /* renamed from: a */
    private getWarnings f2578a;

    static {
        int i = f2576c;
        int i2 = (i ^ 41) + ((i & 41) << 1);
        f2577d = i2 % 128;
        int i3 = i2 % 2;
    }

    public getSDKVersion(getWarnings getwarnings, C1990configure configure, int i) throws JSONException, InvalidInputException {
        if (configure != null) {
            this.f2578a = getwarnings;
            setBaseline setbaseline = configure.Cardinal.Cardinal;
            CardinalRenderType cardinalRenderType = f2575b;
            StringBuilder sb = new StringBuilder("Creating device fingerprint JSON with referenceId : ");
            sb.append(setbaseline.getInstance);
            cardinalRenderType.init("CardinalInit", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(setbaseline.Cardinal);
            sb2.append("/V2/Browser/SaveBrowserData");
            String obj = sb2.toString();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ReferenceId", setbaseline.getInstance);
            jSONObject.put("OrgUnitId", setbaseline.cca_continue);
            jSONObject.put(HttpHeaders.ORIGIN, "CardinalMobileSdk_Android");
            jSONObject.put("DeviceChannel", "SDK");
            jSONObject.put("Fingerprint", Build.FINGERPRINT);
            jSONObject.put("UserAgent", Build.BRAND);
            jSONObject.put("ThreatMetrixEnabled", setbaseline.init);
            jSONObject.put("ThreatMetrixEventType", setbaseline.configure);
            setProgress.Cardinal();
            jSONObject.put("NativeData", setProgress.getInstance.Cardinal());
            super.configure(obj, jSONObject.toString(), i);
            f2575b.init("CardinalInit", "DF task initialized");
            return;
        }
        CardinalRenderType cardinalRenderType2 = f2575b;
        CardinalError cardinalError = new CardinalError(10204);
        cardinalRenderType2.configure(String.valueOf(cardinalError.Cardinal), cardinalError.init, (String) null);
        throw new InvalidInputException("API Call", new Throwable("Invalid Input Exception"));
    }

    public final void cca_continue(String str) {
        int i = f2576c + 121;
        f2577d = i % 128;
        int i2 = i % 2;
        f2575b.init("CardinalInit", "LASSO Save Successful");
        this.f2578a.Cardinal();
        int i3 = f2577d;
        int i4 = i3 & 117;
        int i5 = (i3 | 117) & (~i4);
        int i6 = i4 << 1;
        int i7 = ((i5 | i6) << 1) - (i5 ^ i6);
        f2576c = i7 % 128;
        if ((i7 % 2 != 0 ? 'S' : 'G') != 'G') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public final void getInstance(String str, int i) {
        CardinalError cardinalError = new CardinalError(i, str);
        f2575b.configure(String.valueOf(cardinalError.Cardinal), cardinalError.init, (String) null);
        this.f2578a.cca_continue(cardinalError);
        int i2 = f2577d + 60;
        int i3 = (i2 & -1) + (i2 | -1);
        f2576c = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void cca_continue(Exception exc, setMin setmin) {
        CardinalRenderType cardinalRenderType = f2575b;
        CardinalError cardinalError = new CardinalError(10218, exc.getLocalizedMessage());
        String str = null;
        cardinalRenderType.configure(String.valueOf(cardinalError.Cardinal), cardinalError.init, str);
        this.f2578a.cca_continue(new CardinalError(10218));
        int i = f2576c;
        int i2 = (((i & 86) + (i | 86)) + 0) - 1;
        f2577d = i2 % 128;
        if ((i2 % 2 == 0 ? 'E' : 9) != 9) {
            super.hashCode();
        }
    }
}
