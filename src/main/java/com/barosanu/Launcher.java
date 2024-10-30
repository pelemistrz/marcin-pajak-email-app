package com.barosanu;

import com.barosanu.controller.persistance.PersistanceAccess;
import com.barosanu.controller.persistance.ValidAccount;
import com.barosanu.controller.services.LoginService;
import com.barosanu.model.EmailAccount;
import com.barosanu.view.ViewFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private PersistanceAccess persistanceAccess = new PersistanceAccess();
    private EmailManager emailManager = new EmailManager();

    @Override
    public void start(Stage stage) throws Exception {
        ViewFactory viewFactory = new ViewFactory(emailManager);
        List<ValidAccount> validAccountList = persistanceAccess.loadFromPersistence();
        if(!validAccountList.isEmpty()) {
            viewFactory.showMainWindow();
            for(ValidAccount validAccount : validAccountList) {
                EmailAccount emailAccount = new EmailAccount(validAccount.getAddress(),validAccount.getPassword());
                LoginService loginService = new LoginService(emailAccount,emailManager);
                loginService.start();
            }
        } else {
            viewFactory.showLoginWindow();

        }

    }



    @Override
    public void stop() throws Exception {
        List<ValidAccount> validAccountList = new ArrayList<>();
        for(EmailAccount emailAccount : emailManager.getEmailAccounts()){
            validAccountList.add(new ValidAccount(emailAccount.getAddress(),emailAccount.getPassword()));
        }
        persistanceAccess.saveToPersistence(validAccountList);
    }
}
