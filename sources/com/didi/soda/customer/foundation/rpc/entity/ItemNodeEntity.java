package com.didi.soda.customer.foundation.rpc.entity;

public class ItemNodeEntity implements IEntity {
    private static final long serialVersionUID = -4739632745800676729L;
    public int amount;
    public int level;
    public String nodeId;
    public String parentId;
    public int totalLevel;
    public int type;

    public ItemNodeEntity copy() {
        ItemNodeEntity itemNodeEntity = new ItemNodeEntity();
        itemNodeEntity.nodeId = this.nodeId;
        itemNodeEntity.parentId = this.parentId;
        itemNodeEntity.type = this.type;
        itemNodeEntity.amount = this.amount;
        itemNodeEntity.level = this.level;
        itemNodeEntity.totalLevel = this.totalLevel;
        return itemNodeEntity;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemNodeEntity)) {
            return false;
        }
        String str = this.nodeId;
        String str2 = ((ItemNodeEntity) obj).nodeId;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.nodeId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ItemNodeEntity{nodeId='" + this.nodeId + '\'' + ", parentId='" + this.parentId + '\'' + ", type=" + this.type + ", amount=" + this.amount + ", level=" + this.level + ", totalLevel=" + this.totalLevel + '}';
    }
}
