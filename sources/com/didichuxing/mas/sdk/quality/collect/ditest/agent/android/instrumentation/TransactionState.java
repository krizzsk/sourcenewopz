package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.instrumentation;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.api.common.TransactionData;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLog;
import com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.logging.AgentLogManager;

public final class TransactionState {

    /* renamed from: a */
    private static final AgentLog f47947a = AgentLogManager.getAgentLog();

    /* renamed from: b */
    private final String f47948b = "businesstype";

    /* renamed from: c */
    private String f47949c;

    /* renamed from: d */
    private String f47950d;

    /* renamed from: e */
    private int f47951e;

    /* renamed from: f */
    private int f47952f;

    /* renamed from: g */
    private long f47953g;

    /* renamed from: h */
    private long f47954h;

    /* renamed from: i */
    private long f47955i = System.currentTimeMillis();

    /* renamed from: j */
    private long f47956j;

    /* renamed from: k */
    private String f47957k = "unknown";

    /* renamed from: l */
    private String f47958l = "unknown";

    /* renamed from: m */
    private State f47959m = State.READY;

    /* renamed from: n */
    private String f47960n;

    /* renamed from: o */
    private TransactionData f47961o;

    /* renamed from: p */
    private int f47962p;

    /* renamed from: q */
    private String f47963q;

    /* renamed from: r */
    private boolean f47964r;

    /* renamed from: s */
    private long f47965s;

    /* renamed from: t */
    private long f47966t;

    /* renamed from: u */
    private NetIntfaceType f47967u = NetIntfaceType.UNKNOWN;

    /* renamed from: v */
    private long f47968v;

    /* renamed from: w */
    private long f47969w;

    /* renamed from: x */
    private String f47970x;

    /* renamed from: y */
    private String f47971y;

    public enum NetIntfaceType {
        HTTP_URL_CONNECTION,
        HTTPCLIENT,
        OKHTTP2,
        UNKNOWN
    }

    private enum State {
        READY,
        SENT,
        COMPLETE
    }

    public TransactionState(NetIntfaceType netIntfaceType) {
        this.f47967u = netIntfaceType;
    }

    public TransactionState() {
    }

    public void setCarrier(String str) {
        if (!isSent()) {
            this.f47957k = str;
            return;
        }
        AgentLog agentLog = f47947a;
        agentLog.warning("setCarrier(...) called on TransactionState in " + this.f47959m.toString() + " state");
    }

    public void setWanType(String str) {
        if (!isSent()) {
            this.f47958l = str;
            return;
        }
        AgentLog agentLog = f47947a;
        agentLog.warning("setWanType(...) called on TransactionState in " + this.f47959m.toString() + " state");
    }

    public long getBytesHeaderSent() {
        return this.f47965s;
    }

    public void setBytesHeaderSent(long j) {
        this.f47965s = j;
    }

    public long getBytesHeaderReceived() {
        return this.f47966t;
    }

    public void setBytesHeaderReceived(long j) {
        this.f47966t = j;
    }

    public void setUrl(String str) {
        parseBusinessType(str);
        if (str == null) {
            return;
        }
        if (!isSent()) {
            this.f47968v += (long) (str.length() + 14);
            this.f47949c = str;
            return;
        }
        f47947a.warning("setUrl(...) called on TransactionState in " + this.f47959m.toString() + " state");
    }

    public void setHttpMethod(String str) {
        if (!isSent()) {
            this.f47950d = str;
            return;
        }
        AgentLog agentLog = f47947a;
        agentLog.warning("setHttpMethod(...) called on TransactionState in " + this.f47959m.toString() + " state");
    }

    public String getUrl() {
        return this.f47949c;
    }

    public String getHttpMethod() {
        return this.f47950d;
    }

    public boolean isSent() {
        return this.f47959m.ordinal() >= State.SENT.ordinal();
    }

    public boolean isComplete() {
        return this.f47959m.ordinal() >= State.COMPLETE.ordinal();
    }

    public void setStatusCode(int i) {
        if (!isComplete()) {
            this.f47951e = i;
            this.f47969w += 16;
            return;
        }
        f47947a.warning("setStatusCode(...) called on TransactionState in " + this.f47959m.toString() + " state");
    }

    public int getStatusCode() {
        return this.f47951e;
    }

