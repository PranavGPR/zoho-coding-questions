package bowling;

public class Admin {
    private int ROUNDS = 2;
    private int CHANCES = 2;

    private String password = "admin";

    public int getRounds() {
        return ROUNDS;
    }

    public int getChances() {
        return CHANCES;
    }

    public void setRounds(String pass, int rounds) {
        if (pass == password) {
            ROUNDS = rounds;
        }
    }

    public void setChances(String pass, int chances) {
        if (pass == password) {
            CHANCES = chances;
        }
    }

    public String getPassword() {
        return password;
    }
}
