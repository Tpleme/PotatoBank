package com.melo.javafxwithspring.javafxwithspring.controller;

import com.melo.javafxwithspring.javafxwithspring.WeatherService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("MainStage.fxml")
public class MainStageController {

    @FXML
    private Label weatherLabel;
    private WeatherService weatherService;

    @Autowired
    public MainStageController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public void loadWeatherForecast(ActionEvent actionEvent) {
        this.weatherLabel.setText(weatherService.getWeatherForecast());
    }
}
