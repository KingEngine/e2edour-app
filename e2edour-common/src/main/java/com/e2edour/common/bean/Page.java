package com.e2edour.common.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 分页组件
 * 
 * @author King
 *
 * @param <T>
 */
public class Page<T> implements Serializable {

	private static final long serialVersionUID = 6343071177336194681L;

	private int current;// 当前页

	private int rowCount;// 每页行数

	private List<T> rows;// 记录

	private long total;// 总记录数

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

}
