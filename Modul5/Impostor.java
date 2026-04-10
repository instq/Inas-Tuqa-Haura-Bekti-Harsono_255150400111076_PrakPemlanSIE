public class Impostor implements IImpostor, ICrew, IKickable {
    private final String name;
    
    public Impostor(String name) {
        this.name = name;
    }

    @Override
    // public void kill(ICrew crew) {
    //     System.out.println(crew.getName() + " has been killed!");
    // }
    public void kill(ICrew crew) {
        System.out.println(crew.getName() + " has been killed!");

        if (crew instanceof Crew) {
            ((Crew) crew).die(); // ubah status jadi mati
        }
    }

    @Override
    public void doWork() {
        System.out.println("Impostor " + this.name + " is doing work.");
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void kick() {
        System.out.println("Impostor " + this.name + " was kicked out!");
    }
}
