package com.didi.beatles.p099im.service.dao;

import com.didi.beatles.p099im.p100db.dao.DaoMaster;
import com.didi.beatles.p099im.thirty.greenrobot.dao.database.Database;

/* renamed from: com.didi.beatles.im.service.dao.IMDaoInit */
public interface IMDaoInit {
    void end();

    Database getInitDatabase();

    DaoMaster.DevOpenHelper getOpenHelper();

    void init(long j) throws Exception;
}
