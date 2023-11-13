package test.testGui.testGUIPanelRegistro;

import java.awt.AWTException;
import java.awt.Robot;

import javax.swing.JButton;
import javax.swing.JRadioButton;
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

	/*
	 * En el caso de seleccionar un empleador, el bot�n REG_BUTTON_REGISTRAR estar�
	 * habilitado si y solo si todos los textField de la izquierda son distintos de
	 * vac�o. En el caso de seleccionar un empleado, el bot�n REG_BUTTON_REGISTRAR
	 * estar� habilitado si y solo si todos los textField son distintos de vac�o y
	 * la edad contiene un valor entero positivo.
	 */
	public TestEnabledDisabled() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
		}
	}

	@Before
	public void setUp() throws Exception {
		controlador = new Controlador();
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
	public void EmpleadorTodosLlenos() {
		JRadioButton RBEmpleador = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADOR);
		TestUtils.clickComponent(RBEmpleador, robot);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
//		TestUtils.clickComponent(RBempleado, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(username, robot);
		TestUtils.tipeaTexto("Guillermo2023", robot);
		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField Rep_password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(Rep_password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField RealName = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(RealName, robot);
		TestUtils.tipeaTexto("Guillermo", robot);
		JTextField Telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Telefono, robot);
		TestUtils.tipeaTexto("2235546765", robot);

		Assert.assertTrue("El boton esta habilitado", Registrar.isEnabled());
		TestUtils.getDelay();

	}
	@Test
	public void EmpleadorTodosValidosMenosNombreUsuario() {
		JRadioButton RBEmpleadoR = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADOR);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
//		TestUtils.clickComponent(RBempleado, robot);
		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField Rep_password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(Rep_password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField RealName = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(RealName, robot);
		TestUtils.tipeaTexto("Guillermo", robot);
		JTextField Telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Telefono, robot);
		TestUtils.tipeaTexto("2235546765", robot);
		JTextField Apellido = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_APELLIDO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Apellido, robot);
		TestUtils.tipeaTexto("Lazurri", robot);
		JTextField Edad = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_EDAD);
		TestUtils.clickComponent(Edad, robot);
		TestUtils.tipeaTexto("38", robot);
		Assert.assertFalse("El boton esta deshabilitado", Registrar.isEnabled());
		TestUtils.getDelay();

	}

	// No modificamos el JRadioButton pq viene seleccionado el empleado por default
	@Test
	public void EmpleadoTodosLlenos() {
		JRadioButton RBEmpleado = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADO);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
//		TestUtils.clickComponent(RBempleado, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(username, robot);
		TestUtils.tipeaTexto("Guillermo2023", robot);
		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField Rep_password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(Rep_password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField RealName = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(RealName, robot);
		TestUtils.tipeaTexto("Guillermo", robot);
		JTextField Telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Telefono, robot);
		TestUtils.tipeaTexto("2235546765", robot);
		JTextField Apellido = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_APELLIDO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Apellido, robot);
		TestUtils.tipeaTexto("Lazurri", robot);
		JTextField Edad = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_EDAD);
		TestUtils.clickComponent(Edad, robot);
		TestUtils.tipeaTexto("38", robot);
		Assert.assertTrue("El boton esta habilitado", Registrar.isEnabled());
		TestUtils.getDelay();

	}

	@Test
	public void EmpleadoEdadInvalida() {
		JRadioButton RBEmpleado = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADO);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
//		TestUtils.clickComponent(RBempleado, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(username, robot);
		TestUtils.getDelay();
		TestUtils.tipeaTexto("Guillermo2023", robot);
		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField Rep_password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(Rep_password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField RealName = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(RealName, robot);
		TestUtils.tipeaTexto("Guillermo", robot);
		JTextField Telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Telefono, robot);
		TestUtils.tipeaTexto("2235546765", robot);
		JTextField Apellido = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_APELLIDO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Apellido, robot);
		TestUtils.tipeaTexto("Lazurri", robot);
		JTextField Edad = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_EDAD);
		TestUtils.clickComponent(Edad, robot);
		TestUtils.tipeaTexto("-12", robot);
		Assert.assertFalse("El boton no deberia estar deshabilitado", Registrar.isEnabled());
		TestUtils.getDelay();
	}

	@Test
	public void EmpleadoTodosValidosMenosNombreUsuario() {
		JRadioButton RBEmpleado = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADO);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
