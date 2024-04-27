public class pustakawan {
    private String idPustakawan;
    private String nama;

    public pustakawan(String idPustakawan, String nama) {
        this.idPustakawan = idPustakawan;
        this.nama = nama;
    }

    public String getIdPustakawan() {
        return idPustakawan;
    }

    public void setIdPustakawan(String idPustakawan) {
        this.idPustakawan = idPustakawan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
