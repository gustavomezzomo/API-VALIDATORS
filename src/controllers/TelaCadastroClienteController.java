package controllers;

 
import Dao.CadastroClienteDAO;
import Dao.Cadastro_empresaDAO;
import Dao.Cadastro_mensagemDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import modelo.CadastroCliente;
import modelo.Cadastro_empresa;
import modelo.Cadastro_mensagem;
import view.ViewFactory;


public class TelaCadastroClienteController extends BaseController{
    
    public TelaCadastroClienteController(ViewFactory viewFactory, String fxmlName){
        super(viewFactory, fxmlName);
    }  
	   
    @FXML
    private TextField Cargo;

    @FXML
    private TextField Email;

    @FXML
    private TextField Empresa;

    @FXML
    private TextField Nome;

    @FXML
    private TextField Projeto;

    @FXML
    private TextField Telefone;

    @FXML
    private Label invalidDetailsCliente;

    @FXML
    private VBox cadastroCliente;

    @FXML
    void Voltar(ActionEvent event) {
        viewFactory.TelaInicialSuporte();
        Stage stage = (Stage)Telefone.getScene().getWindow();
        viewFactory.closeStage(stage);
    }


    protected
    String successMessage = String.format("-fx-text-fill: GREEN;");
    String errorMessage = String.format("-fx-text-fill: RED;");
    String errorStyle = String.format("-fx-border-color: RED; -fx-border-width: 2; -fx-border-radius: 5;");
    String successStyle = String.format("-fx-border-color: GREEN; -fx-border-width: 2; -fx-border-radius: 5;");
    
    @FXML
    protected void CC (ActionEvent event) throws InterruptedException {

        if (Cargo.getText().isEmpty() || Email.getText().isEmpty() || Empresa.getText().isEmpty() || Nome.getText().isEmpty() || Projeto.getText().isEmpty() || Telefone.getText().isEmpty()) {
            invalidDetailsCliente.setStyle(errorMessage);
            invalidDetailsCliente.setText("Todos os campos são obrigatórios");
  

        if (Cargo.getText().isEmpty()) {
            Cargo.setStyle(errorStyle);


        } 

        if (Email.getText().isEmpty()) {
            Email.setStyle(errorStyle);


        } 

        if (Empresa.getText().isEmpty()) {
            Empresa.setStyle(errorStyle);


        } 

        if (Nome.getText().isEmpty()) {
          Nome.setStyle(errorStyle);


        }
        
        if (Projeto.getText().isEmpty()) {
          Projeto.setStyle(errorStyle);


        } 

        if (Telefone.getText().isEmpty()) {
          Telefone.setStyle(errorStyle);


        } 

        else {
          invalidDetailsCliente.setText("Tudo certo!");
          invalidDetailsCliente.setStyle(successMessage);
          String cargo, nome, email, nome_empresa, projetos, telefone;
                  
                  cargo = Cargo.getText();
                  nome = Nome.getText();
                  email = Email.getText();
                  nome_empresa = Empresa.getText();
                  projetos = Projeto.getText();
                  telefone = Telefone.getText();

                  CadastroCliente objcadastro = new CadastroCliente();
                  objcadastro.setCargo(cargo);
                  objcadastro.setNome(nome);
                  objcadastro.setEmail(email);
                  objcadastro.setNome_empresa(nome_empresa);
                  objcadastro.setProjetos(projetos);
                  objcadastro.setTelefone(telefone);

                  CadastroClienteDAO objcadastrodao = new CadastroClienteDAO();
                  objcadastrodao.cadastrar(objcadastro);

    }
                    
	    
	   

            
} 
	    
	    	
	    
	   
	    

	   

	   // @FXML
	    //void test(ActionEvent event) {
	    	//grid1.setVisible(false);
	    	//grid1.managedProperty().bind(grid1.visibleProperty());
	    	
	    	//grid2.setVisible(true);
	    	//grid2.managedProperty().bind(grid2.visibleProperty());
	    
	    	//grid1.managedProperty().bind(grid1.visibleProperty());

	    


	 


