package com.didi.map.sdk.sharetrack.external.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.common.map.MapVendor;
import com.didi.map.sdk.nav.car.CameraMode;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didi.sdk.util.WindowUtil;
import com.didichuxing.nightmode.sdk.INightModeChangeCallback;
import com.didichuxing.nightmode.sdk.NightModeManager;
import com.didichuxing.nightmode.sdk.NightModeState;
import com.global.didi.elvish.DateStyle;
import com.global.didi.elvish.DistanceStyle;
import com.global.didi.elvish.Elvish;
import com.global.didi.elvish.TimeStyle;
import com.taxis99.R;

public class FullScreenNavSkinView extends RelativeLayout implements INavSkin, INightModeChangeCallback {

    /* renamed from: a */
    private static final long f28714a = 30000;

    /* renamed from: b */
    private TextView f28715b;

    /* renamed from: c */
    private TextView f28716c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f28717d;

    /* renamed from: e */
    private ImageView f28718e;

    /* renamed from: f */
    private ImageView f28719f;

    /* renamed from: g */
    private ImageView f28720g;

    /* renamed from: h */
    private ImageView f28721h;

    /* renamed from: i */
    private RelativeLayout f28722i;

    /* renamed from: j */
    private FrameLayout f28723j;

    /* renamed from: k */
    private FrameLayout f28724k;

    /* renamed from: l */
    private View f28725l;

    /* renamed from: m */
    private boolean f28726m;

    /* renamed from: n */
    private int f28727n;

    /* renamed from: o */
    private CameraMode f28728o;

    /* renamed from: p */
    private MapVendor f28729p;

    /* renamed from: q */
    private RelativeLayout f28730q;

    /* renamed from: r */
    private RelativeLayout f28731r;

    /* renamed from: s */
    private View f28732s;

    /* renamed from: t */
    private OnSkinInteractionListener f28733t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public int f28734u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public Handler f28735v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public Runnable f28736w;

    public void setOrderId(String str) {
    }

    public FullScreenNavSkinView(Context context) {
        this(context, (AttributeSet) null);
    }

