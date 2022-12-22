package com.didi.dimina.container.bridge;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.p106ui.dialog.BaseActionSheet;
import com.didi.dimina.container.p106ui.dialog.ImageCloseView;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.JSONUtil;
import com.didi.dimina.container.util.LogUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class PopupSubJSBridge {

    /* renamed from: a */
    private static final String f16644a = "PopupSubJSBridge";
    public static BackupPopupWindowManager sBackupPopupWindowManager;

    /* renamed from: b */
    private DialogManager f16645b;

    /* renamed from: c */
    private final Context f16646c;

    public interface BackupPopupWindowManager {
        void hidePopup(Context context, JSONObject jSONObject, CallbackFunction callbackFunction);

        void showPopup(Context context, JSONObject jSONObject, CallbackFunction callbackFunction);
    }

    public PopupSubJSBridge(Context context) {
        this.f16646c = context;
        LogUtil.m13411i("PopupSubJSBridge init");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo54520a(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        LogUtil.m13411i("PopupSubJSBridge showPopup: " + jSONObject);
        BackupPopupWindowManager backupPopupWindowManager = sBackupPopupWindowManager;
        if (backupPopupWindowManager != null) {
            backupPopupWindowManager.showPopup(this.f16646c, jSONObject, callbackFunction);
        } else if (jSONObject.has("imageUrl")) {
            String optString = jSONObject.optString("imageUrl");
            if (!TextUtils.isEmpty(optString)) {
                DialogManager dialogManager = this.f16645b;
                if (dialogManager != null) {
                    dialogManager.dismiss();
                    this.f16645b = null;
                }
                DialogManager dialogManager2 = new DialogManager(this.f16646c, optString);
                this.f16645b = dialogManager2;
                dialogManager2.show(new ImageCloseView.OnImageCloseClickListener() {
                    public void onClick() {
                        JSONObject jSONObject = new JSONObject();
                        JSONUtil.put(jSONObject, "type", (Object) "click");
                        callbackFunction.onCallBack(jSONObject);
                    }

                    public void onClose() {
                        JSONObject jSONObject = new JSONObject();
                        JSONUtil.put(jSONObject, "type", (Object) "close");
                        callbackFunction.onCallBack(jSONObject);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo54521b(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m13411i("PopupSubJSBridge hidePopup: " + jSONObject);
        BackupPopupWindowManager backupPopupWindowManager = sBackupPopupWindowManager;
        if (backupPopupWindowManager != null) {
            backupPopupWindowManager.hidePopup(this.f16646c, jSONObject, callbackFunction);
            return;
        }
        DialogManager dialogManager = this.f16645b;
        if (dialogManager != null) {
            dialogManager.dismiss();
            this.f16645b = null;
        }
        callbackFunction.onCallBack(new Object[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo54522c(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.iRelease(f16644a, "showActionSheet: " + jSONObject);
        String optString = jSONObject.optString("alertText", "");
        String optString2 = jSONObject.optString("itemColor", "#000000");
        JSONArray optJSONArray = jSONObject.optJSONArray("itemList");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            LogUtil.eRelease(f16644a, "showActionSheet fail: itemList is empty");
            CallBackUtil.onFail("itemList is empty", callbackFunction);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.optString(i));
        }
        BaseActionSheet baseActionSheet = new BaseActionSheet(this.f16646c, new BaseActionSheet.OnDismissListener() {
            public final void onDismiss(int i) {
                PopupSubJSBridge.m12273a(CallbackFunction.this, i);
            }
        });
        baseActionSheet.setItemColor(optString2);
        baseActionSheet.setTitle(optString);
        baseActionSheet.refresh(arrayList);
        SystemUtils.showDialog(baseActionSheet);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m12273a(CallbackFunction callbackFunction, int i) {
        if (i < 0) {
            CallBackUtil.onFail("fail cancel", callbackFunction);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONUtil.put(jSONObject, "tapIndex", i);
        CallBackUtil.onSuccess(jSONObject, callbackFunction);
    }

    static class DialogManager {
        private final Context mContext;
        private AlertDialog mDialog;
        private final String mImageUrl;

        DialogManager(Context context, String str) {
            this.mImageUrl = str;
            this.mContext = context;
        }

        /* access modifiers changed from: package-private */
        public void show(ImageCloseView.OnImageCloseClickListener onImageCloseClickListener) {
            if (this.mContext != null) {
                AlertDialog alertDialog = this.mDialog;
                if (alertDialog == null || !alertDialog.isShowing()) {
                    ImageCloseView imageCloseView = new ImageCloseView(this.mContext);
                    imageCloseView.setImageUrl(this.mImageUrl);
                    imageCloseView.setClickListener(onImageCloseClickListener);
                    AlertDialog show = new AlertDialog.Builder(this.mContext, R.style.DiminaDialogNoBg).setCancelable(false).setView(imageCloseView).show();
                    this.mDialog = show;
                    if (show != null && show.getWindow() != null) {
                        this.mDialog.getWindow().setBackgroundDrawable((Drawable) null);
                        Window window = this.mDialog.getWindow();
                        window.getDecorView().setPadding(0, 0, 0, 0);
                        WindowManager.LayoutParams attributes = window.getAttributes();
                        attributes.height = -2;
                        attributes.width = -1;
                        attributes.gravity = 17;
                        window.setAttributes(attributes);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void dismiss() {
            AlertDialog alertDialog;
            if (this.mContext != null && (alertDialog = this.mDialog) != null) {
                alertDialog.dismiss();
                this.mDialog = null;
            }
        }
    }
}
