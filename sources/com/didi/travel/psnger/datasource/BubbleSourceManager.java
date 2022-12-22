package com.didi.travel.psnger.datasource;

import android.content.Context;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.SPUtils;
import com.didi.travel.psnger.model.response.estimate.CarBubbleModule;
import com.didi.travel.psnger.model.response.newbubbleParams.BubbleItemModel;
import com.didi.travel.psnger.model.response.newbubbleParams.BubbleLocation;
import java.util.List;

public class BubbleSourceManager {

    /* renamed from: a */
    private static final String f44204a = BubbleSourceManager.class.getSimpleName();

    /* renamed from: b */
    private final Logger f44205b = LoggerFactory.getLogger(f44204a);

    /* renamed from: c */
    private final Context f44206c;

    /* renamed from: d */
    private boolean f44207d;

    /* renamed from: e */
    private CarBubbleModule f44208e;

    public BubbleSourceManager(Context context) {
        this.f44206c = context;
    }

    public BubbleItemModel getBubble(int i, CarBubbleModule carBubbleModule) {
        return getBubble(i, carBubbleModule, true);
    }

    public BubbleItemModel getBubble(int i, CarBubbleModule carBubbleModule, boolean z) {
        Logger logger = this.f44205b;
        logger.debug("getBubbleLocation: " + i, new Object[0]);
        this.f44208e = carBubbleModule;
        BubbleItemModel bubbleItemModel = null;
        if (carBubbleModule.locationList != null) {
            List<BubbleLocation> list = carBubbleModule.locationList;
            if (list.size() > 0) {
                for (BubbleLocation next : list) {
                    if (next.location == i) {
                        bubbleItemModel = m31411a(next, z);
                    } else {
                        this.f44205b.debug("no this location date", new Object[0]);
                    }
                }
            } else {
                this.f44205b.debug("locationList size is 0", new Object[0]);
            }
        } else {
            this.f44205b.debug("locationList is null", new Object[0]);
        }
        return bubbleItemModel;
    }

    /* renamed from: a */
    private BubbleItemModel m31411a(BubbleLocation bubbleLocation, boolean z) {
        if (bubbleLocation.bubbles != null) {
            List<BubbleItemModel> list = bubbleLocation.bubbles;
            if (list.size() > 0) {
                for (BubbleItemModel next : list) {
                    String str = next.bubbleId;
                    if (isShowBubble(str, next.showCount) && (!m31412a(str) || this.f44207d)) {
                        return next;
                    }
                }
                return null;
            }
            this.f44205b.debug("bubblesList size is 0", new Object[0]);
        } else {
            this.f44205b.debug("bubblesList is null", new Object[0]);
        }
        return null;
    }

    public void saveBubbleShowCount(String str) {
        SPUtils.put(this.f44206c, str, Integer.valueOf(((Integer) SPUtils.get(this.f44206c, str, 0)).intValue() + 1));
    }

    public boolean isShowBubble(String str, int i) {
        int intValue = ((Integer) SPUtils.get(this.f44206c, str, 0)).intValue();
        Logger logger = this.f44205b;
        logger.debug("isShowBubble>>  bubbleId：" + str + " localCount：" + intValue, new Object[0]);
        if (i == -1 || intValue < i) {
            return true;
        }
        return false;
    }

    public void setmIsJapan(boolean z) {
        this.f44207d = z;
    }

    /* renamed from: a */
    private boolean m31412a(String str) {
        if (this.f44208e.strategy == null || this.f44208e.strategy.strategyItems == null || this.f44208e.strategy.strategyItems.size() <= 0) {
            return false;
        }
        return this.f44208e.strategy.strategyItems.contains(str);
    }
}
