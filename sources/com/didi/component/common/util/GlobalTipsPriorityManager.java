package com.didi.component.common.util;

import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GlobalTipsPriorityManager {

    /* renamed from: a */
    private static GlobalTipsPriorityManager f11763a = new GlobalTipsPriorityManager();

    /* renamed from: b */
    private LinkedList<ITipsHandler> f11764b = new LinkedList<>();

    /* renamed from: c */
    private LinkedList<ITipsHandler> f11765c = new LinkedList<>();

    /* renamed from: d */
    private Runnable f11766d = new Runnable() {
        public void run() {
            GlobalTipsPriorityManager.this.m7983b();
        }
    };

    /* renamed from: com.didi.component.common.util.GlobalTipsPriorityManager$ID */
    public static class C4831ID {
        public static final int DIALOG_ID_BIND_CARD_GUIDE = 10;
        public static final int DIALOG_ID_FREEPICKUP_COMP_ADVICE = 11;
        public static final int TIPS_ID_BOOKING_COUPON = 3;
        public static final int TIPS_ID_BOOKING_GUIDE = 1;
        public static final int TIPS_ID_NO_QUOTA = 5;
        public static final int TIPS_ID_PAY_WAY_CHANGED_TO_ONLINE = 9;
        public static final int TIPS_ID_PAY_WAY_COUPON = 2;
        public static final int TIPS_ID_PAY_WAY_COUPON_NEW = 7;
        public static final int TIPS_ID_PAY_WAY_QUOTA = 6;
        public static final int TIPS_ID_QUOTA_DETAIL = 4;
    }

    public interface ITipsHandler {
        void dismiss();

        /* renamed from: id */
        int mo47065id();

        int level();

        boolean show();
    }

    public static class Level {
        public static final int DIALOG_LEVEL_BIND_CARD_GUIDE = 700;
        public static final int TIPS_LEVEL_BOOKING_COUPON = 400;
        public static final int TIPS_LEVEL_BOOKING_GUIDE = 300;
        public static final int TIPS_LEVEL_NO_QUOTA = 200;
        public static final int TIPS_LEVEL_PAY_WAY_CHANGED_TO_ONLINE = 500;
        public static final int TIPS_LEVEL_PAY_WAY_COUPON = 600;
        public static final int TIPS_LEVEL_PAY_WAY_COUPON_NEW = 600;
        public static final int TIPS_LEVEL_PAY_WAY_QUOtA = 700;
        public static final int TIPS_LEVEL_QUOTA_DETAIL = 100;
        public static final int TIPS_LEVEL_SELECT_FREEPICKUP_COMPANY = 255;
    }

    private class TipsHandlerProxy implements ITipsHandler {
        ITipsHandler mHandlerRef;

        public TipsHandlerProxy(ITipsHandler iTipsHandler) {
            this.mHandlerRef = iTipsHandler;
        }

        /* renamed from: id */
        public int mo47065id() {
            ITipsHandler iTipsHandler = this.mHandlerRef;
            if (iTipsHandler != null) {
                return iTipsHandler.mo47065id();
            }
            return 0;
        }

        public int level() {
            ITipsHandler iTipsHandler = this.mHandlerRef;
            if (iTipsHandler != null) {
                return iTipsHandler.level();
            }
            return 0;
        }

        public boolean show() {
            ITipsHandler iTipsHandler = this.mHandlerRef;
            if (iTipsHandler != null) {
                return iTipsHandler.show();
            }
            return false;
        }

        public void dismiss() {
            ITipsHandler iTipsHandler = this.mHandlerRef;
            if (iTipsHandler != null) {
                iTipsHandler.dismiss();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                TipsHandlerProxy tipsHandlerProxy = (TipsHandlerProxy) obj;
                ITipsHandler iTipsHandler = this.mHandlerRef;
                if (iTipsHandler == null || tipsHandlerProxy.mHandlerRef == null || iTipsHandler.mo47065id() != tipsHandlerProxy.mHandlerRef.mo47065id()) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            ITipsHandler iTipsHandler = this.mHandlerRef;
            return iTipsHandler != null ? iTipsHandler.hashCode() : hashCode();
        }

        public String toString() {
            if (this.mHandlerRef == null) {
                return super.toString();
            }
            return "[id: " + this.mHandlerRef.mo47065id() + ", level: " + this.mHandlerRef.level() + Const.jaRight;
        }
    }

    public static GlobalTipsPriorityManager getInstance() {
        return f11763a;
    }

    private GlobalTipsPriorityManager() {
    }

    public void consume(ITipsHandler iTipsHandler) {
        if (iTipsHandler != null) {
            TipsHandlerProxy tipsHandlerProxy = new TipsHandlerProxy(iTipsHandler);
            if (!this.f11764b.contains(tipsHandlerProxy) && !this.f11765c.contains(tipsHandlerProxy)) {
                this.f11764b.add(tipsHandlerProxy);
                m7980a();
            }
        }
    }

    public void remove(ITipsHandler iTipsHandler) {
        if (iTipsHandler != null && this.f11765c.contains(iTipsHandler)) {
            this.f11765c.remove(iTipsHandler);
        }
    }

    public void remove(int i) {
        m7982a(this.f11765c, i);
        m7982a(this.f11764b, i);
    }

    /* renamed from: a */
    private void m7982a(List<ITipsHandler> list, int i) {
        ArrayList<ITipsHandler> arrayList = null;
        for (ITipsHandler next : list) {
            if (next.mo47065id() == i) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
            }
        }
        if (arrayList != null) {
            for (ITipsHandler remove : arrayList) {
                list.remove(remove);
            }
        }
    }

    public boolean isShowing(int i) {
        Iterator it = this.f11765c.iterator();
        while (it.hasNext()) {
            if (((ITipsHandler) it.next()).mo47065id() == i) {
                return true;
            }
        }
        return false;
    }

    public boolean isWaiting(int i) {
        Iterator it = this.f11764b.iterator();
        while (it.hasNext()) {
            if (((ITipsHandler) it.next()).mo47065id() == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m7980a() {
        UiThreadHandler.removeCallbacks(this.f11766d);
        UiThreadHandler.post(this.f11766d);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m7983b() {
        Collections.sort(this.f11764b, new Comparator<ITipsHandler>() {
            public int compare(ITipsHandler iTipsHandler, ITipsHandler iTipsHandler2) {
                return iTipsHandler2.level() - iTipsHandler.level();
            }
        });
        List<ITipsHandler> c = m7984c();
        if (c.size() != 0) {
            int i = 0;
            int level = c.get(0).level();
            if (this.f11765c.size() != 0) {
                i = this.f11765c.get(0).level();
            }
            if (i <= level) {
                if (i < level) {
                    for (ITipsHandler dismiss : new ArrayList(this.f11765c)) {
                        dismiss.dismiss();
                    }
                    this.f11765c.clear();
                }
                for (ITipsHandler next : c) {
                    if (next.show()) {
                        this.f11765c.add(next);
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private List<ITipsHandler> m7984c() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= 0 && this.f11764b.size() > 0) {
            ITipsHandler removeFirst = this.f11764b.removeFirst();
            if (removeFirst != null && (i = removeFirst.level()) > 0) {
                arrayList.add(removeFirst);
            }
        }
        while (i > 0 && this.f11764b.size() > 0) {
            ITipsHandler removeFirst2 = this.f11764b.removeFirst();
            if (removeFirst2 != null && removeFirst2.level() == i) {
                arrayList.add(removeFirst2);
            }
        }
        this.f11764b.clear();
        return arrayList;
    }
}
