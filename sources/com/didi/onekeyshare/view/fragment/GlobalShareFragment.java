package com.didi.onekeyshare.view.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.ninja.Ninja;
import com.didi.onekeyshare.ShareConfig;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.track.OmegaTrack;
import com.didi.onekeyshare.util.ShareConvertCompat;
import com.didi.onekeyshare.view.ShareBgFrameLayout;
import com.didi.onekeyshare.view.ShareBottomLinearLayout;
import com.didi.onekeyshare.view.fragment.ShareFragmentView;
import com.didi.onekeyshare.wrapper.ShareWrapper;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GlobalShareFragment extends ShareFragment implements ShareFragmentView.IShareListener {

    /* renamed from: a */
    private int f29797a = 12;

    /* renamed from: b */
    private ViewPager f29798b;

    /* renamed from: c */
    private ArrayList<View> f29799c;

    /* renamed from: d */
    private ViewGroup f29800d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ImageView[] f29801e;

    /* renamed from: f */
    private ImageView f29802f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ICallback f29803g;

    /* renamed from: h */
    private View f29804h;

    /* renamed from: i */
    private boolean f29805i;

    /* renamed from: j */
    private View f29806j;

    /* renamed from: k */
    private View f29807k;

    /* renamed from: l */
    private ViewGroup f29808l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f29809m = false;

    /* renamed from: n */
    private ICallback.IPlatformClickCallback f29810n;

    public static GlobalShareFragment newInstance(ShareInfo shareInfo) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("ShareInfo", shareInfo);
        GlobalShareFragment globalShareFragment = new GlobalShareFragment();
        globalShareFragment.setArguments(bundle);
        return globalShareFragment;
    }

    public static GlobalShareFragment newInstance(ArrayList<OneKeyShareInfo> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("ShareList", arrayList);
        GlobalShareFragment globalShareFragment = new GlobalShareFragment();
        globalShareFragment.setArguments(bundle);
        return globalShareFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.global_f_share_dialog, viewGroup);
        this.f29806j = inflate.findViewById(R.id.global_share_root);
        this.f29808l = (ViewGroup) inflate.findViewById(R.id.title_layout);
        if (ShareConfig.getConfig().getCornerStyle() == 2) {
            this.f29808l.setBackgroundResource(R.drawable.global_share_title_without_corner_bg);
        } else {
            this.f29808l.setBackgroundResource(R.drawable.global_share_title_bg);
        }
        this.f29807k = inflate.findViewById(R.id.global_share_bottom_root);
        this.f29798b = (ViewPager) inflate.findViewById(R.id.view_pager);
        this.f29800d = (ViewGroup) inflate.findViewById(R.id.layout_dot);
        this.f29806j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalShareFragment.this.m20917c();
            }
        });
        View findViewById = inflate.findViewById(R.id.btn_cancel);
        this.f29804h = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalShareFragment.this.m20917c();
                if (GlobalShareFragment.this.f29803g != null && (GlobalShareFragment.this.f29803g instanceof ICallback.IPlatformShareCallback)) {
                    ((ICallback.IPlatformShareCallback) GlobalShareFragment.this.f29803g).onCancel(SharePlatform.REFRESH_ICON);
                }
                OmegaTrack.trackCancelClick("1");
            }
        });
        if (getResources().getConfiguration().orientation == 2) {
            this.f29797a = 12;
            this.f29805i = true;
        } else {
            this.f29797a = 12;
            this.f29805i = false;
        }
        m20916b();
        SystemUtils.log(6, "SHARE", "NEW SHARE", (Throwable) null, "com.didi.onekeyshare.view.fragment.GlobalShareFragment", 118);
        m20911a();
        return inflate;
    }

    /* renamed from: a */
    private void m20911a() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                    if (i != 4 || keyEvent.getAction() != 0) {
                        return false;
                    }
                    GlobalShareFragment.this.m20917c();
                    return true;
                }
            });
        }
    }

    /* renamed from: a */
    private void m20913a(List<OneKeyShareInfo> list) {
        if (list != null && !list.isEmpty()) {
            int i = 0;
            while (i < list.size()) {
                boolean z = list.get(i).platform == SharePlatform.FACEBOOK_PLATFORM;
                boolean isHit = Ninja.getInstance(getContext()).isHit("FACEBOOK_SHARE");
                if (!z || !isHit) {
                    i++;
                } else {
                    list.remove(i);
                    return;
                }
            }
        }
    }

    /* renamed from: b */
    private void m20916b() {
        List list;
        double d;
        OneKeyShareInfo oneKeyShareInfo;
        this.f29799c = new ArrayList<>();
        ShareInfo shareInfo = (ShareInfo) getArguments().getSerializable("ShareInfo");
        if (shareInfo == null) {
            list = (ArrayList) getArguments().getSerializable("ShareList");
        } else {
            list = ShareConvertCompat.convert(shareInfo);
        }
        m20913a((List<OneKeyShareInfo>) list);
        Iterator it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((OneKeyShareInfo) it.next()).platform == SharePlatform.REFRESH_ICON) {
                    OmegaTrack.trackRefreshShow();
                    break;
                }
            } else {
                break;
            }
        }
        if (!(list == null || list.size() <= 0 || (oneKeyShareInfo = (OneKeyShareInfo) list.get(0)) == null)) {
            OmegaTrack.trackShareShow(list, oneKeyShareInfo.extra);
        }
        if (this.f29805i) {
            this.f29797a = 16;
            d = Math.ceil((double) (((float) list.size()) / 16.0f));
        } else {
            this.f29797a = 12;
            d = Math.ceil((double) (((float) list.size()) / 12.0f));
        }
        int i = (int) d;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f29797a;
            int i4 = i2 * i3;
            List subList = list.subList(i4, i3 + i4 > list.size() ? list.size() : this.f29797a + i4);
            GlobalShareFragmentView globalShareFragmentView = new GlobalShareFragmentView((Context) getActivity(), this.f29805i, i2);
            globalShareFragmentView.setShareInfo(subList);
            globalShareFragmentView.setShareListener(this);
            this.f29799c.add(globalShareFragmentView);
        }
        if (this.f29799c.size() > 1) {
            this.f29801e = new ImageView[this.f29799c.size()];
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(15, 0, 0, 0);
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(layoutParams.leftMargin);
            }
            for (int i5 = 0; i5 < this.f29799c.size(); i5++) {
                ImageView imageView = new ImageView(getActivity());
                this.f29802f = imageView;
                imageView.setLayoutParams(new LinearLayout.LayoutParams(10, 30));
                this.f29802f.setScaleType(ImageView.ScaleType.CENTER);
                if (i5 == 0) {
                    this.f29802f.setBackgroundResource(R.drawable.tone_share_dot_orange);
                } else {
                    this.f29802f.setBackgroundResource(R.drawable.tone_share_dot_gray);
                }
                ImageView[] imageViewArr = this.f29801e;
                imageViewArr[i5] = this.f29802f;
                this.f29800d.addView(imageViewArr[i5], layoutParams);
            }
            this.f29798b.setOnPageChangeListener(new SharePageChangeListener());
            OmegaTrack.trackSlideShow();
        }
        this.f29798b.setAdapter(new ShareViewAdapter(this.f29799c));
    }

    public void setSharePlatformClickCallBack(ICallback.IPlatformClickCallback iPlatformClickCallback) {
        this.f29810n = iPlatformClickCallback;
    }

    private class SharePageChangeListener implements ViewPager.OnPageChangeListener {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        private SharePageChangeListener() {
        }

        public void onPageSelected(int i) {
            for (int i2 = 0; i2 < GlobalShareFragment.this.f29801e.length; i2++) {
                GlobalShareFragment.this.f29801e[i].setBackgroundResource(R.drawable.tone_share_dot_orange);
                if (i != i2) {
                    GlobalShareFragment.this.f29801e[i2].setBackgroundResource(R.drawable.tone_share_dot_gray);
                }
            }
        }
    }

    public class ShareViewAdapter extends PagerAdapter {
        private final ArrayList<View> list;

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public ShareViewAdapter(ArrayList<View> arrayList) {
            this.list = arrayList;
        }

        public int getCount() {
            return this.list.size();
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View view = this.list.get(i);
            ViewGroup viewGroup2 = (ViewGroup) view.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeAllViews();
            }
            viewGroup.addView(view);
            return view;
        }

        public Object instantiateItem(View view, int i) {
            ((ViewPager) view).addView(this.list.get(i));
            return this.list.get(i);
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView(this.list.get(i));
        }
    }

    public void onClickPlatform(OneKeyShareInfo oneKeyShareInfo) {
        dismissAllowingStateLoss();
        ICallback.IPlatformClickCallback iPlatformClickCallback = this.f29810n;
        if (iPlatformClickCallback != null) {
            iPlatformClickCallback.onClickPlatform(oneKeyShareInfo);
        }
        share(oneKeyShareInfo);
    }

    /* access modifiers changed from: protected */
    public void share(OneKeyShareInfo oneKeyShareInfo) {
        if (oneKeyShareInfo != null && oneKeyShareInfo.platform != null && oneKeyShareInfo.platform != SharePlatform.UNKNOWN && oneKeyShareInfo != null) {
            if (oneKeyShareInfo.platform == SharePlatform.REFRESH_ICON) {
                ICallback iCallback = this.f29803g;
                if (iCallback != null && (iCallback instanceof ICallback.IH5ShareCallback)) {
                    ((ICallback.IH5ShareCallback) iCallback).onRefresh();
                    OmegaTrack.trackRefreshClick();
                }
                dismissAllowingStateLoss();
                return;
            }
            SharePlatform sharePlatform = oneKeyShareInfo.platform;
            if (sharePlatform != null) {
                OmegaTrack.trackShareChannelClick(sharePlatform.platformName(), oneKeyShareInfo.extra);
            }
            ShareWrapper.shareToPlatform(getActivity(), oneKeyShareInfo, new ICallback.IPlatformShareCallback2() {
                public void onError(SharePlatform sharePlatform, int i) {
                    if (GlobalShareFragment.this.f29803g != null && (GlobalShareFragment.this.f29803g instanceof ICallback.IPlatformShareCallback2)) {
                        ((ICallback.IPlatformShareCallback2) GlobalShareFragment.this.f29803g).onError(sharePlatform, i);
                    }
                }

                public void onComplete(SharePlatform sharePlatform) {
                    if (GlobalShareFragment.this.f29803g != null) {
                        ((ICallback.IPlatformShareCallback) GlobalShareFragment.this.f29803g).onComplete(sharePlatform);
                    }
                }

                public void onError(SharePlatform sharePlatform) {
                    if (GlobalShareFragment.this.f29803g != null) {
                        ((ICallback.IPlatformShareCallback) GlobalShareFragment.this.f29803g).onError(sharePlatform);
                    }
                }

                public void onCancel(SharePlatform sharePlatform) {
                    if (GlobalShareFragment.this.f29803g != null) {
                        ((ICallback.IPlatformShareCallback) GlobalShareFragment.this.f29803g).onCancel(sharePlatform);
                    }
                }
            });
        }
    }

    public void setShareCallBack(ICallback iCallback) {
        this.f29803g = iCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m20917c() {
        if (!this.f29809m) {
            this.f29809m = true;
            ShareConfig config = ShareConfig.getConfig();
            if (config.getFragmentListener() != null) {
                config.getFragmentListener().onDismiss(getActivity());
            }
            ((ShareBottomLinearLayout) this.f29807k).exitAnimation(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    boolean unused = GlobalShareFragment.this.f29809m = false;
                    GlobalShareFragment.this.dismissAllowingStateLoss();
                }
            });
            ((ShareBgFrameLayout) this.f29806j).exitAnimation(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }
            });
        }
    }
}
