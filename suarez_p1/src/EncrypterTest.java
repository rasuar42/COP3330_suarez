import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EncrypterTest {

    @Test
    public void Case1()
    {
        String encrypted = Encrypter.encrypt("1234");
        assertEquals("0189", encrypted);
    }

    @Test
    public void Case2()
    {
        String decrypted = Decrypter.decrypt("0189");
        assertEquals("1234", decrypted);
    }

}