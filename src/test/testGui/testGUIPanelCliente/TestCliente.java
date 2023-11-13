package test.testGui.testGUIPanelCliente;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bin.controlador.Controlador;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import test.testGui.FalseOptionPane;
import test.testGui.TestUtils;
import util.Constantes;
import util.Mensajes;
import vista.Ventana;

public class TestCliente {
	Robot robot;
	Controlador controlador;
	FalseOptionPane op = new FalseOptionPane();
	Empleador empleador;
	public TestCliente() {
		try {
			robot = new Robot();
		} catch (AWTException e) {

		}
	}

	@Before
	public void setup() {

		 empleador = new Empleador();
		empleador.setPassword("1234567");
		empleador.setUsserName("Manueldeserti");
		Agencia.getInstance().getEmpleadores().put("Manueldeserti", empleador);
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
	}

	@After
	public void tearDown() throws Exception {
		Ventana ventana = (Ventana) controlador.getVista();
		ventana.setVisible(false);
		Agencia.getInstance().getEmpleadores().clear();
		Agencia.getInstance().setEstadoContratacion(false);

	}

	@Test
	public void testNuevoTicketClickeado() {
		TestUtils.getDelay();
		JButton nuevoTicket = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NUEVOTICKET);
		JRadioButton locacion = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.PRESENCIAL);
		JRadioButton tipoDePuesto = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.JUNIOR);
		JTextField remuneracion = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTFIELD_REMUNERACION);
		TestUtils.clickComponent(nuevoTicket, robot);

		Assert.assertFalse("Nuevo ticket habilitado", nuevoTicket.isEnabled());
		Assert.assertTrue("Locacion desactivada", locacion.isEnabled());
		Assert.assertTrue("Campo remuneracion desactivado", remuneracion.isEnabled());
		Assert.assertTrue("Campo remuneracion desactivado", tipoDePuesto.isEnabled());
	}

//	Los componentes del panel de creaci�n de Ticket y el bot�n CONFIRMARNUEVOTICKET 
//	permanecer�n deshabilitados hasta que se pulse el bot�n NUEVOTICKET
	
	@Test
	public void testNuevoTicketHabilitado() {
		TestUtils.getDelay();
		JButton nuevoTicket = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NUEVOTICKET);
		JRadioButton locacion = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.PRESENCIAL);
		JTextField remuneracion = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTFIELD_REMUNERACION);
		JButton aceptar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.CONFIRMARNUEVOTICKET);

		Assert.assertTrue("Nuevo ticket deshabilitado", nuevoTicket.isEnabled());
		Assert.assertFalse("Locacion activada", locacion.isEnabled());
		Assert.assertFalse("Campo remuneracion habilitado", remuneracion.isEnabled());
		Assert.assertFalse("Campo aceptar habilitado", aceptar.isEnabled());
	}

//	Cuando TEXTFIELD_REMUNERACION contenga un entero positivo se habilitar� el bot�n CONFIRMARNUEVOTICKET

	@Test
	public void testHabilitadoAceptar1() {
		TestUtils.getDelay();
		JButton nuevoTicket = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NUEVOTICKET);
		JTextField remuneracion = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTFIELD_REMUNERACION);
		JButton aceptar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.CONFIRMARNUEVOTICKET);
		TestUtils.clickComponent(nuevoTicket, robot);
		TestUtils.clickComponent(remuneracion, robot);
		TestUtils.tipeaTexto("10", robot);
		
		Assert.assertFalse("Nuevo ticket habilitado", nuevoTicket.isEnabled());
		Assert.assertTrue("Aceptar deshabilitado", aceptar.isEnabled());
	}

	//Idem arriba, pero el caso de remuneracion negativa
	@Test
	public void testHabilitadoAceptar2() {
		TestUtils.getDelay();
		JButton nuevoTicket = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NUEVOTICKET);
		JTextField remuneracion = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTFIELD_REMUNERACION);
		JButton aceptar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.CONFIRMARNUEVOTICKET);
		TestUtils.clickComponent(nuevoTicket, robot);
		TestUtils.clickComponent(remuneracion, robot);
		TestUtils.tipeaTexto("-10", robot);

		Assert.assertFalse("Nuevo ticket habilitado", nuevoTicket.isEnabled());
		Assert.assertFalse("Aceptar habilitado", aceptar.isEnabled());
	}
	
	//Idem arriba, pero el caso de remuneracion vacia
	@Test
	public void testHabilitadoAceptar3() {
		TestUtils.getDelay();
		JButton nuevoTicket = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NUEVOTICKET);
		JTextField remuneracion = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTFIELD_REMUNERACION);
		JButton aceptar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.CONFIRMARNUEVOTICKET);
		TestUtils.clickComponent(nuevoTicket, robot);
		TestUtils.clickComponent(remuneracion, robot);
		TestUtils.tipeaTexto("", robot);

		Assert.assertFalse("Nuevo ticket habilitado", nuevoTicket.isEnabled());
		Assert.assertFalse("Aceptar habilitado", aceptar.isEnabled());
	}

