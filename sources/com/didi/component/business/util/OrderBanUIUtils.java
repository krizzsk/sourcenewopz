package com.didi.component.business.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.common.dialog.GlobalCommonBottomPop;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.webview.WebActivity;
import com.didi.travel.psnger.model.response.OrderBanPopInfo;
import com.taxis99.R;

public class OrderBanUIUtils {
    public static GlobalCommonBottomPop showBanPopDialogIfNeed(final Context context, OrderBanPopInfo orderBanPopInfo, final Runnable runnable) {
        String str;
        String str2;
        String str3;
        if (orderBanPopInfo == null) {
            return null;
        }
        String str4 = orderBanPopInfo.title;
        String str5 = orderBanPopInfo.content;
        if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5)) {
            return null;
        }
        final String str6 = orderBanPopInfo.detailUrl;
        boolean z = !TextUtils.isEmpty(str6);
        GlobalCommonBottomPop.BottomPopModel bottomPopModel = new GlobalCommonBottomPop.BottomPopModel();
        bottomPopModel.title = str4;
        bottomPopModel.content = str5;
        if (z) {
            bottomPopModel.isShowNegative = true;
            if (TextUtils.isEmpty(orderBanPopInfo.detailButton)) {
                str2 = ResourcesHelper.getString(context, R.string.click_detail);
            } else {
                str2 = orderBanPopInfo.detailButton;
            }
            bottomPopModel.positive = str2;
            if (TextUtils.isEmpty(orderBanPopInfo.okButton)) {
                str3 = ResourcesHelper.getString(context, R.string.fine);
            } else {
                str3 = orderBanPopInfo.okButton;
            }
            bottomPopModel.negative = str3;
        } else {
            bottomPopModel.isShowNegative = false;
            if (TextUtils.isEmpty(orderBanPopInfo.okButton)) {
                str = ResourcesHelper.getString(context, R.string.fine);
            } else {
                str = orderBanPopInfo.okButton;
            }
            bottomPopModel.positive = str;
        }
        final GlobalCommonBottomPop globalCommonBottomPop = new GlobalCommonBottomPop(context, bottomPopModel);
        globalCommonBottomPop.setCanceledOnTouchOutside(true);
        globalCommonBottomPop.setBottomActionListener(new GlobalCommonBottomPop.GlobalBottomPopActionListener() {
            public void onPositiveClick() {
                GlobalCommonBottomPop.this.dismiss();
                OrderBanUIUtils.openBanDetailPage(context, str6);
                Runnable runnable = runnable;
                if (runnable != null) {
                    runnable.run();
                }
            }

            public void onNegativeClick() {
                GlobalCommonBottomPop.this.dismiss();
            }
        });
        globalCommonBottomPop.show();
        return globalCommonBottomPop;
    }

    public static void openBanDetailPage(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(context, WebActivity.class);
            intent.putExtra("web_view_model", GlobalWebUrl.buildWebViewModel(str));
            context.startActivity(intent);
        }
    }
}
