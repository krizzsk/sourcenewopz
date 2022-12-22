package com.didichuxing.mas.sdk.quality.collect.ditest.agent.android.socketanalysis.config;

import com.facebook.appevents.UserDataStore;

public class SocketConfig {
    public static long DEFAULT_FILE_EXPIRATION_TIME = 86400000;
    public static int DEFAULT_MAX_UPLOAD_LIMIT_PER_DAY = 1500;
    public static boolean DEFAULT_SOCKET_DISK_CACHE = true;
    public static long DEFAULT_UPLOAD_INTERVAL = 600000;
    public static long DEFAULT_WRITE_DISK_INTERVAL = 60000;
    public static long FILE_EXPIRATION_TIME = 86400000;
    public static int MAX_UPLOAD_LIMIT_PER_DAY = 1500;
    public static final String[] PREDEFINED_SOCKET_CONNECTION_KEYS = {"tls", "ver", "ec", UserDataStore.CITY, "fct", "cfc"};
    public static final String[] PREDEFINED_SOCKET_TRANSACTION_KEYS = {"tls", "ver", "seqid", "time", "up", "down", "type"};
    public static boolean SOCKET_DISK_CACHE = true;
    public static boolean SWITCH_SOCKET_CONNECTION_STAT = false;
    public static boolean SWITCH_SOCKET_TRANSACTION_STAT = false;
    public static long UPLOAD_INTERVAL = 600000;
    public static long WRITE_DISK_INTERVAL = 60000;
}
