package com.didi.unifylogin.base.net;

import com.google.gson.JsonSyntaxException;
import java.io.IOException;

public class LoginJsonException extends IOException {
    public LoginJsonException(JsonSyntaxException jsonSyntaxException) {
        super(jsonSyntaxException);
    }
}
