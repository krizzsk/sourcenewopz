package com.didi.component.adalert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentManager;
import com.didi.component.adalert.AdAlertModel;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.view.BaseDialogFragment;
import com.didichuxing.publicservice.resourcecontrol.utils.DensityUtil;
import com.taxis99.R;

public class HomeAdAlertDialog extends BaseDialogFragment {

    /* renamed from: a */
    private ViewGroup f10973a;

    /* renamed from: b */
    private ImageView f10974b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Builder f10975c;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 2132017496);
        setCancelable(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.global_dialog_home_ad_alert, viewGroup, false);
        m7420a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m7420a(View view) {
        this.f10973a = (ViewGroup) view.findViewById(R.id.global_adalert_container);
        this.f10974b = (ImageView) view.findViewById(R.id.global_image_close);
        this.f10973a.getLayoutParams().width = DensityUtil.dip2px(getContext(), 280.0f);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Builder builder = this.f10975c;
        if (!(builder == null || builder.adView == null)) {
            this.f10973a.removeAllViews();
            this.f10973a.addView(this.f10975c.adView);
        }
        this.f10974b.setOnClickListener(new View.OnClickListener() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v22, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v12, resolved type: java.util.Map} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onClick(android.view.View r4) {
                /*
                    r3 = this;
                    com.didi.autotracker.AutoTrackHelper.trackViewOnClick(r4)
                    com.didi.component.adalert.HomeAdAlertDialog r4 = com.didi.component.adalert.HomeAdAlertDialog.this
                    com.didi.component.adalert.HomeAdAlertDialog$Builder r4 = r4.f10975c
                    if (r4 == 0) goto L_0x0060
                    com.didi.component.adalert.HomeAdAlertDialog r4 = com.didi.component.adalert.HomeAdAlertDialog.this
                    com.didi.component.adalert.HomeAdAlertDialog$Builder r4 = r4.f10975c
                    com.didi.component.adalert.AdAlertModel$AdAlertData r4 = r4.data
                    if (r4 == 0) goto L_0x0060
                    com.didi.component.adalert.HomeAdAlertDialog r4 = com.didi.component.adalert.HomeAdAlertDialog.this
                    com.didi.component.adalert.HomeAdAlertDialog$Builder r4 = r4.f10975c
                    com.didi.component.adalert.AdAlertModel$AdAlertData r4 = r4.data
                    org.json.JSONObject r4 = r4.mLogData
                    if (r4 == 0) goto L_0x0060
                    com.google.gson.JsonParser r4 = new com.google.gson.JsonParser     // Catch:{ Exception -> 0x005c }
                    r4.<init>()     // Catch:{ Exception -> 0x005c }
                    com.didi.component.adalert.HomeAdAlertDialog r0 = com.didi.component.adalert.HomeAdAlertDialog.this     // Catch:{ Exception -> 0x005c }
                    com.didi.component.adalert.HomeAdAlertDialog$Builder r0 = r0.f10975c     // Catch:{ Exception -> 0x005c }
                    com.didi.component.adalert.AdAlertModel$AdAlertData r0 = r0.data     // Catch:{ Exception -> 0x005c }
                    org.json.JSONObject r0 = r0.mLogData     // Catch:{ Exception -> 0x005c }
                    java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x005c }
                    com.google.gson.JsonElement r4 = r4.parse((java.lang.String) r0)     // Catch:{ Exception -> 0x005c }
                    com.google.gson.JsonObject r4 = (com.google.gson.JsonObject) r4     // Catch:{ Exception -> 0x005c }
                    java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x005c }
                    r0.<init>()     // Catch:{ Exception -> 0x005c }
                    if (r4 == 0) goto L_0x0056
                    com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x005c }
                    r0.<init>()     // Catch:{ Exception -> 0x005c }
                    com.didi.component.adalert.HomeAdAlertDialog$1$1 r1 = new com.didi.component.adalert.HomeAdAlertDialog$1$1     // Catch:{ Exception -> 0x005c }
                    r1.<init>()     // Catch:{ Exception -> 0x005c }
                    java.lang.reflect.Type r1 = r1.getType()     // Catch:{ Exception -> 0x005c }
                    java.lang.Object r4 = r0.fromJson((com.google.gson.JsonElement) r4, (java.lang.reflect.Type) r1)     // Catch:{ Exception -> 0x005c }
                    r0 = r4
                    java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x005c }
                L_0x0056:
                    java.lang.String r4 = "ibt_gp_ad_popup_close_ck"
                    com.didiglobal.omegasdkadapter.OmegaSDKAdapter.trackEvent((java.lang.String) r4, (java.util.Map<java.lang.String, java.lang.Object>) r0)     // Catch:{ Exception -> 0x005c }
                    goto L_0x0060
                L_0x005c:
                    r4 = move-exception
                    r4.printStackTrace()
                L_0x0060:
                    com.didi.component.adalert.HomeAdAlertDialog r4 = com.didi.component.adalert.HomeAdAlertDialog.this
                    r4.dismiss()
                    com.didi.component.adalert.HomeAdAlertDialog r4 = com.didi.component.adalert.HomeAdAlertDialog.this
                    com.didi.component.adalert.HomeAdAlertDialog$Builder r4 = r4.f10975c
                    if (r4 == 0) goto L_0x0094
                    com.didi.component.adalert.HomeAdAlertDialog r4 = com.didi.component.adalert.HomeAdAlertDialog.this
                    com.didi.component.adalert.HomeAdAlertDialog$Builder r4 = r4.f10975c
                    com.didi.component.adalert.AdAlertModel$AdAlertData r4 = r4.data
                    if (r4 == 0) goto L_0x0094
                    com.didi.sdk.paxadsdk.GlobalAdManager r4 = com.didi.sdk.paxadsdk.GlobalAdManager.getInstance()
                    com.didi.component.adalert.HomeAdAlertDialog r0 = com.didi.component.adalert.HomeAdAlertDialog.this
                    com.didi.component.adalert.HomeAdAlertDialog$Builder r0 = r0.f10975c
                    com.didi.component.adalert.AdAlertModel$AdAlertData r0 = r0.data
                    java.lang.String r0 = r0.agency
                    com.didi.sdk.paxadsdk.NativeAdStyle r1 = com.didi.sdk.paxadsdk.NativeAdStyle.Dialog
                    com.didi.component.adalert.HomeAdAlertDialog r2 = com.didi.component.adalert.HomeAdAlertDialog.this
                    com.didi.component.adalert.HomeAdAlertDialog$Builder r2 = r2.f10975c
                    com.didi.component.adalert.AdAlertModel$AdAlertData r2 = r2.data
                    java.lang.String r2 = r2.adid
                    r4.release(r0, r1, r2)
                L_0x0094:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.component.adalert.HomeAdAlertDialog.C45221.onClick(android.view.View):void");
            }
        });
    }

    public Builder build() {
        Builder builder = new Builder();
        this.f10975c = builder;
        return builder;
    }

    public class Builder {
        View adView;
        AdAlertModel.AdAlertData data;

        public Builder() {
        }

        public Builder setAdView(AdAlertModel.AdAlertData adAlertData, View view) {
            this.data = adAlertData;
            this.adView = view;
            return this;
        }

        public void show(final FragmentManager fragmentManager, final String str) {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    if (fragmentManager != null) {
                        HomeAdAlertDialog.this.show(fragmentManager, str);
                    }
                }
            });
        }
    }
}
