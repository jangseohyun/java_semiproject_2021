import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Calendar;


class Inquiry
{	
	User loginUser;
	InputDate id;
	Payment pm;
	static Reserv rs;
	static CarFrame selCar;
	static UserData ud;

	String[] reserveInfo;
	String loginUserId;

	String paymentType;
	String userCardNum;
	String userCardBank;
	int paidAmount;
	int amount;
	int priceWithCoupon;

	String reserveNum = "";

	DecimalFormat df;

	{
		loginUser = new User();
		rs = new Reserv();
		selCar = new CarFrame();
		ud = new UserData();
		pm = new Payment();
		df = new DecimalFormat("0,000");
	}

	Inquiry()
	{		
	}

	// ����ڰ� ���� ������ ����ϴ� ������
	Inquiry(CarFrame selCar, String loginUserId, UserData ud, String[] reserveInfo, String paymentType, int paidAmount, int priceWithCoupon)
	{
		this.selCar = selCar;
		this.loginUserId = loginUserId;
		this.ud = ud;
		this.reserveInfo = reserveInfo;
		this.paymentType = paymentType;
		this.paidAmount = paidAmount;
		this.priceWithCoupon = priceWithCoupon;
	}

	// ����ڰ� ī�� ������ ����ϴ� ������
	Inquiry(CarFrame selCar, String loginUserId, UserData ud, String[] reserveInfo, String paymentType, String userCardNum, String userCardBank, int priceWithCoupon)
	{
		this.selCar = selCar;
		this.loginUserId = loginUserId;
		this.ud = ud;
		this.reserveInfo = reserveInfo;
		this.paymentType = paymentType;
		this.userCardNum = userCardNum;
		this.userCardBank = userCardBank;
		this.priceWithCoupon = priceWithCoupon;
	}


	// �뿩�� �̸� �������� �� loginUserId

	// ������ ���� �������� 
	String selCarType = selCar.getCarType();
	

	public void clear()
	{	
		if (loginUser.getName()==reserveInfo[0] && loginUser.getLicenseNum()==reserveInfo[1])	//���� ������ ���� �Ϸ� ������ ������
		{
			//����� ������ ���� �Ϸ� ������ ������
			System.out.print("���� �������� ����ī\n");
			System.out.print("        �뿩������         |         �ݳ�������        |     ����    \n");
			System.out.print("==================================================================\n");
			
			// �뿩 ������, �ݳ� ������, inputdate
			// ���� TestCar���� ��������
			System.out.printf(" %20s | %20s | %s \n", reserveInfo[2], reserveInfo[3], selCar.getCarModel());

			System.out.print("==================================================================\n\n");
			}
		
		// ����
		Scanner sc = new Scanner(System.in);

		int n;

		do
		{
			System.out.print("1. ���� Ȯ�μ� �����\n");
			System.out.print("2. �������� �ǵ��ư���\n");
			System.out.printf(">> �Է� : ");
			n = sc.nextInt();
			System.out.println();
		}
		while (n<1 || n>3);
		
		// 1���� �� ���� Ȯ�μ� ����� �� 2���� �� �������� �ǵ��ư��� �� login();
		switch (n)
		{
			case 1: if(paymentType.equals("����"))
					cashReceiptPrint(); 
				else
					cardReceiptPrint();
				break;
			case 2: return;	// Start���� clear()�� ȣ���� �κ����� �ǵ��ư�
		}
	}
	
	public void reserveNumber()
  	{
      	Calendar cal = Calendar.getInstance();
      	String mm = "M";

      	int y, m, d;
      	int rand = (int)(Math.random()*1000);

      	y=cal.get(Calendar.YEAR);
      	m=cal.get(Calendar.MONTH)+1;
      	d=cal.get(Calendar.DATE);

		if(m==10 || m==11 | m==12)
			reserveNum = mm + y + m + d + rand ;
      	else
      		reserveNum = mm + y + "0" + m + d + rand ;
  	}

	public void cashReceiptPrint()	
	{
		if (reserveNum=="")
			reserveNumber();

		System.out.println("\n===================================");
		System.out.println("            [���� Ȯ�μ�]          ");
		System.out.println("===================================");
		System.out.printf("[�����ȣ]%24s\n", reserveNum);
		System.out.printf("[�� �� ��]%20s\n",loginUser.getName());
		System.out.printf("[�뿩����]%20s\n", reserveInfo[2]);
		System.out.printf("[�ݳ�����]%20s\n", reserveInfo[3]);
		System.out.printf("[��    ��]%20s\n", selCar.getCarModel());
		System.out.printf("[������ȣ]%24s\n", selCar.getCarNum());
		System.out.printf("[����ɼ�]%18s\n", selCar.getInsuOption());
		System.out.println("===================================");
		System.out.printf("[�������]%23s\n", paymentType);	
		System.out.printf("[���Աݾ�]%24s\n", df.format(paidAmount));
		System.out.printf("[�����ݾ�]%24s\n", df.format(priceWithCoupon));
		System.out.printf("[�Ž�����]%24s\n", df.format(paidAmount-priceWithCoupon));
		System.out.println("===================================");

		System.out.println("\n* �ʱ� ȭ������ ���ư��ϴ�. *");
		System.out.println("* �̿����ּż� �����մϴ�. *");

		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			System.out.println(e.toString());
		}

		System.out.print("\n\n--------------------------------------------------------------------\n\n");
	}

	public void cardReceiptPrint()	
	{
		if (reserveNum=="")
			reserveNumber();

		System.out.println("\n===================================");
		System.out.println("            [���� Ȯ�μ�]          ");
		System.out.println("===================================");
		System.out.printf("[�����ȣ]%24s\n", reserveNum);	
		System.out.printf("[�� �� ��]%20s\n",loginUser.getName());
		System.out.printf("[�뿩����]%20s\n", reserveInfo[2]);
		System.out.printf("[�ݳ�����]%20s\n", reserveInfo[3]);
		System.out.printf("[��    ��]%24s\n", selCar.getCarModel());
		System.out.printf("[������ȣ]%24s\n", selCar.getCarNum());
		System.out.printf("[����ɼ�]%18s\n", selCar.getInsuOption());
		System.out.println("===================================");
		System.out.printf("[�������]%24s\n", paymentType);
		System.out.printf("[�����ݾ�]%24s\n", df.format(priceWithCoupon));	
		System.out.println("===================================");

		System.out.println("\n* ���� ȭ������ ���ư��ϴ�. *");
		System.out.println("* �̿����ּż� �����մϴ�. *");

		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			System.out.println(e.toString());
		}

		System.out.print("\n\n--------------------------------------------------------------------\n\n");
	}
}