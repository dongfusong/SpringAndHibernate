package model;

import org.hibernate.Session;

import javax.persistence.Query;

/**
 * Created by Thoughtworks on 15/9/4.
 */
public class PageFinder {

    private int pageNo;
    private int cngOfPage;

    private StringBuffer hqlStringBuffer = new StringBuffer();



    public PageFinder(String table, int pageNo, int cngOfPage) {
        this.pageNo = pageNo;
        this.cngOfPage = cngOfPage;
        makeSqlHead(table);

    }

    private void makeSqlHead(String table) {
        hqlStringBuffer.append("from " + table);
    }


    public int calcCurrentPos(){
        return pageNo * cngOfPage;
    }

    public int getCntOfPage(){
        return cngOfPage;
    }

    public org.hibernate.Query createQuery(Session currentSession) {
        return currentSession.createQuery(hqlStringBuffer.toString()).setMaxResults(getCntOfPage())
                .setFirstResult(calcCurrentPos());
    }
}
