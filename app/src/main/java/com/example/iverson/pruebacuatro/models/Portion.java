package com.example.iverson.pruebacuatro.models;

public class Portion {

    private String _index;
    private String _type;
    private String _id;
    private double _score;
    private PortionFields fields;

    public String get_index() {
        return this._index;
    }

    public void set_index(String _index) {
        this._index = _index;
    }

    public String get_type() {
        return this._type;
    }

    public void set_type(String _type) {
        this._type = _type;
    }

    public String get_id() {
        return this._id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public double get_score() {
        return this._score;
    }

    public void set_score(double _score) {
        this._score = _score;
    }

    public PortionFields getFields() {
        return this.fields;
    }

    public void setFields(PortionFields fields) {
        this.fields = fields;
    }

}
