package com.cardinalcommerce.cardinalmobilesdk.models;

import com.cardinalcommerce.cardinalmobilesdk.enums.CardinalEnvironment;
import com.cardinalcommerce.cardinalmobilesdk.enums.CardinalUiType;
import com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError;
import com.cardinalcommerce.p060a.CardinalRenderType;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;
import com.cardinalcommerce.shared.userinterfaces.UiCustomization;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CardinalConfigurationParameters {

    /* renamed from: a */
    private int f3121a = 8000;

    /* renamed from: b */
    private int f3122b = 5;

    /* renamed from: c */
    private String f3123c = "";

    /* renamed from: d */
    private CardinalUiType f3124d = CardinalUiType.BOTH;

    /* renamed from: e */
    private JSONArray f3125e;

    /* renamed from: f */
    private CardinalEnvironment f3126f = CardinalEnvironment.PRODUCTION;

    /* renamed from: g */
    private String f3127g = "";

    /* renamed from: h */
    private UiCustomization f3128h = new UiCustomization();

    /* renamed from: i */
    private boolean f3129i = true;

    /* renamed from: j */
    private final CardinalRenderType f3130j = CardinalRenderType.cca_continue();

    /* renamed from: k */
    private boolean f3131k = true;

    /* renamed from: l */
    private boolean f3132l = false;

    public CardinalConfigurationParameters() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(com.cardinalcommerce.cardinalmobilesdk.enums.CardinalRenderType.OTP);
        jSONArray.put(com.cardinalcommerce.cardinalmobilesdk.enums.CardinalRenderType.SINGLE_SELECT);
        jSONArray.put(com.cardinalcommerce.cardinalmobilesdk.enums.CardinalRenderType.MULTI_SELECT);
        jSONArray.put(com.cardinalcommerce.cardinalmobilesdk.enums.CardinalRenderType.OOB);
        jSONArray.put(com.cardinalcommerce.cardinalmobilesdk.enums.CardinalRenderType.HTML);
        this.f3125e = jSONArray;
    }

    public int getRequestTimeout() {
        return this.f3121a;
    }

    public void setRequestTimeout(int i) {
        if (i < 0) {
            i = 0;
        }
        this.f3121a = i;
    }

    public int getChallengeTimeout() {
        return this.f3122b;
    }

    public void setChallengeTimeout(int i) {
        if (i < 5) {
            i = 5;
        }
        this.f3122b = i;
    }

    public CardinalEnvironment getEnvironment() {
        return this.f3126f;
    }

    public void setEnvironment(CardinalEnvironment cardinalEnvironment) {
        this.f3126f = cardinalEnvironment;
    }

    public String getProxyAddress() {
        return this.f3123c;
    }

    public void setProxyAddress(String str) {
        this.f3123c = str;
    }

    public CardinalUiType getUiType() {
        return this.f3124d;
    }

    public void setUiType(CardinalUiType cardinalUiType) {
        this.f3124d = cardinalUiType;
    }

    public JSONArray getRenderType() {
        return this.f3125e;
    }

    public void setRenderType(JSONArray jSONArray) throws InvalidInputException {
        if (jSONArray != null) {
            this.f3125e = jSONArray;
            return;
        }
        throw new InvalidInputException("InvalidInputException", new Throwable("Invalid Input Exception configure Parameters"));
    }

    public void setUICustomization(UiCustomization uiCustomization) {
        this.f3128h = uiCustomization;
    }

    public UiCustomization getUICustomization() {
        return this.f3128h;
    }

    public boolean isEnableDFSync() {
        return this.f3129i;
    }

    public void setEnableDFSync(boolean z) {
        this.f3129i = z;
    }

    public String getThreeDSRequestorAppURL() {
        return this.f3127g;
    }

    public void setThreeDSRequestorAppURL(String str) {
        this.f3127g = str;
    }

    public boolean isEnableLogging() {
        return this.f3131k;
    }

    public void setEnableLogging(boolean z) {
        this.f3131k = z;
    }

    public boolean isLocationDataConsentGiven() {
        return this.f3132l;
    }

    public void setLocationDataConsentGiven(boolean z) {
        this.f3132l = z;
    }

    public JSONObject getJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("Environment", this.f3126f);
            jSONObject.putOpt("ProxyAddress", this.f3123c);
            jSONObject.putOpt("RenderType", this.f3125e);
            jSONObject.putOpt("Timeout", Integer.valueOf(this.f3121a));
            jSONObject.putOpt("UiType", this.f3124d);
            jSONObject.putOpt("EnableDFSync", Boolean.valueOf(this.f3129i));
            jSONObject.putOpt("EnableLogging", Boolean.valueOf(this.f3131k));
            jSONObject.putOpt("LocationDataConsentGiven", Boolean.valueOf(this.f3132l));
            if (!this.f3127g.equals("")) {
                jSONObject.putOpt("ThreeDSRequestorAppURL", this.f3127g);
            }
        } catch (JSONException e) {
            CardinalRenderType cardinalRenderType = this.f3130j;
            CardinalError cardinalError = new CardinalError(10610, (Exception) e);
            cardinalRenderType.configure(String.valueOf(cardinalError.Cardinal), cardinalError.init, (String) null);
        }
        return jSONObject;
    }
}
