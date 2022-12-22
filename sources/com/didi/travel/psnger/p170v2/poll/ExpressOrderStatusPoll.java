package com.didi.travel.psnger.p170v2.poll;

import android.text.TextUtils;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.map.global.flow.scene.order.serving.components.OrderFloatWindowManager;
import com.didi.map.global.flow.scene.order.serving.param.OrderState;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.travel.p171v2.biz.api.RemoteCallback;
import com.didi.travel.p171v2.poll.IPollCallback;
import com.didi.travel.p171v2.poll.Poll;
import com.didi.travel.p171v2.session.Scene;
import com.didi.travel.p171v2.session.Session;
import com.didi.travel.p171v2.session.SessionOwner;
import com.didi.travel.p171v2.store.Store;
import com.didi.travel.p171v2.util.LogUtils;
import com.didi.travel.psnger.TravelSDK;
import com.didi.travel.psnger.core.listener.IDiDiCoreCallback;
import com.didi.travel.psnger.core.model.response.DTSDKOrderStatus;
import com.didi.travel.psnger.core.model.response.IOrderStatus;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.OrderRealtimePriceCount;
import com.didi.travel.psnger.p170v2.EventKeys;
import com.didi.travel.psnger.p170v2.ExpressSceneContainer;
import com.didi.travel.psnger.p170v2.IExpress;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.didi.travel.psnger.p170v2.push.ExpressOrderPush;
import com.didi.travel.psnger.store.DDTravelConfigStore;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.didi.travel.psnger.v2.poll.ExpressOrderStatusPoll */
public class ExpressOrderStatusPoll extends Poll implements SessionOwner {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f44258a = ExpressOrderStatusPoll.class.getSimpleName();

    /* renamed from: b */
    private static final long f44259b = 86400000;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static final Map<String, ExpressOrderStatusPoll> f44260c = new ConcurrentHashMap();

    /* renamed from: d */
    private Session f44261d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final String f44262e;

    /* renamed from: f */
    private boolean f44263f = false;

    /* renamed from: g */
    private long f44264g = 0;

    /* renamed from: h */
    private final ExpressOrderPush f44265h = new ExpressOrderPush();

    /* renamed from: i */
    private final Set<IDiDiCoreCallback> f44266i = new HashSet();

    /* renamed from: j */
    private final LifecycleOwner f44267j = ProcessLifecycleOwner.get();

