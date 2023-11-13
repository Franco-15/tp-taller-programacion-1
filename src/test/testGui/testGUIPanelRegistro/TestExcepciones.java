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

import controlador.Controlador;
import test.testGui.FalseOptionPane;
import test.testGui.TestUtils;
import util.Constantes;
import util.Mensajes;
import vista.Ventana;

/*
 El metodo registrar() se encarga de registrar un nuevo usuario (empleado o empleador) en la agencia, realizar su inicio de sesion y actualizar
 la vista con los detalles del usuario registrado. Si el tipo de usuario seleccionado es "Empleado", se realiza lo siguiente: 
 Se intenta registrar un empleado en la agencia utilizando los datos proporcionados (nombre de usuario, contrasena, nombre real, apellido, telefono y edad). 
 Si el registro no es exitoso porque el usuario ya existe entonces se trata la excepcion NewRegistrerException y se muestra el mensaje de error correspondiente al 
 enumarado Mensajes.USUARIO_REPETIDO. Si el registro no es exitoso porque las contrasenas no coinciden entonces se trata la excepcion ContraNoCoincideException y 
 se muestra el mensaje de error correspondiente al enumerado Mensajes.PASS_NO_COINCIDE. Si el registro no es exitoso porque alguno de los parametros requerido es 
 nulo, se trata la excecpcion ImposibleCrearEmpleadoException, y se muestra el mensaje de error correspondiente al enumerado Mensajes.PARAMETROS_NULOS 
 Si el registro es exitoso,se loguea al empleado en el sistema. Analogamente para el empleado pero utilizando 
 los datos correspondientes (nombre de usuario, contrasena, nombre real, tipo de persona y rubro).
 * */

public class TestExcepciones {

	Robot robot;
	Controlador controlador;
	FalseOptionPane op = new FalseOptionPane();

	public TestExcepciones() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
		}
	}

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
	public void TestContraNoCoincideException() {
		TestUtils.getDelay();
		JRadioButton RBEmpleador = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADOR);
		TestUtils.getDelay();

		TestUtils.clickComponent(RBEmpleador, robot);
		TestUtils.getDelay();

		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		TestUtils.clickComponent(username, robot);

		TestUtils.tipeaTexto("Guillermo2023", robot);

		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);

		TestUtils.clickComponent(password, robot);

		TestUtils.tipeaTexto("Adolfo123", robot);

		JTextField Rep_password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);

		TestUtils.clickComponent(Rep_password, robot);

		TestUtils.tipeaTexto("Adolfo", robot);
		JTextField RealName = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);

		TestUtils.clickComponent(RealName, robot);

		TestUtils.tipeaTexto("Guillermo", robot);
		JTextField Telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);

		TestUtils.clickComponent(Telefono, robot);

		TestUtils.tipeaTexto("2235546765", robot);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
		TestUtils.clickComponent(Registrar, robot);

		Assert.assertEquals("Los mensajes de respuesta no coinciden", Mensajes.PASS_NO_COINCIDE.getValor(),
				op.getMensaje());
	}

	@Test
	public void TestRegistroEmpleadorRepetidoException() {

		TestUtils.getDelay();
		JRadioButton RBEmpleador = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADOR);
		TestUtils.clickComponent(RBEmpleador, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		TestUtils.clickComponent(username, robot);

		TestUtils.tipeaTexto("Manudeserti", robot);

		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);

		TestUtils.clickComponent(password, robot);

		TestUtils.tipeaTexto("Manuel", robot);

		JTextField Rep_password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);

		TestUtils.clickComponent(Rep_password, robot);

		TestUtils.tipeaTexto("Manuel", robot);
		JTextField RealName = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);

		TestUtils.clickComponent(RealName, robot);

		TestUtils.tipeaTexto("1314542", robot);
		JTextField Telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);

		TestUtils.clickComponent(Telefono, robot);

		TestUtils.tipeaTexto("2235546765", robot);
		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
		TestUtils.clickComponent(Registrar, robot);
		TestUtils.getDelay();

		JButton cerrarSesion = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.CERRARSESION);
		TestUtils.getDelay();

		TestUtils.clickComponent(cerrarSesion, robot);
		TestUtils.getDelay();

		TestUtils.getDelay();
		JButton RegistrarLogin = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REGISTRAR);
		TestUtils.clickComponent(RegistrarLogin, robot);
		TestUtils.getDelay();

		TestUtils.getDelay();
		TestUtils.clickComponent(Registrar, robot);
		TestUtils.getDelay();

		Assert.assertEquals("Usuario repetido", Mensajes.USUARIO_REPETIDO.getValor(), op.getMensaje());

	}

	@Test
	public void TestRegistroEmpleadoRepetidoException() {

		TestUtils.getDelay();
		JRadioButton RBEmpleado = (JRadioButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.EMPLEADO);
		TestUtils.clickComponent(RBEmpleado, robot);
		JTextField username = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_USSER_NAME);
		TestUtils.clickComponent(username, robot);

		TestUtils.tipeaTexto("Manudeserti", robot);

		JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_PASSWORD);

		TestUtils.clickComponent(password, robot);

		TestUtils.tipeaTexto("Manuel", robot);

		JTextField Rep_password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_CONFIRM_PASSWORD);

		TestUtils.clickComponent(Rep_password, robot);

		TestUtils.tipeaTexto("Manuel", robot);
		JTextField RealName = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_REAL_NAME);

		TestUtils.clickComponent(RealName, robot);

		TestUtils.tipeaTexto("1314542", robot);
		JTextField Telefono = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_TELEFONO);

		TestUtils.clickComponent(Telefono, robot);

		TestUtils.tipeaTexto("2235546765", robot);

		JTextField Apellido = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_APELLIDO);

		TestUtils.clickComponent(Apellido, robot);

		TestUtils.tipeaTexto("Deserti", robot);

		JTextField Edad = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_EDAD);

		TestUtils.clickComponent(Edad, robot);

		TestUtils.tipeaTexto("23", robot);

		JButton Registrar = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REG_BUTTON_REGISTRAR);
		TestUtils.clickComponent(Registrar, robot);
		TestUtils.getDelay();

		JButton cerrarSesion = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.CERRARSESION);
		TestUtils.getDelay();

		TestUtils.clickComponent(cerrarSesion, robot);
		TestUtils.getDelay();

		TestUtils.getDelay();
		JButton RegistrarLogin = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(),
				Constantes.REGISTRAR);
		TestUtils.clickComponent(RegistrarLogin, robot);
		TestUtils.getDelay();

		TestUtils.getDelay();
		TestUtils.clickComponent(Registrar, robot);
		TestUtils.getDelay();

		Assert.assertEquals("Usuario repetido", Mensajes.USUARIO_REPETIDO.getValor(), op.getMensaje());
	}



}