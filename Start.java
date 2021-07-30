import java.util.Scanner;
import java.util.InputMismatchException; 


class Start
{
	// �޼ҵ峻���� return �ϸ� �޼ҵ带 ���������� ������
	// �޼ҵ带 ȣ���� ������ ���ƿ��� ������ ���� 
	Login l;
	Join j;
	Cars c;
	Payment pm;
	Insurance insu;

	static InputDate id;
	static CarFrame selCar;
	static Inquiry iq;
	static UserData ud;
	static User loginUser;
	
	static String loginUserId;
	static String[] reserveInfo;

	int amount; // �����ݾ�

	CheckSelection cs;

	// �α��� ������ ���� ���� �޾ƿ��� ������
	private String userCardNum;		// (ī���� ��) ����� ī�� ��ȣ
	private String userCardBank;	// (ī���� ��) ����� ī���
	private int userPaidAmount;		// (������ ��) ������ �ݾ�
	private String paymentType;		// �������(����, ī��)
	private int priceWithCoupon;

	Scanner sc = new Scanner(System.in);

	Start()
	{	
		l = new Login();
		j = new Join();
		c = new Cars();
		ud = new UserData();
		loginUser = new User();
		id = new InputDate();
	}


	void startScreen()
	{
		int userInput = 0;
		
		do
		{
			try
			{
				System.out.println("\n�� ���� ȭ�� ��");
				System.out.println();
				System.out.println("1. �α���");
				System.out.println("2. ȸ������");
				System.out.println();
				System.out.print("\n>> �Է�: ");
				userInput = sc.nextInt();
			}
			catch (InputMismatchException e)
			{
				sc = new Scanner(System.in);
				System.out.println("\n* �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. *");
				System.out.println("\n\n-----------------------------------------------------------------------\n");
			}
		}
		while(userInput!=1 && userInput!=2);

		if (userInput == 1)
		{
			loginUserId = l.login();
			if (loginUserId != "")
				afterLoginScreen();
			else
				startScreen();
		}
		else if (userInput == 2)
		{
			ud = j.join();
			loginUser = ud.getLoginUserInfo(loginUserId);
		}
	}

	void afterLoginScreen()
	{
		int userInput;		
		id = new InputDate(loginUser);

		String userName = loginUser.getName();

		System.out.print("\n\n-----------------------------------------------------------------------\n\n");
		System.out.println("\n* "+userName+" �� ȯ���մϴ�. *");
		System.out.print("\n\n-----------------------------------------------------------------------\n\n");

		do
		{
			System.out.println("\n�� �Ѷ� ����ī ��");
			System.out.println();
			System.out.println("1. �ű� ����");
			System.out.println("2. ���� Ȯ��");
			System.out.println("3. �α׾ƿ�");
			System.out.println("4. ����(�����ڸ� ����)");
			System.out.println();
			System.out.print("\n>> �Է�: ");
			userInput = sc.nextInt();
		}
		while(userInput!=1 && userInput!=2 && userInput!=3 && userInput!=4);

		System.out.println();
		
		try
		{
			if (userInput == 1)
			{
				selectDate();
			}
			else if (userInput == 2)
			{
				iq.clear();
				afterLoginScreen();
			}
			else if (userInput == 3)
			{
				startScreen();
			}
			else if(userInput == 4)
			{
				System.out.println("\n-----------------------------------------------------------------------\n");
				System.out.println("\n������ ��� ���� ��ȣ�� �Է����ּ���.");
				System.out.print("\n>> �Է�: ");
				int adminPw = sc.nextInt();
				if (adminPw == 160905)
					exitProgram();
				else
				{
					System.out.println("\n\n-----------------------------------------------------------------------\n");
					System.out.println("\n* �����ڸ� ���� �����մϴ�. �޴��� ���ư��ϴ�. *");
					afterLoginScreen();
				}
					

			}
		}
		catch(NullPointerException e)
		{
			System.out.print("���� ����� ������ �����ϴ�.\n");
			Scanner sc = new Scanner(System.in);

			int n;

			do
			{
				System.out.println("�����Ͻðڽ��ϱ�?");
				System.out.print("1. �� (����ȭ������ �̵�)\n");		//�� �뿩 �ð� �� ��¥ �������� �̵�
				System.out.print("2. �ƴϿ� (�ʱ�ȭ������ �̵�)\n");	//�� �ʱ�ȭ������ �̵�
				System.out.print(">> �Է� : ");
				n = sc.nextInt();
				System.out.println();
			}
			while (n<1 || n>2);
			
			switch(n)
			{
				case 1: selectDate(); break;
				case 2: startScreen(); break;				
			}
		}
		return;
	}

