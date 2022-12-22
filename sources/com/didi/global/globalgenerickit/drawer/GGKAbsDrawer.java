package com.didi.global.globalgenerickit.drawer;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.didi.global.loading.Loading;
import com.didi.global.loading.LoadingConfig;
import com.taxis99.R;

public abstract class GGKAbsDrawer {

    /* renamed from: a */
    private PopupWindow f22132a;

    /* renamed from: b */
    private LinearLayout f22133b;

    /* renamed from: c */
    private boolean f22134c;

    /* renamed from: d */
    private boolean f22135d;

    /* renamed from: e */
    private boolean f22136e;

    /* renamed from: f */
    private View f22137f;

    /* renamed from: g */
    private RelativeLayout f22138g;

    /* renamed from: h */
    private boolean f22139h = false;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public GGKOnAntiShakeClickListener f22140i;
    protected Context mContext;

    /* access modifiers changed from: protected */
    public abstract int getCustomView();

    /* access modifiers changed from: protected */
    public abstract boolean onShowPrepare();

    public GGKAbsDrawer(Context context) {
        this.mContext = context;
    }

    public void show() {
        Context context = this.mContext;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null && !activity.isFinishing() && !this.f22134c) {
            m16018a();
            if (onShowPrepare()) {
                View findViewById = findViewById(R.id.g_bottom_pop_bg);
                if (this.f22135d) {
                    findViewById.setOnClickListener(new GGKOnAntiShakeClickListener() {
                        public void onAntiShakeClick(View view) {
                            try {
                                if (GGKAbsDrawer.this.f22140i != null) {
                                    GGKAbsDrawer.this.f22140i.onClick(view);
                                }
                            } catch (Exception unused) {
                            }
                            GGKAbsDrawer.this.dismiss();
                        }
                    });
                }
                GGKPopupWindow gGKPopupWindow = new GGKPopupWindow(this.f22133b, -1, -1, this.f22137f, this.mContext);
                this.f22132a = gGKPopupWindow;
                gGKPopupWindow.setSoftInputMode(16);
                if (isBackPressedEnabled()) {
                    setFocusable(true);
                }
                View view = this.f22137f;
                if (view != null) {
                    view.setAnimation(AnimationUtils.loadAnimation(this.mContext, R.anim.ggk_drawer_bottom_in));
                }
                this.f22132a.setClippingEnabled(false);
                this.f22132a.setBackgroundDrawable(new ColorDrawable(0));
                try {
                    this.f22132a.showAtLocation(activity.getWindow().getDecorView(), 81, 0, 0);
                    if (UiUtils.isNavigationBarExist(activity)) {
                        ViewGroup.LayoutParams layoutParams = this.f22137f.getLayoutParams();
                        if (layoutParams instanceof LinearLayout.LayoutParams) {
                            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f22137f.getLayoutParams();
                            layoutParams2.bottomMargin = UiUtils.getNavigationBarHeight(activity);
                            this.f22137f.setLayoutParams(layoutParams2);
                        } else if (layoutParams instanceof RelativeLayout.LayoutParams) {
                            ((RelativeLayout.LayoutParams) this.f22137f.getLayoutParams()).bottomMargin = UiUtils.getNavigationBarHeight(activity);
                            this.f22137f.setLayoutParams(layoutParams);
                        }
                    }
                    this.f22134c = true;
                    if (GGKDrawerManager.showingDrawer == null) {
                        GGKDrawerManager.showingDrawer = this;
                    } else {
                        GGKDrawerManager.showingDrawer.dismiss();
                        GGKDrawerManager.showingDrawer = this;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f22132a.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    public void onDismiss() {
                        GGKDrawerManager.showingDrawer = null;
                    }
                });
            }
        }
    }

    public void setTouchable(boolean z) {
        PopupWindow popupWindow = this.f22132a;
        if (popupWindow != null) {
            popupWindow.setTouchable(z);
        }
    }

    public void setFocusable(boolean z) {
        PopupWindow popupWindow = this.f22132a;
        if (popupWindow != null) {
            popupWindow.setFocusable(z);
        }
    }

    public void setCanceledOnTouchOutside(boolean z) {
        this.f22135d = z;
    }

    public void setOutClickListener(GGKOnAntiShakeClickListener gGKOnAntiShakeClickListener) {
        this.f22140i = gGKOnAntiShakeClickListener;
    }

    /* renamed from: a */
    private void m16018a() {
        this.f22133b = (LinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.ggk_drawer_layout, (ViewGroup) null);
        if (getCustomView() != 0) {
            this.f22137f = LayoutInflater.from(this.mContext).inflate(getCustomView(), (ViewGroup) null);
        }
        View view = this.f22137f;
        if (view == null) {
            return;
        }
        if (this.f22139h) {
            this.f22138g = new RelativeLayout(this.mContext);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(14);
            this.f22138g.addView(this.f22137f, layoutParams);
            this.f22133b.addView(this.f22138g);
            return;
        }
        this.f22133b.addView(view);
    }

    /* access modifiers changed from: protected */
    public <T extends View> T findViewById(int i) {
        LinearLayout linearLayout = this.f22133b;
        if (linearLayout == null) {
            return null;
        }
        return linearLayout.findViewById(i);
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.f22132a;
        if (popupWindow != null && this.f22134c && popupWindow.isShowing()) {
            return true;
        }
        return false;
    }

    public void dismiss() {
        this.f22134c = false;
        PopupWindow popupWindow = this.f22132a;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public void setLoadingEnable(boolean z) {
        this.f22139h = z;
    }

    public void showLoading() {
        if (this.mContext != null && this.f22139h && this.f22137f != null) {
            Loading.make(this.mContext, this.f22137f, LoadingConfig.create().setLoadingGravity(48).build()).show();
        }
    }

    public void hideLoading() {
        View view;
        if (this.f22139h && (view = this.f22137f) != null) {
            Loading.hide(view);
        }
    }

    public boolean isBackPressedEnabled() {
        return this.f22136e;
    }

    public void setBackPressedEnabled(boolean z) {
        this.f22136e = z;
    }
}
