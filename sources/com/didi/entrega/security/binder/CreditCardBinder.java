package com.didi.entrega.security.binder;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.entrega.security.model.SecurityMethodModel;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0014B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001a\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/entrega/security/binder/CreditCardBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/entrega/security/model/SecurityMethodModel;", "Lcom/didi/entrega/security/binder/CreditCardBinder$ViewHolder;", "mClickListener", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "bind", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "extraCanBindCondition", "", "ViewHolder", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreditCardBinder.kt */
public final class CreditCardBinder extends ItemBinder<SecurityMethodModel, ViewHolder> {

    /* renamed from: a */
    private final Function0<Unit> f21051a;

    public Class<SecurityMethodModel> bindDataType() {
        return SecurityMethodModel.class;
    }

    public CreditCardBinder(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "mClickListener");
        this.f21051a = function0;
    }

    public void bind(ViewHolder viewHolder, SecurityMethodModel securityMethodModel) {
        Intrinsics.checkNotNullParameter(securityMethodModel, "item");
        if (viewHolder != null) {
            viewHolder.getMTitle().setCompoundDrawablesWithIntrinsicBounds(viewHolder.itemView.getResources().getDrawable(R.drawable.entrega_customer_selector_credit_card), (Drawable) null, (Drawable) null, (Drawable) null);
            viewHolder.getMTitle().setText(viewHolder.itemView.getContext().getResources().getString(R.string.customer_security_title_creditcard));
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    CreditCardBinder.m15436a(CreditCardBinder.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15436a(CreditCardBinder creditCardBinder, View view) {
        Intrinsics.checkNotNullParameter(creditCardBinder, "this$0");
        creditCardBinder.f21051a.invoke();
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new ViewHolder(layoutInflater.inflate(R.layout.entrega_customer_binder_security_item, viewGroup, false));
    }

    public boolean extraCanBindCondition(SecurityMethodModel securityMethodModel) {
        Intrinsics.checkNotNullParameter(securityMethodModel, "item");
        return 41056 == securityMethodModel.getCode();
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/entrega/security/binder/CreditCardBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/entrega/security/model/SecurityMethodModel;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mCaution", "Landroid/widget/TextView;", "mTitle", "getMTitle", "()Landroid/widget/TextView;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CreditCardBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<SecurityMethodModel> {
        private final TextView mCaution;
        private final TextView mTitle;

        public ViewHolder(View view) {
            super(view);
            Object findViewById = findViewById(R.id.customer_tv_security_method_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<TextView>(R…tv_security_method_title)");
            this.mTitle = (TextView) findViewById;
            Object findViewById2 = findViewById(R.id.customer_tv_security_method_caution);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<TextView>(R…_security_method_caution)");
            this.mCaution = (TextView) findViewById2;
        }

        public final TextView getMTitle() {
            return this.mTitle;
        }
    }
}
