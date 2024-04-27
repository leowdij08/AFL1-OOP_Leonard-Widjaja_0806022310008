public class detailpeminjaman {
    private String idPeminjaman;
    private String idIsbnIssn;
    private String idCd;
    private String batasPengembalian;

    public detailpeminjaman(String idPeminjaman, String idIsbnIssn, String idCd, String batasPengembalian) {
        this.idPeminjaman = idPeminjaman;
        this.idIsbnIssn = idIsbnIssn;
        this.idCd = idCd;
        this.batasPengembalian = batasPengembalian;
    }

    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public String getIdIsbnIssn() {
        return idIsbnIssn;
    }

    public void setIdIsbnIssn(String idIsbnIssn) {
        this.idIsbnIssn = idIsbnIssn;
    }

    public String getIdCd() {
        return idCd;
    }

    public void setIdCd(String idCd) {
        this.idCd = idCd;
    }

    public String getBatasPengembalian() {
        return batasPengembalian;
    }

    public void setBatasPengembalian(String batasPengembalian) {
        this.batasPengembalian = batasPengembalian;
    }
}
