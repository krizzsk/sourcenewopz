package com.didi.soda.customer;

import com.didi.jacoco.api.ICoverageConfig;
import com.didichuxing.bigdata.p173dp.locsdk.once.BuildConfig;

public class CoverageConfigImpl implements ICoverageConfig {
    public String appId() {
        return "101010";
    }

    public String branchName() {
        return BuildConfig.BUILD_BRANCH;
    }

    public long buildTime() {
        return 1669717960144L;
    }

    public String buildType() {
        return "release";
    }

    public String commitInfo() {
        return "{\"id\":\"7f0489faa4b072ea1c5d932245ed0976590fcb6a\",\"shortMessage\":\"Merge commit[7179a7eecff0c41cdfba64f55b0cac209b528a8e] by labwangteng\",\"commitTime\":1669717725,\"name\":\"labwangteng\",\"emailAddress\":\"labwangteng@didiglobal.com\"}";
    }

    public String flavor() {
        return "brazilEmbed";
    }

    public String jenkinsInfo() {
        return "{\"build_id\":\"7420\",\"build_url\":\"http://10.74.226.53:8080/job/android_common_aar_job_prod/7420/\"}";
    }

    public String url() {
        return "";
    }

    public String userEmail() {
        return "ep-robot@didichuxing.com";
    }

    public String userName() {
        return "admin";
    }
}
