package controllers;

import Dao.Cadastro_empresaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Cadastro_empresa;
import view.ViewFactory;

public class TelaCadastroEmpresaController extends BaseController{

    
    public TelaCadastroEmpresaController(ViewFactory viewFactory, String fxmlName){
        super(viewFactory, fxmlName);
    }    


   @FXML
    private TextField NomeEmpresa;

    @FXML
    private TextField Projeto;

    @FXML
    private TextField Responsavel;
    
    @FXML
    private Label invalidDetails;

    @FXML
    void Voltar(ActionEvent event) {
        viewFactory.TelaInicialSuporte();
        Stage stage = (Stage)Projeto.getScene().getWindow();
        viewFactory.closeStage(stage);
    }
    
    // Strings which hold css elements to easily re-use in the application
    protected
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: GREEN; -fx-border-width: 2; -fx-border-radius: 5;");
    
    @FXML
    protected void CE (ActionEvent event) throws InterruptedException {
        // In case the Username and Password fields are left blank then display the error message
        if (NomeEmpresa.getText().isEmpty() && Projeto.getText().isEmpty() && Responsavel.getText().isEmpty()) {
          invalidDetails.setStyle(errorMessage);

        // quando tudo esta em branco
        if (NomeEmpresa.getText().isEmpty() && Projeto.getText().isEmpty() && Responsavel.getText().isEmpty()) {
            invalidDetails.setText("Os campos são obrigatórios");
            NomeEmpresa.setStyle(errorStyle);
            Projeto.setStyle(errorStyle);
            Responsavel.setStyle(errorStyle);


        } else // quando nome da empresa e projeto estao em branco
        if (NomeEmpresa.getText().isEmpty() && Projeto.getText().isEmpty()) {
            NomeEmpresa.setStyle(errorStyle);
            Projeto.setStyle(errorStyle);
            invalidDetails.setText("Os campos são obrigatórios");
            Responsavel.setStyle(successStyle);


        } else // quando projeto e responsavel estao em branco
            if (Projeto.getText().isEmpty() && Responsavel.getText().isEmpty()) {
                Projeto.setStyle(errorStyle);
                Responsavel.setStyle(errorStyle);
                invalidDetails.setText("Os campos são obrigatórios");
                NomeEmpresa.setStyle(successStyle);


            }
        } else // quando nome da empresa e responsavel estao em branco
            if (NomeEmpresa.getText().isEmpty() && Responsavel.getText().isEmpty()) {
                NomeEmpresa.setStyle(errorStyle);
                Responsavel.setStyle(errorStyle);
                invalidDetails.setText("Os campos são obrigatórios");
                Projeto.setStyle(successStyle);


        } else // quando nome da empresa esta em branco
            if (NomeEmpresa.getText().isEmpty()) {
                NomeEmpresa.setStyle(errorStyle);
                invalidDetails.setText("O campo é obrigatório");
                Projeto.setStyle(successStyle); 
                Responsavel.setStyle(successStyle);
                
        } else // quando projeto esta em branco
            if (Projeto.getText().isEmpty()) {
                Projeto.setStyle(errorStyle);
                invalidDetails.setText("O campo é obrigatório");
                NomeEmpresa.setStyle(successStyle); 
                Responsavel.setStyle(successStyle);
                
        } else // quando responsavel esta em branco
            if (Responsavel.getText().isEmpty()) {
                Responsavel.setStyle(errorStyle);
                invalidDetails.setText("O campo é obrigatório");
                NomeEmpresa.setStyle(successStyle); 
                Projeto.setStyle(successStyle);

          }
        // If all login details are entered as required then display success message
        else {
            invalidDetails.setText("Tudo certo!");
            String nome_empresa, responsavel, nome_projeto;

                        nome_empresa = NomeEmpresa.getText();
                        nome_projeto = Projeto.getText();
                        responsavel = Responsavel.getText();
                        

                        Cadastro_empresa objcadastro_empresa = new Cadastro_empresa();
                        objcadastro_empresa.setNome_empresa(nome_empresa);
                        objcadastro_empresa.setResponsavel(responsavel);
                        objcadastro_empresa.setNome_projeto(nome_projeto);


                        Cadastro_empresaDAO objcadastro_empresadao = new Cadastro_empresaDAO();
                        objcadastro_empresadao.cadastrar_empresa(objcadastro_empresa);


        }
    
    }
    
}


