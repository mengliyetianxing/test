package dao;

import java.util.List;

import pojo.Files;

public interface IFilesDAO {
	public int addFiles(Files f);
	
	public int deleteFiles(Files f);
	
	public int updateFiles(Files f);
	
	public int selectFiles(Files f);
	
	public List<Files> selectAllFiles();
}
