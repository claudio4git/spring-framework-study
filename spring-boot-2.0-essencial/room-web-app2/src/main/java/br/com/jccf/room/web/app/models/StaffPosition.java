package br.com.jccf.room.web.app.models;

public enum StaffPosition {
    STAFF, ADM;

    public String toString() {
        switch (this) {
            case STAFF -> {
                return "Staff";
            }
            case ADM -> {
                return "Admin";
            }
            default -> {
                return "";
            }
        }
    }
}
