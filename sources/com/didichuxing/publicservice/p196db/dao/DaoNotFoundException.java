package com.didichuxing.publicservice.p196db.dao;

import com.didichuxing.publicservice.p196db.dao.DaoFactory;

/* renamed from: com.didichuxing.publicservice.db.dao.DaoNotFoundException */
public class DaoNotFoundException extends RuntimeException {
    public DaoNotFoundException(DaoFactory.DaoType daoType) {
        super(daoType + "not found in DaoFactory");
    }
}
