package com.melo.potatobank.view;

import com.melo.potatobank.Router;
import com.melo.potatobank.controller.MainAppController;
import com.melo.potatobank.exception.CannotCreditAccountException;
import com.melo.potatobank.model.Customer;
import com.melo.potatobank.model.account.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.StageStyle;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
@FxmlView("mainApplication.fxml")
public class MainAppView implements View {

    @FXML
    private Label customerName;

    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField nAccountsField;
    @FXML
    private TextField totalField;

    @FXML
    private Pane accountPane;
    @FXML
    private Pane customerInfoPane;
    @FXML
    private Pane favoritePane;
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Customer activeCustomer;

    private MainAppController controller;

    private JavaFxToolbarFactory toolbarFactory;

    @Autowired
    public void setToolbarFactory(JavaFxToolbarFactory toolbarFactory) {
        this.toolbarFactory = toolbarFactory;
    }

    @Autowired
    public void setController(MainAppController controller) {
        this.controller = controller;
    }

    @FXML
    private void initialize() {
        activeCustomer = MainAppController.getActiveCustomer();

        setUpAccountPane();
        setUpCustomerPane();
        setUpFavoritePane();

        customerInfoPane.setVisible(true);
        accountPane.setVisible(false);
        favoritePane.setVisible(false);
    }

    public void onClickCustomerInfoButton(ActionEvent event) {
        customerInfoPane.setVisible(true);
        accountPane.setVisible(false);
        favoritePane.setVisible(false);
    }

    public void onClickAccountsButton(ActionEvent event) {
        customerInfoPane.setVisible(false);
        accountPane.setVisible(true);
        favoritePane.setVisible(false);

    }

    public void onClickFavoritesButton(ActionEvent event) {
        customerInfoPane.setVisible(false);
        accountPane.setVisible(false);
        favoritePane.setVisible(true);
    }

    public void onClickExitButton(ActionEvent event) {
        MainAppController.setActiveCustomer(null);
        Router.reRoute(LogInView.class);
    }

    private void setUpAccountPane() {

        if (activeCustomer.getAccounts().size() <= 7) {
            accountPane.setPrefHeight(266.0);
        } else {
            accountPane.setPrefHeight(266.0 +
                    (toolbarFactory.getDefaultPrefHeight() + toolbarFactory.getPadding() * activeCustomer.getAccounts().size() - 7));
        }

        for (Account account : activeCustomer.getAccounts()) {
            anchorPane.getChildren().add(toolbarFactory.buildToolBar(account));
        }
    }

    private void setUpCustomerPane() {

        customerName.setText(activeCustomer.getFirstName() + " " + activeCustomer.getLastName());

        nameField.setText(activeCustomer.getFirstName() + " " + activeCustomer.getLastName());
        emailField.setText(activeCustomer.getEmail());
        phoneField.setText(activeCustomer.getPhone());

        nAccountsField.setText(String.valueOf(activeCustomer.getAccounts().size()));
        totalField.setText(String.valueOf(controller.getCustomerTotalBalance(activeCustomer)));
    }

    private void setUpFavoritePane() {

    }

    public void onClickViewButton(Account account) {

        System.out.println("Clicked on view button of account " + account.getId());

    }

    public void onClickDepositButton(Account account) {

        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Credit account");
        dialog.setHeaderText("Input the amount you want to deposit in the account with the number " + account.getId());
        dialog.setContentText("Input the amount: ");
        dialog.initStyle(StageStyle.UTILITY);

        Optional<Double> result = dialog.showAndWait().map(Double::new);

        result.ifPresent(amount -> {
            try {
                controller.creditAccount(account, amount);
                //TODO: refresh accountPane, care with calling "setupAccountPane", not the best solution
            } catch (CannotCreditAccountException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    public void onClickWithdrawButton(Account account) {

        System.out.println("Clicked on withdraw button of account " + account.getId());
    }
}
