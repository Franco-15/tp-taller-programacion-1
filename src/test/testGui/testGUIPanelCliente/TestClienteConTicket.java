package test.testGui.testGUIPanelCliente;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bin.controlador.Controlador;
import excepciones.ImposibleModificarTicketsException;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import test.testGui.FalseOptionPane;
import test.testGui.TestUtils;
import util.Constantes;
import util.Mensajes;
import vista.Ventana;

public class TestClienteConTicket {
	Robot robot;
	Controlador controlador;
	FalseOptionPane op = new FalseOptionPane();
	Empleador empleador;
	public TestClienteConTicket() {
		try {
			robot = new Robot();
		} catch (AWTException e) {

		}
	}

	@Before
	public void setup() {

		try {
			empleador = new Empleador();
			empleador.setPassword("1234567");
			empleador.setUsserName("Manueldeserti");
			Agencia.getInstance().getEmpleadores().put("Manueldeserti", empleador);
			Agencia.getInstance().crearTicketEmpleador(Constantes.HOME_OFFICE, 10000, Constantes.JORNADA_COMPLETA,
					Constantes.JUNIOR, Constantes.EXP_MEDIA, Constantes.PRIMARIOS, empleador);
			controlador = new Controlador();
			controlador.setMyOptionPane(op);
			JTextField nombre = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
					Constantes.NOMBRE_USUARIO);
			JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
					Constantes.PASSWORD);
			JButton login = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.LOGIN);

			TestUtils.clickComponent(nombre, robot);
			TestUtils.tipeaTexto(empleador.getUsserName(), robot);

			TestUtils.clickComponent(password, robot);
			TestUtils.tipeaTexto(empleador.getPassword(), robot);

			TestUtils.clickComponent(login, robot);
		} catch (ImposibleModificarTicketsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		Ventana ventana = (Ventana) controlador.getVista();
		ventana.setVisible(false);
		Agencia.getInstance().getEmpleadores().clear();
		Agencia.getInstance().setEstadoContratacion(false);

	}

	@Test
	public void testBotonEliminarHabilitado() {
		TestUtils.getDelay();
		JButton eliminar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.ELIMINAR_TICKET);
		TestUtils.getDelay();
		JTextArea areaTicket = (JTextArea) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXT_AREA_TICKET);
		
		Assert.assertEquals("El area de tickets deberia tener el ticket del cliente",
		this.empleador.getTicket().toString(), areaTicket.getText());
		Assert.assertTrue("El boton eliminar deberia estar habilitado", eliminar.isEnabled());
	}
	
	@Test
	public void testErrorAlEliminarTicket() {
		Agencia.getInstance().setEstadoContratacion(true);
		TestUtils.getDelay();
		JButton eliminar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.ELIMINAR_TICKET);
		TestUtils.getDelay();
		JTextArea areaTicket = (JTextArea) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXT_AREA_TICKET);
		TestUtils.clickComponent(eliminar, robot);
		
		
		Assert.assertEquals("Deberia mostrarse el texto" + Mensajes.ERROR_AGENCIA_EN_CONTRATACION.getValor(),
		Mensajes.ERROR_AGENCIA_EN_CONTRATACION.getValor(), op.getMensaje());
	}
	
	@Test
	public void testHabilitadoAEliminarTicket() {
		Agencia.getInstance().setEstadoContratacion(false);
		TestUtils.getDelay();
		JButton eliminar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.ELIMINAR_TICKET);
		TestUtils.getDelay();
		JTextArea areaTicket = (JTextArea) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXT_AREA_TICKET);
		TestUtils.clickComponent(eliminar, robot);
		
		
		Assert.assertEquals("El area de tickets deberia tener el texto" + Mensajes.SIN_TICKET.getValor(),
		Mensajes.SIN_TICKET.getValor(), areaTicket.getText());
		Assert.assertFalse("El boton eliminar deberia estar deshabilitado", eliminar.isEnabled());
	}
}