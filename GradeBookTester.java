import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	
	GradeBook g1;
	GradeBook g2;

	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g1.addScore(70);
		g1.addScore(79);
		g1.addScore(82);
		
		
		g2 = new GradeBook(5);
		g2.addScore(86.7);
		g2.addScore(97.2);
		g2.addScore(94.1);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		g1 = null;
		g2 = null;
	}

	@Test
	void testaddScore() {
		
		assertTrue(g1.toString().equals("70.0 79.0 82.0 "));
		assertTrue(g2.toString().equals("86.7 97.2 94.1 "));
		
		assertEquals(3,g1.getScoreSize());
		assertEquals(3,g2.getScoreSize());
	}
	
	@Test
	void testSum() {
		assertEquals(231,g1.sum(),0.0001);
		assertEquals(278,g2.sum(),0.0001);
	}
	
	@Test
	void testMinimum() {
		assertEquals(70,g1.minimum(),0.001);
		assertEquals(86.7,g2.minimum(),0.001);
	}
	
	@Test
	void testFinalScore() {
		assertEquals(161,g1.finalScore(),0.001);
		assertEquals(191.3,g2.finalScore(),0.001);
	}
	
	@Test
	void testGetScoreSize() {
		assertTrue(g1.getScoreSize() == 3);
		assertTrue(g2.getScoreSize() == 3);
	}
	
	@Test
	void testToString() {
		assertTrue(g1.toString().equals("70.0 79.0 82.0 "));
		assertTrue(g2.toString().equals("86.7 97.2 94.1 "));
	}

}
