using Internal;
using System;

public class HelloWorld
{
    public static void Main(string[] args)
    {
        // var numberA = 0d;
        // const double NumberB = 3.4;
        // double result;
        // const string Name = "Maria Eugenia Vazquez";
        // const  string Hobby = "I like play football"; 
        // Console.WriteLine("Welcome to my App C#");
        // Console.WriteLine("Please type a number");
        // numberA = Convert.ToDouble(Console.ReadLine());
        // result = NumberB + numberA;
        // Console.WriteLine($"The sum total is:  {result} and my name is {Name} \n y my hobby is {Hobby} ");
        
        var userDealer = 4;
        var userPlayer = 11;
        string message;
        if(userPlayer > userDealer && userPlayer < 12){
            message = "You winner this game";
        } else if(userPlayer <= userDealer) {
            message = "You loser this game";
        } else {
            message = "Other Message";
        }
        Console.WriteLine(message);
    }
}