List<string> TasList = new List<string>();

int menuSelected = 0;
do
{
    menuSelected = ShowMainMenu();
    if ((Menu)menuSelected == Menu.Add)
    {
        ShowMenuAdd();
    }
    else if ((Menu)menuSelected == Menu.Remove)
    {
        ShowMenuRemove();
    }
    else if ((Menu)menuSelected == Menu.List)
    {zx
        ShowMenuList();
    }
} while ((Menu)menuSelected != Menu.Exit);


/// <summary>
/// Show the main menu 
/// </summary>
/// <returns>Returns option indicated by user</returns>
int ShowMainMenu()
{
    Console.WriteLine("----------------------------------------");
    Console.WriteLine("Ingrese la opción a realizar: ");
    Console.WriteLine("1. Nueva tarea");
    Console.WriteLine("2. Remover tarea");
    Console.WriteLine("3. Tareas pendientes");
    Console.WriteLine("4. Salir");

    // Read line
    string readLine = Console.ReadLine();
    return Convert.ToInt32(readLine);
}

void ShowMenuRemove()
{
    try
    {
        Console.WriteLine("Ingrese el número de la tarea a remover: ");
        // Show current taks
        ShowListTask();

        string taskRemove = Console.ReadLine();
        // Remove one position
        int indexToRemove = Convert.ToInt32(taskRemove) - 1;
        if (indexToRemove > (TasList.Count - 1) || indexToRemove < 0)
            Console.WriteLine("Opcion no valida");
        else if (indexToRemove > -1 && TasList.Count > 0)
        {
            string task = TasList[indexToRemove];
            TasList.RemoveAt(indexToRemove);
            Console.WriteLine($"Tarea {task} eliminada");
        }
    }
    catch (Exception)
    {
        Console.WriteLine("Ha ocurrido un error");
    }
}

void ShowMenuAdd()
{
    try
    {
        Console.WriteLine("Ingrese el nombre de la tarea: ");
        string task = Console.ReadLine();
        TasList.Add(task);
        Console.WriteLine("Tarea registrada");
    }
    catch (Exception)
    {
        Console.WriteLine("Ha ocurrido un error");
    }
}

void ShowMenuList()
{
    if (TasList?.Count > 0)
    {
        ShowListTask();
    }
    else
    {
        Console.WriteLine("No hay tareas por realizar");
    }
}

void ShowListTask()
{
    Console.WriteLine("----------------------------------------");
    var indexTask = 0;
    TasList.ForEach(p => Console.WriteLine($"{++indexTask}. {p}"));
    Console.WriteLine("----------------------------------------");
}


public enum Menu
{
    Add = 1,
    Remove = 2,
    List = 3,
    Exit = 4
}