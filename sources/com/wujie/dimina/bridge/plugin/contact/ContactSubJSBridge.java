package com.wujie.dimina.bridge.plugin.contact;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.base.DMServiceSubBridgeModule;
import com.didi.dimina.container.bridge.base.JsInterface;
import com.didi.dimina.container.messager.jsmodule.BaseServiceModule;
import com.didi.dimina.container.p106ui.dialog.DiminaBridgeSheetActivity;
import com.didi.dimina.container.util.UIHandlerUtil;
import org.json.JSONObject;

@DMServiceSubBridgeModule(level = 0)
public class ContactSubJSBridge extends BaseServiceModule {
    public ContactSubJSBridge(DMMina dMMina) {
        super(dMMina);
    }

    @JsInterface({"chooseContact"})
    public void chooseContact(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                ContactSubJSBridge.this.lambda$chooseContact$0$ContactSubJSBridge(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$chooseContact$0$ContactSubJSBridge(JSONObject jSONObject, CallbackFunction callbackFunction) {
        DiminaBridgeSheetActivity.registerCallback(DiminaBridgeSheetActivity.SourceType.CONTACT_SUBJSBRIDGE_CHOOSE_CONTACT, jSONObject, callbackFunction);
        DiminaBridgeSheetActivity.navigateTo(DiminaBridgeSheetActivity.SourceType.CONTACT_SUBJSBRIDGE_CHOOSE_CONTACT, this.mDimina.getActivity());
    }

    @JsInterface({"addPhoneContact"})
    public void showAddPhoneContactDialog(JSONObject jSONObject, CallbackFunction callbackFunction) {
        UIHandlerUtil.post(new Runnable(jSONObject, callbackFunction) {
            public final /* synthetic */ JSONObject f$1;
            public final /* synthetic */ CallbackFunction f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                ContactSubJSBridge.this.lambda$showAddPhoneContactDialog$1$ContactSubJSBridge(this.f$1, this.f$2);
            }
        });
    }

    public /* synthetic */ void lambda$showAddPhoneContactDialog$1$ContactSubJSBridge(JSONObject jSONObject, CallbackFunction callbackFunction) {
        DiminaBridgeSheetActivity.registerCallback(DiminaBridgeSheetActivity.SourceType.CONTACT_SUBJSBRIDGE_ADD_PHONE_CONTACT, jSONObject, callbackFunction);
        DiminaBridgeSheetActivity.navigateTo(DiminaBridgeSheetActivity.SourceType.CONTACT_SUBJSBRIDGE_ADD_PHONE_CONTACT, this.mDimina.getActivity());
    }
}
