package com.didi.payment.transfer.utils;

import android.content.Context;
import android.os.AsyncTask;
import com.didi.payment.transfer.constants.TransferContants;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.AssetsUtil;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class LoadBankInfoTask extends AsyncTask<String, Void, Integer> {
    private Context mAppContext;

    public LoadBankInfoTask(Context context) {
        this.mAppContext = context;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(Integer num) {
        super.onPostExecute(num);
        SystemUtils.log(3, "trans_tag", String.format("load %d bank data.", new Object[]{num}), (Throwable) null, "com.didi.payment.transfer.utils.LoadBankInfoTask", 30);
    }

    /* access modifiers changed from: protected */
    public Integer doInBackground(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return 0;
        }
        try {
            JSONObject optJSONObject = new JSONObject(AssetsUtil.getAssetsFile(this.mAppContext, strArr[0])).optJSONObject(TransferContants.BankData.JSON_KEY_FULL_LIST);
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    TransStore.getInstance().addBankItem(Integer.parseInt(optJSONObject.optString(next)), next);
                } catch (Exception unused) {
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Integer.valueOf(TransStore.getInstance().getBankCount());
    }
}
