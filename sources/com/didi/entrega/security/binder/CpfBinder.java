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

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0015\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/entrega/security/binder/CpfBinder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemBinder;", "Lcom/didi/entrega/security/model/SecurityMethodModel;", "Lcom/didi/entrega/security/binder/CpfBinder$ViewHolder;", "mClickListener", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "mViewHolder", "bind", "holder", "item", "bindDataType", "Ljava/lang/Class;", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "extraCanBindCondition", "", "ViewHolder", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CpfBinder.kt */
public final class CpfBinder extends ItemBinder<SecurityMethodModel, ViewHolder> {

    /* renamed from: a */
    private final Function0<Unit> f21049a;

    /* renamed from: b */
    private ViewHolder f21050b;

    public Class<SecurityMethodModel> bindDataType() {
        return SecurityMethodModel.class;
    }

    public CpfBinder(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "mClickListener");
        this.f21049a = function0;
    }

    public void bind(ViewHolder viewHolder, SecurityMethodModel securityMethodModel) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(securityMethodModel, "item");
        viewHolder.getMTitle().setCompoundDrawablesWithIntrinsicBounds(viewHolder.itemView.getResources().getDrawable(R.drawable.entrega_customer_selector_curp), (Drawable) null, (Drawable) null, (Drawable) null);
        viewHolder.getMTitle().setText(viewHolder.itemView.getContext().getResources().getString(R.string.customer_security_title_cpf));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CpfBinder.m15435a(CpfBinder.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15435a(CpfBinder cpfBinder, View view) {
        Intrinsics.checkNotNullParameter(cpfBinder, "this$0");
        cpfBinder.f21049a.invoke();
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ViewHolder viewHolder = new ViewHolder(layoutInflater.inflate(R.layout.entrega_customer_binder_security_item, viewGroup, false));
        this.f21050b = viewHolder;
        Intrinsics.checkNotNull(viewHolder);
        return viewHolder;
    }

    public boolean extraCanBindCondition(SecurityMethodModel securityMethodModel) {
        Intrinsics.checkNotNullParameter(securityMethodModel, "item");
        return 41059 == securityMethodModel.getCode();
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, mo175978d2 = {"Lcom/didi/entrega/security/binder/CpfBinder$ViewHolder;", "Lcom/didi/app/nova/support/view/recyclerview/binder/ItemViewHolder;", "Lcom/didi/entrega/security/model/SecurityMethodModel;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mCaution", "Landroid/widget/TextView;", "mTitle", "getMTitle", "()Landroid/widget/TextView;", "setMTitle", "(Landroid/widget/TextView;)V", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CpfBinder.kt */
    public static final class ViewHolder extends ItemViewHolder<SecurityMethodModel> {
        private final TextView mCaution;
        private TextView mTitle;

        public ViewHolder(View view) {
            super(view);
            Object findViewById = findViewById(R.id.customer_tv_security_method_title);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.custom…tv_security_method_title)");
            this.mTitle = (TextView) findViewById;
            Object findViewById2 = findViewById(R.id.customer_tv_security_method_caution);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.custom…_security_method_caution)");
            this.mCaution = (TextView) findViewById2;
        }

        public final TextView getMTitle() {
            return this.mTitle;
        }

        public final void setMTitle(TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mTitle = textView;
        }
    }
}
