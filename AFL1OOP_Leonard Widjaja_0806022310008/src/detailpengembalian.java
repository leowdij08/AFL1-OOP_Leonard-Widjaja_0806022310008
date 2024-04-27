public class detailpengembalian {
    private String idPengembalian;
    private String idIsbnIssn;
    private String idCd;

    public detailpengembalian(String idPengembalian, String idIsbnIssn, String idCd) {
        this.idPengembalian = idPengembalian;
        this.idIsbnIssn = idIsbnIssn;
        this.idCd = idCd;
    }

    public String getIdPengembalian() {
        return idPengembalian;
    }

    public void setIdPengembalian(String idPengembalian) {
        this.idPengembalian = idPengembalian;
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
}
