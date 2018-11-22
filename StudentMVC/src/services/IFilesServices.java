package services;


import java.util.List;

import pojo.Files;

public interface IFilesServices {
	public int addFiles(String name,String des);
	
	public List<Files> selectAllFiles();
}
