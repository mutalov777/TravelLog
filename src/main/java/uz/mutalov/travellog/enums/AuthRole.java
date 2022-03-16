package uz.mutalov.travellog.enums;

import lombok.Getter;

@Getter
public enum AuthRole {
    ADMIN("ADMIN"),
    USER("USER");

    private  String code;

    AuthRole(String code) {
        this.code = code;
    }
}
