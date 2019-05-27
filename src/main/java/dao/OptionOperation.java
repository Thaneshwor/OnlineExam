package dao;

import java.util.ArrayList;

import bean.Option;
import bean.Question;

public interface OptionOperation {

	public long insertOption(Option q);
	
	long upDate(long id, Option o);

	public boolean delete(long id);
	
	public Option selectOption(long id);
	
	public ArrayList<Option> selectAllOption();
	
	public ArrayList<Option> searchByName(String name);
}
