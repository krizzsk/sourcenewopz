package com.didichuxing.diface.appeal.brazil;

import com.didichuxing.diface.data.BaseResult;
import java.io.Serializable;

public class SubmitResult extends BaseResult {
    public static final int CODE_REPEATED_SUBMIT = 100004;
    public Data data;

    public static class Data implements Serializable {
        public int code;
        public String message;
    }
}
