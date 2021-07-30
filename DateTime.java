import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.Date;


class InputDate
{
	ReservData rd;
	String[] reserveInfo = new String[4];
	static boolean successEnd = false;
	User loginUser;

	String[] startDateArr;
	String[] endDateArr;
	
	{
		rd = new ReservData();
		loginUser = new User();
	}

	InputDate(User loginUser)
	{
		this.loginUser = loginUser; 
	}
	
	InputDate()	
	{	
	}

	Scanner sc = new Scanner(System.in);
	String startDate, startTime;
	String endDate, endTime;
	int userDaysStart,userDaysEnd;
	int userTimeStart,userTimeEnd;
	static int rentTime;

	Date time = new Date();
	
	// ���� �ð� ��������
	SimpleDateFormat nowTime1 = new SimpleDateFormat ("yyyy-MM-dd HH:mm");
	SimpleDateFormat nowTime2 = new SimpleDateFormat ("yyyy-MM-dd");
	SimpleDateFormat nowTime3 = new SimpleDateFormat ("HH:mm");
	String nowtime1 = nowTime1.format(time);
	String nowtime2 = nowTime2.format(time);
	String nowtime3 = nowTime3.format(time);
	String[] nowtime = nowtime3.split("");
	String nowtime10 = nowtime[0]+nowtime[1]+nowtime[2]+nowtime[3];

	// ���� ��,��,�� ��������
	Calendar cal = Calendar.getInstance();
	int nowY = cal.get(Calendar.YEAR);
	int nowM = cal.get(Calendar.MONTH)+1;
	int nowD = cal.get(Calendar.DATE);
	int nowH = cal.get(Calendar.HOUR_OF_DAY);
	int nowMn = cal.get(Calendar.MINUTE);
	int nowDays = compareDate(nowY,nowM,nowD);
	int nowTime = compareTime(nowH,nowMn);
	

	// �޷� ���η� �� �� ���
	void twoCalendar()
	{
		int w, w2, last, last2;
		int d = 1, n = 1;
		int n7;

		SimpleDateFormat year = new SimpleDateFormat ("yyyy");
		SimpleDateFormat month = new SimpleDateFormat ("MM");
		
		// ���� �ް� �� ���� �ޱ����� �޷¸��� ����ϱ� ����
		int y = Integer.parseInt(year.format(time));
		int m = Integer.parseInt(month.format(time));

		// ���� �޷� ����
		Calendar cal = new GregorianCalendar();
		cal.set(y,m-1,1);	//--�Է¹��� ������ ���� 1�Ϸ� ����
		w = cal.get(Calendar.DAY_OF_WEEK);	//--1���� �ش��ϴ� ����(�Ͽ���: 1)
		last = cal.getActualMaximum(Calendar.DATE);	//--��¥ �ִ밪(������ ��)

		// ������ �޷� ����
		Calendar cal2 = new GregorianCalendar();
		cal2.set(y,m,1);
		w2 = cal2.get(Calendar.DAY_OF_WEEK);
		last2 = cal2.getActualMaximum(Calendar.DATE);

		// ���
		System.out.print("\n-----------------------------------------------------------------------\n\n");
		System.out.println("\n*  ��¥ �������� �̵��մϴ�.  *");

		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			System.out.println(e.toString());
		}

		System.out.print("\n\n-----------------------------------------------------------------------\n\n");
		System.out.print("\n�� ��¥ ���� ��\n");

		System.out.printf("\n\n        [%d�� %d��]\t\t\t   [%d�� %d��]",y,m,y,m+1);
		System.out.print("\n\n ��  ��  ȭ  ��  ��  ��  ��         ��  ��  ȭ  ��  ��  ��  ��\n============================       ============================\n");
		

		// 1�� ������ ���� ���
		for (int i=1; i<w; i++)
			System.out.print("    ");

