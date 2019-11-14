class Variables {
	public static void main(String[] args) {
		// Variabel:
		// <tipe data> <namaVariabel>; (tidak terinitialisasi)
		// <tipe data> <namaVariabel> = <nilai> (terinisialisasi)

		// <tipe data> = char
		// <namaVariabel> = hello
		// tidak terinisialisasi
		char hello;
		// System.out.println(hello); // error: variabel "hello" belum diinisialisasi
		hello = 'S'; // menginisialisasi nilai
		System.out.println(hello + "epti"); // tidak error
		
		// <tipe data> = int
		// <namaVariabel> = portal
		// <nilai> = 12345;
		int portal = 12345;
		System.out.println("portal = " + portal);

		// rentang int: -2147483648...2147483647
		// Integer.MIN_VALUE = -2147483648
		// Integer.MAX_VALUE = 2147483647
		int minValue = Integer.MIN_VALUE;
		// -2147483648 - 1 = -2147483649? TIDAK!
		// -2147483649 terlalu kecil untuk int.
		// Nilai minValue = 2147483647
		minValue -= 1; // a -= b -> a = a - (b);
		System.out.println("minValue = " + minValue);

		// Boolean hanya true(1)/false(0).
		// Menggunakan operator komparasi (==, !=, >, >=, <, dan <=)
		// (dan secara opsional) ditambah dengan operator AND (&&) atau OR (||)
		// menghasilkan nilai dengan tipe data boolean.
		boolean minValueIsIntegerMax = minValue == Integer.MAX_VALUE;
		System.out.println("minValue == Integer.MAX_VALUE? " + minValueIsIntegerMax);

		// String bukan tipe data primitif, tapi reference.
		// bedanya, kalo primitif tidak pernah null. Kalo reference bisa null.
		// Nilai "null" berarti nilainya tidak ada.
		// Mengakses objek yang "null" bisa menyebabkan "NullPointerException"!
		// "nilai tidak ada" beda dengan 0/false pada boolean/int/long/tipe data primitif
		// int intNull = null; // error: tidak bisa mengubah null ke int
		String stella = null;
		// System.out.println(stella); // melempar NullPointerException!
		stella = "Stella"; // sudah tidak null
		System.out.println(stella); // aman
	}
}
