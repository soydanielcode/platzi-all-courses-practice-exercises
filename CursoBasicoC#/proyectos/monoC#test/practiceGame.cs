using Internal;
using System;

public class HelloWorld
{
    public static void Main(string[] args)
    {
        int playerUser = 0;
        int playerDealer = 0;
        int numberRandom;
        int coins = 0;
        string message = "";
        string casino;
        bool wantGame = true;
        System.Random random = new System.Random();

        while (wantGame)
        {
            Console.WriteLine("Please type casino to game");
            casino = Console.ReadLine();
            Console.WriteLine("Please type number Coins you need");
            coins = Convert.ToInt32(Console.ReadLine());
            if (casino == "casino")
            {
                for (int i = 0; i < coins; i++)
                {
                    do
                    {
                        numberRandom = random.Next(1, 14);
                        playerUser = playerUser + numberRandom;
                        Console.WriteLine($"You first cart is: {numberRandom}");
                        Console.WriteLine("Other Cart?");
                        casino = Console.ReadLine();
                    } while (casino == "si");
                    playerDealer = random.Next(10, 21);
                    if (playerUser > playerDealer && playerUser < 22)
                    {
                        message = "Congrats you win this game";
                    }
                    else if (playerUser < playerDealer || playerUser > 21)
                    {
                        message = "Sorry, you loser this game";
                    }
                    Console.WriteLine($"{message} Your points: {playerUser} and points Dealer: {playerDealer}");
                    playerDealer = 0;
                    playerUser = 0;
                }
                Console.WriteLine("The Game Over");
            }
            else
            {
                message = "The Game Finished";
                wantGame = false;
                Console.WriteLine("Exit");
            }
        }
    }
}