package diditransreq;

import didihttp.Interceptor;
import didihttp.Request;
import didihttp.Response;
import didihttp.ServerCallItem;
import didihttp.StatisticalContext;
import didihttp.internal.connection.ConnectInterceptor;
import didihttp.internal.http.RealInterceptorChain;
import didinet.Logger;
import didinet.NetEngine;
import java.io.IOException;

public class ConnectSwitcherInterceptor implements Interceptor {

    /* renamed from: b */
    private static final String f57162b = "Http2Socket";

    /* renamed from: a */
    private ConnectInterceptor f57163a;

    public ConnectSwitcherInterceptor(ConnectInterceptor connectInterceptor) {
        this.f57163a = connectInterceptor;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        int i;
        boolean z;
        StatisticalContext.TransDGCode transDGCode;
        NetEngine.ExternalParam onGetExternalParam;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        StatisticalContext statisticalContext = (StatisticalContext) realInterceptorChain.getExtraData();
        ServerCallItem currentServerCallData = statisticalContext.currentServerCallData();
        NetEngine.ExternalParamGetter paramGetter = NetEngine.getInstance().getParamGetter();
        long j = 0;
        if (paramGetter == null || (onGetExternalParam = paramGetter.onGetExternalParam()) == null || !onGetExternalParam.hasAppState()) {
            i = 0;
        } else {
            i = onGetExternalParam.getAppState();
            if (i == 2) {
                j = onGetExternalParam.getBackgroundDuration();
            }
        }
        currentServerCallData.setAppState(i);
        currentServerCallData.setBkgDur(j);
        Request request = realInterceptorChain.request();
        int longlinkState = statisticalContext.getLonglinkState();
        String c = Http2SocketManager.m40982c(request.url().toString());
        Logger.m40928d(f57162b, String.format("[%s] URL => %s", new Object[]{f57162b, c}));
        Object[] objArr = new Object[2];
        objArr[0] = f57162b;
        objArr[1] = Boolean.valueOf(longlinkState > 0);
        Logger.m40928d(f57162b, String.format("[%s] Already used transreq => %b", objArr));
        boolean equals = "1".equals(request.header("use_trans"));
        boolean isTransEnabled = NetEngine.getInstance().isTransEnabled();
        currentServerCallData.traceStart();
        m40973a(statisticalContext);
        boolean isHaveUsedTrans = statisticalContext.isHaveUsedTrans();
        boolean z2 = m40974a(c) || equals;
        try {
            z = NetEngine.getInstance().getPushAPI().isConnected();
        } catch (UnsatisfiedLinkError e) {
            Logger.m40929d(f57162b, "Push.so maybe not load!", e);
            z = false;
        }
        Logger.m40928d(f57162b, String.format("[%s] Push connected or not => %b", new Object[]{f57162b, Boolean.valueOf(z)}));
        if (!isTransEnabled || !z2 || !z || isHaveUsedTrans || Http2SocketManager.m40981b() || Http2SocketManager.m40976a().mo170580b(c)) {
            if (isHaveUsedTrans) {
                statisticalContext.setLonglinkState(2);
            } else if (!isTransEnabled || !z2) {
                statisticalContext.setLonglinkState(0);
                if (!isTransEnabled) {
                    transDGCode = StatisticalContext.TransDGCode.TransReqDGRCodeSetDisable;
                } else {
                    transDGCode = StatisticalContext.TransDGCode.TransReqDGRCodeApolloNotAllow;
                }
                statisticalContext.setTransDGCode(transDGCode);
            } else {
                statisticalContext.setLonglinkState(2);
                if (!z) {
                    if (NetEngine.getInstance().getPushAPI().isPushInited()) {
                        statisticalContext.setTransDGCode(StatisticalContext.TransDGCode.TransReqDGRCodePushNotConnected);
                    } else {
                        statisticalContext.setTransDGCode(StatisticalContext.TransDGCode.TransReqDGRCodePushNotInited);
                    }
                } else if (Http2SocketManager.m40981b()) {
                    statisticalContext.setTransDGCode(StatisticalContext.TransDGCode.TransReqDGRCodeServerLimit);
                } else {
                    statisticalContext.setTransDGCode(StatisticalContext.TransDGCode.TransReqDGRCodeServerNotSupport);
                }
            }
            Logger.m40928d(f57162b, String.format("[%s] Not satisfied condition [%d][%s]", new Object[]{f57162b, Integer.valueOf(statisticalContext.getTransDGCode().getValue()), c}));
            return this.f57163a.intercept(chain);
        }
        statisticalContext.setTransDGCode(StatisticalContext.TransDGCode.TransReqDGRCodeOK);
        statisticalContext.setLonglinkState(1);
        statisticalContext.setHaveUsedTrans(true);
        return chain.proceed(request);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m40973a(didihttp.StatisticalContext r5) {
        /*
            r4 = this;
            didinet.NetEngine r0 = didinet.NetEngine.getInstance()
            didinet.PushAPI r0 = r0.getPushAPI()
            boolean r1 = r0.isPushInited()
            r2 = 1
            if (r1 == 0) goto L_0x0019
            boolean r1 = r0.isConnected()
            if (r1 == 0) goto L_0x0017
            r1 = 1
            goto L_0x001a
        L_0x0017:
            r1 = -1
            goto L_0x001a
        L_0x0019:
            r1 = -2
        L_0x001a:
            r5.setPushState(r1)
            didinet.LocalIPStack r1 = r0.getLocalIPStack()
            if (r1 == 0) goto L_0x0047
            int[] r1 = diditransreq.ConnectSwitcherInterceptor.C208051.$SwitchMap$didinet$LocalIPStack
            didinet.LocalIPStack r3 = r0.getLocalIPStack()
            int r3 = r3.ordinal()
            r1 = r1[r3]
            if (r1 == r2) goto L_0x0044
            r2 = 2
            if (r1 == r2) goto L_0x0041
            r2 = 3
            if (r1 == r2) goto L_0x003e
            r2 = 4
            if (r1 == r2) goto L_0x003b
            goto L_0x0047
        L_0x003b:
            java.lang.String r1 = "Dual"
            goto L_0x0049
        L_0x003e:
            java.lang.String r1 = "IPv6"
            goto L_0x0049
        L_0x0041:
            java.lang.String r1 = "IPv4"
            goto L_0x0049
        L_0x0044:
            java.lang.String r1 = "None"
            goto L_0x0049
        L_0x0047:
            java.lang.String r1 = "Unknown"
        L_0x0049:
            r5.setIpStack(r1)
            didinet.PushAPI$PushParam r0 = r0.getPushParam()
            if (r0 == 0) goto L_0x0089
            java.lang.String r1 = r0.pushHost
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0089
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r0.pushHost
            r1.append(r2)
            java.lang.String r2 = ":"
            r1.append(r2)
            int r2 = r0.pushPort
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r5.setTransAddr(r1)
            java.lang.String r1 = r0.pushVer
            r5.setPushVer(r1)
            boolean r1 = r0.tls
            r5.setPushTLS(r1)
            int r1 = r0.isMulti
            r5.setIsPushMulti(r1)
            int r0 = r0.confVer
            r5.setPushConfVer(r0)
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: diditransreq.ConnectSwitcherInterceptor.m40973a(didihttp.StatisticalContext):void");
    }

    /* renamed from: diditransreq.ConnectSwitcherInterceptor$1 */
    static /* synthetic */ class C208051 {
        static final /* synthetic */ int[] $SwitchMap$didinet$LocalIPStack;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                didinet.LocalIPStack[] r0 = didinet.LocalIPStack.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$didinet$LocalIPStack = r0
                didinet.LocalIPStack r1 = didinet.LocalIPStack.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$didinet$LocalIPStack     // Catch:{ NoSuchFieldError -> 0x001d }
                didinet.LocalIPStack r1 = didinet.LocalIPStack.IPv4     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$didinet$LocalIPStack     // Catch:{ NoSuchFieldError -> 0x0028 }
                didinet.LocalIPStack r1 = didinet.LocalIPStack.IPv6     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$didinet$LocalIPStack     // Catch:{ NoSuchFieldError -> 0x0033 }
                didinet.LocalIPStack r1 = didinet.LocalIPStack.Dual     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: diditransreq.ConnectSwitcherInterceptor.C208051.<clinit>():void");
        }
    }

    /* renamed from: a */
    private boolean m40974a(String str) {
        return Http2SocketParam.getParam().mo170582a(str);
    }
}
