package com.didi.sdk.messagecenter.deserializer;

import com.didi.sdk.messagecenter.model.BaseMessage;
import com.squareup.wire.Message;
import com.squareup.wire.Wire;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

public class TencentDeserializer<T extends BaseMessage> implements Deserializer<T> {

    /* renamed from: a */
    private Map<Class, Class> f36769a = new LinkedHashMap();

    public T deserialize(byte[] bArr, Class<T> cls) {
        Class<Message> a;
        T t;
        if (bArr == null || (a = m26035a(cls)) == null) {
            return null;
        }
        if (a == Message.class) {
            t = null;
        } else {
            try {
                t = new Wire((Class<?>[]) new Class[0]).parseFrom(bArr, a);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            }
        }
        T t2 = (BaseMessage) cls.newInstance();
        t2.msg = t;
        t2.raw = bArr;
        return t2;
    }

    /* renamed from: a */
    private Class m26035a(Class<? extends BaseMessage> cls) {
        Type[] actualTypeArguments;
        if (this.f36769a.containsKey(cls)) {
            return this.f36769a.get(cls);
        }
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType) || (actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments()) == null || actualTypeArguments.length <= 0) {
            return null;
        }
        Class cls2 = (Class) actualTypeArguments[0];
        if (!Message.class.isAssignableFrom(cls2)) {
            return null;
        }
        this.f36769a.put(cls, cls2);
        return cls2;
    }
}
