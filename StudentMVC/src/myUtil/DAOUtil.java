package myUtil;

public class DAOUtil {
	public static String splitPageSql(String sql,int pageIndex,int pageCount) {
		return "select * from (select t.*,rownum n from ("+sql+") t) tab where tab.n>"+(pageIndex-1)*pageCount+" and tab.n<="+(pageIndex)*pageCount;
	}
}
