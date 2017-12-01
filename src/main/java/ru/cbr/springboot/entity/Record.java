package ru.cbr.springboot.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Record {

    @Id
    @GeneratedValue
    private Long id;
    private String vkey;
    private String real1;
    private String pzn;
    private String uer;
    private String rgn;
    private String ind;
    private String tnp;
    private String nnp;
    private String adr;
    private String rkc;
    private String namep;
    private String namen;
    private String newnum;
    private String newks;
    private String permfo;
    private String srok;
    private String at1;
    private String at2;
    private String telef;
    private String regn;
    private String okpo;
    @Temporal(TemporalType.DATE)
    private Date dt_izm;
    private String cks;
    private String ksnp;
    @Temporal(TemporalType.DATE)
    private Date date_in;
    @Temporal(TemporalType.DATE)
    private Date date_ch;
    private String vkeydel;
    @Temporal(TemporalType.DATE)
    private Date dt_izmr;

    public Record() {

    }

    public Record(String pzn, String rgn, String rkc) {
        this.pzn = pzn;
        this.rgn = rgn;
        this.rkc = rkc;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVkey() {
        return vkey;
    }

    public void setVkey(String vkey) {
        this.vkey = vkey;
    }

    public String getReal1() {
        return real1;
    }

    public void setReal1(String real1) {
        this.real1 = real1;
    }

    public void setPzn(String pzn) {
        this.pzn = pzn;
    }

    public String getUer() {
        return uer;
    }

    public void setUer(String uer) {
        this.uer = uer;
    }

    public void setRgn(String rgn) {
        this.rgn = rgn;
    }

    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    public String getTnp() {
        return tnp;
    }

    public void setTnp(String tnp) {
        this.tnp = tnp;
    }

    public String getNnp() {
        return nnp;
    }

    public void setNnp(String nnp) {
        this.nnp = nnp;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public void setRkc(String rkc) {
        this.rkc = rkc;
    }

    public String getNamep() {
        return namep;
    }

    public void setNamep(String namep) {
        this.namep = namep;
    }

    public String getNamen() {
        return namen;
    }

    public void setNamen(String namen) {
        this.namen = namen;
    }

    public String getNewnum() {
        return newnum;
    }

    public void setNewnum(String newnum) {
        this.newnum = newnum;
    }

    public String getNewks() {
        return newks;
    }

    public void setNewks(String newks) {
        this.newks = newks;
    }

    public String getPermfo() {
        return permfo;
    }

    public void setPermfo(String permfo) {
        this.permfo = permfo;
    }

    public String getSrok() {
        return srok;
    }

    public void setSrok(String srok) {
        this.srok = srok;
    }

    public String getAt1() {
        return at1;
    }

    public void setAt1(String at1) {
        this.at1 = at1;
    }

    public String getAt2() {
        return at2;
    }

    public void setAt2(String at2) {
        this.at2 = at2;
    }

    public String getTelef() {
        return telef;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }

    public String getRegn() {
        return regn;
    }

    public void setRegn(String regn) {
        this.regn = regn;
    }

    public String getOkpo() {
        return okpo;
    }

    public void setOkpo(String okpo) {
        this.okpo = okpo;
    }

    public Date getDt_izm() {
        return dt_izm;
    }

    public void setDt_izm(Date dt_izm) {
        this.dt_izm = dt_izm;
    }

    public String getCks() {
        return cks;
    }

    public void setCks(String cks) {
        this.cks = cks;
    }

    public String getKsnp() {
        return ksnp;
    }

    public void setKsnp(String ksnp) {
        this.ksnp = ksnp;
    }

    public Date getDate_in() {
        return date_in;
    }

    public void setDate_in(Date date_in) {
        this.date_in = date_in;
    }

    public Date getDate_ch() {
        return date_ch;
    }

    public void setDate_ch(Date date_ch) {
        this.date_ch = date_ch;
    }

    public String getVkeydel() {
        return vkeydel;
    }

    public void setVkeydel(String vkeydel) {
        this.vkeydel = vkeydel;
    }

    public Date getDt_izmr() {
        return dt_izmr;
    }

    public void setDt_izmr(Date dt_izmr) {
        this.dt_izmr = dt_izmr;
    }

    private static List<Record> records = new ArrayList<>();

    public static List<Record> getRecords() {
        return records;
    }

    public static List<String> namesOfRow = new ArrayList<>();

    public static List<String> getNamesOfRow() {
        return namesOfRow;
    }



    public String getRkc() {
        return rkc;
    }

    public String getPzn() {
        return pzn;
    }

    public String getRgn() {
        return rgn;
    }

    public Long getId() {
        return id;
    }

    /*@Override
    public String toString() {
        return
                "REAL='" + REAL1 + '\'' +
                        ", PZN='" + PZN + '\'' +
                        ", UER='" + UER + '\'' +
                        ", RGN='" + RGN + '\'' +
                        ", IND='" + IND + '\'' +
                        ", TNP='" + TNP + '\'' +
                        ", NNP='" + NNP + '\'' +
                        ", ADR='" + ADR + '\'' +
                        ", RKC='" + RKC + '\'' +
                        ", NAMEP='" + NAMEP + '\'' +
                        ", NEWNUM='" + NEWNUM + '\'' +
                        ", TELEF='" + TELEF + '\'' +
                        ", REGN='" + REGN + '\'' +
                        ", OKPO='" + OKPO + '\'' +
                        ", DT_IZM=" + DT_IZM +
                        ", KSNP='" + KSNP + '\'' +
                        ", DATE_IN=" + DATE_IN +
                        ", DATE_CH=" + DATE_CH;
    }

    public List<Record> findByRKC(String rkc) {
        List<Record> listRKC = new ArrayList<>();
        for (Record item : getRecords()) {
            if (item.getRKC().equals(rkc)) {
                listRKC.add(item);
            }
        }
        return listRKC;
    }

    public List<Record> findByRGN(String rgn) {
        List<Record> listRGN = new ArrayList<>();
        for (Record item : getRecords()) {
            if (item.getRGN().equals(rgn)) {
                listRGN.add(item);
            }
        }
        return listRGN;
    }

    public List<Record> findByPZN(String pzn) {
        List<Record> listPZN = new ArrayList<>();
        for (Record item : getRecords()) {
            if (item.getPZN().equals(pzn)) {
                listPZN.add(item);
            }
        }
        return listPZN;
    }

    public List<Record> findAll() {
        List<Record> listAll = new ArrayList<>();
        for (Record item : getRecords()) {
            listAll.add(item);
        }
        return listAll;
    }*/
}
