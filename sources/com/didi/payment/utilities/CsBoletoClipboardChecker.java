package com.didi.payment.utilities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.globalgenerickit.utils.UIThreadHandler;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.utilities.input.CsManualInputDialog;
import java.util.HashMap;

public class CsBoletoClipboardChecker {

    /* renamed from: a */
    private static HashMap<String, Runnable> f31540a;

    /* renamed from: b */
    private static HashMap<String, CsManualInputDialog> f31541b;

    public static void postClipboardCheckerRunnable(final FragmentActivity fragmentActivity, final String str) {
        if (WalletApolloUtil.isBoletoScanOptEnable()) {
            if (f31540a == null) {
                f31540a = new HashMap<>();
            }
            if (!f31540a.containsKey(str)) {
                C110021 r0 = new Runnable() {
                    public void run() {
                        CsBoletoClipboardChecker.removeClipboardCheckerRunnable(str);
                        CsBoletoClipboardChecker.m22283b(fragmentActivity, str);
                    }
                };
                f31540a.put(str, r0);
                UIThreadHandler.post(r0, 100);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m22283b(FragmentActivity fragmentActivity, final String str) {
        String a = m22280a((Context) fragmentActivity);
        if (!TextUtils.isEmpty(a) && !a.contains("BR.GOV.BCB.PIX") && !a.contains("BR.GOV.BCB.PIX".toLowerCase())) {
            String removeNonNumber = CsInputFilter.removeNonNumber(a);
            if (CsBoletoCheckUtil.checkBoletoTypableLength(removeNonNumber)) {
                CsManualInputDialog csManualInputDialog = new CsManualInputDialog(fragmentActivity);
                csManualInputDialog.show(removeNonNumber, str, new Runnable() {
                    public void run() {
                        CsBoletoClipboardChecker.m22284b(str);
                    }
                });
                if (f31541b == null) {
                    f31541b = new HashMap<>();
                }
                f31541b.put(str, csManualInputDialog);
            }
        }
    }

    /* renamed from: a */
    private static String m22280a(Context context) {
        ClipData.Item itemAt;
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager == null) {
            return "";
        }
        ClipData clipData = null;
        try {
            clipData = clipboardManager.getPrimaryClip();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!clipboardManager.hasPrimaryClip() || clipData == null || clipData.getItemCount() <= 0 || (itemAt = clipData.getItemAt(0)) == null || itemAt.getText() == null) {
            return "";
        }
        return String.valueOf(itemAt.getText());
    }

    public static void clearClipboard(Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager != null) {
            try {
                clipboardManager.setPrimaryClip(ClipData.newPlainText("", ""));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m22284b(String str) {
        CsManualInputDialog csManualInputDialog;
        HashMap<String, CsManualInputDialog> hashMap = f31541b;
        if (hashMap != null && (csManualInputDialog = hashMap.get(str)) != null) {
            csManualInputDialog.dismiss();
            f31541b.remove(str);
        }
    }

    public static void removeClipboardCheckerRunnable(String str) {
        m22284b(str);
        HashMap<String, Runnable> hashMap = f31540a;
        if (hashMap != null) {
            hashMap.remove(str);
            if (f31540a.isEmpty()) {
                f31540a = null;
            }
        }
    }
}
