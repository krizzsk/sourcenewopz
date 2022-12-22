package com.didi.beatles.p099im.manager;

import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.api.entity.IMSendActionTipRequest;
import com.didi.beatles.p099im.module.IIMSessionModule;
import com.didi.beatles.p099im.module.IMSendActionTipCallback;
import com.didi.beatles.p099im.pref.IMPreference;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* renamed from: com.didi.beatles.im.manager.IMActionTipManager */
public class IMActionTipManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f9226a = IMActionTipManager.class.getSimpleName();

    /* renamed from: b */
    private static final int f9227b = 3;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Set<String> f9228c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Set<Long> f9229d;

    private IMActionTipManager() {
    }

    public static IMActionTipManager getInstance() {
        return Holder.INSTANCE;
    }

    public void onSystemActionsUpdated(int i, long j, long j2, List<Integer> list) {
        if (j != 0 && list != null && !list.isEmpty()) {
            for (Integer intValue : list) {
                if (intValue.intValue() == 1) {
                    m6241a(i, j, j2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m6241a(int i, long j, long j2) {
        if (!IMContextInfoHelper.enableSendImage()) {
            IMLog.m6631d(f9226a, C4234I.m6591t("[onTakePhotoActionUpdate] disable send image"));
            return;
        }
        if (this.f9228c == null) {
            this.f9228c = IMPreference.getInstance(IMContextInfoHelper.getContext()).getTakPhotoActionTip(IMContextInfoHelper.getUid());
        }
        if (this.f9228c == null) {
            this.f9228c = new HashSet();
        }
        Set<Long> set = this.f9229d;
        if (set == null || !set.contains(Long.valueOf(j))) {
            final int size = this.f9228c.size();
            if (size >= 3) {
                IMLog.m6631d(f9226a, C4234I.m6591t("[onTakePhotoActionUpdate] Reach max count ->", Integer.valueOf(size)));
            } else if (this.f9228c.contains(String.valueOf(j))) {
                IMLog.m6631d(f9226a, C4234I.m6591t("[onTakePhotoActionUpdate] Tip has showed for session ->", Long.valueOf(j)));
            } else {
                if (this.f9229d == null) {
                    this.f9229d = new HashSet();
                }
                this.f9229d.add(Long.valueOf(j));
                IIMSessionModule sessionModel = IMManager.getInstance().getSessionModel();
                if (sessionModel != null) {
                    final long j3 = j;
                    sessionModel.sendActionTipRequest(i, IMContextInfoHelper.getUid(), j2, IMSendActionTipRequest.ACTION_SEND_IMAGE, size, new IMSendActionTipCallback() {
                        public void onSucceed() {
                            IMLog.m6631d(IMActionTipManager.f9226a, C4234I.m6591t("[onTakePhotoActionUpdate] send action tip success. tipCount ->", Integer.valueOf(size)));
                            IMActionTipManager.this.f9228c.add(String.valueOf(j3));
                            IMPreference.getInstance(IMContextInfoHelper.getContext()).setTakePhotoActionTip(IMContextInfoHelper.getUid(), IMActionTipManager.this.f9228c);
                            IMActionTipManager.this.f9229d.remove(Long.valueOf(j3));
                        }

                        public void onFailed() {
                            IMActionTipManager.this.f9229d.remove(Long.valueOf(j3));
                            IMLog.m6631d(IMActionTipManager.f9226a, C4234I.m6591t("[onTakePhotoActionUpdate] send action tip failed. "));
                        }
                    });
                }
            }
        } else {
            IMLog.m6631d(f9226a, C4234I.m6591t("[onTakePhotoActionUpdate] Session is requesting action tip. ->", Long.valueOf(j)));
        }
    }

    /* renamed from: com.didi.beatles.im.manager.IMActionTipManager$Holder */
    private static final class Holder {
        /* access modifiers changed from: private */
        public static final IMActionTipManager INSTANCE = new IMActionTipManager();

        private Holder() {
        }
    }
}
