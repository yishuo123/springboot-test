package com.example.springboottest.controller.util;

import java.io.Serializable;
import java.util.List;

/**
 * 返回页面数据
 * @author lizy
 * 2016年11月28日
 * @param <E>
 */
public class Page<E> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final Integer DEFAULT_MAX_RESULT = 10;
	private static final Integer DEFAULT_TOTAL_RESULT = 0;

	private Integer pageIndex;
	private Integer totalPage;
	private Integer maxResult = DEFAULT_MAX_RESULT;
	private Integer totalResult = DEFAULT_TOTAL_RESULT;
	private List<E> list;

	public Page() {
		super();
	}

	public Page(int pageIndex, int maxResult) {
		super();
		this.pageIndex = pageIndex;
		this.maxResult = maxResult;
	}

	public Page(Integer pageIndex, Integer maxResult) {
		super();
		this.pageIndex = pageIndex;
		this.maxResult = maxResult;
	}
	
	public Page(Integer totalResult, List<E> list) {
		super();
		this.totalResult = totalResult;
		this.list = list;
	}

	public Page(Integer pageIndex, Integer maxResult, Integer totalResult, List<E> list) {
		super();
		this.pageIndex = pageIndex;
		this.maxResult = maxResult;
		this.totalResult = totalResult;
		this.list = list;
	}

	public Integer getPageIndex() {
		return null == pageIndex ? 0 : pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getTotalPage() {
		return totalResult % getMaxResult() == 0 ? totalResult / getMaxResult() : totalResult / getMaxResult() + 1;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getMaxResult() {
		return null == maxResult ? DEFAULT_MAX_RESULT : maxResult;
	}

	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public Integer getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(Integer totalResult) {
		this.totalResult = totalResult;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("List: ").append(getList() == null ? "null" : getList().size()).append(", ");
		sb.append("MaxResult: ").append(getMaxResult()).append(", ");
		sb.append("PageIndex: ").append(getPageIndex()).append(", ");
		sb.append("TotalPage: ").append(getTotalPage()).append(", ");
		sb.append("TotalResult: ").append(getTotalResult()).append(", ");
		return sb.toString();
	}
}
