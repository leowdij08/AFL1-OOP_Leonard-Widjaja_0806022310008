public class dosen {
    private String nik;
    private String nama;
    private String prodi;

    public dosen(String nik, String nama, String prodi) {
        this.nik = nik;
        this.nama = nama;
        this.prodi = prodi;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }
}
