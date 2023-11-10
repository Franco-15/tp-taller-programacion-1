package TestGui;

import controlador.Controlador;
import vista.Ventana;
import java.awt.AWTException;
import java.awt.Robot;
import javax.swing.JButton;
import javax.swing.JTextField;
import util.Constantes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestLogin {
    Robot robot;
    Controlador controlador;

    public TestLogin()
    {
        try
        {
            robot = new Robot();
        } catch (AWTException e)
        {
        }
    }

    @Before
    public void setUp() throws Exception
    {
        controlador = new Controlador();
        controlador.setVista(new Ventana(controlador));
    }

    @Test
    public void testRegSoloNombre()
    {
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.NOMBRE_USUARIO);
        JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.LOGIN);
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("holajfgjfgjfgjfgjfgjfgjfgjfgjfgjfgjgfjfgjfgjfgjfgjfgj", robot);
        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarLog.isEnabled());
    }

    @Test
    public void testRegSoloPassword()
    {
        robot.delay(TestUtils.getDelay());
        JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.PASSWORD);
        JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.LOGIN);
        TestUtils.clickComponent(password, robot);
        TestUtils.tipeaTexto("holajfgjfgjfgjfgjfgjfgjfgjfgjfgjfgjgfjfgjfgjfgjfgjfgj", robot);
        Assert.assertFalse("El boton de registro deberia estar deshablitado", aceptarLog.isEnabled());
    }

    @Test
    public void testRegNombreYPassword()
    {
        robot.delay(TestUtils.getDelay());
        JTextField nombre = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.NOMBRE_USUARIO);
        JTextField password = (JTextField) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.PASSWORD);
        JButton aceptarLog = (JButton) TestUtils.getComponentForName((Ventana) controlador.getVista(), Constantes.LOGIN);
        TestUtils.clickComponent(nombre, robot);
        TestUtils.tipeaTexto("holajfgjfgjfgjfgjfgjfgjfgjfgjfgjfgjgfjfgjfgjfgjfgjfgj", robot);
        TestUtils.clickComponent(password, robot);
        TestUtils.tipeaTexto("holajfgjfgjfgjfgjfgjfgjfgjfgjfgjfgjgfjfgjfgjfgjfgjfgj", robot);
        Assert.assertTrue("El boton de registro deberia estar hablitado", aceptarLog.isEnabled());
    }

}
