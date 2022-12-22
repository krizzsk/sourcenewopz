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

public class CpfBinder extends ItemBinder<SecurityMethodModel, ViewHolder> {

    /* renamed from: a */
    private ViewHolder f43795a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View.OnClickListener f43796b;

    public CpfBinder(View.OnClickListener onClickListener) {
        this.f43796b = onClickListener;
    }

    public void bind(ViewHolder viewHolder, final SecurityMethodModel securityMethodModel) {
        viewHolder.mTitle.setCompoundDrawablesWithIntrinsicBounds(viewHolder.itemView.getResources().getDrawable(R.drawable.customer_selector_curp), (Drawable) null, (Drawable) null, (Drawable) null);
        viewHolder.mTitle.setText(viewHolder.itemView.getContext().getResources().getString(R.string.customer_security_title_cpf));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (CpfBinder.this.f43796b != null) {
                    CpfBinder.this.f43796b.onClick(view);
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
        this.f43795a = viewHolder;
        return viewHolder;
    }

    public boolean extraCanBindCondition(SecurityMethodModel securityMethodModel) {
        return 41059 == securityMethodModel.code;
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
