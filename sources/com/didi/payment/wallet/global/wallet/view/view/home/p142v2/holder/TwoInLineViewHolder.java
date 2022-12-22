package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.holder;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.WalletHomeHolderData;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Button;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.FinancialEntry;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.IconEntry;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeAmountStatus;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/TwoInLineViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/holder/IHomeViewHolder;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/FinancialEntry;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bottomViewContainer", "Landroidx/constraintlayout/widget/ConstraintLayout;", "ivLogo", "Landroid/widget/ImageView;", "subTitleView", "Landroid/widget/TextView;", "titleImageView", "tvBalance", "tvBtn", "tvDesc", "tvStatus", "tvTitle", "tvUnit", "getViewType", "", "onBindViewHolder", "", "info", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeHolderData;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.holder.TwoInLineViewHolder */
/* compiled from: TwoInLineViewHolder.kt */
public final class TwoInLineViewHolder extends RecyclerView.ViewHolder implements IHomeViewHolder<FinancialEntry> {

    /* renamed from: a */
    private final TextView f32743a;

    /* renamed from: b */
    private final TextView f32744b;

    /* renamed from: c */
    private final TextView f32745c;

    /* renamed from: d */
    private final TextView f32746d;

    /* renamed from: e */
    private final TextView f32747e;

    /* renamed from: f */
    private final TextView f32748f;

    /* renamed from: g */
    private final ImageView f32749g;

    /* renamed from: h */
    private final TextView f32750h;

    /* renamed from: i */
    private final ImageView f32751i;

    /* renamed from: j */
    private final ConstraintLayout f32752j;

    public int getViewType() {
        return 3;
    }

    public void onCreateViewHolder(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TwoInLineViewHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
        View findViewById = view.findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_title)");
        this.f32743a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_balance);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.tv_balance)");
        this.f32744b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tv_unit);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.tv_unit)");
        this.f32745c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.tv_desc)");
        this.f32746d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.tv_btn)");
        this.f32747e = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.tv_status);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.tv_status)");
        this.f32748f = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.iv_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.iv_logo)");
        this.f32749g = (ImageView) findViewById7;
        View findViewById8 = view.findViewById(R.id.tv_subTitle);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.tv_subTitle)");
        this.f32750h = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.iv_title_img);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "itemView.findViewById(R.id.iv_title_img)");
        this.f32751i = (ImageView) findViewById9;
        View findViewById10 = view.findViewById(R.id.bottom_content_container);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "itemView.findViewById(R.…bottom_content_container)");
        this.f32752j = (ConstraintLayout) findViewById10;
    }

    public void onBindViewHolder(WalletHomeHolderData<FinancialEntry> walletHomeHolderData) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(walletHomeHolderData, "info");
        FinancialEntry contentObj = walletHomeHolderData.getContentObj();
        if (contentObj != null) {
            this.f32743a.setText(contentObj.getTitle());
            String status = contentObj.getStatus();
            boolean z = true;
            String str = null;
            int i3 = 0;
            if ((status != null && WalletHomeModelKt.toDefaultInt$default(status, 0, 1, (Object) null) == 0) || WalletHomeAmountStatus.Companion.isShowAmount()) {
                this.f32745c.setVisibility(4);
                this.f32744b.setVisibility(4);
                this.f32750h.setVisibility(0);
                PayRichInfo mainMessage = contentObj.getMainMessage();
                if (mainMessage != null) {
                    mainMessage.bindTextView(this.f32750h, new PayRichInfo.DefaultSpannable());
                }
            } else {
                this.f32750h.setVisibility(4);
                this.f32745c.setVisibility(0);
                this.f32744b.setVisibility(0);
                this.f32745c.setText(contentObj.getCurrency());
                this.f32744b.setText(contentObj.getLocalAmount());
            }
            ImageView imageView = this.f32751i;
            CharSequence titleIcon = contentObj.getTitleIcon();
            if (!(titleIcon == null || titleIcon.length() == 0)) {
                z = false;
            }
            if (z) {
                i = 8;
            } else {
                Glide.with(this.itemView.getContext()).load(contentObj.getTitleIcon()).into(this.f32751i);
                i = 0;
            }
            imageView.setVisibility(i);
            this.f32746d.setText(contentObj.getDetailMessage());
            TextView textView = this.f32747e;
            Button button = contentObj.getButton();
            textView.setText(button == null ? null : button.getText());
            Function0 twoInLineViewHolder$onBindViewHolder$1$click$1 = new TwoInLineViewHolder$onBindViewHolder$1$click$1(this, contentObj, contentObj);
            this.f32747e.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    TwoInLineViewHolder.m23140a(Function0.this, view);
                }
            });
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    TwoInLineViewHolder.m23141b(Function0.this, view);
                }
            });
            GlideUtils.loadRoundImage(this.itemView.getContext(), contentObj.getBgPicUrl(), 10, this.f32749g);
            TextView textView2 = this.f32748f;
            IconEntry icon = contentObj.getIcon();
            if (TextUtils.isEmpty(icon == null ? null : icon.getText())) {
                i3 = 8;
            }
            textView2.setVisibility(i3);
            TextView textView3 = this.f32748f;
            IconEntry icon2 = contentObj.getIcon();
            textView3.setText(icon2 == null ? null : icon2.getText());
            if (this.f32748f.getVisibility() == 0) {
                try {
                    IconEntry icon3 = contentObj.getIcon();
                    if (icon3 != null) {
                        str = icon3.getColor();
                    }
                    i2 = Color.parseColor(str);
                } catch (IllegalArgumentException unused) {
                    i2 = ContextCompat.getColor(this.itemView.getContext(), R.color.wallet_color_3FC790);
                }
                Drawable background = this.f32748f.getBackground();
                if (background != null) {
                    ((GradientDrawable) background).setColor(i2);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23140a(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$click");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m23141b(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$click");
        function0.invoke();
    }
}
