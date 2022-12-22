package com.didiglobal.pay.paysecure.p204ui.view;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/ui/view/InputPwdListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bgLayout", "point", "Landroid/widget/ImageView;", "setStatus", "", "pwd", "", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.view.InputPwdListViewHolder */
/* compiled from: InputPwdView.kt */
public final class InputPwdListViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private final View f50458a;

    /* renamed from: b */
    private final ImageView f50459b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputPwdListViewHolder(View view) {
        super(view);
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        this.f50458a = view;
        View findViewById = view.findViewById(R.id.iv_point_input_pwd);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById(R.id.iv_point_input_pwd)");
        this.f50459b = (ImageView) findViewById;
    }

    public final void setStatus(char c) {
        if (c == ' ') {
            this.f50458a.setBackgroundResource(R.drawable.bg_item_input_pwd_nor);
            this.f50459b.setVisibility(8);
        } else if (c != '-') {
            this.f50458a.setBackgroundResource(R.drawable.bg_item_input_pwd_nor);
            this.f50459b.setVisibility(0);
            this.f50459b.setImageResource(R.drawable.ic_input_pwd_nor);
        } else {
            this.f50458a.setBackgroundResource(R.drawable.bg_item_input_pwd_err);
            this.f50459b.setVisibility(0);
            this.f50459b.setImageResource(R.drawable.ic_input_pwd_err);
        }
    }
}
