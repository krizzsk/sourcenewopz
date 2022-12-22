package com.didichuxing.publicservice.resourcecontrol.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.publicservice.general.AppUtils;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.api.ResourceApi;
import com.didichuxing.publicservice.resourcecontrol.p197bi.CommonBIUtil;
import com.didichuxing.publicservice.resourcecontrol.pojo.DSplashResource;
import com.didichuxing.publicservice.resourcecontrol.utils.PublicWebUtils;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceLocale;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceTrack;
import com.didichuxing.xpanel.xcard.loader.XCardManager;
import com.didichuxing.xpanel.xcard.view.XPanelImageView;
import com.didichuxing.xpanel.xcard.view.XPanelYogaLayout;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.facebook.yoga.android.YogaLayout;
import com.taxis99.R;
import com.tunasashimi.tuna.TunaDownload;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class AssetSplashViewLayout extends AssetBaseView implements SurfaceHolder.Callback {
    private String TAG = AssetSplashViewLayout.class.getSimpleName();
    private TextView coutDowntime;
    /* access modifiers changed from: private */
    public int height;
    private View layout_skip_ad_tv;
    private String localPath;
    private TextView mAdTips;
    private RelativeLayout mBottomLogo;
    private Context mContext;
    private RelativeLayout mGoto_web;
    /* access modifiers changed from: private */
    public Handler mHandle;
    private boolean mIsAd = true;
    private View mLogoContainerRoot;
    /* access modifiers changed from: private */
    public DSplashResource mResource;
    private TextView mSkipAd_Tv;
    private View.OnClickListener mSkipListener = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            HashMap hashMap = new HashMap();
            String str = CommonBIUtil.KEY_ACDID;
            AssetSplashViewLayout assetSplashViewLayout = AssetSplashViewLayout.this;
            hashMap.put(str, Integer.valueOf(assetSplashViewLayout.getAcdId(assetSplashViewLayout.mResource)));
            if (!(AssetSplashViewLayout.this.mResource == null || AssetSplashViewLayout.this.mResource.data == null || AssetSplashViewLayout.this.mResource.data.size() <= 0)) {
                hashMap.putAll(AssetSplashViewLayout.this.mResource.data.get(0).log_data);
            }
            String valueOf = String.valueOf(AssetSplashViewLayout.this.mResource.data.get(0).activity_id);
            if (AssetSplashViewLayout.this.getActivity() != null && !TextUtils.isEmpty(valueOf)) {
                Map mapFromString = ResourceApi.getMapFromString(SystemUtils.getPreferences(AssetSplashViewLayout.this.getActivity(), 0), valueOf);
                if (mapFromString != null && mapFromString.size() > 0) {
                    hashMap.putAll(mapFromString);
                }
                ResourceTrack.trackEventClose(mapFromString);
                SharedPreferences preferences = SystemUtils.getPreferences(AssetSplashViewLayout.this.getActivity(), 0);
                ResourceTrack.trackURL(ResourceApi.getListFromString(preferences, valueOf + "close"));
            }
            hashMap.put("key", ConstantUtils.PASSAGER_RESOURCE_NAME);
            OmegaSDKAdapter.trackEvent(CommonBIUtil.TONE_P_X_BUB_SKIP_CK, (Map<String, Object>) hashMap);
            AssetSplashViewLayout.this.mHandle.sendEmptyMessage(101);
        }
    };
    /* access modifiers changed from: private */
    public ImageView mSplashIv;
    private ViewGroup mSplashLayout;
    private MediaPlayer player;
    private SurfaceHolder surfaceHolder;
    private SurfaceView surfaceView;
    private int width;

    interface OnCallback {
        void onAvailable();
    }

    public void destorySplashBitmap() {
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder2, int i, int i2, int i3) {
    }

    public AssetSplashViewLayout(Context context) {
        super(context);
        this.mContext = context;
    }

    public AssetSplashViewLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public AssetSplashViewLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    private void initView(String str, boolean z) {
        ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.asset_splashview_layout, this);
        this.mSplashLayout = (ViewGroup) findViewById(R.id.splash_layout);
        this.mSplashIv = (ImageView) findViewById(R.id.splashIv);
        this.surfaceView = (SurfaceView) findViewById(R.id.surfaceView);
        initMediaPlayer();
        this.layout_skip_ad_tv = findViewById(R.id.layout_skip_ad_tv);
        this.coutDowntime = (TextView) findViewById(R.id.coutDowntime);
        this.height = 2160;
        this.width = 1080;
        try {
            this.height = TunaDownload.getDeviceHeight(this.mContext);
            this.width = TunaDownload.getDeviceWidth(this.mContext);
        } catch (Exception e) {
            AppUtils.logE("---->TunaDownload.getDeviceHeight exception:" + e.getMessage());
        }
        if (TextUtils.isEmpty(str) || z) {
            this.mSplashIv.setVisibility(8);
            this.surfaceView.setVisibility(8);
        } else if (!str.endsWith("mp4")) {
            this.mSplashIv.setVisibility(0);
            this.surfaceView.setVisibility(8);
            ((RequestBuilder) ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext.getApplicationContext()).asBitmap().load(str).diskCacheStrategy(DiskCacheStrategy.RESOURCE)).placeholder((int) R.drawable.screen_white_bg)).error((int) R.drawable.screen_white_bg)).into(new CustomTarget<Bitmap>() {
                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    if (bitmap != null) {
                        final Bitmap copy = bitmap.copy(bitmap.getConfig(), true);
                        AssetSplashViewLayout.this.setImageViewSize(bitmap.getWidth(), bitmap.getHeight(), new OnCallback() {
                            public void onAvailable() {
                                AssetSplashViewLayout.this.mSplashIv.setImageBitmap(copy);
                            }
                        });
                    }
                }

                public void onLoadCleared(Drawable drawable) {
                    AssetSplashViewLayout.this.mSplashIv.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    AssetSplashViewLayout.this.mSplashIv.setImageResource(R.drawable.screen_white_bg);
                }
            });
        } else {
            this.localPath = this.mResource.data.get(0).dataDetail.localPath;
            this.mSplashIv.setVisibility(8);
            this.surfaceView.setVisibility(0);
        }
        this.mGoto_web = (RelativeLayout) findViewById(R.id.goto_web);
        this.mBottomLogo = (RelativeLayout) findViewById(R.id.buttom_ly);
        this.mLogoContainerRoot = findViewById(R.id.logo_container_root);
        this.mSkipAd_Tv = (TextView) findViewById(R.id.skip_ad_tv);
        this.mAdTips = (TextView) findViewById(R.id.ad_tips);
        this.layout_skip_ad_tv.setOnClickListener(this.mSkipListener);
    }

    /* access modifiers changed from: private */
    public void setImageViewSize(final int i, final int i2, final OnCallback onCallback) {
        if (i > 0 && i2 > 0) {
            this.mSplashIv.post(new Runnable() {
                public void run() {
                    int measuredWidth = AssetSplashViewLayout.this.mSplashIv.getMeasuredWidth();
                    if (!ResourceLocale.isResourceLocaleIsGl() && !ResourceLocale.isResourceLocaleIsPt()) {
                        int unused = AssetSplashViewLayout.this.height = (i2 * measuredWidth) / i;
                    }
                    if (measuredWidth == 0 || AssetSplashViewLayout.this.height == 0) {
                        onCallback.onAvailable();
                        return;
                    }
                    ViewGroup.LayoutParams layoutParams = AssetSplashViewLayout.this.mSplashIv.getLayoutParams();
                    layoutParams.width = measuredWidth;
                    layoutParams.height = AssetSplashViewLayout.this.height;
                    AssetSplashViewLayout.this.mSplashIv.setLayoutParams(layoutParams);
                    onCallback.onAvailable();
                }
            });
        }
    }

    public void showSplashComercial(final DSplashResource dSplashResource, final Handler handler) {
        XPanelYogaLayout xPanelYogaLayout;
        View childAt;
        if (dSplashResource != null && dSplashResource.data != null && dSplashResource.data.size() != 0) {
            this.mResource = dSplashResource;
            this.mHandle = handler;
            DSplashResource.DataBean dataBean = dSplashResource.data.get(0);
            String str = null;
            if (!TextUtils.isEmpty(dataBean.cdn)) {
                initView((String) null, true);
                View createXCardView = XCardManager.getInstance().createXCardView(this.mContext, XCardManager.getInstance().getXMLCache(dataBean.cdn), dataBean.data, new ResCardListener(this.mContext));
                if (createXCardView == null) {
                    handler.sendEmptyMessage(101);
                    return;
                }
                try {
                    Map map = (Map) dataBean.data;
                    if (map != null && map.containsKey("useLogo")) {
                        setLogoView(((Double) map.get("useLogo")).intValue());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    setLogoView(1);
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.width, this.height);
                View childAt2 = ((ViewGroup) createXCardView).getChildAt(0);
                childAt2.setLayoutParams(layoutParams);
                if ((childAt2 instanceof XPanelYogaLayout) && (childAt = xPanelYogaLayout.getChildAt(0)) != null && (childAt instanceof XPanelImageView)) {
                    (xPanelYogaLayout = (XPanelYogaLayout) childAt2).getYogaNodeForView(childAt).setAspectRatio(((float) this.width) / ((float) this.height));
                    childAt.setLayoutParams(new YogaLayout.LayoutParams(this.width, this.height));
                    xPanelYogaLayout.invalidate(childAt);
                }
                this.mSplashLayout.addView(createXCardView);
            } else {
                final DSplashResource.DataDetail dataDetail = dataBean.getDataDetail();
                if (dataDetail != null) {
                    str = dataDetail.image;
                }
                initView(str, false);
                this.mIsAd = true;
                if (dataDetail == null || TextUtils.isEmpty(dataDetail.url) || TextUtils.isEmpty(dataDetail.clickContent)) {
                    this.mGoto_web.setVisibility(8);
                } else {
                    this.mGoto_web.setVisibility(0);
                }
                setLogoView(dataDetail != null ? dataDetail.useLogo : 0);
                this.layout_skip_ad_tv.setVisibility(0);
                this.mLogoContainerRoot.setVisibility(8);
                if (dataDetail != null && !TextUtils.isEmpty(dataDetail.clickContent)) {
                    this.mAdTips.setText(dataDetail.clickContent);
                }
                this.mGoto_web.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Map map;
                        AutoTrackHelper.trackViewOnClick(view);
                        HashMap hashMap = new HashMap();
                        hashMap.put(CommonBIUtil.KEY_ACDID, Integer.valueOf(AssetSplashViewLayout.this.getAcdId(dSplashResource)));
                        if (dSplashResource.data != null && dSplashResource.data.size() > 0) {
                            hashMap.putAll(dSplashResource.data.get(0).log_data);
                        }
                        String valueOf = String.valueOf(dSplashResource.data.get(0).activity_id);
                        String str = null;
                        if (AssetSplashViewLayout.this.getActivity() == null || TextUtils.isEmpty(valueOf)) {
                            map = null;
                        } else {
                            map = ResourceApi.getMapFromString(SystemUtils.getPreferences(AssetSplashViewLayout.this.getActivity(), 0), valueOf);
                            if (map != null && map.size() > 0) {
                                hashMap.putAll(map);
                            }
                            ResourceTrack.trackURL(ResourceApi.getListFromString(SystemUtils.getPreferences(AssetSplashViewLayout.this.getActivity(), 0), valueOf + "click"));
                        }
                        hashMap.put("key", ConstantUtils.PASSAGER_RESOURCE_NAME);
                        ResourceTrack.trackEventCK(map);
                        OmegaSDKAdapter.trackEvent(CommonBIUtil.TONE_P_X_BUB_ACT_CK, (Map<String, Object>) hashMap);
                        handler.sendEmptyMessage(102);
                        try {
                            Intent intent = new Intent("com.didi.home");
                            intent.addFlags(268435456);
                            intent.setPackage(AssetSplashViewLayout.this.getActivity().getPackageName());
                            AssetSplashViewLayout.this.getActivity().startActivity(intent);
                            Context context = AssetSplashViewLayout.this.getContext();
                            if (dataDetail != null) {
                                str = dataDetail.url;
                            }
                            AssetSplashViewLayout.this.getActivity().startActivity(PublicWebUtils.getWebActivity(context, str));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            setSkipInfo(3);
        }
    }

    private void setLogoView(int i) {
        if (i == 0) {
            try {
                this.mBottomLogo.setVisibility(8);
            } catch (NumberFormatException unused) {
                this.mBottomLogo.setVisibility(8);
            }
        } else {
            this.mBottomLogo.setVisibility(0);
            ImageView imageView = (ImageView) findViewById(R.id.buttom_iv);
            SystemUtils.log(3, "AssetSplashViewLayout", "AssetSplashViewLayout:" + ResourceLocale.isResourceLocaleIsPt(), (Throwable) null, "com.didichuxing.publicservice.resourcecontrol.view.AssetSplashViewLayout", 329);
            if (ResourceLocale.isResourceLocaleIsPt()) {
                imageView.setImageResource(R.drawable.guarana_advertise_logo);
            } else if (ResourceLocale.isResourceLocaleIsGl()) {
                imageView.setImageResource(R.drawable.global_advertise_logo);
            }
        }
    }

    public void setSkipInfo(int i) {
        if (this.mIsAd) {
            this.mSkipAd_Tv.setText(R.string.publicservice_skip_ad_hint);
            TextView textView = this.coutDowntime;
            textView.setText("" + i);
        }
    }

    /* access modifiers changed from: private */
    public int getAcdId(DSplashResource dSplashResource) {
        if (dSplashResource == null || dSplashResource.data == null || dSplashResource.data.size() <= 0) {
            return 0;
        }
        return dSplashResource.data.get(0).activity_id;
    }

    private void initMediaPlayer() {
        SurfaceHolder holder = this.surfaceView.getHolder();
        this.surfaceHolder = holder;
        holder.setFormat(-2);
        this.surfaceHolder.setKeepScreenOn(true);
        this.surfaceHolder.addCallback(this);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder2) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
            public void run() {
                AssetSplashViewLayout.this.autoPlay();
            }
        });
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder2) {
        AppUtils.log("splash--surfaceDestroyed-release-->>>");
    }

    /* access modifiers changed from: private */
    public void autoPlay() {
        try {
            File file = new File(this.localPath);
            if (file.exists()) {
                MediaPlayer mediaPlayer = new MediaPlayer();
                this.player = mediaPlayer;
                mediaPlayer.setAudioStreamType(3);
                this.player.setDisplay(this.surfaceHolder);
                this.player.setLooping(true);
                FileInputStream fileInputStream = new FileInputStream(file);
                this.player.reset();
                this.player.setDataSource(fileInputStream.getFD());
                this.player.prepareAsync();
                this.player.setVolume(0.0f, 0.0f);
                this.player.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                        AppUtils.log("splash--onBufferingUpdate-->>>" + i);
                    }
                });
                this.player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        AssetSplashViewLayout.this.start();
                    }
                });
                this.player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        AssetSplashViewLayout.this.start();
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void start() {
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            try {
                this.player.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void release() {
        try {
            if (this.player != null && this.player.isPlaying()) {
                this.player.stop();
                this.player.release();
                this.player = null;
            }
        } catch (Exception unused) {
        }
    }
}
