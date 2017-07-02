package com.jamaro.catastro.utils;

class Inmueble {

    private String pc1;
    private String pc2;
    private String xcen;
    private String ycen;
    private String ldt;
    private String dis;

    public String getpc1() {
        return pc1;
    }

    public void setpc1(String pc1) {
        this.pc1 = pc1;
    }

    public String getpc2() {
        return pc2;
    }

    public void setpc2(String pc2) {
        this.pc2 = pc2;
    }

    public String getxcen() {
        return xcen;
    }

    public void setxcen(String xcen) {
        this.xcen = xcen;
    }

    public String getycen() {
        return ycen;
    }

    public void setycen(String ycen) {
        this.ycen = ycen;
    }
    public String getldt() {
        return ldt;
    }

    public void setldt(String ldt) {
        this.ldt = ldt;
    }

    public String getdis() {
        return dis;
    }

    public void setdis(String dis) {
        this.dis = dis;
    }

    @Override
    public String toString() {
        return "PC1 PC2: " + pc1 + pc2 + "\t ycen,xcen: " + ycen+ "," + xcen + "\tLDT: " + ldt + "\tDIS: " + dis + "\thttps://www1.sedecatastro.gob.es/CYCBienInmueble/OVCListaBienes.aspx?RC1=" + pc1 + "&RC2=" + pc2 + "&RC3=&RC4=&esBice=&RCBice1=&RCBice2=&DenoBice=";
    }

}
