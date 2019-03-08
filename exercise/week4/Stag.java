import java.util.*;
import java.io.*;

class Stag {
    Scanner scanner;
    Place here;
    String verb, noun;
    String [] needs ;
    PrintStream out;

    void setup() {
        scanner = new Scanner(System.in);
        out = System.out;
        
        Place house = new Place("house",
            "You are in the house.\n" +
            "There are exits to the kitchen and the road. "
        );
        Place road = new Place("road",
            "You are in the road." +
            "There are exits to the butcher, market and China town. "
        );
        Place kitchen = new Place ("kitchen",  "you are in the kitchen. \n"+ "Lin is here and ask her what you need to cook beef noodle. ");
        Place butcher = new Place ("butcher", "you are in the butcher. \n"+ "Ben is here and you can buy the beef from him.");
        Place market = new Place ("market", "you are in the market. \n"+ "David is here and you can buy everything you need here.");
        Place grocery = new Place ("grocery", "you are in the market. \n"+ "John is here and you can buy everything you need here.");
        Place chinatown = new Place ("chinatown", "you are in the China town. \n"+ "Wang is here and you can buy Chinese food from here.");
        
        Npc lin = new Npc ("Lin", "Here is the recipe, I put on the desk. Go to take it .....");
        Npc ben = new Npc("Ben", "Short rib is suitable to cook beef noodle");
        Npc david = new Npc("David", "I have oions, tomatoes, gingers, greenoions and shallots.");
        Npc john = new Npc("John", "I have sugars, pepper, and water.");
        Npc wang = new Npc("Wang", "I have wine, soysauce, noodle and chillisauce.");
        
        String [] needs = new String[] {"shallot","oions","greenoions",
            "tomatoes","gingers", "beef","sugar","pepper"
            ,"water","wine","soysauce","noodle","chilli"};

        
        Thing oions = new Thing("oions", 
            "Onions are part of the allium family of vegetables and herbs, which have been cultivated for centuries for their characteristic, pungent flavors and for their medicinal properties.");
        Thing green = new Thing("greenoions", 
            "Onions are part of the allium family of vegetables and herbs, which have been cultivated for centuries for their characteristic, pungent flavors and for their medicinal properties.");
        Thing tomatoes = new Thing("tomatoes", 
            "A tomato is a nutrient-dense superfood that offers benefit to a range of bodily systems. Its nutritional content supports healthful skin, weight loss, and heart health.");
        Thing gingers = new Thing ("gingers", 
            "Possible health benefits include relieving nausea, loss of appetite, motion sickness, and pain. The root or underground stem  of the ginger plant can be consumed fresh, powdered, dried as a spice, in oil form, or as juice. Ginger is part of the Zingiberaceae family, alongside cardamom and turmeric.");
        Thing shallots = new Thing("shallots",
            "Shallots share the same antioxidant properties as garlic, and the organosulfur compounds they contain -- which give them that distinctive smell – help protect the body against certain types of cancer.");
        
        Thing beef = new Thing("beef",
            "Short ribs are a cut of beef taken from the brisket, chuck, plate, or rib areas of beef cattle. They consist of a short portion of the rib bone, which is overlain by meat which varies in thickness. ");
        
        Thing sugar = new Thing("sugar",
        "");
        Thing pepper = new Thing("pepper",
        "");
        Thing water = new Thing("water",
        "");

        Thing wine = new Thing("wine",
        "This is rice wine");
        Thing soysauce = new Thing("soysauce",
        "");
        Thing noodle = new Thing("noodle",
        "");
        Thing chilli = new Thing("chilli",
        "");

        Thing food = new Thing("food",
            "You have found the beef noodle."); 
        Puzzle recipe = new Puzzle("recipe",
            "There is a recipe here.");
        
        recipe.action("open", needs, new Thing[] {food},
            "You need all the ingredients.",
            "You open the recipe."
        );
        house.links(road, kitchen);
        road.links(house, butcher, market, grocery, chinatown );
        kitchen.links(road,lin, recipe);
        market.links(road, david,oions, gingers, shallots, tomatoes,green );
        butcher.links(road, ben, beef );
        grocery.links(road, john,sugar, pepper, water);
        chinatown.links(road, wang, wine, soysauce,noodle, chilli);
        here = house;
    }

    void run() {
        setup();
        here.act(here, "go", out);
        while (true) {
            read();
            Entity e = here.find(noun);
            if (e == null) {
                out.println("What " + noun + "?");
                continue;
            }
            here = e.act(here, verb, out);
        }
    }

    void read() {
        System.out.print("> ");
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        verb = words[0];
        noun = words[1];
    }
    public static void main(String[] args) {
        Stag program = new Stag();
        program.run();
    }
}
