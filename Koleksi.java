import java.util.*;

class Koleksi {
	public static void main(String[] args) {
		// ArrayList bekerja seperti Array tapi ada sedikit perbedaan.
		// Bikin ArrayList dengan jenis array String.
		// Perhatikan bahwa tidak ada "ukuran array" yang diberikan.
		// ArrayList otomatis mengatur panjangnya, alias panjangnya dinamis.
		// Perbedaan lainnya juga akan dituliskan dibawah.
		ArrayList<String> arrayString = new ArrayList<>();

		// Ini akan error:
		// ArrayList<int> arrayInt = new ArrayList<>(); // error
		// Solusi: Gunakan tipe data "Integer"
		// ArrayList<Integer> arrayInt = new ArrayList<>(); // Ok
		// Alasan: ArrayList tidak bisa menerima tipe data primitif.
		// "Wrapper" tipe data primitif ke reference
		// byte    -> Byte
		// char    -> Character
		// short   -> Short
		// int     -> Integer
		// long    -> Long
		// boolean -> Boolean

		// Menambahkan item dalam ArrayList dengan method .add
		arrayString.add("Indira"); // Bukan arrayString[0] = "Indira";
		arrayString.add("Septi"); // Bukan arrayString[1] = "Septi";
		arrayString.add("Annisa"); // Bukan arrayString[2] = "Annisa";
		// Mencek panjang array dengan method .size()
		System.out.println("ArrayList length " + arrayString.size()); // Bukan arrayString.length;
		// Memprint semua elemen
		for(String str: arrayString)
			System.out.println(str);
		// Menghapus entri 0 (Indira)
		arrayString.remove(0);
		// Elemen yang dihapus akan didorong untuk mengisi kekosongan.
		// Sebelum:
		// 0. Indira
		// 1. Septi
		// 2. Annisa
		// Sesudah:
		// 0. Septi
		// 1. Annisa
		// Ingat bahwa method juga bisa di nested.
		System.out.println("Index 0 Septi? " + arrayString.get(0).equals("Septi"));
		System.out.println("Index 1 Annisa? " + arrayString.get(0).equals("Annisa"));
		// Membersihkan ArrayList
		arrayString.clear();
		System.out.println("ArrayList length adalah 0? " + (arrayString.size() == 0)); // true

		// HashSet mirip seperti himpunan (matematika).
		// Contoh:
		// setA = {2, 4, 6, 8, 10}
		HashSet<Integer> setA = new HashSet<>();
		// Method .add menambah elemen ke HashSet
		setA.add(2); setA.add(4); setA.add(6); setA.add(8); setA.add(10);
		// setB = {1, 3, 5, 7, 9}
		HashSet<Integer> setB = new HashSet<>();
		// Elemen yang sama tidak akan ditambahkan 2 kali!
		// Perhatikan ada "setB.add(1);" sebanyak 2 kali
		setB.add(1); setB.add(1); setB.add(3); setB.add(5); setB.add(7); setB.add(9);
		// Method .iterator() menghasilkan iterator yang bisa digunakan
		// untuk mengambil nilai-nilai dalam HashSet.
		// Method .iterator() juga ada pada ArrayList dan HashSet (nanti dibawah)
		System.out.println("setA = " + iteratorToString(setA.iterator()));
		// HashSet juga memiliki method .size()
		System.out.println("n(setA) = " + setA.size());
		System.out.println("setB = " + iteratorToString(setB.iterator()));
		// Ingat tadi "setB.add(1);" dipanggil 2 kali, tapi karena duplikat
		// maka yang duplikat tidak akan ditambahkan.
		System.out.println("n(setB) = " + setB.size());
		// Method .contains mencek apakah sebuah nilai ada pada HashSet
		System.out.println("3 ada di setA? " + setA.contains(3));
		System.out.println("3 ada di setB? " + setB.contains(3));
		// Membuat himpunan baru dan mencari irisan
		// setC = setA ∩ setB
		HashSet<Integer> setC = new HashSet<>(setA);
		setC.retainAll(setB);
		// Print set
		System.out.println("setC = " + iteratorToString(setC.iterator()));
		System.out.println("n(setC) = " + setC.size());
		// Membuat himpunan baru dan membuat gabungan himpunan
		// setD = setA ∪ setB
		HashSet<Integer> setD = new HashSet<>(setA);
		setD.addAll(setB);
		// Print set
		System.out.println("setD = " + iteratorToString(setD.iterator()));
		System.out.println("n(setD) = " + setD.size());

		// HashMap merupakan penyimpanan data dengan key tipe data apapun
		// dan value tipe data apapun. Ingatlah bahwa selama tipe data
		// itu sebuah objek, bisa dijadikan tipe data value, bahkan
		// nested "HashMap" bisa ditambahkan ataupun jadi bagian dari
		// ArrayList.
		// * HashMap<String, HashMap<Integer, String>> itu valid.
		// * HashMap<int, int> itu TIDAK valid. Tipe data harus berupa reference.
		// * HashMap<String, ArrayList<String>> itu valid.
		// * ArrayList<HashMap<Byte, Character>> itu valid.
		//      key     value
		HashMap<String, char[]> hashMapNIM = new HashMap<>();
		// Menambahkan data dengan method .put
		// Catatan: "H071191011" adalah String, jadi memiliki method toCharArray
		hashMapNIM.put("NPad93", "H071191010".toCharArray()); // NIM salah, harusnya 011
		hashMapNIM.put("Rizkuntul", "H071191052".toCharArray()); // NIM salah, harusnya 053
		// Mengganti nilai dengan .replace
		// Bedanya adalah jika sebelumnya tidak ditambahkan, maka tidak akan ditambahkan.
		hashMapNIM.replace("NPad93", "H071191011".toCharArray()); // char[] "H071191010"
		hashMapNIM.replace("Indira", "H071191023".toCharArray()); // null
		// Mengganti nilai dengan .put juga bisa dilakukan.
		// Dalam hal tersebut, method .put menghasilkan char array.
		// Catatan: Jika nilai belum di-set sebelumnya, maka method .put menghasilkan
		//          "null".
		char nimRizkuntulSalah[] = hashMapNIM.put("Rizkuntul", "H071191053".toCharArray());
		System.out.println(nimRizkuntulSalah);
		// Mengakses elemen dengan .get(...)
		System.out.println("NIM NPad93: " + new String(hashMapNIM.get("NPad93")));
	}

	// Contoh menggunakan Iterator
	static String iteratorToString(Iterator i) {
		StringBuilder sb = new StringBuilder("{");
		boolean hasAdd = false;

		// Method .hasNext() mencek apakah masih ada elemen selanjutnya
		while (i.hasNext()) {
			// Method .next() membaca nilai selanjutnya
			sb.append(i.next().toString());
			sb.append(", ");
			hasAdd = true;
		}

		if (hasAdd)
			sb.setLength(sb.length() - 2);

		sb.append('}');
		return sb.toString();
	}
}