//		TestUtils.clickComponent(RBempleado, robot);
		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField Rep_password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(Rep_password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField RealName = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(RealName, robot);
		TestUtils.tipeaTexto("Guillermo", robot);
		JTextField Telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Telefono, robot);
		TestUtils.tipeaTexto("2235546765", robot);
		JTextField Apellido = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_APELLIDO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Apellido, robot);
		TestUtils.tipeaTexto("Lazurri", robot);
		JTextField Edad = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_EDAD);
		TestUtils.clickComponent(Edad, robot);
		TestUtils.tipeaTexto("38", robot);
		Assert.assertFalse("El boton esta deshabilitado", Registrar.isEnabled());
		TestUtils.getDelay();

	}

	@Test
	public void EmpleadoTodosValidosMenospassword() {
		JRadioButton RBEmpleado = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADO);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
//		TestUtils.clickComponent(RBempleado, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(username, robot);
		TestUtils.tipeaTexto("Guillermo2023", robot);

		JTextField Rep_password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(Rep_password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField RealName = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(RealName, robot);
		TestUtils.tipeaTexto("Guillermo", robot);
		JTextField Telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Telefono, robot);
		TestUtils.tipeaTexto("2235546765", robot);
		JTextField Apellido = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_APELLIDO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Apellido, robot);
		TestUtils.tipeaTexto("Lazurri", robot);
		JTextField Edad = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_EDAD);
		TestUtils.clickComponent(Edad, robot);
		TestUtils.tipeaTexto("38", robot);
		Assert.assertFalse("El boton esta deshabilitado", Registrar.isEnabled());
		TestUtils.getDelay();

	}
	@Test
	public void EmpleadorTodosValidosMenospassword() {
		JRadioButton RBEmpleador = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADOR);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
//		TestUtils.clickComponent(RBempleado, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(username, robot);
		TestUtils.tipeaTexto("Guillermo2023", robot);

		JTextField Rep_password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(Rep_password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField RealName = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(RealName, robot);
		TestUtils.tipeaTexto("Guillermo", robot);
		JTextField Telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Telefono, robot);
		TestUtils.tipeaTexto("2235546765", robot);
		JTextField Apellido = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_APELLIDO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Apellido, robot);
		TestUtils.tipeaTexto("Lazurri", robot);
		JTextField Edad = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_EDAD);
		TestUtils.clickComponent(Edad, robot);
		TestUtils.tipeaTexto("38", robot);
		Assert.assertFalse("El boton esta deshabilitado", Registrar.isEnabled());
		TestUtils.getDelay();

	}

	@Test
	public void EmpleadoTodosValidosMenosReppassword() {
		JRadioButton RBEmpleado = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADO);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
//		TestUtils.clickComponent(RBempleado, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(username, robot);
		TestUtils.tipeaTexto("Guillermo2023", robot);
		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField RealName = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(RealName, robot);
		TestUtils.tipeaTexto("Guillermo", robot);
		JTextField Telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Telefono, robot);
		TestUtils.tipeaTexto("2235546765", robot);
		JTextField Apellido = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_APELLIDO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Apellido, robot);
		TestUtils.tipeaTexto("Lazurri", robot);
		JTextField Edad = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_EDAD);
		TestUtils.clickComponent(Edad, robot);
		TestUtils.tipeaTexto("38", robot);
		Assert.assertFalse("El boton esta deshabilitado", Registrar.isEnabled());
		TestUtils.getDelay();

	}
	@Test
	public void EmpleadorTodosValidosMenosReppassword() {
		JRadioButton RBEmpleador = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADOR);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
//		TestUtils.clickComponent(RBempleado, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(username, robot);
		TestUtils.tipeaTexto("Guillermo2023", robot);
		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField RealName = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(RealName, robot);
		TestUtils.tipeaTexto("Guillermo", robot);
		JTextField Telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Telefono, robot);
		TestUtils.tipeaTexto("2235546765", robot);
		JTextField Apellido = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_APELLIDO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Apellido, robot);
		TestUtils.tipeaTexto("Lazurri", robot);
		JTextField Edad = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_EDAD);
		TestUtils.clickComponent(Edad, robot);
		TestUtils.tipeaTexto("38", robot);
		Assert.assertFalse("El boton esta deshabilitado", Registrar.isEnabled());
		TestUtils.getDelay();

	}

	@Test
	public void EmpleadoTodosValidosMenosRealName() {
		JRadioButton RBEmpleado = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADO);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
//		TestUtils.clickComponent(RBempleado, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(username, robot);
		TestUtils.tipeaTexto("Guillermo2023", robot);
		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField Rep_password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(Rep_password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);

		JTextField Telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Telefono, robot);
		TestUtils.tipeaTexto("2235546765", robot);
		JTextField Apellido = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_APELLIDO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Apellido, robot);
		TestUtils.tipeaTexto("Lazurri", robot);
		JTextField Edad = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_EDAD);
		TestUtils.clickComponent(Edad, robot);
		TestUtils.tipeaTexto("38", robot);
		Assert.assertFalse("El boton esta deshabilitado", Registrar.isEnabled());
		TestUtils.getDelay();

	}
	@Test
	public void EmpleadorTodosValidosMenosRealName() {
		JRadioButton RBEmpleador = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADOR);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
