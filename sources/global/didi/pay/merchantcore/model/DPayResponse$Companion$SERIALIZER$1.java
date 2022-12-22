package global.didi.pay.merchantcore.model;

import global.didi.pay.merchantcore.exception.ModelSerializationException;
import global.didi.pay.merchantcore.model.DModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, mo175978d2 = {"global/didi/pay/merchantcore/model/DPayResponse$Companion$SERIALIZER$1", "Lglobal/didi/pay/merchantcore/model/DModelObject$Serializer;", "Lglobal/didi/pay/merchantcore/model/DPayResponse;", "deserialize", "jsonObject", "Lorg/json/JSONObject;", "serialize", "modelObject", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DPayResponse.kt */
public final class DPayResponse$Companion$SERIALIZER$1 implements DModelObject.Serializer<DPayResponse> {
    DPayResponse$Companion$SERIALIZER$1() {
    }

    public JSONObject serialize(DPayResponse dPayResponse) {
        Intrinsics.checkParameterIsNotNull(dPayResponse, "modelObject");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pay_status", Integer.valueOf(dPayResponse.getPayStatus()));
            jSONObject.putOpt("msg", DPayMsg.SERIALIZER.serialize(dPayResponse.getMsg()));
            return jSONObject;
        } catch (JSONException e) {
            throw new ModelSerializationException(DPayResponse.class, e);
        }
    }

    public DPayResponse deserialize(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "jsonObject");
        try {
            int i = jSONObject.getInt("pay_status");
            DModelObject.Serializer<DPayMsg> serializer = DPayMsg.SERIALIZER;
            JSONObject jSONObject2 = jSONObject.getJSONObject("msg");
            Intrinsics.checkExpressionValueIsNotNull(jSONObject2, "jsonObject.getJSONObject(FIELD_MSG)");
            return new DPayResponse(i, serializer.deserialize(jSONObject2));
        } catch (JSONException e) {
            throw new ModelSerializationException(DPayResponse.class, e);
        }
    }
}
