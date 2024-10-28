package com.barosanu.view;

public enum ColorTheme {
    LIGHT,DEFAULT,DARK;

    public static String getCssPath(ColorTheme theme){
        return switch (theme){
            case LIGHT -> "/view/css/themeLight.css";
            case DARK -> "/view/css/themeDark.css";
            case DEFAULT -> "/view/css/themeDefault.css";
            default -> null;

        };
    }
}
