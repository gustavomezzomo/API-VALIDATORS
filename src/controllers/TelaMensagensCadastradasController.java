/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.ViewFactory;

public class TelaMensagensCadastradasController extends BaseController{
   
    public TelaMensagensCadastradasController(ViewFactory viewFactory, String fxmlName){
        super(viewFactory, fxmlName);
    }
    
    
    @FXML
    private TableColumn<?, ?> colunaData;

    @FXML
    private TableColumn<?, ?> colunaMeio;

    @FXML
    private TableColumn<?, ?> colunaMensagem;

    @FXML
    private TableColumn<?, ?> colunaNome;

    @FXML
    private TableColumn<?, ?> colunaTipo;

    @FXML
    private VBox mensagensCadastradas;

    @FXML
    void Voltar(ActionEvent event) {
        viewFactory.TelaInicialSuporte();
        Stage stage = (Stage)mensagensCadastradas.getScene().getWindow();
        viewFactory.closeStage(stage);
    }
}
    








