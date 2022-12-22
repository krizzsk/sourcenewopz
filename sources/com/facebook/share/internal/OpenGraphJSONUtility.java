package com.facebook.share.internal;

import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphObject;
import com.facebook.share.model.SharePhoto;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u001e\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\u0012"}, mo175978d2 = {"Lcom/facebook/share/internal/OpenGraphJSONUtility;", "", "()V", "toJSONArray", "Lorg/json/JSONArray;", "list", "", "photoJSONProcessor", "Lcom/facebook/share/internal/OpenGraphJSONUtility$PhotoJSONProcessor;", "toJSONObject", "Lorg/json/JSONObject;", "action", "Lcom/facebook/share/model/ShareOpenGraphAction;", "graphObject", "Lcom/facebook/share/model/ShareOpenGraphObject;", "toJSONValue", "value", "PhotoJSONProcessor", "facebook-common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OpenGraphJSONUtility.kt */
public final class OpenGraphJSONUtility {
    public static final OpenGraphJSONUtility INSTANCE = new OpenGraphJSONUtility();

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/facebook/share/internal/OpenGraphJSONUtility$PhotoJSONProcessor;", "", "toJSONObject", "Lorg/json/JSONObject;", "photo", "Lcom/facebook/share/model/SharePhoto;", "facebook-common_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OpenGraphJSONUtility.kt */
    public interface PhotoJSONProcessor {
        JSONObject toJSONObject(SharePhoto sharePhoto);
    }

    private OpenGraphJSONUtility() {
    }

    @JvmStatic
    public static final JSONObject toJSONObject(ShareOpenGraphAction shareOpenGraphAction, PhotoJSONProcessor photoJSONProcessor) throws JSONException {
        if (shareOpenGraphAction == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String next : shareOpenGraphAction.keySet()) {
            jSONObject.put(next, toJSONValue(shareOpenGraphAction.get(next), photoJSONProcessor));
        }
        return jSONObject;
    }

    private final JSONObject toJSONObject(ShareOpenGraphObject shareOpenGraphObject, PhotoJSONProcessor photoJSONProcessor) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (String next : shareOpenGraphObject.keySet()) {
            jSONObject.put(next, toJSONValue(shareOpenGraphObject.get(next), photoJSONProcessor));
        }
        return jSONObject;
    }

    private final JSONArray toJSONArray(List<?> list, PhotoJSONProcessor photoJSONProcessor) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Object jSONValue : list) {
            jSONArray.put(toJSONValue(jSONValue, photoJSONProcessor));
        }
        return jSONArray;
    }

    @JvmStatic
    public static final Object toJSONValue(Object obj, PhotoJSONProcessor photoJSONProcessor) throws JSONException {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long)) {
            return obj;
        }
        try {
            if (obj instanceof SharePhoto) {
                if (photoJSONProcessor == null) {
                    return null;
                }
                return photoJSONProcessor.toJSONObject((SharePhoto) obj);
            } else if (obj instanceof ShareOpenGraphObject) {
                return INSTANCE.toJSONObject((ShareOpenGraphObject) obj, photoJSONProcessor);
            } else {
                if (obj instanceof List) {
                    return INSTANCE.toJSONArray((List) obj, photoJSONProcessor);
                }
                return null;
            }
        } catch (Exception unused) {
        }
    }
}
