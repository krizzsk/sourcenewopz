package com.didi.entrega.info.component;

import android.os.Bundle;
import android.view.View;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.entrega.customer.base.recycler.CustomerRecyclerPresenter;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.util.NetWorkUtils;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewModel;
import com.didi.entrega.customer.widget.abnormal.AbnormalViewModelFactory;
import com.didi.entrega.info.component.AbsInfoView;
import com.didi.entrega.info.helper.InfoStepConfig;
import com.didi.entrega.info.model.BaseContactModel;
import com.didi.entrega.info.model.InfoHeaderModel;
import com.taxis99.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J3\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2#\u0010$\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*0%J\b\u0010+\u001a\u00020*H&J\u0006\u0010,\u001a\u00020*J\b\u0010-\u001a\u00020*H\u0016J\u0012\u0010.\u001a\u00020*2\b\u0010/\u001a\u0004\u0018\u000100H&J \u0010\u0011\u001a\u00020*2\b\u00101\u001a\u0004\u0018\u00010\r2\u000e\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r03R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R>\u0010\u0013\u001a&\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\r0\r \u0015*\u0012\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\r0\r\u0018\u00010\u00140\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u00064"}, mo175978d2 = {"Lcom/didi/entrega/info/component/AbsInfoPresenter;", "T", "Lcom/didi/entrega/info/component/AbsInfoView;", "Lcom/didi/entrega/customer/base/recycler/CustomerRecyclerPresenter;", "()V", "currentStepConfig", "Lcom/didi/entrega/info/helper/InfoStepConfig;", "getCurrentStepConfig", "()Lcom/didi/entrega/info/helper/InfoStepConfig;", "setCurrentStepConfig", "(Lcom/didi/entrega/info/helper/InfoStepConfig;)V", "dataList", "Ljava/util/ArrayList;", "Lcom/didi/entrega/info/model/BaseContactModel;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "dataListManager", "Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "kotlin.jvm.PlatformType", "getDataListManager", "()Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;", "setDataListManager", "(Lcom/didi/app/nova/support/view/recyclerview/data/ChildDataListManager;)V", "infoHeaderModel", "Lcom/didi/entrega/info/model/InfoHeaderModel;", "getInfoHeaderModel", "()Lcom/didi/entrega/info/model/InfoHeaderModel;", "setInfoHeaderModel", "(Lcom/didi/entrega/info/model/InfoHeaderModel;)V", "createAbnormalViewModel", "Lcom/didi/entrega/customer/widget/abnormal/AbnormalViewModel;", "errMsg", "", "abnormalBlock", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "", "handleBack", "initHeader", "onCreate", "onPageResult", "data", "Landroid/os/Bundle;", "model", "setModel", "Lkotlin/Function0;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AbsInfoPresenter.kt */
public abstract class AbsInfoPresenter<T extends AbsInfoView> extends CustomerRecyclerPresenter<T> {
    private InfoStepConfig currentStepConfig = new InfoStepConfig();
    private ArrayList<BaseContactModel> dataList = new ArrayList<>();
    private ChildDataListManager<BaseContactModel> dataListManager = createChildDataListManager();
    private InfoHeaderModel infoHeaderModel;

    public abstract void handleBack();

    public abstract void onPageResult(Bundle bundle);

    public final InfoStepConfig getCurrentStepConfig() {
        return this.currentStepConfig;
    }

    public final void setCurrentStepConfig(InfoStepConfig infoStepConfig) {
        this.currentStepConfig = infoStepConfig;
    }

    public final InfoHeaderModel getInfoHeaderModel() {
        return this.infoHeaderModel;
    }

    public final void setInfoHeaderModel(InfoHeaderModel infoHeaderModel2) {
        this.infoHeaderModel = infoHeaderModel2;
    }

    public final ChildDataListManager<BaseContactModel> getDataListManager() {
        return this.dataListManager;
    }

    public final void setDataListManager(ChildDataListManager<BaseContactModel> childDataListManager) {
        this.dataListManager = childDataListManager;
    }

