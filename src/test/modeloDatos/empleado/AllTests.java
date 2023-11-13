package test.modeloDatos.empleado;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCalculoComisionEscenario1.class, TestCalculoComisionEscenario2.class, TestEmpleadoPretenso.class,
		TestGettersSetters.class })
public class AllTests {

}
