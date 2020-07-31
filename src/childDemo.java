
public class childDemo extends parentDemo{

	String name ="QAClickAcademy";


	public childDemo()
	{
	super();// this should be always be at first line
	System.out.println("child class construtor");

	}
	public void getStringdata()
	{
	System.out.println(name);
	System.out.println(super.name);
	}


	public void getData()
	{
	super.getData();
	System.out.println("I am in child class");
	}
	public static void main(String[] args) {
	// TODO Auto-generated method stub



	childDemo cd = new childDemo();

	cd.getStringdata();
	cd.getData();
		
		/*int a[][]= {{2,4,6},{3,1,5},{7,9,8}};
		int max=a[0][0];
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(a[i][j]>max)
				{
					max=a[i][j];
				}
			}
			
		}*/
		//System.out.println(max);
	}
}
