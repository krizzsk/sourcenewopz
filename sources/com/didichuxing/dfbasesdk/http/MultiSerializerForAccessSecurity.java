package com.didichuxing.dfbasesdk.http;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.didi.dimina.starbox.util.FileUtil;
import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.net.http.MultipartBody;
import com.didichuxing.foundation.net.http.MultipartEntity;
import com.didichuxing.foundation.p188io.AbstractSerializer;
import com.didichuxing.foundation.util.Introspector;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MultiSerializerForAccessSecurity extends AbstractSerializer<Object> {

    /* renamed from: a */
    private static final String f46578a = "a19Okqhm4oK6FWIfN10PH3X895WZYD-k_OK";
    public static final String contentType = "multipart/form-data; boundary=a19Okqhm4oK6FWIfN10PH3X895WZYD-k_OK";

    /* renamed from: b */
    private final MultipartBody.Builder f46579b = new MultipartBody.Builder().setBoundary(f46578a);

    public InputStream serialize(Object obj) throws IOException {
        Map<String, Object> map;
        if (obj instanceof Map) {
            if (obj instanceof TreeMap) {
                map = new TreeMap<>();
            } else if (obj instanceof LinkedHashMap) {
                map = new LinkedHashMap<>();
            } else {
                map = new HashMap<>();
            }
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                map.put(String.valueOf(entry.getKey()), entry.getValue());
            }
        } else {
            map = Introspector.properties(obj, true);
        }
        MultipartBody.Builder newBuilder = this.f46579b.build().newBuilder();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (value instanceof byte[]) {
                newBuilder.addPart(str, (byte[]) value);
            } else if (value instanceof File) {
                newBuilder.addPart(str, (File) value);
            } else if (value instanceof InputStream) {
                newBuilder.addPart(str, (InputStream) value);
            } else if (value instanceof MultipartEntity) {
                newBuilder.addPart(str, (MultipartEntity) value);
            } else if (value instanceof MemJpg) {
                MemJpg memJpg = (MemJpg) value;
                if (!memJpg.isEmpty()) {
                    newBuilder.addPart(str, (MultipartEntity) new MemJpgMultipartEntity(memJpg));
                }
            } else {
                newBuilder.addPart(str, value);
            }
        }
        return newBuilder.build().getContent();
    }

    public static class MemJpg {
        byte[] jpgData;
        String jpgName;

        public MemJpg(byte[] bArr, String str) {
            this.jpgData = bArr;
            this.jpgName = str;
        }

        public boolean isEmpty() {
            byte[] bArr = this.jpgData;
            return bArr == null || bArr.length <= 0;
        }
    }

    public static class MemJpgMultipartEntity implements MultipartEntity {
        public static final Charset CHARSET_UTF_8 = Charset.forName("UTF-8");
        MemJpg memJpg;

        public void close() throws IOException {
        }

        public String getTransferEncoding() {
            return "binary";
        }

        public MemJpgMultipartEntity(MemJpg memJpg2) {
            this.memJpg = memJpg2;
        }

        public String getFilename() {
            MemJpg memJpg2 = this.memJpg;
            return (memJpg2 == null || TextUtils.isEmpty(memJpg2.jpgName)) ? "img.jpg" : this.memJpg.jpgName;
        }

        public MimeType getContentType() {
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(FileUtil.JPG);
            if (TextUtils.isEmpty(mimeTypeFromExtension)) {
                return MimeType.APPLICATION_OCTET_STREAM;
            }
            return MimeType.parse(mimeTypeFromExtension);
        }

        public Charset getCharset() {
            MimeType contentType = getContentType();
            return contentType == null ? CHARSET_UTF_8 : contentType.getCharset(CHARSET_UTF_8);
        }

        public InputStream getContent() throws IOException {
            if (this.memJpg != null) {
                return new ByteArrayInputStream(this.memJpg.jpgData);
            }
            return null;
        }

        public long getContentLength() throws IOException {
            MemJpg memJpg2 = this.memJpg;
            if (memJpg2 == null || memJpg2.jpgData == null) {
                return 0;
            }
            return (long) this.memJpg.jpgData.length;
        }

        public void writeTo(OutputStream outputStream) throws IOException {
            MemJpg memJpg2 = this.memJpg;
            if (memJpg2 != null && memJpg2.jpgData != null) {
                outputStream.write(this.memJpg.jpgData);
            }
        }
    }
}
