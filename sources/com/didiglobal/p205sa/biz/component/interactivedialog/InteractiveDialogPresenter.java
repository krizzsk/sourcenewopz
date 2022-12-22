package com.didiglobal.p205sa.biz.component.interactivedialog;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.never.base.PageFragment;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.component.never.core.IView;
import com.didi.component.never.core.page.Page;
import com.didi.global.globalgenerickit.config.GGKConfigManager;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.data.parser.util.XEParserUtil;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.xengine.SAXEngineConstants;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0012\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0016\u0010\u0018\u001a\u00020\u00122\u000e\u0010\u0019\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001bJ\b\u0010\u001c\u001a\u00020\u0012H\u0016J\u001c\u0010\u001d\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\"\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020#2\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/interactivedialog/InteractiveDialogPresenter;", "Lcom/didi/component/never/core/ComponentPresenterImpl;", "Lcom/didi/component/never/core/IView;", "params", "Lcom/didi/component/never/core/ComponentParams;", "(Lcom/didi/component/never/core/ComponentParams;)V", "TOAST_NAG_TYPE", "", "TOAST_NORMAL_TYPE", "TOAST_POS_TYPE", "mAlertId", "", "mSheetId", "mXELogicCallbackAlert", "Lcom/didiglobal/enginecore/callback/XEResponseCallback;", "mXELogicCallbackSheet", "mXELogicCallbackToast", "omegaTrack4ToastShow", "", "jsonObject", "Lcom/google/gson/JsonObject;", "onAdd", "arguments", "Landroid/os/Bundle;", "onFail", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "onRemove", "onSuccess", "configId", "onSuccessWithToast", "show", "activity", "Landroidx/fragment/app/FragmentActivity;", "Lorg/json/JSONObject;", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.interactivedialog.InteractiveDialogPresenter */
/* compiled from: InteractiveDialogPresenter.kt */
public final class InteractiveDialogPresenter extends ComponentPresenterImpl<IView<?>> {

    /* renamed from: a */
    private final int f51009a;

    /* renamed from: b */
    private final int f51010b = 1;

    /* renamed from: c */
    private final int f51011c = 2;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f51012d = "";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f51013e = "";

    /* renamed from: f */
    private XEResponseCallback f51014f = new InteractiveDialogPresenter$mXELogicCallbackSheet$1(this);

    /* renamed from: g */
    private XEResponseCallback f51015g = new InteractiveDialogPresenter$mXELogicCallbackAlert$1(this);

    /* renamed from: h */
    private XEResponseCallback f51016h = new InteractiveDialogPresenter$mXELogicCallbackToast$1(this);

    public InteractiveDialogPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegister.registerTemplate(new XERegisterModel(SAXEngineConstants.INSTANCE.getREQUEST_KEY_SHEET(), "sa_home", this.f51014f));
        XERegister.registerTemplate(new XERegisterModel(SAXEngineConstants.INSTANCE.getREQUEST_KEY_ALERT(), "sa_home", this.f51015g));
        XERegister.registerTemplate(new XERegisterModel(SAXEngineConstants.INSTANCE.getREQUEST_KEY_TOAST(), "sa_home", this.f51016h));
    }

    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(SAXEngineConstants.INSTANCE.getREQUEST_KEY_SHEET());
        XERegister.unregisterTemplate(SAXEngineConstants.INSTANCE.getREQUEST_KEY_ALERT());
        XERegister.unregisterTemplate(SAXEngineConstants.INSTANCE.getREQUEST_KEY_TOAST());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36544a(JsonObject jsonObject) {
        JsonObject asObject = XEParserUtil.getAsObject("data", jsonObject);
        if (asObject != null) {
            String asString = XEParserUtil.getAsString("toast_content", asObject, "");
            if (!TextUtils.isEmpty(asString)) {
                int asInt = XEParserUtil.getAsInt("type", asObject, 0);
                if (asInt == this.f51009a) {
                    LEGOToastHelper.showToast(this.mContext, asString);
                } else if (asInt == this.f51010b) {
                    LEGOToastHelper.showShortPosToast(this.mContext, asString);
                } else if (asInt == this.f51011c) {
                    LEGOToastHelper.showShortNagToast(this.mContext, asString);
                }
                m36546b(jsonObject);
            }
        }
    }

    /* renamed from: b */
    private final void m36546b(JsonObject jsonObject) {
        JsonObject asObject = XEParserUtil.getAsObject("extension", jsonObject);
        if (asObject != null) {
            Map hashMap = new HashMap();
            try {
                JsonObject asObject2 = XEParserUtil.getAsObject("log_data", asObject);
                if (asObject2 != null) {
                    hashMap = (Map) new Gson().fromJson((JsonElement) asObject2, new InteractiveDialogPresenter$omegaTrack4ToastShow$1().getType());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            OmegaSDKAdapter.trackEvent("ibt_gp_commonmodule_sw", (Map<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36545a(JsonObject jsonObject, String str) {
        FragmentActivity activity;
        if (getNodeParent() != null && getNodeParent().getNodeManager() != null && getNodeParent().getNodeManager().getHostPage() != null) {
            Page hostPage = getNodeParent().getNodeManager().getHostPage();
            if (hostPage instanceof Fragment) {
                PageFragment pageFragment = (PageFragment) hostPage;
                if (pageFragment.getActivity() != null && (activity = pageFragment.getActivity()) != null && jsonObject != null) {
                    activity.findViewById(16908290).post(new Runnable(activity, new JSONObject(jsonObject.toString()), str) {
                        public final /* synthetic */ FragmentActivity f$1;
                        public final /* synthetic */ JSONObject f$2;
                        public final /* synthetic */ String f$3;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                            this.f$3 = r4;
                        }

                        public final void run() {
                            InteractiveDialogPresenter.m36543a(InteractiveDialogPresenter.this, this.f$1, this.f$2, this.f$3);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36543a(InteractiveDialogPresenter interactiveDialogPresenter, FragmentActivity fragmentActivity, JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(interactiveDialogPresenter, "this$0");
        Intrinsics.checkNotNullParameter(jSONObject, "$json");
        interactiveDialogPresenter.m36542a(fragmentActivity, jSONObject, str);
    }

    public final void onFail(Exception exc) {
        if (exc != null) {
            exc.printStackTrace();
        }
    }

    /* renamed from: a */
    private final void m36542a(FragmentActivity fragmentActivity, JSONObject jSONObject, String str) {
        try {
            GGKConfigManager.legoConfig(fragmentActivity, new JSONObject(jSONObject.toString()), str, new InteractiveDialogPresenter$show$1(this, fragmentActivity));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
