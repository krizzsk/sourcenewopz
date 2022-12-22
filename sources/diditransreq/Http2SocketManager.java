package diditransreq;

import com.didi.raven.config.RavenKey;
import com.squareup.wire.Wire;
import didihttp.Request;
import didihttp.Response;
import didihttp.ServerCallItem;
import didihttp.StatisticalContext;
import didinet.Logger;
import didinet.NetEngine;
import didinet.NetworkStateManager;
import didinet.OmegaAPI;
import didinet.PushAPI;
import diditransreq.p231pb.MsgType;
import diditransreq.p231pb.PushMsg;
import diditransreq.p231pb.ReqPack;
import diditransreq.p231pb.TransReq;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import okio.ByteString;

class Http2SocketManager {

    /* renamed from: a */
    private static final String f57165a = "Http2Socket";

    /* renamed from: d */
    private static boolean f57166d = false;

    /* renamed from: e */
    private static final int f57167e = 3842;

    /* renamed from: f */
    private static final int f57168f = 3844;

    /* renamed from: g */
    private static final int f57169g = 1024;

    /* renamed from: h */
    private static final ThreadLocal<Wire> f57170h = new ThreadLocal<>();

    /* renamed from: j */
    private static final int f57171j = 30000;

    /* renamed from: b */
    private Map<Long, ReqRepPair> f57172b;

    /* renamed from: c */
    private final Lock f57173c;

    /* renamed from: i */
    private List<String> f57174i;

    /* renamed from: k */
    private TransReqPushCallback f57175k;

    static class SingletonHolder {
        /* access modifiers changed from: private */
        public static Http2SocketManager INSTANCE = new Http2SocketManager();

        SingletonHolder() {
        }
    }

    /* renamed from: a */
    public static Http2SocketManager m40976a() {
        return SingletonHolder.INSTANCE;
    }

