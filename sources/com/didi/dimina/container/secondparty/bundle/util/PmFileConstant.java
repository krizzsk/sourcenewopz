package com.didi.dimina.container.secondparty.bundle.util;

import com.didi.dimina.container.mina.DMSandboxHelper;
import java.io.File;

public class PmFileConstant {
    public static final String CACHE_DM_CONFIG_FILE_SUFFIX = ".cache";
    public static final String CONFIG_JSON = "config.json";
    public static final String DIMINA_NODE_CONFIG_ROOT_DIR = (DMSandboxHelper.DIMINA + File.separator + "dm_node_configs");
    public static final String DM_CONFIG_FILE_NAME = "dm_config.json";
    public static final String DM_CONFIG_FILE_NAME_IN_CACHE = "dm_config.json.cache";
    public static final String MODULE_UNZIP_SUCCESS_FLAG = ".SUCCESS";
    public static final String NODE_CONFIG_FILE_NAME_IN_CACHE = "config.json.cache";
    public static final String ZIP_SUFFIX = ".zip";

    public static String getDiminaBundleRootDir() {
        return DMSandboxHelper.DIMINA + File.separator + "dm_bundles_v2";
    }
}
