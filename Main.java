import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class Main
{
	public static void main(String[] args)	throws Exception
	{
	 
		Start s = new Start();
	
		// ���α׷��� �����ϸ�(Main�� �����ϸ�) StartŬ������ startScreen�� ���ѹݺ�. 
		while (true)
		{
			s.startScreen();	
		}
	}
}