    private Http2SocketManager() {
        this.f57173c = new ReentrantLock();
        this.f57174i = new CopyOnWriteArrayList();
        this.f57175k = new TransReqPushCallback();
        this.f57172b = new HashMap();
        NetEngine.getInstance().getPushAPI().addPushCallback(this.f57175k);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Response mo170578a(Request request, StatisticalContext statisticalContext, ServerCallItem serverCallItem) throws IOException {
        Request request2 = request;
        StatisticalContext statisticalContext2 = statisticalContext;
        ServerCallItem serverCallItem2 = serverCallItem;
        serverCallItem.traceRequestSendStart();
        int b = Http2SocketParam.getParam().mo170583b();
        ReqPack a = C20808a.m40998a(request);
        boolean z = a.toByteArray().length >= b;
        byte[] byteArray = a.toByteArray();
        if (z) {
            byteArray = C20809b.m41000a(byteArray);
        }
        TransReq build = new TransReq.Builder().seqid(1L).compressed_pack(ByteString.m3608of(byteArray, 0, byteArray.length)).compression_format(Integer.valueOf(z ? 1 : 0)).timeout_ms(30000).ver(1).build();
        Logger.m40928d(f57165a, String.format("[%s] Transreq compress is [%s], length:[%d zip=> %d], compressBase:[%d]", new Object[]{f57165a, Boolean.valueOf(z), Integer.valueOf(a.toByteArray().length), Integer.valueOf(C20809b.m41000a(a.toByteArray()).length), Integer.valueOf(b)}));
        PushAPI pushAPI = NetEngine.getInstance().getPushAPI();
        int value = MsgType.kMsgTypeTransReq.getValue();
        byte[] bArr = new byte[8];
        byte[] byteArray2 = build.toByteArray();
        if (byteArray2.length > 10240) {
            statisticalContext2.setTransDGCode(StatisticalContext.TransDGCode.TransReqDGRCodeDataTooLarge);
            Logger.m40928d(f57165a, String.format("[%s] Transreq failed because request data is too large, length:[%d]", new Object[]{f57165a, Integer.valueOf(byteArray2.length)}));
            return null;
        }
        serverCallItem2.setSinkCount((long) byteArray2.length);
        NetworkStateManager networkStateManager = NetEngine.getInstance().getNetworkStateManager();
        HashMap hashMap = new HashMap();
        hashMap.put(RavenKey.TYPE, Long.valueOf(System.currentTimeMillis()));
        if (networkStateManager != null && networkStateManager.isWifiAvailable()) {
            hashMap.put("wan_type", "wifi");
        } else if (networkStateManager == null || !networkStateManager.isMobileAvailable()) {
            hashMap.put("wan_type", "unknown");
        } else {
            hashMap.put("wan_type", networkStateManager.getNetworkClassDesc());
        }
        this.f57173c.lock();
        try {
            int request3 = pushAPI.request(value, byteArray2, 0, bArr, false);
            serverCallItem.traceRequestSendEnd();
            Logger.m40928d(f57165a, String.format("[%s] Transreq send request [%d]", new Object[]{f57165a, Integer.valueOf(request3)}));
            if (request3 != 0) {
                statisticalContext2.setTransDGCode(StatisticalContext.TransDGCode.TransReqDGRCodeTransError);
                return null;
            }
            statisticalContext.traceTransAckStart();
            serverCallItem.traceResponseReceiveStart();
            ReqRepPair reqRepPair = new ReqRepPair();
            reqRepPair.request = request2;
            reqRepPair.item = serverCallItem2;
            reqRepPair.context = statisticalContext2;
            long j = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getLong();
            this.f57172b.put(Long.valueOf(j), reqRepPair);
            hashMap.put("seq_id", Long.valueOf(j));
            BypassProbing.getDefault().mo170573a(j);
            this.f57173c.unlock();
            synchronized (request) {
                try {
                    int a2 = Http2SocketParam.getParam().mo170581a() * 1000;
                    Logger.m40928d(f57165a, String.format("[%s] Transreq wait to receive response [%dms]", new Object[]{f57165a, Integer.valueOf(a2)}));
                    request2.wait((long) a2);
                } catch (InterruptedException e) {
                    Logger.m40930e(f57165a, "InterruptedException occurs when Transreq wait to receive : " + e.getMessage());
                }
            }
            this.f57173c.lock();
            try {
                ReqRepPair remove = this.f57172b.remove(Long.valueOf(j));
                Response response = remove != null ? remove.response : null;
                if (response == null) {
                    if (statisticalContext.getTransDGCode() == StatisticalContext.TransDGCode.TransReqDGRCodeOK) {
                        statisticalContext2.setTransDGCode(StatisticalContext.TransDGCode.TransReqDGRCodeWaitTimeout);
                        OmegaAPI omegaAPI = NetEngine.getInstance().getOmegaAPI();
                        hashMap.put("url", request.url().toString());
                        hashMap.put("msg_size", Integer.valueOf(byteArray2.length));
                        omegaAPI.trackEvent("trans_timeout_detail", (String) null, hashMap);
                    }
                    Logger.m40928d(f57165a, String.format("[%s] Transreq failed! DGCode is %s, seqid is %d", new Object[]{f57165a, statisticalContext.getTransDGCode(), Long.valueOf(j)}));
                }
                return response;
            } finally {
                this.f57173c.unlock();
            }
        } finally {
            this.f57173c.unlock();
        }
    }

    public class TransReqPushCallback implements PushAPI.PushCallback {
        public TransReqPushCallback() {
        }

        public void response(int i, int i2, byte[] bArr, PushMsg pushMsg) {
            if (i == MsgType.kMsgTypeAppPushMessageReq.getValue()) {
                Http2SocketManager.this.m40977a(i2, bArr, pushMsg);
            }
            if (i == MsgType.kMsgTypeTransRsp.getValue()) {
                Http2SocketManager.this.m40980a(bArr);
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40980a(byte[] bArr) {
        long j = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getLong();
        this.f57173c.lock();
        try {
            ReqRepPair reqRepPair = this.f57172b.get(Long.valueOf(j));
            this.f57173c.unlock();
            if (reqRepPair == null) {
                Logger.m40928d(f57165a, String.format("[%s] Transreq didn't find req/rsp pair!", new Object[]{f57165a}));
                return;
            }
            StatisticalContext statisticalContext = reqRepPair.context;
            statisticalContext.traceTransAckEnd();
            Logger.m40928d(f57165a, String.format("[%s] Receive ask package, seqid => %d, cost => %d", new Object[]{f57165a, Long.valueOf(j), Long.valueOf(statisticalContext.getTransAckCost())}));
        } catch (Throwable th) {
            this.f57173c.unlock();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x02da  */
    /* JADX WARNING: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m40977a(int r18, byte[] r19, diditransreq.p231pb.PushMsg r20) {
        /*
            r17 = this;
            r1 = r17
            diditransreq.pb.PushMessageType r0 = diditransreq.p231pb.PushMessageType.kPushMessageTypeTransBackendRsp
            int r0 = r0.getValue()
            r2 = r18
            if (r2 == r0) goto L_0x000d
            return
        L_0x000d:
            r3 = 0
            r4 = 1
            java.lang.ThreadLocal<com.squareup.wire.Wire> r0 = f57170h     // Catch:{ all -> 0x02be }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x02be }
            com.squareup.wire.Wire r0 = (com.squareup.wire.Wire) r0     // Catch:{ all -> 0x02be }
            if (r0 != 0) goto L_0x0025
            com.squareup.wire.Wire r0 = new com.squareup.wire.Wire     // Catch:{ all -> 0x02be }
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ all -> 0x02be }
            r0.<init>((java.lang.Class<?>[]) r5)     // Catch:{ all -> 0x02be }
            java.lang.ThreadLocal<com.squareup.wire.Wire> r5 = f57170h     // Catch:{ all -> 0x02be }
            r5.set(r0)     // Catch:{ all -> 0x02be }
        L_0x0025:
            r5 = r20
            okio.ByteString r6 = r5.payload     // Catch:{ all -> 0x02be }
            okio.ByteString r7 = diditransreq.p231pb.PushMsg.DEFAULT_PAYLOAD     // Catch:{ all -> 0x02be }
            java.lang.Object r6 = com.squareup.wire.Wire.get(r6, r7)     // Catch:{ all -> 0x02be }
            okio.ByteString r6 = (okio.ByteString) r6     // Catch:{ all -> 0x02be }
            byte[] r6 = r6.toByteArray()     // Catch:{ all -> 0x02be }
            java.lang.Class<diditransreq.pb.TransBackendRsp> r7 = diditransreq.p231pb.TransBackendRsp.class
            com.squareup.wire.Message r6 = r0.parseFrom((byte[]) r6, r7)     // Catch:{ all -> 0x02be }
            diditransreq.pb.TransBackendRsp r6 = (diditransreq.p231pb.TransBackendRsp) r6     // Catch:{ all -> 0x02be }
            java.lang.Long r7 = r6.f57192sc     // Catch:{ all -> 0x02be }
            r8 = -1
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x02be }
            java.lang.Object r7 = com.squareup.wire.Wire.get(r7, r8)     // Catch:{ all -> 0x02be }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x02be }
            long r7 = r7.longValue()     // Catch:{ all -> 0x02be }
            java.lang.String r9 = r6.msg     // Catch:{ all -> 0x02be }
            java.lang.String r10 = ""
            java.lang.Object r9 = com.squareup.wire.Wire.get(r9, r10)     // Catch:{ all -> 0x02be }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x02be }
            java.lang.Long r10 = r6.seqid     // Catch:{ all -> 0x02be }
            java.lang.Long r11 = diditransreq.p231pb.TransBackendRsp.DEFAULT_SEQID     // Catch:{ all -> 0x02be }
            java.lang.Object r10 = com.squareup.wire.Wire.get(r10, r11)     // Catch:{ all -> 0x02be }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ all -> 0x02be }
            long r10 = r10.longValue()     // Catch:{ all -> 0x02be }
            diditransreq.BypassProbing r12 = diditransreq.BypassProbing.getDefault()     // Catch:{ all -> 0x02be }
            r12.mo170574b((long) r10)     // Catch:{ all -> 0x02be }
            java.lang.String r12 = "Http2Socket"
            java.lang.String r13 = "[%s] Transreq got TransBackendRsp [seqid: %d, sc: %d, msg: %s]"
            r14 = 4
            java.lang.Object[] r15 = new java.lang.Object[r14]     // Catch:{ all -> 0x02be }
            java.lang.String r16 = "Http2Socket"
            r15[r3] = r16     // Catch:{ all -> 0x02be }
            java.lang.Long r16 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x02be }
            r15[r4] = r16     // Catch:{ all -> 0x02be }
            java.lang.Long r16 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x02be }
            r2 = 2
            r15[r2] = r16     // Catch:{ all -> 0x02be }
            r16 = 3
            r15[r16] = r9     // Catch:{ all -> 0x02be }
            java.lang.String r9 = java.lang.String.format(r13, r15)     // Catch:{ all -> 0x02be }
            didinet.Logger.m40928d(r12, r9)     // Catch:{ all -> 0x02be }
            java.util.concurrent.locks.Lock r9 = r1.f57173c     // Catch:{ all -> 0x02be }
            r9.lock()     // Catch:{ all -> 0x02be }
            java.util.Map<java.lang.Long, diditransreq.Http2SocketManager$ReqRepPair> r9 = r1.f57172b     // Catch:{ all -> 0x02b7 }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x02b7 }
            java.lang.Object r9 = r9.get(r10)     // Catch:{ all -> 0x02b7 }
            diditransreq.Http2SocketManager$ReqRepPair r9 = (diditransreq.Http2SocketManager.ReqRepPair) r9     // Catch:{ all -> 0x02b7 }
            java.util.concurrent.locks.Lock r10 = r1.f57173c     // Catch:{ all -> 0x02be }
            r10.unlock()     // Catch:{ all -> 0x02be }
            if (r9 != 0) goto L_0x00bb
            java.lang.String r0 = "Http2Socket"
            java.lang.String r2 = "[%s] Transreq didn't find req/rsp pair!"
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x02be }
            java.lang.String r6 = "Http2Socket"
            r5[r3] = r6     // Catch:{ all -> 0x02be }
            java.lang.String r2 = java.lang.String.format(r2, r5)     // Catch:{ all -> 0x02be }
            didinet.Logger.m40928d(r0, r2)     // Catch:{ all -> 0x02be }
            return
        L_0x00bb:
            didihttp.StatisticalContext r10 = r9.context     // Catch:{ all -> 0x02be }
            didihttp.Request r11 = r9.request     // Catch:{ all -> 0x02be }
            r12 = 0
            int r15 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r15 == 0) goto L_0x0129
            r5 = 3842(0xf02, double:1.898E-320)
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x00f9
            java.lang.String r0 = "Http2Socket"
            java.lang.String r5 = "[%s] response sc is %d"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x02b4 }
            java.lang.String r6 = "Http2Socket"
            r2[r3] = r6     // Catch:{ all -> 0x02b4 }
            java.lang.Long r6 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x02b4 }
            r2[r4] = r6     // Catch:{ all -> 0x02b4 }
            java.lang.String r2 = java.lang.String.format(r5, r2)     // Catch:{ all -> 0x02b4 }
            didinet.Logger.m40928d(r0, r2)     // Catch:{ all -> 0x02b4 }
            didihttp.Request r0 = r9.request     // Catch:{ all -> 0x02b4 }
            didihttp.HttpUrl r0 = r0.url()     // Catch:{ all -> 0x02b4 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x02b4 }
            java.lang.String r0 = m40982c(r0)     // Catch:{ all -> 0x02b4 }
            r1.mo170579a((java.lang.String) r0)     // Catch:{ all -> 0x02b4 }
            didihttp.StatisticalContext$TransDGCode r0 = didihttp.StatisticalContext.TransDGCode.TransReqDGRCodeServerNotSupport     // Catch:{ all -> 0x02b4 }
            r10.setTransDGCode(r0)     // Catch:{ all -> 0x02b4 }
            goto L_0x010c
        L_0x00f9:
            r5 = 3844(0xf04, double:1.899E-320)
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 != 0) goto L_0x0107
            f57166d = r4     // Catch:{ all -> 0x02b4 }
            didihttp.StatisticalContext$TransDGCode r0 = didihttp.StatisticalContext.TransDGCode.TransReqDGRCodeServerLimit     // Catch:{ all -> 0x02b4 }
            r10.setTransDGCode(r0)     // Catch:{ all -> 0x02b4 }
            goto L_0x010c
        L_0x0107:
            didihttp.StatisticalContext$TransDGCode r0 = didihttp.StatisticalContext.TransDGCode.TransReqDGRCodeServerError     // Catch:{ all -> 0x02b4 }
            r10.setTransDGCode(r0)     // Catch:{ all -> 0x02b4 }
        L_0x010c:
            if (r11 == 0) goto L_0x0128
            monitor-enter(r11)
            java.lang.String r0 = "Http2Socket"
            java.lang.String r2 = "[%s] Transreq notify to continue"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0125 }
            java.lang.String r5 = "Http2Socket"
            r4[r3] = r5     // Catch:{ all -> 0x0125 }
            java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ all -> 0x0125 }
            didinet.Logger.m40928d(r0, r2)     // Catch:{ all -> 0x0125 }
            r11.notify()     // Catch:{ all -> 0x0125 }
            monitor-exit(r11)     // Catch:{ all -> 0x0125 }
            goto L_0x0128
        L_0x0125:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0125 }
            throw r0
        L_0x0128:
            return
        L_0x0129:
            didihttp.ServerCallItem r7 = r9.item     // Catch:{ all -> 0x02b4 }
            r7.traceResponseReceiveEnd()     // Catch:{ all -> 0x02b4 }
            int r5 = r20.getSerializedSize()     // Catch:{ all -> 0x02b4 }
            long r12 = (long) r5     // Catch:{ all -> 0x02b4 }
            r7.setSourceCount(r12)     // Catch:{ all -> 0x02b4 }
            okio.ByteString r5 = r6.compressed_pack     // Catch:{ all -> 0x02b4 }
            okio.ByteString r7 = diditransreq.p231pb.TransBackendRsp.DEFAULT_COMPRESSED_PACK     // Catch:{ all -> 0x02b4 }
            java.lang.Object r5 = com.squareup.wire.Wire.get(r5, r7)     // Catch:{ all -> 0x02b4 }
            okio.ByteString r5 = (okio.ByteString) r5     // Catch:{ all -> 0x02b4 }
            okio.ByteString r7 = diditransreq.p231pb.TransBackendRsp.DEFAULT_COMPRESSED_PACK     // Catch:{ all -> 0x02b4 }
            boolean r7 = r7.equals(r5)     // Catch:{ all -> 0x02b4 }
            if (r7 == 0) goto L_0x017b
            java.lang.String r0 = "Http2Socket"
            java.lang.String r2 = "[%s] Transreq didn't find compressed_pack"
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x02b4 }
            java.lang.String r6 = "Http2Socket"
            r5[r3] = r6     // Catch:{ all -> 0x02b4 }
            java.lang.String r2 = java.lang.String.format(r2, r5)     // Catch:{ all -> 0x02b4 }
            didinet.Logger.m40928d(r0, r2)     // Catch:{ all -> 0x02b4 }
            didihttp.StatisticalContext$TransDGCode r0 = didihttp.StatisticalContext.TransDGCode.TransReqDGRCodeServerError     // Catch:{ all -> 0x02b4 }
            r10.setTransDGCode(r0)     // Catch:{ all -> 0x02b4 }
            if (r11 == 0) goto L_0x017a
            monitor-enter(r11)
            java.lang.String r0 = "Http2Socket"
            java.lang.String r2 = "[%s] Transreq notify to continue"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0177 }
            java.lang.String r5 = "Http2Socket"
            r4[r3] = r5     // Catch:{ all -> 0x0177 }
            java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ all -> 0x0177 }
            didinet.Logger.m40928d(r0, r2)     // Catch:{ all -> 0x0177 }
            r11.notify()     // Catch:{ all -> 0x0177 }
            monitor-exit(r11)     // Catch:{ all -> 0x0177 }
            goto L_0x017a
        L_0x0177:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0177 }
            throw r0
        L_0x017a:
            return
        L_0x017b:
            java.lang.Integer r6 = r6.compression_format     // Catch:{ all -> 0x02b4 }
            java.lang.Integer r7 = diditransreq.p231pb.TransBackendRsp.DEFAULT_COMPRESSION_FORMAT     // Catch:{ all -> 0x02b4 }
            java.lang.Object r6 = com.squareup.wire.Wire.get(r6, r7)     // Catch:{ all -> 0x02b4 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x02b4 }
            java.lang.String r7 = "Http2Socket"
            java.lang.String r8 = "[%s] TransHttpRsp compressionFormat = %d"
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch:{ all -> 0x02b4 }
            java.lang.String r13 = "Http2Socket"
            r12[r3] = r13     // Catch:{ all -> 0x02b4 }
            r12[r4] = r6     // Catch:{ all -> 0x02b4 }
            java.lang.String r8 = java.lang.String.format(r8, r12)     // Catch:{ all -> 0x02b4 }
            didinet.Logger.m40928d(r7, r8)     // Catch:{ all -> 0x02b4 }
            java.lang.Integer r7 = diditransreq.p231pb.TransBackendRsp.DEFAULT_COMPRESSION_FORMAT     // Catch:{ all -> 0x02b4 }
            boolean r6 = r7.equals(r6)     // Catch:{ all -> 0x02b4 }
            if (r6 == 0) goto L_0x0207
            byte[] r6 = r5.toByteArray()     // Catch:{ all -> 0x02b4 }
            byte[] r6 = diditransreq.C20809b.m41001b(r6)     // Catch:{ all -> 0x02b4 }
            if (r6 != 0) goto L_0x01dd
            java.lang.String r0 = "Http2Socket"
            java.lang.String r2 = "[%s] TransHttpRsp decompress response return null"
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x02b4 }
            java.lang.String r6 = "Http2Socket"
            r5[r3] = r6     // Catch:{ all -> 0x02b4 }
            java.lang.String r2 = java.lang.String.format(r2, r5)     // Catch:{ all -> 0x02b4 }
            didinet.Logger.m40928d(r0, r2)     // Catch:{ all -> 0x02b4 }
            didihttp.StatisticalContext$TransDGCode r0 = didihttp.StatisticalContext.TransDGCode.TransReqDGRCodeDecodeError     // Catch:{ all -> 0x02b4 }
            r10.setTransDGCode(r0)     // Catch:{ all -> 0x02b4 }
            if (r11 == 0) goto L_0x01dc
            monitor-enter(r11)
            java.lang.String r0 = "Http2Socket"
            java.lang.String r2 = "[%s] Transreq notify to continue"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x01d9 }
            java.lang.String r5 = "Http2Socket"
            r4[r3] = r5     // Catch:{ all -> 0x01d9 }
            java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ all -> 0x01d9 }
            didinet.Logger.m40928d(r0, r2)     // Catch:{ all -> 0x01d9 }
            r11.notify()     // Catch:{ all -> 0x01d9 }
            monitor-exit(r11)     // Catch:{ all -> 0x01d9 }
            goto L_0x01dc
        L_0x01d9:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x01d9 }
            throw r0
        L_0x01dc:
            return
        L_0x01dd:
            java.lang.String r7 = "Http2Socket"
            java.lang.String r8 = "[%s] TransHttpRsp decompress is [%s], length:[%d unzip=> %d]"
            java.lang.Object[] r12 = new java.lang.Object[r14]     // Catch:{ all -> 0x02b4 }
            java.lang.String r13 = "Http2Socket"
            r12[r3] = r13     // Catch:{ all -> 0x02b4 }
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x02b4 }
            r12[r4] = r13     // Catch:{ all -> 0x02b4 }
            byte[] r5 = r5.toByteArray()     // Catch:{ all -> 0x02b4 }
            int r5 = r5.length     // Catch:{ all -> 0x02b4 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x02b4 }
            r12[r2] = r5     // Catch:{ all -> 0x02b4 }
            int r5 = r6.length     // Catch:{ all -> 0x02b4 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x02b4 }
            r12[r16] = r5     // Catch:{ all -> 0x02b4 }
            java.lang.String r5 = java.lang.String.format(r8, r12)     // Catch:{ all -> 0x02b4 }
            didinet.Logger.m40928d(r7, r5)     // Catch:{ all -> 0x02b4 }
            goto L_0x020b
        L_0x0207:
            byte[] r6 = r5.toByteArray()     // Catch:{ all -> 0x02b4 }
        L_0x020b:
            java.lang.Class<diditransreq.pb.TransHttpRsp> r5 = diditransreq.p231pb.TransHttpRsp.class
            com.squareup.wire.Message r0 = r0.parseFrom((byte[]) r6, r5)     // Catch:{ all -> 0x02b4 }
            diditransreq.pb.TransHttpRsp r0 = (diditransreq.p231pb.TransHttpRsp) r0     // Catch:{ all -> 0x02b4 }
            if (r0 != 0) goto L_0x0248
            java.lang.String r0 = "Http2Socket"
            java.lang.String r2 = "[%s] Transreq fail to parse TransHttpRsp"
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x02b4 }
            java.lang.String r6 = "Http2Socket"
            r5[r3] = r6     // Catch:{ all -> 0x02b4 }
            java.lang.String r2 = java.lang.String.format(r2, r5)     // Catch:{ all -> 0x02b4 }
            didinet.Logger.m40928d(r0, r2)     // Catch:{ all -> 0x02b4 }
            didihttp.StatisticalContext$TransDGCode r0 = didihttp.StatisticalContext.TransDGCode.TransReqDGRCodeDecodeError     // Catch:{ all -> 0x02b4 }
            r10.setTransDGCode(r0)     // Catch:{ all -> 0x02b4 }
            if (r11 == 0) goto L_0x0247
            monitor-enter(r11)
            java.lang.String r0 = "Http2Socket"
            java.lang.String r2 = "[%s] Transreq notify to continue"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0244 }
            java.lang.String r5 = "Http2Socket"
            r4[r3] = r5     // Catch:{ all -> 0x0244 }
            java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ all -> 0x0244 }
            didinet.Logger.m40928d(r0, r2)     // Catch:{ all -> 0x0244 }
            r11.notify()     // Catch:{ all -> 0x0244 }
            monitor-exit(r11)     // Catch:{ all -> 0x0244 }
            goto L_0x0247
        L_0x0244:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0244 }
            throw r0
        L_0x0247:
            return
        L_0x0248:
            java.lang.String r5 = "Http2Socket"
            java.lang.String r6 = "[%s] Transreq get statue code => %s"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x02b4 }
            java.lang.String r7 = "Http2Socket"
            r2[r3] = r7     // Catch:{ all -> 0x02b4 }
            java.lang.Integer r7 = r0.f57194sc     // Catch:{ all -> 0x02b4 }
            r2[r4] = r7     // Catch:{ all -> 0x02b4 }
            java.lang.String r2 = java.lang.String.format(r6, r2)     // Catch:{ all -> 0x02b4 }
            didinet.Logger.m40928d(r5, r2)     // Catch:{ all -> 0x02b4 }
            didihttp.Response r0 = diditransreq.C20808a.m40997a(r11, r0)     // Catch:{ all -> 0x02b4 }
            if (r0 != 0) goto L_0x0296
            java.lang.String r0 = "Http2Socket"
            java.lang.String r2 = "[%s] Transreq fail to translate to a didihttp.Response entity"
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x02b4 }
            java.lang.String r6 = "Http2Socket"
            r5[r3] = r6     // Catch:{ all -> 0x02b4 }
            java.lang.String r2 = java.lang.String.format(r2, r5)     // Catch:{ all -> 0x02b4 }
            didinet.Logger.m40928d(r0, r2)     // Catch:{ all -> 0x02b4 }
            didihttp.StatisticalContext$TransDGCode r0 = didihttp.StatisticalContext.TransDGCode.TransReqDGRCodeDecodeError     // Catch:{ all -> 0x02b4 }
            r10.setTransDGCode(r0)     // Catch:{ all -> 0x02b4 }
            if (r11 == 0) goto L_0x0295
            monitor-enter(r11)
            java.lang.String r0 = "Http2Socket"
            java.lang.String r2 = "[%s] Transreq notify to continue"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0292 }
            java.lang.String r5 = "Http2Socket"
            r4[r3] = r5     // Catch:{ all -> 0x0292 }
            java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ all -> 0x0292 }
            didinet.Logger.m40928d(r0, r2)     // Catch:{ all -> 0x0292 }
            r11.notify()     // Catch:{ all -> 0x0292 }
            monitor-exit(r11)     // Catch:{ all -> 0x0292 }
            goto L_0x0295
        L_0x0292:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x0292 }
            throw r0
        L_0x0295:
            return
        L_0x0296:
            r9.response = r0     // Catch:{ all -> 0x02b4 }
            if (r11 == 0) goto L_0x02f4
            monitor-enter(r11)
            java.lang.String r0 = "Http2Socket"
            java.lang.String r2 = "[%s] Transreq notify to continue"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x02b1 }
            java.lang.String r5 = "Http2Socket"
            r4[r3] = r5     // Catch:{ all -> 0x02b1 }
            java.lang.String r2 = java.lang.String.format(r2, r4)     // Catch:{ all -> 0x02b1 }
            didinet.Logger.m40928d(r0, r2)     // Catch:{ all -> 0x02b1 }
            r11.notify()     // Catch:{ all -> 0x02b1 }
            monitor-exit(r11)     // Catch:{ all -> 0x02b1 }
            goto L_0x02f4
        L_0x02b1:
            r0 = move-exception
            monitor-exit(r11)     // Catch:{ all -> 0x02b1 }
            throw r0
        L_0x02b4:
            r0 = move-exception
            r2 = r11
            goto L_0x02c0
        L_0x02b7:
            r0 = move-exception
            java.util.concurrent.locks.Lock r2 = r1.f57173c     // Catch:{ all -> 0x02be }
            r2.unlock()     // Catch:{ all -> 0x02be }
            throw r0     // Catch:{ all -> 0x02be }
        L_0x02be:
            r0 = move-exception
            r2 = 0
        L_0x02c0:
            java.lang.String r5 = "Http2Socket"
            java.lang.String r6 = ""
            didinet.Logger.m40931e(r5, r6, r0)     // Catch:{ all -> 0x02f5 }
            java.lang.String r0 = "Http2Socket"
            java.lang.String r5 = "[%s] Transreq get exception"
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ all -> 0x02f5 }
            java.lang.String r7 = "Http2Socket"
            r6[r3] = r7     // Catch:{ all -> 0x02f5 }
            java.lang.String r5 = java.lang.String.format(r5, r6)     // Catch:{ all -> 0x02f5 }
            didinet.Logger.m40928d(r0, r5)     // Catch:{ all -> 0x02f5 }
            if (r2 == 0) goto L_0x02f4
            monitor-enter(r2)
            java.lang.String r0 = "Http2Socket"
            java.lang.String r5 = "[%s] Transreq notify to continue"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x02f1 }
            java.lang.String r6 = "Http2Socket"
            r4[r3] = r6     // Catch:{ all -> 0x02f1 }
            java.lang.String r3 = java.lang.String.format(r5, r4)     // Catch:{ all -> 0x02f1 }
            didinet.Logger.m40928d(r0, r3)     // Catch:{ all -> 0x02f1 }
            r2.notify()     // Catch:{ all -> 0x02f1 }
            monitor-exit(r2)     // Catch:{ all -> 0x02f1 }
            goto L_0x02f4
        L_0x02f1:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x02f1 }
            throw r0
        L_0x02f4:
            return
        L_0x02f5:
            r0 = move-exception
            if (r2 == 0) goto L_0x0312
            monitor-enter(r2)
            java.lang.String r5 = "Http2Socket"
            java.lang.String r6 = "[%s] Transreq notify to continue"
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x030f }
            java.lang.String r7 = "Http2Socket"
            r4[r3] = r7     // Catch:{ all -> 0x030f }
            java.lang.String r3 = java.lang.String.format(r6, r4)     // Catch:{ all -> 0x030f }
            didinet.Logger.m40928d(r5, r3)     // Catch:{ all -> 0x030f }
            r2.notify()     // Catch:{ all -> 0x030f }
            monitor-exit(r2)     // Catch:{ all -> 0x030f }
            goto L_0x0312
        L_0x030f:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x030f }
            throw r0
        L_0x0312:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: diditransreq.Http2SocketManager.m40977a(int, byte[], diditransreq.pb.PushMsg):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo170579a(String str) {
        this.f57174i.add(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo170580b(String str) {
        for (String next : this.f57174i) {
            Logger.m40928d(f57165a, String.format("[%s] black list item => %s", new Object[]{f57165a, next}));
            if (next.equals(str)) {
                Logger.m40928d(f57165a, String.format("[%s] url => [%s] in the temp black list!", new Object[]{f57165a, str}));
                return true;
            }
        }
        Logger.m40928d(f57165a, String.format("[%s] url => [%s] not in the temp black list!", new Object[]{f57165a, str}));
        return false;
    }

    static class ReqRepPair {
        public StatisticalContext context;
        public ServerCallItem item;
        public Request request;
        public Response response;

        ReqRepPair() {
        }
    }

    /* renamed from: c */
    static String m40982c(String str) {
        int indexOf = str.indexOf(63);
        return indexOf < 0 ? str : str.substring(0, indexOf);
    }

    /* renamed from: b */
    static boolean m40981b() {
        return f57166d;
    }
}
