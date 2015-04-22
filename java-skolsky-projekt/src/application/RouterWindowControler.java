package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class RouterWindowControler {

	@FXML
	private Button	RefreshButton;

	@FXML
	void Button_click_refresh(ActionEvent event) throws IOException {
		System.out.println("skuska");
	}

}
