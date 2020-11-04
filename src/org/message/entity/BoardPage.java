package org.message.entity;

import java.util.ArrayList;

public class BoardPage {
    private int currentPage = -1;
    private int pageSize = -1;
    private int totalCount = -1;
    private int totalPage = -1;
    private ArrayList<MessageBoard> messages = null;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        if(totalCount != -1){
            totalPage = totalCount % pageSize == 0?totalCount / pageSize:totalCount / pageSize + 1;
        }
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        if(pageSize != -1){
            totalPage = totalCount % pageSize == 0?totalCount / pageSize:totalCount / pageSize + 1;
        }
    }

    public int getTotalPage() {
        return totalPage;
    }

    public ArrayList<MessageBoard> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<MessageBoard> messages) {
        this.messages = messages;
    }

    public BoardPage(int currentPage, int pageSize, int totalCount, int totalPage, ArrayList<MessageBoard> messages) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        this.messages = messages;
    }

    public BoardPage() {
    }
}