    public FullScreenNavSkinView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FullScreenNavSkinView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f28727n = -1;
        this.f28728o = CameraMode.CAR_HEAD_UP;
        this.f28736w = new Runnable() {
            public void run() {
                if (FullScreenNavSkinView.this.f28734u > 0 && FullScreenNavSkinView.this.f28717d != null) {
                    FullScreenNavSkinView.this.m20249b();
                }
                if (FullScreenNavSkinView.this.f28735v != null) {
                    FullScreenNavSkinView.this.f28735v.removeCallbacks(FullScreenNavSkinView.this.f28736w);
                    FullScreenNavSkinView.this.f28735v.postDelayed(FullScreenNavSkinView.this.f28736w, 30000);
                }
            }
        };
        m20247a((MapVendor) null, (View) null, (View) null);
    }

    public FullScreenNavSkinView(Context context, MapVendor mapVendor, View view, View view2) {
        super(context);
        this.f28727n = -1;
        this.f28728o = CameraMode.CAR_HEAD_UP;
        this.f28736w = new Runnable() {
            public void run() {
                if (FullScreenNavSkinView.this.f28734u > 0 && FullScreenNavSkinView.this.f28717d != null) {
                    FullScreenNavSkinView.this.m20249b();
                }
                if (FullScreenNavSkinView.this.f28735v != null) {
                    FullScreenNavSkinView.this.f28735v.removeCallbacks(FullScreenNavSkinView.this.f28736w);
                    FullScreenNavSkinView.this.f28735v.postDelayed(FullScreenNavSkinView.this.f28736w, 30000);
                }
            }
        };
        m20247a(mapVendor, view, view2);
    }

    /* renamed from: a */
    private void m20247a(MapVendor mapVendor, View view, View view2) {
        if (getContext() != null) {
            this.f28729p = mapVendor;
            if (mapVendor == null || MapVendor.DIDI != mapVendor) {
                this.f28732s = LayoutInflater.from(getContext()).inflate(R.layout.maprouter_full_nav_skin_v2, this);
            } else {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.maprouter_full_nav_skin_v2, (ViewGroup) null);
                this.f28732s = inflate;
                RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.maprouter_fullnav_navcard_layout);
                this.f28730q = relativeLayout;
                if (view != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                    layoutParams.topMargin += WindowUtil.getStatusBarHeight(getContext());
                    this.f28730q.setLayoutParams(layoutParams);
                    this.f28730q.addView(view, new ViewGroup.LayoutParams(-2, -2));
                    this.f28730q.setVisibility(0);
                }
                this.f28731r = (RelativeLayout) this.f28732s.findViewById(R.id.maprouter_fullnav_limit_speed_layout);
                if (view2 != null) {
                    this.f28731r.addView(view2, new ViewGroup.LayoutParams(-2, -2));
                    this.f28731r.setVisibility(0);
                }
            }
            this.f28715b = (TextView) this.f28732s.findViewById(R.id.maprouter_tv_nav_full_eta_v2);
            this.f28716c = (TextView) this.f28732s.findViewById(R.id.maprouter_tv_nav_full_eda_v2);
            this.f28717d = (TextView) this.f28732s.findViewById(R.id.maprouter_tv_nav_full_arrive_t_v2);
            this.f28718e = (ImageView) this.f28732s.findViewById(R.id.maprouter_iv_nav_full_close_v2);
            this.f28719f = (ImageView) this.f28732s.findViewById(R.id.maprouter_iv_nav_full_setting_v2);
            this.f28724k = (FrameLayout) this.f28732s.findViewById(R.id.maprouter_fl_nav_full_safe_v2);
            this.f28720g = (ImageView) this.f28732s.findViewById(R.id.maprouter_iv_nav_full_zoom_back_v2);
            this.f28723j = (FrameLayout) this.f28732s.findViewById(R.id.maprouter_fl_nav_full_tel_v2);
            this.f28721h = (ImageView) this.f28732s.findViewById(R.id.maprouter_iv_nav_full_camera_mode_v2);
            this.f28722i = (RelativeLayout) this.f28732s.findViewById(R.id.maprouter_rl_nav_full_bottom_bar_v2);
            this.f28725l = this.f28732s.findViewById(R.id.maprouter_v_nav_full_center_dot_v2);
            m20244a();
            this.f28735v = new Handler(Looper.getMainLooper());
        }
    }

    /* renamed from: a */
    private void m20244a() {
        this.f28718e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullScreenNavSkinView.this.m20261g(view);
            }
        });
        this.f28719f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullScreenNavSkinView.this.m20260f(view);
            }
        });
        this.f28724k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullScreenNavSkinView.this.m20259e(view);
            }
        });
        this.f28720g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullScreenNavSkinView.this.m20256d(view);
            }
        });
        this.f28723j.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullScreenNavSkinView.this.m20252c(view);
            }
        });
        this.f28721h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullScreenNavSkinView.this.m20250b(view);
            }
        });
        if (this.f28722i.getViewTreeObserver() != null) {
            this.f28722i.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public final void onGlobalLayout() {
                    FullScreenNavSkinView.this.m20258e();
                }
            });
        }
        NightModeManager.getInstance(getContext().getApplicationContext()).addNightModeChangeListener(this, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m20261g(View view) {
        OnSkinInteractionListener onSkinInteractionListener = this.f28733t;
        if (onSkinInteractionListener != null) {
            onSkinInteractionListener.onCloseClicked();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m20260f(View view) {
        OnSkinInteractionListener onSkinInteractionListener = this.f28733t;
        if (onSkinInteractionListener != null) {
            onSkinInteractionListener.onSettingToolClicked();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m20259e(View view) {
        OnSkinInteractionListener onSkinInteractionListener = this.f28733t;
        if (onSkinInteractionListener != null) {
            onSkinInteractionListener.onSafeToolClicked(view);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m20256d(View view) {
        this.f28720g.setVisibility(8);
        OnSkinInteractionListener onSkinInteractionListener = this.f28733t;
        if (onSkinInteractionListener != null) {
            onSkinInteractionListener.onZoomBackClicked(this.f28728o);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m20252c(View view) {
        OnSkinInteractionListener onSkinInteractionListener = this.f28733t;
        if (onSkinInteractionListener != null) {
            onSkinInteractionListener.onTelClicked(view);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m20250b(View view) {
        if (this.f28728o == CameraMode.CAR_HEAD_UP) {
            this.f28728o = CameraMode.NORTH_UP;
        } else {
            this.f28728o = CameraMode.CAR_HEAD_UP;
        }
        m20255d();
        OnSkinInteractionListener onSkinInteractionListener = this.f28733t;
        if (onSkinInteractionListener != null) {
            onSkinInteractionListener.onSwitchCameraModeClicked(this.f28728o);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m20258e() {
        int bottom = this.f28722i.getBottom() - this.f28722i.getTop();
        RelativeLayout relativeLayout = this.f28730q;
        int bottom2 = (relativeLayout == null || relativeLayout.getVisibility() != 0) ? 0 : this.f28730q.getBottom();
        FrameLayout frameLayout = this.f28724k;
        if (frameLayout != null && frameLayout.getVisibility() == 0 && this.f28724k.getTop() > 0) {
            int height = this.f28724k.getHeight();
            int width = this.f28724k.getWidth();
            if (this.f28729p == null || MapVendor.DIDI != this.f28729p || height < width) {
                bottom = this.f28722i.getBottom() - this.f28724k.getTop();
            } else {
                DLog.m20357d("FullScreenNavSkinView", "hawaii do not need mSafeContainer padding", new Object[0]);
            }
        }
        if (bottom < 0) {
            bottom = 300;
        }
        if (this.f28727n != bottom) {
            this.f28727n = bottom;
            OnSkinInteractionListener onSkinInteractionListener = this.f28733t;
            if (onSkinInteractionListener != null) {
                onSkinInteractionListener.onMapPaddingCalculateComplete(0, bottom2, 0, bottom);
            }
        }
    }

    public void updateEtaEda(int i, int i2) {
        String str;
        if (getContext() != null && getContext().getResources() != null) {
            if (i <= 0) {
                i = 1;
            }
            String formatCountdownTime = Elvish.Companion.getInstance().formatCountdownTime(i * 60, false);
            TextView textView = this.f28715b;
            if (textView != null) {
                textView.setText(formatCountdownTime);
            }
            if (i2 < 100) {
                i2 = 100;
            }
            if (i2 < 1000) {
                str = Elvish.Companion.getInstance().formatDistance((double) i2, DistanceStyle.M, 0, false);
            } else {
                str = Elvish.Companion.getInstance().formatDistance((double) i2, DistanceStyle.KM, 1, false);
            }
            TextView textView2 = this.f28716c;
            if (textView2 != null) {
                textView2.setText(str);
            }
            this.f28734u = i;
            m20249b();
            Handler handler = this.f28735v;
            if (handler != null) {
                handler.removeCallbacks(this.f28736w);
                this.f28735v.postDelayed(this.f28736w, 30000);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m20249b() {
        String formatDateTime = Elvish.Companion.getInstance().formatDateTime((System.currentTimeMillis() / 1000) + ((long) (this.f28734u * 60)), DateStyle.NONE, TimeStyle.TIME_HH_MM, true);
        TextView textView = this.f28717d;
        if (textView != null) {
            textView.setText(formatDateTime);
        }
    }

    /* renamed from: a */
    private void m20245a(int i) {
        Handler handler = this.f28735v;
        if (handler != null) {
            handler.removeCallbacks(this.f28736w);
        }
        if (i == 0) {
            if (this.f28734u > 0 && this.f28717d != null) {
                m20249b();
            }
            Handler handler2 = this.f28735v;
            if (handler2 != null) {
                handler2.postDelayed(this.f28736w, 30000);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        m20245a(i);
    }

    public void changeNightMode(boolean z) {
        this.f28726m = z;
        m20251c();
    }

    public void updateZoomBackVisibility(boolean z) {
        ImageView imageView = this.f28720g;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    public void updateCameraMode(CameraMode cameraMode) {
        this.f28728o = cameraMode;
        m20255d();
    }

    public void setTelephoneView(View view) {
        if (view != null && this.f28723j != null) {
            m20246a(view);
            this.f28723j.removeAllViews();
            this.f28723j.addView(view);
            this.f28723j.setVisibility(0);
        }
    }

    public void setSafeToolView(View view) {
        if (view != null && this.f28724k != null) {
            m20246a(view);
            this.f28724k.removeAllViews();
            this.f28724k.addView(view);
            this.f28724k.setVisibility(0);
        }
    }

    public void destroy() {
        FrameLayout frameLayout = this.f28724k;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.f28724k = null;
        }
        FrameLayout frameLayout2 = this.f28723j;
        if (frameLayout2 != null) {
            frameLayout2.removeAllViews();
            this.f28723j = null;
        }
        Handler handler = this.f28735v;
        if (handler != null) {
            handler.removeCallbacks(this.f28736w);
        }
        this.f28733t = null;
        NightModeManager.getInstance(getContext().getApplicationContext()).removeNightModeChangeListener(this);
    }

    public void setOnSkinInteractionListener(OnSkinInteractionListener onSkinInteractionListener) {
        this.f28733t = onSkinInteractionListener;
    }

    /* renamed from: c */
    private void m20251c() {
        if (this.f28726m) {
            this.f28720g.setBackgroundResource(R.drawable.maprouter_selector_nav_full_zoom_back_night);
            this.f28718e.setImageResource(R.drawable.maprouter_nav_full_close_night);
            this.f28719f.setImageResource(R.drawable.maprouter_nav_full_setting_night);
            this.f28722i.setBackgroundResource(R.drawable.maprouter_nav_full_bootom_bar_night);
            this.f28725l.setBackgroundResource(R.drawable.maprouter_nav_full_dot_night);
            if (getResources() != null) {
                this.f28715b.setTextColor(ContextCompat.getColor(getContext(), R.color.map_router_nav_full_de_white));
                this.f28716c.setTextColor(ContextCompat.getColor(getContext(), R.color.map_router_nav_full_de_white));
                this.f28717d.setTextColor(ContextCompat.getColor(getContext(), R.color.map_router_nav_full_white));
            }
        } else {
            this.f28720g.setBackgroundResource(R.drawable.maprouter_selector_nav_full_zoom_back_day);
            this.f28718e.setImageResource(R.drawable.maprouter_nav_full_close);
            this.f28719f.setImageResource(R.drawable.maprouter_nav_full_setting);
            this.f28722i.setBackgroundResource(R.drawable.maprouter_nav_full_bootom_bar_day);
            this.f28725l.setBackgroundResource(R.drawable.maprouter_nav_full_dot_day);
            if (getResources() != null) {
                this.f28715b.setTextColor(ContextCompat.getColor(getContext(), R.color.map_router_nav_full_setting_scheme_disable_text));
                this.f28716c.setTextColor(ContextCompat.getColor(getContext(), R.color.map_router_nav_full_setting_scheme_disable_text));
                this.f28717d.setTextColor(ContextCompat.getColor(getContext(), R.color.map_router_nav_full_normal_text_day));
            }
        }
        m20255d();
    }

    /* renamed from: d */
    private void m20255d() {
        if (this.f28728o == CameraMode.CAR_HEAD_UP) {
            if (this.f28726m) {
                this.f28721h.setBackgroundResource(R.drawable.maprouter_selector_nav_full_overview_night);
            } else {
                this.f28721h.setBackgroundResource(R.drawable.maprouter_selector_nav_full_overview_day);
            }
        } else if (this.f28728o != CameraMode.NORTH_UP) {
        } else {
            if (this.f28726m) {
                this.f28721h.setBackgroundResource(R.drawable.maprouter_selector_nav_full_car_up_night);
            } else {
                this.f28721h.setBackgroundResource(R.drawable.maprouter_selector_nav_full_car_up_day);
            }
        }
    }

    public View getSkinRootView() {
        return this.f28732s;
    }

    public void setSkinVisibility(int i) {
        View view = this.f28732s;
        if (view != null) {
            view.setVisibility(i);
            m20245a(i);
        }
    }

    public boolean isVisible() {
        View view = this.f28732s;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public CameraMode getCameraMode() {
        return this.f28728o;
    }

    public void onNightModeStateChange(NightModeState nightModeState) {
        this.f28726m = nightModeState == NightModeState.NIGHT;
        m20251c();
    }

    /* renamed from: a */
    private void m20246a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
    }
}
