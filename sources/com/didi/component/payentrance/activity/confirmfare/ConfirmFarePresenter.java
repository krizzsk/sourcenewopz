package com.didi.component.payentrance.activity.confirmfare;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.core.PresenterGroup;
import com.didi.component.payentrance.model.OrderRecord;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.travel.psnger.core.model.response.DTSDKDriverModel;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.unifiedPay.sdk.model.BillConfirm;
import com.taxis99.R;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConfirmFarePresenter extends PresenterGroup<IConfirmFareView> {
    public ConfirmFarePresenter(Context context, Bundle bundle) {
        super(context, bundle);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    public void bind(BillConfirm billConfirm, String str) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            OrderRecord orderRecord = new OrderRecord();
            m10698a(this.mContext, orderRecord, order, str);
            if (billConfirm != null && !TextUtil.isEmpty(billConfirm.totalFeeText)) {
                orderRecord.setPrice(billConfirm.totalFeeText);
            }
            ((IConfirmFareView) this.mView).showOrderRecord(orderRecord);
            m10697a(this.mContext, orderRecord, order);
            return;
        }
        ((IConfirmFareView) this.mView).showOrderRecord((OrderRecord) null);
    }

    /* renamed from: a */
    private void m10698a(Context context, OrderRecord orderRecord, CarOrder carOrder, String str) {
        if (orderRecord != null && carOrder != null) {
            orderRecord.setBusinessName(BusinessUtils.getCarNameByBid("ride", carOrder.productid));
            if (str == null) {
                str = m10696a(context);
            }
            orderRecord.setPriceUnit(str);
            if (carOrder.feeDetail != null) {
                orderRecord.setPrice(carOrder.feeDetail.payTitle);
            }
            orderRecord.setDate(new SimpleDateFormat(this.mContext.getString(R.string.pe_pay_confirm_fare_date_format)).format(new Date(carOrder.createTime)));
            if (carOrder.startAddress != null) {
                orderRecord.setStart(carOrder.startAddress.address);
            }
            if (carOrder.endAddress != null) {
                orderRecord.setEnd(carOrder.endAddress.address);
            }
            DTSDKDriverModel dTSDKDriverModel = carOrder.carDriver;
            if (dTSDKDriverModel != null) {
                orderRecord.setDriverName(dTSDKDriverModel.name);
                orderRecord.setCarInfo(dTSDKDriverModel.carType);
                orderRecord.setPlate(dTSDKDriverModel.card);
            }
        }
    }

    /* renamed from: a */
    private String m10696a(Context context) {
        String currency = NationTypeUtil.getNationComponentData().getCurrency();
        return TextUtils.isEmpty(currency) ? context.getString(R.string.pe_pay_car_pay_unit) : currency;
    }

    /* renamed from: a */
    private void m10697a(Context context, final OrderRecord orderRecord, CarOrder carOrder) {
        DTSDKDriverModel dTSDKDriverModel;
        if (orderRecord != null && carOrder != null && (dTSDKDriverModel = carOrder.carDriver) != null && !TextUtil.isEmpty(dTSDKDriverModel.avatarUrl)) {
            ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with(context).asBitmap().load(dTSDKDriverModel.avatarUrl).centerCrop()).placeholder((int) R.drawable.global_pe_pay_common_icon_head_driver)).error((int) R.drawable.global_pe_pay_common_icon_head_driver)).into(new CustomTarget<Bitmap>() {
                public void onLoadCleared(Drawable drawable) {
                }

                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    orderRecord.setDriverIcon(bitmap);
                    ((IConfirmFareView) ConfirmFarePresenter.this.mView).showOrderRecord(orderRecord);
                }
            });
        }
    }
}
