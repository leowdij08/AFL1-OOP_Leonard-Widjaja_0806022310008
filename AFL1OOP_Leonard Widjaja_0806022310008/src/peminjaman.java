public class peminjaman {
    private String idPeminjaman;
    private String idPustakawan;
    private String nim;
    private String nik;
    private String tanggalPeminjaman;

    public peminjaman(String idPeminjaman, String idPustakawan, String nim, String nik, String tanggalPeminjaman) {
        this.idPeminjaman = idPeminjaman;
        this.idPustakawan = idPustakawan;
        this.nim = nim;
        this.nik = nik;
        this.tanggalPeminjaman = tanggalPeminjaman;
    }

    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public String getIdPustakawan() {
        return idPustakawan;
    }

    public void setIdPustakawan(String idPustakawan) {
        this.idPustakawan = idPustakawan;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }

    public void setTanggalPeminjaman(String tanggalPeminjaman) {
        this.tanggalPeminjaman = tanggalPeminjaman;
    }
}
