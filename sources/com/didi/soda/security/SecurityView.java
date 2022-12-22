package com.didi.soda.security;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import com.didi.app.nova.support.view.recyclerview.view.INovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.security.Contract;
import com.didi.soda.security.FacebookBinder;
import com.facebook.internal.CallbackManagerImpl;
import com.taxis99.R;

public class SecurityView extends Contract.AbsSecurityView {

    /* renamed from: a */
    private FacebookBinder f43815a;
    @BindView(18382)
    ImageView mClose;
    @BindView(18676)
    NovaRecyclerView mRecyclerView;
    @BindView(19109)
    TextView mSecurityCaution;

    public void onActivityResult(int i, int i2, Intent intent) {
        this.f43815a.onActivityResult(i, i2, intent);
    }

    public void onCreate() {
        super.onCreate();
        this.mClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SecurityView.this.getScopeContext().getNavigator().finish();
            }
        });
        this.mSecurityCaution.setText(getResources().getString(R.string.customer_security_caution, new Object[]{"99"}));
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_security_container, viewGroup, true);
    }

    /* access modifiers changed from: protected */
    public INovaRecyclerView generateNovaRecyclerView() {
        return this.mRecyclerView;
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        FacebookBinder facebookBinder = new FacebookBinder(getScopeContext(), (Activity) getContext(), new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(SecurityView.this.getContext(), FacebookMiddleActivity.class);
                if (GlobalContext.isEmbed()) {
                    GlobalContext.getFragment().startActivityForResult(intent, CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
                } else {
                    ((FragmentActivity) GlobalContext.getContext()).startActivityForResult(intent, CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode());
                }
            }
        }, new FacebookBinder.Callback() {
            public void disable(int i) {
                ((Contract.AbsSecurityPresenter) SecurityView.this.getPresenter()).disable(i);
            }

            public boolean hasEnable() {
                return ((Contract.AbsSecurityPresenter) SecurityView.this.getPresenter()).hasEnable();
            }
        });
        this.f43815a = facebookBinder;
        registerBinder(facebookBinder);
        registerBinder(new CpfBinder(new View.OnClickListener() {
            public void onClick(View view) {
                ((Contract.AbsSecurityPresenter) SecurityView.this.getPresenter()).verifyCpf();
            }
        }));
        registerBinder(new CurpBinder(new View.OnClickListener() {
            public void onClick(View view) {
                ((Contract.AbsSecurityPresenter) SecurityView.this.getPresenter()).verifyCurp();
            }
        }));
        registerBinder(new CreditCardBinder(new View.OnClickListener() {
            public void onClick(View view) {
                ((Contract.AbsSecurityPresenter) SecurityView.this.getPresenter()).bindCard();
            }
        }));
    }
}
