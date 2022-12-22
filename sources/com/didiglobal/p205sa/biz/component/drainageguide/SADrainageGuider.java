package com.didiglobal.p205sa.biz.component.drainageguide;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.global.common.com.UiUtils;
import com.didi.sdk.util.SaApolloUtil;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.drainageguide.SADrainageGuideView;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.ICardPosition;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuider */
public class SADrainageGuider {
    public static final String kingkong_item_tips = "sa_business_icon";

    /* renamed from: a */
    private final RecyclerView.LayoutManager f50922a;

    /* renamed from: b */
    private final Context f50923b;

    /* renamed from: c */
    private SADrainageModel f50924c;

    /* renamed from: d */
    private RecyclerView f50925d;

    /* renamed from: e */
    private List<GudieModel> f50926e;

    /* renamed from: f */
    private int f50927f = 0;

    /* renamed from: g */
    private long f50928g;

    public SADrainageGuider(Context context, RecyclerView recyclerView, List<SACardProperty> list, SADrainageModel sADrainageModel) {
        this.f50923b = context;
        this.f50925d = recyclerView;
        this.f50922a = recyclerView.getLayoutManager();
        this.f50924c = sADrainageModel;
        m36508a(list);
    }

    /* renamed from: a */
    private void m36508a(List<SACardProperty> list) {
        this.f50926e = new ArrayList();
        String[] strArr = {this.f50924c.getBusiness_type()};
        for (int i = 0; i < 1; i++) {
            String str = strArr[i];
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    break;
                } else if (ComponentType.COMPONENT_BUSINESS_CARD.equals(list.get(i2).getId())) {
                    GudieModel gudieModel = new GudieModel();
                    gudieModel.f50929id = str;
                    gudieModel.postion = i2;
                    SADrainageGuideView a = m36505a(str, i2, list);
                    if (a != null) {
                        gudieModel.guideView = a;
                        this.f50926e.add(gudieModel);
                    }
                } else {
                    i2++;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36506a() {
        if (this.f50927f < this.f50926e.size()) {
            this.f50926e.get(this.f50927f).guideView.hide();
            HashMap hashMap = new HashMap(1);
            hashMap.put("time", Long.valueOf(System.currentTimeMillis() - this.f50928g));
            omegaTrack("ibt_gp_grayband_staytime_sw", hashMap);
            int i = this.f50927f + 1;
            this.f50927f = i;
            if (i >= this.f50926e.size()) {
                this.f50922a.smoothScrollToPosition(this.f50925d, new RecyclerView.State(), 0);
                return;
            }
            this.f50922a.smoothScrollToPosition(this.f50925d, new RecyclerView.State(), this.f50926e.get(i).postion);
            View findViewByPosition = this.f50922a.findViewByPosition(this.f50926e.get(i).postion);
            if (findViewByPosition != null) {
                int top = findViewByPosition.getTop();
                int height = findViewByPosition.getHeight();
                this.f50925d.scrollBy(0, top - ((this.f50925d.getHeight() / 2) - (height / 2)));
                this.f50926e.get(i).guideView.show();
            }
        }
    }

    /* renamed from: a */
    private SADrainageGuideView m36505a(String str, int i, List<SACardProperty> list) {
        SADrainageGuideView.Direction direction = SADrainageGuideView.Direction.CENTER_TIPS_BOTTOM;
        int dip2px = UiUtils.dip2px(this.f50923b, 200.0f);
        ICardPosition position = list.get(i).getPosition();
        View cardPosition = position != null ? position.getCardPosition(str) : null;
        SADrainageGuideView.Direction direction2 = SADrainageGuideView.Direction.ANIMATION_TIPS_BOTTOM;
        int i2 = 1;
        if (cardPosition != null) {
            int[] iArr = new int[2];
            cardPosition.getLocationInWindow(iArr);
            if (iArr[1] > dip2px) {
                i2 = 0;
                direction2 = SADrainageGuideView.Direction.ANIMATION_TIPS_TOP;
            }
        }
        SADrainageGuideBgViewTips sADrainageGuideBgViewTips = new SADrainageGuideBgViewTips(this.f50923b, i2);
        if (cardPosition == null || cardPosition.getHeight() == 0 || cardPosition.getWidth() == 0) {
            return null;
        }
        sADrainageGuideBgViewTips.setOnGetClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SADrainageGuider.this.omegaTrack("ibt_gp_grayband_close_ck", (HashMap) null);
                SADrainageGuider.this.m36506a();
            }
        });
        sADrainageGuideBgViewTips.setmGuideViewListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SADrainageGuider.this.omegaTrack("ibt_gp_grayband_ck", (HashMap) null);
                SADrainageGuider.this.m36506a();
            }
        });
        sADrainageGuideBgViewTips.setData(this.f50924c);
        SADrainageGuideView build = SADrainageGuideView.Builder.newInstance(this.f50923b).setTargetView(cardPosition).setCustomGuideView(sADrainageGuideBgViewTips).setDirction(direction2).setShape(SADrainageGuideView.MyShape.RECTANGULAR).setBgColor(Color.parseColor("#B30A121A")).build();
        build.setOnTouchOutListener(new SADrainageGuideView.DrainageClickListener() {
            public void onClickDrainage(boolean z) {
                if (z) {
                    SADrainageGuider.this.omegaTrack("ibt_gp_grayband_tab_ck", (HashMap) null);
                } else {
                    SADrainageGuider.this.omegaTrack("ibt_gp_out_grayband_ck", (HashMap) null);
                }
            }
        });
        return build;
    }

    public void showGuides() {
        if (this.f50922a != null && this.f50926e.size() > 0) {
            this.f50922a.smoothScrollToPosition(this.f50925d, new RecyclerView.State(), this.f50926e.get(0).postion);
            View findViewByPosition = this.f50922a.findViewByPosition(this.f50926e.get(0).postion);
            if (findViewByPosition != null) {
                int top = findViewByPosition.getTop();
                int height = findViewByPosition.getHeight();
                this.f50925d.scrollBy(0, top - ((this.f50925d.getHeight() / 2) - (height / 2)));
                this.f50926e.get(0).guideView.show();
                this.f50928g = System.currentTimeMillis();
                omegaTrack("ibt_gp_grayband_sw", (HashMap) null);
            }
        }
    }

    public void omegaTrack(String str, HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.put("tag", getSAType());
        SADrainageModel sADrainageModel = this.f50924c;
        if (!(sADrainageModel == null || sADrainageModel.getLog_data() == null)) {
            hashMap2.putAll(this.f50924c.getLog_data());
        }
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap2);
    }

    public static String getSAType() {
        SaApolloUtil.SaType saType = SaApolloUtil.INSTANCE.getSaType();
        if (saType == SaApolloUtil.SaType.SA_A) {
            return ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
        }
        if (saType == SaApolloUtil.SaType.SA_B) {
            return "B";
        }
        return saType == SaApolloUtil.SaType.SA_C ? "C" : "default";
    }

    /* renamed from: com.didiglobal.sa.biz.component.drainageguide.SADrainageGuider$GudieModel */
    public class GudieModel {
        public SADrainageGuideView guideView;

        /* renamed from: id */
        public String f50929id;
        public int postion;

        public GudieModel() {
        }
    }
}
