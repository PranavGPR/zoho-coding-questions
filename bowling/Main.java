package bowling;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Admin admin = new Admin();

    public static int[][][] game(ArrayList<String> players) {
        int[][][] points = new int[admin.getRounds()][players.size()][admin.getChances()];
        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("Game started");
        System.out.println("---------------------");
        for (int k = 0; k < admin.getRounds(); k++) {
            System.out.println("---------------------");
            System.out.println("Round " + (k + 1));
            System.out.println("---------------------");
            for (int i = 0; i < players.size(); i++) {
                int pins = 10;
                System.out.println("---------------------");
                System.out.println("Chances of Player " + players.get(i));
                System.out.println("---------------------");
                for (int j = 0; j < admin.getChances(); j++) {
                    System.out.println("Enter the number of pins took down by " + players.get(i) + ": ");
                    int temp = sc.nextInt();

                    if (temp > pins || temp < 0) {
                        System.out.println("There are only " + pins + " pins placed. Enter a valid number: ");
                        int validInput = sc.nextInt();
                        points[k][i][j] += validInput;
                        pins -= validInput;

                        if (pins == 0) {
                            if (j == 0) {
                                System.out.println("STRIKE!!!");
                                points[k][i][j] += 10;
                            }
                            if (j == 1) {
                                System.out.println("SPARE!!!");
                                points[k][i][j] += 5;
                            }
                            if (k == admin.getRounds() - 1) {
                                pins = 10;
                                System.out.println(
                                        "You've got 2 extra balls to serve " + players.get(i) + ". Play it wisely...");
                                for (int e = 0; e < 2; e++) {
                                    System.out
                                            .println("Enter the number of pins took down by " + players.get(i) + ": ");
                                    int extra = sc.nextInt();
                                    if (extra > pins || extra < 0) {
                                        System.out.println("There are only 10 pins placed. Enter a valid number: ");
                                        points[k][i][j] += sc.nextInt();
                                        pins -= extra;
                                        System.out.println("There are " + pins + " pins left to take out");
                                    } else {
                                        points[k][i][j] += extra;
                                        pins -= extra;
                                        System.out.println("There are " + pins + " pins left to take out");
                                    }
                                }
                            }
                            System.out.println("There are " + pins + " pins left to take out");
                        }
                    } else {
                        points[k][i][j] += temp;
                        pins -= temp;
                        System.out.println("There are " + pins + " pins left to take out");

                        if (pins == 0) {
                            if (j == 0) {
                                System.out.println("STRIKE!!!");
                                points[k][i][j] += 10;
                            }
                            if (j == 1) {
                                System.out.println("SPARE!!!");
                                points[k][i][j] += 5;
                            }
                            if (k == admin.getRounds() - 1) {
                                System.out.println(
                                        "You've got 2 extra balls to serve " + players.get(i)
                                                + ". Play it wisely...");
                                pins = 10;
                                for (int e = 0; e < 2; e++) {
                                    System.out.println(
                                            "Enter the number of pins took down by " + players.get(i) + ": ");
                                    int extra = sc.nextInt();
                                    if (extra > pins || extra < 0) {
                                        System.out.println("There are only 10 pins placed. Enter a valid number: ");
                                        points[k][i][j] += sc.nextInt();
                                        pins -= extra;
                                        System.out.println("There are " + pins + " pins left to take out");
                                    } else {
                                        points[k][i][j] += extra;
                                        pins -= extra;
                                        System.out.println("There are " + pins + " pins left to take out");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        sc.close();
        return points;
    }

    public static void main(String[] args) {
        boolean isAdmin = false;
        String password = "";
        int noOfPlayers;

        Scanner sc = new Scanner(System.in);
        System.out.println("Are you an admin?(y/n)");
        String answer = sc.next().toLowerCase();
        if (answer == "y") {
            System.out.println("Enter your password:");
            password = sc.next();
            if (admin.getPassword() == password) {
                isAdmin = true;
            } else {
                while (admin.getPassword() == password) {
                    System.out.println("Invalid Password. Try again...");
                    password = sc.next();
                }
            }
        } else
            isAdmin = false;

        if (isAdmin) {
            int option = 0;
            System.out.println("What action do you want to carry on?");
            System.out.println("1. Change Rounds");
            System.out.println("2. Change Chances");
            System.out.println("3. Exit");

            switch (option) {
                case 1:
                    System.out.println("Enter the number of rounds: ");
                    admin.setRounds(password, sc.nextInt());
                    break;
                case 2:
                    System.out.println("Enter the number of chances:");
                    admin.setChances(password, sc.nextInt());
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("Welcome to the game!");
            System.out.println("Enter the number of players: ");
            noOfPlayers = sc.nextInt();

            ArrayList<String> players = new ArrayList<String>(noOfPlayers);
            for (int i = 0; i < noOfPlayers; i++) {
                System.out.println("Enter the name of Player " + (i + 1) + ": ");
                players.add(sc.next().toUpperCase());
            }

            int[][][] points = new int[admin.getRounds()][noOfPlayers][admin.getChances()];
            points = game(players);

            System.out.println("------------------");
            System.out.println("SCOREBOARD");
            System.out.println("------------------");
            for (int k = 0; k < admin.getRounds(); k++) {
                System.out.println("Round " + (k + 1));
                for (int i = 0; i < players.size(); i++) {
                    System.out.print(players.get(i) + " - ");
                    for (int j = 0; j < admin.getChances(); j++) {
                        if (points[k][i][j] == 20)
                            System.out.print("X ");
                        else if (points[k][i][j] == 15)
                            System.out.println("/ ");
                        else
                            System.out.print(points[k][i][j] + " ");
                    }
                    System.out.println();
                }
            }
            int[] totalPoints = new int[noOfPlayers];

            for (int k = 0; k < admin.getRounds(); k++) {
                for (int i = 0; i < players.size(); i++) {
                    for (int j = 0; j < admin.getChances(); j++) {
                        totalPoints[i] += points[k][i][j];
                    }
                }
            }

            System.out.println("------------------");
            System.out.println("LEADERBOARD");
            System.out.println("------------------");

            for (int i = 0; i < noOfPlayers - 1; i++) {
                for (int j = 1; j <= noOfPlayers - 1; j++) {
                    int temp;
                    String playerName;
                    if (totalPoints[i] < totalPoints[j]) {
                        temp = totalPoints[i];
                        playerName = players.get(i);

                        totalPoints[i] = totalPoints[j];
                        players.set(i, players.get(j));

                        totalPoints[j] = temp;
                        players.set(j, playerName);
                    }
                }
            }

            for (int i = 0; i < noOfPlayers; i++) {
                System.out.println((i + 1) + ". " + players.get(i) + " - " + totalPoints[i]);
            }
        }
        sc.close();
    }
}