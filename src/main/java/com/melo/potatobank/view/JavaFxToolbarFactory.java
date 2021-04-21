package com.melo.potatobank.view;

import com.melo.potatobank.model.account.Account;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.ToolBar;

public class JavaFxToolbarFactory {

    private final double padding = 2;
    private double defaultPositionX;
    private double defaultPositionY;
    private NodeOrientation defaultNodeOrientation;
    private double defaultPrefHeight;
    private double defaultPrefWeight;

    public JavaFxToolbarFactory() {
        defaultPositionX = 23.0;
        defaultPositionY = 0;
        defaultNodeOrientation = NodeOrientation.RIGHT_TO_LEFT;
        defaultPrefHeight = 42.0;
        defaultPrefWeight = 639.0;

    }

    public ToolBar buildToolBar(Account account) {

        defaultPositionY += 23.0 + padding;

        ToolBar toolBar = new ToolBar();

        toolBar.setLayoutX(defaultPositionX);
        toolBar.setLayoutY(defaultPositionY);
        toolBar.setNodeOrientation(defaultNodeOrientation);
        toolBar.setPrefHeight(defaultPrefHeight);
        toolBar.setPrefWidth(defaultPrefWeight);

        return toolBar;
    }

/*    private ToolBar fillToolBar(ToolBar toolBar, Account account) {

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
    }*/
}
