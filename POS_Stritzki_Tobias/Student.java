public class Student
{
    private String name;
    private int geburtsjahr;
    
    public void setName(String name)
    {
        this.name = name;
    }
    public void setGeburtsjahr(int geburtsjahr) 
    {
        this.geburtsjahr = geburtsjahr;
    }
    public Student() 
    {
        setName("Tobias");
        setGeburtsjahr(2004);
    }
}