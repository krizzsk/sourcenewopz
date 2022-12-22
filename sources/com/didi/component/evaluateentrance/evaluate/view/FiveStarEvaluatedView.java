package com.didi.component.evaluateentrance.evaluate.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.evaluateentrance.evaluate.model.FiveStarModel;
import com.didi.component.evaluateentrance.evaluate.presenter.AbsFiveStarPresenter;
import com.didi.component.evaluateentrance.evaluate.toolkit.ViewToolKit;
import com.taxis99.R;

public class FiveStarEvaluatedView implements IFiveStarView {

    /* renamed from: a */
    private final ViewGroup f13526a;

    /* renamed from: b */
    private final ViewToolKit f13527b;

    /* renamed from: c */
    private final FiveStarRenderView f13528c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AbsFiveStarPresenter f13529d;

    public void showEvaluated(int i) {
    }

    public FiveStarEvaluatedView(Context context) {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.g_xp_evaluate_five_star_completion_layout, (ViewGroup) null, false);
        this.f13526a = viewGroup;
        ViewToolKit create = ViewToolKit.create(viewGroup);
        this.f13527b = create;
        this.f13528c = (FiveStarRenderView) create.findViewById(R.id.fsv_evaluate);
    }

    public void initData(FiveStarModel fiveStarModel) {
        if (fiveStarModel.normal != null) {
            final FiveStarModel.NormalBean normalBean = fiveStarModel.normal;
            this.f13527b.setImageView(R.id.civ_avatar, normalBean.avatarIcon, R.drawable.global_xp_driver_car_default_avatar);
            if (fiveStarModel.normal.tipInfo == null || !fiveStarModel.normal.tipInfo.isPay()) {
                this.f13527b.setTextViewText((int) R.id.tv_five_start_title, (int) R.string.global_new_evaluate_five_star_complete_title);
            } else {
                this.f13527b.setTextViewText((int) R.id.tv_five_start_title, (CharSequence) fiveStarModel.normal.tipInfo.title, (int) R.string.global_new_evaluate_five_star_complete_title);
            }
            this.f13528c.setEnable(false);
            this.f13528c.flushRateStar(normalBean.level - 1);
            this.f13526a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    FiveStarEvaluatedView.this.f13529d.onEvaluatedClicked(-1, normalBean.evaluateInfoJson);
                }
            });
            return;
        }
        getView().setVisibility(8);
    }

    public View getView() {
        return this.f13526a;
    }

    public void setPresenter(AbsFiveStarPresenter absFiveStarPresenter) {
        this.f13529d = absFiveStarPresenter;
    }
}
