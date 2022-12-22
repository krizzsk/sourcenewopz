package com.didi.soda.home.component.category;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.rfusion.widget.floating.IRFFloatingExpand;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.binder.abnormal.topgun.TopGunAbnormalRvModel;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CategoryEntity;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.widget.abnormal.topgun.TopGunAbnormalFactory;
import com.didi.soda.home.binder.model.AllCategoryItemModel;
import com.didi.soda.home.component.category.Contract;
import com.didi.soda.home.manager.RouterCloseRepo;
import com.didi.soda.home.topgun.manager.HomeOmegaHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0016J\b\u0010\u0013\u001a\u00020\nH\u0016J\b\u0010\u0014\u001a\u00020\rH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/soda/home/component/category/AllCategoryPresenter;", "Lcom/didi/soda/home/component/category/Contract$AbsAllCategoryPresenter;", "Lcom/didi/rfusion/widget/floating/IRFFloatingExpand;", "()V", "mCategoryListManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "mColNum", "", "mComponentLogicUnit", "Lcom/didi/soda/customer/base/binder/ComponentLogicUnit;", "getColumnCount", "handleLogicRepo", "", "allCategoryItemItemModel", "Lcom/didi/soda/home/binder/model/AllCategoryItemModel;", "initDataManagers", "initParams", "onCreate", "provideComponentLogicUnit", "showAbnormalView", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AllCategoryPresenter.kt */
public final class AllCategoryPresenter extends Contract.AbsAllCategoryPresenter implements IRFFloatingExpand {

    /* renamed from: a */
    private ComponentLogicUnit f42556a;

    /* renamed from: b */
    private ChildDataListManager<RecyclerModel> f42557b;

    /* renamed from: c */
    private int f42558c = 2;

