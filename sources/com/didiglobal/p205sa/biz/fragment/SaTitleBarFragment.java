package com.didiglobal.p205sa.biz.fragment;

import com.didi.sdk.events.RemotionalMessageEvent;
import com.didi.sdk.home.view.HomeNewTitleBarFragment;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014¨\u0006\f"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/fragment/SaTitleBarFragment;", "Lcom/didi/sdk/home/view/HomeNewTitleBarFragment;", "()V", "emotionMessageShow", "", "getLayoutId", "", "needHandleNetWorkState", "", "noNeedHandleRemotionMessage", "event", "Lcom/didi/sdk/events/RemotionalMessageEvent;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.fragment.SaTitleBarFragment */
/* compiled from: SaTitleBarFragment.kt */
public final class SaTitleBarFragment extends HomeNewTitleBarFragment {
    public int getLayoutId() {
        return R.layout.sa_fragment_title_bar;
    }

    public boolean needHandleNetWorkState() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean noNeedHandleRemotionMessage(RemotionalMessageEvent remotionalMessageEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void emotionMessageShow() {
        super.emotionMessageShow();
        OmegaSDKAdapter.trackEvent("ibt_gp_welcome_banner_sw");
    }
}
