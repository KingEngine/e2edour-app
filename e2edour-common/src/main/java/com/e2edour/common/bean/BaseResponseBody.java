package com.e2edour.common.bean;

import java.util.List;

public class BaseResponseBody<T> {

	private List<T> dataList;

	private boolean isError;

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public boolean isError() {
		return isError;
	}

	public void setError(boolean isError) {
		this.isError = isError;
	}

}