    public /* synthetic */ void dismiss(ScopeContext scopeContext) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext);
    }

    public /* synthetic */ void dismiss(ScopeContext scopeContext, Bundle bundle) {
        IRFFloatingExpand.CC.$default$dismiss(this, scopeContext, bundle);
    }

    public /* synthetic */ Bundle getFloatingArgs(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getFloatingArgs(this, scopeContext);
    }

    public /* synthetic */ RFFloatingNavBar getNavBar(ScopeContext scopeContext) {
        return IRFFloatingExpand.CC.$default$getNavBar(this, scopeContext);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, page);
    }

    public /* synthetic */ void pushOuter(ScopeContext scopeContext, Dialog dialog, String str) {
        IRFFloatingExpand.CC.$default$pushOuter(this, scopeContext, dialog, str);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page);
    }

    public /* synthetic */ void pushPage(ScopeContext scopeContext, Page page, int i) {
        IRFFloatingExpand.CC.$default$pushPage(this, scopeContext, page, i);
    }

    public /* synthetic */ void setGestureEnable(ScopeContext scopeContext, boolean z) {
        IRFFloatingExpand.CC.$default$setGestureEnable(this, scopeContext, z);
    }

    public int getColumnCount() {
        return this.f42558c;
    }

    public void onCreate() {
        super.onCreate();
        m29995a();
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [kotlin.Unit] */
    /* JADX WARNING: type inference failed for: r1v4, types: [kotlin.Unit] */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v12, types: [kotlin.Unit] */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r0 = r0.getBundle();
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m29995a() {
        /*
            r6 = this;
            com.didi.app.nova.skeleton.ScopeContext r0 = r6.getScopeContext()
            r1 = 0
            if (r0 != 0) goto L_0x0009
        L_0x0007:
            r0 = r1
            goto L_0x0017
        L_0x0009:
            android.os.Bundle r0 = r0.getBundle()
            if (r0 != 0) goto L_0x0010
            goto L_0x0007
        L_0x0010:
            java.lang.String r2 = "recid"
            java.lang.String r0 = r0.getString(r2)
        L_0x0017:
            com.didi.app.nova.skeleton.ScopeContext r2 = r6.getScopeContext()
            java.lang.String r3 = "allCategoryPageOpenSource"
            if (r2 != 0) goto L_0x0021
        L_0x001f:
            r2 = r1
            goto L_0x002c
        L_0x0021:
            android.os.Bundle r2 = r2.getBundle()
            if (r2 != 0) goto L_0x0028
            goto L_0x001f
        L_0x0028:
            java.lang.String r2 = r2.getString(r3)
        L_0x002c:
            r6.setFromPage(r2)
            java.lang.String r2 = r6.getFromPage()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x005a
            com.didi.app.nova.skeleton.ScopeContext r2 = r6.getScopeContext()
            if (r2 != 0) goto L_0x0043
        L_0x0041:
            r2 = r1
            goto L_0x0057
        L_0x0043:
            android.os.Bundle r2 = r2.getBundle()
            if (r2 != 0) goto L_0x004a
            goto L_0x0041
        L_0x004a:
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r4 = "(this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.String r2 = r2.getString(r3)
        L_0x0057:
            r6.setFromPage(r2)
        L_0x005a:
            com.didi.app.nova.skeleton.ScopeContext r2 = r6.getScopeContext()
            if (r2 != 0) goto L_0x0062
            goto L_0x00e6
        L_0x0062:
            android.os.Bundle r2 = r2.getBundle()
            if (r2 != 0) goto L_0x006a
            goto L_0x00e6
        L_0x006a:
            java.lang.String r3 = "subitems"
            java.lang.String r2 = r2.getString(r3)
            if (r2 != 0) goto L_0x0075
            goto L_0x00e6
        L_0x0075:
            java.lang.Class<com.didi.soda.customer.foundation.rpc.entity.topgun.AllCategoryEntity> r3 = com.didi.soda.customer.foundation.rpc.entity.topgun.AllCategoryEntity.class
            java.lang.Object r2 = com.didi.soda.customer.foundation.util.GsonUtil.fromJson((java.lang.String) r2, r3)     // Catch:{ Exception -> 0x00dc }
            com.didi.soda.customer.foundation.rpc.entity.topgun.AllCategoryEntity r2 = (com.didi.soda.customer.foundation.rpc.entity.topgun.AllCategoryEntity) r2     // Catch:{ Exception -> 0x00dc }
            if (r2 != 0) goto L_0x0081
            goto L_0x00e6
        L_0x0081:
            int r3 = r2.getColNum()     // Catch:{ Exception -> 0x00dc }
            if (r3 <= 0) goto L_0x008d
            int r3 = r2.getColNum()     // Catch:{ Exception -> 0x00dc }
            r6.f42558c = r3     // Catch:{ Exception -> 0x00dc }
        L_0x008d:
            java.util.List r2 = r2.getItems()     // Catch:{ Exception -> 0x00dc }
            if (r2 != 0) goto L_0x0094
            goto L_0x00d1
        L_0x0094:
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ Exception -> 0x00dc }
            boolean r3 = r3.isEmpty()     // Catch:{ Exception -> 0x00dc }
            if (r3 == 0) goto L_0x00a3
            r6.m29997b()     // Catch:{ Exception -> 0x00dc }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x00dc }
            goto L_0x00d0
        L_0x00a3:
            com.didi.soda.home.binder.model.AllCategoryItemModel$Companion r3 = com.didi.soda.home.binder.model.AllCategoryItemModel.Companion     // Catch:{ Exception -> 0x00dc }
            java.lang.String r4 = ""
            if (r0 != 0) goto L_0x00ab
            r5 = r4
            goto L_0x00ac
        L_0x00ab:
            r5 = r0
        L_0x00ac:
            java.util.List r2 = r3.convetModelList(r2, r5)     // Catch:{ Exception -> 0x00dc }
            com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager<com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel> r3 = r6.f42557b     // Catch:{ Exception -> 0x00dc }
            if (r3 != 0) goto L_0x00ba
            java.lang.String r3 = "mCategoryListManager"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)     // Catch:{ Exception -> 0x00dc }
            goto L_0x00bb
        L_0x00ba:
            r1 = r3
        L_0x00bb:
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ Exception -> 0x00dc }
            r1.addAll(r3)     // Catch:{ Exception -> 0x00dc }
            com.didi.soda.home.topgun.manager.HomeOmegaHelper r1 = com.didi.soda.home.topgun.manager.HomeOmegaHelper.getInstance()     // Catch:{ Exception -> 0x00dc }
            if (r0 != 0) goto L_0x00c8
            r0 = r4
        L_0x00c8:
            java.lang.String r3 = r6.getFromPage()     // Catch:{ Exception -> 0x00dc }
            r1.trackFilterCategoryPanelSw(r2, r0, r3)     // Catch:{ Exception -> 0x00dc }
            r0 = r2
        L_0x00d0:
            r1 = r0
        L_0x00d1:
            if (r1 != 0) goto L_0x00e6
            r0 = r6
            com.didi.soda.home.component.category.AllCategoryPresenter r0 = (com.didi.soda.home.component.category.AllCategoryPresenter) r0     // Catch:{ Exception -> 0x00dc }
            r0.m29997b()     // Catch:{ Exception -> 0x00dc }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ Exception -> 0x00dc }
            goto L_0x00e6
        L_0x00dc:
            r0 = move-exception
            r0.printStackTrace()
            r6.m29997b()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            r1 = r0
        L_0x00e6:
            if (r1 != 0) goto L_0x00ee
            r0 = r6
            com.didi.soda.home.component.category.AllCategoryPresenter r0 = (com.didi.soda.home.component.category.AllCategoryPresenter) r0
            r0.m29997b()
        L_0x00ee:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.home.component.category.AllCategoryPresenter.m29995a():void");
    }

    /* renamed from: b */
    private final void m29997b() {
        TopGunAbnormalRvModel topGunAbnormalRvModel = new TopGunAbnormalRvModel();
        topGunAbnormalRvModel.setAbnormalVm(TopGunAbnormalFactory.buildAllCategoryNoData());
        topGunAbnormalRvModel.mHeight = -1;
        ChildDataListManager<RecyclerModel> childDataListManager = this.f42557b;
        if (childDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCategoryListManager");
            childDataListManager = null;
        }
        childDataListManager.add(topGunAbnormalRvModel);
    }

    public void initDataManagers() {
        super.initDataManagers();
        ChildDataListManager<RecyclerModel> createChildDataListManager = createChildDataListManager();
        Intrinsics.checkNotNullExpressionValue(createChildDataListManager, "createChildDataListManager<RecyclerModel>()");
        this.f42557b = createChildDataListManager;
        if (createChildDataListManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCategoryListManager");
            createChildDataListManager = null;
        }
        addDataManager(createChildDataListManager);
    }

    public ComponentLogicUnit provideComponentLogicUnit() {
        super.provideComponentLogicUnit();
        if (this.f42556a == null) {
            this.f42556a = new AllCategoryPresenter$provideComponentLogicUnit$1(this);
        }
        ComponentLogicUnit componentLogicUnit = this.f42556a;
        if (componentLogicUnit != null) {
            return componentLogicUnit;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.didi.soda.customer.base.binder.ComponentLogicUnit");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m29996a(AllCategoryItemModel allCategoryItemModel) {
        if (allCategoryItemModel != null && allCategoryItemModel.getLogicType() == 100) {
            CategoryEntity category = allCategoryItemModel.getCategory();
            if (category != null) {
                RouterCloseRepo routerCloseRepo = (RouterCloseRepo) RepoFactory.getRepo(RouterCloseRepo.class);
                RouterCloseRepo.AllCateGoryPageCloseModel allCateGoryPageCloseModel = new RouterCloseRepo.AllCateGoryPageCloseModel();
                allCateGoryPageCloseModel.setFrom(getFromPage());
                if (TextUtils.isEmpty(allCateGoryPageCloseModel.getFrom())) {
                    allCateGoryPageCloseModel.setFrom("homePage");
                }
                allCateGoryPageCloseModel.setCateId(category.getCateId());
                allCateGoryPageCloseModel.setRecId(allCategoryItemModel.getRecId());
                allCateGoryPageCloseModel.setUrl(category.getUrl());
                Unit unit = Unit.INSTANCE;
                routerCloseRepo.setValue((RouterCloseRepo.CloseModel) allCateGoryPageCloseModel);
                HomeOmegaHelper.getInstance().trackFilterCategoryConfirm(category, allCategoryItemModel.getPosition(), allCategoryItemModel.getRecId(), getFromPage());
            }
            dismiss(getScopeContext());
        }
    }
}
