package com.company;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class MenuAtm extends Akun{
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat formatUang = new DecimalFormat("'Rp'###,###.00");
    private int moneyDrawn = 0;
    private int attempt = 0;
    private double[] noRek = {2000018441,2000018442, 2000018439, 2000018438, 2000018437};
    private HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public double[] getNoRek(){
        return this.noRek;
    }
    public void getLogin() throws IOException{
        int x = 1;
        do{
            try {
                data.put(184400, 300021);

                System.out.println("Selamat datang di ATM!");
                System.out.println("Masukkan nomor rekening :");
                setNoCust(menuInput.nextInt());
                System.out.println("Masukkan pin :");
                setNoPin(menuInput.nextInt());
            }catch (Exception e){
                System.out.println("Hanya boleh angka!");
                x++;
            }
            int nc = getNoCust();
            int np = getNoPin();
            if(data.containsKey(nc) && data.get(nc) == np){
                getAkun();
            } else
                System.out.println("Pin atau Rekening salah");
        }while (x <=3);
    }
    public void getAkun() throws IOException {
        System.out.println("Menu Akun :");
        System.out.println("Type 1 - Informasi saldo");
        System.out.println("Type 2 - Penarikan uang");
        System.out.println("Type 3 - Deposito uang");
        System.out.println("Type 4 - Transfer");
        System.out.println("Keluar");


        int pilihan = menuInput.nextInt();

        switch (pilihan){
            case 1:
                System.out.println("Saldo : " + formatUang.format(getSaldo()));
                break;
            case 2:
                if(attempt<3){
                    int besarnya = getInputPenarikanSaldo(this.moneyDrawn);
                    if(besarnya == -1){
                        attempt++;
                    }else {
                        this.moneyDrawn += besarnya;
                    }
                }else {
                    System.out.println("Anda sudah terblokir");
                }

                break;
            case 3:
                getInputDepositoSaldo();
                break;
            case 4:
                getInputTransfer();
                break;
            case 5:
                getLogin();
                break;
            default:
                System.out.println("Invalid");
                break;
        }
        getAkun();

    }
}
