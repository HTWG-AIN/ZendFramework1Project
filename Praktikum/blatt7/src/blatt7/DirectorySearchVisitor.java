package blatt7;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DirectorySearchVisitor implements DirectoryVisitor {
	private String extension;
	private List<String> searchList = new LinkedList<String>();

	public void setExtension(String s) {
		extension = s;
	}

	public void clearSearchList() {
		searchList.clear();

	}

	public List<String> getSearchList() {
		return searchList;
	}

	@Override
	public void visitFile(File file) {

		if (file.getName().endsWith(extension)) {
			searchList.add(file.getName());
			Collections.sort(searchList);
			// System.out.println(searchList);
		}

	}

	@Override
	public void enterDirectory(File dir) {
		// leer

	}

	@Override
	public void leaveDirectory(File dir) {
		// leer

	}
}
