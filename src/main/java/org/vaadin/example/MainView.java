package org.vaadin.example;

import alerta.ServicioMysql;
import alerta.alerta;
import back.Diary;
import back.Pick;
import back.bbdd;
import com.google.gson.Gson;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.datetimepicker.DateTimePicker;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.FileRejectedEvent;
import com.vaadin.flow.data.renderer.NumberRenderer;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;
import java.io.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport("./styles/style.css")
@CssImport("./styles/text.css")
@CssImport(value = "./styles/grid.css", themeFor = "vaadin-grid")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {


    private TextArea descripcion;
    private NumberField cantidad;
    private NumberField tomas;
    private NumberField frecuencia;
    private NumberField duracion;
    private TextField nombre;
    private PasswordField pass;
    private TextField user;
    private Button button;

    public MainView(@Autowired GreetService service) throws IOException {

        HorizontalLayout total = new HorizontalLayout();
        HorizontalLayout board1 = new HorizontalLayout();
        HorizontalLayout inicio = new HorizontalLayout();
        HorizontalLayout layout = new HorizontalLayout();
        VerticalLayout a = new VerticalLayout();
        VerticalLayout b = new VerticalLayout();
        VerticalLayout c = new VerticalLayout();
        VerticalLayout cc = new VerticalLayout();
        VerticalLayout ccc = new VerticalLayout();
        VerticalLayout board = new VerticalLayout();
        HorizontalLayout layout1 = new HorizontalLayout();
        HorizontalLayout layout2 = new HorizontalLayout();

        ArrayList lista = (ArrayList) new ServicioMysql().findAll();

        Grid<alerta> grid = new Grid<>();
        int activo = new ServicioMysql().COUNTACTIVOS();
        int desactivo = new ServicioMysql().COUNTDESACTIVOS();
        Span s = new Span("Num Reglas");
        s.getElement().getStyle().set("font-size", "17px").set("margin", "auto").set("padding-left", "15px").set("padding-top", "20px").set("height", "30px").set("width", "200px").set("background-color", "white").set("color", "rgb(85, 179, 98)");
        Label sd = new Label(String.valueOf(activo+desactivo));
        sd.setClassName("label1");
        c.add(s,sd);
        c.setPadding(false);
        c.setMargin(false);

        Span ss = new Span("Reglas Activas");
        ss.getElement().getStyle().set("font-size", "17px").set("margin", "auto").set("padding-left", "15px").set("padding-top", "20px").set("height", "30px").set("width", "200px").set("background-color", "white").set("color", "rgb(85, 179, 98)");
        Label ssd = new Label(String.valueOf(activo));
        ssd.setClassName("label1");
        cc.add(ss,ssd);
        cc.setPadding(false);
        cc.setMargin(false);

        Span sss = new Span("Reglas No Activas");
        sss.getElement().getStyle().set("font-size", "17px").set("margin", "auto").set("padding-left", "15px").set("padding-top", "20px").set("height", "30px").set("width", "200px").set("background-color", "white").set("color", "#ff6666");
        Label sssd = new Label(String.valueOf(desactivo));
        sssd.setClassName("label2");
        ccc.add(sss,sssd);
        ccc.setPadding(false);
        ccc.setMargin(false);

        board1.add(c, cc, ccc);
        board.add(board1);

        descripcion = new TextArea("Notas");
        descripcion.setHeight("100px");
        descripcion.setWidth("395px");

        cantidad = new NumberField("Cantidad/Toma");
        cantidad.setWidth("120px");
        cantidad.setValue(1d);
        cantidad.setHasControls(true);
        cantidad.setMin(1);
        cantidad.setMax(10);

        nombre = new TextField("Medicamento");
        nombre.setWidth("265px");

        tomas = new NumberField("Tomas al dia");
        tomas.setWidth("105px");
        tomas.setValue(1d);
        tomas.setHasControls(true);
        tomas.setMin(1);
        tomas.setMax(10);

        frecuencia = new NumberField("Tiempo entre tomas");
        frecuencia.setWidth("140px");
        frecuencia.setValue(8d);
        frecuencia.setHasControls(true);
        frecuencia.setMin(1);
        frecuencia.setMax(24);

        duracion = new NumberField("Duración (días)");
        duracion.setWidth("120px");
        duracion.setValue(10d);
        duracion.setHasControls(true);
        duracion.setMin(1);

        DatePicker dateTimePicker = new DatePicker();
        dateTimePicker.setLabel("Dia y hora de inicio");
        DatePicker valueDatePicker = new DatePicker();
        LocalDate now = LocalDate.now();
        valueDatePicker.setValue(now);
        dateTimePicker.setWidth("395px");

        button = new Button("AÑADIR");
        button.setThemeName("primary");
        button.setWidth("150px");
        button.setHeight("50px");

        b.setPadding(false);
        b.setMargin(false);

        layout.setPadding(false);
        layout.setMargin(false);

        layout1.setPadding(false);
        layout1.setMargin(false);

        layout.add(nombre, cantidad);
        layout1.add(tomas,frecuencia, duracion);
        layout2.add(dateTimePicker);

        a.add(layout, layout1, layout2,descripcion, button);


        button.addClickListener(e -> {
            Notification.show("Nueva regla añadida");
        });


        button.addClickListener(w -> {
            new ServicioMysql().insert(nombre.getValue(), cantidad.getValue().intValue() ,tomas.getValue().intValue() , frecuencia.getValue().intValue() , duracion.getValue().intValue(), descripcion.getValue(), Date.valueOf(dateTimePicker.getValue()).toString(), Date.valueOf(dateTimePicker.getValue().plusDays(duracion.getValue().intValue())).toString(),1);
            grid.setItems(lista);
            UI.getCurrent().getPage().reload();
            //sd.setText(String.valueOf(lista.getNum()));

        });

        grid.setItems(lista);
        grid.setHeight("530px");
        grid.addColumn(alerta::getNombre).setHeader("Medicamento").setWidth("100px");; //Columns created del grid
        grid.addColumn(alerta::getCantidad).setHeader("Num Tomas Dia").setWidth("100px");; //Columns created del grid
        grid.addColumn(alerta::getDescripcion).setHeader("Notas").setWidth("300px");
        grid.addColumn(alerta::getInicio).setHeader("Fecha Inicio").setWidth("120px");;
        grid.addColumn(alerta::getFin).setHeader("Fecha Fin").setWidth("120px");;
        grid.addComponentColumn(item -> new Button("Activar", clickEvent -> {
            item.setActivo(1);
            new ServicioMysql().UPDATE(1,item.getId());
            grid.setItems(lista);
            //UI.getCurrent().getPage().reload();
            sd.setText(String.valueOf(activo+desactivo));
            ssd.setText(String.valueOf(activo));
            sssd.setText(String.valueOf(desactivo));

        })).setWidth("60px");
        grid.addComponentColumn(item -> new Button("Desactivar", clickEvent -> {
            item.setActivo(0);
            new ServicioMysql().UPDATE(0,item.getId());
            grid.setItems(lista);
            UI.getCurrent().getPage().reload();

        })).setWidth("80px");
        grid.addComponentColumn(item -> new Button("Eliminar", clickEvent -> {
            new ServicioMysql().delete(item.getId());
            grid.setItems(lista);
            UI.getCurrent().getPage().reload();

        })).setWidth("80px");

        grid.setClassNameGenerator(customer -> {
            if (customer.getActivo() == 0 ) {
                return "error";
            }
            else{
                return "success";
            }
        });

        MenuBar menuBar = new MenuBar();
        menuBar.addItem("Home", e -> {
            add(inicio);
            add(board);
            remove(a);
            remove(grid);
        });

        menuBar.addItem("Mis Reglas", e -> {
            add(grid);
            remove(a);
            remove(board);
            remove(inicio);
        });

        menuBar.addItem("Añadir", e -> {
            add(a);
            remove(grid);
            remove(board);
            remove(inicio);
        });
        /*menuBar.addItem("Iniciar Sesión", e -> {
            add(a);
            remove(grid);
            remove(board);
            remove(inicio);
        });*/
        total.add(menuBar);
        add(total);
    }
}
