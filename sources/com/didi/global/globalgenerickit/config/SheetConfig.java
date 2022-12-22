package com.didi.global.globalgenerickit.config;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.drouter.api.DRouter;
import com.didi.global.globalgenerickit.CommonEventListener;
import com.didi.global.globalgenerickit.GGKData;
import com.didi.global.globalgenerickit.GGKView;
import com.didi.global.globalgenerickit.GlobalGenericKit;
import com.didi.global.globalgenerickit.callback.LEGOOnAntiShakeClickListenerImpl;
import com.didi.global.globalgenerickit.config.GGKDrawerConfigModel;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.global.globalgenerickit.utils.OmegaUtils;
import com.didi.global.globaluikit.callback.LEGOCheckboxListener;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGOBtnModelAndCallback;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.LEGODrawerModel;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SheetConfig implements IConfig {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public LEGODrawer f22055a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public LEGODrawer f22056b;

    public void show(FragmentActivity fragmentActivity, JSONArray jSONArray, GGKConfigCallbackAdapter gGKConfigCallbackAdapter) {
        if (jSONArray != null && jSONArray.length() != 0) {
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
            final GGKDrawerConfigModel gGKDrawerConfigModel = (GGKDrawerConfigModel) new Gson().fromJson(jSONObject.toString(), GGKDrawerConfigModel.class);
            if (gGKDrawerConfigModel != null) {
                gGKDrawerConfigModel.parse(gGKDrawerConfigModel);
                if (gGKConfigCallbackAdapter.sheetWillShow(gGKDrawerConfigModel.f22053id)) {
                    if (gGKDrawerConfigModel.isXml()) {
                        m15996a((Context) fragmentActivity, gGKDrawerConfigModel, gGKConfigCallbackAdapter);
                        return;
                    }
                    LEGODrawerModel lEGODrawerModel = new LEGODrawerModel();
                    if (gGKDrawerConfigModel.drawerData != null) {
                        final GGKDrawerConfigModel.LEGODrawerBusinessData lEGODrawerBusinessData = gGKDrawerConfigModel.drawerData;
                        if (lEGODrawerBusinessData.title != null) {
                            lEGODrawerModel.mRichTitle = lEGODrawerBusinessData.title;
                        }
                        if (lEGODrawerBusinessData.body != null) {
                            lEGODrawerModel.mRichSubTitle = lEGODrawerBusinessData.body;
                        }
                        boolean z = false;
                        if (lEGODrawerBusinessData.style == 0) {
                            if (lEGODrawerBusinessData.buttons != null && lEGODrawerBusinessData.buttons.size() == 2) {
                                final ButtonModel buttonModel = lEGODrawerBusinessData.buttons.get(0);
                                final ButtonModel buttonModel2 = lEGODrawerBusinessData.buttons.get(1);
                                if (!(buttonModel2 == null || buttonModel == null)) {
                                    buttonModel.f22052id = gGKDrawerConfigModel.f22053id;
                                    buttonModel2.f22052id = gGKDrawerConfigModel.f22053id;
                                    LEGOBtnModelAndCallback lEGOBtnModelAndCallback = new LEGOBtnModelAndCallback();
                                    LEGODrawerModel.WidgetModel widgetModel = new LEGODrawerModel.WidgetModel();
                                    widgetModel.text = buttonModel2.text;
                                    lEGOBtnModelAndCallback.btnModel = widgetModel;
                                    lEGOBtnModelAndCallback.listener = new LEGOOnAntiShakeClickListener() {
                                        public void onAntiShakeClick(View view) {
                                            if (!TextUtils.isEmpty(gGKDrawerConfigModel.f22053id)) {
                                                OmegaUtils.configButtonClickTrack(gGKDrawerConfigModel.f22053id, buttonModel2.actionId, Const.DRAWER, gGKDrawerConfigModel.logMap);
                                            }
                                            GGKConfigCallbackAdapter gGKConfigCallbackAdapter = gGKConfigCallbackAdapter;
                                            if (gGKConfigCallbackAdapter != null) {
                                                LEGODrawer a = SheetConfig.this.f22056b;
                                                ButtonModel buttonModel = buttonModel2;
                                                if (gGKConfigCallbackAdapter.sheetClickLis(a, buttonModel, buttonModel.link)) {
                                                    return;
                                                }
                                            }
                                            DRouter.build(buttonModel2.link).start();
                                        }
                                    };
                                    LEGOBtnModelAndCallback lEGOBtnModelAndCallback2 = new LEGOBtnModelAndCallback();
                                    LEGODrawerModel.WidgetModel widgetModel2 = new LEGODrawerModel.WidgetModel();
                                    widgetModel2.text = buttonModel.text;
                                    lEGOBtnModelAndCallback2.btnModel = widgetModel2;
                                    lEGOBtnModelAndCallback2.listener = new LEGOOnAntiShakeClickListener() {
                                        public void onAntiShakeClick(View view) {
                                            if (!TextUtils.isEmpty(gGKDrawerConfigModel.f22053id)) {
                                                OmegaUtils.configButtonClickTrack(gGKDrawerConfigModel.f22053id, buttonModel.actionId, Const.DRAWER, gGKDrawerConfigModel.logMap);
                                            }
                                            GGKConfigCallbackAdapter gGKConfigCallbackAdapter = gGKConfigCallbackAdapter;
                                            if (gGKConfigCallbackAdapter != null) {
                                                LEGODrawer a = SheetConfig.this.f22056b;
                                                ButtonModel buttonModel = buttonModel;
                                                if (gGKConfigCallbackAdapter.sheetClickLis(a, buttonModel, buttonModel.link)) {
                                                    return;
                                                }
                                            }
                                            DRouter.build(buttonModel.link).start();
                                        }
                                    };
                                    lEGODrawerModel.isTwoBtnHorizontal = true;
                                    lEGODrawerModel.majorBtn = lEGOBtnModelAndCallback;
                                    lEGODrawerModel.minorBtns = new ArrayList();
                                    lEGODrawerModel.minorBtns.add(lEGOBtnModelAndCallback2);
                                }
                            }
                        } else if (lEGODrawerBusinessData.style == 1) {
                            lEGODrawerModel.isTwoBtnHorizontal = false;
                            if (lEGODrawerBusinessData.buttons != null && lEGODrawerBusinessData.buttons.size() > 0) {
                                final ButtonModel buttonModel3 = lEGODrawerBusinessData.buttons.get(0);
                                buttonModel3.f22052id = gGKDrawerConfigModel.f22053id;
                                LEGOBtnModelAndCallback lEGOBtnModelAndCallback3 = new LEGOBtnModelAndCallback();
                                LEGODrawerModel.WidgetModel widgetModel3 = new LEGODrawerModel.WidgetModel();
                                widgetModel3.text = buttonModel3.text;
                                lEGOBtnModelAndCallback3.btnModel = widgetModel3;
                                lEGOBtnModelAndCallback3.listener = new LEGOOnAntiShakeClickListener() {
                                    public void onAntiShakeClick(View view) {
                                        if (!TextUtils.isEmpty(gGKDrawerConfigModel.f22053id)) {
                                            OmegaUtils.configButtonClickTrack(gGKDrawerConfigModel.f22053id, buttonModel3.actionId, Const.DRAWER, gGKDrawerConfigModel.logMap);
                                        }
                                        GGKConfigCallbackAdapter gGKConfigCallbackAdapter = gGKConfigCallbackAdapter;
                                        if (gGKConfigCallbackAdapter != null) {
                                            LEGODrawer a = SheetConfig.this.f22056b;
                                            ButtonModel buttonModel = buttonModel3;
                                            if (gGKConfigCallbackAdapter.sheetClickLis(a, buttonModel, buttonModel.link)) {
                                                return;
                                            }
                                        }
                                        DRouter.build(buttonModel3.link).start();
                                    }
                                };
                                lEGODrawerModel.majorBtn = lEGOBtnModelAndCallback3;
                                if (lEGODrawerBusinessData.buttons.size() > 1 && lEGODrawerBusinessData.buttons.size() <= 3) {
                                    lEGODrawerModel.minorBtns = new ArrayList();
                                    for (int i = 1; i < lEGODrawerBusinessData.buttons.size(); i++) {
                                        ButtonModel buttonModel4 = lEGODrawerBusinessData.buttons.get(i);
                                        buttonModel4.f22052id = gGKDrawerConfigModel.f22053id;
                                        LEGOBtnModelAndCallback lEGOBtnModelAndCallback4 = new LEGOBtnModelAndCallback();
                                        LEGODrawerModel.WidgetModel widgetModel4 = new LEGODrawerModel.WidgetModel();
                                        widgetModel4.text = buttonModel4.text;
                                        lEGOBtnModelAndCallback4.btnModel = widgetModel4;
                                        lEGOBtnModelAndCallback4.listener = new LEGOOnAntiShakeClickListenerImpl(buttonModel4) {
                                            public void onAntiShakeClick(View view) {
                                                ButtonModel buttonModel = this.btnModel;
                                                if (!TextUtils.isEmpty(gGKDrawerConfigModel.f22053id)) {
                                                    OmegaUtils.configButtonClickTrack(gGKDrawerConfigModel.f22053id, buttonModel.actionId, Const.DRAWER, gGKDrawerConfigModel.logMap);
                                                }
                                                GGKConfigCallbackAdapter gGKConfigCallbackAdapter = gGKConfigCallbackAdapter;
                                                if (gGKConfigCallbackAdapter == null || !gGKConfigCallbackAdapter.sheetClickLis(SheetConfig.this.f22056b, buttonModel, buttonModel.link)) {
                                                    DRouter.build(buttonModel.link).start();
                                                }
                                            }
                                        };
                                        lEGODrawerModel.minorBtns.add(lEGOBtnModelAndCallback4);
                                    }
                                }
                            }
                        }
                        lEGODrawerModel.isShowCloseImg = lEGODrawerBusinessData.cancelable == 1;
                        if (lEGODrawerBusinessData.coverCancel == 1) {
                            lEGODrawerModel.clickOutsideCanCancel = true;
                            lEGODrawerModel.backPressedEnabled = true;
                        } else if (lEGODrawerBusinessData.coverCancel == 2) {
                            lEGODrawerModel.backPressedEnabled = false;
                            lEGODrawerModel.clickOutsideCanCancel = false;
                        }
                        if (!TextUtils.isEmpty(lEGODrawerBusinessData.image)) {
                            lEGODrawerModel.imgUrl = lEGODrawerBusinessData.image;
                        }
                        if (lEGODrawerBusinessData.checkbox != null) {
                            lEGODrawerModel.mRichCheckbox = lEGODrawerBusinessData.checkbox.title;
                            if (lEGODrawerBusinessData.checkbox.checked == 1) {
                                z = true;
                            }
                            lEGODrawerModel.mIsChecked = z;
                            lEGODrawerModel.mCheckListener = new LEGOCheckboxListener() {
                                public void onCheckedChanged(boolean z) {
                                }
                            };
                        }
                        if (lEGODrawerBusinessData.link != null) {
                            lEGODrawerModel.mRichLink = lEGODrawerBusinessData.link.title;
                            lEGODrawerModel.mLinkListener = new LEGOOnAntiShakeClickListener() {
                                public void onAntiShakeClick(View view) {
                                    DRouter.build(lEGODrawerBusinessData.link.link).start();
                                }
                            };
                        }
                        if (lEGODrawerBusinessData.selectedAction != null) {
                            lEGODrawerModel.mRichLeft = lEGODrawerBusinessData.selectedAction.title;
                            LEGODrawerModel.WidgetModel widgetModel5 = new LEGODrawerModel.WidgetModel();
                            widgetModel5.text = lEGODrawerBusinessData.selectedAction.selectedTitle;
                            LEGOBtnModelAndCallback lEGOBtnModelAndCallback5 = new LEGOBtnModelAndCallback();
                            lEGOBtnModelAndCallback5.btnModel = widgetModel5;
                            lEGOBtnModelAndCallback5.listener = new LEGOOnAntiShakeClickListener() {
                                public void onAntiShakeClick(View view) {
                                    DRouter.build(lEGODrawerBusinessData.selectedAction.link).start();
                                }
                            };
                            lEGODrawerModel.mRightBtn = lEGOBtnModelAndCallback5;
                        }
                        this.f22056b = new LEGODrawer(fragmentActivity, lEGODrawerModel);
                        OmegaUtils.configShowTrack(gGKDrawerConfigModel.f22053id, Const.DRAWER, gGKDrawerConfigModel.logMap);
                        this.f22056b.show();
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m15996a(final Context context, GGKDrawerConfigModel gGKDrawerConfigModel, final GGKConfigCallbackAdapter gGKConfigCallbackAdapter) {
        final GGKData gGKData = new GGKData(gGKDrawerConfigModel.f22053id, gGKDrawerConfigModel.template, gGKDrawerConfigModel.cdn, gGKDrawerConfigModel.data, gGKDrawerConfigModel.extension);
        gGKData.setCDNCallback(new GGKData.CDNCallback() {
            public void onCDNCached() {
                SheetConfig.this.m15995a(context, gGKData);
            }
        });
        gGKData.setEventListener(new CommonEventListener(gGKData) {
            public boolean handleEvent(String str, String str2, Map<String, Object> map) {
                if (!TextUtils.isEmpty(gGKData.getId())) {
                    OmegaUtils.configButtonClickTrack(gGKData.getId(), map.get(Const.BUTTON_ID) != null ? (String) map.get(Const.BUTTON_ID) : "", Const.DRAWER, gGKData.getExt());
                }
                GGKConfigCallbackAdapter gGKConfigCallbackAdapter = gGKConfigCallbackAdapter;
                if (gGKConfigCallbackAdapter != null && gGKConfigCallbackAdapter.sheetXMLClickLis(SheetConfig.this.f22055a, gGKData, str, str2, map)) {
                    return true;
                }
                DRouter.build(str2).start();
                SheetConfig.this.f22055a.dismiss();
                return true;
            }
        });
        m15995a(context, gGKData);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15995a(Context context, GGKData gGKData) {
        GGKView createTemplateView = GlobalGenericKit.createTemplateView(context, gGKData);
        if (createTemplateView != null) {
            LEGODrawerModel lEGODrawerModel = new LEGODrawerModel();
            lEGODrawerModel.allExtendView = createTemplateView.getView();
            JSONObject data = gGKData.getData();
            if (data != null) {
                lEGODrawerModel.isShowCloseImg = data.optInt("cancelable") == 1;
                int optInt = data.optInt("cover_cancel");
                if (optInt == 1) {
                    lEGODrawerModel.clickOutsideCanCancel = true;
                    lEGODrawerModel.backPressedEnabled = true;
                } else if (optInt == 2) {
                    lEGODrawerModel.backPressedEnabled = false;
                    lEGODrawerModel.clickOutsideCanCancel = false;
                }
            }
            this.f22055a = new LEGODrawer(context, lEGODrawerModel);
            OmegaUtils.configShowTrack(gGKData.getId(), Const.DRAWER, gGKData.getExt());
            this.f22055a.show();
        }
    }
}
