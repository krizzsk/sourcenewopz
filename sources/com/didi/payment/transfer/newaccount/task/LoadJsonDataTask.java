package com.didi.payment.transfer.newaccount.task;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import com.didi.payment.transfer.newaccount.BankDataModel;
import java.lang.ref.SoftReference;

public class LoadJsonDataTask extends AsyncTask<String, Void, BankDataModel> {

    /* renamed from: a */
    SoftReference<Context> f31429a;

    /* renamed from: b */
    IViewCallback f31430b;

    /* renamed from: c */
    Bundle f31431c;

    /* renamed from: d */
    BankDataModel f31432d;

    public interface IViewCallback {
        void onBankDataLoaded(BankDataModel bankDataModel);
    }

    public LoadJsonDataTask(Context context, IViewCallback iViewCallback, Bundle bundle) {
        this.f31429a = new SoftReference<>(context);
        this.f31431c = bundle;
        this.f31430b = iViewCallback;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(BankDataModel bankDataModel) {
        super.onPostExecute(bankDataModel);
        this.f31432d = bankDataModel;
        IViewCallback iViewCallback = this.f31430b;
        if (iViewCallback != null) {
            iViewCallback.onBankDataLoaded(bankDataModel);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:30|31|32|33|34|28) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.payment.transfer.newaccount.BankDataModel doInBackground(java.lang.String... r8) {
        /*
            r7 = this;
            com.didi.payment.transfer.newaccount.BankDataModel r0 = r7.f31432d
            if (r0 == 0) goto L_0x000d
            boolean r0 = r0.isValid()
            if (r0 == 0) goto L_0x000d
            com.didi.payment.transfer.newaccount.BankDataModel r8 = r7.f31432d
            return r8
        L_0x000d:
            com.didi.payment.transfer.newaccount.BankDataModel r0 = new com.didi.payment.transfer.newaccount.BankDataModel
            r0.<init>()
            if (r8 == 0) goto L_0x00b7
            int r1 = r8.length
            if (r1 > 0) goto L_0x0019
            goto L_0x00b7
        L_0x0019:
            java.lang.ref.SoftReference<android.content.Context> r1 = r7.f31429a
            java.lang.Object r1 = r1.get()
            if (r1 != 0) goto L_0x0022
            return r0
        L_0x0022:
            java.lang.ref.SoftReference<android.content.Context> r1 = r7.f31429a
            java.lang.Object r1 = r1.get()
            android.content.Context r1 = (android.content.Context) r1
            r2 = 0
            r8 = r8[r2]
            java.lang.String r8 = com.didi.sdk.util.AssetsUtil.getAssetsFile(r1, r8)
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b3 }
            r1.<init>(r8)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r8 = "top_five"
            org.json.JSONObject r8 = r1.optJSONObject(r8)     // Catch:{ JSONException -> 0x00b3 }
            java.util.Iterator r2 = r8.keys()     // Catch:{ JSONException -> 0x00b3 }
        L_0x0040:
            boolean r3 = r2.hasNext()     // Catch:{ JSONException -> 0x00b3 }
            r4 = 1
            if (r3 == 0) goto L_0x005e
            java.lang.Object r3 = r2.next()     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r5 = r8.optString(r3)     // Catch:{ JSONException -> 0x00b3 }
            com.didi.payment.transfer.common.model.TransBankInfo r6 = new com.didi.payment.transfer.common.model.TransBankInfo     // Catch:{ JSONException -> 0x00b3 }
            r6.<init>(r3, r5)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r3 = r6.toString()     // Catch:{ JSONException -> 0x00b3 }
            r0.addBankItem(r3, r6, r4)     // Catch:{ JSONException -> 0x00b3 }
            goto L_0x0040
        L_0x005e:
            android.os.Bundle r8 = r7.f31431c     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r2 = ""
            if (r8 == 0) goto L_0x006c
            android.os.Bundle r8 = r7.f31431c     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r3 = "last_option"
            java.lang.String r2 = r8.getString(r3, r2)     // Catch:{ JSONException -> 0x00b3 }
        L_0x006c:
            boolean r8 = com.didi.sdk.util.TextUtil.isEmpty(r2)     // Catch:{ JSONException -> 0x00b3 }
            if (r8 != 0) goto L_0x0080
            com.didi.payment.transfer.newaccount.task.LoadJsonDataTask$1 r8 = new com.didi.payment.transfer.newaccount.task.LoadJsonDataTask$1     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r3 = "0"
            r8.<init>(r2, r3)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r2 = r8.toString()     // Catch:{ JSONException -> 0x00b3 }
            r0.addBankItem(r2, r8, r4)     // Catch:{ JSONException -> 0x00b3 }
        L_0x0080:
            java.lang.String r8 = "full_list"
            org.json.JSONObject r8 = r1.optJSONObject(r8)     // Catch:{ JSONException -> 0x00b3 }
            java.util.Iterator r1 = r8.keys()     // Catch:{ JSONException -> 0x00b3 }
        L_0x008a:
            boolean r2 = r1.hasNext()     // Catch:{ JSONException -> 0x00b3 }
            if (r2 == 0) goto L_0x00b7
            java.lang.Object r2 = r1.next()     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r3 = r8.optString(r2)     // Catch:{ JSONException -> 0x00b3 }
            com.didi.payment.transfer.utils.TransStore r4 = com.didi.payment.transfer.utils.TransStore.getInstance()     // Catch:{ Exception -> 0x00a5 }
            int r5 = java.lang.Integer.parseInt(r3)     // Catch:{ Exception -> 0x00a5 }
            r4.addBankItem(r5, r2)     // Catch:{ Exception -> 0x00a5 }
        L_0x00a5:
            com.didi.payment.transfer.common.model.TransBankInfo r4 = new com.didi.payment.transfer.common.model.TransBankInfo     // Catch:{ JSONException -> 0x00b3 }
            r4.<init>(r2, r3)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.String r2 = r4.toString()     // Catch:{ JSONException -> 0x00b3 }
            r3 = 2
            r0.addBankItem(r2, r4, r3)     // Catch:{ JSONException -> 0x00b3 }
            goto L_0x008a
        L_0x00b3:
            r8 = move-exception
            r8.printStackTrace()
        L_0x00b7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.transfer.newaccount.task.LoadJsonDataTask.doInBackground(java.lang.String[]):com.didi.payment.transfer.newaccount.BankDataModel");
    }
}
