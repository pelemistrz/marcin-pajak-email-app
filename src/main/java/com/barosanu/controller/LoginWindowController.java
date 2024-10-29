package com.barosanu.controller;

import com.barosanu.EmailManager;
import com.barosanu.controller.services.LoginService;
import com.barosanu.model.EmailAccount;
import com.barosanu.view.ViewFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController extends BaseController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        emailAddressField.setText("pelemistrz@op.pl");
        passwordField.setText("k*j-w7fCzHqKLsn");
    }

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @FXML
    private TextField emailAddressField;

    @FXML
    private Label errrorLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    void loginButtonAction() {

        if (fieldsAreValid()) {
            EmailAccount emailAccount = new EmailAccount(emailAddressField.getText(), passwordField.getText());
            LoginService loginService = new LoginService(emailAccount, emailManager);
            loginService.start();
            loginService.setOnSucceeded(event -> {
                        EmailLoginResult emailLoginResult = loginService.getValue();

                        switch (emailLoginResult) {
                            case SUCCESS:
                                if (!viewFactory.isMainViewInitialized()) {
                                    viewFactory.showMainWindow();
                                }
                                Stage stage = (Stage) errrorLabel.getScene().getWindow();
                                viewFactory.closeStage(stage);
                                return;
                            case FAILED_BY_CREDENTIALS:
                                errrorLabel.setText("Invalid credentials");
                                return;
                            case FAILED_BY_UNEXPECTED_ERROR:
                                errrorLabel.setText("Unexpected error");
                                return;
                        }
                    }

            );


        }
    }

    private boolean fieldsAreValid() {
        if (emailAddressField.getText().isEmpty()) {
            errrorLabel.setText("Please fill email");
            return false;
        }
        if (passwordField.getText().isEmpty()) {
            errrorLabel.setText("Please fill password");
            return false;
        }
        return true;
    }
}
