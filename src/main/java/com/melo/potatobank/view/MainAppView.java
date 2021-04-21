package com.melo.potatobank.view;

import com.melo.potatobank.Router;
import com.melo.potatobank.controller.MainAppController;
import com.melo.potatobank.model.Customer;
import com.melo.potatobank.model.account.Account;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Pane;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@FxmlView("mainApplication.fxml")
public class MainAppView implements View{

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

   // @FXML
    //private Label accountTypeLabel;
   // @FXML
    //private Label accountIdLabel;
   // @FXML
    //private Label amountLabel;

    @FXML
    private Customer activeCustomer;

    private MainAppController controller;

    @Autowired
    public void setController(MainAppController controller) {
        this.controller = controller;
    }

    @FXML
    private void initialize() {
        activeCustomer = MainAppController.getActiveCustomer();

        customerInfoPane.setVisible(false);
        accountPane.setVisible(false);

        customerName.setText(activeCustomer.getFirstName() + " " + activeCustomer.getLastName());

        nameField.setText(activeCustomer.getFirstName() + " " + activeCustomer.getLastName());
        emailField.setText(activeCustomer.getEmail());
        phoneField.setText(activeCustomer.getPhone());

        nAccountsField.setText(String.valueOf(activeCustomer.getAccounts().size()));
        totalField.setText(String.valueOf(controller.getCustomerTotalBalance(activeCustomer.getEmail())));
    }

    public void onClickCustomerInfoButton(ActionEvent event) {
        customerInfoPane.setVisible(true);
        accountPane.setVisible(false);
    }

    public void onClickAccountsButton(ActionEvent event) {
        customerInfoPane.setVisible(false);

        JavaFxToolbarFactory toolbarFactory = new JavaFxToolbarFactory();

        for (Account account : activeCustomer.getAccounts()) {
            accountPane.getChildren().add(toolbarFactory.buildToolBar(account));
        }


        accountPane.setVisible(true);


        //accountIdLabel.setText(String.valueOf(activeCustomer.getAccounts().get(0).getId()));
        //accountTypeLabel.setText(String.valueOf(activeCustomer.getAccounts().get(0).getAccountType()));
        //amountLabel.setText(activeCustomer.getAccounts().get(0).getBalance() + " €");
    }

    public void onClickFavoritesButton(ActionEvent event) {
        customerInfoPane.setVisible(false);
        accountPane.setVisible(false);
    }

    public void onClickExitButton(ActionEvent event) {
        MainAppController.setActiveCustomer(null);
        Router.reRoute(LogInView.class);
    }

    public void onActionViewAccount(ActionEvent event) {
    }

    public void onActionDeposit(ActionEvent event) {
    }

    public void onActionWithdraw(ActionEvent event) {
    }
}
