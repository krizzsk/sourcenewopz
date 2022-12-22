package com.didi.soda.home.component.policy;

import com.didi.app.nova.skeleton.mvp.IPresenter;
import com.didi.app.nova.skeleton.mvp.IView;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/home/component/policy/Contract;", "", "AbsPolicyUpdatePresenter", "AbsPolicyUpdateView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Contract.kt */
public interface Contract {

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/home/component/policy/Contract$AbsPolicyUpdatePresenter;", "Lcom/didi/app/nova/skeleton/mvp/IPresenter;", "Lcom/didi/soda/home/component/policy/Contract$AbsPolicyUpdateView;", "()V", "confirmPolicy", "", "showPolicyDetail", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsPolicyUpdatePresenter extends IPresenter<AbsPolicyUpdateView> {
        public abstract void confirmPolicy();

        public abstract void showPolicyDetail();
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/home/component/policy/Contract$AbsPolicyUpdateView;", "Lcom/didi/app/nova/skeleton/mvp/IView;", "Lcom/didi/soda/home/component/policy/Contract$AbsPolicyUpdatePresenter;", "()V", "updatePolicyContent", "", "defaultNote", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Contract.kt */
    public static abstract class AbsPolicyUpdateView extends IView<AbsPolicyUpdatePresenter> {
        public abstract void updatePolicyContent(String str);
    }
}
