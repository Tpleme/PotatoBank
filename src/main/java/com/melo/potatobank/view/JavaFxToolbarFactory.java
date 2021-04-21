package com.melo.potatobank.view;

import com.melo.potatobank.model.account.Account;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;

public class JavaFxToolbarFactory {

    private final double padding = 5.0;
    private final double defaultPositionX;
    private double defaultPositionY;
    private final NodeOrientation defaultNodeOrientation;
    private final double defaultPrefHeight;
    private final double defaultPrefWeight;

    public JavaFxToolbarFactory() {
        defaultPositionX = 23.0;
        defaultPositionY = 20.0;
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
        Label amountLabel = new Label(String.valueOf(account.getBalance()));
        Label accountTypeLabel = new Label(String.valueOf(account.getAccountType()));
        Label accountIdLabel = new Label(String.valueOf(account.getId()));

        toolBar.getItems().add(viewButton);
        toolBar.getItems().add(depositButton);
        toolBar.getItems().add(withdrawButton);
        toolBar.getItems().add(separator);
        toolBar.getItems().add(amountLabel);
        toolBar.getItems().add(separator);
        toolBar.getItems().add(accountTypeLabel);
        toolBar.getItems().add(separator);
        toolBar.getItems().add(accountIdLabel);

        return toolBar;
    }
}
