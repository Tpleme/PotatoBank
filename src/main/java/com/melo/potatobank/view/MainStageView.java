package com.melo.potatobank.view;

import com.melo.potatobank.WeatherService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("MainStage.fxml")
public class MainStageView implements View {

    @FXML
    private Label weatherLabel;
    private WeatherService weatherService;

    @Autowired
    public MainStageView(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public void loadWeatherForecast(ActionEvent actionEvent) {
        this.weatherLabel.setText(weatherService.getWeatherForecast());
    }
}
