package com.didi.onekeyshare.presenter;

import android.app.Activity;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.model.IShareModel;
import com.didi.onekeyshare.model.ShareModel;
import com.didi.onekeyshare.track.OmegaTrack;
import com.didi.onekeyshare.view.IShareView;
import com.didi.onekeyshare.wrapper.ShareWrapper;
import java.util.List;
import java.util.Map;

public class SharePresenter implements ISharePresenter {

    /* renamed from: a */
    private IShareView f29772a;

    /* renamed from: b */
    private IShareModel f29773b = new ShareModel();

    /* renamed from: c */
    private ICallback.IPlatformCallback f29774c;

    /* renamed from: d */
    private ICallback.IShareCallback f29775d;

    /* renamed from: e */
    private ICallback.IPlatformShareCallback f29776e;

    /* renamed from: f */
    private Activity f29777f;

    public SharePresenter(Activity activity, IShareView iShareView) {
        this.f29772a = iShareView;
        this.f29777f = activity;
    }

    public void setCallback(ICallback iCallback) {
        if (iCallback != null) {
            if (iCallback instanceof ICallback.IPlatformCallback) {
                this.f29774c = (ICallback.IPlatformCallback) iCallback;
            }
            if (iCallback instanceof ICallback.IPlatformShareCallback) {
                this.f29776e = (ICallback.IPlatformShareCallback) iCallback;
            }
            if (iCallback instanceof ICallback.IShareCallback) {
                this.f29775d = (ICallback.IShareCallback) iCallback;
            }
        }
    }

    public void setShareInfo(List<OneKeyShareInfo> list) {
        this.f29773b.setShareInfo(list);
        this.f29772a.updateShareView(list);
    }

    public List<OneKeyShareInfo> getShareInfo() {
        return this.f29773b.getShareInfo();
    }

    public void onClickPlatform(OneKeyShareInfo oneKeyShareInfo) {
        share(oneKeyShareInfo);
    }

    public void onCancel() {
        m20894a();
    }

    public void onShow(List<OneKeyShareInfo> list) {
        if (list != null && this.f29772a.getContext() != null) {
            OmegaTrack.trackSharePagedShow(this.f29772a.getContext(), list);
        }
    }

    /* access modifiers changed from: protected */
    public void share(OneKeyShareInfo oneKeyShareInfo) {
        if (oneKeyShareInfo != null && oneKeyShareInfo.platform != null && oneKeyShareInfo.platform != SharePlatform.UNKNOWN) {
            m20895a(oneKeyShareInfo.platform);
            if (oneKeyShareInfo != null) {
                ShareWrapper.shareToPlatform(this.f29777f, oneKeyShareInfo, this.f29776e);
            }
        }
    }

    /* renamed from: a */
    private void m20894a() {
        ICallback.IShareCallback iShareCallback = this.f29775d;
        if (iShareCallback != null) {
            iShareCallback.onCancel();
        }
    }

    /* renamed from: a */
    private void m20895a(SharePlatform sharePlatform) {
        ICallback.IPlatformCallback iPlatformCallback = this.f29774c;
        if (iPlatformCallback != null) {
            iPlatformCallback.onClickPlatform(sharePlatform);
        }
        IShareView iShareView = this.f29772a;
        if (iShareView != null) {
            OmegaTrack.trackShareChannelClick(iShareView.getContext().getString(sharePlatform.alias()), (Map) null);
        }
    }
}
