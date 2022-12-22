package com.didiglobal.p205sa.biz.component.sapanel.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.didi.map.setting.common.utils.DisplayUtil;
import com.didi.sdk.app.business.SaBusinessManager;
import com.didi.sdk.app.business.SaTabIds;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.sapanel.PanelAnimatorMgr;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.ISAPanel;
import com.didiglobal.p205sa.biz.component.sapanel.model.PageTouchEventManger;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import com.didiglobal.p205sa.biz.component.sapanel.omega.PanelOmegaTracker;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.sapanel.view.SAPanelRecView */
public class SAPanelRecView implements ISAPanel {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Activity f51143a;

    /* renamed from: b */
    private View f51144b;

    /* renamed from: c */
    private LayoutInflater f51145c;

    /* renamed from: d */
    private SAPanelAdapter f51146d;

    /* renamed from: e */
    private RecyclerView f51147e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public PanelOmegaTracker f51148f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f51149g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f51150h = 0;

    /* renamed from: b */
    static /* synthetic */ int m36645b(SAPanelRecView sAPanelRecView, int i) {
        int i2 = sAPanelRecView.f51149g + i;
        sAPanelRecView.f51149g = i2;
        return i2;
    }

    public SAPanelRecView(Activity activity) {
        this.f51143a = activity;
        this.f51148f = new PanelOmegaTracker();
        m36642a();
    }

    /* renamed from: a */
    private void m36642a() {
        LayoutInflater from = LayoutInflater.from(this.f51143a);
        this.f51145c = from;
        View inflate = from.inflate(R.layout.component_panel_recyclerview, (ViewGroup) null);
        this.f51144b = inflate;
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.xp_scroll_view);
        this.f51147e = recyclerView;
        this.f51147e.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        SAPanelAdapter sAPanelAdapter = new SAPanelAdapter(this.f51147e.getContext());
        this.f51146d = sAPanelAdapter;
        this.f51147e.setAdapter(sAPanelAdapter);
        this.f51147e.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    UIThreadHandler.post(new Runnable() {
                        public void run() {
                            SAPanelRecView.this.f51148f.omegaScrollTrack();
                        }
                    });
                    int i2 = 1;
                    HashMap hashMap = new HashMap(1);
                    if (SAPanelRecView.this.f51149g - SAPanelRecView.this.f51150h <= 0) {
                        i2 = 2;
                    }
                    hashMap.put("type", Integer.valueOf(i2));
                    OmegaSDKAdapter.trackEvent("ibt_gp_sa_home_sd", (Map<String, Object>) hashMap);
                    SAPanelRecView sAPanelRecView = SAPanelRecView.this;
                    int unused = sAPanelRecView.f51150h = sAPanelRecView.f51149g;
                }
            }

            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                SAPanelRecView.m36645b(SAPanelRecView.this, i2);
                if (SAPanelRecView.this.f51149g > DisplayUtil.getScreenHeight(SAPanelRecView.this.f51143a) / 2) {
                    SaBusinessManager.Companion.getIns().notifyTabUp(SaTabIds.TAB_HOME.getId());
                } else {
                    SaBusinessManager.Companion.getIns().notifyTabDown(SaTabIds.TAB_HOME.getId());
                }
                PanelAnimatorMgr.onRvScroll(SAPanelRecView.this.f51149g);
            }
        });
    }

    public void setData(List<SACardProperty> list) {
        if (list != null) {
            m36643a(list);
        }
    }

    /* renamed from: a */
    private void m36643a(List<SACardProperty> list) {
        PageTouchEventManger.showMap = false;
        PageTouchEventManger.mapInFirstPosition = false;
        for (int i = 0; i < list.size(); i++) {
            SACardProperty sACardProperty = list.get(i);
            if (ComponentType.COMPONENT_RIDE_CARD.equals(sACardProperty.getId())) {
                if (sACardProperty.isTransparent()) {
                    PageTouchEventManger.showMap = true;
                }
                if (i == 0) {
                    PageTouchEventManger.mapInFirstPosition = true;
                }
            }
        }
        this.f51146d.setCardPropertyList(list);
        this.f51148f.setCurrentCardProperties(list);
    }

    public void addCard(SACardProperty sACardProperty, int i) {
        this.f51146d.addCard(sACardProperty, i);
    }

    public void removeCard(int i) {
        this.f51146d.removeCard(i);
    }

    public void updateCard(SACardProperty sACardProperty) {
        this.f51146d.updateCard(sACardProperty);
    }

    public View getView() {
        return this.f51144b;
    }

    public RecyclerView getContainer() {
        return this.f51147e;
    }

    public void resumePageSize() {
        RecyclerView recyclerView = this.f51147e;
        if (recyclerView != null) {
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
                if (behavior instanceof SARecycleViewBehavior) {
                    ((SARecycleViewBehavior) behavior).reverseAnimator();
                }
            }
        }
    }

    public void expandPage() {
        RecyclerView recyclerView = this.f51147e;
        if (recyclerView != null) {
            ViewGroup.LayoutParams layoutParams = recyclerView.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
                if (behavior instanceof SARecycleViewBehavior) {
                    ((SARecycleViewBehavior) behavior).expandToRid(1);
                }
            }
        }
    }

    public void scrollTop(int i) {
        if (this.f51149g > DisplayUtil.getScreenHeight(this.f51143a) / 2) {
            this.f51147e.smoothScrollToPosition(0);
        }
    }
}
