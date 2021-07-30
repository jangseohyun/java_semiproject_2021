import java.util.Scanner;


class CheckSelection
{
	//���ó��� �����ֱ�
	int userSel;
	String[] reserveInfo;
	CarFrame selCar;

	CheckSelection(String[] reserveInfo, CarFrame selCar)
	{
		this.reserveInfo = reserveInfo;
		this.selCar = selCar;
	}
	

	public int checkInfo1()
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("\n=========================================\n");
		// �뿩������(�ð�����)
		System.out.printf("�뿩 ���� ��¥ : %s\n", reserveInfo[2]);
		// �ݳ�������(�ð�����)
		System.out.printf("�ݳ� ���� ���� : %s\n", reserveInfo[3]);
		// ���� ����
		System.out.printf("���� ���� : %s\n", selCar.getCarModel());
		// ���� �ɼ�
		System.out.printf("���� �ɼ� : %s\n", selCar.getInsuOption());
		System.out.print("=========================================\n");
		
		int n;

		do
		{
			System.out.print("\n�Էµ� ������ �½��ϱ�?\n\n");
			System.out.print("1. ��\n");		// ���� �ݾ�����
			System.out.print("2. �ƴϿ�\n");	
			System.out.print("\n\n>> �Է�: ");	// 1. ��, 2. �ƴϿ�
			n = sc.nextInt();					// y �Է��ϸ� ���� �ݾ����� 		    
		}
		while (n<1 || n>2);

		switch (n)
		{  
			case 1: userSel=1; break;	
			case 2: userSel=2; break;
		}
	
		return userSel;
	}

	public int checkInfo2()
	{
		Scanner sc = new Scanner(System.in);

		int n;

		do
		{
			System.out.print("1. ��¥ �� �ð� ���Է�\n");
			System.out.print("2. ���� ���Է�\n");
			System.out.print("3. ���� �ɼ� ���Է�\n");
			System.out.print(">> �Է�: ");
			n = sc.nextInt();
			System.out.println();
		}
		while (n<1 || n>4);
		
		switch (n)
		{
			case 1: userSel=1 ; break;	
			case 2: userSel=2 ; break;
			case 3: userSel=3 ; break;	
		}
		
		return userSel;
	}
}


/*
- ���� ���� Ȯ�� �� '�Էµ� ������ �½��ϱ�?
======================================
�뿩 ���� ��¥ : 2021.03.12(��) 15:00
�ݳ� ���� ���� : 2021.03.15(��) 15:00
���� ���� : �ô����׽ý� G80
���� �ɼ� : �ڱ�δ�� 30����
======================================
- 1. �� �� ���� �ݾ� �ȳ�
- 2. �ƴϿ� �� ���ư��� �ɼ� ���
1. ��¥ �� �ð� ���Է�
2. ���� ���Է�
3. ���� �ɼ� ���Է�
- 1�� ���� ��, ����, ����ɼ� �Է��ϴ� �κ� ���ļ� ���������� ���ƿ�����.
*/