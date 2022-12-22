package global.didi.pay.presenter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.didi.unifiedPay.component.IViewCallback;
import com.didi.unifiedPay.component.presenter.PayInfoManager;
import com.didi.unifiedPay.sdk.internal.PayConstant;
import com.didi.unifiedPay.sdk.model.BasicBill;
import com.didi.unifiedPay.sdk.model.DetailBill;
import com.didi.unifiedPay.sdk.model.ExternalPayChannel;
import com.didi.unifiedPay.sdk.model.PayInfo;
import com.didi.unifiedPay.sdk.model.PrepayInfo;
import com.didi.unifiedPay.util.UniPayParamUtil;
import com.google.gson.Gson;
import global.didi.pay.GlobalConfirmActivity;
import global.didi.pay.web.UniPayWebModel;
import global.didi.pay.web.UniPayWebUtil;

public class GlobalOffLinePaymentHelper {
    public static boolean needSecondConfirm(String str) {
        ExternalPayChannel selectedExternalPayChannel = getSelectedExternalPayChannel(str);
        if (selectedExternalPayChannel != null && selectedExternalPayChannel.need_guide_page) {
            return true;
        }
        return false;
    }

    public static void startOfflinePage(Context context, String str, String str2, int i, IViewCallback iViewCallback) {
        UniPayWebModel uniPayWebModel = new UniPayWebModel();
        uniPayWebModel.context = context;
        uniPayWebModel.url = str;
        uniPayWebModel.sid = str2;
        uniPayWebModel.requestCode = i;
        uniPayWebModel.intentFlag = View.STATUS_BAR_TRANSIENT;
        UniPayWebUtil.startWebPage(uniPayWebModel, iViewCallback);
    }

    public static void gotoConfirmPayActivity(Context context, PayConstant.PayBillType payBillType, String str, int i) {
        int selectedExternalPayChannelId = getSelectedExternalPayChannelId(str);
        long totalFee = getTotalFee(str);
        Intent intent = new Intent();
        intent.setClass(context, GlobalConfirmActivity.class);
        intent.putExtra("billType", payBillType);
        intent.putExtra("channelId", selectedExternalPayChannelId);
        intent.putExtra("totalFee", totalFee);
        intent.putExtra("oid", str);
        intent.putExtra("bid", i);
        intent.putExtra("currency", getCurrency(str));
        context.startActivity(intent);
    }

    public static boolean needJumpOfflineWebPage(String str) {
        ExternalPayChannel selectedExternalPayChannel = getSelectedExternalPayChannel(str);
        if (selectedExternalPayChannel == null) {
            return false;
        }
        return PayConstant.isGlobalOfflineChannel(selectedExternalPayChannel.channel_id);
    }

    public static String getOfflinePayH5Url(String str) {
        try {
            PrepayInfo.OfflinePayModel offlinePayModel = (PrepayInfo.OfflinePayModel) new Gson().fromJson(str, PrepayInfo.OfflinePayModel.class);
            if (offlinePayModel == null || TextUtils.isEmpty(offlinePayModel.h5_url)) {
                return "";
            }
            return offlinePayModel.h5_url;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static ExternalPayChannel getSelectedExternalPayChannel(String str) {
        DetailBill detailBill;
        ExternalPayChannel[] externalPayChannelArr;
        PayInfo payInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(str);
        if (!(payInfo == null || (detailBill = payInfo.billDetail) == null || (externalPayChannelArr = detailBill.externalChannels) == null || externalPayChannelArr.length <= 0)) {
            for (ExternalPayChannel externalPayChannel : externalPayChannelArr) {
                if (externalPayChannel != null && externalPayChannel.selected == 1) {
                    return externalPayChannel;
                }
            }
        }
        return null;
    }

    private static int getSelectedExternalPayChannelId(String str) {
        ExternalPayChannel selectedExternalPayChannel = getSelectedExternalPayChannel(str);
        if (selectedExternalPayChannel != null) {
            return selectedExternalPayChannel.channel_id;
        }
        return 0;
    }

    private static long getTotalFee(String str) {
        BasicBill basicBill;
        PayInfo payInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(str);
        if (payInfo == null || (basicBill = payInfo.billBasic) == null) {
            return 0;
        }
        return basicBill.totalFee;
    }

    private static String getCurrency(String str) {
        BasicBill basicBill;
        PayInfo payInfo = PayInfoManager.getInstance(UniPayParamUtil.getLang()).getPayInfo(str);
        if (payInfo == null || (basicBill = payInfo.billBasic) == null) {
            return "";
        }
        return basicBill.currency;
    }
}
