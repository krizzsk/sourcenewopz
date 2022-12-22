package com.didi.soda.customer.biz.popdialog.natived.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.raven.config.RavenKey;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.customer.biz.popdialog.natived.Contract;
import com.didi.soda.customer.biz.popdialog.natived.model.NAPopCouponRvModel;
import com.didi.soda.customer.foundation.rpc.entity.CouponEntity;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.ClickUtils;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.widget.RoundImageView;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\tH\u0002J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\tH\u0002J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\tH\u0002J\u001e\u0010 \u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, mo175978d2 = {"Lcom/didi/soda/customer/biz/popdialog/natived/view/CouponPopItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "clickListener", "Lcom/didi/soda/customer/biz/popdialog/natived/Contract$NaPopBinderActionListener;", "getClickListener", "()Lcom/didi/soda/customer/biz/popdialog/natived/Contract$NaPopBinderActionListener;", "setClickListener", "(Lcom/didi/soda/customer/biz/popdialog/natived/Contract$NaPopBinderActionListener;)V", "couponStyle", "getCouponStyle", "()I", "setCouponStyle", "(I)V", "initView", "", "updateContent", "model", "Lcom/didi/soda/customer/biz/popdialog/natived/model/NAPopCouponRvModel;", "updateLogo", "updateOperation", "index", "updateOperationBtn", "updateOperationContent", "updateView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CouponPopItemView.kt */
public final class CouponPopItemView extends ConstraintLayout {

    /* renamed from: a */
    private Contract.NaPopBinderActionListener f40509a;

    /* renamed from: b */
    private int f40510b;

    public void _$_clearFindViewByIdCache() {
    }

    public final Contract.NaPopBinderActionListener getClickListener() {
        return this.f40509a;
    }

    public final void setClickListener(Contract.NaPopBinderActionListener naPopBinderActionListener) {
        this.f40509a = naPopBinderActionListener;
    }

    public final int getCouponStyle() {
        return this.f40510b;
    }

    public final void setCouponStyle(int i) {
        this.f40510b = i;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CouponPopItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CouponPopItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        initView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CouponPopItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        initView();
    }

    public final void initView() {
        View.inflate(getContext(), R.layout.customer_dialog_coupon_pop_itemview, this);
        ((ConstraintLayout) findViewById(R.id.customer_ll_pop_root)).setBackground(getContext().getResources().getDrawable(R.drawable.customer_icon_coupon_bg_left));
        if (DisplayUtils.getScreenWidth(getContext()) <= 720) {
            ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_coupon_expire_time)).setTextSize(9.0f);
        } else {
            ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_coupon_expire_time)).setTextSize(10.0f);
        }
    }

    public final void updateView(int i, NAPopCouponRvModel nAPopCouponRvModel, int i2) {
        Intrinsics.checkNotNullParameter(nAPopCouponRvModel, "model");
        this.f40510b = i;
        m28751b(nAPopCouponRvModel);
        m28748a(nAPopCouponRvModel);
        m28749a(nAPopCouponRvModel, i2);
    }

    /* renamed from: a */
    private final void m28749a(NAPopCouponRvModel nAPopCouponRvModel, int i) {
        ViewGroup.LayoutParams layoutParams = ((LinearLayout) findViewById(R.id.customer_ll_coupon_operation)).getLayoutParams();
        layoutParams.width = Math.max(DisplayUtils.dip2px(getContext(), 112.0f), (int) Math.floor(((double) CustomerSystemUtil.getScreenWidth(getContext())) * 0.2986666666666667d));
        ((LinearLayout) findViewById(R.id.customer_ll_coupon_operation)).setLayoutParams(layoutParams);
        ((LinearLayout) findViewById(R.id.customer_ll_coupon_operation)).setBackground(getContext().getResources().getDrawable(R.drawable.customer_icon_coupon_bg_right));
        m28753c(nAPopCouponRvModel, i);
        m28752b(nAPopCouponRvModel, i);
    }

    /* renamed from: b */
    private final void m28752b(NAPopCouponRvModel nAPopCouponRvModel, int i) {
        CouponEntity.ButtonInfo btn = nAPopCouponRvModel.getBtn();
        String str = null;
        CharSequence charSequence = btn == null ? null : btn.text;
        if (charSequence == null || charSequence.length() == 0) {
            ((RFMainButton) findViewById(R.id.customer_btb_operation)).setVisibility(8);
            ((RFMainButton) findViewById(R.id.customer_btb_operation)).setOnClickListener((View.OnClickListener) null);
            return;
        }
        ((RFMainButton) findViewById(R.id.customer_btb_operation)).setVisibility(0);
        RFMainButton rFMainButton = (RFMainButton) findViewById(R.id.customer_btb_operation);
        CouponEntity.ButtonInfo btn2 = nAPopCouponRvModel.getBtn();
        if (btn2 != null) {
            str = btn2.text;
        }
        if (str == null) {
            str = "";
        }
        rFMainButton.setText(str);
        ((RFMainButton) findViewById(R.id.customer_btb_operation)).setOnClickListener(new View.OnClickListener(this, i) {
            public final /* synthetic */ CouponPopItemView f$1;
            public final /* synthetic */ int f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                CouponPopItemView.m28750a(NAPopCouponRvModel.this, this.f$1, this.f$2, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28750a(NAPopCouponRvModel nAPopCouponRvModel, CouponPopItemView couponPopItemView, int i, View view) {
        CouponEntity.ButtonInfo btn;
        String str;
        Intrinsics.checkNotNullParameter(nAPopCouponRvModel, "$model");
        Intrinsics.checkNotNullParameter(couponPopItemView, "this$0");
        if (!ClickUtils.isFastClick() && (btn = nAPopCouponRvModel.getBtn()) != null && (str = btn.redirectUrl) != null) {
            HashMap hashMap = new HashMap();
            Map map = hashMap;
            map.put(ParamConst.PARAM_BATCH_ID, nAPopCouponRvModel.getBatchId());
            String discountDesc = nAPopCouponRvModel.getDiscountDesc();
            if (discountDesc == null) {
                discountDesc = "";
            }
            map.put("title", discountDesc);
            map.put("from", "1");
            DiRouter.request().path("webPage").putString("url", str).putSerializable("params", hashMap).open();
            Contract.NaPopBinderActionListener clickListener = couponPopItemView.getClickListener();
            if (clickListener != null) {
                clickListener.onOperationClickAction(nAPopCouponRvModel.getCouponId(), i);
            }
        }
    }

    /* renamed from: c */
    private final void m28753c(NAPopCouponRvModel nAPopCouponRvModel, int i) {
        int i2;
        String str = "";
        int i3 = 0;
        if (nAPopCouponRvModel.getCouponTypeInt() == 100) {
            if (!TextUtils.isEmpty(nAPopCouponRvModel.getDiscountStr())) {
                str = Intrinsics.stringPlus(nAPopCouponRvModel.getDiscountStr(), nAPopCouponRvModel.getExtStr());
            }
        } else if (!TextUtils.isEmpty(nAPopCouponRvModel.getCurrencyMark()) && !TextUtils.isEmpty(nAPopCouponRvModel.getCouponAmount())) {
            String couponAmount = nAPopCouponRvModel.getCouponAmount();
            if ((couponAmount == null ? 0 : couponAmount.length()) > 2) {
                String currencyMark = nAPopCouponRvModel.getCurrencyMark();
                if (currencyMark == null) {
                    currencyMark = str;
                }
                String couponAmount2 = nAPopCouponRvModel.getCouponAmount();
                if (couponAmount2 != null) {
                    str = couponAmount2;
                }
                if (this.f40510b == 0) {
                    String substring = str.substring(0, str.length() - 2);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    str = Intrinsics.stringPlus(currencyMark, substring);
                } else {
                    StringBuilder sb = new StringBuilder();
                    String substring2 = str.substring(0, str.length() - 2);
                    Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sb.append(substring2);
                    sb.append(' ');
                    sb.append(currencyMark);
                    str = sb.toString();
                }
            }
        }
        CustomerAppCompatTextView customerAppCompatTextView = (CustomerAppCompatTextView) findViewById(R.id.customer_txt_ooperation_des);
        CharSequence limitStr = nAPopCouponRvModel.getLimitStr();
        if (limitStr == null || limitStr.length() == 0) {
            i2 = 8;
        } else {
            ((CustomerAppCompatTextView) findViewById(R.id.customer_txt_ooperation_des)).setText(nAPopCouponRvModel.getLimitStr());
            i2 = 0;
        }
        customerAppCompatTextView.setVisibility(i2);
        CustomerAppCompatTextView customerAppCompatTextView2 = (CustomerAppCompatTextView) findViewById(R.id.customer_txt_operation);
        CharSequence charSequence = str;
        if (charSequence.length() == 0) {
            i3 = 8;
        }
        customerAppCompatTextView2.setVisibility(i3);
        ((CustomerAppCompatTextView) findViewById(R.id.customer_txt_operation)).setText(charSequence);
        ((CustomerAppCompatTextView) findViewById(R.id.customer_txt_operation)).setTextSize(1, (str.length() > 6 || DisplayUtils.getScreenWidth(getContext()) < 640) ? 16.0f : 22.0f);
    }

    /* renamed from: a */
    private final void m28748a(NAPopCouponRvModel nAPopCouponRvModel) {
        ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_coupon_name)).setText(nAPopCouponRvModel.getActivityName());
        CouponEntity.ExpireInfo expireInfo = nAPopCouponRvModel.getExpireInfo();
        String str = null;
        CharSequence charSequence = expireInfo == null ? null : expireInfo.note;
        boolean z = true;
        if (charSequence == null || charSequence.length() == 0) {
            ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_coupon_expire_time)).setVisibility(8);
            return;
        }
        ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_coupon_expire_time)).setVisibility(0);
        CustomerAppCompatTextView customerAppCompatTextView = (CustomerAppCompatTextView) findViewById(R.id.customer_tv_coupon_expire_time);
        CouponEntity.ExpireInfo expireInfo2 = nAPopCouponRvModel.getExpireInfo();
        if (expireInfo2 != null) {
            str = expireInfo2.note;
        }
        customerAppCompatTextView.setText(str);
        CouponEntity.ExpireInfo expireInfo3 = nAPopCouponRvModel.getExpireInfo();
        if (expireInfo3 == null || expireInfo3.style != 4) {
            z = false;
        }
        if (z) {
            ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_coupon_expire_time)).setTextColor(getResources().getColor(R.color.rf_color_gery_1_0_000000));
        } else {
            ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_coupon_expire_time)).setTextColor(getResources().getColor(R.color.rf_color_brands_2_72_31B77E));
        }
    }

    /* renamed from: b */
    private final void m28751b(NAPopCouponRvModel nAPopCouponRvModel) {
        int i = nAPopCouponRvModel.getBusinessCouponType() == 1 ? R.drawable.customer_store_coupon_default : R.drawable.customer_platform_coupon_default;
        if (nAPopCouponRvModel.getRlCustomLogo() == null) {
            ((RoundImageView) findViewById(R.id.customer_round_logo)).setImageResource(i);
        } else {
            FlyImageLoader.loadImage1x1(getContext(), nAPopCouponRvModel.getRlCustomLogo()).error(i).centerCrop().into((ImageView) (RoundImageView) findViewById(R.id.customer_round_logo));
        }
    }
}
