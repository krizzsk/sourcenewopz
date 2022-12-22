package com.didichuxing.bigdata.p173dp.locsdk.biz;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.Looper;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.biz.BizManager */
public class BizManager implements BizStateListener {

    /* renamed from: a */
    private Handler f45742a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C15096a f45743b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<BizStateListener> f45744c;

    private BizManager() {
        this.f45742a = new Handler(Looper.getMainLooper());
        this.f45744c = new ArrayList();
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.biz.BizManager$SingleHolder */
    private static class SingleHolder {
        static BizManager INSTANCE = new BizManager();

        private SingleHolder() {
        }
    }

    public static BizManager getIntance() {
        return SingleHolder.INSTANCE;
    }

    public void init(final Context context) {
        m32756a((Runnable) new Runnable() {
            public void run() {
                BizClientType bizClientType = BizManager.this.getBizClientType(context);
                if (C150945.$SwitchMap$com$didichuxing$bigdata$dp$locsdk$biz$BizClientType[bizClientType.ordinal()] == 1) {
                    C15096a unused = BizManager.this.f45743b = new DriverCommonBizAdapter();
                }
                DLog.m32737d("BizManager.init bizClientCategory=" + bizClientType + " bizAdapterImpl=" + BizManager.this.f45743b);
                if (BizManager.this.f45743b != null) {
                    BizManager.this.f45743b.mo114370a(context);
                }
            }
        });
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.biz.BizManager$5 */
    static /* synthetic */ class C150945 {
        static final /* synthetic */ int[] $SwitchMap$com$didichuxing$bigdata$dp$locsdk$biz$BizClientType;

        static {
            int[] iArr = new int[BizClientType.values().length];
            $SwitchMap$com$didichuxing$bigdata$dp$locsdk$biz$BizClientType = iArr;
            try {
                iArr[BizClientType.DRIVER_COMMON.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void registerBizStateListener(final BizStateListener bizStateListener) {
        m32756a((Runnable) new Runnable() {
            public void run() {
                DLog.m32737d("BizManager.registerBizStateListener bizAdapterImpl=" + BizManager.this.f45743b);
                if (BizManager.this.f45743b != null) {
                    if (BizManager.this.f45744c.size() == 0) {
                        BizManager.this.f45743b.mo114371a((BizStateListener) BizManager.this);
                    }
                    BizManager.this.f45744c.add(bizStateListener);
                }
            }
        });
    }

    public void unregisterBizStateListener(final BizStateListener bizStateListener) {
        m32756a((Runnable) new Runnable() {
            public void run() {
                DLog.m32737d("BizManager.unregisterBizStateListener bizAdapterImpl=" + BizManager.this.f45743b);
                if (BizManager.this.f45743b != null) {
                    BizManager.this.f45744c.remove(bizStateListener);
                    if (BizManager.this.f45744c.size() == 0) {
                        BizManager.this.f45743b.mo114371a((BizStateListener) null);
                    }
                }
            }
        });
    }

    public void onBizStateChanged(final BizState bizState, final String str, final String str2) {
        m32756a((Runnable) new Runnable() {
            public void run() {
                for (BizStateListener bizStateListener : BizManager.this.f45744c) {
                    if (bizStateListener != null) {
                        bizStateListener.onBizStateChanged(bizState, str, str2);
                    }
                }
            }
        });
    }

    public BizClientType getBizClientType(Context context) {
        String packageName = context.getPackageName();
        if ("com.sdu.didi.gsui".equals(packageName)) {
            return BizClientType.DRIVER_COMMON;
        }
        if (!m32757a(context) || !"com.didichuxing.bigdata.dp.locsdkdemo".equals(packageName)) {
            return BizClientType.UNKNOWN;
        }
        return BizClientType.DRIVER_COMMON;
    }

    /* renamed from: a */
    private boolean m32757a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || (applicationInfo.flags & 2) == 0) ? false : true;
    }

    /* renamed from: a */
    private void m32756a(Runnable runnable) {
        if (runnable != null) {
            this.f45742a.post(runnable);
        }
    }
}
