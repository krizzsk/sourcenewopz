package okhttp3.logging;

import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import org.osgi.framework.VersionRange;

public final class HttpLoggingInterceptor implements Interceptor {

    /* renamed from: a */
    private static final Charset f5611a = Charset.forName("UTF-8");

    /* renamed from: b */
    private final Logger f5612b;

    /* renamed from: c */
    private volatile Level f5613c;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() {
            public void log(String str) {
                Platform.get().log(4, str, (Throwable) null);
            }
        };

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger logger) {
        this.f5613c = Level.NONE;
        this.f5612b = logger;
    }

    public HttpLoggingInterceptor setLevel(Level level) {
        if (level != null) {
            this.f5613c = level;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    public Level getLevel() {
        return this.f5613c;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        boolean z;
        String str2;
        long j;
        String str3;
        char c;
        String str4;
        boolean z2;
        Interceptor.Chain chain2 = chain;
        Level level = this.f5613c;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain2.proceed(request);
        }
        boolean z3 = true;
        boolean z4 = level == Level.BODY;
        boolean z5 = z4 || level == Level.HEADERS;
        RequestBody body = request.body();
        if (body == null) {
            z3 = false;
        }
        Connection connection = chain.connection();
        StringBuilder sb = new StringBuilder();
        sb.append("--> ");
        sb.append(request.method());
        sb.append(' ');
        sb.append(request.url());
        if (connection != null) {
            str = " " + connection.protocol();
        } else {
            str = "";
        }
        sb.append(str);
        String sb2 = sb.toString();
        if (!z5 && z3) {
            sb2 = sb2 + " (" + body.contentLength() + "-byte body)";
        }
        this.f5612b.log(sb2);
        if (z5) {
            if (z3) {
                if (body.contentType() != null) {
                    this.f5612b.log("Content-Type: " + body.contentType());
                }
                if (body.contentLength() != -1) {
                    this.f5612b.log("Content-Length: " + body.contentLength());
                }
            }
            Headers headers = request.headers();
            int size = headers.size();
            int i = 0;
            while (i < size) {
                String name = headers.name(i);
                int i2 = size;
                if ("Content-Type".equalsIgnoreCase(name) || HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(name)) {
                    z2 = z5;
                } else {
                    z2 = z5;
                    this.f5612b.log(name + ": " + headers.value(i));
                }
                i++;
                size = i2;
                z5 = z2;
            }
            z = z5;
            if (!z4 || !z3) {
                this.f5612b.log("--> END " + request.method());
            } else if (m3604a(request.headers())) {
                this.f5612b.log("--> END " + request.method() + " (encoded body omitted)");
            } else {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                Charset charset = f5611a;
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    charset = contentType.charset(f5611a);
                }
                this.f5612b.log("");
                if (m3605a(buffer)) {
                    this.f5612b.log(buffer.readString(charset));
                    this.f5612b.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                } else {
                    this.f5612b.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                }
            }
        } else {
            z = z5;
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain2.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                str2 = contentLength + "-byte";
            } else {
                str2 = "unknown-length";
            }
            Logger logger = this.f5612b;
            StringBuilder sb3 = new StringBuilder();
            String str5 = "-byte body)";
            sb3.append("<-- ");
            sb3.append(proceed.code());
            if (proceed.message().isEmpty()) {
                j = contentLength;
                str3 = "";
                c = ' ';
            } else {
                StringBuilder sb4 = new StringBuilder();
                j = contentLength;
                c = ' ';
                sb4.append(' ');
                sb4.append(proceed.message());
                str3 = sb4.toString();
            }
            sb3.append(str3);
            sb3.append(c);
            sb3.append(proceed.request().url());
            sb3.append(" (");
            sb3.append(millis);
            sb3.append("ms");
            if (!z) {
                str4 = ", " + str2 + " body";
            } else {
                str4 = "";
            }
            sb3.append(str4);
            sb3.append(VersionRange.RIGHT_OPEN);
            logger.log(sb3.toString());
            if (z) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    this.f5612b.log(headers2.name(i3) + ": " + headers2.value(i3));
                }
                if (!z4 || !okhttp3.internal.http.HttpHeaders.hasBody(proceed)) {
                    this.f5612b.log("<-- END HTTP");
                } else if (m3604a(proceed.headers())) {
                    this.f5612b.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource source = body2.source();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer2 = source.buffer();
                    Charset charset2 = f5611a;
                    MediaType contentType2 = body2.contentType();
                    if (contentType2 != null) {
                        charset2 = contentType2.charset(f5611a);
                    }
                    if (!m3605a(buffer2)) {
                        this.f5612b.log("");
                        this.f5612b.log("<-- END HTTP (binary " + buffer2.size() + "-byte body omitted)");
                        return proceed;
                    }
                    if (j != 0) {
                        this.f5612b.log("");
                        this.f5612b.log(buffer2.clone().readString(charset2));
                    }
                    this.f5612b.log("<-- END HTTP (" + buffer2.size() + str5);
                }
            }
            return proceed;
        } catch (Exception e) {
            Exception exc = e;
            this.f5612b.log("<-- HTTP FAILED: " + exc);
            throw exc;
        }
    }

    /* renamed from: a */
    static boolean m3605a(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, buffer.size() < 64 ? buffer.size() : 64);
            for (int i = 0; i < 16; i++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    /* renamed from: a */
    private boolean m3604a(Headers headers) {
        String str = headers.get(HttpHeaders.CONTENT_ENCODING);
        return str != null && !str.equalsIgnoreCase("identity");
    }
}
