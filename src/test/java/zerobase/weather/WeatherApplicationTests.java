package zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class WeatherApplicationTests {

	@Test
	void equalTest() {
		//given
		//when
		int a = 1;
		int b = 1;
		assertEquals(a, b);
	}

	@Test
	void nullTest() {
		//given
		//when
		assertNull(null);
	}

	@Test
	void trueTest() {
		//given
		//when
		assertTrue(1 == 1);
	}

}
