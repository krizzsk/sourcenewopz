package com.didi.soda.web.page.performance;

import android.text.TextUtils;
import com.didi.soda.web.tools.LogUtil;
import java.util.HashMap;

public class PagePerformanceDelegate {

    /* renamed from: a */
    private HashMap<String, PagePerformance> f43908a = new HashMap<>();

    /* renamed from: b */
    private PagePerformanceListener f43909b;

    public void onDestroy() {
        LogUtil.info("PagePerformanceDelegate onDestroy");
        this.f43908a.clear();
        this.f43909b = null;
    }

    public void onWebPageStarted(String str) {
        if (!TextUtils.isEmpty(str)) {
            LogUtil.info("PagePerformanceDelegate Started ->" + str);
            PagePerformance pagePerformance = new PagePerformance();
            pagePerformance.url = str;
            pagePerformance.startTime = System.currentTimeMillis();
            this.f43908a.put(str, pagePerformance);
        }
    }

    public void onWebPageFinished(String str) {
        if (!TextUtils.isEmpty(str)) {
            LogUtil.info("PagePerformanceDelegate onWebPageFinished");
            if (this.f43908a.containsKey(str)) {
                LogUtil.info("PerformanceDelegate Finished ->" + str);
                PagePerformance remove = this.f43908a.remove(str);
                remove.endTime = System.currentTimeMillis();
                remove.totalTime = remove.endTime - remove.startTime;
                PagePerformanceListener pagePerformanceListener = this.f43909b;
                if (pagePerformanceListener != null) {
                    pagePerformanceListener.onPagePerformance(remove);
                }
            }
        }
    }

    public void setPerformanceListener(PagePerformanceListener pagePerformanceListener) {
        this.f43909b = pagePerformanceListener;
    }
}
