package com.example.uploadrule;

import android.content.Context;
import android.text.TextUtils;
import com.didiglobal.omegasdkadapter.EventWrapper;
import com.didiglobal.omegasdkadapter.OmegaAdapterInterceptorManager;
import com.example.uploadrule.utils.OURApolloUtil;
import com.example.uploadrule.utils.SPUtils;
import java.util.HashSet;
import java.util.Set;

public class OmegaUploadRuleInterceptor implements OmegaAdapterInterceptorManager.OmegaAdapterInterceptor {
    public static Set<String> set = new HashSet();
    private ParamsProvider paramsProvider;

    public interface ParamsProvider {
        Context getContext();

        String getOrderId();
    }

    public OmegaUploadRuleInterceptor(ParamsProvider paramsProvider2) {
        this.paramsProvider = paramsProvider2;
    }

    public EventWrapper intercept(EventWrapper eventWrapper) {
        ParamsProvider paramsProvider2;
        if (eventWrapper != null) {
            if (OURApolloUtil.rule0NotReport(eventWrapper)) {
                return null;
            }
            if (OURApolloUtil.rule1Upload(eventWrapper)) {
                return eventWrapper;
            }
            if (OURApolloUtil.rule2OrderOnce(eventWrapper) && (paramsProvider2 = this.paramsProvider) != null && !TextUtils.isEmpty(paramsProvider2.getOrderId()) && this.paramsProvider.getContext() != null) {
                Context context = this.paramsProvider.getContext();
                String orderId = this.paramsProvider.getOrderId();
                if (!TextUtils.isEmpty(orderId)) {
                    if (orderId.equals((String) SPUtils.get(context, getEventId(eventWrapper), ""))) {
                        return null;
                    }
                    SPUtils.put(context, getEventId(eventWrapper), orderId);
                    return eventWrapper;
                }
            }
            if (OURApolloUtil.rule3LifecycleOnce(eventWrapper)) {
                if (set.contains(getEventId(eventWrapper))) {
                    return null;
                }
                set.add(getEventId(eventWrapper));
                return eventWrapper;
            } else if (!OURApolloUtil.rule4HitNotReportErrorReport(eventWrapper) && !OURApolloUtil.rule5HitNotReport(eventWrapper)) {
                return eventWrapper;
            } else {
                return null;
            }
        }
        return eventWrapper;
    }

    public static String getEventId(EventWrapper eventWrapper) {
        if (eventWrapper == null) {
            return "";
        }
        String eventId = eventWrapper.getEventId();
        return (TextUtils.isEmpty(eventId) && eventWrapper.getEvent() != null) ? eventWrapper.getEvent().getEventId() : eventId;
    }
}
