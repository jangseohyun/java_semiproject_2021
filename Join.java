import java.util.Scanner;
import java.util.Arrays;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;


class Join
{
	CheckDriversLicense cdl = new CheckDriversLicense();

	UserData ud;
	User u;

	Scanner sc = new Scanner(System.in);
	SimpleDateFormat splitFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");   // ���߿� "-"��  split�ؼ� �� ��
	Date time = new Date();

	// �ڸ��� ���� �Է��� ������ �Է� Ƚ�� Ȯ�ο�
	int count;
	
	{
		ud = new UserData();
		u = new User();
	}
	

	// �Է¹ް� ����
	String[] joinDB(String userTel, String userPw, String userName, String userBirth, String userLicenseNum)
	{
		String[] joinData = {userTel,userPw,userName,userBirth,userLicenseNum};

		return joinData;
	}

	// ���̵� �Է¹ޱ�
	String inputUserTel()
	{	
		count = 0;
		String userTel = "";
		
		System.out.print("\n\n-----------------------------------------------------------------------\n\n");

		do
		{
			try
			{
				if (count == 0)
					System.out.print("\n����Ͻ� ���̵�(�޴�����ȣ 11�ڸ�)�� �Է��ϼ���. : ");
				else
					System.out.print("\n�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. : ");
				userTel = sc.next();
				count++;
			}
			catch (InputMismatchException e)
			{
				sc = new Scanner(System.in);
				System.out.println("\n* �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. *");
				System.out.println("\n\n-----------------------------------------------------------------------\n");
			}
		}
		while (userTel.length() != 11 || userTel.charAt(0)!='0' || userTel.charAt(1)!='1');
	
		return userTel;
	}

	// ��й�ȣ �Է¹ޱ�
	String inputUserPw()
	{
		count = 0;
		String userPw = "";

		do
		{
			try
			{
				if (count == 0)
				{
					System.out.print("\n����Ͻ� ��й�ȣ(6�ڸ�)�� �Է��ϼ���. : ");
					userPw = sc.next();
				}
				else
				{
					System.out.print("\n�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. : ");
					userPw = sc.next();
				}
				count++;	
				}
			catch (InputMismatchException e)
			{
				sc = new Scanner(System.in);
				System.out.println("\n* �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. *");
				System.out.println("\n\n-----------------------------------------------------------------------\n");
			}
		}
		while (userPw.length() != 6);

		return userPw;
	}

