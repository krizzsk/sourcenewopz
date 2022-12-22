package com.didi.component.comp_new_xpanel.template;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import com.android.didi.bfflib.business.BffNetConstant;
import com.didi.component.business.xpanelnew.OmegaXPTrack;
import com.didi.component.comp_new_xpanel.AbsNewXPanelPresenter;
import com.didi.sdk.log.Logger;
import com.didi.sdk.monitor.QualityCheckTrackImpl;
import com.didi.sdk.paxadsdk.AdLoadListenner;
import com.didi.sdk.paxadsdk.GlobalAdManager;
import com.didi.sdk.paxadsdk.NativeAdStyle;
import com.didi.soda.compose.card.BaseCard;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.didiglobal.enginecore.template.temp.IXEView;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class XpTemplateAdCardView implements IXEView<XpTemplateAdCardModel> {

    /* renamed from: a */
    private static final String f12303a = "XpTemplateAdCardView";

    /* renamed from: b */
    private Context f12304b;

    /* renamed from: c */
    private View f12305c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CardView f12306d;

    /* renamed from: e */
    private final int f12307e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f12308f = 0;

    /* renamed from: c */
    static /* synthetic */ int m8349c(XpTemplateAdCardView xpTemplateAdCardView) {
        int i = xpTemplateAdCardView.f12308f;
        xpTemplateAdCardView.f12308f = i + 1;
        return i;
    }

    public void initView(Context context) {
        this.f12304b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.g_xp_template_ad_card, (ViewGroup) null);
        this.f12305c = inflate;
        this.f12306d = (CardView) inflate.findViewById(R.id.ad_container);
    }

    public void bindData(final XpTemplateAdCardModel xpTemplateAdCardModel) {
        if (xpTemplateAdCardModel == null || xpTemplateAdCardModel.normal == null || xpTemplateAdCardModel.normal.data == null || TextUtils.isEmpty(xpTemplateAdCardModel.normal.data.agency) || TextUtils.isEmpty(xpTemplateAdCardModel.normal.data.adid)) {
            this.f12305c.setVisibility(8);
        } else if (!AbsNewXPanelPresenter.cachedAdViews.containsKey(xpTemplateAdCardModel.normal.data.adid) || AbsNewXPanelPresenter.cachedAdViews.get(xpTemplateAdCardModel.normal.data.adid) == null) {
            GlobalAdManager.getInstance().loadNativeAD(this.f12304b, xpTemplateAdCardModel.normal.data.agency, NativeAdStyle.Small_CARD, xpTemplateAdCardModel.normal.data.adid, new AdLoadListenner() {
                public void onAdClosed() {
                }

                public void onAdLoaded() {
                }

                public void onAdOpened() {
                }

                public void onSuccess(View view) {
                    if (AbsNewXPanelPresenter.entered) {
                        XpTemplateAdCardView.this.f12306d.removeAllViews();
                        XpTemplateAdCardView.this.f12306d.addView(view);
                        AbsNewXPanelPresenter.cachedAdViews.put(xpTemplateAdCardModel.normal.data.adid, view);
                    }
                    int unused = XpTemplateAdCardView.this.f12308f = 0;
                    Logger.m25811i(XpTemplateAdCardView.f12303a, "load ad success ");
                }

                public void onFailed(String str, String str2, String str3) {
                    Logger.m25811i(XpTemplateAdCardView.f12303a, "load ad failed " + str3);
                    if (XpTemplateAdCardView.this.f12308f <= 0) {
                        XpTemplateAdCardView.m8349c(XpTemplateAdCardView.this);
                        Logger.m25811i(XpTemplateAdCardView.f12303a, "retry load ad " + XpTemplateAdCardView.this.f12308f);
                        HashMap hashMap = new HashMap();
                        hashMap.put("agency", xpTemplateAdCardModel.normal.data.agency);
                        hashMap.put(Constants.JSON_KEY_ANDID, xpTemplateAdCardModel.normal.data.adid);
                        hashMap.put("errmsg", str2);
                        hashMap.put(BffNetConstant.ERR_CODE, str);
                        int i = -1;
                        try {
                            i = Integer.parseInt(str);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        QualityCheckTrackImpl.trackError("tech_admob_resource_sw", i, hashMap);
                        XpTemplateAdCardView.this.bindData(xpTemplateAdCardModel);
                    }
                }

                public void onAdClicked() {
                    XpTemplateAdCardModel xpTemplateAdCardModel = xpTemplateAdCardModel;
                    if (xpTemplateAdCardModel != null) {
                        OmegaXPTrack.omegaTrackWhenClickCard(xpTemplateAdCardModel);
                    }
                }

                public void onAdImpression() {
                    if (xpTemplateAdCardModel != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put(BaseCard.KEY_CARD_ID, xpTemplateAdCardModel.f50198id);
                        try {
                            if (!(xpTemplateAdCardModel.extension == null || xpTemplateAdCardModel.extension.log_data == null)) {
                                String jSONObject = xpTemplateAdCardModel.extension.log_data.toString();
                                HashMap hashMap2 = new HashMap();
                                if (xpTemplateAdCardModel.extension.extra != null) {
                                    for (String str : xpTemplateAdCardModel.extension.extra.keySet()) {
                                        hashMap.put(str, xpTemplateAdCardModel.extension.extra.get(str));
                                    }
                                }
                                hashMap.putAll((Map) new Gson().fromJson((JsonElement) new JsonParser().parse(jSONObject).getAsJsonObject(), hashMap2.getClass()));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        OmegaSDKAdapter.trackEvent("ibt_gp_ad_xpanel_sw", (Map<String, Object>) hashMap);
                    }
                }
            });
        } else {
            View view = AbsNewXPanelPresenter.cachedAdViews.get(xpTemplateAdCardModel.normal.data.adid);
            if (view.getParent() != null) {
                Logger.m25808d("admob", "last cached view has parent");
                ((ViewGroup) view.getParent()).removeView(view);
            }
            Logger.m25808d("admob", "add last cached view");
            this.f12306d.removeAllViews();
            this.f12306d.addView(view);
        }
    }

    public View getView() {
        return this.f12305c;
    }
}
