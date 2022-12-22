package com.didi.beatles.p099im.p100db.dao;

import com.didi.beatles.p099im.p100db.entity.IMSessionDaoEntity;
import com.didi.beatles.p099im.p100db.entity.IMUserDaoEntity;
import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDao;
import com.didi.beatles.p099im.thirty.greenrobot.dao.AbstractDaoSession;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.Database;
import com.didi.beatles.p099im.thirty.greenrobot.dao.identityscope.IdentityScopeType;
import com.didi.beatles.p099im.thirty.greenrobot.dao.internal.DaoConfig;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.beatles.im.db.dao.DaoSession */
public class DaoSession extends AbstractDaoSession {

    /* renamed from: a */
    private final DaoConfig f9167a;

    /* renamed from: b */
    private final DaoConfig f9168b;

    /* renamed from: c */
    private final SessionDao f9169c;

    /* renamed from: d */
    private final UserDao f9170d;

    /* renamed from: e */
    private Database f9171e;

    /* renamed from: f */
    private Map<String, MessageDao> f9172f = new HashMap();

    /* renamed from: g */
    private Map<String, UserDao> f9173g = new HashMap();

    /* renamed from: h */
    private Map<String, DaoConfig> f9174h = new HashMap();

    public DaoSession(Database database, IdentityScopeType identityScopeType, Map<String, DaoConfig> map) {
        super(database);
        this.f9171e = database;
        DaoConfig clone = map.get(DaoMaster.SESSION_TABLE).clone();
        this.f9167a = clone;
        clone.initIdentityScope(identityScopeType);
        DaoConfig clone2 = map.get(DaoMaster.USER_TABLE).clone();
        this.f9168b = clone2;
        clone2.initIdentityScope(identityScopeType);
        this.f9169c = new SessionDao(this.f9167a, this);
        this.f9170d = new UserDao(this.f9168b, this);
        registerDao(IMSessionDaoEntity.class, this.f9169c);
        registerDao(IMUserDaoEntity.class, this.f9170d);
    }

    public void clear() {
        this.f9167a.getIdentityScope().clear();
        this.f9168b.getIdentityScope().clear();
        if (!this.f9174h.isEmpty()) {
            for (Map.Entry value : this.f9174h.entrySet()) {
                try {
                    ((DaoConfig) value.getValue()).getIdentityScope().clear();
                } catch (Exception unused) {
                }
            }
        }
        if (!this.f9172f.isEmpty()) {
            this.f9172f.clear();
        }
    }

    /* renamed from: a */
    private DaoConfig m6219a(Class<? extends AbstractDao<?, ?>> cls, String str) {
        Map<String, DaoConfig> map = this.f9174h;
        if (map != null && map.containsKey(str)) {
            return this.f9174h.get(str);
        }
        DaoConfig daoConfig = new DaoConfig(this.f9171e, cls, str);
        this.f9174h.put(str, daoConfig);
        return daoConfig;
    }

    public boolean containsMessageDao(long j) {
        String str = "im_message_table_" + j;
        Map<String, MessageDao> map = this.f9172f;
        return map != null && map.containsKey(str);
    }

    public MessageDao getMessageDao(long j) {
        String str = "im_message_table_" + j;
        Map<String, MessageDao> map = this.f9172f;
        if (map != null && map.containsKey(str)) {
            return this.f9172f.get(str);
        }
        DaoConfig a = m6219a(MessageDao.class, str);
        a.initIdentityScope(IdentityScopeType.Session);
        MessageDao messageDao = new MessageDao(a, this, str);
        messageDao.createTable(this.f9171e, true);
        messageDao.updateTable(this.f9171e);
        this.f9172f.put(str, messageDao);
        return messageDao;
    }

    public UserDao getUserDao(long j) {
        String str = "im_user_table_" + j;
        Map<String, UserDao> map = this.f9173g;
        if (map != null && map.containsKey(str)) {
            return this.f9173g.get(str);
        }
        DaoConfig a = m6219a(UserDao.class, str);
        a.initIdentityScope(IdentityScopeType.Session);
        UserDao userDao = new UserDao(a, this);
        userDao.createTableDynamic(this.f9171e, true);
        this.f9173g.put(str, userDao);
        return userDao;
    }

    public boolean removeMessageDao(String str) {
        Map<String, MessageDao> map = this.f9172f;
        if (map == null || !map.containsKey(str)) {
            return false;
        }
        this.f9172f.remove(str);
        return true;
    }

    public boolean removeUserDao(String str) {
        Map<String, UserDao> map = this.f9173g;
        if (map == null || !map.containsKey(str)) {
            return false;
        }
        this.f9173g.remove(str);
        return true;
    }

    public SessionDao getSessionDao() {
        return this.f9169c;
    }

    public UserDao getUserDao() {
        return this.f9170d;
    }
}
