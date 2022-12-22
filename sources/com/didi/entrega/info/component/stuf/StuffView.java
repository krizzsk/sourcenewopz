package com.didi.entrega.info.component.stuf;

import android.view.View;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.INovaLayoutManager;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaLinearLayoutManager;
import com.didi.entrega.customer.foundation.util.KeyboardUtils;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.customer.widget.titlebar.OnBackClickListener;
import com.didi.entrega.customer.widget.titlebar.TitleBarView;
import com.didi.entrega.info.binder.StufRemarkBinder;
import com.didi.entrega.info.binder.StufRuleBinder;
import com.didi.entrega.info.binder.StufTypeBinder;
import com.didi.entrega.info.component.StuffConstract;
import com.didi.entrega.info.helper.InfoDataHelper;
import com.didi.entrega.info.model.StuffTypeModel;
import com.didi.entrega.info.repo.InfoComponentRepo;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/entrega/info/component/stuf/StuffView;", "Lcom/didi/entrega/info/component/StuffConstract$AbsCommonStuffView;", "()V", "repo", "Lcom/didi/entrega/info/repo/InfoComponentRepo;", "kotlin.jvm.PlatformType", "getRepo", "()Lcom/didi/entrega/info/repo/InfoComponentRepo;", "typeBinder", "Lcom/didi/entrega/info/binder/StufTypeBinder;", "getTypeBinder", "()Lcom/didi/entrega/info/binder/StufTypeBinder;", "setTypeBinder", "(Lcom/didi/entrega/info/binder/StufTypeBinder;)V", "generateNovaLayoutManager", "Lcom/didi/app/nova/support/view/recyclerview/view/layoutmanager/INovaLayoutManager;", "initItemBinders", "", "initItemData", "model", "Lcom/didi/entrega/info/model/StuffTypeModel;", "onCreate", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: StuffView.kt */
public final class StuffView extends StuffConstract.AbsCommonStuffView {

    /* renamed from: a */
    private final InfoComponentRepo f20788a = ((InfoComponentRepo) RepoFactory.getRepo(InfoComponentRepo.class));

    /* renamed from: b */
    private StufTypeBinder f20789b;

    public final InfoComponentRepo getRepo() {
        return this.f20788a;
    }

    public final StufTypeBinder getTypeBinder() {
        return this.f20789b;
    }

    public final void setTypeBinder(StufTypeBinder stufTypeBinder) {
        this.f20789b = stufTypeBinder;
    }

    public void onCreate() {
        super.onCreate();
        ((TitleBarView) getRootView().findViewById(R.id.title_bar)).setOnBackClickListener(new OnBackClickListener() {
            public final void onBackClick(View view) {
                StuffView.m15214a(StuffView.this, view);
            }
        });
        this.f20788a.subscribe(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                StuffView.m15215a(StuffView.this, (String) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15214a(StuffView stuffView, View view) {
        Intrinsics.checkNotNullParameter(stuffView, "this$0");
        KeyboardUtils.hideSoftInput(stuffView.getContext(), (View) null);
        stuffView.getScopeContext().getNavigator().finish();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006a, code lost:
        if (r0 != false) goto L_0x006e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0040  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m15215a(com.didi.entrega.info.component.stuf.StuffView r5, java.lang.String r6) {
        /*
            java.lang.String r6 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            com.didi.entrega.info.repo.InfoComponentRepo r6 = r5.getRepo()
            com.didi.entrega.info.model.StuffTypeModel r6 = r6.getStuffTypeModel()
            r0 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
            r2 = 0
            if (r6 != 0) goto L_0x0018
        L_0x0016:
            r6 = 1
            goto L_0x0035
        L_0x0018:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$CateInfoTag r6 = r6.getStuffEntityData()
            if (r6 != 0) goto L_0x0020
            r6 = 0
            goto L_0x0028
        L_0x0020:
            java.lang.Boolean r6 = r6.getRequired()
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
        L_0x0028:
            if (r6 == 0) goto L_0x0016
            com.didi.entrega.info.repo.InfoComponentRepo r6 = r5.getRepo()
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$CateInfosItem r6 = r6.getSelectedItem()
            if (r6 != 0) goto L_0x0016
            r6 = 0
        L_0x0035:
            com.didi.entrega.info.repo.InfoComponentRepo r3 = r5.getRepo()
            com.didi.entrega.info.model.StuffRemarkModel r3 = r3.getStuffRemarkModel()
            if (r3 != 0) goto L_0x0040
            goto L_0x006f
        L_0x0040:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Remark r4 = r3.getStuffEntityData()
            if (r4 != 0) goto L_0x0048
            r1 = 0
            goto L_0x0050
        L_0x0048:
            java.lang.Boolean r4 = r4.getRequired()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r1)
        L_0x0050:
            if (r1 == 0) goto L_0x006d
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Remark r1 = r3.getStuffEntityData()
            if (r1 != 0) goto L_0x005a
            r1 = 0
            goto L_0x005e
        L_0x005a:
            java.lang.String r1 = r1.getContent()
        L_0x005e:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x006a
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r0 = 0
        L_0x006a:
            if (r0 == 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r2 = r6
        L_0x006e:
            r6 = r2
        L_0x006f:
            android.view.View r5 = r5.getRootView()
            r0 = 2131427856(0x7f0b0210, float:1.847734E38)
            android.view.View r5 = r5.findViewById(r0)
            com.didi.rfusion.widget.button.RFMainButton r5 = (com.didi.rfusion.widget.button.RFMainButton) r5
            r5.setEnabled(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.component.stuf.StuffView.m15215a(com.didi.entrega.info.component.stuf.StuffView, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public INovaLayoutManager generateNovaLayoutManager() {
        return new NovaLinearLayoutManager(getContext());
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        super.initItemBinders();
        StufTypeBinder stufTypeBinder = new StufTypeBinder();
        stufTypeBinder.setScopeContext(getScopeContext());
        Unit unit = Unit.INSTANCE;
        this.f20789b = stufTypeBinder;
        registerBinder(stufTypeBinder);
        StufRemarkBinder stufRemarkBinder = new StufRemarkBinder();
        stufRemarkBinder.setClickListener(new StuffView$initItemBinders$2$1(this));
        Unit unit2 = Unit.INSTANCE;
        registerBinder(stufRemarkBinder);
        StufRuleBinder stufRuleBinder = new StufRuleBinder();
        stufRuleBinder.setScopContext(getScopeContext());
        Unit unit3 = Unit.INSTANCE;
        registerBinder(stufRuleBinder);
    }

    public void initItemData(StuffTypeModel stuffTypeModel) {
        StufTypeBinder typeBinder;
        if (stuffTypeModel != null && (typeBinder = getTypeBinder()) != null) {
            typeBinder.setData(InfoDataHelper.INSTANCE.getStuffTypeItemDataList(stuffTypeModel));
        }
    }
}
