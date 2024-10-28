package com.barosanu.view;

public enum FontSize {
    SMALL, MEDIUM, LARGE;
    public static String getCssPath(FontSize size) {
        return switch(size){
            case SMALL -> "/view/css/fontSmall.css";
            case MEDIUM -> "/view/css/fontMedium.css";
            case LARGE -> "/view/css/fontBig.css";
            default -> null;
        };
    }

}
