import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    private static ArrayList<buku> bukulist = new ArrayList<>();
    private static ArrayList<cd> cdlist = new ArrayList<>();
    private static ArrayList<detaildenda> detaildendalist = new ArrayList<>();
    private static ArrayList<detailpeminjaman> detailpeminjamanlist = new ArrayList<>();
    private static ArrayList<detailpengembalian> detailpengembalianlist = new ArrayList<>();
    private static ArrayList<dosen> dosenlist = new ArrayList<>();
    private static ArrayList<mahasiswa> mahasiswalist = new ArrayList<>();
    private static ArrayList<peminjaman> peminjamanlist = new ArrayList<>();
    private static ArrayList<pengembalian> pengembalianlist = new ArrayList<>();
    private static ArrayList<pustakawan> pustakawanlist = new ArrayList<>();

    public static void generateTable(String bannerTitle, String tableFormat, Object[][] rowData, Object[] columnNames,
            int dataLengthTotal) {
        String titleBanner = "+", titlePadding = "";
        if (dataLengthTotal % 2 == 0) {
            for (int i = 0; i < dataLengthTotal - 1; i++) {
                titleBanner += "-";
            }
        } else {
            for (int i = 0; i < dataLengthTotal - 1; i++) {
                titleBanner += "-";
            }
        }
        titleBanner += "+";
        for (int i = 0; i < ((dataLengthTotal - bannerTitle.length()) / 2) - 1; i++) {
            titlePadding += " ";
        }
        System.out.printf(titleBanner + "%n");
        System.out.printf("|" + titlePadding + bannerTitle + " " + titlePadding + "|%n");
        System.out.printf(titleBanner + "%n");
        System.out.printf(tableFormat, columnNames);
        System.out.printf(titleBanner + "%n");
        for (int n = 0; n < rowData.length; n++) {
            System.out.printf(tableFormat, rowData[n]);
        }
        System.out.printf(titleBanner + "%n");
    }

    public static Object[][] dataGenerator(int rowCount, Object[] columnNames) {
        Object rowData[][] = new Object[rowCount][columnNames.length];
        return rowData;
    }

    public static String tableFormatter(Object[][] rowData, Object[] columnNames) {
        int[] dataLength = new int[columnNames.length];
        for (int length = 0; length < columnNames.length; length++) {
            if (columnNames[length] != null) {
                int panjangHeader = columnNames[length].toString().length();
                if (panjangHeader > dataLength[length]) {
                    dataLength[length] = panjangHeader;
                }
            }
        }

        for (int i = 0; i < rowData.length; i++) {
            for (int l = 0; l < columnNames.length; l++) {
                if (rowData[i][l] != null) {
                    int panjangData = rowData[i][l].toString().length();
                    if (panjangData > dataLength[l]) {
                        dataLength[l] = panjangData;
                    }
                }
            }
        }

        String formatTable = "| %";
        int dataLengthTotal = 0;
        for (int a = 0; a < dataLength.length; a++) {
            formatTable += "-" + (dataLength[a] + 2) + "s | %";
            dataLengthTotal += dataLength[a] + 5;
        }
        formatTable += "n";
        return formatTable + "/" + dataLengthTotal;
    }

    static void bukulist() throws IOException {
        Object[] columnNames = new Object[] {
                "ISBN/ISSN",
                "Judul Buku",
                "Buku Tersedia",
                "Buku Terpinjam",
                "Total Buku",
        };

        Object[][] rowData = dataGenerator(bukulist.size(), columnNames);
        for (int i = 0; i < rowData.length; i++) {
            buku data = bukulist.get(i);
            rowData[i][0] = data.getIdIsbnIssn();
            rowData[i][1] = data.getJudulBuku();
            rowData[i][2] = data.getBukuTersedia();
            rowData[i][3] = data.getBukuTerpinjam();
            rowData[i][4] = data.getTotalBuku();
        }
        generateTable("Daftar Buku", tableFormatter(rowData, columnNames).split("/")[0], rowData, columnNames,
                Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
        printTXT("Daftar Buku", tableFormatter(rowData, columnNames).split("/")[0], rowData, "Buku.txt", columnNames,
                Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
    }

    static void cdlist() throws IOException {
        Object[] columnNames = new Object[] {
                "ID CD",
                "Judul CD",
                "CD Tersedia",
                "CD Terpinjam",
                "Total CD",
        };

        Object[][] rowData = dataGenerator(cdlist.size(), columnNames);
        for (int i = 0; i < rowData.length; i++) {
            cd data = cdlist.get(i);
            rowData[i][0] = data.getIdCd();
            rowData[i][1] = data.getJudulCd();
            rowData[i][2] = data.getCdTersedia();
            rowData[i][3] = data.getCdTerpinjam();
            rowData[i][4] = data.getTotalCd();
        }
        generateTable("Daftar CD", tableFormatter(rowData, columnNames).split("/")[0], rowData, columnNames,
                Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
        printTXT("Daftar CD", tableFormatter(rowData, columnNames).split("/")[0], rowData, "CD.txt", columnNames,
                Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
    }

    static void detaildendalist() throws IOException {
        Object[] columnNames = new Object[] {
                "ID Pengembalian",
                "Kategori Denda"
        };

        Object[][] rowData = dataGenerator(detaildendalist.size(), columnNames);
        for (int i = 0; i < rowData.length; i++) {
            detaildenda data = detaildendalist.get(i);
            rowData[i][0] = data.getIdPengembalian();
            rowData[i][1] = data.getKategoriDenda();
        }
        generateTable("Detail Denda", tableFormatter(rowData, columnNames).split("/")[0], rowData,
                columnNames, Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
        printTXT("Detail Denda", tableFormatter(rowData, columnNames).split("/")[0], rowData,
                "Detail Denda.txt", columnNames,
                Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
    }

    static void detailpeminjamanlist() throws IOException {
        Object[] columnNames = new Object[] {
                "ID Peminjaman",
                "ISBN/ISSN",
                "ID CD",
                "Batas Pengembalian",
        };

        Object[][] rowData = dataGenerator(detailpeminjamanlist.size(), columnNames);
        for (int i = 0; i < rowData.length; i++) {
            detailpeminjaman data = detailpeminjamanlist.get(i);
            rowData[i][0] = data.getIdPeminjaman();
            rowData[i][1] = data.getIdIsbnIssn();
            rowData[i][2] = data.getIdCd();
            rowData[i][3] = data.getBatasPengembalian();
        }
        generateTable("Detail Peminjaman", tableFormatter(rowData, columnNames).split("/")[0], rowData, columnNames,
                Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
        printTXT("Detail Peminjaman", tableFormatter(rowData, columnNames).split("/")[0], rowData,
                "Detail Peminjaman.txt", columnNames,
                Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
    }

    static void detailpengembalianlist() throws IOException {
        Object[] columnNames = new Object[] {
                "ID Pengembalian",
                "ISBN/ISSN",
                "ID CD",
        };

        Object[][] rowData = dataGenerator(detailpengembalianlist.size(), columnNames);
        for (int i = 0; i < rowData.length; i++) {
            detailpengembalian data = detailpengembalianlist.get(i);
            rowData[i][0] = data.getIdPengembalian();
            rowData[i][1] = data.getIdIsbnIssn();
            rowData[i][2] = data.getIdCd();
        }
        generateTable("Detail Pengembalian", tableFormatter(rowData, columnNames).split("/")[0], rowData, columnNames,
                Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
        printTXT("Detail Pengembalian", tableFormatter(rowData, columnNames).split("/")[0], rowData,
                "Detail Pengembalian.txt", columnNames,
                Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
    }

    static void dosenlist() throws IOException {
        Object[] columnNames = new Object[] {
                "NIK",
                "Nama",
                "Prodi",
        };

        Object[][] rowData = dataGenerator(dosenlist.size(), columnNames);
        for (int i = 0; i < rowData.length; i++) {
            dosen data = dosenlist.get(i);
            rowData[i][0] = data.getNik();
            rowData[i][1] = data.getNama();
            rowData[i][2] = data.getProdi();
        }
        generateTable("List Dosen", tableFormatter(rowData, columnNames).split("/")[0], rowData, columnNames,
                Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
        printTXT("List Dosen", tableFormatter(rowData, columnNames).split("/")[0], rowData, "Dosen.txt", columnNames,
                Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
    }

    static void mahasiswalist() throws IOException {
        Object[] columnNames = new Object[] {
                "NIM",
                "Nama",
                "Prodi",
        };

        Object[][] rowData = dataGenerator(mahasiswalist.size(), columnNames);
        for (int i = 0; i < rowData.length; i++) {
            mahasiswa data = mahasiswalist.get(i);
            rowData[i][0] = data.getNim();
            rowData[i][1] = data.getNama();
            rowData[i][2] = data.getProdi();
        }
        generateTable("List Mahasiswa", tableFormatter(rowData, columnNames).split("/")[0], rowData, columnNames,
                Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
        printTXT("List Mahasiswa", tableFormatter(rowData, columnNames).split("/")[0], rowData, "Mahasiswa.txt",
                columnNames, Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
    }

    static void peminjamanlist() throws IOException {
        Object[] columnNames = new Object[] {
                "ID Peminjaman",
                "ID Pustakawan",
                "NIM",
                "NIK",
                "Tanggal Peminjaman"
        };

        Object[][] rowData = dataGenerator(peminjamanlist.size(), columnNames);
        for (int i = 0; i < rowData.length; i++) {
            peminjaman data = peminjamanlist.get(i);
            rowData[i][0] = data.getIdPeminjaman();
            rowData[i][1] = data.getIdPustakawan();
            rowData[i][2] = data.getNim();
            rowData[i][3] = data.getNik();
            rowData[i][4] = data.getTanggalPeminjaman();
        }
        generateTable("List Peminjaman", tableFormatter(rowData, columnNames).split("/")[0], rowData, columnNames,
                Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
        printTXT("List Peminjaman", tableFormatter(rowData, columnNames).split("/")[0], rowData, "Peminjaman.txt",
                columnNames, Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
    }

    static void pengembalianlist() throws IOException {
        Object[] columnNames = new Object[] {
                "ID Pengembalian",
                "ID Peminjaman",
                "ID Pustakawan",
                "Tanggal Pengembalian",
        };

        Object[][] rowData = dataGenerator(pengembalianlist.size(), columnNames);
        for (int i = 0; i < rowData.length; i++) {
            pengembalian data = pengembalianlist.get(i);
            rowData[i][0] = data.getIdPengembalian();
            rowData[i][1] = data.getIdPeminjaman();
            rowData[i][2] = data.getIdPustakawan();
            rowData[i][3] = data.getTanggalPengembalian();
        }
        generateTable("List Pengembalian", tableFormatter(rowData, columnNames).split("/")[0], rowData, columnNames,
                Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
        printTXT("List Pengembalian", tableFormatter(rowData, columnNames).split("/")[0], rowData, "Pengembalian.txt",
                columnNames, Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
    }

    public static void pustakawanlist() throws IOException {
        Object[] columnNames = new Object[] {
                "ID Pustakawan",
                "Nama",
        };

        Object[][] rowData = dataGenerator(pustakawanlist.size(), columnNames);
        for (int i = 0; i < rowData.length; i++) {
            pustakawan data = pustakawanlist.get(i);
            rowData[i][0] = data.getIdPustakawan();
            rowData[i][1] = data.getNama();
        }
        generateTable("List Pustakawan", tableFormatter(rowData, columnNames).split("/")[0], rowData, columnNames,
                Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
        printTXT("List Pustakawan", tableFormatter(rowData, columnNames).split("/")[0], rowData, "Pustakawan.txt",
                columnNames, Integer.parseInt(tableFormatter(rowData, columnNames).split("/")[1]));
    }

    public static boolean printTXT(String bannerTitle, String tableFormat, Object[][] rowData, String pathToFile,
            Object[] columnNames, int dataLengthTotal) throws IOException {
        try {
            PrintWriter txt = new PrintWriter(pathToFile);
            String titleBanner = "+", titlePadding = "";
            if (dataLengthTotal % 2 == 0) {
                for (int i = 0; i < dataLengthTotal; i++) {
                    titleBanner += "-";
                }
            } else {
                for (int i = 0; i < dataLengthTotal; i++) {
                    titleBanner += "-";
                }
            }
            titleBanner += "+";
            for (int i = 0; i < ((dataLengthTotal - bannerTitle.length()) / 2) - 1; i++) {
                titlePadding += " ";
            }
            txt.printf(titleBanner + "%n");
            txt.printf("|" + titlePadding + bannerTitle + " " + titlePadding + "|%n");
            txt.printf(titleBanner + "%n");
            txt.printf(tableFormat, columnNames);
            txt.printf(titleBanner + "%n");
            for (int n = 0; n < rowData.length; n++) {
                txt.printf(tableFormat, rowData[n]);
            }
            txt.printf(titleBanner + "%n");
            txt.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String enumerator(String enumTitle, String[] choices, Scanner scanner) {
        System.out.println(enumTitle);
        int count = 1;
        for (String choice : choices) {
            System.out.println(count + ". " + choice);
            count++;
        }
        System.out.print("Masukkan Pilihan: ");
        int pilihan;
        try {
            pilihan = Integer.parseInt(scanner.nextLine());
            if (pilihan <= choices.length && pilihan > 0) {
                return choices[pilihan - 1];
            } else {
                System.out.println("\nWrong Input!");
                return enumerator(enumTitle, choices, scanner);
            }
        } catch (Exception e) {
            System.out.println("\nWrong Input!");
            return enumerator(enumTitle, choices, scanner);
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int c = 0;
        int apustakawan = 2;
        int apeminjaman = 1;
        int apengembalian = 1;
        String idPustakawan = "";

        pustakawanlist.add(new pustakawan("1", "Leo"));

        loopLuar: while (true) {

            System.out.println("Selamat datang di Perpustakaan Cinema!");
            System.out.println("Silakan pilih peran Anda:");
            System.out.println("1. Mahasiswa");
            System.out.println("2. Dosen");
            System.out.println("3. Pustakawan");
            System.out.println("4. Keluar");
            System.out.print("Pilihan Anda: ");
            int role = scanner.nextInt();
            boolean isBenar = false;

            switch (role) {
                case 1:
                    // Mahasiswa
                    System.out.println("Anda memilih peran Mahasiswa.");
                    System.out.print("Masukkan NIM: ");
                    String nim = scanner.next();
                    for (mahasiswa siswa : mahasiswalist) {
                        if (siswa.getNim().equalsIgnoreCase(nim)) {
                            isBenar = true;
                        }
                    }
                    
                    // Lakukan operasi sesuai peran Mahasiswa
                    break;
                case 2:
                    // Dosen
                    System.out.println("Anda memilih peran Dosen.");
                    System.out.print("Masukkan NIK: ");
                    String nik = scanner.next();
                    for (dosen dosen : dosenlist) {
                        if (dosen.getNik().equalsIgnoreCase(nik)) {
                            isBenar = true;
                        }
                    }
                    // Lakukan operasi sesuai peran Dosen
                    break;
                case 3:
                    // Pustakawan
                    System.out.println("Anda memilih peran Pustakawan.");
                    System.out.print("Masukkan ID Pustakawan: ");
                    idPustakawan = scanner.next();
                    for (pustakawan pustakawan : pustakawanlist) {
                        if (pustakawan.getIdPustakawan().equalsIgnoreCase(idPustakawan)) {
                            isBenar = true;
                        }
                    }
                    // Lakukan operasi sesuai peran Pustakawan
                    break;
                case 4:
                    System.out.println("Anda Memilih Untuk Keluar");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    return;
            }

            if (!isBenar) {
                System.out.println("Akun Anda Tidak Tersedia");
                break loopLuar;
            }

            if (role == 1 || role == 2) {
                boolean ulang = true;
                while (ulang) {
                    System.out.println("Menu:");
                    System.out.println("1. Melihat list buku");
                    System.out.println("2. Melihat list CD");
                    System.out.println("3. Keluar");
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            bukulist();
                            break;
                        case 2:
                            cdlist();
                            break;
                        case 3:
                            System.out.println("Anda Memilih Untuk Keluar");
                            ulang = false;
                            break;
                        default:
                            System.out.println("Pilihan tidak valid.");
                    }
                }
            } else if (role == 3) {
                boolean ulang = true;
                while (ulang) {
                    System.out.println("Menu:");
                    System.out.println("1. Menambahkan List Buku");
                    System.out.println("2. Menambahkan List CD");
                    System.out.println("3. Menambahkan List Mahasiswa");
                    System.out.println("4. Menambahkan List Dosen");
                    System.out.println("5. Menambahkan List Pustakawan");
                    System.out.println("6. Menu Peminjaman");
                    System.out.println("7. Menu Pengembalian");
                    System.out.println("8. Melihat List Buku");
                    System.out.println("9. Melihat List CD");
                    System.out.println("10. Melihat List Mahasiswa");
                    System.out.println("11. Melihat List Dosen");
                    System.out.println("12. Melihat List Pustakawan");
                    System.out.println("13. Keluar");
                    System.out.print("Pilihan Anda: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.println("TAMBAH BUKU ");
                            System.out.print("Masukkan ISBN/ISSN : ");
                            String a = scanner.nextLine();
                            System.out.print("Masukkan Judul Buku :");
                            String b = scanner.nextLine();
                            System.out.println("Masukkan Jumlah Buku :");
                            c = Integer.parseInt(scanner.nextLine());

                            bukulist.add(new buku(a, b, c, 0, c));

                            break;
                        case 2:
                            int ccd = 0;
                            System.out.println("TAMBAH CD");
                            System.out.print("Masukkan ID CD : ");
                            String acd = scanner.nextLine();
                            System.out.print("Masukkan Judul CD :");
                            String bcd = scanner.nextLine();
                            System.out.println("Masukkan Jumlah CD :");
                            ccd = Integer.parseInt(scanner.nextLine());

                            cdlist.add(new cd(acd, bcd, ccd, 0, ccd));

                            break;
                        case 3:
                            System.out.println("TAMBAH MAHASISWA");
                            System.out.print("Masukkan NIM : ");
                            String amahasiswa = scanner.nextLine();
                            System.out.print("Masukkan Nama Mahasiswa :");
                            String bmahasiswa = scanner.nextLine();
                            String cmahasiswa = enumerator("Prodi:", new String[] { "MAN", "IMT", "VCD" }, scanner);

                            mahasiswalist.add(new mahasiswa(amahasiswa, bmahasiswa, cmahasiswa));

                            break;
                        case 4:
                            System.out.println("TAMBAH DOSEN");
                            System.out.print("Masukkan NIK : ");
                            String adosen = scanner.nextLine();
                            System.out.print("Masukkan Nama Dosen :");
                            String bdosen = scanner.nextLine();
                            String cdosen = enumerator("Prodi:", new String[] { "MAN", "IMT", "VCD" }, scanner);

                            dosenlist.add(new dosen(adosen, bdosen, cdosen));

                            break;
                        case 5:
                            System.out.println("TAMBAH PUSTAKAWAN");
                            System.out.print("Masukkan Nama Pustakawan :");
                            String bpustakawan = scanner.nextLine();

                            pustakawanlist.add(new pustakawan(Integer.toString(apustakawan), bpustakawan));
                            apustakawan++;
                            break;
                        case 6:
                            boolean ulang2 = true;
                            while (ulang2) {
                                System.out.println("Menu:");
                                System.out.println("1. Menambahkan List Peminjaman");
                                System.out.println("2. Melihat List Peminjaman");
                                System.out.println("3. Melihat Detail Peminjaman");
                                System.out.println("4. Keluar");
                                System.out.print("Pilihan Anda: ");

                                int choice2 = Integer.parseInt(scanner.nextLine());
                                loop: switch (choice2) {
                                    case 1:
                                        boolean isbenar = false;
                                        String bdetailpeminjaman = "";

                                        System.out.println("TAMBAH LIST PEMINJAMAN");
                                        String posisi = enumerator("Posisi:", new String[] { "Dosen", "Mahasiswa" },
                                                scanner);
                                        if (posisi.matches("Dosen")) {
                                            System.out.print("Masukkan NIK Dosen :");
                                        } else {
                                            System.out.print("Masukkan NIM Mahasiswa :");
                                        }
                                        String cpeminjaman = scanner.nextLine();
                                        System.out.print("Masukkan Tanggal Peminjaman :");
                                        String dpeminjaman = scanner.nextLine();
                                        peminjamanlist.add(new peminjaman(Integer.toString(apeminjaman), idPustakawan,
                                                (posisi.matches("Dosen")) ? cpeminjaman : "",
                                                (posisi.matches("Mahasiswa")) ? cpeminjaman : "", dpeminjaman));
                                        String jenisaset = enumerator("Jenis Aset:", new String[] { "Buku", "CD" },
                                                scanner);

                                        while (!isbenar) {
                                            if (jenisaset.matches("Buku")) {
                                                System.out.print("Masukkan ISBN/ISSN :");
                                            } else {
                                                System.out.print("Masukkan ID CD :");
                                            }
                                            bdetailpeminjaman = scanner.nextLine();

                                            if (jenisaset.matches("Buku")) {
                                                for (buku buku : bukulist) {
                                                    if (buku.getIdIsbnIssn().equalsIgnoreCase(bdetailpeminjaman)) {
                                                        isbenar = true;
                                                    }
                                                }
                                            } else {
                                                for (cd cd : cdlist) {
                                                    if (cd.getIdCd().equalsIgnoreCase(bdetailpeminjaman)) {
                                                        isbenar = true;
                                                    }
                                                }
                                            }

                                            if (!isbenar) {
                                                System.out.println("tidak ditemukan.");
                                                break loop;
                                            }
                                        }
                                        System.out.print("Masukkan Batas Pengembalian :");
                                        String ddetailpeminjaman = scanner.nextLine();
                                        detailpeminjamanlist.add(new detailpeminjaman(Integer.toString(apeminjaman),
                                                (jenisaset.matches("Buku")) ? bdetailpeminjaman : "",
                                                (jenisaset.matches("CD")) ? bdetailpeminjaman : "", ddetailpeminjaman));
                                        if (jenisaset.matches("Buku")) {
                                            for (buku buku : bukulist) {
                                                if (buku.getIdIsbnIssn().matches(bdetailpeminjaman)) {
                                                    buku.setBukuTersedia(buku.getBukuTersedia() - 1);
                                                    buku.setBukuTerpinjam(buku.getBukuTerpinjam() + 1);
                                                }
                                            }
                                        } else {
                                            for (cd cd : cdlist) {
                                                if (cd.getIdCd().matches(bdetailpeminjaman)) {
                                                    cd.setCdTersedia(cd.getCdTersedia() - 1);
                                                    cd.setCdTerpinjam(cd.getCdTerpinjam() + 1);
                                                }
                                            }
                                        }
                                        apeminjaman++;
                                        break;
                                    case 2:
                                        peminjamanlist();
                                        break;
                                    case 3:
                                        detailpeminjamanlist(); 
                                        break;    
                                    case 4:
                                        System.out.println("Anda Memilih Untuk Keluar");
                                        ulang2 = false;
                                        break;
                                    default:
                                        System.out.println("Pilihan tidak valid.");
                                        break;
                                }
                            }
                            break;
                        case 7:
                            boolean ulang3 = true;
                            while (ulang3) {
                                System.out.println("Menu:");
                                System.out.println("1. Menambahkan List Pengembalian");
                                System.out.println("2. Melihat List Pengembalian");
                                System.out.println("3. Melihat Detail Pengembalian");
                                System.out.println("4. Melihat Detail Denda");
                                System.out.println("5. Keluar");
                                System.out.print("Pilihan Anda: ");

                                int choice3 = Integer.parseInt(scanner.nextLine());
                                switch (choice3) {
                                    case 1:
                                        System.out.println("TAMBAH LIST PENGEMBALIAN");
                                        System.out.print("Masukkan ID Peminjaman :");
                                        String bpengembalian = scanner.nextLine();
                                        System.out.print("Masukkan Tanggal Pengembalian :");
                                        String dpengembalian = scanner.nextLine();

                                        pengembalianlist.add(new pengembalian(Integer.toString(apengembalian),
                                                bpengembalian, idPustakawan, dpengembalian));
                                        String jenisaset = enumerator("Jenis Aset:", new String[] { "Buku", "CD" },
                                                scanner);
                                        if (jenisaset.matches("Buku")) {
                                            System.out.print("Masukkan ISBN/ISSN :");
                                        } else {
                                            System.out.print("Masukkan ID CD :");
                                        }
                                        String bdetailpengembalian = scanner.nextLine();
                                        detailpengembalianlist
                                                .add(new detailpengembalian(Integer.toString(apengembalian),
                                                        (jenisaset.matches("Buku")) ? bdetailpengembalian : "",
                                                        (jenisaset.matches("CD")) ? bdetailpengembalian : ""));
                                        String jenisdenda = enumerator("Jenis Denda:",
                                                new String[] { "Terlambat", "Rusak", "Hilang", "Tidak Ada" }, scanner);
                                        detaildendalist.add(
                                                new detaildenda(Integer.toString(apengembalian), jenisdenda));
                                        if (jenisaset.matches("Buku")) {
                                            for (buku buku : bukulist) {
                                                if (buku.getIdIsbnIssn().matches(bdetailpengembalian)) {
                                                    buku.setBukuTersedia(buku.getBukuTersedia() + 1);
                                                    buku.setBukuTerpinjam(buku.getBukuTerpinjam() - 1);
                                                }
                                            }
                                        } else {
                                            for (cd cd : cdlist) {
                                                if (cd.getIdCd().matches(bdetailpengembalian)) {
                                                    cd.setCdTersedia(cd.getCdTersedia() + 1);
                                                    cd.setCdTerpinjam(cd.getCdTerpinjam() - 1);
                                                }
                                            }
                                        }
                                        apengembalian++;
                                        break;
                                    case 2:
                                        pengembalianlist();
                                        break;
                                    
                                    case 3:
                                        detailpengembalianlist();
                                        break;

                                    case 4:
                                        detaildendalist();
                                        break;

                                    case 5:
                                        System.out.println("Anda Memilih Untuk Keluar");
                                        ulang3 = false;
                                        break;
                                    default:
                                        System.out.println("Pilihan tidak valid.");

                                }
                            }
                            break;
                        case 8:
                            bukulist();
                            break;
                        case 9:
                            cdlist();
                            break;
                        case 10:
                            mahasiswalist();
                            break;
                        case 11:
                            dosenlist();
                            break;
                        case 12:
                            pustakawanlist();
                            break;
                        case 13:
                            System.out.println("Anda Memilih Untuk Keluar");
                            ulang = false;
                            break;
                        default:
                            System.out.println("Pilihan tidak valid.");
                    }
                }
            }

        }
    }

}
