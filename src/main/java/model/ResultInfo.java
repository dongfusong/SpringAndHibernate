package model;

import repository.ErrorInfo;

/**
 * Created by Thoughtworks on 15/9/7.
 */
public class ResultInfo {
    String content;
    public ResultInfo(ErrorInfo info) {
        this.content = info.getContent();
    }
}
