package cinema;
import java.util.Scanner;

public class Cinema {

    public static void ShowSeats(char[][] cinemaMatrix, int rowNumber, int seatNumberInRow) {
        char character = 'B';
        System.out.println("Cinema:");
        for (int i=0; i < cinemaMatrix.length; i++) {
            if (i != 0) {
                System.out.print(i+" ");
            } else {
                System.out.print("  ");
            }
            for (int j = 0; j < cinemaMatrix[i].length; j++) {
                if (i == 0) {
                    System.out.print(j+1+ " ");
                } else {
                    if (i != rowNumber && j != seatNumberInRow-1 && cinemaMatrix[i][j] != character)
                    {
                        cinemaMatrix[i][j] = 'S';
                    }
                    else if (i != rowNumber && j != seatNumberInRow-1 && cinemaMatrix[i][j] == character) {
                        cinemaMatrix[i][j] = character;
                    }
                    else if (i == rowNumber && j == seatNumberInRow-1){
                        cinemaMatrix[i][j] = character;
                    } else {
                        cinemaMatrix[i][j] = 'S';
                    }
                    System.out.print(cinemaMatrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public static void BuyTicket(int rowNumber, int numberOfSeats, int numberOfRows) {
        if (numberOfSeats * numberOfRows <= 60) {
            System.out.println("Ticket price: $"+10);
        } else {
            if (rowNumber <= numberOfRows/2) {
                System.out.println("Ticket price: $"+10);
            } else {
                System.out.println("Ticket price: $"+8);
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        Scanner scanner = new Scanner(System.in);
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();
        String options = """
                1. Show the seats
                2. Buy a ticket
                0. Exit""";
        System.out.println(options);
        char[][] cinemaMatrix = new char[numberOfRows+1][numberOfSeats];
        while (true) {
            int selectedOption = scanner.nextInt();
            if (selectedOption == 1) {
                ShowSeats(cinemaMatrix, 0, 0);
                System.out.println(options);
                }
            else if (selectedOption == 0) {
                return;
         } else {
                while (selectedOption == 2) {
                    System.out.println("Enter a row number:");
                    int rowNumber = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int seatNumberInRow = scanner.nextInt();
                    BuyTicket(rowNumber, numberOfSeats, numberOfRows);
                    System.out.println(options);
                    int selectedOption2 = scanner.nextInt();
                    if (selectedOption2 == 1) {
                        ShowSeats(cinemaMatrix, rowNumber, seatNumberInRow);
                        System.out.println(options);
                        scanner.nextInt();
                    } else if (selectedOption2 == 0){
                        return;
                    }
                }
            }
        }
    }
}
