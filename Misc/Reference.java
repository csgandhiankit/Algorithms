

public class Reference{


	public static void main(String[] args) {
		int a = 3;
		int b = a;

		System.out.println("Value of b before change: " + b);
		System.out.println("Value of a before change: " + a);


		a = a + 3;

		System.out.println("Value of b after change: " + b);

		System.out.println("Value of a after change: " + a);

	}
}