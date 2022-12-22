package com.didi.soda.business.component.image;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.soda.business.component.home.PreviewImageModel;
import com.didi.soda.business.component.image.Contract;
import com.didi.soda.business.manager.BusinessOmegaHelper;
import com.didi.soda.cart.model.BusinessState;
import com.didi.soda.cart.repo.BusinessStateRepo;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.repo.RepoFactory;
import java.io.Serializable;

public class BusinessPreviewImagePresenter extends Contract.AbsBusinessImagePresenter {

    /* renamed from: a */
    private OnPreviewImageListener f39598a;

    /* renamed from: b */
    private BusinessOmegaHelper f39599b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f39600c;

    /* renamed from: d */
    private String f39601d;

    /* renamed from: e */
    private PreviewImageModel f39602e;

    /* renamed from: f */
    private boolean f39603f;

    public BusinessPreviewImagePresenter(OnPreviewImageListener onPreviewImageListener) {
        this.f39598a = onPreviewImageListener;
    }

    public void finish(int i) {
        PreviewImageModel previewImageModel = this.f39602e;
        m28167a().onPreviewImageCloseCk(previewImageModel != null ? previewImageModel.mGoodId : "0", i);
        getScopeContext().getNavigator().finish();
    }

    public void clickAddBtn(PreviewImageModel previewImageModel) {
        OnPreviewImageListener onPreviewImageListener = this.f39598a;
        if (onPreviewImageListener != null) {
            onPreviewImageListener.onClickAddEvent(previewImageModel);
            ((PreviewImageRepo) RepoFactory.getRepo(PreviewImageRepo.class)).clickAdd(previewImageModel);
        }
    }

    public void onBigImageSw(PreviewImageModel previewImageModel) {
        if (!this.f39603f) {
            m28167a().onPreviewImageSw(previewImageModel);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        Serializable serializable = getScopeContext().getBundle().getSerializable(Const.PageParams.PREVIEW_IMAGE);
        if (serializable instanceof PreviewImageModel) {
            PreviewImageModel previewImageModel = (PreviewImageModel) serializable;
            this.f39602e = previewImageModel;
            ((Contract.AbsBusinessImageView) getLogicView()).updateView(previewImageModel);
            this.f39601d = previewImageModel.mShopId;
            ((BusinessStateRepo) RepoFactory.getRepo(BusinessStateRepo.class)).subscribe(previewImageModel.mShopId, getScopeContext(), new Action1<BusinessState>() {
                public void call(BusinessState businessState) {
                    int unused = BusinessPreviewImagePresenter.this.f39600c = businessState.shopStatus;
                    BusinessPreviewImagePresenter.this.m28167a().updateBusinessStatus(BusinessPreviewImagePresenter.this.f39600c);
                }
            });
            return;
        }
        LogUtil.m29102e("TAG", "传入的数据不正确");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f39603f = true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public BusinessOmegaHelper m28167a() {
        if (this.f39599b == null) {
            this.f39599b = new BusinessOmegaHelper(getScopeContext(), this.f39601d, this.f39600c);
        }
        return this.f39599b;
    }
}
