package com.didi.map.global.rpc.adapter.deserialization;

import com.didi.map.global.rpc.adapter.MapGsonAdapter;
import com.didi.map.global.rpc.model.MapRpcBaseResult;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.p188io.Streams;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

public class MapApiDeserializationBytes<T extends MapRpcBaseResult> extends GsonDeserializer<T> {

    /* renamed from: a */
    private final MapGsonAdapter f27348a = new MapGsonAdapter();

    protected MapApiDeserializationBytes() {
    }

    public MapApiDeserializationBytes(Type type) {
        super(type);
    }

    public T deserialize(InputStream inputStream) throws IOException {
        try {
            byte[] readFullyNoClose = Streams.readFullyNoClose(inputStream);
            T t = (MapRpcBaseResult) this.f27348a.getGson().fromJson("{}", getType());
            t.setBytes(readFullyNoClose);
            return t;
        } catch (JsonSyntaxException e) {
            throw new IOException(e);
        }
    }
}