	void selectDate()
	{
		boolean successStart;

		successStart = id.userInputStart();

		if (successStart)
		{
			reserveInfo = id.userInputEnd();
			if (reserveInfo != null)
			{
				selectCar();
			}
			else
				return;
		}
		else
			return;
	}

	void selectCar()
	{
		c.updateCar(c);
		c.printCar();
		int userSel = c.selectCar();
		
		switch (userSel)
		{
			case -1: selectDate();	break;	// -1�� �����ߴ� �� �������� �ǵ��ư��⸦ ����
			case 1: selCar = c.selCar;		// 1�� �����ߴ� �� ����ڰ� ������ ��ȣ�� ���� �޾ƿͼ� selCar������ ��Ҵ�.
					selectInsu();	break;
			case 2: selectCar();	break;	// 2�� �����ߴ� �� �߸��� ���� �Է��ؼ� selectCar()�� ��ȣ�� �ؾ��Ѵ�.
		}

		return;
	}

	void selectInsu()
	{
		insu = new Insurance(selCar);		// ������ ������ ä���� selCar�� �������� �Ű������� �Ѱ��� 
		
		int userSel2 = insu.selectIns();	// ������ ���� ���� ���� �ɼ��� ����Ѵ�. 
		
		if (userSel2 == -1)
			selectCar();
		else
		{
			amount = insu.amount;
			checkSelection();
		}

		return;
	}

	void checkSelection()
	{
		cs = new CheckSelection(reserveInfo, selCar);

		int userSel = cs.checkInfo1();

		switch (userSel)
		{
			case 1: payment();
			case 2: userSel = cs.checkInfo2();
					switch (userSel)
					{
						case 1: selectDate(); break;
						case 2: selectCar(); break;
						case 3: selectInsu(); break;
					}
		}

		return;
	}

	void payment()
	{
		pm = new Payment(c, selCar);
		//System.out.println("payment�޼ҵ� ������ amount : " + amount);
		boolean success = pm.run(amount);
		
		userCardBank = pm.user.getBank();
		userCardNum = pm.user.getNum();
		userPaidAmount = pm.getPaidAmount();
		paymentType = pm.user.getPayment();
		priceWithCoupon = pm.getPriceWithCoupon();

		if(paymentType.equals("����"))	// ����ڰ� �������� ���� �� 
		{	
			iq = new Inquiry(selCar, loginUserId, ud, reserveInfo, paymentType, userPaidAmount, priceWithCoupon);
			iq.cashReceiptPrint();
		}
		else
		{
			iq = new Inquiry(selCar, loginUserId, ud, reserveInfo, paymentType, userCardNum, userCardBank, priceWithCoupon);
			iq.cardReceiptPrint();	
		}
		
		if(success)
			c = pm.changeRentalState();
		
		try
		{
			Thread.sleep(3000);
			startScreen();
		}
		catch (InterruptedException e)
		{
			System.out.println(e.toString());
		}
	}


	// ���α׷� ���� ����
	void exitProgram()
	{
		System.out.println("\n\n-----------------------------------------------------------------------\n\n");
		System.out.println("*  ���α׷��� ����˴ϴ�.  *");
		System.out.println("* �̿����ּż� �����մϴ�. *\n\n");
		try
		{
			Thread.sleep(2000);
			System.exit(0);
		}
		catch (InterruptedException e)
		{
			System.out.println(e.toString());
		}
	}
}
