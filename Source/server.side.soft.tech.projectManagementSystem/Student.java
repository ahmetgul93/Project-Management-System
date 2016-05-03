
public class Student implements Serializable{
	private long int studentNumber;
	private String name;
	private String surname;
	
	
	public Student()
	{
		
	} 
	
	public long int getstudentNumber()
	{
		return this.studentNumber;
	}
	public void setstudentNumber(long int studentNumber)
	{
		this.studentNumber = studentNumber;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSurname()
	{
		return this.surname;
	}
	public void setSurname(String surname)
	{
		this.surname = surname;
	}
	
}
