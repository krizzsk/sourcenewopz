package com.didi.soda.bill.view.item;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.raven.config.RavenKey;
import com.didi.soda.bill.component.bill.BillWsgTouchHelper;
import com.didi.soda.bill.model.BillFocusHelper;
import com.didi.soda.bill.model.ComponentDataModel;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.PayChannelModel;
import com.didi.soda.bill.view.BillItemView;
import com.didi.soda.bill.view.item.logic.ItemViewCommonLogic;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.PayMethodListInfoEntity;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.pay.CombinedPayLayout;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.taxis99.R;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB'\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001aH\u0014J\b\u0010\u001e\u001a\u00020\u001aH\u0014J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001cH\u0002J&\u0010$\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010&2\b\u0010(\u001a\u0004\u0018\u00010&H\u0002J\u001a\u0010)\u001a\u00020\u001a2\b\u0010*\u001a\u0004\u0018\u00010&2\u0006\u0010+\u001a\u00020\nH\u0002J\u001c\u0010,\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010&H\u0002J\u0012\u0010-\u001a\u00020\u001a2\b\u0010*\u001a\u0004\u0018\u00010&H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000¨\u0006."}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/BillPayChannelItemView;", "Lcom/didi/soda/bill/view/BillItemView;", "Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogic;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "payCombinedIcon", "Lcom/didi/soda/customer/widget/pay/CombinedPayLayout;", "payCombinedValueView", "Landroid/widget/TextView;", "payIcon", "Landroid/widget/ImageView;", "payMethodView", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "payTip", "Lcom/didi/soda/customer/widget/text/RichTextView;", "payValueView", "initView", "", "needFocusContent", "", "onAttachedToWindow", "onDetachedFromWindow", "setData", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "setPaymentFocusStyle", "isFocus", "showCombinedPayment", "payText", "", "cardOrg", "combinedOrg", "showNotPayment", "tip", "sectionIndex", "showValidPayment", "updatePaymentTip", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillPayChannelItemView.kt */
public final class BillPayChannelItemView extends BillItemView<ItemViewCommonLogic> {

    /* renamed from: a */
    private CustomerAppCompatTextView f39223a;

    /* renamed from: b */
    private CombinedPayLayout f39224b;

    /* renamed from: c */
    private ImageView f39225c;

    /* renamed from: d */
    private RichTextView f39226d;

    /* renamed from: e */
    private CustomerAppCompatTextView f39227e;

