package com.adyen.checkout.core.model;

import com.adyen.checkout.core.exception.BadModelException;
import com.adyen.checkout.core.exception.NoConstructorException;
import com.adyen.checkout.core.model.ModelObject;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ModelUtils {
    public static final String SERIALIZER_FIELD_NAME = "SERIALIZER";

    /* renamed from: a */
    static <T extends ModelObject> T m1087a(JSONObject jSONObject, Class<T> cls) {
        return m1086a(cls).deserialize(jSONObject);
    }

    public static <T extends ModelObject> T deserializeOpt(JSONObject jSONObject, ModelObject.Serializer<T> serializer) {
        if (jSONObject == null) {
            return null;
        }
        return serializer.deserialize(jSONObject);
    }

    public static <T extends ModelObject> List<T> deserializeOptList(JSONArray jSONArray, ModelObject.Serializer<T> serializer) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(serializer.deserialize(optJSONObject));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static <T extends ModelObject> JSONObject serializeOpt(T t, ModelObject.Serializer<T> serializer) {
        if (t == null) {
            return null;
        }
        return serializer.serialize(t);
    }

    public static <T extends ModelObject> JSONArray serializeOptList(List<T> list, ModelObject.Serializer<T> serializer) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (T serialize : list) {
            jSONArray.put(serializer.serialize(serialize));
        }
        return jSONArray;
    }

    /* renamed from: a */
    private static ModelObject.Serializer<?> m1086a(Class<?> cls) {
        try {
            Field field = cls.getField("SERIALIZER");
            if ((field.getModifiers() & 8) == 0) {
                throw new BadModelException(cls, (Throwable) null);
            } else if (ModelObject.Serializer.class.isAssignableFrom(field.getType())) {
                return (ModelObject.Serializer) field.get((Object) null);
            } else {
                throw new BadModelException(cls, (Throwable) null);
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new BadModelException(cls, e);
        }
    }

    private ModelUtils() {
        throw new NoConstructorException();
    }
}
