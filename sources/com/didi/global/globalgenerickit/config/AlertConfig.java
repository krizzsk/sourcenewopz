package com.didi.global.globalgenerickit.config;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.CommonEventListener;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.GGKView;
import com.didi.global.globalgenerickit.GlobalGenericKit;
import com.didi.global.globalgenerickit.callback.LEGOOnAntiShakeClickListenerImpl;
import com.didi.global.globalgenerickit.config.GGKDialogConfigModel;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.global.globalgenerickit.utils.OmegaUtils;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOCheckboxListener;
import com.didi.global.globaluikit.callback.LEGOImgModel;
import com.didi.global.globaluikit.dialog.LEGOBaseAlertDialogFragment;
import com.didi.global.globaluikit.dialog.LEGOCustomFragment;
import com.didi.global.globaluikit.dialog.LEGODialogFragment;
import com.didi.global.globaluikit.dialog.LEGODialogFragmentManager;
import com.didi.global.globaluikit.dialog.LEGORealUsedModel;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AlertConfig implements IConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public LEGOBaseAlertDialogFragment f22050a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LEGOBaseAlertDialogFragment f22051b;

    public void show(FragmentActivity fragmentActivity, JSONArray jSONArray, GGKConfigCallbackAdapter gGKConfigCallbackAdapter) {
        if (fragmentActivity != null && jSONArray != null && jSONArray.length() != 0) {
            if (gGKConfigCallbackAdapter == null) {
                gGKConfigCallbackAdapter = new GGKConfigCallbackAdapter();
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    show(fragmentActivity, jSONArray.getJSONObject(i), gGKConfigCallbackAdapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void show(FragmentActivity fragmentActivity, JSONObject jSONObject, final GGKConfigCallbackAdapter gGKConfigCallbackAdapter) {
        if (fragmentActivity != null && jSONObject != null) {
            if (gGKConfigCallbackAdapter == null) {
                gGKConfigCallbackAdapter = new GGKConfigCallbackAdapter();
            }
            final GGKDialogConfigModel gGKDialogConfigModel = (GGKDialogConfigModel) new Gson().fromJson(jSONObject.toString(), GGKDialogConfigModel.class);
            if (gGKDialogConfigModel != null) {
                gGKDialogConfigModel.parse(gGKDialogConfigModel);
                if (gGKConfigCallbackAdapter.alertWillShow(gGKDialogConfigModel.f22053id)) {
                    if (gGKDialogConfigModel.isXml()) {
                        m15989a((Context) fragmentActivity, fragmentActivity.getSupportFragmentManager(), gGKDialogConfigModel, gGKConfigCallbackAdapter);
                        return;
                    }
                    LEGORealUsedModel lEGORealUsedModel = new LEGORealUsedModel();
                    if (gGKDialogConfigModel.dialogData != null) {
                        GGKDialogConfigModel.LEGODialogBusinessData lEGODialogBusinessData = gGKDialogConfigModel.dialogData;
                        if (lEGODialogBusinessData.title != null) {
                            lEGORealUsedModel.mRichTitle = lEGODialogBusinessData.title;
                        }
                        if (lEGODialogBusinessData.body != null) {
                            lEGORealUsedModel.mRichSubTitle = lEGODialogBusinessData.body;
                        }
                        if (lEGODialogBusinessData.buttons != null && lEGODialogBusinessData.buttons.size() > 0) {
                            lEGORealUsedModel.mListOfBtns = new ArrayList();
                            for (int i = 0; i < lEGODialogBusinessData.buttons.size(); i++) {
                                ButtonModel buttonModel = lEGODialogBusinessData.buttons.get(i);
                                buttonModel.f22052id = gGKDialogConfigModel.f22053id;
                                lEGORealUsedModel.mListOfBtns.add(new LEGOBtnTextAndCallback(buttonModel.text, new LEGOOnAntiShakeClickListenerImpl(buttonModel) {
                                    public void onAntiShakeClick(View view) {
                                        ButtonModel buttonModel = this.btnModel;
                                        if (!TextUtils.isEmpty(gGKDialogConfigModel.f22053id)) {
                                            OmegaUtils.configButtonClickTrack(gGKDialogConfigModel.f22053id, buttonModel.actionId, Const.POPUP, gGKDialogConfigModel.logMap);
                                        }
                                        GGKConfigCallbackAdapter gGKConfigCallbackAdapter = gGKConfigCallbackAdapter;
                                        if (gGKConfigCallbackAdapter != null && gGKConfigCallbackAdapter.alertClickLis(AlertConfig.this.f22050a, buttonModel, buttonModel.link)) {
                                            return;
                                        }
                                        if (!TextUtils.isEmpty(buttonModel.link)) {
                                            DRouter.build(buttonModel.link).start();
                                        } else {
                                            LEGODialogFragmentManager.getInstance().dismissAllGGKDialog();
                                        }
                                    }
                                }));
                                if (lEGORealUsedModel.mListOfBtns.size() == 3) {
                                    break;
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(lEGODialogBusinessData.image)) {
                            LEGOImgModel lEGOImgModel = new LEGOImgModel();
                            lEGOImgModel.setImgUrl(lEGODialogBusinessData.image);
                            lEGORealUsedModel.mImageModel = lEGOImgModel;
                        }
                        if (lEGODialogBusinessData.checkbox != null) {
                            lEGORealUsedModel.mRichCheckbox = lEGODialogBusinessData.checkbox.title;
                            int i2 = lEGODialogBusinessData.checkbox.checked;
                            boolean z = true;
                            if (i2 != 1) {
                                z = false;
                            }
                            lEGORealUsedModel.mIsChecked = z;
                            lEGORealUsedModel.mCheckListener = new LEGOCheckboxListener() {
                                public void onCheckedChanged(boolean z) {
                                }
                            };
                        }
                        LEGODialogFragment newInstance = LEGODialogFragment.newInstance(lEGORealUsedModel);
                        this.f22050a = newInstance;
                        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
                        newInstance.show(supportFragmentManager, System.currentTimeMillis() + "");
                        OmegaUtils.configShowTrack(gGKDialogConfigModel.f22053id, Const.POPUP, gGKDialogConfigModel.logMap);
                        this.f22050a.setCancelable(false);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m15989a(final Context context, final FragmentManager fragmentManager, GGKDialogConfigModel gGKDialogConfigModel, final GGKConfigCallbackAdapter gGKConfigCallbackAdapter) {
        this.f22051b = new LEGOCustomFragment();
        final GGKData gGKData = new GGKData(gGKDialogConfigModel.f22053id, gGKDialogConfigModel.template, gGKDialogConfigModel.cdn, gGKDialogConfigModel.data, gGKDialogConfigModel.extension);
        gGKData.setCDNCallback(new GGKData.CDNCallback() {
            public void onCDNCached() {
                AlertConfig.this.m15988a(context, fragmentManager, gGKData);
            }
        });
        gGKData.setEventListener(new CommonEventListener(gGKData) {
            public boolean handleEvent(String str, String str2, Map<String, Object> map) {
                if (!TextUtils.isEmpty(gGKData.getId()) && !"xpanel_card_ck".equals(str)) {
                    OmegaUtils.configButtonClickTrack(gGKData.getId(), map.get(Const.BUTTON_ID) != null ? (String) map.get(Const.BUTTON_ID) : "", Const.POPUP, gGKData.getExt());
                }
                GGKConfigCallbackAdapter gGKConfigCallbackAdapter = gGKConfigCallbackAdapter;
                if (gGKConfigCallbackAdapter != null && gGKConfigCallbackAdapter.alertXMLClickLis(AlertConfig.this.f22051b, gGKData, str, str2, map)) {
                    return true;
                }
                DRouter.build(str2).start();
                LEGODialogFragmentManager.getInstance().dismissAllGGKDialog();
                return true;
            }
        });
        m15988a(context, fragmentManager, gGKData);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15988a(Context context, FragmentManager fragmentManager, GGKData gGKData) {
        LEGOBaseAlertDialogFragment lEGOBaseAlertDialogFragment;
        GGKView createTemplateView = GlobalGenericKit.createTemplateView(context, gGKData);
        if (createTemplateView != null && (lEGOBaseAlertDialogFragment = this.f22051b) != null && (lEGOBaseAlertDialogFragment instanceof LEGOCustomFragment)) {
            ((LEGOCustomFragment) lEGOBaseAlertDialogFragment).setRootView(createTemplateView.getView());
            LEGOBaseAlertDialogFragment lEGOBaseAlertDialogFragment2 = this.f22051b;
            lEGOBaseAlertDialogFragment2.show(fragmentManager, System.currentTimeMillis() + "");
            OmegaUtils.configShowTrack(gGKData.getId(), Const.POPUP, gGKData.getExt());
            this.f22051b.setCancelable(false);
        }
    }
}
