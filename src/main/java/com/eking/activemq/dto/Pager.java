package com.eking.activemq.dto;

import com.github.pagehelper.Page;
import java.io.Serializable;
import java.util.List;

public class Pager <T>{

    private static final long serialVersionUID = 1L;
    public Pager() {

    }
    /**
     * 总记录数
     */
    private Long total;

    /**
     * 页数
     */
    private Integer pageNum;

    /**
     * 每页记录数
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer pages;

    /**
     * 结果集
     */
    private List<T> list;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Pager(List<T> list) {
            init(list);
        }

        /**
         * 初始化
         *
         * @param list
         */
        private void init(List<T> list) {
            if (list instanceof Page) {
                Page<T> page = (Page<T>) list;
                this.total = page.getTotal();
                this.list = page.getResult();
                this.pageNum = page.getPageNum();
                this.pageSize = page.getPageSize();
                this.pages = page.getPages();
            }
        }
}
