package com.didiglobal.p205sa.biz.component.guide.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.global.common.com.UiUtils;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.guide.GuideTipModel;
import com.didiglobal.p205sa.biz.component.guide.view.GuideView;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.ICardPosition;
import com.didiglobal.p205sa.biz.component.sapanel.model.SACardProperty;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.guide.view.Guider */
public class Guider {
    public static final String kingkong_item_tips = "sa_business_icon";

    /* renamed from: a */
    private final RecyclerView.LayoutManager f50989a;

    /* renamed from: b */
    private final Context f50990b;

    /* renamed from: c */
    private GuideTipModel f50991c;

    /* renamed from: d */
    private RecyclerView f50992d;

    /* renamed from: e */
    private List<GudieModel> f50993e;

    /* renamed from: f */
    private int f50994f = 0;

    public Guider(Context context, RecyclerView recyclerView, List<SACardProperty> list, GuideTipModel guideTipModel) {
        this.f50990b = context;
        this.f50992d = recyclerView;
        this.f50989a = recyclerView.getLayoutManager();
        this.f50991c = guideTipModel;
        m36536a(list);
    }

    /* renamed from: a */
    private void m36536a(List<SACardProperty> list) {
        String[] strArr;
        this.f50993e = new ArrayList();
        if (this.f50991c.getUser_type() == 1) {
            strArr = new String[]{"sa_business_icon", ComponentType.COMPONENT_BUSINESS_CARD, ComponentType.COMPONENT_RECOMMEND};
        } else {
            strArr = new String[]{ComponentType.COMPONENT_RIDE_CARD, ComponentType.COMPONENT_BUSINESS_CARD, ComponentType.COMPONENT_RECOMMEND};
        }
        for (String str : strArr) {
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                } else if (str.equals("sa_business_icon") && ComponentType.COMPONENT_BUSINESS_CARD.equals(list.get(i).getId())) {
                    GudieModel gudieModel = new GudieModel();
                    gudieModel.f50995id = str;
                    gudieModel.postion = i;
                    GuideView a = m36530a(str, i, list);
                    if (a != null) {
                        gudieModel.guideView = a;
                        this.f50993e.add(gudieModel);
                    }
                } else if (str.equals(list.get(i).getId())) {
                    GudieModel gudieModel2 = new GudieModel();
                    gudieModel2.f50995id = str;
                    gudieModel2.postion = i;
                    GuideView a2 = m36530a(str, i, list);
                    if (a2 != null) {
                        gudieModel2.guideView = a2;
                        this.f50993e.add(gudieModel2);
                    }
                } else {
                    i++;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36532a() {
        if (this.f50994f < this.f50993e.size()) {
            this.f50993e.get(this.f50994f).guideView.hide();
            int i = this.f50994f + 1;
            this.f50994f = i;
            if (i >= this.f50993e.size()) {
                this.f50989a.smoothScrollToPosition(this.f50992d, new RecyclerView.State(), 0);
                return;
            }
            this.f50989a.smoothScrollToPosition(this.f50992d, new RecyclerView.State(), this.f50993e.get(i).postion);
            View findViewByPosition = this.f50989a.findViewByPosition(this.f50993e.get(i).postion);
            if (findViewByPosition != null) {
                int top = findViewByPosition.getTop();
                int height = findViewByPosition.getHeight();
                this.f50992d.scrollBy(0, top - ((this.f50992d.getHeight() / 2) - (height / 2)));
                this.f50993e.get(i).guideView.show();
                m36535a(this.f50993e.get(i).f50995id, "ibt_gp_noob_sw");
            }
        }
    }

    /* renamed from: a */
    private GuideView m36530a(final String str, int i, List<SACardProperty> list) {
        GuideView.Direction direction;
        IGuideInterface iGuideInterface;
        View view;
        int i2;
        GuideView.Direction direction2;
        ICardPosition position;
        int i3;
        GuideView.Direction direction3 = GuideView.Direction.CENTER_TIPS_BOTTOM;
        int dimension = (int) this.f50990b.getResources().getDimension(R.dimen.view_bg_content);
        int dimension2 = (int) this.f50990b.getResources().getDimension(R.dimen.view_bg_arrow);
        if (str.equals("sa_business_icon")) {
            ICardPosition position2 = list.get(i).getPosition();
            view = position2 != null ? position2.getCardPosition("soda") : null;
            int i4 = i + 1;
            int i5 = 0;
            while (i4 < list.size() && (r7 = this.f50989a.findViewByPosition(i4)) != null && (i5 = i5 + r7.getHeight()) <= dimension2) {
                i4++;
            }
            if (i5 > dimension2) {
                direction = GuideView.Direction.BOTTOM_ARROW;
                i3 = 0;
            } else {
                direction = GuideView.Direction.TOP_ARROW;
                i3 = 1;
            }
            iGuideInterface = new GuideBgArrow(this.f50990b, i3);
        } else {
            View view2 = list.get(i).getView();
            if (ComponentType.COMPONENT_RECOMMEND.equals(str) && (position = list.get(i).getPosition()) != null) {
                view2 = position.getCardPosition("recomd");
            }
            int i6 = i + 1;
            int i7 = 0;
            while (i6 < list.size() && (r7 = this.f50989a.findViewByPosition(i6)) != null && (i7 = i7 + r7.getHeight()) <= dimension) {
                i6++;
            }
            if (i7 > dimension) {
                direction2 = GuideView.Direction.CENTER_TIPS_BOTTOM;
                i2 = 1;
            } else {
                direction2 = GuideView.Direction.CENTER_TIPS_TOP;
                i2 = 0;
            }
            View view3 = view2;
            iGuideInterface = new GuideBgViewTips(this.f50990b, i2);
            view = view3;
        }
        if (view == null || view.getHeight() == 0 || view.getWidth() == 0) {
            return null;
        }
        iGuideInterface.setOnGetClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                Guider.this.m36535a(str, "ibt_gp_noob_ck");
                Guider.this.m36532a();
            }
        });
        iGuideInterface.setGuideTips(m36531a(str));
        iGuideInterface.setBtnText(m36537b());
        GuideView build = GuideView.Builder.newInstance(this.f50990b).setTargetView(view).setCustomGuideView((View) iGuideInterface).setDirction(direction).setShape(GuideView.MyShape.RECTANGULAR).setBgColor(Color.parseColor("#B30A121A")).build();
        if (ComponentType.COMPONENT_RECOMMEND.equals(str)) {
            build.setBgmargin(0);
            build.setTargetViewpadding(UiUtils.dip2px(this.f50990b, 6.0f));
            build.setVisiblePaddings(new Rect(UiUtils.dip2px(this.f50990b, 6.0f), 0, UiUtils.dip2px(this.f50990b, 6.0f), 0));
            int dimension3 = ((int) this.f50990b.getResources().getDimension(R.dimen.view_bg_radius)) * 2;
            int dimension4 = ((int) this.f50990b.getResources().getDimension(R.dimen.view_radius)) * 2;
            GuideBgViewTips guideBgViewTips = (GuideBgViewTips) iGuideInterface;
            guideBgViewTips.setmAllBgDiameter(guideBgViewTips.getmTipType() == 1 ? new int[]{dimension4, dimension4, dimension3, dimension3} : new int[]{dimension3, dimension3, dimension4, dimension4});
        }
        if (ComponentType.COMPONENT_BUSINESS_CARD.equals(str)) {
            build.setVisiblePaddings(new Rect(UiUtils.dip2px(this.f50990b, 16.0f), UiUtils.dip2px(this.f50990b, 10.0f), UiUtils.dip2px(this.f50990b, 16.0f), UiUtils.dip2px(this.f50990b, 17.0f)));
        }
        return build;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36535a(String str, String str2) {
        HashMap hashMap = new HashMap(1);
        hashMap.put(ParamConst.PARAM_MODULE_ID, str);
        OmegaSDKAdapter.trackEvent(str2, (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    private String m36537b() {
        GuideTipModel guideTipModel = this.f50991c;
        if (guideTipModel == null) {
            return "";
        }
        return guideTipModel.getAction_button();
    }

    /* renamed from: a */
    private String m36531a(String str) {
        if (this.f50991c == null) {
            return "";
        }
        if (ComponentType.COMPONENT_RECOMMEND.equals(str)) {
            return this.f50991c.getRecommend_card_tips();
        }
        if (ComponentType.COMPONENT_RIDE_CARD.equals(str)) {
            return this.f50991c.getMain_card_tips();
        }
        if (ComponentType.COMPONENT_BUSINESS_CARD.equals(str)) {
            return this.f50991c.getKingkong_card_tips();
        }
        if ("sa_business_icon".equals(str)) {
            return this.f50991c.getKingkong_item_tips();
        }
        return "";
    }

    public void showGuides() {
        if (this.f50989a != null && this.f50993e.size() > 0) {
            this.f50989a.smoothScrollToPosition(this.f50992d, new RecyclerView.State(), this.f50993e.get(0).postion);
            View findViewByPosition = this.f50989a.findViewByPosition(this.f50993e.get(0).postion);
            if (findViewByPosition != null) {
                int top = findViewByPosition.getTop();
                int height = findViewByPosition.getHeight();
                this.f50992d.scrollBy(0, top - ((this.f50992d.getHeight() / 2) - (height / 2)));
                this.f50993e.get(0).guideView.show();
                m36535a(this.f50993e.get(0).f50995id, "ibt_gp_noob_sw");
            }
        }
    }

    /* renamed from: com.didiglobal.sa.biz.component.guide.view.Guider$GudieModel */
    public class GudieModel {
        public GuideView guideView;

        /* renamed from: id */
        public String f50995id;
        public int postion;

        public GudieModel() {
        }
    }
}
