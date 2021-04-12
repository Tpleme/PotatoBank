package com.melo.potatobank.view;

import com.melo.potatobank.Router;
import com.melo.potatobank.exception.CustomException;
import com.melo.potatobank.exception.FieldNotFilledException;
import com.melo.potatobank.exception.PasswordDontMatchException;
import com.melo.potatobank.service.RegistrationService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("registration.fxml")
public class RegistrationView implements View {

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private Label warningLabel;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;

    private RegistrationService registrationService;

    @Autowired
    public RegistrationView(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @FXML
    private void onClickCancelButton() {
        Router.reRoute(LogInView.class);
    }

    @FXML
    private void onClickConfirmButton() {

        try {

            registrationService.registerNewUser(firstNameField.getText(), lastNameField.getText(), emailField.getText()
            ,phoneField.getText(), passwordField.getText(), confirmPasswordField.getText());

        }catch (CustomException e) {
            warningLabel.setText(e.getMessage());
        }
    }
}