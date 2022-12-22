package com.didi.soda.customer.biz.popdialog.natived;

import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.customer.base.ICustomerPresenter;
import com.didi.soda.customer.base.ICustomerView;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.manager.CustomerGuideManager;

public interface Contract {

    public interface NaPopBinderActionListener {
        void onBindAction(String str, int i, String str2, int i2);

        void onOperationClickAction(String str, int i);
    }

    public static abstract class AbsPopDialogView extends ICustomerView<AbsPopDialogPresenter> implements DialogAnimateInterface {
        public void updatePopDialog(NAPopDialogEntity nAPopDialogEntity) {
        }

        public void hidePopDialog(NAPopDialogEntity nAPopDialogEntity) {
            if (nAPopDialogEntity.animationEffect != 0) {
                PopDialogAnimateHelper.disAppearDialogWithAnimate(this);
            } else if (getRootView() != null) {
                getRootView().setVisibility(8);
                CustomerGuideManager.Companion.getInstance().syncAndTriggerCustomerGuideInfoShown();
            }
        }

        /* access modifiers changed from: protected */
        public void showPopDialog(NAPopDialogEntity nAPopDialogEntity) {
            if (nAPopDialogEntity.animationEffect != 0) {
                PopDialogAnimateHelper.appearDialogWithAnimate(this);
            } else if (getRootView() != null) {
                getRootView().setVisibility(0);
            }
        }
    }

    public static abstract class AbsPopDialogPresenter extends ICustomerPresenter<AbsPopDialogView> {
        private static final String TAG = "AbsPopDialogPresenter";
        private long mDownloadSucTime;
        /* access modifiers changed from: private */
        public long mFetchStartTime;
        /* access modifiers changed from: private */
        public boolean mHasLoadFinish;
        private long mImageRequestStartTime;
        private boolean mOnPause = true;
        protected final NAPopDialogEntity mPopDialogEntity;
        protected PopDialogOmageHelper mPopDialogOmageHelper;
        private Subscription mSubscription;

        /* access modifiers changed from: protected */
        public String getActivityUrl() {
            return "";
        }

        public AbsPopDialogPresenter(NAPopDialogEntity nAPopDialogEntity) {
            this.mPopDialogEntity = nAPopDialogEntity;
        }

        public void onBtnClick() {
            this.mPopDialogOmageHelper.mo102141b(EventConst.PopDialog.REDENVELOPE_BUTTON_CK);
        }

        public void onImageClick() {
            this.mPopDialogOmageHelper.mo102142c(getActivityUrl());
        }

        public void onOperationClick(String str, int i) {
            this.mPopDialogOmageHelper.mo102138a(str, i);
            ((AbsPopDialogView) getLogicView()).hidePopDialog(this.mPopDialogEntity);
        }

        public void onBindAction(String str, int i, String str2, int i2) {
            this.mPopDialogOmageHelper.popRealRedEnvElope(str, i, str2, i2);
        }

        public void onCloseBtnClick() {
            ((AbsPopDialogView) getLogicView()).hidePopDialog(this.mPopDialogEntity);
            this.mPopDialogOmageHelper.mo102141b(EventConst.PopDialog.REDENVELOPE_CLOSE_CK);
        }

        public void onPopDialogShow() {
            this.mPopDialogOmageHelper.mo102137a(getActivityUrl());
            this.mPopDialogOmageHelper.create(EventConst.PopDialog.REDENVELOPE_SHOW).addEventParam(ParamConst.PARAM_DRAW_DURATION, Long.valueOf(System.currentTimeMillis() - this.mDownloadSucTime)).addEventParam("duration", Long.valueOf(System.currentTimeMillis() - this.mFetchStartTime)).addEventParam("is_suc", 1).addEventParam(ParamConst.PARAM_IS_ONBACKGROUD, Boolean.valueOf(this.mOnPause)).build().track();
            this.mHasLoadFinish = true;
            reportPopDialogExposure(this.mPopDialogEntity.f41041id);
        }

        public void onDownloadPicSucess() {
            this.mDownloadSucTime = System.currentTimeMillis();
            this.mPopDialogOmageHelper.mo102139a(EventConst.PopDialog.REDENVELOPE_IMAGE_DOWNLOAD, this.mImageRequestStartTime, 1);
        }

        public void onDownloadPicFail(String str) {
            this.mPopDialogOmageHelper.mo102140a(ErrorConst.ErrorName.FLY_EXCEPTION, "", str);
            this.mPopDialogOmageHelper.mo102139a(EventConst.PopDialog.REDENVELOPE_IMAGE_DOWNLOAD, this.mImageRequestStartTime, 2);
            this.mPopDialogOmageHelper.mo102139a(EventConst.PopDialog.REDENVELOPE_SHOW, this.mFetchStartTime, 2);
            this.mHasLoadFinish = true;
            CustomerGuideManager.Companion.getInstance().syncAndTriggerCustomerGuideInfoShown();
        }

        /* access modifiers changed from: protected */
        public void onCreate() {
            super.onCreate();
            this.mPopDialogOmageHelper = new PopDialogOmageHelper(getScopeContext(), this.mPopDialogEntity);
            this.mImageRequestStartTime = System.currentTimeMillis();
            this.mFetchStartTime = ((Long) getScopeContext().getObject("duration_key")).longValue();
            this.mSubscription = ((AppKillRepo) RepoFactory.getRepo(AppKillRepo.class)).subscribe(getScopeContext(), new Action1<Boolean>() {
                public void call(Boolean bool) {
                    LogUtil.m29104i(AbsPopDialogPresenter.TAG, "AppKillRepo call " + bool);
                    if (bool != null && bool.booleanValue() && !AbsPopDialogPresenter.this.mHasLoadFinish) {
                        AbsPopDialogPresenter.this.mPopDialogOmageHelper.mo102139a(EventConst.PopDialog.REDENVELOPE_APP_KILL, AbsPopDialogPresenter.this.mFetchStartTime, -1);
                    }
                }
            });
        }

        /* access modifiers changed from: protected */
        public void onResume() {
            super.onResume();
            this.mOnPause = false;
        }

        /* access modifiers changed from: protected */
        public void onPause() {
            super.onPause();
            this.mOnPause = true;
        }

        /* access modifiers changed from: protected */
        public void onDestroy() {
            super.onDestroy();
            LogUtil.m29104i(TAG, "onPageDestory = " + this.mHasLoadFinish);
            if (!this.mHasLoadFinish) {
                this.mPopDialogOmageHelper.mo102139a(EventConst.PopDialog.REDENVELOPE_PAGE_DESTORY, this.mFetchStartTime, -1);
            }
            Subscription subscription = this.mSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
                this.mSubscription = null;
            }
            this.mPopDialogOmageHelper.onClear();
        }

        private void reportPopDialogExposure(String str) {
            ((C13643a) RepoFactory.getRepo(C13643a.class)).mo102151a(str, (CustomerRpcCallback<Object>) new CustomerRpcCallback<Object>() {
                public void onRpcFailure(SFRpcException sFRpcException) {
                }

                public void onRpcSuccess(Object obj, long j) {
                }
            });
        }
    }
}
