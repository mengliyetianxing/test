package services;


import java.util.List;

import dao.FilesDAOimpl;
import dao.IFilesDAO;
import oracle.net.aso.d;
import pojo.Files;

public class FilesServicesimpl implements IFilesServices{
	IFilesDAO fdi = new FilesDAOimpl();
	@Override
	public int addFiles(String name, String des) {
		Files f = new Files();
		f.setFname(name);
		f.setFdes(des);
		return fdi.addFiles(f);
	}

	@Override
	public List<Files> selectAllFiles() {
		return fdi.selectAllFiles();
	}
	
}
