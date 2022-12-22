package com.didi.sdk.misconfig.p153v2.model;

import java.io.Serializable;

/* renamed from: com.didi.sdk.misconfig.v2.model.PriConfGroupModel */
public class PriConfGroupModel implements Serializable {
    private String a_T;
    private String groupIcon;
    private String groupIconActived;
    private int groupId;
    private String groupType;
    private String h5link;
    private String link;
    private String linkText;
    private String name;
    private String navTag;
    private String schema;
    private String sourceType;

    public int getGroupId() {
        return this.groupId;
    }

    public String getGroupType() {
        return this.groupType;
    }

    public String getLink() {
        return this.link;
    }

    public String getLinkText() {
        return this.linkText;
    }

    public String getGroupIcon() {
        return this.groupIcon;
    }

    public String getGroupIconActived() {
        return this.groupIconActived;
    }

    public String getName() {
        return this.name;
    }

    public String getSourceType() {
        return this.sourceType;
    }

    public String getH5link() {
        return this.h5link;
    }

    public String getNavTag() {
        return this.navTag;
    }

    public String getSchema() {
        return this.schema;
    }

    public String getA_T() {
        return this.a_T;
    }
}
