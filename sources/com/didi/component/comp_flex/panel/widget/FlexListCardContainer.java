package com.didi.component.comp_flex.panel.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.didi.component.business.commonlist.item.CommonListCardProperty;
import com.didi.component.business.commonlist.widget.CommonListCardContainer;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import java.util.Iterator;
import java.util.List;

public class FlexListCardContainer extends CommonListCardContainer {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Logger f12206a = LoggerFactory.getLogger(getClass());
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f12207b;

    public FlexListCardContainer(Context context) {
        super(context);
    }

    public FlexListCardContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FlexListCardContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        super.init(context);
        setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                Logger a = FlexListCardContainer.this.f12206a;
                a.debug("lxsScrolloldScrollY = " + i4 + " --> scrollY = " + i2, new Object[0]);
                int i5 = i2 - i4;
                if (!FlexListCardContainer.this.f12207b) {
                    boolean unused = FlexListCardContainer.this.f12207b = true;
                    if (i5 > 0) {
                        FlexListCardContainer.this.f12206a.debug("lxsScroll向上滑", new Object[0]);
                        GlobalOmegaUtils.trackEvent("ibt_gp_wait_drivercard_sd", "type", "up");
                        return;
                    }
                    FlexListCardContainer.this.f12206a.debug("lxsScroll向下滑", new Object[0]);
                    GlobalOmegaUtils.trackEvent("ibt_gp_wait_drivercard_sd", "type", "down");
                }
            }
        });
        setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    boolean unused = FlexListCardContainer.this.f12207b = false;
                    FlexListCardContainer.this.f12206a.debug("lxsScroll手指离开", new Object[0]);
                }
                return false;
            }
        });
    }

    public void setData(List<CommonListCardProperty> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            Iterator<CommonListCardProperty> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getId().equals("flex_driver_card")) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_TRIP_SHOW_OR_HIDE_FLEX, true);
                super.setData(list);
                return;
            }
            this.f12206a.info("lxslxs: no flex driver data", new Object[0]);
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.WaitRsp.EVENT_TRIP_SHOW_OR_HIDE_FLEX, false);
        }
    }
}
