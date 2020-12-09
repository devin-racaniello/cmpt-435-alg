public class Person {
    public static int ppl = 0;
    public int id = 0;
    public boolean hasCovid;

    Person(){
        this.id = ppl;
        ppl++;
        this.hasCovid = false;
    }
}
