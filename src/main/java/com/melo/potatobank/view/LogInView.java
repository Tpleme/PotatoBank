package com.melo.potatobank.view;

import com.melo.potatobank.Router;
import com.melo.potatobank.exception.CustomException;
import com.melo.potatobank.controller.LogInController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("login.fxml")
public class LogInView implements View {

    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label warningLabel;

    private LogInController logInController;

    @Autowired
    public LogInView(LogInController logInController) {
        this.logInController = logInController;
    }

    @FXML
    private void onClickCancelButton() {
        Router.closeStage();
    }

    @FXML
    private void onClickLoginButton() {

        try {
            logInController.loginUser(userNameField.getText(), passwordField.getText());

        } catch (CustomException exception) {
            warningLabel.setText(exception.getMessage());
        }
    }

    @FXML
    private void onClickRegisterButton() {
        Router.reRoute(RegistrationView.class);
    }
}
