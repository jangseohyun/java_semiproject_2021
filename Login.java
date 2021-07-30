import java.util.Map;
import java.util.HashMap;
import java.util.Vector;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;


class Login extends User
{
	UserData userdata;
	InputDate id = new InputDate();
	
	Login()
	{
	}
	
	Login(UserData readData)
	{
		this.userdata = readData;
	}
	

	String userInputId = "";         // ����� �Է� ���̵�
	String userInputPw = "";         // ����� �Է� ��й�ȣ

	int loginCount = getLoginCount();
	String loginTime = getLoginTime();
	boolean userStatus = getUserStatus();

	Scanner sc = new Scanner(System.in);
	SimpleDateFormat splitFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");   // ���߿� "-"��  split�ؼ� �� ��
	Date time = new Date();

	Map<String, String> loginMap = new HashMap<String, String>();   // ���̵�, ��й�ȣ ����� map
	Map<String, String> lockMap = new HashMap<String, String>();    // ���̵�, ��й�ȣ ��ݿ� map
	Map<String, String> collectMap = new HashMap<String, String>();

	
	String login()
	{
		String result = "";
		boolean success = false;
		
		System.out.print("\n\n-----------------------------------------------------------------------\n\n");
		System.out.print("\n�� �α��� ��\n\n");

		do
		{
			try
			{
				System.out.print("�޴��� ��ȣ: ");
				userInputId = sc.next();

				if (userInputId.length() != 11)
					System.out.println("�ٽ� �Է����ֽʽÿ�.");
			}
			catch (InputMismatchException e)
			{
				sc = new Scanner(System.in);
				System.out.println("\n* �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. *");
				System.out.println("\n\n-----------------------------------------------------------------------\n");
			}
		}
		while (userInputId.length() != 11);

		// �Է��� ���̵� readData�� key���� �����ϴ��� Ȯ��
		if (tryLogin(userInputId) != null)
		{
			try
			{
				System.out.print("��й�ȣ: ");
				userInputPw = sc.next();	
			}
			catch (InputMismatchException e)
			{
				sc = new Scanner(System.in);
				System.out.println("\n* �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. *");
				System.out.println("\n\n-----------------------------------------------------------------------\n");
			}
			result = userInputId;

			// userInputId�� readData�� ����� key���� ���
			// �̿� �ش��ϴ� value���� userInputPw�� ��ġ�Ѵٸ�
			if (tryLogin(userInputId).equals(userInputPw))
			{
				userStatus = true;
				setUserStatus(userStatus);
				setLoginTime(splitFormat.format(time));
				userCoupon();
				success = true;
			}
			else	// id�� �����ϴµ�, ��й�ȣ�� Ʋ�����
			{
				userStatus = false;
				setUserStatus(userStatus);
				System.out.println("\n* �߸��� ��й�ȣ �Դϴ�. *");
				login();
			}
		}
		else if (tryLogin(userInputId) == null)	// �������� �ʴ� id�� ���
		{
			System.out.println("\n* ��ϵ��� ���� ���̵��Դϴ�. �ʱ� ȭ������ ���ư��ϴ�. *");
			System.out.print("\n\n-----------------------------------------------------------------------\n\n");
			result = "";
		}
		else	// �߸� �Է����� ���
		{
			System.out.println("\n* �߸��� ���̵��Դϴ�. *");
			login();
		}

		return result;
	}

	String tryLogin(String userInputId)
	{
		for (int i=0; i<userdata.getUser().size(); i++)
		{
			collectMap.put(userdata.getUser().get(i).getHp(), userdata.getUser().get(i).getPw());
		}

		return collectMap.get(userInputId);
	}

	// �α��� �õ� Ƚ�� ����
	void countLogin()
	{
		setLoginCount(loginCount++);

		// �α��� Ƚ�� 5ȸ ���ϴ� �α��� ��õ�, �ʰ��� ���� ���
		if (loginCount < 5)
			return;
		else if (loginCount >= 5)
		{
			lockMap.put(userInputId,userInputPw);
			loginMap.put(userInputId,null);
			lockedAccount();
		}
	}

	// ������ ���� �ȳ�
	void lockedAccount()
	{
		System.out.print("\n\n-----------------------------------------------------------------------\n\n");
		System.out.println("\n* �α��� �Է� Ƚ�� �ʰ��� ������ ������ �����Դϴ�. *");
		System.out.println("* �������� â���� �湮���ּ���. *");

		loginCount = 0;
		setLoginCount(loginCount);

		System.out.print("\n\n-----------------------------------------------------------------------\n\n");
		System.out.print("\n* �ʱ� ȭ������ ���ư��ϴ�. *\n");
		System.out.print("\n\n--------------------------------------------------------------------\n\n");

		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			System.out.println(e.toString());
		}

		return;
	}
	
	// ���� �߰�
	void userCoupon()
	{
		String loginTime = getLoginTime();
		String joinTime = getJoinTime();

		String[] loginTimeSplit = loginTime.split("-");
		String[] joinTimeSplit = joinTime.split("-");
		String[] birthSplit = getBirth().split("");

		String birthMonth = birthSplit[2]+birthSplit[3];

		int checkJoinTime = id.compareDate(Integer.parseInt(joinTimeSplit[0]),Integer.parseInt(joinTimeSplit[1]),Integer.parseInt(joinTimeSplit[2]));
		int checkNowTime = id.compareDate(Integer.parseInt(loginTimeSplit[0]),Integer.parseInt(loginTimeSplit[1]),Integer.parseInt(loginTimeSplit[2]));

		if (loginTimeSplit[1].equals(birthMonth))
			setCoupon("1::: ���� ���� ���� (10% ����)","10");

		if (loginTimeSplit[0].equals("2021"))
			setCoupon("2::: ���� 7�ֳ� ��� ���� (7% ����)","7");

		if ((checkNowTime-checkJoinTime)>0 || ((checkNowTime-checkJoinTime)<7))
			setCoupon("3::: �ű� ���� ���� (5% ����)","5");
	}

	void testPrint() throws Exception
	{
		userdata.printUser();
	}
}