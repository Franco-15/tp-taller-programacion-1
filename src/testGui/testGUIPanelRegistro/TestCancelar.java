package testGui.testGUIPanelRegistro;

import static org.junit.Assert.fail;

import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import testGui.FalseOptionPane;
import testGui.TestUtils;
import util.Constantes;
import vista.Ventana;

public class TestCancelar{
	Robot robot;
	Controlador controlador;
	FalseOptionPane op = new FalseOptionPane();
	
	@Before
	public void setUp() throws Exception {
		controlador = new Controlador();
		controlador.setMyOptionPane(op);
		JButton RegistrarLogin = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REGISTRAR);
		TestUtils.clickComponent(RegistrarLogin, robot);
	}

	@After
	public void tearDown() throws Exception {
		Ventana ventana = (Ventana) controlador.getVista();
		ventana.setVisible(false);
	}
	@Test
	public void TestCancelarVuelveAPanelLogin() {
		JButton Cancelar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_CANCELAR);
		TestUtils.clickComponent(Cancelar, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NOMBRE_USUARIO);
		Assert.assertNotNull("No se volvio al panel login", username);

	}

}
