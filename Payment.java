import java.util.Scanner;
import java.util.HashMap;
import java.util.Vector;
import java.util.Arrays;
import java.util.ArrayList;
import java.text.DecimalFormat;


class Payment
{
	private int[] cash = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
	private int price;
	private int sel;				// ����� ���ð� ���� ����
	private int change;				// �Ž����� ����
	private int paidAmount;			// ����ڰ� �� ���� �հ�
	private String paymentType; 	// ����ڰ� ������ ���ҹ��(����, ī��)
	private int priceWithCoupon;
	Scanner sc;
	
	DecimalFormat df = new DecimalFormat("0,000"); // ���ڸ� 000,000 ǥ�����ִ� Ŭ���� ����

	HashMap<String, String> couponMap = new HashMap<String, String>();
	
	Cars c;
	CarFrame selCar;
	UserCard user;
	User u;
	CreditCard credit;
	CheckCard check;
	boolean flag = false;
	boolean flag2 = false;

	ArrayList<String[]> couponKey = new ArrayList<String[]>();

	Payment()
	{
		user = new UserCard();
		credit = new CreditCard();
		check = new CheckCard();
		u = new User();
	}

	Payment(Cars c, CarFrame selCar)
	{
		user = new UserCard();
		credit = new CreditCard();
		check = new CheckCard();
		u = new User();
		this.c = c;
		this.selCar = selCar;	
	}

	public void setPaidAmount(int paidAmount)
	{
		this.paidAmount = paidAmount;
	}
	
	public int getPaidAmount()
	{
		return paidAmount;
	}

	public void setPriceWithCoupon(int priceWithCoupon)
	{
		this.priceWithCoupon = priceWithCoupon;
	}

	public int getPriceWithCoupon()
	{
		return priceWithCoupon;
	}
	

	// �ܺο��� ������ ���� ȣ���ϴ� �޼ҵ�
	public boolean run(int price)
	{
		boolean success = false;
		this.price = price;

		couponAdd();
		select();

		switch (sel)
		{
			case 1: System.out.println("\n\n* ���� ���� ���� �ݾ� : " + df.format(priceWithCoupon) + " *"); inputCash(); break;
			case 2: System.out.println("\n\n* ���� ���� ���� �ݾ� : " + df.format(priceWithCoupon) + " *"); inputCardNum(); break;
		}
	
		System.out.print("\n\n--------------------------------------------------------------------\n\n");

		success = true;

		return success; 
	}
	
	// ���� ��ȸ �� ����
	void couponAdd()
	{
		couponMap = u.getCoupon();

		Object[] mapkey = couponMap.keySet().toArray();
		Arrays.sort(mapkey);

		price *= (100-(Double.parseDouble(String.valueOf(couponMap.get(mapkey[0])))))/100;
		priceWithCoupon = Math.round(price/10)*10;

		System.out.print("\n\n--------------------------------------------------------------------\n\n");
		System.out.println("\n* ���� ���� ��� *\n");
		
		for (Object obj : mapkey)
			couponKey.add(String.valueOf(obj).split(":::"));
		
		int i = 1; 

		for (String[] str : couponKey)
		{
			System.out.println(i+". "+str[1]);
			i++;
		}
			
		System.out.print("\n\n* ���� ���� �������� ���� ������ �ڵ� ����˴ϴ�. *\n");
	}

	// ����, ī�� ����
	private void select()
	{
		sc = new Scanner(System.in);
 
		System.out.print("\n\n--------------------------------------------------------------------\n\n");

		do
		{
			System.out.println("\n�� ���� ��� ���� ��\n");
			System.out.println("1. ���� ���� ");
			System.out.println("2. ī�� ���� ");
			System.out.print("\n>> �Է�: ");
			sel = sc.nextInt();
		}
		while (sel!=1 && sel!=2);
	}

