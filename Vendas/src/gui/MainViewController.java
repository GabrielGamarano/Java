package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.service.EstoqueService;
import model.service.NovoEstoqueService;



public class MainViewController implements Initializable{
	
	
	@FXML
	private MenuItem novoProduto;
	
	@FXML
	private MenuItem compraEstoque;
	
	@FXML
	private MenuItem listaEstoque;
	
	@FXML
	private MenuItem novaVenda;
	
	@FXML
	private MenuItem listaVenda;
	
	@FXML
	private MenuItem sobre;
	
	@FXML
	public void onMenuItemNovoProdutoAction(ActionEvent event) {
		loadView("/gui/EstoqueForm.fxml", (EstoqueFormController controller) -> {
			controller.setEstoqueService(new EstoqueService());
		});
	}
	
	@FXML
	public void onMenuItemCompraEstoque() {
		System.out.println("Adicionar Estoque");
	}
	@FXML
	public void onMenuItemListaEstoque(ActionEvent event) {
		loadView("/gui/EstoqueList.fxml", (EstoqueListController controller) ->{
			controller.setNovoEstoqueService(new NovoEstoqueService());
		});
	}
	@FXML
	public void onMenuItemNovaVenda() {
		
	}
	@FXML
	public void onMenuItemListaVenda() {
		
	}
	@FXML
	public void onMenuItemSobre() {
		
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
	}
	
	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));
			VBox newvbox = loader.load();
			
			Scene mainScene = Main.getMainScene();
			VBox mainVBox = (VBox) ((ScrollPane) mainScene.getRoot()).getContent();
			
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newvbox.getChildren());
			
			T controller = loader.getController();
			initializingAction.accept(controller);
			
		}catch (IOException e) {
			// TODO: handle exception
		}
	}
	
	
	
	
	

}
