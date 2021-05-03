package com.melo.potatobank.view;

import com.melo.potatobank.model.account.Account;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JavaFxToolbarFactory {

    private final double padding = 5.0;
    private final double defaultPositionX;
    private double defaultPositionY;
    private final NodeOrientation defaultNodeOrientation;
    private final double defaultPrefHeight;
    private final double defaultPrefWeight;

    private MainAppView mainAppView;

    @Autowired
    public void setMainAppView(MainAppView mainAppView) {
        this.mainAppView = mainAppView;
    }

    public JavaFxToolbarFactory() {
        defaultPositionX = 23.0;
        defaultPositionY = 10.0;
        defaultNodeOrientation = NodeOrientation.RIGHT_TO_LEFT;
        defaultPrefHeight = 42.0;
        defaultPrefWeight = 639.0;

    }

    public ToolBar buildToolBar(Account account) {

        ToolBar toolBar = new ToolBar();

        toolBar.setLayoutX(defaultPositionX);
        toolBar.setLayoutY(defaultPositionY);
        toolBar.setNodeOrientation(defaultNodeOrientation);
        toolBar.setPrefHeight(defaultPrefHeight);
        toolBar.setPrefWidth(defaultPrefWeight);

        System.out.println(defaultPositionY);

        defaultPositionY += defaultPrefHeight + padding;

        return fillToolBar(toolBar, account);
    }

    private ToolBar fillToolBar(ToolBar toolBar, Account account) {

        Button viewButton = new Button("View");
        Button depositButton = new Button("Deposit");
        Button withdrawButton = new Button("Withdraw");
        Separator separator = new Separator(Orientation.VERTICAL);
        Separator separator1 = new Separator(Orientation.VERTICAL);
        Separator separator2 = new Separator(Orientation.VERTICAL);
        Label amountLabel = new Label(account.getBalance() + " €");
        Label accountTypeLabel = new Label(account.getAccountType() + " ACCOUNT");
        Label accountIdLabel = new Label("ID: " + account.getId());

        amountLabel.setAlignment(Pos.CENTER);
        amountLabel.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        amountLabel.setPrefHeight(17.0);
        amountLabel.setPrefWidth(86.0);

        accountTypeLabel.setAlignment(Pos.CENTER);
        accountTypeLabel.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        accountTypeLabel.setPrefHeight(17.0);
        accountTypeLabel.setPrefWidth(272.0);

        accountIdLabel.setAlignment(Pos.CENTER);
        accountIdLabel.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        accountIdLabel.setPrefHeight(17.0);
        accountIdLabel.setPrefWidth(32.0);

        viewButton.setOnAction(event -> mainAppView.onClickViewButton(account));
        depositButton.setOnAction(event -> mainAppView.onClickDepositButton(account));
        withdrawButton.setOnAction(event -> mainAppView.onClickWithdrawButton(account));

        toolBar.getItems().add(viewButton);
        toolBar.getItems().add(depositButton);
        toolBar.getItems().add(withdrawButton);
        toolBar.getItems().add(separator);
        toolBar.getItems().add(amountLabel);
        toolBar.getItems().add(separator1);
        toolBar.getItems().add(accountTypeLabel);
        toolBar.getItems().add(separator2);
        toolBar.getItems().add(accountIdLabel);

        return toolBar;
    }

    public double getDefaultPrefHeight() {
        return defaultPrefHeight;
    }

    public double getPadding() {
        return padding;
    }
}
