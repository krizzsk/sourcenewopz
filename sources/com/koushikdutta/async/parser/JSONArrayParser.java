package com.koushikdutta.async.parser;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import java.lang.reflect.Type;
import org.json.JSONArray;

public class JSONArrayParser implements AsyncParser<JSONArray> {
    public String getMime() {
        return "application/json";
    }

    public Future<JSONArray> parse(DataEmitter dataEmitter) {
        return new StringParser().parse(dataEmitter).thenConvert($$Lambda$Euf2pcfSTqxq1moNJ7WmhpzGyM.INSTANCE);
    }

    public void write(DataSink dataSink, JSONArray jSONArray, CompletedCallback completedCallback) {
        new StringParser().write(dataSink, jSONArray.toString(), completedCallback);
    }

    public Type getType() {
        return JSONArray.class;
    }
}
