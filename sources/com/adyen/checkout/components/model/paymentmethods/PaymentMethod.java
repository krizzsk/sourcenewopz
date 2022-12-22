package com.adyen.checkout.components.model.paymentmethods;

import android.os.Parcel;
import com.adyen.checkout.core.exception.ModelSerializationException;
import com.adyen.checkout.core.model.JsonUtils;
import com.adyen.checkout.core.model.ModelObject;
import com.adyen.checkout.core.model.ModelUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentMethod extends ModelObject {
    public static final ModelObject.Creator<PaymentMethod> CREATOR = new ModelObject.Creator<>(PaymentMethod.class);
    public static final ModelObject.Serializer<PaymentMethod> SERIALIZER = new ModelObject.Serializer<PaymentMethod>() {
        public JSONObject serialize(PaymentMethod paymentMethod) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("type", paymentMethod.getType());
                jSONObject.putOpt("name", paymentMethod.getName());
                jSONObject.putOpt(PaymentMethod.f693c, JsonUtils.serializeOptStringList(paymentMethod.getBrands()));
                jSONObject.putOpt("brand", paymentMethod.getBrand());
                jSONObject.putOpt(PaymentMethod.f695e, paymentMethod.getFundingSource());
                jSONObject.putOpt(PaymentMethod.f696f, ModelUtils.serializeOptList(paymentMethod.getIssuers(), Issuer.SERIALIZER));
                jSONObject.putOpt(PaymentMethod.f697g, ModelUtils.serializeOpt(paymentMethod.getConfiguration(), Configuration.SERIALIZER));
                jSONObject.putOpt("details", ModelUtils.serializeOptList(paymentMethod.getDetails(), InputDetail.SERIALIZER));
                return jSONObject;
            } catch (JSONException e) {
                throw new ModelSerializationException(PaymentMethod.class, e);
            }
        }

        public PaymentMethod deserialize(JSONObject jSONObject) {
            PaymentMethod paymentMethod = new PaymentMethod();
            paymentMethod.setType(jSONObject.optString("type", (String) null));
            paymentMethod.setName(jSONObject.optString("name", (String) null));
            paymentMethod.setBrands(JsonUtils.parseOptStringList(jSONObject.optJSONArray(PaymentMethod.f693c)));
            paymentMethod.setBrand(jSONObject.optString("brand", (String) null));
            paymentMethod.setFundingSource(jSONObject.optString(PaymentMethod.f695e, (String) null));
            paymentMethod.setIssuers(ModelUtils.deserializeOptList(jSONObject.optJSONArray(PaymentMethod.f696f), Issuer.SERIALIZER));
            paymentMethod.setConfiguration((Configuration) ModelUtils.deserializeOpt(jSONObject.optJSONObject(PaymentMethod.f697g), Configuration.SERIALIZER));
            paymentMethod.setDetails(ModelUtils.deserializeOptList(jSONObject.optJSONArray("details"), InputDetail.SERIALIZER));
            return paymentMethod;
        }
    };

    /* renamed from: a */
    private static final String f691a = "type";

    /* renamed from: b */
    private static final String f692b = "name";

    /* renamed from: c */
    private static final String f693c = "brands";

    /* renamed from: d */
    private static final String f694d = "brand";

    /* renamed from: e */
    private static final String f695e = "fundingSource";

    /* renamed from: f */
    private static final String f696f = "issuers";

    /* renamed from: g */
    private static final String f697g = "configuration";

    /* renamed from: h */
    private static final String f698h = "details";

    /* renamed from: i */
    private String f699i;

    /* renamed from: j */
    private String f700j;

    /* renamed from: k */
    private List<String> f701k;

    /* renamed from: l */
    private String f702l;

    /* renamed from: m */
    private String f703m;

    /* renamed from: n */
    private List<Issuer> f704n;

    /* renamed from: o */
    private Configuration f705o;

    /* renamed from: p */
    private List<InputDetail> f706p;

    public void writeToParcel(Parcel parcel, int i) {
        JsonUtils.writeToParcel(parcel, SERIALIZER.serialize(this));
    }

    public String getType() {
        return this.f699i;
    }

    public String getName() {
        return this.f700j;
    }

    public List<String> getBrands() {
        return this.f701k;
    }

    public String getBrand() {
        return this.f702l;
    }

    public String getFundingSource() {
        return this.f703m;
    }

    public List<Issuer> getIssuers() {
        return this.f704n;
    }

    public Configuration getConfiguration() {
        return this.f705o;
    }

    public List<InputDetail> getDetails() {
        return this.f706p;
    }

    public void setType(String str) {
        this.f699i = str;
    }

    public void setName(String str) {
        this.f700j = str;
    }

    public void setBrands(List<String> list) {
        this.f701k = list;
    }

    public void setBrand(String str) {
        this.f702l = str;
    }

    public void setFundingSource(String str) {
        this.f703m = str;
    }

    public void setIssuers(List<Issuer> list) {
        this.f704n = list;
    }

    public void setConfiguration(Configuration configuration) {
        this.f705o = configuration;
    }

    public void setDetails(List<InputDetail> list) {
        this.f706p = list;
    }
}