		for (int i=1; i<=42; i++)
		{	
			// ���� �޷� ä���
			// ������ �ϱ��� ���� ä������ ���� ĭ�� �������� ä���
			if (d <= last)
			{
				System.out.printf("%4d", d);
				d++;
			}
			else
				System.out.print("    ");

			// ������ �޷��� �� �־� ������ �Է�
			// ������ �޷� ù° ��
			if (w == 7)
			{
				System.out.printf("       ");

				for (int j=1; j<w2; j++)
					System.out.print("    ");

				for (int j=1; j<=8-w2; j++)
				{
					System.out.printf("%4d", j);
					// ������ �޷� ��¥ �����ϴ� ���� n
					n++;
				}
			}

			// ������ �޷� ��°, ��°, ��°, �ټ�° ��
			if (w == 14 || w == 21 || w == 28 || w == 35)
			{
				System.out.printf("       ");
				
				// �� �ֿ� �ش��ϴ� �ϸ� ����ϱ� ����
				n7 = n+7;

				for (int j=n; j<n7; j++)
				{
					System.out.printf("%4d", j);
					if (j==last2)
						break;
					n++;
				}
			}

			// ������ �޷� ����° ��
			if (w == 42)
			{
				System.out.printf("       ");
				
				// ������ �޷¿��� ����° �ֿ� ���� �ϴ� ���� ������ ���
				if (n<last2)
				{
					for (int j=n; j<=last2; j++)
					{
						if (n<=last2)
							System.out.printf("%4d", j);
					}
				}
			}

			// ����
			if (w%7==0 && w != 42 && i != last)
				System.out.println();
			w++;
		}

