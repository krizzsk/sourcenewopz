package global.didi.pay.merchantcore.model;

import global.didi.pay.merchantcore.model.DModelObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/model/ModelUtils;", "", "()V", "Companion", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ModelUtils.kt */
public final class ModelUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String SERIALIZER_FIELD_NAME = "SERIALIZER";

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b¢\u0006\u0002\u0010\fJ1\u0010\r\u001a\u0004\u0018\u0001H\u0006\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000f¢\u0006\u0002\u0010\u0010J2\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u0012\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000fJ\u0018\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u000f2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000bH\u0002J1\u0010\u0016\u001a\u0004\u0018\u00010\t\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00072\b\u0010\u0017\u001a\u0004\u0018\u0001H\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000f¢\u0006\u0002\u0010\u0018J2\u0010\u0019\u001a\u0004\u0018\u00010\u0014\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00072\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u0006\u0018\u00010\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lglobal/didi/pay/merchantcore/model/ModelUtils$Companion;", "", "()V", "SERIALIZER_FIELD_NAME", "", "deserializeModel", "T", "Lglobal/didi/pay/merchantcore/model/DModelObject;", "jsonObject", "Lorg/json/JSONObject;", "modelClass", "Ljava/lang/Class;", "(Lorg/json/JSONObject;Ljava/lang/Class;)Lglobal/didi/pay/merchantcore/model/DModelObject;", "deserializeOpt", "serializer", "Lglobal/didi/pay/merchantcore/model/DModelObject$Serializer;", "(Lorg/json/JSONObject;Lglobal/didi/pay/merchantcore/model/DModelObject$Serializer;)Lglobal/didi/pay/merchantcore/model/DModelObject;", "deserializeOptList", "", "jsonArray", "Lorg/json/JSONArray;", "readModelSerializer", "serializeOpt", "modelObject", "(Lglobal/didi/pay/merchantcore/model/DModelObject;Lglobal/didi/pay/merchantcore/model/DModelObject$Serializer;)Lorg/json/JSONObject;", "serializeOptList", "modelList", "merchantCore_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: ModelUtils.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T extends DModelObject> T deserializeModel(JSONObject jSONObject, Class<T> cls) {
            Intrinsics.checkParameterIsNotNull(jSONObject, "jsonObject");
            Intrinsics.checkParameterIsNotNull(cls, "modelClass");
            DModelObject.Serializer<?> readModelSerializer = readModelSerializer(cls);
            if (readModelSerializer != null) {
                return readModelSerializer.deserialize(jSONObject);
            }
            throw new TypeCastException("null cannot be cast to non-null type global.didi.pay.merchantcore.model.DModelObject.Serializer<T>");
        }

        public final <T extends DModelObject> T deserializeOpt(JSONObject jSONObject, DModelObject.Serializer<T> serializer) {
            Intrinsics.checkParameterIsNotNull(serializer, "serializer");
            if (jSONObject == null) {
                return null;
            }
            return serializer.deserialize(jSONObject);
        }

        public final <T extends DModelObject> List<T> deserializeOptList(JSONArray jSONArray, DModelObject.Serializer<T> serializer) {
            Intrinsics.checkParameterIsNotNull(serializer, "serializer");
            if (jSONArray == null) {
                return null;
            }
            List arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    arrayList.add(serializer.deserialize(optJSONObject));
                }
            }
            return Collections.unmodifiableList(arrayList);
        }

        public final <T extends DModelObject> JSONObject serializeOpt(T t, DModelObject.Serializer<T> serializer) {
            Intrinsics.checkParameterIsNotNull(serializer, "serializer");
            if (t == null) {
                return null;
            }
            return serializer.serialize(t);
        }

        public final <T extends DModelObject> JSONArray serializeOptList(List<? extends T> list, DModelObject.Serializer<T> serializer) {
            Intrinsics.checkParameterIsNotNull(serializer, "serializer");
            if (list == null || list.isEmpty()) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<? extends T> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(serializer.serialize((DModelObject) it.next()));
            }
            return jSONArray;
        }

        private final DModelObject.Serializer<?> readModelSerializer(Class<?> cls) {
            try {
                Field field = cls.getField("SERIALIZER");
                Intrinsics.checkExpressionValueIsNotNull(field, "field");
                if ((field.getModifiers() & 8) == 0) {
                    throw new RuntimeException();
                } else if (DModelObject.Serializer.class.isAssignableFrom(field.getType())) {
                    Object obj = field.get((Object) null);
                    if (obj != null) {
                        return (DModelObject.Serializer) obj;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type global.didi.pay.merchantcore.model.DModelObject.Serializer<*>");
                } else {
                    throw new RuntimeException();
                }
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private ModelUtils() {
        throw new RuntimeException();
    }
}
