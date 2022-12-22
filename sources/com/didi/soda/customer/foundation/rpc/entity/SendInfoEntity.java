package com.didi.soda.customer.foundation.rpc.entity;

public class SendInfoEntity implements IEntity {
    private static final long serialVersionUID = -5682168664892725815L;
    public BindEmailConfirmEntity bindEmailConfirm;
    public String email;
    public int emailStatus;
    public String phone;
    public int sendingStatus;

    public static class BindEmailConfirmEntity implements IEntity {
        private static final long serialVersionUID = 6048419117098698255L;
        public String cancelBtnDesc;
        public String msg;
        public String okBtnDesc;
        public String title;
    }
}
