package com.didi.unifylogin.presenter;

import android.content.Context;
import android.view.View;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.net.pojo.request.ChangeCellByIdCardParam;
import com.didi.unifylogin.base.net.pojo.response.ChangeCellResponse;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.pojo.FaceParam;
import com.didi.unifylogin.utils.OmegaUtils;
import com.didi.unifylogin.utils.customview.CommonBottomDialog;
import com.didi.unifylogin.utils.simplifycode.LoginServiceCallbackV2;
import com.didichuxing.foundation.rpc.RpcRequest;

public class CPFInputPresenter extends LoginBasePresenter<ICPFInputView> implements ICPFInputPresenter {
    public CPFInputPresenter(ICPFInputView iCPFInputView, Context context) {
        super(iCPFInputView, context);
    }

    public void verifyCPF() {
        OmegaUtils.ibt_gd_brchangephone_cfp_ck();
        ((ICPFInputView) this.view).showLoading((String) null);
        ChangeCellByIdCardParam changeCellByIdCardParam = new ChangeCellByIdCardParam(((ICPFInputView) this.view).getBaseActivity(), LoginScene.SCENE_CHANGE_PHONE_WITH_CODE.getSceneNum());
        changeCellByIdCardParam.setIdNum(((ICPFInputView) this.view).getCPF());
        getMessenger().setIdNum(((ICPFInputView) this.view).getCPF());
        LoginModel.getNet(this.context).changeCellByIdCard(changeCellByIdCardParam, new LoginServiceCallbackV2<ChangeCellResponse>(this.view) {
            /* access modifiers changed from: protected */
            public void handleError(RpcRequest rpcRequest) {
            }

            /* access modifiers changed from: protected */
            public boolean handleResponse(ChangeCellResponse changeCellResponse, int i, String str) {
                String str2;
                String str3;
                ((ICPFInputView) CPFInputPresenter.this.view).hideLoading();
                int i2 = changeCellResponse.errno;
                if (i2 == 41030) {
                    ((ICPFInputView) CPFInputPresenter.this.view).getBaseActivity().finish();
                    FaceParam faceParam = new FaceParam();
                    faceParam.setSessionId(changeCellResponse.sessionId);
                    faceParam.setAccessToken(changeCellResponse.accessToken);
                    faceParam.setBizCode(changeCellResponse.bizCode);
                    ListenerManager.getCpfInputListener().onSuccess(((ICPFInputView) CPFInputPresenter.this.view).getBaseActivity(), ((ICPFInputView) CPFInputPresenter.this.view).getCPF(), faceParam);
                    return true;
                } else if (i2 != 62403 || changeCellResponse.dialogData == null) {
                    return false;
                } else {
                    CommonBottomDialog commonBottomDialog = new CommonBottomDialog(((ICPFInputView) CPFInputPresenter.this.view).getBaseActivity());
                    commonBottomDialog.setCancelable(false);
                    String str4 = "";
                    if (changeCellResponse.dialogData.operations == null || changeCellResponse.dialogData.operations.size() <= 0) {
                        str3 = str4;
                        str2 = str3;
                    } else {
                        String str5 = str4;
                        for (ChangeCellResponse.Operation next : changeCellResponse.dialogData.operations) {
                            if (next.btnType == 0) {
                                str4 = next.title;
                            } else if (next.btnType == 1) {
                                str5 = next.title;
                            }
                        }
                        str2 = str4;
                        str3 = str5;
                    }
                    commonBottomDialog.show(changeCellResponse.dialogData.title, changeCellResponse.dialogData.text, str3, str2, (View) null, new CommonBottomDialog.BottomDialogInterface() {
                        public void onConfirmClicked(CommonBottomDialog commonBottomDialog) {
                            ((ICPFInputView) CPFInputPresenter.this.view).getBaseActivity().finish();
                        }

                        public void onCancelClicked(CommonBottomDialog commonBottomDialog) {
                            commonBottomDialog.dismiss();
                        }

                        public void onCloseDialog(CommonBottomDialog commonBottomDialog) {
                            super.onCloseDialog(commonBottomDialog);
                            commonBottomDialog.dismiss();
                        }
                    });
                    OmegaUtils.ibt_gd_brchangephone_cfp_popup_sw();
                    return true;
                }
            }
        });
    }
}