		System.out.print("\n============================       ============================\n");
	}// twoCalendar() ��

	// �뿩 ���� �Է�
	boolean userInputStart()
	{
		boolean success = false;
		String[] startDateSplit, startTimeSplit;
		int y, m , d, h, mn;
		y = m = d = h = mn = 0;
		int countD = 0;
		int countT = 0;

		// �޷� ���
		twoCalendar();
		
		// �ȳ� ���� ���
		System.out.println("\n* �뿩 ���� ��¥�� ���ú��� 14�� �̳��� ��¥ �߿��� ���� �����մϴ�. *");
		System.out.println("* ���� �ð����� 1�ð� ���ĺ��� ���� �����մϴ�. *");
		System.out.println("* ������ �ּ� 2�ð����� �ִ� 14�ϱ��� �����մϴ�. *\n");
		System.out.println("* ���� �� �ݳ��ð��� 10�� ������ ���� �����մϴ�. *\n");
		System.out.printf("\n* ���� �ð�: %s *\n\n\n",nowtime1);

		try
		{	
			do
			{
				if (countD != 0)
					System.out.println("\n** ��¥�� �߸� �Է��ϼ̽��ϴ�. **\n");

				System.out.printf("�뿩 ���� ��¥�� �Է��ϼ���.(��: %s) : ",nowtime2);
				startDate = sc.next();
				startDateSplit = startDate.split("-");
				y = Integer.parseInt(startDateSplit[0]);
				m = Integer.parseInt(startDateSplit[1]);
				d = Integer.parseInt(startDateSplit[2]);
				userDaysStart = compareDate(y,m,d); 
				
				countD++;

				if ((userDaysStart-nowDays) > 14)
				{
					System.out.println("\n** 14�� �̳��� ��¥���� ���� �����մϴ�. �ٽ� �Է����ּ���. **\n");
					countD = 0;
				}

				if ((userDaysStart-nowDays) < 0)
				{
					System.out.println("\n** ���� �ð� ���ĺ��� ���� �����մϴ�. �ٽ� �Է����ּ���. **\n");
					countD = 0;
				}
			}
			while ((y != nowY) || (m<1 || m>12) || (d<1 || d>31) || ((userDaysStart-nowDays) > 14) || (userDaysStart-nowDays) < 0);
		}
		catch (ArrayIndexOutOfBoundsException | NumberFormatException f)
		{
			System.out.println("\n** �ùٸ� �������� �Է��ϼ���.**\n");
			sc = new Scanner(System.in);
			userInputStart();
		}

		try
		{
			do
			{
				if (countT != 0)
					System.out.println("\n** �ð��� �߸� �Է��ϼ̽��ϴ�. **\n");

				System.out.printf("�뿩 ���� �ð��� �Է��ϼ���.(��: %s0): ",nowtime10);
				startTime = sc.next();
				startTimeSplit = startTime.split(":");
				h = Integer.parseInt(startTimeSplit[0]);
				mn = Integer.parseInt(startTimeSplit[1]);
				userTimeStart = compareTime(h,mn) + (userDaysStart-nowDays)*1440;
				
				countT++;
			
				while (mn!=0 && mn%10!=0) 
				{
					System.out.println("\n* �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. *\n");
				
					System.out.printf("�뿩 ���� �ð��� �Է��ϼ���.(��: %s0): ",nowtime10);
					startTime = sc.next();
					startTimeSplit = startTime.split(":");
					h = Integer.parseInt(startTimeSplit[0]);
					mn = Integer.parseInt(startTimeSplit[1]);
					userTimeStart = compareTime(h,mn) + (userDaysStart-nowDays)*1440;
				}
        	    	
				if ((userTimeStart-nowTime) < 60)
				{
					System.out.println("\n** 1�ð� ���ĺ��� ���� �����մϴ�. �ٽ� �Է����ּ���. **\n");
					countT = 0;
				}
				

			}
			while ((h<0 || h>23) || (m<0 || m>59) || ((userTimeStart-nowTime) < 60) || ((userTimeStart-nowTime) < 0));
		}
		catch (ArrayIndexOutOfBoundsException | NumberFormatException f)
		{
			System.out.println("\n** �ùٸ� �������� �Է��ϼ���.**\n");
			sc = new Scanner(System.in);
			userInputStart();
		}

		startDateArr = new String[]{Integer.toString(y), Integer.toString(m), Integer.toString(d), Integer.toString(h), Integer.toString(mn)};
		success = true;

		return success;
	} // userInputStart() ��

	// �ݳ� ���� �Է�
	String[] userInputEnd()
	{
		System.out.println();

		String[] endDateSplit, endTimeSplit;
		int y, m , d, h, mn;
		y = m = d = h = mn = 0;
		int countD = 0;
		int countT = 0;

		try
		{
			do
			{
				if (countD != 0)
					System.out.println("\n** ��¥�� �߸� �Է��ϼ̽��ϴ�. **");

				System.out.printf("�ݳ� ���� ��¥�� �Է��ϼ���.(��: %s) : ",nowtime2);
				endDate = sc.next();
				endDateSplit = endDate.split("-");
				y = Integer.parseInt(endDateSplit[0]);
				m = Integer.parseInt(endDateSplit[1]);
				d = Integer.parseInt(endDateSplit[2]);
				userDaysEnd = compareDate(y,m,d); 
				
				countD++;

				if ((userDaysEnd-userDaysStart) > 14)
				{
					System.out.println("\n** 14�� �̳��� ��¥���� ���� �����մϴ�. �ٽ� �Է����ּ���. **\n");
					countD = 0;
				}

				if ((userDaysEnd-userDaysStart) < 0)
				{
					System.out.println("\n** ���� �ð� ���ĺ��� ���� �����մϴ�. �ٽ� �Է����ּ���. **\n");
					countD = 0;
				}
			}
			while ((y != nowY) || (m<1 || m>12) || (d<1 || d>31) || ((userDaysEnd-userDaysStart) > 14) || (userDaysEnd-userDaysStart) < 0);
		}
		catch (ArrayIndexOutOfBoundsException | NumberFormatException f)
		{
			sc = new Scanner(System.in);
			System.out.println("\n** �ùٸ� �������� �Է��ϼ���.**\n");
			userInputEnd();
		}

		try
		{
			do
			{
				if (countT != 0)
					System.out.println("\n** �ð��� �߸� �Է��ϼ̽��ϴ�. **");

				System.out.printf("�ݳ� ���� �ð��� �Է��ϼ���.(��: %s0): ",nowtime10);
				endTime = sc.next();
				endTimeSplit = endTime.split(":");
				h = Integer.parseInt(endTimeSplit[0]);
				mn = Integer.parseInt(endTimeSplit[1]);
				userTimeEnd = compareTime(h,mn)  + (userDaysEnd-nowDays)*1440;
				rentTime = userTimeEnd-userTimeStart;

				countT++;

				while(mn!=0 && mn%10!=0)
				{	
					System.out.println("\n* �߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���. *\n");
				
					System.out.printf("�ݳ� ���� �ð��� �Է��ϼ���.(��: %s0): ",nowtime10);
					endTime = sc.next();
					endTimeSplit = endTime.split(":");
					h = Integer.parseInt(endTimeSplit[0]);
					mn = Integer.parseInt(endTimeSplit[1]);
					userTimeEnd = compareTime(h,mn)  + (userDaysEnd-nowDays)*1440;
					rentTime = userTimeEnd-userTimeStart;
        		
				}
        		
				if (((userTimeEnd - userTimeStart) < 120) || (userTimeEnd - userTimeStart) < 0)
				{
					System.out.println("\n** ���� �ð� 2�ð� ���ĺ��� ���� �����մϴ�. �ٽ� �Է����ּ���. **\n");
					countT = 0;
				}
			}
			while ((h<0 || h>23) || (m<0 || m>59) || ((userTimeEnd - userTimeStart) < 120) || ((userTimeEnd - userTimeStart) < 0));
		}
		catch (ArrayIndexOutOfBoundsException | NumberFormatException f)
		{
			System.out.println("\n** �ùٸ� �������� �Է��ϼ���.**\n");
			sc = new Scanner(System.in);
			userInputEnd();
		}

		endDateArr = new String[]{Integer.toString(y), Integer.toString(m), Integer.toString(d), Integer.toString(h), Integer.toString(mn)};	
		
		rd.putReservStartData(new Reserv(loginUser.getName(), loginUser.getLicenseNum(), startDateArr[0], startDateArr[1], startDateArr[2], startDateArr[3], startDateArr[4], endDateArr[0], endDateArr[1], endDateArr[2], endDateArr[3], endDateArr[4]));

		reserveInfo[0] = loginUser.getName();
		reserveInfo[1] = loginUser.getLicenseNum();
		reserveInfo[2] = startDateArr[0] + "�� " + startDateArr[1] + "�� " + startDateArr[2] +"�� "+ startDateArr[3] + "��" + startDateArr[4] + "��";
		reserveInfo[3] = endDateArr[0] + "�� " + endDateArr[1] + "�� " + endDateArr[2] +"�� "+ endDateArr[3] + "��" + endDateArr[4] + "��";

		return reserveInfo;
	}
	
	int compareDate(int y, int m, int d)
	{
		int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

		if (y % 4 == 0 && y % 100 !=0 || y % 400 == 0)
			days[1] = 29;

		int checkDays = (y-1)*365 + (y-1)/4 - (y-1)/100 + (y-1)/400;

		for (int i=0; i<m-1; i++)
			checkDays += days[i];

		checkDays += d;

		return checkDays;
	}

	int compareTime(int h, int mn)
	{
		int checkTime = (h*60) + mn;

		return checkTime;
	}
}

class DateTime
{
	public static void main(String[] args)
	{
		// �׽�Ʈ
		InputDate id = new InputDate();
		id.userInputStart();
		id.userInputEnd();
	}
}

/*
[���� ���]

        [2021�� 3��]                       [2021�� 4��]
 ��  ��  ȭ  ��  ��  ��  ��         ��  ��  ȭ  ��  ��  ��  ��
============================       ============================
       1   2   3   4   5   6                          1   2   3
   7   8   9  10  11  12  13          4   5   6   7   8   9  10
  14  15  16  17  18  19  20         11  12  13  14  15  16  17
  21  22  23  24  25  26  27         18  19  20  21  22  23  24
  28  29  30  31                     25  26  27  28  29  30

============================       ============================

�뿩 ���� ��¥�� �Է��ϼ���.(��: 2021-03-17) : 2021-03-17
�뿩 ���� �ð��� �Է��ϼ���.(��: 18:30): 18:30

�ݳ� ���� ��¥�� �Է��ϼ���.(��: 2021-03-17) : 2021-03-17
�ݳ� ���� �ð��� �Է��ϼ���.(��: 18:30): 20:30
����Ϸ��� �ƹ� Ű�� �����ʽÿ� . . .
*/