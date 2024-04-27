public class detaildenda {
    private String idPengembalian;
    private String kategoriDenda;

    public detaildenda(String idPengembalian, String kategoriDenda) {
        this.idPengembalian = idPengembalian;
        this.kategoriDenda = kategoriDenda;
    }

    public String getIdPengembalian() {
        return idPengembalian;
    }

    public void setIdPengembalian(String idPengembalian) {
        this.idPengembalian = idPengembalian;
    }

    public String getKategoriDenda() {
        return kategoriDenda;
    }

    public void setKategoriDenda(String kategoriDenda) {
        this.kategoriDenda = kategoriDenda;
    }

}
