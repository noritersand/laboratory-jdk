package jdk.java.math;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @since 2018-01-23
 * @author fixalot
 */
public class MathTest {
//	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(MathTest.class);

	@Test
	public void test() {
		logger.debug("{}", Math.random());
	}

	@Test
	public void testAbs() {
		Assert.assertEquals(0, Math.abs(1000 / 1333));
		Assert.assertEquals(1, Math.abs(1333 / 1333));
		Assert.assertEquals(1, Math.abs(1334 / 1333));
		Assert.assertEquals(1, Math.abs(2665 / 1333));
		Assert.assertEquals(2, Math.abs(2666 / 1333));
		Assert.assertEquals(2, Math.abs(2667 / 1333));
	}
}
