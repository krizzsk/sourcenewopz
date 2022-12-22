package didihttp;

import android.os.SystemClock;
import com.didi.sdk.audiorecorder.utils.TimeUtil;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import didihttp.LogEventListener;
import didihttp.internal.C20747Util;
import didihttp.internal.trace.LogStrategy;
import didihttpdns.p230db.DnsConstants;
import didinet.ConnectCallback;
import didinet.DnsCallback;
import didinet.NetEngine;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultLogEventHandle implements LogEventListener {

    /* renamed from: a */
    private static Logger f56374a = null;

    /* renamed from: b */
    private static final String f56375b = "HttpTracker";

    /* renamed from: c */
    private boolean f56376c;

    /* renamed from: d */
    private long f56377d;

    /* renamed from: e */
    private long f56378e;

    /* renamed from: f */
    private final int f56379f;

    /* renamed from: g */
    private final boolean f56380g;

    /* renamed from: h */
    private final SimpleDateFormat f56381h = new SimpleDateFormat(TimeUtil.YMD_HMSS);

    static {
        try {
            f56374a = LoggerFactory.getLogger("didi_http", f56375b);
        } catch (Throwable unused) {
        }
    }

    public DefaultLogEventHandle(Call call, int i) {
        this.f56379f = i;
        String httpUrl = call.request().f56486a.toString();
        if (f56374a != null) {
            this.f56380g = LogStrategy.getStrategy().isLogOpen(httpUrl);
        } else {
            this.f56380g = false;
        }
    }

    public void callStart(Call call, int i) {
        if (this.f56380g) {
            String httpUrl = call.request().f56486a.toString();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "callStart");
            linkedHashMap.put("threadId", Integer.valueOf(i));
            linkedHashMap.put("url", httpUrl);
            m40583a(linkedHashMap);
        }
    }

    public void enqueue(Call call) {
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "enqueue");
            m40583a(linkedHashMap);
        }
    }

    public void interceptorStart(Call call, Object obj) {
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", C20747Util.fixClassName(obj.toString()) + " start");
            m40583a(linkedHashMap);
        }
    }

    public void interceptorEnd(Call call, Object obj) {
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", C20747Util.fixClassName(obj.toString()) + " end");
            m40583a(linkedHashMap);
        }
    }

    public void useHttpDns(Call call, boolean z) {
        this.f56376c = z;
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("useHttpDns", Boolean.valueOf(z));
            m40583a(linkedHashMap);
        }
    }

    public void dnsStart(Call call, String str) {
        this.f56377d = SystemClock.uptimeMillis();
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "dnsStart");
            linkedHashMap.put("host", str);
            m40583a(linkedHashMap);
        }
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        m40584a(true, (int) (SystemClock.uptimeMillis() - this.f56377d));
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "dnsEnd");
            linkedHashMap.put("host", str);
            if (list != null) {
                StringBuilder sb = new StringBuilder();
                for (InetAddress hostAddress : list) {
                    sb.append(hostAddress.getHostAddress());
                    sb.append(",");
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                linkedHashMap.put(DnsConstants.IPS, sb.toString());
            }
            m40583a(linkedHashMap);
        }
    }

    public void dnsFailed(Call call, String str, IOException iOException) {
        m40584a(false, (int) (SystemClock.uptimeMillis() - this.f56377d));
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "dnsFailed");
            linkedHashMap.put("host", str);
            linkedHashMap.put("reason", iOException.getMessage());
            m40583a(linkedHashMap);
        }
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        this.f56378e = SystemClock.uptimeMillis();
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "connectStart");
            m40583a(linkedHashMap);
        }
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        m40585b(true, (int) (SystemClock.uptimeMillis() - this.f56378e));
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "connectEnd");
            m40583a(linkedHashMap);
        }
    }

    public void connectFail(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        m40585b(false, (int) (SystemClock.uptimeMillis() - this.f56378e));
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "connectFail");
            linkedHashMap.put("reason", iOException.getMessage());
            if (inetSocketAddress != null) {
                linkedHashMap.put("address", inetSocketAddress.getHostString());
            }
            if (proxy != null) {
                linkedHashMap.put("proxy", proxy.toString());
            }
            if (protocol != null) {
                linkedHashMap.put("protocol", protocol.toString());
            }
            m40583a(linkedHashMap);
        }
    }

    public void tlsConnectStart(Call call) {
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "tlsStart");
            m40583a(linkedHashMap);
        }
    }

    public void tlsConnectEnd(Call call, Handshake handshake) {
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "tlsEnd");
            m40583a(linkedHashMap);
        }
    }

    public void connectionAcquired(Call call) {
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "connectionAcquired");
            m40583a(linkedHashMap);
        }
    }

    public void connectionReleased(Call call) {
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "connectionReleased");
            m40583a(linkedHashMap);
        }
    }

    public void transStart(Call call) {
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "transStart");
            m40583a(linkedHashMap);
        }
    }

    public void transEnd(Call call) {
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "transEnd");
            m40583a(linkedHashMap);
        }
    }

    public void transFail(Call call, Throwable th) {
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "transEnd");
            linkedHashMap.put("reason", th.getMessage());
            m40583a(linkedHashMap);
        }
    }

    public void receiveResponse(Call call) {
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "rcvRes");
            m40583a(linkedHashMap);
        }
    }

    public void callFailed(Call call, Throwable th) {
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "callFailed");
            linkedHashMap.put("reason", th.getMessage());
            m40583a(linkedHashMap);
        }
    }

    public void callEnd(Call call) {
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "callEnd");
            m40583a(linkedHashMap);
        }
    }

    public void retry(Call call, Throwable th) {
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "retry");
            linkedHashMap.put("reason", th.getMessage());
            m40583a(linkedHashMap);
        }
    }

    public void redirect(Call call) {
        if (this.f56380g) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("msg", "redirect");
            m40583a(linkedHashMap);
        }
    }

    /* renamed from: a */
    private void m40583a(Map<String, Object> map) {
        f56374a.infoEvent(String.format("%s %s id=%d", new Object[]{f56375b, this.f56381h.format(new Date()), Integer.valueOf(this.f56379f)}), (Map<?, ?>) map);
    }

    public static class FACTORY implements LogEventListener.Factory {
        AtomicInteger idGenerator = new AtomicInteger(0);

        public LogEventListener create(Call call) {
            return new DefaultLogEventHandle(call, this.idGenerator.getAndIncrement());
        }
    }

    public int getIdentity() {
        return this.f56379f;
    }

    /* renamed from: a */
    private void m40584a(boolean z, int i) {
        if (!this.f56376c) {
            NetEngine.getInstance().notifyDnsCallback(new DnsCallback.DnsContext(z, i));
        }
    }

    /* renamed from: b */
    private void m40585b(boolean z, int i) {
        NetEngine.getInstance().notifyConnectCallback(new ConnectCallback.ConnectContext(z, i));
    }
}
