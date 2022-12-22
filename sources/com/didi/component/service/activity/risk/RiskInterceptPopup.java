package com.didi.component.service.activity.risk;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.service.activity.risk.bff.RiskBff;
import com.didi.component.service.activity.risk.model.RiskVerifyListItem;
import com.didi.component.service.activity.risk.model.RiskVerifyResponse;
import com.didi.global.loading.Loading;
import com.didi.global.loading.LoadingRenderType;
import com.didi.sdk.view.SimplePopupBase;
import com.didichuxing.foundation.rpc.RpcService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.IOException;
import java.util.ArrayList;

public class RiskInterceptPopup extends SimplePopupBase {

    /* renamed from: a */
    private static final String f15667a = "key_verify_mode";

    /* renamed from: b */
    private static final String f15668b = "key_extension";

    /* renamed from: c */
    private static final String f15669c = "globalOneTravel://one/safety/bind_card_verify_v1";

    /* renamed from: d */
    private TextView f15670d;

    /* renamed from: e */
    private View f15671e;

    /* renamed from: f */
    private Drawable f15672f;

    /* renamed from: g */
    private ColorStateList f15673g;

    /* renamed from: h */
    private String f15674h;

    /* renamed from: i */
    private String f15675i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ArrayList<RiskVerifyListItem> f15676j = null;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_risk_verify_dialog;
    }

    public static RiskInterceptPopup getInstance(String str, String str2) {
        RiskInterceptPopup riskInterceptPopup = new RiskInterceptPopup();
        Bundle bundle = new Bundle();
        bundle.putString(f15667a, str);
        bundle.putString(f15668b, str2);
        riskInterceptPopup.setArguments(bundle);
        return riskInterceptPopup;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f15674h = getArguments().getString(f15667a, "10");
            this.f15675i = getArguments().getString(f15668b);
        }
    }

    /* renamed from: a */
    private void m11436a() {
        if (getActivity() != null) {
            Loading.make(getContext(), LoadingRenderType.ANIMATION, this.f15671e, true, 48).show();
            if (TextUtils.isEmpty(this.f15674h)) {
                this.f15674h = "10";
            }
            RiskBff.getRiskVerifyList(getActivity(), this.f15674h, new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    RiskInterceptPopup.this.m11438b();
                    try {
                        RiskVerifyResponse riskVerifyResponse = (RiskVerifyResponse) new Gson().fromJson((JsonElement) jsonObject, RiskVerifyResponse.class);
                        if (riskVerifyResponse != null && riskVerifyResponse.errno == 0 && riskVerifyResponse.data != null && riskVerifyResponse.data.verify_list != null && !riskVerifyResponse.data.verify_list.isEmpty()) {
                            ArrayList unused = RiskInterceptPopup.this.f15676j = riskVerifyResponse.data.verify_list;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                public void onFailure(IOException iOException) {
                    RiskInterceptPopup.this.m11438b();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m11438b() {
        Drawable drawable = this.f15672f;
        if (drawable != null) {
            this.f15670d.setBackground(drawable);
        }
        ColorStateList colorStateList = this.f15673g;
        if (colorStateList != null) {
            this.f15670d.setTextColor(colorStateList);
        }
        this.f15670d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                RiskInterceptPopup.this.startRiskListActivity();
                RiskInterceptPopup.this.dismiss();
            }
        });
        Loading.hide(this.f15671e);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        TextView textView = (TextView) this.mRootView.findViewById(R.id.tv_verify_btn);
        this.f15670d = textView;
        this.f15672f = textView.getBackground();
        this.f15673g = this.f15670d.getTextColors();
        this.f15670d.setBackgroundColor(getResources().getColor(R.color.oc_color_EEEEEE));
        this.f15670d.setTextColor(getResources().getColor(R.color.color_CCCCCC));
        this.f15671e = this.mRootView.findViewById(R.id.risk_verify_fallback);
        setCancelable(true);
        m11436a();
    }

    public void startRiskListActivity() {
        if (getActivity() != null) {
            if (this.f15676j == null) {
                RiskVerifyListItem createFromParcel = RiskVerifyListItem.CREATOR.createFromParcel(Parcel.obtain());
                createFromParcel.head = "";
                createFromParcel.content = getString(R.string.risk_credit_card_label);
                createFromParcel.cell_click_scheme = f15669c;
                ArrayList<RiskVerifyListItem> arrayList = new ArrayList<>();
                this.f15676j = arrayList;
                arrayList.add(createFromParcel);
            }
            Intent intent = new Intent(getActivity(), RiskUserActivity.class);
            intent.putExtra(RiskUserActivity.RISK_USER_ACTIVITY_EXTRA_VERIFY_LIST, this.f15676j);
            intent.putExtra("extension", this.f15675i);
            startActivity(intent);
        }
    }
}
