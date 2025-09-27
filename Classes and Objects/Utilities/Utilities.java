package Utilities;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

public class Utilities {

    private static final Random ran = new Random();

    // Utilities
    public String generatePersonID(String gender) {
        String birthDate = getTodaysDate(); // YYMMDD
        String genderNumber = getGenderNumber(gender); // G
        String sequenceNumber = generateSequenceNumber(); // SSS
        String citizenship = "0";
        String raceDigit = "9";
        String partialID = birthDate + genderNumber + sequenceNumber + citizenship + raceDigit;
        String checkDigit = calCheckDigit(partialID);
        return partialID + checkDigit;
    }
    
    public String calCheckDigit(String partialID) {
        int sum = 0;
        boolean alt = false;

        //Process digits from right to left
        for(int i = partialID.length() - 1; i >= 0; i--){
            int digit = Character.getNumericValue(partialID.charAt(i));
            if(alt){
                digit *= 2;
                if(digit > 9){
                    digit = (digit % 10) + 1;
                }
            }
            sum += digit;
            alt = !alt;
        }
        int checkDigit = (10 - (sum % 10)) % 10;
        return String.valueOf(checkDigit);
    }

    public String generateSequenceNumber() {
        return String.format("%03d", ran.nextInt(1000));
    }

    public String getGenderNumber(String gender2) {
        // Set gender digit to a random number between 5 and 9 for a male or 0 to 4 for a female
        if(gender2 == null){
            return generateRandomGenderNumber();
        }

        if(gender2.equalsIgnoreCase("male") || gender2.equalsIgnoreCase("m")){
            return String.valueOf(5 + ran.nextInt(5)); // 5 - 9
        }
        return String.valueOf(ran.nextInt(5)); // 0 - 4
    }

    private String generateRandomGenderNumber() {
        if(ran.nextBoolean()){
            return String.valueOf(5 + ran.nextInt(5)); // 5 - 9 (Male)
        }
        return String.valueOf(ran.nextInt(5)); // 0 - 4 (Female)
    }

    // Fixed: Use getMonthValue() instead of getMonth()
    public String getTodaysDate() {
        LocalDate today = LocalDate.now();

        //Get today's date as YYMMDD
        String year = String.format("%02d", today.getYear() % 100); // YY
        String month = String.format("%02d", today.getMonthValue()); // MM - Fixed!
        String day = String.format("%02d", today.getDayOfMonth()); // DD

        return year + month + day;
    }

    // Fixed: Proper age calculation
    public int updateAge(String id){
        if(id == null || id.length() < 6) {
            return 0;
        }
        
        LocalDate today = LocalDate.now();
        
        try {
            // Extract birth date from ID (YYMMDD)
            int birthYear = Integer.parseInt(id.substring(0, 2));
            int birthMonth = Integer.parseInt(id.substring(2, 4));
            int birthDay = Integer.parseInt(id.substring(4, 6));
            
            // Determine full year (assume 00-30 is 2000s, 31-99 is 1900s)
            int fullBirthYear = birthYear <= 30 ? 2000 + birthYear : 1900 + birthYear;
            
            LocalDate birthDate = LocalDate.of(fullBirthYear, birthMonth, birthDay);
            
            // Calculate age using Period
            return Period.between(birthDate, today).getYears();
            
        } catch (Exception e) {
            // If there's any error parsing the date, return 0
            return 0;
        }
    }
    
    // Additional utility method to extract gender from ID
    public String getGenderFromId(String id) {
        if(id == null || id.length() < 7) {
            return "Unknown";
        }
        
        int genderDigit = Character.getNumericValue(id.charAt(6));
        return genderDigit >= 5 ? "Male" : "Female";
    }
    
    // Additional utility method to get birth date from ID
    public LocalDate getBirthDateFromId(String id) {
        if(id == null || id.length() < 6) {
            return null;
        }
        
        try {
            int birthYear = Integer.parseInt(id.substring(0, 2));
            int birthMonth = Integer.parseInt(id.substring(2, 4));
            int birthDay = Integer.parseInt(id.substring(4, 6));
            
            // Determine full year (assume 00-30 is 2000s, 31-99 is 1900s)
            int fullBirthYear = birthYear <= 30 ? 2000 + birthYear : 1900 + birthYear;
            
            return LocalDate.of(fullBirthYear, birthMonth, birthDay);
        } catch (Exception e) {
            return null;
        }
    }
}