// Sebaiknya file ini tidak dicek untuk pemula!
// File ini jalankan untuk menjalankan semua file *.java
// di repository ini, kecuali file ini sendiri!
// Method-method yang digunakan disini belum dipelajari di PP2019!!!
import java.io.*;

class CompileJava {
	public static void main(String[] args) throws IOException, InterruptedException {
		File dir = new File(".");
		String currentFilename = CompileJava.class.getName() + ".java";

		for(String path: dir.list()) {
			File f = new File(path);
			if (
				path.equals(currentFilename) ||
				path.endsWith(".java") == false ||
				f.isFile() == false
			)
				continue;
			
			System.out.println("==========");
			// Compile
			System.out.println("Compiling " + path);
			Process javac = new ProcessBuilder("javac", path)
				.inheritIO()
				.directory(dir)
				.start();
			int exitVal = javac.waitFor();
			if (exitVal != 0) {
				System.err.println("javac " + path + " returns " + exitVal);
				System.exit(1);
			}
			javac.destroy();

			// Run
			System.out.println("Running " + path);
			String className = path.substring(0, path.length() - 5);
			Process java = new ProcessBuilder("java", className)
				.inheritIO()
				.directory(dir)
				.start();
			exitVal = java.waitFor();
			if (exitVal != 0) {
				System.err.println("java " + path + " returns " + exitVal);
				System.exit(1);
			}
			java.destroy();

			// Delete .class file
			(new File(className + ".class")).delete();
		}
	}
}
