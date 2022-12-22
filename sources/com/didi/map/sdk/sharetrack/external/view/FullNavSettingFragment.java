package com.didi.map.sdk.sharetrack.external.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.didi.map.sdk.sharetrack.logger.DLog;
import com.didi.map.setting.common.MapSettingFactory;
import com.didi.map.setting.common.MapSettingNavInfo;
import com.didi.map.setting.global.MapSettingWindowView;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.nightmode.sdk.NightModeManager;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class FullNavSettingFragment extends DialogFragment {

    /* renamed from: a */
    private TextView f28700a;

    /* renamed from: b */
    private TextView f28701b;

    /* renamed from: c */
    private TextView f28702c;

    /* renamed from: d */
    private TextView f28703d;

    /* renamed from: e */
    private ImageView f28704e;

    /* renamed from: f */
    private RelativeLayout f28705f;

    /* renamed from: g */
    private RelativeLayout f28706g;

    /* renamed from: h */
    private boolean f28707h = false;

    /* renamed from: i */
    private int f28708i = 0;

    /* renamed from: j */
    private boolean f28709j = false;

    /* renamed from: k */
    private IFullNavSettingListener f28710k;

    /* renamed from: l */
    private MapSettingNavInfo f28711l;

    /* renamed from: m */
    private MapSettingWindowView f28712m;

    /* renamed from: n */
    private ViewGroup f28713n;

    public void showSafely(FragmentManager fragmentManager, String str) {
        if (fragmentManager == null) {
            try {
                m20235a("manager is null");
            } catch (Exception e) {
                m20235a(e.getMessage());
            }
        } else if (isAdded()) {
            m20235a("added");
        } else if (fragmentManager.findFragmentByTag(str) != null) {
            m20235a("has tag");
        } else {
            showNow(fragmentManager, str);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f28709j = arguments.getBoolean("is_in_night_mode", false);
        }
        if (getContext() != null) {
            this.f28707h = MapSettingFactory.createMapPreferences(getContext().getApplicationContext()).getInAppNavVoiceOpen();
            this.f28708i = MapSettingFactory.createMapPreferences(getContext().getApplicationContext()).getNavDayNightMode();
            DLog.m20357d("GoogleFull", "init voice enable: " + this.f28707h + " map color: " + this.f28708i, new Object[0]);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (getActivity() == null) {
            return null;
        }
        Dialog dialog = new Dialog(getActivity(), R.style.BottomFragmentDialog);
        dialog.requestWindowFeature(1);
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.maprouter_full_nav_setting_layout_v2, (ViewGroup) null);
        m20234a(inflate);
        m20233a();
        dialog.setContentView(inflate);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        Window window = dialog.getWindow();
        if (window == null) {
            return dialog;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setAttributes(attributes);
        return dialog;
    }

    /* renamed from: a */
    private void m20234a(View view) {
        this.f28705f = (RelativeLayout) view.findViewById(R.id.maprouter_nav_full_voice_container);
        this.f28706g = (RelativeLayout) view.findViewById(R.id.maprouter_nav_full_setting_others);
        this.f28704e = (ImageView) view.findViewById(R.id.maprouter_nav_full_voice);
        this.f28700a = (TextView) view.findViewById(R.id.maprouter_nav_full_setting_color_auto);
        this.f28701b = (TextView) view.findViewById(R.id.maprouter_nav_full_setting_color_day);
        this.f28702c = (TextView) view.findViewById(R.id.maprouter_nav_full_setting_color_night);
        this.f28703d = (TextView) view.findViewById(R.id.maprouter_nav_full_setting_confirm);
        this.f28704e.setImageResource(this.f28707h ? R.drawable.maprouter_full_nav_voice_open : R.drawable.maprouter_full_nav_voice_close);
        if (Apollo.getToggle("global_driver_android_nav_mute").allow()) {
            this.f28705f.setVisibility(0);
        }
        m20236b();
    }

    /* renamed from: a */
    private void m20233a() {
        this.f28705f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullNavSettingFragment.this.m20242g(view);
            }
        });
        this.f28700a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullNavSettingFragment.this.m20241f(view);
            }
        });
        this.f28701b.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullNavSettingFragment.this.m20240e(view);
            }
        });
        this.f28702c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullNavSettingFragment.this.m20239d(view);
            }
        });
        this.f28706g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullNavSettingFragment.this.m20238c(view);
            }
        });
        this.f28703d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FullNavSettingFragment.this.m20237b(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public /* synthetic */ void m20242g(View view) {
        boolean z = !this.f28707h;
        this.f28707h = z;
        this.f28704e.setImageResource(z ? R.drawable.maprouter_full_nav_voice_open : R.drawable.maprouter_full_nav_voice_close);
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public /* synthetic */ void m20241f(View view) {
        this.f28708i = 0;
        m20236b();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m20240e(View view) {
        this.f28708i = 1;
        m20236b();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m20239d(View view) {
        this.f28708i = 2;
        m20236b();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m20238c(View view) {
        if (this.f28711l != null && getContext() != null) {
            MapSettingWindowView mapSettingWindowView = this.f28712m;
            if (mapSettingWindowView == null) {
                this.f28712m = (MapSettingWindowView) MapSettingFactory.createMapDelegate(getContext()).getSelectNavView(this.f28713n, this.f28711l);
            } else {
                mapSettingWindowView.setNavInfo(this.f28711l);
            }
            this.f28712m.show(true, false);
            dismissAllowingStateLoss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m20237b(View view) {
        if (getContext() != null) {
            MapSettingFactory.createMapPreferences(getContext().getApplicationContext()).setInAppNavVoiceOpen(this.f28707h);
            MapSettingFactory.createMapPreferences(getContext().getApplicationContext()).setNavDayNightMode(this.f28708i);
            IFullNavSettingListener iFullNavSettingListener = this.f28710k;
            if (iFullNavSettingListener != null) {
                iFullNavSettingListener.onVoiceStatusChanged(this.f28707h);
                this.f28710k.onMapColorSchemeChanged(this.f28708i);
            }
            if (this.f28708i != 0) {
                NightModeManager.getInstance(getContext().getApplicationContext()).onOrderStageChanged(this.f28708i == 2);
            }
        }
        dismissAllowingStateLoss();
    }

    /* renamed from: b */
    private void m20236b() {
        int i = this.f28708i;
        if (i == 0) {
            this.f28700a.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_active);
            this.f28701b.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_disable);
            this.f28702c.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_disable);
            this.f28700a.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_active_100));
            this.f28701b.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_disable_text));
            this.f28702c.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_disable_text));
            this.f28700a.setTypeface(Typeface.defaultFromStyle(1));
            this.f28701b.setTypeface(Typeface.defaultFromStyle(0));
            this.f28702c.setTypeface(Typeface.defaultFromStyle(0));
        } else if (i == 1) {
            this.f28700a.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_disable);
            this.f28701b.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_active);
            this.f28702c.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_disable);
            this.f28700a.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_disable_text));
            this.f28701b.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_active_100));
            this.f28702c.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_disable_text));
            this.f28700a.setTypeface(Typeface.defaultFromStyle(0));
            this.f28701b.setTypeface(Typeface.defaultFromStyle(1));
            this.f28702c.setTypeface(Typeface.defaultFromStyle(0));
        } else if (i == 2) {
            this.f28700a.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_disable);
            this.f28701b.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_disable);
            this.f28702c.setBackgroundResource(R.drawable.maprouter_nav_full_setting_color_active);
            this.f28700a.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_disable_text));
            this.f28701b.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_disable_text));
            this.f28702c.setTextColor(getResources().getColor(R.color.map_router_nav_full_setting_scheme_active_100));
            this.f28700a.setTypeface(Typeface.defaultFromStyle(0));
            this.f28701b.setTypeface(Typeface.defaultFromStyle(0));
            this.f28702c.setTypeface(Typeface.defaultFromStyle(1));
        }
    }

    public void setOnSettingListener(IFullNavSettingListener iFullNavSettingListener) {
        this.f28710k = iFullNavSettingListener;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    public void setNavInfo(MapSettingNavInfo mapSettingNavInfo) {
        this.f28711l = mapSettingNavInfo;
    }

    public void setContainerView(ViewGroup viewGroup) {
        this.f28713n = viewGroup;
    }

    /* renamed from: a */
    private void m20235a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("reason", str);
        OmegaSDKAdapter.trackEvent("map_inner_nav_setting_exc_ck", (Map<String, Object>) hashMap);
    }
}
