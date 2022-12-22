package com.didi.beatles.p099im.net;

import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didichuxing.foundation.p188io.AbstractDeserializer;
import com.didichuxing.foundation.p188io.Streams;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;

/* renamed from: com.didi.beatles.im.net.IMJsonDeserializer */
public class IMJsonDeserializer<T> extends AbstractDeserializer<T> {
    protected IMJsonDeserializer() {
    }

    public IMJsonDeserializer(Type type) {
        super(type);
    }

    public T deserialize(InputStream inputStream) throws IOException {
        try {
            return IMJsonUtil.objectFromJson(Streams.readFullyNoClose((Reader) new InputStreamReader(inputStream)), getType());
        } catch (Exception e) {
            IMLog.m6633e(e);
            return null;
        }
    }
}
