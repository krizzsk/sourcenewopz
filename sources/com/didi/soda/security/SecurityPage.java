package com.didi.soda.security;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.BindView;
import com.didi.soda.customer.base.pages.CustomerPage;
import com.didi.soda.pay.IPayMethodCallback;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.annotations.Route;
import com.taxis99.R;
import org.json.JSONException;
import org.json.JSONObject;

@Route({"securityPage"})
public class SecurityPage extends CustomerPage implements IPayMethodCallback {

    /* renamed from: a */
    private SecurityComponent f43811a;
    @BindView(18203)
    FrameLayout mContainer;

    public SecurityPage() {
        DiRouter.registerHub("securityPage", this);
    }

    public void onCreate(View view) {
        super.onCreate(view);
        SecurityComponent securityComponent = new SecurityComponent(this.mContainer);
        this.f43811a = securityComponent;
        addComponent(securityComponent);
    }

    public View onInflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_page_security_container, viewGroup, false);
    }

    public void onPageResult(Bundle bundle) {
        super.onPageResult(bundle);
        if (bundle != null) {
            try {
                if (new JSONObject(bundle.getString("risk_auth_result")).optInt("status") == 0) {
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
