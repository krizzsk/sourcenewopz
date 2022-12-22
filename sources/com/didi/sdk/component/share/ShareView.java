package com.didi.sdk.component.share;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.util.C10429QQ;
import com.didi.onekeyshare.util.QZone;
import com.didi.onekeyshare.util.Wechat;
import com.didi.onekeyshare.util.WechatMoments;
import com.didi.sdk.login.view.CommonDialog;
import com.didi.sdk.login.view.DialogHelper;
import com.didi.sdk.util.WindowUtil;
import com.didi.share.spi.ComponentManager;
import com.didi.sharesdk.OneKeyShareModel;
import com.didi.sharesdk.ShareApi;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShareView extends LinearLayout implements View.OnClickListener {
    public static final String ALIPAY_FRIENDS_NAME = "ALIPAY_FRIENDS";
    public static final String ALIPAY_FRIENDS_TIMELINE = "ALIPAY_TIMELINE";
    public static final int ID_ALIPAY_CIRCLE = 7;
    public static final int ID_ALIPAY_FRIEND = 6;
    public static final int ID_QQ = 4;
    public static final int ID_QZONE = 5;
    public static final int ID_SINA = 3;
    public static final int ID_SYS_MSG = 8;
    public static final int ID_WX_FRIENDS = 2;
    public static final int ID_WX_MOMENTS = 1;

    /* renamed from: a */
    private static final String f35673a = "share_channel=";

    /* renamed from: b */
    private Button f35674b;

    /* renamed from: c */
    private ShareReportModel f35675c;

    /* renamed from: d */
    private ShareModel f35676d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ShareListener f35677e;

    /* renamed from: f */
    private List<IShareViewAdapter> f35678f = new ArrayList();
    protected int itemNum = 0;
    protected ShareItemView mAlipayCircleView;
    protected ShareItemView mAlipayFriendsView;
    protected LinearLayout mContainerRow;
    protected LinearLayout mContainerRowSecond;
    protected Context mContext;
    protected ShareItemView mQqView;
    protected ShareItemView mQzoneView;
    protected ShareItemView mSinaView;
    protected ShareItemView mSystemMsgView;
    protected ShareItemView mWxFirendsView;
    protected ShareItemView mWxMomentsView;

    public interface ShareListener {
        public static final int PLATFORM_ALIPAY = 6;
        public static final int PLATFORM_QQ = 3;
        public static final int PLATFORM_QZONE = 4;
        public static final int PLATFORM_SINA = 5;
        public static final int PLATFORM_SYS_MSG = 7;
        public static final int PLATFORM_WECHAT = 1;
        public static final int PLATFORM_WECHATMOMENTS = 2;

        void onCancel();

        void onCancel(int i);

        void onClick(int i);

        void onComplete(int i);

        void onError(int i);
    }

    public static class ShareModel {
        public static final int ALIPAY_CIRCLE_PLAFORM = 16777216;
        public static final int ALIPAY_FRIEND_PLAFORM = 1048576;
        public static final int QQ_PLATFORM = 4096;
        public static final int QZONE_PLATFORM = 65536;
        public static final int SINAWEIBO_PLATFORM = 256;
        public static final int SYS_MSG = 268435456;
        public static final int WXCHAT_PLATFORM = 1;
        public static final int WXMOMENTS_PLATFORM = 16;
        public Bitmap bitmap;
        public String content;
        public String iconUrl;
        public String imagePath;
        public String imageUrl;
        public String message = "";
        public String phone = "";
        public int platforms = 273;
        public boolean silent = false;
        public String title;
        public int type = 0;
        public String url;
    }

    public ShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        m25261a();
    }

    public ShareView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        m25261a();
    }

    public ShareView(Activity activity) {
        super(activity);
        this.mContext = activity;
        m25261a();
    }

    public ShareView(Context context) {
        super(context);
        this.mContext = context;
        m25261a();
    }

    /* renamed from: a */
    private void m25261a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.v_share, this);
        this.mContainerRow = (LinearLayout) inflate.findViewById(R.id.ll_row_first);
        this.mContainerRowSecond = (LinearLayout) inflate.findViewById(R.id.ll_row_second);
        m25264b();
        Button button = (Button) inflate.findViewById(R.id.share_btn_cancel);
        this.f35674b = button;
        button.setOnClickListener(this);
    }

    /* renamed from: b */
    private void m25264b() {
        Iterator<S> componentIterator = ComponentManager.getInstance().getComponentIterator(IShareViewAdapter.class);
        while (componentIterator.hasNext()) {
            IShareViewAdapter iShareViewAdapter = (IShareViewAdapter) componentIterator.next();
            this.f35678f.add(iShareViewAdapter);
            iShareViewAdapter.init(this);
        }
    }

    public void setShareModel(ShareModel shareModel) {
        this.f35676d = shareModel;
        m25263a(shareModel);
    }

    public void setShareListener(ShareListener shareListener) {
        this.f35677e = shareListener;
        for (IShareViewAdapter shareListener2 : this.f35678f) {
            shareListener2.setShareListener(shareListener);
        }
    }

    public void setReportModel(ShareReportModel shareReportModel) {
        this.f35675c = shareReportModel;
    }

    /* access modifiers changed from: protected */
    public void share(final String str) {
        final int i;
        if (str.equals(Wechat.NAME)) {
            i = 1;
        } else if (str.equals(WechatMoments.NAME)) {
            i = 2;
        } else if (str.equals(C10429QQ.NAME)) {
            i = 3;
        } else {
            i = str.equals(QZone.NAME) ? 4 : 0;
        }
        ShareListener shareListener = this.f35677e;
        if (shareListener != null) {
            shareListener.onClick(i);
        }
        ShareApi.show((Activity) this.mContext, m25260a(str, this.f35676d), (ICallback.IPlatformShareCallback) new ICallback.IPlatformShareCallback() {
            public void onComplete(SharePlatform sharePlatform) {
                if (str.equals(Wechat.NAME)) {
                    ShareView.this.addAppSharePublicLog("g_app_public_log", "pay_share_suc_channel_ck", "2");
                } else if (str.equals(WechatMoments.NAME)) {
                    ShareView.this.addAppSharePublicLog("g_app_public_log", "pay_share_suc_channel_ck", "1");
                } else if (str.equals(C10429QQ.NAME)) {
                    ShareView.this.addAppSharePublicLog("g_app_public_log", "pay_share_suc_channel_ck", "5");
                } else if (str.equals(QZone.NAME)) {
                    ShareView.this.addAppSharePublicLog("g_app_public_log", "pay_share_suc_channel_ck", "4");
                }
                if (ShareView.this.f35677e != null) {
                    ShareView.this.f35677e.onComplete(i);
                }
            }

            public void onError(SharePlatform sharePlatform) {
                if (ShareView.this.f35677e != null) {
                    ShareView.this.f35677e.onError(i);
                }
            }

            public void onCancel(SharePlatform sharePlatform) {
                if (ShareView.this.f35677e != null) {
                    ShareView.this.f35677e.onCancel(i);
                }
            }
        });
    }

    /* renamed from: a */
    private void m25263a(ShareModel shareModel) {
        int i = shareModel.platforms;
        this.itemNum = 0;
        for (IShareViewAdapter next : this.f35678f) {
            if (next.getPlatformView() != null) {
                m25262a(i, next.getPlatform(), next.getPlatformView());
            }
        }
    }

    /* renamed from: c */
    private void m25265c() {
        for (int i = this.itemNum; i < 8; i++) {
            ShareItemView shareItemView = new ShareItemView(this.mContext);
            shareItemView.setVisibility(4);
            shareItemView.setClickable(false);
            shareItemView.setFocusable(false);
            if (i < 4) {
                this.mContainerRow.addView(shareItemView);
            } else {
                this.mContainerRowSecond.addView(shareItemView);
            }
            if (this.itemNum < 4) {
                this.mContainerRowSecond.setVisibility(8);
            }
        }
    }

    /* renamed from: a */
    private void m25262a(int i, int i2, View view) {
        if ((i & i2) == i2 && view != null && this.itemNum <= 5) {
            view.setVisibility(0);
            if (this.itemNum < 3) {
                this.mContainerRow.addView(view);
            } else {
                this.mContainerRowSecond.setVisibility(0);
                this.mContainerRowSecond.addView(view);
            }
            this.itemNum++;
        }
    }

    /* renamed from: a */
    private OneKeyShareModel m25260a(String str, ShareModel shareModel) {
        OneKeyShareModel oneKeyShareModel = new OneKeyShareModel(str);
        if (shareModel == null) {
            return oneKeyShareModel;
        }
        int i = 1;
        if (shareModel.type == 1) {
            oneKeyShareModel.imgUrl = shareModel.imageUrl;
            oneKeyShareModel.imgPath = shareModel.imagePath;
            oneKeyShareModel.bitmap = shareModel.bitmap;
            oneKeyShareModel.silent = true;
        } else {
            oneKeyShareModel.title = shareModel.title;
            oneKeyShareModel.content = shareModel.content;
            oneKeyShareModel.imgUrl = shareModel.imageUrl;
            oneKeyShareModel.bitmap = shareModel.bitmap;
            oneKeyShareModel.silent = true;
            if (!str.equals(Wechat.NAME)) {
                if (str.equals(WechatMoments.NAME)) {
                    i = 2;
                } else if (str.equals(C10429QQ.NAME)) {
                    i = 3;
                } else {
                    i = str.equals(QZone.NAME) ? 4 : 0;
                }
            }
            if (shareModel.url == null || shareModel.url.indexOf("?") == -1) {
                oneKeyShareModel.url = shareModel.url + "?" + f35673a + i;
            } else {
                oneKeyShareModel.url = shareModel.url + ParamKeys.SIGN_AND + f35673a + i;
            }
        }
        return oneKeyShareModel;
    }

    /* renamed from: d */
    private void m25266d() {
        ShareListener shareListener = this.f35677e;
        if (shareListener != null) {
            shareListener.onCancel();
        }
    }

    /* access modifiers changed from: protected */
    public void addAppSharePublicLog(String str, String str2, String str3) {
        ShareReportModel shareReportModel = this.f35675c;
        if (shareReportModel != null) {
            shareReportModel.channel = str3;
            this.f35675c.event_id = str2;
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == 1) {
            share(WechatMoments.NAME);
        } else if (id == 2) {
            share(Wechat.NAME);
        } else if (id == 4) {
            share(C10429QQ.NAME);
        } else if (id == 5) {
            share(QZone.NAME);
        } else if (id == R.id.share_btn_cancel) {
            m25266d();
        } else if (id == 6) {
            for (IShareViewAdapter onClick : this.f35678f) {
                onClick.onClick(id, this.mContext, this.f35676d);
            }
        } else if (id == 7) {
            for (IShareViewAdapter onClick2 : this.f35678f) {
                onClick2.onClick(id, this.mContext, this.f35676d);
            }
        } else if (id == 8) {
            this.f35677e.onClick(7);
            sendSMS(this.mContext, this.f35676d.phone, this.f35676d.message);
        }
    }

    public void onShareListenerClick(int i) {
        this.f35677e.onClick(i);
    }

    public void sendSMS(Context context, String str, String str2) {
        try {
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
            intent.putExtra("sms_body", str2);
            context.startActivity(intent);
        } catch (Exception unused) {
        }
    }

    public void showTipDialog(int i) {
        final DialogHelper dialogHelper = new DialogHelper(this.mContext);
        dialogHelper.setButtonType(CommonDialog.ButtonType.ONE);
        dialogHelper.setIconType(CommonDialog.IconType.INFO);
        dialogHelper.setSubmitBtnText(getContext().getString(R.string.confirm));
        dialogHelper.setTitleContent((String) null, this.mContext.getString(i));
        dialogHelper.setListener(new CommonDialog.CommonDialogListener() {
            public void cancel() {
            }

            public void firstClick() {
            }

            public void secondClick() {
            }

            public void submit() {
            }

            public void thirdClick() {
            }

            public void submitOnly() {
                dialogHelper.dismiss();
            }
        });
        dialogHelper.show();
    }

    public ShareItemView createShareItemView(int i, int i2, String str) {
        ShareItemView shareItemView = new ShareItemView(getContext());
        shareItemView.setInfo(i, str);
        shareItemView.setId(i2);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) WindowUtil.dip2pxWithResId(getContext(), R.dimen.share_btn_size), -1);
        layoutParams.weight = 1.0f;
        shareItemView.setLayoutParams(layoutParams);
        return shareItemView;
    }
}
