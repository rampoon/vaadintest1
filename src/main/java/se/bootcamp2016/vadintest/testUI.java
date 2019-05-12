package se.bootcamp2016.vadintest;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("testtheme")
public class testUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout vLayout = new VerticalLayout();
        final HorizontalLayout hLayout = new HorizontalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Namn:");
        final TextField address = new TextField();
        address.setCaption("Adress:");
        final TextField postalAddress = new TextField();
        postalAddress.setCaption("Postadress:");
        final TextField zipCode = new TextField();
        zipCode.setCaption("Postnr:");

        Button buttonSpara = new Button("Spara");
        buttonSpara.addClickListener( e -> {
            vLayout.addComponent(new Label("Tack för din anmälan " + name.getValue() ));
        });
        
        Button buttonRensa = new Button("Rensa");
        buttonRensa.addClickListener( e -> {
            vLayout.addComponent(new Label("Rensar formuläret"));
            name.clear();
            address.clear();
            postalAddress.clear();
            zipCode.clear();
        });
        
        hLayout.addComponents(buttonSpara, buttonRensa);
        vLayout.addComponents(name, address, postalAddress, zipCode, hLayout);
        vLayout.setMargin(true);
        vLayout.setSpacing(true);
        
        setContent(vLayout);
    }

    @WebServlet(urlPatterns = "/*", name = "testUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = testUI.class, productionMode = false)
    public static class testUIServlet extends VaadinServlet {
    }
}
