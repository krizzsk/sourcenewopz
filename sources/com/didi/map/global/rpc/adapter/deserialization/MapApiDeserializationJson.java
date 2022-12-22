package com.didi.map.global.rpc.adapter.deserialization;

import com.didi.map.global.rpc.adapter.MapGsonAdapter;
import com.didi.map.global.rpc.model.MapRpcBaseResult;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.p188io.Streams;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;

public class MapApiDeserializationJson<T extends MapRpcBaseResult> extends GsonDeserializer<T> {

    /* renamed from: a */
    private final MapGsonAdapter f27349a = new MapGsonAdapter();

    protected MapApiDeserializationJson() {
    }

    public MapApiDeserializationJson(Type type) {
        super(type);
    }

    public T deserialize(InputStream inputStream) throws IOException {
        try {
            String readFullyNoClose = Streams.readFullyNoClose((Reader) new InputStreamReader(inputStream));
            T t = (MapRpcBaseResult) this.f27349a.getGson().fromJson(readFullyNoClose, getType());
            t.setJson(readFullyNoClose);
            return t;
        } catch (JsonSyntaxException e) {
            throw new IOException(e);
        }
    }
}
