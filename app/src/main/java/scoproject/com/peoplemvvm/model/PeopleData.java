package scoproject.com.peoplemvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ibnumuzzakkir on 5/1/17.
 */

public class PeopleData {
    @SerializedName("results")
    @Expose
    private List<PeopleResult> results = null;
    @SerializedName("info")
    @Expose
    private PeopleInfo info;

    public List<PeopleResult> getResults() {
        return results;
    }

    public void setResults(List<PeopleResult> results) {
        this.results = results;
    }

    public PeopleInfo getInfo() {
        return info;
    }

    public void setInfo(PeopleInfo info) {
        this.info = info;
    }

}
