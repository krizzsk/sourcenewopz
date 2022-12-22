package com.didi.unifylogin.base.net.pojo.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AuthResponse extends BaseLoginSuccessResponse {
    public String credential;
    public AuthInfo data;

    public static class AuthInfo implements Serializable {
        private String cell;
        private String email;
        @SerializedName("first_name")
        private String firstName;
        @SerializedName("last_name")
        private String lastName;

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getEmail() {
            return this.email;
        }

        public String getCell() {
            return this.cell;
        }

        public AuthInfo setFirstName(String str) {
            this.firstName = str;
            return this;
        }

        public AuthInfo setLastName(String str) {
            this.lastName = str;
            return this;
        }

        public AuthInfo setEmail(String str) {
            this.email = str;
            return this;
        }

        public AuthInfo setCell(String str) {
            this.cell = str;
            return this;
        }
    }
}
