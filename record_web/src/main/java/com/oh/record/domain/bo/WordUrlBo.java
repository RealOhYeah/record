package com.oh.record.domain.bo;

import java.io.Serializable;

public class WordUrlBo implements Serializable{

    String wordUrl;

    public WordUrlBo() {
    }

    public WordUrlBo(String wordUrl) {
        this.wordUrl = wordUrl;
    }

    public String getWordUrl() {
        return wordUrl;
    }

    public void setWordUrl(String wordUrl) {
        this.wordUrl = wordUrl;
    }

    @Override
    public String toString() {
        return "WordUrlBo{" +
                "wordUrl='" + wordUrl + '\'' +
                '}';
    }
}
