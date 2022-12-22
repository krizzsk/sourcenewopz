package com.didi.component.service.presenter.onservice;

import android.os.Handler;
import android.os.Message;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.track.DidiTrackingClient;
import com.didi.component.common.util.GLog;
import com.didi.sdk.messagecenter.p152pb.PassengerState;
import com.didi.travel.psnger.common.push.PushManager;
import com.didi.travel.psnger.model.response.CarOrder;
import java.lang.ref.WeakReference;

public class UploadPostion {

    /* renamed from: a */
    private static final int f15774a = 1;

    /* renamed from: b */
    private static final int f15775b = 1001;

    /* renamed from: c */
    private CarOrder f15776c = CarOrderHelper.getOrder();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f15777d;

    /* renamed from: e */
    private UploadHandler f15778e = new UploadHandler();

    private static class UploadHandler extends Handler {
        private WeakReference<UploadPostion> ref;

        private UploadHandler(UploadPostion uploadPostion) {
            this.ref = new WeakReference<>(uploadPostion);
        }

        public void handleMessage(Message message) {
            if (this.ref.get() != null) {
                UploadPostion uploadPostion = (UploadPostion) this.ref.get();
                int i = message.what;
                if (i != 1) {
                    if (i == 1001) {
                        uploadPostion.doPositionSendForCheat();
                    }
                } else if (!uploadPostion.f15777d) {
                    uploadPostion.m11505a();
                    uploadPostion.m11507b();
                }
            }
        }
    }

    public void initPositionUpload() {
        GLog.m7971i("upload position", "call the initPositionUpload");
        this.f15777d = false;
        this.f15778e.postDelayed(new Runnable() {
            public void run() {
                UploadPostion.this.m11505a();
            }
        }, 1600);
    }

    public void requestPassengerPositionSend() {
        GLog.m7971i("upload position", "call the requestPassengerPositionSend");
        this.f15778e.removeMessages(1001);
        this.f15778e.sendEmptyMessageDelayed(1001, 5000);
    }

    public void cancelPostionSend() {
        GLog.m7971i("upload position", "call the cancelPostionSend");
        this.f15778e.removeMessages(1);
        this.f15777d = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11505a() {
        GLog.m7971i("upload position", "call the requestPositionSend");
        this.f15778e.removeMessages(1);
        this.f15778e.sendEmptyMessageDelayed(1, 3000);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11507b() {
        if (this.f15776c != null) {
            GLog.m7971i("upload position", "call the doPositionSend to send the position");
            DidiTrackingClient.getInstance().callTrackingAtOnce(1);
        }
    }

    public void doPositionSendForCheat() {
        if (this.f15776c != null) {
            GLog.m7971i("upload position", "call the doPositionSendForCheat");
            PushManager.sendLocation(this.f15776c, false, PassengerState.PassengerStateNormal.getValue());
        }
    }
}
