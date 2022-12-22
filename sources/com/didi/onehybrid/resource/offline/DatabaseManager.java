package com.didi.onehybrid.resource.offline;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

public class DatabaseManager {
    private static DatabaseManager instance;
    private static SQLiteOpenHelper mDatabaseHelper;
    private SQLiteDatabase mDatabase;
    private AtomicInteger mOpenCounter = new AtomicInteger();

    public static synchronized void initializeInstance(SQLiteOpenHelper sQLiteOpenHelper) {
        synchronized (DatabaseManager.class) {
            if (instance == null) {
                instance = new DatabaseManager();
                mDatabaseHelper = sQLiteOpenHelper;
            }
        }
    }

    public static synchronized DatabaseManager getInstance(SQLiteOpenHelper sQLiteOpenHelper) {
        DatabaseManager databaseManager;
        synchronized (DatabaseManager.class) {
            if (instance == null) {
                initializeInstance(sQLiteOpenHelper);
            }
            databaseManager = instance;
        }
        return databaseManager;
    }

    public synchronized SQLiteDatabase getWritableDatabase() {
        if (this.mOpenCounter.incrementAndGet() == 1) {
            this.mDatabase = mDatabaseHelper.getWritableDatabase();
        }
        return this.mDatabase;
    }

    public synchronized SQLiteDatabase getReadableDatabase() {
        if (this.mOpenCounter.incrementAndGet() == 1) {
            this.mDatabase = mDatabaseHelper.getReadableDatabase();
        }
        return this.mDatabase;
    }

    public synchronized void closeDatabase() {
        if (this.mOpenCounter.decrementAndGet() == 0) {
            this.mDatabase.close();
        }
    }
}
