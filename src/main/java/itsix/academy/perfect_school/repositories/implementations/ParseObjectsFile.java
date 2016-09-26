package itsix.academy.perfect_school.repositories.implementations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

import itsix.academy.perfect_school.repositories.IMainRepository;
import itsix.academy.perfect_school.repositories.IParser;

public class ParseObjectsFile implements IParser {
	String path = "src/main/data/repo.ser";

	@Override
	public void serialize(IMainRepository repository) {
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(repository);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	@Override
	public IMainRepository deserializeRepository() {
		IMainRepository mainRepository = null;
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			mainRepository = (IMainRepository) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			return null;
		}
		return mainRepository;
	}
 

}
