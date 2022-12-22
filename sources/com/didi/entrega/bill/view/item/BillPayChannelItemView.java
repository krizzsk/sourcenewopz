package com.didi.entrega.bill.view.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.entrega.bill.BillOmegaHelper;
import com.didi.entrega.bill.model.ComponentDataModel;
import com.didi.entrega.bill.model.ComponentModel;
import com.didi.entrega.bill.view.BillItemView;
import com.didi.entrega.customer.foundation.rpc.entity.PayChannel;
import com.didi.entrega.customer.foundation.util.FlyImageLoader;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IToolsService;
import com.didi.entrega.customer.widget.text.RichTextView;
import com.didi.entrega.foundation.rpc.entity.PayMethodListInfoEntity;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u001a\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u001c\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010 \u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001aH\u0002R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX.¢\u0006\u0002\n\u0000¨\u0006!"}, mo175978d2 = {"Lcom/didi/entrega/bill/view/item/BillPayChannelItemView;", "Lcom/didi/entrega/bill/view/BillItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "payIcon", "Landroid/widget/ImageView;", "payMethodView", "Landroid/widget/TextView;", "payTip", "Lcom/didi/entrega/customer/widget/text/RichTextView;", "payValueView", "initView", "", "setData", "componentModel", "Lcom/didi/entrega/bill/model/ComponentModel;", "setPaymentFocusStyle", "isFocus", "", "showBottomTips", "text", "", "showNotPayment", "tip", "sectionIndex", "showValidPayment", "payText", "updatePaymentTip", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillPayChannelItemView.kt */
public final class BillPayChannelItemView extends BillItemView {

    /* renamed from: a */
    private TextView f19600a;

    /* renamed from: b */
    private ImageView f19601b;

    /* renamed from: c */
    private RichTextView f19602c;

