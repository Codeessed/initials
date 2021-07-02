import java.util.Scanner;

public class Main {

    public static void stat(int ticket_sold, int ticket_price, int total_income){
        int current_income = ticket_price * ticket_sold;
        double percentage_bought =(double) Math.round((double) current_income / total_income *10000)/100;

        System.out.println("Number of purchased tickets: "+ ticket_sold +"\n" +
                "Percentage: "+ percentage_bought +"%"+"\n" +
                "Current income: $" + current_income +"\n" +
                "Total income: $"+ total_income +"\n");
        space();

    }



    public static void main(String[] args){
        //user variables for seat position
        int buyer_row_choice;
        int buyer_column_choice;
        //owner variables for amount of seat
        int row;
        int column;
        //user variable for menu option
        int menu_select;

        //calculation variables
        int ticket_price = 10;
        int ticket_sold = 0;
        double percentage_bought = 0.00D;
        int current_income;
         int total_income;


        //setup scanner
        Scanner b = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");

        //number of rows the theatre has
        row = b.nextInt();

        System.out.print("Enter the number of seats in each row: ");


        //number of seats per row i.e column
        column = b.nextInt();

        //create space
        space();

        //total income calculation
        total_income = row * column * ticket_price;

        //menu
        menu();



        //select option for menu
        menu_select = b.nextInt();

        //declaration of seat array
        char[][] seat = new char[row][column];
        for(int i = 0; i< row; i++){
            for(int j = 0; j< column; j++){
                seat[i][j]= 'S';

            }
        }
        while(menu_select != 0){
            if(menu_select == 1){
                for(int i = 0; i< row; i++){
                    for(int j = 0; j< column; j++){
                        System.out.print(seat[i][j] + "  ");
                    }
                    System.out.println();
                }
                space();
            }



            else if(menu_select == 2){
                System.out.print("Enter a row number: ");
                buyer_row_choice = b.nextInt();
                System.out.print("Enter a seat number in that row: ");
                buyer_column_choice = b.nextInt();
                space();
                if(buyer_row_choice >= row || buyer_column_choice >= column){
                    System.out.println("SEAT DOESN'T EXIST, pls select row between 0 and "+(row-1)+", column between 0 and "+(column-1));
                }else {
                    if (seat[buyer_row_choice][buyer_column_choice] == 'T') {
                        System.out.println("OOPS!!! That ticket has already been purchased");

                    }else{
                        System.out.println("Ticket price: $10");
                        //claiming a ticket has now been purchased
                        seat[buyer_row_choice][buyer_column_choice] = 'T';
                        ticket_sold += 1;
                    }
                }
                space();
            }

            else if(menu_select == 3){
                //looping through the whole array to count Ts
//                for (int i =0; i<row; i++){
//                    for (int j =0; j<column; j++){
//                        if(seat[i][j] == 'T');
//
//                    }
//                }

      //          System.out.println(ticket_sold);
                //calculations

               stat(ticket_sold,ticket_price, total_income);



                current_income = ticket_price * ticket_sold;
                percentage_bought =(double) Math.round((double) current_income / total_income *10000)/100;

                        System.out.println("Number of purchased tickets: "+ ticket_sold +"\n" +
                        "Percentage: "+percentage_bought+"%"+"\n" +
                        "Current income: $" + current_income +"\n" +
                        "Total income: $"+ total_income +"\n");

            }
            else{
                System.out.println("INVALID INPUT!");
                space();
            }
            //display menu again
            menu();
            //get input from user again
            menu_select = b.nextInt();
        }
        //end the program
        endProgram();
    }
    public static void menu(){
        System.out.println("1. Show the seats\n" + "2. Buy a ticket\n" + "3. Statistics\n" + "0. Exit");
        space();
    }
    public static void space(){
        System.out.println(" ");
    }
    public static void endProgram(){
        System.out.println("Thank you. Goodbye");
    }

}
