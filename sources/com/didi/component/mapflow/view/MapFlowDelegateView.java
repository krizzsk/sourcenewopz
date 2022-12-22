package com.didi.component.mapflow.view;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.mapflow.presenter.AbsMapFlowDelegatePresenter;
import com.didi.component.mapflow.view.widget.MapOverlayViewGroup;
import com.didi.map.global.flow.MapFlowView;
import com.didi.sdk.view.tips.TipsContainer;
import com.didi.sdk.view.tips.TipsView;
import com.taxis99.R;

public class MapFlowDelegateView implements IMapFlowDelegateView {

    /* renamed from: a */
    private AbsMapFlowDelegatePresenter f14504a;

    /* renamed from: b */
    private Context f14505b;

    /* renamed from: c */
    private MapFlowView f14506c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TipsContainer f14507d;

    /* renamed from: e */
    private MapOverlayViewGroup f14508e;

    /* renamed from: f */
    private boolean f14509f;

    /* renamed from: g */
    private View f14510g;

    /* renamed from: h */
    private int f14511h = 1;

    /* renamed from: i */
    private int f14512i;

    public View getView() {
        return null;
    }

    public MapFlowDelegateView(Context context, MapFlowView mapFlowView) {
        this.f14505b = context;
        this.f14506c = mapFlowView;
        if (mapFlowView != null) {
            this.f14508e = (MapOverlayViewGroup) mapFlowView.getTag(R.id.id_mapflow_overlayviewgroup);
        }
    }

    public void addBottomMask(int i) {
        this.f14512i = i;
        if (this.f14510g == null) {
            m10308a();
        }
        if (i > 0) {
            if (this.f14510g.getParent() != null) {
                ((ViewGroup) this.f14510g.getParent()).removeView(this.f14510g);
            }
            int i2 = 0;
            while (i2 < this.f14506c.getChildCount()) {
                Object tag = this.f14506c.getChildAt(i2).getTag();
                if (tag == null || !(tag instanceof Integer) || ((Integer) tag).intValue() != this.f14511h) {
                    i2++;
                } else {
                    ((RelativeLayout.LayoutParams) this.f14506c.getChildAt(i2).getLayoutParams()).height = i;
                    return;
                }
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, i);
            layoutParams.addRule(12);
            this.f14506c.addView(this.f14510g, layoutParams);
        }
    }

    public void removeBottomMask() {
        int i = 0;
        while (true) {
            if (i >= this.f14506c.getChildCount()) {
                i = -1;
                break;
            }
            Object tag = this.f14506c.getChildAt(i).getTag();
            if (tag != null && (tag instanceof Integer) && ((Integer) tag).intValue() == this.f14511h) {
                break;
            }
            i++;
        }
        if (i >= 0) {
            this.f14506c.removeViewAt(i);
        }
    }

    /* renamed from: a */
    private void m10308a() {
        View view = new View(this.f14505b);
        this.f14510g = view;
        view.setTag(Integer.valueOf(this.f14511h));
        this.f14510g.setBackgroundResource(R.drawable.tab_gradient_bg);
    }

    public void setPresenter(AbsMapFlowDelegatePresenter absMapFlowDelegatePresenter) {
        this.f14504a = absMapFlowDelegatePresenter;
    }

    public MapFlowView getMapFlowView() {
        return this.f14506c;
    }

    public void showPopup(String str, int i, int i2) {
        if (this.f14506c != null) {
            if (this.f14507d == null) {
                if (this.f14505b instanceof Activity) {
                    this.f14507d = new TipsContainer((Activity) this.f14505b);
                } else {
                    return;
                }
            }
            TipsView tipsView = new TipsView(this.f14505b);
            tipsView.setTips(str);
            tipsView.setId(this.f14506c.hashCode());
            tipsView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (MapFlowDelegateView.this.f14507d != null) {
                        MapFlowDelegateView.this.f14507d.clearAllTips();
                    }
                }
            });
            this.f14507d.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (MapFlowDelegateView.this.f14507d == null) {
                        return false;
                    }
                    MapFlowDelegateView.this.f14507d.clearAllTips();
                    MapFlowDelegateView.this.f14507d.setOnTouchListener((View.OnTouchListener) null);
                    return false;
                }
            });
            this.f14507d.show(tipsView, this.f14506c, 0, 0, i, i2, false);
        }
    }

    public void dismissPopup() {
        TipsContainer tipsContainer = this.f14507d;
        if (tipsContainer != null) {
            tipsContainer.clearAllTips();
            this.f14507d.setOnTouchListener((View.OnTouchListener) null);
            this.f14507d = null;
        }
    }

    public void showMapOverlayView(final MapOverlayViewGroup.OverlayViewsBuilder overlayViewsBuilder) {
        if (this.f14506c != null) {
            if (this.f14508e == null) {
                MapOverlayViewGroup mapOverlayViewGroup = new MapOverlayViewGroup(this.f14505b, this.f14506c);
                this.f14508e = mapOverlayViewGroup;
                this.f14506c.setTag(R.id.id_mapflow_overlayviewgroup, mapOverlayViewGroup);
            }
            C61963 r0 = new MapOverlayViewGroup.OverlayViewsBuilder() {
                public View getOverlayContentView(Context context) {
                    MapOverlayViewGroup.OverlayViewsBuilder overlayViewsBuilder = overlayViewsBuilder;
                    if (overlayViewsBuilder != null) {
                        return overlayViewsBuilder.getOverlayContentView(context);
                    }
                    return null;
                }
            };
            this.f14508e.clearAllOverlayViews();
            this.f14508e.buildOverlayViews(r0);
            this.f14508e.attachToMapFlowView();
        }
    }

    public void dismissMapOverlayView() {
        MapOverlayViewGroup mapOverlayViewGroup = this.f14508e;
        if (mapOverlayViewGroup != null) {
            mapOverlayViewGroup.detachFromMapFlowView();
            this.f14506c.setTag(R.id.id_mapflow_overlayviewgroup, (Object) null);
        }
    }
}
