package com.didi.sdk.home.bizbar;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.didi.global.globaluikit.animation.GlobalUIKitAnimationFactory;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.DIDIBaseApplication;
import com.didi.sdk.app.IBizNavBarDelegate;
import com.didi.sdk.home.bizbar.HomeBizNavExtendBarController;
import com.didi.sdk.home.model.TopCarGroupWrapper;
import com.didi.sdk.misconfig.model.CarGrop;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.util.ResourcesHelper;
import com.didiglobal.travel.util.view.ViewEx;
import com.taxis99.R;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public class HomeBizNavBarFragment extends Fragment implements IBizNavBarDelegate {

    /* renamed from: a */
    private static final String f36382a = "HomeBizNavBarFragment";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f36383b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public BizNavLayout f36384c;

    /* renamed from: d */
    private View f36385d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FrameLayout f36386e;

    /* renamed from: f */
    private HomeBizNavExtendBarController f36387f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public BizNavItemMgr f36388g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public BizSelectListener f36389h;

    /* renamed from: i */
    private int f36390i = 0;

    /* renamed from: j */
    private boolean f36391j = false;

    public interface BizSelectListener {
        void onSelect(CarGrop carGrop, CarGrop carGrop2, boolean z, int i);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflateViewAsync = ViewEx.inflateViewAsync(layoutInflater, (int) R.layout.new_ui_f_biz_bar, (ViewGroup) null, false);
        this.f36383b = inflateViewAsync;
        this.f36384c = (BizNavLayout) inflateViewAsync.findViewById(R.id.biz_nav_layout);
        this.f36385d = this.f36383b.findViewById(R.id.biz_nav_divider);
        this.f36386e = (FrameLayout) this.f36383b.findViewById(R.id.biz_nav_container);
        return this.f36383b;
    }

    public View getItemByGroupType(String str) {
        return this.f36384c.getItemByGroupType(str);
    }

    public void showBizBar() {
        if (this.f36383b == null || this.f36390i <= 1) {
            SystemUtils.log(3, f36382a, "showBizBar:" + this.f36390i, (Throwable) null, "com.didi.sdk.home.bizbar.HomeBizNavBarFragment", 77);
            return;
        }
        SystemUtils.log(3, f36382a, "showBizBar", (Throwable) null, "com.didi.sdk.home.bizbar.HomeBizNavBarFragment", 74);
        m25757a();
    }

    public void hideBizBar() {
        if (this.f36383b != null) {
            m25761b();
        }
    }

    public int getBizBarHeight() {
        View view = this.f36383b;
        if (view == null || this.f36391j) {
            return 0;
        }
        return view.getHeight();
    }

    public void setBizBarBackgroundColor(int i) {
        BizNavLayout bizNavLayout = this.f36384c;
        if (bizNavLayout != null) {
            bizNavLayout.setBackgroundColor(i);
        }
    }

    public void showBizBarDivider() {
        View view = this.f36385d;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void hideBizBarDivider() {
        View view = this.f36385d;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void setConfigInfo(List<TopCarGroupWrapper> list, boolean z) {
        if (this.f36383b != null) {
            if (this.f36388g == null) {
                this.f36388g = new BizNavItemMgr(DIDIBaseApplication.getAppContext());
            }
            if (list == null || list.size() == 0 || list.size() == 1) {
                this.f36390i = 1;
                m25763c();
                return;
            }
            this.f36388g.setList(m25756a(list));
            this.f36390i = this.f36388g.getList().size();
            this.f36388g.setHotInfo(ConfProxy.getInstance().getHotInfo());
            this.f36384c.setBizNavItemMgr(this.f36388g);
            if (!z && this.f36386e.getVisibility() != 0) {
                SystemUtils.log(3, f36382a, "showBizNav", (Throwable) null, "com.didi.sdk.home.bizbar.HomeBizNavBarFragment", 134);
                m25757a();
            }
        }
    }

    /* renamed from: a */
    private void m25757a() {
        this.f36391j = false;
        this.f36383b.setVisibility(0);
        this.f36386e.setVisibility(0);
        this.f36384c.setClickable(true);
        this.f36386e.startAnimation(m25755a((int) R.anim.new_ui_bottom_in, (Animation.AnimationListener) new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                HomeBizNavBarFragment.this.m25758a(1);
            }

            public void onAnimationEnd(Animation animation) {
                HomeBizNavBarFragment.this.m25758a(2);
            }
        }));
    }

    /* renamed from: b */
    private void m25761b() {
        if (this.f36383b.getVisibility() != 4 && !this.f36391j) {
            SystemUtils.log(3, f36382a, "hideBizNav", (Throwable) null, "com.didi.sdk.home.bizbar.HomeBizNavBarFragment", 167);
            this.f36391j = true;
            this.f36384c.setClickable(false);
            this.f36386e.startAnimation(m25755a((int) R.anim.new_ui_bottom_out, (Animation.AnimationListener) new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    HomeBizNavBarFragment.this.m25758a(3);
                }

                public void onAnimationEnd(Animation animation) {
                    HomeBizNavBarFragment.this.f36383b.setVisibility(4);
                    HomeBizNavBarFragment.this.m25758a(4);
                }
            }));
        }
    }

    /* renamed from: c */
    private void m25763c() {
        if (this.f36386e.getVisibility() != 8) {
            SystemUtils.log(3, f36382a, "hideBizNavContainer", (Throwable) null, "com.didi.sdk.home.bizbar.HomeBizNavBarFragment", 194);
            this.f36386e.startAnimation(m25755a((int) R.anim.new_ui_bottom_out, (Animation.AnimationListener) new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    HomeBizNavBarFragment.this.m25758a(3);
                }

                public void onAnimationEnd(Animation animation) {
                    HomeBizNavBarFragment.this.f36386e.setVisibility(8);
                    HomeBizNavBarFragment.this.m25758a(4);
                }
            }));
        }
    }

    /* renamed from: a */
    private Animation m25755a(int i, Animation.AnimationListener animationListener) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f36386e.getContext(), i);
        loadAnimation.setInterpolator(GlobalUIKitAnimationFactory.GlobalUIKitInterpolatorFactory.getInterpolator(GlobalUIKitAnimationFactory.InterpolatorType.EASY_OUT));
        loadAnimation.setAnimationListener(animationListener);
        return loadAnimation;
    }

    public void switchToPage(String str) {
        TopCarGroupWrapper switchToPage = this.f36384c.switchToPage(str);
        if (switchToPage != null) {
            this.f36388g.changeItemToMainBar(switchToPage);
            this.f36384c.notifyDataChanged();
        }
        restoreToDefaultStyle();
    }

    public void showExtendBar(Context context, ViewGroup viewGroup) {
        if (this.f36387f == null) {
            HomeBizNavExtendBarController homeBizNavExtendBarController = new HomeBizNavExtendBarController(this.f36388g);
            this.f36387f = homeBizNavExtendBarController;
            homeBizNavExtendBarController.setSelectListener(new HomeBizNavExtendBarController.ExtendSelectListener() {
                public void onSelect(CarGrop carGrop) {
                    CarGrop selectedGrop = HomeBizNavBarFragment.this.f36384c.getSelectedGrop();
                    HomeBizNavBarFragment.this.f36384c.notifyDataChanged();
                    if (HomeBizNavBarFragment.this.f36389h != null) {
                        boolean z = false;
                        if (HomeBizNavBarFragment.this.f36388g.hasRedPoint(carGrop.getGroupType(), carGrop.getNavTag()) && HomeBizNavBarFragment.this.f36388g.isRedPointNeedShow()) {
                            z = true;
                            HomeBizNavBarFragment.this.f36388g.activeRedPointCount();
                        }
                        HomeBizNavBarFragment.this.f36389h.onSelect(selectedGrop, carGrop, z, 3);
                    }
                }
            });
        }
        this.f36387f.showExtendBar(context, viewGroup);
    }

    public void hideExtendBar() {
        HomeBizNavExtendBarController homeBizNavExtendBarController = this.f36387f;
        if (homeBizNavExtendBarController != null) {
            homeBizNavExtendBarController.hideExtendBar();
        }
    }

    /* renamed from: a */
    private List<TopCarGroupWrapper> m25756a(List<TopCarGroupWrapper> list) {
        if (list == null) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).carGrop == null) {
                list.remove(i);
            }
        }
        return list;
    }

    public void restoreToDefaultStyle() {
        setBizBarBackgroundColor(ResourcesHelper.getColor(getContext(), R.color.new_ui_biz_nav_background));
        showBizBarDivider();
    }

    public void setNavSelectListener(BizSelectListener bizSelectListener) {
        this.f36389h = bizSelectListener;
        this.f36384c.setSelectListener(bizSelectListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25758a(int i) {
        BizNavBarEvent bizNavBarEvent = new BizNavBarEvent();
        bizNavBarEvent.state = i;
        bizNavBarEvent.height = getBizBarHeight();
        EventBus.getDefault().postSticky(bizNavBarEvent);
    }
}
