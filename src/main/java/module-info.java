module com.example {
    exports com.example.Controlador;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.eclipse.persistence.core;
    requires org.eclipse.persistence.asm;
    requires org.eclipse.persistence.jpa;
    requires org.eclipse.persistence.jpa.jpql;
    requires javax.persistence;

    opens com.example.Controlador.view to javafx.fxml;
}
