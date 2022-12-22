package com.didi.soda.customer.biz.popdialog.natived.view;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import butterknife.BindView;
import com.didi.app.nova.skeleton.image.FitType;
import com.didi.app.nova.skeleton.image.ImageDownloadListener;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.biz.popdialog.natived.Contract;
import com.didi.soda.customer.foundation.imageloader.ClipBottomTransformation;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;
import com.didi.soda.customer.foundation.util.BitmapUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.taxis99.R;
import java.io.File;

public class ImagePopDialogView extends Contract.AbsPopDialogView {

    /* renamed from: a */
    private static final String f40511a = "ImagePopDialogView";
    @BindView(18457)
    ImageView mPopClose;
    @BindView(18458)
    ImageView mPopImage;
    @BindView(18558)
    View mRootView;

    public void updatePopDialog(final NAPopDialogEntity nAPopDialogEntity) {
        LogUtil.m29104i(f40511a, "updatePopDialog");
        FlyImageLoader.loadImageDownLoadOnly(getScopeContext(), FitType.FIT_None, nAPopDialogEntity.info.imgUrl).transform(new ClipBottomTransformation(getContext(), getResources().getDimensionPixelOffset(R.dimen.customer_580px), getResources().getDimensionPixelOffset(R.dimen.customer_774px), DisplayUtils.dip2px(getContext(), 5.0f))).downloadOnly(new ImageDownloadListener() {
            public void onFailure(Exception exc) {
                String str;
                if (exc != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(exc.getMessage());
                    sb.append(",getCause = ");
                    sb.append(exc.getCause() != null ? exc.getCause().getMessage() : "null");
                    str = sb.toString();
                    LogUtil.m29104i(ImagePopDialogView.f40511a, "down load image fail = " + str);
                } else {
                    str = "";
                }
                ((Contract.AbsPopDialogPresenter) ImagePopDialogView.this.getPresenter()).onDownloadPicFail(str);
            }

            public void onSuccess(File file) {
                Bitmap convertFileToBitmap = BitmapUtil.convertFileToBitmap(file);
                if (convertFileToBitmap == null) {
                    LogUtil.m29104i(ImagePopDialogView.f40511a, "convert file to bitmap fail");
                    ((Contract.AbsPopDialogPresenter) ImagePopDialogView.this.getPresenter()).onDownloadPicFail("convert file to bitmap fail");
                    return;
                }
                ImagePopDialogView.this.showPopDialog(nAPopDialogEntity);
                LogUtil.m29104i(ImagePopDialogView.f40511a, "download onSuccess");
                ((Contract.AbsPopDialogPresenter) ImagePopDialogView.this.getPresenter()).onDownloadPicSucess();
                ImagePopDialogView.this.mPopImage.setImageBitmap(convertFileToBitmap);
                ((Contract.AbsPopDialogPresenter) ImagePopDialogView.this.getPresenter()).onPopDialogShow();
            }
        });
    }

    public View getRootView() {
        return this.mRootView;
    }

    public View getContentView() {
        return this.mPopImage;
    }

    public View getClosedView() {
        return this.mPopClose;
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        this.mPopClose.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((Contract.AbsPopDialogPresenter) ImagePopDialogView.this.getPresenter()).onCloseBtnClick();
            }
        });
        this.mPopImage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ((Contract.AbsPopDialogPresenter) ImagePopDialogView.this.getPresenter()).onImageClick();
            }
        });
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_dialog_image_pop, viewGroup, true);
    }
}
