package testGui;

import vista.IOptionPane;

import java.awt.Component;

public class FalseOptionPane implements IOptionPane {
    private String mensaje = null;

    public FalseOptionPane() {
        super();
    }

    @Override
    public void ShowMessage(String arg0) {
        this.mensaje = arg0;
    }

    public String getMensaje() {
        return mensaje;
    }
}
