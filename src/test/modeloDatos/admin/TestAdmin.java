package test.modeloDatos.admin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import modeloDatos.Admin;


public class TestAdmin {
	
	private Admin admin;

	@Before
	public void setUp() throws Exception {
		admin = new Admin();
	}

	@Test
	public void test_admin_valores_no_vacios() {
		this.admin.setUsserName("Messi10");
		this.admin.setPassword("1234");
		this.admin.setRealName("Jose");
		this.admin.setTelefono("22344441111");
		
		Assert.assertSame("El nombre de usuario no coincide", "Messi10", this.admin.getUsserName());
		Assert.assertSame("El password no coincide", "1234", this.admin.getPassword());
		Assert.assertSame("El nombre real no coincide", "Jose", this.admin.getRealName());
		Assert.assertSame("El telefono no coincide", "22344441111", this.admin.getTelefono());
	}
	
	@Test
	public void test_admin_valores_vacios() {
		this.admin.setUsserName("");
		this.admin.setPassword("");
		this.admin.setRealName("");
		this.admin.setTelefono("");
		
		Assert.assertSame("El nombre de usuario no coincide", "", this.admin.getUsserName());
		Assert.assertSame("El password no coincide", "", this.admin.getPassword());
		Assert.assertSame("El nombre real no coincide", "", this.admin.getRealName());
		Assert.assertSame("El telefono no coincide", "", this.admin.getTelefono());
	}

}