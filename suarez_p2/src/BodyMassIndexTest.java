import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    //BMI Calculation
    @Test
    public void bmiTest() {
        BodyMassIndex test = new BodyMassIndex(64, 150);
        assertEquals(25.7, test.calcBMI());
    }

    //Category Tests
    @Test
    public void underweight() {
        BodyMassIndex test = new BodyMassIndex(64, 100);
        assertEquals("Underweight",test.categorize());
    }
    @Test
    public void normalWeight() {
        BodyMassIndex test = new BodyMassIndex(64, 120);
        assertEquals("Normal Weight",test.categorize());
    }
    @Test
    public void overweight() {
        BodyMassIndex test = new BodyMassIndex(64, 150);
        assertEquals("Overweight",test.categorize());
    }
    @Test
    public void obese() {
        BodyMassIndex test = new BodyMassIndex(64, 190);
        assertEquals("Obesity",test.categorize());
    }



}