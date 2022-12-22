package com.didi.onekeyshare.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.presenter.ISharePresenter;
import com.didi.onekeyshare.presenter.SharePresenter;
import com.didi.onekeyshare.view.ShareView;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.List;

public class ShareDialog extends Dialog implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, IShareView, ShareView.IShareListener {

    /* renamed from: a */
    private ShareView f29783a;

    /* renamed from: b */
    private ISharePresenter f29784b;

    public ShareDialog(Activity activity) {
        super(activity, R.style.tone_share_style_dialog_activity);
        ShareView shareView = new ShareView(activity);
        this.f29783a = shareView;
        shareView.setShareListener(this);
        this.f29784b = new SharePresenter(activity, this);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        setOnCancelListener(this);
        setOnDismissListener(this);
        setContentView(this.f29783a, new ViewGroup.LayoutParams(-1, -1));
        m20899a();
    }

    /* renamed from: a */
    private void m20899a() {
        Window window = getWindow();
        window.setWindowAnimations(R.style.tone_share_style_dialog_animation);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = -1;
        attributes.width = -1;
        window.setAttributes(attributes);
    }

    public ISharePresenter getSharePresenter() {
        return this.f29784b;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.f29784b.onCancel();
    }

    public void onClickPlatform(OneKeyShareInfo oneKeyShareInfo) {
        m20900b();
        this.f29784b.onClickPlatform(oneKeyShareInfo);
    }

    public void onCancel() {
        m20900b();
        this.f29784b.onCancel();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        m20900b();
        this.f29784b.onCancel();
        return true;
    }

    public void show() {
        super.show();
        this.f29784b.onShow(this.f29783a.getShareInfo());
        this.f29783a.enterAnimation();
    }

    public void updateShareView(List<OneKeyShareInfo> list) {
        this.f29783a.setShareInfo(list);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        SystemUtils.log(6, "-one-share-", "---->didi one share dialog dismiss", (Throwable) null, "com.didi.onekeyshare.view.ShareDialog", 103);
    }

    /* renamed from: b */
    private void m20900b() {
        SystemUtils.log(6, "-one-share-", "---->>>dismissDialog", (Throwable) null, "com.didi.onekeyshare.view.ShareDialog", 107);
        this.f29783a.exitAnimation(new Animation.AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                ShareDialog.this.dismiss();
            }
        });
    }
}