	// ���� ���� �޼ҵ�
	private void inputCash()
	{
		sc = new Scanner(System.in);

		int inputCash;

		user.setPayment("����");
		
		do
		{
			System.out.print("\n\n--------------------------------------------------------------------\n\n\n");
			System.out.println("������ �����ϼ���.");
			System.out.print("\n>> ");
			inputCash = sc.nextInt();
		}
		while (!isCash(inputCash));
		
		paidAmount += inputCash; // ����ڰ� ������ �ݾ��� �հ踦 ����

		if (inputCash > price)
		{
			change = inputCash-price;
			price = 0;
			System.out.println("\n\n���� �ݾ� : " + price);
			System.out.println("�Ž�����  : " + df.format(change));
		}
		else if (inputCash == price)
		{
			price = 0;
			System.out.println("\n\n���� �ݾ� : " + price);
			System.out.println("�Ž�����  : " + df.format(change));
		}
		else if (inputCash < price)
		{
			price -= inputCash;
			System.out.println("\n\n���� �ݾ� : " + df.format(price));
			inputCash();
		}
		if(flag==false)
		{
			printChange();
			printPaymentResult();
			flag = true;
		}
	}

	private boolean isCash(int inputCash)
	{
		for (int i : cash)
		{
			if(inputCash == i)
				return true;
		}
		return false;	
	}

	public void printChange()
	{
		int cnt;
		String s = "";
		flag = true;

		System.out.print("\n\n--------------------------------------------------------------------\n\n\n");
		printSleep("�Ž����� ��ȯ ��");
		System.out.print("\n--------------------------------------------------------------------\n\n\n");

		for (int i=0; i<cash.length; i++)
		{
			if (change!=0)
			{
				cnt = change/cash[i];
				change %= cash[i];
				
				if (cnt>0)
				{
					if (i==1)
					{
						System.out.printf("��������������������\n");
						System.out.printf("��  10000 ��  �� %d\n", cnt);
						System.out.printf("��������������������\n");
					}
					if (i == 2)
					{
						System.out.printf("������������������\n");
						System.out.printf("��  5000 �� �� %d\n", cnt);
						System.out.printf("������������������\n");
					}
					if (i == 3)
					{
						System.out.printf("������������������\n");
						System.out.printf("��  1000 �� �� %d\n", cnt);
						System.out.printf("������������������\n");
					}
					if (i== 4)
					{
						System.out.printf(" ��ۨ� �� %d", cnt);
					}
					if (i == 5)
					{
						System.out.printf(" ��ۨ� �� %d", cnt);
					}
					if (i == 6)
					{
						System.out.printf(" ��� �� %d", cnt);
					}
					if (i == 7)
					{
						System.out.printf(" ��� �� %d", cnt);
					}
				}
			}
		}
		System.out.printf("\n%s\n", s);
		System.out.print("\n--------------------------------------------------------------------\n\n");
	}


	// ����� ī�� �Է� �޴� �޼ҵ� (ī�帮���� ����)
	private void inputCardNum()
	{
		sc = new Scanner(System.in);

		int n;	// ����ڰ� ������ ī���

		System.out.print("\n\n--------------------------------------------------------------------\n\n");
		
		do
		{
			System.out.println("\nī��縦 �������ּ���.\n");

			for (int i=0; i<user.BANK_LIST.length; i++)
			{
				System.out.printf("%d. %s\n", (i+1), user.BANK_LIST[i]);
			}
			System.out.print("\n\n>> �Է�: ");

			n = sc.nextInt();
		}
		while (n<1 || n>7);
		
		switch (n)
		{
			case 1: user.setBank("����"); break;
			case 2: user.setBank("����"); break;
			case 3: user.setBank("�Ե�"); break;
			case 4: user.setBank("�Ｚ"); break;
			case 5: user.setBank("����"); break;
			case 6: user.setBank("�츮"); break;
			case 7: user.setBank("�ϳ�"); break;
		}
		
		System.out.print("\n\n--------------------------------------------------------------------\n\n");
		System.out.print("\nī���ȣ 16�ڸ��� �Է����ּ���(������ ����) : ");
		user.setNum(sc.next());

		cardCompare();
		seperate();
		printPaymentResult();
	}

