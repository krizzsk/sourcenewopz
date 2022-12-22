package didihttp;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.google.firebase.messaging.Constants;
import didihttp.internal.trace.Tree;
import didinet.Logger;
import didinet.NetEngine;
import didinet.NetworkStateManager;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import org.json.JSONArray;

public class StatisticalContext {

    /* renamed from: a */
    private static String f56554a;

    /* renamed from: A */
    private String f56555A;

    /* renamed from: B */
    private TransDGCode f56556B = TransDGCode.NONE;

    /* renamed from: C */
    private StringBuilder f56557C = new StringBuilder();

    /* renamed from: b */
    private DidiHttpClient f56558b;

    /* renamed from: c */
    private Call f56559c;

    /* renamed from: d */
    private LinkedList<ServerCallItem> f56560d = new LinkedList<>();

    /* renamed from: e */
    private int f56561e = 0;

    /* renamed from: f */
    private int f56562f = 0;

    /* renamed from: g */
    private int f56563g = 0;

    /* renamed from: h */
    private Throwable f56564h;

    /* renamed from: i */
    private long f56565i;

    /* renamed from: j */
    private long f56566j;

    /* renamed from: k */
    private long f56567k;

    /* renamed from: l */
    private Dns f56568l;

    /* renamed from: m */
    private List<String> f56569m = new LinkedList();

    /* renamed from: n */
    private Request f56570n;

    /* renamed from: o */
    private Tree f56571o;

    /* renamed from: p */
    private int f56572p;

    /* renamed from: q */
    private long f56573q;

    /* renamed from: r */
    private long f56574r;

    /* renamed from: s */
    private String f56575s;

    /* renamed from: t */
    private String f56576t;

    /* renamed from: u */
    private boolean f56577u;

    /* renamed from: v */
    private boolean f56578v;

    /* renamed from: w */
    private int f56579w;

    /* renamed from: x */
    private int f56580x;

    /* renamed from: y */
    private int f56581y;

    /* renamed from: z */
    private int f56582z;

    static {
        try {
            SSLContext sSLContext = SSLContext.getDefault();
            SSLParameters supportedSSLParameters = sSLContext.getSupportedSSLParameters();
            SSLParameters defaultSSLParameters = sSLContext.getDefaultSSLParameters();
            Logger.m40928d("DidiHttp", "sslParameters.getProtocols = " + Arrays.toString(supportedSSLParameters.getProtocols()));
            Logger.m40928d("DidiHttp", "sslParameters.getProtocols = " + Arrays.toString(defaultSSLParameters.getProtocols()));
            f56554a = Arrays.toString(defaultSSLParameters.getProtocols()) + "/" + Arrays.toString(supportedSSLParameters.getProtocols());
        } catch (Exception unused) {
        }
    }

    StatisticalContext(DidiHttpClient didiHttpClient, Call call) {
        this.f56558b = didiHttpClient;
        this.f56559c = call;
    }

    public void newServerCallData() {
        this.f56560d.add(new ServerCallItem());
    }

    public ServerCallItem currentServerCallData() {
        if (this.f56560d.isEmpty()) {
            this.f56560d.add(new ServerCallItem());
        }
        return this.f56560d.getLast();
    }

    public void setUrlConfigVer(int i) {
        this.f56582z = i;
    }

    public void setIpStack(String str) {
        this.f56555A = str;
    }

    public void addRetryHDnsCount() {
        this.f56561e++;
    }

    public void addRetryCount() {
        this.f56562f++;
    }

