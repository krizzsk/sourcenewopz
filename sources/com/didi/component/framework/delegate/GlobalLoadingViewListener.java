package com.didi.component.framework.delegate;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.net.CarRequest;
import com.didi.component.common.util.GLog;
import com.didi.component.common.view.RegisterProgressView;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.ActivityResInfo;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.utils.ApolloSwitch;
import com.taxis99.R;
import java.util.Map;

public class GlobalLoadingViewListener implements LoginListeners.LoadingViewListener {

    /* renamed from: e */
    private static final String f13749e = "new";

    /* renamed from: f */
    private static final String f13750f = "old";

    /* renamed from: g */
    private static final int f13751g = 0;

    /* renamed from: h */
    private static final int f13752h = 1;

    /* renamed from: i */
    private static final int f13753i = 0;

    /* renamed from: j */
    private static final int f13754j = 2;

    /* renamed from: k */
    private static final int f13755k = 14;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f13756a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f13757b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RegisterProgressView f13758c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f13759d;

    public void onCreate(Map<String, Object> map, LinearLayout linearLayout) {
        if (map != null && !map.isEmpty() && linearLayout != null) {
            String str = (String) map.get("user_type");
            int intValue = ((Integer) map.get("scene")).intValue();
            int intValue2 = ((Integer) map.get("page")).intValue();
            GLog.m7968e("lxs", "userType = " + str + "-->scene = " + intValue + "-->page = " + intValue2);
            if (!this.f13756a && intValue == 0 && intValue2 == 2) {
                if (ApolloSwitch.getInstance().passportSdkUpdate()) {
                    CarRequest.getActivityRes(linearLayout.getContext(), CarRequest.RESOURCE_NAME_G_PAS_SIGN_UP_BANNER, new ResponseListener<ActivityResInfo>() {
                        public void onSuccess(ActivityResInfo activityResInfo) {
                            if (!TextUtils.isEmpty(activityResInfo.json)) {
                                boolean unused = GlobalLoadingViewListener.this.f13756a = true;
                                ListenerManager.getPreLoginListener().callback(activityResInfo.json);
                            }
                        }
                    });
                } else {
                    final LinearLayout linearLayout2 = linearLayout;
                    final String str2 = str;
                    final int i = intValue;
                    final int i2 = intValue2;
                    CarRequest.getActivityRes(linearLayout.getContext(), CarRequest.RESOURCE_NAME_PAS_REGISTERPAGE_TIP, new ResponseListener<ActivityResInfo>() {
                        public void onSuccess(ActivityResInfo activityResInfo) {
                            super.onSuccess(activityResInfo);
                            GLog.m7968e("lxs", activityResInfo.activityId + "");
                            if (activityResInfo.activityId > 0) {
                                GlobalOmegaUtils.trackEvent("pas_login_progress_sw");
                                View inflate = LayoutInflater.from(linearLayout2.getContext()).inflate(R.layout.global_register_coupon_progress, linearLayout2);
                                RegisterProgressView unused = GlobalLoadingViewListener.this.f13758c = (RegisterProgressView) inflate.findViewById(R.id.g_register_progress_view);
                                TextView unused2 = GlobalLoadingViewListener.this.f13759d = (TextView) inflate.findViewById(R.id.g_register_coupon_tip);
                                linearLayout2.setOrientation(0);
                                boolean unused3 = GlobalLoadingViewListener.this.f13756a = true;
                                boolean unused4 = GlobalLoadingViewListener.this.f13757b = true;
                                GlobalLoadingViewListener.this.m9546a(str2, i, i2);
                            }
                        }
                    });
                }
            }
            if (this.f13757b) {
                m9546a(str, intValue, intValue2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9546a(String str, int i, int i2) {
        RegisterProgressView registerProgressView = this.f13758c;
        if (registerProgressView != null && this.f13759d != null) {
            registerProgressView.setVisibility(0);
            this.f13759d.setVisibility(0);
            if ("old".equals(str) && i2 != 2) {
                this.f13758c.setVisibility(8);
                this.f13759d.setVisibility(8);
            } else if ("new".equals(str) && i == 1) {
                if (i2 == 0) {
                    this.f13758c.setStepByAnimator(1);
                } else if (i2 == 14) {
                    this.f13758c.setStepByAnimator(2);
                } else if (i2 == 2) {
                    this.f13758c.setStepByAnimator(0);
                }
            }
        }
    }

    public void destroy() {
        this.f13756a = false;
        this.f13757b = false;
        this.f13758c = null;
        this.f13759d = null;
    }
}
