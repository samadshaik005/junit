package com.bharaththippireddy.mockito.mockitoargumenttypes;

import static org.mockito.Matchers.anyDouble;
import static org.mockito.Matchers.anyFloat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ArgumentBOClassTest {

	private static final double DOUBLE_INPUT = 3.3;

	private static final float FLOAT_INPUT = 2.2F;

	private static final int INT_INPUT = 1;

	private static final double PRIMITIVE_RESULT = 6.5;

	private static final int OBJECT_RESULT = 1;

	@Mock
	ArgumentDAOClass dao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testPrimitiveMethod() {

		ArgumentBOClass bo = new ArgumentBOClass(dao);
		when(dao.primitiveMethod(anyInt(), anyFloat(), anyDouble()))
				.thenReturn(PRIMITIVE_RESULT);
		Assert.assertEquals(
				bo.primitiveMethod(INT_INPUT, FLOAT_INPUT, DOUBLE_INPUT),
				PRIMITIVE_RESULT, 0);
	}

	@Test
	public void testPrimitiveMethod_exactvalues() {

		ArgumentBOClass bo = new ArgumentBOClass(dao);
		when(dao.primitiveMethod(INT_INPUT, FLOAT_INPUT, DOUBLE_INPUT))
				.thenReturn(PRIMITIVE_RESULT);
		Assert.assertEquals(
				bo.primitiveMethod(INT_INPUT, FLOAT_INPUT, DOUBLE_INPUT),
				PRIMITIVE_RESULT, 0);
		Mockito.verify(dao).primitiveMethod(INT_INPUT, FLOAT_INPUT,
				DOUBLE_INPUT);
	}

	@Test
	public void testObectMethod() {

		ArgumentBOClass bo = new ArgumentBOClass(dao);
		when(dao.objectMethod(any(ParamObject.class))).thenReturn(1);
		Assert.assertEquals(bo.objectMethod(new ParamObject()), OBJECT_RESULT,
				0);
	}

	@Test
	public void testObectMethod_exactObject() {

		ParamObject object = new ParamObject();
		ArgumentBOClass bo = new ArgumentBOClass(dao);
		when(dao.objectMethod(object)).thenReturn(1);
		Assert.assertEquals(bo.objectMethod(object), OBJECT_RESULT, 0);
	}
}
