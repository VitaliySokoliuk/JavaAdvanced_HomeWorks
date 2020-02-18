package org.example;

import org.junit.*;

public class CalculationTest {

    private Calculation calculation;

    @BeforeClass
    public static void bef(){
        System.out.println("Before class");
    }

    @AfterClass
    public static void aft(){
        System.out.println("After class");
    }


    @Before
    public void setUp() {
        calculation = new Calculation(10, 40, 2, 2, 1, 50);
        System.out.println("Before test");
    }

    @After
    public void tearDown(){
        calculation = null;
        System.out.println("After test");
    }

    @Test
    public void testBonus() {
        int actual = calculation.bonus();
        int expected = 100;
        Assert.assertEquals(actual, expected);
        System.out.println("Test 'testBonus'");
    }

    @Test(expected = Exception.class)
    public void testSalaryEx() throws Exception {
        calculation.setPaymentPerHour(-5);
        calculation.salary();
        System.out.println("Test 'testSalaryEx'");
    }

    @Test
    public void testSalary() throws Exception {
        int actual = calculation.salary();
        int expected = 400;
        Assert.assertEquals(actual, expected);
        System.out.println("Test 'testSalary'");
    }

    @Test
    public void testPaymentPerDay() {
        int actual = calculation.paymentPerDay();
        int expected = 80;
        Assert.assertEquals(actual, expected);
        System.out.println("Test 'testPaymentPerDay'");
    }

    @Test
    public void testMedicalBill() {
        int actual = calculation.medicalBill();
        int expected = 80;
        Assert.assertEquals(actual, expected);
        System.out.println("Test 'testMedicalBill'");
    }

    @Test
    public void testSummary() throws Exception {
        int actual = calculation.summary();
        int expected = 580;
        Assert.assertEquals(actual, expected);
        System.out.println("Test 'testSummary'");
    }
}
