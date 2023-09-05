package com.anura.magkursach.algebra;

public class Examples {
    private Integer number;
    private String formula1;
    private String formula2;
    private String formula3;
    private String formula4;

    public Examples(Integer number, String formula1, String formula2, String formula3, String formula4) {
        this.number = number;
        this.formula1 = formula1;
        this.formula2 = formula2;
        this.formula3 = formula3;
        this.formula4 = formula4;
    }
    public Examples(){}

    public Integer getNumber() {
        return number;
    }

    public String getFormula1() {
        return formula1;
    }

    public String getFormula2() {
        return formula2;
    }

    public String getFormula3() {
        return formula3;
    }

    public String getFormula4() {
        return formula4;
    }
}
