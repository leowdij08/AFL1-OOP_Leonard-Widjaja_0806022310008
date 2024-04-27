public class pengembalian {
    private String idPengembalian;
    private String idPeminjaman;
    private String idPustakawan;
    private String tanggalPengembalian;

    public pengembalian(String idPengembalian, String idPeminjaman, String idPustakawan, String tanggalPengembalian) {
        this.idPengembalian = idPengembalian;
        this.idPeminjaman = idPeminjaman;
        this.idPustakawan = idPustakawan;
        this.tanggalPengembalian = tanggalPengembalian;
    }

    public String getIdPengembalian() {
        return idPengembalian;
    }

    public void setIdPengembalian(String idPengembalian) {
        this.idPengembalian = idPengembalian;
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

    public String getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    public void setTanggalPengembalian(String tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }
}
