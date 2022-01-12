package BirthdayTracker;

public class BirthdayNode implements Comparable<BirthdayNode>{
    private String name;
    private int date;
    private String notes;
    private BirthdayNode nextNode;

    public BirthdayNode(String name, int date){
        this.date = date;
        this.name = name;
    }
    public void changeDate(int newDate){
        this.date = newDate;
    }
    public void changeName(String newName){
        this.name=newName;
    }
    public void addNote(String notes){
        this.notes=notes;
    }

    @Override
    public int compareTo(BirthdayNode compared){
        return Integer.compare(this.date, compared.getDate());
    }

    public int getDate() {
        return date;
    }

    public String getName() {
        return name;
    }
}
