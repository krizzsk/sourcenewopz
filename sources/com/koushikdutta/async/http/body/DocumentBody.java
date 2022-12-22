package com.koushikdutta.async.http.body;

import com.koushikdutta.async.C20137Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.DataSink;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.parser.DocumentParser;
import com.koushikdutta.async.util.Charsets;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

public class DocumentBody implements AsyncHttpRequestBody<Document> {
    public static final String CONTENT_TYPE = "application/xml";

    /* renamed from: a */
    ByteArrayOutputStream f55309a;

    /* renamed from: b */
    Document f55310b;

    public String getContentType() {
        return CONTENT_TYPE;
    }

    public boolean readFullyOnRequest() {
        return true;
    }

    public DocumentBody() {
        this((Document) null);
    }

    public DocumentBody(Document document) {
        this.f55310b = document;
    }

    /* renamed from: a */
    private void m39875a() {
        if (this.f55309a == null) {
            try {
                DOMSource dOMSource = new DOMSource(this.f55310b);
                Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
                this.f55309a = new ByteArrayOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f55309a, Charsets.UTF_8);
                newTransformer.transform(dOMSource, new StreamResult(outputStreamWriter));
                outputStreamWriter.flush();
            } catch (Exception unused) {
            }
        }
    }

    public void write(AsyncHttpRequest asyncHttpRequest, DataSink dataSink, CompletedCallback completedCallback) {
        m39875a();
        C20137Util.writeAll(dataSink, this.f55309a.toByteArray(), completedCallback);
    }

    public void parse(DataEmitter dataEmitter, final CompletedCallback completedCallback) {
        new DocumentParser().parse(dataEmitter).setCallback(new FutureCallback<Document>() {
            public void onCompleted(Exception exc, Document document) {
                DocumentBody.this.f55310b = document;
                completedCallback.onCompleted(exc);
            }
        });
    }

    public int length() {
        m39875a();
        return this.f55309a.size();
    }

    public Document get() {
        return this.f55310b;
    }
}
