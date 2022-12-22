package okhttp3.internal.http;

import javax.annotation.Nullable;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public final class RealResponseBody extends ResponseBody {
    @Nullable

    /* renamed from: a */
    private final String f5370a;

    /* renamed from: b */
    private final long f5371b;

    /* renamed from: c */
    private final BufferedSource f5372c;

    public RealResponseBody(@Nullable String str, long j, BufferedSource bufferedSource) {
        this.f5370a = str;
        this.f5371b = j;
        this.f5372c = bufferedSource;
    }

    public MediaType contentType() {
        String str = this.f5370a;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    public long contentLength() {
        return this.f5371b;
    }

    public BufferedSource source() {
        return this.f5372c;
    }
}
