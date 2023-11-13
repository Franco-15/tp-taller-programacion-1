package test.persistencia;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestAtributoPersistenciaNull.class, TestPersistenciaArchivoConDatos.class,
		TestPersistenciaArchivoNoExiste.class })
public class AllTests {

}
