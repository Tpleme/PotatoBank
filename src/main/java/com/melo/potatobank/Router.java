package com.melo.potatobank;

import com.melo.potatobank.view.View;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.rgielen.fxweaver.core.FxWeaver;


public class Router {

    private static Stage stage;
    private static Scene scene;
    private static FxWeaver fxWeaver;


    public Router(Stage stage, Class<? extends View> view, FxWeaver fxWeaver) {

        Router.fxWeaver = fxWeaver;
        Router.stage = stage;

        scene = new Scene(loadFXMLView(view));
        reRoute(view);
        init();

    }

    private void init() {

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    private static void reRoute(Class<? extends View> view) {

        scene.setRoot(loadFXMLView(view));
        stage.sizeToScene();
    }

    private static Parent loadFXMLView(Class<? extends View> view){

        return fxWeaver.loadView(view);
    }
}