    /* renamed from: f */
    private TextView f39228f;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m27780a(View view, MotionEvent motionEvent) {
        return false;
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillPayChannelItemView(Context context) {
        super(context, false, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillPayChannelItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillPayChannelItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillPayChannelItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
    }

    public void initView() {
        View inflate = View.inflate(getContext(), R.layout.customer_item_bill_pay_channel, this);
        View findViewById = inflate.findViewById(R.id.customer_tv_payment_value);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_payment_value)");
        this.f39223a = (CustomerAppCompatTextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_iv_payment_combined_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.custom…iv_payment_combined_icon)");
        this.f39224b = (CombinedPayLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_iv_payment_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_iv_payment_icon)");
        this.f39225c = (ImageView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_tv_payment_tip);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_tv_payment_tip)");
        this.f39226d = (RichTextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.customer_tv_payment_method);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.customer_tv_payment_method)");
        this.f39227e = (CustomerAppCompatTextView) findViewById5;
        View findViewById6 = inflate.findViewById(R.id.customer_tv_payment_combined_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.customer_tv_payment_combined_tv)");
        this.f39228f = (TextView) findViewById6;
    }

    public void setData(ComponentModel componentModel) {
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        CharSequence name = componentModel.getName();
        boolean z = false;
        Object obj = null;
        if (!(name == null || name.length() == 0)) {
            CustomerAppCompatTextView customerAppCompatTextView = this.f39227e;
            if (customerAppCompatTextView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payMethodView");
                customerAppCompatTextView = null;
            }
            customerAppCompatTextView.setText(componentModel.getName());
        }
        int sectionIndex = componentModel.getSectionIndex();
        ComponentDataModel data = componentModel.getData();
        PayChannelModel payChannelModel = data == null ? null : data.getPayChannelModel();
        if (payChannelModel != null) {
            String payMethodChannelName = PayMethodListInfoEntity.getPayMethodChannelName(payChannelModel.getChannelId(), payChannelModel.getChannelName(), payChannelModel.getCardSuffix(), true);
            PayChannelEntity payChannelEntity = payChannelModel.getPayChannelEntity();
            if (payChannelEntity != null) {
                obj = payChannelEntity.combinedChannelList;
            }
            Collection collection = (Collection) obj;
            if (!(collection == null || collection.isEmpty())) {
                m27779a(payChannelModel.getChannelName(), payChannelModel.getCardOrg(), payChannelModel.getCombinedCardOrg());
                m27776a(componentModel.getHint());
            } else {
                CharSequence charSequence = payMethodChannelName;
                if (charSequence == null || charSequence.length() == 0) {
                    z = true;
                }
                if (!z) {
                    m27778a(payMethodChannelName, payChannelModel.getCardOrg());
                    m27776a(componentModel.getHint());
                } else {
                    m27777a(componentModel.getHint(), sectionIndex);
                }
            }
            obj = Unit.INSTANCE;
        }
        if (obj == null) {
            m27777a(componentModel.getHint(), sectionIndex);
        }
        setOnClickListener(new View.OnClickListener(componentModel) {
            public final /* synthetic */ ComponentModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                BillPayChannelItemView.m27775a(BillPayChannelItemView.this, this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27775a(BillPayChannelItemView billPayChannelItemView, ComponentModel componentModel, View view) {
        Intrinsics.checkNotNullParameter(billPayChannelItemView, "this$0");
        Intrinsics.checkNotNullParameter(componentModel, "$componentModel");
        ItemViewCommonLogic itemViewCommonLogic = (ItemViewCommonLogic) billPayChannelItemView.getLogic();
        if (itemViewCommonLogic != null) {
            ItemViewCommonLogic.onItemClick$default(itemViewCommonLogic, componentModel, (Integer) null, (Bundle) null, (Function1) null, 14, (Object) null);
        }
    }

    /* renamed from: a */
    private final void m27779a(String str, String str2, String str3) {
        CustomerAppCompatTextView customerAppCompatTextView = this.f39223a;
        ImageView imageView = null;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            customerAppCompatTextView = null;
        }
        customerAppCompatTextView.setVisibility(8);
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            TextView textView = this.f39228f;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payCombinedValueView");
                textView = null;
            }
            textView.setVisibility(0);
            TextView textView2 = this.f39228f;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payCombinedValueView");
                textView2 = null;
            }
            textView2.setText(charSequence);
        } else {
            TextView textView3 = this.f39228f;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payCombinedValueView");
                textView3 = null;
            }
            textView3.setVisibility(8);
        }
        CombinedPayLayout combinedPayLayout = this.f39224b;
        if (combinedPayLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payCombinedIcon");
            combinedPayLayout = null;
        }
        combinedPayLayout.setData(str2, str3);
        CombinedPayLayout combinedPayLayout2 = this.f39224b;
        if (combinedPayLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payCombinedIcon");
            combinedPayLayout2 = null;
        }
        combinedPayLayout2.setVisibility(0);
        ImageView imageView2 = this.f39225c;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payIcon");
        } else {
            imageView = imageView2;
        }
        imageView.setVisibility(8);
    }

    /* renamed from: a */
    private final void m27778a(String str, String str2) {
        TextView textView = this.f39228f;
        CombinedPayLayout combinedPayLayout = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payCombinedValueView");
            textView = null;
        }
        textView.setVisibility(8);
        CustomerAppCompatTextView customerAppCompatTextView = this.f39223a;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            customerAppCompatTextView = null;
        }
        customerAppCompatTextView.setVisibility(0);
        CustomerAppCompatTextView customerAppCompatTextView2 = this.f39223a;
        if (customerAppCompatTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            customerAppCompatTextView2 = null;
        }
        customerAppCompatTextView2.setText(str);
        CustomerAppCompatTextView customerAppCompatTextView3 = this.f39223a;
        if (customerAppCompatTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            customerAppCompatTextView3 = null;
        }
        customerAppCompatTextView3.setHint("");
        setPaymentFocusStyle(false);
        CustomerAppCompatTextView customerAppCompatTextView4 = this.f39223a;
        if (customerAppCompatTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            customerAppCompatTextView4 = null;
        }
        customerAppCompatTextView4.setTextSize(0, (float) DisplayUtils.dip2px(GlobalContext.getContext(), 18.0f));
        IToolsService iToolsService = (IToolsService) CustomerServiceManager.getService(IToolsService.class);
        CustomerAppCompatTextView customerAppCompatTextView5 = this.f39223a;
        if (customerAppCompatTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            customerAppCompatTextView5 = null;
        }
        iToolsService.setTypeface(customerAppCompatTextView5, IToolsService.FontType.MEDIUM);
        FlyImageLoader.ImageRequestWrapper loadImageUnspecified = FlyImageLoader.loadImageUnspecified(getContext(), str2);
        ImageView imageView = this.f39225c;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payIcon");
            imageView = null;
        }
        loadImageUnspecified.into(imageView);
        ImageView imageView2 = this.f39225c;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payIcon");
            imageView2 = null;
        }
        imageView2.setVisibility(0);
        CombinedPayLayout combinedPayLayout2 = this.f39224b;
        if (combinedPayLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payCombinedIcon");
        } else {
            combinedPayLayout = combinedPayLayout2;
        }
        combinedPayLayout.setVisibility(8);
    }

    /* renamed from: a */
    private final void m27777a(String str, int i) {
        CustomerAppCompatTextView customerAppCompatTextView = this.f39223a;
        TextView textView = null;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            customerAppCompatTextView = null;
        }
        customerAppCompatTextView.setHint(R.string.customer_name_please_select);
        CustomerAppCompatTextView customerAppCompatTextView2 = this.f39223a;
        if (customerAppCompatTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            customerAppCompatTextView2 = null;
        }
        customerAppCompatTextView2.setText("");
        setPaymentFocusStyle(i == BillFocusHelper.Companion.getNeedFocusIndex());
        CustomerAppCompatTextView customerAppCompatTextView3 = this.f39223a;
        if (customerAppCompatTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            customerAppCompatTextView3 = null;
        }
        customerAppCompatTextView3.setTextSize(0, (float) DisplayUtils.dip2px(GlobalContext.getContext(), 14.0f));
        IToolsService iToolsService = (IToolsService) CustomerServiceManager.getService(IToolsService.class);
        CustomerAppCompatTextView customerAppCompatTextView4 = this.f39223a;
        if (customerAppCompatTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            customerAppCompatTextView4 = null;
        }
        iToolsService.setTypeface(customerAppCompatTextView4, IToolsService.FontType.LIGHT);
        CombinedPayLayout combinedPayLayout = this.f39224b;
        if (combinedPayLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payCombinedIcon");
            combinedPayLayout = null;
        }
        combinedPayLayout.setVisibility(4);
        ImageView imageView = this.f39225c;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payIcon");
            imageView = null;
        }
        imageView.setVisibility(8);
        TextView textView2 = this.f39228f;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payCombinedValueView");
        } else {
            textView = textView2;
        }
        textView.setVisibility(8);
        m27776a(str);
    }

    /* renamed from: a */
    private final void m27776a(String str) {
        CharSequence charSequence = str;
        RichTextView richTextView = null;
        if (charSequence == null || charSequence.length() == 0) {
            RichTextView richTextView2 = this.f39226d;
            if (richTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payTip");
            } else {
                richTextView = richTextView2;
            }
            richTextView.setVisibility(8);
            return;
        }
        RichTextView richTextView3 = this.f39226d;
        if (richTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payTip");
            richTextView3 = null;
        }
        richTextView3.setVisibility(0);
        RichTextView richTextView4 = this.f39226d;
        if (richTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payTip");
        } else {
            richTextView = richTextView4;
        }
        richTextView.setText(charSequence);
    }

    private final void setPaymentFocusStyle(boolean z) {
        CustomerAppCompatTextView customerAppCompatTextView = null;
        if (z) {
            CustomerAppCompatTextView customerAppCompatTextView2 = this.f39223a;
            if (customerAppCompatTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            } else {
                customerAppCompatTextView = customerAppCompatTextView2;
            }
            customerAppCompatTextView.setHintTextColor(ResourceHelper.getColor(R.color.rf_color_alert_red_100_FF4E45));
            return;
        }
        CustomerAppCompatTextView customerAppCompatTextView3 = this.f39223a;
        if (customerAppCompatTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
        } else {
            customerAppCompatTextView = customerAppCompatTextView3;
        }
        customerAppCompatTextView.setHintTextColor(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
    }

    public boolean needFocusContent() {
        CustomerAppCompatTextView customerAppCompatTextView = this.f39223a;
        TextView textView = null;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            customerAppCompatTextView = null;
        }
        CharSequence text = customerAppCompatTextView.getText();
        if (text == null || text.length() == 0) {
            TextView textView2 = this.f39228f;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payCombinedValueView");
            } else {
                textView = textView2;
            }
            CharSequence text2 = textView.getText();
            if (text2 == null || text2.length() == 0) {
                setPaymentFocusStyle(true);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (BillWsgTouchHelper.Companion.getInstance().getPayChooseTouch() != null) {
            setOnTouchListener(BillWsgTouchHelper.Companion.getInstance().getPayChooseTouch());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        setOnTouchListener($$Lambda$BillPayChannelItemView$yVgSNvZws2wQniZXFpfbj8nL1sw.INSTANCE);
        super.onDetachedFromWindow();
    }
}
