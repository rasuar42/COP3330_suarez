public class Encrypter {

    public static String encrypt(String input)
    {
        String output = "";
        int temp;

        for(int i = 0; i < input.length(); i++)
        {
            temp = Character.getNumericValue(input.charAt(i));
            temp += 7;
            temp = temp%10;
            output+=temp;
        }
        output = switchNumbers(output);

        return output;
    }

    private static String switchNumbers(String str)
    {
        char s1 = str.charAt(0);
        char s2 = str.charAt(1);
        char s3 = str.charAt(2);
        char s4 = str.charAt(3);

        return ""+s3+s4+s1+s2;
    }
}
