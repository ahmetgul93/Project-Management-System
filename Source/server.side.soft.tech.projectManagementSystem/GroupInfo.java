
public class GroupInfo implements java.io.Serializable{
	
		private ArrayList<Student> group;
		private int groupNo;
	
		public GroupInfo()
		{
			group = new ArrayList<Student>();
		}
		
		public void setGroupNo(int groupNo)
		{
			this.groupNo = groupNo;
		}
		public int getGroupNo()
		{
			return this.groupNo;
		}
		public ArrayList<Student> getGroup()
		{
			return this.group;
		}
		public void addStudent(Student s)
		{
			this.group.add(s);
		}
		
}
