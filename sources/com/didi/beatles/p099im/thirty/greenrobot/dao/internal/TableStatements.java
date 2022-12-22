package com.didi.beatles.p099im.thirty.greenrobot.dao.internal;

import com.didi.beatles.p099im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.DatabaseStatement;

/* renamed from: com.didi.beatles.im.thirty.greenrobot.dao.internal.TableStatements */
public class TableStatements {

    /* renamed from: a */
    private final Database f9705a;

    /* renamed from: b */
    private final String f9706b;

    /* renamed from: c */
    private final String[] f9707c;

    /* renamed from: d */
    private final String[] f9708d;

    /* renamed from: e */
    private DatabaseStatement f9709e;

    /* renamed from: f */
    private DatabaseStatement f9710f;

    /* renamed from: g */
    private DatabaseStatement f9711g;

    /* renamed from: h */
    private DatabaseStatement f9712h;

    /* renamed from: i */
    private volatile String f9713i;

    /* renamed from: j */
    private volatile String f9714j;

    /* renamed from: k */
    private volatile String f9715k;

    /* renamed from: l */
    private volatile String f9716l;

    public TableStatements(Database database, String str, String[] strArr, String[] strArr2) {
        this.f9705a = database;
        this.f9706b = str;
        this.f9707c = strArr;
        this.f9708d = strArr2;
    }

    public DatabaseStatement getInsertStatement() {
        if (this.f9709e == null) {
            this.f9709e = this.f9705a.compileStatement(SqlUtils.createSqlInsert("INSERT INTO ", this.f9706b, this.f9707c));
        }
        return this.f9709e;
    }

    public DatabaseStatement getInsertOrReplaceStatement() {
        if (this.f9710f == null) {
            this.f9710f = this.f9705a.compileStatement(SqlUtils.createSqlInsert("INSERT OR REPLACE INTO ", this.f9706b, this.f9707c));
        }
        return this.f9710f;
    }

    public DatabaseStatement getDeleteStatement() {
        if (this.f9712h == null) {
            this.f9712h = this.f9705a.compileStatement(SqlUtils.createSqlDelete(this.f9706b, this.f9708d));
        }
        return this.f9712h;
    }

    public DatabaseStatement getUpdateStatement() {
        if (this.f9711g == null) {
            this.f9711g = this.f9705a.compileStatement(SqlUtils.createSqlUpdate(this.f9706b, this.f9707c, this.f9708d));
        }
        return this.f9711g;
    }

    public String getSelectAll() {
        if (this.f9713i == null) {
            this.f9713i = SqlUtils.createSqlSelect(this.f9706b, "T", this.f9707c);
        }
        return this.f9713i;
    }

    public String getSelectKeys() {
        if (this.f9716l == null) {
            this.f9716l = SqlUtils.createSqlSelect(this.f9706b, "T", this.f9708d);
        }
        return this.f9716l;
    }

    public String getSelectByKey() {
        if (this.f9714j == null) {
            StringBuilder sb = new StringBuilder(getSelectAll());
            sb.append("WHERE ");
            SqlUtils.appendColumnsEqValue(sb, "T", this.f9708d);
            this.f9714j = sb.toString();
        }
        return this.f9714j;
    }

    public String getSelectByRowId() {
        if (this.f9715k == null) {
            this.f9715k = getSelectAll() + "WHERE ROWID=?";
        }
        return this.f9715k;
    }
}
