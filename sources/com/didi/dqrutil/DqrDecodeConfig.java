package com.didi.dqrutil;

public interface DqrDecodeConfig {
    boolean analysisDqr();

    int binarizerType();

    boolean caculateIncline();

    int contourDilateCount();

    int contourFinderRate();

    boolean cropRect();

    int cropRedundancy();

    float cvBlockSizeFact();

    int findBestPatternType();

    int newFinderRate();

    int opencvBlockBulking();

    float patternCorrectLimit();

    int patternCorrectRate();

    int patternMinValidCount();

    float patternTolerant();

    boolean useContourFinder();

    boolean useDynamicCVBlocksize();

    boolean useFilter();

    int useNativeDecodeRate();

    boolean usePatternAutoComple();

    boolean usePatternCorrect();
}
