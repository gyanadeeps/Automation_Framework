package com.project.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GetRandomDataGenerator
{

    public static final String configFile="src/test/resources/config.properties";


    public static String getFirstName() {

        Random r = new Random(System.currentTimeMillis());
        int randomData = ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
        String firstName = String.valueOf(randomData);
        firstName = "ProFund"+firstName;
        System.out.println(firstName);

        return firstName;


    }
    public static String getBusinessName()
    {
        Random r = new Random(System.currentTimeMillis());
        int randomData = ((1 + r.nextInt(2)) * 1000 + r.nextInt(1000));
        String businessName = String.valueOf(randomData);
        businessName = "ECLOUDMS"+businessName;
        // System.out.println(firstName);
        return businessName;
    }


    public static String generatePhoneNumber()
    {
        long phoneNumber = (long) (Math.random() * 100000 + 3333300000L);
        String phone = String.valueOf(phoneNumber);
        return phone;
    }

    public static String getEmail()
    {

        Random r = new Random(System.currentTimeMillis());
        int randomData = ((1 + r.nextInt(2)) * 100000 + r.nextInt(100000));
        String firstName = String.valueOf(randomData);
        String email = "profound+"+firstName+"@yopmail.com";
        System.out.println(email);
        return email;


    }
    public static String getCityData() {
        List<String> namesList = Arrays.asList("New York","California", "Illinois", "Texas", "Arizona", "Pennsylvania");

        ArrayList<String> sportLists = new ArrayList<>();
        sportLists.addAll(namesList);
        int i = ThreadLocalRandom.current().nextInt(0, 5 + 1);
        System.out.println(sportLists.get(i));

        return sportLists.get(i);


    }


    public static String getZipcode()
    {
        String zipcode =String.valueOf(ThreadLocalRandom.current().nextInt(90000, 96160+ 1));
        return zipcode;
    }
    public static String getBuildNumber() {

        Properties pr = new Properties();

        String build_number = null;
        try {
            File file = new File(configFile);
            InputStream fis = new FileInputStream(file);

            pr.load(fis);


            build_number = pr.getProperty("Build_version");


        } catch (Exception e) {
            e.printStackTrace();
        }

        return build_number;
    }
    public static String getMobile_Version() {

        Properties pr = new Properties();

        String mobile = null;
        try {
            File file = new File(configFile);
            InputStream fis = new FileInputStream(file);

            pr.load(fis);


            mobile = pr.getProperty("mobile_version");


        } catch (Exception e) {
            e.printStackTrace();
        }

        return mobile;
    }

}
