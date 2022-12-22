package com.didi.component.service.activity.risk;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.service.activity.risk.dialog.NormalDialogInfo;
import com.didi.sdk.util.GlobalOmegaUtils;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;

public abstract class AbsRiskItem implements IDialogDisplayer {

    /* renamed from: a */
    private RiskListAdapter f15666a;
    protected Activity mActivity;
    protected String mTypeName;

    /* access modifiers changed from: protected */
    public abstract int getItemIconRes();

    /* access modifiers changed from: protected */
    public String getItemIconUrl() {
        return "";
    }

    /* access modifiers changed from: protected */
    public abstract int getItemTitleRes();

    /* access modifiers changed from: protected */
    public String getItemTitleStr() {
        return "";
    }

    /* access modifiers changed from: protected */
    public boolean isCustomItem() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract boolean isItemEnable();

    /* access modifiers changed from: protected */
    public abstract void onActivityResult(int i, int i2, Intent intent);

    /* access modifiers changed from: protected */
    public abstract void onClick(RiskListAdapter riskListAdapter, View view, RiskViewHolder riskViewHolder, int i);

    /* access modifiers changed from: protected */
    public abstract void onDestroy();

    public AbsRiskItem(String str, RiskListAdapter riskListAdapter, Activity activity) {
        this.mActivity = activity;
        this.f15666a = riskListAdapter;
        this.mTypeName = str;
    }

    /* access modifiers changed from: protected */
    public void finishActivity(Intent intent) {
        this.mActivity.setResult(-1, intent);
        this.mActivity.finish();
    }

    public IDialog showDialog(NormalDialogInfo normalDialogInfo, IDialog.DialogListener dialogListener) {
        Activity activity = this.mActivity;
        if (activity instanceof IDialogDisplayer) {
            return ((IDialogDisplayer) activity).showDialog(normalDialogInfo, dialogListener);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void notifyChanged() {
        this.f15666a.notifyDataSetChanged();
    }

    public IDialog showLoading(String str) {
        Activity activity = this.mActivity;
        if (activity instanceof IDialogDisplayer) {
            return ((IDialogDisplayer) activity).showLoading(str);
        }
        return null;
    }

    public void dismissLoading(IDialog iDialog) {
        Activity activity = this.mActivity;
        if (activity instanceof IDialogDisplayer) {
            ((IDialogDisplayer) activity).dismissLoading(iDialog);
        }
    }

    /* access modifiers changed from: protected */
    public boolean hasEnableItem() {
        return this.f15666a.hasEnableItem();
    }

    /* access modifiers changed from: protected */
    public void trackVerifyEvent() {
        String str;
        HashMap hashMap = new HashMap();
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem == null) {
            str = "";
        } else {
            str = newEstimateItem.estimateId;
        }
        hashMap.put("bubble_id", str);
        GlobalOmegaUtils.trackEvent("gp_safetyvarify_success_sw", hashMap);
    }

    /* access modifiers changed from: protected */
    public void trackClickEvent(int i) {
        String str;
        HashMap hashMap = new HashMap();
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        hashMap.put("type", Integer.valueOf(i));
        if (newEstimateItem == null) {
            str = "";
        } else {
            str = newEstimateItem.estimateId;
        }
        hashMap.put("bubble_id", str);
        GlobalOmegaUtils.trackEvent("gp_safetyvarify_options_ck", hashMap);
    }

    /* access modifiers changed from: protected */
    public Map<String, String> getExtendResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (HashMap) new Gson().fromJson(str, new TypeToken<HashMap<String, String>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> getExtendObjectResult(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (HashMap) new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
