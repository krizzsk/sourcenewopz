package didihttp.internal.http;

import didihttp.Headers;
import didihttp.MediaType;
import didihttp.ResponseBody;
import okio.BufferedSource;

public final class RealResponseBody extends ResponseBody {

    /* renamed from: a */
    private final Headers f56713a;

    /* renamed from: b */
    private final BufferedSource f56714b;

    public RealResponseBody(Headers headers, BufferedSource bufferedSource) {
        this.f56713a = headers;
        this.f56714b = bufferedSource;
    }

    public MediaType contentType() {
        String str = this.f56713a.get("Content-Type");
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    public long contentLength() {
        return HttpHeaders.contentLength(this.f56713a);
    }

    public BufferedSource source() {
        return this.f56714b;
    }
}
