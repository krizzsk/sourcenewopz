package com.didi.sdk.envsetbase.toolbase;

public enum EnvGroup {
    ENVIRONMENT("环境相关", 19),
    DATATOOLS("数据相关", 18),
    OTHERTOOLS("其他工具", 17);
    
    private String groupName;
    private int groupWeight;

    private EnvGroup(String str, int i) {
        this.groupName = str;
        this.groupWeight = i;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public int getGroupWeight() {
        return this.groupWeight;
    }
}
