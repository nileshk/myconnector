// FileInputHandler
//
// Summary: simplified file input
//
// Java's IO framework is elegant, but simple operations are notoriously
// cumbersome to implement. This class attempts to address the issue
// by providing a simplified means of reading data (as a String) from
// a file one line at a time.
//
// Author: Dave Small
//
// History
//    v200111.27 - prettied up prior work.

package com.myconnector.client.util;

import java.io.*;

public class FileInputHandler {
	private BufferedReader reader;

	String filename = null;
	
	public FileInputHandler(String filename) {
		this.filename = filename;
		try {
			reader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			throw new RuntimeException("FileInputHandler: File \"" + filename
					+ "\" not found.");

		} catch (Exception e) {
			System.err.println("FileInputHandler: Error opening file named \""
					+ filename + "\" for reading: " + e);
			throw new RuntimeException(
					"FileInputHandler: Error opening file named \"" + filename
							+ "\" for reading");
		}
	}

	//-----------------------------------------------------------------
	// readLine() returns the first unread line from the file each time
	// it is called -- i.e., the first call returns the first line, the
	// second call returns the second line, etc. When all the lines
	// have been read, readLine() returns null.

	public String readLine() {
		String s = null;

		try {
			s = reader.readLine();
		} catch (Exception e) {
			System.err.println("FileInputHandler: Error reading file named \""
					+ filename + "\" for reading: " + e);
			throw new RuntimeException(
					"FileInputHandler: Error reading file named \"" + filename
							+ "\" for reading");
		}
		return s;
	}

	//-----------------------------------------------------------------
	// After one is finished reading one should close the file to free
	// system resources.

	public void close() {
		try {
			reader.close();
		} catch (Exception e) {
		}
	}

	//-----------------------------------------------------------------
	// The finalize() method is not meant to be called under normal use;
	// its purpose is to close the file and free system resources in the
	// event that a FileInputHandler goes out of scope and is garbage
	// collected

	protected void finalize() throws Throwable {
		try {
			reader.close();
		} finally {
			super.finalize();
		}
	}
}