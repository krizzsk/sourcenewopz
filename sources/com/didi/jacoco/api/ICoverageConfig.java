package com.didi.jacoco.api;

public interface ICoverageConfig {
    String appId();

    String branchName();

    long buildTime();

    String buildType();

    String commitInfo();

    String flavor();

    String jenkinsInfo();

    String url();

    String userEmail();

    String userName();
}