    public final ArrayList<BaseContactModel> getDataList() {
        return this.dataList;
    }

    public final void setDataList(ArrayList<BaseContactModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.dataList = arrayList;
    }

    public final void initHeader() {
        InfoHeaderModel infoHeaderModel2;
        InfoStepConfig infoStepConfig = this.currentStepConfig;
        if (infoStepConfig != null) {
            setInfoHeaderModel(new InfoHeaderModel());
            InfoHeaderModel infoHeaderModel3 = getInfoHeaderModel();
            if (infoHeaderModel3 != null) {
                infoHeaderModel3.setCurrentStep(infoStepConfig.getCurrentStep());
            }
            int currentStep = infoStepConfig.getCurrentStep();
            if (currentStep == 1) {
                InfoHeaderModel infoHeaderModel4 = getInfoHeaderModel();
                if (infoHeaderModel4 != null) {
                    infoHeaderModel4.setTitle(ResourceHelper.getString(R.string.FoodC_info_Fill_in_SDGf));
                }
            } else if (currentStep == 2) {
                InfoHeaderModel infoHeaderModel5 = getInfoHeaderModel();
                if (infoHeaderModel5 != null) {
                    infoHeaderModel5.setTitle(ResourceHelper.getString(R.string.FoodC_info_Recipient_Information_JGug));
                }
            } else if (currentStep == 3 && (infoHeaderModel2 = getInfoHeaderModel()) != null) {
                infoHeaderModel2.setTitle(ResourceHelper.getString(R.string.FoodC_info_Item_Information_gDfc));
            }
            InfoHeaderModel infoHeaderModel6 = getInfoHeaderModel();
            if (infoHeaderModel6 != null) {
                getDataListManager().add(0, infoHeaderModel6);
            }
        }
    }

    public void onCreate() {
        super.onCreate();
        InfoStepConfig infoStepConfig = this.currentStepConfig;
        if (infoStepConfig != null) {
            ((AbsInfoView) getLogicView()).setTitleBarTxt(infoStepConfig);
        }
    }

    public final void setDataList(BaseContactModel baseContactModel, Function0<? extends BaseContactModel> function0) {
        BaseContactModel baseContactModel2;
        Intrinsics.checkNotNullParameter(function0, "setModel");
        int indexOf = this.dataListManager.indexOf(baseContactModel);
        LogUtil.m14765i("AbsInfoPresenter", Intrinsics.stringPlus("setDataList：", Integer.valueOf(indexOf)));
        if (indexOf >= 0 && (baseContactModel2 = (BaseContactModel) function0.invoke()) != null) {
            this.dataListManager.set(indexOf, baseContactModel2);
        }
    }

    public final AbnormalViewModel createAbnormalViewModel(String str, Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, DMWebSocketListener.KEY_ERR_MSG);
        Intrinsics.checkNotNullParameter(function1, "abnormalBlock");
        $$Lambda$AbsInfoPresenter$OzF8Tvn58O6fG0kjEsWAHJoac r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                AbsInfoPresenter.m46366createAbnormalViewModel$lambda3(Function1.this, view);
            }
        };
        if (!NetWorkUtils.isNetworkConnected(getContext())) {
            AbnormalViewModel buildNoNetwork = AbnormalViewModelFactory.buildNoNetwork(r0);
            Intrinsics.checkNotNullExpressionValue(buildNoNetwork, "{\n            AbnormalVi…nClickListener)\n        }");
            return buildNoNetwork;
        }
        AbnormalViewModel buildNoService = AbnormalViewModelFactory.buildNoService(str, r0);
        Intrinsics.checkNotNullExpressionValue(buildNoService, "{\n            AbnormalVi…nClickListener)\n        }");
        return buildNoService;
    }

    /* access modifiers changed from: private */
    /* renamed from: createAbnormalViewModel$lambda-3  reason: not valid java name */
    public static final void m46366createAbnormalViewModel$lambda3(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$abnormalBlock");
        function1.invoke(view);
    }
}
