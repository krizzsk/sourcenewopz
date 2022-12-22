package com.didi.component.service.activity.risk.items;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.service.activity.MexicoCurpAuthWebActivity;
import com.didi.component.service.activity.risk.AbsRiskItem;
import com.didi.component.service.activity.risk.RiskListAdapter;
import com.didi.component.service.activity.risk.RiskViewHolder;
import com.didi.sdk.webview.WebViewModel;
import com.taxis99.R;
import java.util.Map;

public class MexicoCurpItem extends AbsRiskItem {

    /* renamed from: a */
    private static final int f15725a = 36867;

    /* renamed from: b */
    private String f15726b;

    /* renamed from: c */
    private String f15727c;

    /* access modifiers changed from: protected */
    public int getItemIconRes() {
        return R.drawable.curp_icon_selector;
    }

    /* access modifiers changed from: protected */
    public int getItemTitleRes() {
        return R.string.risk_mexico_curp_label;
    }

    /* access modifiers changed from: protected */
    public boolean isItemEnable() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    public MexicoCurpItem(String str, RiskListAdapter riskListAdapter, Activity activity, String str2, String str3) {
        super(str, riskListAdapter, activity);
        this.f15726b = str2;
        this.f15727c = str3;
    }

    /* access modifiers changed from: protected */
    public void onClick(RiskListAdapter riskListAdapter, View view, RiskViewHolder riskViewHolder, int i) {
        String str = this.f15726b;
        if (!TextUtils.isEmpty(str)) {
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.url = str;
            webViewModel.isSupportCache = false;
            webViewModel.addParam("product_id", BusinessDataUtil.getProductId());
            if (!TextUtils.isEmpty(this.f15727c)) {
                Map<String, String> extendResult = getExtendResult(this.f15727c);
                if (!CollectionUtils.isEmpty((Map) extendResult)) {
                    for (String next : extendResult.keySet()) {
                        if (!TextUtils.isEmpty(next)) {
                            webViewModel.addParam(next, extendResult.get(next));
                        }
                    }
                }
            }
            Intent intent = new Intent(this.mActivity, MexicoCurpAuthWebActivity.class);
            intent.putExtra("web_view_model", webViewModel);
            intent.putExtra("CPF_AUTH_SOURCE_KEY", 3);
            this.mActivity.startActivityForResult(intent, 36867);
        }
        trackClickEvent(1);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 36867 && i2 == -1) {
            GLog.m7964d("result ok.. close activity by mexico item");
            finishActivity(intent);
        }
    }
}
