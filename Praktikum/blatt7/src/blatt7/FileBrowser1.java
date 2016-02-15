package blatt7;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.LinkedList;

public class FileBrowser1 {

	public static void main(String[] args) throws IOException {
		File dir = new File("/home/aiham/Pictures");
		List<String> list = new LinkedList<String>();
	//	DirectorySearchVisitor v = new DirectorySearchVisitor();
		DirectoryPrintVisitor v = new DirectoryPrintVisitor();

	//	dirPrint(dir);
//		dirSearch(dir, ".txt", list);
		
	//	v.setExtension(".txt");
		traverse(dir, v);

//		for (String s : v.getSearchList()) {
//			System.out.println(s);
//		}
//	System.out.println(" " + list + " ");

	}

	public static void traverse(File dir, DirectoryVisitor visitor) {
		File[] files = dir.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				visitor.enterDirectory(f);
				traverse(f, visitor);
				visitor.leaveDirectory(f);
			} else {
				visitor.visitFile(f);
			}
		}
	}

	public static void dirPrint(File file) throws IOException {
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				System.out.println("\n *Ordner : " + f.getAbsolutePath()
						+ "    \n *Name des Ordners : " + f.getName()
						+ "    \n *Göße des Ordners in B :" + f.length()
						+ "B");
				dirPrint(f);
			} else {
				System.out.println("\n *Datei : " + f.getAbsolutePath()
						+ "    \n *Name der Datei : " + f.getName()
						+ " \n *Göße der Datei in B : " + f.length() 
						+ "B");

			}
		}
	}

	public static void dirSearch(File file, String txt, List<String> list)
			throws IOException {
		File[] files = file.listFiles();
		if (files != null) {
			for (File f : files) {
				if (!f.isDirectory()) {
					if (f.getName().endsWith(txt)) { // ".txt" funktioniert !
						list.add(f.getName());
						dirSearch(f, ".txt", list); //

					}
				} else {
					dirSearch(f, ".txt", list); // 
				}

			}

		}
	}

}