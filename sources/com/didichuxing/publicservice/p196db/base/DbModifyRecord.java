package com.didichuxing.publicservice.p196db.base;

import java.util.HashSet;
import java.util.Set;

/* renamed from: com.didichuxing.publicservice.db.base.DbModifyRecord */
public class DbModifyRecord {
    public Set<BaseModel> modifiedTables = new HashSet();
    public int modifyVersion;

    public DbModifyRecord(int i) {
        this.modifyVersion = i;
    }

    public DbModifyRecord addTable(BaseModel baseModel) {
        this.modifiedTables.add(baseModel);
        return this;
    }
}
