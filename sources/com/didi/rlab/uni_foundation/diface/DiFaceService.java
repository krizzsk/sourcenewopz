package com.didi.rlab.uni_foundation.diface;

import java.util.Map;

public interface DiFaceService {

    public interface Result<T> {
        void success(T t);
    }

    void startDiFaceRecognition(String str, String str2, Result<Map<String, Object>> result);
}
