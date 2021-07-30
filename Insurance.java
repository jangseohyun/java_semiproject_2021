import java.util.Vector;
import java.util.Scanner;
import java.io.IOException;
import java.util.Hashtable;
import java.util.InputMismatchException;
import java.text.DecimalFormat;


class Insurance
{
	static CarFrame selCar;
	Payment pm = new Payment();
	Cars cr = new Cars();

	private int sel;
	int selCarPrice;
	static double sum;
	static int amount;

	DecimalFormat df = new DecimalFormat("0,000"); // ���ڸ� 000,000 ǥ�����ִ� Ŭ���� ����

	int userSel;
	
	{
		selCar = new CarFrame();
	}	

	Insurance(CarFrame selCar)
	{
		this.selCar = selCar;
	}

	Insurance()
	{
	}


	public int selectIns()
	{
		selCarPrice = cr.selCarPrice;

		Scanner sc = new Scanner(System.in);

		System.out.print("\n\n--------------------------------------------------------------------\n\n");
		System.out.println("\n*  ���� �������� �̵��մϴ�.  *");
		System.out.print("\n\n--------------------------------------------------------------------\n\n");
		
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			System.out.println(e.toString());
		}

		do
		{
			try
			{
				System.out.println("\n�� ���� �ɼ� ����(��� �� ������ �δ� �ݾ�) ��\n");
				System.out.println("1. �ڱ� �δ�� 5����");
				System.out.println("2. �ڱ� �δ�� 30����");
				System.out.println("3. �ڱ� �δ�� 70����");
				
				System.out.println("\n* ���� �ܰ�� ���ư���: -1 *");
				System.out.print("\n\n>> ������ �ɼ� ��ȣ �Է�(1~3): ");
				sel = sc.nextInt();
			}
			catch (InputMismatchException e)
			{
				sc = new Scanner(System.in);
				System.out.println("\n* �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. *");
			}
		}
		while(sel!=-1 && sel!=1 && sel!=2 && sel!=3);
		
		if(sel == -1)
			userSel = -1;

		if(sel == 1)
		{
			selCar.setInsuOption("�ڱ� �δ�� 5����");
			opCal_s();
		}
		else if(sel == 2) 
		{
			selCar.setInsuOption("�ڱ� �δ�� 30����");
			opCal_m();
		}
		else if(sel == 3)
		{
			selCar.setInsuOption("�ڱ� �δ�� 70����");
			opCal_l();	
		}

		return userSel;
	}
	
	// ���� �ɼ� 5����
	public void opCal_s()
	{
		double[] insRate = new double[24];
		insRate[0] = 1;
		double price=0;

		selCarPrice = cr.selCarPrice;

		for (int i=0;i<17 ;i++)
		{
				if (i<24)
					price += 0.0175*i*selCar.getInsurance()[0];
			
				else if (i>=24 && i<168)
				{
					price += 0.0125*i*selCar.getInsurance()[0];
				}
				else
					price += 0.005*i*selCar.getInsurance()[0];
					
		}

		sum = price + selCarPrice;
		
		System.out.print("\n\n-----------------------------------------------------------------------\n\n");
		System.out.println("\n* ���� ���� ���� �ݾ�: " + df.format((int)(Math.round(sum/10)*10)) + " �� *\n");
		amount = ((int)(Math.round(sum/10)*10));
	}
		
	// ���� �ɼ� 30����
	public void opCal_m()
	{
		double[] insRate = new double[24];
		insRate[0] = 1;
		double price=0;

		selCarPrice = cr.selCarPrice;
		
		for (int i=0;i<17 ;i++)
		{
				if (i<24)
					price += 0.015*i*selCar.getInsurance()[0];
			
				else if (i>=24 && i<168)
				{
					price += 0.0075*i*selCar.getInsurance()[0];
				}
				else
					price += 0.001*i*selCar.getInsurance()[0];
		}

		sum = price + selCarPrice;
		
		System.out.print("\n\n-----------------------------------------------------------------------\n\n");
		System.out.println("\n* ���� ���� ���� �ݾ�: " + df.format((int)(Math.round(sum/10)*10)) + " �� *\n");

		amount = ((int)(Math.round(sum/10)*10));
	}
	
	// ���� �ɼ� 70����
	public void opCal_l()
	{
		double[] insRate = new double[24];
		insRate[0] = 1;
		double price=0;

		selCarPrice = cr.selCarPrice;

		for (int i=0;i<17 ;i++)
		{
				if (i<24)
					price += 0.005*i*selCar.getInsurance()[0];
			
				else if (i>=24 && i<168)
				{
					price += 0.00075*i*selCar.getInsurance()[0];
				}
				else
					price += 0.0004*i*selCar.getInsurance()[0];
					
		}

		sum = price + selCarPrice;

		System.out.print("\n\n-----------------------------------------------------------------------\n\n");
		System.out.println("\n* ���� ���� ���� �ݾ�: " + df.format((int)(Math.round(sum/10)*10))+" �� *\n");

		amount = ((int)(Math.round(sum/10)*10));
	}
}