	// ��й�ȣ Ȯ��
	void checkUserPw(String userPw)
	{
		count = 0;
		String checkPw = "";

		do
		{
			try
			{
				if (count == 0)
				{
					System.out.print("\n��й�ȣ Ȯ���� ���� �ٽ� �Է����ּ���. : ");
					checkPw = sc.next();
				}
				else if (count < 3)
				{
					System.out.print("\n�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. : ");
					checkPw = sc.next();
				}
				else
				{
					System.out.println("\n�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
					System.out.print("��й�ȣ �Է����� ���ư��÷��� 1�� �Է��ϼ���. : ");
					checkPw = sc.next();

					if (checkPw.equals("1"))
					{
						inputUserPw();
						count = -1;
					}
				}
				count++;	
			}
			catch (InputMismatchException e)
			{
				sc = new Scanner(System.in);
				System.out.println("\n* �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. *");
				System.out.println("\n\n-----------------------------------------------------------------------\n");
			}

		}
		while (!checkPw.equals(userPw));
	}

	// �̸� �Է¹ޱ�
	String inputUserName()
	{
		System.out.print("\n����Ͻ� �̸��� �Է��ϼ���. : ");
		String userName= sc.next();	

		return userName;
	}

	// ������� 6�ڸ� �Է¹ޱ�
	String inputUserBirth()
	{
		count = 0;
		String userBirth = "";

		do
		{
			try
			{
				if (count == 0)
					System.out.print("\n�������(���� 6�ڸ�)�� �Է��ϼ���. : ");
				else
					System.out.print("\n�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. : ");
				userBirth = sc.next();
				count++;
			}
			catch (InputMismatchException e)
			{
				sc = new Scanner(System.in);
				System.out.println("\n* �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. *");
				System.out.println("\n\n-----------------------------------------------------------------------\n");
			}
		}
		while (userBirth.length()>6 || userBirth.length()<6);

		return userBirth;
	}

	// �����ȣ �Է¹ޱ�
	String inputUserLicenseNum()
	{
		count = 0;
		String userLicenseNum = "";

		do
		{
			try
			{
				if (count == 0)
					System.out.print("\n�����ȣ(���� 12�ڸ�, ������ ����) �Է��ϼ���. : ");
				else
					System.out.print("\n�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. : ");
				userLicenseNum = sc.next();
				count++;
			}
			catch (InputMismatchException e)
			{
				sc = new Scanner(System.in);
				System.out.println("\n* �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. *");
				System.out.println("\n\n-----------------------------------------------------------------------\n");
			}

		}
		while (userLicenseNum.length()>15 || userLicenseNum.length()<15);

		do
		{
			try
			{
				if (!cdl.checkNum(userLicenseNum))
				{
					System.out.print("\n��ȿ���� ���� ��ȣ�Դϴ�. �ٽ� �Է����ּ���. : ");
					userLicenseNum = sc.next();
				}
			}
			catch (InputMismatchException e)
			{
				sc = new Scanner(System.in);
				System.out.println("\n* �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. *");
				System.out.println("\n\n-----------------------------------------------------------------------\n");
			}
		}
		while (!cdl.checkNum(userLicenseNum));
		
		return userLicenseNum;
	}

	// ���� ���� ������ �� ��ȣ�� ����� �Է� ��ȣ�� ��ġ ����
	String checkLicenseNum(String userLicenseNum)
	{
		try
		{
			if (!cdl.checkNum(userLicenseNum))
			{
				System.out.print("\n��ȿ���� ���� ��ȣ�Դϴ�. �ٽ� �Է����ּ���. : ");
				inputUserLicenseNum();
			}
		}
		catch (InputMismatchException e)
		{
			sc = new Scanner(System.in);
			System.out.println("\n* �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. *");
			System.out.println("\n\n-----------------------------------------------------------------------\n");
		}		
		return userLicenseNum;
	}

	// �Է� �޼ҵ���� ȣ���ϰ�, �Է°����� UserData�� �����Ͽ� ȸ������ ��ü ���μ����� �����ϴ� �޼ҵ�
	UserData join() 
	{
		// �������� ȸ�������� ���� �Է°����� �޾ƿ��� �޼ҵ� ȣ��
		String userTel = inputUserTel();
		String userPw = inputUserPw();
		checkUserPw(userPw);
		String userName = inputUserName();
		String userBirth = inputUserBirth();
		String userLicenseNum = inputUserLicenseNum();
		
		// �Է¹��� ���� �������� User�� �����ϰ� �̸� UserData�� put���� 
		ud.putUserData(new User(userName, userTel, userPw, userLicenseNum, userBirth));
		u.setJoinTime(splitFormat.format(time));

		// UserData�� ������ ��ġ�� ȸ�������� �Ϸ�� 
		System.out.print("\n\n-----------------------------------------------------------------------\n\n");
		System.out.println("\n* ȸ�������� �Ϸ�Ǿ����ϴ�. *");
		System.out.println("* ���� ȭ������ �̵��մϴ�. *");

		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			System.out.println(e.toString());
		}
		
		System.out.print("\n\n-----------------------------------------------------------------------\n\n");

		// �޼ҵ忡�� return�� �Ѵٴ� ���� �޼ҵ带 �����Ѵٴ� ��.
		// ��, �� �޼ҵ带 ȣ���ߴ� �������� ���ư��� �ȴ�. �� startScreen() 
		return ud;
	}
	

	// �Է¹��� ���� ����Ǿ� �ִ� UserData�� ��ȯ���ִ� �޼ҵ�
	UserData getUserData()
	{
		return ud;
	}
}

/*
[���� ���]
����Ͻ� ���̵�(�޴�����ȣ 11�ڸ�)�� �Է��ϼ���. : 12345678910

����Ͻ� ��й�ȣ(���� 6�ڸ�)�� �Է��ϼ���. : 121212

��й�ȣ Ȯ���� ���� �ٽ� �Է����ּ���. : 121212

����Ͻ� �̸��� �Է��ϼ���. : ddd

�������(���� 6�ڸ�)�� �Է��ϼ���. : 121212

�����ȣ(���� 12�ڸ�, ������ ����) �Է��ϼ���. : 12-12-121212-11

��ȿ���� ���� ��ȣ�Դϴ�. �ٽ� �Է����ּ���. : 11-17-893804-41

ȸ�������� �Ϸ�Ǿ����ϴ�.


���� ȭ��

[ 1. �α���   ]
[ 2. ȸ������ ]

>> �Է�:
*/