public class buku {
    private String idIsbnIssn;
    private String judulBuku;
    private int bukuTersedia;
    private int bukuTerpinjam;
    private int totalBuku;

    public buku(String idIsbnIssn, String judulBuku, int bukuTersedia, int bukuTerpinjam, int totalBuku) {
        this.idIsbnIssn = idIsbnIssn;
        this.judulBuku = judulBuku;
        this.bukuTersedia = bukuTersedia;
        this.bukuTerpinjam = bukuTerpinjam;
        this.totalBuku = totalBuku;
    }

    public String getIdIsbnIssn() {
        return idIsbnIssn;
    }

    public void setIdIsbnIssn(String idIsbnIssn) {
        this.idIsbnIssn = idIsbnIssn;
    }

    public String getJudulBuku() {
        return judulBuku;
    }

    public void setJudulBuku(String judulBuku) {
        this.judulBuku = judulBuku;
    }

    public int getBukuTersedia() {
        return bukuTersedia;
    }

    public void setBukuTersedia(int bukuTersedia) {
        this.bukuTersedia = bukuTersedia;
    }

    public int getBukuTerpinjam() {
        return bukuTerpinjam;
    }

    public void setBukuTerpinjam(int bukuTerpinjam) {
        this.bukuTerpinjam = bukuTerpinjam;
    }

    public int getTotalBuku() {
        return totalBuku;
    }

    public void setTotalBuku(int totalBuku) {
        this.totalBuku = totalBuku;
    }
}
