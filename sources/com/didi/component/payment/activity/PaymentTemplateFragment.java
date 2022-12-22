package com.didi.component.payment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.UniPayManager;
import com.didi.component.common.util.GLog;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.payment.presenter.impl.GlobalBridgePaymentPresenter;
import com.didi.component.payment.proxy.ViewProxy;
import com.didi.sdk.webview.PassengerProxyWebActivity;
import com.didi.unifiedPay.component.IViewCallback;
import global.didi.pay.IGlobalPayView;
import global.didi.pay.presenter.GlobalAbsPaymentPresenter;

public class PaymentTemplateFragment extends Fragment implements IViewCallback {
    private BaseEventPublisher.OnEventListener<String> payEventListener = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            if (TextUtils.equals(str, BaseEventKeys.Pay.CATEGORY)) {
                GLog.m7965d("PaymentTemplateFragment", "event " + str2);
            }
        }
    };
    GlobalAbsPaymentPresenter paymentPresenter;

    public void closeView() {
    }

    public int requestCode(int i) {
        return i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Pay.CATEGORY, this.payEventListener);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        GlobalAbsPaymentPresenter globalAbsPaymentPresenter = this.paymentPresenter;
        if (globalAbsPaymentPresenter != null) {
            globalAbsPaymentPresenter.onAdd(getArguments());
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ViewProxy viewProxy = new ViewProxy(getContext());
        IGlobalPayView realView = viewProxy.getRealView();
        Bundle arguments = getArguments();
        String string = arguments.getString("BUNDLE_KEY_SID");
        String string2 = arguments.getString("order_id");
        GlobalBridgePaymentPresenter globalBridgePaymentPresenter = new GlobalBridgePaymentPresenter(getActivity(), getFragmentManager(), string, arguments.getString("product_id"), string2, this);
        this.paymentPresenter = globalBridgePaymentPresenter;
        globalBridgePaymentPresenter.setFragment(this);
        realView.setListener(this.paymentPresenter);
        this.paymentPresenter.setIView(realView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        relativeLayout.addView(viewProxy.getView(), layoutParams);
        return relativeLayout;
    }

    public void onResume() {
        super.onResume();
        GlobalAbsPaymentPresenter globalAbsPaymentPresenter = this.paymentPresenter;
        if (globalAbsPaymentPresenter != null) {
            globalAbsPaymentPresenter.onPageResume();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        GlobalAbsPaymentPresenter globalAbsPaymentPresenter = this.paymentPresenter;
        if (globalAbsPaymentPresenter != null) {
            globalAbsPaymentPresenter.onRemove();
        }
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Pay.CATEGORY, this.payEventListener);
    }

    public void onStop() {
        super.onStop();
        GlobalAbsPaymentPresenter globalAbsPaymentPresenter = this.paymentPresenter;
        if (globalAbsPaymentPresenter != null) {
            globalAbsPaymentPresenter.onPageStop();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        GlobalAbsPaymentPresenter globalAbsPaymentPresenter = this.paymentPresenter;
        if (globalAbsPaymentPresenter != null) {
            globalAbsPaymentPresenter.onActivityResult(i, i2, intent);
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void callStartActivityForResult(Intent intent, int i) {
        if (intent != null && intent.getClass() == null) {
            intent.setClass(getContext(), PassengerProxyWebActivity.class);
        }
        intent.setPackage(UniPayManager.getPackageName(getContext()));
        startActivityForResult(intent, i);
    }

    public void callStartActivity(Intent intent) {
        if (intent != null && intent.getClass() == null) {
            intent.setClass(getContext(), PassengerProxyWebActivity.class);
        }
        intent.setPackage(UniPayManager.getPackageName(getContext()));
        startActivity(intent);
    }
}
