package laboratory.util.json;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

/**
 * 커스텀 TypeAdeptor가 선언된 GsonBuilder 테스트
 *  
 * @author fixalot
 * @since 2017-12-01
 */
public class GsonBuilderTest {
	private static final Logger logger = LoggerFactory.getLogger(GsonBuilderTest.class);
	
	@Test
	public void testFromJsonForPlainObject() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.getGson();
		GsonTestModel convertedModel = gson.fromJson(makeJsonObjectText(), GsonTestModel.class);
		Assert.assertNull(convertedModel.getCharValue());
		Assert.assertEquals("", convertedModel.getStringValue());
		Assert.assertNull(convertedModel.getShortValue());
		Assert.assertNull(convertedModel.getIntValue());
		Assert.assertNull(convertedModel.getLongValue());
		Assert.assertNull(convertedModel.getDoubleValue());
		Assert.assertNull(convertedModel.getBigDecimalValue());
		Assert.assertNull(convertedModel.getBoolValue());
	}

	@Test
	public void testFromJsonForArray() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.getGson();
		GsonTestModel[] convertedModel = gson.fromJson(makeJsonArrayText(), GsonTestModel[].class);
		logger.debug(Arrays.toString(convertedModel));
	}
	
	@Test
	public void testFromJsonForArrayInArray() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.getGson();
		GsonTestModel[] convertedModel = gson.fromJson(makeJsonArrayInArrayText(), GsonTestModel[].class);
		logger.debug(Arrays.toString(convertedModel));
	}
	
	@Test
	public void testFromJsonForArrayInArrayToList() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.getGson();
		
		@SuppressWarnings("serial")
		List<GsonTestModel> convertedModelList = gson.fromJson(makeJsonArrayInArrayText(), new TypeToken<ArrayList<GsonTestModel>>() {}.getType());
		
		GsonTestChild[] convertedModel = convertedModelList.get(0).getGsonTestChild();
		Assert.assertTrue(convertedModel.length == 1);
		Assert.assertEquals(GsonTestChild[].class, convertedModel.getClass());
		
		GsonTestChild gsonTestChild = convertedModel[0];
		Assert.assertEquals("1", gsonTestChild.getA());
		Assert.assertEquals("2", gsonTestChild.getB());
	}

	public String makeJsonObjectText() {
		StringBuilder sb = new StringBuilder()
				.append("{")
				.append("\"stringValue\":\"\"")
				.append(",").append("\"imAlone\":\"\"")
				.append(",").append("\"charValue\":\"\"")
				.append(",").append("\"shortValue\":\"\"")
				.append(",").append("\"intValue\":\"\"")
				.append(",").append("\"longValue\":\"\"")
				.append(",").append("\"doubleValue\":\"\"")
				.append(",").append("\"bigDecimalValue\":\"\"")
				.append(",").append("\"boolValue\":\"\"")
//				.append(",").append("\"dateValue\":\"1999-01-01\"")
				.append("}");
		String text = sb.toString();
		logger.debug("text: " + text);
		return text;
	}

	public String makeJsonArrayText() {
		StringBuilder sb = new StringBuilder()
				.append("[")
				.append("{")
				.append("\"stringValue\":\"\"")
				.append(",").append("\"charValue\":\"\"")
				.append(",").append("\"shortValue\":\"\"")
				.append(",").append("\"intValue\":\"\"")
				.append(",").append("\"longValue\":\"\"")
				.append(",").append("\"doubleValue\":\"\"")
				.append(",").append("\"bigDecimalValue\":\"\"")
				.append(",").append("\"boolValue\":\"\"")
//				.append(",").append("\"dateValue\":\"\"")
				.append("}")
				.append("]");
		String text = sb.toString();
		logger.debug("text: " + text);
		return text;
	}
	
	public String makeJsonArrayInArrayText() {
		StringBuilder sb = new StringBuilder()
				.append("[")
				.append("{")
				.append("\"stringValue\":\"\"")
				.append(",").append("\"charValue\":\"\"")
				.append(",").append("\"shortValue\":\"\"")
				.append(",").append("\"intValue\":\"\"")
				.append(",").append("\"longValue\":\"\"")
				.append(",").append("\"doubleValue\":\"\"")
				.append(",").append("\"bigDecimalValue\":\"\"")
				.append(",").append("\"boolValue\":\"\"")
				.append(",").append("\"gsonTestChild\": [{ \"a\":\"1\", \"b\":\"2\" }]")
				.append("}")
				.append("]");
		String text = sb.toString();
		logger.debug("text: " + text);
		return text;
	}
	
	@SuppressWarnings("unused")
	private class GsonTestModel {
		private Character charValue;
		private String stringValue;
		private Short shortValue;
		private Integer intValue;
		private Long longValue;
		private Double doubleValue;
		private BigDecimal bigDecimalValue;
		private Boolean boolValue;
		private Date dateValue;
		
		private GsonTestChild[] gsonTestChild;
		
		public GsonTestChild[] getGsonTestChild() {
			return gsonTestChild;
		}

		public void setGsonTestChild(GsonTestChild[] gsonTestChild) {
			this.gsonTestChild = gsonTestChild;
		}

		public Date getDateValue() {
			return dateValue;
		}

		public void setDateValue(Date dateValue) {
			this.dateValue = dateValue;
		}

		public Character getCharValue() {
			return charValue;
		}

		public void setCharValue(Character charValue) {
			this.charValue = charValue;
		}

		public String getStringValue() {
			return stringValue;
		}

		public void setStringValue(String stringValue) {
			this.stringValue = stringValue;
		}

		public Short getShortValue() {
			return shortValue;
		}

		public void setShortValue(Short shortValue) {
			this.shortValue = shortValue;
		}

		public Integer getIntValue() {
			return intValue;
		}

		public void setIntValue(Integer intValue) {
			this.intValue = intValue;
		}

		public Long getLongValue() {
			return longValue;
		}

		public void setLongValue(Long longValue) {
			this.longValue = longValue;
		}

		public Double getDoubleValue() {
			return doubleValue;
		}

		public void setDoubleValue(Double doubleValue) {
			this.doubleValue = doubleValue;
		}

		public BigDecimal getBigDecimalValue() {
			return bigDecimalValue;
		}

		public void setBigDecimalValue(BigDecimal bigDecimalValue) {
			this.bigDecimalValue = bigDecimalValue;
		}

		public Boolean getBoolValue() {
			return boolValue;
		}

		public void setBoolValue(Boolean boolValue) {
			this.boolValue = boolValue;
		}

		@Override
		public String toString() {
			Class<?> clazz = this.getClass();
			Field[] fields = clazz.getDeclaredFields();
			StringBuilder returnString = new StringBuilder();
			for (Field field : fields) {
				field.setAccessible(true);
				try {
//					if (null == field.get(this)) {
//						continue; // 값이 없을 때 출력하지 않음
//					}
					returnString.append(field.getName());
					returnString.append(" = ");
					returnString.append(field.get(this));
				} catch (IllegalArgumentException e) {
					returnString.append("IllegalArgumentException occured!!");
					returnString.append(e.toString());
				} catch (IllegalAccessException e) {
					returnString.append("IllegalAccessException occured!!");
					returnString.append(e.toString());
				}
				returnString.append(";\n");
			}
			return returnString.toString();
		}
	}

	@SuppressWarnings("unused")
	private class GsonTestChild {
		private String a;
		private String b;

		public String getA() {
			return a;
		}

		public void setA(String a) {
			this.a = a;
		}

		public String getB() {
			return b;
		}

		public void setB(String b) {
			this.b = b;
		}
	}

}

