package Controller;

import com.mycompany.jpa.MysqlCon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import Model.Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import com.mycompany.jpa.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookJar_Belso_Ablak_OlvasoiController implements Initializable {

    MysqlCon dbCon;

    @FXML
    private Label BookJar_Main_Label;

    @FXML
    private TextField Writer_TextField;

    @FXML
    private TextField Title_TextField;

    @FXML
    private TextField ISBN_TextField;

    @FXML
    private TableView<Books> TableView;

    @FXML
    private TableColumn<Books, String> author;

    @FXML
    private TableColumn<Books, String> title;

    @FXML
    private TableColumn<Books, String> isbn;

    @FXML
    private TableColumn<Books, Integer> bookID;
    
    public int usedTextFields;

    ObservableList<Books> data
            = FXCollections.observableArrayList();

    @FXML
    void SearchButton_Pressed(ActionEvent event) throws SQLException {
        queryBooks();
    }

    @FXML
    void Exit_Pushed(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dbCon = MysqlCon.getInstance();

        Model model = new Model();

        StringBuilder sb = new StringBuilder();
        sb.append("Szia, ").append(model.passLoginUserName).append("! Válassz az alábbi menüpontok közül!");
        BookJar_Main_Label.setText(sb.toString());  
    }
    
    public void queryBooks() throws SQLException{
        ResultSet rs = null;
        data.clear();
        
        usedTextFields = 0;
        
        TableView.setEditable(true);

        usedTextFields += (!Writer_TextField.getText().equals("") ? 1 : 0);
        usedTextFields += (!Title_TextField.getText().equals("") ? 2 : 0);
        usedTextFields += (!ISBN_TextField.getText().equals("") ? 4 : 0);

        switch (usedTextFields) {
            case 1:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Author LIKE " 
                        + "'" + "%" + Writer_TextField.getText() + "%" +"';");
                break;
            case 2:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Title LIKE " 
                        + "'" + "%" + Title_TextField.getText() + "%" + "';");
                break;
            case 3:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Author LIKE " 
                        + "'" + "%" + Writer_TextField.getText() + "%" + "' AND Title LIKE" 
                                + "'" + "%" + Title_TextField.getText() + "%" +"';");
                break;
            case 4:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE ISBN LIKE " 
                        + "'" + "%" + ISBN_TextField.getText() + "%" +"';");
                break;
            case 5:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Author LIKE " 
                        + "'" + "%" + Writer_TextField.getText() + "%" + "' AND ISBN LIKE" 
                                + "'" + "%" + ISBN_TextField.getText() + "%" +"';");
                break;
            case 6:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Title LIKE " 
                        + "'" + "%" + Title_TextField.getText() + "%" + "' AND ISBN LIKE" 
                                + "'" + "%" + ISBN_TextField.getText() + "%" +"';");
                break;
            case 7:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Author LIKE " 
                        + "'" + "%" + Writer_TextField.getText() + "%" + "' AND Title LIKE" 
                                + "'" + "%" + Title_TextField.getText() + "%" + "' AND ISBN LIKE"
                                        + "'" + "%" + ISBN_TextField.getText() + "%" + "';");
                break;
            default:
                rs = dbCon.executeQuery("SELECT * FROM books;");
                break;
        }

        
        while (rs.next()) {
            Books book = new Books();
            book.setAuthor(rs.getString("Author"));
            book.setTitle(rs.getString("Title"));
            book.setIsbn(rs.getString("ISBN"));
            book.setBookID(rs.getInt("bookID"));

            data.add(book);
        }
        
        author.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));
        title.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
        isbn.setCellValueFactory(new PropertyValueFactory<Books, String>("isbn"));
        bookID.setCellValueFactory(new PropertyValueFactory<Books, Integer>("BookID"));

        TableView.setItems(data);
    }

}
