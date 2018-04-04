package org.eclipse.iot.unide.integrators;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.apache.camel.Exchange;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.eclipse.iot.unide.ppmp.process.Measurements;
// import org.springframework.test.context.ContextConfiguration;
import org.eclipse.iot.unide.ppmp.process.Process.Result;
import org.eclipse.iot.unide.ppmp.process.ProcessWrapper;
import org.junit.After;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KistlerLogTest extends CamelSpringTestSupport {

	private ObjectMapper mapper;
	private static String transformedPayload = "{\"content-spec\":\"urn:spec://eclipse.org/unide/process-message#v2\",\"device\":{\"deviceID\":\"KP_Force1\"},\"measurements\":[{\"ts\":\"2018-03-27T16:27:11.651+02:00\",\"series\":{\"x\":[9.452E-5,0.0121,0.0241,0.03611,0.04811,0.06012,0.07212,0.08413,0.09613,0.1081,0.1201,0.1321,0.1441,0.1562,0.1682,0.1802,0.1922,0.2042,0.2162,0.2282,0.2402,0.2522,0.2642,0.2762,0.2882,0.3002,0.3122,0.3242,0.3362,0.3482,0.3602,0.3722,0.3842,0.3962,0.4082,0.4202,0.4323,0.4443,0.4563,0.4683,0.4803,0.4923,0.5043,0.5163,0.5283,0.5403,0.5523,0.5643,0.5763,0.5883,0.6003,0.6123,0.6243,0.6363,0.6483,0.6603,0.6723,0.6843,0.6964,0.7084,0.7204,0.7324,0.7444,0.7564,0.7684,0.7804,0.7924,0.8044,0.8164,0.8284,0.8404,0.8524,0.8644,0.8764,0.8884,0.9004,0.9124,0.9244,0.9364,0.9484,0.9604,0.9725,0.9845,0.9965,1.008,1.02,1.032,1.044,1.056,1.068,1.08,1.092,1.105,1.117,1.129,1.141,1.153,1.165,1.177,1.189,1.201,1.213,1.225,1.237,1.249,1.261,1.273,1.285,1.297,1.309,1.321,1.333,1.345,1.357,1.369,1.381,1.393,1.405,1.417,1.429,1.441,1.453,1.465,1.477,1.489,1.501,1.513,1.525,1.537,1.549,1.561,1.573,1.585,1.597,1.609,1.621,1.633,1.645,1.657,1.669,1.681,1.693,1.705,1.717,1.729,1.741,1.753,1.765,1.777,1.789,1.801,1.813,1.825,1.837,1.849,1.861,1.873,1.885,1.897,1.909,1.921,1.933,1.945,1.957,1.969,1.981,1.993,2.005,2.017,2.029,2.041,2.053,2.065,2.077,2.089,2.101,2.113,2.125,2.137,2.149,2.161,2.173,2.185,2.197,2.209,2.221,2.233,2.245,2.257,2.269,2.281,2.293,2.305,2.317,2.329,2.341,2.353,2.365,2.377,2.389,2.401,2.413,2.425,2.437,2.449,2.461,2.473,2.485,2.497,2.509,2.521,2.533,2.545,2.557,2.569,2.581,2.593,2.605,2.617,2.629,2.641,2.653,2.665,2.677,2.689,2.701,2.713,2.725,2.737,2.749,2.761,2.773,2.785,2.797,2.809,2.821,2.833,2.845,2.857,2.869,2.881,2.893,2.905,2.917,2.929,2.941,2.953,2.965,2.977,2.989,3.001,3.013,3.025,3.037,3.049,3.061,3.073,3.085,3.097,3.109,3.121,3.133,3.145,3.157,3.169,3.181,3.193,3.205,3.217,3.229,3.241,3.253,3.265,3.277,3.289,3.301,3.313,3.325,3.337,3.349,3.361,3.373,3.385,3.397,3.409,3.421,3.433,3.445,3.457,3.469,3.481,3.493,3.505,3.517,3.529,3.541,3.553,3.565,3.577,3.589,3.601,3.613,3.625,3.637,3.649,3.661,3.673,3.685,3.697,3.709,3.721,3.733,3.745,3.757,3.769,3.781,3.793,3.805,3.818,3.83,3.842,3.854,3.866,3.878,3.89,3.902,3.914,3.926,3.938,3.95,3.962,3.974,3.986,3.998,4.01,4.022,4.034,4.046,4.058,4.07,4.082,4.094,4.106,4.118,4.13,4.142,4.154,4.166,4.178,4.19,4.193,4.194],\"y\":[0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.1026,0.3077,0.5641,1.154,1.667,2.667,3.179,3.949,4.538,5.103,6.256,6.359,7.0,7.333,7.436,7.487,7.256,7.0,6.846,6.744,6.692,6.641,6.59,6.59,6.59,6.615,7.282,7.0,7.051,7.077,7.103,7.179,7.179,7.205,7.256,7.282,7.308,7.333,7.359,7.359,7.41,7.41,7.436,7.487,7.462,7.487,7.513,7.513,7.538,7.538,7.564,7.564,7.564,7.564,7.564,7.564,7.564,7.564,7.59,7.59,7.615,7.615,7.641,7.641,7.667,7.692,7.718,7.744,7.795,7.846,7.897,7.923,7.974,8.0,8.026,8.026,8.026,8.051,8.051,8.077,8.103,8.128,8.128,8.154,8.179,8.205,8.231,8.256,8.282,8.308,8.333,8.385,8.385,8.436,8.462,8.462,8.513,8.513,8.538,8.538,8.538,8.538,8.538,8.564,8.538,8.538,8.564,8.564,8.59,8.564,8.59,8.564,8.564,8.564,8.538,8.564,8.538,8.564,8.564,8.564,8.59,8.564,8.564,8.564,8.564,8.564,8.564,8.564,8.564,8.564,8.59,8.564,8.59,8.564,8.59,8.564,8.564,8.564,8.564,8.59,8.564,8.59,8.59,8.59,8.615,8.59,8.615,8.59,8.59,8.615,8.59,8.615,8.615,8.641,8.641,8.615,8.641,8.615,8.641,8.615,8.641,8.667,8.641,8.667,8.667,8.667,8.692,8.692,8.718,8.718,8.718,8.692,8.692,8.718,8.692,8.692,8.692,8.667,8.667,8.641,8.667,8.641,8.641,8.641,8.615,8.641,8.615,8.641,8.59,8.615,8.641,8.59,8.615,8.615,8.615,8.641,9.308,10.21,11.21,12.28,13.44,14.59,15.72,16.36,16.46,16.46]}}],\"process\":{\"ts\":\"2018-03-27T16:27:11.651+02:00\",\"result\":\"OK\"}}";
	
	public KistlerLogTest() {
		super();
		mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		mapper.setSerializationInclusion(Include.NON_NULL);
	}

	@After
	public void cleanup() {
		deleteDirectory(".filestore.dat"); // also deletes files
	}

	@Test
	public void testReadFiles() throws Exception {
		// mock.expectedMessageCount(1);
		// template.sendBodyAndHeader("https://localhost:" + port + "/test",
		// expectedBody, "Content-Type", "application/xml");
		Exchange exchange = consumer.receive("direct:nextRoute", 5000);
		
		assertNotNull(exchange);
		
		// testing one-by-one
		String filename = exchange.getMessage().getHeader(Exchange.FILE_NAME, String.class);
		ProcessWrapper wrapper = exchange.getMessage().getBody(ProcessWrapper.class);
		String deviceId = wrapper.getDevice().getDeviceID();
		Result result = wrapper.getProcess().getResult();
		List<Measurements> measurementsList = wrapper.getMeasurements();
		Measurements measurements = measurementsList.get(0);
		OffsetDateTime odt = OffsetDateTime.now();
		ZoneOffset localTimezoneOffset = odt.getOffset();
		Date d = exchange.getMessage().getHeader("CamelFileLastModified", Date.class);
		OffsetDateTime fileTs = OffsetDateTime.ofInstant(d.toInstant(), localTimezoneOffset);
		
		
		assertEquals("00000855.html", filename);
		assertEquals("KP_Force1", deviceId);
		assertEquals(Result.OK, result);
		assertEquals(1, measurementsList.size());
		assertNotNull(measurements.getTimestamp());
		assertEquals(352, measurements.getSeriesMap().getSeries().get("x").size());
		assertEquals(352, measurements.getSeriesMap().getSeries().get("y").size());
		assertEquals(fileTs, measurements.getTimestamp());
		assertEquals(fileTs, wrapper.getProcess().getTimestamp());
		
		// testing all at once, overwriting dynamic timestamp
		OffsetDateTime fdt = OffsetDateTime.parse("2018-03-27T16:27:11.651+02:00");
		measurements.setTimestamp(fdt);
		wrapper.getProcess().setTimestamp(fdt);
		assertEquals(transformedPayload, mapper.writeValueAsString(wrapper));
		
		consumer.doneUoW(exchange);
		consumer.stop();
	}

	@Override
	protected ClassPathXmlApplicationContext createApplicationContext() {
		return new ClassPathXmlApplicationContext("kistlerlog.xml");
	}
}
