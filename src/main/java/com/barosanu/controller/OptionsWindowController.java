package com.barosanu.controller;

import com.barosanu.EmailManager;
import com.barosanu.view.ColorTheme;
import com.barosanu.view.FontSize;
import com.barosanu.view.ViewFactory;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsWindowController extends BaseController implements Initializable {
    @FXML
    private ChoiceBox<ColorTheme> colorThemePicker;

    @FXML
    private Slider fontSizePicker;

    public OptionsWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUpThemePicker();
        setUpSizePicker();
    }

    private void setUpSizePicker() {
        fontSizePicker.setMin(0);
        fontSizePicker.setMax(FontSize.values().length-1);
        fontSizePicker.setValue(viewFactory.getFontSize().ordinal());
        fontSizePicker.setMajorTickUnit(1);
        fontSizePicker.setMinorTickCount(0);
        fontSizePicker.setBlockIncrement(1);
        fontSizePicker.setSnapToTicks(true);
        fontSizePicker.setShowTickMarks(true);
        fontSizePicker.setShowTickLabels(true);
        fontSizePicker.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double aDouble) {
                int i = aDouble.intValue();
                return FontSize.values()[i].toString();
            }

            @Override
            public Double fromString(String s) {
                return 0.0;
            }
        });
        fontSizePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            fontSizePicker.setValue(newValue.intValue());
        });
    }

    private void setUpThemePicker() {
        colorThemePicker.setItems(FXCollections.observableArrayList(ColorTheme.values()));
        colorThemePicker.setValue(viewFactory.getColorTheme());
    }

    @FXML
    void applyBtnAction() {
        viewFactory.setColorTheme(colorThemePicker.getValue());
        viewFactory.setFontSize(FontSize.values()[(int)(fontSizePicker.getValue())]);
        viewFactory.updateStyles();
    }

    @FXML
    void cancelBtnAction() {
        Stage stage = (Stage) fontSizePicker.getScene().getWindow();
        stage.close();
    }


}
