package com.koushikdutta.async.parser;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import java.lang.reflect.Type;
import org.json.JSONObject;

public class JSONObjectParser implements AsyncParser<JSONObject> {
    public String getMime() {
        return "application/json";
    }

    public Future<JSONObject> parse(DataEmitter dataEmitter) {
        return new StringParser().parse(dataEmitter).thenConvert($$Lambda$nLUzEUAkwlIcHRA8apYh908V4g.INSTANCE);
    }

    public void write(DataSink dataSink, JSONObject jSONObject, CompletedCallback completedCallback) {
        new StringParser().write(dataSink, jSONObject.toString(), completedCallback);
    }

    public Type getType() {
        return JSONObject.class;
    }
}