//		TestUtils.clickComponent(RBempleado, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(username, robot);
		TestUtils.tipeaTexto("Guillermo2023", robot);
		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField Rep_password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(Rep_password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);

		JTextField Telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Telefono, robot);
		TestUtils.tipeaTexto("2235546765", robot);
		JTextField Apellido = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_APELLIDO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Apellido, robot);
		TestUtils.tipeaTexto("Lazurri", robot);
		JTextField Edad = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_EDAD);
		TestUtils.clickComponent(Edad, robot);
		TestUtils.tipeaTexto("38", robot);
		Assert.assertFalse("El boton esta deshabilitado", Registrar.isEnabled());
		TestUtils.getDelay();

	}

	@Test
	public void EmpleadoTodosValidosMenosTelefono() {
		JRadioButton RBEmpleado = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADO);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
//		TestUtils.clickComponent(RBempleado, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(username, robot);
		TestUtils.tipeaTexto("Guillermo2023", robot);
		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField Rep_password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(Rep_password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField RealName = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(RealName, robot);
		TestUtils.tipeaTexto("Guillermo", robot);

		JTextField Apellido = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_APELLIDO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Apellido, robot);
		TestUtils.tipeaTexto("Lazurri", robot);
		JTextField Edad = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_EDAD);
		TestUtils.clickComponent(Edad, robot);
		TestUtils.tipeaTexto("38", robot);
		Assert.assertFalse("El boton esta deshabilitado", Registrar.isEnabled());
		TestUtils.getDelay();
	}
	@Test
	public void EmpleadorTodosValidosMenosTelefono() {
		JRadioButton RBEmpleador = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADOR);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
//		TestUtils.clickComponent(RBempleado, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(username, robot);
		TestUtils.tipeaTexto("Guillermo2023", robot);
		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField Rep_password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(Rep_password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField RealName = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(RealName, robot);
		TestUtils.tipeaTexto("Guillermo", robot);

		JTextField Apellido = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_APELLIDO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Apellido, robot);
		TestUtils.tipeaTexto("Lazurri", robot);
		JTextField Edad = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_EDAD);
		TestUtils.clickComponent(Edad, robot);
		TestUtils.tipeaTexto("38", robot);
		Assert.assertFalse("El boton esta deshabilitado", Registrar.isEnabled());
		TestUtils.getDelay();
	}

	@Test
	public void EmpleadoTodosValidosMenosApellido() {
		JRadioButton RBEmpleado = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADO);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
//		TestUtils.clickComponent(RBempleado, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(username, robot);
		TestUtils.tipeaTexto("Guillermo2023", robot);
		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField Rep_password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(Rep_password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField RealName = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(RealName, robot);
		TestUtils.tipeaTexto("Guillermo", robot);
		JTextField Telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Telefono, robot);
		TestUtils.tipeaTexto("2235546765", robot);

		JTextField Edad = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_EDAD);
		TestUtils.clickComponent(Edad, robot);
		TestUtils.tipeaTexto("38", robot);
		Assert.assertFalse("El boton esta deshabilitado", Registrar.isEnabled());
		TestUtils.getDelay();

	}

	@Test
	public void EmpleadoTodosValidosMenosEdad() {
		JRadioButton RBEmpleado = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADO);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
//		TestUtils.clickComponent(RBempleado, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(username, robot);
		TestUtils.tipeaTexto("Guillermo2023", robot);
		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField Rep_password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);
		TestUtils.getDelay();
		TestUtils.clickComponent(Rep_password, robot);
		TestUtils.tipeaTexto("Adolfo123", robot);
		JTextField RealName = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);
		TestUtils.getDelay();
		TestUtils.clickComponent(RealName, robot);
		TestUtils.tipeaTexto("Guillermo", robot);
		JTextField Telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Telefono, robot);
		TestUtils.tipeaTexto("2235546765", robot);
		JTextField Apellido = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_APELLIDO);
		TestUtils.getDelay();
		TestUtils.clickComponent(Apellido, robot);
		TestUtils.tipeaTexto("Lazurri", robot);

		TestUtils.tipeaTexto("38", robot);
		Assert.assertFalse("El boton esta deshabilitado", Registrar.isEnabled());
		TestUtils.getDelay();

	}

}
