package com.didi.component.service.util.verifycard;

import android.content.Context;
import com.didi.component.business.data.form.FormStore;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalCheckCardData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public class VerifyCardOperator {
    public static final int VERIFY_FAILED = 100001;
    public static final int VERIFY_SUCCESS = 100000;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public IVerifyOperation f15784a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IDialogOperation f15785b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IProgressOperation f15786c;

    /* renamed from: d */
    private Context f15787d;

    public VerifyCardOperator(Context context) {
        this.f15787d = context;
    }

    public void setIVerifyOperation(IVerifyOperation iVerifyOperation) {
        this.f15784a = iVerifyOperation;
    }

    public void setIDialogOperation(IDialogOperation iDialogOperation) {
        this.f15785b = iDialogOperation;
    }

    public void setIProgressOperation(IProgressOperation iProgressOperation) {
        this.f15786c = iProgressOperation;
    }

    public void createVerifyDialog(final CarOrder carOrder) {
        VerifyCardDialogBuilder verifyCardDialogBuilder = new VerifyCardDialogBuilder(this.f15787d);
        verifyCardDialogBuilder.setDialogStatus(0);
        verifyCardDialogBuilder.setDialogOperation(new IDialogOperation() {
            public void dismiss() {
                VerifyCardOperator.this.f15785b.dismiss();
            }

            public void cancelDismiss() {
                VerifyCardOperator.this.f15785b.cancelDismiss();
            }
        });
        verifyCardDialogBuilder.setVerifyOperation(new IVerifyOperation() {
            public void onVerify(DidiGlobalCheckCardData.CheckCardParam checkCardParam) {
                if (checkCardParam.cardNo == null || checkCardParam.cardNo.length() >= 8) {
                    checkCardParam.cardIndex = VerifyCardOperator.this.m11514a();
                    checkCardParam.businessId = carOrder.productid;
                    VerifyCardOperator.this.m11516a(checkCardParam);
                    return;
                }
                VerifyCardOperator.this.f15785b.dismiss();
                VerifyCardDialogBuilder createResultDialog = VerifyCardOperator.this.createResultDialog();
                createResultDialog.setDialogStatus(2);
                VerifyCardOperator.this.f15785b.show(createResultDialog.buildDialog());
            }
        });
        this.f15785b.show(verifyCardDialogBuilder.buildDialog(carOrder));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m11514a() {
        return FormStore.getInstance().getCardIndex();
    }

    /* renamed from: b */
    private String m11517b() {
        return (NationTypeUtil.getNationComponentData() == null || NationTypeUtil.getNationComponentData().getLocCountry() == null) ? "" : NationTypeUtil.getNationComponentData().getLocCountry();
    }

    public VerifyCardDialogBuilder createResultDialog() {
        VerifyCardDialogBuilder verifyCardDialogBuilder = new VerifyCardDialogBuilder(this.f15787d);
        verifyCardDialogBuilder.setDialogOperation(new IDialogOperation() {
            public void dismiss() {
                if (VerifyCardOperator.this.f15785b != null) {
                    VerifyCardOperator.this.f15785b.dismiss();
                }
            }

            public void cancelDismiss() {
                VerifyCardOperator.this.f15785b.cancelDismiss();
            }
        });
        verifyCardDialogBuilder.setVerifyOperation(new IVerifyOperation() {
            public void onReVerfiry() {
                if (VerifyCardOperator.this.f15784a != null) {
                    VerifyCardOperator.this.f15784a.onReVerfiry();
                }
            }

            public void onSuccess() {
                if (VerifyCardOperator.this.f15784a != null) {
                    VerifyCardOperator.this.f15784a.onSuccess();
                }
            }

            public void onChangePayMethod() {
                if (VerifyCardOperator.this.f15784a != null) {
                    VerifyCardOperator.this.f15784a.onChangePayMethod();
                }
            }
        });
        return verifyCardDialogBuilder;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11516a(DidiGlobalCheckCardData.CheckCardParam checkCardParam) {
        IProgressOperation iProgressOperation = this.f15786c;
        if (iProgressOperation != null) {
            iProgressOperation.show();
        }
        DidiCreditCardFactory.createGlobalCreditCardApi().checkCardNo(this.f15787d, checkCardParam, new RpcService.Callback<DidiGlobalCheckCardData.CheckCardResult>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(DidiGlobalCheckCardData.CheckCardResult checkCardResult) {
                if (checkCardResult != null && checkCardResult.errNo == 0) {
                    VerifyCardOperator.this.f15786c.dismiss();
                    VerifyCardOperator.this.f15785b.dismiss();
                    VerifyCardDialogBuilder createResultDialog = VerifyCardOperator.this.createResultDialog();
                    if (checkCardResult.data != null && checkCardResult.data.code == 100000) {
                        createResultDialog.setDialogStatus(1);
                    } else if (checkCardResult.data != null && checkCardResult.data.code == 100001) {
                        createResultDialog.setDialogStatus(2);
                    }
                    VerifyCardOperator.this.f15785b.show(createResultDialog.buildDialog());
                }
            }
        });
    }
}
