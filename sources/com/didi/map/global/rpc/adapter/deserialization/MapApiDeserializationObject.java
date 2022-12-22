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

public class MapApiDeserializationObject<T extends MapRpcBaseResult> extends GsonDeserializer<T> {
    protected final MapGsonAdapter mAdapter = new MapGsonAdapter();

    protected MapApiDeserializationObject() {
    }

    public MapApiDeserializationObject(Type type) {
        super(type);
    }

    public T deserialize(InputStream inputStream) throws IOException {
        try {
            return (MapRpcBaseResult) this.mAdapter.getGson().fromJson(Streams.readFullyNoClose((Reader) new InputStreamReader(inputStream)), getType());
        } catch (JsonSyntaxException e) {
            throw new IOException(e);
        }
    }
}
