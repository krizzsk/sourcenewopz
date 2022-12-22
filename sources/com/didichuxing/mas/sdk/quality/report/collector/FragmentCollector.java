package com.didichuxing.mas.sdk.quality.report.collector;

import com.didichuxing.mas.sdk.quality.report.MASConfig;
import com.didichuxing.mas.sdk.quality.report.utils.BoundedLinkedQueue;
import com.didichuxing.mas.sdk.quality.report.utils.CommonUtil;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Iterator;

public class FragmentCollector {
    private static BoundedLinkedQueue<FragmentKeeper> mFragmentQueue = new BoundedLinkedQueue<>(MASConfig.ACTIVITY_QUEUE_MAX_LEN);

    public static void whenFragmentResumed(Object obj) {
        FragmentKeeper fragmentKeeper = new FragmentKeeper(obj);
        fragmentKeeper.indate = new Date();
        mFragmentQueue.add(fragmentKeeper);
    }

    public static void whenFragmentPaused(Object obj) {
        Iterator descendingIterator = mFragmentQueue.descendingIterator();
        FragmentKeeper fragmentKeeper = null;
        while (descendingIterator.hasNext()) {
            FragmentKeeper fragmentKeeper2 = (FragmentKeeper) descendingIterator.next();
            if (fragmentKeeper2.outdate != null) {
                break;
            }
            fragmentKeeper = fragmentKeeper2;
        }
        if (fragmentKeeper != null && fragmentKeeper.get() != null) {
            fragmentKeeper.outdate = new Date();
        }
    }

    public static String getFragmentHistory() {
        StringBuilder sb = new StringBuilder();
        Iterator it = mFragmentQueue.iterator();
        while (it.hasNext()) {
            FragmentKeeper fragmentKeeper = (FragmentKeeper) it.next();
            if (fragmentKeeper != null) {
                sb.append(PageCollector.desensitizationString(fragmentKeeper.f48287pn));
                sb.append(" ● ");
                sb.append(CommonUtil.time2Human(fragmentKeeper.indate));
                sb.append(" ➜ ");
                if (fragmentKeeper.outdate == null) {
                    sb.append("... ✘\n");
                } else {
                    sb.append(CommonUtil.time2Human(fragmentKeeper.outdate));
                    sb.append(" ✔\n");
                }
            }
        }
        return sb.toString();
    }

    public static String getCurFragmentPage() {
        FragmentKeeper last = mFragmentQueue.getLast();
        return (last == null || last.get() == null) ? "" : last.f48287pn;
    }

    static class FragmentKeeper extends WeakReference<Object> {
        Date indate;
        Date outdate;

        /* renamed from: pn */
        String f48287pn;

        FragmentKeeper(Object obj) {
            super(obj);
            this.f48287pn = CommonUtil.simplifyClassName(obj.getClass().getName());
        }
    }
}
