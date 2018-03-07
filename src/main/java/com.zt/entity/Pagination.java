package com.zt.entity;


/**
 * Created by admin on 2018/1/31.
 */
public class Pagination {
    private int pageIndex;//页码
    private int pageSize;//每页的数据条数
    private int totalRows;//总数据条数
    private  int totalPages;//总页数
    private int beginRow;//起始数据行
    private int endRow;//结束数据行

    public Pagination(int pageIndex,int pageSize,int totalRows){
        this.pageIndex=pageIndex;
        this.pageSize=pageSize;
        this.totalRows=totalRows;
        //计算总页数
        this.totalPages=totalRows % pageSize == 0 ? (totalRows/pageSize) : (totalRows/pageSize)+1;
        beginRow=(pageIndex-1)*pageSize;
        if (pageIndex!=totalPages)
        {
            endRow=pageIndex*pageSize;
        }
        else {
            endRow=totalRows;
        }
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getBeginRow() {
        return beginRow;
    }

    public void setBeginRow(int beginRow) {
        this.beginRow = beginRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public void setEndRow(int endRow) {
        this.endRow = endRow;
    }
}
