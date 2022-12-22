package com.didi.payment.base.anti;

import android.content.Context;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

public class AccessBlockManager {
    public static final int ERROR_ANTI_FRAUD_WALLET_ACCESS_NEED_FACE_CNH = 10010;
    public static final int ERROR_ANTI_FRAUD_WALLET_ACCESS_NEED_FACE_RG = 10011;
    public static final int ERROR_ANTI_FRAUD_WALLET_ACCESS_NEED_FULL_KYC = 10012;
    public static final String PARAM_ACCESS_BLOCK = "param_access_block";
    public static final String PARAM_ACCESS_BLOCK_CODE = "param_access_block_code";
    public static final String PARAM_ACCESS_BLOCK_PAGE_CHOOSE_ID = "chooseIdType";
    public static final String PARAM_ACCESS_BLOCK_PAGE_SCENE = "scene";
    public static final String PARAM_ACCESS_BLOCK_PAGE_SOURCE = "param_source";

    /* renamed from: a */
    private static final String f29857a = "99pay://one/pix_register?source=4";

    /* renamed from: b */
    private static AccessBlockManager f29858b;

    public static AccessBlockManager getInstance() {
        if (f29858b == null) {
            synchronized (AccessBlockManager.class) {
                if (f29858b == null) {
                    f29858b = new AccessBlockManager();
                }
            }
        }
        return f29858b;
    }

    public void checkResponse(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("errno");
            if (10010 == optInt || 10011 == optInt || 10012 == optInt) {
                int i = 0;
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                if (optJSONObject != null) {
                    i = optJSONObject.optInt("source");
                }
                ((Request) ((Request) ((Request) ((Request) DRouter.build(f29857a).putExtra(PARAM_ACCESS_BLOCK, true)).putExtra(PARAM_ACCESS_BLOCK_CODE, optInt)).putExtra("scene", PARAM_ACCESS_BLOCK_PAGE_CHOOSE_ID)).putExtra(PARAM_ACCESS_BLOCK_PAGE_SOURCE, i)).start((Context) null, new RouterCallback() {
                    public void onResult(Result result) {
                        EventBus.getDefault().post(new AccessBlockEvent());
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
