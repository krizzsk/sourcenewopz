package com.didi.onekeyshare.wrapper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.wrapper.FacebookPlatform;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.share.ErrorCode;
import com.facebook.CallbackManager;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.taxis99.R;

public class DispatchFacebookShareCbActivity extends Activity {

    /* renamed from: a */
    CallbackManager f29831a;

    /* renamed from: b */
    ShareDialog f29832b;

    /* renamed from: c */
    private String f29833c;

    /* renamed from: d */
    private String f29834d;

    /* renamed from: e */
    private String f29835e;

    /* renamed from: f */
    private String f29836f;

    /* renamed from: g */
    private String f29837g;

    /* renamed from: h */
    private Bitmap f29838h;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_facebook_share_entry);
        this.f29831a = CallbackManager.Factory.create();
        Intent intent = getIntent();
        if (intent == null) {
            finish();
        }
        this.f29833c = intent.getStringExtra("url");
        this.f29834d = intent.getStringExtra("title");
        this.f29835e = intent.getStringExtra("content");
        this.f29836f = intent.getStringExtra("imgUrl");
        this.f29837g = intent.getStringExtra("imgPath");
        ICallback.IPlatformShareCallback iPlatformShareCallback = FacebookPlatform.sCallback;
        if (!TextUtil.isEmpty(this.f29833c)) {
            ShareLinkContent build = ((ShareLinkContent.Builder) new ShareLinkContent.Builder().setContentUrl(Uri.parse(this.f29833c))).setQuote(this.f29834d + "\n" + this.f29835e).build();
            ShareDialog shareDialog = new ShareDialog((Activity) this);
            this.f29832b = shareDialog;
            if (iPlatformShareCallback != null) {
                shareDialog.registerCallback(this.f29831a, new FacebookPlatform.ShareCallback(iPlatformShareCallback));
            }
            this.f29832b.show((ShareContent<?, ?>) build, ShareDialog.Mode.AUTOMATIC);
        } else {
            SharePhoto.Builder builder = new SharePhoto.Builder();
            Bitmap bitmap = this.f29838h;
            if (bitmap != null) {
                builder.setBitmap(bitmap);
            } else if (!TextUtil.isEmpty(this.f29836f)) {
                builder.setImageUrl(Uri.parse(this.f29836f));
            } else if (!TextUtil.isEmpty(this.f29837g)) {
                builder.setImageUrl(Uri.parse(this.f29837g));
            } else {
                if (iPlatformShareCallback != null) {
                    if (iPlatformShareCallback instanceof ICallback.IPlatformShareCallback2) {
                        ((ICallback.IPlatformShareCallback2) iPlatformShareCallback).onError(SharePlatform.FACEBOOK_PLATFORM, ErrorCode.ERROR_PARAMS);
                    } else if (iPlatformShareCallback instanceof ICallback.IPlatformShareCallback) {
                        iPlatformShareCallback.onError(SharePlatform.FACEBOOK_PLATFORM);
                    }
                }
                finish();
                return;
            }
            SharePhotoContent build2 = new SharePhotoContent.Builder().addPhoto(builder.build()).build();
            ShareDialog shareDialog2 = new ShareDialog((Activity) this);
            this.f29832b = shareDialog2;
            if (iPlatformShareCallback != null) {
                shareDialog2.registerCallback(this.f29831a, new FacebookPlatform.ShareCallback(iPlatformShareCallback));
            }
            this.f29832b.show((ShareContent<?, ?>) build2, ShareDialog.Mode.AUTOMATIC);
        }
        FacebookPlatform.sCallback = null;
        FacebookPlatform.sBitmap = null;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        CallbackManager callbackManager = this.f29831a;
        if (callbackManager != null) {
            callbackManager.onActivityResult(i, i2, intent);
        }
        if (!isFinishing()) {
            finish();
        }
    }
}
