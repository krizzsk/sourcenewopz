package com.didi.soda.customer.biz.popdialog.natived;

import com.didi.soda.customer.biz.popdialog.natived.model.NAPopCouponRvModel;
import com.didi.soda.customer.foundation.rpc.entity.CouponEntity;
import com.didi.soda.customer.foundation.rpc.entity.RedeemCouponEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0007¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/customer/biz/popdialog/natived/PopCouponDataHelper;", "", "()V", "parseNAPopCouponRvModel", "Lcom/didi/soda/customer/biz/popdialog/natived/model/NAPopCouponRvModel;", "couponEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/CouponEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/RedeemCouponEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PopCouponDataHelper.kt */
public final class PopCouponDataHelper {
    public static final PopCouponDataHelper INSTANCE = new PopCouponDataHelper();

    private PopCouponDataHelper() {
    }

    @JvmStatic
    public static final NAPopCouponRvModel parseNAPopCouponRvModel(CouponEntity couponEntity) {
        CouponEntity couponEntity2 = couponEntity;
        Intrinsics.checkNotNullParameter(couponEntity2, "couponEntity");
        NAPopCouponRvModel nAPopCouponRvModel = new NAPopCouponRvModel((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (CouponEntity.ButtonInfo) null, 0, (CouponEntity.ExpireInfo) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 131071, (DefaultConstructorMarker) null);
        nAPopCouponRvModel.setCouponId(couponEntity2.couponId);
        nAPopCouponRvModel.setActivityName(couponEntity2.activityName);
        nAPopCouponRvModel.setCouponAmount(couponEntity2.couponAmount);
        nAPopCouponRvModel.setActivityName(couponEntity2.activityName);
        nAPopCouponRvModel.setRlCustomLogo(couponEntity2.rlCustomLogo);
        nAPopCouponRvModel.setCurrencyMark(couponEntity2.currencyMark);
        nAPopCouponRvModel.setBatchId(couponEntity2.batchId);
        nAPopCouponRvModel.setDiscountDesc(couponEntity2.discountDesc);
        nAPopCouponRvModel.setNewUser(couponEntity2.newUser);
        List<CouponEntity.ButtonInfo> list = couponEntity2.buttons;
        nAPopCouponRvModel.setBtn((list == null ? 0 : list.size()) > 0 ? couponEntity2.buttons.get(0) : null);
        nAPopCouponRvModel.setBusinessCouponType(couponEntity2.couponBusinessType);
        nAPopCouponRvModel.setExpireInfo(couponEntity2.expireInfo);
        nAPopCouponRvModel.setCouponTypeInt(couponEntity2.couponTypeInt);
        nAPopCouponRvModel.setExpireStr(couponEntity2.expireStr);
        nAPopCouponRvModel.setExtStr(couponEntity2.extStr);
        nAPopCouponRvModel.setDiscountStr(couponEntity2.discountStr);
        return nAPopCouponRvModel;
    }

    @JvmStatic
    public static final NAPopCouponRvModel parseNAPopCouponRvModel(RedeemCouponEntity redeemCouponEntity) {
        String str;
        RedeemCouponEntity redeemCouponEntity2 = redeemCouponEntity;
        Intrinsics.checkNotNullParameter(redeemCouponEntity2, "couponEntity");
        NAPopCouponRvModel nAPopCouponRvModel = new NAPopCouponRvModel((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (CouponEntity.ButtonInfo) null, 0, (CouponEntity.ExpireInfo) null, 0, (String) null, (String) null, (String) null, (String) null, (String) null, 131071, (DefaultConstructorMarker) null);
        nAPopCouponRvModel.setCouponId(redeemCouponEntity2.couponId);
        nAPopCouponRvModel.setActivityName(redeemCouponEntity2.name);
        nAPopCouponRvModel.setRlCustomLogo(redeemCouponEntity2.logoUrl);
        nAPopCouponRvModel.setBatchId(redeemCouponEntity2.batchId);
        nAPopCouponRvModel.setDiscountDesc(redeemCouponEntity2.remark);
        RedeemCouponEntity.CouponAmountSplitEntity couponAmountSplitEntity = redeemCouponEntity2.couponAmountSplit;
        String str2 = "";
        if (couponAmountSplitEntity == null || (str = couponAmountSplitEntity.display) == null) {
            str = str2;
        }
        nAPopCouponRvModel.setCouponAmountSplitDisplay(str);
        boolean z = true;
        nAPopCouponRvModel.setBusinessCouponType(1);
        nAPopCouponRvModel.setExpireInfo(new CouponEntity.ExpireInfo());
        CouponEntity.ExpireInfo expireInfo = nAPopCouponRvModel.getExpireInfo();
        if (expireInfo != null) {
            CharSequence charSequence = redeemCouponEntity2.expireTimeDisplay;
            if (!(charSequence == null || charSequence.length() == 0)) {
                z = false;
            }
            if (!z) {
                str2 = ResourceHelper.getString(R.string.FoodC_coupon_Validity_Period_hiKb) + ':' + redeemCouponEntity2.expireTimeDisplay;
            }
            expireInfo.note = str2;
        }
        CouponEntity.ExpireInfo expireInfo2 = nAPopCouponRvModel.getExpireInfo();
        if (expireInfo2 != null) {
            expireInfo2.style = 4;
        }
        nAPopCouponRvModel.setCouponTypeInt(redeemCouponEntity2.couponType);
        nAPopCouponRvModel.setDiscountStr(redeemCouponEntity2.discountShow);
        nAPopCouponRvModel.setLimitStr(redeemCouponEntity2.discountDesc);
        return nAPopCouponRvModel;
    }
}
