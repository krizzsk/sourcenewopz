package global.didi.pay.merchantcore.model;

import global.didi.pay.merchantcore.exception.ModelSerializationException;
import global.didi.pay.merchantcore.model.DModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, mo175978d2 = {"global/didi/pay/merchantcore/model/DPayRequest$Companion$SERIALIZER$1", "Lglobal/didi/pay/merchantcore/model/DModelObject$Serializer;", "Lglobal/didi/pay/merchantcore/model/DPayRequest;", "deserialize", "jsonObject", "Lorg/json/JSONObject;", "serialize", "modelObject", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DPayRequest.kt */
public final class DPayRequest$Companion$SERIALIZER$1 implements DModelObject.Serializer<DPayRequest> {
    DPayRequest$Companion$SERIALIZER$1() {
    }

    public JSONObject serialize(DPayRequest dPayRequest) {
        Intrinsics.checkParameterIsNotNull(dPayRequest, "modelObject");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(DPayRequest.FIELD_MERCHANT_ORDER_ID, dPayRequest.getMerchantOrderId());
            jSONObject.putOpt(DPayRequest.FIELD_PAY_ORDER_ID, dPayRequest.getPayOrderId());
            jSONObject.putOpt(DPayRequest.FIELD_MERCHANT_ID, dPayRequest.getMerchantId());
            jSONObject.putOpt("app_id", dPayRequest.getAppId());
            jSONObject.putOpt("timestamp", dPayRequest.getTimestamp());
            jSONObject.putOpt("nonce_str", dPayRequest.getNonceStr());
            jSONObject.putOpt("version", dPayRequest.getVersion());
            jSONObject.putOpt("sign", dPayRequest.getSign());
            return jSONObject;
        } catch (JSONException e) {
            throw new ModelSerializationException(DPayRequest.class, e);
        }
    }

    public DPayRequest deserialize(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "jsonObject");
        try {
            return new DPayRequest(JsonUtilsKt.getStringOrNull(jSONObject, DPayRequest.FIELD_MERCHANT_ORDER_ID), JsonUtilsKt.getStringOrNull(jSONObject, DPayRequest.FIELD_PAY_ORDER_ID), JsonUtilsKt.getStringOrNull(jSONObject, DPayRequest.FIELD_MERCHANT_ID), JsonUtilsKt.getStringOrNull(jSONObject, "app_id"), JsonUtilsKt.getStringOrNull(jSONObject, "timestamp"), JsonUtilsKt.getStringOrNull(jSONObject, "nonce_str"), JsonUtilsKt.getStringOrNull(jSONObject, "version"), JsonUtilsKt.getStringOrNull(jSONObject, "sign"));
        } catch (JSONException e) {
            throw new ModelSerializationException(DPayRequest.class, e);
        }
    }
}
