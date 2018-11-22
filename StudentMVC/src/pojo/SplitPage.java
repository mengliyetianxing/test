package pojo;

import java.util.List;

public class SplitPage <T> {
	int pageIndex;//ҳ����
	int pageCount;//ÿҳ����
	int count;//��������
	int totalPage;//��ҳ��
	List<T> list;//���ݶ���
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalPage() {
		if (pageCount!=0) {
			return count%pageCount==0?count/pageCount:count/pageCount+1;
		}else {
			return 0;
		}
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
