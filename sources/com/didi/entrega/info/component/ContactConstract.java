package com.didi.entrega.info.component;

import android.os.Bundle;
import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.entrega.customer.foundation.util.ClickUtils;
import com.didi.entrega.customer.foundation.util.DialogUtil;
import com.didi.entrega.customer.foundation.util.KeyboardUtils;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.info.component.ContactConstract;
import com.didi.entrega.info.helper.InfoDataHelper;
import com.didi.entrega.info.helper.InfoOmegaHelper;
import com.didi.entrega.info.model.BaseContactModel;
import com.didi.entrega.info.model.ContactModel;
import com.didi.entrega.info.model.HistoryModel;
import com.didi.entrega.info.model.InfoHeaderModel;
import com.didi.entrega.info.model.MiddleTitleModel;
import com.didi.entrega.info.repo.HistoryListRepo;
import com.didi.entrega.info.repo.InfoComponentRepo;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import com.didi.entrega.manager.base.ICustomerManager;
import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000 \u00042\u00020\u0001:\u0003\u0002\u0003\u0004¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/info/component/ContactConstract;", "", "AbsEditContactPresenter", "AbsEditContactView", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ContactConstract.kt */
public interface ContactConstract {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String USER_TYPE_RECEIVER = "2";
    public static final String USER_TYPE_SENDER = "1";

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/entrega/info/component/ContactConstract$Companion;", "", "()V", "USER_TYPE_RECEIVER", "", "USER_TYPE_SENDER", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ContactConstract.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String USER_TYPE_RECEIVER = "2";
        public static final String USER_TYPE_SENDER = "1";

