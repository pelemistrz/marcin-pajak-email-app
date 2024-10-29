package com.barosanu.controller;

import com.barosanu.EmailManager;
import com.barosanu.model.EmailAccount;
import com.barosanu.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.HTMLEditor;

public class ComposeMessageController extends BaseController {
    @FXML
    private ChoiceBox<EmailAccount> emailAccountChoice;
    @FXML
    private Label errorLabel;
    @FXML
    private HTMLEditor htmlEditor;
    @FXML
    private TextField recipientTextField;
    @FXML
    private TextField subjectTextField;

    public ComposeMessageController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }
    @FXML
    void sendButtonAction() {
        System.out.println("print send");
    }


}
