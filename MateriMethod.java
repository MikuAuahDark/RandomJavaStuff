import java.io.*;

class MateriMethod {
	// "main" adalah sebuah method yang memiliki
	// 1 parameter: String[] (array 1 dimensi)
	// Formasi method adalah sebagai berikut
	// Catatan:
	// Tanda [ dan ] menandakan hal yang opsional
	// Tanda < dan > menandakan hal yang wajib
	// [akses = private] [static] <tipe data> <namaMethod>([parameter])
	// [akses] jika tidak didefinisikan default ke private
	// [static] jika tidak ada, maka method adalah method objek
	//          (harus ada objeknya terlebih dahulu)
	// <tipe data> = tipe data. void = tanpa tipe data.
	//               Jika tipe data selain "void" maka
	//               harus ada "return <nilai>;" pada semua
	//               kasus/kondisi
	// <namaMethod> = nama method.
	// [parameter] = Daftar parameter.
	//               Parameter terdiri dari <tipeData> <namaVariabel>
	//               Parameter lainnya dipisahkan dengan koma.
	//
	// Analisis main method
	// Method: public static void main(String[] args)
	// [akses] = public
	// [static] = ada (static method)
	// <tipe data> = void, tidak menghasilkan nilai apapun
	// <manaMethod> = main
	// [parameter] = 1 parameter
	//               String[] args
	//                 <tipe data> = String[] (array String 1 dimensi)
	//                 <namaVariabel> = args
	// Method tanpa [static] akan dipelajari nanti di Pemrograman Berbasis Objek.
	public static void main(String[] args) {
		// "println" yang sering digunakan pada "System.out.println"
		// adalah sebuah method non-statik, artinya perlu sebuah objek.
		// Method "println" ini adalah bagian dari kelas "java.io.PrintStream".

		// Analisis method PrintStream.println
		// Method: public void println(String x)
		// [akses] = public
		// [static] = tidak ada, perlu objek. Disini objek
		//            PrintStream sendiri adalah "System.out".
		// <tipe data> = void
		// <namaMethod> = println
		// [parameter] = beragam. Method overloading, lihat dibawah!
		System.out.println("Hello world");
		// Agar lebih mengerti konsep method overloading (mungkin)
		PrintStream outStream = System.out;
		outStream.println("Indira"); // println(String str). Indira
		outStream.println(687291); // println(int num). 687291
		outStream.println('T'); // println(char ch). T
		outStream.println(false); // println(boolean b). false

		// Contoh memanggil method dan menaruhnya di variabel
		String nimCalc = method(1, 1);
		outStream.println(nimCalc);
		// Atau bisa digunakan langsung untuk method lain
		// tanpa ditaruh ke variabel terlebih dahulu
		outStream.println(method(4, 2));

		// Memanggil method yang nantinya memanggil method
		outStream.println(methodDalamMethod(2, 1, 4));
		// Memanggil method dengan nama yang sama tapi dengan
		// parameter yang berbeda
		outStream.println(methodDalamMethod(11, "PKI"));

		// Memanggil method rekursif
		outStream.println("f(84) dari https://youtu.be/UlZSFIXsvD8 adalah");
		outStream.println(methodRekursif(84));
	}

	// Method yang menghitung x * 71 + y * 191 lalu mengubahnya menjadi String
	// dengan format "H<hasil>"
	static String method(int nimAngkaKeduaTerakhir /* x */, int minAngkaTerakhir /* y */) {
		return "H" + (nimAngkaKeduaTerakhir * 71 + minAngkaTerakhir * 191);
	}

	// Method overloading & memanggil method dalam method.
	// Method ini memiliki 3 parameter: int, int, dan int
	static String methodDalamMethod(int a, int b, int c) {
		return method(a, b) + method(a, c) + method(b, c);
	}

	// Method overloading.
	// Method ini memiliki 2 parameter: int dan String
	static String methodDalamMethod(int p, String s) {
		return method(0, p) + s;
	}

	// Contoh method rekursif
	// Method diadaptasi dari https://youtu.be/UlZSFIXsvD8
	// f(x) didefinisikan sebagai
	// f(x) = {
	//    x - 3       , x >= 1000
	//    f(f(x + 5)) , x < 1000
	// }
	static int methodRekursif(int x) {
		if (x >= 1000)
			return x - 3;
		else
			// Memanggil method dalam method
			// sama saja seperti umumnya memanggil method di
			// main method.
			return methodRekursif(methodRekursif(x + 5));
	}
}
