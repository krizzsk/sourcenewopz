package com.didi.universal.pay.biz.manager;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.didi.universal.pay.biz.model.UniversalPayItemModel;
import com.didi.universal.pay.biz.model.UniversalViewModel;
import com.didi.universal.pay.biz.util.UniversalNumberUtil;
import com.didi.universal.pay.sdk.method.model.ActionType;
import com.didi.universal.pay.sdk.method.model.BasicBill;
import com.didi.universal.pay.sdk.method.model.DeductionInfo;
import com.didi.universal.pay.sdk.method.model.DetailBill;
import com.didi.universal.pay.sdk.method.model.PayInfo;
import com.didi.universal.pay.sdk.method.model.UniversalPayChannelResponse;
import com.didi.universal.pay.sdk.model.BillMarketing;
import com.didi.universal.pay.sdk.util.UnipayTextUtil;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UniversalViewModelManager {
    public static String getTitleModel(Context context, PayInfo payInfo) {
        HashMap hashMap;
        String str = !TextUtils.isEmpty(payInfo.pay_title) ? payInfo.pay_title : "";
        BasicBill basicBill = payInfo.billBasic;
        if (!(basicBill == null || (hashMap = basicBill.extra) == null || hashMap.size() <= 0)) {
            try {
                str = (String) hashMap.get("ex_prepay_title_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return TextUtils.isEmpty(str) ? context.getString(R.string.universal_title) : str;
    }

    public static String getSubTitleModel(PayInfo payInfo) {
        HashMap hashMap;
        BasicBill basicBill = payInfo.billBasic;
        if (!(basicBill == null || (hashMap = basicBill.extra) == null || hashMap.size() <= 0)) {
            try {
                return (String) hashMap.get("ex_prepay_subtitle_text");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static List<UniversalViewModel.TotalFeeItem> getTotalFeeList(Context context, UniversalViewModel universalViewModel, PayInfo payInfo) {
        DeductionInfo[] deductionInfoArr;
        ArrayList arrayList = new ArrayList();
        BasicBill basicBill = payInfo.billBasic;
        if (basicBill != null) {
            universalViewModel.getClass();
            UniversalViewModel.TotalFeeItem totalFeeItem = new UniversalViewModel.TotalFeeItem();
            totalFeeItem.name = basicBill.total_fee_title;
            totalFeeItem.value = basicBill.getLeftDes() + basicBill.getTotalFeeText() + basicBill.getRightDes();
            totalFeeItem.nameDesc = basicBill.total_fee_include_text;
            arrayList.add(totalFeeItem);
        }
        DetailBill detailBill = payInfo.billDetail;
        if (!(detailBill == null || (deductionInfoArr = detailBill.deductions) == null)) {
            ArrayList arrayList2 = new ArrayList();
            for (DeductionInfo refreshDeductionModel : deductionInfoArr) {
                universalViewModel.getClass();
                UniversalViewModel.TotalFeeItem totalFeeItem2 = new UniversalViewModel.TotalFeeItem();
                refreshDeductionModel(context, totalFeeItem2, refreshDeductionModel);
                arrayList2.add(totalFeeItem2);
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    private static void refreshDeductionModel(Context context, UniversalViewModel.TotalFeeItem totalFeeItem, DeductionInfo deductionInfo) {
        int i = deductionInfo.type;
        int i2 = deductionInfo.status;
        if (i == 2 || i == 3) {
            i2 = 5;
        }
        totalFeeItem.name = deductionInfo.name;
        if (!TextUtils.isEmpty(deductionInfo.info)) {
            totalFeeItem.nameDesc = Const.jaLeft + deductionInfo.info + Const.jaRight;
        }
        totalFeeItem.value = deductionInfo.deduction;
        totalFeeItem.deductionType = deductionInfo.type;
        totalFeeItem.deductionStatus = i2;
        totalFeeItem.deductionCost = deductionInfo.cost;
        totalFeeItem.deductionId = deductionInfo.couponId;
        totalFeeItem.status = 1;
        if (i2 == 1 || i2 == 5 || i2 == 2) {
            totalFeeItem.status = 2;
        } else if (i2 == 3 || i2 == 4) {
            totalFeeItem.status = 3;
        }
        if (i2 == 1 || i2 == 3 || i2 == 2) {
            totalFeeItem.deductionURL = deductionInfo.url;
        }
        if (TextUtils.isEmpty(totalFeeItem.value)) {
            int i3 = deductionInfo.status;
            if (i3 != 1) {
                if (i3 == 2) {
                    totalFeeItem.value = context.getResources().getString(R.string.universal_voucher_deduction_choose);
                    return;
                } else if (i3 == 3) {
                    totalFeeItem.value = context.getResources().getString(R.string.universal_no_voucher);
                    return;
                } else if (i3 == 4) {
                    totalFeeItem.value = context.getResources().getString(R.string.universal_not_support_voucher);
                    return;
                } else if (i3 != 5) {
                    totalFeeItem.value = context.getResources().getString(R.string.universal_no_voucher);
                    return;
                }
            }
            Resources resources = context.getResources();
            totalFeeItem.value = resources.getString(R.string.universal_voucher_deduction_value, new Object[]{"" + deductionInfo.cost});
        }
    }

    public static UniversalViewModel.AboveFeeItem getAboveLabelModel(UniversalViewModel universalViewModel, DetailBill detailBill) {
        BillMarketing[] billMarketingArr = detailBill.marketing;
        if (billMarketingArr == null || billMarketingArr.length <= 0) {
            return null;
        }
        BillMarketing billMarketing = billMarketingArr[0];
        universalViewModel.getClass();
        UniversalViewModel.AboveFeeItem aboveFeeItem = new UniversalViewModel.AboveFeeItem(universalViewModel, billMarketing.title);
        aboveFeeItem.url = billMarketing.url;
        return aboveFeeItem;
    }

    public static CharSequence getFeeModel(BasicBill basicBill) {
        String leftDes = basicBill.getLeftDes();
        String rightDes = basicBill.getRightDes();
        String needPayFee = basicBill.getNeedPayFee();
        UniversalNumberUtil universalNumberUtil = new UniversalNumberUtil(leftDes + needPayFee + rightDes);
        universalNumberUtil.spanNumSize(3.0f);
        return universalNumberUtil;
    }

    public static List<UniversalPayItemModel> getPayChannelsModel(Context context, DetailBill detailBill) {
        ArrayList arrayList = new ArrayList();
        UniversalPayChannelResponse[] universalPayChannelResponseArr = detailBill.internalChannels;
        UniversalPayChannelResponse[] universalPayChannelResponseArr2 = detailBill.externalChannels;
        if (universalPayChannelResponseArr != null) {
            for (UniversalPayChannelResponse universalPayChannelResponse : universalPayChannelResponseArr) {
                if (UniversalPayChannelManager.isPlatformPayChannel(universalPayChannelResponse.channel_id)) {
                    arrayList.add(getChannelModelByResponse(context, universalPayChannelResponse));
                }
            }
        }
        if (universalPayChannelResponseArr2 != null) {
            for (UniversalPayChannelResponse universalPayChannelResponse2 : universalPayChannelResponseArr2) {
                if (UniversalPayChannelManager.isThirdPayChannel(universalPayChannelResponse2.channel_id)) {
                    arrayList.add(getChannelModelByResponse(context, universalPayChannelResponse2));
                }
            }
        }
        return arrayList;
    }

    private static UniversalPayItemModel getChannelModelByResponse(Context context, UniversalPayChannelResponse universalPayChannelResponse) {
        UniversalPayItemModel universalPayItemModel = new UniversalPayItemModel();
        universalPayItemModel.f45101id = universalPayChannelResponse.channel_id;
        universalPayItemModel.url = universalPayChannelResponse.url;
        boolean z = false;
        if (universalPayChannelResponse.flags == null || universalPayChannelResponse.flags.length <= 0) {
            universalPayItemModel.iconURL = universalPayChannelResponse.icon;
        } else {
            universalPayItemModel.iconURL = universalPayChannelResponse.flags[0];
        }
        universalPayItemModel.name = universalPayChannelResponse.name;
        if (!TextUtils.isEmpty(universalPayChannelResponse.info)) {
            universalPayItemModel.descFirstLine = Const.jaLeft + universalPayChannelResponse.info + Const.jaRight;
        } else if (universalPayChannelResponse.balance > 0) {
            universalPayItemModel.descFirstLine = context.getString(R.string.universal_balanceDes_balance, new Object[]{UnipayTextUtil.format(universalPayChannelResponse.balance)});
        }
        if (!TextUtils.isEmpty(universalPayChannelResponse.marketing_text)) {
            if (TextUtils.isEmpty(universalPayItemModel.descFirstLine)) {
                universalPayItemModel.marketDesc = universalPayChannelResponse.marketing_text;
            } else {
                universalPayItemModel.descFirstLine += "  " + universalPayChannelResponse.marketing_text;
            }
        }
        universalPayItemModel.value = universalPayChannelResponse.deduction;
        universalPayItemModel.descSecondLine = universalPayChannelResponse.extension;
        universalPayItemModel.payNumber = universalPayChannelResponse.channel_number;
        universalPayItemModel.canCancel = universalPayChannelResponse.canCancel == 1;
        universalPayItemModel.setState(universalPayChannelResponse.selected, universalPayChannelResponse.canSelect, universalPayChannelResponse.level);
        if (universalPayChannelResponse.hidden == 1) {
            z = true;
        }
        universalPayItemModel.isHidden = z;
        return universalPayItemModel;
    }

    public static List<UniversalViewModel.JumpItem> getJumpListModel(BasicBill basicBill, UniversalViewModel universalViewModel) {
        ArrayList arrayList = new ArrayList();
        ActionType[] actionTypeArr = basicBill.actionTypes;
        if (actionTypeArr == null) {
            return arrayList;
        }
        for (ActionType actionType : actionTypeArr) {
            universalViewModel.getClass();
            UniversalViewModel.JumpItem jumpItem = new UniversalViewModel.JumpItem();
            jumpItem.name = actionType.name;
            jumpItem.url = actionType.url;
            jumpItem.type = actionType.type;
            arrayList.add(jumpItem);
        }
        return arrayList;
    }

    public static UniversalViewModel.PayModel getPayBtnModel(DetailBill detailBill, UniversalViewModel universalViewModel) {
        universalViewModel.getClass();
        UniversalViewModel.PayModel payModel = new UniversalViewModel.PayModel();
        payModel.text = detailBill.payBtnTitle;
        if (detailBill.payEnable > 0) {
            payModel.status = 1;
        } else {
            payModel.status = 2;
        }
        return payModel;
    }
}
