package minitest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JunitTest {
	
	@Test
	public void testAppiConnection(){
		assertEquals(200, ApiConnection.connectApi());
	}
	
}
