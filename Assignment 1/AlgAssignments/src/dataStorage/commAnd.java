package dataStorage;

public class commAnd {
    public static void main(String[] args) {
        String items = "Feather token, swan boat, Hero Musk, Darkskull, Hammer of Weylund, Rod of Defense, Ioun stone, vibrant purple prism, Troll Jar, Dream Weaver, Eye Stalk, Tome of understanding +3, Arachnid tome, Circlet of persuasion, Wild Wild Wizard's Staff, Bracers of armor +5, Ring of power, Amulet of natural armor +1, Golf flog, Soap of Cleanliness, Robe of Darkness, Hat of disguise, Tome of understanding +2, Ring of Air, Amulet of natural armor +4, Staff of Divine Winds, Efficient quiver, Helm of comprehend languages and read magic, Bead of force, Cloak of Magic Shielding, Incense of meditation, Pearl of power, 8th-level spell, Cloak of Charisma +2, Elixir of sneaking, Crown, Rod of Ascension, Potion of testing, Arrows of Translocation, Ring gates, Potion of Delayed healing, Skiero's Scimitar, Thorn wand, Fan of Deadly Quills, Blade";
        items = items.replaceAll(","," &");
        System.out.println(items);
    }
}
