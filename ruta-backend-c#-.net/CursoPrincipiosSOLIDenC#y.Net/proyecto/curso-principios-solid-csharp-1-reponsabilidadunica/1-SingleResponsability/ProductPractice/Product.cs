namespace SingleResponsability;

public class Product
{
    public int Id { get; set; }
    public string Name { get; set; }
    public double Price { get; set; }
    public string Code { get; set; }
    public string Description { get; set; }
    public List<string> Ingredients { get; set; }

    public Product()
    {
        this.Name = String.Empty;
        this.Price = 0.0;
        this.Code = String.Empty;
        this.Ingredients = new List<string>();
    }

    public Product(int id, string name, double price, string code, List<string> ingredients){
        this.Id = id;
        this.Name = name;
        this.Price = price;
        this.Code = code;
        this.Ingredients = ingredients;
    }
}