    public void addRedirectCount() {
        this.f56563g++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo169898a(Throwable th) {
        this.f56564h = th;
    }

    public DidiHttpClient getDidiHttpClient() {
        return this.f56558b;
    }

    public Call getCall() {
        return this.f56559c;
    }

    public int getRetryCount() {
        return this.f56562f;
    }

    public int getRedirectCount() {
        return this.f56563g;
    }

    public Throwable getError() {
        return this.f56564h;
    }

    public Throwable getRootCause() {
        return m40647b(this.f56564h);
    }

    /* renamed from: b */
    private Throwable m40647b(Throwable th) {
        if (th == null) {
            return null;
        }
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    public boolean hasError() {
        return this.f56564h != null;
    }

    public void traceTotalStartTime() {
        this.f56565i = SystemClock.uptimeMillis();
    }

    public long getTotalStartTime() {
        return this.f56565i;
    }

    public void traceExecuteTime() {
        this.f56566j = SystemClock.uptimeMillis();
    }

    public void traceTotalEndTime() {
        this.f56567k = SystemClock.uptimeMillis();
    }

    public long getTotalTimeCost() {
        return this.f56567k - this.f56565i;
    }

    public long getWaitTimeCost() {
        long j = this.f56566j;
        long j2 = this.f56565i;
        if (j > j2) {
            return j - j2;
        }
        return 0;
    }

    public Collection<ServerCallItem> getServerCallDatas() {
        return Collections.unmodifiableList(this.f56560d);
    }

    public Dns getCustomDns() {
        return this.f56568l;
    }

    public void setCustomDns(Dns dns) {
        this.f56568l = dns;
    }

    public void addFailIP(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f56569m.add(str);
        }
    }

    public void addFailIP(InetAddress inetAddress) {
        if (inetAddress != null) {
            addFailIP(inetAddress.getHostAddress());
        }
    }

    public void appendRawHttpData(String str) {
        this.f56557C.append(str);
    }

    /* renamed from: a */
    private String m40645a() {
        return Base64.encodeToString(this.f56557C.toString().getBytes(), 2);
    }

    public void addDataToOmega(Map map) {
        currentServerCallData().mo169815a(map);
        map.put("netLib", "v1");
        map.put("redirectNum", Integer.valueOf(this.f56563g));
        map.put("retryHDns", Integer.valueOf(this.f56561e));
        map.put("retry", Integer.valueOf(this.f56562f));
        map.put("llstate", Integer.valueOf(this.f56572p));
        map.put("transDGCode", Integer.valueOf(this.f56556B.getValue()));
        map.put("transAckMs", Long.valueOf(getTransAckCost()));
        if (!TextUtils.isEmpty(this.f56555A)) {
            map.put("ipStack", this.f56555A);
        }
        NetworkStateManager networkStateManager = NetEngine.getInstance().getNetworkStateManager();
        if (networkStateManager != null) {
            if (!networkStateManager.isWifiAvailable()) {
                map.put("dcs", Integer.valueOf(networkStateManager.getDataConnectionState()));
                map.put("oss", Integer.valueOf(networkStateManager.getOperatorServiceState()));
            }
            String httpProxyInfo = networkStateManager.getHttpProxyInfo();
            if (!TextUtils.isEmpty(httpProxyInfo)) {
                map.put("proxy", httpProxyInfo);
            }
            String vpnInfo = networkStateManager.getVpnInfo();
            if (!TextUtils.isEmpty(vpnInfo)) {
                map.put("vpn", vpnInfo);
            }
        }
        map.put("time", Long.valueOf(getTotalTimeCost()));
        map.put(ParamKeys.PARAM_WAIT_TIME, Long.valueOf(getWaitTimeCost()));
        if (!"".equals(this.f56557C.toString())) {
            map.put(Constants.MessagePayloadKeys.RAW_DATA, m40645a());
        }
        int i = this.f56582z;
        if (i != 0) {
            map.put("urlConfVer", Integer.valueOf(i));
        }
        try {
            if (!this.f56569m.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (String put : this.f56569m) {
                    jSONArray.put(put);
                }
                map.put("failIPs", "" + jSONArray);
            }
        } catch (Exception unused) {
        }
        if (hasError()) {
            map.put(com.didichuxing.mas.sdk.quality.report.utils.Constants.ERROR_CODE, -1);
            map.put("e", getRootCause());
        } else {
            map.put(com.didichuxing.mas.sdk.quality.report.utils.Constants.ERROR_CODE, 0);
        }
        map.put("pushStat", Integer.valueOf(this.f56581y));
        if (!TextUtils.isEmpty(this.f56575s)) {
            map.put("transAddr", this.f56575s);
            if (!TextUtils.isEmpty(this.f56576t)) {
                map.put("pushVer", this.f56576t);
            }
            map.put("pushTLS", Integer.valueOf(this.f56577u ? 2 : 1));
            map.put("is_multi", Integer.valueOf(this.f56579w));
            map.put("conf_ver", Integer.valueOf(this.f56580x));
        }
        Tree tree = this.f56571o;
        if (tree != null) {
            String icpCost = tree.getIcpCost();
            if (!TextUtils.isEmpty(icpCost)) {
                map.put("icpCost", icpCost);
            }
        }
        if (Build.VERSION.SDK_INT > 19) {
            map.put("ssl_proto", m40646b());
        }
    }

    public void addDataToLocalStorage(Map map) {
        if (hasError()) {
            currentServerCallData().mo169816b(map);
            map.put("e", Log.getStackTraceString(this.f56564h));
            map.put("llstate", Integer.valueOf(this.f56572p));
            return;
        }
        ServerCallItem currentServerCallData = currentServerCallData();
        map.put("HttpDNS", Boolean.valueOf(currentServerCallData.isUseHttpDns()));
        map.put("responseCode", Integer.valueOf(currentServerCallData.getResponseCode()));
        map.put("llstate", Integer.valueOf(this.f56572p));
    }

    /* renamed from: b */
    private String m40646b() {
        String str = f56554a;
        return str == null ? "[TLSv1.3, TLSv1.2, TLSv1.1, TLSv1]" : str;
    }

    public int getLonglinkState() {
        return this.f56572p;
    }

    public void setLonglinkState(int i) {
        this.f56572p = i;
    }

    public void traceTransAckStart() {
        this.f56573q = SystemClock.uptimeMillis();
    }

    public void traceTransAckEnd() {
        this.f56574r = SystemClock.uptimeMillis();
    }

    public long getTransAckCost() {
        long j = this.f56574r - this.f56573q;
        if (j > 0) {
            return j;
        }
        return 0;
    }

    public Request getRequest() {
        Request request = this.f56570n;
        return request == null ? this.f56559c.request() : request;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo169897a(Request request) {
        this.f56570n = request;
    }

    public void setTransDGCode(TransDGCode transDGCode) {
        this.f56556B = transDGCode;
    }

    public TransDGCode getTransDGCode() {
        return this.f56556B;
    }

    public void setPushTLS(boolean z) {
        this.f56577u = z;
    }

    public boolean isHaveUsedTrans() {
        return this.f56578v;
    }

    public void setHaveUsedTrans(boolean z) {
        this.f56578v = z;
    }

    public void setIsPushMulti(int i) {
        this.f56579w = i;
    }

    public void setPushConfVer(int i) {
        this.f56580x = i;
    }

    public void setPushState(int i) {
        this.f56581y = i;
    }

    public enum TransDGCode {
        NONE(-1),
        TransReqDGRCodeOK(0),
        TransReqDGRCodePushNotConnected(1),
        TransReqDGRCodeApolloNotAllow(2),
        TransReqDGRCodeTransError(3),
        TransReqDGRCodeServerNotSupport(4),
        TransReqDGRCodeSetDisable(5),
        TransReqDGRCodeDecodeError(6),
        TransReqDGRCodeServerError(7),
        TransReqDGRCodeWaitTimeout(8),
        TransReqDGRCodeDataTooLarge(9),
        TransReqDGRCodePushNotInited(10),
        TransReqDGRCodeServerLimit(11);
        
        private int value;

        private TransDGCode(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public void setTransAddr(String str) {
        this.f56575s = str;
    }

    public void setPushVer(String str) {
        this.f56576t = str;
    }

    public void setInterceptorCallTree(Tree tree) {
        this.f56571o = tree;
    }
}
