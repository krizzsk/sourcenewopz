package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;

public class OpenScreenEntity implements IEntity {
    private static final long serialVersionUID = -2622853375525979543L;
    public List<OpenScreenItemEntity> list;

    public static class OpenScreenItemEntity implements IEntity {
        private static final long serialVersionUID = 6671654647421537198L;
        public long effectiveTimeFrom;
        public long effectiveTimeTo;

        /* renamed from: id */
        public String f41042id;
        public String imageUrl;
        public int isExclusive;
        public String name;
        public String redirectUrl;
        public String textDescription;
        public int weight;
    }
}
