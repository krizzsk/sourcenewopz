package com.didi.soda.order.binder.receipt;

import com.didi.app.nova.skeleton.repo.Repo;

public final class OrderReceiptInputLogicRepo extends Repo<ReceiptInputLogicModel> {
    public static final int LOGIC_RETURN_TYPE_STATE_CHANGED = 100;
    public static final int LOGIC_TYPE_MAIL_CLICKED = 0;
    public static final int LOGIC_TYPE_NAME_CHANGED = 1;

    public static class ReceiptInputLogicModel {
        public boolean isMailValid;
        public boolean isNameValid;
        public int logicType;
        public CharSequence receiptName;

        public static ReceiptInputLogicModel newNameChangedModel(CharSequence charSequence) {
            ReceiptInputLogicModel receiptInputLogicModel = new ReceiptInputLogicModel();
            receiptInputLogicModel.logicType = 1;
            receiptInputLogicModel.receiptName = charSequence;
            return receiptInputLogicModel;
        }

        public static ReceiptInputLogicModel newMailClickedModel() {
            ReceiptInputLogicModel receiptInputLogicModel = new ReceiptInputLogicModel();
            receiptInputLogicModel.logicType = 0;
            return receiptInputLogicModel;
        }

        public static ReceiptInputLogicModel newValidStateChangedModel(boolean z, boolean z2) {
            ReceiptInputLogicModel receiptInputLogicModel = new ReceiptInputLogicModel();
            receiptInputLogicModel.logicType = 100;
            receiptInputLogicModel.isNameValid = z;
            receiptInputLogicModel.isMailValid = z2;
            return receiptInputLogicModel;
        }
    }
}
