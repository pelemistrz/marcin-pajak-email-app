package com.barosanu.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginWindowController {
    @FXML
    private TextField emailAddressField;

    @FXML
    private Label errrorLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    void loginButtonAction(ActionEvent event) {
        System.out.println("clicked");
    }
}