    /* renamed from: k */
    private final LifecycleEventObserver f44268k = new LifecycleEventObserver() {
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            int i = C1438316.$SwitchMap$androidx$lifecycle$Lifecycle$Event[event.ordinal()];
            if (i == 2) {
                ExpressOrderStatusPoll expressOrderStatusPoll = ExpressOrderStatusPoll.this;
                expressOrderStatusPoll.tryResumePoll(expressOrderStatusPoll.m31445a(1002));
            } else if (i == 5) {
                ExpressOrderStatusPoll expressOrderStatusPoll2 = ExpressOrderStatusPoll.this;
                expressOrderStatusPoll2.tryPausePoll(expressOrderStatusPoll2.m31445a(1001));
            }
        }
    };

    /* renamed from: l */
    private boolean f44269l = false;

    /* renamed from: m */
    private AtomicBoolean f44270m = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: n */
    public BaseEventPublisher.OnEventListener<String> f44271n = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            Logger logger = LoggerFactory.getLogger("GlobalTravelSdk");
            logger.info("mXEngineOrderDetailListener.onEvent:event = " + str + ", orderId = " + TravelUtil.getRichOid(str2), new Object[0]);
            if (!ExpressOrderStatusPoll.this.f44262e.equals(str2)) {
                Logger logger2 = LoggerFactory.getLogger("GlobalTravelSdk");
                logger2.info("mXEngineOrderDetailListener.onEvent:event not match, mOrderId = " + TravelUtil.getRichOid(ExpressOrderStatusPoll.this.f44262e) + ", orderId = " + TravelUtil.getRichOid(str2), new Object[0]);
            } else if (EventKeys.XEngine.EVENT_X_ENGINE_ORDER_DETAIL_SUCCESS.equals(str)) {
                ExpressOrderStatusPoll.this.m31466h();
            } else if (EventKeys.XEngine.EVENT_X_ENGINE_ORDER_DETAIL_FAIL.equals(str)) {
                ExpressOrderStatusPoll.this.m31468i();
            } else if (EventKeys.XEngine.EVENT_X_ENGINE_ORDER_DETAIL_ERROR.equals(str)) {
                ExpressOrderStatusPoll.this.m31469j();
            } else {
                String a = ExpressOrderStatusPoll.f44258a;
                LogUtils.m31492e(a, "invalid event = " + str + ", orderId = " + str2);
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: o */
    public BaseEventPublisher.OnEventListener<DTSDKOrderStatus> f44272o = new BaseEventPublisher.OnEventListener<DTSDKOrderStatus>() {
        public void onEvent(String str, DTSDKOrderStatus dTSDKOrderStatus) {
            String a = ExpressOrderStatusPoll.f44258a;
            LogUtils.m31493i(a, "mOrderStatusChangeByPushListener.onEvent:event = " + str + ", dtsdkOrderStatus = " + dTSDKOrderStatus);
            if (dTSDKOrderStatus == null) {
                LogUtils.m31492e(ExpressOrderStatusPoll.f44258a, "mOrderStatusChangeByPushListener.onEvent:dtsdkOrderStatus is null");
            } else if (!ExpressOrderStatusPoll.this.f44262e.equals(dTSDKOrderStatus.oid)) {
                LogUtils.m31492e("GlobalTravelSdk", "mOrderStatusChangeByPushListener.onEvent:orderId not match, mOrderId = " + TravelUtil.getRichOid(ExpressOrderStatusPoll.this.f44262e) + ", dtsdkOrderStatus.oid = " + TravelUtil.getRichOid(dTSDKOrderStatus.oid));
            } else {
                ExpressOrderStatusPoll.this.onGetOrderStatusByPush(dTSDKOrderStatus);
            }
        }
    };

    /* renamed from: com.didi.travel.psnger.v2.poll.ExpressOrderStatusPoll$16 */
    static /* synthetic */ class C1438316 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.lifecycle.Lifecycle$Event[] r0 = androidx.lifecycle.Lifecycle.Event.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$androidx$lifecycle$Lifecycle$Event = r0
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_CREATE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_START     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_RESUME     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_PAUSE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_STOP     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_DESTROY     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$androidx$lifecycle$Lifecycle$Event     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.lifecycle.Lifecycle$Event r1 = androidx.lifecycle.Lifecycle.Event.ON_ANY     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.travel.psnger.p170v2.poll.ExpressOrderStatusPoll.C1438316.<clinit>():void");
        }
    }

    public static synchronized ExpressOrderStatusPoll getInstance(Scene scene, Session session, String str) {
        ExpressOrderStatusPoll expressOrderStatusPoll;
        synchronized (ExpressOrderStatusPoll.class) {
            String str2 = f44258a;
            LogUtils.m31493i(str2, "getInstance:scene = " + scene + ", session = " + session + ", orderId = " + TravelUtil.getRichOid(str));
            expressOrderStatusPoll = f44260c.get(TravelUtil.generateOrderStatusPollKey(str));
            if (expressOrderStatusPoll == null) {
                String str3 = f44258a;
                LogUtils.m31492e(str3, "getInstance:new instance, orderId = " + TravelUtil.getRichOid(str));
                expressOrderStatusPoll = new ExpressOrderStatusPoll(scene, session, str);
            }
        }
        return expressOrderStatusPoll;
    }

    private ExpressOrderStatusPoll(Scene scene, Session session, String str) {
        super(scene, TravelUtil.generateOrderStatusPollKey(str));
        if (session == null) {
            throw new NullPointerException(f44258a + ".new:session is null, scene = " + scene + ", orderId = " + str);
        } else if (!TextUtils.isEmpty(str)) {
            this.f44261d = session;
            this.f44262e = str;
            setPollCallback(new IPollCallback() {
                public int isContinue() {
                    int i = TextUtils.isEmpty(TravelSDK.travelParam() != null ? TravelSDK.travelParam().token() : null) ? 1002 : 1;
                    String a = ExpressOrderStatusPoll.f44258a;
                    LogUtils.m31493i(a, "isContinueCode = " + i);
                    return i;
                }

                public void onTick(int i) {
                    ExpressOrderStatusPoll.this.m31459e();
                }

                public void onPollTimeChanged(long j) {
                    for (IDiDiCoreCallback next : ExpressOrderStatusPoll.this.getOrderCallbackSet()) {
                        if (next != null) {
                            next.onOrderPollTimeChange((int) (j / 1000));
                        }
                    }
                }

                public void onPollTimeout() {
                    for (IDiDiCoreCallback next : ExpressOrderStatusPoll.this.getOrderCallbackSet()) {
                        if (next != null) {
                            next.onOrderStatusTimeOut();
                        }
                    }
                }
            });
            getLifecycle().addObserver(new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_CREATE) {
                        LogUtils.m31492e(ExpressOrderStatusPoll.f44258a, "onStateChanged:ON_CREATE");
                        ExpressOrderStatusPoll.f44260c.put(ExpressOrderStatusPoll.this.getKey(), ExpressOrderStatusPoll.this);
                        BaseEventPublisher.getPublisher().subscribeSync(EventKeys.Poll.EVENT_TRAVEL_SDK_ORDER_STATUS_CHANGE_BY_PUSH, ExpressOrderStatusPoll.this.f44272o);
                        BaseEventPublisher.getPublisher().subscribeSync(EventKeys.XEngine.EVENT_X_ENGINE_ORDER_DETAIL_SUCCESS, ExpressOrderStatusPoll.this.f44271n);
                        BaseEventPublisher.getPublisher().subscribeSync(EventKeys.XEngine.EVENT_X_ENGINE_ORDER_DETAIL_FAIL, ExpressOrderStatusPoll.this.f44271n);
                        BaseEventPublisher.getPublisher().subscribeSync(EventKeys.XEngine.EVENT_X_ENGINE_ORDER_DETAIL_ERROR, ExpressOrderStatusPoll.this.f44271n);
                    } else if (event == Lifecycle.Event.ON_DESTROY) {
                        LogUtils.m31492e(ExpressOrderStatusPoll.f44258a, "onStateChanged:ON_DESTROY");
                        ExpressOrderStatusPoll.f44260c.remove(ExpressOrderStatusPoll.this.getKey());
                        BaseEventPublisher.getPublisher().unsubscribeSync(EventKeys.Poll.EVENT_TRAVEL_SDK_ORDER_STATUS_CHANGE_BY_PUSH, ExpressOrderStatusPoll.this.f44272o);
                        BaseEventPublisher.getPublisher().unsubscribeSync(EventKeys.XEngine.EVENT_X_ENGINE_ORDER_DETAIL_SUCCESS, ExpressOrderStatusPoll.this.f44271n);
                        BaseEventPublisher.getPublisher().unsubscribeSync(EventKeys.XEngine.EVENT_X_ENGINE_ORDER_DETAIL_FAIL, ExpressOrderStatusPoll.this.f44271n);
                        BaseEventPublisher.getPublisher().unsubscribeSync(EventKeys.XEngine.EVENT_X_ENGINE_ORDER_DETAIL_ERROR, ExpressOrderStatusPoll.this.f44271n);
                    }
                }
            });
            this.f44261d.getLifecycle().addObserver(new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (Lifecycle.Event.ON_DESTROY == event) {
                        LogUtils.m31492e(ExpressOrderStatusPoll.f44258a, "Session.onStateChanged:ON_DESTROY");
                        ExpressOrderStatusPoll.this.destroyPoll((Scene) null);
                    }
                }
            });
        } else {
            throw new IllegalArgumentException(f44258a + ".new:orderId is empty, scene = " + scene + ", session = " + session);
        }
    }

    public synchronized void setOuterPollInterval(boolean z, long j) {
        String str = f44258a;
        LogUtils.m31493i(str, "setOuterPollInterval:isOuterControl = " + z + ", pollInterval = " + j);
        if (!z || j > 0) {
            this.f44263f = z;
            this.f44264g = j;
            setPollInterval((Scene) null, m31444a((long) (DDTravelConfigStore.getInstance().getOrderStatusIntervalTime() * 1000)));
            return;
        }
        String str2 = f44258a;
        LogUtils.m31492e(str2, "setOuterPollInterval:invalid data, isOuterControl = true, pollInterval = " + j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return r6;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized long m31444a(long r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.f44263f     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0011
            long r0 = r5.f44264g     // Catch:{ all -> 0x0013 }
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x0011
            long r6 = r5.f44264g     // Catch:{ all -> 0x0013 }
            monitor-exit(r5)
            return r6
        L_0x0011:
            monitor-exit(r5)
            return r6
        L_0x0013:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.travel.psnger.p170v2.poll.ExpressOrderStatusPoll.m31444a(long):long");
    }

    public synchronized void addCoreCallback(IDiDiCoreCallback iDiDiCoreCallback) {
        if (iDiDiCoreCallback != null) {
            this.f44266i.add(iDiDiCoreCallback);
            this.f44265h.addCoreCallback(iDiDiCoreCallback);
        }
    }

    public synchronized void removeCoreCallback(IDiDiCoreCallback iDiDiCoreCallback) {
        if (iDiDiCoreCallback != null) {
            this.f44266i.remove(iDiDiCoreCallback);
            this.f44265h.removeCoreCallback(iDiDiCoreCallback);
        }
    }

    public void setPollCallback(IPollCallback iPollCallback) {
        super.setPollCallback(iPollCallback);
    }

    public void setIsNeedAppBackgroundPoll(boolean z) {
        if (this.f44269l != z) {
            this.f44269l = z;
            if (z) {
                tryResumePoll(m31445a(1005));
            } else {
                tryPausePoll(m31445a(1006));
            }
        }
    }

    /* access modifiers changed from: protected */
    public int isPollInnerReady() {
        LifecycleOwner lifecycleOwner = this.f44267j;
        return (lifecycleOwner == null || lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) || this.f44269l) ? 1 : 1001;
    }

    public void startPoll(Scene scene) {
        Store store;
        Logger logger = LoggerFactory.getLogger("GlobalTravelSdk");
        logger.info("Start OrderStatus Pull " + this.f44262e, new Object[0]);
        long j = 86400000;
        if (!(this.f44261d == null || (store = Store.getStore(TravelUtil.generateCarOrderStoreKey(this.f44262e))) == null || store.getData() == null || ((CarOrder) store.getData()).getCreateTime() <= 0)) {
            j = (((CarOrder) store.getData()).getCreateTime() + 86400000) - System.currentTimeMillis();
        }
        startPoll(scene, j);
    }

    public void startPoll(Scene scene, long j) {
        setPollInterval(scene, m31444a((long) (DDTravelConfigStore.getInstance().getOrderStatusIntervalTime() * 1000)));
        super.startPoll(scene, j);
        this.f44265h.registerPushListener();
        this.f44267j.getLifecycle().addObserver(this.f44268k);
    }

    public void stopPoll(Scene scene) {
        Logger logger = LoggerFactory.getLogger("GlobalTravelSdk");
        logger.info("Stop OrderStatus Pull " + this.f44262e, new Object[0]);
        this.f44265h.unregisterPushListener();
        this.f44267j.getLifecycle().removeObserver(this.f44268k);
        super.stopPoll(scene);
    }

    public void onGetOrderStatusByPush(DTSDKOrderStatus dTSDKOrderStatus) {
        onOrderStatusGot(dTSDKOrderStatus, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Scene m31445a(int i) {
        return ExpressSceneContainer.getInstance().getScene(i);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x033e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00db, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x010a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onOrderStatusGot(final com.didi.travel.psnger.core.model.response.DTSDKOrderStatus r11, boolean r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r0 = "GlobalTravelSdk"
            com.didi.sdk.logging.Logger r0 = com.didi.sdk.logging.LoggerFactory.getLogger((java.lang.String) r0)     // Catch:{ all -> 0x033f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x033f }
            r1.<init>()     // Catch:{ all -> 0x033f }
            java.lang.String r2 = "onOrderStatusGot : status = "
            r1.append(r2)     // Catch:{ all -> 0x033f }
            int r2 = r11.status()     // Catch:{ all -> 0x033f }
            r1.append(r2)     // Catch:{ all -> 0x033f }
            java.lang.String r2 = ", subStatus = "
            r1.append(r2)     // Catch:{ all -> 0x033f }
            int r2 = r11.subStatus()     // Catch:{ all -> 0x033f }
            r1.append(r2)     // Catch:{ all -> 0x033f }
            java.lang.String r2 = ", isPush = "
            r1.append(r2)     // Catch:{ all -> 0x033f }
            r1.append(r12)     // Catch:{ all -> 0x033f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x033f }
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x033f }
            r0.info((java.lang.String) r1, (java.lang.Object[]) r3)     // Catch:{ all -> 0x033f }
            com.didi.component.core.event.BaseEventPublisher r0 = com.didi.component.core.event.BaseEventPublisher.getPublisher()     // Catch:{ all -> 0x033f }
            java.lang.String r1 = "EVENT_ORDER_STATUS"
            r0.publish(r1, r11)     // Catch:{ all -> 0x033f }
            r10.m31449a((com.didi.travel.psnger.core.model.response.DTSDKOrderStatus) r11)     // Catch:{ all -> 0x033f }
            r0 = 2003(0x7d3, float:2.807E-42)
            r1 = 2
            if (r11 == 0) goto L_0x006f
            int r3 = r11.status()     // Catch:{ all -> 0x033f }
            if (r3 != r1) goto L_0x006f
            int r3 = r11.subStatus()     // Catch:{ all -> 0x033f }
            if (r3 != r0) goto L_0x006f
            java.lang.String r3 = r11.newOrderId     // Catch:{ all -> 0x033f }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x033f }
            if (r3 != 0) goto L_0x006f
            com.didi.travel.psnger.core.order.OrderReassignInfo r3 = com.didi.travel.psnger.core.order.OrderReassignInfo.getInstance()     // Catch:{ all -> 0x033f }
            java.lang.String r4 = r11.oid     // Catch:{ all -> 0x033f }
            java.lang.String r5 = r11.newOrderId     // Catch:{ all -> 0x033f }
            r3.store(r4, r5)     // Catch:{ all -> 0x033f }
            com.didi.component.core.event.BaseEventPublisher r3 = com.didi.component.core.event.BaseEventPublisher.getPublisher()     // Catch:{ all -> 0x033f }
            java.lang.String r4 = "event_message_bar_stop_timer"
            r3.publish(r4)     // Catch:{ all -> 0x033f }
        L_0x006f:
            java.lang.String r3 = r10.f44262e     // Catch:{ all -> 0x033f }
            java.lang.String r3 = com.didi.travel.psnger.p170v2.TravelUtil.generateCarOrderStoreKey(r3)     // Catch:{ all -> 0x033f }
            com.didi.travel.v2.store.Store r3 = com.didi.travel.p171v2.store.Store.getStore(r3)     // Catch:{ all -> 0x033f }
            if (r3 != 0) goto L_0x007d
            r3 = 0
            goto L_0x0083
        L_0x007d:
            java.lang.Object r3 = r3.getData()     // Catch:{ all -> 0x033f }
            com.didi.travel.psnger.model.response.CarOrder r3 = (com.didi.travel.psnger.model.response.CarOrder) r3     // Catch:{ all -> 0x033f }
        L_0x0083:
            boolean r4 = r11.isTimeout()     // Catch:{ all -> 0x033f }
            r5 = 1
            if (r3 == 0) goto L_0x0092
            boolean r6 = r3.isBooking()     // Catch:{ all -> 0x033f }
            if (r6 == 0) goto L_0x0092
            r6 = 1
            goto L_0x0093
        L_0x0092:
            r6 = 0
        L_0x0093:
            r7 = 7
            if (r4 == 0) goto L_0x00a4
            if (r6 == 0) goto L_0x00b2
            if (r6 == 0) goto L_0x00a4
            int r4 = r11.status()     // Catch:{ all -> 0x033f }
            if (r4 != r7) goto L_0x00a4
            int r4 = r11.subStatus     // Catch:{ all -> 0x033f }
            if (r4 == 0) goto L_0x00b2
        L_0x00a4:
            if (r6 == 0) goto L_0x00dc
            int r4 = r11.status()     // Catch:{ all -> 0x033f }
            if (r4 != r7) goto L_0x00dc
            int r4 = r11.subStatus     // Catch:{ all -> 0x033f }
            r6 = 2005(0x7d5, float:2.81E-42)
            if (r4 != r6) goto L_0x00dc
        L_0x00b2:
            java.lang.String r12 = f44258a     // Catch:{ all -> 0x033f }
            java.lang.String r0 = "onOrderStatusGot : timeout"
            com.didi.travel.p171v2.util.LogUtils.m31495w(r12, r0)     // Catch:{ all -> 0x033f }
            int r11 = r11.status()     // Catch:{ all -> 0x033f }
            if (r11 != r7) goto L_0x00da
            if (r3 == 0) goto L_0x00c7
            int r11 = r3.getStatus()     // Catch:{ all -> 0x033f }
            if (r11 != r7) goto L_0x00da
        L_0x00c7:
            r11 = 2001(0x7d1, float:2.804E-42)
            com.didi.travel.v2.session.Scene r11 = r10.m31445a((int) r11)     // Catch:{ all -> 0x033f }
            r10.stopPoll(r11)     // Catch:{ all -> 0x033f }
            android.os.Handler r11 = r10.mHandler     // Catch:{ all -> 0x033f }
            com.didi.travel.psnger.v2.poll.ExpressOrderStatusPoll$7 r12 = new com.didi.travel.psnger.v2.poll.ExpressOrderStatusPoll$7     // Catch:{ all -> 0x033f }
            r12.<init>()     // Catch:{ all -> 0x033f }
            r11.post(r12)     // Catch:{ all -> 0x033f }
        L_0x00da:
            monitor-exit(r10)
            return
        L_0x00dc:
            int r4 = r11.status     // Catch:{ all -> 0x033f }
            if (r4 != r1) goto L_0x010b
            int r1 = r11.subStatus     // Catch:{ all -> 0x033f }
            if (r1 != r0) goto L_0x010b
            java.lang.String r0 = r11.newOrderId     // Catch:{ all -> 0x033f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x033f }
            if (r0 != 0) goto L_0x010b
            com.didi.travel.psnger.model.response.CarOrder r12 = r10.m31457d()     // Catch:{ all -> 0x033f }
            if (r12 != 0) goto L_0x00fd
            java.lang.String r11 = "onOrderStatusGot"
            com.didi.travel.psnger.v2.poll.ExpressOrderStatusPoll$8 r12 = new com.didi.travel.psnger.v2.poll.ExpressOrderStatusPoll$8     // Catch:{ all -> 0x033f }
            r12.<init>()     // Catch:{ all -> 0x033f }
            r10.m31452a((java.lang.String) r11, (java.lang.Runnable) r12)     // Catch:{ all -> 0x033f }
            goto L_0x0109
        L_0x00fd:
            r12.orderState = r11     // Catch:{ all -> 0x033f }
            android.os.Handler r12 = r10.mHandler     // Catch:{ all -> 0x033f }
            com.didi.travel.psnger.v2.poll.ExpressOrderStatusPoll$9 r0 = new com.didi.travel.psnger.v2.poll.ExpressOrderStatusPoll$9     // Catch:{ all -> 0x033f }
            r0.<init>(r11)     // Catch:{ all -> 0x033f }
            r12.post(r0)     // Catch:{ all -> 0x033f }
        L_0x0109:
            monitor-exit(r10)
            return
        L_0x010b:
            boolean r0 = r10.isPollRunning()     // Catch:{ all -> 0x033f }
            java.lang.String r1 = f44258a     // Catch:{ all -> 0x033f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x033f }
            r4.<init>()     // Catch:{ all -> 0x033f }
            java.lang.String r6 = "onOrderStatusGot:isPollRunning="
            r4.append(r6)     // Catch:{ all -> 0x033f }
            r4.append(r0)     // Catch:{ all -> 0x033f }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x033f }
            com.didi.travel.p171v2.util.LogUtils.m31493i(r1, r4)     // Catch:{ all -> 0x033f }
            if (r3 == 0) goto L_0x021d
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ all -> 0x033f }
            r1.<init>()     // Catch:{ all -> 0x033f }
            java.lang.String r4 = "oid"
            java.lang.String r6 = r3.getOid()     // Catch:{ all -> 0x033f }
            r1.put(r4, r6)     // Catch:{ all -> 0x033f }
            java.lang.String r4 = "status"
            int r6 = r3.getStatus()     // Catch:{ all -> 0x033f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x033f }
            r1.put(r4, r6)     // Catch:{ all -> 0x033f }
            java.lang.String r4 = "sub_status"
            int r6 = r3.getSubStatus()     // Catch:{ all -> 0x033f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x033f }
            r1.put(r4, r6)     // Catch:{ all -> 0x033f }
            java.lang.String r4 = "s_status"
            int r6 = r11.status()     // Catch:{ all -> 0x033f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x033f }
            r1.put(r4, r6)     // Catch:{ all -> 0x033f }
            java.lang.String r4 = "s_sub_status"
            int r6 = r11.subStatus()     // Catch:{ all -> 0x033f }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x033f }
            r1.put(r4, r6)     // Catch:{ all -> 0x033f }
            java.lang.String r4 = "is_push"
            if (r12 == 0) goto L_0x016f
            r6 = 1
            goto L_0x0170
        L_0x016f:
            r6 = 0
        L_0x0170:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x033f }
            r1.put(r4, r6)     // Catch:{ all -> 0x033f }
            java.lang.String r4 = "is_poll"
            if (r0 == 0) goto L_0x017d
            r6 = 1
            goto L_0x017e
        L_0x017d:
            r6 = 0
        L_0x017e:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x033f }
            r1.put(r4, r6)     // Catch:{ all -> 0x033f }
            com.didi.travel.psnger.core.model.response.IOrderStatus r4 = r3.getOrderStatus()     // Catch:{ all -> 0x033f }
            com.didi.travel.psnger.core.model.response.DTSDKOrderStatus r4 = (com.didi.travel.psnger.core.model.response.DTSDKOrderStatus) r4     // Catch:{ all -> 0x033f }
            if (r11 == 0) goto L_0x01a3
            java.lang.String r6 = "s_md5"
            java.lang.String r8 = r11.md5     // Catch:{ all -> 0x033f }
            r1.put(r6, r8)     // Catch:{ all -> 0x033f }
            java.lang.String r6 = r11.newOrderId     // Catch:{ all -> 0x033f }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x033f }
            if (r6 != 0) goto L_0x01a3
            java.lang.String r6 = "new_oid"
            java.lang.String r8 = r11.newOrderId     // Catch:{ all -> 0x033f }
            r1.put(r6, r8)     // Catch:{ all -> 0x033f }
        L_0x01a3:
            if (r4 == 0) goto L_0x01c1
            if (r11 == 0) goto L_0x01c1
            java.lang.String r6 = r4.md5     // Catch:{ all -> 0x033f }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x033f }
            if (r6 != 0) goto L_0x01c1
            java.lang.String r6 = r11.md5     // Catch:{ all -> 0x033f }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x033f }
            if (r6 != 0) goto L_0x01c1
            java.lang.String r6 = r4.md5     // Catch:{ all -> 0x033f }
            java.lang.String r8 = r11.md5     // Catch:{ all -> 0x033f }
            boolean r6 = r6.equals(r8)     // Catch:{ all -> 0x033f }
            r6 = r6 ^ r5
            goto L_0x01c2
        L_0x01c1:
            r6 = 0
        L_0x01c2:
            java.lang.String r8 = "md5changed"
            if (r6 == 0) goto L_0x01c8
            r6 = 1
            goto L_0x01c9
        L_0x01c8:
            r6 = 0
        L_0x01c9:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x033f }
            r1.put(r8, r6)     // Catch:{ all -> 0x033f }
            if (r4 == 0) goto L_0x01ec
            java.lang.String r6 = "o_status"
            int r8 = r4.status()     // Catch:{ all -> 0x033f }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x033f }
            r1.put(r6, r8)     // Catch:{ all -> 0x033f }
            java.lang.String r6 = "o_sub_status"
            int r8 = r4.subStatus()     // Catch:{ all -> 0x033f }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x033f }
            r1.put(r6, r8)     // Catch:{ all -> 0x033f }
        L_0x01ec:
            if (r4 == 0) goto L_0x0218
            if (r11 == 0) goto L_0x0218
            int r4 = r4.status     // Catch:{ all -> 0x033f }
            if (r4 != r7) goto L_0x0218
            int r4 = r11.status     // Catch:{ all -> 0x033f }
            r6 = 4
            if (r4 != r6) goto L_0x0218
            int r4 = r11.subStatus     // Catch:{ all -> 0x033f }
            r6 = 4001(0xfa1, float:5.607E-42)
            if (r4 != r6) goto L_0x0218
            com.didichuxing.bigdata.dp.locsdk.ntp.TimeServiceManager r4 = com.didichuxing.bigdata.p173dp.locsdk.ntp.TimeServiceManager.getInstance()     // Catch:{ all -> 0x033f }
            long r6 = r4.getNTPCurrenTimeMillis()     // Catch:{ all -> 0x033f }
            long r8 = r3.getCreateTime()     // Catch:{ all -> 0x033f }
            long r6 = r6 - r8
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = r6 / r8
            java.lang.String r4 = "wait_time"
            java.lang.String r6 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x033f }
            r1.put(r4, r6)     // Catch:{ all -> 0x033f }
        L_0x0218:
            java.lang.String r4 = "tech_pax_order_status_changed"
            com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r4, (java.util.Map<java.lang.String, java.lang.Object>) r1)     // Catch:{ all -> 0x033f }
        L_0x021d:
            if (r3 == 0) goto L_0x030b
            if (r0 == 0) goto L_0x030b
            com.didi.travel.psnger.core.model.response.IOrderStatus r0 = r3.getOrderStatus()     // Catch:{ all -> 0x033f }
            if (r0 != 0) goto L_0x023c
            java.lang.String r0 = f44258a     // Catch:{ all -> 0x033f }
            java.lang.String r1 = "onOrderStatusGot:status is null"
            com.didi.travel.p171v2.util.LogUtils.m31493i(r0, r1)     // Catch:{ all -> 0x033f }
            r3.setOrderStatus(r11)     // Catch:{ all -> 0x033f }
            boolean r0 = r3.isDirty()     // Catch:{ all -> 0x033f }
            if (r0 == 0) goto L_0x030b
            r10.m31462f()     // Catch:{ all -> 0x033f }
            goto L_0x030b
        L_0x023c:
            java.lang.String r0 = r11.lineMD5()     // Catch:{ all -> 0x033f }
            com.didi.travel.psnger.core.model.response.IOrderStatus r1 = r3.getOrderStatus()     // Catch:{ all -> 0x033f }
            java.lang.String r1 = r1.lineMD5()     // Catch:{ all -> 0x033f }
            boolean r0 = android.text.TextUtils.equals(r0, r1)     // Catch:{ all -> 0x033f }
            r0 = r0 ^ r5
            if (r0 == 0) goto L_0x0259
            android.os.Handler r0 = r10.mHandler     // Catch:{ all -> 0x033f }
            com.didi.travel.psnger.v2.poll.ExpressOrderStatusPoll$10 r1 = new com.didi.travel.psnger.v2.poll.ExpressOrderStatusPoll$10     // Catch:{ all -> 0x033f }
            r1.<init>()     // Catch:{ all -> 0x033f }
            r0.post(r1)     // Catch:{ all -> 0x033f }
        L_0x0259:
            int r0 = r11.subStatus()     // Catch:{ all -> 0x033f }
            com.didi.travel.psnger.core.model.response.IOrderStatus r1 = r3.getOrderStatus()     // Catch:{ all -> 0x033f }
            int r1 = r1.subStatus()     // Catch:{ all -> 0x033f }
            if (r0 == r1) goto L_0x0269
            r0 = 1
            goto L_0x026a
        L_0x0269:
            r0 = 0
        L_0x026a:
            int r1 = r11.status()     // Catch:{ all -> 0x033f }
            if (r1 <= 0) goto L_0x0280
            int r1 = r11.status()     // Catch:{ all -> 0x033f }
            com.didi.travel.psnger.core.model.response.IOrderStatus r4 = r3.getOrderStatus()     // Catch:{ all -> 0x033f }
            int r4 = r4.status()     // Catch:{ all -> 0x033f }
            if (r1 == r4) goto L_0x0280
            r1 = 1
            goto L_0x0281
        L_0x0280:
            r1 = 0
        L_0x0281:
            java.lang.String r4 = f44258a     // Catch:{ all -> 0x033f }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x033f }
            r6.<init>()     // Catch:{ all -> 0x033f }
            java.lang.String r7 = "onOrderStatusGot:isSubStatusChanged="
            r6.append(r7)     // Catch:{ all -> 0x033f }
            r6.append(r0)     // Catch:{ all -> 0x033f }
            java.lang.String r0 = " isStatusChanged="
            r6.append(r0)     // Catch:{ all -> 0x033f }
            r6.append(r1)     // Catch:{ all -> 0x033f }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x033f }
            com.didi.travel.p171v2.util.LogUtils.m31493i(r4, r0)     // Catch:{ all -> 0x033f }
            r3.setOrderStatus(r11)     // Catch:{ all -> 0x033f }
            int r0 = r11.subStatus()     // Catch:{ all -> 0x033f }
            int r1 = r3.getSubStatus()     // Catch:{ all -> 0x033f }
            if (r0 == r1) goto L_0x02ae
            r0 = 1
            goto L_0x02af
        L_0x02ae:
            r0 = 0
        L_0x02af:
            int r1 = r11.status()     // Catch:{ all -> 0x033f }
            if (r1 <= 0) goto L_0x02c0
            int r1 = r11.status()     // Catch:{ all -> 0x033f }
            int r4 = r3.getStatus()     // Catch:{ all -> 0x033f }
            if (r1 == r4) goto L_0x02c0
            goto L_0x02c1
        L_0x02c0:
            r5 = 0
        L_0x02c1:
            java.lang.String r1 = f44258a     // Catch:{ all -> 0x033f }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x033f }
            r4.<init>()     // Catch:{ all -> 0x033f }
            java.lang.String r6 = "onOrderStatusGot:isDetailSubStatusChanged="
            r4.append(r6)     // Catch:{ all -> 0x033f }
            r4.append(r0)     // Catch:{ all -> 0x033f }
            java.lang.String r0 = " isDetailStatusChanged="
            r4.append(r0)     // Catch:{ all -> 0x033f }
            r4.append(r5)     // Catch:{ all -> 0x033f }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x033f }
            com.didi.travel.p171v2.util.LogUtils.m31493i(r1, r0)     // Catch:{ all -> 0x033f }
            boolean r0 = r3.isDirty()     // Catch:{ all -> 0x033f }
            if (r0 == 0) goto L_0x02e9
            r10.m31462f()     // Catch:{ all -> 0x033f }
            goto L_0x030b
        L_0x02e9:
            com.didi.travel.psnger.model.response.OrderRealtimePriceCount r0 = r3.getRealtimePriceCount()     // Catch:{ all -> 0x033f }
            if (r0 == 0) goto L_0x0303
            java.util.concurrent.atomic.AtomicBoolean r0 = r10.f44270m     // Catch:{ all -> 0x033f }
            boolean r0 = r0.get()     // Catch:{ all -> 0x033f }
            if (r0 == 0) goto L_0x02f8
            goto L_0x0303
        L_0x02f8:
            android.os.Handler r0 = r10.mHandler     // Catch:{ all -> 0x033f }
            com.didi.travel.psnger.v2.poll.ExpressOrderStatusPoll$11 r1 = new com.didi.travel.psnger.v2.poll.ExpressOrderStatusPoll$11     // Catch:{ all -> 0x033f }
            r1.<init>(r11)     // Catch:{ all -> 0x033f }
            r0.post(r1)     // Catch:{ all -> 0x033f }
            goto L_0x030b
        L_0x0303:
            java.util.concurrent.atomic.AtomicBoolean r0 = r10.f44270m     // Catch:{ all -> 0x033f }
            r0.set(r2)     // Catch:{ all -> 0x033f }
            r10.m31466h()     // Catch:{ all -> 0x033f }
        L_0x030b:
            if (r12 != 0) goto L_0x033d
            int r12 = r11.intervalTime()     // Catch:{ all -> 0x033f }
            long r0 = (long) r12     // Catch:{ all -> 0x033f }
            r12 = 1004(0x3ec, float:1.407E-42)
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0322
            com.didi.travel.v2.session.Scene r11 = r10.m31445a((int) r12)     // Catch:{ all -> 0x033f }
            r10.stopPoll(r11)     // Catch:{ all -> 0x033f }
            goto L_0x033d
        L_0x0322:
            int r0 = r11.intervalTime()     // Catch:{ all -> 0x033f }
            long r0 = (long) r0     // Catch:{ all -> 0x033f }
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x033d
            com.didi.travel.v2.session.Scene r12 = r10.m31445a((int) r12)     // Catch:{ all -> 0x033f }
            int r11 = r11.intervalTime()     // Catch:{ all -> 0x033f }
            int r11 = r11 * 1000
            long r0 = (long) r11     // Catch:{ all -> 0x033f }
            long r0 = r10.m31444a((long) r0)     // Catch:{ all -> 0x033f }
            r10.setPollInterval(r12, r0)     // Catch:{ all -> 0x033f }
        L_0x033d:
            monitor-exit(r10)
            return
        L_0x033f:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.travel.psnger.p170v2.poll.ExpressOrderStatusPoll.onOrderStatusGot(com.didi.travel.psnger.core.model.response.DTSDKOrderStatus, boolean):void");
    }

    /* renamed from: a */
    private void m31449a(DTSDKOrderStatus dTSDKOrderStatus) {
        if (dTSDKOrderStatus != null) {
            int i = dTSDKOrderStatus.status;
            int i2 = dTSDKOrderStatus.subStatus;
            OrderFloatWindowManager Instance = OrderFloatWindowManager.Instance();
            if (i == 7) {
                Instance.updateOrderState(OrderState.STATE_CALLING);
            }
            if (i == 2 && i == 2003) {
                Instance.updateOrderState(OrderState.STATE_CANCEL);
            }
            if (i != 2 || i2 != 2003) {
                switch (i2) {
                    case 4001:
                    case 4002:
                        Instance.updateOrderState(OrderState.STATE_PICKUP);
                        break;
                    case 4003:
                        Instance.updateOrderState(OrderState.STATE_ARRIVED);
                        break;
                    case 4004:
                        Instance.updateOrderState(OrderState.STATE_PASSENGER_LATE);
                        break;
                    case 4006:
                    case 4007:
                        Instance.updateOrderState(OrderState.STATE_PASSENGER_BOARDED);
                        break;
                }
            } else if (!TextUtils.isEmpty(dTSDKOrderStatus.newOrderId)) {
                OrderFloatWindowManager.Instance().updateOrderState(OrderState.STATE_CANCEL_REASSIGNMENT);
            } else {
                OrderFloatWindowManager.Instance().updateOrderState(OrderState.STATE_CANCEL);
            }
            CarOrder d = m31457d();
            if (d != null) {
                Instance.setProductId(String.valueOf(d.productid));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public CarOrder m31457d() {
        Store store = Store.getStore(TravelUtil.generateCarOrderStoreKey(this.f44262e));
        if (store == null) {
            m31452a("getCarOrder", (Runnable) null);
        }
        if (store == null) {
            return null;
        }
        return (CarOrder) store.getData();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m31459e() {
        Logger logger = LoggerFactory.getLogger("GlobalTravelSdk");
        logger.info("doQueryOrderStatus " + this.f44262e, new Object[0]);
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", this.f44262e);
        ((IExpress) this.f44261d.getIBiz(IExpress.class)).getOrderStatus(hashMap, new RemoteCallback<DTSDKOrderStatus>() {
            public void onBizFail(DTSDKOrderStatus dTSDKOrderStatus) {
            }

            public void onFinish(DTSDKOrderStatus dTSDKOrderStatus) {
            }

            public void onNetError(DTSDKOrderStatus dTSDKOrderStatus) {
            }

            public void onBizSuccess(DTSDKOrderStatus dTSDKOrderStatus) {
                ExpressOrderStatusPoll.this.onOrderStatusGot(dTSDKOrderStatus, false);
            }
        });
    }

    /* renamed from: f */
    private void m31462f() {
        Logger logger = LoggerFactory.getLogger("GlobalTravelSdk");
        logger.info("doQueryOrderDetail" + this.f44262e, new Object[0]);
        BaseEventPublisher.getPublisher().publishSync(EventKeys.XEngine.EVENT_X_ENGINE_ORDER_STATUS_CHANGE, this.f44262e);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m31452a(String str, Runnable runnable) {
        Session session = this.f44261d;
        if (session == null || session.getLifecycle().getCurrentState() != Lifecycle.State.DESTROYED) {
            String str2 = f44258a;
            LogUtils.m31492e(str2, str + ":carOrder is null, mSession state = " + this.f44261d.getLifecycle().getCurrentState());
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        String str3 = f44258a;
        LogUtils.m31495w(str3, str + ":carOrder is null, mSession is destroyed");
    }

    /* renamed from: g */
    private void m31464g() {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", this.f44262e);
        ((IExpress) this.f44261d.getIBiz(IExpress.class)).getOnServiceRealtimePrice(hashMap, new RemoteCallback<OrderRealtimePriceCount>() {
            public void onBizFail(OrderRealtimePriceCount orderRealtimePriceCount) {
            }

            public void onFinish(OrderRealtimePriceCount orderRealtimePriceCount) {
            }

            public void onNetError(OrderRealtimePriceCount orderRealtimePriceCount) {
            }

            public void onBizSuccess(final OrderRealtimePriceCount orderRealtimePriceCount) {
                String a = ExpressOrderStatusPoll.f44258a;
                LogUtils.m31493i(a, "getOnServiceRealtimePrice onBizSuccess : data = " + orderRealtimePriceCount);
                CarOrder h = ExpressOrderStatusPoll.this.m31457d();
                if (h == null) {
                    ExpressOrderStatusPoll.this.m31452a("doQueryRealtimePrice", (Runnable) new Runnable() {
                        public void run() {
                            LogUtils.m31492e(ExpressOrderStatusPoll.f44258a, "doQueryRealtimePrice:invalid data, carOrder is null");
                        }
                    });
                    return;
                }
                h.setRealtimePriceCount(orderRealtimePriceCount);
                ExpressOrderStatusPoll.this.mHandler.post(new Runnable() {
                    public void run() {
                        for (IDiDiCoreCallback next : ExpressOrderStatusPoll.this.getOrderCallbackSet()) {
                            if (next != null) {
                                next.onRealtimePriceRefresh(orderRealtimePriceCount);
                            }
                        }
                    }
                });
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m31466h() {
        CarOrder d = m31457d();
        if (d == null) {
            m31452a("onOrderDetailFinished", (Runnable) new Runnable() {
                public void run() {
                    LogUtils.m31492e(ExpressOrderStatusPoll.f44258a, "onOrderDetailFinished:invalid state, carOrder is null");
                }
            });
            return;
        }
        final IOrderStatus orderStatus = d.getOrderStatus();
        if (d != null && orderStatus != null) {
            if (orderStatus.status() == 4 && orderStatus.subStatus() == 4006) {
                m31464g();
            }
            this.mHandler.post(new Runnable() {
                public void run() {
                    Logger logger = LoggerFactory.getLogger("GlobalTravelSdk");
                    logger.info("onOrderDetailFinished:" + TravelUtil.getRichOid(orderStatus.oid()) + ", orderStatus = " + orderStatus.status() + "-" + orderStatus.subStatus(), new Object[0]);
                    for (IDiDiCoreCallback next : ExpressOrderStatusPoll.this.getOrderCallbackSet()) {
                        if (next != null) {
                            next.onOrderStatusChange(orderStatus);
                        }
                    }
                }
            });
        }
    }

    public synchronized Set<IDiDiCoreCallback> getOrderCallbackSet() {
        return new HashSet(this.f44266i);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m31468i() {
        LogUtils.m31492e(f44258a, "onOrderDetailFail");
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m31469j() {
        LogUtils.m31492e(f44258a, "onOrderDetailError");
    }

    public void setSession(Session session) {
        this.f44261d = session;
    }

    public Session getSession() {
        return this.f44261d;
    }
}
