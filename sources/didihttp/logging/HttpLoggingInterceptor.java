package didihttp.logging;

import com.google.common.net.HttpHeaders;
import didihttp.Connection;
import didihttp.Headers;
import didihttp.Interceptor;
import didihttp.MediaType;
import didihttp.Protocol;
import didihttp.Request;
import didihttp.RequestBody;
import didihttp.Response;
import didihttp.ResponseBody;
import didihttp.internal.platform.Platform;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import org.osgi.framework.VersionRange;

public final class HttpLoggingInterceptor implements Interceptor {

    /* renamed from: a */
    private static final Charset f56982a = Charset.forName("UTF-8");

    /* renamed from: b */
    private final Logger f56983b;

    /* renamed from: c */
    private volatile Level f56984c;

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
        this.f56984c = Level.NONE;
        this.f56983b = logger;
    }

    public HttpLoggingInterceptor setLevel(Level level) {
        if (level != null) {
            this.f56984c = level;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    public Level getLevel() {
        return this.f56984c;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        String str;
        String str2;
        boolean z2;
        Interceptor.Chain chain2 = chain;
        Level level = this.f56984c;
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
        String str3 = "--> " + request.method() + ' ' + request.url() + ' ' + (connection != null ? connection.protocol() : Protocol.HTTP_1_1);
        if (!z5 && z3) {
            str3 = str3 + " (" + body.contentLength() + "-byte body)";
        }
        this.f56983b.log(str3);
        if (z5) {
            if (z3) {
                if (body.contentType() != null) {
                    this.f56983b.log("Content-Type: " + body.contentType());
                }
                if (body.contentLength() != -1) {
                    this.f56983b.log("Content-Length: " + body.contentLength());
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
                    this.f56983b.log(name + ": " + headers.value(i));
                }
                i++;
                size = i2;
                z5 = z2;
            }
            z = z5;
            if (!z4 || !z3) {
                this.f56983b.log("--> END " + request.method());
            } else if (m40892a(request.headers())) {
                this.f56983b.log("--> END " + request.method() + " (encoded body omitted)");
            } else {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                Charset charset = f56982a;
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    charset = contentType.charset(f56982a);
                }
                this.f56983b.log("");
                if (m40893a(buffer)) {
                    this.f56983b.log(buffer.readString(charset));
                    this.f56983b.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                } else {
                    this.f56983b.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
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
                str = contentLength + "-byte";
            } else {
                str = "unknown-length";
            }
            Logger logger = this.f56983b;
            StringBuilder sb = new StringBuilder();
            String str4 = "-byte body)";
            sb.append("<-- ");
            sb.append(proceed.code());
            sb.append(' ');
            long j = contentLength;
            sb.append(proceed.message());
            sb.append(' ');
            sb.append(proceed.request().url());
            sb.append(" (");
            sb.append(millis);
            sb.append("ms");
            if (!z) {
                str2 = ", " + str + " body";
            } else {
                str2 = "";
            }
            sb.append(str2);
            sb.append(VersionRange.RIGHT_OPEN);
            logger.log(sb.toString());
            if (z) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    this.f56983b.log(headers2.name(i3) + ": " + headers2.value(i3));
                }
                if (!z4 || !didihttp.internal.http.HttpHeaders.hasBody(proceed)) {
                    this.f56983b.log("<-- END HTTP");
                } else if (m40892a(proceed.headers())) {
                    this.f56983b.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource source = body2.source();
                    source.request(Long.MAX_VALUE);
                    Buffer buffer2 = source.buffer();
                    Charset charset2 = f56982a;
                    MediaType contentType2 = body2.contentType();
                    if (contentType2 != null) {
                        try {
                            charset2 = contentType2.charset(f56982a);
                        } catch (UnsupportedCharsetException unused) {
                            this.f56983b.log("");
                            this.f56983b.log("Couldn't decode the response body; charset is likely malformed.");
                            this.f56983b.log("<-- END HTTP");
                            return proceed;
                        }
                    }
                    if (!m40893a(buffer2)) {
                        this.f56983b.log("");
                        this.f56983b.log("<-- END HTTP (binary " + buffer2.size() + "-byte body omitted)");
                        return proceed;
                    }
                    if (j != 0) {
                        this.f56983b.log("");
                        this.f56983b.log(buffer2.clone().readString(charset2));
                    }
                    this.f56983b.log("<-- END HTTP (" + buffer2.size() + str4);
                }
            }
            return proceed;
        } catch (Exception e) {
            Exception exc = e;
            this.f56983b.log("<-- HTTP FAILED: " + exc);
            throw exc;
        }
    }

    /* renamed from: a */
    static boolean m40893a(Buffer buffer) {
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
    private boolean m40892a(Headers headers) {
        String str = headers.get(HttpHeaders.CONTENT_ENCODING);
        return str != null && !str.equalsIgnoreCase("identity");
    }
}
