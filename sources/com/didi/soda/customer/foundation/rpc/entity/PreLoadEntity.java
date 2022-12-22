package com.didi.soda.customer.foundation.rpc.entity;

import java.util.List;

public class PreLoadEntity implements IEntity {
    private static final long serialVersionUID = 2702373758973172997L;
    public List<PreLoadModulesEntity> modules;

    public class PreLoadModulesEntity implements IEntity {
        private static final long serialVersionUID = 3338019765053881155L;
        public List<PreLoadItemEntity> list;
        public String module;

        public PreLoadModulesEntity() {
        }
    }

    public class PreLoadItemEntity implements IEntity {
        private static final long serialVersionUID = -3058217748304254259L;
        public String size;
        public String url;

        public PreLoadItemEntity() {
        }
    }
}
