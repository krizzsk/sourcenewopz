package com.didi.soda.customer.foundation.rpc.entity;

public class ShareCouponInfoEntity implements IEntity {
    private static final long serialVersionUID = 5262844524845726119L;
    public ShareInfoEntity data;
    public String type;

    public static class ShareInfoEntity implements IEntity {
        private static final long serialVersionUID = 85141142850544622L;
        public String content;
        public String icon;
        public String image;
        public String title;
        public String type;
        public String url;
    }
}