    public void setErrorCode(int i) {
        if (!isComplete()) {
            this.f47952f = i;
            return;
        }
        AgentLog agentLog = f47947a;
        agentLog.warning("setErrorCode(...) called on TransactionState in " + this.f47959m.toString() + " state");
    }

    public int getErrorCode() {
        return this.f47952f;
    }

    public void setBytesSent(long j) {
        if (!isComplete()) {
            this.f47953g = j;
            this.f47959m = State.SENT;
            return;
        }
        AgentLog agentLog = f47947a;
        agentLog.warning("setBytesSent(...) called on TransactionState in " + this.f47959m.toString() + " state");
    }

    public void setBytesReceived(long j) {
        if (!isComplete()) {
            this.f47954h = j;
            return;
        }
        AgentLog agentLog = f47947a;
        agentLog.warning("setBytesReceived(...) called on TransactionState in " + this.f47959m.toString() + " state, value:" + j);
    }

    public long getBytesReceived() {
        return this.f47954h;
    }

    public TransactionData end() {
        if (!isComplete()) {
            this.f47959m = State.COMPLETE;
            this.f47956j = System.currentTimeMillis();
        }
        return m34242a();
    }

    /* renamed from: a */
    private TransactionData m34242a() {
        if (!isComplete()) {
            f47947a.warning("toTransactionData() called on incomplete TransactionState");
        }
        if (this.f47954h + this.f47966t + this.f47969w == 0) {
            AgentLog agentLog = f47947a;
            agentLog.debug("apm net interface type:" + this.f47967u.toString());
        }
        String str = this.f47949c;
        if (str == null) {
            f47947a.error("Attempted to convert a TransactionState instance with no URL into a TransactionData");
            return null;
        }
        if (this.f47961o == null) {
            TransactionData transactionData = r3;
            TransactionData transactionData2 = new TransactionData(str, this.f47950d, this.f47957k, this.f47956j - this.f47955i, this.f47951e, this.f47952f, this.f47953g + this.f47965s + this.f47968v, this.f47954h + this.f47966t + this.f47969w, this.f47958l, this.f47962p, this.f47963q, this.f47964r, this.f47970x, this.f47971y);
            this.f47961o = transactionData;
        }
        return this.f47961o;
    }

    public int getBusinessType() {
        return this.f47962p;
    }

    public void setBusinessType(int i) {
        this.f47962p = i;
    }

    public String getTraceId() {
        return this.f47963q;
    }

    public void setTraceId(String str) {
        this.f47963q = str;
    }

    public String getContentType() {
        return this.f47960n;
    }

    public void setContentType(String str) {
        this.f47960n = str;
    }

    public void parseBusinessType(String str) {
        if (str != null) {
            int indexOf = str.indexOf(63);
            if (indexOf > 0) {
                str = str.substring(indexOf + 1);
            }
            String[] split = str.split(ParamKeys.SIGN_AND);
            for (String split2 : split) {
                String[] split3 = split2.split("=");
                if (split3.length == 2 && split3[0].equals("businesstype")) {
                    try {
                        setBusinessType(Integer.parseInt(split3[1]));
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        }
    }

    public long getBytesRequestLine() {
        return this.f47968v;
    }

    public void setBytesRequestLine(long j) {
        this.f47968v = j;
    }

    public long getBytesStatusLine() {
        return this.f47969w;
    }

    public void setBytesStatusLine(long j) {
        this.f47969w = j;
    }

    public String getErrCodeClass() {
        return this.f47970x;
    }

    public void setErrCodeClass(String str) {
        this.f47970x = str;
    }

    public String getErrCodeInfo() {
        return this.f47971y;
    }

    public void setErrCodeInfo(String str) {
        this.f47971y = str;
    }

    public String toString() {
        return "TransactionState{url='" + this.f47949c + '\'' + ", httpMethod='" + this.f47950d + '\'' + ", statusCode=" + this.f47951e + ", errorCode=" + this.f47952f + ", bytesSent=" + this.f47953g + ", bytesReceived=" + this.f47954h + ", startTime=" + this.f47955i + ", endTime=" + this.f47956j + ", carrier='" + this.f47957k + '\'' + ", wanType='" + this.f47958l + '\'' + ", state=" + this.f47959m + ", contentType='" + this.f47960n + '\'' + ", transactionData=" + this.f47961o + '}';
    }
}
