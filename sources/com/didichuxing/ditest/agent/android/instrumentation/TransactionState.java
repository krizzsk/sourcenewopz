package com.didichuxing.ditest.agent.android.instrumentation;

import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.ditest.agent.android.api.common.TransactionData;
import com.didichuxing.ditest.agent.android.logging.AgentLog;
import com.didichuxing.ditest.agent.android.logging.AgentLogManager;

public final class TransactionState {
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private final String DIDI_BUSINESS_TYPE_KEY = "businesstype";
    private int businessType;
    private long bytesHeaderReceived;
    private long bytesHeaderSent;
    private long bytesReceived;
    private long bytesRequestLine;
    private long bytesSent;
    private long bytesStatusLine;
    private String carrier = "unknown";
    private String contentType;
    private long endTime;
    private String errCodeClass;
    private String errCodeInfo;
    private int errorCode;
    private boolean forground;
    private String httpMethod;
    private NetIntfaceType netIntfaceType = NetIntfaceType.UNKNOWN;
    private long startTime = System.currentTimeMillis();
    private State state = State.READY;
    private int statusCode;
    private String traceId;
    private TransactionData transactionData;
    private String url;
    private String wanType = "unknown";

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

    public TransactionState(NetIntfaceType netIntfaceType2) {
        this.netIntfaceType = netIntfaceType2;
    }

    public TransactionState() {
    }

    public void setCarrier(String str) {
        if (!isSent()) {
            this.carrier = str;
            return;
        }
        AgentLog agentLog = log;
        agentLog.warning("setCarrier(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setWanType(String str) {
        if (!isSent()) {
            this.wanType = str;
            return;
        }
        AgentLog agentLog = log;
        agentLog.warning("setWanType(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public long getBytesHeaderSent() {
        return this.bytesHeaderSent;
    }

    public void setBytesHeaderSent(long j) {
        this.bytesHeaderSent = j;
    }

    public long getBytesHeaderReceived() {
        return this.bytesHeaderReceived;
    }

    public void setBytesHeaderReceived(long j) {
        this.bytesHeaderReceived = j;
    }

    public void setUrl(String str) {
        parseBusinessType(str);
        if (str == null) {
            return;
        }
        if (!isSent()) {
            this.bytesRequestLine += (long) (str.length() + 14);
            this.url = str;
            return;
        }
        log.warning("setUrl(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setHttpMethod(String str) {
        if (!isSent()) {
            this.httpMethod = str;
            return;
        }
        AgentLog agentLog = log;
        agentLog.warning("setHttpMethod(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public String getUrl() {
        return this.url;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public boolean isSent() {
        return this.state.ordinal() >= State.SENT.ordinal();
    }

    public boolean isComplete() {
        return this.state.ordinal() >= State.COMPLETE.ordinal();
    }

    public void setStatusCode(int i) {
        if (!isComplete()) {
            this.statusCode = i;
            this.bytesStatusLine += 16;
            return;
        }
        log.warning("setStatusCode(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setErrorCode(int i) {
        if (!isComplete()) {
            this.errorCode = i;
            return;
        }
        AgentLog agentLog = log;
        agentLog.warning("setErrorCode(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setBytesSent(long j) {
        if (!isComplete()) {
            this.bytesSent = j;
            this.state = State.SENT;
            return;
        }
        AgentLog agentLog = log;
        agentLog.warning("setBytesSent(...) called on TransactionState in " + this.state.toString() + " state");
    }

    public void setBytesReceived(long j) {
        if (!isComplete()) {
            this.bytesReceived = j;
            return;
        }
        AgentLog agentLog = log;
        agentLog.warning("setBytesReceived(...) called on TransactionState in " + this.state.toString() + " state, value:" + j);
    }

    public long getBytesReceived() {
        return this.bytesReceived;
    }

    public TransactionData end() {
        if (!isComplete()) {
            this.state = State.COMPLETE;
            this.endTime = System.currentTimeMillis();
        }
        return toTransactionData();
    }

    private TransactionData toTransactionData() {
        if (!isComplete()) {
            log.warning("toTransactionData() called on incomplete TransactionState");
        }
        if (this.bytesReceived + this.bytesHeaderReceived + this.bytesStatusLine == 0) {
            AgentLog agentLog = log;
            agentLog.debug("apm net interface type:" + this.netIntfaceType.toString());
        }
        String str = this.url;
        if (str == null) {
            log.error("Attempted to convert a TransactionState instance with no URL into a TransactionData");
            return null;
        }
        if (this.transactionData == null) {
            TransactionData transactionData2 = r3;
            TransactionData transactionData3 = new TransactionData(str, this.httpMethod, this.carrier, this.endTime - this.startTime, this.statusCode, this.errorCode, this.bytesSent + this.bytesHeaderSent + this.bytesRequestLine, this.bytesReceived + this.bytesHeaderReceived + this.bytesStatusLine, this.wanType, this.businessType, this.traceId, this.forground, this.errCodeClass, this.errCodeInfo);
            this.transactionData = transactionData2;
        }
        return this.transactionData;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public void setBusinessType(int i) {
        this.businessType = i;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public String getContentType() {
        return this.contentType;
    }

    public void setContentType(String str) {
        this.contentType = str;
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
        return this.bytesRequestLine;
    }

    public void setBytesRequestLine(long j) {
        this.bytesRequestLine = j;
    }

    public long getBytesStatusLine() {
        return this.bytesStatusLine;
    }

    public void setBytesStatusLine(long j) {
        this.bytesStatusLine = j;
    }

    public String getErrCodeClass() {
        return this.errCodeClass;
    }

    public void setErrCodeClass(String str) {
        this.errCodeClass = str;
    }

    public String getErrCodeInfo() {
        return this.errCodeInfo;
    }

    public void setErrCodeInfo(String str) {
        this.errCodeInfo = str;
    }

    public String toString() {
        return "TransactionState{url='" + this.url + '\'' + ", httpMethod='" + this.httpMethod + '\'' + ", statusCode=" + this.statusCode + ", errorCode=" + this.errorCode + ", bytesSent=" + this.bytesSent + ", bytesReceived=" + this.bytesReceived + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", carrier='" + this.carrier + '\'' + ", wanType='" + this.wanType + '\'' + ", state=" + this.state + ", contentType='" + this.contentType + '\'' + ", transactionData=" + this.transactionData + '}';
    }
}
