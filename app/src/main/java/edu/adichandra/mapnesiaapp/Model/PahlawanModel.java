package edu.adichandra.mapnesiaapp.Model;

public class PahlawanModel {
    private String nama;
    private String image;
    private String asal;
    private String lahir;
    private String meninggal;
    private String makam;
    private String serjarah_singkat;

    public PahlawanModel() {
        this.nama = nama;
        this.image = image;
        this.asal = asal;
        this.lahir = lahir;
        this.meninggal = meninggal;
        this.makam = makam;
        this.serjarah_singkat = serjarah_singkat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getLahir() {
        return lahir;
    }

    public void setLahir(String lahir) {
        this.lahir = lahir;
    }

    public String getMeninggal() {
        return meninggal;
    }

    public void setMeninggal(String meninggal) {
        this.meninggal = meninggal;
    }

    public String getSerjarah_singkat() {
        return serjarah_singkat;
    }

    public void setSerjarah_singkat(String serjarah_singkat) {
        this.serjarah_singkat = serjarah_singkat;
    }

    public String getMakam() {
        return makam;
    }

    public void setMakam(String makam) {
        this.makam = makam;
    }
}
