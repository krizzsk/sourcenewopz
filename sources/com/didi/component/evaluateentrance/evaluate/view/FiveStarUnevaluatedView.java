package com.didi.component.evaluateentrance.evaluate.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.evaluateentrance.evaluate.model.FiveStarModel;
import com.didi.component.evaluateentrance.evaluate.presenter.AbsFiveStarPresenter;
import com.didi.component.evaluateentrance.evaluate.toolkit.ViewToolKit;
import com.didi.component.evaluateentrance.evaluate.view.FiveStarRenderView;
import com.taxis99.R;

public class FiveStarUnevaluatedView implements IFiveStarView {

    /* renamed from: a */
    private final ViewGroup f13530a;

    /* renamed from: b */
    private final ViewToolKit f13531b;

    /* renamed from: c */
    private final FiveStarRenderView f13532c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AbsFiveStarPresenter f13533d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GXPEvaluateTipPayDrawer f13534e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f13535f;

    public FiveStarUnevaluatedView(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.g_xp_evaluate_five_star_layout, (ViewGroup) null, false);
        this.f13530a = viewGroup;
        ViewToolKit create = ViewToolKit.create(viewGroup);
        this.f13531b = create;
        this.f13532c = (FiveStarRenderView) create.findViewById(R.id.fsv_evaluate);
        m9284a();
    }

    /* renamed from: a */
    private void m9284a() {
        this.f13532c.setClickFiveStarListener(new FiveStarRenderView.OnClickFiveStarListener() {
            public void onClickFiveStarLevel(int i) {
                FiveStarUnevaluatedView.this.f13533d.onEvaluatedClicked(i, FiveStarUnevaluatedView.this.f13535f);
            }
        });
    }

    public void initData(final FiveStarModel fiveStarModel) {
        if (fiveStarModel.normal != null) {
            FiveStarModel.NormalBean normalBean = fiveStarModel.normal;
            this.f13531b.setImageView(R.id.civ_avatar, normalBean.avatarIcon, R.drawable.global_xp_driver_car_default_avatar);
            this.f13531b.setTextViewText((int) R.id.tv_title, (CharSequence) normalBean.title, (int) R.string.global_new_evaluate_five_star_title_current);
            this.f13531b.setTextViewText((int) R.id.tv_sub_title, (CharSequence) normalBean.subTitle, (int) R.string.global_new_evaluate_five_star_subtitle);
            this.f13532c.setEnable(true);
            this.f13535f = normalBean.evaluateInfoJson;
            final EvaluateTipView evaluateTipView = (EvaluateTipView) this.f13531b.findViewById(R.id.eve_tip);
            if (normalBean != null && normalBean.status == 0) {
                evaluateTipView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (FiveStarUnevaluatedView.this.f13534e == null) {
                            GXPEvaluateTipPayDrawer unused = FiveStarUnevaluatedView.this.f13534e = new GXPEvaluateTipPayDrawer(evaluateTipView.getContext(), FiveStarUnevaluatedView.this.f13533d, fiveStarModel.normal.tipInfo, "starrate", fiveStarModel.normal.avatarIcon);
                        }
                        FiveStarUnevaluatedView.this.f13534e.show();
                        GlobalOmegaUtils.trackEvent("ibt_gp_tipentrance_btn_ck", "source", "starrate");
                    }
                });
                evaluateTipView.initData(normalBean.tipInfo, "starrate");
            }
            closeDrawer();
        }
    }

    public void showEvaluated(int i) {
        this.f13532c.setEnable(false);
        this.f13532c.flushRateStar(i - 1);
        this.f13533d.refreshXpanel();
    }

    public View getView() {
        return this.f13530a;
    }

    public void setPresenter(AbsFiveStarPresenter absFiveStarPresenter) {
        this.f13533d = absFiveStarPresenter;
    }

    public void closeDrawer() {
        GXPEvaluateTipPayDrawer gXPEvaluateTipPayDrawer = this.f13534e;
        if (gXPEvaluateTipPayDrawer != null && gXPEvaluateTipPayDrawer.isShowing()) {
            this.f13534e.dismiss();
        }
    }
}
