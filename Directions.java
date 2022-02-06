public class Directions {
    public static void main(String[] args) {
        String[] strArr = new String[] { "LEFT", "FORWARD", "BACKWARD", "RIGHT", "BACKWARD", "FORWARD" };
        String[] finalArr = new String[10];

        int len = strArr.length;
        int x = 0, y = 0;

        for (int i = 0; i < len; i++) {
            switch (strArr[i]) {
                case "LEFT":
                    x++;
                    break;
                case "RIGHT":
                    x--;
                    break;
                case "FORWARD":
                    y++;
                    break;
                case "BACKWARD":
                    y--;
                    break;
            }
        }

        for (int i = 0; i < len; i++) {
            if (x > 0) {
                finalArr[i] = "LEFT";
                x--;
            } else if (y > 0) {
                finalArr[i] = "FORWARD";
                y--;
            } else if (x < 0) {
                finalArr[i] = "RIGHT";
                x++;
            } else if (y < 0) {
                finalArr[i] = "BACKWARD";
                y++;
            } else {
                continue;
            }
        }

        for (int i = 0; i < finalArr.length; i++) {
            if (finalArr[i] == null) {
                continue;
            }
            System.out.println(finalArr[i]);
        }
    }
}
