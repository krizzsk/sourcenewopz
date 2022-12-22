package com.didiglobal.privacysdk.law.update;

import android.text.TextUtils;
import android.widget.PopupWindow;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.NetUtil;
import com.didi.sdk.util.SidConverter;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.privacysdk.GlobalPrivacySDK;
import com.didiglobal.privacysdk.law.update.BffConstants;
import com.didiglobal.privacysdk.law.update.LawPopDialogShowManager;
import com.didiglobal.privacysdk.law.update.response.LegalNotice;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;

public class LawPopDialogManager {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Logger f50664a = LoggerFactory.getLogger("LawPopDialogManager");
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static boolean f50665b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static boolean f50666c;

    public interface OnDialogClickListener {
        void onAgreeBtnCLicked();

        void onLinkClicked(String str);
    }

    public static void postTaskDelayed(FragmentActivity fragmentActivity, OnDialogClickListener onDialogClickListener) {
        postTaskDelayed(fragmentActivity, (Integer) null, (Integer) null, onDialogClickListener);
    }

    public static void postTaskDelayed(final FragmentActivity fragmentActivity, final Integer num, final Integer num2, final OnDialogClickListener onDialogClickListener) {
        if (!f50666c) {
            f50666c = true;
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    boolean unused = LawPopDialogManager.f50666c = false;
                    LawPopDialogManager.showLawPopDialog(fragmentActivity, num, num2, onDialogClickListener);
                }
            }, 3000);
        }
    }

    public static void showLawPopDialog(FragmentActivity fragmentActivity, OnDialogClickListener onDialogClickListener) {
        showLawPopDialog(fragmentActivity, (Integer) null, (Integer) null, onDialogClickListener);
    }

    public static void showLawPopDialog(final FragmentActivity fragmentActivity, final Integer num, final Integer num2, final OnDialogClickListener onDialogClickListener) {
        if (!f50665b && fragmentActivity != null && !fragmentActivity.isFinishing()) {
            m36383a(fragmentActivity, num, num2, new RpcService.Callback<LegalNotice>() {
                public void onFailure(IOException iOException) {
                }

                public void onSuccess(LegalNotice legalNotice) {
                    if (legalNotice == null || 2 == legalNotice.getErrorCode() || legalNotice.legalNoticeData == null || !"1".equals(legalNotice.legalNoticeData.popLaw)) {
                        LawPopDialogManager.f50664a.info("server response data without show law pop dialog", new Object[0]);
                    } else {
                        LawPopDialogManager.m36385b(fragmentActivity, legalNotice, num, num2, onDialogClickListener);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m36385b(FragmentActivity fragmentActivity, LegalNotice legalNotice, Integer num, Integer num2, OnDialogClickListener onDialogClickListener) {
        if (!TextUtils.isEmpty(legalNotice.legalNoticeData.title) && !TextUtils.isEmpty(legalNotice.legalNoticeData.content) && !TextUtils.isEmpty(legalNotice.legalNoticeData.linkText) && !TextUtils.isEmpty(legalNotice.legalNoticeData.linkUrl) && !f50665b && fragmentActivity != null && !fragmentActivity.isFinishing()) {
            LawPopDialogShowManager.DataBuilder dataBuilder = new LawPopDialogShowManager.DataBuilder();
            dataBuilder.setTitle(legalNotice.legalNoticeData.title);
            dataBuilder.setContent(legalNotice.legalNoticeData.content);
            dataBuilder.setLinkText(legalNotice.legalNoticeData.linkText);
            dataBuilder.setLinkUrl(legalNotice.legalNoticeData.linkUrl);
            dataBuilder.setOnDismissListener(new LawPopDialogShowManager.OnDismissListener() {
                public void onDismiss() {
                    boolean unused = LawPopDialogManager.f50665b = false;
                }
            });
            final FragmentActivity fragmentActivity2 = fragmentActivity;
            final LegalNotice legalNotice2 = legalNotice;
            final Integer num3 = num;
            final Integer num4 = num2;
            final OnDialogClickListener onDialogClickListener2 = onDialogClickListener;
            dataBuilder.setOnClickListener(new LawPopDialogShowManager.OnClickListener() {
                public void onButtonClick(PopupWindow popupWindow) {
                    if (!NetUtil.isAvailable(fragmentActivity2)) {
                        ToastHelper.showShortInfo(fragmentActivity2.getApplicationContext(), fragmentActivity2.getString(R.string.no_net));
                        return;
                    }
                    popupWindow.dismiss();
                    LawPopDialogManager.agreeLegalNotice(fragmentActivity2, legalNotice2.legalNoticeData.lawId, legalNotice2.legalNoticeData.lawVersion, num3, num4);
                    LawPopDialogManager.f50664a.info("user click agree btn", new Object[0]);
                    OnDialogClickListener onDialogClickListener = onDialogClickListener2;
                    if (onDialogClickListener != null) {
                        onDialogClickListener.onAgreeBtnCLicked();
                    }
                }

                public void onLinkClick(PopupWindow popupWindow, String str) {
                    OnDialogClickListener onDialogClickListener = onDialogClickListener2;
                    if (onDialogClickListener != null) {
                        onDialogClickListener.onLinkClicked(str);
                    }
                }
            });
            LawPopDialogShowManager.INSTANCE.show(fragmentActivity, dataBuilder);
            f50665b = true;
            f50664a.info("lawpop show", new Object[0]);
        }
    }

    public static void resetShowDialogStatus() {
        f50665b = false;
    }

    /* renamed from: a */
    private static void m36383a(FragmentActivity fragmentActivity, Integer num, Integer num2, final RpcService.Callback<LegalNotice> callback) {
        HashMap hashMap = new HashMap();
        hashMap.put("appID", GlobalPrivacySDK.getAppId(fragmentActivity));
        if (num != null) {
            hashMap.put(BlocksConst.ACTION_PARAMS_SCENE_ID, num);
        }
        if (num2 != null) {
            hashMap.put(SidConverter.BUSINESS_STR, num2);
        }
        Bff.call(new IBffProxy.Ability.Builder(fragmentActivity, BffConstants.AbilityID.ABILIY_GET_LEGAl_NOTICE).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                callback.onSuccess((LegalNotice) new Gson().fromJson((JsonElement) jsonObject, LegalNotice.class));
            }

            public void onFailure(IOException iOException) {
                callback.onFailure(iOException);
            }
        }).build());
    }

    public static void agreeLegalNotice(FragmentActivity fragmentActivity, String str, String str2) {
        agreeLegalNotice(fragmentActivity, str, str2, (Integer) null, (Integer) null);
    }

    public static void agreeLegalNotice(FragmentActivity fragmentActivity, String str, String str2, Integer num, Integer num2) {
        IBffProxy.Ability.Builder builder = new IBffProxy.Ability.Builder(fragmentActivity, BffConstants.AbilityID.ABLITY_AGREE_LEGAL_NOTICE);
        HashMap hashMap = new HashMap();
        hashMap.put("appID", GlobalPrivacySDK.getAppId(fragmentActivity));
        hashMap.put("law_id", str);
        hashMap.put("law_version", str2);
        if (num != null) {
            hashMap.put(BlocksConst.ACTION_PARAMS_SCENE_ID, num);
        }
        if (num2 != null) {
            hashMap.put(SidConverter.BUSINESS_STR, num2);
        }
        builder.setParams(hashMap);
        builder.setCallback(new RpcService.Callback<JsonObject>() {
            public void onSuccess(JsonObject jsonObject) {
                LawPopDialogManager.f50664a.info("agreeLegalNotice response success", new Object[0]);
            }

            public void onFailure(IOException iOException) {
                LawPopDialogManager.f50664a.info("agreeLegalNotice response failure", new Object[0]);
            }
        });
        Bff.call(builder.build());
        f50664a.info(!f50665b ? "user agreeLegalNotice with login" : "user agreeLegalNotice with dialog show", new Object[0]);
    }
}
