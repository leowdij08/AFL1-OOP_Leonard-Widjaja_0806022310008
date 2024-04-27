public class cd {
    private String idCd;
    private String judulCd;
    private int cdTersedia;
    private int cdTerpinjam;
    private int totalCd;

    public cd(String idCd, String judulCd, int cdTersedia, int cdTerpinjam, int totalCd) {
        this.idCd = idCd;
        this.judulCd = judulCd;
        this.cdTersedia = cdTersedia;
        this.cdTerpinjam = cdTerpinjam;
        this.totalCd = totalCd;
    }

    public String getIdCd() {
        return idCd;
    }

    public void setIdCd(String idCd) {
        this.idCd = idCd;
    }

    public String getJudulCd() {
        return judulCd;
    }

    public void setJudulCd(String judulCd) {
        this.judulCd = judulCd;
    }

    public int getCdTersedia() {
        return cdTersedia;
    }

    public void setCdTersedia(int cdTersedia) {
        this.cdTersedia = cdTersedia;
    }

    public int getCdTerpinjam() {
        return cdTerpinjam;
    }

    public void setCdTerpinjam(int cdTerpinjam) {
        this.cdTerpinjam = cdTerpinjam;
    }

    public int getTotalCd() {
        return totalCd;
    }

    public void setTotalCd(int totalCd) {
        this.totalCd = totalCd;
    }
}
