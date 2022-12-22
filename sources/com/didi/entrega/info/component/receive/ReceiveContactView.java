package com.didi.entrega.info.component.receive;

import android.view.View;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.INovaLayoutManager;
import com.didi.app.nova.support.view.recyclerview.view.layoutmanager.NovaLinearLayoutManager;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.customer.widget.titlebar.OnBackClickListener;
import com.didi.entrega.customer.widget.titlebar.TitleBarView;
import com.didi.entrega.info.binder.EditContactBinder;
import com.didi.entrega.info.binder.HistoryItemBinder;
import com.didi.entrega.info.binder.HistoryTitleBinder;
import com.didi.entrega.info.component.AbsInfoPresenter;
import com.didi.entrega.info.component.ContactConstract;
import com.didi.entrega.info.repo.InfoComponentRepo;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0006\u0010\u0013\u001a\u00020\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/entrega/info/component/receive/ReceiveContactView;", "Lcom/didi/entrega/info/component/ContactConstract$AbsEditContactView;", "()V", "editBinder", "Lcom/didi/entrega/info/binder/EditContactBinder;", "getEditBinder", "()Lcom/didi/entrega/info/binder/EditContactBinder;", "setEditBinder", "(Lcom/didi/entrega/info/binder/EditContactBinder;)V", "repo", "Lcom/didi/entrega/info/repo/InfoComponentRepo;", "kotlin.jvm.PlatformType", "getRepo", "()Lcom/didi/entrega/info/repo/InfoComponentRepo;", "generateNovaLayoutManager", "Lcom/didi/app/nova/support/view/recyclerview/view/layoutmanager/INovaLayoutManager;", "initItemBinders", "", "onCreate", "onSave", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ReceiveContactView.kt */
public final class ReceiveContactView extends ContactConstract.AbsEditContactView {

    /* renamed from: a */
    private EditContactBinder f20780a;

    /* renamed from: b */
    private final InfoComponentRepo f20781b = ((InfoComponentRepo) RepoFactory.getRepo(InfoComponentRepo.class));

    public final void onSave() {
    }

    public final EditContactBinder getEditBinder() {
        return this.f20780a;
    }

    public final void setEditBinder(EditContactBinder editContactBinder) {
        this.f20780a = editContactBinder;
    }

    public final InfoComponentRepo getRepo() {
        return this.f20781b;
    }

