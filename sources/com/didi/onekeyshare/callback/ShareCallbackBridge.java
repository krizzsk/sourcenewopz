package com.didi.onekeyshare.callback;

import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.share.ErrorCode;
import com.didi.share.spi.ComponentManager;

public class ShareCallbackBridge {

    /* renamed from: a */
    private static ShareCallbackBridge f29760a;

    /* renamed from: b */
    private ICallback.IPlatformShareCallback f29761b = new CallbackBridge();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ICallback.IPlatformShareCallback f29762c;

    public static ShareCallbackBridge getInstance() {
        if (f29760a == null) {
            synchronized (ShareCallbackBridge.class) {
                if (f29760a == null) {
                    f29760a = new ShareCallbackBridge();
                }
            }
        }
        return f29760a;
    }

    private ShareCallbackBridge() {
    }

    public ICallback.IPlatformShareCallback getShareCallback() {
        return this.f29761b;
    }

    public void setPlatformListener(ICallback.IPlatformShareCallback iPlatformShareCallback) {
        this.f29762c = iPlatformShareCallback;
    }

    public class CallbackBridge implements ICallback.IPlatformShareCallback2 {
        public static final int RET_CANCEL = 3;
        public static final int RET_ERROR = 2;
        public static final int RET_OK = 1;

        public CallbackBridge() {
        }

        public void onComplete(SharePlatform sharePlatform) {
            int i = C104021.$SwitchMap$com$didi$onekeyshare$entity$SharePlatform[sharePlatform.ordinal()];
            if (i == 1 || i == 2) {
                callbackWx(1, sharePlatform, 0);
            } else if (i == 3 || i == 4) {
                callbackAlipay(1, sharePlatform, 0);
            } else if (ShareCallbackBridge.this.f29762c != null) {
                ShareCallbackBridge.this.f29762c.onComplete(sharePlatform);
                ICallback.IPlatformShareCallback unused = ShareCallbackBridge.this.f29762c = null;
            }
        }

        public void onError(SharePlatform sharePlatform) {
            onError(sharePlatform, ErrorCode.ERR_COMM);
        }

        public void onError(SharePlatform sharePlatform, int i) {
            int i2 = C104021.$SwitchMap$com$didi$onekeyshare$entity$SharePlatform[sharePlatform.ordinal()];
            if (i2 == 1 || i2 == 2) {
                callbackWx(2, sharePlatform, i);
            } else if (i2 == 3 || i2 == 4) {
                callbackAlipay(2, sharePlatform, i);
            } else if (ShareCallbackBridge.this.f29762c != null) {
                ShareCallbackBridge.this.f29762c.onError(sharePlatform);
                if (ShareCallbackBridge.this.f29762c instanceof ICallback.IPlatformShareCallback2) {
                    ((ICallback.IPlatformShareCallback2) ShareCallbackBridge.this.f29762c).onError(sharePlatform, i);
                }
                ICallback.IPlatformShareCallback unused = ShareCallbackBridge.this.f29762c = null;
            }
        }

        public void onCancel(SharePlatform sharePlatform) {
            int i = C104021.$SwitchMap$com$didi$onekeyshare$entity$SharePlatform[sharePlatform.ordinal()];
            if (i == 1 || i == 2) {
                callbackWx(3, sharePlatform, 0);
            } else if (i == 3 || i == 4) {
                callbackAlipay(3, sharePlatform, 0);
            } else if (ShareCallbackBridge.this.f29762c != null) {
                ShareCallbackBridge.this.f29762c.onCancel(sharePlatform);
                ICallback.IPlatformShareCallback unused = ShareCallbackBridge.this.f29762c = null;
            }
        }

        private synchronized void callbackAlipay(int i, SharePlatform sharePlatform, int i2) {
            ICallbackComponent iCallbackComponent = (ICallbackComponent) ComponentManager.getInstance().getComponent(ICallbackComponent.class);
            ICallback.IPlatformShareCallback callback = iCallbackComponent.getCallback();
            if (callback != null) {
                if (i == 1) {
                    callback.onComplete(sharePlatform);
                } else if (i == 2) {
                    callback.onError(sharePlatform);
                    if (callback instanceof ICallback.IPlatformShareCallback2) {
                        ((ICallback.IPlatformShareCallback2) callback).onError(sharePlatform, i2);
                    }
                } else if (i == 3) {
                    callback.onCancel(sharePlatform);
                }
                iCallbackComponent.setCallback((ICallback.IPlatformShareCallback) null);
            }
        }

        private synchronized void callbackWx(int i, SharePlatform sharePlatform, int i2) {
            if (ShareCallbackBridge.this.f29762c != null) {
                if (i == 1) {
                    ShareCallbackBridge.this.f29762c.onComplete(sharePlatform);
                } else if (i == 2) {
                    ShareCallbackBridge.this.f29762c.onError(sharePlatform);
                    if (ShareCallbackBridge.this.f29762c instanceof ICallback.IPlatformShareCallback2) {
                        ((ICallback.IPlatformShareCallback2) ShareCallbackBridge.this.f29762c).onError(sharePlatform, i2);
                    }
                } else if (i == 3) {
                    ShareCallbackBridge.this.f29762c.onCancel(sharePlatform);
                }
                ICallback.IPlatformShareCallback unused = ShareCallbackBridge.this.f29762c = null;
            }
        }
    }

    /* renamed from: com.didi.onekeyshare.callback.ShareCallbackBridge$1 */
    static /* synthetic */ class C104021 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$onekeyshare$entity$SharePlatform;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.didi.onekeyshare.entity.SharePlatform[] r0 = com.didi.onekeyshare.entity.SharePlatform.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$onekeyshare$entity$SharePlatform = r0
                com.didi.onekeyshare.entity.SharePlatform r1 = com.didi.onekeyshare.entity.SharePlatform.WXCHAT_PLATFORM     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$onekeyshare$entity$SharePlatform     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.onekeyshare.entity.SharePlatform r1 = com.didi.onekeyshare.entity.SharePlatform.WXMOMENTS_PLATFORM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$onekeyshare$entity$SharePlatform     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.onekeyshare.entity.SharePlatform r1 = com.didi.onekeyshare.entity.SharePlatform.ALIPAY_FRIEND_PLAFORM     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$onekeyshare$entity$SharePlatform     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.onekeyshare.entity.SharePlatform r1 = com.didi.onekeyshare.entity.SharePlatform.ALIPAY_CIRCLE_PLAFORM     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.onekeyshare.callback.ShareCallbackBridge.C104021.<clinit>():void");
        }
    }
}
