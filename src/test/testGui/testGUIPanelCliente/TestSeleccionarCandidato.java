package test.testGui.testGUIPanelCliente;


import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import bin.controlador.Controlador;
import excepciones.ImposibleModificarTicketsException;
import modeloDatos.ClientePuntaje;
import modeloDatos.EmpleadoPretenso;
import modeloDatos.Empleador;
import modeloNegocio.Agencia;
import test.testGui.FalseOptionPane;
import test.testGui.TestUtils;
import util.Constantes;
import vista.Ventana;

public class TestSeleccionarCandidato {
	Robot robot;
	Controlador controlador;
	FalseOptionPane op = new FalseOptionPane();
	Empleador empleador;
	EmpleadoPretenso empleado;
	ClientePuntaje clientePuntaje;
	
	public TestSeleccionarCandidato() {
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
			empleado = new EmpleadoPretenso("messi","1234","jose","jose","jose",10);
			clientePuntaje = new ClientePuntaje(10, empleado);
			ArrayList<ClientePuntaje> listaPostulantes = new ArrayList<ClientePuntaje>();
			listaPostulantes.add(clientePuntaje);
			empleador.setListaDePostulantes(listaPostulantes);
			Agencia.getInstance().getEmpleadores().put("Manueldeserti", empleador);
			Agencia.getInstance().getEmpleados().put("messi", empleado);

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
	
//	El bot�n SELECCIONAR_CANDIDATO invoca al m�todo seleccionar candidato de la clase Controlador.
	@Test
	public void testSeleccionarCandidato(){
		JList<ClientePuntaje> lista = (JList<ClientePuntaje>) TestUtils.getComponentForName((Ventana) controlador.getVista(),
                Constantes.LISTA_CANDIDATOS);
		TestUtils.getDelay();
        TestUtils.clickComponent(lista, robot);
        TestUtils.getDelay();
        JButton selCandidato = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.SELECCIONAR_CANDIDATO);
        TestUtils.clickComponent(selCandidato, robot);
        TestUtils.getDelay();
        Assert.assertEquals(empleado.toString(),op.getMensaje());

	}
}