package didihttp;

import android.os.SystemClock;
import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.google.common.net.HttpHeaders;
import java.net.InetAddress;
import java.net.Proxy;
import java.net.Socket;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

public class ServerCallItem {

    /* renamed from: A */
    private String f56508A;

    /* renamed from: B */
    private List<Certificate> f56509B;

    /* renamed from: C */
    private List<Certificate> f56510C;

    /* renamed from: D */
    private Principal f56511D;

    /* renamed from: E */
    private Principal f56512E;

    /* renamed from: F */
    private long f56513F;

    /* renamed from: G */
    private byte[] f56514G;

    /* renamed from: H */
    private int f56515H;

    /* renamed from: I */
    private Protocol f56516I;

    /* renamed from: J */
    private boolean f56517J;

    /* renamed from: K */
    private long f56518K;

    /* renamed from: L */
    private long f56519L;

    /* renamed from: M */
    private Throwable f56520M;

    /* renamed from: N */
    private boolean f56521N;

    /* renamed from: O */
    private boolean f56522O;

    /* renamed from: P */
    private String f56523P;

    /* renamed from: Q */
    private String f56524Q;

    /* renamed from: R */
    private int f56525R;

    /* renamed from: S */
    private long f56526S = 0;

    /* renamed from: T */
    private int f56527T = -1;

    /* renamed from: a */
    private long f56528a;

    /* renamed from: b */
    private long f56529b;

    /* renamed from: c */
    private long f56530c;

    /* renamed from: d */
    private long f56531d;

    /* renamed from: e */
    private long f56532e;

    /* renamed from: f */
    private long f56533f;

    /* renamed from: g */
    private long f56534g;

    /* renamed from: h */
    private long f56535h;

    /* renamed from: i */
    private long f56536i;

    /* renamed from: j */
    private long f56537j;

    /* renamed from: k */
    private long f56538k;

    /* renamed from: l */
    private long f56539l;

    /* renamed from: m */
    private long f56540m;

    /* renamed from: n */
    private int f56541n = 0;

    /* renamed from: o */
    private long f56542o;

    /* renamed from: p */
    private long f56543p;

    /* renamed from: q */
    private String f56544q;

    /* renamed from: r */
    private String f56545r;

    /* renamed from: s */
    private String f56546s;

    /* renamed from: t */
    private String f56547t;

    /* renamed from: u */
    private InetAddress f56548u;

    /* renamed from: v */
    private int f56549v;

    /* renamed from: w */
    private InetAddress f56550w;

    /* renamed from: x */
    private int f56551x;

    /* renamed from: y */
    private Proxy f56552y;

    /* renamed from: z */
    private TlsVersion f56553z;

    /* renamed from: a */
    private long m40642a(long j) {
        if (j < 0) {
            return 0;
        }
        return j;
    }

    public void traceStart() {
        this.f56529b = SystemClock.uptimeMillis();
        this.f56541n = 1;
        this.f56528a = System.currentTimeMillis();
    }

    public void traceEnd() {
        this.f56530c = SystemClock.uptimeMillis();
        this.f56541n = 12;
    }

    public void traceDnsLookupStart() {
        this.f56531d = SystemClock.uptimeMillis();
        this.f56541n = 2;
    }

    public void traceDnsLookupEnd() {
        this.f56532e = SystemClock.uptimeMillis();
        this.f56541n = 3;
    }

    public void traceConnectStart() {
        this.f56533f = SystemClock.uptimeMillis();
        this.f56541n = 4;
    }

    public void traceConnectEnd() {
        this.f56534g = SystemClock.uptimeMillis();
        this.f56541n = 7;
    }

    public void traceHandShakeStart() {
        this.f56535h = SystemClock.uptimeMillis();
        this.f56541n = 5;
    }

    public void traceHandShakeEnd() {
        this.f56536i = SystemClock.uptimeMillis();
        this.f56541n = 6;
    }

    public void traceRequestSendStart() {
        this.f56537j = SystemClock.uptimeMillis();
        this.f56541n = 8;
    }

    public void traceRequestSendEnd() {
        this.f56538k = SystemClock.uptimeMillis();
        this.f56541n = 9;
    }

    public void traceResponseReceiveStart() {
        this.f56539l = SystemClock.uptimeMillis();
        this.f56541n = 10;
    }

