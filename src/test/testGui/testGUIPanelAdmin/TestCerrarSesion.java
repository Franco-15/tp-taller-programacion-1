package test.testGui.testGUIPanelAdmin;

import static org.junit.Assert.*;

import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controlador.Controlador;
import test.testGui.FalseOptionPane;
import test.testGui.TestUtils;
import util.Constantes;
import vista.Ventana;

public class TestCerrarSesion {

	Robot robot;
	Controlador controlador;
	FalseOptionPane op = new FalseOptionPane();
	
	@Before
	public void setUp() throws Exception {
		controlador = new Controlador();
		robot=new Robot();
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NOMBRE_USUARIO);
		TestUtils.getDelay();
		TestUtils.clickComponent(username, robot);
		TestUtils.tipeaTexto("admin", robot);
		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.PASSWORD);
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("admin", robot);
		JButton login = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.LOGIN);
		TestUtils.clickComponent(login, robot);

	}

	@After
	public void tearDown() throws Exception {
		Ventana ventana = (Ventana) controlador.getVista();
		ventana.setVisible(false);
	}
	@Test
	public void TestCerrarSesionVuelveAPanelLogin() {
		JButton CerrarSesion = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.CERRARSESION);
		TestUtils.clickComponent(CerrarSesion, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NOMBRE_USUARIO);
		Assert.assertNotNull("No se volvio al panel login", username);
	}
}
