package TH;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhonebookManagenr {
    List<Phonebook> phonebooks = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void show() {
        int count = 0;
        for (Phonebook phonebook : phonebooks) {
            System.out.println(phonebook);
            count++;
            if (count == 5) {
                count = 0;
                scanner.nextLine();
            }
        }
    }

    public void add(Phonebook phonebook) {
        phonebooks.add(phonebook);
    }

    public void update(String phoneNumber, Phonebook phonebook) {
        int index = findByPhoneNumber(phoneNumber);
        if (index != -1) {
            phonebooks.set(index, phonebook);
        } else {
            System.out.println("không có số điện thoại này");
        }

    }

    private int findByPhoneNumber(String phoneNumber) {
        int index = -1;
        for (int i = 0; i < phonebooks.size(); i++) {
            if (phonebooks.get(i).getPhoneNumber().equals(phoneNumber)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void deletePhoneNumber(String phoneNumber) {
        int index = findByPhoneNumber(phoneNumber);
        if (index != -1) {
            phonebooks.remove(phoneNumber);
        } else {
            System.out.println("không có sdt này");
        }

    }
    public void fileOut(){
        try {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("phoneBook.txt"));
            for (int i = 0; i < phonebooks.size(); i++) {
                bufferedWriter.write(phonebooks.get(i).toString()+"\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void fileInput(){
        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader("phonebook.txt"));
            String line=null;
            while ((line=bufferedReader.readLine())!=null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
