package com.facebook.gamingservices.model;

import android.os.Parcel;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;

public final class ContextSwitchContent implements ShareModel {
    private final String contextID;

    public int describeContents() {
        return 0;
    }

    private ContextSwitchContent(Builder builder) {
        this.contextID = builder.contextID;
    }

    ContextSwitchContent(Parcel parcel) {
        this.contextID = parcel.readString();
    }

    public String getContextID() {
        return this.contextID;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.contextID);
    }

    public static class Builder implements ShareModelBuilder<ContextSwitchContent, Builder> {
        /* access modifiers changed from: private */
        public String contextID;

        public Builder setContextID(String str) {
            this.contextID = str;
            return this;
        }

        public ContextSwitchContent build() {
            return new ContextSwitchContent(this);
        }

        public Builder readFrom(ContextSwitchContent contextSwitchContent) {
            return contextSwitchContent == null ? this : setContextID(contextSwitchContent.getContextID());
        }

        /* access modifiers changed from: package-private */
        public Builder readFrom(Parcel parcel) {
            return readFrom((ContextSwitchContent) parcel.readParcelable(ContextSwitchContent.class.getClassLoader()));
        }
    }
}
