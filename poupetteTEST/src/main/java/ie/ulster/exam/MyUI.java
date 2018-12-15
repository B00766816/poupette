package ie.ulster.exam;

import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.*;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

   @Override
    protected void init(VaadinRequest vaadinRequest) {
        
        // Create the connection object
        Connection connection = null;  
         String connectionString = "jdbc:sqlserver://poupettedb.database.windows.net:1433;database=poupette3db;user=B00766816@poupettedb;password=DB@iku6Chot!;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
        
         final VerticalLayout layout = new VerticalLayout();
         HorizontalLayout topRow = new HorizontalLayout ();
         final TextField name = new TextField ();
         name.setCaption ("Type your name here");

         Label logo  = new Label ("<H1> Marty Party Planners </H1> <p/> <h3>Please enter the details below and click Book </h3>");
         logo.setContentMode (com.vaadin.shared.ui.ContentMode.HTML);
        
         //Label number = new Label ("Student No");

         final Slider amountSlider = new Slider ("How many invited", 10, 300);
            amountSlider.setWidth("500px");

        final ComboBox <String> children = new ComboBox<String>();
         children.setCaption("Are children attending");
        children.setItems ("infant", "adult", "minor");
        
        Button button = new Button("Click Me");
        button.addClickListener (e -> {
            layout.addComponent(new Label ("Thanks "+ name.getValue() + "it works!"));
        });

       // final Label vertvalue = new Label ();

        //Label studentNo = new Label ("B00766816");

        Label status = new Label ("Your party is not booked yet");

       


    try 
{
	// Connect with JDBC driver to a database
    connection = DriverManager.getConnection(connectionString);
    // Add a label to the web app with the message and name of the database we connected to 
	//layout.addComponent(new Label("Connected to database: " + connection.getCatalog()));
   
    ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM room;");
    List <Rooms> roomsList = new ArrayList <Rooms>();
    while (rs.next()) {
        roomsList.add (new Rooms (rs.getString ("room"),
                                    rs.getInt("capacity"),
                                    rs.getString("feature"),
                                    rs.getBoolean("alcohol_allowed")));

    }//while
    
    // Add my component, grid is templated with Customer
    Grid <Rooms> myGrid = new Grid <> ();
    // Set the items (List)
    myGrid.setItems (roomsList);
    // Configure the order and the caption of the grid
    myGrid.addColumn (Rooms::getRoom).setCaption("Room");
    myGrid.addColumn(Rooms::getCapacity).setCaption("Capacity");
    myGrid.addColumn(Rooms::getFeature).setCaption("Feature");
    myGrid.addColumn(Rooms::getAlcohol).setCaption ("Alcohol");

    // Add the grid to the list
    layout.addComponent(myGrid);




} 




catch (Exception e) 
{
	// This will show an error message if something went wrong
	layout.addComponent(new Label(e.getMessage()));
}

setContent(layout);

}

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
