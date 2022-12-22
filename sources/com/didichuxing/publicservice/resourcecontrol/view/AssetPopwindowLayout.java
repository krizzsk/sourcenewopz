package com.didichuxing.publicservice.resourcecontrol.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didichuxing.publicservice.general.AppUtils;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.p197bi.CommonBIUtil;
import com.didichuxing.publicservice.resourcecontrol.pojo.DPopResource;
import com.didichuxing.publicservice.resourcecontrol.utils.DensityUtil;
import com.didichuxing.publicservice.resourcecontrol.utils.PublicWebUtils;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceTrack;
import com.didichuxing.xpanel.xcard.loader.XCardManager;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import com.tunasashimi.tuna.TunaRepeat;
import com.tunasashimi.tuna.TunaView;
import com.tunasashimi.tuna.TunaViewPager;
import java.util.HashMap;
import java.util.Map;

public class AssetPopwindowLayout extends AssetBaseView {
    /* access modifiers changed from: private */
    public int count;
    private int currentItem;
    /* access modifiers changed from: private */
    public LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public int mImageHeight;
    /* access modifiers changed from: private */
    public int mImageWidth;
    /* access modifiers changed from: private */
    public View[] mPopupViewsArray;
    private final PagerAdapter pagerAdapter = new PagerAdapter() {
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public Object instantiateItem(ViewGroup viewGroup, final int i) {
            if (AssetPopwindowLayout.this.resource == null || AssetPopwindowLayout.this.resource.data == null || AssetPopwindowLayout.this.resource.data.length == 0) {
                return viewGroup;
            }
            RelativeLayout relativeLayout = (RelativeLayout) AssetPopwindowLayout.this.layoutInflater.inflate(R.layout.asset_popwindow_item, (ViewGroup) null);
            final DPopResource.DataBean dataBean = AssetPopwindowLayout.this.resource.data[i % AssetPopwindowLayout.this.count];
            Object obj = dataBean.data;
            if (!TextUtils.isEmpty(dataBean.cdn)) {
                ViewGroup viewGroup2 = (ViewGroup) XCardManager.getInstance().createXCardView(AssetPopwindowLayout.this.mContext, XCardManager.getInstance().getXMLCache(dataBean.cdn), obj, new ResCardListener(AssetPopwindowLayout.this.mContext));
                if (viewGroup2 == null) {
                    return viewGroup;
                }
                ((ImageView) relativeLayout.findViewById(R.id.common_loading_img)).setVisibility(8);
                viewGroup2.getChildAt(0).setLayoutParams(new FrameLayout.LayoutParams(AssetPopwindowLayout.this.mImageWidth, AssetPopwindowLayout.this.mImageHeight));
                ((ViewGroup) relativeLayout.findViewById(R.id.content_layout)).addView(viewGroup2);
                AssetPopwindowLayout.this.mPopupViewsArray[i % AssetPopwindowLayout.this.count] = relativeLayout;
            } else {
                final DPopResource.DataDetail dataDetail = (DPopResource.DataDetail) AppUtils.parseJson(AppUtils.convertObjectToString(obj), DPopResource.DataDetail.class);
                if (dataDetail == null) {
                    return viewGroup;
                }
                final ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.pageItemIcon);
                imageView.setVisibility(0);
                final ImageView imageView2 = (ImageView) relativeLayout.findViewById(R.id.common_loading_img);
                imageView2.setVisibility(0);
                ((AnimationDrawable) imageView2.getDrawable()).start();
                AssetPopwindowLayout.this.mPopupViewsArray[i % AssetPopwindowLayout.this.count] = relativeLayout;
                imageView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        DPopResource.DataDetail dataDetail;
                        AutoTrackHelper.trackViewOnClick(view);
                        if (!ResourceManager.isFastClick() && dataBean != null && (dataDetail = dataDetail) != null && !TextUtils.isEmpty(dataDetail.link)) {
                            Bundle bundle = new Bundle();
                            bundle.putString(ConstantUtils.EXTRA_WEBVIEW_URL, dataDetail.link);
                            bundle.putInt(ConstantUtils.EXTRA_RESOURCE_TYPE, 1004);
                            AssetPopwindowLayout.this.openView(AssetPopwindowLayout.this.mContext, bundle, false);
                            if (!(AssetPopwindowLayout.this.resource.data == null || AssetPopwindowLayout.this.resource.data.length < 1 || dataBean == null)) {
                                HashMap hashMap = new HashMap();
                                hashMap.put(CommonBIUtil.KEY_RESOURCEID, CommonBIUtil.convertBiz(AssetPopwindowLayout.this.resourceId));
                                hashMap.putAll(dataBean.log_data);
                                hashMap.put(CommonBIUtil.KEY_ACDID, Integer.valueOf(dataBean.activity_id));
                                if ((i % AssetPopwindowLayout.this.count) + 1 == 1) {
                                    hashMap.put("key", "pas_notice_webview");
                                } else {
                                    hashMap.put("key", "pas_notice_webview_page" + ((i % AssetPopwindowLayout.this.count) + 1));
                                }
                                OmegaSDKAdapter.trackEvent(CommonBIUtil.TONE_P_X_HOME_NTPP_CK, (Map<String, Object>) hashMap);
                                ResourceTrack.trackEventCK(dataBean.log_data);
                                ResourceTrack.trackURL(dataBean.click_tracks);
                            }
                            C162502.this.dissDialog();
                        }
                    }
                });
                ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with(AssetPopwindowLayout.this.mContext).load(dataDetail.image).override(AssetPopwindowLayout.this.mImageWidth, AssetPopwindowLayout.this.mImageHeight)).centerCrop()).dontAnimate()).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).into(new CustomTarget<Drawable>() {
                    public void onLoadCleared(Drawable drawable) {
                    }

                    public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                        imageView.setImageDrawable(drawable);
                        imageView2.setVisibility(8);
                    }
                });
            }
            viewGroup.addView(AssetPopwindowLayout.this.mPopupViewsArray[i % AssetPopwindowLayout.this.count]);
            return AssetPopwindowLayout.this.mPopupViewsArray[i % AssetPopwindowLayout.this.count];
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        /* access modifiers changed from: private */
        public void dissDialog() {
            if (AssetPopwindowLayout.this.dialogFragment != null) {
                AssetPopwindowLayout.this.dialogFragment.dismissAllowingStateLoss();
            }
        }

        public int getCount() {
            if (AssetPopwindowLayout.this.resource == null || AssetPopwindowLayout.this.resource.data == null || AssetPopwindowLayout.this.resource.data.length == 0) {
                return 0;
            }
            return AssetPopwindowLayout.this.resource.data.length == 1 ? 1 : Integer.MAX_VALUE;
        }
    };
    /* access modifiers changed from: private */
    public DPopResource resource;
    /* access modifiers changed from: private */
    public TunaRepeat tunaRepeat;
    private TunaViewPager viewPager;

    public void releaseResource() {
    }

    public int getPageSize() {
        return this.count;
    }

    public AssetPopwindowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public AssetPopwindowLayout(Context context) {
        super(context);
    }

    public AssetPopwindowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public void autoCalculateViewMargin(int i) {
        this.mImageWidth = DensityUtil.dip2px(this.mContext, 267.0f);
        this.mImageHeight = DensityUtil.dip2px(this.mContext, 356.0f);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.viewPager.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        layoutParams.width = this.mImageWidth;
        layoutParams.height = this.mImageHeight;
        layoutParams.addRule(13, -1);
        this.viewPager.setLayoutParams(layoutParams);
    }

    public void initView(DPopResource dPopResource) {
        this.resource = dPopResource;
        this.layoutInflater = LayoutInflater.from(this.mContext);
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.asset_popowindow_layout, this);
        int min = Math.min(this.resource.data.length, 5);
        this.count = min;
        this.currentItem = min * 120;
        this.mPopupViewsArray = new View[min];
        this.tunaRepeat = (TunaRepeat) findViewById(R.id.tunaRepeat);
        this.viewPager = (TunaViewPager) findViewById(R.id.popViewpager);
        this.tunaRepeat.setTunaRepeatTotal(min);
        TunaView.setLayoutByWidth(this.tunaRepeat, (float) (min * 20));
        if (min > 1) {
            this.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                public void onPageScrollStateChanged(int i) {
                }

                public void onPageScrolled(int i, float f, int i2) {
                }

                public void onPageSelected(int i) {
                    AssetPopwindowLayout.this.tunaRepeat.setTunaRepeatCurrentIndex(i % AssetPopwindowLayout.this.count);
                }
            });
        } else {
            this.tunaRepeat.setVisibility(8);
        }
        this.viewPager.setAdapter(this.pagerAdapter);
        this.viewPager.setCurrentItem(this.currentItem);
    }

    public String getAcdId(DPopResource dPopResource, int i) {
        return (dPopResource == null || dPopResource.data == null || dPopResource.data.length < 1 || i >= dPopResource.data.length) ? "" : String.valueOf(dPopResource.data[i].activity_id);
    }

    public ViewPager getViewPager() {
        return this.viewPager;
    }

    public void openView(Context context, Bundle bundle, boolean z) {
        if (bundle != null) {
            try {
                String string = bundle.getString(ConstantUtils.EXTRA_WEBVIEW_URL);
                if (!TextUtils.isEmpty(string)) {
                    if (!string.startsWith("http://") && !string.startsWith("https://")) {
                        DRouter.build(string).start(context);
                    } else if (string.startsWith("https://play.google.com")) {
                        DRouter.build(string).start(context);
                    } else {
                        Intent webActivity = PublicWebUtils.getWebActivity(getContext(), string);
                        webActivity.putExtra("url", string);
                        String string2 = bundle.getString(ConstantUtils.EXTRA_WEBVIEW_TITLE);
                        if (!TextUtils.isEmpty(string2)) {
                            webActivity.putExtra("title", string2);
                        }
                        webActivity.setPackage(getActivity().getPackageName());
                        context.startActivity(webActivity);
                    }
                }
            } catch (RuntimeException e) {
                AppUtils.log("could not find ======== class    didi.passenger.intent.action.WebActivity");
                e.printStackTrace();
            }
        }
    }
}
