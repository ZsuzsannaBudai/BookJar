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
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class BookJar_Belso_Ablak_DolgozoiController implements Initializable {

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

    /*-------------------------------------------------------------*/
    @FXML
    private TableView<AdminWindow_Lending> TableView_Kolcsonzott;

    @FXML
    private TableColumn<AdminWindow_Lending, String> author_lend;

    @FXML
    private TableColumn<AdminWindow_Lending, String> title_lend;

    @FXML
    private TableColumn<AdminWindow_Lending, String> isbn_lend;

    @FXML
    private TableColumn<AdminWindow_Lending, String> lend_date;

    @FXML
    private TableColumn<AdminWindow_Lending, String> lend_date_end;

    @FXML
    private TableColumn<AdminWindow_Lending, String> lend_email;
    
    @FXML
    private TextField Hosszabbitas_TextField;
    
    @FXML
    private Label Hosszabbitas_Label;

    /*-------------------------------------------------------------*/
    @FXML
    private TableView<Regisztralt_Ember> Felhaszn_Lista_TableView;

    @FXML
    private Button Landing_Button;

    @FXML
    private Label ErrorMessage_Label;

    @FXML
    private TabPane TabPanel;

    @FXML
    private TableColumn<Regisztralt_Ember, String> nev;

    @FXML
    private TableColumn<Regisztralt_Ember, String> mail;

    @FXML
    private TableColumn<Regisztralt_Ember, String> regDate;

    @FXML
    private TableColumn<Regisztralt_Ember, String> kolcsSz;

    boolean errorInLending = false;

    boolean setVis = false;

    @FXML
    private Label successfullBooking;

    public void Kolcsonzes_Tab() throws SQLException {
        ObservableList<AdminWindow_Lending> data
                = sqlQuery2();

        author_lend.setCellValueFactory(new PropertyValueFactory<AdminWindow_Lending, String>("author_lending"));
        title_lend.setCellValueFactory(new PropertyValueFactory<AdminWindow_Lending, String>("title_lending"));
        isbn_lend.setCellValueFactory(new PropertyValueFactory<AdminWindow_Lending, String>("isbn"));
        lend_date.setCellValueFactory(new PropertyValueFactory<AdminWindow_Lending, String>("lend_date"));
        lend_date_end.setCellValueFactory(new PropertyValueFactory<AdminWindow_Lending, String>("lend_date_end"));
        lend_email.setCellValueFactory(new PropertyValueFactory<AdminWindow_Lending, String>("Email"));

        TableView_Kolcsonzott.setItems(data);
    }

    public void Felhasznalo_lista_tab() throws SQLException {
        ObservableList<Regisztralt_Ember> data = sqlQuery();

        nev.setCellValueFactory(new PropertyValueFactory<Regisztralt_Ember, String>("Name"));
        mail.setCellValueFactory(new PropertyValueFactory<Regisztralt_Ember, String>("Email"));
        regDate.setCellValueFactory(new PropertyValueFactory<Regisztralt_Ember, String>("Date"));
        kolcsSz.setCellValueFactory(new PropertyValueFactory<Regisztralt_Ember, String>("BookedNumbers"));

        Felhaszn_Lista_TableView.setItems(data);
    }

    @FXML
    void Pressed_a_new_Tab(MouseEvent event) throws SQLException {
        if (TabPanel.getSelectionModel().getSelectedItem().getText().equals("Kölcsönzések")) {
            Kolcsonzes_Tab();
        } else if (TabPanel.getSelectionModel().getSelectedItem().getText().equals("Felhasználó lista")) {
            Felhasznalo_lista_tab();
        }
    }

    @FXML
    void Landing_a_Book(ActionEvent event) throws SQLException {

        this.dbCon = MysqlCon.getInstance();

        errorInLending = false;

        Model model = new Model();
        int userID = model.passLoginUserID;

        Books book = TableView.getSelectionModel().getSelectedItem();

        ResultSet rs = null;
        rs = dbCon.executeQuery("SELECT * FROM lending l, books b WHERE l.bookID = b.bookID;");

        List<Lending> data = new ArrayList<Lending>();

        while (rs.next()) {
            Lending lending = new Lending();
            lending.setAuthor_lending(rs.getString("Author"));
            lending.setTitle_lending(rs.getString("Title"));
            lending.setLend_date(rs.getString("lend_date"));
            lending.setLend_date_end(rs.getString("lend_date_end"));

            data.add(lending);
        }

        if (book != null) {
            for (Lending l : data) {
                if (l.getAuthor_lending().equals(book.getAuthor()) && l.getTitle_lending().equals(book.getTitle())) {
                    errorInLending = true;
                    break;
                }
            }
        }

        if (book == null || errorInLending) {
            ErrorMessage_Label.setVisible(true);

            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException k) {
                    }
                    return null;
                }
            };

            new Thread(sleeper).start();
            sleeper.setOnSucceeded(b -> {
                ErrorMessage_Label.setVisible(false);
            });
        } else {
            Statement stmt = dbCon.mysqlconnection.createStatement();
            Statement stmt2 = dbCon.mysqlconnection.createStatement();

            LocalDate localdate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate = localdate.format(formatter);

            LocalDate localdate2 = LocalDate.now().plusDays(7);
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDate2 = localdate2.format(formatter2);

            successfullBooking.setVisible(true);

            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException k) {
                    }
                    return null;
                }
            };

            new Thread(sleeper).start();
            sleeper.setOnSucceeded(b -> {
                successfullBooking.setVisible(false);
            });

            stmt.executeUpdate("INSERT INTO lending(bookID, UserID, lend_date, lend_date_end) VALUE ('"
                    + book.getBookID() + "','" + Model.passLoginUserID + "','" + formattedDate + "','" + formattedDate2 + "');");
            stmt2.executeUpdate("UPDATE users SET BookedNumbers = BookedNumbers + 1 WHERE users.UserID = " + "'" + Model.passLoginUserID + "';");
        }

        Refresh();
    }

    @FXML
    void Select_An_Item(MouseEvent event) {
        TableView.setRowFactory(tv -> new TableRow<Books>() {
            @Override
            protected void updateItem(Books item, boolean empty) {
                super.updateItem(item, empty);

                if (item == null || item.getBookID() == null) {
                    setStyle("");
                } else if (item.equals(TableView.getSelectionModel().getSelectedItem())) {
                    setStyle("-fx-background-color: #FFD700;");
                } else if (!item.getLending()) {
                    setStyle("-fx-background-color: #00FF00;");
                } else if (item.getLending()) {
                    setStyle("-fx-background-color: #FF0000;");
                } else {
                    setStyle("");
                }
            }
        });
    }

    @FXML
    void SearchButton_Pressed(ActionEvent event) throws SQLException {
        Refresh();
        Title_TextField.setText("");
ISBN_TextField.setText("");
Writer_TextField.setText("");
    }

    public void Refresh() throws SQLException {
        ObservableList<Books> data
                = searchQuery(Writer_TextField.getText(), Title_TextField.getText(), ISBN_TextField.getText());

        if (setVis) {
            TableView.setVisible(true);
            Landing_Button.setVisible(true);
        }

        author.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));
        title.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
        isbn.setCellValueFactory(new PropertyValueFactory<Books, String>("isbn"));
        bookID.setCellValueFactory(new PropertyValueFactory<Books, Integer>("BookID"));

        TableView.setItems(data);

        TableView.setRowFactory(tv -> new TableRow<Books>() {
            @Override
            protected void updateItem(Books item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || item.getBookID() == null) {
                    setStyle("");
                } else if (item.equals(TableView.getSelectionModel().getSelectedItem())) {
                    setStyle("-fx-background-color: #FFD700;");
                } else if (!item.getLending()) {
                    setStyle("-fx-background-color: #00FF00;");
                } else if (item.getLending()) {
                    setStyle("-fx-background-color: #FF0000;");
                } else {
                    setStyle("");
                }
            }
        });
    }

    @FXML
    void Exit_Pushed(ActionEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.dbCon = MysqlCon.getInstance();
        ErrorMessage_Label.setVisible(false);
        TableView.setVisible(false);
        Landing_Button.setVisible(false);
        successfullBooking.setVisible(false);
        Hosszabbitas_Label.setVisible(false);

        Model model = new Model();

        StringBuilder sb = new StringBuilder();
        sb.append("Szia, ").append(model.passLoginUserName).append("! Válassz az alábbi menüpontok közül!");
        BookJar_Main_Label.setText(sb.toString());
    }

    public ObservableList<Books> searchQuery(String author, String title, String isbn) throws SQLException {
        setVis = true;
        this.dbCon = MysqlCon.getInstance();

        ResultSet rs = null;
        ObservableList<Books> data = FXCollections.observableArrayList();

        int usedTextFields = 0;

        usedTextFields += (!author.equals("") ? 1 : 0);
        usedTextFields += (!title.equals("") ? 2 : 0);
        usedTextFields += (!isbn.equals("") ? 4 : 0);

        switch (usedTextFields) {
            case 1:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Author LIKE "
                        + "'" + "%" + author + "%" + "';");
                break;
            case 2:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Title LIKE "
                        + "'" + "%" + title + "%" + "';");
                break;
            case 3:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Author LIKE "
                        + "'" + "%" + author + "%" + "' AND Title LIKE "
                        + "'" + "%" + title + "%" + "';");
                break;
            case 4:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE ISBN LIKE "
                        + "'" + "%" + isbn + "%" + "';");
                break;
            case 5:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Author LIKE "
                        + "'" + "%" + author + "%" + "' AND ISBN LIKE "
                        + "'" + "%" + isbn + "%" + "';");
                break;
            case 6:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Title LIKE "
                        + "'" + "%" + title + "%" + "' AND ISBN LIKE"
                        + "'" + "%" + isbn + "%" + "';");
                break;
            case 7:
                rs = dbCon.executeQuery("SELECT * FROM books WHERE Author LIKE "
                        + "'" + "%" + author + "%" + "' AND Title LIKE"
                        + "'" + "%" + title + "%" + "' AND ISBN LIKE"
                        + "'" + "%" + isbn + "%" + "';");
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

            ResultSet rs2 = dbCon.executeQuery("SELECT * FROM lending WHERE bookID = " + "'" + book.getBookID() + "';");
            if (rs2.next()) {
                book.setLending(true);
            } else {
                book.setLending(false);
            }

            data.add(book);
        }

        return data;
    }

    public ObservableList<Lending> lendingQuery() throws SQLException {
        this.dbCon = MysqlCon.getInstance();
        Model model = new Model();

        ObservableList<Lending> data = FXCollections.observableArrayList();
        ResultSet rs = null;
        rs = dbCon.executeQuery("SELECT * FROM lending l, books b WHERE l.bookID = b.bookID AND UserID = " + Model.passLoginUserID + ";");

        while (rs.next()) {
            Lending lending = new Lending();
            lending.setAuthor_lending(rs.getString("Author"));
            lending.setTitle_lending(rs.getString("Title"));
            lending.setLend_date(rs.getString("lend_date"));
            lending.setLend_date_end(rs.getString("lend_date_end"));

            data.add(lending);
        }

        return data;
    }

    public ObservableList<Regisztralt_Ember> sqlQuery() throws SQLException {
        this.dbCon = MysqlCon.getInstance();

        ObservableList<Regisztralt_Ember> data = FXCollections.observableArrayList();
        ResultSet rs = null;
        rs = dbCon.executeQuery("SELECT * FROM users;");

        while (rs.next()) {
            Regisztralt_Ember ember = new Regisztralt_Ember();
            ember.setName(rs.getString("Name"));
            ember.setEmail(rs.getString("Email"));
            ember.setDate(rs.getString("Date"));
            ember.setBookedNumbers(rs.getInt("BookedNumbers"));

            data.add(ember);
        }

        return data;
    }

    public ObservableList<AdminWindow_Lending> sqlQuery2() throws SQLException {
        this.dbCon = MysqlCon.getInstance();

        ObservableList<AdminWindow_Lending> data = FXCollections.observableArrayList();

        ResultSet rs = null;
        rs = dbCon.executeQuery("SELECT "
                + "b.Author, b.Title, b.ISBN, l.lend_date, l.lend_date_end, u.Email "
                + "FROM users u,  lending l, books b "
                + "WHERE u.UserID = l.UserID AND b.bookID = l.bookID;");

        while (rs.next()) {
            AdminWindow_Lending aw_l = new AdminWindow_Lending();
            aw_l.setAuthor_lending(rs.getString("Author"));
            aw_l.setTitle_lending(rs.getString("Title"));
            aw_l.setIsbn(rs.getString("ISBN"));
            aw_l.setLend_date(rs.getString("lend_date"));
            aw_l.setLend_date_end(rs.getString("lend_date_end"));
            aw_l.setEmail(rs.getString("Email"));

            data.add(aw_l);
        }

        return data;
    }

    @FXML
    void Lending_Delete(ActionEvent event) throws SQLException {
        AdminWindow_Lending aw_l = TableView_Kolcsonzott.getSelectionModel().getSelectedItem();

        ResultSet re_getBookID = dbCon.executeQuery("SELECT * FROM books WHERE "
                + "Author = " + "'" + aw_l.getAuthor_lending() + "'" + " "
                + "AND Title = " + "'" + aw_l.getTitle_lending() + "'" + ";");

        Integer bookID = null;

        while (re_getBookID.next()) {
            bookID = re_getBookID.getInt("bookID");
        }

        if (re_getBookID.next()) {
            bookID = Integer.parseInt(re_getBookID.toString());
        }

        ResultSet re_getUserID = dbCon.executeQuery("SELECT * FROM users WHERE "
                + "Email = " + "'" + aw_l.getEmail() + "'" + ";");

        Integer UserID = null;

        while (re_getUserID.next()) {
            UserID = re_getUserID.getInt("UserID");
        }

        if (re_getUserID.next()) {
            bookID = Integer.parseInt(re_getUserID.toString());
        }

        dbCon.executeUpdate_Delete("DELETE FROM lending WHERE UserID = " + UserID + " AND "
                + "bookID = " + bookID + ";");
        
        dbCon.executeUpdate("UPDATE users SET BookedNumbers = BookedNumbers - 1 WHERE users.UserID = " + "'" + UserID + "';");
        
        Kolcsonzes_Tab();
        Refresh();
    }

    @FXML
    void Extension(ActionEvent event) throws ParseException, SQLException {
        try{
        AdminWindow_Lending aw_l = TableView_Kolcsonzott.getSelectionModel().getSelectedItem();
        
        String lend_date_end_local = aw_l.getLend_date_end();
        Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse(lend_date_end_local);
        
            System.out.println(toDate.toString());
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate formattedDate = LocalDate.parse(lend_date_end_local, formatter);
        
            System.out.println(formattedDate.toString());
        
        LocalDate plusDay_Formatted = null;   

        plusDay_Formatted = formattedDate.plusDays(Integer.parseInt(Hosszabbitas_TextField.getText()));
        
        ResultSet rs = dbCon.executeQuery("SELECT bookID FROM books WHERE Author = " + "'" + aw_l.getAuthor_lending() + "' AND "
                + "" + " Title = " + "'" + aw_l.getTitle_lending() + "' AND " + "ISBN = " + "'" + aw_l.getIsbn() + "';");
        
        Integer bookID = null;
        
        while(rs.next())
            bookID = rs.getInt("bookID");
        
        dbCon.executeUpdate("UPDATE lending SET lend_date_end = " + "'" + plusDay_Formatted.toString() + "'" + " "
                + "WHERE bookID = " + bookID + ";");
        
        Kolcsonzes_Tab();
        }
        catch(Exception E){

            Hosszabbitas_Label.setVisible(true);

            Task<Void> sleeper = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException k) {
                    }
                    return null;
                }
            };

            new Thread(sleeper).start();
            sleeper.setOnSucceeded(b -> {
                Hosszabbitas_Label.setVisible(false);
            });
        }
        Hosszabbitas_TextField.setText("");
    }

}
