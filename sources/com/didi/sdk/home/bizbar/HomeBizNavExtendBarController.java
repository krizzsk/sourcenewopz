package com.didi.sdk.home.bizbar;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.framework.pages.invitation.InvitationPageActivity;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.didi.sdk.home.model.TopCarGroupWrapper;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeBizNavExtendBarController {

    /* renamed from: a */
    BizGridItemAdapter f36392a;

    /* renamed from: b */
    BizGridItemAdapter f36393b;

    /* renamed from: c */
    List<TopCarGroupWrapper> f36394c = new ArrayList();

    /* renamed from: d */
    List<TopCarGroupWrapper> f36395d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ViewGroup f36396e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f36397f;

    /* renamed from: g */
    private View f36398g;

    /* renamed from: h */
    private View f36399h;

    /* renamed from: i */
    private GridView f36400i;

    /* renamed from: j */
    private GridView f36401j;

    /* renamed from: k */
    private View f36402k;

    /* renamed from: l */
    private boolean f36403l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public BizNavItemMgr f36404m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public ExtendSelectListener f36405n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f36406o = 4;

    public interface ExtendSelectListener {
        void onSelect(CarGrop carGrop);
    }

    public HomeBizNavExtendBarController(BizNavItemMgr bizNavItemMgr) {
        this.f36404m = bizNavItemMgr;
        this.f36406o = bizNavItemMgr.getMaxColumnNum() - 1;
    }

    public void showExtendBar(Context context, ViewGroup viewGroup) {
        if (!this.f36403l) {
            this.f36396e = viewGroup;
            View inflate = LayoutInflater.from(context).inflate(R.layout.new_ui_biz_extend_bar, viewGroup, false);
            this.f36397f = inflate;
            this.f36398g = inflate.findViewById(R.id.biz_bar_expand_container);
            this.f36399h = this.f36397f.findViewById(R.id.biz_bar_expand_bg);
            m25767a();
            viewGroup.addView(this.f36397f);
            Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.new_ui_bottom_in);
            loadAnimation.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
            this.f36398g.startAnimation(loadAnimation);
            this.f36399h.startAnimation(GlobalUIKitAnimationFactory.getAlphaAnimation(0.0f, 1.0f, GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT, false, true, 400, 0, 0, (Animation.AnimationListener) null));
            this.f36404m.updateNavRedPointItemView();
            this.f36403l = true;
        }
    }

    public void hideExtendBar() {
        if (this.f36397f != null && this.f36396e != null && this.f36403l) {
            this.f36399h.startAnimation(GlobalUIKitAnimationFactory.getAlphaAnimation(1.0f, 0.0f, GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT, true, false, 400, 0, 0, (Animation.AnimationListener) null));
            Animation loadAnimation = AnimationUtils.loadAnimation(this.f36397f.getContext(), R.anim.new_ui_bottom_out);
            loadAnimation.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    HomeBizNavExtendBarController.this.f36396e.removeView(HomeBizNavExtendBarController.this.f36397f);
                }
            });
            this.f36398g.startAnimation(loadAnimation);
            this.f36403l = false;
        }
    }

    /* renamed from: a */
    private void m25767a() {
        this.f36397f.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                HomeBizNavExtendBarController.this.hideExtendBar();
                return true;
            }
        });
        GridView gridView = (GridView) this.f36397f.findViewById(R.id.biz_bar_expand_more_container);
        this.f36401j = gridView;
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                if (HomeBizNavExtendBarController.this.f36405n != null && HomeBizNavExtendBarController.this.f36404m.getList() != null && HomeBizNavExtendBarController.this.f36404m.getList().size() > HomeBizNavExtendBarController.this.f36406o + i) {
                    TopCarGroupWrapper topCarGroupWrapper = HomeBizNavExtendBarController.this.f36404m.getList().get(i + HomeBizNavExtendBarController.this.f36406o);
                    HomeBizNavExtendBarController.this.f36404m.changeItemToMainBar(topCarGroupWrapper);
                    HomeBizNavExtendBarController.this.hideExtendBar();
                    HomeBizNavExtendBarController.this.f36405n.onSelect(topCarGroupWrapper.carGrop);
                }
            }
        });
        GridView gridView2 = (GridView) this.f36397f.findViewById(R.id.biz_bar_expand_main_container);
        this.f36400i = gridView2;
        gridView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                if (HomeBizNavExtendBarController.this.f36405n != null && HomeBizNavExtendBarController.this.f36404m.getList() != null && HomeBizNavExtendBarController.this.f36404m.getList().size() > i) {
                    HomeBizNavExtendBarController.this.hideExtendBar();
                    TopCarGroupWrapper topCarGroupWrapper = HomeBizNavExtendBarController.this.f36404m.getList().get(i);
                    if (topCarGroupWrapper != null) {
                        if (topCarGroupWrapper.isSelected) {
                            HomeBizNavExtendBarController.this.reportExtendHide("samebusiness");
                        }
                        HomeBizNavExtendBarController.this.f36405n.onSelect(topCarGroupWrapper.carGrop);
                    }
                }
            }
        });
        m25769b();
        this.f36392a = new BizGridItemAdapter();
        this.f36393b = new BizGridItemAdapter();
        this.f36392a.setData(this.f36395d);
        this.f36392a.f36359a = this.f36404m;
        this.f36401j.setAdapter(this.f36392a);
        this.f36393b.setData(this.f36394c);
        this.f36393b.f36359a = this.f36404m;
        this.f36400i.setAdapter(this.f36393b);
        View findViewById = this.f36397f.findViewById(R.id.biz_bar_expand_blank);
        this.f36402k = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                HomeBizNavExtendBarController.this.hideExtendBar();
                HomeBizNavExtendBarController.this.reportExtendHide(InvitationPageActivity.BLANK);
            }
        });
    }

    public void setSelectListener(ExtendSelectListener extendSelectListener) {
        this.f36405n = extendSelectListener;
    }

    /* renamed from: b */
    private void m25769b() {
        this.f36394c.clear();
        this.f36395d.clear();
        for (int i = 0; i < this.f36404m.getList().size(); i++) {
            if (i < this.f36406o) {
                this.f36394c.add(this.f36404m.getList().get(i));
            } else {
                this.f36395d.add(this.f36404m.getList().get(i));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void reportExtendHide(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        OmegaSDKAdapter.trackEvent("ibt_gp_changebusiness_more_close_ck", (Map<String, Object>) hashMap);
    }
}
