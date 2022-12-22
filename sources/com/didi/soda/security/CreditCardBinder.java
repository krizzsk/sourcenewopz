package com.didi.soda.security;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.bill.BillOmegaHelper;
import com.taxis99.R;

public class CreditCardBinder extends ItemBinder<SecurityMethodModel, ViewHolder> {

    /* renamed from: a */
    private ViewHolder f43797a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View.OnClickListener f43798b;

    public CreditCardBinder(View.OnClickListener onClickListener) {
        this.f43798b = onClickListener;
    }

    public void bind(ViewHolder viewHolder, final SecurityMethodModel securityMethodModel) {
        viewHolder.mTitle.setCompoundDrawablesWithIntrinsicBounds(viewHolder.itemView.getResources().getDrawable(R.drawable.customer_selector_credit_card), (Drawable) null, (Drawable) null, (Drawable) null);
        viewHolder.mTitle.setText(viewHolder.itemView.getContext().getResources().getString(R.string.customer_security_title_creditcard));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (CreditCardBinder.this.f43798b != null) {
                    CreditCardBinder.this.f43798b.onClick(view);
                }
                BillOmegaHelper.Companion.clickSecurityPage(securityMethodModel.cid, Integer.valueOf(securityMethodModel.code));
            }
        });
    }

    public Class<SecurityMethodModel> bindDataType() {
        return SecurityMethodModel.class;
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(layoutInflater.inflate(R.layout.customer_binder_security_item, viewGroup, false));
        this.f43797a = viewHolder;
        return viewHolder;
    }

    public boolean extraCanBindCondition(SecurityMethodModel securityMethodModel) {
        return 41056 == securityMethodModel.code;
    }

    public static class ViewHolder extends ItemViewHolder<SecurityMethodModel> {
        private TextView mCaution = ((TextView) findViewById(R.id.customer_tv_security_method_caution));
        /* access modifiers changed from: private */
        public TextView mTitle = ((TextView) findViewById(R.id.customer_tv_security_method_title));

        public ViewHolder(View view) {
            super(view);
        }
    }
}