	private void cardCompare()
	{
		// üũī�� ��ȣ�� key�� �����ϰ�, value�� �Է��� ī��簡 ������ 
		if (check.containsNum(user.getNum()) && (check.getBank(user.getNum()) == user.getBank()))
		{
			user.setValid(true);		// ��ȿ�ϰ�
			user.setType(false);		// üũī��
		}
		else if (credit.containsNum(user.getNum()) && (credit.getBank(user.getNum()) == user.getBank()))
		{
			user.setValid(true);		// ��ȿ�ϰ�
			user.setType(true);			// �ſ�ī��
		}
		else
		{
			user.setValid(false);
			System.out.println("\n* ��ȿ���� ���� ī���ȣ �Դϴ�. *\n");
			inputCardNum();		// �����ܰ�� ���ư��� �� ���� �ʿ�
		}
	}

	private void seperate()	// �Ͻú�, �Һ�(����) 
	{
		sc = new Scanner(System.in);
		int n=0;
		int halbu=0;

		//�Ͻú� �Һ� ����
		if(user.getValid()==true && price>=50000)
		{
			System.out.print("\n\n--------------------------------------------------------------------\n\n");

			do
			{
				System.out.println("\n���Ͻô� ���� ����� �������ּ���.\n");
				System.out.println("1. �Ͻú�");
				System.out.println("2. �Һ�");
				System.out.print("\n>> ");
				n = sc.nextInt();
			}
			while (n!=1 && n!=2);

			if (n==2 && user.getType()==false)
			{	
				System.out.println("\n* üũī��� �Ͻú� ������ �����մϴ�. *\n");
				seperate(); 
			}
			else if(n==2 && user.getType()==true)
			{
				do
				{
					System.out.print("\n�Һ� ���� ���� �Է��ϼ���(2~12) : ");
					System.out.print("\n>> �Է�: ");
					halbu = sc.nextInt();
				}
				while (halbu<2 || halbu>12);
				user.setPayment("�Һ�(" + halbu + "����)");
			}
		}
		
		System.out.println();
		if (flag2==false)
		{
			System.out.print("\n--------------------------------------------------------------------\n\n\n");
			printSleep("���� ���� ��");
			System.out.print("\n--------------------------------------------------------------------\n\n");
			flag2=true;
		}
		
		System.out.println();
	}
	
	private void printPaymentResult()
	{
		System.out.println("\n* "+user.getPayment() + " ���� �Ϸ� *");
	}

	public String getUserValue()
	{
		return user.getBank() + " " + user.getNum();
	}
	
	public Cars changeRentalState()
	{
		for(int i=0; i<c.whole.length; i++)
		{
			if(c.whole[i].getCarNum().equals(selCar.getCarNum()))
			{
				c.whole[i].setRentalState(false);
			}
		}

		return c;
	}

	public void printSleep(String str)
	{
		try
		{
			Thread.sleep(500);
		}	
		catch (InterruptedException e)
		{
			System.out.println(e.toString());
		}	

		System.out.print("  ��");

		try
		{
			Thread.sleep(500);
		}	
		catch (InterruptedException e)
		{
			System.out.println(e.toString());
		}		
		
		System.out.print("��");

		try
		{
			Thread.sleep(500);
		}			
		catch (InterruptedException e)
		{				
			System.out.println(e.toString());
		}		

		System.out.print("�� ");		
		
		try
		{
			Thread.sleep(500);
		}			
		catch (InterruptedException e)
		{
			System.out.println(e.toString());
		}	
		
		System.out.print(str);		

		try
		{
			Thread.sleep(500);
		}
		catch (InterruptedException e)
		{
			System.out.println(e.toString());
		}		

		System.out.print(" ��");	
		
		try
		{
			Thread.sleep(500);
		}		
		catch (InterruptedException e)
		{
			System.out.println(e.toString());
		}

		System.out.print("��");	
		
		try
		{
			Thread.sleep(500);
		}		
		catch (InterruptedException e)
		{
			System.out.println(e.toString());
		}

		System.out.print("��");		
		
		try
		{
			Thread.sleep(500);
		}	
		catch (InterruptedException e)
		{
			System.out.println(e.toString());
		}	
		
		System.out.println("\n");
	}
}