package com.koushikdutta.async.parser;

import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.body.DocumentBody;
import java.lang.reflect.Type;
import org.w3c.dom.Document;

public class DocumentParser implements AsyncParser<Document> {
    public String getMime() {
        return "text/xml";
    }

    public Future<Document> parse(DataEmitter dataEmitter) {
        return new ByteBufferListParser().parse(dataEmitter).thenConvert($$Lambda$DocumentParser$1rn4BttcABaXJ79ZmLU_gAdRZL0.INSTANCE);
    }

    public void write(DataSink dataSink, Document document, CompletedCallback completedCallback) {
        new DocumentBody(document).write((AsyncHttpRequest) null, dataSink, completedCallback);
    }

    public Type getType() {
        return Document.class;
    }
}
