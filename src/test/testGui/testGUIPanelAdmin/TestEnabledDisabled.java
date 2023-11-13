package test.testGui.testGUIPanelAdmin;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bin.controlador.Controlador;
import test.testGui.TestUtils;
import util.Constantes;
import vista.Ventana;

public class TestEnabledDisabled {
	Robot robot;
	Controlador controlador;

	public TestEnabledDisabled() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
		}
	} 

	@Before
	public void setUp() throws Exception {
		controlador = new Controlador();
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NOMBRE_USUARIO);
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
	public void testModificarValoresVacios() {
		robot.delay(TestUtils.getDelay());
		JButton cambiar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.MODIFICAR_VALORES);
		Assert.assertFalse("El boton 'cambiar' deberia estar deshablitado", cambiar.isEnabled());
	}

	@Test
	public void testModificarValoresSoloInferior() {
		robot.delay(TestUtils.getDelay());
		JTextField inferior = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTO_INFERIOR);
		JButton cambiar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.MODIFICAR_VALORES);
		TestUtils.clickComponent(inferior, robot);
		TestUtils.tipeaTexto("10", robot);
		Assert.assertFalse("El boton 'cambiar' deberia estar deshablitado", cambiar.isEnabled());
	}

	@Test
	public void testModificarValoresSoloSuperior() {
		robot.delay(TestUtils.getDelay());
		JTextField superior = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTO_SUPERIOR);
		JButton cambiar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.MODIFICAR_VALORES);
		TestUtils.clickComponent(superior, robot);
		TestUtils.tipeaTexto("10", robot);
		Assert.assertFalse("El boton 'cambiar' deberia estar deshablitado", cambiar.isEnabled());
	} 

	@Test

	public void testModificarValoresAmbosCorrectos() {
		robot.delay(TestUtils.getDelay());
		JTextField inferior = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTO_INFERIOR);
		JTextField superior = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTO_SUPERIOR);
		JButton cambiar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.MODIFICAR_VALORES);
		TestUtils.clickComponent(inferior, robot);
		TestUtils.tipeaTexto("1001", robot);
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(superior, robot);
		TestUtils.tipeaTexto("1020", robot);
		robot.delay(TestUtils.getDelay());
		Assert.assertTrue("El boton 'cambiar' deberia estar Habilitado", cambiar.isEnabled());
	}

	@Test

	public void testModificarValoresInferiorMayor() {
		robot.delay(TestUtils.getDelay());
		JTextField inferior = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTO_INFERIOR);
		JTextField superior = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTO_SUPERIOR);
		JButton cambiar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.MODIFICAR_VALORES);
		TestUtils.clickComponent(inferior, robot);
		TestUtils.tipeaTexto("20", robot);
		robot.delay(TestUtils.getDelay());
		TestUtils.clickComponent(superior, robot);
		TestUtils.tipeaTexto("10", robot);
		Assert.assertFalse("El boton 'cambiar' deberia estar deshablitado", cambiar.isEnabled());
	}
}
