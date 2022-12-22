package didihttp;

import didihttp.internal.C20747Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okio.Buffer;
import okio.BufferedSink;

public final class FormBody extends RequestBody {

    /* renamed from: a */
    private static final MediaType f56432a = MediaType.parse("application/x-www-form-urlencoded");

    /* renamed from: b */
    private final List<String> f56433b;

    /* renamed from: c */
    private final List<String> f56434c;

    FormBody(List<String> list, List<String> list2) {
        this.f56433b = C20747Util.immutableList(list);
        this.f56434c = C20747Util.immutableList(list2);
    }

    public int size() {
        return this.f56433b.size();
    }

    public String encodedName(int i) {
        return this.f56433b.get(i);
    }

    public String name(int i) {
        return HttpUrl.m40618a(encodedName(i), true);
    }

    public String encodedValue(int i) {
        return this.f56434c.get(i);
    }

    public String value(int i) {
        return HttpUrl.m40618a(encodedValue(i), true);
    }

    public MediaType contentType() {
        return f56432a;
    }

    public long contentLength() {
        return m40610a((BufferedSink) null, true);
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        m40610a(bufferedSink, false);
    }

    /* renamed from: a */
    private long m40610a(BufferedSink bufferedSink, boolean z) {
        Buffer buffer;
        if (z) {
            buffer = new Buffer();
        } else {
            buffer = bufferedSink.buffer();
        }
        int size = this.f56433b.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.f56433b.get(i));
            buffer.writeByte(61);
            buffer.writeUtf8(this.f56434c.get(i));
        }
        if (!z) {
            return 0;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    public static final class Builder {
        private final List<String> names = new ArrayList();
        private final List<String> values = new ArrayList();

        public Builder add(String str, String str2) {
            this.names.add(HttpUrl.m40617a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.values.add(HttpUrl.m40617a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public Builder addEncoded(String str, String str2) {
            this.names.add(HttpUrl.m40617a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.values.add(HttpUrl.m40617a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }

        public FormBody build() {
            return new FormBody(this.names, this.values);
        }
    }
}
