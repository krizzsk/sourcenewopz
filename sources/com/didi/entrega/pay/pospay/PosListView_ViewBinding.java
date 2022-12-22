package com.didi.entrega.pay.pospay;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.entrega.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;

public class PosListView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PosListView f21013a;

    public PosListView_ViewBinding(PosListView posListView, View view) {
        this.f21013a = posListView;
        posListView.mTitleView = (CustomerAppCompatTextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_pos_list_title, "field 'mTitleView'", CustomerAppCompatTextView.class);
        posListView.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.customer_rv_pos_list, "field 'mRecycleView'", RecyclerView.class);
        posListView.mBackView = Utils.findRequiredView(view, R.id.customer_iv_close, "field 'mBackView'");
    }

    public void unbind() {
        PosListView posListView = this.f21013a;
        if (posListView != null) {
            this.f21013a = null;
            posListView.mTitleView = null;
            posListView.mRecycleView = null;
            posListView.mBackView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