    public void onCreate() {
        super.onCreate();
        ((TitleBarView) getRootView().findViewById(R.id.title_bar)).setOnBackClickListener(new OnBackClickListener() {
            public final void onBackClick(View view) {
                ReceiveContactView.m15196a(ReceiveContactView.this, view);
            }
        });
        this.f20781b.subscribe(getScopeContext(), new Action1() {
            public final void call(Object obj) {
                ReceiveContactView.m15197a(ReceiveContactView.this, (String) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15196a(ReceiveContactView receiveContactView, View view) {
        Intrinsics.checkNotNullParameter(receiveContactView, "this$0");
        ((AbsInfoPresenter) receiveContactView.getPresenter()).handleBack();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0020, code lost:
        r2 = r2.getAddress();
     */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0128  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m15197a(com.didi.entrega.info.component.receive.ReceiveContactView r6, java.lang.String r7) {
        /*
            java.lang.String r7 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r7)
            com.didi.entrega.info.repo.InfoComponentRepo r7 = r6.getRepo()
            com.didi.entrega.info.model.ContactModel r7 = r7.getReceiver()
            r0 = 1
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r0)
            if (r7 != 0) goto L_0x0017
            goto L_0x0188
        L_0x0017:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r2 = r7.getContact()
            r3 = 0
            if (r2 != 0) goto L_0x0020
        L_0x001e:
            r2 = 0
            goto L_0x002c
        L_0x0020:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r2 = r2.getAddress()
            if (r2 != 0) goto L_0x0027
            goto L_0x001e
        L_0x0027:
            boolean r2 = r2.required
            if (r2 != r0) goto L_0x001e
            r2 = 1
        L_0x002c:
            r4 = 0
            if (r2 == 0) goto L_0x0057
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r2 = r7.getContact()
            if (r2 != 0) goto L_0x0037
        L_0x0035:
            r2 = r4
            goto L_0x0045
        L_0x0037:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity r2 = r2.getAddress()
            if (r2 != 0) goto L_0x003e
            goto L_0x0035
        L_0x003e:
            com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity$PoiEntity r2 = r2.poi
            if (r2 != 0) goto L_0x0043
            goto L_0x0035
        L_0x0043:
            java.lang.String r2 = r2.poiId
        L_0x0045:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0052
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0050
            goto L_0x0052
        L_0x0050:
            r2 = 0
            goto L_0x0053
        L_0x0052:
            r2 = 1
        L_0x0053:
            if (r2 == 0) goto L_0x0057
            r2 = 0
            goto L_0x0058
        L_0x0057:
            r2 = 1
        L_0x0058:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r7.getContact()
            if (r5 != 0) goto L_0x0060
        L_0x005e:
            r5 = 0
            goto L_0x006f
        L_0x0060:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$BuildingAddress r5 = r5.getBuildingAddress()
            if (r5 != 0) goto L_0x0067
            goto L_0x005e
        L_0x0067:
            java.lang.Boolean r5 = r5.getRequired()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r1)
        L_0x006f:
            if (r5 == 0) goto L_0x0095
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r7.getContact()
            if (r5 != 0) goto L_0x0079
        L_0x0077:
            r5 = r4
            goto L_0x0084
        L_0x0079:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$BuildingAddress r5 = r5.getBuildingAddress()
            if (r5 != 0) goto L_0x0080
            goto L_0x0077
        L_0x0080:
            java.lang.String r5 = r5.getBuildingAddress()
        L_0x0084:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x0091
            int r5 = r5.length()
            if (r5 != 0) goto L_0x008f
            goto L_0x0091
        L_0x008f:
            r5 = 0
            goto L_0x0092
        L_0x0091:
            r5 = 1
        L_0x0092:
            if (r5 == 0) goto L_0x0095
            r2 = 0
        L_0x0095:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r7.getContact()
            if (r5 != 0) goto L_0x009d
        L_0x009b:
            r5 = 0
            goto L_0x00ac
        L_0x009d:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r5 = r5.getPhoneNumber()
            if (r5 != 0) goto L_0x00a4
            goto L_0x009b
        L_0x00a4:
            java.lang.Boolean r5 = r5.getRequired()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r1)
        L_0x00ac:
            if (r5 == 0) goto L_0x00d2
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r7.getContact()
            if (r5 != 0) goto L_0x00b6
        L_0x00b4:
            r5 = r4
            goto L_0x00c1
        L_0x00b6:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r5 = r5.getPhoneNumber()
            if (r5 != 0) goto L_0x00bd
            goto L_0x00b4
        L_0x00bd:
            java.lang.String r5 = r5.getPhoneNumber()
        L_0x00c1:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x00ce
            int r5 = r5.length()
            if (r5 != 0) goto L_0x00cc
            goto L_0x00ce
        L_0x00cc:
            r5 = 0
            goto L_0x00cf
        L_0x00ce:
            r5 = 1
        L_0x00cf:
            if (r5 == 0) goto L_0x00d2
            r2 = 0
        L_0x00d2:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r7.getContact()
            if (r5 != 0) goto L_0x00da
        L_0x00d8:
            r5 = 0
            goto L_0x00e9
        L_0x00da:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r5 = r5.getPhoneNumber()
            if (r5 != 0) goto L_0x00e1
            goto L_0x00d8
        L_0x00e1:
            java.lang.Boolean r5 = r5.getRequired()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r1)
        L_0x00e9:
            if (r5 == 0) goto L_0x010f
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r7.getContact()
            if (r5 != 0) goto L_0x00f3
        L_0x00f1:
            r5 = r4
            goto L_0x00fe
        L_0x00f3:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$PhoneNumber r5 = r5.getPhoneNumber()
            if (r5 != 0) goto L_0x00fa
            goto L_0x00f1
        L_0x00fa:
            java.lang.String r5 = r5.getCallingCode()
        L_0x00fe:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x010b
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0109
            goto L_0x010b
        L_0x0109:
            r5 = 0
            goto L_0x010c
        L_0x010b:
            r5 = 1
        L_0x010c:
            if (r5 == 0) goto L_0x010f
            r2 = 0
        L_0x010f:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r7.getContact()
            if (r5 != 0) goto L_0x0117
        L_0x0115:
            r5 = 0
            goto L_0x0126
        L_0x0117:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$FirstName r5 = r5.getFirstName()
            if (r5 != 0) goto L_0x011e
            goto L_0x0115
        L_0x011e:
            java.lang.Boolean r5 = r5.getRequired()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r1)
        L_0x0126:
            if (r5 == 0) goto L_0x014c
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r7.getContact()
            if (r5 != 0) goto L_0x0130
        L_0x012e:
            r5 = r4
            goto L_0x013b
        L_0x0130:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$FirstName r5 = r5.getFirstName()
            if (r5 != 0) goto L_0x0137
            goto L_0x012e
        L_0x0137:
            java.lang.String r5 = r5.getFirstName()
        L_0x013b:
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x0148
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0146
            goto L_0x0148
        L_0x0146:
            r5 = 0
            goto L_0x0149
        L_0x0148:
            r5 = 1
        L_0x0149:
            if (r5 == 0) goto L_0x014c
            r2 = 0
        L_0x014c:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r5 = r7.getContact()
            if (r5 != 0) goto L_0x0154
        L_0x0152:
            r1 = 0
            goto L_0x0163
        L_0x0154:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$LastName r5 = r5.getLastName()
            if (r5 != 0) goto L_0x015b
            goto L_0x0152
        L_0x015b:
            java.lang.Boolean r5 = r5.getRequired()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r1)
        L_0x0163:
            if (r1 == 0) goto L_0x0187
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$Contact r7 = r7.getContact()
            if (r7 != 0) goto L_0x016c
            goto L_0x0177
        L_0x016c:
            com.didi.entrega.customer.foundation.rpc.entity.CommonInfoEntity$LastName r7 = r7.getLastName()
            if (r7 != 0) goto L_0x0173
            goto L_0x0177
        L_0x0173:
            java.lang.String r4 = r7.getLastName()
        L_0x0177:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x0183
            int r7 = r4.length()
            if (r7 != 0) goto L_0x0182
            goto L_0x0183
        L_0x0182:
            r0 = 0
        L_0x0183:
            if (r0 == 0) goto L_0x0187
            r0 = 0
            goto L_0x0188
        L_0x0187:
            r0 = r2
        L_0x0188:
            android.view.View r6 = r6.getRootView()
            r7 = 2131427856(0x7f0b0210, float:1.847734E38)
            android.view.View r6 = r6.findViewById(r7)
            com.didi.rfusion.widget.button.RFMainButton r6 = (com.didi.rfusion.widget.button.RFMainButton) r6
            r6.setEnabled(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.component.receive.ReceiveContactView.m15197a(com.didi.entrega.info.component.receive.ReceiveContactView, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public INovaLayoutManager generateNovaLayoutManager() {
        return new NovaLinearLayoutManager(getContext());
    }

    /* access modifiers changed from: protected */
    public void initItemBinders() {
        super.initItemBinders();
        EditContactBinder editContactBinder = new EditContactBinder();
        editContactBinder.setSender(false);
        editContactBinder.setBinderFusionChannel(getFusionChannel());
        editContactBinder.setBinderPageSource(getPageSource());
        editContactBinder.setBinderEventSource(getEventSource());
        editContactBinder.setContactCardClickListener(new ReceiveContactView$initItemBinders$1$1(this));
        Unit unit = Unit.INSTANCE;
        this.f20780a = editContactBinder;
        registerBinder(editContactBinder);
        HistoryItemBinder historyItemBinder = new HistoryItemBinder();
        historyItemBinder.setHistoryClickListener(new ReceiveContactView$initItemBinders$2$1(this));
        Unit unit2 = Unit.INSTANCE;
        registerBinder(historyItemBinder);
        registerBinder(new HistoryTitleBinder());
    }
}
