class StringManipulation {
	public static void main(String[] args) {
		// String, meskipun objek, tapi didesain agar tidak bisa
		// dimodifikasi (immutable).

		// Membuat String dengan method "new String(...)" bisa dengan
		// memberi array 1 dimensi "char".
		String test = new String(new char[] {'H', 'e', 'l', 'l', 'o'});
		System.out.println("String test = " + test);

		// Mengkomparasi String tidak akan bekerja semestinya dengan
		// komparasi ==.
		System.out.print("test == \"Hello\" = ");
		System.out.println(test == "Hello"); // false
		// Namun, gunakan method ".equals" dari objek String
		System.out.print("test.equals(\"Hello\") = ");
		System.out.println(test.equals("Hello")); // true

		// Operator + pada String menggabung String tersebut.
		// Untuk efisiensi program, sebaiknyya hanya gunakan operator +
		// jika tidak sering. Tapi untuk PP2019, tidak apa2.
		// Jika sering menambah String, gunakan StringBuilder (pelajari sendiri)
		// StringBuilder: https://docs.oracle.com/javase/7/docs/api/java/lang/StringBuilder.html
		String world = test + " World";
		System.out.println(world); // Hello World
		System.out.println(test + test + test + test); // HelloHelloHelloHello

		// Method2 pada String.
		String animeMovieName = world + " Anime";
		System.out.println(animeMovieName); // Hello World Anime
		// Method .equals(String) digunakan untuk mencocokkan String
		System.out.println(animeMovieName.equals("Hello World Anime")); // true
		// Method .equalsIgnoreCase(String) mengabaikan kapitalisasi string.
		// Perhatikan perbedaannya dibawah!
		System.out.println(animeMovieName.equals("hELLO wORLD aNIME")); // false
		System.out.println(animeMovieName.equalsIgnoreCase("hELLO wORLD aNIME")); // true
		// Method .substring memotong string. Method ini memiliki banyak overload.
		// Method .substring(int mulai). Ingat bahwa indeks "mulai" mulai dari 0 (awal string)
		// Ingat juga nilai yang dihasilkan method bisa langsung digunakan
		// sebagai nilai parameter sebuah method.
		System.out.println(animeMovieName.equals(animeMovieName.substring(0))); // true
		// Method .substring(int mulai, int selesai), dengan syarat mulai <= selesai.
		System.out.println(animeMovieName.substring(6, 11)); // World
		// Indeks-indeks yang ditaruh dimethod .substring harus diantara panjang string.
		// System.out.println(animeMovieName.substring(12345)); // IndexOutOfBoundsException
		// Method .toCharArray mengubah String menjadi array "char" (1 dimensi)
		// Ingat bahwa array elemen-elemennya bisa dimodifikasi.
		char animeName[] = animeMovieName.toCharArray();
		System.out.println(animeName);
		animeName[1] = 'a'; // Info: tidak ada method untuk mengubah isi karakter pada String.
		// Tambahan untuk "new String(...)"
		// 0 = offset awal (0 = mulai dari 'H')
		// 5 = panjang (0 + 5 = 5 = sampai 'o' pada "Hello")
		System.out.println(new String(animeName, 0, 5)); // Hallo
		// Method-method string bisa dirantai, selama method itu menghasilkan String
		// Untuk "animeMovieName.toUpperCase().substring(6, 12).trim()", urutan methodnya adalah:
		// 1. toUpperCase()
		// 2. substring(...)
		// 3. trim()
		String pki = animeMovieName.toUpperCase().substring(6, 12).trim() + animeMovieName.substring(0, 5).toLowerCase();
		System.out.println(pki + pki.toUpperCase());

		// String.format adalah sebuah method yang membuat string berdasarkan pola
		// dan parameter tambahan yang diberikan.
		// Ingat pola yang diberikan HARUS sama dengan tipe data yang akan diberikan!
		//                             1  2    3    4     5
		String portal = String.format("%d|%02x|%20s|%-20s|%-10d|",
			12345, // %d (nomor) (1)
			// Type-casting: mengubah tipe data satu jadi tipe data lain!
			(int) 'E', // %02x (heksadesimal, 2 angka ditambahkan 0 jika perlu) (2)
			"Kombat", // %20s (string, ditambah spasi sampai 20 karakter pada sebelah kiri jika perlu) (3)
			"Indonesia", // %-20s (string, ditambah spasi sampai 20 karakter pada sebelah kanan jika perlu) (4)
			Integer.MAX_VALUE // %-10d (nomor, ditambah spasi sampai 10 karakter pada sebelah kanan jika perlu) (5)
		);
		System.out.println(portal);
		// Ini akan error
		// System.out.println(String.format("%d", "Error")); // IllegalFormatException!

		// Parameter pertama String.format juga bisa berupa variabel.
		// Karena setiap pola HARUS diawali dengan "%", maka ada juga
		// pola "%%" yaitu hanya menghasilkan "%" saja.
		String formatter = String.format("%%0%dd", portal.length());
		System.out.println("formatter = " + formatter); // formatter = %0<panjang>d
		String hasil = String.format(formatter, Long.MAX_VALUE - Integer.MAX_VALUE);
		System.out.println(hasil); // ditambah 0 jika perlu

		// Method printf pada PrintStream juga bekerja persis seperti String.format
		// tetapi langsung menulis ke PrintStream dan tidak menghasilkan kembali
		// string yang diformat. Pada contoh dibawah, System.out adalah PrintStream
		// yang langsung menulis ke console.
		//                 1    2  3  4
		System.out.printf("%10s %s %s %10s",
			formatter, // %10s (1)
			"Portal", // %s (2)
			"Kombat", // %s (3)
			"Indonesia" // %10s (4)
		);
	}
}