    /* renamed from: d */
    private TextView f19603d;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillPayChannelItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BillPayChannelItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillPayChannelItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillPayChannelItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void initView() {
        View inflate = View.inflate(getContext(), R.layout.entrega_customer_item_bill_pay_channel, this);
        View findViewById = inflate.findViewById(R.id.customer_tv_payment_value);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_tv_payment_value)");
        this.f19600a = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_iv_payment_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_iv_payment_icon)");
        this.f19601b = (ImageView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_tv_payment_tip);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_payment_tip)");
        this.f19602c = (RichTextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_tv_payment_method);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_tv_payment_method)");
        this.f19603d = (TextView) findViewById4;
    }

    public void setData(ComponentModel componentModel) {
        Unit unit;
        Intrinsics.checkNotNullParameter(componentModel, "componentModel");
        CharSequence name = componentModel.getName();
        boolean z = false;
        String str = null;
        if (!(name == null || name.length() == 0)) {
            TextView textView = this.f19603d;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payMethodView");
                textView = null;
            }
            textView.setText(componentModel.getName());
        }
        IToolsService iToolsService = (IToolsService) CustomerServiceManager.getService(IToolsService.class);
        TextView textView2 = this.f19603d;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payMethodView");
            textView2 = null;
        }
        iToolsService.setTypeface(textView2, IToolsService.FontType.MEDIUM);
        ComponentDataModel data = componentModel.getData();
        PayChannel payChannel = data == null ? null : data.getPayChannel();
        if (payChannel == null) {
            unit = null;
        } else {
            String payMethodChannelName = PayMethodListInfoEntity.getPayMethodChannelName(payChannel.getChannelId(), payChannel.getChannelName(), payChannel.getCardSuffix(), true);
            CharSequence charSequence = payMethodChannelName;
            if (charSequence == null || charSequence.length() == 0) {
                z = true;
            }
            if (!z) {
                m14626a(payMethodChannelName, payChannel.getCardOrg());
                m14627b(componentModel.getHint());
            } else {
                m14625a(componentModel.getHint(), componentModel.getSectionIndex());
            }
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            m14625a(componentModel.getHint(), componentModel.getSectionIndex());
        }
        if (payChannel != null) {
            str = payChannel.getBottomTips();
        }
        m14624a(str);
        setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BillPayChannelItemView.m14623a(ComponentModel.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m14623a(ComponentModel componentModel, View view) {
        Intrinsics.checkNotNullParameter(componentModel, "$componentModel");
        Function1<View, Unit> onCardClick = componentModel.getOnCardClick();
        if (onCardClick != null) {
            Intrinsics.checkNotNullExpressionValue(view, "it");
            onCardClick.invoke(view);
        }
    }

    /* renamed from: a */
    private final void m14624a(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            findViewById(R.id.entrega_view_divider).setVisibility(8);
            ((RichTextView) findViewById(R.id.entrega_view_bottom_tips)).setVisibility(8);
            return;
        }
        findViewById(R.id.entrega_view_divider).setVisibility(0);
        ((RichTextView) findViewById(R.id.entrega_view_bottom_tips)).setVisibility(0);
        ((RichTextView) findViewById(R.id.entrega_view_bottom_tips)).setText(charSequence);
    }

    /* renamed from: a */
    private final void m14626a(String str, String str2) {
        TextView textView = this.f19600a;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            textView = null;
        }
        textView.setText(str);
        TextView textView2 = this.f19600a;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            textView2 = null;
        }
        textView2.setHint("");
        setPaymentFocusStyle(false);
        try {
            FlyImageLoader.ImageRequestWrapper error = FlyImageLoader.loadImageUnspecified(getContext(), str2).placeholder((int) R.drawable.entrega_icon_stuff_placeholder).error((int) R.drawable.entrega_icon_stuff_placeholder);
            ImageView imageView2 = this.f19601b;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payIcon");
                imageView2 = null;
            }
            error.into(imageView2);
        } catch (Exception unused) {
            BillOmegaHelper.INSTANCE.billGlideContextError();
        }
        ImageView imageView3 = this.f19601b;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payIcon");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(0);
    }

    /* renamed from: a */
    private final void m14625a(String str, int i) {
        TextView textView = this.f19600a;
        ImageView imageView = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            textView = null;
        }
        textView.setHint(R.string.FoodC_unpaid_Select_NWED);
        TextView textView2 = this.f19600a;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            textView2 = null;
        }
        textView2.setText("");
        setPaymentFocusStyle(i == 0);
        IToolsService iToolsService = (IToolsService) CustomerServiceManager.getService(IToolsService.class);
        TextView textView3 = this.f19600a;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            textView3 = null;
        }
        iToolsService.setTypeface(textView3, IToolsService.FontType.LIGHT);
        ImageView imageView2 = this.f19601b;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payIcon");
            imageView2 = null;
        }
        imageView2.setImageBitmap((Bitmap) null);
        ImageView imageView3 = this.f19601b;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payIcon");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
        m14627b(str);
    }

    /* renamed from: b */
    private final void m14627b(String str) {
        CharSequence charSequence = str;
        RichTextView richTextView = null;
        if (charSequence == null || charSequence.length() == 0) {
            RichTextView richTextView2 = this.f19602c;
            if (richTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("payTip");
            } else {
                richTextView = richTextView2;
            }
            richTextView.setVisibility(8);
            return;
        }
        RichTextView richTextView3 = this.f19602c;
        if (richTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payTip");
            richTextView3 = null;
        }
        richTextView3.setVisibility(0);
        RichTextView richTextView4 = this.f19602c;
        if (richTextView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payTip");
        } else {
            richTextView = richTextView4;
        }
        richTextView.setText(charSequence);
    }

    private final void setPaymentFocusStyle(boolean z) {
        TextView textView = this.f19600a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payValueView");
            textView = null;
        }
        textView.setHintTextColor(ResourceHelper.getColor(R.color.rf_color_gery_4_80_CCCCCC));
    }
}
