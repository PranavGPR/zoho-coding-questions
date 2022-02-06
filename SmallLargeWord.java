public class SmallLargeWord {
    public static void main(String[] args) {
        String str = "Our example paragraph will be about human misconceptions of piranhas. Step 1. Decide on a controlling idea and create a topic sentence. Paragraph development";
        String word = "", small = "", large = "";
        String[] words = new String[100];
        int length = 0;

        str = str + " ";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                word += str.charAt(i);
            } else {
                words[length] = word;
                length++;
                word = "";
            }
        }

        small = large = words[0];

        for (int k = 0; k < length; k++) {
            if (small.length() > words[k].length())
                small = words[k];

            if (large.length() < words[k].length())
                large = words[k];
        }

        System.out.println("Largest Word: " + large);
        System.out.println("Smallest Word: " + small);
    }
}
