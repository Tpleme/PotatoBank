package com.melo.potatobank.view;

import com.melo.potatobank.Router;
import com.melo.potatobank.StatusCode;
import com.melo.potatobank.service.LogInService;
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

    private LogInService logInService;

    @Autowired
    public LogInView(LogInService logInService) {
        this.logInService = logInService;
    }

    @FXML
    private void onClickCancelButton() {
        Router.closeStage();
    }

    @FXML
    private void onClickLoginButton() {

        StatusCode statusCode = logInService.loginUser(userNameField.getText(), passwordField.getText());

        switch (statusCode) {
            case ALL_OK: //TODO: Enter main application
                System.out.println("Login success");
                break;
            case WRONG_CREDENTIAL:
                warningLabel.setText(StatusCode.WRONG_CREDENTIAL.getMessage());
                break;
            case FIELDS_NOT_FILLED:
                warningLabel.setText(StatusCode.FIELDS_NOT_FILLED.getMessage());
                break;
            case COULD_NOT_CONNECT_TO_SERVER:
                warningLabel.setText(StatusCode.COULD_NOT_CONNECT_TO_SERVER.getMessage());
                break;
            case COULD_NOT_COMMUNICATE_WITH_DB:
                warningLabel.setText(StatusCode.COULD_NOT_COMMUNICATE_WITH_DB.getMessage());
                break;
        }

    }

    @FXML
    private void onClickRegisterButton() {
        Router.reRoute(RegistrationView.class);
    }
}
