package com.didi.payment.base.view.webview.fusion.model;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterCallback;
import com.didi.global.loading.ILoadingable;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.payment.base.anti.AccessBlockEvent;
import com.didi.payment.base.view.webview.titlebar.TitleBarFactory;
import com.didi.payment.base.view.webview.util.ChooseFileHelper;
import com.didi.payment.base.view.webview.util.image.PickImageHelper;
import com.didi.payment.base.web.WalletDiminaUtil;
import com.didi.payment.wallet.global.prepaidcard.PrepaidCardManager;
import com.didi.sdk.webview.BaseWebActivity;
import com.didi.soda.compose.card.BaseCard;
import com.didi.unifiedPay.util.UIUtils;
import com.didiglobal.pay.paysecure.prepaidcard.CardPwdManager;
import com.didiglobal.pay.paysecure.prepaidcard.IActiveCardListener;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletCommonModule extends FusionBridgeModule {
    public static String driverWebName = "";
    public static CallbackFunction refreshCallback;

    public WalletCommonModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        driverWebName = hybridableContainer.getActivity().getClass().getSimpleName();
    }

    @JsInterface({"cashbackChannel"})
    public void cashbackChannel(JSONObject jSONObject) {
        DRouter.build(jSONObject.optString("routerUrl")).start(this.mContext);
    }

    @JsInterface({"openDimina"})
    public void openDimina(JSONObject jSONObject, CallbackFunction callbackFunction) {
        DRouter.build(jSONObject.optString("routerUrl")).start(this.mContext);
    }

    @JsInterface({"routerToPix"})
    public void jumpPixIndex(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            refreshCallback = callbackFunction;
            String optString = jSONObject.optString("routerUrl");
            if (!TextUtils.isEmpty(optString)) {
                DRouter.build(optString).start(this.mContext);
            }
        }
    }

    @JsInterface({"onClosePageCallback"})
    public void callbackNativeOrDimina(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            WalletDiminaUtil.INSTANCE.callbackFromH5(this.mContext, jSONObject);
        }
    }

    @JsInterface({"routerToAny"})
    public void routeToAny(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            refreshCallback = callbackFunction;
            String optString = jSONObject.optString("routerUrl");
            if (jSONObject.optBoolean("isClean")) {
                Intent intent = new Intent();
                intent.setAction(BaseWebActivity.ACTION_INTENT_BROADCAST_CLOSE);
                this.mContext.sendBroadcast(intent);
                EventBus.getDefault().post(new AccessBlockEvent());
            }
            if (!TextUtils.isEmpty(optString)) {
                DRouter.build(m21043a(optString)).start(this.mContext);
            }
        }
    }

    @JsInterface({"prepayCardActive"})
    public void prepayCardActive(JSONObject jSONObject, CallbackFunction callbackFunction) {
        int i;
        int optInt = jSONObject.optInt("activatedProgress");
        String optString = jSONObject.optString("cardId");
        String optString2 = jSONObject.optString("sessionId");
        String optString3 = jSONObject.optString("scene");
        if (optInt == 0) {
            i = 1;
        } else if (optInt == 1) {
            i = 5;
        } else {
            callbackFunction.onCallBack(m21045a(3));
            return;
        }
        final CallbackFunction callbackFunction2 = callbackFunction;
        final String str = optString;
        final String str2 = optString2;
        final String str3 = optString3;
        final int i2 = i;
        C105311 r2 = new IActiveCardListener() {
            public void onResult(int i) {
                if (i == 1) {
                    callbackFunction2.onCallBack(WalletCommonModule.this.m21045a(i));
                } else if (i == 0) {
                    callbackFunction2.onCallBack(WalletCommonModule.this.m21045a(2));
                } else if (i == 3) {
                    CardPwdManager.INSTANCE.showCreatePassword(WalletCommonModule.this.mContext, str, str2, str3, Integer.valueOf(i2), this);
                } else {
                    callbackFunction2.onCallBack(WalletCommonModule.this.m21045a(3));
                }
            }
        };
        CardPwdManager.INSTANCE.showCreatePassword(this.mContext, optString, optString2, optString3, Integer.valueOf(i), r2);
    }

    @JsInterface({"prepayCardSetting"})
    public void prepayCardSetting(JSONObject jSONObject, CallbackFunction callbackFunction) {
        final int optInt = jSONObject.optInt("currentNumberCards");
        final int optInt2 = jSONObject.optInt("maximumNumberCards");
        final String optString = jSONObject.optString("cardId");
        final boolean optBoolean = jSONObject.optBoolean("hidden");
        final boolean optBoolean2 = jSONObject.optBoolean("activated");
        final String optString2 = jSONObject.optString("cardListUrl");
        Integer valueOf = Integer.valueOf(R.id.btn_setting);
        if (!optBoolean) {
            C105322 r0 = new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    Request build = DRouter.build("99pay://one/prepaid_setting");
                    build.putExtra("currentNumberCards", optInt);
                    build.putExtra("maximumNumberCards", optInt2);
                    build.putExtra("cardId", optString);
                    build.putExtra("hidden", optBoolean);
                    build.putExtra("activated", optBoolean2);
                    build.putExtra("cardListUrl", optString2);
                    build.start(WalletCommonModule.this.mContext);
                }
            };
            ImageView imageView = new ImageView(this.mContext);
            imageView.setTag(valueOf);
            int dip2px = UIUtils.dip2px(this.mContext, 17.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
            layoutParams.addRule(21);
            layoutParams.addRule(15);
            layoutParams.rightMargin = UIUtils.dip2px(this.mContext, 56.0f);
            imageView.setLayoutParams(layoutParams);
            imageView.setOnClickListener(r0);
            Glide.with(this.mContext).load(Integer.valueOf(R.drawable.wallet_setting_entrance_icon)).into(imageView);
            TitleBarFactory.getTitleBar(this.mContext).addViewToTitleBar(this.mContext, imageView, layoutParams);
            return;
        }
        TitleBarFactory.getTitleBar(this.mContext).removeViewFromTitleBar(this.mContext, valueOf);
    }

    @JsInterface({"riskControl"})
    public void riskControl(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        String optString = jSONObject.optString("verifyType");
        String optString2 = jSONObject.optString("faceBizCode");
        String optString3 = jSONObject.optString("faceSessionId");
        String optString4 = jSONObject.optString("sessionId");
        String optString5 = jSONObject.optString("scene");
        Request build = DRouter.build("99pay://one/risk_control");
        build.putExtra("type", optString);
        build.putExtra("biz_code", optString2);
        build.putExtra("face_session_id", optString3);
        build.putExtra("session_id", optString4);
        build.putExtra("scene", optString5);
        C105333 r8 = new RouterCallback() {
            public void onResult(Result result) {
                if (WalletCommonModule.this.mContext instanceof ILoadingable) {
                    ((ILoadingable) WalletCommonModule.this.mContext).hideLoading();
                }
                int i = result.getInt("result");
                if (i == 1) {
                    callbackFunction.onCallBack(WalletCommonModule.this.m21045a(1));
                } else if (i == 0) {
                    callbackFunction.onCallBack(WalletCommonModule.this.m21045a(2));
                } else if (i == 3) {
                    callbackFunction.onCallBack(WalletCommonModule.this.m21045a(3));
                }
            }
        };
        if (this.mContext instanceof ILoadingable) {
            ((ILoadingable) this.mContext).showLoading();
        }
        build.start(this.mContext, r8);
    }

    @JsInterface({"passwordVerify"})
    public void passwordVerify(JSONObject jSONObject, final CallbackFunction callbackFunction) {
        String optString = jSONObject.optString("pwdType");
        String optString2 = jSONObject.optString("cardId");
        String optString3 = jSONObject.optString("scene");
        String optString4 = jSONObject.optString("sessionId");
        String optString5 = jSONObject.optString("paySessionId");
        HashMap hashMap = new HashMap();
        hashMap.put(BaseCard.KEY_CARD_ID, optString2);
        hashMap.put("pwd_type", optString);
        hashMap.put("scene", optString3);
        hashMap.put("session_id", optString4);
        hashMap.put("verify_pwd", "1");
        hashMap.put("pay_session_id", optString5);
        DRouter.build(m21044a(PrepaidCardManager.PREPAID_CARD_URL, (Map<String, String>) hashMap)).start(this.mContext, new RouterCallback() {
            public void onResult(Result result) {
                int i = result.getInt("result");
                CallbackFunction callbackFunction = callbackFunction;
                int i2 = 1;
                Object[] objArr = new Object[1];
                WalletCommonModule walletCommonModule = WalletCommonModule.this;
                if (i != 1) {
                    i2 = 2;
                }
                objArr[0] = walletCommonModule.m21045a(i2);
                callbackFunction.onCallBack(objArr);
            }
        });
    }

    @JsInterface({"setRightNavBtn"})
    public void navigationRight(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            final String optString = jSONObject.optString("url");
            if (!jSONObject.optBoolean("hidden")) {
                ImageView imageView = new ImageView(this.mContext);
                imageView.setTag(Integer.valueOf(R.id.btn_service));
                int dip2px = UIUtils.dip2px(this.mContext, 17.0f);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dip2px, dip2px);
                layoutParams.addRule(21);
                layoutParams.addRule(15);
                layoutParams.rightMargin = UIUtils.dip2px(this.mContext, 16.0f);
                imageView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        DRouter.build(optString).start(WalletCommonModule.this.mContext);
                    }
                });
                Glide.with(this.mContext).load(Integer.valueOf(R.drawable.wallet_service_enter_icon)).into(imageView);
                TitleBarFactory.getTitleBar(this.mContext).addViewToTitleBar(this.mContext, imageView, layoutParams);
                return;
            }
            TitleBarFactory.getTitleBar(this.mContext).removeViewFromTitleBar(this.mContext, Integer.valueOf(R.id.btn_service));
        }
    }

    @JsInterface({"navigationLeft"})
    public void navigationLeft(JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (jSONObject != null) {
            boolean optBoolean = jSONObject.optBoolean("hidden");
            this.mHybridContainer.getUpdateUIHandler().updateUI(FusionBridgeModule.UI_TARGET_HIDDEN_BACK, Boolean.valueOf(optBoolean));
        }
    }

    @JsInterface({"copyContent"})
    public void copyContent(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ((ClipboardManager) this.mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText((CharSequence) null, jSONObject.optString("content")));
        callbackFunction.onCallBack(m21045a(1));
    }

    @JsInterface({"pickImage"})
    public void pickImage(JSONObject jSONObject, CallbackFunction callbackFunction) {
        FragmentActivity fragmentActivity = (FragmentActivity) this.mHybridContainer.getActivity();
        if (fragmentActivity != null) {
            new PickImageHelper(fragmentActivity, jSONObject, callbackFunction).execute();
        }
    }

    @JsInterface({"chooseFile"})
    public void chooseFile(JSONObject jSONObject, CallbackFunction callbackFunction) {
        FragmentActivity fragmentActivity = (FragmentActivity) this.mHybridContainer.getActivity();
        if (fragmentActivity != null) {
            new ChooseFileHelper(fragmentActivity, jSONObject, callbackFunction).execute();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public JSONObject m21045a(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: a */
    private String m21043a(String str) {
        if (!str.startsWith("http")) {
            return str;
        }
        return "d" + str;
    }

    /* renamed from: a */
    private String m21044a(String str, Map<String, String> map) {
        try {
            Uri.Builder buildUpon = Uri.parse(str).buildUpon();
            for (Map.Entry next : map.entrySet()) {
                buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
            }
            return buildUpon.build().toString();
        } catch (Exception unused) {
            return str;
        }
    }
}
