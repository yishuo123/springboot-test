package com.example.springboottest.util;

import java.io.Serializable;
import java.util.List;

/**
 * 分页使用的工具类
 */
public class Page<E> implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final Integer DEFAULT_MAX_RESULT = 10;
    public static final Integer DEFAULT_TOTAL_RESULT = 0;

    private Integer pageIndex;
    private Integer totalPage;
    private Integer maxResult = DEFAULT_MAX_RESULT;
    private Integer totalResult = DEFAULT_TOTAL_RESULT;
    private List<E> list;

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

    public Page() {
        super();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static Integer getDefaultMaxResult() {
        return DEFAULT_MAX_RESULT;
    }

    public static Integer getDefaultTotalResult() {
        return DEFAULT_TOTAL_RESULT;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(Integer maxResult) {
        this.maxResult = maxResult;
    }

    public Integer getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Integer totalResult) {
        this.totalResult = totalResult;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public Page(Integer pageIndex, Integer totalPage, Integer maxResult, Integer totalResult, List<E> list) {
        super();
        this.pageIndex = pageIndex;
        this.totalPage = totalPage;
        this.maxResult = maxResult;
        this.totalResult = totalResult;
        this.list = list;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Page{");
        sb.append("pageIndex=").append(pageIndex);
        sb.append(", totalPage=").append(totalPage);
        sb.append(", maxResult=").append(maxResult);
        sb.append(", totalResult=").append(totalResult);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
