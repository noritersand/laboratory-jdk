package laboratory.test.java.lang;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassTest {
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(ClassTest.class);
	
	@Test
	public void testGetClassName() {
		Assert.assertEquals("laboratory.test.java.lang.ClassTest", ClassTest.class.getName());
	}
	
	@Test
	public void testGetPackageName() {
		Assert.assertEquals("laboratory.test.java.lang", ClassTest.class.getPackage().getName());
	}
}