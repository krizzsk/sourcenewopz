package com.didichuxing.publicservice.resourcecontrol.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.activities.RControlActivity;
import com.didichuxing.publicservice.resourcecontrol.pojo.Resource;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager;
import com.taxis99.R;
import com.tunasashimi.tuna.TunaDownload;
import com.tunasashimi.tuna.TunaRepeat;
import com.tunasashimi.tuna.TunaViewPager;

public class AssetViewPagerLayout extends AssetBaseView {
    public static final int MSG_BREAK_SILENT = 3;
    public static int MSG_DELAY = 5000;
    public static final int MSG_KEEP_SILENT = 2;
    public static final int MSG_PAGE_CHANGED = 4;
    public static final int MSG_UPDATE_TUNA = 1;
    private static final String TAG = AssetViewPagerLayout.class.getSimpleName();
    /* access modifiers changed from: private */
    public ViewPager.OnPageChangeListener ViewPagerListener = new ViewPager.OnPageChangeListener() {
        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
            if (!(AssetViewPagerLayout.this.mResource == null || AssetViewPagerLayout.this.mResource.list == null || AssetViewPagerLayout.this.mResource.list.size() <= 0)) {
                AssetViewPagerLayout.this.tunaRepeat.setTunaRepeatCurrentIndex(i % AssetViewPagerLayout.this.mResource.list.size());
            }
            AssetViewPagerLayout.this.handler.sendMessage(Message.obtain(AssetViewPagerLayout.this.handler, 4, i, 0));
        }

        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                AssetViewPagerLayout.this.handler.sendEmptyMessageDelayed(1, (long) AssetViewPagerLayout.MSG_DELAY);
            } else if (i == 1) {
                AssetViewPagerLayout.this.handler.sendEmptyMessage(2);
            }
        }
    };
    /* access modifiers changed from: private */
    public int currentItem = 0;
    /* access modifiers changed from: private */
    public Handler handler = new Handler() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (AssetViewPagerLayout.this.mContext != null && AssetViewPagerLayout.this.mResource != null && AssetViewPagerLayout.this.mResource.list != null && AssetViewPagerLayout.this.mResource.list.size() != 0) {
                if (AssetViewPagerLayout.this.handler.hasMessages(1)) {
                    AssetViewPagerLayout.this.handler.removeMessages(1);
                }
                int i = message.what;
                if (i == 1) {
                    AssetViewPagerLayout.access$308(AssetViewPagerLayout.this);
                    AssetViewPagerLayout.this.viewPager.setCurrentItem(AssetViewPagerLayout.this.currentItem);
                    AssetViewPagerLayout.this.handler.sendEmptyMessageDelayed(1, (long) AssetViewPagerLayout.MSG_DELAY);
                } else if (i == 3) {
                    AssetViewPagerLayout.this.handler.sendEmptyMessageDelayed(1, (long) AssetViewPagerLayout.MSG_DELAY);
                } else if (i == 4) {
                    int unused = AssetViewPagerLayout.this.currentItem = message.arg1;
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public LayoutInflater layoutInflater;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public Resource mResource;
    /* access modifiers changed from: private */
    public PagerAdapter pagerAdapter = new PagerAdapter() {
        public void destroyItem(View view, int i, Object obj) {
        }

        public void finishUpdate(View view) {
        }

        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        public Object instantiateItem(View view, int i) {
            if (AssetViewPagerLayout.this.mResource == null || AssetViewPagerLayout.this.mResource.list == null || AssetViewPagerLayout.this.mResource.list.size() == 0) {
                return view;
            }
            int size = i % AssetViewPagerLayout.this.mResource.list.size();
            if (AssetViewPagerLayout.this.tunaDownloadArray[size] == null) {
                RelativeLayout relativeLayout = (RelativeLayout) AssetViewPagerLayout.this.layoutInflater.inflate(R.layout.asset_viewpager_item, (ViewGroup) null);
                TunaDownload tunaDownload = (TunaDownload) relativeLayout.findViewById(R.id.tunaDownload);
                tunaDownload.setTunaDownloadCacheFolder(ConstantUtils.IMAGE_FILE_URL);
                AssetViewPagerLayout.this.tunaDownloadArray[size] = relativeLayout;
                final Resource.SingleResource singleResource = AssetViewPagerLayout.this.mResource.list.get(size);
                tunaDownload.setTunaDownloadGraphicsSrcURLRequestHeight(160);
                tunaDownload.setTunaDownloadGraphicsSrcURLRequestWidth(690);
                tunaDownload.init(RControlActivity.tunaDownloadMapList, singleResource.image);
                tunaDownload.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Resource.SingleResource singleResource;
                        AutoTrackHelper.trackViewOnClick(view);
                        if (!ResourceManager.isFastClick() && (singleResource = singleResource) != null && singleResource.link != null && !TextUtils.isEmpty(singleResource.link.trim())) {
                            Bundle bundle = new Bundle();
                            bundle.putString(ConstantUtils.EXTRA_WEBVIEW_URL, singleResource.link);
                            bundle.putInt(ConstantUtils.EXTRA_RESOURCE_TYPE, 1004);
                            AssetViewPagerLayout.this.openView(AssetViewPagerLayout.this.mContext, bundle, true);
                        }
                    }
                });
            }
            TunaViewPager tunaViewPager = (TunaViewPager) view;
            ViewParent parent = AssetViewPagerLayout.this.tunaDownloadArray[size].getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(AssetViewPagerLayout.this.tunaDownloadArray[size]);
            }
            tunaViewPager.addView(AssetViewPagerLayout.this.tunaDownloadArray[size]);
            return AssetViewPagerLayout.this.tunaDownloadArray[size];
        }

        public int getCount() {
            return (AssetViewPagerLayout.this.mResource == null || AssetViewPagerLayout.this.mResource.list == null || AssetViewPagerLayout.this.mResource.list.size() == 0) ? 0 : Integer.MAX_VALUE;
        }
    };
    /* access modifiers changed from: private */
    public View[] tunaDownloadArray;
    /* access modifiers changed from: private */
    public TunaRepeat tunaRepeat;
    /* access modifiers changed from: private */
    public TunaViewPager viewPager;

    static /* synthetic */ int access$308(AssetViewPagerLayout assetViewPagerLayout) {
        int i = assetViewPagerLayout.currentItem;
        assetViewPagerLayout.currentItem = i + 1;
        return i;
    }

    public AssetViewPagerLayout(Context context) {
        super(context);
        this.mContext = context;
    }

    public AssetViewPagerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public void initView(final Resource resource) {
        post(new Runnable() {
            public void run() {
                Resource unused = AssetViewPagerLayout.this.mResource = resource;
                if (AssetViewPagerLayout.this.mResource != null && AssetViewPagerLayout.this.mResource.list != null && AssetViewPagerLayout.this.mResource.list.size() != 0) {
                    AssetViewPagerLayout assetViewPagerLayout = AssetViewPagerLayout.this;
                    LayoutInflater unused2 = assetViewPagerLayout.layoutInflater = LayoutInflater.from(assetViewPagerLayout.mContext);
                    ((LayoutInflater) AssetViewPagerLayout.this.mContext.getSystemService("layout_inflater")).inflate(R.layout.asset_viewpager_layout, AssetViewPagerLayout.this);
                    AssetViewPagerLayout assetViewPagerLayout2 = AssetViewPagerLayout.this;
                    View[] unused3 = assetViewPagerLayout2.tunaDownloadArray = new View[assetViewPagerLayout2.mResource.list.size()];
                    AssetViewPagerLayout assetViewPagerLayout3 = AssetViewPagerLayout.this;
                    TunaViewPager unused4 = assetViewPagerLayout3.viewPager = (TunaViewPager) assetViewPagerLayout3.findViewById(R.id.viewPager);
                    AssetViewPagerLayout.this.viewPager.setAdapter(AssetViewPagerLayout.this.pagerAdapter);
                    AssetViewPagerLayout.this.viewPager.setOnPageChangeListener(AssetViewPagerLayout.this.ViewPagerListener);
                    AssetViewPagerLayout assetViewPagerLayout4 = AssetViewPagerLayout.this;
                    TunaRepeat unused5 = assetViewPagerLayout4.tunaRepeat = (TunaRepeat) assetViewPagerLayout4.findViewById(R.id.tunaRepeat);
                    AssetViewPagerLayout.this.tunaRepeat.setTunaRepeatTotal(AssetViewPagerLayout.this.mResource.list.size());
                    AssetViewPagerLayout.this.handler.sendEmptyMessageDelayed(1, (long) AssetViewPagerLayout.MSG_DELAY);
                    AssetViewPagerLayout.this.viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
                        public void transformPage(View view, float f) {
                            int width = view.getWidth();
                            int height = view.getHeight();
                            if (f < -1.0f) {
                                view.setAlpha(0.0f);
                            } else if (f <= 1.0f) {
                                float max = Math.max(0.85f, 1.0f - Math.abs(f));
                                float f2 = 1.0f - max;
                                float f3 = (((float) height) * f2) / 2.0f;
                                float f4 = (((float) width) * f2) / 2.0f;
                                if (f < 0.0f) {
                                    view.setTranslationX(f4 - (f3 / 2.0f));
                                } else {
                                    view.setTranslationX((-f4) + (f3 / 2.0f));
                                }
                                view.setScaleX(max);
                                view.setScaleY(max);
                                view.setAlpha((((max - 0.85f) / 0.14999998f) * 0.5f) + 0.5f);
                            } else {
                                view.setAlpha(0.0f);
                            }
                        }
                    });
                }
            }
        });
    }

    public void stopTransition() {
        this.handler.sendEmptyMessage(2);
    }

    public void startTransition() {
        this.handler.sendEmptyMessageDelayed(1, (long) MSG_DELAY);
    }
}
