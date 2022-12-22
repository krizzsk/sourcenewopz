package com.didi.component.messagebar.model;

import java.io.Serializable;

public class MessageBarParams implements Serializable {
    public MessageBarArgs args;
    public MessageBarConditions conditions;
    public String order_id;
    public int version;

    public String getOrder_id() {
        return this.order_id;
    }

    public void setOrder_id(String str) {
        this.order_id = str;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i) {
        this.version = i;
    }

    public MessageBarConditions getConditions() {
        return this.conditions;
    }

    public void setConditions(MessageBarConditions messageBarConditions) {
        this.conditions = messageBarConditions;
    }

    public MessageBarArgs getArgs() {
        return this.args;
    }

    public void setArgs(MessageBarArgs messageBarArgs) {
        this.args = messageBarArgs;
    }
}
