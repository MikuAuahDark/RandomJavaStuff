import java.util.*;

class ArrayStuff {
	public static void main(String[] args) {
		// Array
		// <tipe data> <namaVariabel>[]; (tidak terinitialisasi)
		// <tope data> <namaVariabel>[] = <nilai>
		// Tanda "[]" menandakan tipe array.
		// Memperbanyak "[]" meningkatkan dimensi array.

		// Array apapun itu bertipe data reference.
		boolean arrayBoolean[] = null;
		// System.out.println(arrayBoolean[0]); // NullPointerException!
		
		// Membuat array baru:
		// new <tipe data>[n1]
		// Banyak [...] tergantung dari dimensi array.
		// Dibawah akan membuat array dengan 20 elemen
		arrayBoolean = new boolean[20];

		// Secara default, jika bertipe data primitif
		// maka elemennya akan diset semua ke 0/false
		// Indeks array mulai dari 0 sampai dengan array.length - 1
		System.out.println(arrayBoolean[0]); // false
		System.out.println(arrayBoolean[arrayBoolean.length - 1]); // false
		//  System.out.println(arrayBoolean[arrayBoolean.length]); // ArrayIndexOutOfBoundsException!

		// Membuat array tipe data reference (contoh: String)
		// akan men-set semua elemennya ke null
		String arrayString[] = new String[3];
		System.out.println(arrayString[2] == null); // komparasi menghasilkan boolean!

		// Menset elemen
		arrayString[0] = "Septi";
		arrayString[1] = "Raf";
		arrayString[2] = arrayString.getClass().getName(); // [Ljava.lang.String
		// Print elemen
		System.out.println(arrayString.length);
		System.out.println(arrayString[0]);
		System.out.println(arrayString[1]);
		System.out.println(arrayString[2]);
		// System.out.println(arrayString[3]); // INGAT INDEKS MULAI DARI 0

		// Array 2 dimensi ditandai dengan 2 tanda "[]"
		int array2Dimensi[][] = new int[2][2];
		System.out.println(array2Dimensi.getClass().getName()); // [[i

		// Mengakses array multidimensi dianggap mengurangi 1 dimensi array
		// Perhatikan bahwa tanda "[]" hanya 1x karena array2Dimensi[n] itu mengurangi 1 dimensi.
		// Jadi, dari int[][] array2Dimensi, jika diakses array2Dimensi[n] (n = index)
		// maka nilainya bertipe data int[] (int array 1 dimensi)
		int index0Array2D[] = array2Dimensi[0];

		// Karena array dimensi apapun bertipe data reference, maka
		// memodifikasi elemen index0Array2D berefek ke array2Dimensi[0] pula.
		index0Array2D[0] = 20010606;
		index0Array2D[1] = 687291;
		System.out.println(array2Dimensi[0][0]); // 20010606
		System.out.println(array2Dimensi[0][0] == index0Array2D[0]); // true
		System.out.println(array2Dimensi[0][1]); // 687291
		System.out.println(array2Dimensi[0][1] == index0Array2D[1]); // true
	}
}
