
public class BirthdayNode implements Comparable<BirthdayNode>{
    private String name;
    private int date;
    private String notes;

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
    @Override
    public String toString() {
        return name;
    }

    //Set methods
    public void setNotes(String notes){
        this.notes=notes;
    }

    //Get methods
    public int getMonth(){
        return (date/100);
    }
    public int getDay(){
        return (date%100);
    }
    public int getDate() {
        return date;
    }
    public String getName() {
        return name;
    }
    public String getNotes() {
        return notes;
    }
    public String getSaveLine(){
        return (name +","+ date +","+ notes);
    }
}
