package com.didi.sdk.debug.language;

import android.content.Context;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000eH\u0007J\u0006\u0010\u000f\u001a\u00020\tJ\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/sdk/debug/language/LanguageDebugPresenter;", "", "viewProxy", "Lcom/didi/sdk/debug/language/ILanguageViewProxy;", "(Lcom/didi/sdk/debug/language/ILanguageViewProxy;)V", "currentSelectLanguage", "", "iLanguageViewProxy", "init", "", "onDestroy", "onReceive", "event", "Lcom/didi/sdk/debug/language/AreaSelectEvent;", "Lcom/didi/sdk/debug/language/LanguageSelectEvent;", "reset", "showDialog", "context", "Landroid/content/Context;", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: LanguageDebugPresenter.kt */
public final class LanguageDebugPresenter {

    /* renamed from: a */
    private String f35798a = "";

    /* renamed from: b */
    private ILanguageViewProxy f35799b;

    public LanguageDebugPresenter(ILanguageViewProxy iLanguageViewProxy) {
        Intrinsics.checkNotNullParameter(iLanguageViewProxy, "viewProxy");
        this.f35799b = iLanguageViewProxy;
    }

    public final void init() {
        EventBus.getDefault().register(this);
        ILanguageViewProxy iLanguageViewProxy = this.f35799b;
        if (iLanguageViewProxy != null) {
            iLanguageViewProxy.updateFragment(true);
        }
        ILanguageViewProxy iLanguageViewProxy2 = this.f35799b;
        if (iLanguageViewProxy2 != null) {
            iLanguageViewProxy2.updateTitle("语言");
        }
    }

    public final void onDestroy() {
        EventBus.getDefault().unregister(this);
    }

    public final void reset() {
        Context context;
        ILanguageViewProxy iLanguageViewProxy = this.f35799b;
        if (iLanguageViewProxy != null && (context = iLanguageViewProxy.getContext()) != null) {
            LanguageDebugUtil.INSTANCE.putArea(context, "");
            LanguageDebugUtil.INSTANCE.putLanguage(context, "");
            m25348a(context);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReceive(LanguageSelectEvent languageSelectEvent) {
        Intrinsics.checkNotNullParameter(languageSelectEvent, "event");
        this.f35798a = languageSelectEvent.getSelect();
        ILanguageViewProxy iLanguageViewProxy = this.f35799b;
        if (iLanguageViewProxy != null) {
            iLanguageViewProxy.updateFragment(false);
        }
        ILanguageViewProxy iLanguageViewProxy2 = this.f35799b;
        if (iLanguageViewProxy2 != null) {
            iLanguageViewProxy2.updateTitle("地区");
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReceive(AreaSelectEvent areaSelectEvent) {
        Context context;
        Intrinsics.checkNotNullParameter(areaSelectEvent, "event");
        ILanguageViewProxy iLanguageViewProxy = this.f35799b;
        if (iLanguageViewProxy != null && (context = iLanguageViewProxy.getContext()) != null) {
            LanguageDebugUtil.INSTANCE.putArea(context, areaSelectEvent.getSelect());
            LanguageDebugUtil.INSTANCE.putLanguage(context, this.f35798a);
            m25348a(context);
        }
    }

    /* renamed from: a */
    private final void m25348a(Context context) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1("重启app生效", new LEGOBtnTextAndCallback("好的", new LanguageDebugPresenter$showDialog$model$1(objectRef, context)));
        lEGODrawerModel1.setmBackPressedEnabled(false);
        lEGODrawerModel1.setClickOutsideCanCancel(false);
        objectRef.element = LEGOUICreator.showDrawerTemplate(context, lEGODrawerModel1);
    }
}