    public void traceResponseReceiveEnd() {
        this.f56540m = SystemClock.uptimeMillis();
        this.f56541n = 11;
    }

    public int getState() {
        int i = this.f56541n;
        if (i - 1 > 10) {
            return 10;
        }
        return i - 1;
    }

    public long getTotalCostTime() {
        return m40642a(this.f56530c - this.f56529b);
    }

    public long getDnsLookupTime() {
        return m40642a(this.f56532e - this.f56531d);
    }

    public long getConnectTime() {
        return m40642a(this.f56534g - this.f56533f);
    }

    public long getHandShakeTime() {
        return m40642a(this.f56536i - this.f56535h);
    }

    public long getRequestSendTime() {
        return m40642a(this.f56538k - this.f56537j);
    }

    public long getResponseReceiveTime() {
        return m40642a(this.f56540m - this.f56539l);
    }

    public long getStartTimeStamp() {
        return this.f56528a;
    }

    public long getStartTime() {
        return this.f56529b;
    }

    public long getEndTime() {
        return this.f56530c;
    }

    public long getDnsLookupStartTime() {
        return this.f56531d;
    }

    public long getDnsLookupEndTime() {
        return this.f56532e;
    }

    public long getConnectStartTime() {
        return this.f56533f;
    }

    public long getConnectEndTime() {
        return this.f56534g;
    }

    public long getSslHandShakeStartTime() {
        return this.f56535h;
    }

    public long getSslHandShakeEndTime() {
        return this.f56536i;
    }

    public long getRequestSendStartTime() {
        return this.f56537j;
    }

    public long getRequestSendEndTime() {
        return this.f56538k;
    }

    public long getResponseReceiveStartTime() {
        return this.f56539l;
    }

    public long getResponseReceiveEndTime() {
        return this.f56540m;
    }

