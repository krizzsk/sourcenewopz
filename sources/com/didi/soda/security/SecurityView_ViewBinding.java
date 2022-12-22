package com.didi.soda.security;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.taxis99.R;

public class SecurityView_ViewBinding implements Unbinder {

    /* renamed from: a */
    private SecurityView f43816a;

    public SecurityView_ViewBinding(SecurityView securityView, View view) {
        this.f43816a = securityView;
        securityView.mRecyclerView = (NovaRecyclerView) Utils.findRequiredViewAsType(view, R.id.customer_rv_security_method, "field 'mRecyclerView'", NovaRecyclerView.class);
        securityView.mClose = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_close, "field 'mClose'", ImageView.class);
        securityView.mSecurityCaution = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_tv_security_method_caution, "field 'mSecurityCaution'", TextView.class);
    }

    public void unbind() {
        SecurityView securityView = this.f43816a;
        if (securityView != null) {
            this.f43816a = null;
            securityView.mRecyclerView = null;
            securityView.mClose = null;
            securityView.mSecurityCaution = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
