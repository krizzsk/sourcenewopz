package global.didi.pay.merchantcore.model;

import global.didi.pay.merchantcore.exception.ModelSerializationException;
import global.didi.pay.merchantcore.model.DModelObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, mo175978d2 = {"global/didi/pay/merchantcore/model/DPayMsg$Companion$SERIALIZER$1", "Lglobal/didi/pay/merchantcore/model/DModelObject$Serializer;", "Lglobal/didi/pay/merchantcore/model/DPayMsg;", "deserialize", "jsonObject", "Lorg/json/JSONObject;", "serialize", "modelObject", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DPayResponse.kt */
public final class DPayMsg$Companion$SERIALIZER$1 implements DModelObject.Serializer<DPayMsg> {
    DPayMsg$Companion$SERIALIZER$1() {
    }

    public JSONObject serialize(DPayMsg dPayMsg) {
        Intrinsics.checkParameterIsNotNull(dPayMsg, "modelObject");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("errno", Integer.valueOf(dPayMsg.getErrno()));
            jSONObject.putOpt(DPayMsg.FIELD_MSG_CONTENT, dPayMsg.getMsgContent());
            return jSONObject;
        } catch (JSONException e) {
            throw new ModelSerializationException(DPayMsg.class, e);
        }
    }

    public DPayMsg deserialize(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "jsonObject");
        try {
            return new DPayMsg(jSONObject.getInt("errno"), JsonUtilsKt.getStringOrNull(jSONObject, DPayMsg.FIELD_MSG_CONTENT));
        } catch (JSONException e) {
            throw new ModelSerializationException(DPayMsg.class, e);
        }
    }
}
