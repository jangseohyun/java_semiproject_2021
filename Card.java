import java.util.Scanner;
import java.util.Hashtable;


class UserCard
{
	static final String[] BANK_LIST = {"����", "����", "�Ե�", "�Ｚ", "����", "�츮", "�ϳ�"};
	private String payment;		// �Ͻú�, �Һ�(����) ��¿� ����
	private String num;
	private String bank;
	private boolean type;		// true = �ſ�, false = üũ(�⺻��)
	private boolean valid;

	UserCard()
	{
		payment = "�Ͻú�";
		type = false;
	}


	public void setPayment(String payment)
	{
		this.payment = payment;
	}

	public String getPayment()
	{
		return payment;
	}

	public void setNum(String num)
	{
		this.num = num;
	}

	public String getNum()
	{
		return num;
	}

	public void setBank(String bank)
	{
		this.bank = bank;
	}

	public String getBank()
	{
		return bank;
	}

	public void setType(boolean type)
	{
		this.type = type;
	}

	public boolean getType()
	{
		return type;
	}

	public void setValid(boolean valid)
	{
		this.valid = valid;
	}

	public boolean getValid()
	{
		return valid;
	}
}

class CreditCard  //�ſ�ī�� 
{

    Hashtable<String, String> creditHt;
	private static final String[] creditNums = {"5831-3390-2748-9301", "5012-6391-9204-2952", "1215-3276-5434-3423", "7219-5921-6954-2424", "3619-2477-3921-5945",
												"2361-1182-8231-2111", "2563-1630-6242-4182", "4136-7218-2295-2313", "4503-8691-2844-9524", "6383-2897-2521-5825"};
	private static final String[] creditBank = {"����", "����", "�Ե�", "�Ｚ", "����"};
	//-- ī���ȣ ���ڸ� 1=����, 2=����, 3=�Ե�, 4=�Ｚ, 5=����
	//-- ī���ȣ ���ڸ��� �°� ī��� ��������ֱ� ���� 
	//   ī���ȣ ���ڸ��� �������� �������� ���� ���·� ������ ����

	CreditCard()
	{
		creditHt = new Hashtable<String, String>();
		for (int i=0, j=0; i<creditNums.length; i++)
		{
			creditHt.put(creditNums[i], creditBank[j++]);
			if (j==creditBank.length)
				j=0;
		}
	}


	public Hashtable getCreditHt()
	{
		return creditHt;
	}

	public boolean containsNum(String num)
	{
		return creditHt.containsKey(num);
	}

	public String getBank(String num)
	{
		return creditHt.get(num);
	}
}


class CheckCard  //üũī��
{
    Hashtable<String, String> checkHt;

	// ī���ȣ ���ڸ� 2���� ���� Ȧ���� üũ, ¦���� �ſ�
	private static final String[] checkNums = {"2342-2222-3333-3426", "2547-7932-9950-7297", "7074-3953-5642-1368", "8139-3679-2951-9309", "0954-2345-2964-1020",
											   "2922-3333-4444-2346", "1234-5678-9123-2567", "4736-3451-4634-3458", "9232-4526-4072-4369", "7454-2916-6240-2350"};
	private static final String[] checkBank = {"����", "����", "����", "�츮", "�ϳ�"};
	// ī���ȣ ���ڸ� 6-����, 7-����, 8-����, 9-�츮, 0-�ϳ�

	CheckCard()
	{
		checkHt = new Hashtable<String, String>();
		for (int i=0, j=0; i<checkNums.length; i++)
		{
			checkHt.put(checkNums[i], checkBank[j++]);
			if (j==checkBank.length)
				j=0;
		}
	}


	public Hashtable getCheckHt()
	{
		return checkHt;
	}

	public boolean containsNum(String num)
	{
		return checkHt.containsKey(num);
	}

	public String getBank(String num)
	{
		return checkHt.get(num);
	}
}