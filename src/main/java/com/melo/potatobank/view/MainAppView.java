package com.melo.potatobank.view;

import com.melo.potatobank.Router;
import com.melo.potatobank.controller.MainAppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@FxmlView("mainApp.fxml")
public class MainAppView implements View{

    @FXML
    private Label customerName;

    private MainAppController controller;

    @Autowired
    public void setController(MainAppController controller) {
        this.controller = controller;
    }

    @FXML
    private void initialize() {
        customerName.setText(MainAppController.getActiveCustomer().getFirstName() +
                " " + MainAppController.getActiveCustomer().getLastName());
    }

    public void onClickCustomerInfoButton(ActionEvent event) {

    }

    public void onClickAccountsButton(ActionEvent event) {
    }

    public void onClickFavoritesButton(ActionEvent event) {
    }

    public void onClickExitButton(ActionEvent event) {
        MainAppController.setActiveCustomer(null);
        Router.reRoute(LogInView.class);
    }
}
