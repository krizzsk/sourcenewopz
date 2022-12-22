package com.koushikdutta.async.parser;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.Future;
import com.koushikdutta.async.future.ThenCallback;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

public class StringParser implements AsyncParser<String> {

    /* renamed from: a */
    Charset f55437a;

    public String getMime() {
        return null;
    }

    public StringParser() {
    }

    public StringParser(Charset charset) {
        this.f55437a = charset;
    }

    public Future<String> parse(DataEmitter dataEmitter) {
        return new ByteBufferListParser().parse(dataEmitter).thenConvert(new ThenCallback(dataEmitter.charset()) {
            public final /* synthetic */ String f$1;

            {
                this.f$1 = r2;
            }

            public final Object then(Object obj) {
                return StringParser.this.m40001a(this.f$1, (ByteBufferList) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ String m40001a(String str, ByteBufferList byteBufferList) throws Exception {
        Charset charset = this.f55437a;
        if (charset == null && str != null) {
            charset = Charset.forName(str);
        }
        return byteBufferList.readString(charset);
    }

    public void write(DataSink dataSink, String str, CompletedCallback completedCallback) {
        new ByteBufferListParser().write(dataSink, new ByteBufferList(str.getBytes()), completedCallback);
    }

    public Type getType() {
        return String.class;
    }
}
