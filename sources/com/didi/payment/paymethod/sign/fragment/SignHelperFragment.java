package com.didi.payment.paymethod.sign.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.payment.paymethod.open.callback.SignCallback;
import com.didi.payment.paymethod.open.param.SignParam;
import com.didi.payment.paymethod.sign.channel.ISignChannel;
import com.didi.payment.paymethod.sign.channel.SignChannelFactory;

public class SignHelperFragment extends Fragment {

    /* renamed from: a */
    private static final String f31015a = "SignHelperFragment";

    /* renamed from: b */
    private static final String f31016b = "SIGN_PARAM";

    /* renamed from: c */
    private ISignChannel f31017c;

    /* renamed from: d */
    private SignCallback f31018d;

    /* renamed from: e */
    private boolean f31019e;

    public static void launch(FragmentActivity fragmentActivity, SignParam signParam, SignCallback signCallback) {
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(f31015a);
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
        }
        beginTransaction.add((Fragment) newInstance(signParam, signCallback), f31015a);
        beginTransaction.commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
    }

    public static SignHelperFragment newInstance(SignParam signParam, SignCallback signCallback) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(f31016b, signParam);
        SignHelperFragment signHelperFragment = new SignHelperFragment();
        signHelperFragment.setArguments(bundle);
        signHelperFragment.setCallback(signCallback);
        return signHelperFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        SignParam signParam = (SignParam) getArguments().getSerializable(f31016b);
        if (signParam != null) {
            ISignChannel createSignChannel = SignChannelFactory.createSignChannel(getContext(), signParam.channelId);
            this.f31017c = createSignChannel;
            createSignChannel.sign(this, signParam, this.f31018d);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.f31019e) {
            this.f31019e = false;
            this.f31017c.onActivityResume();
        }
    }

    public void onPause() {
        super.onPause();
        this.f31019e = true;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f31017c.release();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.f31017c.onActivityResult(i2);
    }

    public void setCallback(SignCallback signCallback) {
        this.f31018d = signCallback;
    }
}