//	Al pulsar el bot�n CONFIRMARNUEVOTICKET, se deshabilitan el bot�n CONFIRMARNUEVOTICKET y 
//	los componentes del panel de creaci�n de ticket. Adem�s, se habilitan el bot�n NUEVOTICKET. 
//
	
	@Test
	public void testBotonAceptarClickeado() {
		TestUtils.getDelay();
		JButton nuevoTicket = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NUEVOTICKET);
		JTextField remuneracion = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTFIELD_REMUNERACION);
		JRadioButton locacion = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.PRESENCIAL);
		JButton aceptar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.CONFIRMARNUEVOTICKET);
		TestUtils.clickComponent(nuevoTicket, robot);
		TestUtils.clickComponent(remuneracion, robot);
		TestUtils.tipeaTexto("10", robot);
		TestUtils.clickComponent(aceptar, robot);

		Assert.assertTrue("Nuevo ticket deshabilitado", nuevoTicket.isEnabled());
		Assert.assertFalse("Aceptar habilitado", aceptar.isEnabled());
		Assert.assertFalse("Locacion habilitado", locacion.isEnabled());
		Assert.assertFalse("Campo remuneracion habilitado", remuneracion.isEnabled());
	}
//Se testea que 
	@Test
	public void testErrorCrearTicket() {
		TestUtils.getDelay();
		Agencia.getInstance().setEstadoContratacion(true);
		JButton nuevoTicket = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NUEVOTICKET);
		JTextField remuneracion = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTFIELD_REMUNERACION);
		JButton aceptar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.CONFIRMARNUEVOTICKET);
		TestUtils.clickComponent(nuevoTicket, robot);
		TestUtils.clickComponent(remuneracion, robot);
		TestUtils.tipeaTexto("10", robot);
		TestUtils.clickComponent(aceptar, robot);

		Assert.assertEquals("Los mensajes no coinciden", Mensajes.ERROR_AGENCIA_EN_CONTRATACION.getValor(),
				op.getMensaje());
	}
	
	@Test
	public void testCrearTicket() {
		TestUtils.getDelay();
		Agencia.getInstance().setEstadoContratacion(false);
		JButton nuevoTicket = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.NUEVOTICKET);
		JTextArea areaTicket = (JTextArea) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXT_AREA_TICKET);
		JTextField remuneracion = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXTFIELD_REMUNERACION);
		JButton aceptar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.CONFIRMARNUEVOTICKET);
		TestUtils.clickComponent(nuevoTicket, robot);
		TestUtils.clickComponent(remuneracion, robot);
		TestUtils.tipeaTexto("10", robot);
		TestUtils.clickComponent(aceptar, robot);

		Assert.assertEquals("Los mensajes coinciden",this.empleador.getTicket().toString(), areaTicket.getText());
				
	}


	@Test
	public void testBotonEliminarDeshabilitado() {
		TestUtils.getDelay();
		JButton eliminar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.ELIMINAR_TICKET);
		JTextArea areaTicket = (JTextArea) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.TEXT_AREA_TICKET);

		Assert.assertEquals("El area de tickets deberia tener el texto" + Mensajes.SIN_TICKET.getValor(),
				Mensajes.SIN_TICKET.getValor(), areaTicket.getText());
		Assert.assertFalse("El boton eliminar deberia estar deshabilitado", eliminar.isEnabled());
	}
}