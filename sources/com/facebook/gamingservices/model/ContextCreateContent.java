package com.facebook.gamingservices.model;

import android.os.Parcel;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;

public class ContextCreateContent implements ShareModel {
    private final String suggestedPlayerID;

    public int describeContents() {
        return 0;
    }

    private ContextCreateContent(Builder builder) {
        this.suggestedPlayerID = builder.suggestedPlayerID;
    }

    ContextCreateContent(Parcel parcel) {
        this.suggestedPlayerID = parcel.readString();
    }

    public String getSuggestedPlayerID() {
        return this.suggestedPlayerID;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.suggestedPlayerID);
    }

    public static class Builder implements ShareModelBuilder<ContextCreateContent, Builder> {
        /* access modifiers changed from: private */
        public String suggestedPlayerID;

        public Builder setSuggestedPlayerID(String str) {
            this.suggestedPlayerID = str;
            return this;
        }

        public ContextCreateContent build() {
            return new ContextCreateContent(this);
        }

        public Builder readFrom(ContextCreateContent contextCreateContent) {
            return contextCreateContent == null ? this : setSuggestedPlayerID(contextCreateContent.getSuggestedPlayerID());
        }

        /* access modifiers changed from: package-private */
        public Builder readFrom(Parcel parcel) {
            return readFrom((ContextCreateContent) parcel.readParcelable(ContextCreateContent.class.getClassLoader()));
        }
    }
}
