package gui;

import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import gui.listeners.DataChangeListener;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entidades.PedidoEstoque;
import model.service.NovoEstoqueService;

public class EstoqueListController  implements Initializable, DataChangeListener{
	

	
	private NovoEstoqueService nEstoqueservice;
	
	@FXML
	private TableView<PedidoEstoque> tableViewEstoque;
	@FXML
	private TableColumn<PedidoEstoque, Integer> tableCompraId;
	@FXML
	private TableColumn<PedidoEstoque, Integer> tableCompraQnt;
	@FXML
	private TableColumn<PedidoEstoque, Double> tableCompraPreco;
	@FXML
	private TableColumn<PedidoEstoque, Date> tableCompraData;
	@FXML
	private TableColumn<PedidoEstoque, Date> tableCompraExp;
	@FXML
	private Button btNovaCompra;
	@FXML
	private Button btProcurar;
	
	private ObservableList<PedidoEstoque> obsList;
	
	@Override
	public void onDataChanged() {
		updateTableView();
	}
	
	public void setNovoEstoqueService(NovoEstoqueService nEstoqueService) {
		this.nEstoqueservice = nEstoqueService;
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}
	
	public void initializeNodes() {
		tableCompraId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
		tableCompraQnt.setCellValueFactory(new PropertyValueFactory<>("orderQnt"));
		tableCompraPreco.setCellValueFactory(new PropertyValueFactory<>("orderPrice"));
		Utils.formatTableColumnDouble(tableCompraPreco, 2);
		tableCompraData.setCellValueFactory(new PropertyValueFactory<>(""));
		Utils.formatTableColumnDate(tableCompraData, "dd/MM/yyyy");
		tableCompraExp.setCellValueFactory(new PropertyValueFactory<>(""));
		Utils.formatTableColumnDate(tableCompraExp, "dd/MM/yyyy");
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewEstoque.prefHeightProperty().bind(stage.heightProperty());
	}
	
	public void updateTableView() {
		List<PedidoEstoque> list = nEstoqueservice.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewEstoque.setItems(obsList);
	}

}
