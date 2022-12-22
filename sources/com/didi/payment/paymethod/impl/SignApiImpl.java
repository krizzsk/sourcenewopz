package com.didi.payment.paymethod.impl;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.payment.paymethod.open.ISignApi;
import com.didi.payment.paymethod.open.callback.Callback;
import com.didi.payment.paymethod.open.callback.SignCallback;
import com.didi.payment.paymethod.open.param.CancelSignParam;
import com.didi.payment.paymethod.open.param.QuerySignStatusParam;
import com.didi.payment.paymethod.open.param.SignParam;
import com.didi.payment.paymethod.sign.channel.SignChannelFactory;
import com.didi.payment.paymethod.sign.fragment.SignHelperFragment;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import java.util.HashMap;

public class SignApiImpl implements ISignApi {
    public void sign(Activity activity, SignParam signParam, SignCallback signCallback) {
        if (signCallback != null) {
            if (signParam.channelId == 182 || signParam.channelId == 183) {
                HashMap hashMap = new HashMap();
                hashMap.put("context", activity);
                hashMap.put(ParamConst.PARAM_BIND_TYPE, Integer.valueOf(signParam.bindType));
                SignChannelFactory.createSimpleSignChannel(signParam.channelId).sign(hashMap, signCallback);
            } else if (activity instanceof FragmentActivity) {
                SignHelperFragment.launch((FragmentActivity) activity, signParam, signCallback);
            }
        }
    }

    public void sign(Fragment fragment, SignParam signParam, SignCallback signCallback) {
        if (signCallback != null) {
            if (signParam.channelId == 182 || signParam.channelId == 183) {
                HashMap hashMap = new HashMap();
                hashMap.put("context", fragment);
                hashMap.put(ParamConst.PARAM_BIND_TYPE, Integer.valueOf(signParam.bindType));
                SignChannelFactory.createSimpleSignChannel(signParam.channelId).sign(hashMap, signCallback);
                return;
            }
            SignHelperFragment.launch(fragment.getActivity(), signParam, signCallback);
        }
    }

    public void cancelSign(Context context, CancelSignParam cancelSignParam, Callback callback) {
        if (callback != null) {
            if (cancelSignParam.channelId == 182 || cancelSignParam.channelId == 183) {
                HashMap hashMap = new HashMap();
                hashMap.put("context", context);
                hashMap.put("email", cancelSignParam.email);
                SignChannelFactory.createSimpleSignChannel(cancelSignParam.channelId).cancelSign(hashMap, callback);
                return;
            }
            SignChannelFactory.createSignChannel(context, cancelSignParam.channelId).cancelSign(cancelSignParam.cmbParam, callback);
        }
    }

    public void querySignStatus(Context context, QuerySignStatusParam querySignStatusParam, Callback callback) {
        if (callback != null) {
            if (querySignStatusParam.channelId == 182 || querySignStatusParam.channelId == 183) {
                HashMap hashMap = new HashMap();
                hashMap.put("context", context);
                SignChannelFactory.createSimpleSignChannel(querySignStatusParam.channelId).querySignStatus(hashMap, callback);
                return;
            }
            SignChannelFactory.createSignChannel(context, querySignStatusParam.channelId).querySignStatus(querySignStatusParam.cmbParam, callback);
        }
    }
}
