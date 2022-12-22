package com.didi.beatles.p099im.manager;

import com.didi.beatles.p099im.event.IMMessageUpdateReadStatusEvent;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.impl.IMMessageModule;
import com.didi.beatles.p099im.task.IMTriggerList;
import com.didi.beatles.p099im.utils.IMLog;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.manager.IMMessageReadStatusManager */
public class IMMessageReadStatusManager {

    /* renamed from: a */
    private static final int f9259a = 2000;

    /* renamed from: b */
    private static final int f9260b = 60000;

    /* renamed from: d */
    private static IMMessageReadStatusManager f9261d = null;

    /* renamed from: e */
    private static final String f9262e = "IMMessageReadStatusManager";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IMTriggerList<IMMessage> f9263c;

    public static synchronized IMMessageReadStatusManager getInstance() {
        IMMessageReadStatusManager iMMessageReadStatusManager;
        synchronized (IMMessageReadStatusManager.class) {
            if (f9261d == null) {
                f9261d = new IMMessageReadStatusManager();
            }
            iMMessageReadStatusManager = f9261d;
        }
        return iMMessageReadStatusManager;
    }

    private IMMessageReadStatusManager() {
        IMTriggerList<IMMessage> iMTriggerList = new IMTriggerList<>();
        this.f9263c = iMTriggerList;
        iMTriggerList.addTriggerListener(new IMTriggerList.IMTriggerListener<IMMessage>() {
            public boolean onTrigger(List<IMMessage> list, boolean z) {
                if (z) {
                    IMLog.m6635i(IMMessageReadStatusManager.f9262e, "report repeat,enlarge the interval,size is " + list.size());
                    IMMessageReadStatusManager.this.f9263c.setTriggerTime(60000);
                } else {
                    IMLog.m6635i(IMMessageReadStatusManager.f9262e, "report nomal,size is " + list.size());
                    IMMessageReadStatusManager.this.f9263c.setTriggerTime(2000);
                }
                EventBus.getDefault().post(new IMMessageUpdateReadStatusEvent(list));
                return false;
            }
        });
    }

    public void ackHasReadMsg(IMMessage iMMessage) {
        if (iMMessage != null) {
            IMMessageModule iMMessageModule = (IMMessageModule) IMManager.getInstance().getMessageModel();
            if (iMMessageModule == null) {
                IMLog.m6637w(f9262e, "IMMessageModule is null,ack has read msg failed!");
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(iMMessage.getMid()));
            iMMessageModule.pushMessageReadStatus(iMMessage.getSid(), arrayList);
            IMLog.m6631d(f9262e, "report at once");
        }
    }

    public void addHasReadMsg(IMMessage iMMessage) {
        if (this.f9263c != null) {
            IMLog.m6631d(f9262e, "offer one msg");
            this.f9263c.setTriggerTime(2000);
            this.f9263c.add(iMMessage);
        }
    }

    public void removeHasReportMsg() {
        IMTriggerList<IMMessage> iMTriggerList = this.f9263c;
        if (iMTriggerList != null) {
            iMTriggerList.removeHasExecuted();
        }
    }

    public void removeHasReportMsg(List<IMMessage> list) {
        if (this.f9263c != null && list != null) {
            IMLog.m6635i(f9262e, "remove msgs which are report success, size is " + list.size());
            this.f9263c.removeAll(list);
        }
    }

    public void reportByHand() {
        IMTriggerList<IMMessage> iMTriggerList = this.f9263c;
        if (iMTriggerList != null) {
            iMTriggerList.ExecuteAll(true);
            IMLog.m6631d(f9262e, "report unread msgs by hand");
        }
    }

    public void destory() {
        f9261d = null;
    }
}
