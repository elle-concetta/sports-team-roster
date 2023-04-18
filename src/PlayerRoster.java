/*
Author: Elizabeth Fassler
Course: COP 2210 RVD 1231
Date: 04/18/2023
Assignment: 15.1 Lab
Instructor: Sergio Pisano
Description: Soccer team roster
*/
import java.util.Scanner;
// class PlayerRoster
public class PlayerRoster {
    // printing the menu
    public static void outputMenu() {
        System.out.println("MENU");
        System.out.println("u - Update player rating");
        System.out.println("a - Output players above a rating");
        System.out.println("r - Replace player");
        System.out.println("o - Output roster");
        System.out.println("q - Quit\n");
        System.out.println("Choose an option:");
    }

    // printing the details of players
    public static void outputRoster(int[] jersey, int rating[], int min)
    {
        System.out.println(((min>0) ? ("ABOVE " + min) : ("ROSTER")));
        for (int i=0; i<5; i++)
        {
            if (rating[i] > min)
            {
                System.out.println("Player " + (i + 1) + " -- Jersey number: " + jersey[i] + ", Rating: " + rating[i]);
            }
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        // declarations
        int[] jersey = new int[5];
        int[] rating = new int[5];
        char input;
        boolean keepAlive = true;

        // reading the jersey numbers and rating
        for (int i=0; i<5; i++)
        {
            System.out.println("Enter player " + (i + 1) + "'s jersey number:");
            jersey[i] = scnr.nextInt();
            System.out.println("Enter player " + (i+1) + "'s rating:");
            rating[i] = scnr.nextInt();
            System.out.println();
        }
        outputRoster(jersey, rating, 0); // calling the function to print details of players.
        while(keepAlive)
        {
            outputMenu(); // calling the function to printing the menu options
            input = scnr.next().charAt(0); // reading the user choice
            if(input == 'q') // user wants to quit
            {
                keepAlive = false;
            }
            else if(input == 'o') // user want to print the details of players
            {
                outputRoster(jersey, rating, 0); // calling the function to print details of players
            }
            else if(input == 'u') // user wants to update the player rating
            {
                // reading the jersey number
                System.out.println("Enter a jersey number:");
                int jerseyNum = scnr.nextInt();
                // reading the new rating for player
                System.out.println("Enter a new rating for player:");
                int newRating = scnr.nextInt();

                // updating the rating of player
                for(int i=0; i<5; i++)
                {
                    if(jersey[i] == jerseyNum)
                    {
                        rating[i] = newRating;
                    }
                }
                System.out.println();
            }
            else if(input == 'a') // user wants to print details above rating
            {
                // reading the rating
                System.out.println("Enter a rating:");
                int above_rat = scnr.nextInt();
                outputRoster(jersey, rating, above_rat); // calling the function to print details of players above rating
            }
            else if(input == 'r') // user wants to replace the player
            {
                // reading the jersey number of player to replace
                System.out.println("Enter a jersey number:");
                int jerseyNum = scnr.nextInt();

                // replacing the player
                for(int i=0; i<5; i++)
                {
                    if(jersey[i] == jerseyNum)
                    {
                        System.out.println("Enter a new jersey number:");
                        jersey[i] = scnr.nextInt();

                        System.out.println("Enter a rating for the new player:");
                        rating[i] = scnr.nextInt();
                    }
                }
                System.out.println();
            }
        }
    }
}




