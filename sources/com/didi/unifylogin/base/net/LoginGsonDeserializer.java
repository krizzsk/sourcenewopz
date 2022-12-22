package com.didi.unifylogin.base.net;

import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didichuxing.foundation.gson.GsonAdapter;
import com.didichuxing.foundation.p188io.AbstractDeserializer;
import com.didichuxing.foundation.p188io.Streams;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;

public class LoginGsonDeserializer<T> extends AbstractDeserializer<T> {

    /* renamed from: a */
    private final GsonAdapter f44683a = new GsonAdapter();

    protected LoginGsonDeserializer() {
    }

    public LoginGsonDeserializer(Type type) {
        super(type);
    }

    public T deserialize(InputStream inputStream) throws IOException {
        try {
            return this.f44683a.getGson().fromJson(Streams.readFullyNoClose((Reader) new InputStreamReader(inputStream)), getType());
        } catch (JsonSyntaxException e) {
            new LoginOmegaUtil(LoginOmegaUtil.TECH_PAX_EVENT_LOGIN_ERROR).add("err_type", 3).add("err_msg", "json deserialize error").add("module", getType().toString()).send();
            throw new LoginJsonException(e);
        }
    }
}
