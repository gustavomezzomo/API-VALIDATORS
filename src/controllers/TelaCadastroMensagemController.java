/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;


import Dao.Cadastro_mensagemDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import modelo.Cadastro_mensagem;
import view.ViewFactory;

public class TelaCadastroMensagemController extends BaseController{

    public TelaCadastroMensagemController(ViewFactory viewFactory, String fxmlName){
        super(viewFactory, fxmlName);
    }  
    
    @FXML
    private TextField Categoria;

    @FXML
    private TextField MeioComu;

    @FXML
    private TextArea Mensagem;

    @FXML
    private TextField Titulo;

    @FXML
    void Voltar(ActionEvent event) {
        viewFactory.TelaInicialSuporte();
        Stage stage = (Stage)Titulo.getScene().getWindow();
        viewFactory.closeStage(stage);
    }
    
    @FXML
    void CM(ActionEvent event) {
        String titulo, categoria, meio_comunicacao, conteudo;
                    titulo = Titulo.getText();
                    categoria = Categoria.getText();
                    meio_comunicacao = MeioComu.getText();
                    conteudo = Mensagem.getText();

                    Cadastro_mensagem objcadastro_mensagem = new Cadastro_mensagem ();
                    objcadastro_mensagem.setTitulo(titulo);
                    objcadastro_mensagem.setCategoria(categoria);
                    objcadastro_mensagem.setMeio_comunicacao(meio_comunicacao);
                    objcadastro_mensagem.setConteudo(conteudo);

                    Cadastro_mensagemDAO objcadastro_mensagemdao = new Cadastro_mensagemDAO();
                    objcadastro_mensagemdao.cadastrar_mensagem(objcadastro_mensagem);

    }
                
	    

}
