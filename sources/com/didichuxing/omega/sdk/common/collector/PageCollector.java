package com.didichuxing.omega.sdk.common.collector;

import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.utils.BoundedLinkedQueue;
import com.didichuxing.omega.sdk.common.utils.CommonUtil;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Iterator;

public class PageCollector {
    private static BoundedLinkedQueue<PageKeeper> mPageQueue = new BoundedLinkedQueue<>(OmegaConfig.ACTIVITY_QUEUE_MAX_LEN);

    public static void whenPageResumed(Object obj) {
        PageKeeper pageKeeper = new PageKeeper(obj);
        pageKeeper.indate = new Date();
        mPageQueue.add(pageKeeper);
    }

    public static void whenPagePaused(Object obj) {
        Iterator descendingIterator = mPageQueue.descendingIterator();
        PageKeeper pageKeeper = null;
        while (descendingIterator.hasNext()) {
            PageKeeper pageKeeper2 = (PageKeeper) descendingIterator.next();
            if (pageKeeper2.outdate != null) {
                break;
            }
            pageKeeper = pageKeeper2;
        }
        if (pageKeeper != null && pageKeeper.get() != null) {
            pageKeeper.outdate = new Date();
        }
    }

    public static String getPageHistory() {
        StringBuilder sb = new StringBuilder();
        Iterator it = mPageQueue.iterator();
        while (it.hasNext()) {
            PageKeeper pageKeeper = (PageKeeper) it.next();
            if (pageKeeper != null) {
                sb.append(pageKeeper.f48478pn);
                sb.append(" ● ");
                sb.append(CommonUtil.time2Human(pageKeeper.indate));
                sb.append(" ➜ ");
                if (pageKeeper.outdate == null) {
                    sb.append("... ✘\n");
                } else {
                    sb.append(CommonUtil.time2Human(pageKeeper.outdate));
                    sb.append(" ✔\n");
                }
            }
        }
        return sb.toString();
    }

    public static String getCurPage() {
        PageKeeper last = mPageQueue.getLast();
        return (last == null || last.get() == null) ? "" : last.f48478pn;
    }

    static class PageKeeper extends WeakReference<Object> {
        Date indate;
        Date outdate;

        /* renamed from: pn */
        String f48478pn;

        PageKeeper(Object obj) {
            super(obj);
            this.f48478pn = CommonUtil.simplifyClassName(obj instanceof String ? (String) obj : obj.getClass().getName());
        }
    }
}