    public String getTimeDescJson() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.f56528a);
        jSONArray.put(m40642a(this.f56531d - this.f56529b));
        jSONArray.put(m40642a(this.f56532e - this.f56529b));
        jSONArray.put(m40642a(this.f56533f - this.f56529b));
        jSONArray.put(m40642a(this.f56535h - this.f56529b));
        jSONArray.put(m40642a(this.f56536i - this.f56529b));
        jSONArray.put(m40642a(this.f56534g - this.f56529b));
        jSONArray.put(m40642a(this.f56537j - this.f56529b));
        jSONArray.put(m40642a(this.f56538k - this.f56529b));
        jSONArray.put(m40642a(this.f56539l - this.f56529b));
        jSONArray.put(m40642a(this.f56540m - this.f56529b));
        return jSONArray.toString();
    }

    public long getSinkCount() {
        return this.f56542o;
    }

    public void setSinkCount(long j) {
        this.f56542o = j;
    }

    public long getSourceCount() {
        return this.f56543p;
    }

    public void setSourceCount(long j) {
        this.f56543p = j;
    }

    public void setRequest(Request request) {
        if (request != null) {
            String header = request.header(HttpHeaders.HOST);
            if (TextUtils.isEmpty(header)) {
                this.f56544q = request.f56486a.f56453l;
            } else {
                this.f56544q = header;
            }
            this.f56545r = request.f56486a.encodedPath();
            this.f56546s = request.f56487b;
            this.f56547t = request.f56486a.f56452k;
            List<String> headers = request.headers("didi-header-rid");
            if (headers != null && !headers.isEmpty()) {
                this.f56523P = headers.get(0);
            }
            List<String> headers2 = request.headers(HttpHeaders.COOKIE);
            this.f56518K = 0;
            for (String bytes : headers2) {
                this.f56518K += (long) bytes.getBytes().length;
            }
        }
    }

    public String getHost() {
        return this.f56544q;
    }

    public String getPath() {
        return this.f56545r;
    }

    public String getMethod() {
        return this.f56546s;
    }

    public String getScheme() {
        return this.f56547t;
    }

    public void setResponse(Response response) {
        this.f56515H = response.f56494c;
        List<String> headers = response.headers("Set-Cookie");
        this.f56519L = 0;
        for (String bytes : headers) {
            this.f56519L += (long) bytes.getBytes().length;
        }
    }

    public int getResponseCode() {
        return this.f56515H;
    }

    public Throwable getThrowable() {
        return this.f56520M;
    }

    public void setThrowable(Throwable th) {
        this.f56520M = th;
    }

    public boolean hasError() {
        return this.f56520M != null;
    }

    public boolean isCloseConnection() {
        return this.f56522O;
    }

    public void setCloseConnection(boolean z) {
        this.f56522O = z;
    }

    public boolean isUseHttpDns() {
        return this.f56521N;
    }

    public void setUseHttpDns(boolean z) {
        this.f56521N = z;
    }

    public void setSocket(Socket socket) {
        if (socket != null) {
            this.f56548u = socket.getInetAddress();
            this.f56549v = socket.getPort();
            this.f56550w = socket.getLocalAddress();
            this.f56551x = socket.getLocalPort();
        }
    }

    public int getRemotePort() {
        return this.f56549v;
    }

    public InetAddress getRemoteAddress() {
        return this.f56548u;
    }

    public InetAddress getLocalAddress() {
        return this.f56550w;
    }

    public int getLocalPort() {
        return this.f56551x;
    }

    public Protocol getProtocol() {
        return this.f56516I;
    }

    public void setProtocol(Protocol protocol) {
        this.f56516I = protocol;
    }

    public boolean isConnReused() {
        return this.f56517J;
    }

    public void setConnReused(boolean z) {
        this.f56517J = z;
    }

    public void setHandShake(Handshake handshake) {
        if (handshake != null) {
            this.f56553z = handshake.tlsVersion();
            this.f56508A = handshake.cipherSuite().javaName();
            this.f56509B = handshake.peerCertificates();
            this.f56510C = handshake.localCertificates();
            this.f56511D = handshake.peerPrincipal();
            this.f56512E = handshake.localPrincipal();
            this.f56513F = 0;
            List<Certificate> list = this.f56509B;
            if (list != null && !list.isEmpty()) {
                for (Certificate next : this.f56509B) {
                    if (next != null) {
                        try {
                            byte[] encoded = next.getEncoded();
                            if (encoded != null) {
                                this.f56513F += (long) encoded.length;
                            }
                        } catch (CertificateEncodingException unused) {
                        }
                    }
                }
            }
            this.f56514G = handshake.getSessionId();
        }
    }

    public TlsVersion getTlsVersion() {
        return this.f56553z;
    }

    public String getCipherSuite() {
        return this.f56508A;
    }

    public List<Certificate> getPeerCertificates() {
        return Collections.unmodifiableList(this.f56509B);
    }

    public List<Certificate> getLocalCertificates() {
        return Collections.unmodifiableList(this.f56510C);
    }

    public Principal getPeerPrincipal() {
        return this.f56511D;
    }

    public Principal getLocalPrincipal() {
        return this.f56512E;
    }

    public String getTraceId() {
        return this.f56523P;
    }

    public Proxy getProxy() {
        return this.f56552y;
    }

    public void setProxy(Proxy proxy) {
        this.f56552y = proxy;
    }

    public long getPeerCertificatesSize() {
        return this.f56513F;
    }

    public long getRequestCookieSize() {
        return this.f56518K;
    }

    public long getResponseSetCookieSize() {
        return this.f56519L;
    }

    public void setConfigVersion(String str) {
        this.f56524Q = str;
    }

    public byte[] getSessionId() {
        return this.f56514G;
    }

    public String getConfigVersion() {
        return this.f56524Q;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo169815a(Map map) {
        map.put(Constants.STATE_CODE, Integer.valueOf(this.f56515H));
        map.put("up", Long.valueOf(this.f56542o));
        long j = this.f56543p;
        if ("https".equals(this.f56547t) && !this.f56517J) {
            long j2 = j + this.f56513F;
            byte[] bArr = this.f56514G;
            j = j2 + (bArr == null ? 0 : (long) bArr.length);
        }
        map.put("down", Long.valueOf(j));
        map.put("traceid", this.f56523P);
        map.put("method", this.f56546s);
        map.put(Constants.REUSE_CON, Integer.valueOf(this.f56517J ? 1 : 0));
        map.put(Constants.CON_STATE, Integer.valueOf(getState()));
        Protocol protocol = this.f56516I;
        map.put("proto", Integer.valueOf(protocol != null ? protocol.ordinal() : -1));
        map.put("conTimeStamp", getTimeDescJson());
        map.put(Constants.HTTP_DNS, Integer.valueOf(this.f56521N ? 1 : 0));
        InetAddress localAddress = getLocalAddress();
        if (localAddress != null) {
            map.put("localIp", "" + localAddress.getHostAddress());
        }
        InetAddress remoteAddress = getRemoteAddress();
        if (remoteAddress != null) {
            map.put("ip", "" + remoteAddress.getHostAddress());
        }
        long j3 = this.f56518K;
        if (j3 > 0) {
            map.put("reqCkSz", Long.valueOf(j3));
        }
        long j4 = this.f56519L;
        if (j4 > 0) {
            map.put("rspCkSz", Long.valueOf(j4));
        }
        Proxy proxy = getProxy();
        if (!(proxy == null || proxy.type() == Proxy.Type.DIRECT)) {
            map.put("pxy", "" + proxy);
        }
        if (!TextUtils.isEmpty(this.f56524Q)) {
            map.put("cfg", this.f56524Q);
        }
        map.put("appState", Integer.valueOf(this.f56525R));
        long j5 = this.f56526S;
        if (j5 > 0) {
            map.put("bkgDur", Long.valueOf(j5));
        }
        map.put("bootStatus", Integer.valueOf(this.f56527T));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo169816b(Map map) {
        map.put("Protocol", "" + this.f56516I);
        map.put("Scheme", "" + this.f56547t);
        map.put(HttpHeaders.HOST, "" + this.f56544q);
        map.put("Path", "" + this.f56545r);
        map.put("Method", "" + this.f56546s);
        map.put("State", Integer.valueOf(getState()));
        map.put("time", getTimeDescJson());
        map.put("ConnectionReused", Boolean.valueOf(this.f56517J));
        map.put("TraceID", "" + this.f56523P);
        map.put("HttpDNS", Boolean.valueOf(this.f56521N));
        map.put("RemoteAddress", "" + this.f56548u);
        map.put("RemotePort", Integer.valueOf(this.f56549v));
        map.put("LocalAddress", "" + this.f56550w);
        map.put("LocalPort", Integer.valueOf(this.f56551x));
        map.put("Proxy", "" + this.f56552y);
        map.put("tlsVersion", "" + this.f56553z);
        map.put("cipherSuite", "" + this.f56508A);
        map.put("responseCode", Integer.valueOf(this.f56515H));
        map.put("appState", Integer.valueOf(this.f56525R));
        long j = this.f56526S;
        if (j > 0) {
            map.put("bkgDur", Long.valueOf(j));
        }
        map.put("bootStatus", Integer.valueOf(this.f56527T));
    }

    public String toString() {
        return "ServerCallItem{" + "Protocol=" + this.f56516I + ", RemoteAddress=" + this.f56548u + ", RemotePort=" + this.f56549v + ", LocalAddress=" + this.f56550w + ", LocalPort=" + this.f56551x + ", proxy=" + this.f56552y + ", TotalCostTime=" + getTotalCostTime() + ", DnsLookupTime=" + getDnsLookupTime() + ", ConnectTime=" + getConnectTime() + ", HandShakeTime=" + getHandShakeTime() + ", RequestSendTime=" + getRequestSendTime() + ", ResponseReceiveTime=" + getResponseReceiveTime() + ", times=" + getTimeDescJson() + ", ConnectionReused=" + this.f56517J + ", sinkCount=" + this.f56542o + ", sourceCount=" + this.f56543p + ", host='" + this.f56544q + '\'' + ", path='" + this.f56545r + '\'' + ", method='" + this.f56546s + '\'' + ", scheme='" + this.f56547t + '\'' + ", tlsVersion=" + this.f56553z + ", cipherSuite=" + this.f56508A + ", peerCertificatesSize=" + this.f56513F + ", peerPrincipal=" + this.f56511D + ", localPrincipal=" + this.f56512E + ", requestCookieSize=" + this.f56518K + ", responseCode=" + this.f56515H + ", responseSetCookieSize=" + this.f56519L + ", throwable=" + this.f56520M + ", useHttpDns=" + this.f56521N + ", closeConnection=" + this.f56522O + ", state=" + getState() + ", traceId=" + this.f56523P + '}';
    }

    public void setAppState(int i) {
        this.f56525R = i;
    }

    public void setBkgDur(long j) {
        this.f56526S = j;
    }

    public void setBootStatus(int i) {
        this.f56527T = i;
    }
}
