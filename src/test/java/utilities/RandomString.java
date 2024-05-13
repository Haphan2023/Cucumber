package ulitities;

import java.util.Random;

public class RandomString {
    public static void main(String[] args) {
        String email = "ha" + generateRandomString(5) +"@gmail.com";
        System.out.println(email);
    }

    public static String generateRandomString(int length){
        String character ="cagefajhgjfrhfgahdgdgdjkzzcxfdyfgkDSAERYJJHGF";
        Random random = new Random();
        if (length < 1) throw new IllegalArgumentException("Length must be positive");
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(character.length());
            sb.append(character.charAt(randomIndex));
        }
        return sb.toString();

    }
}
