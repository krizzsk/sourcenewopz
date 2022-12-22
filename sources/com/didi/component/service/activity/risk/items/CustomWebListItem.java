package com.didi.component.service.activity.risk.items;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.service.activity.risk.AbsRiskItem;
import com.didi.component.service.activity.risk.RiskListAdapter;
import com.didi.component.service.activity.risk.RiskViewHolder;
import com.didi.component.service.activity.risk.model.RiskVerifyListItem;
import com.didi.drouter.api.DRouter;
import com.taxis99.R;
import java.util.Map;

public class CustomWebListItem extends AbsRiskItem {

    /* renamed from: a */
    private RiskVerifyListItem f15720a;

    /* renamed from: b */
    private String f15721b;

    /* access modifiers changed from: protected */
    public int getItemIconRes() {
        return R.drawable.risk_verify_item_default_icon;
    }

    /* access modifiers changed from: protected */
    public int getItemTitleRes() {
        return R.string.risk_page_dialog_msg_alert_confirm;
    }

    /* access modifiers changed from: protected */
    public boolean isCustomItem() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean isItemEnable() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    public CustomWebListItem(String str, RiskListAdapter riskListAdapter, Activity activity, RiskVerifyListItem riskVerifyListItem, String str2) {
        super(str, riskListAdapter, activity);
        this.f15720a = riskVerifyListItem;
        this.f15721b = str2;
    }

    /* access modifiers changed from: protected */
    public void onClick(RiskListAdapter riskListAdapter, View view, RiskViewHolder riskViewHolder, int i) {
        RiskVerifyListItem riskVerifyListItem = this.f15720a;
        if (!(riskVerifyListItem == null || riskVerifyListItem.cell_click_param == null || TextUtils.isEmpty(this.f15720a.cell_click_param.url))) {
            String str = this.f15720a.cell_click_param.url;
            Map<String, Object> extendObjectResult = getExtendObjectResult(this.f15721b);
            if (!CollectionUtils.isEmpty((Map) extendObjectResult)) {
                str = GlobalWebUrl.buildUrl(str, extendObjectResult);
            }
            DRouter.build("GlobalCommonVerify://one/?" + "weburl" + "=" + str).start(this.mActivity);
        }
        trackClickEvent(4);
    }

    /* access modifiers changed from: protected */
    public String getItemTitleStr() {
        return this.f15720a.content;
    }

    /* access modifiers changed from: protected */
    public String getItemIconUrl() {
        return this.f15720a.head;
    }
}
