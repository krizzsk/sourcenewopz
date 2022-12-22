package com.didi.onehybrid.resource.offline;

import android.provider.BaseColumns;

public final class FusionContract {

    public static class OfflineBundle implements BaseColumns {
        public static final String COLUMN_NAME_BUNDLE_NAME = "bundle_name";
        public static final String COLUMN_NAME_DOWNLOAD_MODE = "download_mode";
        public static final String COLUMN_NAME_DOWNLOAD_URL = "download_url";
        public static final String COLUMN_NAME_MD5 = "md5";
        public static final String COLUMN_NAME_RESOURCE_NAME = "resource_name";
        public static final String COLUMN_NAME_RESOURCE_URL = "resource_url";
        public static final String COLUMN_NAME_STATE = "state";
        public static final String COLUMN_NAME_VERSION = "version";
        public static final String TABLE_NAME = "offlinebundles";
        public static final String TABLE_RESOURCE_NAME = "offlinebundleresource";
    }

    private FusionContract() {
    }
}
