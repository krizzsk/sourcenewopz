package com.didi.soda.pay.pospay;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.taxis99.R;

public class PosListView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private PosListView f43642a;

    public PosListView_ViewBinding(PosListView posListView, View view) {
        this.f43642a = posListView;
        posListView.mTitleView = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_pos_list_title, "field 'mTitleView'", TextView.class);
        posListView.mRecycleView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.customer_rv_pos_list, "field 'mRecycleView'", RecyclerView.class);
        posListView.mBackView = Utils.findRequiredView(view, R.id.customer_iv_close, "field 'mBackView'");
    }

    public void unbind() {
        PosListView posListView = this.f43642a;
        if (posListView != null) {
            this.f43642a = null;
            posListView.mTitleView = null;
            posListView.mRecycleView = null;
            posListView.mBackView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
