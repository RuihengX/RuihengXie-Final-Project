package pkgUT;

import static org.junit.Assert.*;
import org.apache.poi.ss.formula.functions.*;
import org.junit.Test;

public class TestPMT {

	@Test
	public void test1() {
		double PMT;
		double r = 0.1 / 12;
		double n = 20 * 12;
		double p = 200000;
		double f = 0;
		boolean t = false;
		PMT = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		
		double PMTExpected = 1930.04;
		
		assertEquals(PMTExpected, PMT, 0.01);
		}
	
	@Test
	public void test2() {
		double PMT;
		double r = 0.03 / 12;
		double n = 50 * 12;
		double p = 250000;
		double f = 0;
		boolean t = false;
		PMT = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		
		double PMTExpected = 804.94;
		
		assertEquals(PMTExpected, PMT, 0.01);
	}
	
}

 