        private Companion() {
        }
    }

    @Metadata(mo175977d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u00107\u001a\u000208H\u0016J\u001a\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020\u0012H&J\b\u0010=\u001a\u000208H\u0016J\u0012\u0010>\u001a\u0002082\b\u0010?\u001a\u0004\u0018\u00010\u001cH\u0016J\u0010\u0010@\u001a\u0002082\b\u0010?\u001a\u0004\u0018\u00010\u001cJ\b\u0010A\u001a\u000208H\u0016J\b\u0010B\u001a\u000208H\u0014J\u001e\u0010C\u001a\u0002082\u0016\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dJ<\u0010E\u001a\u0016\u0012\u0004\u0012\u00020F\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020F\u0018\u0001`\u001d2\b\u0010G\u001a\u0004\u0018\u0001022\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dR\"\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R*\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\n \u0006*\u0004\u0018\u00010#0#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R\u001c\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006H"}, mo175978d2 = {"Lcom/didi/entrega/info/component/ContactConstract$AbsEditContactPresenter;", "Lcom/didi/entrega/info/component/AbsInfoPresenter;", "Lcom/didi/entrega/info/component/ContactConstract$AbsEditContactView;", "()V", "componentRepo", "Lcom/didi/entrega/info/repo/InfoComponentRepo;", "kotlin.jvm.PlatformType", "getComponentRepo", "()Lcom/didi/entrega/info/repo/InfoComponentRepo;", "setComponentRepo", "(Lcom/didi/entrega/info/repo/InfoComponentRepo;)V", "contractModel", "Lcom/didi/entrega/info/model/ContactModel;", "getContractModel", "()Lcom/didi/entrega/info/model/ContactModel;", "setContractModel", "(Lcom/didi/entrega/info/model/ContactModel;)V", "eventSource", "", "getEventSource", "()I", "setEventSource", "(I)V", "fusionChannel", "getFusionChannel", "setFusionChannel", "historyContactList", "Ljava/util/ArrayList;", "Lcom/didi/entrega/info/model/HistoryModel;", "Lkotlin/collections/ArrayList;", "getHistoryContactList", "()Ljava/util/ArrayList;", "setHistoryContactList", "(Ljava/util/ArrayList;)V", "historyListRepo", "Lcom/didi/entrega/info/repo/HistoryListRepo;", "getHistoryListRepo", "()Lcom/didi/entrega/info/repo/HistoryListRepo;", "setHistoryListRepo", "(Lcom/didi/entrega/info/repo/HistoryListRepo;)V", "infoManager", "Lcom/didi/entrega/manager/base/ICustomerContactManager;", "getInfoManager", "()Lcom/didi/entrega/manager/base/ICustomerContactManager;", "setInfoManager", "(Lcom/didi/entrega/manager/base/ICustomerContactManager;)V", "pageSource", "getPageSource", "setPageSource", "titleModel", "Lcom/didi/entrega/info/model/MiddleTitleModel;", "getTitleModel", "()Lcom/didi/entrega/info/model/MiddleTitleModel;", "setTitleModel", "(Lcom/didi/entrega/info/model/MiddleTitleModel;)V", "handleBack", "", "onCallingClick", "callingCode", "", "countryId", "onCreate", "onHistoryItemClick", "item", "onHistoryItemDeleteClick", "onPoiClick", "onResume", "randerHistoryListAfterChange", "historyList", "randerHistoryWithTitle", "Lcom/didi/entrega/info/model/BaseContactModel;", "title", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ContactConstract.kt */
    public static abstract class AbsEditContactPresenter extends AbsInfoPresenter<AbsEditContactView> {
        private InfoComponentRepo componentRepo = ((InfoComponentRepo) RepoFactory.getRepo(InfoComponentRepo.class));
        private ContactModel contractModel;
        private int eventSource;
        private int fusionChannel = 2;
        private ArrayList<HistoryModel> historyContactList = new ArrayList<>();
        private HistoryListRepo historyListRepo = ((HistoryListRepo) RepoFactory.getRepo(HistoryListRepo.class));
        public ICustomerContactManager infoManager;
        private int pageSource;
        private MiddleTitleModel titleModel;

        public abstract void onCallingClick(String str, int i);

        public final int getFusionChannel() {
            return this.fusionChannel;
        }

        public final void setFusionChannel(int i) {
            this.fusionChannel = i;
        }

        public final int getPageSource() {
            return this.pageSource;
        }

        public final void setPageSource(int i) {
            this.pageSource = i;
        }

        public final int getEventSource() {
            return this.eventSource;
        }

        public final void setEventSource(int i) {
            this.eventSource = i;
        }

        public final ICustomerContactManager getInfoManager() {
            ICustomerContactManager iCustomerContactManager = this.infoManager;
            if (iCustomerContactManager != null) {
                return iCustomerContactManager;
            }
            Intrinsics.throwUninitializedPropertyAccessException("infoManager");
            return null;
        }

        public final void setInfoManager(ICustomerContactManager iCustomerContactManager) {
            Intrinsics.checkNotNullParameter(iCustomerContactManager, "<set-?>");
            this.infoManager = iCustomerContactManager;
        }

        public final ContactModel getContractModel() {
            return this.contractModel;
        }

        public final void setContractModel(ContactModel contactModel) {
            this.contractModel = contactModel;
        }

        public final MiddleTitleModel getTitleModel() {
            return this.titleModel;
        }

        public final void setTitleModel(MiddleTitleModel middleTitleModel) {
            this.titleModel = middleTitleModel;
        }

        public final ArrayList<HistoryModel> getHistoryContactList() {
            return this.historyContactList;
        }

        public final void setHistoryContactList(ArrayList<HistoryModel> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.historyContactList = arrayList;
        }

        public final InfoComponentRepo getComponentRepo() {
            return this.componentRepo;
        }

        public final void setComponentRepo(InfoComponentRepo infoComponentRepo) {
            this.componentRepo = infoComponentRepo;
        }

        public final HistoryListRepo getHistoryListRepo() {
            return this.historyListRepo;
        }

        public final void setHistoryListRepo(HistoryListRepo historyListRepo2) {
            this.historyListRepo = historyListRepo2;
        }

        public void onCreate() {
            Bundle bundle;
            super.onCreate();
            ICustomerManager loadManager = CustomerManagerLoader.loadManager(ICustomerContactManager.class);
            Intrinsics.checkNotNullExpressionValue(loadManager, "loadManager(ICustomerContactManager::class.java)");
            setInfoManager((ICustomerContactManager) loadManager);
            this.pageSource = getScopeContext().getBundle().getInt("page_source", 1);
            int i = 2;
            this.eventSource = getScopeContext().getBundle().getInt(ParamConst.InfoOmega.EVENT_SOURCE, 2);
            ScopeContext scopeContext = getScopeContext();
            if (!(scopeContext == null || (bundle = scopeContext.getBundle()) == null)) {
                i = bundle.getInt(ParamConst.InfoOmega.FUSION_CHANNEL, 2);
            }
            this.fusionChannel = i;
        }

        /* access modifiers changed from: protected */
        public void onResume() {
            super.onResume();
            InfoOmegaHelper.INSTANCE.trackContactCommonShow(this);
        }

        public void handleBack() {
            InfoOmegaHelper.INSTANCE.trackContactCommonCK(this);
        }

        public void onPoiClick() {
            KeyboardUtils.hideSoftInput(GlobalContext.getContext(), (View) null);
        }

        public void onHistoryItemClick(HistoryModel historyModel) {
            InfoOmegaHelper infoOmegaHelper = InfoOmegaHelper.INSTANCE;
            ChildDataListManager<BaseContactModel> dataListManager = getDataListManager();
            infoOmegaHelper.trackHistoryCk(this, dataListManager == null ? 0 : dataListManager.indexOf(historyModel));
        }

        public final void onHistoryItemDeleteClick(HistoryModel historyModel) {
            if (!ClickUtils.isFastClick()) {
                DialogUtil.showWarningDialog(ResourceHelper.getString(R.string.FoodC_info_Delete_Records_IzwE), ResourceHelper.getString(R.string.FoodC_info_Confirm_deletion_JaYz), R.string.FoodC_up_Cancel_anHR, R.string.FoodC_up_Confirmation_hKaf, getScopeContext(), C8191x5d9e8be2.INSTANCE, new RFDialogInterface.OnClickListener(this) {
                    public final /* synthetic */ ContactConstract.AbsEditContactPresenter f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(RFDialog rFDialog) {
                        ContactConstract.AbsEditContactPresenter.m46370onHistoryItemDeleteClick$lambda2(HistoryModel.this, this.f$1, rFDialog);
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: onHistoryItemDeleteClick$lambda-0  reason: not valid java name */
        public static final void m46369onHistoryItemDeleteClick$lambda0(RFDialog rFDialog) {
            rFDialog.dismiss();
        }

        /* access modifiers changed from: private */
        /* renamed from: onHistoryItemDeleteClick$lambda-2  reason: not valid java name */
        public static final void m46370onHistoryItemDeleteClick$lambda2(HistoryModel historyModel, AbsEditContactPresenter absEditContactPresenter, RFDialog rFDialog) {
            Intrinsics.checkNotNullParameter(absEditContactPresenter, "this$0");
            rFDialog.dismiss();
            if (historyModel != null) {
                ((AbsEditContactView) absEditContactPresenter.getLogicView()).loadingAndHideBottomBtn();
                InfoDataHelper.INSTANCE.deleteContact(historyModel, new C8193x471ce07e(absEditContactPresenter), new C8194x471ce07f(absEditContactPresenter));
            }
        }

        public final ArrayList<BaseContactModel> randerHistoryWithTitle(MiddleTitleModel middleTitleModel, ArrayList<HistoryModel> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "historyContactList");
            if (arrayList.size() <= 0) {
                return null;
            }
            ArrayList<BaseContactModel> arrayList2 = new ArrayList<>();
            if (middleTitleModel != null) {
                arrayList2.add(middleTitleModel);
            }
            arrayList2.addAll(arrayList);
            return arrayList2;
        }

        public final void randerHistoryListAfterChange(ArrayList<HistoryModel> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "historyList");
            setDataList(new ArrayList());
            InfoHeaderModel infoHeaderModel = getInfoHeaderModel();
            if (infoHeaderModel != null) {
                getDataList().add(infoHeaderModel);
            }
            ContactModel contactModel = this.contractModel;
            if (contactModel != null) {
                getDataList().add(contactModel);
            }
            ArrayList<BaseContactModel> randerHistoryWithTitle = randerHistoryWithTitle(this.titleModel, arrayList);
            if (randerHistoryWithTitle != null) {
                getDataList().addAll(randerHistoryWithTitle);
            }
            ChildDataListManager<BaseContactModel> dataListManager = getDataListManager();
            if (dataListManager != null) {
                dataListManager.set(getDataList());
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/entrega/info/component/ContactConstract$AbsEditContactView;", "Lcom/didi/entrega/info/component/AbsInfoView;", "()V", "eventSource", "", "getEventSource", "()I", "setEventSource", "(I)V", "fusionChannel", "getFusionChannel", "setFusionChannel", "pageSource", "getPageSource", "setPageSource", "initItemBinders", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ContactConstract.kt */
    public static abstract class AbsEditContactView extends AbsInfoView {
        private int eventSource;
        private int fusionChannel = 2;
        private int pageSource;

        public final int getPageSource() {
            return this.pageSource;
        }

        public final void setPageSource(int i) {
            this.pageSource = i;
        }

        public final int getEventSource() {
            return this.eventSource;
        }

        public final void setEventSource(int i) {
            this.eventSource = i;
        }

        public final int getFusionChannel() {
            return this.fusionChannel;
        }

        public final void setFusionChannel(int i) {
            this.fusionChannel = i;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
            r0 = r0.getBundle();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void initItemBinders() {
            /*
                r3 = this;
                super.initItemBinders()
                com.didi.app.nova.skeleton.ScopeContext r0 = r3.getScopeContext()
                r1 = 0
                if (r0 != 0) goto L_0x000c
            L_0x000a:
                r0 = 0
                goto L_0x001a
            L_0x000c:
                android.os.Bundle r0 = r0.getBundle()
                if (r0 != 0) goto L_0x0013
                goto L_0x000a
            L_0x0013:
                java.lang.String r2 = "page_source"
                int r0 = r0.getInt(r2, r1)
            L_0x001a:
                r3.pageSource = r0
                com.didi.app.nova.skeleton.ScopeContext r0 = r3.getScopeContext()
                if (r0 != 0) goto L_0x0023
                goto L_0x0030
            L_0x0023:
                android.os.Bundle r0 = r0.getBundle()
                if (r0 != 0) goto L_0x002a
                goto L_0x0030
            L_0x002a:
                java.lang.String r2 = "event_source"
                int r1 = r0.getInt(r2, r1)
            L_0x0030:
                r3.eventSource = r1
                com.didi.app.nova.skeleton.ScopeContext r0 = r3.getScopeContext()
                r1 = 2
                if (r0 != 0) goto L_0x003a
                goto L_0x0047
            L_0x003a:
                android.os.Bundle r0 = r0.getBundle()
                if (r0 != 0) goto L_0x0041
                goto L_0x0047
            L_0x0041:
                java.lang.String r2 = "fusionChannel"
                int r1 = r0.getInt(r2, r1)
            L_0x0047:
                r3.fusionChannel = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.entrega.info.component.ContactConstract.AbsEditContactView.initItemBinders():void");
        }
    }
}
