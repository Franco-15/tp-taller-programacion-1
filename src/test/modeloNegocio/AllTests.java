package test.modeloNegocio;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ agenciaCrearTicketTest.class, agenciaEliminarTicketTest.class, agenciaLoginTest.class,
		agenciaMatchTest.class, agenciaRegistroTest.class, agenciaSetLimitesRenumeracionTest.class })
public class AllTests {

}
