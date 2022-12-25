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
                    else if (cinemaMatrix[i][j] == character) {
                        cinemaMatrix[i][j] = character;
                    }
                    else if (i != rowNumber && j != seatNumberInRow-1 && cinemaMatrix[i][j] == character) {
                        cinemaMatrix[i][j] = character;
                    }
                    else if (i == rowNumber && j == seatNumberInRow-1 && cinemaMatrix[i][j] != character){
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
    public static int BuyTicket2(int rowNumber, int numberOfSeats, int numberOfRows) {
        if (numberOfSeats * numberOfRows <= 60) {
            return 10;
        } else {
            if (rowNumber <= numberOfRows/2) {
                return 10;
            } else {
                return 8;
            }
        }
    }
    public static void ShowStatistics (int numberOfPurchasedTickets, int numberOfSeats, int numberOfRows, int currentIncome) {
        int size = numberOfRows * numberOfSeats;
        double porcentage = (numberOfPurchasedTickets* 100.0)/size;
        System.out.printf("Number of purchased tickets: %d %nPercentage: %.2f", numberOfPurchasedTickets, (double)Math.round(porcentage* 100.0) / 100.0);
        System.out.print("%");
        System.out.printf("%nCurrent income: $%d", currentIncome);
        System.out.println();
        if (numberOfSeats * numberOfRows <= 60) {
            System.out.printf("Total income: $%d", numberOfRows * numberOfSeats * 10);
        } else {
            if (numberOfRows % 2 == 0) {
                System.out.printf("Total income: $%d", numberOfSeats * ((numberOfRows / 2) * 10 + (numberOfRows / 2) * 8));
            } else {
                System.out.printf("Total income: $%d", numberOfSeats * ((numberOfRows / 2) * 10 + (numberOfRows / 2 + 1) * 8));
            }
        }
        System.out.println();
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
                3. Statistics
                0. Exit""";
        System.out.println(options);
        char[][] cinemaMatrix = new char[numberOfRows+1][numberOfSeats];
        int counter = 0;
        while (true) {
            int selectedOption = scanner.nextInt();
            if (selectedOption == 1) {
                ShowSeats(cinemaMatrix, 0, 0);
                System.out.println(options);
                }
            else if (selectedOption == 3) {
                ShowStatistics(0, numberOfSeats, numberOfRows, 0);
                System.out.println(options);
            }
            else if (selectedOption == 0) {
                return;
         } else {
                while (selectedOption == 2) {
                    counter++;
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
                        if (scanner.nextInt()==0) {
                            return;
                        }
                    }
                    if (selectedOption2 == 3) {
                        ShowStatistics(counter, numberOfSeats, numberOfRows, BuyTicket2(rowNumber, numberOfSeats, numberOfRows));
                        System.out.println(options);
                        if (scanner.nextInt()==0) {
                            return;
                        }
                    }
                    if (selectedOption2 == 0){
                        return;
                    }
                }
            }
        }
    }
}
